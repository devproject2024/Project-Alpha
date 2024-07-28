package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.util.CommentsEditText;

public final class ag {
    public final ImageView A;
    public final ConstraintLayout B;
    public final ConstraintLayout C;
    public final RelativeLayout D;
    public final ConstraintLayout E;
    public final TextView F;
    public final ImageView G;
    public final ShimmerFrameLayout H;
    public final LottieAnimationView I;
    public final RecyclerView J;
    public final ConstraintLayout K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    private final ConstraintLayout S;

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f53636a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f53637b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53638c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f53639d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53640e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomAmountTextInputEditText f53641f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f53642g;

    /* renamed from: h  reason: collision with root package name */
    public final NestedScrollView f53643h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f53644i;
    public final ImageView j;
    public final ImageView k;
    public final LinearLayout l;
    public final ImageView m;
    public final ConstraintLayout n;
    public final LottieAnimationView o;
    public final RelativeLayout p;
    public final TextView q;
    public final ImageView r;
    public final ImageView s;
    public final ImageView t;
    public final LinearLayout u;
    public final LinearLayout v;
    public final TextView w;
    public final RelativeLayout x;
    public final CommentsEditText y;
    public final View z;

    private ag(ConstraintLayout constraintLayout, LinearLayout linearLayout, LottieAnimationView lottieAnimationView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, CustomAmountTextInputEditText customAmountTextInputEditText, LinearLayout linearLayout2, NestedScrollView nestedScrollView, LinearLayout linearLayout3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout4, ImageView imageView3, ConstraintLayout constraintLayout3, LottieAnimationView lottieAnimationView2, RelativeLayout relativeLayout, TextView textView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView4, RelativeLayout relativeLayout2, CommentsEditText commentsEditText, View view, ImageView imageView7, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, RelativeLayout relativeLayout3, ConstraintLayout constraintLayout6, TextView textView5, ImageView imageView8, ShimmerFrameLayout shimmerFrameLayout, LottieAnimationView lottieAnimationView3, RecyclerView recyclerView, ConstraintLayout constraintLayout7, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.S = constraintLayout;
        this.f53636a = linearLayout;
        this.f53637b = lottieAnimationView;
        this.f53638c = textView;
        this.f53639d = constraintLayout2;
        this.f53640e = textView2;
        this.f53641f = customAmountTextInputEditText;
        this.f53642g = linearLayout2;
        this.f53643h = nestedScrollView;
        this.f53644i = linearLayout3;
        this.j = imageView;
        this.k = imageView2;
        this.l = linearLayout4;
        this.m = imageView3;
        this.n = constraintLayout3;
        this.o = lottieAnimationView2;
        this.p = relativeLayout;
        this.q = textView3;
        this.r = imageView4;
        this.s = imageView5;
        this.t = imageView6;
        this.u = linearLayout5;
        this.v = linearLayout6;
        this.w = textView4;
        this.x = relativeLayout2;
        this.y = commentsEditText;
        this.z = view;
        this.A = imageView7;
        this.B = constraintLayout4;
        this.C = constraintLayout5;
        this.D = relativeLayout3;
        this.E = constraintLayout6;
        this.F = textView5;
        this.G = imageView8;
        this.H = shimmerFrameLayout;
        this.I = lottieAnimationView3;
        this.J = recyclerView;
        this.K = constraintLayout7;
        this.L = textView6;
        this.M = textView7;
        this.N = textView8;
        this.O = textView9;
        this.P = textView10;
        this.Q = textView11;
        this.R = textView12;
    }

    public final ConstraintLayout a() {
        return this.S;
    }

    public static ag a(View view) {
        String str;
        View view2 = view;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.accountLoadingLayout);
        if (linearLayout != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.accountsLoader);
            if (lottieAnimationView != null) {
                TextView textView = (TextView) view2.findViewById(R.id.addMessageTextView);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.amountContainer);
                    if (constraintLayout != null) {
                        TextView textView2 = (TextView) view2.findViewById(R.id.amount_error_tv);
                        if (textView2 != null) {
                            CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) view2.findViewById(R.id.amount_et);
                            if (customAmountTextInputEditText != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.amountParentView);
                                if (linearLayout2 != null) {
                                    NestedScrollView nestedScrollView = (NestedScrollView) view2.findViewById(R.id.amount_scrollview);
                                    if (nestedScrollView != null) {
                                        LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(R.id.bankDetailsContainer);
                                        if (linearLayout3 != null) {
                                            ImageView imageView = (ImageView) view2.findViewById(R.id.bankImageCollapsedView);
                                            if (imageView != null) {
                                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.bankImageView);
                                                if (imageView2 != null) {
                                                    LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(R.id.bankNameContainer);
                                                    if (linearLayout4 != null) {
                                                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.bankarrow);
                                                        if (imageView3 != null) {
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.bottomContainer);
                                                            if (constraintLayout2 != null) {
                                                                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view2.findViewById(R.id.bottomLoader);
                                                                if (lottieAnimationView2 != null) {
                                                                    RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.bottomProceedParent);
                                                                    if (relativeLayout != null) {
                                                                        TextView textView3 = (TextView) view2.findViewById(R.id.headerBankLogoName);
                                                                        if (textView3 != null) {
                                                                            ImageView imageView4 = (ImageView) view2.findViewById(R.id.iv_back_button1);
                                                                            if (imageView4 != null) {
                                                                                ImageView imageView5 = (ImageView) view2.findViewById(R.id.ivVerificationLogo);
                                                                                if (imageView5 != null) {
                                                                                    ImageView imageView6 = (ImageView) view2.findViewById(R.id.leftArrow);
                                                                                    if (imageView6 != null) {
                                                                                        LinearLayout linearLayout5 = (LinearLayout) view2.findViewById(R.id.ll_amount_wrapper);
                                                                                        if (linearLayout5 != null) {
                                                                                            LinearLayout linearLayout6 = (LinearLayout) view2.findViewById(R.id.ll_pay_wrapper);
                                                                                            if (linearLayout6 != null) {
                                                                                                TextView textView4 = (TextView) view2.findViewById(R.id.ll_uni_pay);
                                                                                                if (textView4 != null) {
                                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.lnr_details_layout);
                                                                                                    if (relativeLayout2 != null) {
                                                                                                        CommentsEditText commentsEditText = (CommentsEditText) view2.findViewById(R.id.messageEditText);
                                                                                                        if (commentsEditText != null) {
                                                                                                            View findViewById = view2.findViewById(R.id.messageUnderLine);
                                                                                                            if (findViewById != null) {
                                                                                                                ImageView imageView7 = (ImageView) view2.findViewById(R.id.options);
                                                                                                                if (imageView7 != null) {
                                                                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view2.findViewById(R.id.pullDownLayout);
                                                                                                                    if (constraintLayout3 != null) {
                                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view2.findViewById(R.id.pullToRefreshView);
                                                                                                                        if (constraintLayout4 != null) {
                                                                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.rl_uni_selected_payment_inst);
                                                                                                                            if (relativeLayout3 != null) {
                                                                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) view2.findViewById(R.id.rootView);
                                                                                                                                if (constraintLayout5 != null) {
                                                                                                                                    TextView textView5 = (TextView) view2.findViewById(R.id.rupee_prefix_tv);
                                                                                                                                    if (textView5 != null) {
                                                                                                                                        ImageView imageView8 = (ImageView) view2.findViewById(R.id.selectedBankDownArrowTV);
                                                                                                                                        if (imageView8 != null) {
                                                                                                                                            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view2.findViewById(R.id.shimmer_name);
                                                                                                                                            if (shimmerFrameLayout != null) {
                                                                                                                                                LottieAnimationView lottieAnimationView3 = (LottieAnimationView) view2.findViewById(R.id.theme_animation);
                                                                                                                                                if (lottieAnimationView3 != null) {
                                                                                                                                                    RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.themeRecycleView);
                                                                                                                                                    if (recyclerView != null) {
                                                                                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) view2.findViewById(R.id.topPaymentCardLayout);
                                                                                                                                                        if (constraintLayout6 != null) {
                                                                                                                                                            TextView textView6 = (TextView) view2.findViewById(R.id.transfered_from);
                                                                                                                                                            if (textView6 != null) {
                                                                                                                                                                TextView textView7 = (TextView) view2.findViewById(R.id.tv_receiver_acc_number);
                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                    TextView textView8 = (TextView) view2.findViewById(R.id.tv_receiver_ifsc);
                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                        TextView textView9 = (TextView) view2.findViewById(R.id.tv_receiver_name);
                                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                                            TextView textView10 = (TextView) view2.findViewById(R.id.tv_selected_source_label);
                                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                                TextView textView11 = (TextView) view2.findViewById(R.id.tvbhimUpi);
                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                    TextView textView12 = (TextView) view2.findViewById(R.id.viewPaymentHistory);
                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                        return new ag((ConstraintLayout) view2, linearLayout, lottieAnimationView, textView, constraintLayout, textView2, customAmountTextInputEditText, linearLayout2, nestedScrollView, linearLayout3, imageView, imageView2, linearLayout4, imageView3, constraintLayout2, lottieAnimationView2, relativeLayout, textView3, imageView4, imageView5, imageView6, linearLayout5, linearLayout6, textView4, relativeLayout2, commentsEditText, findViewById, imageView7, constraintLayout3, constraintLayout4, relativeLayout3, constraintLayout5, textView5, imageView8, shimmerFrameLayout, lottieAnimationView3, recyclerView, constraintLayout6, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
                                                                                                                                                                                    }
                                                                                                                                                                                    str = "viewPaymentHistory";
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "tvbhimUpi";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "tvSelectedSourceLabel";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "tvReceiverName";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "tvReceiverIfsc";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "tvReceiverAccNumber";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "transferedFrom";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "topPaymentCardLayout";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "themeRecycleView";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "themeAnimation";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "shimmerName";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "selectedBankDownArrowTV";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "rupeePrefixTv";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "rootView";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "rlUniSelectedPaymentInst";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "pullToRefreshView";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "pullDownLayout";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "options";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "messageUnderLine";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "messageEditText";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "lnrDetailsLayout";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "llUniPay";
                                                                                                }
                                                                                            } else {
                                                                                                str = "llPayWrapper";
                                                                                            }
                                                                                        } else {
                                                                                            str = "llAmountWrapper";
                                                                                        }
                                                                                    } else {
                                                                                        str = "leftArrow";
                                                                                    }
                                                                                } else {
                                                                                    str = "ivVerificationLogo";
                                                                                }
                                                                            } else {
                                                                                str = "ivBackButton1";
                                                                            }
                                                                        } else {
                                                                            str = "headerBankLogoName";
                                                                        }
                                                                    } else {
                                                                        str = "bottomProceedParent";
                                                                    }
                                                                } else {
                                                                    str = "bottomLoader";
                                                                }
                                                            } else {
                                                                str = "bottomContainer";
                                                            }
                                                        } else {
                                                            str = "bankarrow";
                                                        }
                                                    } else {
                                                        str = "bankNameContainer";
                                                    }
                                                } else {
                                                    str = "bankImageView";
                                                }
                                            } else {
                                                str = "bankImageCollapsedView";
                                            }
                                        } else {
                                            str = "bankDetailsContainer";
                                        }
                                    } else {
                                        str = "amountScrollview";
                                    }
                                } else {
                                    str = "amountParentView";
                                }
                            } else {
                                str = "amountEt";
                            }
                        } else {
                            str = "amountErrorTv";
                        }
                    } else {
                        str = "amountContainer";
                    }
                } else {
                    str = "addMessageTextView";
                }
            } else {
                str = "accountsLoader";
            }
        } else {
            str = "accountLoadingLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
