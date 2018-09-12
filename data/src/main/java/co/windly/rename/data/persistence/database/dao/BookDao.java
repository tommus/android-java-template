package co.windly.rename.data.persistence.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import co.windly.rename.data.persistence.database.entity.book.BookEntity;
import io.reactivex.Flowable;
import java.util.List;

@Dao
public abstract class BookDao extends BaseDao<BookEntity> {

  //region Book

  @Query("SELECT * FROM books ORDER BY title ASC")
  public abstract Flowable<List<BookEntity>> getAll();

  //endregion
}
