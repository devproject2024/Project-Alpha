package net.one97.paytm.ups.pref;

public interface UpsSharedPreferenceHelper {
    String getUserId();

    boolean isUserIdSaved();

    void saveUserId(String str);
}
