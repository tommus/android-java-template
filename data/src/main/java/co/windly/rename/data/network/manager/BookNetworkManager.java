package co.windly.rename.data.network.manager;

import co.windly.rename.data.network.dto.response.book.BookData;
import co.windly.rename.data.network.dto.response.book.CharacterData;
import co.windly.rename.data.network.service.BooksApi;
import io.reactivex.Single;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

import static io.reactivex.annotations.SchedulerSupport.IO;

@SchedulerSupport(value = IO)
@SuppressWarnings("WeakerAccess")
public class BookNetworkManager {

  //region Service

  @Inject
  BooksApi api;

  //endregion

  //region Constructor

  @Inject
  public BookNetworkManager() {
    // No-op.
  }

  //endregion

  //region Books

  public Single<List<BookData>> getBooks() {
    return api
      .getBooks()
      .subscribeOn(Schedulers.io());
  }

  //endregion

  //region Characters

  public Single<List<CharacterData>> getCharacters() {
    return api
      .getCharacters()
      .subscribeOn(Schedulers.io());
  }

  //endregion
}
