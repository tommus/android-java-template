package co.windly.rename.presentation.splash;

import android.content.Context;
import android.support.annotation.NonNull;
import co.windly.rename.data.domain.manager.AccountDomainManager;
import co.windly.rename.presentation.base.activity.BasePresenter;

@SuppressWarnings("FieldCanBeLocal")
class SplashPresenter extends BasePresenter<SplashView> {

  //region Managers

  private AccountDomainManager accountManager;

  @Override
  protected void initializeManagers(@NonNull Context context) {
    super.initializeManagers(context);
    accountManager = new AccountDomainManager(context);
  }

  //endregion
}
