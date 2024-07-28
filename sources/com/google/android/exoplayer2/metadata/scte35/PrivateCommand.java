package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.r;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new PrivateCommand[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f32723a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32724b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f32725c;

    /* synthetic */ PrivateCommand(Parcel parcel, byte b2) {
        this(parcel);
    }

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.f32723a = j2;
        this.f32724b = j;
        this.f32725c = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f32723a = parcel.readLong();
        this.f32724b = parcel.readLong();
        this.f32725c = new byte[parcel.readInt()];
        parcel.readByteArray(this.f32725c);
    }

    static PrivateCommand a(r rVar, int i2, long j) {
        long g2 = rVar.g();
        byte[] bArr = new byte[(i2 - 4)];
        rVar.a(bArr, 0, bArr.length);
        return new PrivateCommand(g2, bArr, j);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f32723a);
        parcel.writeLong(this.f32724b);
        parcel.writeInt(this.f32725c.length);
        parcel.writeByteArray(this.f32725c);
    }
}
