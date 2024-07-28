package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.a;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.i;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public Excluder f39463a = Excluder.f39473a;

    /* renamed from: b  reason: collision with root package name */
    public e f39464b = d.IDENTITY;

    /* renamed from: c  reason: collision with root package name */
    public final List<x> f39465c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f39466d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39467e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39468f = false;

    /* renamed from: g  reason: collision with root package name */
    private v f39469g = v.DEFAULT;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Type, h<?>> f39470h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final List<x> f39471i = new ArrayList();
    private boolean j = false;
    private int k = 2;
    private int l = 2;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public final g a(Type type, Object obj) {
        boolean z = true;
        a.a(true);
        if (obj instanceof h) {
            this.f39470h.put(type, (h) obj);
        }
        com.google.gson.b.a<?> aVar = com.google.gson.b.a.get(type);
        List<x> list = this.f39465c;
        if (aVar.getType() != aVar.getRawType()) {
            z = false;
        }
        list.add(new TreeTypeAdapter.SingleTypeFactory(obj, aVar, z));
        if (obj instanceof w) {
            this.f39465c.add(i.a(com.google.gson.b.a.get(type), (w) obj));
        }
        return this;
    }

    public final f a() {
        a aVar;
        a aVar2;
        a aVar3;
        ArrayList arrayList = new ArrayList(this.f39465c.size() + this.f39471i.size() + 3);
        arrayList.addAll(this.f39465c);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f39471i);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        String str = this.f39466d;
        int i2 = this.k;
        int i3 = this.l;
        if (str == null || "".equals(str.trim())) {
            if (!(i2 == 2 || i3 == 2)) {
                aVar3 = new a(Date.class, i2, i3);
                a aVar4 = new a(Timestamp.class, i2, i3);
                a aVar5 = new a(java.sql.Date.class, i2, i3);
                aVar2 = aVar4;
                aVar = aVar5;
            }
            return new f(this.f39463a, this.f39464b, this.f39470h, this.j, this.m, this.p, this.f39467e, this.o, this.f39468f, this.n, this.f39469g, this.f39466d, this.k, this.l, this.f39465c, this.f39471i, arrayList);
        }
        a aVar6 = new a(Date.class, str);
        aVar2 = new a(Timestamp.class, str);
        aVar = new a(java.sql.Date.class, str);
        aVar3 = aVar6;
        arrayList.add(i.a(Date.class, aVar3));
        arrayList.add(i.a(Timestamp.class, aVar2));
        arrayList.add(i.a(java.sql.Date.class, aVar));
        return new f(this.f39463a, this.f39464b, this.f39470h, this.j, this.m, this.p, this.f39467e, this.o, this.f39468f, this.n, this.f39469g, this.f39466d, this.k, this.l, this.f39465c, this.f39471i, arrayList);
    }
}
