package net.one97.paytm.upi.common.models;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CustProductList implements UpiBaseDataModel {
    private String errorMessage;
    private Isa isa;
    private Pdc pdc;
    private Slfd slfdIblCifStatus;
    private Vdc vdc;

    public String getIsaStatus() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.status;
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

    public String getIsaAccountStatus() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.accountStatus;
        }
        return null;
    }
}
