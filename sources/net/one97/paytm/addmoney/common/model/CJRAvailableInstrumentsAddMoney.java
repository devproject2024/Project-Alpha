package net.one97.paytm.addmoney.common.model;

import com.google.gson.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAvailableInstrumentsAddMoney extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private ArrayList<Card> data = null;

    public ArrayList<Card> getData() {
        return this.data;
    }

    public void setData(ArrayList<Card> arrayList) {
        this.data = arrayList;
    }

    public class Card implements IJRDataModel {
        @b(a = "cardFirstSixDigits")
        @a
        private Integer cardFirstSixDigits;
        @b(a = "cardLastFourDigits")
        @a
        private Integer cardLastFourDigits;
        @b(a = "cardScheme")
        @a
        private String cardScheme;
        @b(a = "cardType")
        @a
        private String cardType;
        private boolean checked;
        private boolean isNewCard;
        @b(a = "issuerCode")
        @a
        private String issuerCode;
        @b(a = "issuerDisplayName")
        @a
        private String issuerDisplayName;
        @b(a = "savedCardId")
        @a
        private String savedCardId;

        public Card() {
        }

        public boolean isChecked() {
            return this.checked;
        }

        public String getSavedCardId() {
            return this.savedCardId;
        }

        public void setSavedCardId(String str) {
            this.savedCardId = str;
        }

        public Integer getCardFirstSixDigits() {
            return this.cardFirstSixDigits;
        }

        public void setCardFirstSixDigits(Integer num) {
            this.cardFirstSixDigits = num;
        }

        public Integer getCardLastFourDigits() {
            return this.cardLastFourDigits;
        }

        public String getCardFirstFourDigit() {
            try {
                String valueOf = String.valueOf(this.cardFirstSixDigits);
                if (valueOf == null || valueOf.length() != 6) {
                    return "";
                }
                return valueOf.substring(0, 4);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public void setCardLastFourDigits(Integer num) {
            this.cardLastFourDigits = num;
        }

        public String getCardType() {
            return this.cardType;
        }

        public void setCardType(String str) {
            this.cardType = str;
        }

        public String getCardScheme() {
            return this.cardScheme;
        }

        public void setCardScheme(String str) {
            this.cardScheme = str;
        }

        public String getIssuerDisplayName() {
            return this.issuerDisplayName;
        }

        public void setIssuerDisplayName(String str) {
            this.issuerDisplayName = str;
        }

        public String getIssuerCode() {
            return this.issuerCode;
        }

        public void setIssuerCode(String str) {
            this.issuerCode = str;
        }

        public void setChecked(boolean z) {
            this.checked = z;
        }

        public boolean isNewCard() {
            return this.isNewCard;
        }

        public void setNewCard(boolean z) {
            this.isNewCard = z;
        }
    }
}
