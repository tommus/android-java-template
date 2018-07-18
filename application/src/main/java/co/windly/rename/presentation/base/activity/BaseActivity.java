package co.windly.rename.presentation.base.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends MvpActivity<V, P>
  implements BaseView {

  //region Ui

  @LayoutRes
  protected abstract int getLayout();

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
    initializeViews();
    getPresenter().initializeManagers(this);
  }

  @Override
  protected void onDestroy() {
    getPresenter().destroy();
    super.onDestroy();
  }

  //endregion

  //region View Injection

  protected void initializeViews() {
    ButterKnife.bind(this);
  }

  //endregion
}
