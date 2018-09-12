package co.windly.rename.data.persistence.database.entity.book;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import co.windly.rename.data.persistence.database.entity.base.IdentifiableEntity;
import io.reactivex.annotations.NonNull;

@Entity(tableName = "characters")
public class CharacterEntity extends IdentifiableEntity {

  //region Column Definitions

  @NonNull
  @ColumnInfo(name = "first_name")
  private String firstName = "";

  @NonNull
  @ColumnInfo(name = "last_name")
  private String lastName = "";

  //endregion

  //region Getters and Setters

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //endregion
}
