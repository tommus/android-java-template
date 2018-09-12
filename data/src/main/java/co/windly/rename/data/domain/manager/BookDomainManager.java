package co.windly.rename.data.domain.manager;

import android.content.Context;
import co.windly.rename.data.domain.DaggerDomainComponent;
import co.windly.rename.data.domain.model.book.Book;
import co.windly.rename.data.domain.model.book.Character;
import co.windly.rename.data.network.NetworkModule;
import co.windly.rename.data.network.manager.BookNetworkManager;
import co.windly.rename.data.persistence.PersistenceModule;
import co.windly.rename.data.persistence.manager.BookPersistenceManager;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import java.util.List;
import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class BookDomainManager {

  //region Fields

  @Inject
  BookNetworkManager network;

  @Inject
  BookPersistenceManager persistence;

  //endregion

  //region Constructor

  public BookDomainManager(@NonNull Context context) {
    DaggerDomainComponent
      .builder()
      .networkModule(new NetworkModule())
      .persistenceModule(new PersistenceModule(context))
      .build()
      .inject(this);
  }

  //endregion

  //region Book

  public Completable downloadBooks() {
    return network
      .getBooks()
      .flatMapCompletable(persistence::saveBooks);
  }

  public Flowable<List<Book>> getAllBooks() {
    return persistence
      .getAllBooks();
  }

  //endregion

  //region Characters

  public Completable downloadCharacters() {
    return network
      .getCharacters()
      .flatMapCompletable(persistence::saveCharacters);
  }

  public Flowable<List<Character>> getAllCharacters() {
    return persistence
      .getAllCharacters();
  }

  //endregion
}
