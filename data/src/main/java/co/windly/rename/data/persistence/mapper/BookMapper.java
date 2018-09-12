package co.windly.rename.data.persistence.mapper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import co.windly.rename.data.common.mapper.BaseMapper;
import co.windly.rename.data.domain.model.book.Book;
import co.windly.rename.data.network.dto.response.book.BookData;
import co.windly.rename.data.persistence.database.entity.book.BookEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;

import static io.reactivex.Observable.fromIterable;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

public class BookMapper extends BaseMapper {

  //region Constructor

  @Inject
  public BookMapper(@NonNull ModelMapper mapper) {
    super(mapper);
  }

  //endregion

  //region BookData -> BookEntity -> Book

  private BookEntity mapBookDataToEntity(@NonNull BookData data) {
    return mapper.map(data, BookEntity.class);
  }

  public List<BookEntity> mapBookDatasToEntities(@Nullable List<BookData> datas) {
    return fromIterable(defaultIfNull(datas, new ArrayList<>()))
      .map(this::mapBookDataToEntity)
      .toList()
      .blockingGet();
  }

  private Book mapBookEntityToModel(@NonNull BookEntity entity) {
    return mapper.map(entity, Book.class);
  }

  public List<Book> mapBookEntitiesToModels(@Nullable List<BookEntity> entities) {
    return fromIterable(defaultIfNull(entities, new ArrayList<>()))
      .map(this::mapBookEntityToModel)
      .toList()
      .blockingGet();
  }

  //endregion
}
