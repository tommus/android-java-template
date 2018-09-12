package co.windly.rename.data.persistence.manager;

import co.windly.rename.data.domain.model.book.Book;
import co.windly.rename.data.domain.model.book.Character;
import co.windly.rename.data.network.dto.response.book.BookData;
import co.windly.rename.data.network.dto.response.book.CharacterData;
import co.windly.rename.data.persistence.database.AndroidDatabase;
import co.windly.rename.data.persistence.database.entity.book.BookEntity;
import co.windly.rename.data.persistence.database.entity.book.CharacterEntity;
import co.windly.rename.data.persistence.mapper.BookMapper;
import co.windly.rename.data.persistence.mapper.CharacterMapper;
import co.windly.rename.data.persistence.settings.SessionCachePrefs;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class BookPersistenceManager {

  //region Fields

  @Inject
  AndroidDatabase database;

  @Inject
  BookMapper bookMapper;

  @Inject
  CharacterMapper characterMapper;

  @Inject
  SessionCachePrefs sessionCache;

  //endregion

  //region Constructor

  @Inject
  public BookPersistenceManager() {
    // No-op.
  }

  //endregion

  //region Books

  public Completable saveBooks(@Nullable List<BookData> datas) {
    return Completable.fromAction(() -> {
      final List<BookEntity> entities = bookMapper.mapBookDatasToEntities(datas);
      database.bookDao().insert(entities);
    }).subscribeOn(Schedulers.io());
  }

  public Flowable<List<Book>> getAllBooks() {
    return database
      .bookDao()
      .getAll()
      .map(bookMapper::mapBookEntitiesToModels)
      .subscribeOn(Schedulers.io());
  }

  //endregion

  //region Character

  public Completable saveCharacters(@Nullable List<CharacterData> datas) {
    return Completable.fromAction(() -> {
      final List<CharacterEntity> entities = characterMapper.mapCharacterDatasToEntities(datas);
      database.characterDao().insert(entities);
    }).subscribeOn(Schedulers.io());
  }

  public Flowable<List<Character>> getAllCharacters() {
    return database
      .characterDao()
      .getAll()
      .map(characterMapper::mapCharacterEntitiesToModels)
      .subscribeOn(Schedulers.io());
  }

  //endregion
}
