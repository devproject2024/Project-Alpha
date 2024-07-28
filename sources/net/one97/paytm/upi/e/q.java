package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66869a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f66870b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f66871c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66872d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f66873e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f66874f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f66875g;

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f66876h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66877i;
    public final ImageView j;
    public final TextView k;
    public final View l;
    public final TextView m;
    private final ConstraintLayout n;

    private q(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView3, TextView textView2, ImageView imageView4, ConstraintLayout constraintLayout3, TextView textView3, ImageView imageView5, TextView textView4, View view, TextView textView5) {
        this.n = constraintLayout;
        this.f66869a = imageView;
        this.f66870b = imageView2;
        this.f66871c = constraintLayout2;
        this.f66872d = textView;
        this.f66873e = imageView3;
        this.f66874f = textView2;
        this.f66875g = imageView4;
        this.f66876h = constraintLayout3;
        this.f66877i = textView3;
        this.j = imageView5;
        this.k = textView4;
        this.l = view;
        this.m = textView5;
    }

    public static q a(View view) {
        String str;
        View view2 = view;
        ImageView imageView = (ImageView) view2.findViewById(R.id.cross);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.loginArrow);
            if (imageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.loginContainer);
                if (constraintLayout != null) {
                    TextView textView = (TextView) view2.findViewById(R.id.loginDescription);
                    if (textView != null) {
                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.loginImage);
                        if (imageView3 != null) {
                            TextView textView2 = (TextView) view2.findViewById(R.id.loginTitle);
                            if (textView2 != null) {
                                ImageView imageView4 = (ImageView) view2.findViewById(R.id.replaceArrow);
                                if (imageView4 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.replaceContainer);
                                    if (constraintLayout2 != null) {
                                        TextView textView3 = (TextView) view2.findViewById(R.id.replaceDescription);
                                        if (textView3 != null) {
                                            ImageView imageView5 = (ImageView) view2.findViewById(R.id.replaceImage);
                                            if (imageView5 != null) {
                                                TextView textView4 = (TextView) view2.findViewById(R.id.replaceTitle);
                                                if (textView4 != null) {
                                                    View findViewById = view2.findViewById(R.id.separator);
                                                    if (findViewById != null) {
                                                        TextView textView5 = (TextView) view2.findViewById(R.id.title);
                                                        if (textView5 != null) {
                                                            return new q((ConstraintLayout) view2, imageView, imageView2, constraintLayout, textView, imageView3, textView2, imageView4, constraintLayout2, textView3, imageView5, textView4, findViewById, textView5);
                                                        }
                                                        str = "title";
                                                    } else {
                                                        str = "separator";
                                                    }
                                                } else {
                                                    str = "replaceTitle";
                                                }
                                            } else {
                                                str = "replaceImage";
                                            }
                                        } else {
                                            str = "replaceDescription";
                                        }
                                    } else {
                                        str = "replaceContainer";
                                    }
                                } else {
                                    str = "replaceArrow";
                                }
                            } else {
                                str = "loginTitle";
                            }
                        } else {
                            str = "loginImage";
                        }
                    } else {
                        str = "loginDescription";
                    }
                } else {
                    str = "loginContainer";
                }
            } else {
                str = "loginArrow";
            }
        } else {
            str = "cross";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
