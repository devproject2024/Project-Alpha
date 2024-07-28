package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f32726a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32727b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32728c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f32729d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f32730e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32731f;

    /* renamed from: g  reason: collision with root package name */
    public final long f32732g;

    /* renamed from: h  reason: collision with root package name */
    public final List<a> f32733h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f32734i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    /* synthetic */ SpliceInsertCommand(Parcel parcel, byte b2) {
        this(parcel);
    }

    private SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<a> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.f32726a = j2;
        this.f32727b = z;
        this.f32728c = z2;
        this.f32729d = z3;
        this.f32730e = z4;
        this.f32731f = j3;
        this.f32732g = j4;
        this.f32733h = Collections.unmodifiableList(list);
        this.f32734i = z5;
        this.j = j5;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f32726a = parcel.readLong();
        boolean z = false;
        this.f32727b = parcel.readByte() == 1;
        this.f32728c = parcel.readByte() == 1;
        this.f32729d = parcel.readByte() == 1;
        this.f32730e = parcel.readByte() == 1;
        this.f32731f = parcel.readLong();
        this.f32732g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(new a(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.f32733h = Collections.unmodifiableList(arrayList);
        this.f32734i = parcel.readByte() == 1 ? true : z;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    static SpliceInsertCommand a(r rVar, long j2, ab abVar) {
        boolean z;
        int i2;
        int i3;
        int i4;
        long j3;
        boolean z2;
        List list;
        long j4;
        boolean z3;
        boolean z4;
        List list2;
        boolean z5;
        long j5;
        ab abVar2 = abVar;
        long g2 = rVar.g();
        boolean z6 = (rVar.c() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z6) {
            int c2 = rVar.c();
            boolean z7 = (c2 & 128) != 0;
            boolean z8 = (c2 & 64) != 0;
            boolean z9 = (c2 & 32) != 0;
            boolean z10 = (c2 & 16) != 0;
            long a2 = (!z8 || z10) ? -9223372036854775807L : TimeSignalCommand.a(rVar, j2);
            if (!z8) {
                int c3 = rVar.c();
                list2 = new ArrayList(c3);
                for (int i5 = 0; i5 < c3; i5++) {
                    int c4 = rVar.c();
                    long a3 = !z10 ? TimeSignalCommand.a(rVar, j2) : -9223372036854775807L;
                    list2.add(new a(c4, a3, abVar2.b(a3), (byte) 0));
                }
            } else {
                list2 = emptyList;
            }
            if (z9) {
                long c5 = (long) rVar.c();
                z5 = (128 & c5) != 0;
                j5 = ((((c5 & 1) << 32) | rVar.g()) * 1000) / 90;
            } else {
                j5 = -9223372036854775807L;
                z5 = false;
            }
            int d2 = rVar.d();
            i3 = rVar.c();
            i2 = rVar.c();
            z4 = z7;
            z = z8;
            list = list2;
            boolean z11 = z5;
            i4 = d2;
            long j6 = j5;
            z3 = z10;
            j4 = a2;
            z2 = z11;
            j3 = j6;
        } else {
            list = emptyList;
            z4 = false;
            z3 = false;
            j4 = -9223372036854775807L;
            z2 = false;
            j3 = -9223372036854775807L;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z = false;
        }
        return new SpliceInsertCommand(g2, z6, z4, z, z3, j4, abVar2.b(j4), list, z2, j3, i4, i3, i2);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f32735a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32736b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32737c;

        /* synthetic */ a(int i2, long j, long j2, byte b2) {
            this(i2, j, j2);
        }

        a(int i2, long j, long j2) {
            this.f32735a = i2;
            this.f32736b = j;
            this.f32737c = j2;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f32726a);
        parcel.writeByte(this.f32727b ? (byte) 1 : 0);
        parcel.writeByte(this.f32728c ? (byte) 1 : 0);
        parcel.writeByte(this.f32729d ? (byte) 1 : 0);
        parcel.writeByte(this.f32730e ? (byte) 1 : 0);
        parcel.writeLong(this.f32731f);
        parcel.writeLong(this.f32732g);
        int size = this.f32733h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = this.f32733h.get(i3);
            parcel.writeInt(aVar.f32735a);
            parcel.writeLong(aVar.f32736b);
            parcel.writeLong(aVar.f32737c);
        }
        parcel.writeByte(this.f32734i ? (byte) 1 : 0);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }
}
