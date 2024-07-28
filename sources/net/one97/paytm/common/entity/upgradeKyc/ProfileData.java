package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import java.util.List;

public class ProfileData {
    @b(a = "app_variable_config")
    private AppVariableConfig app_variable_config;
    @b(a = "next")
    private List<Next> next = null;
    @b(a = "pp")
    private String pp;

    public String getPp() {
        return this.pp;
    }

    public void setPp(String str) {
        this.pp = str;
    }

    public List<Next> getNext() {
        return this.next;
    }

    public void setNext(List<Next> list) {
        this.next = list;
    }

    public AppVariableConfig getAppVariableConfig() {
        return this.app_variable_config;
    }

    public void setAppVariableConfig(AppVariableConfig appVariableConfig) {
        this.app_variable_config = appVariableConfig;
    }

    public class AppVariableConfig {
        @b(a = "BENEFICIARY")
        private BENEFICIARY beneficiary;
        @b(a = "CERSAI")
        private CERSAI cersai;
        @b(a = "FULLKYC")
        private FULLKYC fullKyc;
        @b(a = "KYC")
        private KYC kyc;
        @b(a = "MINKYC")
        private MINKYC minkyc;
        @b(a = "PAYMENTPREFERENCE")
        private PAYMENTPREFERENCE paymentpreference;
        @b(a = "UPISTATUS")
        private UPISTATUS upistatus;
        @b(a = "VERIFIEDADHAAR")
        private VERIFIEDADHAAR verifiedaadhar;
        @b(a = "VERIFIEDEMAIL")
        private VERIFIEDEMAIL verifiedemail;
        @b(a = "VERIFIEDPAN")
        private VERIFIEDPAN verifiedpan;
        @b(a = "VERIFIEDMOBILENUMBER")
        private VERIFIEDMOBILENUMBER verifyNumber;

        public AppVariableConfig() {
        }

        public VERIFIEDMOBILENUMBER getVerifyNumber() {
            return this.verifyNumber;
        }

        public void setVerifyNumber(VERIFIEDMOBILENUMBER verifiedmobilenumber) {
            this.verifyNumber = verifiedmobilenumber;
        }

        public VERIFIEDEMAIL getVerifiedemail() {
            return this.verifiedemail;
        }

        public void setVerifiedemail(VERIFIEDEMAIL verifiedemail2) {
            this.verifiedemail = verifiedemail2;
        }

        public FULLKYC getFullKyc() {
            return this.fullKyc;
        }

        public void setFullKyc(FULLKYC fullkyc) {
            this.fullKyc = fullkyc;
        }

        public PAYMENTPREFERENCE getPaymentpreference() {
            return this.paymentpreference;
        }

        public void setPaymentpreference(PAYMENTPREFERENCE paymentpreference2) {
            this.paymentpreference = paymentpreference2;
        }

        public CERSAI getCersai() {
            return this.cersai;
        }

        public void setCersai(CERSAI cersai2) {
            this.cersai = cersai2;
        }

        public BENEFICIARY getBeneficiary() {
            return this.beneficiary;
        }

        public void setBeneficiary(BENEFICIARY beneficiary2) {
            this.beneficiary = beneficiary2;
        }

        public UPISTATUS getUpistatus() {
            return this.upistatus;
        }

        public void setUpistatus(UPISTATUS upistatus2) {
            this.upistatus = upistatus2;
        }

        public MINKYC getMINKYC() {
            return this.minkyc;
        }

        public void setMINKYC(MINKYC minkyc2) {
            this.minkyc = minkyc2;
        }

        public KYC getKYC() {
            return this.kyc;
        }

        public void setKYC(KYC kyc2) {
            this.kyc = kyc2;
        }

        public VERIFIEDADHAAR getVERIFIEDAADHAR() {
            return this.verifiedaadhar;
        }

        public void setVERIFIEDAADHAR(VERIFIEDADHAAR verifiedadhaar) {
            this.verifiedaadhar = this.verifiedaadhar;
        }

        public VERIFIEDPAN getVERIFIEDPAN() {
            return this.verifiedpan;
        }

        public void setVERIFIEDPAN(VERIFIEDPAN verifiedpan2) {
            this.verifiedpan = this.verifiedpan;
        }
    }

    public class KYC {
        @b(a = "Deep-link")
        private String deepLink;
        @b(a = "Title")
        private String title;

        public KYC() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class MINKYC {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public MINKYC() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class VERIFIEDADHAAR {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public VERIFIEDADHAAR() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class VERIFIEDPAN {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public VERIFIEDPAN() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class VERIFIEDMOBILENUMBER {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public VERIFIEDMOBILENUMBER() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class VERIFIEDEMAIL {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public VERIFIEDEMAIL() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class FULLKYC {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public FULLKYC() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class PAYMENTPREFERENCE {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public PAYMENTPREFERENCE() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class CERSAI {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public CERSAI() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class BENEFICIARY {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public BENEFICIARY() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }

    public class UPISTATUS {
        @b(a = "deepLink")
        private String deepLink;
        @b(a = "title")
        private String title;

        public UPISTATUS() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDeepLink() {
            return this.deepLink;
        }

        public void setDeepLink(String str) {
            this.deepLink = str;
        }
    }
}
