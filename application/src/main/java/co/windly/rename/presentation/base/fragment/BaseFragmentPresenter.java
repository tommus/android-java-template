package co.windly.rename.presentation.base.fragment;

import android.content.Context;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

public class BaseFragmentPresenter<V extends BaseFragmentView> extends MvpBasePresenter<V> {

  //region Threading

  protected CompositeDisposable disposables = new CompositeDisposable();

  //endregion

  //region Managers

  protected void initializeManagers(@NonNull Context context) {
    // No-op.
  }

  //endregion

  //region Detach

  protected void detach() {
    disposables.clear();
  }

  //endregion
}
