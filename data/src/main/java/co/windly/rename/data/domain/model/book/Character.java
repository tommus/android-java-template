package co.windly.rename.data.domain.model.book;

import co.windly.rename.data.domain.model.base.IdentifiableModel;
import io.reactivex.annotations.NonNull;

public class Character extends IdentifiableModel {

  //region First Name

  @NonNull
  private String firstName = "";

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //endregion

  //region Last Name

  @NonNull
  private String lastName = "";

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //endregion
}
