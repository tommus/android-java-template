package co.windly.rename.data.domain.model.book;

import co.windly.rename.data.domain.model.base.IdentifiableModel;
import io.reactivex.annotations.NonNull;

public class Book extends IdentifiableModel {

  //region Title

  @NonNull
  private String title = "";

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  //endreigon
}
