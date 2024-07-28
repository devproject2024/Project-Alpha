package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRUserSocialInfoV2 implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "siteLoginId")
    private String mSiteLoginId;
    @b(a = "siteName")
    private String mSiteName;
    @b(a = "info")
    private SocialSiteInfo mSocialSiteInfo;
    @b(a = "userId")
    private String mUserId;

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getSiteName() {
        return this.mSiteName;
    }

    public void setSiteName(String str) {
        this.mSiteName = str;
    }

    public String getSiteLoginId() {
        return this.mSiteLoginId;
    }

    public void setSiteLoginId(String str) {
        this.mSiteLoginId = str;
    }

    public SocialSiteInfo getSocialSiteInfo() {
        return this.mSocialSiteInfo;
    }

    public void setSocialSiteInfo(SocialSiteInfo socialSiteInfo) {
        this.mSocialSiteInfo = socialSiteInfo;
    }

    public class SocialSiteInfo {
        @b(a = "firstName")
        private String mFirstName;
        @b(a = "gender")
        private String mGender;
        @b(a = "lastName")
        private String mLastName;
        @b(a = "locale")
        private String mLocale;
        @b(a = "picture")
        private String mPicture;

        public SocialSiteInfo() {
        }

        public String getFirstName() {
            return this.mFirstName;
        }

        public void setFirstName(String str) {
            this.mFirstName = str;
        }

        public String getLastName() {
            return this.mLastName;
        }

        public void setLastName(String str) {
            this.mLastName = str;
        }

        public String getGender() {
            return this.mGender;
        }

        public void setGender(String str) {
            this.mGender = str;
        }

        public String getLocale() {
            return this.mLocale;
        }

        public void setLocale(String str) {
            this.mLocale = str;
        }

        public String getPicture() {
            return this.mPicture;
        }

        public void setPicture(String str) {
            this.mPicture = str;
        }
    }
}
