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
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.f.b;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public final class n extends e implements o {

    /* renamed from: d  reason: collision with root package name */
    private HashMap f64171d;

    public final void a() {
        HashMap hashMap = this.f64171d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View b(int i2) {
        if (this.f64171d == null) {
            this.f64171d = new HashMap();
        }
        View view = (View) this.f64171d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64171d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_ott_storefront, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        FrameLayout frameLayout;
        View view2 = view;
        k.c(view2, "view");
        ImageView imageView = (ImageView) view2.findViewById(R.id.operator_logo);
        TextView textView = (TextView) view2.findViewById(R.id.operator_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.recharge_number);
        TextView textView3 = (TextView) view2.findViewById(R.id.operator_message);
        k.a((Object) textView, "operatorName");
        a b2 = b();
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        textView.setText(b2.R(context));
        a b3 = b();
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        CharSequence Q = b3.Q(context2);
        if (!TextUtils.isEmpty(Q)) {
            k.a((Object) textView2, "rechargeNumber");
            textView2.setText(Q);
        } else {
            k.a((Object) textView2, "rechargeNumber");
            textView2.setVisibility(8);
        }
        CJROrderedCart u = b().u();
        Object metaDataResponse = u != null ? u.getMetaDataResponse() : null;
        if (!(metaDataResponse instanceof Map)) {
            metaDataResponse = null;
        }
        Map map = (Map) metaDataResponse;
        if (map != null) {
            if (map.containsKey("plan_name")) {
                CharSequence charSequence = (String) map.get("plan_name");
                boolean isEmpty = TextUtils.isEmpty(charSequence);
                if (isEmpty) {
                    TextView textView4 = (TextView) b(R.id.plan_name);
                    if (textView4 != null) {
                        ai.b(textView4);
                    }
                } else if (!isEmpty) {
                    TextView textView5 = (TextView) b(R.id.plan_name);
                    if (textView5 != null) {
                        textView5.setText(charSequence);
                    }
                    TextView textView6 = (TextView) b(R.id.plan_name);
                    if (textView6 != null) {
                        ai.a(textView6);
                    }
                }
            } else {
                TextView textView7 = (TextView) b(R.id.plan_name);
                if (textView7 != null) {
                    ai.b(textView7);
                }
            }
            if (map.containsKey("is_subscription")) {
                String str = (String) map.get("is_subscription");
                if (str != null && str.hashCode() == 49 && str.equals("1")) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) b(R.id.lyt_subscription);
                    if (constraintLayout != null) {
                        ai.a(constraintLayout);
                    }
                    if (map.containsKey("due_date")) {
                        boolean isEmpty2 = TextUtils.isEmpty((CharSequence) map.get("due_date"));
                        if (!isEmpty2) {
                            TextView textView8 = (TextView) b(R.id.text_due_date);
                            if (textView8 != null) {
                                textView8.setText(getString(R.string.payment_due, map.get("due_date")));
                            }
                            TextView textView9 = (TextView) b(R.id.text_due_date);
                            if (textView9 != null) {
                                ai.a(textView9);
                            }
                        } else if (isEmpty2) {
                            TextView textView10 = (TextView) b(R.id.text_due_date);
                            if (textView10 != null) {
                                ai.b(textView10);
                            }
                        } else {
                            throw new m();
                        }
                    } else {
                        TextView textView11 = (TextView) b(R.id.text_due_date);
                        if (textView11 != null) {
                            ai.b(textView11);
                        }
                    }
                } else {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) b(R.id.lyt_subscription);
                    if (constraintLayout2 != null) {
                        ai.b(constraintLayout2);
                    }
                }
            } else {
                ConstraintLayout constraintLayout3 = (ConstraintLayout) b(R.id.lyt_subscription);
                if (constraintLayout3 != null) {
                    ai.b(constraintLayout3);
                }
            }
        }
        CJROrderedCart u2 = b().u();
        if (u2 == null) {
            k.a();
        }
        CJROSActionResponseV2 cJROSActionResponseV2 = b().m.get(Long.valueOf(u2.getId()));
        a b4 = b();
        Context context3 = getContext();
        if (context3 == null) {
            k.a();
        }
        k.a((Object) context3, "context!!");
        CharSequence b5 = b4.b(context3, cJROSActionResponseV2);
        if (!TextUtils.isEmpty(b5)) {
            k.a((Object) textView3, "operatorMessage");
            textView3.setText(b5);
            textView3.setVisibility(0);
        }
        if (getParentFragment() != null && (getParentFragment() instanceof b)) {
            CJRRechargeItemActionsListView.b bVar = CJRRechargeItemActionsListView.f64530e;
            Context context4 = getContext();
            if (context4 == null) {
                k.a();
            }
            k.a((Object) context4, "context!!");
            a b6 = b();
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f64164c = CJRRechargeItemActionsListView.b.a(context4, 1, 1, u2, b6, (b) parentFragment, false, false, 192);
                if (!(this.f64164c == null || (frameLayout = (FrameLayout) b(R.id.lyt_actions)) == null)) {
                    frameLayout.addView(this.f64164c);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
            }
        }
        String c2 = b().c(u2);
        if (!TextUtils.isEmpty(c2)) {
            try {
                w.a().a(c2).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), 0, true)).a(R.color.color_ffffff).a(imageView);
            } catch (Exception unused) {
            }
        }
    }
}
