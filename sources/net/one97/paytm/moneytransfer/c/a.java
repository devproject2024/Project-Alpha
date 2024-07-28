package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53589a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53590b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f53591c;

    /* renamed from: d  reason: collision with root package name */
    public final View f53592d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53593e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53594f;

    /* renamed from: g  reason: collision with root package name */
    public final LottieAnimationView f53595g;

    /* renamed from: h  reason: collision with root package name */
    public final CardView f53596h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f53597i;
    public final RadioButton j;
    public final ConstraintLayout k;
    public final TextView l;
    private final ConstraintLayout m;

    private a(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, View view, TextView textView3, TextView textView4, LottieAnimationView lottieAnimationView, CardView cardView, TextView textView5, RadioButton radioButton, ConstraintLayout constraintLayout2, TextView textView6) {
        this.m = constraintLayout;
        this.f53589a = textView;
        this.f53590b = textView2;
        this.f53591c = imageView;
        this.f53592d = view;
        this.f53593e = textView3;
        this.f53594f = textView4;
        this.f53595g = lottieAnimationView;
        this.f53596h = cardView;
        this.f53597i = textView5;
        this.j = radioButton;
        this.k = constraintLayout2;
        this.l = textView6;
    }

    public final ConstraintLayout a() {
        return this.m;
    }

    public static a a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.acc_and_bal_history_item_view, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.availableBalance);
        if (textView != null) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.bankAccNumber);
            if (textView2 != null) {
                ImageView imageView = (ImageView) inflate.findViewById(R.id.bankImage);
                if (imageView != null) {
                    View findViewById = inflate.findViewById(R.id.bankImageOutline);
                    if (findViewById != null) {
                        TextView textView3 = (TextView) inflate.findViewById(R.id.bankName);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) inflate.findViewById(R.id.checkBalance);
                            if (textView4 != null) {
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lottieLoader);
                                if (lottieAnimationView != null) {
                                    CardView cardView = (CardView) inflate.findViewById(R.id.primaryDotView);
                                    if (cardView != null) {
                                        TextView textView5 = (TextView) inflate.findViewById(R.id.primaryTextView);
                                        if (textView5 != null) {
                                            RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radioButton);
                                            if (radioButton != null) {
                                                ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.rootView);
                                                if (constraintLayout != null) {
                                                    TextView textView6 = (TextView) inflate.findViewById(R.id.setMpin);
                                                    if (textView6 != null) {
                                                        return new a((ConstraintLayout) inflate, textView, textView2, imageView, findViewById, textView3, textView4, lottieAnimationView, cardView, textView5, radioButton, constraintLayout, textView6);
                                                    }
                                                    str = "setMpin";
                                                } else {
                                                    str = "rootView";
                                                }
                                            } else {
                                                str = "radioButton";
                                            }
                                        } else {
                                            str = "primaryTextView";
                                        }
                                    } else {
                                        str = "primaryDotView";
                                    }
                                } else {
                                    str = "lottieLoader";
                                }
                            } else {
                                str = "checkBalance";
                            }
                        } else {
                            str = "bankName";
                        }
                    } else {
                        str = "bankImageOutline";
                    }
                } else {
                    str = "bankImage";
                }
            } else {
                str = "bankAccNumber";
            }
        } else {
            str = "availableBalance";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
