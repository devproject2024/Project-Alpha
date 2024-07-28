package com.paytmmall.artifact.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f15393a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f15394b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15395c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f15396d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f15397e;

    /* renamed from: f  reason: collision with root package name */
    public final View f15398f;

    /* renamed from: g  reason: collision with root package name */
    public final View f15399g;

    /* renamed from: h  reason: collision with root package name */
    protected com.paytmmall.artifact.clp.a.a f15400h;

    /* renamed from: i  reason: collision with root package name */
    protected com.paytmmall.artifact.clp.b.a f15401i;

    public abstract void a(com.paytmmall.artifact.clp.a.a aVar);

    protected a(Object obj, View view, View view2, FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, RecyclerView recyclerView, View view3, View view4) {
        super(obj, view, 0);
        this.f15393a = view2;
        this.f15394b = frameLayout;
        this.f15395c = imageView;
        this.f15396d = progressBar;
        this.f15397e = recyclerView;
        this.f15398f = view3;
        this.f15399g = view4;
    }
}
