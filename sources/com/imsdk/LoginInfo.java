package com.imsdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;

public class LoginInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<LoginInfo> CREATOR = new Parcelable.Creator<LoginInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new LoginInfo[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LoginInfo(parcel);
        }
    };
    private String account;
    private String token;

    public int describeContents() {
        return 0;
    }

    public LoginInfo(String str, String str2) {
        String str3;
        if (str == null) {
            str3 = null;
        } else {
            str3 = str.toLowerCase();
        }
        this.account = str3;
        this.token = str2;
    }

    protected LoginInfo(Parcel parcel) {
        this.account = parcel.readString();
        this.token = parcel.readString();
    }

    public String getAccount() {
        return this.account;
    }

    public String getToken() {
        return this.token;
    }

    public boolean valid() {
        return !TextUtils.isEmpty(this.account) && !TextUtils.isEmpty(this.token);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.account);
        parcel.writeString(this.token);
    }
}
