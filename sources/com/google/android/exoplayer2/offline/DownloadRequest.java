package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new DownloadRequest[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32758a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32759b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f32760c;

    /* renamed from: d  reason: collision with root package name */
    public final List<StreamKey> f32761d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32762e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f32763f;

    public final int describeContents() {
        return 0;
    }

    DownloadRequest(Parcel parcel) {
        this.f32758a = (String) ae.a(parcel.readString());
        this.f32759b = (String) ae.a(parcel.readString());
        this.f32760c = Uri.parse((String) ae.a(parcel.readString()));
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f32761d = Collections.unmodifiableList(arrayList);
        this.f32762e = parcel.readString();
        this.f32763f = new byte[parcel.readInt()];
        parcel.readByteArray(this.f32763f);
    }

    public final String toString() {
        return this.f32759b + AppConstants.COLON + this.f32758a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.f32758a.equals(downloadRequest.f32758a) || !this.f32759b.equals(downloadRequest.f32759b) || !this.f32760c.equals(downloadRequest.f32760c) || !this.f32761d.equals(downloadRequest.f32761d) || !ae.a((Object) this.f32762e, (Object) downloadRequest.f32762e) || !Arrays.equals(this.f32763f, downloadRequest.f32763f)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = ((((((((this.f32759b.hashCode() * 31) + this.f32758a.hashCode()) * 31) + this.f32759b.hashCode()) * 31) + this.f32760c.hashCode()) * 31) + this.f32761d.hashCode()) * 31;
        String str = this.f32762e;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f32763f);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32758a);
        parcel.writeString(this.f32759b);
        parcel.writeString(this.f32760c.toString());
        parcel.writeInt(this.f32761d.size());
        for (int i3 = 0; i3 < this.f32761d.size(); i3++) {
            parcel.writeParcelable(this.f32761d.get(i3), 0);
        }
        parcel.writeString(this.f32762e);
        parcel.writeInt(this.f32763f.length);
        parcel.writeByteArray(this.f32763f);
    }
}
