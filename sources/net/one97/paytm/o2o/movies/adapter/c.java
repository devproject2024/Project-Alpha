package net.one97.paytm.o2o.movies.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.fragment.d;

public final class c extends m {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f74584a;

    /* renamed from: b  reason: collision with root package name */
    private final b f74585b;

    /* renamed from: c  reason: collision with root package name */
    private final a f74586c;

    public interface a {
        void setFragment(Fragment fragment);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(j jVar, List<String> list, b bVar, a aVar) {
        super(jVar);
        k.c(jVar, "fm");
        k.c(list, "items");
        k.c(bVar, "mModel");
        k.c(aVar, "mListener");
        this.f74584a = list;
        this.f74585b = bVar;
        this.f74586c = aVar;
    }

    public final Fragment getItem(int i2) {
        Fragment fragment;
        if (i2 == 0) {
            fragment = d.a(this.f74585b.f74523a, this.f74585b.f74524b, this.f74585b.f74525c, this.f74585b.f74526d, this.f74585b.f74527e, this.f74585b.f74529g, this.f74585b.f74530h, this.f74585b.f74528f);
        } else if (i2 != 1) {
            fragment = null;
        } else {
            fragment = net.one97.paytm.o2o.movies.fragment.a.a(this.f74585b.f74525c, this.f74585b.f74531i, this.f74585b.f74524b, this.f74585b.f74527e);
        }
        a aVar = this.f74586c;
        if (fragment == null) {
            k.a();
        }
        aVar.setFragment(fragment);
        return fragment;
    }

    public final int getCount() {
        return this.f74584a.size();
    }
}
