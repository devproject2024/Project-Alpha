package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66815a;

    /* renamed from: b  reason: collision with root package name */
    public final View f66816b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f66817c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66818d;

    /* renamed from: e  reason: collision with root package name */
    public final CircularImageView f66819e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f66820f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f66821g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66822h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66823i;
    public final TextView j;
    public final TextView k;
    private final ConstraintLayout l;

    private h(ConstraintLayout constraintLayout, TextView textView, View view, ImageView imageView, TextView textView2, CircularImageView circularImageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.l = constraintLayout;
        this.f66815a = textView;
        this.f66816b = view;
        this.f66817c = imageView;
        this.f66818d = textView2;
        this.f66819e = circularImageView;
        this.f66820f = textView3;
        this.f66821g = textView4;
        this.f66822h = textView5;
        this.f66823i = textView6;
        this.j = textView7;
        this.k = textView8;
    }

    public static h a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.amountTextView);
        if (textView != null) {
            View findViewById = view.findViewById(R.id.background);
            if (findViewById != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.crossImage);
                if (imageView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.declinePlaceholder);
                    if (textView2 != null) {
                        CircularImageView circularImageView = (CircularImageView) view.findViewById(R.id.logoImage);
                        if (circularImageView != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.nameInitials);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.payeeName);
                                if (textView4 != null) {
                                    TextView textView5 = (TextView) view.findViewById(R.id.payeeVpa);
                                    if (textView5 != null) {
                                        TextView textView6 = (TextView) view.findViewById(R.id.paymentTitle);
                                        if (textView6 != null) {
                                            TextView textView7 = (TextView) view.findViewById(R.id.proceedButton);
                                            if (textView7 != null) {
                                                TextView textView8 = (TextView) view.findViewById(R.id.validityText);
                                                if (textView8 != null) {
                                                    return new h((ConstraintLayout) view, textView, findViewById, imageView, textView2, circularImageView, textView3, textView4, textView5, textView6, textView7, textView8);
                                                }
                                                str = "validityText";
                                            } else {
                                                str = "proceedButton";
                                            }
                                        } else {
                                            str = "paymentTitle";
                                        }
                                    } else {
                                        str = "payeeVpa";
                                    }
                                } else {
                                    str = "payeeName";
                                }
                            } else {
                                str = "nameInitials";
                            }
                        } else {
                            str = "logoImage";
                        }
                    } else {
                        str = "declinePlaceholder";
                    }
                } else {
                    str = "crossImage";
                }
            } else {
                str = "background";
            }
        } else {
            str = "amountTextView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
