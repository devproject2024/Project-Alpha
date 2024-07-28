package com.zhihu.matisse.internal.entity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.android.chat.R;

public class Album implements Parcelable {
    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new Album[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Album(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f45758a = H5BridgeContext.INVALID_ID;

    /* renamed from: b  reason: collision with root package name */
    public final String f45759b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f45760c;

    /* renamed from: d  reason: collision with root package name */
    public long f45761d;

    /* renamed from: e  reason: collision with root package name */
    private final String f45762e;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ Album(Parcel parcel, byte b2) {
        this(parcel);
    }

    private Album(String str, Uri uri, String str2, long j) {
        this.f45759b = str;
        this.f45760c = uri;
        this.f45762e = str2;
        this.f45761d = j;
    }

    private Album(Parcel parcel) {
        this.f45759b = parcel.readString();
        this.f45760c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f45762e = parcel.readString();
        this.f45761d = parcel.readLong();
    }

    public static Album a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("uri"));
        String string2 = cursor.getString(cursor.getColumnIndex("bucket_id"));
        if (string == null) {
            string = "";
        }
        return new Album(string2, Uri.parse(string), cursor.getString(cursor.getColumnIndex("bucket_display_name")), cursor.getLong(cursor.getColumnIndex("count")));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f45759b);
        parcel.writeParcelable(this.f45760c, 0);
        parcel.writeString(this.f45762e);
        parcel.writeLong(this.f45761d);
    }

    public final void a() {
        this.f45761d++;
    }

    public final String a(Context context) {
        if (b()) {
            return context.getString(R.string.chat_module_album_name_all);
        }
        return this.f45762e;
    }

    public final boolean b() {
        return f45758a.equals(this.f45759b);
    }

    public final boolean c() {
        return this.f45761d == 0;
    }
}
