package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;

public final class an {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53691a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53692b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53693c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53694d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53695e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f53696f;

    /* renamed from: g  reason: collision with root package name */
    public final LottieAnimationView f53697g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f53698h;

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f53699i;

    private an(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, View view, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, LottieAnimationView lottieAnimationView, TextView textView4) {
        this.f53699i = constraintLayout;
        this.f53691a = textView;
        this.f53692b = imageView;
        this.f53693c = view;
        this.f53694d = textView2;
        this.f53695e = textView3;
        this.f53696f = constraintLayout2;
        this.f53697g = lottieAnimationView;
        this.f53698h = textView4;
    }

    public final ConstraintLayout a() {
        return this.f53699i;
    }

    public static an a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.transfer_to_bank_acc_bank_item_view, viewGroup, false);
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
                                    TextView textView4 = (TextView) inflate.findViewById(R.id.setMpin);
                                    if (textView4 != null) {
                                        return new an((ConstraintLayout) inflate, textView, imageView, findViewById, textView2, textView3, constraintLayout, lottieAnimationView, textView4);
                                    }
                                    str = "setMpin";
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
