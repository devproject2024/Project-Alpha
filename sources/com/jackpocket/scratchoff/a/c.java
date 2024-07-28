package com.jackpocket.scratchoff.a;

import android.graphics.Path;
import com.jackpocket.scratchoff.a.d;
import com.jackpocket.scratchoff.b;
import java.util.ArrayList;
import java.util.List;

public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    com.jackpocket.scratchoff.c f40777a;

    /* renamed from: c  reason: collision with root package name */
    public List<Path> f40778c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public int[] f40779d = {0, 0};

    /* renamed from: e  reason: collision with root package name */
    private d f40780e;

    /* renamed from: f  reason: collision with root package name */
    private a f40781f;

    public c(com.jackpocket.scratchoff.c cVar) {
        this.f40777a = cVar;
        this.f40780e = new d(cVar);
        this.f40781f = new a(cVar);
    }

    public final void a(d.a aVar) {
        this.f40780e.f40785c = aVar;
    }

    public final void b() {
        d dVar = this.f40780e;
        if (dVar != null) {
            dVar.b();
        }
        a aVar = this.f40781f;
        if (aVar != null) {
            aVar.b();
        }
        super.b();
    }

    public final void c() {
        d dVar = this.f40780e;
        if (dVar != null) {
            dVar.c();
        }
        a aVar = this.f40781f;
        if (aVar != null) {
            aVar.c();
        }
        super.c();
    }

    /* access modifiers changed from: protected */
    public final void a() throws Exception {
        while (this.f40776b && this.f40777a.e()) {
            final List<Path> list = this.f40778c;
            this.f40778c = new ArrayList();
            if (list.size() > 0) {
                this.f40777a.b(new Runnable() {
                    public final void run() {
                        com.jackpocket.scratchoff.c cVar = c.this.f40777a;
                        List<Path> list = list;
                        if (cVar.f40808a != null) {
                            b bVar = cVar.f40808a;
                            if (bVar.f40797c != null) {
                                synchronized (bVar.f40797c) {
                                    for (Path drawPath : list) {
                                        bVar.f40796b.drawPath(drawPath, bVar.f40799e);
                                    }
                                }
                            }
                        }
                    }
                });
                a aVar = this.f40781f;
                synchronized (aVar.f40773a) {
                    aVar.f40773a.addAll(list);
                }
                this.f40780e.a(list);
            }
            Thread.sleep(10);
        }
    }
}
