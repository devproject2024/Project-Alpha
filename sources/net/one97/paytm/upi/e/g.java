package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class g {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    private final NestedScrollView E;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66806a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66807b;

    /* renamed from: c  reason: collision with root package name */
    public final View f66808c;

    /* renamed from: d  reason: collision with root package name */
    public final Group f66809d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f66810e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f66811f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f66812g;

    /* renamed from: h  reason: collision with root package name */
    public final Barrier f66813h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66814i;
    public final LottieAnimationView j;
    public final ImageView k;
    public final TextView l;
    public final View m;
    public final ImageView n;
    public final TextView o;
    public final w p;
    public final CircularImageView q;
    public final LottieAnimationView r;
    public final LottieAnimationView s;
    public final FrameLayout t;
    public final TextView u;
    public final z v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private g(NestedScrollView nestedScrollView, TextView textView, TextView textView2, View view, Group group, ImageView imageView, ImageView imageView2, TextView textView3, Barrier barrier, TextView textView4, LottieAnimationView lottieAnimationView, ImageView imageView3, TextView textView5, View view2, ImageView imageView4, TextView textView6, w wVar, CircularImageView circularImageView, LottieAnimationView lottieAnimationView2, LottieAnimationView lottieAnimationView3, FrameLayout frameLayout, TextView textView7, z zVar, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.E = nestedScrollView;
        this.f66806a = textView;
        this.f66807b = textView2;
        this.f66808c = view;
        this.f66809d = group;
        this.f66810e = imageView;
        this.f66811f = imageView2;
        this.f66812g = textView3;
        this.f66813h = barrier;
        this.f66814i = textView4;
        this.j = lottieAnimationView;
        this.k = imageView3;
        this.l = textView5;
        this.m = view2;
        this.n = imageView4;
        this.o = textView6;
        this.p = wVar;
        this.q = circularImageView;
        this.r = lottieAnimationView2;
        this.s = lottieAnimationView3;
        this.t = frameLayout;
        this.u = textView7;
        this.v = zVar;
        this.w = textView8;
        this.x = textView9;
        this.y = textView10;
        this.z = textView11;
        this.A = textView12;
        this.B = textView13;
        this.C = textView14;
        this.D = textView15;
    }

    public final NestedScrollView a() {
        return this.E;
    }

    public static g a(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.amountTextView);
        if (textView != null) {
            TextView textView2 = (TextView) view2.findViewById(R.id.availableBalance);
            if (textView2 != null) {
                View findViewById = view2.findViewById(R.id.background);
                if (findViewById != null) {
                    Group group = (Group) view2.findViewById(R.id.bankGroup);
                    if (group != null) {
                        ImageView imageView = (ImageView) view2.findViewById(R.id.bankImageBg);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) view2.findViewById(R.id.bankImageView);
                            if (imageView2 != null) {
                                TextView textView3 = (TextView) view2.findViewById(R.id.bankName);
                                if (textView3 != null) {
                                    Barrier barrier = (Barrier) view2.findViewById(R.id.barrier);
                                    if (barrier != null) {
                                        TextView textView4 = (TextView) view2.findViewById(R.id.checkBalance);
                                        if (textView4 != null) {
                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.checkBalanceLoader);
                                            if (lottieAnimationView != null) {
                                                ImageView imageView3 = (ImageView) view2.findViewById(R.id.crossImage);
                                                if (imageView3 != null) {
                                                    TextView textView5 = (TextView) view2.findViewById(R.id.declineButton);
                                                    if (textView5 != null) {
                                                        View findViewById2 = view2.findViewById(R.id.divider);
                                                        if (findViewById2 != null) {
                                                            ImageView imageView4 = (ImageView) view2.findViewById(R.id.downArrow);
                                                            if (imageView4 != null) {
                                                                TextView textView6 = (TextView) view2.findViewById(R.id.importantMessage);
                                                                if (textView6 != null) {
                                                                    View findViewById3 = view2.findViewById(R.id.layoutBanksExpanded);
                                                                    if (findViewById3 != null) {
                                                                        RecyclerView recyclerView = (RecyclerView) findViewById3.findViewById(R.id.allBankList);
                                                                        if (recyclerView != null) {
                                                                            String str6 = "Missing required view with ID: ";
                                                                            TextView textView7 = (TextView) findViewById3.findViewById(R.id.payFrom);
                                                                            if (textView7 != null) {
                                                                                TextView textView8 = textView5;
                                                                                ImageView imageView5 = (ImageView) findViewById3.findViewById(R.id.upArrow);
                                                                                if (imageView5 != null) {
                                                                                    ImageView imageView6 = imageView3;
                                                                                    w wVar = new w((ConstraintLayout) findViewById3, recyclerView, textView7, imageView5);
                                                                                    CircularImageView circularImageView = (CircularImageView) view2.findViewById(R.id.logoImage);
                                                                                    if (circularImageView != null) {
                                                                                        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view2.findViewById(R.id.lottieLoader);
                                                                                        if (lottieAnimationView2 != null) {
                                                                                            LottieAnimationView lottieAnimationView3 = (LottieAnimationView) view2.findViewById(R.id.money_transfer_loader);
                                                                                            if (lottieAnimationView3 != null) {
                                                                                                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.money_transfer_loader_container);
                                                                                                if (frameLayout != null) {
                                                                                                    TextView textView9 = (TextView) view2.findViewById(R.id.nameInitials);
                                                                                                    if (textView9 != null) {
                                                                                                        View findViewById4 = view2.findViewById(R.id.noBankSupportedLayout);
                                                                                                        if (findViewById4 != null) {
                                                                                                            TextView textView10 = (TextView) findViewById4.findViewById(R.id.description);
                                                                                                            if (textView10 != null) {
                                                                                                                TextView textView11 = (TextView) findViewById4.findViewById(R.id.heading);
                                                                                                                if (textView11 != null) {
                                                                                                                    w wVar2 = wVar;
                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) findViewById4.findViewById(R.id.unsupportedBankVpaList);
                                                                                                                    if (recyclerView2 != null) {
                                                                                                                        CircularImageView circularImageView2 = circularImageView;
                                                                                                                        z zVar = new z((ConstraintLayout) findViewById4, textView10, textView11, recyclerView2);
                                                                                                                        TextView textView12 = (TextView) view2.findViewById(R.id.oldAmount);
                                                                                                                        if (textView12 != null) {
                                                                                                                            TextView textView13 = (TextView) view2.findViewById(R.id.payeeName);
                                                                                                                            if (textView13 != null) {
                                                                                                                                TextView textView14 = (TextView) view2.findViewById(R.id.payeeVpa);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    TextView textView15 = (TextView) view2.findViewById(R.id.paymentTitle);
                                                                                                                                    if (textView15 != null) {
                                                                                                                                        TextView textView16 = (TextView) view2.findViewById(R.id.proceedButton);
                                                                                                                                        if (textView16 != null) {
                                                                                                                                            TextView textView17 = (TextView) view2.findViewById(R.id.tvImportantLabel);
                                                                                                                                            if (textView17 != null) {
                                                                                                                                                TextView textView18 = (TextView) view2.findViewById(R.id.updatePlaceHolder);
                                                                                                                                                if (textView18 != null) {
                                                                                                                                                    TextView textView19 = (TextView) view2.findViewById(R.id.validityText);
                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                        return new g((NestedScrollView) view2, textView, textView2, findViewById, group, imageView, imageView2, textView3, barrier, textView4, lottieAnimationView, imageView6, textView8, findViewById2, imageView4, textView6, wVar2, circularImageView2, lottieAnimationView2, lottieAnimationView3, frameLayout, textView9, zVar, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19);
                                                                                                                                                    }
                                                                                                                                                    str2 = "validityText";
                                                                                                                                                } else {
                                                                                                                                                    str2 = "updatePlaceHolder";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str2 = "tvImportantLabel";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str2 = "proceedButton";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str2 = "paymentTitle";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str2 = "payeeVpa";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str2 = "payeeName";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str2 = "oldAmount";
                                                                                                                        }
                                                                                                                        str = str6;
                                                                                                                    } else {
                                                                                                                        str5 = "unsupportedBankVpaList";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str5 = "heading";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str5 = RequestConfirmationDialogFragment.KEY_DESCRIPTION;
                                                                                                            }
                                                                                                            throw new NullPointerException(str6.concat(str5));
                                                                                                        }
                                                                                                        str = str6;
                                                                                                        str2 = "noBankSupportedLayout";
                                                                                                    } else {
                                                                                                        str = str6;
                                                                                                        str2 = "nameInitials";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = str6;
                                                                                                    str2 = "moneyTransferLoaderContainer";
                                                                                                }
                                                                                            } else {
                                                                                                str = str6;
                                                                                                str2 = "moneyTransferLoader";
                                                                                            }
                                                                                        } else {
                                                                                            str = str6;
                                                                                            str2 = "lottieLoader";
                                                                                        }
                                                                                    } else {
                                                                                        str = str6;
                                                                                        str2 = "logoImage";
                                                                                    }
                                                                                } else {
                                                                                    str3 = str6;
                                                                                    str4 = "upArrow";
                                                                                }
                                                                            } else {
                                                                                str3 = str6;
                                                                                str4 = "payFrom";
                                                                            }
                                                                        } else {
                                                                            str3 = "Missing required view with ID: ";
                                                                            str4 = "allBankList";
                                                                        }
                                                                        throw new NullPointerException(str3.concat(str4));
                                                                    }
                                                                    str = "Missing required view with ID: ";
                                                                    str2 = "layoutBanksExpanded";
                                                                } else {
                                                                    str = "Missing required view with ID: ";
                                                                    str2 = "importantMessage";
                                                                }
                                                            } else {
                                                                str = "Missing required view with ID: ";
                                                                str2 = "downArrow";
                                                            }
                                                        } else {
                                                            str = "Missing required view with ID: ";
                                                            str2 = "divider";
                                                        }
                                                    } else {
                                                        str = "Missing required view with ID: ";
                                                        str2 = "declineButton";
                                                    }
                                                } else {
                                                    str = "Missing required view with ID: ";
                                                    str2 = "crossImage";
                                                }
                                            } else {
                                                str = "Missing required view with ID: ";
                                                str2 = "checkBalanceLoader";
                                            }
                                        } else {
                                            str = "Missing required view with ID: ";
                                            str2 = "checkBalance";
                                        }
                                    } else {
                                        str = "Missing required view with ID: ";
                                        str2 = "barrier";
                                    }
                                } else {
                                    str = "Missing required view with ID: ";
                                    str2 = "bankName";
                                }
                            } else {
                                str = "Missing required view with ID: ";
                                str2 = "bankImageView";
                            }
                        } else {
                            str = "Missing required view with ID: ";
                            str2 = "bankImageBg";
                        }
                    } else {
                        str = "Missing required view with ID: ";
                        str2 = "bankGroup";
                    }
                } else {
                    str = "Missing required view with ID: ";
                    str2 = "background";
                }
            } else {
                str = "Missing required view with ID: ";
                str2 = "availableBalance";
            }
        } else {
            str = "Missing required view with ID: ";
            str2 = "amountTextView";
        }
        throw new NullPointerException(str.concat(str2));
    }
}
