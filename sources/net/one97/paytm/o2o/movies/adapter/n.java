package net.one97.paytm.o2o.movies.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.List;
import kotlin.g.b.k;

public final class n extends m {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f74685a;

    /* renamed from: b  reason: collision with root package name */
    private final m f74686b;

    /* renamed from: c  reason: collision with root package name */
    private final a f74687c;

    /* renamed from: d  reason: collision with root package name */
    private final String f74688d;

    public interface a {
        void setFragment(Fragment fragment);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(j jVar, List<String> list, m mVar, a aVar, String str) {
        super(jVar);
        k.c(jVar, "fm");
        k.c(list, "items");
        k.c(mVar, "mModel");
        k.c(aVar, "mListener");
        this.f74685a = list;
        this.f74686b = mVar;
        this.f74687c = aVar;
        this.f74688d = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: net.one97.paytm.o2o.movies.fragment.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: net.one97.paytm.o2o.movies.fragment.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: net.one97.paytm.o2o.movies.fragment.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: net.one97.paytm.o2o.movies.fragment.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: net.one97.paytm.o2o.movies.fragment.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: net.one97.paytm.o2o.movies.fragment.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: net.one97.paytm.o2o.movies.fragment.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.fragment.app.Fragment getItem(int r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x0041
            r1 = 1
            if (r11 == r1) goto L_0x0028
            r1 = 2
            if (r11 == r1) goto L_0x000a
            goto L_0x006f
        L_0x000a:
            java.lang.String r11 = r10.f74688d
            if (r11 == 0) goto L_0x0025
            net.one97.paytm.o2o.movies.fragment.e$a r0 = net.one97.paytm.o2o.movies.fragment.e.f75289a
            java.lang.String r0 = "movieCode"
            kotlin.g.b.k.c(r11, r0)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r1.putString(r0, r11)
            net.one97.paytm.o2o.movies.fragment.e r0 = new net.one97.paytm.o2o.movies.fragment.e
            r0.<init>()
            r0.setArguments(r1)
        L_0x0025:
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            goto L_0x006f
        L_0x0028:
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r11 = r11.f74679d
            if (r11 == 0) goto L_0x003e
            net.one97.paytm.o2o.movies.adapter.m r0 = r10.f74686b
            java.lang.String r0 = r0.j
            net.one97.paytm.o2o.movies.adapter.m r1 = r10.f74686b
            java.lang.String r1 = r1.f74678c
            net.one97.paytm.o2o.movies.adapter.m r2 = r10.f74686b
            java.lang.String r2 = r2.f74681f
            net.one97.paytm.o2o.movies.fragment.a r0 = net.one97.paytm.o2o.movies.fragment.a.a((java.lang.String) r11, (java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x003e:
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            goto L_0x006f
        L_0x0041:
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r3 = r11.f74678c
            if (r3 == 0) goto L_0x006d
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r4 = r11.f74679d
            if (r4 == 0) goto L_0x006d
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r1 = r11.f74676a
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r2 = r11.f74677b
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r5 = r11.f74680e
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            boolean r6 = r11.f74683h
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            boolean r7 = r11.f74684i
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r8 = r11.f74682g
            net.one97.paytm.o2o.movies.adapter.m r11 = r10.f74686b
            java.lang.String r9 = r11.k
            net.one97.paytm.o2o.movies.fragment.i r0 = net.one97.paytm.o2o.movies.fragment.i.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x006d:
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
        L_0x006f:
            net.one97.paytm.o2o.movies.adapter.n$a r11 = r10.f74687c
            if (r0 != 0) goto L_0x0076
            kotlin.g.b.k.a()
        L_0x0076:
            r11.setFragment(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.n.getItem(int):androidx.fragment.app.Fragment");
    }

    public final int getCount() {
        return this.f74685a.size();
    }
}
