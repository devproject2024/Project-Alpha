package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.b.m;
import java.util.List;

public interface e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f33499a = $$Lambda$e$E0ReNb7GnahXzmlZOJqx_ErSU0.INSTANCE;

    int[] getBitrates(Format[] formatArr, List<? extends l> list, m[] mVarArr, int[] iArr);

    /* renamed from: com.google.android.exoplayer2.trackselection.e$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ int[] a(Format[] formatArr, List list, m[] mVarArr, int[] iArr) {
            int length = formatArr.length;
            if (iArr == null) {
                iArr = new int[length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = formatArr[i2].f31065e;
            }
            return iArr;
        }
    }
}
