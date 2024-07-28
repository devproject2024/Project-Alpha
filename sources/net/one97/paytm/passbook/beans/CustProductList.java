package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CustProductList extends IJRDataModel {
    public static final String ISA_CREDIT_FREEZED = "CREDIT_FREEZED";
    public static final String ISA_DEBIT_FREEZED = "DEBIT_FREEZED";
    public static final String ISA_DORMANT = "DORMANT";
    public static final String ISA_TOTAL_FREEZED = "TOTAL_FREEZED";
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "ica")
    private Isa ica;
    @b(a = "isa")
    private Isa isa;
    @b(a = "pdc")
    private Pdc pdc;
    @b(a = "slfdIblCifStatus")
    private Slfd slfdIblCifStatus;
    @b(a = "vdc")
    private Vdc vdc;

    public static class FreezeDescription extends IJRDataModel {
        @b(a = "actionDescription")
        public String actionDescription;
        @b(a = "actionable")
        public boolean actionable;
        @b(a = "freezeCode")
        public String freezeCode;
        @b(a = "freezeReason")
        public String freezeReason;
    }

    class Isa extends IJRDataModel {
        @b(a = "accountNumber")
        String accountNumber;
        @b(a = "accountStatus")
        String accountStatus;
        @b(a = "caId")
        String caId;
        @b(a = "freezeDescriptionList")
        ArrayList<FreezeDescription> freezeDescription;
        @b(a = "ifscCode")
        String ifscCode;
        @b(a = "productType")
        String productType;
        @b(a = "status")
        String status;
        @b(a = "txnActivityStatus")
        public String txnActivityStatus;

        private Isa() {
        }
    }

    class Vdc extends IJRDataModel {
        @b(a = "cardAlias")
        String cardAlias;
        @b(a = "cardStatus")
        String cardStatus;
        @b(a = "maskedCardNumber")
        String maskedCardNumber;
        @b(a = "status")
        String status;

        private Vdc() {
        }
    }

    class Pdc extends Vdc implements Serializable {
        @b(a = "imageId")
        String imageId;
        @b(a = "orderId")
        String orderId;
        @b(a = "walletQRCode")
        String walletQRCode;

        private Pdc() {
            super();
        }
    }

    class Slfd extends IJRDataModel {
        @b(a = "iblCifId")
        String iblCifId;
        @b(a = "processId")
        String processId;
        @b(a = "productType")
        String productType;
        @b(a = "slfdStatus")
        String slfdStatus;
        @b(a = "status")
        String status;

        private Slfd() {
        }
    }

    public String getICAccountStatus() {
        Isa isa2 = this.ica;
        if (isa2 != null) {
            return isa2.accountStatus;
        }
        return null;
    }

    public String getIsaStatus() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.status;
        }
        return null;
    }

    public String getICAStatus() {
        Isa isa2 = this.ica;
        if (isa2 != null) {
            return isa2.status;
        }
        return null;
    }

    public String getICARefId() {
        Isa isa2 = this.ica;
        if (isa2 != null) {
            return isa2.caId;
        }
        return null;
    }

    public void setIsaStatus(String str) {
        this.isa.status = str;
    }

    public String getIsaIfsc() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.ifscCode;
        }
        return null;
    }

    public String getIsaAccNum() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.accountNumber;
        }
        return null;
    }

    public String getICAAccNum() {
        Isa isa2 = this.ica;
        if (isa2 != null) {
            return isa2.accountNumber;
        }
        return null;
    }

    public boolean isLimitApplicable() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return "SAINF".equals(isa2.productType);
        }
        return true;
    }

    public String getIsaProductType() {
        Isa isa2 = this.isa;
        return isa2 != null ? isa2.productType : "";
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getVdcStatus() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.status;
        }
        return null;
    }

    public String getVdcMaskedCardNum() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.maskedCardNumber;
        }
        return null;
    }

    public String getVdcCardAlias() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.cardAlias;
        }
        return null;
    }

    public String getVdcCardStatus() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.cardStatus;
        }
        return null;
    }

    public String getSlfdStatus() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.status;
        }
        return null;
    }

    public String getSlfdIblCifId() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.iblCifId;
        }
        return null;
    }

    public String getSlfdActiveStatus() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.slfdStatus;
        }
        return null;
    }

    public String getSlfdProductType() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.productType;
        }
        return null;
    }

    public Vdc getVdc() {
        return this.vdc;
    }

    public Pdc getPdc() {
        return this.pdc;
    }

    public String getPdcStatus() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.status;
        }
        return null;
    }

    public String getPdcMaskedCardNum() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.maskedCardNumber;
        }
        return null;
    }

    public String getPdcCardAlias() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.cardAlias;
        }
        return null;
    }

    public String getPdcCardStatus() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.cardStatus;
        }
        return null;
    }

    public String getPdcImageId() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.imageId;
        }
        return null;
    }

    public String getPdcWalletQr() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.walletQRCode;
        }
        return null;
    }

    public String getPDCOrderId() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.orderId;
        }
        return null;
    }

    public String getTxnActivityStatus() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.txnActivityStatus;
        }
        return null;
    }

    public String getIsaAccountStatus() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.accountStatus;
        }
        return null;
    }

    public FreezeDescription getAccountFreezeDescription() {
        Isa isa2 = this.isa;
        if (isa2 == null || isa2.freezeDescription == null || this.isa.freezeDescription.size() <= 0) {
            return null;
        }
        return this.isa.freezeDescription.get(0);
    }

    public static boolean isToShowAccountFreeze(CustProductList custProductList) {
        return (custProductList.getIsaAccountStatus() == null || ISA_CREDIT_FREEZED.equals(custProductList.getIsaAccountStatus()) || ISA_DEBIT_FREEZED.equals(custProductList.getIsaAccountStatus()) || ISA_TOTAL_FREEZED.equals(custProductList.getIsaAccountStatus()) || ISA_DORMANT.equals(custProductList.getTxnActivityStatus())) && custProductList.getAccountFreezeDescription() != null;
    }
}
