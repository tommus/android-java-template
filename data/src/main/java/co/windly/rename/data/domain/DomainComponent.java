package co.windly.rename.data.domain;

import co.windly.rename.data.domain.manager.BookDomainManager;
import co.windly.rename.data.network.NetworkModule;
import co.windly.rename.data.persistence.PersistenceModule;
import dagger.Component;

@Component(modules = { PersistenceModule.class, DomainModule.class, NetworkModule.class })
public interface DomainComponent {

  //region Injections

  void inject(BookDomainManager manager);

  //endregion
}
