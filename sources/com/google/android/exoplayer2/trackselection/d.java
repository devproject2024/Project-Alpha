package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Arrays;

public abstract class d extends i {

    /* renamed from: c  reason: collision with root package name */
    private a f33491c;

    /* access modifiers changed from: protected */
    public abstract Pair<ad[], f[]> a(a aVar, int[][][] iArr, int[] iArr2) throws i;

    public static final class a {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public final int f33492a = this.f33493b;

        /* renamed from: b  reason: collision with root package name */
        final int f33493b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f33494c;

        /* renamed from: d  reason: collision with root package name */
        public final TrackGroupArray[] f33495d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f33496e;

        /* renamed from: f  reason: collision with root package name */
        private final int[][][] f33497f;

        /* renamed from: g  reason: collision with root package name */
        private final TrackGroupArray f33498g;

        a(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f33494c = iArr;
            this.f33495d = trackGroupArrayArr;
            this.f33497f = iArr3;
            this.f33496e = iArr2;
            this.f33498g = trackGroupArray;
            this.f33493b = iArr.length;
        }

        public final int a(int i2, int i3, int i4) {
            return this.f33497f[i2][i3][i4] & 7;
        }

        public final int a(int i2, int i3) {
            int i4 = this.f33495d[i2].f32785c[i3].f32780a;
            int[] iArr = new int[i4];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                if (a(i2, i3, i7) == 4) {
                    iArr[i6] = i7;
                    i6++;
                }
            }
            int[] copyOf = Arrays.copyOf(iArr, i6);
            String str = null;
            boolean z = false;
            int i8 = 0;
            int i9 = 16;
            while (i5 < copyOf.length) {
                String str2 = this.f33495d[i2].f32785c[i3].f32781b[copyOf[i5]].f31069i;
                int i10 = i8 + 1;
                if (i8 == 0) {
                    str = str2;
                } else {
                    z |= !ae.a((Object) str, (Object) str2);
                }
                i9 = Math.min(i9, this.f33497f[i2][i3][i5] & 24);
                i5++;
                i8 = i10;
            }
            return z ? Math.min(i9, this.f33496e[i2]) : i9;
        }
    }

    public final void a(Object obj) {
        this.f33491c = (a) obj;
    }

    public final j a(ac[] acVarArr, TrackGroupArray trackGroupArray) throws i {
        int[] iArr;
        int[] iArr2 = new int[(acVarArr.length + 1)];
        TrackGroup[][] trackGroupArr = new TrackGroup[(acVarArr.length + 1)][];
        int[][][] iArr3 = new int[(acVarArr.length + 1)][][];
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            trackGroupArr[i2] = new TrackGroup[trackGroupArray.f32784b];
            iArr3[i2] = new int[trackGroupArray.f32784b][];
        }
        int[] iArr4 = new int[acVarArr.length];
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            iArr4[i3] = acVarArr[i3].o();
        }
        for (int i4 = 0; i4 < trackGroupArray.f32784b; i4++) {
            TrackGroup trackGroup = trackGroupArray.f32785c[i4];
            int length = acVarArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= acVarArr.length) {
                    i5 = length;
                    break;
                }
                ac acVar = acVarArr[i5];
                int i7 = length;
                int i8 = i6;
                for (int i9 = 0; i9 < trackGroup.f32780a; i9++) {
                    int a2 = acVar.a(trackGroup.f32781b[i9]) & 7;
                    if (a2 > i8) {
                        if (a2 == 4) {
                            break;
                        }
                        i7 = i5;
                        i8 = a2;
                    }
                }
                i5++;
                i6 = i8;
                length = i7;
            }
            if (i5 == acVarArr.length) {
                iArr = new int[trackGroup.f32780a];
            } else {
                ac acVar2 = acVarArr[i5];
                int[] iArr5 = new int[trackGroup.f32780a];
                for (int i10 = 0; i10 < trackGroup.f32780a; i10++) {
                    iArr5[i10] = acVar2.a(trackGroup.f32781b[i10]);
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i5];
            trackGroupArr[i5][i11] = trackGroup;
            iArr3[i5][i11] = iArr;
            iArr2[i5] = iArr2[i5] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[acVarArr.length];
        int[] iArr6 = new int[acVarArr.length];
        for (int i12 = 0; i12 < acVarArr.length; i12++) {
            int i13 = iArr2[i12];
            trackGroupArrayArr[i12] = new TrackGroupArray((TrackGroup[]) ae.a((T[]) trackGroupArr[i12], i13));
            iArr3[i12] = (int[][]) ae.a((T[]) iArr3[i12], i13);
            iArr6[i12] = acVarArr[i12].a();
        }
        int[] iArr7 = iArr4;
        int[][][] iArr8 = iArr3;
        a aVar = new a(iArr6, trackGroupArrayArr, iArr7, iArr8, new TrackGroupArray((TrackGroup[]) ae.a((T[]) trackGroupArr[acVarArr.length], iArr2[acVarArr.length])));
        Pair<ad[], f[]> a3 = a(aVar, iArr3, iArr4);
        return new j((ad[]) a3.first, (f[]) a3.second, aVar);
    }
}
