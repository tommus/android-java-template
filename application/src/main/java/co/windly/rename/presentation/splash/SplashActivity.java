package co.windly.rename.presentation.splash;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import co.windly.limbo.activity.base.LimboActivity;
import co.windly.rename.R;
import co.windly.rename.utility.view.ViewUtil;

public class SplashActivity extends LimboActivity<SplashView, SplashPresenter> implements SplashView {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_splash;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public SplashPresenter createPresenter() {
    return new SplashPresenter();
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Animate logo.
    animateLogo();

    // Download books and characters.
    getPresenter().downloadBooksAndCharacters();
  }

  //endregion

  //region Logo

  @BindView(R.id.logo)
  ImageView logoView;

  @Override
  public void animateLogo() {
    final Drawable drawable = logoView.getDrawable();
    if (drawable instanceof Animatable) {
      final Animatable animatable = (Animatable) drawable;
      animatable.start();
    }
  }

  //endregion

  //region Loading

  @BindView(R.id.loading)
  View loadingView;

  @Override
  public void showLoading(boolean flag) {
    ViewUtil.changeVisibility(loadingView, flag);
  }

  //endregion
}
