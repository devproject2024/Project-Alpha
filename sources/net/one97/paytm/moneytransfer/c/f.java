package net.one97.paytm.moneytransfer.c;

import android.view.View;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final View f53738a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53739b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53740c;

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatRadioButton f53741d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f53742e;

    private f(ConstraintLayout constraintLayout, View view, View view2, View view3, AppCompatRadioButton appCompatRadioButton) {
        this.f53742e = constraintLayout;
        this.f53738a = view;
        this.f53739b = view2;
        this.f53740c = view3;
        this.f53741d = appCompatRadioButton;
    }

    public static f a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.circle);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.view_1);
            if (findViewById2 != null) {
                View findViewById3 = view.findViewById(R.id.view_2);
                if (findViewById3 != null) {
                    AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) view.findViewById(R.id.view_7);
                    if (appCompatRadioButton != null) {
                        return new f((ConstraintLayout) view, findViewById, findViewById2, findViewById3, appCompatRadioButton);
                    }
                    str = "view7";
                } else {
                    str = "view2";
                }
            } else {
                str = "view1";
            }
        } else {
            str = "circle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
