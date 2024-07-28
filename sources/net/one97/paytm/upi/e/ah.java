package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import net.one97.paytm.upi.R;

public final class ah {

    /* renamed from: a  reason: collision with root package name */
    public final Guideline f66769a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66770b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f66771c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66772d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f66773e;

    private ah(ConstraintLayout constraintLayout, Guideline guideline, TextView textView, TextView textView2, TextView textView3) {
        this.f66773e = constraintLayout;
        this.f66769a = guideline;
        this.f66770b = textView;
        this.f66771c = textView2;
        this.f66772d = textView3;
    }

    public static ah a(View view) {
        String str;
        Guideline guideline = (Guideline) view.findViewById(R.id.guideline);
        if (guideline != null) {
            TextView textView = (TextView) view.findViewById(R.id.invite_header);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.invite_info);
                if (textView2 != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.invite_now);
                    if (textView3 != null) {
                        return new ah((ConstraintLayout) view, guideline, textView, textView2, textView3);
                    }
                    str = "inviteNow";
                } else {
                    str = "inviteInfo";
                }
            } else {
                str = "inviteHeader";
            }
        } else {
            str = "guideline";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
