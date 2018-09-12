package co.windly.rename.presentation.splash;

import co.windly.limbo.activity.base.LimboActivityView;

interface SplashView extends LimboActivityView {

  //region Logo

  void animateLogo();

  //endregion

  //region Loading

  void showLoading(boolean flag);

  //endregion
}
