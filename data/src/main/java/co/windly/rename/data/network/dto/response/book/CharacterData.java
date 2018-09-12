package co.windly.rename.data.network.dto.response.book;

import co.windly.rename.data.network.dto.response.base.data.IdentifiableApiData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterData extends IdentifiableApiData {

  //region First Name

  @JsonProperty(value = "first_name")
  private String firstName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //endregion

  //region Last Name

  @JsonProperty(value = "last_name")
  private String lastName;

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //endregion
}
