package com.travel.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

public abstract class aa extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f22830a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f22831b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22832c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f22833d;

    /* renamed from: e  reason: collision with root package name */
    public final View f22834e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f22835f;

    protected aa(Object obj, View view, ImageView imageView, FrameLayout frameLayout, TextView textView, RelativeLayout relativeLayout, View view2, Toolbar toolbar) {
        super(obj, view, 0);
        this.f22830a = imageView;
        this.f22831b = frameLayout;
        this.f22832c = textView;
        this.f22833d = relativeLayout;
        this.f22834e = view2;
        this.f22835f = toolbar;
    }
}
