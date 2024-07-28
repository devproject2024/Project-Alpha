package com.google.android.gms.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.b.a;

final class k implements a.C0120a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FrameLayout f8290a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ LayoutInflater f8291b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ViewGroup f8292c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f8293d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ a f8294e;

    k(a aVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8294e = aVar;
        this.f8290a = frameLayout;
        this.f8291b = layoutInflater;
        this.f8292c = viewGroup;
        this.f8293d = bundle;
    }

    public final int a() {
        return 2;
    }

    public final void b() {
        this.f8290a.removeAllViews();
        this.f8290a.addView(this.f8294e.f8274a.a(this.f8291b, this.f8292c, this.f8293d));
    }
}
