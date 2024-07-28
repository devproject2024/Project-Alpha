package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.SettingsInfoBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.network.response.ResponseOfUserSettings;
import com.sendbird.android.constant.StringSet;

public class SetUserSettingsRequest extends BaseRequest {
    public SetUserSettingsRequest(ResponseOfUserSettings.DataOfSettings dataOfSettings, a<String> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.UPDATE_USER_SETTINGS);
        this.baseData.c("application/json", new f().a((Object) dataOfSettings));
        c.a.a.f.b(url, this.baseData, aVar);
    }

    public SetUserSettingsRequest(String str, SettingsInfoBean settingsInfoBean, a<String> aVar) {
        f fVar = new f();
        ResponseOfUserSettings.DownloadSettings downloadSettings = new ResponseOfUserSettings.DownloadSettings();
        if (settingsInfoBean.settings_media_save2camera_roll) {
            downloadSettings.setCamera("on");
        } else {
            downloadSettings.setCamera(StringSet.off);
        }
        if (settingsInfoBean.settings_media_photos == 1) {
            downloadSettings.setPhotos("cellular");
        } else if (settingsInfoBean.settings_media_photos == 2) {
            downloadSettings.setPhotos("never");
        } else {
            downloadSettings.setPhotos("wifi");
        }
        if (settingsInfoBean.settings_media_documents == 1) {
            downloadSettings.setDocuments("cellular");
        } else if (settingsInfoBean.settings_media_documents == 2) {
            downloadSettings.setDocuments("never");
        } else {
            downloadSettings.setDocuments("wifi");
        }
        if (settingsInfoBean.settings_media_audio == 1) {
            downloadSettings.setAudio("cellular");
        } else if (settingsInfoBean.settings_media_audio == 2) {
            downloadSettings.setAudio("never");
        } else {
            downloadSettings.setAudio("wifi");
        }
        ResponseOfUserSettings.DataOfSettings dataOfSettings = new ResponseOfUserSettings.DataOfSettings();
        dataOfSettings.setUserId(str);
        dataOfSettings.setDownloadSettings(fVar.a((Object) downloadSettings));
        if (settingsInfoBean.settings_notifications_sound) {
            dataOfSettings.setSoundNotification(1);
        } else {
            dataOfSettings.setSoundNotification(0);
        }
        if (settingsInfoBean.settings_notifications_lock_screen) {
            dataOfSettings.setLockScreenNotification(1);
        } else {
            dataOfSettings.setLockScreenNotification(0);
        }
        String url = UrlManager.getUrl(UrlProfileList.UPDATE_USER_SETTINGS);
        this.baseData.c("application/json", new f().a((Object) dataOfSettings));
        c.a.a.f.b(url, this.baseData, aVar);
    }
}
