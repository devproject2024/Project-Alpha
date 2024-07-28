package net.one97.paytm.paymentsBank.model.chequebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class ChequeBookResponse extends IJRPaytmDataModel implements Parcelable {
    public static final Parcelable.Creator<ChequeBookResponse> CREATOR = new Parcelable.Creator<ChequeBookResponse>() {
        public final ChequeBookResponse createFromParcel(Parcel parcel) {
            return new ChequeBookResponse(parcel);
        }

        public final ChequeBookResponse[] newArray(int i2) {
            return new ChequeBookResponse[i2];
        }
    };
    @a
    @b(a = "pendingChequeBooks")
    private List<PendingChequeBook> pendingChequeBooks = new ArrayList();
    @a
    @b(a = "signature")
    private ChequeBookSignature signature;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }

    protected ChequeBookResponse(Parcel parcel) {
    }

    public ChequeBookSignature getSignature() {
        return this.signature;
    }

    public void setSignature(ChequeBookSignature chequeBookSignature) {
        this.signature = chequeBookSignature;
    }

    public List<PendingChequeBook> getPendingChequeBooks() {
        return this.pendingChequeBooks;
    }

    public void setPendingChequeBooks(List<PendingChequeBook> list) {
        this.pendingChequeBooks = list;
    }
}
