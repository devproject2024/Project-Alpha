package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.e.ah;

public final class am {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53682a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f53683b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53684c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f53685d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53686e;

    /* renamed from: f  reason: collision with root package name */
    public final View f53687f;

    /* renamed from: g  reason: collision with root package name */
    public final View f53688g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f53689h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f53690i;
    public final ah j;
    public final ImageView k;
    public final ImageView l;
    public final ConstraintLayout m;
    public final TextView n;
    public final ImageView o;
    public final TextView p;
    public final TextView q;
    private final ConstraintLayout r;

    private am(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView2, TextView textView2, View view, View view2, TextView textView3, TextView textView4, ah ahVar, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout3, TextView textView5, ImageView imageView5, TextView textView6, TextView textView7) {
        this.r = constraintLayout;
        this.f53682a = imageView;
        this.f53683b = constraintLayout2;
        this.f53684c = textView;
        this.f53685d = imageView2;
        this.f53686e = textView2;
        this.f53687f = view;
        this.f53688g = view2;
        this.f53689h = textView3;
        this.f53690i = textView4;
        this.j = ahVar;
        this.k = imageView3;
        this.l = imageView4;
        this.m = constraintLayout3;
        this.n = textView5;
        this.o = imageView5;
        this.p = textView6;
        this.q = textView7;
    }

    public static am a(View view) {
        String str;
        View view2 = view;
        ImageView imageView = (ImageView) view2.findViewById(R.id.arrow_2);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.bank_container);
            if (constraintLayout != null) {
                TextView textView = (TextView) view2.findViewById(R.id.bank_heading);
                if (textView != null) {
                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.bank_icon);
                    if (imageView2 != null) {
                        TextView textView2 = (TextView) view2.findViewById(R.id.bank_text);
                        if (textView2 != null) {
                            View findViewById = view2.findViewById(R.id.divider);
                            if (findViewById != null) {
                                View findViewById2 = view2.findViewById(R.id.divider_2);
                                if (findViewById2 != null) {
                                    TextView textView3 = (TextView) view2.findViewById(R.id.fastest_text);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view2.findViewById(R.id.heading);
                                        if (textView4 != null) {
                                            View findViewById3 = view2.findViewById(R.id.invite);
                                            if (findViewById3 != null) {
                                                ah a2 = ah.a(findViewById3);
                                                ImageView imageView3 = (ImageView) view2.findViewById(R.id.iv_back);
                                                if (imageView3 != null) {
                                                    ImageView imageView4 = (ImageView) view2.findViewById(R.id.right_arrow_1);
                                                    if (imageView4 != null) {
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.wallet_container);
                                                        if (constraintLayout2 != null) {
                                                            TextView textView5 = (TextView) view2.findViewById(R.id.wallet_heading);
                                                            if (textView5 != null) {
                                                                ImageView imageView5 = (ImageView) view2.findViewById(R.id.wallet_icon);
                                                                if (imageView5 != null) {
                                                                    TextView textView6 = (TextView) view2.findViewById(R.id.wallet_text);
                                                                    if (textView6 != null) {
                                                                        TextView textView7 = (TextView) view2.findViewById(R.id.wallet_text_here_why);
                                                                        if (textView7 != null) {
                                                                            return new am((ConstraintLayout) view2, imageView, constraintLayout, textView, imageView2, textView2, findViewById, findViewById2, textView3, textView4, a2, imageView3, imageView4, constraintLayout2, textView5, imageView5, textView6, textView7);
                                                                        }
                                                                        str = "walletTextHereWhy";
                                                                    } else {
                                                                        str = "walletText";
                                                                    }
                                                                } else {
                                                                    str = "walletIcon";
                                                                }
                                                            } else {
                                                                str = "walletHeading";
                                                            }
                                                        } else {
                                                            str = "walletContainer";
                                                        }
                                                    } else {
                                                        str = "rightArrow1";
                                                    }
                                                } else {
                                                    str = "ivBack";
                                                }
                                            } else {
                                                str = "invite";
                                            }
                                        } else {
                                            str = "heading";
                                        }
                                    } else {
                                        str = "fastestText";
                                    }
                                } else {
                                    str = "divider2";
                                }
                            } else {
                                str = "divider";
                            }
                        } else {
                            str = "bankText";
                        }
                    } else {
                        str = "bankIcon";
                    }
                } else {
                    str = "bankHeading";
                }
            } else {
                str = "bankContainer";
            }
        } else {
            str = "arrow2";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
