package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f53863a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53864b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53865c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f53866d;

    private w(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.f53866d = constraintLayout;
        this.f53863a = constraintLayout2;
        this.f53864b = textView;
        this.f53865c = textView2;
    }

    public final ConstraintLayout a() {
        return this.f53866d;
    }

    public static w a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.addBank);
        if (constraintLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.link_another_tv);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.plusTV);
                if (textView2 != null) {
                    return new w((ConstraintLayout) view, constraintLayout, textView, textView2);
                }
                str = "plusTV";
            } else {
                str = "linkAnotherTv";
            }
        } else {
            str = "addBank";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
