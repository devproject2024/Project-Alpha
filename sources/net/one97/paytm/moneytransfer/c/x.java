package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53867a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53868b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f53869c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53870d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53871e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f53872f;

    /* renamed from: g  reason: collision with root package name */
    public final CircularProgressBar f53873g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f53874h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f53875i;
    public final FrameLayout j;
    public final RadioButton k;
    public final TextView l;
    public final TextView m;
    public final LottieAnimationView n;
    private final RelativeLayout o;

    private x(RelativeLayout relativeLayout, TextView textView, ImageView imageView, FrameLayout frameLayout, TextView textView2, TextView textView3, FrameLayout frameLayout2, CircularProgressBar circularProgressBar, TextView textView4, RelativeLayout relativeLayout2, FrameLayout frameLayout3, RadioButton radioButton, TextView textView5, TextView textView6, LottieAnimationView lottieAnimationView) {
        this.o = relativeLayout;
        this.f53867a = textView;
        this.f53868b = imageView;
        this.f53869c = frameLayout;
        this.f53870d = textView2;
        this.f53871e = textView3;
        this.f53872f = frameLayout2;
        this.f53873g = circularProgressBar;
        this.f53874h = textView4;
        this.f53875i = relativeLayout2;
        this.j = frameLayout3;
        this.k = radioButton;
        this.l = textView5;
        this.m = textView6;
        this.n = lottieAnimationView;
    }

    public final RelativeLayout a() {
        return this.o;
    }

    public static x a(View view) {
        String str;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.availableBalance);
        if (textView != null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.bankImage);
            if (imageView != null) {
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.bankImageBg);
                if (frameLayout != null) {
                    TextView textView2 = (TextView) view2.findViewById(R.id.check_balance_tv);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view2.findViewById(R.id.dummyTextView);
                        if (textView3 != null) {
                            FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.dummyViewTop);
                            if (frameLayout2 != null) {
                                CircularProgressBar circularProgressBar = (CircularProgressBar) view2.findViewById(R.id.infoProgressBar);
                                if (circularProgressBar != null) {
                                    TextView textView4 = (TextView) view2.findViewById(R.id.infoText);
                                    if (textView4 != null) {
                                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.item_rl_root);
                                        if (relativeLayout != null) {
                                            FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(R.id.overlay);
                                            if (frameLayout3 != null) {
                                                RadioButton radioButton = (RadioButton) view2.findViewById(R.id.radio_button);
                                                if (radioButton != null) {
                                                    TextView textView5 = (TextView) view2.findViewById(R.id.setmpin);
                                                    if (textView5 != null) {
                                                        TextView textView6 = (TextView) view2.findViewById(R.id.source_name);
                                                        if (textView6 != null) {
                                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.wallet_loader);
                                                            if (lottieAnimationView != null) {
                                                                return new x((RelativeLayout) view2, textView, imageView, frameLayout, textView2, textView3, frameLayout2, circularProgressBar, textView4, relativeLayout, frameLayout3, radioButton, textView5, textView6, lottieAnimationView);
                                                            }
                                                            str = "walletLoader";
                                                        } else {
                                                            str = "sourceName";
                                                        }
                                                    } else {
                                                        str = "setmpin";
                                                    }
                                                } else {
                                                    str = "radioButton";
                                                }
                                            } else {
                                                str = "overlay";
                                            }
                                        } else {
                                            str = "itemRlRoot";
                                        }
                                    } else {
                                        str = "infoText";
                                    }
                                } else {
                                    str = "infoProgressBar";
                                }
                            } else {
                                str = "dummyViewTop";
                            }
                        } else {
                            str = "dummyTextView";
                        }
                    } else {
                        str = "checkBalanceTv";
                    }
                } else {
                    str = "bankImageBg";
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
