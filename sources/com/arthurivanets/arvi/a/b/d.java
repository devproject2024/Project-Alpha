package com.arthurivanets.arvi.a.b;

import android.content.Context;
import android.os.Handler;
import com.arthurivanets.arvi.b.b.c;
import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d extends h {

    /* renamed from: b  reason: collision with root package name */
    private final List<e<i>> f30988b;

    public d(Context context, e[] eVarArr, int i2) {
        super(context);
        this.f32595a = i2;
        if (eVarArr == null || eVarArr.length <= 1) {
            this.f30988b = new ArrayList();
            return;
        }
        c.a((Object) eVarArr);
        int length = eVarArr.length;
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.set(i3, eVarArr[i3]);
        }
        this.f30988b = arrayList;
    }

    public final void a(Context context, int i2, com.google.android.exoplayer2.d.c cVar, e<i> eVar, boolean z, boolean z2, Handler handler, com.google.android.exoplayer2.video.h hVar, long j, ArrayList<ab> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        super.a(context, i2, cVar, eVar, z, z2, handler, hVar, j, (ArrayList<ab>) arrayList2);
        HashSet hashSet = new HashSet(arrayList2);
        if (!this.f30988b.isEmpty()) {
            arrayList2.clear();
            for (e<i> a2 : this.f30988b) {
                super.a(context, 0, cVar, a2, z, z2, handler, hVar, j, (ArrayList<ab>) arrayList2);
            }
            hashSet.addAll(arrayList2);
        }
        arrayList.addAll(hashSet);
    }

    public final void a(Context context, int i2, com.google.android.exoplayer2.d.c cVar, e<i> eVar, boolean z, boolean z2, g[] gVarArr, Handler handler, com.google.android.exoplayer2.b.h hVar, ArrayList<ab> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        super.a(context, i2, cVar, eVar, z, z2, gVarArr, handler, hVar, (ArrayList<ab>) arrayList2);
        HashSet hashSet = new HashSet(arrayList2);
        if (!this.f30988b.isEmpty()) {
            arrayList2.clear();
            for (e<i> a2 : this.f30988b) {
                super.a(context, 0, cVar, a2, z, z2, gVarArr, handler, hVar, (ArrayList<ab>) arrayList2);
            }
            hashSet.addAll(arrayList2);
        }
        arrayList.addAll(hashSet);
    }
}
