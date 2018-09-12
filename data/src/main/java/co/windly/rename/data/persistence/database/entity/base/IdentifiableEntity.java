package co.windly.rename.data.persistence.database.entity.base;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import io.reactivex.annotations.NonNull;

public abstract class IdentifiableEntity {

  //region Column Definitions

  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "id")
  private Long id = 0L;

  //endregion

  //region Getters and Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  //endregion
}
