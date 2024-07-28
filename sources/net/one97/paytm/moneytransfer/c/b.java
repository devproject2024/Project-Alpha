package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53708a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53709b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53710c;

    /* renamed from: d  reason: collision with root package name */
    public final CircularImageView f53711d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53712e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53713f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53714g;

    /* renamed from: h  reason: collision with root package name */
    public final View f53715h;

    /* renamed from: i  reason: collision with root package name */
    public final View f53716i;
    public final LottieAnimationView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final View n;
    private final ConstraintLayout o;

    private b(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, CircularImageView circularImageView, TextView textView3, TextView textView4, TextView textView5, View view, View view2, LottieAnimationView lottieAnimationView, TextView textView6, TextView textView7, TextView textView8, View view3) {
        this.o = constraintLayout;
        this.f53708a = imageView;
        this.f53709b = textView;
        this.f53710c = textView2;
        this.f53711d = circularImageView;
        this.f53712e = textView3;
        this.f53713f = textView4;
        this.f53714g = textView5;
        this.f53715h = view;
        this.f53716i = view2;
        this.j = lottieAnimationView;
        this.k = textView6;
        this.l = textView7;
        this.m = textView8;
        this.n = view3;
    }

    public final ConstraintLayout a() {
        return this.o;
    }

    public static b a(LayoutInflater layoutInflater) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.activity_account_settings, (ViewGroup) null, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.backButton);
        if (imageView != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.balanceTextView);
            if (textView != null) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.bankIfsc);
                if (textView2 != null) {
                    CircularImageView circularImageView = (CircularImageView) inflate.findViewById(R.id.bankImage);
                    if (circularImageView != null) {
                        TextView textView3 = (TextView) inflate.findViewById(R.id.bankName);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) inflate.findViewById(R.id.checkBalanceButton);
                            if (textView4 != null) {
                                TextView textView5 = (TextView) inflate.findViewById(R.id.createNewPin);
                                if (textView5 != null) {
                                    View findViewById = inflate.findViewById(R.id.divider1);
                                    if (findViewById != null) {
                                        View findViewById2 = inflate.findViewById(R.id.divider2);
                                        if (findViewById2 != null) {
                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lottieLoader);
                                            if (lottieAnimationView != null) {
                                                TextView textView6 = (TextView) inflate.findViewById(R.id.needHelp);
                                                if (textView6 != null) {
                                                    TextView textView7 = (TextView) inflate.findViewById(R.id.removeBank);
                                                    if (textView7 != null) {
                                                        TextView textView8 = (TextView) inflate.findViewById(R.id.userFullName);
                                                        if (textView8 != null) {
                                                            View findViewById3 = inflate.findViewById(R.id.whiteBackground);
                                                            if (findViewById3 != null) {
                                                                return new b((ConstraintLayout) inflate, imageView, textView, textView2, circularImageView, textView3, textView4, textView5, findViewById, findViewById2, lottieAnimationView, textView6, textView7, textView8, findViewById3);
                                                            }
                                                            str = "whiteBackground";
                                                        } else {
                                                            str = "userFullName";
                                                        }
                                                    } else {
                                                        str = "removeBank";
                                                    }
                                                } else {
                                                    str = "needHelp";
                                                }
                                            } else {
                                                str = "lottieLoader";
                                            }
                                        } else {
                                            str = "divider2";
                                        }
                                    } else {
                                        str = "divider1";
                                    }
                                } else {
                                    str = "createNewPin";
                                }
                            } else {
                                str = "checkBalanceButton";
                            }
                        } else {
                            str = "bankName";
                        }
                    } else {
                        str = "bankImage";
                    }
                } else {
                    str = "bankIfsc";
                }
            } else {
                str = "balanceTextView";
            }
        } else {
            str = "backButton";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
