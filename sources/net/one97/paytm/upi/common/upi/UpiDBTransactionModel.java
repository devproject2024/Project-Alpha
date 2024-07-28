package net.one97.paytm.upi.common.upi;

import android.os.Parcel;
import android.os.Parcelable;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiDBTransactionModel implements Parcelable, UpiBaseDataModel {
    public static final Parcelable.Creator<UpiDBTransactionModel> CREATOR = new Parcelable.Creator<UpiDBTransactionModel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new UpiDBTransactionModel[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UpiDBTransactionModel(parcel);
        }
    };
    private String bank_name;
    private String beneficiary_name;
    private String ifsc;
    private boolean isSelected;
    private boolean isSelf = false;
    private String timestamp;
    private String txn_amount;
    private String txn_mode;
    private String txn_type;

    public int describeContents() {
        return 0;
    }

    public UpiDBTransactionModel() {
    }

    public UpiDBTransactionModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.txn_type = str;
        this.txn_mode = str2;
        this.beneficiary_name = str3;
        this.bank_name = str4;
        this.txn_amount = str6;
        this.timestamp = str7;
        this.ifsc = str5;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getIfsc() {
        return this.ifsc;
    }

    public void setIfsc(String str) {
        this.ifsc = str;
    }

    public String getTxn_type() {
        return this.txn_type;
    }

    public void setTxn_type(String str) {
        this.txn_type = str;
    }

    public String getTxn_mode() {
        return this.txn_mode;
    }

    public void setTxn_mode(String str) {
        this.txn_mode = str;
    }

    public String getBeneficiary_name() {
        return this.beneficiary_name;
    }

    public void setBeneficiary_name(String str) {
        this.beneficiary_name = str;
    }

    public String getBank_name() {
        return this.bank_name;
    }

    public void setBank_name(String str) {
        this.bank_name = str;
    }

    public String getTxn_amount() {
        return this.txn_amount;
    }

    public void setTxn_amount(String str) {
        this.txn_amount = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.txn_type);
        parcel.writeString(this.txn_mode);
        parcel.writeString(this.beneficiary_name);
        parcel.writeString(this.bank_name);
        parcel.writeString(this.txn_amount);
        parcel.writeString(this.timestamp);
        parcel.writeString(this.ifsc);
        parcel.writeByte(this.isSelected ? (byte) 1 : 0);
        parcel.writeByte(this.isSelf ? (byte) 1 : 0);
    }

    protected UpiDBTransactionModel(Parcel parcel) {
        boolean z = false;
        this.txn_type = parcel.readString();
        this.txn_mode = parcel.readString();
        this.beneficiary_name = parcel.readString();
        this.bank_name = parcel.readString();
        this.txn_amount = parcel.readString();
        this.timestamp = parcel.readString();
        this.ifsc = parcel.readString();
        this.isSelected = parcel.readByte() != 0;
        this.isSelf = parcel.readByte() != 0 ? true : z;
    }
}
