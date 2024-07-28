package net.one97.paytm.recharge.common.a;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import androidx.viewpager.widget.ViewPager;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.common.fragment.q;
import net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8;

public final class d extends m {

    /* renamed from: a  reason: collision with root package name */
    public List<CJRBowsePlanGroupingListV8> f60486a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, String> f60487b;

    /* renamed from: c  reason: collision with root package name */
    private final j f60488c;

    /* renamed from: d  reason: collision with root package name */
    private final List<CJRBowsePlanGroupingListV8> f60489d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f60490e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(j jVar, List<? extends CJRBowsePlanGroupingListV8> list, ViewPager viewPager) {
        super(jVar);
        k.c(jVar, "fm");
        k.c(viewPager, "viewpager");
        this.f60488c = jVar;
        this.f60489d = list;
        this.f60490e = viewPager;
        List<CJRBowsePlanGroupingListV8> list2 = this.f60489d;
        if (list2 != null) {
            this.f60486a.addAll(list2);
        }
        this.f60487b = new HashMap<>();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "container");
        Object instantiateItem = super.instantiateItem(viewGroup, i2);
        k.a(instantiateItem, "super.instantiateItem(container, position)");
        if (instantiateItem instanceof Fragment) {
            String tag = ((Fragment) instantiateItem).getTag();
            HashMap<Integer, String> hashMap = this.f60487b;
            if (hashMap != null) {
                Integer valueOf = Integer.valueOf(i2);
                if (tag == null) {
                    k.a();
                }
                hashMap.put(valueOf, tag);
            }
        }
        return instantiateItem;
    }

    public final Fragment getItem(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
        q qVar = new q();
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8 = this.f60486a.get(i2);
        k.c(cJRBowsePlanGroupingListV8, "groupingList");
        qVar.f61376c = cJRBowsePlanGroupingListV8;
        qVar.setArguments(bundle);
        return qVar;
    }

    public final Fragment a() {
        String str;
        HashMap<Integer, String> hashMap = this.f60487b;
        if (hashMap != null && hashMap.size() == 0) {
            return null;
        }
        HashMap<Integer, String> hashMap2 = this.f60487b;
        if (hashMap2 == null || (str = hashMap2.get(0)) == null) {
            Object instantiateItem = instantiateItem(this.f60490e, 0);
            if (instantiateItem != null) {
                return (Fragment) instantiateItem;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }
        k.a((Object) str, "mFragmentTags?.get(posit…er, position) as Fragment");
        j jVar = this.f60488c;
        if (jVar != null) {
            return jVar.c(str);
        }
        return null;
    }

    public final int getCount() {
        List<CJRBowsePlanGroupingListV8> list = this.f60486a;
        return (list != null ? Integer.valueOf(list.size()) : null).intValue();
    }

    public final CharSequence getPageTitle(int i2) {
        String name = this.f60486a.get(i2).getName();
        return name != null ? name : "";
    }
}
