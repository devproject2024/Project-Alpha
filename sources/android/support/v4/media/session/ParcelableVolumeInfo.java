package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f888a;

    /* renamed from: b  reason: collision with root package name */
    public int f889b;

    /* renamed from: c  reason: collision with root package name */
    public int f890c;

    /* renamed from: d  reason: collision with root package name */
    public int f891d;

    /* renamed from: e  reason: collision with root package name */
    public int f892e;

    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f888a = parcel.readInt();
        this.f890c = parcel.readInt();
        this.f891d = parcel.readInt();
        this.f892e = parcel.readInt();
        this.f889b = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f888a);
        parcel.writeInt(this.f890c);
        parcel.writeInt(this.f891d);
        parcel.writeInt(this.f892e);
        parcel.writeInt(this.f889b);
    }
}
