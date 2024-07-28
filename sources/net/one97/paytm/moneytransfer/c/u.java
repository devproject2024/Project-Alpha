package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.moneytransfer.R;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53845a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53846b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53847c;

    /* renamed from: d  reason: collision with root package name */
    public final LottieAnimationView f53848d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53849e;

    /* renamed from: f  reason: collision with root package name */
    public final View f53850f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f53851g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f53852h;

    /* renamed from: i  reason: collision with root package name */
    private final FrameLayout f53853i;

    private u(FrameLayout frameLayout, TextView textView, View view, TextView textView2, LottieAnimationView lottieAnimationView, TextView textView3, View view2, ImageView imageView, TextView textView4) {
        this.f53853i = frameLayout;
        this.f53845a = textView;
        this.f53846b = view;
        this.f53847c = textView2;
        this.f53848d = lottieAnimationView;
        this.f53849e = textView3;
        this.f53850f = view2;
        this.f53851g = imageView;
        this.f53852h = textView4;
    }

    public static u a(View view) {
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
                            View findViewById2 = view.findViewById(R.id.paymentCardBackground);
                            if (findViewById2 != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.paymentStatusImageView);
                                if (imageView != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.paymentStatusTextView);
                                    if (textView4 != null) {
                                        return new u((FrameLayout) view, textView, findViewById, textView2, lottieAnimationView, textView3, findViewById2, imageView, textView4);
                                    }
                                    str = "paymentStatusTextView";
                                } else {
                                    str = "paymentStatusImageView";
                                }
                            } else {
                                str = "paymentCardBackground";
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
