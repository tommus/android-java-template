package co.windly.rename.data.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import co.windly.rename.data.persistence.database.dao.BookDao;
import co.windly.rename.data.persistence.database.dao.CharacterDao;
import co.windly.rename.data.persistence.database.entity.book.BookEntity;
import co.windly.rename.data.persistence.database.entity.book.CharacterEntity;

@Database(
  version = 1,
  exportSchema = false,
  entities = {
    BookEntity.class,
    CharacterEntity.class
  }
)
public abstract class AndroidDatabase extends RoomDatabase {

  //region Dao

  public abstract BookDao bookDao();

  public abstract CharacterDao characterDao();

  //endregion

  //region Name

  private static final String DB_NAME = "books.db";

  //endregion

  //region Singleton

  private static AndroidDatabase INSTANCE;

  public static AndroidDatabase getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      synchronized (AndroidDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room
            .databaseBuilder(context, AndroidDatabase.class, DB_NAME)
            // TODO: Define migrations rather than destructing database.
            .fallbackToDestructiveMigration()
            //.addMigrations(provideMigrations())
            .build();
        }
      }
    }
    return INSTANCE;
  }

  //endregion

  //region Migrations

  @Deprecated
  private static Migration[] provideMigrations() {
    return new Migration[] {
      // TODO:
    };
  }

  //endregion
}
