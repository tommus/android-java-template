package co.windly.rename.application;

import android.app.Application;
import co.windly.rename.BuildConfig;
import co.windly.rename.utility.debug.Bugtracker;
import co.windly.rename.utility.debug.DebugBridge;
import co.windly.rename.utility.log.WiLogger;

public class Rename extends Application {

  //region Lifecycle

  @Override
  public void onCreate() {
    super.onCreate();

    initializeBugtracker();
    initializeDebugBridge();
    initializeLogger();
  }

  //endregion

  //region Bugtracker

  private void initializeBugtracker() {
    Bugtracker.init(BuildConfig.ENABLE_BUG_TRACKER, this);
  }

  //endregion

  //region Debug Bridge

  private void initializeDebugBridge() {
    DebugBridge.init(BuildConfig.ENABLE_DEBUG_BRIDGE, this);
  }

  //endregion

  //region Logger

  private void initializeLogger() {
    WiLogger.init(BuildConfig.DEBUG);
  }

  //endregion
}
