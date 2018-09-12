package co.windly.rename.data.network.dto.response.book;

import co.windly.rename.data.network.dto.response.base.data.IdentifiableApiData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookData extends IdentifiableApiData {

  //region Title

  @JsonProperty(value = "title")
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  //endregion
}
