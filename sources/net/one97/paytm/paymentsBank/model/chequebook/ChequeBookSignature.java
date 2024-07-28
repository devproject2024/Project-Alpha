package net.one97.paytm.paymentsBank.model.chequebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;

public class ChequeBookSignature implements Parcelable {
    public static final Parcelable.Creator<ChequeBookSignature> CREATOR = new Parcelable.Creator<ChequeBookSignature>() {
        public final ChequeBookSignature createFromParcel(Parcel parcel) {
            return new ChequeBookSignature(parcel);
        }

        public final ChequeBookSignature[] newArray(int i2) {
            return new ChequeBookSignature[i2];
        }
    };
    @b(a = "status")
    private String status;

    public int describeContents() {
        return 0;
    }

    protected ChequeBookSignature(Parcel parcel) {
        this.status = parcel.readString();
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.status);
    }
}
