package com.paytm.android.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;

public class FriendBean implements Parcelable {
    public static final Parcelable.Creator<FriendBean> CREATOR = new Parcelable.Creator<FriendBean>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new FriendBean[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FriendBean(parcel);
        }
    };
    @b(a = "new")
    boolean isNew;
    String name;
    @b(a = "paytm_user_id")
    String paytmUserId;
    String phone;
    String photo;
    @b(a = "preview_text")
    String previewText;
    @b(a = "s_id")
    String sendbirdId;

    public int describeContents() {
        return 0;
    }

    public FriendBean(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        this.isNew = z;
        this.paytmUserId = str;
        this.sendbirdId = str2;
        this.previewText = str3;
        this.name = str4;
        this.photo = str5;
        this.phone = str6;
    }

    protected FriendBean(Parcel parcel) {
        this.isNew = parcel.readByte() != 0;
        this.paytmUserId = parcel.readString();
        this.sendbirdId = parcel.readString();
        this.previewText = parcel.readString();
        this.name = parcel.readString();
        this.photo = parcel.readString();
        this.phone = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.isNew ? (byte) 1 : 0);
        parcel.writeString(this.paytmUserId);
        parcel.writeString(this.sendbirdId);
        parcel.writeString(this.previewText);
        parcel.writeString(this.name);
        parcel.writeString(this.photo);
        parcel.writeString(this.phone);
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void setNew(boolean z) {
        this.isNew = z;
    }

    public String getPaytmUserId() {
        return this.paytmUserId;
    }

    public void setPaytmUserId(String str) {
        this.paytmUserId = str;
    }

    public String getSendbirdId() {
        return this.sendbirdId;
    }

    public void setSendbirdId(String str) {
        this.sendbirdId = str;
    }

    public String getPreviewText() {
        return this.previewText;
    }

    public void setPreviewText(String str) {
        this.previewText = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String str) {
        this.photo = str;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
