package net.one97.paytm.p2mNewDesign.g;

import androidx.lifecycle.z;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.text.DecimalFormat;
import kotlin.g.b.k;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f51279a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final DecimalFormat f51280b = new DecimalFormat("0.00");

    static final class a<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f51281a;

        a(b bVar) {
            this.f51281a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f fVar = (f) obj;
            h hVar = fVar.f55796a;
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            g gVar = fVar.f55798c;
            if (hVar == h.SUCCESS) {
                this.f51281a.onApiSuccess(iJRPaytmDataModel);
            } else if (hVar == h.ERROR) {
                b bVar = this.f51281a;
                if (gVar == null) {
                    k.a();
                }
                bVar.handleErrorCode(gVar.f55799a, gVar.f55800b, gVar.f55801c);
            }
        }
    }

    private d() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0167: MOVE  (r2v10 java.lang.String) = (r47v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public static void a(android.content.Context r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, boolean r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, com.paytm.network.listener.b r49) {
        /*
            r0 = r35
            r1 = r37
            r2 = r38
            r3 = r39
            r4 = r40
            r5 = r43
            r6 = r44
            r7 = r45
            r8 = r46
            r9 = r47
            r10 = r48
            r11 = r49
            java.lang.String r12 = "context"
            kotlin.g.b.k.c(r0, r12)
            java.lang.String r12 = "amount"
            r13 = r36
            kotlin.g.b.k.c(r13, r12)
            java.lang.String r12 = "productId"
            kotlin.g.b.k.c(r1, r12)
            java.lang.String r12 = "quantity"
            kotlin.g.b.k.c(r2, r12)
            java.lang.String r14 = "warehouseId"
            kotlin.g.b.k.c(r3, r14)
            java.lang.String r14 = "pgMid"
            kotlin.g.b.k.c(r6, r14)
            java.lang.String r15 = "description"
            kotlin.g.b.k.c(r7, r15)
            java.lang.String r13 = "listener"
            kotlin.g.b.k.c(r11, r13)
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.util.Map r13 = (java.util.Map) r13
            java.lang.String r11 = com.paytm.utility.d.a(r35)
            java.lang.String r0 = "CJRNetUtility.getSSOToken(context)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            java.lang.String r0 = "sso_token"
            r13.put(r0, r11)
            java.lang.String r0 = "Content-Type"
            java.lang.String r11 = "application/json"
            r13.put(r0, r11)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r11 = "client"
            r16 = r13
            java.lang.String r13 = "androidapp"
            r0.put(r11, r13)
            android.content.pm.PackageManager r11 = r35.getPackageManager()
            java.lang.String r13 = r35.getPackageName()
            r10 = 0
            android.content.pm.PackageInfo r10 = r11.getPackageInfo(r13, r10)
            java.lang.String r10 = r10.versionName
            java.lang.String r11 = "context.packageManager.g…ckageName, 0).versionName"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.lang.String r11 = "version"
            r0.put(r11, r10)
            java.lang.String r10 = "child_site_id"
            java.lang.String r11 = "1"
            r0.put(r10, r11)
            java.lang.String r13 = "site_id"
            r0.put(r13, r11)
            r17 = r13
            java.lang.String r13 = "native_withdraw"
            r0.put(r13, r11)
            if (r42 == 0) goto L_0x00a5
            java.lang.String r13 = "mlv_withdraw"
            r0.put(r13, r11)
        L_0x00a5:
            java.text.DecimalFormat r13 = f51280b
            r18 = r0
            java.math.RoundingMode r0 = java.math.RoundingMode.HALF_UP
            r13.setRoundingMode(r0)
            double r19 = java.lang.Double.parseDouble(r36)
            if (r41 == 0) goto L_0x00d3
            if (r42 == 0) goto L_0x00d3
            java.text.DecimalFormat r0 = f51280b
            double r19 = java.lang.Double.parseDouble(r36)
            double r21 = java.lang.Double.parseDouble(r41)
            r13 = r10
            r23 = r11
            double r10 = r19 - r21
            java.lang.String r0 = r0.format(r10)
            java.lang.String r10 = "df.format(amount.toDoubl…) - mlvAmount.toDouble())"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            double r19 = java.lang.Double.parseDouble(r0)
            goto L_0x00d6
        L_0x00d3:
            r13 = r10
            r23 = r11
        L_0x00d6:
            r10 = 0
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r10 = r19
        L_0x00df:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r41 = r13
            org.json.JSONArray r13 = new org.json.JSONArray
            r13.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            r19 = r10
            double r10 = java.lang.Double.parseDouble(r36)
            java.lang.String r5 = "price"
            r8.put(r5, r10)
            r8.put(r15, r7)
            java.lang.String r5 = "configuration"
            r9.put(r5, r8)
            java.lang.String r5 = "product_id"
            r9.put(r5, r1)
            r9.put(r12, r2)
            java.lang.String r1 = "warehouse_id"
            r9.put(r1, r3)
            r13.put(r9)
            if (r4 == 0) goto L_0x0131
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "globalcode"
            r1.put(r2, r4)
            java.lang.String r2 = "action"
            java.lang.String r3 = "applypromo"
            r1.put(r2, r3)
            java.lang.String r2 = "promo_action"
            r0.put(r2, r1)
        L_0x0131:
            java.lang.String r1 = "cart_items"
            r0.put(r1, r13)
            r0.put(r14, r6)
            r1 = r43
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0163
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "mode"
            r3.put(r4, r1)
            java.lang.String r1 = "txnAmount"
            r10 = r19
            r3.put(r1, r10)
            r2.put(r3)
            java.lang.String r1 = "payment_intent"
            r0.put(r1, r2)
        L_0x0163:
            r1 = r46
            if (r1 == 0) goto L_0x0181
            r2 = r47
            if (r2 == 0) goto L_0x0181
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "kybId"
            r3.put(r4, r1)
            java.lang.String r1 = "shopId"
            r3.put(r1, r2)
            java.lang.String r1 = "store_info"
            r0.put(r1, r3)
        L_0x0181:
            r1 = r48
            if (r1 == 0) goto L_0x018a
            java.lang.String r2 = "pos_transaction_required"
            r0.put(r2, r1)
        L_0x018a:
            r1 = r41
            r2 = r23
            r0.put(r1, r2)
            r1 = r17
            r0.put(r1, r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "mlvJsonObject.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r35)
            if (r1 == 0) goto L_0x0205
            net.one97.paytm.network.b r1 = new net.one97.paytm.network.b
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse r2 = new net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 8191(0x1fff, float:1.1478E-41)
            r34 = 0
            r19 = r2
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            java.lang.String r3 = "https://channels.paytm.com/v2/channels/checkout?"
            r36 = r1
            r37 = r3
            r38 = r2
            r39 = r18
            r40 = r16
            r41 = r0
            r36.<init>(r37, r38, r39, r40, r41)
            r1.e()
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "payment_instrument_api_timeout"
            r3 = r35
            int r0 = r0.getIntegerFromGTM((android.content.Context) r3, (java.lang.String) r2)
            int r0 = net.one97.paytm.wallet.utility.a.a((int) r0)
            r1.a(r0)
            androidx.lifecycle.LiveData r0 = r1.a()
            net.one97.paytm.p2mNewDesign.g.d$a r1 = new net.one97.paytm.p2mNewDesign.g.d$a
            r2 = r49
            r1.<init>(r2)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r0.observeForever(r1)
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.g.d.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.paytm.network.listener.b):void");
    }
}
