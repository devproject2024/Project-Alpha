package com.paytm.android.chat.network.response;

import java.io.Serializable;

public class ResponseOfUserSettings extends ResponseBase implements Serializable {
    private DataOfSettings data;

    public DataOfSettings getData() {
        return this.data;
    }

    public void setData(DataOfSettings dataOfSettings) {
        this.data = dataOfSettings;
    }

    public static class DataOfSettings {
        private String appLanguage;
        private String discoverSetting;
        private String downloadSettings;
        private int lockScreenNotification = 0;
        private String receiveSetting;
        private int soundNotification = 0;
        private String userId;

        public String getAppLanguage() {
            return this.appLanguage;
        }

        public void setAppLanguage(String str) {
            this.appLanguage = str;
        }

        public String getDiscoverSetting() {
            return this.discoverSetting;
        }

        public void setDiscoverSetting(String str) {
            this.discoverSetting = str;
        }

        public String getDownloadSettings() {
            return this.downloadSettings;
        }

        public void setDownloadSettings(String str) {
            this.downloadSettings = str;
        }

        public int getLockScreenNotification() {
            return this.lockScreenNotification;
        }

        public void setLockScreenNotification(int i2) {
            this.lockScreenNotification = i2;
        }

        public String getReceiveSetting() {
            return this.receiveSetting;
        }

        public void setReceiveSetting(String str) {
            this.receiveSetting = str;
        }

        public int getSoundNotification() {
            return this.soundNotification;
        }

        public void setSoundNotification(int i2) {
            this.soundNotification = i2;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setUserId(String str) {
            this.userId = str;
        }

        public String toString() {
            return "DataOfSettings{appLanguage='" + this.appLanguage + '\'' + ", discoverSetting='" + this.discoverSetting + '\'' + ", downloadSettings='" + this.downloadSettings.toString() + '\'' + ", lockScreenNotification=" + this.lockScreenNotification + ", receiveSetting='" + this.receiveSetting + '\'' + ", soundNotification=" + this.soundNotification + ", userId=" + this.userId + '}';
        }
    }

    public static class DownloadSettings {
        private String audio;
        private String camera;
        private String documents;
        private String photos;

        public String getCamera() {
            return this.camera;
        }

        public void setCamera(String str) {
            this.camera = str;
        }

        public String getPhotos() {
            return this.photos;
        }

        public void setPhotos(String str) {
            this.photos = str;
        }

        public String getDocuments() {
            return this.documents;
        }

        public void setDocuments(String str) {
            this.documents = str;
        }

        public String getAudio() {
            return this.audio;
        }

        public void setAudio(String str) {
            this.audio = str;
        }

        public String toString() {
            return "DownloadSettings{camera='" + this.camera + '\'' + ", photos='" + this.photos + '\'' + ", documents='" + this.documents + '\'' + ", audio='" + this.audio + '\'' + '}';
        }
    }
}
