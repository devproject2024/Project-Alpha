package com.paytm.android.chat.bean;

import java.io.Serializable;

public class SettingsInfoBean implements Serializable {
    public int settings_media_audio = 0;
    public int settings_media_documents = 0;
    public int settings_media_photos = 0;
    public boolean settings_media_save2camera_roll = false;
    public int settings_media_videos = 0;
    public boolean settings_notifications_lock_screen = false;
    public boolean settings_notifications_lock_screen_name = true;
    public boolean settings_notifications_lock_screen_preview = true;
    public boolean settings_notifications_sound = true;
    public boolean settings_notifications_vibrate = true;
    public int settings_privacy_discover = 7;
    public int settings_privacy_msg_from = 0;
    public int settings_privacy_online_status = 0;
    public int settings_privacy_profile_pic = 0;
}
