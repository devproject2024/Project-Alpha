package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CSTReasonsMetaData extends IJRDataModel {
    @b(a = "api_url_android")
    private CJRReasonsAPIUrl apiUrl;
    @b(a = "community")
    private CJRReasonsAPIUrl community;
    @b(a = "deeplink")
    private CJRCSTDeepLink deeplink;
    @b(a = "ivr")
    private CJRReasonsAPIUrl ivr;
    @b(a = "our_suggestion")
    private CJRReasonsAPIUrl ourSuggestion;
    @b(a = "api_url_android_recentorders_homepage")
    private CJRReasonsAPIUrl recentOrderUrl;
    @b(a = "toggle_display")
    private CJRCSTDeepLink toggleDisplay;

    public CJRCSTDeepLink getToggleDisplay() {
        return this.toggleDisplay;
    }

    public void setToggleDisplay(CJRCSTDeepLink cJRCSTDeepLink) {
        this.toggleDisplay = cJRCSTDeepLink;
    }

    public void setApiUrl(CJRReasonsAPIUrl cJRReasonsAPIUrl) {
        this.apiUrl = cJRReasonsAPIUrl;
    }

    public void setOurSuggestion(CJRReasonsAPIUrl cJRReasonsAPIUrl) {
        this.ourSuggestion = cJRReasonsAPIUrl;
    }

    public void setRecentOrderUrl(CJRReasonsAPIUrl cJRReasonsAPIUrl) {
        this.recentOrderUrl = cJRReasonsAPIUrl;
    }

    public CJRReasonsAPIUrl getApiUrl() {
        return this.apiUrl;
    }

    public CJRReasonsAPIUrl getOurSuggestion() {
        return this.ourSuggestion;
    }

    public CJRReasonsAPIUrl getRecentOrderUrl() {
        return this.recentOrderUrl;
    }

    public CJRReplacementReason clone() throws CloneNotSupportedException {
        return (CJRReplacementReason) super.clone();
    }

    public CJRReasonsAPIUrl getIvr() {
        return this.ivr;
    }

    public void setIvr(CJRReasonsAPIUrl cJRReasonsAPIUrl) {
        this.ivr = cJRReasonsAPIUrl;
    }

    public CJRReasonsAPIUrl getCommunity() {
        return this.community;
    }

    public void setCommunity(CJRReasonsAPIUrl cJRReasonsAPIUrl) {
        this.community = cJRReasonsAPIUrl;
    }

    public CJRCSTDeepLink getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(CJRCSTDeepLink cJRCSTDeepLink) {
        this.deeplink = cJRCSTDeepLink;
    }
}
