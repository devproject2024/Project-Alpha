package com.travel.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.e.a;

public abstract class w extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f22950a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f22951b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f22952c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22953d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22954e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22955f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22956g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22957h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22958i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    protected BookingInfo n;
    protected a o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected w(Object obj, View view, CardView cardView, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view2 = view;
        this.f22950a = cardView;
        this.f22951b = textView;
        this.f22952c = constraintLayout;
        this.f22953d = textView2;
        this.f22954e = imageView;
        this.f22955f = textView3;
        this.f22956g = textView4;
        this.f22957h = textView5;
        this.f22958i = textView6;
        this.j = textView7;
        this.k = textView8;
        this.l = textView9;
        this.m = textView10;
    }
}
