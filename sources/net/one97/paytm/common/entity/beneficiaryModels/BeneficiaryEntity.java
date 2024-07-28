package net.one97.paytm.common.entity.beneficiaryModels;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class BeneficiaryEntity extends IJRPaytmDataModel implements IJRDataModel {
    public String beneficiaryId;
    public InstrumentPreferences instrumentPreferences;
    public boolean isSelected;
    public String nickName;

    public static class InstrumentPreferences implements IJRDataModel {
        public OtherBank otherBank;
        public UPI upi;
        public Wallet wallet;
    }

    public static class Limit implements IJRDataModel {
        public String ruleId;
        public RuleParam ruleParams;
    }

    public static class OtherBank implements IJRDataModel {
        public ArrayList<OtherBankAccount> accounts;
        public Setting settings;
    }

    public static class OtherBankAccount implements IJRDataModel {
        public OtherBankAccountDetail accountDetail;
        public String creationTime;
        public boolean isTop;
        public ArrayList<Limit> limits;
        public boolean self;
        public Setting settings;
        public Source source;
        public String uuid;
    }

    public static class OtherBankAccountDetail implements IJRDataModel {
        public String accountHolderName;
        public String accountNumber;
        public String bankName;
        public String beneficiaryPhone;
        public String ifscCode;
        public boolean isMpinSet;
        public String logoUrl;
    }

    public static class RuleParam implements IJRDataModel {
        public String amount;
        public String duration;
        public String durationUnit;
        public String source;
        public String txn;
    }

    public static class Setting implements IJRDataModel {
        private String displayOrder;
        private String self;
        private String status;
    }

    public static class Source implements IJRDataModel {
        public String oba;
        public String upi;
        public String wallet;
    }

    public static class UPI implements IJRDataModel {
        public ArrayList<UPIAccount> accounts;
        public Setting settings;
    }

    public static class UPIAccount implements IJRDataModel {
        public UPIAccountDetail accountDetail;
        public String creationTime;
        public boolean isTop;
        public ArrayList<Limit> limits;
        public Setting settings;
        public Source source;
        public String uuid;
    }

    public static class UPIAccountDetail implements IJRDataModel {
        public String accountHolderName;
        public String accountNumber;
        public String bankName;
        public String ifscCode;
        public String vpa;
    }

    public static class Wallet implements IJRDataModel {
        public ArrayList<WalletAccount> accounts;
        public Setting settings;
    }

    public static class WalletAccount implements IJRDataModel {
        public WalletAccountDetail accountDetail;
        public String creationTime;
        public boolean isTop;
        public ArrayList<Limit> limits;
        public Setting settings;
        public Source source;
        public String uuid;
    }

    public static class WalletAccountDetail implements IJRDataModel {
        public String beneficiaryName;
        public String beneficiaryPhone;
        public String walletGuid;
        public String walletType;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
