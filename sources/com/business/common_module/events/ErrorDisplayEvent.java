package com.business.common_module.events;

import android.os.Parcel;
import android.os.Parcelable;

public class ErrorDisplayEvent implements Parcelable {
    public static final Parcelable.Creator<ErrorDisplayEvent> CREATOR = new Parcelable.Creator<ErrorDisplayEvent>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ErrorDisplayEvent[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ErrorDisplayEvent(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f7338a;

    /* renamed from: b  reason: collision with root package name */
    public int f7339b;

    /* renamed from: c  reason: collision with root package name */
    public String f7340c;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ ErrorDisplayEvent(Parcel parcel, byte b2) {
        this(parcel);
    }

    public ErrorDisplayEvent(String str) {
        this.f7338a = str;
        this.f7339b = 11;
    }

    public ErrorDisplayEvent(String str, int i2, String str2) {
        this.f7338a = str;
        this.f7339b = i2;
        this.f7340c = str2;
    }

    private ErrorDisplayEvent(Parcel parcel) {
        this.f7338a = parcel.readString();
        this.f7339b = parcel.readInt();
        this.f7340c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7338a);
        parcel.writeInt(this.f7339b);
        parcel.writeString(this.f7340c);
    }
}
