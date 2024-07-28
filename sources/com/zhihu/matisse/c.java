package com.zhihu.matisse;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.zhihu.matisse.c.a;
import com.zhihu.matisse.ui.MatisseActivity;
import java.util.ArrayList;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final com.zhihu.matisse.internal.entity.c f45721a = com.zhihu.matisse.internal.entity.c.a();

    /* renamed from: b  reason: collision with root package name */
    private final a f45722b;

    c(a aVar, Set<b> set, boolean z) {
        this.f45722b = aVar;
        com.zhihu.matisse.internal.entity.c cVar = this.f45721a;
        cVar.f45778a = set;
        cVar.f45779b = z;
        cVar.f45782e = -1;
    }

    public final c a() {
        this.f45721a.f45780c = true;
        return this;
    }

    public final c a(boolean z) {
        this.f45721a.f45783f = z;
        return this;
    }

    public final c a(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSelectable must be greater than or equal to one");
        } else if (this.f45721a.f45785h > 0 || this.f45721a.f45786i > 0) {
            throw new IllegalStateException("already set maxImageSelectable and maxVideoSelectable");
        } else {
            this.f45721a.f45784g = i2;
            return this;
        }
    }

    public final c a(a aVar) {
        if (this.f45721a.j == null) {
            this.f45721a.j = new ArrayList();
        }
        this.f45721a.j.add(aVar);
        return this;
    }

    public final c b() {
        this.f45721a.s = false;
        return this;
    }

    public final c c() {
        this.f45721a.t = false;
        return this;
    }

    public final c d() {
        this.f45721a.u = 10;
        return this;
    }

    public final c b(int i2) {
        this.f45721a.n = i2;
        return this;
    }

    public final c a(com.zhihu.matisse.b.a aVar) {
        this.f45721a.p = aVar;
        return this;
    }

    public final void c(int i2) {
        Activity a2 = this.f45722b.a();
        if (a2 != null) {
            Intent intent = new Intent(a2, MatisseActivity.class);
            Fragment b2 = this.f45722b.b();
            if (b2 != null) {
                b2.startActivityForResult(intent, i2);
            } else {
                a2.startActivityForResult(intent, i2);
            }
        }
    }
}
