package io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LinkProperties implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new LinkProperties[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LinkProperties(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<String> f46593a;

    /* renamed from: b  reason: collision with root package name */
    private String f46594b;

    /* renamed from: c  reason: collision with root package name */
    private String f46595c;

    /* renamed from: d  reason: collision with root package name */
    private String f46596d;

    /* renamed from: e  reason: collision with root package name */
    private int f46597e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, String> f46598f;

    /* renamed from: g  reason: collision with root package name */
    private String f46599g;

    /* renamed from: h  reason: collision with root package name */
    private String f46600h;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ LinkProperties(Parcel parcel, byte b2) {
        this(parcel);
    }

    public LinkProperties() {
        this.f46593a = new ArrayList<>();
        this.f46594b = AppConstants.SHARE;
        this.f46598f = new HashMap<>();
        this.f46595c = "";
        this.f46596d = "";
        this.f46597e = 0;
        this.f46599g = "";
        this.f46600h = "";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f46594b);
        parcel.writeString(this.f46595c);
        parcel.writeString(this.f46596d);
        parcel.writeString(this.f46599g);
        parcel.writeString(this.f46600h);
        parcel.writeInt(this.f46597e);
        parcel.writeSerializable(this.f46593a);
        parcel.writeInt(this.f46598f.size());
        for (Map.Entry next : this.f46598f.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    private LinkProperties(Parcel parcel) {
        this();
        this.f46594b = parcel.readString();
        this.f46595c = parcel.readString();
        this.f46596d = parcel.readString();
        this.f46599g = parcel.readString();
        this.f46600h = parcel.readString();
        this.f46597e = parcel.readInt();
        this.f46593a.addAll((ArrayList) parcel.readSerializable());
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f46598f.put(parcel.readString(), parcel.readString());
        }
    }
}
