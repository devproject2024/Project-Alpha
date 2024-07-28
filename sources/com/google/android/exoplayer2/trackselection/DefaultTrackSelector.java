package com.google.android.exoplayer2.trackselection;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.a;
import com.google.android.exoplayer2.trackselection.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class DefaultTrackSelector extends d {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f33418c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    private final f.b f33419d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<Parameters> f33420e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33421f;

    static /* synthetic */ int a(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    protected static boolean a(int i2, boolean z) {
        int i3 = i2 & 7;
        if (i3 != 4) {
            return z && i3 == 3;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int c(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    public static final class c extends TrackSelectionParameters.a {

        /* renamed from: a  reason: collision with root package name */
        int f33448a;

        /* renamed from: b  reason: collision with root package name */
        int f33449b;

        /* renamed from: c  reason: collision with root package name */
        int f33450c;

        /* renamed from: d  reason: collision with root package name */
        int f33451d;

        /* renamed from: e  reason: collision with root package name */
        boolean f33452e;

        /* renamed from: f  reason: collision with root package name */
        boolean f33453f;

        /* renamed from: g  reason: collision with root package name */
        boolean f33454g;

        /* renamed from: h  reason: collision with root package name */
        int f33455h;

        /* renamed from: i  reason: collision with root package name */
        int f33456i;
        boolean j;
        int k;
        int l;
        boolean m;
        boolean n;
        boolean o;
        boolean p;
        boolean q;
        boolean r;
        boolean s;
        int t;
        final SparseArray<Map<TrackGroupArray, SelectionOverride>> u;
        final SparseBooleanArray v;

        /* synthetic */ c(Parameters parameters, byte b2) {
            this(parameters);
        }

        public c() {
            this(Parameters.f33422a);
        }

        private c(Parameters parameters) {
            super(parameters);
            this.f33448a = parameters.f33423b;
            this.f33449b = parameters.f33424c;
            this.f33450c = parameters.f33425d;
            this.f33451d = parameters.f33426e;
            this.f33452e = parameters.f33427f;
            this.f33453f = parameters.f33428g;
            this.f33454g = parameters.f33429h;
            this.f33455h = parameters.f33430i;
            this.f33456i = parameters.j;
            this.j = parameters.k;
            this.k = parameters.l;
            this.l = parameters.m;
            this.m = parameters.n;
            this.n = parameters.o;
            this.o = parameters.p;
            this.p = parameters.q;
            this.q = parameters.r;
            this.r = parameters.s;
            this.s = parameters.v;
            this.t = parameters.w;
            SparseArray a2 = parameters.x;
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>();
            for (int i2 = 0; i2 < a2.size(); i2++) {
                sparseArray.put(a2.keyAt(i2), new HashMap((Map) a2.valueAt(i2)));
            }
            this.u = sparseArray;
            this.v = parameters.E.clone();
        }

        public final c a() {
            this.f33448a = 1279;
            this.f33449b = 719;
            return this;
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new Parameters[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public static final Parameters f33422a = new Parameters();
        /* access modifiers changed from: private */
        public final SparseBooleanArray E;

        /* renamed from: b  reason: collision with root package name */
        public final int f33423b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33424c;

        /* renamed from: d  reason: collision with root package name */
        public final int f33425d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33426e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f33427f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f33428g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f33429h;

        /* renamed from: i  reason: collision with root package name */
        public final int f33430i;
        public final int j;
        public final boolean k;
        public final int l;
        public final int m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final boolean q;
        public final boolean r;
        public final boolean s;
        @Deprecated
        public final boolean t;
        @Deprecated
        public final boolean u;
        public final boolean v;
        public final int w;
        /* access modifiers changed from: package-private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> x;

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Parameters() {
            /*
                r28 = this;
                r0 = r28
                com.google.android.exoplayer2.trackselection.TrackSelectionParameters r1 = com.google.android.exoplayer2.trackselection.TrackSelectionParameters.y
                java.lang.String r11 = r1.z
                com.google.android.exoplayer2.trackselection.TrackSelectionParameters r1 = com.google.android.exoplayer2.trackselection.TrackSelectionParameters.y
                java.lang.String r1 = r1.A
                r18 = r1
                com.google.android.exoplayer2.trackselection.TrackSelectionParameters r1 = com.google.android.exoplayer2.trackselection.TrackSelectionParameters.y
                int r1 = r1.B
                r19 = r1
                com.google.android.exoplayer2.trackselection.TrackSelectionParameters r1 = com.google.android.exoplayer2.trackselection.TrackSelectionParameters.y
                boolean r1 = r1.C
                r20 = r1
                com.google.android.exoplayer2.trackselection.TrackSelectionParameters r1 = com.google.android.exoplayer2.trackselection.TrackSelectionParameters.y
                int r1 = r1.D
                r21 = r1
                android.util.SparseArray r1 = new android.util.SparseArray
                r26 = r1
                r1.<init>()
                android.util.SparseBooleanArray r1 = new android.util.SparseBooleanArray
                r27 = r1
                r1.<init>()
                r1 = 2147483647(0x7fffffff, float:NaN)
                r2 = 2147483647(0x7fffffff, float:NaN)
                r3 = 2147483647(0x7fffffff, float:NaN)
                r4 = 2147483647(0x7fffffff, float:NaN)
                r5 = 1
                r6 = 0
                r7 = 1
                r8 = 2147483647(0x7fffffff, float:NaN)
                r9 = 2147483647(0x7fffffff, float:NaN)
                r10 = 1
                r12 = 2147483647(0x7fffffff, float:NaN)
                r13 = 2147483647(0x7fffffff, float:NaN)
                r14 = 1
                r15 = 0
                r16 = 0
                r17 = 0
                r22 = 0
                r23 = 0
                r24 = 1
                r25 = 0
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.<init>():void");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Parameters(int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, int i6, int i7, boolean z4, String str, int i8, int i9, boolean z5, boolean z6, boolean z7, boolean z8, String str2, int i10, boolean z9, int i11, boolean z10, boolean z11, boolean z12, int i12, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i10, z9, i11);
            boolean z13 = z2;
            boolean z14 = z3;
            this.f33423b = i2;
            this.f33424c = i3;
            this.f33425d = i4;
            this.f33426e = i5;
            this.f33427f = z;
            this.f33428g = z13;
            this.f33429h = z14;
            this.f33430i = i6;
            this.j = i7;
            this.k = z4;
            this.l = i8;
            this.m = i9;
            this.n = z5;
            this.o = z6;
            this.p = z7;
            this.q = z8;
            this.r = z10;
            this.s = z11;
            this.v = z12;
            this.w = i12;
            this.t = z13;
            this.u = z14;
            this.x = sparseArray;
            this.E = sparseBooleanArray;
        }

        Parameters(Parcel parcel) {
            super(parcel);
            this.f33423b = parcel.readInt();
            this.f33424c = parcel.readInt();
            this.f33425d = parcel.readInt();
            this.f33426e = parcel.readInt();
            this.f33427f = ae.a(parcel);
            this.f33428g = ae.a(parcel);
            this.f33429h = ae.a(parcel);
            this.f33430i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = ae.a(parcel);
            this.l = parcel.readInt();
            this.m = parcel.readInt();
            this.n = ae.a(parcel);
            this.o = ae.a(parcel);
            this.p = ae.a(parcel);
            this.q = ae.a(parcel);
            this.r = ae.a(parcel);
            this.s = ae.a(parcel);
            this.v = ae.a(parcel);
            this.w = parcel.readInt();
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    hashMap.put((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader()), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            this.x = sparseArray;
            this.E = (SparseBooleanArray) ae.a(parcel.readSparseBooleanArray());
            this.t = this.f33428g;
            this.u = this.f33429h;
        }

        public final boolean a(int i2) {
            return this.E.get(i2);
        }

        public final boolean equals(Object obj) {
            boolean z;
            boolean z2;
            boolean z3;
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Parameters parameters = (Parameters) obj;
                if (super.equals(obj) && this.f33423b == parameters.f33423b && this.f33424c == parameters.f33424c && this.f33425d == parameters.f33425d && this.f33426e == parameters.f33426e && this.f33427f == parameters.f33427f && this.f33428g == parameters.f33428g && this.f33429h == parameters.f33429h && this.k == parameters.k && this.f33430i == parameters.f33430i && this.j == parameters.j && this.l == parameters.l && this.m == parameters.m && this.n == parameters.n && this.o == parameters.o && this.p == parameters.p && this.q == parameters.q && this.r == parameters.r && this.s == parameters.s && this.v == parameters.v && this.w == parameters.w) {
                    SparseBooleanArray sparseBooleanArray = this.E;
                    SparseBooleanArray sparseBooleanArray2 = parameters.E;
                    int size = sparseBooleanArray.size();
                    if (sparseBooleanArray2.size() == size) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                z = true;
                                break;
                            } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = this.x;
                        SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = parameters.x;
                        int size2 = sparseArray.size();
                        if (sparseArray2.size() == size2) {
                            int i3 = 0;
                            while (true) {
                                if (i3 < size2) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i3));
                                    if (indexOfKey < 0) {
                                        break;
                                    }
                                    Map valueAt = sparseArray.valueAt(i3);
                                    Map valueAt2 = sparseArray2.valueAt(indexOfKey);
                                    if (valueAt2.size() == valueAt.size()) {
                                        Iterator it2 = valueAt.entrySet().iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                z3 = true;
                                                break;
                                            }
                                            Map.Entry entry = (Map.Entry) it2.next();
                                            TrackGroupArray trackGroupArray = (TrackGroupArray) entry.getKey();
                                            if (valueAt2.containsKey(trackGroupArray)) {
                                                if (!ae.a(entry.getValue(), valueAt2.get(trackGroupArray))) {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                        break;
                                    }
                                    i3++;
                                } else {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.f33423b) * 31) + this.f33424c) * 31) + this.f33425d) * 31) + this.f33426e) * 31) + (this.f33427f ? 1 : 0)) * 31) + (this.f33428g ? 1 : 0)) * 31) + (this.f33429h ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31) + this.f33430i) * 31) + this.j) * 31) + this.l) * 31) + this.m) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + (this.p ? 1 : 0)) * 31) + (this.q ? 1 : 0)) * 31) + (this.r ? 1 : 0)) * 31) + (this.s ? 1 : 0)) * 31) + (this.v ? 1 : 0)) * 31) + this.w;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f33423b);
            parcel.writeInt(this.f33424c);
            parcel.writeInt(this.f33425d);
            parcel.writeInt(this.f33426e);
            ae.a(parcel, this.f33427f);
            ae.a(parcel, this.f33428g);
            ae.a(parcel, this.f33429h);
            parcel.writeInt(this.f33430i);
            parcel.writeInt(this.j);
            ae.a(parcel, this.k);
            parcel.writeInt(this.l);
            parcel.writeInt(this.m);
            ae.a(parcel, this.n);
            ae.a(parcel, this.o);
            ae.a(parcel, this.p);
            ae.a(parcel, this.q);
            ae.a(parcel, this.r);
            ae.a(parcel, this.s);
            ae.a(parcel, this.v);
            parcel.writeInt(this.w);
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = this.x;
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                Map valueAt = sparseArray.valueAt(i3);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : valueAt.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
            parcel.writeSparseBooleanArray(this.E);
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SelectionOverride[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final int f33431a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f33432b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33433c;

        /* renamed from: d  reason: collision with root package name */
        public final int f33434d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33435e;

        public final int describeContents() {
            return 0;
        }

        public SelectionOverride(int i2, int... iArr) {
            this(i2, iArr, (byte) 0);
        }

        private SelectionOverride(int i2, int[] iArr, byte b2) {
            this.f33431a = i2;
            this.f33432b = Arrays.copyOf(iArr, iArr.length);
            this.f33433c = iArr.length;
            this.f33434d = 2;
            this.f33435e = 0;
            Arrays.sort(this.f33432b);
        }

        SelectionOverride(Parcel parcel) {
            this.f33431a = parcel.readInt();
            this.f33433c = parcel.readByte();
            this.f33432b = new int[this.f33433c];
            parcel.readIntArray(this.f33432b);
            this.f33434d = parcel.readInt();
            this.f33435e = parcel.readInt();
        }

        public final boolean a(int i2) {
            for (int i3 : this.f33432b) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.f33431a * 31) + Arrays.hashCode(this.f33432b)) * 31) + this.f33434d) * 31) + this.f33435e;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SelectionOverride selectionOverride = (SelectionOverride) obj;
                return this.f33431a == selectionOverride.f33431a && Arrays.equals(this.f33432b, selectionOverride.f33432b) && this.f33434d == selectionOverride.f33434d && this.f33435e == selectionOverride.f33435e;
            }
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f33431a);
            parcel.writeInt(this.f33432b.length);
            parcel.writeIntArray(this.f33432b);
            parcel.writeInt(this.f33434d);
            parcel.writeInt(this.f33435e);
        }
    }

    public DefaultTrackSelector() {
        this(new a.c());
    }

    private DefaultTrackSelector(f.b bVar) {
        this.f33419d = bVar;
        this.f33420e = new AtomicReference<>(Parameters.f33422a);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x00f7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fe A[LOOP:1: B:21:0x0047->B:49:0x00fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.exoplayer2.ad[], com.google.android.exoplayer2.trackselection.f[]> a(com.google.android.exoplayer2.trackselection.d.a r35, int[][][] r36, int[] r37) throws com.google.android.exoplayer2.i {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            r2 = r36
            java.util.concurrent.atomic.AtomicReference<com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters> r3 = r0.f33420e
            java.lang.Object r3 = r3.get()
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters r3 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) r3
            int r4 = r1.f33493b
            int r5 = r1.f33493b
            com.google.android.exoplayer2.trackselection.f$a[] r6 = new com.google.android.exoplayer2.trackselection.f.a[r5]
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0017:
            r11 = 2
            if (r8 >= r5) goto L_0x0167
            int[] r14 = r1.f33494c
            r14 = r14[r8]
            if (r11 != r14) goto L_0x014d
            if (r9 != 0) goto L_0x0130
            com.google.android.exoplayer2.source.TrackGroupArray[] r9 = r1.f33495d
            r9 = r9[r8]
            r14 = r2[r8]
            r15 = r37[r8]
            boolean r7 = r3.s
            if (r7 != 0) goto L_0x0115
            boolean r7 = r3.r
            if (r7 != 0) goto L_0x0115
            boolean r7 = r3.f33429h
            if (r7 == 0) goto L_0x0039
            r7 = 24
            goto L_0x003b
        L_0x0039:
            r7 = 16
        L_0x003b:
            boolean r12 = r3.f33428g
            if (r12 == 0) goto L_0x0045
            r12 = r15 & r7
            if (r12 == 0) goto L_0x0045
            r12 = 1
            goto L_0x0046
        L_0x0045:
            r12 = 0
        L_0x0046:
            r15 = 0
        L_0x0047:
            int r13 = r9.f32784b
            if (r15 >= r13) goto L_0x0115
            com.google.android.exoplayer2.source.TrackGroup[] r13 = r9.f32785c
            r13 = r13[r15]
            r26 = r14[r15]
            int r11 = r3.f33423b
            r27 = r4
            int r4 = r3.f33424c
            int r2 = r3.f33425d
            int r0 = r3.f33426e
            r28 = r5
            int r5 = r3.f33430i
            r29 = r10
            int r10 = r3.j
            boolean r1 = r3.k
            r30 = r6
            int r6 = r13.f32780a
            r31 = r8
            r8 = 2
            if (r6 >= r8) goto L_0x0074
            int[] r0 = f33418c
        L_0x0070:
            r33 = r12
            goto L_0x00f4
        L_0x0074:
            java.util.List r1 = a((com.google.android.exoplayer2.source.TrackGroup) r13, (int) r5, (int) r10, (boolean) r1)
            int r5 = r1.size()
            if (r5 >= r8) goto L_0x0081
            int[] r0 = f33418c
            goto L_0x0070
        L_0x0081:
            if (r12 != 0) goto L_0x00cf
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            r6 = 0
            r10 = 0
            r32 = 0
        L_0x008c:
            int r8 = r1.size()
            if (r6 >= r8) goto L_0x00ca
            java.lang.Object r8 = r1.get(r6)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r33 = r12
            com.google.android.exoplayer2.Format[] r12 = r13.f32781b
            r8 = r12[r8]
            java.lang.String r8 = r8.f31069i
            boolean r12 = r5.add(r8)
            if (r12 == 0) goto L_0x00c5
            r16 = r13
            r17 = r26
            r18 = r7
            r19 = r8
            r20 = r11
            r21 = r4
            r22 = r2
            r23 = r0
            r24 = r1
            int r12 = a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            if (r12 <= r10) goto L_0x00c5
            r32 = r8
            r10 = r12
        L_0x00c5:
            int r6 = r6 + 1
            r12 = r33
            goto L_0x008c
        L_0x00ca:
            r33 = r12
            r19 = r32
            goto L_0x00d3
        L_0x00cf:
            r33 = r12
            r19 = 0
        L_0x00d3:
            r16 = r13
            r17 = r26
            r18 = r7
            r20 = r11
            r21 = r4
            r22 = r2
            r23 = r0
            r24 = r1
            b(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            int r0 = r1.size()
            r2 = 2
            if (r0 >= r2) goto L_0x00f0
            int[] r0 = f33418c
            goto L_0x00f4
        L_0x00f0:
            int[] r0 = com.google.android.exoplayer2.g.ae.a((java.util.List<java.lang.Integer>) r1)
        L_0x00f4:
            int r1 = r0.length
            if (r1 <= 0) goto L_0x00fe
            com.google.android.exoplayer2.trackselection.f$a r1 = new com.google.android.exoplayer2.trackselection.f$a
            r1.<init>(r13, r0)
            r12 = r1
            goto L_0x0120
        L_0x00fe:
            int r15 = r15 + 1
            r0 = r34
            r1 = r35
            r2 = r36
            r4 = r27
            r5 = r28
            r10 = r29
            r6 = r30
            r8 = r31
            r12 = r33
            r11 = 2
            goto L_0x0047
        L_0x0115:
            r27 = r4
            r28 = r5
            r30 = r6
            r31 = r8
            r29 = r10
            r12 = 0
        L_0x0120:
            if (r12 != 0) goto L_0x0126
            com.google.android.exoplayer2.trackselection.f$a r12 = a((com.google.android.exoplayer2.source.TrackGroupArray) r9, (int[][]) r14, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) r3)
        L_0x0126:
            r30[r31] = r12
            r0 = r30[r31]
            if (r0 == 0) goto L_0x012e
            r9 = 1
            goto L_0x013a
        L_0x012e:
            r9 = 0
            goto L_0x013a
        L_0x0130:
            r27 = r4
            r28 = r5
            r30 = r6
            r31 = r8
            r29 = r10
        L_0x013a:
            r0 = r35
            com.google.android.exoplayer2.source.TrackGroupArray[] r1 = r0.f33495d
            r1 = r1[r31]
            int r1 = r1.f32784b
            if (r1 <= 0) goto L_0x0147
            r25 = 1
            goto L_0x0149
        L_0x0147:
            r25 = 0
        L_0x0149:
            r1 = r29 | r25
            r10 = r1
            goto L_0x0158
        L_0x014d:
            r0 = r1
            r27 = r4
            r28 = r5
            r30 = r6
            r31 = r8
            r29 = r10
        L_0x0158:
            int r8 = r31 + 1
            r2 = r36
            r1 = r0
            r4 = r27
            r5 = r28
            r6 = r30
            r0 = r34
            goto L_0x0017
        L_0x0167:
            r0 = r1
            r27 = r4
            r28 = r5
            r30 = r6
            r29 = r10
            r1 = -1
            r2 = r28
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = -1
        L_0x0177:
            if (r4 >= r2) goto L_0x01ce
            int[] r8 = r0.f33494c
            r8 = r8[r4]
            r9 = 1
            if (r9 != r8) goto L_0x01c6
            r8 = r34
            boolean r9 = r8.f33421f
            if (r9 != 0) goto L_0x018b
            if (r29 != 0) goto L_0x0189
            goto L_0x018b
        L_0x0189:
            r9 = 0
            goto L_0x018c
        L_0x018b:
            r9 = 1
        L_0x018c:
            com.google.android.exoplayer2.source.TrackGroupArray[] r10 = r0.f33495d
            r10 = r10[r4]
            r11 = r36
            r12 = r11[r4]
            android.util.Pair r9 = a((com.google.android.exoplayer2.source.TrackGroupArray) r10, (int[][]) r12, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) r3, (boolean) r9)
            if (r9 == 0) goto L_0x01c4
            if (r6 == 0) goto L_0x01a6
            java.lang.Object r10 = r9.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b r10 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.b) r10
            int r10 = r10.compareTo(r6)
            if (r10 <= 0) goto L_0x01c4
        L_0x01a6:
            if (r7 == r1) goto L_0x01ab
            r5 = 0
            r30[r7] = r5
        L_0x01ab:
            java.lang.Object r5 = r9.first
            com.google.android.exoplayer2.trackselection.f$a r5 = (com.google.android.exoplayer2.trackselection.f.a) r5
            r30[r4] = r5
            com.google.android.exoplayer2.source.TrackGroup r6 = r5.f33500a
            int[] r5 = r5.f33501b
            r10 = 0
            r5 = r5[r10]
            com.google.android.exoplayer2.Format[] r6 = r6.f32781b
            r5 = r6[r5]
            java.lang.String r5 = r5.A
            java.lang.Object r6 = r9.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b r6 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.b) r6
            r7 = r4
            goto L_0x01cb
        L_0x01c4:
            r10 = 0
            goto L_0x01cb
        L_0x01c6:
            r10 = 0
            r8 = r34
            r11 = r36
        L_0x01cb:
            int r4 = r4 + 1
            goto L_0x0177
        L_0x01ce:
            r10 = 0
            r8 = r34
            r11 = r36
            r4 = 0
            r6 = 0
            r7 = -1
        L_0x01d6:
            if (r4 >= r2) goto L_0x021f
            int[] r9 = r0.f33494c
            r9 = r9[r4]
            r12 = 1
            r13 = 2
            if (r9 == r12) goto L_0x021b
            if (r9 == r13) goto L_0x021b
            r14 = 3
            if (r9 == r14) goto L_0x01f2
            com.google.android.exoplayer2.source.TrackGroupArray[] r9 = r0.f33495d
            r9 = r9[r4]
            r14 = r11[r4]
            com.google.android.exoplayer2.trackselection.f$a r9 = b(r9, r14, r3)
            r30[r4] = r9
            goto L_0x021b
        L_0x01f2:
            com.google.android.exoplayer2.source.TrackGroupArray[] r9 = r0.f33495d
            r9 = r9[r4]
            r14 = r11[r4]
            android.util.Pair r9 = a((com.google.android.exoplayer2.source.TrackGroupArray) r9, (int[][]) r14, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) r3, (java.lang.String) r5)
            if (r9 == 0) goto L_0x021b
            if (r6 == 0) goto L_0x020a
            java.lang.Object r14 = r9.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$d r14 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.d) r14
            int r14 = r14.compareTo(r6)
            if (r14 <= 0) goto L_0x021b
        L_0x020a:
            r14 = 0
            if (r7 == r1) goto L_0x020f
            r30[r7] = r14
        L_0x020f:
            java.lang.Object r6 = r9.first
            com.google.android.exoplayer2.trackselection.f$a r6 = (com.google.android.exoplayer2.trackselection.f.a) r6
            r30[r4] = r6
            java.lang.Object r6 = r9.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$d r6 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.d) r6
            r7 = r4
            goto L_0x021c
        L_0x021b:
            r14 = 0
        L_0x021c:
            int r4 = r4 + 1
            goto L_0x01d6
        L_0x021f:
            r12 = 1
            r14 = 0
            r1 = r27
            r2 = 0
        L_0x0224:
            if (r2 >= r1) goto L_0x0276
            boolean r4 = r3.a((int) r2)
            if (r4 == 0) goto L_0x022e
        L_0x022c:
            r6 = r14
            goto L_0x0271
        L_0x022e:
            com.google.android.exoplayer2.source.TrackGroupArray[] r4 = r0.f33495d
            r4 = r4[r2]
            android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride>> r5 = r3.x
            java.lang.Object r5 = r5.get(r2)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 == 0) goto L_0x0244
            boolean r5 = r5.containsKey(r4)
            if (r5 == 0) goto L_0x0244
            r5 = 1
            goto L_0x0245
        L_0x0244:
            r5 = 0
        L_0x0245:
            if (r5 == 0) goto L_0x0273
            android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride>> r5 = r3.x
            java.lang.Object r5 = r5.get(r2)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 == 0) goto L_0x0258
            java.lang.Object r5 = r5.get(r4)
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride r5 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride) r5
            goto L_0x0259
        L_0x0258:
            r5 = r14
        L_0x0259:
            if (r5 != 0) goto L_0x025c
            goto L_0x022c
        L_0x025c:
            com.google.android.exoplayer2.trackselection.f$a r6 = new com.google.android.exoplayer2.trackselection.f$a
            int r7 = r5.f33431a
            com.google.android.exoplayer2.source.TrackGroup[] r4 = r4.f32785c
            r4 = r4[r7]
            int[] r7 = r5.f33432b
            int r9 = r5.f33434d
            int r5 = r5.f33435e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.<init>(r4, r7, r9, r5)
        L_0x0271:
            r30[r2] = r6
        L_0x0273:
            int r2 = r2 + 1
            goto L_0x0224
        L_0x0276:
            com.google.android.exoplayer2.trackselection.f$b r2 = r8.f33419d
            com.google.android.exoplayer2.f.d r4 = r8.f33508b
            java.lang.Object r4 = com.google.android.exoplayer2.g.a.a(r4)
            com.google.android.exoplayer2.f.d r4 = (com.google.android.exoplayer2.f.d) r4
            r5 = r30
            com.google.android.exoplayer2.trackselection.f[] r2 = r2.a(r5, r4)
            com.google.android.exoplayer2.ad[] r4 = new com.google.android.exoplayer2.ad[r1]
            r5 = 0
        L_0x0289:
            if (r5 >= r1) goto L_0x02aa
            boolean r6 = r3.a((int) r5)
            if (r6 != 0) goto L_0x029e
            int[] r6 = r0.f33494c
            r6 = r6[r5]
            r7 = 6
            if (r6 == r7) goto L_0x029c
            r6 = r2[r5]
            if (r6 == 0) goto L_0x029e
        L_0x029c:
            r6 = 1
            goto L_0x029f
        L_0x029e:
            r6 = 0
        L_0x029f:
            if (r6 == 0) goto L_0x02a4
            com.google.android.exoplayer2.ad r6 = com.google.android.exoplayer2.ad.f31104a
            goto L_0x02a5
        L_0x02a4:
            r6 = r14
        L_0x02a5:
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0289
        L_0x02aa:
            int r1 = r3.w
            a((com.google.android.exoplayer2.trackselection.d.a) r0, (int[][][]) r11, (com.google.android.exoplayer2.ad[]) r4, (com.google.android.exoplayer2.trackselection.f[]) r2, (int) r1)
            android.util.Pair r0 = android.util.Pair.create(r4, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.trackselection.d$a, int[][][], int[]):android.util.Pair");
    }

    private static int a(TrackGroup trackGroup, int[] iArr, int i2, String str, int i3, int i4, int i5, int i6, List<Integer> list) {
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            int intValue = list.get(i8).intValue();
            if (a(trackGroup.f32781b[intValue], str, iArr[intValue], i2, i3, i4, i5, i6)) {
                i7++;
            }
        }
        return i7;
    }

    private static void b(TrackGroup trackGroup, int[] iArr, int i2, String str, int i3, int i4, int i5, int i6, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            if (!a(trackGroup.f32781b[intValue], str, iArr[intValue], i2, i3, i4, i5, i6)) {
                list2.remove(size);
            }
        }
    }

    private static boolean a(Format format, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (!a(i2, false) || (i2 & i3) == 0 || ((str != null && !ae.a((Object) format.f31069i, (Object) str)) || ((format.n != -1 && format.n > i4) || ((format.o != -1 && format.o > i5) || ((format.p != -1.0f && format.p > ((float) i6)) || (format.f31065e != -1 && format.f31065e > i7)))))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        if (r0 < 0) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.trackselection.f.a a(com.google.android.exoplayer2.source.TrackGroupArray r17, int[][] r18, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r19) {
        /*
            r0 = r17
            r1 = r19
            r3 = -1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = -1
            r10 = -1
        L_0x000b:
            int r11 = r0.f32784b
            if (r5 >= r11) goto L_0x00e7
            com.google.android.exoplayer2.source.TrackGroup[] r11 = r0.f32785c
            r11 = r11[r5]
            int r13 = r1.f33430i
            int r14 = r1.j
            boolean r15 = r1.k
            java.util.List r13 = a((com.google.android.exoplayer2.source.TrackGroup) r11, (int) r13, (int) r14, (boolean) r15)
            r14 = r18[r5]
            r15 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = 0
        L_0x0025:
            int r12 = r11.f32780a
            if (r6 >= r12) goto L_0x00d8
            r12 = r14[r6]
            boolean r2 = r1.v
            boolean r2 = a((int) r12, (boolean) r2)
            if (r2 == 0) goto L_0x00cd
            com.google.android.exoplayer2.Format[] r2 = r11.f32781b
            r2 = r2[r6]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            boolean r12 = r13.contains(r12)
            if (r12 == 0) goto L_0x0072
            int r12 = r2.n
            if (r12 == r3) goto L_0x004b
            int r12 = r2.n
            int r4 = r1.f33423b
            if (r12 > r4) goto L_0x0072
        L_0x004b:
            int r4 = r2.o
            if (r4 == r3) goto L_0x0055
            int r4 = r2.o
            int r12 = r1.f33424c
            if (r4 > r12) goto L_0x0072
        L_0x0055:
            float r4 = r2.p
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x0066
            float r4 = r2.p
            int r12 = r1.f33425d
            float r12 = (float) r12
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 > 0) goto L_0x0072
        L_0x0066:
            int r4 = r2.f31065e
            if (r4 == r3) goto L_0x0070
            int r4 = r2.f31065e
            int r12 = r1.f33426e
            if (r4 > r12) goto L_0x0072
        L_0x0070:
            r4 = 1
            goto L_0x0073
        L_0x0072:
            r4 = 0
        L_0x0073:
            if (r4 != 0) goto L_0x0079
            boolean r12 = r1.f33427f
            if (r12 == 0) goto L_0x00cd
        L_0x0079:
            if (r4 == 0) goto L_0x007d
            r12 = 2
            goto L_0x007e
        L_0x007d:
            r12 = 1
        L_0x007e:
            r3 = r14[r6]
            r0 = 0
            boolean r3 = a((int) r3, (boolean) r0)
            if (r3 == 0) goto L_0x0089
            int r12 = r12 + 1000
        L_0x0089:
            if (r12 <= r9) goto L_0x008d
            r0 = 1
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            if (r12 != r9) goto L_0x00bf
            int r0 = r2.f31065e
            int r0 = c(r0, r10)
            r16 = r7
            boolean r7 = r1.r
            if (r7 == 0) goto L_0x00a4
            if (r0 == 0) goto L_0x00a4
            if (r0 >= 0) goto L_0x00a2
        L_0x00a0:
            r0 = 1
            goto L_0x00c1
        L_0x00a2:
            r0 = 0
            goto L_0x00c1
        L_0x00a4:
            int r0 = r2.a()
            if (r0 == r15) goto L_0x00af
            int r0 = c(r0, r15)
            goto L_0x00b5
        L_0x00af:
            int r0 = r2.f31065e
            int r0 = c(r0, r10)
        L_0x00b5:
            if (r3 == 0) goto L_0x00bc
            if (r4 == 0) goto L_0x00bc
            if (r0 <= 0) goto L_0x00a2
            goto L_0x00a0
        L_0x00bc:
            if (r0 >= 0) goto L_0x00a2
            goto L_0x00a0
        L_0x00bf:
            r16 = r7
        L_0x00c1:
            if (r0 == 0) goto L_0x00cf
            int r10 = r2.f31065e
            int r15 = r2.a()
            r8 = r6
            r7 = r11
            r9 = r12
            goto L_0x00d1
        L_0x00cd:
            r16 = r7
        L_0x00cf:
            r7 = r16
        L_0x00d1:
            int r6 = r6 + 1
            r3 = -1
            r0 = r17
            goto L_0x0025
        L_0x00d8:
            r16 = r7
            int r5 = r5 + 1
            r3 = -1
            r0 = r17
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r15
            r6 = r16
            goto L_0x000b
        L_0x00e7:
            if (r6 != 0) goto L_0x00eb
            r0 = 0
            return r0
        L_0x00eb:
            com.google.android.exoplayer2.trackselection.f$a r0 = new com.google.android.exoplayer2.trackselection.f$a
            r1 = 1
            int[] r1 = new int[r1]
            r2 = 0
            r1[r2] = r7
            r0.<init>(r6, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.source.TrackGroupArray, int[][], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.f$a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.google.android.exoplayer2.trackselection.f.a, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.b> a(com.google.android.exoplayer2.source.TrackGroupArray r22, int[][] r23, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r24, boolean r25) throws com.google.android.exoplayer2.i {
        /*
            r0 = r22
            r1 = r24
            r2 = -1
            r3 = 0
            r7 = r3
            r5 = 0
            r6 = -1
            r8 = -1
        L_0x000a:
            int r9 = r0.f32784b
            if (r5 >= r9) goto L_0x004d
            com.google.android.exoplayer2.source.TrackGroup[] r9 = r0.f32785c
            r9 = r9[r5]
            r10 = r23[r5]
            r11 = r8
            r8 = r7
            r7 = r6
            r6 = 0
        L_0x0018:
            int r12 = r9.f32780a
            if (r6 >= r12) goto L_0x0047
            r12 = r10[r6]
            boolean r13 = r1.v
            boolean r12 = a((int) r12, (boolean) r13)
            if (r12 == 0) goto L_0x0044
            com.google.android.exoplayer2.Format[] r12 = r9.f32781b
            r12 = r12[r6]
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b r13 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b
            r14 = r10[r6]
            r13.<init>(r12, r1, r14)
            boolean r12 = r13.f33439a
            if (r12 != 0) goto L_0x0039
            boolean r12 = r1.n
            if (r12 == 0) goto L_0x0044
        L_0x0039:
            if (r8 == 0) goto L_0x0041
            int r12 = r13.compareTo(r8)
            if (r12 <= 0) goto L_0x0044
        L_0x0041:
            r7 = r5
            r11 = r6
            r8 = r13
        L_0x0044:
            int r6 = r6 + 1
            goto L_0x0018
        L_0x0047:
            int r5 = r5 + 1
            r6 = r7
            r7 = r8
            r8 = r11
            goto L_0x000a
        L_0x004d:
            if (r6 != r2) goto L_0x0050
            return r3
        L_0x0050:
            com.google.android.exoplayer2.source.TrackGroup[] r0 = r0.f32785c
            r0 = r0[r6]
            boolean r2 = r1.s
            r5 = 1
            if (r2 != 0) goto L_0x00f6
            boolean r2 = r1.r
            if (r2 != 0) goto L_0x00f6
            if (r25 == 0) goto L_0x00f6
            r2 = r23[r6]
            int r6 = r1.m
            boolean r15 = r1.o
            boolean r14 = r1.p
            boolean r1 = r1.q
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            r16 = r3
            r11 = 0
            r12 = 0
        L_0x0072:
            int r9 = r0.f32780a
            if (r12 >= r9) goto L_0x00b9
            com.google.android.exoplayer2.Format[] r9 = r0.f32781b
            r9 = r9[r12]
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$a r10 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector$a
            int r3 = r9.v
            int r4 = r9.w
            java.lang.String r9 = r9.f31069i
            r10.<init>(r3, r4, r9)
            boolean r3 = r13.add(r10)
            if (r3 == 0) goto L_0x00a5
            r9 = r0
            r3 = r10
            r10 = r2
            r4 = r11
            r11 = r3
            r18 = r12
            r12 = r6
            r19 = r13
            r13 = r15
            r20 = r14
            r21 = r15
            r15 = r1
            int r9 = a((com.google.android.exoplayer2.source.TrackGroup) r9, (int[]) r10, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a) r11, (int) r12, (boolean) r13, (boolean) r14, (boolean) r15)
            if (r9 <= r4) goto L_0x00ae
            r16 = r3
            r11 = r9
            goto L_0x00af
        L_0x00a5:
            r4 = r11
            r18 = r12
            r19 = r13
            r20 = r14
            r21 = r15
        L_0x00ae:
            r11 = r4
        L_0x00af:
            int r12 = r18 + 1
            r13 = r19
            r14 = r20
            r15 = r21
            r3 = 0
            goto L_0x0072
        L_0x00b9:
            r4 = r11
            r20 = r14
            r21 = r15
            if (r4 <= r5) goto L_0x00e9
            com.google.android.exoplayer2.g.a.a(r16)
            int[] r3 = new int[r4]
            r4 = 0
            r18 = 0
        L_0x00c8:
            int r9 = r0.f32780a
            if (r4 >= r9) goto L_0x00eb
            com.google.android.exoplayer2.Format[] r9 = r0.f32781b
            r9 = r9[r4]
            r10 = r2[r4]
            r11 = r16
            r12 = r6
            r13 = r21
            r14 = r20
            r15 = r1
            boolean r9 = a((com.google.android.exoplayer2.Format) r9, (int) r10, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a) r11, (int) r12, (boolean) r13, (boolean) r14, (boolean) r15)
            if (r9 == 0) goto L_0x00e6
            int r9 = r18 + 1
            r3[r18] = r4
            r18 = r9
        L_0x00e6:
            int r4 = r4 + 1
            goto L_0x00c8
        L_0x00e9:
            int[] r3 = f33418c
        L_0x00eb:
            int r1 = r3.length
            if (r1 <= 0) goto L_0x00f6
            com.google.android.exoplayer2.trackselection.f$a r1 = new com.google.android.exoplayer2.trackselection.f$a
            r1.<init>(r0, r3)
            r17 = r1
            goto L_0x00f8
        L_0x00f6:
            r17 = 0
        L_0x00f8:
            if (r17 != 0) goto L_0x0105
            com.google.android.exoplayer2.trackselection.f$a r1 = new com.google.android.exoplayer2.trackselection.f$a
            int[] r2 = new int[r5]
            r3 = 0
            r2[r3] = r8
            r1.<init>(r0, r2)
            goto L_0x0107
        L_0x0105:
            r1 = r17
        L_0x0107:
            java.lang.Object r0 = com.google.android.exoplayer2.g.a.a(r7)
            android.util.Pair r0 = android.util.Pair.create(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.source.TrackGroupArray, int[][], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, boolean):android.util.Pair");
    }

    private static int a(TrackGroup trackGroup, int[] iArr, a aVar, int i2, boolean z, boolean z2, boolean z3) {
        TrackGroup trackGroup2 = trackGroup;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroup2.f32780a; i4++) {
            if (a(trackGroup2.f32781b[i4], iArr[i4], aVar, i2, z, z2, z3)) {
                i3++;
            }
        }
        return i3;
    }

    private static boolean a(Format format, int i2, a aVar, int i3, boolean z, boolean z2, boolean z3) {
        if (a(i2, false) && ((format.f31065e == -1 || format.f31065e <= i3) && ((z3 || (format.v != -1 && format.v == aVar.f33436a)) && (z || (format.f31069i != null && TextUtils.equals(format.f31069i, aVar.f33438c)))))) {
            if (z2) {
                return true;
            }
            if (format.w == -1 || format.w != aVar.f33437b) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static Pair<f.a, d> a(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, String str) throws i {
        TrackGroup trackGroup = null;
        d dVar = null;
        int i2 = 0;
        int i3 = -1;
        while (i2 < trackGroupArray.f32784b) {
            TrackGroup trackGroup2 = trackGroupArray.f32785c[i2];
            int[] iArr2 = iArr[i2];
            d dVar2 = dVar;
            TrackGroup trackGroup3 = trackGroup;
            for (int i4 = 0; i4 < trackGroup2.f32780a; i4++) {
                if (a(iArr2[i4], parameters.v)) {
                    d dVar3 = new d(trackGroup2.f32781b[i4], parameters, iArr2[i4], str);
                    if (dVar3.f33457a && (dVar2 == null || dVar3.compareTo(dVar2) > 0)) {
                        i3 = i4;
                        trackGroup3 = trackGroup2;
                        dVar2 = dVar3;
                    }
                }
            }
            i2++;
            trackGroup = trackGroup3;
            dVar = dVar2;
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new f.a(trackGroup, i3), com.google.android.exoplayer2.g.a.a(dVar));
    }

    private static f.a b(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws i {
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < trackGroupArray.f32784b) {
            TrackGroup trackGroup2 = trackGroupArray.f32785c[i2];
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            int i6 = i3;
            TrackGroup trackGroup3 = trackGroup;
            for (int i7 = 0; i7 < trackGroup2.f32780a; i7++) {
                if (a(iArr2[i7], parameters.v)) {
                    int i8 = (trackGroup2.f32781b[i7].f31063c & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i7], false)) {
                        i8 += 1000;
                    }
                    if (i8 > i5) {
                        i6 = i7;
                        trackGroup3 = trackGroup2;
                        i5 = i8;
                    }
                }
            }
            i2++;
            trackGroup = trackGroup3;
            i3 = i6;
            i4 = i5;
        }
        if (trackGroup == null) {
            return null;
        }
        return new f.a(trackGroup, i3);
    }

    protected static String a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int a(Format format, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.A)) {
            return 4;
        }
        String a2 = a(str);
        String a3 = a(format.A);
        if (a3 == null || a2 == null) {
            if (!z || a3 != null) {
                return 0;
            }
            return 1;
        } else if (a3.startsWith(a2) || a2.startsWith(a3)) {
            return 3;
        } else {
            if (ae.b(a3, "-")[0].equals(ae.b(a2, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    private static List<Integer> a(TrackGroup trackGroup, int i2, int i3, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.f32780a);
        for (int i4 = 0; i4 < trackGroup.f32780a; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 = 0; i6 < trackGroup.f32780a; i6++) {
                Format format = trackGroup.f32781b[i6];
                if (format.n > 0 && format.o > 0) {
                    Point a2 = a(z, i2, i3, format.n, format.o);
                    int i7 = format.n * format.o;
                    if (format.n >= ((int) (((float) a2.x) * 0.98f)) && format.o >= ((int) (((float) a2.y) * 0.98f)) && i7 < i5) {
                        i5 = i7;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int a3 = trackGroup.f32781b[((Integer) arrayList.get(size)).intValue()].a();
                    if (a3 == -1 || a3 > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point a(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.g.ae.a((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.g.ae.a((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f33439a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33440b;

        /* renamed from: c  reason: collision with root package name */
        private final Parameters f33441c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f33442d;

        /* renamed from: e  reason: collision with root package name */
        private final int f33443e;

        /* renamed from: f  reason: collision with root package name */
        private final int f33444f;

        /* renamed from: g  reason: collision with root package name */
        private final int f33445g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33446h;

        /* renamed from: i  reason: collision with root package name */
        private final int f33447i;
        private final int j;
        private final int k;

        public b(Format format, Parameters parameters, int i2) {
            this.f33441c = parameters;
            this.f33440b = DefaultTrackSelector.a(format.A);
            int i3 = 0;
            this.f33442d = DefaultTrackSelector.a(i2, false);
            this.f33443e = DefaultTrackSelector.a(format, parameters.z, false);
            boolean z = true;
            this.f33446h = (format.f31063c & 1) != 0;
            this.f33447i = format.v;
            this.j = format.w;
            this.k = format.f31065e;
            if ((format.f31065e != -1 && format.f31065e > parameters.m) || (format.v != -1 && format.v > parameters.l)) {
                z = false;
            }
            this.f33439a = z;
            String[] b2 = ae.b();
            int i4 = Integer.MAX_VALUE;
            int i5 = 0;
            while (true) {
                if (i5 >= b2.length) {
                    break;
                }
                int a2 = DefaultTrackSelector.a(format, b2[i5], false);
                if (a2 > 0) {
                    i4 = i5;
                    i3 = a2;
                    break;
                }
                i5++;
            }
            this.f33444f = i4;
            this.f33445g = i3;
        }

        /* renamed from: a */
        public final int compareTo(b bVar) {
            int a2;
            int b2;
            boolean z = this.f33442d;
            int i2 = 1;
            if (z != bVar.f33442d) {
                return z ? 1 : -1;
            }
            int i3 = this.f33443e;
            int i4 = bVar.f33443e;
            if (i3 != i4) {
                return DefaultTrackSelector.a(i3, i4);
            }
            boolean z2 = this.f33439a;
            if (z2 != bVar.f33439a) {
                return z2 ? 1 : -1;
            }
            if (this.f33441c.r && (b2 = DefaultTrackSelector.c(this.k, bVar.k)) != 0) {
                return b2 > 0 ? -1 : 1;
            }
            boolean z3 = this.f33446h;
            if (z3 != bVar.f33446h) {
                return z3 ? 1 : -1;
            }
            int i5 = this.f33444f;
            int i6 = bVar.f33444f;
            if (i5 != i6) {
                return -DefaultTrackSelector.a(i5, i6);
            }
            int i7 = this.f33445g;
            int i8 = bVar.f33445g;
            if (i7 != i8) {
                return DefaultTrackSelector.a(i7, i8);
            }
            if (!this.f33439a || !this.f33442d) {
                i2 = -1;
            }
            int i9 = this.f33447i;
            int i10 = bVar.f33447i;
            if (i9 != i10) {
                a2 = DefaultTrackSelector.a(i9, i10);
            } else {
                int i11 = this.j;
                int i12 = bVar.j;
                if (i11 != i12) {
                    a2 = DefaultTrackSelector.a(i11, i12);
                } else if (!ae.a((Object) this.f33440b, (Object) bVar.f33440b)) {
                    return 0;
                } else {
                    a2 = DefaultTrackSelector.a(this.k, bVar.k);
                }
            }
            return i2 * a2;
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f33436a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33437b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33438c;

        public a(int i2, int i3, String str) {
            this.f33436a = i2;
            this.f33437b = i3;
            this.f33438c = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                return this.f33436a == aVar.f33436a && this.f33437b == aVar.f33437b && TextUtils.equals(this.f33438c, aVar.f33438c);
            }
        }

        public final int hashCode() {
            int i2 = ((this.f33436a * 31) + this.f33437b) * 31;
            String str = this.f33438c;
            return i2 + (str != null ? str.hashCode() : 0);
        }
    }

    protected static final class d implements Comparable<d> {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f33457a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f33458b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f33459c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f33460d;

        /* renamed from: e  reason: collision with root package name */
        private final int f33461e;

        /* renamed from: f  reason: collision with root package name */
        private final int f33462f;

        /* renamed from: g  reason: collision with root package name */
        private final int f33463g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33464h;

        public d(Format format, Parameters parameters, int i2, String str) {
            boolean z = false;
            this.f33458b = DefaultTrackSelector.a(i2, false);
            int i3 = format.f31063c & (~parameters.D);
            this.f33459c = (i3 & 1) != 0;
            boolean z2 = (i3 & 2) != 0;
            this.f33461e = DefaultTrackSelector.a(format, parameters.A, parameters.C);
            this.f33462f = Integer.bitCount(format.f31064d & parameters.B);
            this.f33464h = (format.f31064d & 1088) != 0;
            this.f33460d = (this.f33461e > 0 && !z2) || (this.f33461e == 0 && z2);
            this.f33463g = DefaultTrackSelector.a(format, str, DefaultTrackSelector.a(str) == null);
            if (this.f33461e > 0 || ((parameters.A == null && this.f33462f > 0) || this.f33459c || (z2 && this.f33463g > 0))) {
                z = true;
            }
            this.f33457a = z;
        }

        /* renamed from: a */
        public final int compareTo(d dVar) {
            boolean z;
            boolean z2 = this.f33458b;
            if (z2 != dVar.f33458b) {
                return z2 ? 1 : -1;
            }
            int i2 = this.f33461e;
            int i3 = dVar.f33461e;
            if (i2 != i3) {
                return DefaultTrackSelector.a(i2, i3);
            }
            int i4 = this.f33462f;
            int i5 = dVar.f33462f;
            if (i4 != i5) {
                return DefaultTrackSelector.a(i4, i5);
            }
            boolean z3 = this.f33459c;
            if (z3 != dVar.f33459c) {
                return z3 ? 1 : -1;
            }
            boolean z4 = this.f33460d;
            if (z4 != dVar.f33460d) {
                return z4 ? 1 : -1;
            }
            int i6 = this.f33463g;
            int i7 = dVar.f33463g;
            if (i6 != i7) {
                return DefaultTrackSelector.a(i6, i7);
            }
            if (i4 != 0 || (z = this.f33464h) == dVar.f33464h) {
                return 0;
            }
            return z ? -1 : 1;
        }
    }

    public final void a(c cVar) {
        c cVar2 = cVar;
        Parameters parameters = r2;
        Parameters parameters2 = new Parameters(cVar2.f33448a, cVar2.f33449b, cVar2.f33450c, cVar2.f33451d, cVar2.f33452e, cVar2.f33453f, cVar2.f33454g, cVar2.f33455h, cVar2.f33456i, cVar2.j, cVar2.w, cVar2.k, cVar2.l, cVar2.m, cVar2.n, cVar2.o, cVar2.p, cVar2.x, cVar2.y, cVar2.z, cVar2.A, cVar2.q, cVar2.r, cVar2.s, cVar2.t, cVar2.u, cVar2.v);
        com.google.android.exoplayer2.g.a.a(parameters);
        Parameters parameters3 = parameters;
        if (!this.f33420e.getAndSet(parameters3).equals(parameters3) && this.f33507a != null) {
            this.f33507a.b();
        }
    }

    public final c a() {
        return new c(this.f33420e.get(), (byte) 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0056 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.exoplayer2.trackselection.d.a r15, int[][][] r16, com.google.android.exoplayer2.ad[] r17, com.google.android.exoplayer2.trackselection.f[] r18, int r19) {
        /*
            r0 = r15
            r1 = r19
            if (r1 != 0) goto L_0x0006
            return
        L_0x0006:
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L_0x000b:
            int r7 = r0.f33493b
            r8 = 1
            if (r4 >= r7) goto L_0x0059
            int[] r7 = r0.f33494c
            r7 = r7[r4]
            r9 = r18[r4]
            if (r7 == r8) goto L_0x001b
            r10 = 2
            if (r7 != r10) goto L_0x0056
        L_0x001b:
            if (r9 == 0) goto L_0x0056
            r10 = r16[r4]
            com.google.android.exoplayer2.source.TrackGroupArray[] r11 = r0.f33495d
            r11 = r11[r4]
            if (r9 != 0) goto L_0x0027
        L_0x0025:
            r9 = 0
            goto L_0x0048
        L_0x0027:
            com.google.android.exoplayer2.source.TrackGroup r12 = r9.e()
            int r11 = r11.a(r12)
            r12 = 0
        L_0x0030:
            int r13 = r9.f()
            if (r12 >= r13) goto L_0x0047
            r13 = r10[r11]
            int r14 = r9.b(r12)
            r13 = r13[r14]
            r14 = 32
            r13 = r13 & r14
            if (r13 == r14) goto L_0x0044
            goto L_0x0025
        L_0x0044:
            int r12 = r12 + 1
            goto L_0x0030
        L_0x0047:
            r9 = 1
        L_0x0048:
            if (r9 == 0) goto L_0x0056
            if (r7 != r8) goto L_0x0051
            if (r6 == r2) goto L_0x004f
            goto L_0x0053
        L_0x004f:
            r6 = r4
            goto L_0x0056
        L_0x0051:
            if (r5 == r2) goto L_0x0055
        L_0x0053:
            r0 = 0
            goto L_0x005a
        L_0x0055:
            r5 = r4
        L_0x0056:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0059:
            r0 = 1
        L_0x005a:
            if (r6 == r2) goto L_0x005f
            if (r5 == r2) goto L_0x005f
            r3 = 1
        L_0x005f:
            r0 = r0 & r3
            if (r0 == 0) goto L_0x006b
            com.google.android.exoplayer2.ad r0 = new com.google.android.exoplayer2.ad
            r0.<init>(r1)
            r17[r6] = r0
            r17[r5] = r0
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.trackselection.d$a, int[][][], com.google.android.exoplayer2.ad[], com.google.android.exoplayer2.trackselection.f[], int):void");
    }
}
