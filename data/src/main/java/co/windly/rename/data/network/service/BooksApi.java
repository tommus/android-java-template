package co.windly.rename.data.network.service;

import co.windly.rename.data.network.dto.response.book.BookData;
import co.windly.rename.data.network.dto.response.book.CharacterData;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;

public interface BooksApi {

  //region Books

  @GET("books")
  Single<List<BookData>> getBooks();

  //endregion

  //region Character

  @GET("characters")
  Single<List<CharacterData>> getCharacters();

  //endregion
}
