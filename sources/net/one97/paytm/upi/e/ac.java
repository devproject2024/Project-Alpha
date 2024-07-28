package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f66737a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66738b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f66739c;

    /* renamed from: d  reason: collision with root package name */
    public final View f66740d;

    private ac(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, View view) {
        this.f66737a = constraintLayout;
        this.f66738b = textView;
        this.f66739c = imageView;
        this.f66740d = view;
    }

    public final ConstraintLayout a() {
        return this.f66737a;
    }

    public static ac a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.accountChange);
        if (textView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.arrow);
            if (imageView != null) {
                View findViewById = view.findViewById(R.id.separator);
                if (findViewById != null) {
                    return new ac((ConstraintLayout) view, textView, imageView, findViewById);
                }
                str = "separator";
            } else {
                str = "arrow";
            }
        } else {
            str = "accountChange";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
