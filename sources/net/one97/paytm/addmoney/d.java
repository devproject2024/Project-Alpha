package net.one97.paytm.addmoney;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.addmoney.landing.view.AddMoneyActivity;
import net.one97.paytm.addmoney.togv.view.AddMoneyToGVActivity;
import net.one97.paytm.addmoney.toppb.view.AddMoneyToPPBActivity;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.newaddmoney.view.AddMoneyNewActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.d.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f48562a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static d f48563h;

    /* renamed from: b  reason: collision with root package name */
    private final String f48564b = "add_money";

    /* renamed from: c  reason: collision with root package name */
    private final String f48565c = "universal_add_money";

    /* renamed from: d  reason: collision with root package name */
    private final String f48566d = "bank_landing";

    /* renamed from: e  reason: collision with root package name */
    private final String f48567e = "nearbyAddMoney";

    /* renamed from: f  reason: collision with root package name */
    private final String f48568f = "statement_download";

    /* renamed from: g  reason: collision with root package name */
    private final String f48569g = "gift_paytm_cash";

    public static final d g() {
        return a.a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a() {
            if (d.f48563h == null) {
                d.f48563h = new d();
            }
            return d.f48563h;
        }
    }

    private static Double a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
        return Double.valueOf(0.0d);
    }

    public static Class<?> a() {
        return AddMoneyToGVActivity.class;
    }

    public static Class<?> b() {
        return AddMoneyNewActivity.class;
    }

    public static Intent a(Context context, String str) {
        k.c(context, "context");
        Intent intent = new Intent(context, AddMoneyNewActivity.class);
        if (str != null) {
            intent.putExtra("tab", str);
        }
        return intent;
    }

    public static Class<?> c() {
        return AddMoneyActivity.class;
    }

    public static Class<?> d() {
        return AddMoneyToPPBActivity.class;
    }

    public static Object e() {
        return net.one97.paytm.helper.a.f50546a.a().c();
    }

    public static void a(Object obj, String str) {
        k.c(obj, "obj");
        k.c(str, "amountString");
        ((c) obj).d(str);
    }

    public static void a(Object obj) {
        k.c(obj, "obj");
        ((c) obj).a();
    }

    public final boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) || p.a(deepLinkData.f50284b, "wallet-addmoney", false)) {
            String str = deepLinkData.f50288f;
            if (p.a(str, "txnDetail", true) || p.a(str, this.f48564b, false) || p.a(str, this.f48565c, false) || p.a(str, this.f48566d, false) || p.a(str, "gvTxnDetail", true) || p.a(str, this.f48567e, true) || p.a(str, this.f48568f, true) || p.a(str, this.f48569g, true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v14, types: [android.content.Intent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, net.one97.paytm.deeplink.DeepLinkData r12) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r11, r0)
            if (r12 == 0) goto L_0x0204
            java.lang.String r0 = r12.f50288f
            r1 = 0
            java.lang.String r2 = "wallet-addmoney"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            java.lang.String r2 = "amount"
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x0199
            java.lang.String r0 = r12.f50288f
            java.lang.String r5 = r10.f48564b
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r1)
            if (r0 == 0) goto L_0x0023
            goto L_0x0199
        L_0x0023:
            java.lang.String r0 = r12.f50288f
            java.lang.String r5 = r10.f48565c
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r1)
            if (r0 == 0) goto L_0x0037
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<net.one97.paytm.newaddmoney.view.AddMoneyNewActivity> r12 = net.one97.paytm.newaddmoney.view.AddMoneyNewActivity.class
            r4.<init>(r11, r12)
        L_0x0034:
            r0 = r4
            goto L_0x01f6
        L_0x0037:
            java.lang.String r0 = r12.f50288f
            java.lang.String r5 = r10.f48566d
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r1)
            if (r0 == 0) goto L_0x008c
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.addmoney.toppb.view.AddMoneyToPPBActivity> r1 = net.one97.paytm.addmoney.toppb.view.AddMoneyToPPBActivity.class
            r0.<init>(r11, r1)
            android.net.Uri r1 = r12.f50289g
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r1.getQueryParameter(r2)
            goto L_0x0052
        L_0x0051:
            r1 = r4
        L_0x0052:
            android.net.Uri r3 = r12.f50289g
            java.lang.String r5 = "hide_isa_fd"
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = r3.getQueryParameter(r5)
            goto L_0x005e
        L_0x005d:
            r3 = r4
        L_0x005e:
            if (r3 == 0) goto L_0x0063
            r0.putExtra(r5, r3)
        L_0x0063:
            android.net.Uri r3 = r12.f50289g
            java.lang.String r5 = "slfdIblCifStatus"
            if (r3 == 0) goto L_0x006f
            java.lang.String r3 = r3.getQueryParameter(r5)
            goto L_0x0070
        L_0x006f:
            r3 = r4
        L_0x0070:
            if (r3 == 0) goto L_0x0075
            r0.putExtra(r5, r3)
        L_0x0075:
            android.net.Uri r12 = r12.f50289g
            java.lang.String r3 = "slfdBalance"
            if (r12 == 0) goto L_0x0080
            java.lang.String r4 = r12.getQueryParameter(r3)
        L_0x0080:
            if (r4 == 0) goto L_0x0085
            r0.putExtra(r3, r4)
        L_0x0085:
            if (r1 == 0) goto L_0x01f6
            r0.putExtra(r2, r1)
            goto L_0x01f6
        L_0x008c:
            java.lang.String r0 = r12.f50288f
            java.lang.String r2 = "txnDetail"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r3)
            java.lang.String r2 = "order_id"
            java.lang.String r5 = "intent.putExtra(CJRParam…ts.SOURCE, \"orderDetail\")"
            java.lang.String r6 = "orderDetail"
            java.lang.String r7 = "key_source"
            java.lang.String r8 = "orderId"
            if (r0 == 0) goto L_0x00be
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity> r1 = net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity.class
            r0.<init>(r11, r1)
            android.net.Uri r12 = r12.f50289g
            if (r12 == 0) goto L_0x00b0
            java.lang.String r4 = r12.getQueryParameter(r8)
        L_0x00b0:
            if (r4 == 0) goto L_0x00b5
            r0.putExtra(r2, r4)
        L_0x00b5:
            android.content.Intent r12 = r0.putExtra(r7, r6)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            goto L_0x01f6
        L_0x00be:
            java.lang.String r0 = r12.f50288f
            java.lang.String r9 = "gvTxnDetail"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r9, (boolean) r3)
            if (r0 == 0) goto L_0x0116
            android.net.Uri r0 = r12.f50289g
            if (r0 == 0) goto L_0x00d4
            java.lang.String r1 = "targetMobile"
            java.lang.String r0 = r0.getQueryParameter(r1)
            goto L_0x00d5
        L_0x00d4:
            r0 = r4
        L_0x00d5:
            java.lang.String r1 = com.paytm.utility.a.b((android.content.Context) r11)
            r9 = r0
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00f9
            r9 = r1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00f9
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
            if (r0 != 0) goto L_0x00f9
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.addmoney.togv.view.AddMoneyToGVStatusActivity> r1 = net.one97.paytm.addmoney.togv.view.AddMoneyToGVStatusActivity.class
            r0.<init>(r11, r1)
            goto L_0x0100
        L_0x00f9:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.addmoney.togv.view.AddMoneyToGvSelfStatusActivity> r1 = net.one97.paytm.addmoney.togv.view.AddMoneyToGvSelfStatusActivity.class
            r0.<init>(r11, r1)
        L_0x0100:
            android.net.Uri r12 = r12.f50289g
            if (r12 == 0) goto L_0x0108
            java.lang.String r4 = r12.getQueryParameter(r8)
        L_0x0108:
            if (r4 == 0) goto L_0x010d
            r0.putExtra(r2, r4)
        L_0x010d:
            android.content.Intent r12 = r0.putExtra(r7, r6)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            goto L_0x01f6
        L_0x0116:
            java.lang.String r0 = r12.f50288f
            java.lang.String r2 = r10.f48567e
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r3)
            if (r0 == 0) goto L_0x0161
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.addmoney.view.NearByAddMoneyActivity> r2 = net.one97.paytm.wallet.newdesign.addmoney.view.NearByAddMoneyActivity.class
            r0.<init>(r11, r2)
            android.net.Uri r12 = r12.f50289g
            if (r12 == 0) goto L_0x0131
            java.lang.String r2 = "destination"
            java.lang.String r4 = r12.getQueryParameter(r2)
        L_0x0131:
            java.lang.String r12 = "toWallet"
            boolean r12 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r12, (boolean) r1)
            java.lang.String r2 = "nearby_points"
            if (r12 == 0) goto L_0x014d
            net.one97.paytm.addmoney.utils.m r12 = net.one97.paytm.addmoney.utils.m.NEARBY_CASH_POINT
            int r12 = r12.getIdentifier()
            android.content.Intent r12 = r0.putExtra(r2, r12)
            java.lang.String r1 = "intent.putExtra(AddMoney…BY_CASH_POINT.identifier)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            goto L_0x01f6
        L_0x014d:
            java.lang.String r12 = "toBank"
            boolean r12 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x01f6
            net.one97.paytm.addmoney.utils.m r12 = net.one97.paytm.addmoney.utils.m.NEARBY_BANKING_POINT
            int r12 = r12.getIdentifier()
            r0.putExtra(r2, r12)
            goto L_0x01f6
        L_0x0161:
            java.lang.String r0 = r10.f48568f
            java.lang.String r1 = r12.f50288f
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x0181
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.statementDownload.StatementDownloadActivity> r12 = net.one97.paytm.passbook.statementDownload.StatementDownloadActivity.class
            r4.<init>(r11, r12)
            java.lang.String r12 = "header_title"
            java.lang.String r0 = "Request Statement"
            android.content.Intent r12 = r4.putExtra(r12, r0)
            java.lang.String r0 = "intent.putExtra(\"header_…le\", \"Request Statement\")"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            goto L_0x0034
        L_0x0181:
            java.lang.String r0 = r10.f48569g
            java.lang.String r12 = r12.f50288f
            boolean r12 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r12, (boolean) r3)
            if (r12 == 0) goto L_0x0034
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<net.one97.paytm.addmoney.togv.view.AddMoneyToGVActivity> r12 = net.one97.paytm.addmoney.togv.view.AddMoneyToGVActivity.class
            r4.<init>(r11, r12)
            java.lang.String r12 = "isForFriends"
            r4.putExtra(r12, r3)
            goto L_0x0034
        L_0x0199:
            android.net.Uri r0 = r12.f50289g
            if (r0 == 0) goto L_0x01a5
            java.lang.String r5 = "tab"
            java.lang.String r0 = r0.getQueryParameter(r5)
            goto L_0x01a6
        L_0x01a5:
            r0 = r4
        L_0x01a6:
            if (r0 == 0) goto L_0x01b8
            java.lang.String r5 = "automatic_add_money"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x01b8
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.autoaddmoney.views.AmAutomaticActivity> r2 = net.one97.paytm.autoaddmoney.views.AmAutomaticActivity.class
            r0.<init>(r11, r2)
            goto L_0x01da
        L_0x01b8:
            android.content.Intent r0 = a((android.content.Context) r11, (java.lang.String) r0)
            android.net.Uri r5 = r12.f50289g
            if (r5 == 0) goto L_0x01c5
            java.lang.String r5 = r5.getQueryParameter(r2)
            goto L_0x01c6
        L_0x01c5:
            r5 = r4
        L_0x01c6:
            if (r5 == 0) goto L_0x01da
            java.lang.Double r5 = a((java.lang.String) r5)
            r6 = 0
            boolean r6 = kotlin.g.b.k.a((java.lang.Double) r5, (double) r6)
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x01da
            java.io.Serializable r5 = (java.io.Serializable) r5
            r0.putExtra(r2, r5)
        L_0x01da:
            android.net.Uri r12 = r12.f50289g
            java.lang.String r2 = "source"
            if (r12 == 0) goto L_0x01e5
            java.lang.String r4 = r12.getQueryParameter(r2)
        L_0x01e5:
            r12 = r4
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x01f0
            int r12 = r12.length()
            if (r12 != 0) goto L_0x01f1
        L_0x01f0:
            r1 = 1
        L_0x01f1:
            if (r1 != 0) goto L_0x01f6
            r0.putExtra(r2, r4)
        L_0x01f6:
            if (r0 == 0) goto L_0x0204
            boolean r12 = r11 instanceof android.app.Activity
            if (r12 != 0) goto L_0x0201
            r12 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r12)
        L_0x0201:
            r11.startActivity(r0)
        L_0x0204:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.d.a(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }
}
