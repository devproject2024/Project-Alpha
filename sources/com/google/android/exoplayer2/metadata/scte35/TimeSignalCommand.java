package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.r;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f32750a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32751b;

    /* synthetic */ TimeSignalCommand(long j, long j2, byte b2) {
        this(j, j2);
    }

    private TimeSignalCommand(long j, long j2) {
        this.f32750a = j;
        this.f32751b = j2;
    }

    static TimeSignalCommand a(r rVar, long j, ab abVar) {
        long a2 = a(rVar, j);
        return new TimeSignalCommand(a2, abVar.b(a2));
    }

    static long a(r rVar, long j) {
        long c2 = (long) rVar.c();
        if ((128 & c2) != 0) {
            return 8589934591L & ((((c2 & 1) << 32) | rVar.g()) + j);
        }
        return -9223372036854775807L;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f32750a);
        parcel.writeLong(this.f32751b);
    }
}
