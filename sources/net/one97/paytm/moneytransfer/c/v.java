package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import net.one97.paytm.moneytransfer.R;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f53854a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f53855b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f53856c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53857d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f53858e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53859f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f53860g;

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f53861h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f53862i;
    public final TextView j;
    public final View k;
    public final TextView l;
    public final TextView m;
    private final ConstraintLayout n;

    private v(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ConstraintLayout constraintLayout3, TextView textView, ConstraintLayout constraintLayout4, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout5, TextView textView3, TextView textView4, View view, TextView textView5, TextView textView6) {
        this.n = constraintLayout;
        this.f53854a = constraintLayout2;
        this.f53855b = recyclerView;
        this.f53856c = constraintLayout3;
        this.f53857d = textView;
        this.f53858e = constraintLayout4;
        this.f53859f = textView2;
        this.f53860g = imageView;
        this.f53861h = constraintLayout5;
        this.f53862i = textView3;
        this.j = textView4;
        this.k = view;
        this.l = textView5;
        this.m = textView6;
    }

    public final ConstraintLayout a() {
        return this.n;
    }

    public static v a(View view) {
        String str;
        View view2 = view;
        ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.accountContainerLayout);
        if (constraintLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.accountsRecyclerView);
            if (recyclerView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.accountsTopLayout);
                if (constraintLayout2 != null) {
                    TextView textView = (TextView) view2.findViewById(R.id.addBankAccount);
                    if (textView != null) {
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view2.findViewById(R.id.bottomLayout);
                        if (constraintLayout3 != null) {
                            TextView textView2 = (TextView) view2.findViewById(R.id.contactInitials);
                            if (textView2 != null) {
                                ImageView imageView = (ImageView) view2.findViewById(R.id.image);
                                if (imageView != null) {
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view2.findViewById(R.id.imageLayout);
                                    if (constraintLayout4 != null) {
                                        TextView textView3 = (TextView) view2.findViewById(R.id.name);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view2.findViewById(R.id.proceed);
                                            if (textView4 != null) {
                                                View findViewById = view2.findViewById(R.id.separator);
                                                if (findViewById != null) {
                                                    TextView textView5 = (TextView) view2.findViewById(R.id.transferFrom);
                                                    if (textView5 != null) {
                                                        TextView textView6 = (TextView) view2.findViewById(R.id.upiId);
                                                        if (textView6 != null) {
                                                            return new v((ConstraintLayout) view2, constraintLayout, recyclerView, constraintLayout2, textView, constraintLayout3, textView2, imageView, constraintLayout4, textView3, textView4, findViewById, textView5, textView6);
                                                        }
                                                        str = "upiId";
                                                    } else {
                                                        str = "transferFrom";
                                                    }
                                                } else {
                                                    str = "separator";
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
