package co.windly.rename.data.persistence.database.entity.book;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import co.windly.rename.data.persistence.database.entity.base.IdentifiableEntity;
import io.reactivex.annotations.NonNull;

@Entity(tableName = "books")
public class BookEntity extends IdentifiableEntity {

  //region Column Definitions

  @NonNull
  @ColumnInfo(name = "title")
  private String title = "";

  //endregion

  //region Getters and Setters

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  //endregion
}
