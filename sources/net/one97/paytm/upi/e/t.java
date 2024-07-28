package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.upi.R;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final ac f66893a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f66894b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f66895c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f66896d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f66897e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f66898f;

    /* renamed from: g  reason: collision with root package name */
    public final ae f66899g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66900h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66901i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    private final RelativeLayout p;

    private t(RelativeLayout relativeLayout, ac acVar, RelativeLayout relativeLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout3, ae aeVar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.p = relativeLayout;
        this.f66893a = acVar;
        this.f66894b = relativeLayout2;
        this.f66895c = imageView;
        this.f66896d = imageView2;
        this.f66897e = imageView3;
        this.f66898f = relativeLayout3;
        this.f66899g = aeVar;
        this.f66900h = textView;
        this.f66901i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
        this.m = textView6;
        this.n = textView7;
        this.o = textView8;
    }

    public static t a(View view) {
        String str;
        View view2 = view;
        View findViewById = view2.findViewById(R.id.accountSwitch);
        if (findViewById != null) {
            ac a2 = ac.a(findViewById);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.bottomLayout);
            if (relativeLayout != null) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.iv_back);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.iv_logo);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.motif_iv);
                        if (imageView3 != null) {
                            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.rl_multi_sim);
                            if (relativeLayout2 != null) {
                                View findViewById2 = view2.findViewById(R.id.simSelection);
                                if (findViewById2 != null) {
                                    ae a3 = ae.a(findViewById2);
                                    TextView textView = (TextView) view2.findViewById(R.id.skip_tv);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view2.findViewById(R.id.tv_desc);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view2.findViewById(R.id.tv_error_desc);
                                            if (textView3 != null) {
                                                TextView textView4 = (TextView) view2.findViewById(R.id.tv_operator_charges_warning);
                                                if (textView4 != null) {
                                                    TextView textView5 = (TextView) view2.findViewById(R.id.tv_re_activate_account);
                                                    if (textView5 != null) {
                                                        TextView textView6 = (TextView) view2.findViewById(R.id.tv_select_sim_title);
                                                        if (textView6 != null) {
                                                            TextView textView7 = (TextView) view2.findViewById(R.id.tv_title);
                                                            if (textView7 != null) {
                                                                TextView textView8 = (TextView) view2.findViewById(R.id.tv_upi_offer);
                                                                if (textView8 != null) {
                                                                    return new t((RelativeLayout) view2, a2, relativeLayout, imageView, imageView2, imageView3, relativeLayout2, a3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                                                }
                                                                str = "tvUpiOffer";
                                                            } else {
                                                                str = "tvTitle";
                                                            }
                                                        } else {
                                                            str = "tvSelectSimTitle";
                                                        }
                                                    } else {
                                                        str = "tvReActivateAccount";
                                                    }
                                                } else {
                                                    str = "tvOperatorChargesWarning";
                                                }
                                            } else {
                                                str = "tvErrorDesc";
                                            }
                                        } else {
                                            str = "tvDesc";
                                        }
                                    } else {
                                        str = "skipTv";
                                    }
                                } else {
                                    str = "simSelection";
                                }
                            } else {
                                str = "rlMultiSim";
                            }
                        } else {
                            str = "motifIv";
                        }
                    } else {
                        str = "ivLogo";
                    }
                } else {
                    str = "ivBack";
                }
            } else {
                str = "bottomLayout";
            }
        } else {
            str = "accountSwitch";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
