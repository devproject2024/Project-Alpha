package net.one97.paytm.recharge.common.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2;

public final class s extends h {

    /* renamed from: a  reason: collision with root package name */
    private CJRBaseRechargePromotionalBannerViewV2 f61395a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f61396b;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null).inflate(R.layout.fragment_store_front_offer_layout, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r14 = "view"
            kotlin.g.b.k.c(r13, r14)
            android.os.Bundle r13 = r12.getArguments()
            java.lang.String r14 = ""
            if (r13 == 0) goto L_0x0015
            java.lang.String r0 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r13 = r13.getString(r0, r14)
            if (r13 != 0) goto L_0x0016
        L_0x0015:
            r13 = r14
        L_0x0016:
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r0 = r12.f61395a
            r1 = 0
            if (r0 == 0) goto L_0x0036
            r0 = r13
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0036
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r0 = r12.f61395a
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.getCurrentCategoryId()
            goto L_0x002e
        L_0x002d:
            r0 = r1
        L_0x002e:
            r2 = 1
            boolean r13 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r0, (boolean) r2)
            if (r13 == 0) goto L_0x0036
            return
        L_0x0036:
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r13 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2
            androidx.fragment.app.FragmentActivity r3 = r12.getActivity()
            if (r3 != 0) goto L_0x0041
            kotlin.g.b.k.a()
        L_0x0041:
            java.lang.String r0 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            android.os.Bundle r0 = r12.getArguments()
            if (r0 == 0) goto L_0x0054
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r0 = r0.getString(r2, r14)
            if (r0 != 0) goto L_0x0055
        L_0x0054:
            r0 = r14
        L_0x0055:
            java.lang.String r4 = net.one97.paytm.recharge.common.utils.az.b((java.lang.String) r0)
            r5 = 0
            android.os.Bundle r0 = r12.getArguments()
            if (r0 == 0) goto L_0x006b
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r0 = r0.getString(r2, r14)
            if (r0 != 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r6 = r0
            goto L_0x006c
        L_0x006b:
            r6 = r14
        L_0x006c:
            r7 = 0
            r8 = 0
            android.os.Bundle r0 = r12.getArguments()
            if (r0 == 0) goto L_0x007f
            java.lang.String r2 = "vertical_id"
            java.lang.String r0 = r0.getString(r2, r14)
            if (r0 != 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r10 = r0
            goto L_0x0080
        L_0x007f:
            r10 = r14
        L_0x0080:
            android.os.Bundle r0 = r12.getArguments()
            if (r0 == 0) goto L_0x0091
            java.lang.String r2 = "screen_name"
            java.lang.String r0 = r0.getString(r2, r14)
            if (r0 != 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r9 = r0
            goto L_0x0092
        L_0x0091:
            r9 = r14
        L_0x0092:
            r11 = 48
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.f61395a = r13
            int r13 = net.one97.paytm.recharge.R.id.parent_layout
            java.util.HashMap r14 = r12.f61396b
            if (r14 != 0) goto L_0x00a7
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            r12.f61396b = r14
        L_0x00a7:
            java.util.HashMap r14 = r12.f61396b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            java.lang.Object r14 = r14.get(r0)
            android.view.View r14 = (android.view.View) r14
            if (r14 != 0) goto L_0x00c9
            android.view.View r14 = r12.getView()
            if (r14 != 0) goto L_0x00bc
            goto L_0x00ca
        L_0x00bc:
            android.view.View r14 = r14.findViewById(r13)
            java.util.HashMap r0 = r12.f61396b
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r0.put(r13, r14)
        L_0x00c9:
            r1 = r14
        L_0x00ca:
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            if (r1 == 0) goto L_0x00d5
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r13 = r12.f61395a
            android.view.View r13 = (android.view.View) r13
            r1.addView(r13)
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.s.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f61396b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
