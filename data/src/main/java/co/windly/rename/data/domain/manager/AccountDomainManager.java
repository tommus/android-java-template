package co.windly.rename.data.domain.manager;

import android.content.Context;
import co.windly.rename.data.domain.DaggerDomainComponent;
import co.windly.rename.data.network.manager.AccountNetworkManager;
import co.windly.rename.data.persistence.PersistenceModule;
import co.windly.rename.data.persistence.manager.AccountPersistenceManager;
import io.reactivex.annotations.NonNull;
import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class AccountDomainManager {

  //region Fields

  @Inject
  AccountNetworkManager network;

  @Inject
  AccountPersistenceManager persistence;

  //endregion

  //region Constructor

  public AccountDomainManager(@NonNull Context context) {
    DaggerDomainComponent
      .builder()
      .persistenceModule(new PersistenceModule(context))
      .build()
      .inject(this);
  }

  //endregion
}
