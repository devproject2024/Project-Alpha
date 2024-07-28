package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f32738a;

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, byte b2) {
        this(parcel);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f32741a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32742b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32743c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f32744d;

        /* renamed from: e  reason: collision with root package name */
        public final long f32745e;

        /* renamed from: f  reason: collision with root package name */
        public final List<a> f32746f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f32747g;

        /* renamed from: h  reason: collision with root package name */
        public final long f32748h;

        /* renamed from: i  reason: collision with root package name */
        public final int f32749i;
        public final int j;
        public final int k;

        private b(long j2, boolean z, boolean z2, boolean z3, List<a> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f32741a = j2;
            this.f32742b = z;
            this.f32743c = z2;
            this.f32744d = z3;
            this.f32746f = Collections.unmodifiableList(list);
            this.f32745e = j3;
            this.f32747g = z4;
            this.f32748h = j4;
            this.f32749i = i2;
            this.j = i3;
            this.k = i4;
        }

        b(Parcel parcel) {
            this.f32741a = parcel.readLong();
            boolean z = false;
            this.f32742b = parcel.readByte() == 1;
            this.f32743c = parcel.readByte() == 1;
            this.f32744d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(new a(parcel.readInt(), parcel.readLong()));
            }
            this.f32746f = Collections.unmodifiableList(arrayList);
            this.f32745e = parcel.readLong();
            this.f32747g = parcel.readByte() == 1 ? true : z;
            this.f32748h = parcel.readLong();
            this.f32749i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        static b a(r rVar) {
            long j2;
            int i2;
            int i3;
            int i4;
            boolean z;
            boolean z2;
            long j3;
            ArrayList arrayList;
            long g2 = rVar.g();
            boolean z3 = false;
            boolean z4 = (rVar.c() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (!z4) {
                int c2 = rVar.c();
                boolean z5 = (c2 & 128) != 0;
                z = (c2 & 64) != 0;
                boolean z6 = (c2 & 32) != 0;
                long g3 = z ? rVar.g() : -9223372036854775807L;
                if (!z) {
                    int c3 = rVar.c();
                    ArrayList arrayList3 = new ArrayList(c3);
                    for (int i5 = 0; i5 < c3; i5++) {
                        arrayList3.add(new a(rVar.c(), rVar.g(), (byte) 0));
                    }
                    arrayList2 = arrayList3;
                }
                if (z6) {
                    long c4 = (long) rVar.c();
                    if ((128 & c4) != 0) {
                        z3 = true;
                    }
                    j2 = ((((c4 & 1) << 32) | rVar.g()) * 1000) / 90;
                } else {
                    j2 = -9223372036854775807L;
                }
                int d2 = rVar.d();
                int c5 = rVar.c();
                i2 = rVar.c();
                j3 = g3;
                i4 = d2;
                i3 = c5;
                arrayList = arrayList2;
                boolean z7 = z5;
                z2 = z3;
                z3 = z7;
            } else {
                arrayList = arrayList2;
                j3 = -9223372036854775807L;
                z2 = false;
                z = false;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                j2 = -9223372036854775807L;
            }
            return new b(g2, z4, z3, z, arrayList, j3, z2, j2, i4, i3, i2);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f32739a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32740b;

        /* synthetic */ a(int i2, long j, byte b2) {
            this(i2, j);
        }

        a(int i2, long j) {
            this.f32739a = i2;
            this.f32740b = j;
        }
    }

    private SpliceScheduleCommand(List<b> list) {
        this.f32738a = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(new b(parcel));
        }
        this.f32738a = Collections.unmodifiableList(arrayList);
    }

    static SpliceScheduleCommand a(r rVar) {
        int c2 = rVar.c();
        ArrayList arrayList = new ArrayList(c2);
        for (int i2 = 0; i2 < c2; i2++) {
            arrayList.add(b.a(rVar));
        }
        return new SpliceScheduleCommand((List<b>) arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int size = this.f32738a.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f32738a.get(i3);
            parcel.writeLong(bVar.f32741a);
            parcel.writeByte(bVar.f32742b ? (byte) 1 : 0);
            parcel.writeByte(bVar.f32743c ? (byte) 1 : 0);
            parcel.writeByte(bVar.f32744d ? (byte) 1 : 0);
            int size2 = bVar.f32746f.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                a aVar = bVar.f32746f.get(i4);
                parcel.writeInt(aVar.f32739a);
                parcel.writeLong(aVar.f32740b);
            }
            parcel.writeLong(bVar.f32745e);
            parcel.writeByte(bVar.f32747g ? (byte) 1 : 0);
            parcel.writeLong(bVar.f32748h);
            parcel.writeInt(bVar.f32749i);
            parcel.writeInt(bVar.j);
            parcel.writeInt(bVar.k);
        }
    }
}
