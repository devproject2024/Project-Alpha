package io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class ContentMetadata implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ContentMetadata[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ContentMetadata(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    a f46584a;

    /* renamed from: b  reason: collision with root package name */
    public Double f46585b;

    /* renamed from: c  reason: collision with root package name */
    public Double f46586c;

    /* renamed from: d  reason: collision with root package name */
    public b f46587d;

    /* renamed from: e  reason: collision with root package name */
    public String f46588e;

    /* renamed from: f  reason: collision with root package name */
    public String f46589f;

    /* renamed from: g  reason: collision with root package name */
    public String f46590g;

    /* renamed from: h  reason: collision with root package name */
    public c f46591h;

    /* renamed from: i  reason: collision with root package name */
    public a f46592i;
    public String j;
    public Double k;
    public Double l;
    public Integer m;
    public Double n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public Double t;
    public Double u;
    private final ArrayList<String> v;
    private final HashMap<String, String> w;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ ContentMetadata(Parcel parcel, byte b2) {
        this(parcel);
    }

    public enum a {
        OTHER,
        NEW,
        GOOD,
        FAIR,
        POOR,
        USED,
        REFURBISHED,
        EXCELLENT;

        public static a getValue(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (a aVar : values()) {
                    if (aVar.name().equalsIgnoreCase(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }
    }

    public ContentMetadata() {
        this.v = new ArrayList<>();
        this.w = new HashMap<>();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        a aVar = this.f46584a;
        String str = "";
        parcel.writeString(aVar != null ? aVar.name() : str);
        parcel.writeSerializable(this.f46585b);
        parcel.writeSerializable(this.f46586c);
        b bVar = this.f46587d;
        parcel.writeString(bVar != null ? bVar.name() : str);
        parcel.writeString(this.f46588e);
        parcel.writeString(this.f46589f);
        parcel.writeString(this.f46590g);
        c cVar = this.f46591h;
        parcel.writeString(cVar != null ? cVar.getName() : str);
        a aVar2 = this.f46592i;
        if (aVar2 != null) {
            str = aVar2.name();
        }
        parcel.writeString(str);
        parcel.writeString(this.j);
        parcel.writeSerializable(this.k);
        parcel.writeSerializable(this.l);
        parcel.writeSerializable(this.m);
        parcel.writeSerializable(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeSerializable(this.t);
        parcel.writeSerializable(this.u);
        parcel.writeSerializable(this.v);
        parcel.writeSerializable(this.w);
    }

    private ContentMetadata(Parcel parcel) {
        this();
        this.f46584a = a.getValue(parcel.readString());
        this.f46585b = (Double) parcel.readSerializable();
        this.f46586c = (Double) parcel.readSerializable();
        this.f46587d = b.getValue(parcel.readString());
        this.f46588e = parcel.readString();
        this.f46589f = parcel.readString();
        this.f46590g = parcel.readString();
        this.f46591h = c.getValue(parcel.readString());
        this.f46592i = a.getValue(parcel.readString());
        this.j = parcel.readString();
        this.k = (Double) parcel.readSerializable();
        this.l = (Double) parcel.readSerializable();
        this.m = (Integer) parcel.readSerializable();
        this.n = (Double) parcel.readSerializable();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = (Double) parcel.readSerializable();
        this.u = (Double) parcel.readSerializable();
        this.v.addAll((ArrayList) parcel.readSerializable());
        this.w.putAll((HashMap) parcel.readSerializable());
    }
}
