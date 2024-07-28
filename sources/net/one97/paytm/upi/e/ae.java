package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;

public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66744a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66745b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f66746c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f66747d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f66748e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f66749f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f66750g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66751h;

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f66752i;

    private ae(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4) {
        this.f66752i = constraintLayout;
        this.f66744a = textView;
        this.f66745b = textView2;
        this.f66746c = imageView;
        this.f66747d = imageView2;
        this.f66748e = constraintLayout2;
        this.f66749f = constraintLayout3;
        this.f66750g = textView3;
        this.f66751h = textView4;
    }

    public static ae a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.serviceProvider1);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.serviceProvider2);
            if (textView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.serviceProviderLogo1);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.serviceProviderLogo2);
                    if (imageView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.sim1);
                        if (constraintLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.sim2);
                            if (constraintLayout2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.simNumber1);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.simNumber2);
                                    if (textView4 != null) {
                                        return new ae((ConstraintLayout) view, textView, textView2, imageView, imageView2, constraintLayout, constraintLayout2, textView3, textView4);
                                    }
                                    str = "simNumber2";
                                } else {
                                    str = "simNumber1";
                                }
                            } else {
                                str = "sim2";
                            }
                        } else {
                            str = "sim1";
                        }
                    } else {
                        str = "serviceProviderLogo2";
                    }
                } else {
                    str = "serviceProviderLogo1";
                }
            } else {
                str = "serviceProvider2";
            }
        } else {
            str = "serviceProvider1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
