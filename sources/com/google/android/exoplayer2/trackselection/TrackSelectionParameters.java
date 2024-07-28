package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.g.ae;

public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new Parcelable.Creator<TrackSelectionParameters>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new TrackSelectionParameters[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }
    };
    public static final TrackSelectionParameters y = new TrackSelectionParameters();
    public final String A;
    public final int B;
    public final boolean C;
    public final int D;
    public final String z;

    public int describeContents() {
        return 0;
    }

    public static class a {
        int A;
        String w;
        String x;
        int y;
        boolean z;

        a(TrackSelectionParameters trackSelectionParameters) {
            this.w = trackSelectionParameters.z;
            this.x = trackSelectionParameters.A;
            this.y = trackSelectionParameters.B;
            this.z = trackSelectionParameters.C;
            this.A = trackSelectionParameters.D;
        }
    }

    TrackSelectionParameters() {
        this((String) null, (String) null, 0, false, 0);
    }

    TrackSelectionParameters(String str, String str2, int i2, boolean z2, int i3) {
        this.z = ae.b(str);
        this.A = ae.b(str2);
        this.B = i2;
        this.C = z2;
        this.D = i3;
    }

    TrackSelectionParameters(Parcel parcel) {
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readInt();
        this.C = ae.a(parcel);
        this.D = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
            return TextUtils.equals(this.z, trackSelectionParameters.z) && TextUtils.equals(this.A, trackSelectionParameters.A) && this.B == trackSelectionParameters.B && this.C == trackSelectionParameters.C && this.D == trackSelectionParameters.D;
        }
    }

    public int hashCode() {
        String str = this.z;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.A;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((((hashCode + i2) * 31) + this.B) * 31) + (this.C ? 1 : 0)) * 31) + this.D;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
        ae.a(parcel, this.C);
        parcel.writeInt(this.D);
    }
}
