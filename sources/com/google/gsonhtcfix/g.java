package com.google.gsonhtcfix;

import com.google.gsonhtcfix.b.d;
import com.google.gsonhtcfix.c.a;
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
    private d f39812a = d.f39738a;

    /* renamed from: b  reason: collision with root package name */
    private w f39813b = w.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private e f39814c = d.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, h<?>> f39815d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<z> f39816e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<z> f39817f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f39818g;

    /* renamed from: h  reason: collision with root package name */
    private String f39819h;

    /* renamed from: i  reason: collision with root package name */
    private int f39820i = 2;
    private int j = 2;
    private boolean k;
    private boolean l;
    private boolean m = true;
    private boolean n;
    private boolean o;

    public final f a() {
        a aVar;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f39816e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f39817f);
        String str = this.f39819h;
        int i2 = this.f39820i;
        int i3 = this.j;
        if (str == null || "".equals(str.trim())) {
            if (!(i2 == 2 || i3 == 2)) {
                aVar = new a(i2, i3);
            }
            return new f(this.f39812a, this.f39814c, this.f39815d, this.f39818g, this.k, this.o, this.m, this.n, this.l, this.f39813b, arrayList);
        }
        aVar = new a(str);
        arrayList.add(x.a((a<?>) a.get(Date.class), (Object) aVar));
        arrayList.add(x.a((a<?>) a.get(Timestamp.class), (Object) aVar));
        arrayList.add(x.a((a<?>) a.get(java.sql.Date.class), (Object) aVar));
        return new f(this.f39812a, this.f39814c, this.f39815d, this.f39818g, this.k, this.o, this.m, this.n, this.l, this.f39813b, arrayList);
    }
}
