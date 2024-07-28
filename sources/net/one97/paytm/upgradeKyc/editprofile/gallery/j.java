package net.one97.paytm.upgradeKyc.editprofile.gallery;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.b.d;

public final class j extends ai {
    public final LiveData<b<x>> A = c.a(this.z);
    final y<x> B = new y<>();
    public final LiveData<b<x>> C = c.a(this.B);
    private final y<String> D = new y<>();

    /* renamed from: a  reason: collision with root package name */
    final Context f65883a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<GalleryData> f65884b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<GalleryData> f65885c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    final y<ArrayList<GalleryData>> f65886d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    final LiveData<b<ArrayList<GalleryData>>> f65887e = c.a(this.f65886d);

    /* renamed from: f  reason: collision with root package name */
    final y<String> f65888f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    final LiveData<b<String>> f65889g = c.a(this.f65888f);

    /* renamed from: h  reason: collision with root package name */
    final ArrayList<g> f65890h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    final y<ArrayList<g>> f65891i = new y<>();
    final LiveData<b<ArrayList<g>>> j = c.a(this.f65891i);
    final y<Uri> k = new y<>();
    public final LiveData<b<Uri>> l = c.a(this.k);
    final y<x> m = new y<>();
    public final LiveData<b<x>> n = c.a(this.m);
    public String o;
    final y<x> p = new y<>();
    public final LiveData<b<x>> q = c.a(this.p);
    final y<x> r = new y<>();
    public final LiveData<b<x>> s = c.a(this.r);
    public final y<x> t = new y<>();
    public final LiveData<b<x>> u = c.a(this.t);
    final y<x> v = new y<>();
    public final LiveData<b<x>> w = c.a(this.v);
    final y<x> x = new y<>();
    public final LiveData<b<x>> y = c.a(this.x);
    final y<x> z = new y<>();

    public j() {
        net.one97.paytm.common.b.a b2 = d.b();
        k.a((Object) b2, "HomeHelper.getAppLaunchModuleInterface()");
        this.f65883a = b2.a();
    }

    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(((g) t).f65865b, ((g) t2).f65865b);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ArrayList<g> arrayList) {
        kotlin.a.k.a(arrayList, new a());
        Iterator<g> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.f65890h.add(it2.next());
        }
        this.f65890h.add(0, new g("All Photos", (String) null, this.f65884b, 4));
    }
}
