package net.one97.paytm.recharge.common.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.recharge.common.e.c;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.VERTICAL;

public final class t extends o {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, Fragment> f60681a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<Integer, String> f60682b;

    /* renamed from: c  reason: collision with root package name */
    private final Activity f60683c;

    /* renamed from: d  reason: collision with root package name */
    private final j f60684d;

    /* renamed from: e  reason: collision with root package name */
    private final List<CJRItem> f60685e;

    /* renamed from: f  reason: collision with root package name */
    private final c f60686f;

    /* renamed from: g  reason: collision with root package name */
    private final TabLayout f60687g;

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "object");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(Activity activity, j jVar, List<? extends CJRItem> list, c cVar, TabLayout tabLayout) {
        super(jVar);
        k.c(activity, "context");
        k.c(jVar, "fragmentManager");
        k.c(list, "tabsList");
        k.c(cVar, "fragmentHelper");
        k.c(tabLayout, "tabLayout");
        this.f60683c = activity;
        this.f60684d = jVar;
        this.f60685e = list;
        this.f60686f = cVar;
        this.f60687g = tabLayout;
    }

    public final Fragment getItem(int i2) {
        q.d("getItem " + getPageTitle(i2));
        Fragment a2 = this.f60686f.a(Boolean.TRUE, this.f60685e.get(i2));
        Integer valueOf = Integer.valueOf(i2);
        k.a((Object) a2, "fragment");
        this.f60681a.put(valueOf, a2);
        HashMap<Integer, String> hashMap = this.f60682b;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(i2), a2.getTag());
        }
        if (this.f60687g.getSelectedTabPosition() == i2) {
            d dVar = d.f64967a;
            CJRRechargeErrorModel b2 = d.b();
            b2.clear();
            b2.setVerticalName(VERTICAL.UTILITIES);
            b2.setCategoryId(this.f60685e.get(i2).getCategoryId());
            CharSequence pageTitle = getPageTitle(i2);
            b2.setScreenName(pageTitle != null ? pageTitle.toString() : null);
            return a2;
        }
        net.one97.paytm.recharge.common.fragment.j jVar = new net.one97.paytm.recharge.common.fragment.j();
        Bundle bundle = new Bundle();
        bundle.putSerializable("fragment_position", Integer.valueOf(i2));
        jVar.setArguments(bundle);
        return jVar;
    }

    public final int getCount() {
        return this.f60685e.size();
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f60685e.get(i2).getName();
    }

    public final Fragment a(int i2) {
        String str;
        HashMap<Integer, String> hashMap = this.f60682b;
        if (hashMap == null || (str = hashMap.get(Integer.valueOf(i2))) == null) {
            return this.f60681a.get(Integer.valueOf(i2));
        }
        return this.f60684d.c(str);
    }
}
