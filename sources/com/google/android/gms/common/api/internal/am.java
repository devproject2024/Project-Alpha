package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class am extends aq {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a.f> f8421a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ag f8422b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public am(ag agVar, ArrayList<a.f> arrayList) {
        super(agVar, (byte) 0);
        this.f8422b = agVar;
        this.f8421a = arrayList;
    }

    public final void a() {
        Set<Scope> set;
        as asVar = this.f8422b.f8403a.m;
        ag agVar = this.f8422b;
        if (agVar.k == null) {
            set = Collections.emptySet();
        } else {
            HashSet hashSet = new HashSet(agVar.k.f8817b);
            Map<a<?>, d.b> map = agVar.k.f8819d;
            for (a next : map.keySet()) {
                if (!agVar.f8403a.f8447g.containsKey(next.b())) {
                    hashSet.addAll(map.get(next).f8834a);
                }
            }
            set = hashSet;
        }
        asVar.f8431c = set;
        ArrayList arrayList = this.f8421a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((a.f) obj).a(this.f8422b.f8410h, this.f8422b.f8403a.m.f8431c);
        }
    }
}
