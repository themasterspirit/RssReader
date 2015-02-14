package ua.ck.geekhub.ivanov.rssreader.heplers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceHelper {

    private static SharedPreferenceHelper mInstance;

    private SharedPreferences mSharedPreferences;

    public static final String NOTIFICATION_ON = "pref_key_notification_on";
    public static final String NOTIFICATION_VIBRATION = "pref_key_notification_vibration";
    public static final String NOTIFICATION_LED = "pref_key_notification_led";
    public static final String NOTIFICATION_SOUND = "pref_key_notification_sound";
    public static final String NOTIFICATION_DELAY = "pref_key_notification_delay";

    public static final String SPINNER_POSITION = "spinner_position";
    public static final String LAST_NEWS_LINK = "last_news_link";
    public static final String RUNNING_LIST_FRAGMENT = "running_list_fragment";
    public static final String ATTEMPT_TO_UPDATE = "attempt_to_update";

    private SharedPreferenceHelper(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferenceHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPreferenceHelper(context);
        }
        return mInstance;
    }

    public boolean isNotification() {
        return mSharedPreferences.getBoolean(NOTIFICATION_ON, false);
    }

    public boolean isVibration() {
        return mSharedPreferences.getBoolean(NOTIFICATION_VIBRATION, true);
    }

    public boolean isLed() {
        return mSharedPreferences.getBoolean(NOTIFICATION_LED, false);
    }

    public boolean isSound() {
        return mSharedPreferences.getBoolean(NOTIFICATION_SOUND, true);
    }

    public int getDelay() {
        return mSharedPreferences.getInt(NOTIFICATION_DELAY, 3);
    }

    public int getSpinnerPosition() {
        return mSharedPreferences.getInt(SPINNER_POSITION, 0);
    }

    public void putSpinnerPosition(int position) {
        mSharedPreferences.edit()
                .putInt(SPINNER_POSITION, position)
                .apply();
    }

    public String getLastNewsLink() {
        return mSharedPreferences.getString(LAST_NEWS_LINK, null);
    }

    public void putLastNewsLink(String link) {
        mSharedPreferences.edit()
                .putString(LAST_NEWS_LINK, link)
                .apply();
    }

    public boolean isListRunning() {
        return mSharedPreferences.getBoolean(RUNNING_LIST_FRAGMENT, false);
    }

    public void putListRunning(boolean isRunning) {
        mSharedPreferences.edit()
                .putBoolean(RUNNING_LIST_FRAGMENT, isRunning)
                .apply();
    }

    public int getCountAttempt() {
        return mSharedPreferences.getInt(ATTEMPT_TO_UPDATE, (3));
    }
}