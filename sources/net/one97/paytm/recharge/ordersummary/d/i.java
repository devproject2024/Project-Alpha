package net.one97.paytm.recharge.ordersummary.d;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.j;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class i extends k implements h<Throwable>, j, o {

    /* renamed from: d  reason: collision with root package name */
    private boolean f64146d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f64147e;

    /* renamed from: f  reason: collision with root package name */
    private String f64148f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64149g;

    public final void a() {
        HashMap hashMap = this.f64149g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View b(int i2) {
        if (this.f64149g == null) {
            this.f64149g = new HashMap();
        }
        View view = (View) this.f64149g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64149g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_storefront_metro_smart_card, viewGroup, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: java.util.List} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r13) {
        /*
            r12 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r13, r0)
            int r0 = net.one97.paytm.recharge.R.id.operator_logo
            android.view.View r0 = r13.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r1 = net.one97.paytm.recharge.R.id.operator_name
            android.view.View r1 = r13.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.recharge.R.id.recharge_number
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = net.one97.paytm.recharge.R.id.operator_message
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "operatorName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            net.one97.paytm.recharge.ordersummary.b.a r4 = r12.b()
            android.content.Context r5 = r12.getContext()
            if (r5 != 0) goto L_0x0037
            kotlin.g.b.k.a()
        L_0x0037:
            java.lang.String r6 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r4 = r4.R(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r12.b()
            android.content.Context r4 = r12.getContext()
            if (r4 != 0) goto L_0x0052
            kotlin.g.b.k.a()
        L_0x0052:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r1 = r1.Q(r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r5 = "rechargeNumber"
            if (r4 != 0) goto L_0x006a
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r2.setText(r1)
            goto L_0x0072
        L_0x006a:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r1 = 8
            r2.setVisibility(r1)
        L_0x0072:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r12.b()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r1.u()
            if (r1 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            net.one97.paytm.recharge.ordersummary.b.a r2 = r12.b()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r2 = r2.m
            long r4 = r1.getId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r2 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r2
            net.one97.paytm.recharge.ordersummary.b.a r4 = r12.b()
            android.content.Context r5 = r12.getContext()
            if (r5 != 0) goto L_0x00a0
            kotlin.g.b.k.a()
        L_0x00a0:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.text.SpannableString r4 = r4.b((android.content.Context) r5, (net.one97.paytm.recharge.model.CJROSActionResponseV2) r2)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            r6 = 0
            if (r5 != 0) goto L_0x00bb
            java.lang.String r5 = "operatorMessage"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            r3.setText(r4)
            r3.setVisibility(r6)
        L_0x00bb:
            androidx.fragment.app.Fragment r3 = r12.getParentFragment()
            r4 = 3
            r5 = 0
            r7 = 1
            if (r3 == 0) goto L_0x0161
            androidx.fragment.app.Fragment r3 = r12.getParentFragment()
            boolean r3 = r3 instanceof net.one97.paytm.recharge.ordersummary.f.b
            if (r3 == 0) goto L_0x0161
            if (r2 == 0) goto L_0x011d
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r3 = r2.getItemLevelActions()
            if (r3 == 0) goto L_0x011d
            java.util.List r3 = r3.getActions()
            if (r3 == 0) goto L_0x011d
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r3 = r3.iterator()
        L_0x00e7:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x0119
            java.lang.Object r9 = r3.next()
            r10 = r9
            net.one97.paytm.recharge.model.CJROSActionItemV2 r10 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r10
            int r11 = r10.getVisibility()
            if (r11 == r7) goto L_0x0100
            int r11 = r10.getVisibility()
            if (r11 != r4) goto L_0x0112
        L_0x0100:
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r11 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r11 = r11.getACTION_TYPE_VIEW_DETAILS()
            java.lang.String r10 = r10.getmType()
            boolean r10 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r10, (boolean) r7)
            if (r10 == 0) goto L_0x0112
            r10 = 1
            goto L_0x0113
        L_0x0112:
            r10 = 0
        L_0x0113:
            if (r10 == 0) goto L_0x00e7
            r8.add(r9)
            goto L_0x00e7
        L_0x0119:
            r3 = r8
            java.util.List r3 = (java.util.List) r3
            goto L_0x011e
        L_0x011d:
            r3 = r5
        L_0x011e:
            if (r3 == 0) goto L_0x0161
            int r8 = r3.size()
            if (r8 != r7) goto L_0x0161
            int r8 = net.one97.paytm.recharge.R.id.action_divider
            android.view.View r8 = r13.findViewById(r8)
            java.lang.String r9 = "view.findViewById<View>(R.id.action_divider)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r8.setVisibility(r6)
            int r8 = net.one97.paytm.recharge.R.id.action_next
            android.view.View r8 = r13.findViewById(r8)
            java.lang.String r9 = "view.findViewById<View>(R.id.action_next)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r8.setVisibility(r6)
            int r8 = net.one97.paytm.recharge.R.id.action_view
            android.view.View r13 = r13.findViewById(r8)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r8 = "actionView"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r8)
            r13.setVisibility(r6)
            java.lang.Object r3 = r3.get(r6)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r3 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r3
            java.lang.String r3 = r3.getLabel()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r13.setText(r3)
        L_0x0161:
            net.one97.paytm.recharge.ordersummary.b.a r13 = r12.b()
            java.lang.String r13 = r13.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x019b
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x019a }
            com.squareup.picasso.aa r13 = r1.a((java.lang.String) r13)     // Catch:{ Exception -> 0x019a }
            com.paytm.utility.t$b r1 = new com.paytm.utility.t$b     // Catch:{ Exception -> 0x019a }
            android.content.res.Resources r3 = r12.getResources()     // Catch:{ Exception -> 0x019a }
            int r8 = net.one97.paytm.recharge.R.dimen.dimen_34dp     // Catch:{ Exception -> 0x019a }
            float r3 = r3.getDimension(r8)     // Catch:{ Exception -> 0x019a }
            int r3 = (int) r3     // Catch:{ Exception -> 0x019a }
            r1.<init>(r3, r6, r7)     // Catch:{ Exception -> 0x019a }
            com.squareup.picasso.ah r1 = (com.squareup.picasso.ah) r1     // Catch:{ Exception -> 0x019a }
            com.squareup.picasso.aa r13 = r13.a((com.squareup.picasso.ah) r1)     // Catch:{ Exception -> 0x019a }
            int r1 = net.one97.paytm.recharge.R.color.color_ffffff     // Catch:{ Exception -> 0x019a }
            com.squareup.picasso.aa r13 = r13.a((int) r1)     // Catch:{ Exception -> 0x019a }
            r13.a((android.widget.ImageView) r0)     // Catch:{ Exception -> 0x019a }
            goto L_0x019b
        L_0x019a:
        L_0x019b:
            if (r2 == 0) goto L_0x01a7
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r13 = r2.getItemLevelActions()
            if (r13 == 0) goto L_0x01a7
            net.one97.paytm.recharge.model.CJROSMetroSmartCard r5 = r13.getMetroSmartCard()
        L_0x01a7:
            if (r5 == 0) goto L_0x01c5
            java.lang.String r13 = r5.getAvmUrl()
            boolean r13 = android.webkit.URLUtil.isValidUrl(r13)
            if (r13 == 0) goto L_0x01c5
            int r13 = r5.getVisibility()
            if (r13 == r7) goto L_0x01bf
            int r13 = r5.getVisibility()
            if (r13 != r4) goto L_0x01c5
        L_0x01bf:
            java.lang.String r13 = r5.getAvmUrl()
            r12.f64148f = r13
        L_0x01c5:
            r12.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.i.a(android.view.View):void");
    }

    private final void c() {
        View findViewById;
        View findViewById2;
        if (!this.f64146d) {
            View view = getView();
            if (!(view == null || (findViewById2 = view.findViewById(R.id.next)) == null)) {
                findViewById2.setVisibility(8);
            }
            View view2 = getView();
            if (!(view2 == null || (findViewById = view2.findViewById(R.id.recharging_avm_anim)) == null)) {
                findViewById.setVisibility(8);
            }
            if (getView() instanceof ConstraintLayout) {
                c cVar = new c();
                View view3 = getView();
                if (view3 != null) {
                    cVar.b((ConstraintLayout) view3);
                    cVar.a(R.id.operator_message, 3, b.c(16));
                    cVar.a(R.id.operator_message, 2, 0, 2);
                    View view4 = getView();
                    if (view4 != null) {
                        cVar.c((ConstraintLayout) view4);
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                }
            }
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) b(R.id.recharging_avm_anim);
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.cancelAnimation();
        }
        if (!this.f64147e && !TextUtils.isEmpty(this.f64148f)) {
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView2 = (CJRRechargeLottieAnimationView) b(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView2 != null) {
                cJRRechargeLottieAnimationView2.addLottieOnCompositionLoadedListener(this);
            }
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView3 = (CJRRechargeLottieAnimationView) b(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView3 != null) {
                cJRRechargeLottieAnimationView3.setFailureListener(this);
            }
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView4 = (CJRRechargeLottieAnimationView) b(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView4 != null) {
                cJRRechargeLottieAnimationView4.setAnimationFromUrl(this.f64148f);
            }
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView5 = (CJRRechargeLottieAnimationView) b(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView5 != null) {
                cJRRechargeLottieAnimationView5.playAnimation();
            }
        }
    }

    public final void aB_() {
        View findViewById;
        View findViewById2;
        this.f64146d = true;
        View view = getView();
        if (!(view == null || (findViewById2 = view.findViewById(R.id.next)) == null)) {
            findViewById2.setVisibility(0);
        }
        View view2 = getView();
        if (!(view2 == null || (findViewById = view2.findViewById(R.id.recharging_avm_anim)) == null)) {
            findViewById.setVisibility(0);
        }
        if (getView() instanceof ConstraintLayout) {
            c cVar = new c();
            View view3 = getView();
            if (view3 != null) {
                cVar.b((ConstraintLayout) view3);
                cVar.a(R.id.operator_message, 3, b.c(8));
                cVar.a(R.id.operator_message, 2, R.id.recharging_avm_anim, 1);
                View view4 = getView();
                if (view4 != null) {
                    cVar.c((ConstraintLayout) view4);
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            }
            throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        }
    }

    public final Map<String, View> getSharedElementMap() {
        HashMap hashMap = new HashMap(1);
        if (((CJRCircleImageViewV8) b(R.id.operator_logo)) == null) {
            return hashMap;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String x = androidx.core.h.u.x((CJRCircleImageViewV8) b(R.id.operator_logo));
            if (x != null) {
                k.a((Object) x, "it");
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) b(R.id.operator_logo);
                k.a((Object) cJRCircleImageViewV8, "operator_logo");
                hashMap.put(x, cJRCircleImageViewV8);
            }
            String x2 = androidx.core.h.u.x((TextView) b(R.id.operator_name));
            if (x2 != null) {
                k.a((Object) x2, "it");
                TextView textView = (TextView) b(R.id.operator_name);
                k.a((Object) textView, "operator_name");
                hashMap.put(x2, textView);
            }
            String x3 = androidx.core.h.u.x((TextView) b(R.id.recharge_number));
            if (x3 != null) {
                k.a((Object) x3, "it");
                TextView textView2 = (TextView) b(R.id.recharge_number);
                k.a((Object) textView2, "recharge_number");
                hashMap.put(x3, textView2);
            }
            String x4 = androidx.core.h.u.x(b(R.id.bg_operator_logo));
            if (x4 != null) {
                k.a((Object) x4, "it");
                View b2 = b(R.id.bg_operator_logo);
                k.a((Object) b2, "bg_operator_logo");
                hashMap.put(x4, b2);
            }
            String x5 = androidx.core.h.u.x((TextView) b(R.id.operator_message));
            if (x5 != null) {
                k.a((Object) x5, "it");
                TextView textView3 = (TextView) b(R.id.operator_message);
                k.a((Object) textView3, "operator_message");
                hashMap.put(x5, textView3);
            }
            if (this.f64146d) {
                String x6 = androidx.core.h.u.x((TextView) b(R.id.next));
                if (x6 != null) {
                    k.a((Object) x6, "it");
                    TextView textView4 = (TextView) b(R.id.next);
                    k.a((Object) textView4, "next");
                    hashMap.put(x6, textView4);
                }
                String x7 = androidx.core.h.u.x((CJRRechargeLottieAnimationView) b(R.id.recharging_avm_anim));
                if (x7 != null) {
                    k.a((Object) x7, "it");
                    CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) b(R.id.recharging_avm_anim);
                    k.a((Object) cJRRechargeLottieAnimationView, "recharging_avm_anim");
                    hashMap.put(x7, cJRRechargeLottieAnimationView);
                }
            }
        }
        if (this.f64164c != null) {
            CJRRechargeItemActionsListView cJRRechargeItemActionsListView = this.f64164c;
            if (cJRRechargeItemActionsListView == null) {
                k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView.getSharedElementMap());
        }
        return hashMap;
    }

    public final /* synthetic */ void onResult(Object obj) {
        this.f64146d = false;
        this.f64147e = true;
        c();
    }
}
