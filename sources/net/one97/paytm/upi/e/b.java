package net.one97.paytm.upi.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.upi.R;

public final class b {
    public final ImageView A;
    public final TextView B;
    public final TextView C;
    public final Button D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    private final ConstraintLayout K;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66783a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66784b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f66785c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f66786d;

    /* renamed from: e  reason: collision with root package name */
    public final View f66787e;

    /* renamed from: f  reason: collision with root package name */
    public final Group f66788f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f66789g;

    /* renamed from: h  reason: collision with root package name */
    public final View f66790h;

    /* renamed from: i  reason: collision with root package name */
    public final LottieAnimationView f66791i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final LottieAnimationView n;
    public final TextView o;
    public final View p;
    public final TextView q;
    public final TextView r;
    public final Guideline s;
    public final TextView t;
    public final FrameLayout u;
    public final TextView v;
    public final ImageView w;
    public final TextView x;
    public final x y;
    public final CardView z;

    private b(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, View view, Group group, ImageView imageView2, View view2, LottieAnimationView lottieAnimationView, TextView textView4, TextView textView5, TextView textView6, TextView textView7, LottieAnimationView lottieAnimationView2, TextView textView8, View view3, TextView textView9, TextView textView10, Guideline guideline, TextView textView11, FrameLayout frameLayout, TextView textView12, ImageView imageView3, TextView textView13, x xVar, CardView cardView, ImageView imageView4, TextView textView14, TextView textView15, Button button, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21) {
        this.K = constraintLayout;
        this.f66783a = textView;
        this.f66784b = textView2;
        this.f66785c = textView3;
        this.f66786d = imageView;
        this.f66787e = view;
        this.f66788f = group;
        this.f66789g = imageView2;
        this.f66790h = view2;
        this.f66791i = lottieAnimationView;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
        this.m = textView7;
        this.n = lottieAnimationView2;
        this.o = textView8;
        this.p = view3;
        this.q = textView9;
        this.r = textView10;
        this.s = guideline;
        this.t = textView11;
        this.u = frameLayout;
        this.v = textView12;
        this.w = imageView3;
        this.x = textView13;
        this.y = xVar;
        this.z = cardView;
        this.A = imageView4;
        this.B = textView14;
        this.C = textView15;
        this.D = button;
        this.E = textView16;
        this.F = textView17;
        this.G = textView18;
        this.H = textView19;
        this.I = textView20;
        this.J = textView21;
    }

    public final ConstraintLayout a() {
        return this.K;
    }

    public static b a(LayoutInflater layoutInflater) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.activity_mandate_confirmation_detail, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.ToTextView);
        if (textView != null) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.amountInWordsTextView);
            if (textView2 != null) {
                TextView textView3 = (TextView) inflate.findViewById(R.id.amountTextView);
                if (textView3 != null) {
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.backArrow);
                    if (imageView != null) {
                        View findViewById = inflate.findViewById(R.id.bankClickView);
                        if (findViewById != null) {
                            Group group = (Group) inflate.findViewById(R.id.bankGroup);
                            if (group != null) {
                                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.bankImage);
                                if (imageView2 != null) {
                                    View findViewById2 = inflate.findViewById(R.id.bankImageBg);
                                    if (findViewById2 != null) {
                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.bankLoader);
                                        if (lottieAnimationView != null) {
                                            TextView textView4 = (TextView) inflate.findViewById(R.id.bankName);
                                            if (textView4 != null) {
                                                TextView textView5 = (TextView) inflate.findViewById(R.id.bankPlaceHolder);
                                                if (textView5 != null) {
                                                    TextView textView6 = (TextView) inflate.findViewById(R.id.changeBank);
                                                    if (textView6 != null) {
                                                        TextView textView7 = (TextView) inflate.findViewById(R.id.comment);
                                                        if (textView7 != null) {
                                                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) inflate.findViewById(R.id.confirmBtnLoader);
                                                            if (lottieAnimationView2 != null) {
                                                                TextView textView8 = (TextView) inflate.findViewById(R.id.confirmPaymentText);
                                                                if (textView8 != null) {
                                                                    View findViewById3 = inflate.findViewById(R.id.dashLine);
                                                                    if (findViewById3 != null) {
                                                                        TextView textView9 = (TextView) inflate.findViewById(R.id.forThePeriodPlaceHolder);
                                                                        if (textView9 != null) {
                                                                            TextView textView10 = (TextView) inflate.findViewById(R.id.forThePeriodValue);
                                                                            if (textView10 != null) {
                                                                                Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline);
                                                                                if (guideline != null) {
                                                                                    TextView textView11 = (TextView) inflate.findViewById(R.id.importantMessage);
                                                                                    if (textView11 != null) {
                                                                                        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.lottieRootLayout);
                                                                                        if (frameLayout != null) {
                                                                                            TextView textView12 = (TextView) inflate.findViewById(R.id.mandateName);
                                                                                            if (textView12 != null) {
                                                                                                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.motifImageView);
                                                                                                if (imageView3 != null) {
                                                                                                    TextView textView13 = (TextView) inflate.findViewById(R.id.nameOfPaymentPlaceHolder);
                                                                                                    if (textView13 != null) {
                                                                                                        View findViewById4 = inflate.findViewById(R.id.noBankSupportedLayout);
                                                                                                        if (findViewById4 != null) {
                                                                                                            x a2 = x.a(findViewById4);
                                                                                                            CardView cardView = (CardView) inflate.findViewById(R.id.payButtonCardView);
                                                                                                            if (cardView != null) {
                                                                                                                ImageView imageView4 = (ImageView) inflate.findViewById(R.id.payeeLogo);
                                                                                                                if (imageView4 != null) {
                                                                                                                    TextView textView14 = (TextView) inflate.findViewById(R.id.payeeName);
                                                                                                                    if (textView14 != null) {
                                                                                                                        TextView textView15 = (TextView) inflate.findViewById(R.id.payeeUpiId);
                                                                                                                        if (textView15 != null) {
                                                                                                                            Button button = (Button) inflate.findViewById(R.id.proceedButton);
                                                                                                                            if (button != null) {
                                                                                                                                TextView textView16 = (TextView) inflate.findViewById(R.id.termsAndConditions);
                                                                                                                                if (textView16 != null) {
                                                                                                                                    TextView textView17 = (TextView) inflate.findViewById(R.id.toBePaidPlaceHolder);
                                                                                                                                    if (textView17 != null) {
                                                                                                                                        TextView textView18 = (TextView) inflate.findViewById(R.id.toBePaidValue);
                                                                                                                                        if (textView18 != null) {
                                                                                                                                            TextView textView19 = (TextView) inflate.findViewById(R.id.tvImportantLabel);
                                                                                                                                            if (textView19 != null) {
                                                                                                                                                TextView textView20 = (TextView) inflate.findViewById(R.id.uptoPlaceHolder);
                                                                                                                                                if (textView20 != null) {
                                                                                                                                                    TextView textView21 = (TextView) inflate.findViewById(R.id.viewDetailsTextView);
                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                        return new b((ConstraintLayout) inflate, textView, textView2, textView3, imageView, findViewById, group, imageView2, findViewById2, lottieAnimationView, textView4, textView5, textView6, textView7, lottieAnimationView2, textView8, findViewById3, textView9, textView10, guideline, textView11, frameLayout, textView12, imageView3, textView13, a2, cardView, imageView4, textView14, textView15, button, textView16, textView17, textView18, textView19, textView20, textView21);
                                                                                                                                                    }
                                                                                                                                                    str = "viewDetailsTextView";
                                                                                                                                                } else {
                                                                                                                                                    str = "uptoPlaceHolder";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "tvImportantLabel";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "toBePaidValue";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "toBePaidPlaceHolder";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "termsAndConditions";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "proceedButton";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "payeeUpiId";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "payeeName";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "payeeLogo";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "payButtonCardView";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "noBankSupportedLayout";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "nameOfPaymentPlaceHolder";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "motifImageView";
                                                                                                }
                                                                                            } else {
                                                                                                str = "mandateName";
                                                                                            }
                                                                                        } else {
                                                                                            str = "lottieRootLayout";
                                                                                        }
                                                                                    } else {
                                                                                        str = "importantMessage";
                                                                                    }
                                                                                } else {
                                                                                    str = "guideline";
                                                                                }
                                                                            } else {
                                                                                str = "forThePeriodValue";
                                                                            }
                                                                        } else {
                                                                            str = "forThePeriodPlaceHolder";
                                                                        }
                                                                    } else {
                                                                        str = "dashLine";
                                                                    }
                                                                } else {
                                                                    str = "confirmPaymentText";
                                                                }
                                                            } else {
                                                                str = "confirmBtnLoader";
                                                            }
                                                        } else {
                                                            str = CJRQRScanResultModel.KEY_COMMENT_SMALL;
                                                        }
                                                    } else {
                                                        str = "changeBank";
                                                    }
                                                } else {
                                                    str = "bankPlaceHolder";
                                                }
                                            } else {
                                                str = "bankName";
                                            }
                                        } else {
                                            str = "bankLoader";
                                        }
                                    } else {
                                        str = "bankImageBg";
                                    }
                                } else {
                                    str = "bankImage";
                                }
                            } else {
                                str = "bankGroup";
                            }
                        } else {
                            str = "bankClickView";
                        }
                    } else {
                        str = "backArrow";
                    }
                } else {
                    str = "amountTextView";
                }
            } else {
                str = "amountInWordsTextView";
            }
        } else {
            str = "ToTextView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
