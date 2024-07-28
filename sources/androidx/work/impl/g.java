package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.impl.utils.b;
import androidx.work.l;
import androidx.work.n;
import androidx.work.o;
import androidx.work.t;
import androidx.work.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class g extends t {

    /* renamed from: h  reason: collision with root package name */
    private static final String f5340h = l.a("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    public final j f5341a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5342b;

    /* renamed from: c  reason: collision with root package name */
    public final androidx.work.g f5343c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends w> f5344d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f5345e;

    /* renamed from: f  reason: collision with root package name */
    public final List<g> f5346f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5347g;

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f5348i;
    private o j;

    g(j jVar, List<? extends w> list) {
        this(jVar, (String) null, androidx.work.g.KEEP, list, (List<g>) null);
    }

    g(j jVar, String str, androidx.work.g gVar, List<? extends w> list) {
        this(jVar, str, gVar, list, (List<g>) null);
    }

    private g(j jVar, String str, androidx.work.g gVar, List<? extends w> list, List<g> list2) {
        this.f5341a = jVar;
        this.f5342b = str;
        this.f5343c = gVar;
        this.f5344d = list;
        this.f5346f = list2;
        this.f5345e = new ArrayList(this.f5344d.size());
        this.f5348i = new ArrayList();
        if (list2 != null) {
            for (g gVar2 : list2) {
                this.f5348i.addAll(gVar2.f5348i);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String uuid = ((w) list.get(i2)).f5516a.toString();
            this.f5345e.add(uuid);
            this.f5348i.add(uuid);
        }
    }

    public final t a(List<n> list) {
        if (list.isEmpty()) {
            return this;
        }
        return new g(this.f5341a, this.f5342b, androidx.work.g.KEEP, list, Collections.singletonList(this));
    }

    public final o a() {
        if (!this.f5347g) {
            b bVar = new b(this);
            this.f5341a.f5362d.a(bVar);
            this.j = bVar.f5434a;
        } else {
            l.a();
            String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.f5345e)});
        }
        return this.j;
    }

    public static Set<String> a(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f5346f;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f5345e);
            }
        }
        return hashSet;
    }

    public static boolean a(g gVar, Set<String> set) {
        set.addAll(gVar.f5345e);
        Set<String> a2 = a(gVar);
        for (String contains : set) {
            if (a2.contains(contains)) {
                return true;
            }
        }
        List<g> list = gVar.f5346f;
        if (list != null && !list.isEmpty()) {
            for (g a3 : list) {
                if (a(a3, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f5345e);
        return false;
    }
}
