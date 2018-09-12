package co.windly.rename.data.persistence;

import android.content.Context;
import android.support.annotation.NonNull;
import co.windly.rename.data.persistence.database.AndroidDatabase;
import co.windly.rename.data.persistence.settings.SessionCachePrefs;
import dagger.Module;
import dagger.Provides;

@Module
@SuppressWarnings("FieldCanBeLocal")
public class PersistenceModule {

  //region Fields

  private Context context;

  //endregion

  //region Constructor

  public PersistenceModule(@NonNull Context context) {
    this.context = context;
  }

  //endregion

  //region Database

  @Provides
  @NonNull
  AndroidDatabase provideDatabase() {
    return AndroidDatabase.getInstance(context);
  }

  //endregion

  //region Session Cache

  @Provides
  SessionCachePrefs provideSessionCache() {
    return SessionCachePrefs.get(context);
  }

  //endregion
}
