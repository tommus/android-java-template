package co.windly.rename.data.persistence.settings;

import org.jraf.android.prefs.DefaultString;
import org.jraf.android.prefs.Prefs;

import static android.content.Context.MODE_PRIVATE;

@Prefs(value = "SessionCache", fileMode = MODE_PRIVATE)
public class SessionCache {

  //region Welcome Text

  @DefaultString("")
  String accessToken;

  //endregion
}
