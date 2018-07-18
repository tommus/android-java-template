package co.windly.rename.utility.debug;

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class Bugtracker {

	//region Constructor

	private Bugtracker() {
		/* No-op. */
	}

	//endregion

	//region Initialization

	public static void init(boolean enable, Context context) {
		if (enable) {
			Fabric.with(context, new Crashlytics());
		}
	}

	//endregion
}
