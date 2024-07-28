package net.one97.paytm.upi.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import net.one97.paytm.upi.R;

public final class ag {
    public final View A;
    public final View B;
    public final View C;
    public final View D;
    public final View E;
    public final Group F;
    public final TextView G;
    public final TextView H;
    public final LottieAnimationView I;
    public final Group J;
    public final TextView K;
    public final TextView L;
    public final CoordinatorLayout M;
    public final CheckBox N;
    public final Group O;
    public final TextView P;
    public final Toolbar Q;
    public final Guideline R;
    public final TextView S;
    public final ImageView T;
    public final TextView U;
    public final TextView V;
    public final Group W;
    public final ImageView X;
    public final TextView Y;
    public final TextView Z;

    /* renamed from: a  reason: collision with root package name */
    public final Group f66760a;
    public final FrameLayout aa;
    public final CheckBox ab;
    public final TextView ac;
    public final TextView ad;
    public final TextView ae;
    public final Group af;
    private final CoordinatorLayout ag;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66761b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f66762c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66763d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f66764e;

    /* renamed from: f  reason: collision with root package name */
    public final View f66765f;

    /* renamed from: g  reason: collision with root package name */
    public final View f66766g;

    /* renamed from: h  reason: collision with root package name */
    public final View f66767h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f66768i;
    public final ImageView j;
    public final TextView k;
    public final Group l;
    public final TextView m;
    public final TextView n;
    public final ImageView o;
    public final ImageView p;
    public final ImageView q;
    public final ImageView r;
    public final ImageView s;
    public final ImageView t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final TextView x;
    public final TextView y;
    public final ah z;

    private ag(CoordinatorLayout coordinatorLayout, Group group, TextView textView, TextView textView2, TextView textView3, RecyclerView recyclerView, View view, View view2, View view3, ImageView imageView, ImageView imageView2, TextView textView4, Group group2, TextView textView5, TextView textView6, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, TextView textView7, TextView textView8, ah ahVar, View view4, View view5, View view6, View view7, View view8, Group group3, TextView textView9, TextView textView10, LottieAnimationView lottieAnimationView, Group group4, TextView textView11, TextView textView12, CoordinatorLayout coordinatorLayout2, CheckBox checkBox, Group group5, TextView textView13, Toolbar toolbar, Guideline guideline, TextView textView14, ImageView imageView12, TextView textView15, TextView textView16, Group group6, ImageView imageView13, TextView textView17, TextView textView18, FrameLayout frameLayout, CheckBox checkBox2, TextView textView19, TextView textView20, TextView textView21, Group group7) {
        this.ag = coordinatorLayout;
        this.f66760a = group;
        this.f66761b = textView;
        this.f66762c = textView2;
        this.f66763d = textView3;
        this.f66764e = recyclerView;
        this.f66765f = view;
        this.f66766g = view2;
        this.f66767h = view3;
        this.f66768i = imageView;
        this.j = imageView2;
        this.k = textView4;
        this.l = group2;
        this.m = textView5;
        this.n = textView6;
        this.o = imageView3;
        this.p = imageView4;
        this.q = imageView5;
        this.r = imageView6;
        this.s = imageView7;
        this.t = imageView8;
        this.u = imageView9;
        this.v = imageView10;
        this.w = imageView11;
        this.x = textView7;
        this.y = textView8;
        this.z = ahVar;
        this.A = view4;
        this.B = view5;
        this.C = view6;
        this.D = view7;
        this.E = view8;
        this.F = group3;
        this.G = textView9;
        this.H = textView10;
        this.I = lottieAnimationView;
        this.J = group4;
        this.K = textView11;
        this.L = textView12;
        this.M = coordinatorLayout2;
        this.N = checkBox;
        this.O = group5;
        this.P = textView13;
        this.Q = toolbar;
        this.R = guideline;
        this.S = textView14;
        this.T = imageView12;
        this.U = textView15;
        this.V = textView16;
        this.W = group6;
        this.X = imageView13;
        this.Y = textView17;
        this.Z = textView18;
        this.aa = frameLayout;
        this.ab = checkBox2;
        this.ac = textView19;
        this.ad = textView20;
        this.ae = textView21;
        this.af = group7;
    }

    public static ag a(LayoutInflater layoutInflater) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.upi_settings, (ViewGroup) null, false);
        Group group = (Group) inflate.findViewById(R.id.account_beneficiary_group);
        if (group != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.account_beneficiary_header);
            if (textView != null) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.account_beneficiary_info);
                if (textView2 != null) {
                    TextView textView3 = (TextView) inflate.findViewById(R.id.add_bank_account);
                    if (textView3 != null) {
                        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.bank_recyclerview);
                        if (recyclerView != null) {
                            View findViewById = inflate.findViewById(R.id.barrier1);
                            if (findViewById != null) {
                                View findViewById2 = inflate.findViewById(R.id.barrier2);
                                if (findViewById2 != null) {
                                    View findViewById3 = inflate.findViewById(R.id.barrier3);
                                    if (findViewById3 != null) {
                                        ImageView imageView = (ImageView) inflate.findViewById(R.id.copyVpa);
                                        if (imageView != null) {
                                            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.edit_photo);
                                            if (imageView2 != null) {
                                                TextView textView4 = (TextView) inflate.findViewById(R.id.header);
                                                if (textView4 != null) {
                                                    Group group2 = (Group) inflate.findViewById(R.id.help_group);
                                                    if (group2 != null) {
                                                        TextView textView5 = (TextView) inflate.findViewById(R.id.help_header);
                                                        if (textView5 != null) {
                                                            TextView textView6 = (TextView) inflate.findViewById(R.id.help_info);
                                                            if (textView6 != null) {
                                                                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.ic_account_beneficiary);
                                                                if (imageView3 != null) {
                                                                    ImageView imageView4 = (ImageView) inflate.findViewById(R.id.ic_arrow1);
                                                                    if (imageView4 != null) {
                                                                        ImageView imageView5 = (ImageView) inflate.findViewById(R.id.ic_arrow2);
                                                                        if (imageView5 != null) {
                                                                            ImageView imageView6 = (ImageView) inflate.findViewById(R.id.ic_arrow3);
                                                                            if (imageView6 != null) {
                                                                                ImageView imageView7 = (ImageView) inflate.findViewById(R.id.ic_arrow4);
                                                                                if (imageView7 != null) {
                                                                                    ImageView imageView8 = (ImageView) inflate.findViewById(R.id.ic_help);
                                                                                    if (imageView8 != null) {
                                                                                        ImageView imageView9 = (ImageView) inflate.findViewById(R.id.ic_mandate_placeholder);
                                                                                        if (imageView9 != null) {
                                                                                            ImageView imageView10 = (ImageView) inflate.findViewById(R.id.ic_payment_request);
                                                                                            if (imageView10 != null) {
                                                                                                ImageView imageView11 = (ImageView) inflate.findViewById(R.id.ic_request_money);
                                                                                                if (imageView11 != null) {
                                                                                                    TextView textView7 = (TextView) inflate.findViewById(R.id.image_upload_tooltip);
                                                                                                    if (textView7 != null) {
                                                                                                        TextView textView8 = (TextView) inflate.findViewById(R.id.info);
                                                                                                        if (textView8 != null) {
                                                                                                            View findViewById4 = inflate.findViewById(R.id.invite);
                                                                                                            if (findViewById4 != null) {
                                                                                                                ah a2 = ah.a(findViewById4);
                                                                                                                View findViewById5 = inflate.findViewById(R.id.line);
                                                                                                                if (findViewById5 != null) {
                                                                                                                    View findViewById6 = inflate.findViewById(R.id.line1);
                                                                                                                    if (findViewById6 != null) {
                                                                                                                        View findViewById7 = inflate.findViewById(R.id.line2);
                                                                                                                        if (findViewById7 != null) {
                                                                                                                            View findViewById8 = inflate.findViewById(R.id.line4);
                                                                                                                            if (findViewById8 != null) {
                                                                                                                                View findViewById9 = inflate.findViewById(R.id.lineMandate);
                                                                                                                                if (findViewById9 != null) {
                                                                                                                                    Group group3 = (Group) inflate.findViewById(R.id.payment_request_group);
                                                                                                                                    if (group3 != null) {
                                                                                                                                        TextView textView9 = (TextView) inflate.findViewById(R.id.payment_request_header);
                                                                                                                                        if (textView9 != null) {
                                                                                                                                            TextView textView10 = (TextView) inflate.findViewById(R.id.payment_request_info);
                                                                                                                                            if (textView10 != null) {
                                                                                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.progress);
                                                                                                                                                if (lottieAnimationView != null) {
                                                                                                                                                    Group group4 = (Group) inflate.findViewById(R.id.request_money_group);
                                                                                                                                                    if (group4 != null) {
                                                                                                                                                        TextView textView11 = (TextView) inflate.findViewById(R.id.request_money_header);
                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                            TextView textView12 = (TextView) inflate.findViewById(R.id.request_money_info);
                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate.findViewById(R.id.root);
                                                                                                                                                                if (coordinatorLayout != null) {
                                                                                                                                                                    CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.smart_transfer);
                                                                                                                                                                    if (checkBox != null) {
                                                                                                                                                                        Group group5 = (Group) inflate.findViewById(R.id.smart_transfer_group);
                                                                                                                                                                        if (group5 != null) {
                                                                                                                                                                            TextView textView13 = (TextView) inflate.findViewById(R.id.smart_transfer_lbl);
                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                                                                                                                                                                                if (toolbar != null) {
                                                                                                                                                                                    Guideline guideline = (Guideline) inflate.findViewById(R.id.tooltip);
                                                                                                                                                                                    if (guideline != null) {
                                                                                                                                                                                        TextView textView14 = (TextView) inflate.findViewById(R.id.upi_bank_account_header);
                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                            ImageView imageView12 = (ImageView) inflate.findViewById(R.id.upiMandateArrow);
                                                                                                                                                                                            if (imageView12 != null) {
                                                                                                                                                                                                TextView textView15 = (TextView) inflate.findViewById(R.id.upiMandateHeader);
                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                    TextView textView16 = (TextView) inflate.findViewById(R.id.upiMandateInfo);
                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                        Group group6 = (Group) inflate.findViewById(R.id.upimandateGroup);
                                                                                                                                                                                                        if (group6 != null) {
                                                                                                                                                                                                            ImageView imageView13 = (ImageView) inflate.findViewById(R.id.user_image);
                                                                                                                                                                                                            if (imageView13 != null) {
                                                                                                                                                                                                                TextView textView17 = (TextView) inflate.findViewById(R.id.user_name);
                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                    TextView textView18 = (TextView) inflate.findViewById(R.id.vpa);
                                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                                        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.wallet_logo);
                                                                                                                                                                                                                        if (frameLayout != null) {
                                                                                                                                                                                                                            CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.wallet_money_transfer);
                                                                                                                                                                                                                            if (checkBox2 != null) {
                                                                                                                                                                                                                                TextView textView19 = (TextView) inflate.findViewById(R.id.wallet_money_transfer_header);
                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                    TextView textView20 = (TextView) inflate.findViewById(R.id.wallet_money_transfer_lbl);
                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                        TextView textView21 = (TextView) inflate.findViewById(R.id.wallet_money_transfer_lbl_info);
                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                            Group group7 = (Group) inflate.findViewById(R.id.wallet_transfer_group);
                                                                                                                                                                                                                                            if (group7 != null) {
                                                                                                                                                                                                                                                return new ag((CoordinatorLayout) inflate, group, textView, textView2, textView3, recyclerView, findViewById, findViewById2, findViewById3, imageView, imageView2, textView4, group2, textView5, textView6, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, textView7, textView8, a2, findViewById5, findViewById6, findViewById7, findViewById8, findViewById9, group3, textView9, textView10, lottieAnimationView, group4, textView11, textView12, coordinatorLayout, checkBox, group5, textView13, toolbar, guideline, textView14, imageView12, textView15, textView16, group6, imageView13, textView17, textView18, frameLayout, checkBox2, textView19, textView20, textView21, group7);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            str = "walletTransferGroup";
                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                            str = "walletMoneyTransferLblInfo";
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                        str = "walletMoneyTransferLbl";
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                    str = "walletMoneyTransferHeader";
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                str = "walletMoneyTransfer";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            str = "walletLogo";
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        str = "vpa";
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    str = "userName";
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                str = "userImage";
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            str = "upimandateGroup";
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        str = "upiMandateInfo";
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    str = "upiMandateHeader";
                                                                                                                                                                                                }
                                                                                                                                                                                            } else {
                                                                                                                                                                                                str = "upiMandateArrow";
                                                                                                                                                                                            }
                                                                                                                                                                                        } else {
                                                                                                                                                                                            str = "upiBankAccountHeader";
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        str = "tooltip";
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "toolbar";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "smartTransferLbl";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "smartTransferGroup";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "smartTransfer";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "root";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "requestMoneyInfo";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "requestMoneyHeader";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "requestMoneyGroup";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = H5Param.PROGRESS;
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "paymentRequestInfo";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "paymentRequestHeader";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "paymentRequestGroup";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "lineMandate";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "line4";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = AddEditGstinViewModelKt.BODY_PARAM_LINE2;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = AddEditGstinViewModelKt.BODY_PARAM_LINE1;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "line";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "invite";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "info";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "imageUploadTooltip";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "icRequestMoney";
                                                                                                }
                                                                                            } else {
                                                                                                str = "icPaymentRequest";
                                                                                            }
                                                                                        } else {
                                                                                            str = "icMandatePlaceholder";
                                                                                        }
                                                                                    } else {
                                                                                        str = "icHelp";
                                                                                    }
                                                                                } else {
                                                                                    str = "icArrow4";
                                                                                }
                                                                            } else {
                                                                                str = "icArrow3";
                                                                            }
                                                                        } else {
                                                                            str = "icArrow2";
                                                                        }
                                                                    } else {
                                                                        str = "icArrow1";
                                                                    }
                                                                } else {
                                                                    str = "icAccountBeneficiary";
                                                                }
                                                            } else {
                                                                str = "helpInfo";
                                                            }
                                                        } else {
                                                            str = "helpHeader";
                                                        }
                                                    } else {
                                                        str = "helpGroup";
                                                    }
                                                } else {
                                                    str = H5Logger.HEADER;
                                                }
                                            } else {
                                                str = "editPhoto";
                                            }
                                        } else {
                                            str = "copyVpa";
                                        }
                                    } else {
                                        str = "barrier3";
                                    }
                                } else {
                                    str = "barrier2";
                                }
                            } else {
                                str = "barrier1";
                            }
                        } else {
                            str = "bankRecyclerview";
                        }
                    } else {
                        str = "addBankAccount";
                    }
                } else {
                    str = "accountBeneficiaryInfo";
                }
            } else {
                str = "accountBeneficiaryHeader";
            }
        } else {
            str = "accountBeneficiaryGroup";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
