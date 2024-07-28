package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.moneytransfer.R;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53837a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53838b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53839c;

    /* renamed from: d  reason: collision with root package name */
    public final LottieAnimationView f53840d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53841e;

    /* renamed from: f  reason: collision with root package name */
    public final View f53842f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53843g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f53844h;

    private t(ConstraintLayout constraintLayout, TextView textView, View view, TextView textView2, LottieAnimationView lottieAnimationView, TextView textView3, View view2, TextView textView4) {
        this.f53844h = constraintLayout;
        this.f53837a = textView;
        this.f53838b = view;
        this.f53839c = textView2;
        this.f53840d = lottieAnimationView;
        this.f53841e = textView3;
        this.f53842f = view2;
        this.f53843g = textView4;
    }

    public static t a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.amountTextView);
        if (textView != null) {
            View findViewById = view.findViewById(R.id.blankView);
            if (findViewById != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.date);
                if (textView2 != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.lottieAnimationView);
                    if (lottieAnimationView != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.note);
                        if (textView3 != null) {
                            View findViewById2 = view.findViewById(R.id.receivedBackgroundView);
                            if (findViewById2 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.receivedTextView);
                                if (textView4 != null) {
                                    return new t((ConstraintLayout) view, textView, findViewById, textView2, lottieAnimationView, textView3, findViewById2, textView4);
                                }
                                str = "receivedTextView";
                            } else {
                                str = "receivedBackgroundView";
                            }
                        } else {
                            str = "note";
                        }
                    } else {
                        str = "lottieAnimationView";
                    }
                } else {
                    str = CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR;
                }
            } else {
                str = "blankView";
            }
        } else {
            str = "amountTextView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
