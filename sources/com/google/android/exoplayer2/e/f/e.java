package com.google.android.exoplayer2.e.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.g.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class e implements com.google.android.exoplayer2.e.e {

    /* renamed from: a  reason: collision with root package name */
    private final b f31580a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f31581b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, d> f31582c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, c> f31583d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f31584e;

    public e(b bVar, Map<String, d> map, Map<String, c> map2, Map<String, String> map3) {
        this.f31580a = bVar;
        this.f31583d = map2;
        this.f31584e = map3;
        this.f31582c = Collections.unmodifiableMap(map);
        this.f31581b = bVar.a();
    }

    public final int a(long j) {
        int a2 = ae.a(this.f31581b, j, false, false);
        if (a2 < this.f31581b.length) {
            return a2;
        }
        return -1;
    }

    public final int b() {
        return this.f31581b.length;
    }

    public final long a_(int i2) {
        return this.f31581b[i2];
    }

    public final List<b> b(long j) {
        long j2 = j;
        b bVar = this.f31580a;
        Map<String, d> map = this.f31582c;
        Map<String, c> map2 = this.f31583d;
        Map<String, String> map3 = this.f31584e;
        ArrayList<Pair> arrayList = new ArrayList<>();
        bVar.a(j2, bVar.f31559g, (List<Pair<String, String>>) arrayList);
        TreeMap treeMap = new TreeMap();
        bVar.a(j, false, bVar.f31559g, treeMap);
        bVar.a(j2, map, (Map<String, SpannableStringBuilder>) treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                c cVar = map2.get(pair.first);
                arrayList2.add(new b(decodeByteArray, cVar.f31563b, cVar.f31564c, cVar.f31566e, cVar.f31567f, cVar.f31568g));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar2 = map2.get(entry.getKey());
            arrayList2.add(new b((CharSequence) b.a((SpannableStringBuilder) entry.getValue()), cVar2.f31564c, cVar2.f31565d, cVar2.f31566e, cVar2.f31563b, cVar2.f31567f, cVar2.f31569h, cVar2.f31570i));
        }
        return arrayList2;
    }
}
