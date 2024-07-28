package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSavedCard extends IJRPaytmDataModel {
    public static final String CARD_XXX = "XX XXXX ";
    public static final String CREDIT_CARD = "Credit Card";
    public static final String DEBIT_CARD = "Debit Card";
    private static final long serialVersionUID = 1;
    private boolean Card2FAStatus;
    private boolean isChecked = false;
    @b(a = "BANK_NAME")
    private String mBankname;
    @b(a = "SAVE_CARD_ID")
    private String mCardID;
    @b(a = "CARDBIN")
    private String mCardbin;
    @b(a = "CARDLASTDIGIT")
    private String mCardlastdigit;
    @b(a = "CARD_TYPE")
    private String mCardtype;
    @b(a = "PAYMENTMODE")
    private String mPaymentmode;

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public String getCardID() {
        return this.mCardID;
    }

    public String getCardBIN() {
        return this.mCardbin;
    }

    public String getCardLastDigit() {
        return this.mCardlastdigit;
    }

    public String getPaymentmode() {
        return this.mPaymentmode;
    }

    public String getCardType() {
        return this.mCardtype;
    }

    public String getBankname() {
        return this.mBankname;
    }

    public boolean isCard2FAStatus() {
        return this.Card2FAStatus;
    }

    public void setCard2FAStatus(boolean z) {
        this.Card2FAStatus = z;
    }
}
