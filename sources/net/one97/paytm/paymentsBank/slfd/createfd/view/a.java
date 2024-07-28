package net.one97.paytm.paymentsBank.slfd.createfd.view;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paymentsBank.slfd.common.view.e;

public final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<Fragment> f19119a = new SparseArray<>();

    public final int getCount() {
        return 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(j jVar) {
        super(jVar);
        k.c(jVar, "fm");
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "container");
        Object instantiateItem = super.instantiateItem(viewGroup, i2);
        if (instantiateItem != null) {
            Fragment fragment = (Fragment) instantiateItem;
            this.f19119a.put(i2, fragment);
            return fragment;
        }
        throw new u("null cannot be cast to non-null type androidx.fragment.app.Fragment");
    }

    public final Fragment getItem(int i2) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putString("slfd_status", "active,pending");
        eVar.setArguments(bundle);
        return eVar;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "object");
        this.f19119a.remove(i2);
        super.destroyItem(viewGroup, i2, obj);
    }

    public final Fragment a() {
        return this.f19119a.get(0);
    }
}
