package net.one97.paytm.wallet.utility.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.network.f;
import net.one97.paytm.utils.af;
import net.one97.paytm.utils.at;
import net.one97.paytm.wallet.d.e;
import net.one97.paytm.wallet.d.k;
import net.one97.paytm.wallet.entity.CJRSendMoney;
import net.one97.paytm.wallet.entity.CJRSendMoneyResponse;
import net.one97.paytm.wallet.f.g;
import net.one97.paytm.wallet.newdesign.addbeneficiary.d;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.p2p.P2PLandingPageActivity;
import net.one97.paytm.wallet.utility.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public e f72293a = new e();

    /* renamed from: b  reason: collision with root package name */
    public Activity f72294b;

    /* renamed from: c  reason: collision with root package name */
    public Fragment f72295c;

    /* renamed from: d  reason: collision with root package name */
    public String f72296d;

    /* renamed from: e  reason: collision with root package name */
    String f72297e;

    public static final class a<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f72298a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f72299b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f72300c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f72301d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ WalletPaymentCallbackListener f72302e;

        public a(b bVar, String str, String str2, String str3, WalletPaymentCallbackListener walletPaymentCallbackListener) {
            this.f72298a = bVar;
            this.f72299b = str;
            this.f72300c = str2;
            this.f72301d = str3;
            this.f72302e = walletPaymentCallbackListener;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
            r8 = r8.getLimitMessage();
         */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x010d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r12) {
            /*
                r11 = this;
                net.one97.paytm.network.f r12 = (net.one97.paytm.network.f) r12
                net.one97.paytm.network.h r0 = r12.f55796a
                com.paytm.network.model.IJRPaytmDataModel r1 = r12.f55797b
                net.one97.paytm.network.g r12 = r12.f55798c
                net.one97.paytm.network.h r2 = net.one97.paytm.network.h.SUCCESS
                r3 = 0
                r4 = 0
                if (r0 != r2) goto L_0x01f8
                boolean r12 = r1 instanceof net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel
                if (r12 == 0) goto L_0x0224
                net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel r1 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel) r1
                net.one97.paytm.wallet.utility.a.b r12 = r11.f72298a
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                java.lang.String r2 = "is_add_pay_allowed"
                java.lang.String r5 = "P2P_TRANSFER"
                java.lang.String r6 = "response"
                r7 = 1
                if (r1 == 0) goto L_0x0096
                java.util.ArrayList r8 = r1.getResponse()
                if (r8 == 0) goto L_0x0096
                net.one97.paytm.wallet.communicator.c r8 = net.one97.paytm.wallet.communicator.b.a()
                android.app.Activity r12 = r12.f72294b
                android.content.Context r12 = (android.content.Context) r12
                boolean r12 = r8.getBooleanFromGTM(r12, r2, r4)
                if (r12 == 0) goto L_0x0096
                java.util.ArrayList r12 = r1.getResponse()
                java.util.Iterator r12 = r12.iterator()
            L_0x003d:
                boolean r8 = r12.hasNext()
                if (r8 == 0) goto L_0x0096
                java.lang.Object r8 = r12.next()
                net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel$Response r8 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel.Response) r8
                java.lang.String r9 = r1.getStatusCode()
                java.lang.String r10 = "SUCCESS"
                boolean r9 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r9, (boolean) r7)
                if (r9 == 0) goto L_0x0071
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
                java.lang.Boolean r9 = r8.getIsLimitApplicable()
                boolean r9 = r9.booleanValue()
                if (r9 != 0) goto L_0x0071
                java.lang.String r9 = r8.getAddMoneyDestination()
                java.lang.String r10 = "MAIN"
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r7)
                if (r9 == 0) goto L_0x0071
                java.lang.Boolean r3 = java.lang.Boolean.TRUE
                goto L_0x0097
            L_0x0071:
                if (r8 == 0) goto L_0x0078
                java.lang.String r9 = r8.getWalletOperationType()
                goto L_0x0079
            L_0x0078:
                r9 = r3
            L_0x0079:
                boolean r9 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r9, (boolean) r7)
                if (r9 == 0) goto L_0x003d
                if (r8 == 0) goto L_0x008c
                java.lang.Object r8 = r8.getLimitMessage()
                if (r8 == 0) goto L_0x008c
                java.lang.String r8 = r8.toString()
                goto L_0x008d
            L_0x008c:
                r8 = r3
            L_0x008d:
                java.lang.String r9 = "AL_0006"
                boolean r8 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r8, (boolean) r7)
                if (r8 == 0) goto L_0x003d
                goto L_0x0097
            L_0x0096:
                r3 = r0
            L_0x0097:
                if (r3 != 0) goto L_0x00b2
                net.one97.paytm.wallet.utility.a.b r12 = r11.f72298a
                android.app.Activity r1 = r12.f72294b
                if (r1 == 0) goto L_0x00b1
                net.one97.paytm.wallet.utility.a.b r0 = r11.f72298a
                java.lang.String r2 = r11.f72299b
                java.lang.String r3 = r11.f72300c
                java.lang.String r4 = r11.f72301d
                net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r5 = r11.f72302e
                net.one97.paytm.wallet.utility.a.b.a(r0, r1, r2, r3, r4, r5)
                net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r12 = r11.f72302e
                r12.onPaymentFailure()
            L_0x00b1:
                return
            L_0x00b2:
                if (r1 == 0) goto L_0x00f9
                java.util.ArrayList r12 = r1.getResponse()
                if (r12 == 0) goto L_0x00f9
                java.util.ArrayList r12 = r1.getResponse()
                java.util.Iterator r12 = r12.iterator()
            L_0x00c2:
                boolean r0 = r12.hasNext()
                if (r0 == 0) goto L_0x00f9
                java.lang.Object r0 = r12.next()
                net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel$Response r0 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel.Response) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
                java.lang.String r3 = r0.getWalletOperationType()
                if (r3 == 0) goto L_0x00c2
                java.lang.Object r3 = r0.getLimitMessage()
                if (r3 == 0) goto L_0x00c2
                java.lang.String r3 = r0.getWalletOperationType()
                boolean r3 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r3, (boolean) r7)
                if (r3 == 0) goto L_0x00c2
                java.lang.Object r0 = r0.getLimitMessage()
                java.lang.String r0 = r0.toString()
                java.lang.String r3 = "AL_0007"
                boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r7)
                if (r0 == 0) goto L_0x00c2
                r12 = 1
                goto L_0x00fa
            L_0x00f9:
                r12 = 0
            L_0x00fa:
                if (r12 == 0) goto L_0x010d
                net.one97.paytm.wallet.utility.a.b r12 = r11.f72298a
                android.app.Activity r12 = r12.f72294b
                if (r12 == 0) goto L_0x010c
                net.one97.paytm.wallet.utility.a.b r0 = r11.f72298a
                net.one97.paytm.wallet.utility.a.b.a(r0, r12)
                net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r12 = r11.f72302e
                r12.onPaymentFailure()
            L_0x010c:
                return
            L_0x010d:
                net.one97.paytm.wallet.utility.a.b r12 = r11.f72298a
                java.util.ArrayList r0 = r1.getResponse()
                java.lang.String r3 = "RWL_1001"
                java.lang.String r8 = "RWL_1000"
                if (r0 == 0) goto L_0x0172
                net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
                android.app.Activity r12 = r12.f72294b
                android.content.Context r12 = (android.content.Context) r12
                boolean r12 = r0.getBooleanFromGTM(r12, r2, r4)
                if (r12 == 0) goto L_0x0172
                java.util.ArrayList r12 = r1.getResponse()
                java.util.Iterator r12 = r12.iterator()
            L_0x012f:
                boolean r0 = r12.hasNext()
                if (r0 == 0) goto L_0x0172
                java.lang.Object r0 = r12.next()
                net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel$Response r0 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel.Response) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
                java.lang.String r9 = r0.getWalletOperationType()
                if (r9 == 0) goto L_0x012f
                java.lang.Object r9 = r0.getLimitMessage()
                if (r9 == 0) goto L_0x012f
                java.lang.String r9 = r0.getWalletOperationType()
                boolean r9 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r9, (boolean) r7)
                if (r9 == 0) goto L_0x012f
                java.lang.Object r9 = r0.getLimitMessage()
                java.lang.String r9 = r9.toString()
                boolean r9 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r7)
                if (r9 != 0) goto L_0x0170
                java.lang.Object r0 = r0.getLimitMessage()
                java.lang.String r0 = r0.toString()
                boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r7)
                if (r0 == 0) goto L_0x012f
            L_0x0170:
                r12 = 0
                goto L_0x0173
            L_0x0172:
                r12 = 1
            L_0x0173:
                if (r12 != 0) goto L_0x01f2
                net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r12 = r11.f72302e
                net.one97.paytm.wallet.utility.a.b r0 = r11.f72298a
                java.util.ArrayList r9 = r1.getResponse()
                if (r9 == 0) goto L_0x01ec
                net.one97.paytm.wallet.communicator.c r9 = net.one97.paytm.wallet.communicator.b.a()
                android.app.Activity r0 = r0.f72294b
                android.content.Context r0 = (android.content.Context) r0
                boolean r0 = r9.getBooleanFromGTM(r0, r2, r4)
                if (r0 == 0) goto L_0x01ec
                java.util.ArrayList r0 = r1.getResponse()
                java.util.Iterator r0 = r0.iterator()
            L_0x0195:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x01ec
                java.lang.Object r1 = r0.next()
                net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel$Response r1 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel.Response) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
                java.lang.String r2 = r1.getWalletOperationType()
                if (r2 == 0) goto L_0x0195
                java.lang.Object r2 = r1.getLimitMessage()
                if (r2 == 0) goto L_0x0195
                java.lang.String r2 = r1.getWalletOperationType()
                boolean r2 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r7)
                if (r2 == 0) goto L_0x0195
                java.lang.Object r2 = r1.getLimitMessage()
                java.lang.String r2 = r2.toString()
                boolean r2 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r2, (boolean) r7)
                if (r2 != 0) goto L_0x01d6
                java.lang.Object r2 = r1.getLimitMessage()
                java.lang.String r2 = r2.toString()
                boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r2, (boolean) r7)
                if (r2 == 0) goto L_0x0195
            L_0x01d6:
                java.lang.String r2 = r1.getMessage()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0195
                java.lang.String r0 = r1.getMessage()
                if (r0 != 0) goto L_0x01ee
                kotlin.g.b.k.a()
                goto L_0x01ee
            L_0x01ec:
                java.lang.String r0 = "can't use wallet due to technical issues, please use other paymodes"
            L_0x01ee:
                r12.onWalletNotAvailableUseOtherPaymodes(r0)
                return
            L_0x01f2:
                net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r12 = r11.f72302e
                r12.handleAddMoneyUIChanges()
                return
            L_0x01f8:
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.ERROR
                if (r0 != r1) goto L_0x0224
                if (r12 == 0) goto L_0x0204
                com.paytm.network.model.NetworkCustomError r12 = r12.f55801c
                if (r12 == 0) goto L_0x0204
                com.paytm.network.model.NetworkCustomError$ErrorType r3 = r12.mErrorType
            L_0x0204:
                com.paytm.network.model.NetworkCustomError$ErrorType r12 = com.paytm.network.model.NetworkCustomError.ErrorType.TimeOutError
                if (r3 != r12) goto L_0x021f
                net.one97.paytm.wallet.utility.a.b r12 = r11.f72298a
                android.app.Activity r12 = r12.f72294b
                android.content.Context r12 = (android.content.Context) r12
                java.lang.String r0 = "Network Timed out. Please try again."
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                android.widget.Toast r12 = android.widget.Toast.makeText(r12, r0, r4)
                r12.show()
                net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r12 = r11.f72302e
                r12.onNetworkTimeOutForWalletLimitsAPI()
                return
            L_0x021f:
                net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener r12 = r11.f72302e
                r12.handleAddMoneyUIChanges()
            L_0x0224:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.b.a.onChanged(java.lang.Object):void");
        }
    }

    public b(Activity activity, Fragment fragment) {
        k.c(activity, "activity");
        k.c(fragment, "fragment");
        this.f72294b = activity;
        this.f72295c = fragment;
        a aVar = a.f72261c;
        this.f72296d = a.a();
        a aVar2 = a.f72261c;
        this.f72297e = a.b();
    }

    public final void a(WalletPaymentCallbackListener walletPaymentCallbackListener, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Activity activity = this.f72294b;
        if (activity != null && this.f72295c != null) {
            if (activity == null) {
                k.a();
            }
            if (!activity.isFinishing()) {
                Fragment fragment = this.f72295c;
                if (fragment == null) {
                    k.a();
                }
                if (fragment.isAdded()) {
                    net.one97.paytm.f.b.a().a(this.f72294b, str6, str5, false, h.P2P.getValue(), (String) null, (String) null);
                    net.one97.paytm.wallet.utility.a.d(this.f72294b);
                    this.f72293a.a(str, str5, (String) null, str2, str3, "0", "0", this.f72296d, str4);
                    at.b a2 = at.a();
                    k.a((Object) a2, "PaymentSessionEventSender.getInstance()");
                    a2.c(Long.valueOf(System.currentTimeMillis()));
                    WalletPaymentCallbackListener walletPaymentCallbackListener2 = walletPaymentCallbackListener;
                    this.f72293a.a(z, walletPaymentCallbackListener);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.wallet.utility.a.b$b  reason: collision with other inner class name */
    public static final class C1465b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f72303a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f72304b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WalletPaymentCallbackListener f72305c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f72306d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f72307e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f72308f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f72309g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f72310h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f72311i;

        public final void a() {
        }

        public final void b() {
        }

        public C1465b(b bVar, x.e eVar, WalletPaymentCallbackListener walletPaymentCallbackListener, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f72303a = bVar;
            this.f72304b = eVar;
            this.f72305c = walletPaymentCallbackListener;
            this.f72306d = str;
            this.f72307e = str2;
            this.f72308f = str3;
            this.f72309g = str4;
            this.f72310h = str5;
            this.f72311i = str6;
        }

        public final void a(IJRDataModel iJRDataModel) {
            k.c(iJRDataModel, "obj");
            net.one97.paytm.f.b.a().c();
            if (TextUtils.isEmpty((String) this.f72304b.element)) {
                this.f72304b.element = "";
            }
            if (iJRDataModel instanceof CJRSendMoney) {
                CJRSendMoney cJRSendMoney = (CJRSendMoney) iJRDataModel;
                String statusCode = cJRSendMoney.getStatusCode();
                String status = cJRSendMoney.getStatus();
                boolean z = true;
                if (cJRSendMoney.getmResponse() != null && cJRSendMoney.getmResponse().getmFFResponse() != null) {
                    Intent h2 = net.one97.paytm.wallet.utility.a.h((Context) this.f72303a.f72294b);
                    h2.putExtra("amount", this.f72306d);
                    h2.putExtra("paymentMode", "p2m");
                    h2.putExtra("paymentType", "pay");
                    h2.putExtra("merchant_logo", this.f72307e);
                    h2.putExtra("is_offline_pg", true);
                    h2.putExtra("is_wallet_transection", true);
                    CJRFastForwardResponse cJRFastForwardResponse = cJRSendMoney.getmResponse().getmFFResponse();
                    if (cJRFastForwardResponse != null) {
                        CJRFastForwardResponseDetail fastForwardResponseDetail = cJRFastForwardResponse.getFastForwardResponseDetail();
                        k.a((Object) fastForwardResponseDetail, "response.fastForwardResponseDetail");
                        h2.putExtra("prn", fastForwardResponseDetail.getPrn());
                        h2.putExtra("phone_no", this.f72308f);
                        h2.putExtra("bundle", cJRFastForwardResponse);
                        h2.putExtra("name", this.f72309g);
                        k.a((Object) h2, "paymentSuccessIntent");
                        h2.setFlags(67108864);
                        Activity activity = this.f72303a.f72294b;
                        if (activity != null) {
                            activity.startActivity(h2);
                        }
                        this.f72305c.onPaymentSuccess();
                        Activity activity2 = this.f72303a.f72294b;
                        if (activity2 != null) {
                            activity2.finish();
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse");
                } else if (p.a("FAILURE", status, true) && p.a("AL_0006", statusCode, true)) {
                    Activity activity3 = this.f72303a.f72294b;
                    if (activity3 != null) {
                        b.a(this.f72303a, activity3, this.f72309g, this.f72308f, this.f72306d, this.f72305c);
                        this.f72305c.onPaymentFailure();
                    }
                } else if (!p.a("FAILURE", status, true) || !p.a("AL_0007", statusCode, true)) {
                    if (!p.a("SUCCESS", status, true) || !p.a("SS_0001", statusCode, true)) {
                        x.e eVar = this.f72304b;
                        T statusMessage = cJRSendMoney.getStatusMessage();
                        k.a((Object) statusMessage, "obj.statusMessage");
                        eVar.element = statusMessage;
                    } else {
                        net.one97.paytm.wallet.d.k.a();
                        String str = this.f72308f;
                        String a2 = net.one97.paytm.wallet.utility.a.a(af.a(), str);
                        if (TextUtils.isEmpty(a2)) {
                            a2 = this.f72309g;
                        }
                        if (TextUtils.isEmpty(a2)) {
                            a2 = "Receiver";
                        }
                        String str2 = a2;
                        if (TextUtils.isEmpty(this.f72303a.f72296d) || !k.a((Object) "QR_CODE", (Object) this.f72303a.f72296d)) {
                            net.one97.paytm.wallet.d.k.a(this.f72303a.f72294b, str2, str, this.f72307e, System.currentTimeMillis(), this.f72306d, "wallet", k.a.NONE);
                        } else {
                            net.one97.paytm.wallet.d.k.a(this.f72303a.f72294b, str2, str, this.f72307e, System.currentTimeMillis(), this.f72306d, "wallet", k.a.SCANNER);
                        }
                        RecentDataNetworkManager.uploadRecentPaymentsData(this.f72303a.f72294b);
                        if (!TextUtils.isEmpty(this.f72303a.f72297e)) {
                            net.one97.paytm.wallet.communicator.b.a().markAsPaid(this.f72303a.f72297e, "QUICK_PAYMENTS", true, this.f72303a.f72294b);
                        }
                    }
                    Intent intent = new Intent(this.f72303a.f72294b, P2PLandingPageActivity.class);
                    String str3 = this.f72308f;
                    if (this.f72309g.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        intent.putExtra("uni_p2p_landing_intent_extra_name", this.f72309g);
                    }
                    intent.putExtra("uni_p2p_landing_intent_extra_comment", (String) this.f72304b.element);
                    intent.putExtra("uni_p2p_landing_intent_extra_theme", this.f72310h);
                    intent.putExtra("uni_p2p_landing_intent_extra_mobile_no", str3);
                    intent.putExtra("uni_p2p_landing_intent_extra_success", cJRSendMoney.getStatus());
                    intent.putExtra("uni_p2p_landing_intent_extra_amount", this.f72306d);
                    intent.putExtra("uni_p2p_landing_intent_extra_image_url", this.f72307e);
                    intent.putExtra("uni_p2p_landing_intent_extra_transaction_id", cJRSendMoney.getResponse().getwalletSysTransactionID());
                    CJRSendMoneyResponse response = cJRSendMoney.getResponse();
                    kotlin.g.b.k.a((Object) response, "obj.response");
                    intent.putExtra("uni_p2p_landing_intent_extra_beneficiary_flag", response.isBeneficiaryAdded());
                    intent.putExtra("uni_p2p_user_primary_vpa", this.f72311i);
                    CJRSendMoneyResponse response2 = cJRSendMoney.getResponse();
                    kotlin.g.b.k.a((Object) response2, "obj.response");
                    intent.putExtra("uni_p2p_landing_intent_extra_timestamp", response2.getResponseTimestamp());
                    try {
                        intent.putExtra("UNI_P2P_LANDING_INTENT_EXTRA_ERROR_CODE", ((CJRSendMoney) iJRDataModel).getStatusCode());
                    } catch (Exception unused) {
                    }
                    Activity activity4 = this.f72303a.f72294b;
                    if (activity4 != null) {
                        activity4.startActivity(intent);
                    }
                    this.f72305c.onPaymentSuccess();
                    Activity activity5 = this.f72303a.f72294b;
                    if (activity5 != null) {
                        activity5.finish();
                    }
                } else {
                    Activity activity6 = this.f72303a.f72294b;
                    if (activity6 != null) {
                        b.a(this.f72303a, activity6);
                        this.f72305c.onPaymentFailure();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, Activity activity, String str, String str2, String str3, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        Fragment fragment;
        net.one97.paytm.wallet.newdesign.addbeneficiary.a a2 = net.one97.paytm.wallet.newdesign.addbeneficiary.a.a();
        if (activity != null) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            a2.a(appCompatActivity, str, str2, str3, walletPaymentCallbackListener);
            if (!appCompatActivity.isFinishing() && (fragment = bVar.f72295c) != null) {
                if (fragment == null) {
                    kotlin.g.b.k.a();
                }
                if (fragment.isAdded()) {
                    try {
                        Fragment fragment2 = bVar.f72295c;
                        if (fragment2 == null) {
                            kotlin.g.b.k.a();
                        }
                        q a3 = fragment2.getChildFragmentManager().a();
                        kotlin.g.b.k.a((Object) a3, "mFragment!!.childFragmen…anager.beginTransaction()");
                        a3.a((Fragment) a2, (String) null);
                        a3.c();
                    } catch (Exception unused) {
                    }
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    public static final /* synthetic */ void a(b bVar, Activity activity) {
        d a2 = d.a();
        a2.a(activity);
        if (bVar.f72295c != null && !activity.isFinishing()) {
            Fragment fragment = bVar.f72295c;
            if (fragment == null) {
                kotlin.g.b.k.a();
            }
            if (fragment.isAdded()) {
                try {
                    Fragment fragment2 = bVar.f72295c;
                    if (fragment2 == null) {
                        kotlin.g.b.k.a();
                    }
                    q a3 = fragment2.getChildFragmentManager().a();
                    kotlin.g.b.k.a((Object) a3, "mFragment!!.childFragmen…anager.beginTransaction()");
                    a3.a((Fragment) a2, (String) null);
                    a3.c();
                } catch (Exception unused) {
                }
            }
        }
    }
}
