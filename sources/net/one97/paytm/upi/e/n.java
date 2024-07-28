package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.util.CircularImageView;

public final class n {
    public final TextView A;
    private final ConstraintLayout B;

    /* renamed from: a  reason: collision with root package name */
    public final CustomAmountTextInputEditText f66854a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66855b;

    /* renamed from: c  reason: collision with root package name */
    public final View f66856c;

    /* renamed from: d  reason: collision with root package name */
    public final View f66857d;

    /* renamed from: e  reason: collision with root package name */
    public final Barrier f66858e;

    /* renamed from: f  reason: collision with root package name */
    public final Guideline f66859f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f66860g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66861h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66862i;
    public final TextView j;
    public final View k;
    public final TextView l;
    public final CircularImageView m;
    public final LottieAnimationView n;
    public final FrameLayout o;
    public final TextView p;
    public final Group q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final View x;
    public final TextView y;
    public final TextView z;

    private n(ConstraintLayout constraintLayout, CustomAmountTextInputEditText customAmountTextInputEditText, TextView textView, View view, View view2, Barrier barrier, Guideline guideline, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, View view3, TextView textView5, CircularImageView circularImageView, LottieAnimationView lottieAnimationView, FrameLayout frameLayout, TextView textView6, Group group, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, View view4, TextView textView13, TextView textView14, TextView textView15) {
        this.B = constraintLayout;
        this.f66854a = customAmountTextInputEditText;
        this.f66855b = textView;
        this.f66856c = view;
        this.f66857d = view2;
        this.f66858e = barrier;
        this.f66859f = guideline;
        this.f66860g = imageView;
        this.f66861h = textView2;
        this.f66862i = textView3;
        this.j = textView4;
        this.k = view3;
        this.l = textView5;
        this.m = circularImageView;
        this.n = lottieAnimationView;
        this.o = frameLayout;
        this.p = textView6;
        this.q = group;
        this.r = textView7;
        this.s = textView8;
        this.t = textView9;
        this.u = textView10;
        this.v = textView11;
        this.w = textView12;
        this.x = view4;
        this.y = textView13;
        this.z = textView14;
        this.A = textView15;
    }

    public static n a(View view) {
        String str;
        View view2 = view;
        CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) view2.findViewById(R.id.amountEditText);
        if (customAmountTextInputEditText != null) {
            TextView textView = (TextView) view2.findViewById(R.id.amountInWords);
            if (textView != null) {
                View findViewById = view2.findViewById(R.id.amountUnderLine);
                if (findViewById != null) {
                    View findViewById2 = view2.findViewById(R.id.background);
                    if (findViewById2 != null) {
                        Barrier barrier = (Barrier) view2.findViewById(R.id.barrier);
                        if (barrier != null) {
                            Guideline guideline = (Guideline) view2.findViewById(R.id.centerGuidLine);
                            if (guideline != null) {
                                ImageView imageView = (ImageView) view2.findViewById(R.id.closeButton);
                                if (imageView != null) {
                                    TextView textView2 = (TextView) view2.findViewById(R.id.dateError);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) view2.findViewById(R.id.endDate);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view2.findViewById(R.id.endDatePlaceHolder);
                                            if (textView4 != null) {
                                                View findViewById3 = view2.findViewById(R.id.endDateUnderLine);
                                                if (findViewById3 != null) {
                                                    TextView textView5 = (TextView) view2.findViewById(R.id.importantMessage);
                                                    if (textView5 != null) {
                                                        CircularImageView circularImageView = (CircularImageView) view2.findViewById(R.id.logoImage);
                                                        if (circularImageView != null) {
                                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.lottieLoader);
                                                            if (lottieAnimationView != null) {
                                                                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.lottieRootLayout);
                                                                if (frameLayout != null) {
                                                                    TextView textView6 = (TextView) view2.findViewById(R.id.nameInitials);
                                                                    if (textView6 != null) {
                                                                        Group group = (Group) view2.findViewById(R.id.pauseGroup);
                                                                        if (group != null) {
                                                                            TextView textView7 = (TextView) view2.findViewById(R.id.payeeName);
                                                                            if (textView7 != null) {
                                                                                TextView textView8 = (TextView) view2.findViewById(R.id.payeeVpa);
                                                                                if (textView8 != null) {
                                                                                    TextView textView9 = (TextView) view2.findViewById(R.id.proceedButton);
                                                                                    if (textView9 != null) {
                                                                                        TextView textView10 = (TextView) view2.findViewById(R.id.rupeePrefix);
                                                                                        if (textView10 != null) {
                                                                                            TextView textView11 = (TextView) view2.findViewById(R.id.startDate);
                                                                                            if (textView11 != null) {
                                                                                                TextView textView12 = (TextView) view2.findViewById(R.id.startDatePlaceHolder);
                                                                                                if (textView12 != null) {
                                                                                                    View findViewById4 = view2.findViewById(R.id.startDateUnderLine);
                                                                                                    if (findViewById4 != null) {
                                                                                                        TextView textView13 = (TextView) view2.findViewById(R.id.tvImportantLabel);
                                                                                                        if (textView13 != null) {
                                                                                                            TextView textView14 = (TextView) view2.findViewById(R.id.updatePaymentTitle);
                                                                                                            if (textView14 != null) {
                                                                                                                TextView textView15 = (TextView) view2.findViewById(R.id.validityText);
                                                                                                                if (textView15 != null) {
                                                                                                                    return new n((ConstraintLayout) view2, customAmountTextInputEditText, textView, findViewById, findViewById2, barrier, guideline, imageView, textView2, textView3, textView4, findViewById3, textView5, circularImageView, lottieAnimationView, frameLayout, textView6, group, textView7, textView8, textView9, textView10, textView11, textView12, findViewById4, textView13, textView14, textView15);
                                                                                                                }
                                                                                                                str = "validityText";
                                                                                                            } else {
                                                                                                                str = "updatePaymentTitle";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvImportantLabel";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "startDateUnderLine";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "startDatePlaceHolder";
                                                                                                }
                                                                                            } else {
                                                                                                str = "startDate";
                                                                                            }
                                                                                        } else {
                                                                                            str = "rupeePrefix";
                                                                                        }
                                                                                    } else {
                                                                                        str = "proceedButton";
                                                                                    }
                                                                                } else {
                                                                                    str = "payeeVpa";
                                                                                }
                                                                            } else {
                                                                                str = "payeeName";
                                                                            }
                                                                        } else {
                                                                            str = "pauseGroup";
                                                                        }
                                                                    } else {
                                                                        str = "nameInitials";
                                                                    }
                                                                } else {
                                                                    str = "lottieRootLayout";
                                                                }
                                                            } else {
                                                                str = "lottieLoader";
                                                            }
                                                        } else {
                                                            str = "logoImage";
                                                        }
                                                    } else {
                                                        str = "importantMessage";
                                                    }
                                                } else {
                                                    str = "endDateUnderLine";
                                                }
                                            } else {
                                                str = "endDatePlaceHolder";
                                            }
                                        } else {
                                            str = "endDate";
                                        }
                                    } else {
                                        str = "dateError";
                                    }
                                } else {
                                    str = "closeButton";
                                }
                            } else {
                                str = "centerGuidLine";
                            }
                        } else {
                            str = "barrier";
                        }
                    } else {
                        str = "background";
                    }
                } else {
                    str = "amountUnderLine";
                }
            } else {
                str = "amountInWords";
            }
        } else {
            str = "amountEditText";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
