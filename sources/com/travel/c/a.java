package com.travel.c;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f22826a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22827b;

    /* renamed from: c  reason: collision with root package name */
    public final TabLayout f22828c;

    /* renamed from: d  reason: collision with root package name */
    protected com.travel.booking.e.a f22829d;

    public abstract void a(com.travel.booking.e.a aVar);

    protected a(Object obj, View view, ImageView imageView, ImageView imageView2, TabLayout tabLayout) {
        super(obj, view, 1);
        this.f22826a = imageView;
        this.f22827b = imageView2;
        this.f22828c = tabLayout;
    }
}
