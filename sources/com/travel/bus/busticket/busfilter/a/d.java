package com.travel.bus.busticket.busfilter.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class d extends m {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f22049a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final Context f22050b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Fragment> f22051c = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, j jVar) {
        super(jVar);
        k.c(context, "context");
        k.c(jVar, "supportFragmentManager");
        this.f22050b = context;
    }

    public final Fragment getItem(int i2) {
        Fragment fragment = this.f22051c.get(i2);
        k.a((Object) fragment, "mFragmentList[position]");
        return fragment;
    }

    public final int getCount() {
        return this.f22051c.size();
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f22049a.get(i2);
    }

    public final void a(Fragment fragment, Bundle bundle, String str) {
        k.c(fragment, "fragment");
        k.c(bundle, "bundle");
        k.c(str, "title");
        fragment.setArguments(bundle);
        this.f22051c.add(fragment);
        this.f22049a.add(str);
    }
}
