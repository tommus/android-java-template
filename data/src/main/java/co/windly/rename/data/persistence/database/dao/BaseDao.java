package co.windly.rename.data.persistence.database.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;
import java.util.List;

public abstract class BaseDao<Entity> {

  //region Insert

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  public abstract Long insert(Entity entity);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  public abstract List<Long> insert(List<Entity> entities);

  //endregion

  //region Update

  @Update(onConflict = OnConflictStrategy.REPLACE)
  public abstract void update(Entity entity);

  //endregion

  //region Insert / Update

  @Transaction
  public void upsert(Entity entity) {
    final Long id = insert(entity);
    if (id == -1L) {
      update(entity);
    }
  }

  @Transaction
  public void upsert(List<Entity> entities) {
    for (Entity entity : entities) {
      upsert(entity);
    }
  }

  //endregion

  //region Remove

  @Delete
  public abstract void remove(Entity entity);

  @Delete
  public abstract void remove(List<Entity> entities);

  //endregion
}
