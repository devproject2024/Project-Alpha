package com.paytm.android.chat.network.requests;

import c.a.a.a;
import c.a.a.f;
import com.paytm.android.chat.c;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.network.response.ResponseOfUserSettings;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.q;

public class GetUserSettingsRequest extends BaseRequest {
    public GetUserSettingsRequest(String str, a<ResponseOfUserSettings> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.GET_USER_SETTINGS);
        this.baseData.a("userId", str);
        f.a(url, this.baseData, aVar);
    }

    public GetUserSettingsRequest(String str) {
        new GetUserSettingsRequest(str, new a<ResponseOfUserSettings>() {
            public final /* synthetic */ void a(Object obj) {
                ResponseOfUserSettings responseOfUserSettings = (ResponseOfUserSettings) obj;
                super.a(responseOfUserSettings);
                if (responseOfUserSettings != null && responseOfUserSettings.getResultCode().equals("0") && responseOfUserSettings.getData() != null) {
                    if (responseOfUserSettings.getData().getLockScreenNotification() == 1) {
                        c.f41832a.settings_notifications_lock_screen = true;
                    } else {
                        c.f41832a.settings_notifications_lock_screen = false;
                    }
                    SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_notifications_lock_screen, c.f41832a.settings_notifications_lock_screen);
                    if (responseOfUserSettings.getData().getSoundNotification() == 1) {
                        c.f41832a.settings_notifications_sound = true;
                    } else {
                        c.f41832a.settings_notifications_sound = false;
                    }
                    SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_notifications_sound, c.f41832a.settings_notifications_sound);
                    if (responseOfUserSettings.getData().getDownloadSettings() != null && !responseOfUserSettings.getData().getDownloadSettings().isEmpty()) {
                        try {
                            ResponseOfUserSettings.DownloadSettings downloadSettings = (ResponseOfUserSettings.DownloadSettings) new com.google.gsonhtcfix.f().a(responseOfUserSettings.getData().getDownloadSettings(), ResponseOfUserSettings.DownloadSettings.class);
                            if ("on".equals(downloadSettings.getCamera())) {
                                c.f41832a.settings_media_save2camera_roll = true;
                            } else {
                                c.f41832a.settings_media_save2camera_roll = false;
                            }
                            SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.settings_media_save2camera_roll, c.f41832a.settings_media_save2camera_roll);
                            if ("cellular".equals(downloadSettings.getPhotos())) {
                                c.f41832a.settings_media_photos = 1;
                            } else if ("never".equals(downloadSettings.getPhotos())) {
                                c.f41832a.settings_media_photos = 2;
                            } else {
                                c.f41832a.settings_media_photos = 0;
                            }
                            SharedPreferencesUtil.saveInt(SharedPreferencesUtil.Key.settings_media_photos, c.f41832a.settings_media_photos);
                            if ("cellular".equals(downloadSettings.getDocuments())) {
                                c.f41832a.settings_media_documents = 1;
                            } else if ("never".equals(downloadSettings.getDocuments())) {
                                c.f41832a.settings_media_documents = 2;
                            } else {
                                c.f41832a.settings_media_documents = 0;
                            }
                            SharedPreferencesUtil.saveInt(SharedPreferencesUtil.Key.settings_media_documents, c.f41832a.settings_media_documents);
                            if ("cellular".equals(downloadSettings.getAudio())) {
                                c.f41832a.settings_media_audio = 1;
                            } else if ("never".equals(downloadSettings.getAudio())) {
                                c.f41832a.settings_media_audio = 2;
                            } else {
                                c.f41832a.settings_media_audio = 0;
                            }
                            SharedPreferencesUtil.saveInt(SharedPreferencesUtil.Key.settings_media_audio, c.f41832a.settings_media_audio);
                        } catch (Exception unused) {
                        }
                    }
                }
            }

            public final void a(int i2, String str) {
                super.a(i2, str);
                q.b("onFailure:[" + i2 + "]" + str);
            }
        });
    }
}
