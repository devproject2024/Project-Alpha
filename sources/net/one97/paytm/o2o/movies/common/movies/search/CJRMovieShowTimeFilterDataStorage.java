package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class CJRMovieShowTimeFilterDataStorage implements Parcelable {
    public static final Parcelable.Creator<CJRMovieShowTimeFilterDataStorage> CREATOR = new Parcelable.Creator<CJRMovieShowTimeFilterDataStorage>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieShowTimeFilterDataStorage[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieShowTimeFilterDataStorage(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f75179a;

    /* renamed from: b  reason: collision with root package name */
    public String f75180b;

    /* renamed from: c  reason: collision with root package name */
    public long f75181c;

    /* renamed from: d  reason: collision with root package name */
    public long f75182d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f75183e;

    /* renamed from: f  reason: collision with root package name */
    public String f75184f;

    /* renamed from: g  reason: collision with root package name */
    public int f75185g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<String> f75186h;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f75179a);
        parcel.writeString(this.f75180b);
        parcel.writeLong(this.f75181c);
        parcel.writeLong(this.f75182d);
        parcel.writeStringList(this.f75183e);
        parcel.writeString(this.f75184f);
        parcel.writeStringList(this.f75186h);
        parcel.writeInt(this.f75185g);
    }

    public CJRMovieShowTimeFilterDataStorage() {
    }

    protected CJRMovieShowTimeFilterDataStorage(Parcel parcel) {
        this.f75179a = parcel.readString();
        this.f75180b = parcel.readString();
        this.f75181c = parcel.readLong();
        this.f75182d = parcel.readLong();
        this.f75183e = parcel.createStringArrayList();
        this.f75184f = parcel.readString();
        this.f75186h = parcel.createStringArrayList();
        this.f75185g = parcel.readInt();
    }
}
