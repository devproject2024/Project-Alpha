package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.paytm.utility.t;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.b.d;
import net.one97.paytm.recharge.common.h.f;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.f.b;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public class k extends Fragment implements o {

    /* renamed from: a  reason: collision with root package name */
    protected a f64162a;

    /* renamed from: b  reason: collision with root package name */
    protected CJROrderSummary f64163b;

    /* renamed from: c  reason: collision with root package name */
    CJRRechargeItemActionsListView f64164c;

    /* renamed from: d  reason: collision with root package name */
    private f f64165d;

    /* renamed from: e  reason: collision with root package name */
    private CJRRechargeItemActionsListView f64166e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f64167f;

    public void a() {
        HashMap hashMap = this.f64167f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View b(int i2) {
        if (this.f64167f == null) {
            this.f64167f = new HashMap();
        }
        View view = (View) this.f64167f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64167f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    /* access modifiers changed from: protected */
    public final a b() {
        a aVar = this.f64162a;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_storefront_mobile, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof AJRechargeOrderSummaryActivity) {
            CJRRechargeUtilities.INSTANCE.debugLog("mobile-storefront get viewModel from Activity");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.f64162a = ((AJRechargeOrderSummaryActivity) activity).l();
                a aVar = this.f64162a;
                if (aVar == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                CJROrderSummary cJROrderSummary = aVar.f63998b;
                if (cJROrderSummary == null) {
                    kotlin.g.b.k.a();
                }
                this.f64163b = cJROrderSummary;
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    kotlin.g.b.k.a((Object) activity2, "it");
                    Context applicationContext = activity2.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext, "it.applicationContext");
                    this.f64165d = (f) am.a(activity2, (al.b) new net.one97.paytm.recharge.common.h.a(d.b(applicationContext), d.d(activity2))).a(f.class);
                }
                if (getView() != null) {
                    View view = getView();
                    if (view == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) view, "view!!");
                    a(view);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
        CJRRechargeUtilities.INSTANCE.debugLog("mobile-storefront no implementation to get viewModel: Default returning to home");
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        FrameLayout frameLayout;
        View view2 = view;
        kotlin.g.b.k.c(view2, "view");
        ImageView imageView = (ImageView) view2.findViewById(R.id.operator_logo);
        TextView textView = (TextView) view2.findViewById(R.id.operator_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.recharge_number);
        TextView textView3 = (TextView) view2.findViewById(R.id.operator_message);
        kotlin.g.b.k.a((Object) textView, "operatorName");
        a aVar = this.f64162a;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        textView.setText(aVar.R(context));
        kotlin.g.b.k.a((Object) textView2, "rechargeNumber");
        a aVar2 = this.f64162a;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        Context context2 = getContext();
        if (context2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context2, "context!!");
        textView2.setText(aVar2.Q(context2));
        a aVar3 = this.f64162a;
        if (aVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        CJROrderedCart u = aVar3.u();
        if (u == null) {
            kotlin.g.b.k.a();
        }
        a aVar4 = this.f64162a;
        if (aVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        CJROSActionResponseV2 cJROSActionResponseV2 = aVar4.m.get(Long.valueOf(u.getId()));
        a aVar5 = this.f64162a;
        if (aVar5 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        Context context3 = getContext();
        if (context3 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context3, "context!!");
        CharSequence b2 = aVar5.b(context3, cJROSActionResponseV2);
        if (!TextUtils.isEmpty(b2)) {
            kotlin.g.b.k.a((Object) textView3, "operatorMessage");
            textView3.setText(b2);
            textView3.setVisibility(0);
        }
        if (getParentFragment() != null && (getParentFragment() instanceof b)) {
            CJRRechargeItemActionsListView.b bVar = CJRRechargeItemActionsListView.f64530e;
            Context context4 = getContext();
            if (context4 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context4, "context!!");
            a aVar6 = this.f64162a;
            if (aVar6 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f64164c = CJRRechargeItemActionsListView.b.a(context4, 1, 1, u, aVar6, (b) parentFragment, false, false, 192);
                if (!(this.f64164c == null || (frameLayout = (FrameLayout) b(R.id.lyt_actions)) == null)) {
                    frameLayout.addView(this.f64164c);
                }
                CJRRechargeItemActionsListView.b bVar2 = CJRRechargeItemActionsListView.f64530e;
                Context context5 = getContext();
                if (context5 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context5, "context!!");
                a aVar7 = this.f64162a;
                if (aVar7 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 != null) {
                    this.f64166e = CJRRechargeItemActionsListView.b.a(context5, 1, 1, u, aVar7, (b) parentFragment2, false, true, 64);
                    if (this.f64166e != null) {
                        FrameLayout frameLayout2 = (FrameLayout) b(R.id.lyt_vertical_actions);
                        if (frameLayout2 != null) {
                            ai.a(frameLayout2);
                        }
                        FrameLayout frameLayout3 = (FrameLayout) b(R.id.lyt_vertical_actions);
                        if (frameLayout3 != null) {
                            frameLayout3.addView(this.f64166e);
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
            }
        }
        a aVar8 = this.f64162a;
        if (aVar8 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String c2 = aVar8.c(u);
        if (!TextUtils.isEmpty(c2)) {
            try {
                w.a().a(c2).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), 0, true)).a(R.color.color_ffffff).a(imageView);
            } catch (Exception unused) {
            }
        }
    }

    public Map<String, View> getSharedElementMap() {
        HashMap hashMap = new HashMap(1);
        if (((CJRCircleImageViewV8) b(R.id.operator_logo)) == null) {
            return hashMap;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Map map = hashMap;
                String x = androidx.core.h.u.x((CJRCircleImageViewV8) b(R.id.operator_logo));
                if (x == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) x, "ViewCompat.getTransitionName(operator_logo)!!");
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) b(R.id.operator_logo);
                kotlin.g.b.k.a((Object) cJRCircleImageViewV8, "operator_logo");
                map.put(x, cJRCircleImageViewV8);
                Map map2 = hashMap;
                String x2 = androidx.core.h.u.x((TextView) b(R.id.operator_name));
                if (x2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) x2, "ViewCompat.getTransitionName(operator_name)!!");
                TextView textView = (TextView) b(R.id.operator_name);
                kotlin.g.b.k.a((Object) textView, "operator_name");
                map2.put(x2, textView);
                Map map3 = hashMap;
                String x3 = androidx.core.h.u.x((TextView) b(R.id.recharge_number));
                if (x3 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) x3, "ViewCompat.getTransitionName(recharge_number)!!");
                TextView textView2 = (TextView) b(R.id.recharge_number);
                kotlin.g.b.k.a((Object) textView2, "recharge_number");
                map3.put(x3, textView2);
                Map map4 = hashMap;
                String x4 = androidx.core.h.u.x((TextView) b(R.id.operator_message));
                if (x4 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) x4, "ViewCompat.getTransitionName(operator_message)!!");
                TextView textView3 = (TextView) b(R.id.operator_message);
                kotlin.g.b.k.a((Object) textView3, "operator_message");
                map4.put(x4, textView3);
                Map map5 = hashMap;
                String x5 = androidx.core.h.u.x(b(R.id.bg_operator_logo));
                if (x5 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) x5, "ViewCompat.getTransitionName(bg_operator_logo)!!");
                View b2 = b(R.id.bg_operator_logo);
                kotlin.g.b.k.a((Object) b2, "bg_operator_logo");
                map5.put(x5, b2);
            } catch (Exception unused) {
            }
        }
        CJRRechargeItemActionsListView cJRRechargeItemActionsListView = this.f64164c;
        if (cJRRechargeItemActionsListView != null) {
            if (cJRRechargeItemActionsListView == null) {
                kotlin.g.b.k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView.getSharedElementMap());
        }
        CJRRechargeItemActionsListView cJRRechargeItemActionsListView2 = this.f64166e;
        if (cJRRechargeItemActionsListView2 != null) {
            if (cJRRechargeItemActionsListView2 == null) {
                kotlin.g.b.k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView2.getSharedElementMap());
        }
        return hashMap;
    }
}
