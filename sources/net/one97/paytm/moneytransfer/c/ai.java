package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f53652a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53653b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53654c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f53655d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f53656e;

    /* renamed from: f  reason: collision with root package name */
    public final CircularProgressBar f53657f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53658g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f53659h;

    /* renamed from: i  reason: collision with root package name */
    public final ConstraintLayout f53660i;
    public final TextView j;
    public final TextView k;
    public final ConstraintLayout l;
    public final ImageView m;
    public final ConstraintLayout n;
    public final TextView o;
    public final ConstraintLayout p;
    public final ImageView q;
    public final TextView r;
    private final ConstraintLayout s;

    private ai(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, ImageView imageView, CircularProgressBar circularProgressBar, TextView textView3, ImageView imageView2, ConstraintLayout constraintLayout4, TextView textView4, TextView textView5, ConstraintLayout constraintLayout5, ImageView imageView3, ConstraintLayout constraintLayout6, TextView textView6, ConstraintLayout constraintLayout7, ImageView imageView4, TextView textView7) {
        this.s = constraintLayout;
        this.f53652a = constraintLayout2;
        this.f53653b = textView;
        this.f53654c = textView2;
        this.f53655d = constraintLayout3;
        this.f53656e = imageView;
        this.f53657f = circularProgressBar;
        this.f53658g = textView3;
        this.f53659h = imageView2;
        this.f53660i = constraintLayout4;
        this.j = textView4;
        this.k = textView5;
        this.l = constraintLayout5;
        this.m = imageView3;
        this.n = constraintLayout6;
        this.o = textView6;
        this.p = constraintLayout7;
        this.q = imageView4;
        this.r = textView7;
    }

    public static ai a(View view) {
        String str;
        View view2 = view;
        ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.beneficiaryItemParent);
        if (constraintLayout != null) {
            TextView textView = (TextView) view2.findViewById(R.id.contactInitials);
            if (textView != null) {
                TextView textView2 = (TextView) view2.findViewById(R.id.deleteBeneficiary);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.deleteBeneficiaryContainer);
                    if (constraintLayout2 != null) {
                        ImageView imageView = (ImageView) view2.findViewById(R.id.deleteIcon);
                        if (imageView != null) {
                            CircularProgressBar circularProgressBar = (CircularProgressBar) view2.findViewById(R.id.deleteProgress);
                            if (circularProgressBar != null) {
                                TextView textView3 = (TextView) view2.findViewById(R.id.ifsc);
                                if (textView3 != null) {
                                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.image);
                                    if (imageView2 != null) {
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view2.findViewById(R.id.imageLayout);
                                        if (constraintLayout3 != null) {
                                            TextView textView4 = (TextView) view2.findViewById(R.id.name);
                                            if (textView4 != null) {
                                                TextView textView5 = (TextView) view2.findViewById(R.id.needHelp);
                                                if (textView5 != null) {
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view2.findViewById(R.id.needHelpContainer);
                                                    if (constraintLayout4 != null) {
                                                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.needHelpIcon);
                                                        if (imageView3 != null) {
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view2.findViewById(R.id.payeeContainer);
                                                            if (constraintLayout5 != null) {
                                                                TextView textView6 = (TextView) view2.findViewById(R.id.requestMoney);
                                                                if (textView6 != null) {
                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) view2.findViewById(R.id.requestMoneyContainer);
                                                                    if (constraintLayout6 != null) {
                                                                        ImageView imageView4 = (ImageView) view2.findViewById(R.id.requestMoneyIcon);
                                                                        if (imageView4 != null) {
                                                                            TextView textView7 = (TextView) view2.findViewById(R.id.upiId);
                                                                            if (textView7 != null) {
                                                                                return new ai((ConstraintLayout) view2, constraintLayout, textView, textView2, constraintLayout2, imageView, circularProgressBar, textView3, imageView2, constraintLayout3, textView4, textView5, constraintLayout4, imageView3, constraintLayout5, textView6, constraintLayout6, imageView4, textView7);
                                                                            }
                                                                            str = "upiId";
                                                                        } else {
                                                                            str = "requestMoneyIcon";
                                                                        }
                                                                    } else {
                                                                        str = "requestMoneyContainer";
                                                                    }
                                                                } else {
                                                                    str = "requestMoney";
                                                                }
                                                            } else {
                                                                str = "payeeContainer";
                                                            }
                                                        } else {
                                                            str = "needHelpIcon";
                                                        }
                                                    } else {
                                                        str = "needHelpContainer";
                                                    }
                                                } else {
                                                    str = "needHelp";
                                                }
                                            } else {
                                                str = "name";
                                            }
                                        } else {
                                            str = "imageLayout";
                                        }
                                    } else {
                                        str = H5ResourceHandlerUtil.IMAGE;
                                    }
                                } else {
                                    str = "ifsc";
                                }
                            } else {
                                str = "deleteProgress";
                            }
                        } else {
                            str = "deleteIcon";
                        }
                    } else {
                        str = "deleteBeneficiaryContainer";
                    }
                } else {
                    str = "deleteBeneficiary";
                }
            } else {
                str = "contactInitials";
            }
        } else {
            str = "beneficiaryItemParent";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
