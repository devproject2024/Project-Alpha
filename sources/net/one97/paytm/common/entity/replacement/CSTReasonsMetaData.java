package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.cst.CSTForm;
import net.one97.paytm.common.entity.cst.cstWidget.CJRCSTDeepLink;

public class CSTReasonsMetaData implements Cloneable, IJRDataModel {
    @b(a = "api_url_android")
    private CJRReasonsAPIUrl apiUrl;
    @b(a = "community")
    private CJRReasonsAPIUrl community;
    @b(a = "deeplink")
    private CJRCSTDeepLink deeplink;
    @b(a = "form")
    private CSTForm form;
    @b(a = "ivr")
    private CJRReasonsAPIUrl ivr;
    @b(a = "our_suggestion")
    private CJRReasonsAPIUrl ourSuggestion;
    @b(a = "api_url_android_recentorders_homepage")
    private CJRReasonsAPIUrl recentOrderUrl;
    @b(a = "toggle_display")
    private CJRCSTDeepLink toggleDisplay;

    public CSTForm getForm() {
        return this.form;
    }

    public void setForm(CSTForm cSTForm) {
        this.form = cSTForm;
    }

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
