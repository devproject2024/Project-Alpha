package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.SwipeRevealLayout;

public final class ak {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53668a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53669b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53670c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53671d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53672e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f53673f;

    /* renamed from: g  reason: collision with root package name */
    public final LottieAnimationView f53674g;

    /* renamed from: h  reason: collision with root package name */
    public final AppCompatRadioButton f53675h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f53676i;
    public final TextView j;
    public final SwipeRevealLayout k;
    private final SwipeRevealLayout l;

    private ak(SwipeRevealLayout swipeRevealLayout, TextView textView, ImageView imageView, View view, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, AppCompatRadioButton appCompatRadioButton, TextView textView4, TextView textView5, SwipeRevealLayout swipeRevealLayout2) {
        this.l = swipeRevealLayout;
        this.f53668a = textView;
        this.f53669b = imageView;
        this.f53670c = view;
        this.f53671d = textView2;
        this.f53672e = textView3;
        this.f53673f = constraintLayout;
        this.f53674g = lottieAnimationView;
        this.f53675h = appCompatRadioButton;
        this.f53676i = textView4;
        this.j = textView5;
        this.k = swipeRevealLayout2;
    }

    public final SwipeRevealLayout a() {
        return this.l;
    }

    public static ak a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.mt_v4_self_account_item_view, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.availableBalance);
        if (textView != null) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.bankImage);
            if (imageView != null) {
                View findViewById = inflate.findViewById(R.id.bankImageOutline);
                if (findViewById != null) {
                    TextView textView2 = (TextView) inflate.findViewById(R.id.bankName);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) inflate.findViewById(R.id.checkBalance);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.itemView);
                            if (constraintLayout != null) {
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lottieLoader);
                                if (lottieAnimationView != null) {
                                    AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) inflate.findViewById(R.id.selectBankRadio);
                                    if (appCompatRadioButton != null) {
                                        TextView textView4 = (TextView) inflate.findViewById(R.id.setMpin);
                                        if (textView4 != null) {
                                            TextView textView5 = (TextView) inflate.findViewById(R.id.settings);
                                            if (textView5 != null) {
                                                SwipeRevealLayout swipeRevealLayout = (SwipeRevealLayout) inflate.findViewById(R.id.swipe_layout);
                                                if (swipeRevealLayout != null) {
                                                    return new ak((SwipeRevealLayout) inflate, textView, imageView, findViewById, textView2, textView3, constraintLayout, lottieAnimationView, appCompatRadioButton, textView4, textView5, swipeRevealLayout);
                                                }
                                                str = "swipeLayout";
                                            } else {
                                                str = "settings";
                                            }
                                        } else {
                                            str = "setMpin";
                                        }
                                    } else {
                                        str = "selectBankRadio";
                                    }
                                } else {
                                    str = "lottieLoader";
                                }
                            } else {
                                str = "itemView";
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
            str = "availableBalance";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
