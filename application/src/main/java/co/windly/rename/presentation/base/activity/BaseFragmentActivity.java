package co.windly.rename.presentation.base.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import co.windly.rename.R;
import co.windly.rename.presentation.base.fragment.BaseFragment;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportActivity;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.ISupportFragment.LaunchMode;
import me.yokeyword.fragmentation.SupportActivityDelegate;
import me.yokeyword.fragmentation.SupportHelper;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public abstract class BaseFragmentActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity<V, P>
  implements BaseView, ISupportActivity {

  //region Ui

  @IdRes
  protected int getFragmentContainerId() {
    return R.id.fragmentContainer;
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    delegate.onCreate(savedInstanceState);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    delegate.onPostCreate(savedInstanceState);
  }

  @Override
  protected void onDestroy() {
    delegate.onDestroy();
    super.onDestroy();
  }

  //endregion

  //region Touch Event

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    return delegate.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);
  }

  //endregion

  //region Back

  @Override
  public void onBackPressed() {
    delegate.onBackPressed();
  }

  @Override
  public void onBackPressedSupport() {
    delegate.onBackPressedSupport();
  }

  //endregion

  //region Fragment Animator

  @Override
  public FragmentAnimator getFragmentAnimator() {
    return delegate.getFragmentAnimator();
  }

  @Override
  public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
    delegate.setFragmentAnimator(fragmentAnimator);
  }

  @Override
  public FragmentAnimator onCreateFragmentAnimator() {
    return delegate.onCreateFragmentAnimator();
  }

  //endregion

  //region Support Activity

  final SupportActivityDelegate delegate = new SupportActivityDelegate(this);

  @Override
  public SupportActivityDelegate getSupportDelegate() {
    return delegate;
  }

  @Override
  public ExtraTransaction extraTransaction() {
    return delegate.extraTransaction();
  }

  @Override
  public void post(Runnable runnable) {
    delegate.post(runnable);
  }

  //endregion

  //region Fragment

  public void loadRootFragment(int containerId, @NonNull BaseFragment toFragment) {
    delegate.loadRootFragment(containerId, toFragment);
  }

  public void start(BaseFragment toFragment) {
    delegate.start(toFragment);
  }

  public void start(ISupportFragment toFragment, @LaunchMode int launchMode) {
    delegate.start(toFragment, launchMode);
  }

  public void startWithPopTo(ISupportFragment toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment) {
    delegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment);
  }

  public void pop() {
    delegate.pop();
  }

  public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment) {
    delegate.popTo(targetFragmentClass, includeTargetFragment);
  }

  public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable) {
    delegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable);
  }

  public void popTo(
    Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable, int popAnim) {
    delegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable, popAnim);
  }

  public BaseFragment getTopFragment() {
    return (BaseFragment) SupportHelper.getTopFragment(getSupportFragmentManager());
  }

  public <F extends BaseFragment> F findFragment(Class<F> fragmentClass) {
    return SupportHelper.findFragment(getSupportFragmentManager(), fragmentClass);
  }

  //endregion
}
