package net.one97.paytm.iocl.a;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import net.one97.paytm.transport.iocl.c.d;

public abstract class o extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f14145a;

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatEditText f14146b;

    /* renamed from: c  reason: collision with root package name */
    public final AppCompatEditText f14147c;

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatEditText f14148d;

    /* renamed from: e  reason: collision with root package name */
    public final AppCompatEditText f14149e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f14150f;

    /* renamed from: g  reason: collision with root package name */
    public final CoordinatorLayout f14151g;

    /* renamed from: h  reason: collision with root package name */
    public final ProgressBar f14152h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f14153i;
    public final TextView j;
    public final TextInputLayout k;
    public final TextView l;
    public final TextInputLayout m;
    public final TextView n;
    public final TextInputLayout o;
    public final TextView p;
    public final TextInputLayout q;
    protected d r;

    public abstract void a(d dVar);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected o(Object obj, View view, Button button, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, AppCompatEditText appCompatEditText4, ImageView imageView, CoordinatorLayout coordinatorLayout, ProgressBar progressBar, RelativeLayout relativeLayout, TextView textView, TextInputLayout textInputLayout, TextView textView2, TextInputLayout textInputLayout2, TextView textView3, TextInputLayout textInputLayout3, TextView textView4, TextInputLayout textInputLayout4) {
        super(obj, view, 13);
        Object obj2 = obj;
        View view2 = view;
        this.f14145a = button;
        this.f14146b = appCompatEditText;
        this.f14147c = appCompatEditText2;
        this.f14148d = appCompatEditText3;
        this.f14149e = appCompatEditText4;
        this.f14150f = imageView;
        this.f14151g = coordinatorLayout;
        this.f14152h = progressBar;
        this.f14153i = relativeLayout;
        this.j = textView;
        this.k = textInputLayout;
        this.l = textView2;
        this.m = textInputLayout2;
        this.n = textView3;
        this.o = textInputLayout3;
        this.p = textView4;
        this.q = textInputLayout4;
    }
}
