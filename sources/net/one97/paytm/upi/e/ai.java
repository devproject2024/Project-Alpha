package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.R;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66774a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66775b;

    /* renamed from: c  reason: collision with root package name */
    public final Group f66776c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66777d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f66778e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f66779f;

    /* renamed from: g  reason: collision with root package name */
    public final AppCompatRadioButton f66780g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66781h;

    /* renamed from: i  reason: collision with root package name */
    public final View f66782i;
    public final TextView j;
    public final LottieAnimationView k;
    public final TextView l;
    public final TextView m;
    private final ConstraintLayout n;

    private ai(ConstraintLayout constraintLayout, TextView textView, TextView textView2, Group group, TextView textView3, ImageView imageView, TextView textView4, AppCompatRadioButton appCompatRadioButton, TextView textView5, View view, TextView textView6, LottieAnimationView lottieAnimationView, TextView textView7, TextView textView8) {
        this.n = constraintLayout;
        this.f66774a = textView;
        this.f66775b = textView2;
        this.f66776c = group;
        this.f66777d = textView3;
        this.f66778e = imageView;
        this.f66779f = textView4;
        this.f66780g = appCompatRadioButton;
        this.f66781h = textView5;
        this.f66782i = view;
        this.j = textView6;
        this.k = lottieAnimationView;
        this.l = textView7;
        this.m = textView8;
    }

    public final ConstraintLayout a() {
        return this.n;
    }

    public static ai a(View view) {
        String str;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.amount);
        if (textView != null) {
            TextView textView2 = (TextView) view2.findViewById(R.id.amount_in_words);
            if (textView2 != null) {
                Group group = (Group) view2.findViewById(R.id.balanceGroup);
                if (group != null) {
                    TextView textView3 = (TextView) view2.findViewById(R.id.bank_account);
                    if (textView3 != null) {
                        ImageView imageView = (ImageView) view2.findViewById(R.id.bank_logo);
                        if (imageView != null) {
                            TextView textView4 = (TextView) view2.findViewById(R.id.bank_name);
                            if (textView4 != null) {
                                AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) view2.findViewById(R.id.bank_radio);
                                if (appCompatRadioButton != null) {
                                    TextView textView5 = (TextView) view2.findViewById(R.id.check_balance);
                                    if (textView5 != null) {
                                        View findViewById = view2.findViewById(R.id.divider);
                                        if (findViewById != null) {
                                            TextView textView6 = (TextView) view2.findViewById(R.id.mpin);
                                            if (textView6 != null) {
                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.progress);
                                                if (lottieAnimationView != null) {
                                                    TextView textView7 = (TextView) view2.findViewById(R.id.remove_bank);
                                                    if (textView7 != null) {
                                                        TextView textView8 = (TextView) view2.findViewById(R.id.timestamp);
                                                        if (textView8 != null) {
                                                            return new ai((ConstraintLayout) view2, textView, textView2, group, textView3, imageView, textView4, appCompatRadioButton, textView5, findViewById, textView6, lottieAnimationView, textView7, textView8);
                                                        }
                                                        str = "timestamp";
                                                    } else {
                                                        str = "removeBank";
                                                    }
                                                } else {
                                                    str = H5Param.PROGRESS;
                                                }
                                            } else {
                                                str = PayUtility.MPIN;
                                            }
                                        } else {
                                            str = "divider";
                                        }
                                    } else {
                                        str = "checkBalance";
                                    }
                                } else {
                                    str = "bankRadio";
                                }
                            } else {
                                str = "bankName";
                            }
                        } else {
                            str = "bankLogo";
                        }
                    } else {
                        str = "bankAccount";
                    }
                } else {
                    str = "balanceGroup";
                }
            } else {
                str = "amountInWords";
            }
        } else {
            str = "amount";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
