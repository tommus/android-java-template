package co.windly.rename.data.domain;

import co.windly.rename.data.domain.manager.AccountDomainManager;
import co.windly.rename.data.persistence.PersistenceModule;
import dagger.Component;

@Component(modules = {
  PersistenceModule.class
})
public interface DomainComponent {

  //region Injections

  void inject(AccountDomainManager manager);

  //endregion
}
