package com.jackpocket.scratchoff.a;

import android.graphics.Path;
import com.jackpocket.scratchoff.c;
import java.util.ArrayList;
import java.util.List;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    List<Path> f40773a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private c f40774c;

    public a(c cVar) {
        this.f40774c = cVar;
    }

    /* access modifiers changed from: protected */
    public final void a() throws Exception {
        while (this.f40776b && this.f40774c.e()) {
            synchronized (this.f40773a) {
                if (this.f40773a.size() > 0) {
                    this.f40774c.b().postInvalidate();
                }
                this.f40773a.clear();
            }
            Thread.sleep(15);
        }
    }
}
