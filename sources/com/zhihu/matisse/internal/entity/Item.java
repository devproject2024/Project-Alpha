package com.zhihu.matisse.internal.entity;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import com.business.merchant_payments.common.utility.AppConstants;
import com.zhihu.matisse.b;

public class Item implements Parcelable {
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new Item[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Item(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public long f45763a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45764b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f45765c;

    /* renamed from: d  reason: collision with root package name */
    public final long f45766d;

    /* renamed from: e  reason: collision with root package name */
    public final long f45767e;

    /* renamed from: f  reason: collision with root package name */
    public String f45768f;

    /* renamed from: g  reason: collision with root package name */
    public String f45769g;

    /* renamed from: h  reason: collision with root package name */
    public String f45770h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45771i;
    public String j;
    public String k;

    public int describeContents() {
        return 0;
    }

    private Item(long j2, String str, long j3, long j4) {
        Uri uri;
        this.f45768f = null;
        this.f45769g = null;
        this.f45770h = null;
        this.f45771i = false;
        this.f45763a = j2;
        this.f45764b = str;
        if (b.isImage(this.f45764b)) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (b.isVideo(this.f45764b)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Files.getContentUri("external");
        }
        this.f45765c = ContentUris.withAppendedId(uri, j2);
        this.f45766d = j3;
        this.f45767e = j4;
    }

    public Item(Uri uri) {
        this.f45768f = null;
        this.f45769g = null;
        this.f45770h = null;
        this.f45771i = false;
        this.f45763a = -1;
        this.f45764b = null;
        this.f45765c = uri;
        this.f45766d = 0;
        this.f45767e = 0;
    }

    public Item(Uri uri, String str, String str2, String str3) {
        this.f45768f = null;
        this.f45769g = null;
        this.f45770h = null;
        this.f45771i = false;
        this.f45763a = -1;
        this.f45764b = null;
        this.f45765c = uri;
        this.f45766d = 0;
        this.f45767e = 0;
        this.f45768f = str;
        this.f45769g = str2;
        this.f45770h = str3;
    }

    public static Item a(Cursor cursor) {
        return new Item(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("mime_type")), cursor.getLong(cursor.getColumnIndex("_size")), cursor.getLong(cursor.getColumnIndex(AppConstants.DURATION)));
    }

    public final void a() {
        this.f45771i = true;
    }

    public final boolean b() {
        return this.f45771i;
    }

    public final void a(String str) {
        this.k = str;
    }

    public final String c() {
        return this.k;
    }

    public final void a(Uri uri) {
        this.f45765c = uri;
    }

    public final Uri d() {
        return this.f45765c;
    }

    public final String e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        String str;
        Uri uri;
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        if (this.f45763a != item.f45763a || ((((str = this.f45764b) == null || !str.equals(item.f45764b)) && (this.f45764b != null || item.f45764b != null)) || ((((uri = this.f45765c) == null || !uri.equals(item.f45765c)) && (this.f45765c != null || item.f45765c != null)) || this.f45766d != item.f45766d || this.f45767e != item.f45767e))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Long.valueOf(this.f45763a).hashCode() + 31;
        String str = this.f45764b;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        return (((((hashCode * 31) + this.f45765c.hashCode()) * 31) + Long.valueOf(this.f45766d).hashCode()) * 31) + Long.valueOf(this.f45767e).hashCode();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f45763a);
        parcel.writeString(this.f45764b);
        parcel.writeParcelable(this.f45765c, i2);
        parcel.writeLong(this.f45766d);
        parcel.writeLong(this.f45767e);
        parcel.writeString(this.f45768f);
        parcel.writeString(this.f45769g);
        parcel.writeString(this.f45770h);
        parcel.writeString(this.j);
        parcel.writeInt(this.f45771i ? 1 : 0);
        parcel.writeString(this.k);
    }

    protected Item(Parcel parcel) {
        this.f45768f = null;
        this.f45769g = null;
        this.f45770h = null;
        boolean z = false;
        this.f45771i = false;
        this.f45763a = parcel.readLong();
        this.f45764b = parcel.readString();
        this.f45765c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f45766d = parcel.readLong();
        this.f45767e = parcel.readLong();
        this.f45768f = parcel.readString();
        this.f45769g = parcel.readString();
        this.f45770h = parcel.readString();
        this.j = parcel.readString();
        this.f45771i = parcel.readInt() == 1 ? true : z;
        this.k = parcel.readString();
    }
}
