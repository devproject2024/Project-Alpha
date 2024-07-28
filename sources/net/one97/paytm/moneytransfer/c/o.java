package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import net.one97.paytm.moneytransfer.R;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53802a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53803b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53804c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53805d;

    /* renamed from: e  reason: collision with root package name */
    public final View f53806e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53807f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f53808g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f53809h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f53810i;
    public final ConstraintLayout j;
    public final ImageView k;
    public final TextView l;
    public final Guideline m;
    private final ConstraintLayout n;

    private o(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, View view, TextView textView3, ImageView imageView3, ImageView imageView4, TextView textView4, ConstraintLayout constraintLayout2, ImageView imageView5, TextView textView5, Guideline guideline) {
        this.n = constraintLayout;
        this.f53802a = imageView;
        this.f53803b = imageView2;
        this.f53804c = textView;
        this.f53805d = textView2;
        this.f53806e = view;
        this.f53807f = textView3;
        this.f53808g = imageView3;
        this.f53809h = imageView4;
        this.f53810i = textView4;
        this.j = constraintLayout2;
        this.k = imageView5;
        this.l = textView5;
        this.m = guideline;
    }

    public static o a(View view) {
        String str;
        View view2 = view;
        ImageView imageView = (ImageView) view2.findViewById(R.id.backArrow);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.bankImage);
            if (imageView2 != null) {
                TextView textView = (TextView) view2.findViewById(R.id.cashBackTextView);
                if (textView != null) {
                    TextView textView2 = (TextView) view2.findViewById(R.id.contactNotFoundTextView);
                    if (textView2 != null) {
                        View findViewById = view2.findViewById(R.id.divider);
                        if (findViewById != null) {
                            TextView textView3 = (TextView) view2.findViewById(R.id.inviteButton);
                            if (textView3 != null) {
                                ImageView imageView3 = (ImageView) view2.findViewById(R.id.inviteImage);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view2.findViewById(R.id.inviteLogo);
                                    if (imageView4 != null) {
                                        TextView textView4 = (TextView) view2.findViewById(R.id.inviteMessage);
                                        if (textView4 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.noContactFoundLayout);
                                            if (constraintLayout != null) {
                                                ImageView imageView5 = (ImageView) view2.findViewById(R.id.rightArrow);
                                                if (imageView5 != null) {
                                                    TextView textView5 = (TextView) view2.findViewById(R.id.transferUsingBankAcc);
                                                    if (textView5 != null) {
                                                        Guideline guideline = (Guideline) view2.findViewById(R.id.verticalCenterGuideline);
                                                        if (guideline != null) {
                                                            return new o((ConstraintLayout) view2, imageView, imageView2, textView, textView2, findViewById, textView3, imageView3, imageView4, textView4, constraintLayout, imageView5, textView5, guideline);
                                                        }
                                                        str = "verticalCenterGuideline";
                                                    } else {
                                                        str = "transferUsingBankAcc";
                                                    }
                                                } else {
                                                    str = "rightArrow";
                                                }
                                            } else {
                                                str = "noContactFoundLayout";
                                            }
                                        } else {
                                            str = "inviteMessage";
                                        }
                                    } else {
                                        str = "inviteLogo";
                                    }
                                } else {
                                    str = "inviteImage";
                                }
                            } else {
                                str = "inviteButton";
                            }
                        } else {
                            str = "divider";
                        }
                    } else {
                        str = "contactNotFoundTextView";
                    }
                } else {
                    str = "cashBackTextView";
                }
            } else {
                str = "bankImage";
            }
        } else {
            str = "backArrow";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
