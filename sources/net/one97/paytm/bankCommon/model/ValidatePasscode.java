package net.one97.paytm.bankCommon.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ValidatePasscode extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<ValidatePasscode> CREATOR = new Parcelable.Creator<ValidatePasscode>() {
        public final ValidatePasscode createFromParcel(Parcel parcel) {
            return new ValidatePasscode(parcel);
        }

        public final ValidatePasscode[] newArray(int i2) {
            return new ValidatePasscode[i2];
        }
    };
    @b(a = "message")
    private String mMessage;
    @b(a = "response_code")
    private int mResponseCode;
    @b(a = "status")
    private String mStatus;
    @b(a = "request_id")
    private String requestId;

    public int describeContents() {
        return 0;
    }

    public ValidatePasscode() {
    }

    protected ValidatePasscode(Parcel parcel) {
        this.mStatus = parcel.readString();
        this.mResponseCode = parcel.readInt();
        this.mMessage = parcel.readString();
        this.requestId = parcel.readString();
    }

    public String getStatus() {
        return this.mStatus;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mStatus);
        parcel.writeInt(this.mResponseCode);
        parcel.writeString(this.mMessage);
        parcel.writeString(this.requestId);
    }
}
