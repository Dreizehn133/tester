package mobile.sti.com.sti.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Dreizehn on 4/20/2018.
 */

public class Preference {
    private SharedPreferences ssp;
    private SharedPreferences.Editor editor;

    public Preference(Context c) {
        ssp = PreferenceManager.getDefaultSharedPreferences(c);
        editor = ssp.edit();
    }

    public boolean getWelcome() {
        return ssp.getBoolean("welcome_screen", false);
    }

    public void setWelcome(boolean x) {
        editor.putBoolean("welcome_screen", x);
        editor.commit();
    }

    public void clear() {
        setWelcome(false);
    }


}
