package com.paytmmall.a.a;

import android.app.Activity;
import android.content.Intent;
import com.google.gsonhtcfix.f;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.order.entity.CJROrderSummary;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    public static b f15378a;

    /* renamed from: b  reason: collision with root package name */
    public static b f15379b;

    /* renamed from: c  reason: collision with root package name */
    public static H5Event f15380c;

    public j() {
        super("mpPostorder", "contactUs", "TRACK_ORDER_CLICKED", "UPI_JOURNEY_STARTS", "IS_MGV_ORDER");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r1 == 0) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r1 == 1) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (r1 == 2) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r1 == 3) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0 = com.paytmmall.artifact.d.c.f15691a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        r0 = b(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        if (r0.containsKey("orderSummary") == false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0058, code lost:
        r0 = (com.paytmmall.artifact.order.entity.CJROrderSummary) com.paytmmall.artifact.e.a.a(r0, "orderSummary", com.paytmmall.artifact.order.entity.CJROrderSummary.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        if (r0 == null) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
        r1 = new android.os.Handler();
        r2 = new com.paytmmall.a.a.$$Lambda$j$67eySUEaSD3H607N7CM7fzqwF4(r8, r9, r0);
        com.paytmmall.artifact.common.a.a.a();
        r1.postDelayed(r2, (long) com.paytmmall.artifact.common.a.a.a("MGV_LAUNCH_DELAY_KEY", 5000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007d, code lost:
        f15379b = r10;
        r9.getActivity().startActivityForResult(new android.content.Intent("net.one97.paytm.action.upi.onboarding.CHECK"), 101);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r1 = java.lang.Boolean.valueOf(r9.getParams().optBoolean("isMarketplaceOrder"));
        r2 = b(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a9, code lost:
        if (r1.booleanValue() == false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1 = r9.getActivity();
        r2 = b(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r2.get("item") == null) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bd, code lost:
        if (r2.get(com.sendbird.android.constant.StringSet.order) != null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c0, code lost:
        r0 = (com.paytmmall.artifact.order.entity.CJROrderItems) com.paytmmall.artifact.e.a.a(r2, "item", com.paytmmall.artifact.order.entity.CJROrderItems.class);
        r1 = (com.paytmmall.artifact.order.entity.CJROrderList) com.paytmmall.artifact.e.a.a(r2, com.sendbird.android.constant.StringSet.order, com.paytmmall.artifact.order.entity.CJROrderList.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d0, code lost:
        if (r1 == null) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d2, code lost:
        if (r0 == null) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d4, code lost:
        com.paytmmall.a.a.a(java.lang.String.valueOf(r1.getOrderID()), java.lang.String.valueOf(r0.getId()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e9, code lost:
        com.paytmmall.artifact.d.d.b(r1, r1.getString(com.paytmmall.artifact.R.string.try_again), r1.getString(com.paytmmall.artifact.R.string.some_went_wrong));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fa, code lost:
        com.paytmmall.artifact.common.b.a.a.a(r9.getActivity(), com.paytmmall.artifact.common.b.a.a.a((com.paytmmall.artifact.order.entity.CJROrderList) com.paytmmall.artifact.e.a.a(r2, com.sendbird.android.constant.StringSet.order, com.paytmmall.artifact.order.entity.CJROrderList.class)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010f, code lost:
        if (r9 == null) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0115, code lost:
        if (r9.getActivity() == null) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0117, code lost:
        r0 = ((org.json.JSONObject) java.util.Objects.requireNonNull(r9.getParams())).optInt(com.paytmmall.clpartifact.utils.CLPConstants.ARGUMENT_KEY_POSITION, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012f, code lost:
        if (r9.getParams().isNull("orderSummary") != false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0131, code lost:
        new com.google.gsonhtcfix.f();
        r1 = (com.paytmmall.artifact.order.entity.CJROrderSummary) new com.google.gsonhtcfix.f().a(new com.google.gsonhtcfix.f().a(r9.getParams().opt("orderSummary")), com.paytmmall.artifact.order.entity.CJROrderSummary.class);
        r2 = r9.getActivity();
        r4 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015a, code lost:
        if (r1 == null) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x015c, code lost:
        r4 = r1.getOrderedCartList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0160, code lost:
        if (r4 == null) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0166, code lost:
        if (r4.size() <= r0) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0168, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0169, code lost:
        if (r3 == false) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016b, code lost:
        r0 = r4.get(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0172, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0173, code lost:
        if (r0 == null) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0175, code lost:
        r0.setOrderId(r1.getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017c, code lost:
        r4 = com.paytmmall.artifact.d.q.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0180, code lost:
        r0 = new com.paytmmall.artifact.order.a.a.AnonymousClass1(r2);
        r1 = new com.paytmmall.artifact.ReturnReplace.entity.CJRReplacementReason();
        r1.setParentIssueId(1000001);
        com.paytmmall.artifact.d.t.e().openContactUs(r2, r4, com.paytmmall.artifact.d.q.a(r1), r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r9, net.one97.paytm.phoenix.api.b r10) {
        /*
            r8 = this;
            java.lang.String r0 = "item"
            f15378a = r10     // Catch:{ Exception -> 0x019c }
            f15380c = r9     // Catch:{ Exception -> 0x019c }
            java.lang.String r1 = r9.getBridgeName()     // Catch:{ Exception -> 0x019c }
            int r2 = r1.hashCode()     // Catch:{ Exception -> 0x019c }
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = -1
            r7 = 1
            switch(r2) {
                case -411130146: goto L_0x0035;
                case -217332138: goto L_0x002b;
                case -101111838: goto L_0x0021;
                case -29470431: goto L_0x0017;
                default: goto L_0x0016;
            }     // Catch:{ Exception -> 0x019c }
        L_0x0016:
            goto L_0x003f
        L_0x0017:
            java.lang.String r2 = "UPI_JOURNEY_STARTS"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x019c }
            if (r1 == 0) goto L_0x003f
            r1 = 2
            goto L_0x0040
        L_0x0021:
            java.lang.String r2 = "TRACK_ORDER_CLICKED"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x019c }
            if (r1 == 0) goto L_0x003f
            r1 = 1
            goto L_0x0040
        L_0x002b:
            java.lang.String r2 = "IS_MGV_ORDER"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x019c }
            if (r1 == 0) goto L_0x003f
            r1 = 3
            goto L_0x0040
        L_0x0035:
            java.lang.String r2 = "contactUs"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x019c }
            if (r1 == 0) goto L_0x003f
            r1 = 0
            goto L_0x0040
        L_0x003f:
            r1 = -1
        L_0x0040:
            java.lang.String r2 = "orderSummary"
            if (r1 == 0) goto L_0x010f
            if (r1 == r7) goto L_0x0091
            if (r1 == r5) goto L_0x007d
            if (r1 == r4) goto L_0x004e
            boolean r0 = com.paytmmall.artifact.d.c.f15691a     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x004e:
            java.util.HashMap r0 = b(r9)     // Catch:{ Exception -> 0x019c }
            boolean r1 = r0.containsKey(r2)     // Catch:{ Exception -> 0x019c }
            if (r1 == 0) goto L_0x01a0
            java.lang.Class<com.paytmmall.artifact.order.entity.CJROrderSummary> r1 = com.paytmmall.artifact.order.entity.CJROrderSummary.class
            java.lang.Object r0 = com.paytmmall.artifact.e.a.a(r0, r2, r1)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.order.entity.CJROrderSummary r0 = (com.paytmmall.artifact.order.entity.CJROrderSummary) r0     // Catch:{ Exception -> 0x019c }
            if (r0 == 0) goto L_0x01a0
            android.os.Handler r1 = new android.os.Handler     // Catch:{ Exception -> 0x019c }
            r1.<init>()     // Catch:{ Exception -> 0x019c }
            com.paytmmall.a.a.-$$Lambda$j$67eySUEaSD3H607N7C-M7fzqwF4 r2 = new com.paytmmall.a.a.-$$Lambda$j$67eySUEaSD3H607N7C-M7fzqwF4     // Catch:{ Exception -> 0x019c }
            r2.<init>(r9, r0)     // Catch:{ Exception -> 0x019c }
            java.lang.String r0 = "MGV_LAUNCH_DELAY_KEY"
            com.paytmmall.artifact.common.a.a.a()     // Catch:{ Exception -> 0x019c }
            r3 = 5000(0x1388, float:7.006E-42)
            int r0 = com.paytmmall.artifact.common.a.a.a((java.lang.String) r0, (int) r3)     // Catch:{ Exception -> 0x019c }
            long r3 = (long) r0     // Catch:{ Exception -> 0x019c }
            r1.postDelayed(r2, r3)     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x007d:
            f15379b = r10     // Catch:{ Exception -> 0x019c }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x019c }
            java.lang.String r1 = "net.one97.paytm.action.upi.onboarding.CHECK"
            r0.<init>(r1)     // Catch:{ Exception -> 0x019c }
            android.app.Activity r1 = r9.getActivity()     // Catch:{ Exception -> 0x019c }
            r2 = 101(0x65, float:1.42E-43)
            r1.startActivityForResult(r0, r2)     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x0091:
            org.json.JSONObject r1 = r9.getParams()     // Catch:{ Exception -> 0x019c }
            java.lang.String r2 = "isMarketplaceOrder"
            boolean r1 = r1.optBoolean(r2)     // Catch:{ Exception -> 0x019c }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x019c }
            java.util.HashMap r2 = b(r9)     // Catch:{ Exception -> 0x019c }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x019c }
            java.lang.String r3 = "order"
            if (r1 == 0) goto L_0x00fa
            android.app.Activity r1 = r9.getActivity()     // Catch:{ Exception -> 0x019c }
            java.util.HashMap r2 = b(r9)     // Catch:{ Exception -> 0x019c }
            java.lang.Object r4 = r2.get(r0)     // Catch:{ Exception -> 0x019c }
            if (r4 == 0) goto L_0x00e9
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x019c }
            if (r4 != 0) goto L_0x00c0
            goto L_0x00e9
        L_0x00c0:
            java.lang.Class<com.paytmmall.artifact.order.entity.CJROrderItems> r1 = com.paytmmall.artifact.order.entity.CJROrderItems.class
            java.lang.Object r0 = com.paytmmall.artifact.e.a.a(r2, r0, r1)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.order.entity.CJROrderItems r0 = (com.paytmmall.artifact.order.entity.CJROrderItems) r0     // Catch:{ Exception -> 0x019c }
            java.lang.Class<com.paytmmall.artifact.order.entity.CJROrderList> r1 = com.paytmmall.artifact.order.entity.CJROrderList.class
            java.lang.Object r1 = com.paytmmall.artifact.e.a.a(r2, r3, r1)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.order.entity.CJROrderList r1 = (com.paytmmall.artifact.order.entity.CJROrderList) r1     // Catch:{ Exception -> 0x019c }
            if (r1 == 0) goto L_0x01a0
            if (r0 == 0) goto L_0x01a0
            java.lang.String r1 = r1.getOrderID()     // Catch:{ Exception -> 0x019c }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x019c }
            long r2 = r0.getId()     // Catch:{ Exception -> 0x019c }
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.a.a.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x00e9:
            int r0 = com.paytmmall.artifact.R.string.try_again     // Catch:{ Exception -> 0x019c }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x019c }
            int r2 = com.paytmmall.artifact.R.string.some_went_wrong     // Catch:{ Exception -> 0x019c }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.d.d.b(r1, r0, r2)     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x00fa:
            java.lang.Class<com.paytmmall.artifact.order.entity.CJROrderList> r0 = com.paytmmall.artifact.order.entity.CJROrderList.class
            java.lang.Object r0 = com.paytmmall.artifact.e.a.a(r2, r3, r0)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.order.entity.CJROrderList r0 = (com.paytmmall.artifact.order.entity.CJROrderList) r0     // Catch:{ Exception -> 0x019c }
            android.app.Activity r1 = r9.getActivity()     // Catch:{ Exception -> 0x019c }
            java.lang.String r0 = com.paytmmall.artifact.common.b.a.a.a((com.paytmmall.artifact.order.entity.CJROrderList) r0)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.common.b.a.a.a((android.app.Activity) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x010f:
            if (r9 == 0) goto L_0x01a0
            android.app.Activity r0 = r9.getActivity()     // Catch:{ Exception -> 0x019c }
            if (r0 == 0) goto L_0x01a0
            org.json.JSONObject r0 = r9.getParams()     // Catch:{ Exception -> 0x019c }
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)     // Catch:{ Exception -> 0x019c }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ Exception -> 0x019c }
            java.lang.String r1 = "position"
            int r0 = r0.optInt(r1, r6)     // Catch:{ Exception -> 0x019c }
            org.json.JSONObject r1 = r9.getParams()     // Catch:{ Exception -> 0x019c }
            boolean r1 = r1.isNull(r2)     // Catch:{ Exception -> 0x019c }
            if (r1 != 0) goto L_0x01a0
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x019c }
            r1.<init>()     // Catch:{ Exception -> 0x019c }
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x019c }
            r1.<init>()     // Catch:{ Exception -> 0x019c }
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x019c }
            r4.<init>()     // Catch:{ Exception -> 0x019c }
            org.json.JSONObject r5 = r9.getParams()     // Catch:{ Exception -> 0x019c }
            java.lang.Object r2 = r5.opt(r2)     // Catch:{ Exception -> 0x019c }
            java.lang.String r2 = r4.a((java.lang.Object) r2)     // Catch:{ Exception -> 0x019c }
            java.lang.Class<com.paytmmall.artifact.order.entity.CJROrderSummary> r4 = com.paytmmall.artifact.order.entity.CJROrderSummary.class
            java.lang.Object r1 = r1.a((java.lang.String) r2, r4)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.order.entity.CJROrderSummary r1 = (com.paytmmall.artifact.order.entity.CJROrderSummary) r1     // Catch:{ Exception -> 0x019c }
            android.app.Activity r2 = r9.getActivity()     // Catch:{ Exception -> 0x019c }
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0180
            java.util.ArrayList r4 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x019c }
            if (r4 == 0) goto L_0x0169
            int r5 = r4.size()     // Catch:{ Exception -> 0x019c }
            if (r5 <= r0) goto L_0x0169
            r3 = 1
        L_0x0169:
            if (r3 == 0) goto L_0x0172
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.order.entity.CJROrderedCart r0 = (com.paytmmall.artifact.order.entity.CJROrderedCart) r0     // Catch:{ Exception -> 0x019c }
            goto L_0x0173
        L_0x0172:
            r0 = 0
        L_0x0173:
            if (r0 == 0) goto L_0x017c
            java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x019c }
            r0.setOrderId(r1)     // Catch:{ Exception -> 0x019c }
        L_0x017c:
            java.lang.String r4 = com.paytmmall.artifact.d.q.a(r0)     // Catch:{ Exception -> 0x019c }
        L_0x0180:
            com.paytmmall.artifact.order.a.a$1 r0 = new com.paytmmall.artifact.order.a.a$1     // Catch:{ Exception -> 0x019c }
            r0.<init>(r2)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.ReturnReplace.entity.CJRReplacementReason r1 = new com.paytmmall.artifact.ReturnReplace.entity.CJRReplacementReason     // Catch:{ Exception -> 0x019c }
            r1.<init>()     // Catch:{ Exception -> 0x019c }
            r3 = 1000001(0xf4241, float:1.4013E-39)
            r1.setParentIssueId(r3)     // Catch:{ Exception -> 0x019c }
            java.lang.String r1 = com.paytmmall.artifact.d.q.a(r1)     // Catch:{ Exception -> 0x019c }
            com.paytmmall.artifact.common.a r3 = com.paytmmall.artifact.d.t.e()     // Catch:{ Exception -> 0x019c }
            r3.openContactUs(r2, r4, r1, r0)     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x019c:
            r0 = move-exception
            com.paytmmall.artifact.d.s.a(r0)
        L_0x01a0:
            boolean r9 = super.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.b) r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.a.a.j.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(H5Event h5Event, CJROrderSummary cJROrderSummary) {
        Activity activity = h5Event.getActivity();
        Intent intent = new Intent();
        intent.putExtra("orderResponse", new f().a((Object) cJROrderSummary));
        t.e().resolveIntentByMainApp(activity, intent, "qr_activity", Integer.MIN_VALUE);
    }

    private static HashMap<String, Object> b(H5Event h5Event) {
        JSONObject params;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!(h5Event == null || (params = h5Event.getParams()) == null || params.length() <= 0)) {
            Iterator<String> keys = params.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    hashMap.put(next, params.getString(next));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return hashMap;
    }
}
