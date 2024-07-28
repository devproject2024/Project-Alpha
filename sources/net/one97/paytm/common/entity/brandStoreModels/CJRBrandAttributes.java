package net.one97.paytm.common.entity.brandStoreModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrandAttributes implements IJRDataModel {
    @b(a = "social_media_links")
    private CJRSocialMediaLinks cjrSocialMediaLinks;
    @b(a = "email_id")
    private String emailID;
    @b(a = "brand_logo")
    private CJRBrandLogo mBrandLogo;
    @b(a = "cover_image")
    private CJRBrandCover mCoverImage;
    @b(a = "img_url")
    private String mImgUrl;
    @b(a = "item_name")
    private String mItemName;
    @b(a = "mobile_no1")
    private String mMobile1;
    @b(a = "mobile_no2")
    private String mMobile2;
    @b(a = "name")
    private String mName;
    @b(a = "short_description")
    private String mTabTitleName;
    @b(a = "url_type")
    private String mUrlType;
    @b(a = "video_url")
    private String mVideoUrl;
    @b(a = "address")
    private String maddress;
    @b(a = "display_name")
    private String mdisplayName;
    @b(a = "text_description")
    private String mtextDescp;
    @b(a = "title")
    private String mtitle;
    @b(a = "visitStoreUrl")
    private String mvisitStoreUrl;

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getmItemName() {
        return this.mItemName;
    }

    public void setmItemName(String str) {
        this.mItemName = str;
    }

    public String getmUrlType() {
        return this.mUrlType;
    }

    public void setmUrlType(String str) {
        this.mUrlType = str;
    }

    public String getmImgUrl() {
        return this.mImgUrl;
    }

    public void setmImgUrl(String str) {
        this.mImgUrl = str;
    }

    public String getmVideoUrl() {
        return this.mVideoUrl;
    }

    public String getMaddress() {
        return this.maddress;
    }

    public void setMaddress(String str) {
        this.maddress = str;
    }

    public String getmMobile1() {
        return this.mMobile1;
    }

    public void setmMobile1(String str) {
        this.mMobile1 = str;
    }

    public String getmMobile2() {
        return this.mMobile2;
    }

    public void setmMobile2(String str) {
        this.mMobile2 = str;
    }

    public String getEmailID() {
        return this.emailID;
    }

    public void setEmailID(String str) {
        this.emailID = str;
    }

    public String getMvisitStoreUrl() {
        return this.mvisitStoreUrl;
    }

    public void setMvisitStoreUrl(String str) {
        this.mvisitStoreUrl = str;
    }

    public String getmTabTitleName() {
        return this.mTabTitleName;
    }

    public void setmTabTitleName(String str) {
        this.mTabTitleName = str;
    }

    public CJRSocialMediaLinks getCjrSocialMediaLinks() {
        return this.cjrSocialMediaLinks;
    }

    public void setCjrSocialMediaLinks(CJRSocialMediaLinks cJRSocialMediaLinks) {
        this.cjrSocialMediaLinks = cJRSocialMediaLinks;
    }

    public String getMdisplayName() {
        return this.mdisplayName;
    }

    public void setMdisplayName(String str) {
        this.mdisplayName = str;
    }

    public void setmVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public String getMtitle() {
        return this.mtitle;
    }

    public void setMtitle(String str) {
        this.mtitle = str;
    }

    public String getMtextDescp() {
        return this.mtextDescp;
    }

    public void setMtextDescp(String str) {
        this.mtextDescp = str;
    }

    public CJRBrandLogo getmBrandLogo() {
        return this.mBrandLogo;
    }

    public void setmBrandLogo(CJRBrandLogo cJRBrandLogo) {
        this.mBrandLogo = cJRBrandLogo;
    }

    public CJRBrandCover getmCoverImage() {
        return this.mCoverImage;
    }

    public void setmCoverImage(CJRBrandCover cJRBrandCover) {
        this.mCoverImage = cJRBrandCover;
    }
}
