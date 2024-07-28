package net.one97.paytm.recharge.ordersummary.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.j;
import io.reactivex.rxjava3.j.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.f.l;

public class CJRPaymentReminderWidgetV8 extends ConstraintLayout implements net.one97.paytm.recharge.ordersummary.f.b {

    /* renamed from: a  reason: collision with root package name */
    private CJROrderSummaryProductDetail f64490a;

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f64491b;

    /* renamed from: c  reason: collision with root package name */
    private final CJROrderedCart f64492c;

    /* renamed from: d  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.f.b f64493d;

    /* renamed from: e  reason: collision with root package name */
    private final int f64494e;

    /* renamed from: f  reason: collision with root package name */
    private final CJRAutomaticSubscriptionCheckModel f64495f = null;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64496g;

    public final View a(int i2) {
        if (this.f64496g == null) {
            this.f64496g = new HashMap();
        }
        View view = (View) this.f64496g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64496g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final androidx.fragment.app.b a(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, int i2, View.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "insuranceItem");
        k.c(onClickListener, "tapActionHandler");
        return this.f64493d.a(aVar, cJROrderedCart, i2, onClickListener, onDismissListener);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.f64493d.a(onClickListener);
    }

    public final void a(DialogInterface dialogInterface, CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener) {
        k.c(cJROrderSummaryAction, "action");
        this.f64493d.a(dialogInterface, cJROrderSummaryAction, onDismissListener);
    }

    public final void a(String str) {
        k.c(str, "deeplink");
        this.f64493d.a(str);
    }

    public final void a(String str, String str2) {
        k.c(str, "actionType");
        this.f64493d.a(str, str2);
    }

    public final void a(String str, String str2, String str3) {
        this.f64493d.a(str, str2, str3);
    }

    public final void a(HashMap<String, View> hashMap) {
        k.c(hashMap, "sharedElementsMap");
        this.f64493d.a(hashMap);
    }

    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        k.c(cJROrderSummaryAction, "action");
        this.f64493d.a(cJROrderSummaryAction);
    }

    public final void a(CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener) {
        k.c(cJROrderSummaryAction, "action");
        this.f64493d.a(cJROrderSummaryAction, onDismissListener);
    }

    public final void a(CJROrderedCart cJROrderedCart, String str) {
        k.c(cJROrderedCart, "orderedItem");
        k.c(str, "action");
        this.f64493d.a(cJROrderedCart, str);
    }

    public final void a(net.one97.paytm.recharge.ordersummary.b.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        k.c(aVar, "viewModel");
        this.f64493d.a(aVar, onDismissListener);
    }

    public final void a(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart) {
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedItem");
        this.f64493d.a(aVar, cJROrderedCart);
    }

    public final void a(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, Bundle bundle) {
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedItem");
        k.c(bundle, "itemArgs");
        this.f64493d.a(aVar, cJROrderedCart, bundle);
    }

    public final void at_() {
        this.f64493d.at_();
    }

    public final void b(String str) {
        this.f64493d.b(str);
    }

    public final void b(String str, String str2) {
        k.c(str, "itncTitle");
        this.f64493d.b(str, str2);
    }

    public final void b(l lVar) {
        this.f64493d.b(lVar);
    }

    public final void f(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        this.f64493d.f(cJROrderedCart);
    }

    public CJROrderActionsListView getOrderActionClickListener() {
        return this.f64493d.getOrderActionClickListener();
    }

    public j getSupportFragmentManager() {
        return this.f64493d.getSupportFragmentManager();
    }

    public final void o() {
        this.f64493d.o();
    }

    public final void p() {
        this.f64493d.p();
    }

    public void setBillConsent(CJROrderSummaryAction cJROrderSummaryAction) {
        k.c(cJROrderSummaryAction, "action");
        this.f64493d.setBillConsent(cJROrderSummaryAction);
    }

    public void setupAutoPay(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, CJROrderSummaryAction cJROrderSummaryAction) {
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedCart");
        k.c(cJROrderSummaryAction, "action");
        this.f64493d.setupAutoPay(aVar, cJROrderedCart, cJROrderSummaryAction);
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f64491b;
    }

    public final CJROrderedCart getOrderedCart() {
        return this.f64492c;
    }

    public final net.one97.paytm.recharge.ordersummary.f.b getActionsListener() {
        return this.f64493d;
    }

    public final int getActionVisibility() {
        return this.f64494e;
    }

    public final CJRAutomaticSubscriptionCheckModel getResponse() {
        return this.f64495f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRPaymentReminderWidgetV8(Context context, net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.f.b bVar, int i2) {
        super(context);
        List<CJROSActionItemV2> orderLevelWidgets;
        k.c(context, "context");
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedCart");
        k.c(bVar, "actionsListener");
        this.f64491b = aVar;
        this.f64492c = cJROrderedCart;
        this.f64493d = bVar;
        this.f64494e = i2;
        List list = null;
        setBackgroundColor(androidx.core.content.b.c(context, R.color.white));
        LayoutInflater.from(context).inflate(R.layout.content_os_payment_reminder_add_new_v8, this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f64490a = this.f64492c.getProductDetail();
        CJROSActionResponseV2 cJROSActionResponseV2 = this.f64491b.m.get(Long.valueOf(this.f64492c.getId()));
        if (!(cJROSActionResponseV2 == null || (orderLevelWidgets = cJROSActionResponseV2.getOrderLevelWidgets()) == null)) {
            Collection arrayList = new ArrayList();
            for (Object next : orderLevelWidgets) {
                CJROSActionItemV2 cJROSActionItemV2 = (CJROSActionItemV2) next;
                if (k.a((Object) CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC(), (Object) cJROSActionItemV2.getmType()) && this.f64491b.a(cJROSActionItemV2, this.f64494e, false)) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        }
        if (this.f64495f == null || list == null || !(!list.isEmpty())) {
            try {
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_lyt);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.a();
                }
                ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.shimmer_lyt);
                if (shimmerFrameLayout2 != null) {
                    ai.a(shimmerFrameLayout2);
                }
                Group group = (Group) a(R.id.automatic_view);
                if (group != null) {
                    ai.b(group);
                }
            } catch (Exception unused) {
            }
        } else {
            a((CJROSActionItemV2) list.get(0));
            a();
        }
    }

    private void a(CJROSActionItemV2 cJROSActionItemV2) {
        CharSequence charSequence;
        k.c(cJROSActionItemV2, "automaticWidget");
        View findViewById = findViewById(R.id.txt_alert_msg);
        k.a((Object) findViewById, "findViewById<TextView>(R.id.txt_alert_msg)");
        TextView textView = (TextView) findViewById;
        String label = cJROSActionItemV2.getLabel();
        textView.setText(label != null ? label : "");
        View findViewById2 = findViewById(R.id.txt_alert_description);
        k.a((Object) findViewById2, "findViewById<TextView>(R.id.txt_alert_description)");
        TextView textView2 = (TextView) findViewById2;
        String message = cJROSActionItemV2.getMessage();
        if (message != null) {
            charSequence = message;
        } else {
            charSequence = "";
        }
        textView2.setText(charSequence);
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities.debugLog(CJRPaymentReminderWidgetV8.class.getSimpleName() + " initViews");
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.lyt_actions);
        List<CJROSActionItemV2> actions = cJROSActionItemV2.getActions();
        if (actions != null && (!actions.isEmpty())) {
            Context context = getContext();
            k.a((Object) context, "context");
            CJROrderedCart cJROrderedCart = this.f64492c;
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64491b;
            List<CJROSActionItemV2> actions2 = cJROSActionItemV2.getActions();
            if (actions2 == null) {
                k.a();
            }
            frameLayout.addView(new CJRRechargeItemActionsListView(context, cJROrderedCart, aVar, actions2, this));
        }
    }

    public final boolean a(String str, e<String> eVar, e<String> eVar2) {
        k.c(str, "type");
        k.c(eVar, "enableActionObservable");
        k.c(eVar2, "disableActionObservable");
        if (k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC())) {
            return true;
        }
        return this.f64493d.a(str, eVar, eVar2);
    }

    public void setAutomaticResponse(CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel) {
        List list;
        List<CJROSActionItemV2> orderLevelWidgets;
        if (cJRAutomaticSubscriptionCheckModel != null) {
            a();
            CJROSActionResponseV2 cJROSActionResponseV2 = this.f64491b.m.get(Long.valueOf(this.f64492c.getId()));
            if (cJROSActionResponseV2 == null || (orderLevelWidgets = cJROSActionResponseV2.getOrderLevelWidgets()) == null) {
                list = null;
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : orderLevelWidgets) {
                    CJROSActionItemV2 cJROSActionItemV2 = (CJROSActionItemV2) next;
                    if (k.a((Object) CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC(), (Object) cJROSActionItemV2.getmType()) && this.f64491b.a(cJROSActionItemV2, this.f64494e, false)) {
                        arrayList.add(next);
                    }
                }
                list = (List) arrayList;
            }
            if (list != null && (!list.isEmpty())) {
                a((CJROSActionItemV2) list.get(0));
                return;
            }
            return;
        }
        CJRPaymentReminderWidgetV8 cJRPaymentReminderWidgetV8 = this;
        cJRPaymentReminderWidgetV8.a();
        ai.b(cJRPaymentReminderWidgetV8);
    }

    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRPaymentReminderWidgetV8 f64497a;

        a(CJRPaymentReminderWidgetV8 cJRPaymentReminderWidgetV8) {
            this.f64497a = cJRPaymentReminderWidgetV8;
        }

        public final void onAnimationEnd(Animator animator) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f64497a.a(R.id.shimmer_lyt);
            if (shimmerFrameLayout != null) {
                ai.b(shimmerFrameLayout);
            }
        }
    }

    private void a() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator alpha2;
        ViewPropertyAnimator duration2;
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_lyt);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.shimmer_lyt);
            if (!(shimmerFrameLayout2 == null || (animate2 = shimmerFrameLayout2.animate()) == null || (alpha2 = animate2.alpha(0.0f)) == null || (duration2 = alpha2.setDuration(300)) == null)) {
                duration2.setListener(new a(this));
            }
            Group group = (Group) a(R.id.automatic_view);
            if (group != null && (animate = group.animate()) != null && (alpha = animate.alpha(1.0f)) != null && (duration = alpha.setDuration(300)) != null) {
                duration.setListener(new b(this));
            }
        } catch (Exception unused) {
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRPaymentReminderWidgetV8 f64498a;

        b(CJRPaymentReminderWidgetV8 cJRPaymentReminderWidgetV8) {
            this.f64498a = cJRPaymentReminderWidgetV8;
        }

        public final void onAnimationEnd(Animator animator) {
            Group group = (Group) this.f64498a.a(R.id.automatic_view);
            if (group != null) {
                ai.a(group);
            }
        }
    }
}
