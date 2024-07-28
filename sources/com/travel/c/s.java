package com.travel.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.e.a;

public abstract class s extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f22932a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f22933b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22934c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22935d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22936e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22937f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22938g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22939h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22940i;
    public final TextView j;
    public final TextView k;
    public final Guideline l;
    public final ConstraintLayout m;
    public final ImageView n;
    protected BookingInfo o;
    protected a p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected s(Object obj, View view, CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, Guideline guideline, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view2 = view;
        this.f22932a = cardView;
        this.f22933b = textView;
        this.f22934c = textView2;
        this.f22935d = textView3;
        this.f22936e = textView4;
        this.f22937f = textView5;
        this.f22938g = textView6;
        this.f22939h = textView7;
        this.f22940i = textView8;
        this.j = textView9;
        this.k = textView10;
        this.l = guideline;
        this.m = constraintLayout;
        this.n = imageView;
    }
}
