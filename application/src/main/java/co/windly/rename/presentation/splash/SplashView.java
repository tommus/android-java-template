package co.windly.rename.presentation.splash;

import co.windly.rename.presentation.base.activity.BaseView;

interface SplashView extends BaseView {

  //region Logo

  void animateLogo();

  //endregion

  //region Loading

  void showLoading(boolean flag);

  //endregion
}
