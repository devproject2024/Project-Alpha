package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.paytm.utility.t;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.f.b;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public class m extends d implements o {

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64169h;

    public final View a(int i2) {
        if (this.f64169h == null) {
            this.f64169h = new HashMap();
        }
        View view = (View) this.f64169h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64169h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f64169h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_ott_order_details, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public final void a(View view, Bundle bundle) {
        FrameLayout frameLayout;
        k.c(view, "view");
        CJROrderedCart u = e().u();
        if (u == null) {
            k.a();
        }
        if (e().s && e().d()) {
            a();
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.operator_logo);
        TextView textView = (TextView) view.findViewById(R.id.operator_name);
        TextView textView2 = (TextView) view.findViewById(R.id.recharge_number);
        TextView textView3 = (TextView) view.findViewById(R.id.operator_message);
        TextView textView4 = (TextView) view.findViewById(R.id.recharge_order_id);
        TextView textView5 = (TextView) view.findViewById(R.id.recharge_order_time);
        k.a((Object) textView, "operatorName");
        net.one97.paytm.recharge.ordersummary.b.a e2 = e();
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        textView.setText(e2.T(context));
        net.one97.paytm.recharge.ordersummary.b.a e3 = e();
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        CharSequence Q = e3.Q(context2);
        if (!TextUtils.isEmpty(Q)) {
            k.a((Object) textView2, "rechargeNumber");
            textView2.setText(Q);
        } else {
            k.a((Object) textView2, "rechargeNumber");
            textView2.setVisibility(8);
        }
        CJROrderedCart u2 = e().u();
        Object metaDataResponse = u2 != null ? u2.getMetaDataResponse() : null;
        if (!(metaDataResponse instanceof Map)) {
            metaDataResponse = null;
        }
        Map map = (Map) metaDataResponse;
        if (map != null) {
            if (map.containsKey("plan_name")) {
                CharSequence charSequence = (String) map.get("plan_name");
                boolean isEmpty = TextUtils.isEmpty(charSequence);
                if (isEmpty) {
                    TextView textView6 = (TextView) a(R.id.plan_name);
                    if (textView6 != null) {
                        ai.b(textView6);
                    }
                } else if (!isEmpty) {
                    TextView textView7 = (TextView) a(R.id.plan_name);
                    if (textView7 != null) {
                        textView7.setText(charSequence);
                    }
                    TextView textView8 = (TextView) a(R.id.plan_name);
                    if (textView8 != null) {
                        ai.a(textView8);
                    }
                }
            } else {
                TextView textView9 = (TextView) a(R.id.plan_name);
                if (textView9 != null) {
                    ai.b(textView9);
                }
            }
            if (map.containsKey("is_subscription")) {
                String str = (String) map.get("is_subscription");
                if (str != null && str.hashCode() == 49 && str.equals("1")) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.lyt_subscription);
                    if (constraintLayout != null) {
                        ai.a(constraintLayout);
                    }
                    if (map.containsKey("due_date")) {
                        boolean isEmpty2 = TextUtils.isEmpty((CharSequence) map.get("due_date"));
                        if (!isEmpty2) {
                            TextView textView10 = (TextView) a(R.id.text_due_date);
                            if (textView10 != null) {
                                textView10.setText(getString(R.string.payment_due, map.get("due_date")));
                            }
                            TextView textView11 = (TextView) a(R.id.text_due_date);
                            if (textView11 != null) {
                                ai.a(textView11);
                            }
                        } else if (isEmpty2) {
                            TextView textView12 = (TextView) a(R.id.text_due_date);
                            if (textView12 != null) {
                                ai.b(textView12);
                            }
                        } else {
                            throw new kotlin.m();
                        }
                    } else {
                        TextView textView13 = (TextView) a(R.id.text_due_date);
                        if (textView13 != null) {
                            ai.b(textView13);
                        }
                    }
                } else {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.lyt_subscription);
                    if (constraintLayout2 != null) {
                        ai.b(constraintLayout2);
                    }
                }
            } else {
                ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.lyt_subscription);
                if (constraintLayout3 != null) {
                    ai.b(constraintLayout3);
                }
            }
        }
        k.a((Object) textView4, "rechargeOrderId");
        net.one97.paytm.recharge.ordersummary.b.a e4 = e();
        Context context3 = getContext();
        if (context3 == null) {
            k.a();
        }
        k.a((Object) context3, "context!!");
        textView4.setText(e4.o(context3));
        k.a((Object) textView5, "rechargeOrderTime");
        net.one97.paytm.recharge.ordersummary.b.a e5 = e();
        Context context4 = getContext();
        if (context4 == null) {
            k.a();
        }
        k.a((Object) context4, "context!!");
        textView5.setText(e5.n(context4));
        CJROSActionResponseV2 cJROSActionResponseV2 = e().m.get(Long.valueOf(u.getId()));
        net.one97.paytm.recharge.ordersummary.b.a e6 = e();
        Context context5 = getContext();
        if (context5 == null) {
            k.a();
        }
        k.a((Object) context5, "context!!");
        CharSequence b2 = e6.b(context5, cJROSActionResponseV2);
        if (!TextUtils.isEmpty(b2)) {
            this.f64154e = true;
            k.a((Object) textView3, "operatorMessage");
            textView3.setText(b2);
            textView3.setVisibility(0);
        }
        if (getParentFragment() != null && (getParentFragment() instanceof b)) {
            CJRRechargeItemActionsListView.b bVar = CJRRechargeItemActionsListView.f64530e;
            Context context6 = getContext();
            if (context6 == null) {
                k.a();
            }
            k.a((Object) context6, "context!!");
            net.one97.paytm.recharge.ordersummary.b.a e7 = e();
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f64156g = CJRRechargeItemActionsListView.b.a(context6, 2, 3, u, e7, (b) parentFragment, false, false, 192);
                if (!(this.f64156g == null || (frameLayout = (FrameLayout) a(R.id.lyt_actions)) == null)) {
                    frameLayout.addView(this.f64156g);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
            }
        }
        this.f64153d = true;
        b();
        String c2 = e().c(u);
        if (!TextUtils.isEmpty(c2)) {
            try {
                w.a().a(c2).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), 0, true)).a(R.color.color_909090).a(imageView, (e) new a(this));
            } catch (Exception unused) {
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 != null) {
                    parentFragment2.startPostponedEnterTransition();
                }
            }
        } else {
            Fragment parentFragment3 = getParentFragment();
            if (parentFragment3 != null) {
                parentFragment3.startPostponedEnterTransition();
            }
        }
    }

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f64170a;

        a(m mVar) {
            this.f64170a = mVar;
        }

        public final void onSuccess() {
            Fragment parentFragment = this.f64170a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }

        public final void onError(Exception exc) {
            k.c(exc, "e");
            Fragment parentFragment = this.f64170a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }
    }
}
