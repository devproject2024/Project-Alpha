package net.one97.paytm.upi.common.models;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class BeneficiaryEntity extends IJRPaytmDataModel implements UpiBaseDataModel {
    public String beneficiaryId;
    public InstrumentPreferences instrumentPreferences;
    public boolean isSelected;
    public String nickName;

    public static class InstrumentPreferences implements UpiBaseDataModel {
        public OtherBank otherBank;
        public UPI upi;
        public Wallet wallet;
    }

    public static class Limit implements UpiBaseDataModel {
        public String ruleId;
        public RuleParam ruleParams;
    }

    public static class OtherBank implements UpiBaseDataModel {
        public ArrayList<OtherBankAccount> accounts;
        public Setting settings;
    }

    public static class OtherBankAccount implements UpiBaseDataModel {
        public OtherBankAccountDetail accountDetail;
        public String creationTime;
        public ArrayList<Limit> limits;
        public Setting settings;
        public Source source;
        public String uuid;
    }

    public static class OtherBankAccountDetail implements UpiBaseDataModel {
        public String accountHolderName;
        public String accountNumber;
        public String bankName;
        public String ifscCode;
    }

    public static class RuleParam implements UpiBaseDataModel {
        public String amount;
        public String duration;
        public String durationUnit;
        public String source;
        public String txn;
    }

    public static class Setting implements UpiBaseDataModel {
        private String displayOrder;
        private String self;
        private String status;
    }

    public static class Source implements UpiBaseDataModel {
        public String oba;
        public String upi;
        public String wallet;
    }

    public static class UPI implements UpiBaseDataModel {
        public ArrayList<UPIAccount> accounts;
        public Setting settings;
    }

    public static class UPIAccount implements UpiBaseDataModel {
        public UPIAccountDetail accountDetail;
        public String creationTime;
        public ArrayList<Limit> limits;
        public Setting settings;
        public Source source;
        public String uuid;
    }

    public static class UPIAccountDetail implements UpiBaseDataModel {
        public String accountHolderName;
        public String accountNumber;
        public String bankName;
        public String ifscCode;
        public String vpa;
    }

    public static class Wallet implements UpiBaseDataModel {
        public ArrayList<WalletAccount> accounts;
        public Setting settings;
    }

    public static class WalletAccount implements UpiBaseDataModel {
        public WalletAccountDetail accountDetail;
        public String creationTime;
        public ArrayList<Limit> limits;
        public Setting settings;
        public Source source;
        public String uuid;
    }

    public static class WalletAccountDetail implements UpiBaseDataModel {
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
