package net.one97.paytm.paymentsBank.chequebook.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ChequeBookFinResponse extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<ChequeBookFinResponse> CREATOR = new Parcelable.Creator<ChequeBookFinResponse>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ChequeBookFinResponse[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChequeBookFinResponse();
        }
    };
    @b(a = "message")
    private String message;
    @b(a = "response")
    private ChequeBookResponse response;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String statusCode;
    @b(a = "success")
    private boolean success;

    public int describeContents() {
        return 0;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public ChequeBookResponse getResponse() {
        return this.response;
    }

    public void setResponse(ChequeBookResponse chequeBookResponse) {
        this.response = chequeBookResponse;
    }

    public Boolean getSuccess() {
        return Boolean.valueOf(this.success);
    }

    public void setSuccess(Boolean bool) {
        this.success = bool.booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.responseCode);
        parcel.writeString(this.statusCode);
        parcel.writeString(this.message);
        parcel.writeByte((byte) (this.success ? 0 : 2));
    }
}
