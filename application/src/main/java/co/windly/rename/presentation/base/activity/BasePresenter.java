package co.windly.rename.presentation.base.activity;

import android.content.Context;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<View extends BaseView> extends MvpBasePresenter<View> {

  //region Threading

  protected CompositeDisposable disposables = new CompositeDisposable();

  //endregion

  //region Managers

  protected void initializeManagers(@NonNull Context context) {
    // No-op.
  }

  //endregion

  //region Destroy

  protected void destroy() {
    disposables.clear();
  }

  //endregion
}
