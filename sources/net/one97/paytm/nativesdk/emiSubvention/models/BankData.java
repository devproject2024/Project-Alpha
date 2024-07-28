package net.one97.paytm.nativesdk.emiSubvention.models;

import android.os.Parcel;
import android.os.Parcelable;

public class BankData implements Parcelable {
    public static final Parcelable.Creator<BankData> CREATOR = new Parcelable.Creator<BankData>() {
        public final BankData createFromParcel(Parcel parcel) {
            return new BankData(parcel);
        }

        public final BankData[] newArray(int i2) {
            return new BankData[i2];
        }
    };
    private String bankCode;
    private String bankLogoUrl;
    private String bankName;
    private String cardType;
    private boolean isEnabled;
    private boolean isEndData;
    private boolean isLastData;
    private String label;
    private String title;
    private String type;

    public int describeContents() {
        return 0;
    }

    private BankData(Parcel parcel) {
        this.title = parcel.readString();
        this.label = parcel.readString();
        this.type = parcel.readString();
        this.bankName = parcel.readString();
        this.bankCode = parcel.readString();
        this.bankLogoUrl = parcel.readString();
        boolean z = false;
        this.isEnabled = parcel.readInt() == 1;
        this.isLastData = parcel.readInt() == 1 ? true : z;
        this.cardType = parcel.readString();
    }

    public BankData() {
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeString(this.label);
        parcel.writeString(this.type);
        parcel.writeString(this.bankName);
        parcel.writeString(this.bankCode);
        parcel.writeString(this.bankLogoUrl);
        parcel.writeInt(this.isEnabled ? 1 : 0);
        parcel.writeInt(this.isLastData ? 1 : 0);
        parcel.writeString(this.cardType);
    }

    public String getTitle() {
        return this.title;
    }

    public BankData setTitle() {
        this.title = "SUBVENTION".equalsIgnoreCase(this.type) ? "Zero/Low Cost EMI" : "Standard EMI";
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public BankData setLabel(String str) {
        this.label = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public BankData setType(String str) {
        this.type = str;
        return this;
    }

    public String getBankName() {
        return this.bankName;
    }

    public BankData setBankName(String str) {
        this.bankName = str;
        return this;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public BankData setBankCode(String str) {
        this.bankCode = str;
        return this;
    }

    public String getBankLogoUrl() {
        return this.bankLogoUrl;
    }

    public BankData setBankLogoUrl(String str) {
        this.bankLogoUrl = str;
        return this;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public BankData setEnabled(boolean z) {
        this.isEnabled = z;
        return this;
    }

    public boolean isLastData() {
        return this.isLastData;
    }

    public BankData setLastData(boolean z) {
        this.isLastData = z;
        return this;
    }

    public String getCardType() {
        return this.cardType;
    }

    public BankData setCardType(String str) {
        this.cardType = str;
        return this;
    }

    public void setIsEndData(boolean z) {
        this.isEndData = z;
    }

    public boolean isEndData() {
        return this.isEndData;
    }
}
