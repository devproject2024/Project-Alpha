package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66833a;

    /* renamed from: b  reason: collision with root package name */
    public final View f66834b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f66835c;

    /* renamed from: d  reason: collision with root package name */
    public final CircularImageView f66836d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f66837e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f66838f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f66839g;

    /* renamed from: h  reason: collision with root package name */
    public final View f66840h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66841i;
    public final CircularImageView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    private final ConstraintLayout s;

    private j(ConstraintLayout constraintLayout, TextView textView, View view, ImageView imageView, CircularImageView circularImageView, TextView textView2, TextView textView3, ImageView imageView2, View view2, TextView textView4, CircularImageView circularImageView2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.s = constraintLayout;
        this.f66833a = textView;
        this.f66834b = view;
        this.f66835c = imageView;
        this.f66836d = circularImageView;
        this.f66837e = textView2;
        this.f66838f = textView3;
        this.f66839g = imageView2;
        this.f66840h = view2;
        this.f66841i = textView4;
        this.j = circularImageView2;
        this.k = textView5;
        this.l = textView6;
        this.m = textView7;
        this.n = textView8;
        this.o = textView9;
        this.p = textView10;
        this.q = textView11;
        this.r = textView12;
    }

    public static j a(View view) {
        String str;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.amountTextView);
        if (textView != null) {
            View findViewById = view2.findViewById(R.id.background);
            if (findViewById != null) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.bankImage);
                if (imageView != null) {
                    CircularImageView circularImageView = (CircularImageView) view2.findViewById(R.id.bankImageBg);
                    if (circularImageView != null) {
                        TextView textView2 = (TextView) view2.findViewById(R.id.bankName);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view2.findViewById(R.id.bankPlaceHolder);
                            if (textView3 != null) {
                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.crossImage);
                                if (imageView2 != null) {
                                    View findViewById2 = view2.findViewById(R.id.divider);
                                    if (findViewById2 != null) {
                                        TextView textView4 = (TextView) view2.findViewById(R.id.importantMessage);
                                        if (textView4 != null) {
                                            CircularImageView circularImageView2 = (CircularImageView) view2.findViewById(R.id.logoImage);
                                            if (circularImageView2 != null) {
                                                TextView textView5 = (TextView) view2.findViewById(R.id.nameInitials);
                                                if (textView5 != null) {
                                                    TextView textView6 = (TextView) view2.findViewById(R.id.payeeName);
                                                    if (textView6 != null) {
                                                        TextView textView7 = (TextView) view2.findViewById(R.id.payeeVpa);
                                                        if (textView7 != null) {
                                                            TextView textView8 = (TextView) view2.findViewById(R.id.paymentTitle);
                                                            if (textView8 != null) {
                                                                TextView textView9 = (TextView) view2.findViewById(R.id.rrnTextView);
                                                                if (textView9 != null) {
                                                                    TextView textView10 = (TextView) view2.findViewById(R.id.tvImportantLabel);
                                                                    if (textView10 != null) {
                                                                        TextView textView11 = (TextView) view2.findViewById(R.id.umnTextView);
                                                                        if (textView11 != null) {
                                                                            TextView textView12 = (TextView) view2.findViewById(R.id.viewDetailsTextView);
                                                                            if (textView12 != null) {
                                                                                return new j((ConstraintLayout) view2, textView, findViewById, imageView, circularImageView, textView2, textView3, imageView2, findViewById2, textView4, circularImageView2, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
                                                                            }
                                                                            str = "viewDetailsTextView";
                                                                        } else {
                                                                            str = "umnTextView";
                                                                        }
                                                                    } else {
                                                                        str = "tvImportantLabel";
                                                                    }
                                                                } else {
                                                                    str = "rrnTextView";
                                                                }
                                                            } else {
                                                                str = "paymentTitle";
                                                            }
                                                        } else {
                                                            str = "payeeVpa";
                                                        }
                                                    } else {
                                                        str = "payeeName";
                                                    }
                                                } else {
                                                    str = "nameInitials";
                                                }
                                            } else {
                                                str = "logoImage";
                                            }
                                        } else {
                                            str = "importantMessage";
                                        }
                                    } else {
                                        str = "divider";
                                    }
                                } else {
                                    str = "crossImage";
                                }
                            } else {
                                str = "bankPlaceHolder";
                            }
                        } else {
                            str = "bankName";
                        }
                    } else {
                        str = "bankImageBg";
                    }
                } else {
                    str = "bankImage";
                }
            } else {
                str = "background";
            }
        } else {
            str = "amountTextView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
