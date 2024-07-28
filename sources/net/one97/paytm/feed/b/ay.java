package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.feed.repository.models.polls.Polls;
import net.one97.paytm.feed.ui.feed.i.a;
import net.one97.paytm.feed.ui.feed.i.c;
import net.one97.paytm.feed.utility.RoundCornersImageView;

public abstract class ay extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33903a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f33904b;

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f33905c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33906d;

    /* renamed from: e  reason: collision with root package name */
    public final ProgressBar f33907e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33908f;

    /* renamed from: g  reason: collision with root package name */
    public final RadioButton f33909g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f33910h;

    /* renamed from: i  reason: collision with root package name */
    public final ProgressBar f33911i;
    public final TextView j;
    public final RadioButton k;
    public final TextView l;
    public final ProgressBar m;
    public final TextView n;
    public final RadioButton o;
    public final TextView p;
    public final ProgressBar q;
    public final TextView r;
    public final RadioGroup s;
    public final RoundCornersImageView t;
    public final TextView u;
    protected Polls v;
    protected Integer w;
    protected String x;
    protected c y;
    protected a z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ay(Object obj, View view, TextView textView, TextView textView2, RadioButton radioButton, TextView textView3, ProgressBar progressBar, TextView textView4, RadioButton radioButton2, TextView textView5, ProgressBar progressBar2, TextView textView6, RadioButton radioButton3, TextView textView7, ProgressBar progressBar3, TextView textView8, RadioButton radioButton4, TextView textView9, ProgressBar progressBar4, TextView textView10, RadioGroup radioGroup, RoundCornersImageView roundCornersImageView, TextView textView11) {
        super(obj, view, 1);
        Object obj2 = obj;
        View view2 = view;
        this.f33903a = textView;
        this.f33904b = textView2;
        this.f33905c = radioButton;
        this.f33906d = textView3;
        this.f33907e = progressBar;
        this.f33908f = textView4;
        this.f33909g = radioButton2;
        this.f33910h = textView5;
        this.f33911i = progressBar2;
        this.j = textView6;
        this.k = radioButton3;
        this.l = textView7;
        this.m = progressBar3;
        this.n = textView8;
        this.o = radioButton4;
        this.p = textView9;
        this.q = progressBar4;
        this.r = textView10;
        this.s = radioGroup;
        this.t = roundCornersImageView;
        this.u = textView11;
    }
}
