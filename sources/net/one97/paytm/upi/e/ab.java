package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f66728a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f66729b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f66730c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66731d;

    /* renamed from: e  reason: collision with root package name */
    public final c f66732e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f66733f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f66734g;

    /* renamed from: h  reason: collision with root package name */
    public final CircularImageView f66735h;

    /* renamed from: i  reason: collision with root package name */
    public final ConstraintLayout f66736i;
    public final TextView j;
    public final View k;
    public final TextView l;
    public final TextView m;
    private final ConstraintLayout n;

    private ab(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ConstraintLayout constraintLayout3, TextView textView, c cVar, TextView textView2, TextView textView3, CircularImageView circularImageView, ConstraintLayout constraintLayout4, TextView textView4, View view, TextView textView5, TextView textView6) {
        this.n = constraintLayout;
        this.f66728a = constraintLayout2;
        this.f66729b = recyclerView;
        this.f66730c = constraintLayout3;
        this.f66731d = textView;
        this.f66732e = cVar;
        this.f66733f = textView2;
        this.f66734g = textView3;
        this.f66735h = circularImageView;
        this.f66736i = constraintLayout4;
        this.j = textView4;
        this.k = view;
        this.l = textView5;
        this.m = textView6;
    }

    public static ab a(View view) {
        View view2 = view;
        ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.accountContainerLayout);
        String str = "bottomColorLayout";
        if (constraintLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.accountsRecyclerView);
            if (recyclerView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.accountsTopLayout);
                if (constraintLayout2 != null) {
                    TextView textView = (TextView) view2.findViewById(R.id.addBankAccount);
                    if (textView != null) {
                        View findViewById = view2.findViewById(R.id.bottomColorLayout);
                        if (findViewById != null) {
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById.findViewById(R.id.bottomColorLayout);
                            if (constraintLayout3 != null) {
                                View findViewById2 = findViewById.findViewById(R.id.rel_light_blue);
                                if (findViewById2 != null) {
                                    TextView textView2 = (TextView) findViewById.findViewById(R.id.tooltipMessage);
                                    if (textView2 != null) {
                                        c cVar = new c((ConstraintLayout) findViewById, constraintLayout3, findViewById2, textView2);
                                        TextView textView3 = (TextView) view2.findViewById(R.id.contactInitials);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view2.findViewById(R.id.description);
                                            if (textView4 != null) {
                                                CircularImageView circularImageView = (CircularImageView) view2.findViewById(R.id.image);
                                                if (circularImageView != null) {
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view2.findViewById(R.id.imageLayout);
                                                    if (constraintLayout4 != null) {
                                                        TextView textView5 = (TextView) view2.findViewById(R.id.name);
                                                        if (textView5 != null) {
                                                            View findViewById3 = view2.findViewById(R.id.separator);
                                                            if (findViewById3 != null) {
                                                                TextView textView6 = (TextView) view2.findViewById(R.id.transferFrom);
                                                                if (textView6 != null) {
                                                                    TextView textView7 = (TextView) view2.findViewById(R.id.upiId);
                                                                    if (textView7 != null) {
                                                                        return new ab((ConstraintLayout) view2, constraintLayout, recyclerView, constraintLayout2, textView, cVar, textView3, textView4, circularImageView, constraintLayout4, textView5, findViewById3, textView6, textView7);
                                                                    }
                                                                    str = "upiId";
                                                                } else {
                                                                    str = "transferFrom";
                                                                }
                                                            } else {
                                                                str = "separator";
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
                                                str = RequestConfirmationDialogFragment.KEY_DESCRIPTION;
                                            }
                                        } else {
                                            str = "contactInitials";
                                        }
                                    } else {
                                        str = "tooltipMessage";
                                    }
                                } else {
                                    str = "relLightBlue";
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(str));
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
