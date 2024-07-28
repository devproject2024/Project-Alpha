package net.one97.paytm.deeplink;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class DeepLinkData implements Parcelable {
    public static final a CREATOR = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public String f50283a;

    /* renamed from: b  reason: collision with root package name */
    public String f50284b;

    /* renamed from: c  reason: collision with root package name */
    String f50285c;

    /* renamed from: d  reason: collision with root package name */
    String f50286d;

    /* renamed from: e  reason: collision with root package name */
    String f50287e;

    /* renamed from: f  reason: collision with root package name */
    public String f50288f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f50289g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f50290h;

    public final int describeContents() {
        return 0;
    }

    public DeepLinkData() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeepLinkData(Parcel parcel) {
        this();
        k.c(parcel, "parcel");
        this.f50283a = parcel.readString();
        this.f50284b = parcel.readString();
        this.f50285c = parcel.readString();
        this.f50286d = parcel.readString();
        this.f50287e = parcel.readString();
        this.f50288f = parcel.readString();
        this.f50289g = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f50290h = parcel.readBundle(Bundle.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.f50283a);
        parcel.writeString(this.f50284b);
        parcel.writeString(this.f50285c);
        parcel.writeString(this.f50286d);
        parcel.writeString(this.f50287e);
        parcel.writeString(this.f50288f);
        parcel.writeParcelable(this.f50289g, i2);
        parcel.writeBundle(this.f50290h);
    }

    public static final class a implements Parcelable.Creator<DeepLinkData> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new DeepLinkData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new DeepLinkData[i2];
        }
    }
}
