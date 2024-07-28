package net.one97.paytm.iocl.a;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import net.one97.paytm.transport.iocl_v1.c.d;

public abstract class q extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f14158a;

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatEditText f14159b;

    /* renamed from: c  reason: collision with root package name */
    public final AppCompatEditText f14160c;

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatEditText f14161d;

    /* renamed from: e  reason: collision with root package name */
    public final AppCompatEditText f14162e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f14163f;

    /* renamed from: g  reason: collision with root package name */
    public final CoordinatorLayout f14164g;

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f14165h;

    /* renamed from: i  reason: collision with root package name */
    public final TextInputLayout f14166i;
    public final TextView j;
    public final TextInputLayout k;
    public final TextInputLayout l;
    protected d m;

    public abstract void a(d dVar);

    protected q(Object obj, View view, Button button, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, AppCompatEditText appCompatEditText4, ImageView imageView, CoordinatorLayout coordinatorLayout, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextView textView, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4) {
        super(obj, view, 9);
        this.f14158a = button;
        this.f14159b = appCompatEditText;
        this.f14160c = appCompatEditText2;
        this.f14161d = appCompatEditText3;
        this.f14162e = appCompatEditText4;
        this.f14163f = imageView;
        this.f14164g = coordinatorLayout;
        this.f14165h = textInputLayout;
        this.f14166i = textInputLayout2;
        this.j = textView;
        this.k = textInputLayout3;
        this.l = textInputLayout4;
    }
}
