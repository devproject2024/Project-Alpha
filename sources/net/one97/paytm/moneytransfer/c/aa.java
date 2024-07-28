package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.SwipeRevealLayout;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53599a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53600b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f53601c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53602d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53603e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f53604f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53605g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f53606h;

    /* renamed from: i  reason: collision with root package name */
    public final ConstraintLayout f53607i;
    public final SwipeRevealLayout j;
    private final SwipeRevealLayout k;

    private aa(SwipeRevealLayout swipeRevealLayout, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, ImageView imageView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout, SwipeRevealLayout swipeRevealLayout2) {
        this.k = swipeRevealLayout;
        this.f53599a = imageView;
        this.f53600b = textView;
        this.f53601c = imageView2;
        this.f53602d = textView2;
        this.f53603e = textView3;
        this.f53604f = imageView3;
        this.f53605g = textView4;
        this.f53606h = textView5;
        this.f53607i = constraintLayout;
        this.j = swipeRevealLayout2;
    }

    public static aa a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.bank_logo);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.beneficiary_account_details);
            if (textView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.beneficiary_icon);
                if (imageView2 != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.beneficiary_initials);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.beneficiary_name);
                        if (textView3 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.beneficiary_rounded_bg);
                            if (imageView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.beneficiary_transaction_history);
                                if (textView4 != null) {
                                    TextView textView5 = (TextView) view.findViewById(R.id.history);
                                    if (textView5 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.root);
                                        if (constraintLayout != null) {
                                            SwipeRevealLayout swipeRevealLayout = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout);
                                            if (swipeRevealLayout != null) {
                                                return new aa((SwipeRevealLayout) view, imageView, textView, imageView2, textView2, textView3, imageView3, textView4, textView5, constraintLayout, swipeRevealLayout);
                                            }
                                            str = "swipeLayout";
                                        } else {
                                            str = "root";
                                        }
                                    } else {
                                        str = "history";
                                    }
                                } else {
                                    str = "beneficiaryTransactionHistory";
                                }
                            } else {
                                str = "beneficiaryRoundedBg";
                            }
                        } else {
                            str = "beneficiaryName";
                        }
                    } else {
                        str = "beneficiaryInitials";
                    }
                } else {
                    str = "beneficiaryIcon";
                }
            } else {
                str = "beneficiaryAccountDetails";
            }
        } else {
            str = "bankLogo";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
