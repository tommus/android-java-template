package co.windly.rename.data.domain.model.base;

import io.reactivex.annotations.NonNull;

public abstract class IdentifiableModel {

  //region Id

  @NonNull
  private Long id = 0L;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  //endregion
}
