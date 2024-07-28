package net.one97.paytm.common.entity.home;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class LeftNavigationModel extends IJRPaytmDataModel {
    private FooterModel footer;
    private HeaderModel header;

    public HeaderModel getHeader() {
        return this.header;
    }

    public void setHeader(HeaderModel headerModel) {
        this.header = headerModel;
    }

    public FooterModel getFooter() {
        return this.footer;
    }

    public void setFooter(FooterModel footerModel) {
        this.footer = footerModel;
    }

    public class HeaderModel implements IJRDataModel {
        private String accountBalance;
        private String accountNumber;
        private List<String> availableProfiles;
        private String headerBg;
        private String headerImageUrl;
        private String name;
        private String primaryUpiId;
        private boolean securityShieldEnabled;
        private String selectedProfile;
        private boolean showLinkBankAccount;

        public HeaderModel() {
        }

        public String getHeaderImageUrl() {
            return this.headerImageUrl;
        }

        public void setHeaderImageUrl(String str) {
            this.headerImageUrl = str;
        }

        public boolean isShowLinkBankAccount() {
            return this.showLinkBankAccount;
        }

        public void setShowLinkBankAccount(boolean z) {
            this.showLinkBankAccount = z;
        }

        public List<String> getAvailableProfiles() {
            return this.availableProfiles;
        }

        public void setAvailableProfiles(List<String> list) {
            this.availableProfiles = list;
        }

        public String getPrimaryUpiId() {
            return this.primaryUpiId;
        }

        public void setPrimaryUpiId(String str) {
            this.primaryUpiId = str;
        }

        public String getSelectedProfile() {
            return this.selectedProfile;
        }

        public void setSelectedProfile(String str) {
            this.selectedProfile = str;
        }

        public boolean isSecurityShieldEnabled() {
            return this.securityShieldEnabled;
        }

        public void setSecurityShieldEnabled(boolean z) {
            this.securityShieldEnabled = z;
        }

        public String getHeaderBg() {
            return this.headerBg;
        }

        public void setHeaderBg(String str) {
            this.headerBg = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getAccountBalance() {
            return this.accountBalance;
        }

        public void setAccountBalance(String str) {
            this.accountBalance = str;
        }

        public String getAccountNumber() {
            return this.accountNumber;
        }

        public void setAccountNumber(String str) {
            this.accountNumber = str;
        }
    }

    public class FooterModel implements IJRDataModel {
        private List<CJRHomePageItem> cjrHomePageItem;
        private CJRHomePageItem displayedItem;

        public FooterModel() {
        }

        public void setCjrHomePageItem(List<CJRHomePageItem> list) {
            this.cjrHomePageItem = list;
        }

        public List<CJRHomePageItem> getCjrHomePageItem() {
            return this.cjrHomePageItem;
        }

        public CJRHomePageItem getDisplayedItem() {
            return this.displayedItem;
        }

        public void setDisplayedItem(CJRHomePageItem cJRHomePageItem) {
            this.displayedItem = cJRHomePageItem;
        }
    }

    public enum LeftNavigationModelType {
        TYPE_TITLE("title"),
        TYPE_FOOTER(ViewHolderFactory.TYPE_SEAL_TRUST);
        
        private final String name;

        private LeftNavigationModelType(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }
    }
}
