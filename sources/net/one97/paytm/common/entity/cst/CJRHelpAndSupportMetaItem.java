package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHelpAndSupportMetaItem implements IJRDataModel {
    private static final String TAG = CJRHelpAndSupportMetaItem.class.getSimpleName();
    @b(a = "api_url_android_archived_issues_homepage")
    CJRHelpAndSupportMetaItemDetails archivedIssues;
    @b(a = "api_url_android_bank_homepage")
    CJRHelpAndSupportMetaItemDetails bankHomepage;
    @b(a = "api_url_android_fastag_homepage")
    CJRHelpAndSupportMetaItemDetails fasttagHomePage;
    @b(a = "api_url_android_gv_homepage")
    CJRHelpAndSupportMetaItemDetails gvHomePage;
    @b(a = "login_required")
    CJRHelpAndSupportItemLoginRequired login;
    @b(a = "mall_icon")
    CJRHelpAndSupportMallIcon mallIcon;
    @b(a = "parent_id")
    CJRHelpAndSupportItemParent parent;
    @b(a = "api_url_android_recentorders_homepage")
    CJRHelpAndSupportMetaItemDetails recentOrdersHomepage;
    @b(a = "api_url_android_recentorders_homepage_mall")
    CJRHelpAndSupportMetaItemDetails recentOrdersHomepageMall;
    private final Long serialVersionUID = 1L;
    @b(a = "api_url_android_wallet_homepage")
    CJRHelpAndSupportMetaItemDetails walletHomepage;
    @b(a = "api_url_android_webview_homepage")
    CJRHelpAndSupportMetaItemDetails webviewHomepage;

    public CJRHelpAndSupportMetaItemDetails getGvHomePage() {
        return this.gvHomePage;
    }

    public void setGvHomePage(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.gvHomePage = cJRHelpAndSupportMetaItemDetails;
    }

    public CJRHelpAndSupportMetaItemDetails getFasttagHomePage() {
        return this.fasttagHomePage;
    }

    public void setFasttagHomePage(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.fasttagHomePage = cJRHelpAndSupportMetaItemDetails;
    }

    public CJRHelpAndSupportMallIcon getMallIcon() {
        return this.mallIcon;
    }

    public void setMallIcon(CJRHelpAndSupportMallIcon cJRHelpAndSupportMallIcon) {
        this.mallIcon = cJRHelpAndSupportMallIcon;
    }

    public CJRHelpAndSupportMetaItemDetails getBankHomepage() {
        return this.bankHomepage;
    }

    public void setBankHomepage(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.bankHomepage = cJRHelpAndSupportMetaItemDetails;
    }

    public CJRHelpAndSupportMetaItemDetails getWalletHomepage() {
        return this.walletHomepage;
    }

    public void setWalletHomepage(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.walletHomepage = cJRHelpAndSupportMetaItemDetails;
    }

    public CJRHelpAndSupportMetaItemDetails getRecentOrdersHomepage() {
        return this.recentOrdersHomepage;
    }

    public void setRecentOrdersHomepage(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.recentOrdersHomepage = cJRHelpAndSupportMetaItemDetails;
    }

    public CJRHelpAndSupportMetaItemDetails getWebviewHomepage() {
        return this.webviewHomepage;
    }

    public void setWebviewHomepage(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.webviewHomepage = cJRHelpAndSupportMetaItemDetails;
    }

    public CJRHelpAndSupportMetaItemDetails getArchivedIssues() {
        return this.archivedIssues;
    }

    public void setArchivedIssues(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.archivedIssues = cJRHelpAndSupportMetaItemDetails;
    }

    public CJRHelpAndSupportMetaItemDetails getRecentOrdersHomepageMall() {
        return this.recentOrdersHomepageMall;
    }

    public void setRecentOrdersHomepageMall(CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails) {
        this.recentOrdersHomepageMall = cJRHelpAndSupportMetaItemDetails;
    }

    public String getApiUrlValue(boolean z) {
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails;
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails2 = this.bankHomepage;
        if (cJRHelpAndSupportMetaItemDetails2 != null) {
            return cJRHelpAndSupportMetaItemDetails2.getValue();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails3 = this.walletHomepage;
        if (cJRHelpAndSupportMetaItemDetails3 != null) {
            return cJRHelpAndSupportMetaItemDetails3.getValue();
        }
        if (z && (cJRHelpAndSupportMetaItemDetails = this.recentOrdersHomepageMall) != null) {
            return cJRHelpAndSupportMetaItemDetails.getValue();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails4 = this.recentOrdersHomepage;
        if (cJRHelpAndSupportMetaItemDetails4 != null) {
            return cJRHelpAndSupportMetaItemDetails4.getValue();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails5 = this.webviewHomepage;
        if (cJRHelpAndSupportMetaItemDetails5 != null) {
            return cJRHelpAndSupportMetaItemDetails5.getValue();
        }
        CJRHelpAndSupportItemParent cJRHelpAndSupportItemParent = this.parent;
        if (cJRHelpAndSupportItemParent != null) {
            return cJRHelpAndSupportItemParent.getValue();
        }
        return null;
    }

    public String getApiUrlKey(boolean z) {
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails;
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails2 = this.bankHomepage;
        if (cJRHelpAndSupportMetaItemDetails2 != null) {
            return cJRHelpAndSupportMetaItemDetails2.getKey();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails3 = this.walletHomepage;
        if (cJRHelpAndSupportMetaItemDetails3 != null) {
            return cJRHelpAndSupportMetaItemDetails3.getKey();
        }
        if (z && (cJRHelpAndSupportMetaItemDetails = this.recentOrdersHomepageMall) != null) {
            return cJRHelpAndSupportMetaItemDetails.getKey();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails4 = this.recentOrdersHomepage;
        if (cJRHelpAndSupportMetaItemDetails4 != null) {
            return cJRHelpAndSupportMetaItemDetails4.getKey();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails5 = this.webviewHomepage;
        if (cJRHelpAndSupportMetaItemDetails5 != null) {
            return cJRHelpAndSupportMetaItemDetails5.getKey();
        }
        return null;
    }

    public int getApiIssueId(boolean z) {
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails;
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails2 = this.bankHomepage;
        if (cJRHelpAndSupportMetaItemDetails2 != null) {
            return cJRHelpAndSupportMetaItemDetails2.getIssueId();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails3 = this.walletHomepage;
        if (cJRHelpAndSupportMetaItemDetails3 != null) {
            return cJRHelpAndSupportMetaItemDetails3.getIssueId();
        }
        if (z && (cJRHelpAndSupportMetaItemDetails = this.recentOrdersHomepageMall) != null) {
            return cJRHelpAndSupportMetaItemDetails.getIssueId();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails4 = this.recentOrdersHomepage;
        if (cJRHelpAndSupportMetaItemDetails4 != null) {
            return cJRHelpAndSupportMetaItemDetails4.getIssueId();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails5 = this.webviewHomepage;
        if (cJRHelpAndSupportMetaItemDetails5 != null) {
            return cJRHelpAndSupportMetaItemDetails5.getIssueId();
        }
        return -1;
    }

    public String getApiFile(boolean z) {
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails;
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails2 = this.bankHomepage;
        if (cJRHelpAndSupportMetaItemDetails2 != null) {
            return cJRHelpAndSupportMetaItemDetails2.getFile();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails3 = this.walletHomepage;
        if (cJRHelpAndSupportMetaItemDetails3 != null) {
            return cJRHelpAndSupportMetaItemDetails3.getFile();
        }
        if (z && (cJRHelpAndSupportMetaItemDetails = this.recentOrdersHomepageMall) != null) {
            return cJRHelpAndSupportMetaItemDetails.getFile();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails4 = this.recentOrdersHomepage;
        if (cJRHelpAndSupportMetaItemDetails4 != null) {
            return cJRHelpAndSupportMetaItemDetails4.getFile();
        }
        CJRHelpAndSupportMetaItemDetails cJRHelpAndSupportMetaItemDetails5 = this.webviewHomepage;
        if (cJRHelpAndSupportMetaItemDetails5 != null) {
            return cJRHelpAndSupportMetaItemDetails5.getFile();
        }
        return null;
    }

    public int getParentId() {
        CJRHelpAndSupportItemParent cJRHelpAndSupportItemParent = this.parent;
        if (cJRHelpAndSupportItemParent != null) {
            try {
                return Integer.parseInt(cJRHelpAndSupportItemParent.getValue());
            } catch (Exception unused) {
                q.a();
            }
        }
        return -1;
    }

    public boolean isLoginRequired() {
        CJRHelpAndSupportItemLoginRequired cJRHelpAndSupportItemLoginRequired = this.login;
        return cJRHelpAndSupportItemLoginRequired != null && cJRHelpAndSupportItemLoginRequired.isLoginRequired();
    }
}
