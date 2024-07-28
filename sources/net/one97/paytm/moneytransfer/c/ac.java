package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53609a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53610b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53611c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f53612d;

    /* renamed from: e  reason: collision with root package name */
    public final LottieAnimationView f53613e;

    /* renamed from: f  reason: collision with root package name */
    public final LottieAnimationView f53614f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f53615g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f53616h;

    /* renamed from: i  reason: collision with root package name */
    public final Group f53617i;
    public final ConstraintLayout j;
    public final View k;
    public final TextView l;
    public final ImageView m;
    public final TextView n;
    public final TextView o;
    private final ConstraintLayout p;

    private ac(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, RelativeLayout relativeLayout, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, RelativeLayout relativeLayout2, TextView textView3, Group group, ConstraintLayout constraintLayout2, View view, TextView textView4, ImageView imageView2, TextView textView5, TextView textView6) {
        this.p = constraintLayout;
        this.f53609a = textView;
        this.f53610b = imageView;
        this.f53611c = textView2;
        this.f53612d = relativeLayout;
        this.f53613e = lottieAnimationView;
        this.f53614f = lottieAnimationView2;
        this.f53615g = relativeLayout2;
        this.f53616h = textView3;
        this.f53617i = group;
        this.j = constraintLayout2;
        this.k = view;
        this.l = textView4;
        this.m = imageView2;
        this.n = textView5;
        this.o = textView6;
    }

    public final ConstraintLayout a() {
        return this.p;
    }

    public static ac a(View view) {
        String str;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.accountTypeCurrent);
        if (textView != null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.arrow_iv);
            if (imageView != null) {
                TextView textView2 = (TextView) view2.findViewById(R.id.card_view_button);
                if (textView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.cardViewProceedParent);
                    if (relativeLayout != null) {
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.cardViewloader);
                        if (lottieAnimationView != null) {
                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view2.findViewById(R.id.check_balance_loader);
                            if (lottieAnimationView2 != null) {
                                RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.checkBalanceParent);
                                if (relativeLayout2 != null) {
                                    TextView textView3 = (TextView) view2.findViewById(R.id.check_balance_tv);
                                    if (textView3 != null) {
                                        Group group = (Group) view2.findViewById(R.id.clickable_group);
                                        if (group != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.mt_selected_account_cv);
                                            if (constraintLayout != null) {
                                                View findViewById = view2.findViewById(R.id.padded_view);
                                                if (findViewById != null) {
                                                    TextView textView4 = (TextView) view2.findViewById(R.id.payFrom);
                                                    if (textView4 != null) {
                                                        ImageView imageView2 = (ImageView) view2.findViewById(R.id.sender_bank_iv);
                                                        if (imageView2 != null) {
                                                            TextView textView5 = (TextView) view2.findViewById(R.id.source_name);
                                                            if (textView5 != null) {
                                                                TextView textView6 = (TextView) view2.findViewById(R.id.tooltipMessage);
                                                                if (textView6 != null) {
                                                                    return new ac((ConstraintLayout) view2, textView, imageView, textView2, relativeLayout, lottieAnimationView, lottieAnimationView2, relativeLayout2, textView3, group, constraintLayout, findViewById, textView4, imageView2, textView5, textView6);
                                                                }
                                                                str = "tooltipMessage";
                                                            } else {
                                                                str = "sourceName";
                                                            }
                                                        } else {
                                                            str = "senderBankIv";
                                                        }
                                                    } else {
                                                        str = "payFrom";
                                                    }
                                                } else {
                                                    str = "paddedView";
                                                }
                                            } else {
                                                str = "mtSelectedAccountCv";
                                            }
                                        } else {
                                            str = "clickableGroup";
                                        }
                                    } else {
                                        str = "checkBalanceTv";
                                    }
                                } else {
                                    str = "checkBalanceParent";
                                }
                            } else {
                                str = "checkBalanceLoader";
                            }
                        } else {
                            str = "cardViewloader";
                        }
                    } else {
                        str = "cardViewProceedParent";
                    }
                } else {
                    str = "cardViewButton";
                }
            } else {
                str = "arrowIv";
            }
        } else {
            str = "accountTypeCurrent";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
