package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSocialMediaLinks implements IJRDataModel {
    @b(a = "facebook")
    CJRSocialAtrributes mfacebook;
    @b(a = "instagram")
    CJRSocialAtrributes minstagram;
    @b(a = "pinInterest")
    CJRSocialAtrributes mpintrest;
    @b(a = "twitter")
    CJRSocialAtrributes mtwitter;
    @b(a = "youtube")
    CJRSocialAtrributes myoutube;

    public CJRSocialAtrributes getMtwitter() {
        return this.mtwitter;
    }

    public void setMtwitter(CJRSocialAtrributes cJRSocialAtrributes) {
        this.mtwitter = cJRSocialAtrributes;
    }

    public CJRSocialAtrributes getMpintrest() {
        return this.mpintrest;
    }

    public void setMpintrest(CJRSocialAtrributes cJRSocialAtrributes) {
        this.mpintrest = cJRSocialAtrributes;
    }

    public CJRSocialAtrributes getMfacebook() {
        return this.mfacebook;
    }

    public void setMfacebook(CJRSocialAtrributes cJRSocialAtrributes) {
        this.mfacebook = cJRSocialAtrributes;
    }

    public CJRSocialAtrributes getMinstagram() {
        return this.minstagram;
    }

    public void setMinstagram(CJRSocialAtrributes cJRSocialAtrributes) {
        this.minstagram = cJRSocialAtrributes;
    }

    public CJRSocialAtrributes getMyoutube() {
        return this.myoutube;
    }

    public void setMyoutube(CJRSocialAtrributes cJRSocialAtrributes) {
        this.myoutube = cJRSocialAtrributes;
    }
}
