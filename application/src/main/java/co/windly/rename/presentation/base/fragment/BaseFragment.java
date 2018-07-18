package co.windly.rename.presentation.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.SupportHelper;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public abstract class BaseFragment<V extends BaseFragmentView, P extends BaseFragmentPresenter<V>>
  extends MvpFragment<V, P> implements BaseFragmentView, ISupportFragment {

  //region Ui

  @LayoutRes
  protected abstract int getLayout();

  @CallSuper
  protected void initializeView(@NonNull View view, @Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this, view);
  }

  //endregion

  //region Lifecycle

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    delegate.onAttach((Activity) context);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(getLayout(), container, false);
    initializeView(view, savedInstanceState);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getPresenter().initializeManagers(getContext());
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    delegate.onCreate(savedInstanceState);
  }

  @Override
  public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    return delegate.onCreateAnimation(transit, enter, nextAnim);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    delegate.onActivityCreated(savedInstanceState);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    delegate.onSaveInstanceState(outState);
  }

  @Override
  public void onResume() {
    super.onResume();
    delegate.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
    delegate.onPause();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    delegate.onDestroyView();
  }

  @Override
  public void onDetach() {
    getPresenter().detach();
    super.onDetach();
  }

  @Override
  public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    delegate.onHiddenChanged(hidden);
  }

  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    delegate.setUserVisibleHint(isVisibleToUser);
  }

  //endregion

  //region Back

  @Override
  public boolean onBackPressedSupport() {
    return delegate.onBackPressedSupport();
  }

  //endregion

  //region Fragment Animator

  @Override
  public FragmentAnimator onCreateFragmentAnimator() {
    return delegate.onCreateFragmentAnimator();
  }

  @Override
  public FragmentAnimator getFragmentAnimator() {
    return delegate.getFragmentAnimator();
  }

  @Override
  public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
    delegate.setFragmentAnimator(fragmentAnimator);
  }

  //endregion

  //region Support Fragment

  final SupportFragmentDelegate delegate = new SupportFragmentDelegate(this);

  @Override
  public SupportFragmentDelegate getSupportDelegate() {
    return delegate;
  }

  @Override
  public ExtraTransaction extraTransaction() {
    return delegate.extraTransaction();
  }

  @Override
  public void enqueueAction(Runnable runnable) {
    delegate.enqueueAction(runnable);
  }

  @Override
  public void post(Runnable runnable) {
    delegate.post(runnable);
  }

  @Override
  public void onEnterAnimationEnd(@Nullable Bundle savedInstanceState) {
    delegate.onEnterAnimationEnd(savedInstanceState);
  }

  @Override
  public void onLazyInitView(@Nullable Bundle savedInstanceState) {
    delegate.onLazyInitView(savedInstanceState);
  }

  @Override
  public void onSupportVisible() {
    delegate.onSupportVisible();
  }

  @Override
  public void onSupportInvisible() {
    delegate.onSupportInvisible();
  }

  @Override
  public boolean isSupportVisible() {
    return delegate.isSupportVisible();
  }

  @Override
  public void setFragmentResult(int resultCode, Bundle bundle) {
    delegate.setFragmentResult(resultCode, bundle);
  }

  @Override
  public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
    delegate.onFragmentResult(requestCode, resultCode, data);
  }

  @Override
  public void onNewBundle(Bundle args) {
    delegate.onNewBundle(args);
  }

  @Override
  public void putNewBundle(Bundle newBundle) {
    delegate.putNewBundle(newBundle);
  }

  //endregion

  //region Soft Input

  protected void hideSoftInput() {
    delegate.hideSoftInput();
  }

  protected void showSoftInput(final View view) {
    delegate.showSoftInput(view);
  }

  //endregion

  //region Fragment

  public void loadRootFragment(int containerId, BaseFragment toFragment) {
    delegate.loadRootFragment(containerId, toFragment);
  }

  public void loadRootFragment(
    int containerId, BaseFragment toFragment, boolean addToBackStack, boolean allowAnimation) {
    delegate.loadRootFragment(containerId, toFragment, addToBackStack, allowAnimation);
  }

  public void loadMultipleRootFragment(int containerId, int showPosition, BaseFragment... toFragments) {
    delegate.loadMultipleRootFragment(containerId, showPosition, toFragments);
  }

  public void start(BaseFragment toFragment) {
    delegate.start(toFragment);
  }

  public void start(final ISupportFragment toFragment, @LaunchMode int launchMode) {
    delegate.start(toFragment, launchMode);
  }

  public void startForResult(BaseFragment toFragment, int requestCode) {
    delegate.startForResult(toFragment, requestCode);
  }

  public void startWithPop(ISupportFragment toFragment) {
    delegate.startWithPop(toFragment);
  }

  public void startWithPopTo(ISupportFragment toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment) {
    delegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment);
  }

  public void replaceFragment(ISupportFragment toFragment, boolean addToBackStack) {
    delegate.replaceFragment(toFragment, addToBackStack);
  }

  public void showHideFragment(BaseFragment showFragment) {
    delegate.showHideFragment(showFragment);
  }

  public void showHideFragment(BaseFragment showFragment, BaseFragment hideFragment) {
    delegate.showHideFragment(showFragment, hideFragment);
  }

  public void pop() {
    delegate.pop();
  }

  public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment) {
    delegate.popTo(targetFragmentClass, includeTargetFragment);
  }

  public <T extends BaseFragment> T findChildFragment(Class<T> fragmentClass) {
    return SupportHelper.findFragment(getChildFragmentManager(), fragmentClass);
  }

  //endregion
}
