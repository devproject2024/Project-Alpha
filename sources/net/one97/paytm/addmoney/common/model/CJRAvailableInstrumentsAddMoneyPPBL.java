package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class CJRAvailableInstrumentsAddMoneyPPBL extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private ArrayList<Card> data = null;

    public ArrayList<Card> getData() {
        return this.data;
    }

    public void setData(ArrayList<Card> arrayList) {
        this.data = arrayList;
    }

    public class Card implements IJRDataModel {
        @a
        @b(a = "accountType")
        private ArrayList<String> accountList = null;
        private boolean checked;
        @a
        @b(a = "issuerCode")
        private String issuerCode;
        @a
        @b(a = "issuerDisplayName")
        private String issuerDisplayName;
        @a
        @b(a = "payMethod")
        private String payMethod;

        public Card() {
        }

        public String getPayMethod() {
            return this.payMethod;
        }

        public boolean isChecked() {
            return this.checked;
        }

        public String getIssuerDisplayName() {
            if (this.issuerDisplayName.equals(SDKConstants.AI_KEY_PPBL)) {
                return "Paytm Payments Bank Account";
            }
            return this.issuerDisplayName;
        }

        public String getIssuerCode() {
            return this.issuerCode;
        }

        public ArrayList<String> getAccountList() {
            return this.accountList;
        }

        public void setChecked(boolean z) {
            this.checked = z;
        }
    }
}
