package io.branch.indexing;

import android.os.Parcel;
import android.os.Parcelable;
import io.branch.referral.util.ContentMetadata;
import java.util.ArrayList;

public class BranchUniversalObject implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new BranchUniversalObject[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BranchUniversalObject(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f46372a;

    /* renamed from: b  reason: collision with root package name */
    private String f46373b;

    /* renamed from: c  reason: collision with root package name */
    private String f46374c;

    /* renamed from: d  reason: collision with root package name */
    private String f46375d;

    /* renamed from: e  reason: collision with root package name */
    private String f46376e;

    /* renamed from: f  reason: collision with root package name */
    private ContentMetadata f46377f;

    /* renamed from: g  reason: collision with root package name */
    private a f46378g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<String> f46379h;

    /* renamed from: i  reason: collision with root package name */
    private long f46380i;
    private a j;
    private long k;

    public enum a {
        PUBLIC,
        PRIVATE
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ BranchUniversalObject(Parcel parcel, byte b2) {
        this(parcel);
    }

    public BranchUniversalObject() {
        this.f46377f = new ContentMetadata();
        this.f46379h = new ArrayList<>();
        this.f46372a = "";
        this.f46373b = "";
        this.f46374c = "";
        this.f46375d = "";
        this.f46378g = a.PUBLIC;
        this.j = a.PUBLIC;
        this.f46380i = 0;
        this.k = System.currentTimeMillis();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.k);
        parcel.writeString(this.f46372a);
        parcel.writeString(this.f46373b);
        parcel.writeString(this.f46374c);
        parcel.writeString(this.f46375d);
        parcel.writeString(this.f46376e);
        parcel.writeLong(this.f46380i);
        parcel.writeInt(this.f46378g.ordinal());
        parcel.writeSerializable(this.f46379h);
        parcel.writeParcelable(this.f46377f, i2);
        parcel.writeInt(this.j.ordinal());
    }

    private BranchUniversalObject(Parcel parcel) {
        this();
        this.k = parcel.readLong();
        this.f46372a = parcel.readString();
        this.f46373b = parcel.readString();
        this.f46374c = parcel.readString();
        this.f46375d = parcel.readString();
        this.f46376e = parcel.readString();
        this.f46380i = parcel.readLong();
        this.f46378g = a.values()[parcel.readInt()];
        ArrayList arrayList = (ArrayList) parcel.readSerializable();
        if (arrayList != null) {
            this.f46379h.addAll(arrayList);
        }
        this.f46377f = (ContentMetadata) parcel.readParcelable(ContentMetadata.class.getClassLoader());
        this.j = a.values()[parcel.readInt()];
    }
}
