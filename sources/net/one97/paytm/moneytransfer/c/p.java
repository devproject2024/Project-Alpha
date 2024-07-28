package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final AppCompatRadioButton f53811a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53812b;

    /* renamed from: c  reason: collision with root package name */
    public final Group f53813c;

    /* renamed from: d  reason: collision with root package name */
    public final LottieAnimationView f53814d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f53815e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f53816f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f53817g;

    private p(ConstraintLayout constraintLayout, AppCompatRadioButton appCompatRadioButton, TextView textView, Group group, LottieAnimationView lottieAnimationView, ImageView imageView, FrameLayout frameLayout) {
        this.f53817g = constraintLayout;
        this.f53811a = appCompatRadioButton;
        this.f53812b = textView;
        this.f53813c = group;
        this.f53814d = lottieAnimationView;
        this.f53815e = imageView;
        this.f53816f = frameLayout;
    }

    public final ConstraintLayout a() {
        return this.f53817g;
    }

    public static p a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.mt_add_more_account, viewGroup, false);
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) inflate.findViewById(R.id.addBankRadio);
        if (appCompatRadioButton != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.addMoreBank);
            if (textView != null) {
                Group group = (Group) inflate.findViewById(R.id.addMoreBankGroup);
                if (group != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lottieAnimation);
                    if (lottieAnimationView != null) {
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.plusIcon);
                        if (imageView != null) {
                            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.radioPlusSignFrame);
                            if (frameLayout != null) {
                                return new p((ConstraintLayout) inflate, appCompatRadioButton, textView, group, lottieAnimationView, imageView, frameLayout);
                            }
                            str = "radioPlusSignFrame";
                        } else {
                            str = "plusIcon";
                        }
                    } else {
                        str = "lottieAnimation";
                    }
                } else {
                    str = "addMoreBankGroup";
                }
            } else {
                str = "addMoreBank";
            }
        } else {
            str = "addBankRadio";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
