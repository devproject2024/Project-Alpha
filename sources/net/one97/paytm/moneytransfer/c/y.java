package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import net.one97.paytm.moneytransfer.R;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f53876a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f53877b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f53878c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53879d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f53880e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53881f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f53882g;

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f53883h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f53884i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    private final ConstraintLayout m;

    private y(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ConstraintLayout constraintLayout3, TextView textView, ConstraintLayout constraintLayout4, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout5, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.m = constraintLayout;
        this.f53876a = constraintLayout2;
        this.f53877b = recyclerView;
        this.f53878c = constraintLayout3;
        this.f53879d = textView;
        this.f53880e = constraintLayout4;
        this.f53881f = textView2;
        this.f53882g = imageView;
        this.f53883h = constraintLayout5;
        this.f53884i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
    }

    public final ConstraintLayout a() {
        return this.m;
    }

    public static y a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.accountContainerLayout);
        if (constraintLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.accountsRecyclerView);
            if (recyclerView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.accountsTopLayout);
                if (constraintLayout2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.addBankAccount);
                    if (textView != null) {
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.bottomLayout);
                        if (constraintLayout3 != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.contactInitials);
                            if (textView2 != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.image);
                                if (imageView != null) {
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.imageLayout);
                                    if (constraintLayout4 != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.name);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view.findViewById(R.id.proceed);
                                            if (textView4 != null) {
                                                TextView textView5 = (TextView) view.findViewById(R.id.transferFrom);
                                                if (textView5 != null) {
                                                    TextView textView6 = (TextView) view.findViewById(R.id.upiId);
                                                    if (textView6 != null) {
                                                        return new y((ConstraintLayout) view, constraintLayout, recyclerView, constraintLayout2, textView, constraintLayout3, textView2, imageView, constraintLayout4, textView3, textView4, textView5, textView6);
                                                    }
                                                    str = "upiId";
                                                } else {
                                                    str = "transferFrom";
                                                }
                                            } else {
                                                str = "proceed";
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
                                str = "contactInitials";
                            }
                        } else {
                            str = "bottomLayout";
                        }
                    } else {
                        str = "addBankAccount";
                    }
                } else {
                    str = "accountsTopLayout";
                }
            } else {
                str = "accountsRecyclerView";
            }
        } else {
            str = "accountContainerLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
