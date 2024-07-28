package com.google.android.gms.measurement.internal;

import androidx.a.a;
import com.google.android.gms.internal.measurement.aj;
import com.google.android.gms.internal.measurement.dv;
import com.google.android.gms.internal.measurement.ed;
import com.google.android.gms.internal.measurement.lf;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class jx {

    /* renamed from: a  reason: collision with root package name */
    BitSet f12301a;

    /* renamed from: b  reason: collision with root package name */
    private String f12302b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12303c;

    /* renamed from: d  reason: collision with root package name */
    private aj.i f12304d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f12305e;

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, Long> f12306f;

    /* renamed from: g  reason: collision with root package name */
    private Map<Integer, List<Long>> f12307g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ jv f12308h;

    private jx(jv jvVar, String str) {
        this.f12308h = jvVar;
        this.f12302b = str;
        this.f12303c = true;
        this.f12301a = new BitSet();
        this.f12305e = new BitSet();
        this.f12306f = new a();
        this.f12307g = new a();
    }

    private jx(jv jvVar, String str, aj.i iVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f12308h = jvVar;
        this.f12302b = str;
        this.f12301a = bitSet;
        this.f12305e = bitSet2;
        this.f12306f = map;
        this.f12307g = new a();
        if (map2 != null) {
            for (Integer next : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(next));
                this.f12307g.put(next, arrayList);
            }
        }
        this.f12303c = false;
        this.f12304d = iVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(kc kcVar) {
        int a2 = kcVar.a();
        if (kcVar.f12330c != null) {
            this.f12305e.set(a2, kcVar.f12330c.booleanValue());
        }
        if (kcVar.f12331d != null) {
            this.f12301a.set(a2, kcVar.f12331d.booleanValue());
        }
        if (kcVar.f12332e != null) {
            Long l = this.f12306f.get(Integer.valueOf(a2));
            long longValue = kcVar.f12332e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f12306f.put(Integer.valueOf(a2), Long.valueOf(longValue));
            }
        }
        if (kcVar.f12333f != null) {
            List list = this.f12307g.get(Integer.valueOf(a2));
            if (list == null) {
                list = new ArrayList();
                this.f12307g.put(Integer.valueOf(a2), list);
            }
            lf.a();
            if (this.f12308h.H_().d(this.f12302b, o.as) && kcVar.b()) {
                list.clear();
            }
            list.add(Long.valueOf(kcVar.f12333f.longValue() / 1000));
        }
    }

    /* access modifiers changed from: package-private */
    public final aj.a a(int i2, List<Integer> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        List<Integer> list2 = list;
        aj.a.C0157a c2 = aj.a.c();
        c2.a(i2);
        c2.a(this.f12303c);
        aj.i iVar = this.f12304d;
        if (iVar != null) {
            c2.a(iVar);
        }
        aj.i.a a2 = aj.i.d().b((Iterable<? extends Long>) jn.a(this.f12301a)).a((Iterable<? extends Long>) jn.a(this.f12305e));
        Map<Integer, Long> map = this.f12306f;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(map.size());
            for (Integer intValue : this.f12306f.keySet()) {
                int intValue2 = intValue.intValue();
                arrayList.add((aj.b) ((dv) aj.b.c().a(intValue2).a(this.f12306f.get(Integer.valueOf(intValue2)).longValue()).w()));
            }
        }
        a2.c(arrayList);
        Map<Integer, List<Long>> map2 = this.f12307g;
        if (map2 == null) {
            arrayList2 = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer next : this.f12307g.keySet()) {
                aj.j.a a3 = aj.j.c().a(next.intValue());
                List list3 = this.f12307g.get(next);
                if (list3 != null) {
                    Collections.sort(list3);
                    a3.a((Iterable<? extends Long>) list3);
                }
                arrayList3.add((aj.j) ((dv) a3.w()));
            }
            arrayList2 = arrayList3;
        }
        lf.a();
        if (!this.f12308h.H_().d(this.f12302b, o.as) && c2.a()) {
            ed<aj.j> edVar = c2.b().zzf;
            if (!edVar.isEmpty()) {
                ArrayList arrayList4 = new ArrayList(arrayList2);
                a aVar = new a();
                for (aj.j next2 : edVar) {
                    if (next2.a() && next2.b() > 0) {
                        aVar.put(Integer.valueOf(next2.zzd), Long.valueOf(next2.b(next2.b() - 1)));
                    }
                }
                for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                    aj.j jVar = (aj.j) arrayList4.get(i3);
                    Long l = (Long) aVar.remove(jVar.a() ? Integer.valueOf(jVar.zzd) : null);
                    if (l != null && (list2 == null || !list2.contains(Integer.valueOf(jVar.zzd)))) {
                        ArrayList arrayList5 = new ArrayList();
                        if (l.longValue() < jVar.b(0)) {
                            arrayList5.add(l);
                        }
                        arrayList5.addAll(jVar.zze);
                        arrayList4.set(i3, (aj.j) ((dv) ((aj.j.a) jVar.m()).a().a((Iterable<? extends Long>) arrayList5).w()));
                    }
                }
                for (Integer num : aVar.keySet()) {
                    arrayList4.add((aj.j) ((dv) aj.j.c().a(num.intValue()).a(((Long) aVar.get(num)).longValue()).w()));
                }
                arrayList2 = arrayList4;
            }
        }
        a2.d(arrayList2);
        c2.a(a2);
        return (aj.a) ((dv) c2.w());
    }

    /* synthetic */ jx(jv jvVar, String str, aj.i iVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, byte b2) {
        this(jvVar, str, iVar, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ jx(jv jvVar, String str, byte b2) {
        this(jvVar, str);
    }
}
