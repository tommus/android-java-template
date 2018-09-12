package co.windly.rename.data.network.dto.response.base.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class IdentifiableApiData extends ApiData {

  //region Id

  @JsonProperty(value = "id")
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  //endregion
}
