package co.windly.rename.presentation.splash;

import android.content.Context;
import android.support.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivityPresenter;
import co.windly.rename.data.domain.manager.BookDomainManager;
import co.windly.rename.utility.log.WiLogger;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

@SuppressWarnings("FieldCanBeLocal")
class SplashPresenter extends LimboActivityPresenter<SplashView> {

  //region Managers

  private BookDomainManager bookManager;

  @Override
  protected void initializeManagers(@NonNull Context context) {
    super.initializeManagers(context);
    bookManager = new BookDomainManager(context);
  }

  //endregion

  //region Download Books

  void downloadBooksAndCharacters() {

    disposables
      .add(
        Completable.mergeArrayDelayError(
          bookManager.downloadBooks(),
          bookManager.downloadCharacters()
        )
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(
            this::handleDownloadBooksAndCharactersSuccess,
            this::handleDownloadBooksAndCharactersError));
  }

  private void handleDownloadBooksAndCharactersSuccess() {

    // Log the fact.
    WiLogger.v("Successfully downloaded books and characters.");
  }

  private void handleDownloadBooksAndCharactersError(@NonNull Throwable throwable) {

    // Log na error.
    WiLogger.e("An error occurred while downloading books and characters.");
    WiLogger.e(throwable.getLocalizedMessage());
  }

  //endregion
}
