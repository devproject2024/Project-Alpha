package net.one97.paytm.wallet.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsReqDataModel;
import net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.f.i;
import net.one97.paytm.wallet.utility.a;
import net.one97.paytm.wallet.utility.j;
import org.json.JSONObject;

public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f70222a;

    /* renamed from: b  reason: collision with root package name */
    protected i f70223b;

    /* renamed from: c  reason: collision with root package name */
    protected a f70224c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70225d;

    /* renamed from: e  reason: collision with root package name */
    private String f70226e;

    /* renamed from: f  reason: collision with root package name */
    private String f70227f;

    /* renamed from: g  reason: collision with root package name */
    private CJRQRScanResultModel f70228g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f70229h = false;

    /* renamed from: i  reason: collision with root package name */
    private ProgressDialog f70230i;
    private String j;
    private Dialog k;
    private boolean l;
    private CJRPGTransactionParams m;

    public final void a(Activity activity, i iVar) {
        this.f70222a = activity;
        this.f70223b = iVar;
        if (this.f70224c == null) {
            this.f70224c = b.b();
        }
        this.f70224c.onAttachToFragment(activity, this);
    }

    public final void c() {
        this.f70222a = null;
        this.f70223b = null;
    }

    public final void a(NetworkCustomError networkCustomError) {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            o();
            m();
            if (networkCustomError != null) {
                try {
                    if (!(networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401)) {
                        if (networkCustomError.getStatusCode() != 403) {
                            if (networkCustomError.getMessage() != null && !b.a().checkErrorCode(this.f70222a, networkCustomError)) {
                                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                    com.paytm.utility.b.b((Context) this.f70222a, this.f70222a.getResources().getString(R.string.network_error_heading), this.f70222a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                                    this.f70223b.a((String) null);
                                    return;
                                }
                                Activity activity2 = this.f70222a;
                                String url = networkCustomError.getUrl();
                                StringBuilder sb = new StringBuilder();
                                sb.append(networkCustomError.getStatusCode());
                                com.paytm.utility.b.d((Context) activity2, url, sb.toString());
                                this.f70223b.a((String) null);
                                return;
                            }
                            return;
                        }
                    }
                    b.a().handleError(this.f70222a, networkCustomError, (String) null, (Bundle) null, false);
                    this.f70223b.a((String) null);
                } catch (Resources.NotFoundException e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e3));
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0317 A[Catch:{ Exception -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x036f A[Catch:{ Exception -> 0x03b3 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0370 A[Catch:{ Exception -> 0x03b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            android.app.Activity r2 = r1.f70222a
            if (r2 == 0) goto L_0x068e
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x0010
            goto L_0x068e
        L_0x0010:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.CJRPGTokenList
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x03d9
            net.one97.paytm.common.entity.CJRPGTokenList r0 = (net.one97.paytm.common.entity.CJRPGTokenList) r0
            android.app.Activity r2 = r1.f70222a
            if (r2 == 0) goto L_0x03d8
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x0024
            goto L_0x03d8
        L_0x0024:
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r0 = r2.getPgToken(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x03cc
            android.app.Activity r2 = r1.f70222a
            if (r2 == 0) goto L_0x03cb
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x003e
            goto L_0x03cb
        L_0x003e:
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r2 = "Content-Type"
            java.lang.String r5 = "application/json"
            r9.put(r2, r5)
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r5 = r1.f70222a
            java.lang.String r6 = "enableGzipCompressionForFastForward"
            boolean r2 = r2.getBooleanFromGTM(r5, r6, r4)
            if (r2 == 0) goto L_0x0064
            java.lang.String r2 = "Accept-Compression"
            java.lang.String r5 = "gzip"
            r9.put(r2, r5)
        L_0x0064:
            java.lang.String r2 = "ssotoken"
            r9.put(r2, r0)
            net.one97.paytm.f.b r0 = net.one97.paytm.f.b.a()
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r0 = r0.f50402a
            if (r0 == 0) goto L_0x0090
            com.google.gson.f r0 = new com.google.gson.f     // Catch:{ Exception -> 0x008f }
            r0.<init>()     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.wallet.d.h$1 r2 = new net.one97.paytm.wallet.d.h$1     // Catch:{ Exception -> 0x008f }
            r2.<init>()     // Catch:{ Exception -> 0x008f }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.f.b r5 = net.one97.paytm.f.b.a()     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r5 = r5.f50402a     // Catch:{ Exception -> 0x008f }
            java.lang.String r0 = r0.a((java.lang.Object) r5, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "risk_extended_info"
            r9.put(r2, r0)     // Catch:{ Exception -> 0x008f }
            goto L_0x0090
        L_0x008f:
        L_0x0090:
            boolean r0 = r1.l
            java.lang.String r2 = "sendMoneyAPITimeout"
            if (r0 == 0) goto L_0x026f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            if (r0 == 0) goto L_0x00c6
            android.app.Activity r0 = r1.f70222a
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            java.lang.Class<net.one97.paytm.wallet.activity.AJRQRActivity> r2 = net.one97.paytm.wallet.activity.AJRQRActivity.class
            java.lang.String r2 = r2.getSimpleName()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r2)
            boolean r2 = r0 instanceof net.one97.paytm.p2mNewDesign.d.g
            if (r2 == 0) goto L_0x00c5
            net.one97.paytm.p2mNewDesign.d.g r0 = (net.one97.paytm.p2mNewDesign.d.g) r0
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r3 = r1.m
            java.lang.String r3 = r3.getTxnAmount()
            r0.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r2, (java.lang.String) r3)
        L_0x00c5:
            return
        L_0x00c6:
            android.app.Activity r0 = r1.f70222a
            java.lang.String r0 = com.paytm.utility.b.A((android.content.Context) r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.app.Activity r4 = r1.f70222a
            java.lang.String r4 = com.paytm.utility.b.v((android.content.Context) r4)
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            r3.append(r4)
            java.lang.String r13 = r3.toString()
            net.one97.paytm.common.entity.offline_pg.paymethodrequest.Head r3 = new net.one97.paytm.common.entity.offline_pg.paymethodrequest.Head
            android.app.Activity r4 = r1.f70222a
            java.lang.String r12 = com.paytm.utility.a.q(r4)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r4 = r1.m
            java.lang.String r14 = r4.getMid()
            java.lang.String r15 = com.paytm.utility.b.k()
            java.lang.String r11 = "SSO"
            java.lang.String r16 = "v1"
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16)
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.setRequestTimeStamp(r4)
            net.one97.paytm.common.entity.offline_pg.paymethodrequest.CJRFastForwardRequest r4 = new net.one97.paytm.common.entity.offline_pg.paymethodrequest.CJRFastForwardRequest
            r4.<init>()
            r4.setHead(r3)
            net.one97.paytm.common.entity.offline_pg.paymethodrequest.CJRFastForwardRequestDetail r3 = new net.one97.paytm.common.entity.offline_pg.paymethodrequest.CJRFastForwardRequestDetail
            r3.<init>()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r5 = r5.H
            if (r5 == 0) goto L_0x0139
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r5 = r5.d()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0139
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r5 = r5.d()
            r3.setOrderId(r5)
            goto L_0x0158
        L_0x0139:
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getOrderId()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x014f
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getOrderId()
            r3.setOrderId(r5)
            goto L_0x0158
        L_0x014f:
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getRefId()
            r3.setRefId(r5)
        L_0x0158:
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getCurrency()
            r3.setCurrency(r5)
            r3.setDeviceId(r0)
            java.lang.String r0 = "CLW_APP_PAY"
            r3.setReqType(r0)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r0 = r1.m
            java.lang.String r0 = r0.getIndustryType()
            r3.setIndustryType(r0)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r0 = r1.m
            java.lang.String r0 = r0.getTxnAmount()
            r3.setTxnAmount(r0)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r0 = r1.m
            java.lang.String r0 = r0.getAuthMode()
            r3.setAuthMode(r0)
            java.lang.String r0 = "WAP"
            r3.setChannel(r0)
            java.lang.String r0 = "PPI"
            r3.setPaymentMode(r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getLinkType()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r6 = "merchantUniqueReference"
            if (r5 != 0) goto L_0x01dc
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getLinkType()
            net.one97.paytm.common.utility.j r7 = net.one97.paytm.common.utility.j.GENERIC
            java.lang.String r7 = r7.name()
            boolean r5 = r5.equalsIgnoreCase(r7)
            if (r5 != 0) goto L_0x01c9
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getLinkType()
            net.one97.paytm.common.utility.j r7 = net.one97.paytm.common.utility.j.FIXED
            java.lang.String r7 = r7.name()
            boolean r5 = r5.equalsIgnoreCase(r7)
            if (r5 == 0) goto L_0x01c6
            goto L_0x01c9
        L_0x01c6:
            net.one97.paytm.common.utility.j r5 = net.one97.paytm.common.utility.j.INVOICE
            goto L_0x01cb
        L_0x01c9:
            net.one97.paytm.common.utility.j r5 = net.one97.paytm.common.utility.j.FIXED
        L_0x01cb:
            java.lang.String r5 = r5.getLinkType()
            r3.setReqType(r5)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getId()
            r0.put(r6, r5)
            goto L_0x01e5
        L_0x01dc:
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getQrCodeId()
            r0.put(r6, r5)
        L_0x01e5:
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getPosId()
            java.lang.String r6 = "udf1"
            r0.put(r6, r5)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getAdditionalInfo()
            java.lang.String r6 = "additionalInfo"
            r0.put(r6, r5)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r5 = r1.m
            java.lang.String r5 = r5.getLinkDescription()
            java.lang.String r6 = "LINK_DESCRIPTION"
            r0.put(r6, r5)
            r3.setExtendInfo(r0)
            android.app.Activity r0 = r1.f70222a
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r0)
            r3.setCustomerId(r0)
            r4.setFastForwardDetail(r3)
            com.google.gson.f r0 = new com.google.gson.f
            r0.<init>()
            java.lang.String r10 = r0.b(r4)
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70222a
            java.lang.String r4 = "offline_pg_fast_forward_URL"
            java.lang.String r0 = r0.getStringFromGTM(r3, r4)
            android.app.Activity r3 = r1.f70222a
            java.lang.String r6 = com.paytm.utility.b.e((android.content.Context) r3, (java.lang.String) r0)
            android.app.Activity r0 = r1.f70222a
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0268
            net.one97.paytm.network.b r0 = new net.one97.paytm.network.b
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse r7 = new net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse
            r7.<init>()
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r0.e()
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r4 = r1.f70222a
            int r2 = r3.getIntegerFromGTM((android.content.Context) r4, (java.lang.String) r2)
            int r2 = net.one97.paytm.wallet.utility.a.a((int) r2)
            r0.a(r2)
            androidx.lifecycle.y r0 = r0.c()
            net.one97.paytm.wallet.d.-$$Lambda$h$trjVOuzCtTtJw_Kt155pAu5j-yk r2 = new net.one97.paytm.wallet.d.-$$Lambda$h$trjVOuzCtTtJw_Kt155pAu5j-yk
            r2.<init>()
            r0.observeForever(r2)
            return
        L_0x0268:
            r17.l()
            r17.m()
            return
        L_0x026f:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            org.json.JSONObject r0 = r0.getJson()     // Catch:{ Exception -> 0x03b3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r5 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r5 = r5.getMerchantGUID()     // Catch:{ Exception -> 0x03b3 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x03b3 }
            if (r5 != 0) goto L_0x028e
            java.lang.String r5 = "merchantGuid"
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r6 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r6 = r6.getMerchantGUID()     // Catch:{ Exception -> 0x03b3 }
            r0.put(r5, r6)     // Catch:{ Exception -> 0x03b3 }
            r5 = 1
            goto L_0x028f
        L_0x028e:
            r5 = 0
        L_0x028f:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r6 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r6 = r6.getMID()     // Catch:{ Exception -> 0x03b3 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x03b3 }
            if (r6 != 0) goto L_0x02a7
            java.lang.String r5 = "MID"
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r6 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r6 = r6.getMID()     // Catch:{ Exception -> 0x03b3 }
            r0.put(r5, r6)     // Catch:{ Exception -> 0x03b3 }
            goto L_0x02a8
        L_0x02a7:
            r3 = r5
        L_0x02a8:
            if (r3 == 0) goto L_0x03ab
            java.lang.String r3 = "totalAmount"
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r5 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r6 = r1.f70226e     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r7 = r5.getTxnAmount()     // Catch:{ Exception -> 0x03b3 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x03b3 }
            if (r7 == 0) goto L_0x02bb
            goto L_0x02bf
        L_0x02bb:
            java.lang.String r6 = r5.getTxnAmount()     // Catch:{ Exception -> 0x03b3 }
        L_0x02bf:
            double r5 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x03b3 }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x03b3 }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x03b3 }
            net.one97.paytm.p2mNewDesign.g.c r3 = r3.H     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r5 = "merchantOrderId"
            if (r3 == 0) goto L_0x02ea
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = r3.d()     // Catch:{ Exception -> 0x03b3 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x03b3 }
            if (r3 != 0) goto L_0x02ea
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = r3.d()     // Catch:{ Exception -> 0x03b3 }
            r0.put(r5, r3)     // Catch:{ Exception -> 0x03b3 }
            goto L_0x02f3
        L_0x02ea:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r3 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = r3.getOrderID()     // Catch:{ Exception -> 0x03b3 }
            r0.put(r5, r3)     // Catch:{ Exception -> 0x03b3 }
        L_0x02f3:
            java.lang.String r3 = "industryType"
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r5 = r1.f70228g     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r5 = r5.getIndustryTypeID()     // Catch:{ Exception -> 0x03b3 }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = "currencyCode"
            java.lang.String r5 = "INR"
            r0.put(r3, r5)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = "TXN_AMOUNT"
            r0.remove(r3)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = "ORDER_ID"
            r0.remove(r3)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = r1.f70227f     // Catch:{ Exception -> 0x03b3 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x03b3 }
            if (r3 != 0) goto L_0x031e
            java.lang.String r3 = "comment"
            java.lang.String r5 = r1.f70227f     // Catch:{ Exception -> 0x03b3 }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x03b3 }
        L_0x031e:
            android.app.Activity r3 = r1.f70222a     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r5 = "phone"
            r3.getSystemService(r5)     // Catch:{ Exception -> 0x03b3 }
            android.app.Activity r3 = r1.f70222a     // Catch:{ Exception -> 0x03b3 }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r3 = com.paytm.utility.b.e((android.content.Context) r3)     // Catch:{ Exception -> 0x03b3 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x03b3 }
            r5.<init>()     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r6 = "request"
            r5.put(r6, r0)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r0 = "platformName"
            java.lang.String r6 = "PayTM"
            r5.put(r0, r6)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r0 = "operationType"
            java.lang.String r6 = "WITHDRAW_MONEY"
            r5.put(r0, r6)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r0 = "mode"
            java.lang.String r6 = "QRCODE"
            r5.put(r0, r6)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r0 = "deviceId"
            r5.put(r0, r3)     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r10 = r5.toString()     // Catch:{ Exception -> 0x03b3 }
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x03b3 }
            android.app.Activity r3 = r1.f70222a     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r5 = "WalletPayMerchantV8"
            java.lang.String r0 = r0.getStringFromGTM(r3, r5)     // Catch:{ Exception -> 0x03b3 }
            android.app.Activity r3 = r1.f70222a     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r6 = com.paytm.utility.b.e((android.content.Context) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x03b3 }
            boolean r0 = android.webkit.URLUtil.isValidUrl(r6)     // Catch:{ Exception -> 0x03b3 }
            if (r0 != 0) goto L_0x0370
            return
        L_0x0370:
            android.app.Activity r0 = r1.f70222a     // Catch:{ Exception -> 0x03b3 }
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)     // Catch:{ Exception -> 0x03b3 }
            if (r0 == 0) goto L_0x03a4
            net.one97.paytm.network.b r0 = new net.one97.paytm.network.b     // Catch:{ Exception -> 0x03b3 }
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel r7 = new net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel     // Catch:{ Exception -> 0x03b3 }
            r7.<init>()     // Catch:{ Exception -> 0x03b3 }
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x03b3 }
            r0.e()     // Catch:{ Exception -> 0x03b3 }
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x03b3 }
            android.app.Activity r5 = r1.f70222a     // Catch:{ Exception -> 0x03b3 }
            int r2 = r3.getIntegerFromGTM((android.content.Context) r5, (java.lang.String) r2)     // Catch:{ Exception -> 0x03b3 }
            int r2 = net.one97.paytm.wallet.utility.a.a((int) r2)     // Catch:{ Exception -> 0x03b3 }
            r0.a(r2)     // Catch:{ Exception -> 0x03b3 }
            androidx.lifecycle.y r0 = r0.c()     // Catch:{ Exception -> 0x03b3 }
            net.one97.paytm.wallet.d.-$$Lambda$h$9OgoU8WwO4c5KgMRKgPYxMe5-D4 r2 = new net.one97.paytm.wallet.d.-$$Lambda$h$9OgoU8WwO4c5KgMRKgPYxMe5-D4     // Catch:{ Exception -> 0x03b3 }
            r2.<init>()     // Catch:{ Exception -> 0x03b3 }
            r0.observeForever(r2)     // Catch:{ Exception -> 0x03b3 }
            return
        L_0x03a4:
            r17.l()     // Catch:{ Exception -> 0x03b3 }
            r17.m()     // Catch:{ Exception -> 0x03b3 }
            return
        L_0x03ab:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x03b3 }
            java.lang.String r2 = "Incorrect QR, Both MID & merchantGUID not present"
            r0.<init>(r2)     // Catch:{ Exception -> 0x03b3 }
            throw r0     // Catch:{ Exception -> 0x03b3 }
        L_0x03b3:
            r0 = move-exception
            r17.m()
            android.app.Activity r2 = r1.f70222a
            java.lang.String r3 = r0.getMessage()
            android.widget.Toast.makeText(r2, r3, r4)
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x03cb
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
        L_0x03cb:
            return
        L_0x03cc:
            r17.m()
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r2 = r1.f70222a
            r0.showSessionTimeoutAlert(r2)
        L_0x03d8:
            return
        L_0x03d9:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel
            java.lang.String r5 = "SUCCESS"
            if (r2 == 0) goto L_0x042e
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel r0 = (net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel) r0
            android.app.Activity r2 = r1.f70222a
            if (r2 == 0) goto L_0x042d
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x03ec
            goto L_0x042d
        L_0x03ec:
            r17.o()
            r17.m()
            if (r0 == 0) goto L_0x042d
            java.lang.String r2 = r0.getStatusCode()
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0404
            net.one97.paytm.wallet.f.i r2 = r1.f70223b
            r2.a((net.one97.paytm.common.entity.IJRDataModel) r0)
            return
        L_0x0404:
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70222a
            boolean r2 = r2.instanceOfIDPostcardActiovity(r3)
            if (r2 == 0) goto L_0x041a
            net.one97.paytm.wallet.f.i r2 = r1.f70223b
            java.lang.String r0 = r0.getStatusMessage()
            r2.a((java.lang.String) r0)
            return
        L_0x041a:
            android.app.Activity r2 = r1.f70222a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.wallet.R.string.send_money
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r0 = r0.getStatusMessage()
            r1.a((java.lang.String) r2, (java.lang.String) r0)
        L_0x042d:
            return
        L_0x042e:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            if (r2 == 0) goto L_0x0483
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r0
            if (r0 == 0) goto L_0x047f
            java.lang.String r2 = r0.getPaymentStatus()
            if (r2 == 0) goto L_0x047f
            java.lang.String r0 = r0.getPaymentStatus()
            boolean r2 = r0.equalsIgnoreCase(r5)
            if (r2 == 0) goto L_0x044d
            r17.o()
            r17.i()
            return
        L_0x044d:
            java.lang.String r2 = "FAILED"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x045c
            r17.o()
            r17.e()
            return
        L_0x045c:
            boolean r0 = r1.f70229h
            if (r0 != 0) goto L_0x0478
            android.app.Activity r0 = r1.f70222a
            if (r0 != 0) goto L_0x0465
            goto L_0x0478
        L_0x0465:
            com.paytm.utility.b.j()
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            net.one97.paytm.wallet.d.h$9 r2 = new net.one97.paytm.wallet.d.h$9
            r2.<init>()
            r3 = 5000(0x1388, double:2.4703E-320)
            r0.postDelayed(r2, r3)
            return
        L_0x0478:
            r17.o()
            r17.f()
            return
        L_0x047f:
            r17.o()
            return
        L_0x0483:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse
            if (r2 == 0) goto L_0x053c
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse r0 = (net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse) r0
            android.app.Activity r2 = r1.f70222a
            if (r2 == 0) goto L_0x053b
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x0495
            goto L_0x053b
        L_0x0495:
            r17.o()
            r17.m()
            if (r0 == 0) goto L_0x053b
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r2 = r0.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r2 = r2.getResultInfo()
            java.lang.String r2 = r2.getResultStatus()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r3 = r0.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r3 = r3.getResultInfo()
            java.lang.String r3 = r3.getResultCode()
            java.lang.String r4 = "TXN_SUCCESS"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0536
            java.lang.String r4 = "PENDING"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0536
            java.lang.String r4 = "TXN_PENDING"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0536
            java.lang.String r4 = "TXN_FAILURE"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x04d6
            goto L_0x0536
        L_0x04d6:
            if (r3 == 0) goto L_0x04fc
            java.lang.String r2 = "MERCHANT_VELOCITY_LIMIT_BREACH"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x04fc
            android.app.Activity r2 = r1.f70222a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.wallet.R.string.payment_declined
            java.lang.String r2 = r2.getString(r3)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r0 = r0.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r0 = r0.getResultInfo()
            java.lang.String r0 = r0.getResultMsg()
            r1.a((java.lang.String) r2, (java.lang.String) r0)
            return
        L_0x04fc:
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70222a
            boolean r2 = r2.instanceOfIDPostcardActiovity(r3)
            if (r2 == 0) goto L_0x051a
            net.one97.paytm.wallet.f.i r2 = r1.f70223b
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r0 = r0.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r0 = r0.getResultInfo()
            java.lang.String r0 = r0.getResultMsg()
            r2.a((java.lang.String) r0)
            return
        L_0x051a:
            android.app.Activity r2 = r1.f70222a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.wallet.R.string.send_money
            java.lang.String r2 = r2.getString(r3)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r0 = r0.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r0 = r0.getResultInfo()
            java.lang.String r0 = r0.getResultMsg()
            r1.a((java.lang.String) r2, (java.lang.String) r0)
            goto L_0x053b
        L_0x0536:
            net.one97.paytm.wallet.f.i r2 = r1.f70223b
            r2.a((net.one97.paytm.common.entity.IJRDataModel) r0)
        L_0x053b:
            return
        L_0x053c:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel
            if (r2 == 0) goto L_0x068e
            net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel r0 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel) r0
            if (r0 == 0) goto L_0x0678
            java.util.ArrayList r2 = r0.getResponse()
            if (r2 == 0) goto L_0x0678
            java.util.ArrayList r2 = r0.getResponse()
            java.util.Iterator r2 = r2.iterator()
            java.lang.String r5 = ""
            r6 = r5
        L_0x0555:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0572
            java.lang.Object r7 = r2.next()
            net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel$Response r7 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel.Response) r7
            java.lang.String r8 = r7.getWalletOperationType()
            java.lang.String r9 = "ADD_MONEY"
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x0555
            java.lang.String r6 = r7.getAddMoneyDestination()
            goto L_0x0555
        L_0x0572:
            java.util.ArrayList r0 = r0.getResponse()
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x057b:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x05ac
            java.lang.Object r2 = r0.next()
            net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel$Response r2 = (net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel.Response) r2
            java.lang.Boolean r7 = r2.getIsLimitApplicable()
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x05aa
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x059f
            android.app.Activity r0 = r1.f70222a
            int r5 = net.one97.paytm.wallet.R.string.title_400
            java.lang.String r5 = r0.getString(r5)
        L_0x059f:
            java.lang.String r0 = r2.getMessage()
            if (r0 == 0) goto L_0x05ad
            java.lang.String r5 = r2.getMessage()
            goto L_0x05ad
        L_0x05aa:
            r2 = r7
            goto L_0x057b
        L_0x05ac:
            r7 = r2
        L_0x05ad:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "P2M_"
            r0.<init>(r2)
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r1.f70228g
            if (r2 == 0) goto L_0x05cb
            java.lang.String r2 = r2.getMID()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x05cb
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r1.f70228g
            java.lang.String r2 = r2.getMID()
            r0.append(r2)
        L_0x05cb:
            android.app.Activity r2 = r1.f70222a
            java.lang.String r2 = net.one97.paytm.wallet.utility.a.a((android.content.Context) r2)
            java.lang.String r8 = r1.f70226e
            java.lang.String r8 = net.one97.paytm.wallet.utility.a.a((java.lang.String) r2, (java.lang.String) r8)
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r9 = r1.m
            if (r9 == 0) goto L_0x05ff
            boolean r9 = r9.isPCF()
            if (r9 == 0) goto L_0x05ff
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r9 = r1.m
            java.lang.Double r9 = r9.getPcfAmount()
            double r9 = r9.doubleValue()
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x05ff
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r8 = r1.m
            java.lang.Double r8 = r8.getPcfAmount()
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = net.one97.paytm.wallet.utility.a.a((java.lang.String) r2, (java.lang.String) r8)
        L_0x05ff:
            r10 = r8
            r17.n()
            if (r7 != 0) goto L_0x0668
            if (r6 == 0) goto L_0x0615
            java.lang.String r2 = "GIFT"
            boolean r2 = r6.contains(r2)
            if (r2 == 0) goto L_0x0615
            net.one97.paytm.wallet.d.a r2 = r1.f70224c
            r2.setIsForGiftVoucher(r3)
            goto L_0x061a
        L_0x0615:
            net.one97.paytm.wallet.d.a r2 = r1.f70224c
            r2.setIsForGiftVoucher(r4)
        L_0x061a:
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r2 = r1.m
            if (r2 == 0) goto L_0x065e
            java.lang.String r2 = r2.getLinkType()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x065e
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r2 = r1.m
            java.lang.String r2 = r2.getId()
            if (r2 != 0) goto L_0x0647
            net.one97.paytm.wallet.d.a r9 = r1.f70224c
            r11 = 1
            java.lang.String r12 = r0.toString()
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r0 = r1.m
            java.lang.String r13 = r0.getLinkType()
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r0 = r1.m
            java.lang.String r14 = r0.getRefId()
            r9.addMoneyForInsufficientBalanceError(r10, r11, r12, r13, r14)
            return
        L_0x0647:
            net.one97.paytm.wallet.d.a r9 = r1.f70224c
            r11 = 1
            java.lang.String r12 = r0.toString()
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r0 = r1.m
            java.lang.String r13 = r0.getLinkType()
            net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams r0 = r1.m
            java.lang.String r14 = r0.getId()
            r9.addMoneyForInsufficientBalanceError(r10, r11, r12, r13, r14)
            return
        L_0x065e:
            net.one97.paytm.wallet.d.a r2 = r1.f70224c
            java.lang.String r0 = r0.toString()
            r2.addMoneyForInsufficientBalanceError(r10, r3, r0)
            return
        L_0x0668:
            android.app.Activity r0 = r1.f70222a
            android.content.res.Resources r0 = r0.getResources()
            int r2 = net.one97.paytm.wallet.R.string.payment_declined
            java.lang.String r0 = r0.getString(r2)
            r1.a((java.lang.String) r0, (java.lang.String) r5)
            return
        L_0x0678:
            r17.n()
            android.app.Activity r0 = r1.f70222a
            int r2 = net.one97.paytm.wallet.R.string.error
            java.lang.String r0 = r0.getString(r2)
            android.app.Activity r2 = r1.f70222a
            int r3 = net.one97.paytm.wallet.R.string.some_went_wrong
            java.lang.String r2 = r2.getString(r3)
            r1.a((java.lang.String) r0, (java.lang.String) r2)
        L_0x068e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.d.h.a(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void a(CJRQRScanResultModel cJRQRScanResultModel, String str, String str2) {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            this.f70226e = str;
            this.f70228g = cJRQRScanResultModel;
            this.f70227f = str2;
            k();
            a(cJRQRScanResultModel);
        }
    }

    public final void a(CJRQRScanResultModel cJRQRScanResultModel, CJRPGTransactionParams cJRPGTransactionParams, String str, String str2) {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            this.f70226e = str;
            this.f70228g = cJRQRScanResultModel;
            this.m = cJRPGTransactionParams;
            this.f70227f = str2;
            k();
            a(cJRQRScanResultModel);
        }
    }

    public final void a(CJRPGTransactionParams cJRPGTransactionParams, String str, String str2, String str3) {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            this.f70226e = str2;
            this.m = cJRPGTransactionParams;
            this.f70227f = str3;
            this.l = true;
            k();
            try {
                n();
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                double parseDouble = Double.parseDouble(str);
                double parseDouble2 = Double.parseDouble(this.f70226e);
                if (this.m != null && this.m.isPCF() && this.m.getPcfAmount().doubleValue() > 0.0d) {
                    parseDouble2 = this.m.getPcfAmount().doubleValue();
                }
                if (parseDouble2 <= parseDouble || this.m.isBalanceUnavailable()) {
                    i();
                    return;
                }
                String additionalInfo = this.m.getAdditionalInfo();
                StringBuilder sb = new StringBuilder();
                sb.append(parseDouble2 - parseDouble);
                this.m.setAdditionalInfo(a.d(additionalInfo, sb.toString()));
                this.f70222a.getResources().getString(R.string.insufficient_balance_error_title);
                this.f70222a.getResources().getString(R.string.insufficient_balance_error_message);
                h();
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void a(CJRPGTransactionParams cJRPGTransactionParams, String str) {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            this.l = true;
            this.m = cJRPGTransactionParams;
            this.f70226e = cJRPGTransactionParams.getTxnAmount();
            this.f70227f = str;
            k();
            try {
                String stringFromGTM = b.a().getStringFromGTM(this.f70222a, "pgWalletBalanceURL");
                if (stringFromGTM == null) {
                    return;
                }
                if (URLUtil.isValidUrl(stringFromGTM)) {
                    String e2 = com.paytm.utility.b.e((Context) this.f70222a, stringFromGTM);
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(cJRPGTransactionParams.getMerchantGUID())) {
                        jSONObject2.put(CJRQRScanResultModel.KEY_MERCHANT_GUID, cJRPGTransactionParams.getMerchantGUID());
                    }
                    if (!TextUtils.isEmpty(cJRPGTransactionParams.getMid())) {
                        jSONObject2.put("mid", cJRPGTransactionParams.getMid());
                    }
                    jSONObject.put("request", jSONObject2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70222a));
                    hashMap.put("Accept-Encoding", "gzip");
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f70222a));
                    com.paytm.utility.b.j();
                    if (com.paytm.utility.b.c((Context) this.f70222a)) {
                        new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z() {
                            public final void onChanged(Object obj) {
                                h.this.a((f) obj);
                            }
                        });
                        return;
                    }
                    l();
                    m();
                }
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
        }
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Activity activity = this.f70222a;
            if (activity != null && !activity.isFinishing()) {
                this.j = str;
                this.f70229h = false;
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        boolean unused = h.this.f70229h = true;
                        com.paytm.utility.b.j();
                    }
                }, 120000);
                Activity activity2 = this.f70222a;
                if (activity2 != null && !activity2.isFinishing()) {
                    try {
                        if (this.f70230i == null) {
                            this.f70230i = new ProgressDialog(this.f70222a);
                            this.f70230i.setProgressStyle(0);
                            this.f70230i.setMessage(this.f70222a.getResources().getString(R.string.paytm_cash_addition_confirmation_message));
                            this.f70230i.setCancelable(false);
                            this.f70230i.setCanceledOnTouchOutside(false);
                        }
                        if (!this.f70230i.isShowing()) {
                            this.f70230i.show();
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                }
                g();
                return;
            }
            return;
        }
        e();
    }

    private void e() {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            o();
            new AlertDialog.Builder(this.f70222a).setTitle(R.string.wallet_add_money_failure_title).setMessage(R.string.wallet_add_money_failure_message).setPositiveButton(R.string.wallet_add_money_failure_positive_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    h.this.d();
                }
            }).setNegativeButton(R.string.wallet_add_money_failure_negative_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    private void f() {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            o();
            new AlertDialog.Builder(this.f70222a).setTitle(R.string.wallet_add_money_delayed_title).setMessage(R.string.wallet_add_money_delayed_message).setPositiveButton(R.string.wallet_add_money_delayed_positive_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f70229h || this.f70222a == null) {
            o();
            f();
            return;
        }
        String str = b.a().getStringFromGTM(this.f70222a, "orderdetail") + this.j;
        new net.one97.paytm.network.a(com.paytm.utility.b.b((Context) this.f70222a, str) + "&actions=1", new CJROrderSummary(), (Map<String, String>) null, (Map<String, String>) null).c().observeForever(new z() {
            public final void onChanged(Object obj) {
                h.this.c((f) obj);
            }
        });
    }

    private void h() {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            d();
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        if (this.f70224c != null) {
            String a2 = a.a((Context) this.f70222a);
            String a3 = a.a(a2, this.f70226e);
            CJRPGTransactionParams cJRPGTransactionParams = this.m;
            if (cJRPGTransactionParams != null && cJRPGTransactionParams.isPCF() && this.m.getPcfAmount().doubleValue() > 0.0d) {
                a3 = a.a(a2, this.m.getPcfAmount().toString());
            }
            k();
            c(a3);
        }
    }

    private void c(String str) {
        String stringFromGTM = b.a().getStringFromGTM(this.f70222a, "walletLimitV2");
        if (URLUtil.isValidUrl(stringFromGTM)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70222a.getApplicationContext()));
            hashMap.put("tokentype", "OAUTH");
            hashMap.put("is_admin", "false");
            hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap.put("Content-Type", "application/json");
            WalletLimitsReqDataModel walletLimitsReqDataModel = new WalletLimitsReqDataModel();
            walletLimitsReqDataModel.setOperationType("WALLET_LIMIT");
            walletLimitsReqDataModel.setPlatformName("PayTM");
            WalletLimitsReqDataModel.Request request = new WalletLimitsReqDataModel.Request();
            request.setSsoId(com.paytm.utility.b.n(this.f70222a.getApplicationContext()));
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add("ADD_MONEY");
                arrayList.add("WITHDRAW_MONEY");
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
            request.setWalletOperationTypeList(arrayList);
            ArrayList arrayList2 = new ArrayList();
            try {
                arrayList2.add(Double.valueOf(Double.parseDouble(str)));
                arrayList2.add(Double.valueOf(Double.parseDouble(this.f70226e)));
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
            request.setWalletOperationTypeBasedAmountList(arrayList2);
            walletLimitsReqDataModel.setRequest(request);
            net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new WalletLimitsResDataModel(), (Map<String, String>) null, hashMap, new com.google.gsonhtcfix.f().a((Object) walletLimitsReqDataModel, (Type) WalletLimitsReqDataModel.class));
            bVar.c().observeForever(new z(bVar) {
                private final /* synthetic */ net.one97.paytm.network.b f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    h.this.a(this.f$1, (f) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.b bVar, f fVar) {
        bVar.e();
        bVar.a(a.a(b.a().getIntegerFromGTM((Context) this.f70222a, "walletLimitApiTimeout")));
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            g gVar = fVar.f55798c;
            if (gVar == null || gVar.f55801c.mErrorType == null || gVar.f55801c.mErrorType != NetworkCustomError.ErrorType.TimeOutError) {
                a(gVar.f55801c);
                return;
            }
            Activity activity = this.f70222a;
            if (activity != null && !activity.isFinishing()) {
                o();
                m();
                Activity activity2 = this.f70222a;
                com.paytm.utility.b.b((Context) activity2, "Alert", activity2.getResources().getString(R.string.time_out_msg_wallet_limit));
            }
        }
    }

    private void i() {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            if (com.paytm.utility.b.c((Context) this.f70222a)) {
                String q = com.paytm.utility.a.q(this.f70222a);
                if (!TextUtils.isEmpty(q)) {
                    j();
                    b.a().getWalletToken(q, this.f70222a, new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            h.this.a(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            h.this.a(networkCustomError);
                        }
                    });
                    return;
                }
                b.a().showSessionTimeoutAlert(this.f70222a);
                return;
            }
            l();
            m();
        }
    }

    private void j() {
        i iVar = this.f70223b;
        if (iVar != null) {
            iVar.a();
        }
        k();
    }

    private void k() {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing() && !b.a().instanceOfIDPostcardActiovity(this.f70222a) && !this.f70225d) {
            try {
                if (this.k == null) {
                    this.k = a.b(this.f70222a);
                }
                if (this.k != null && !this.k.isShowing()) {
                    this.k.show();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f70222a != null && !this.f70222a.isFinishing()) {
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f70222a);
                builder.setTitle(str);
                builder.setMessage(str2);
                builder.setPositiveButton(this.f70222a.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        if (h.this.f70222a != null) {
                            h.this.f70222a.finish();
                        }
                    }
                });
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        if (h.this.f70222a != null) {
                            h.this.f70222a.finish();
                        }
                    }
                });
                builder.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void a(String str) {
        Activity activity;
        if (!TextUtils.isEmpty(str) && (activity = this.f70222a) != null && !activity.isFinishing()) {
            Activity activity2 = this.f70222a;
            a.a(activity2, activity2.getString(R.string.error), str);
        }
    }

    public final void a() {
        i iVar = this.f70223b;
        if (iVar != null) {
            iVar.a();
        }
    }

    public final void b() {
        i iVar = this.f70223b;
        if (iVar != null) {
            iVar.b();
        }
    }

    private void l() {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            m();
            a.a(this.f70222a);
        }
    }

    private void m() {
        i iVar = this.f70223b;
        if (iVar != null) {
            iVar.b();
        }
        n();
    }

    private void n() {
        try {
            if (this.k != null && this.k.isShowing()) {
                this.k.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private void o() {
        try {
            if (this.f70230i != null && this.f70230i.isShowing()) {
                this.f70230i.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private void a(CJRQRScanResultModel cJRQRScanResultModel) {
        try {
            String stringFromGTM = b.a().getStringFromGTM(this.f70222a, "pgWalletBalanceURL");
            if (stringFromGTM == null) {
                return;
            }
            if (URLUtil.isValidUrl(stringFromGTM)) {
                String e2 = com.paytm.utility.b.e((Context) this.f70222a, stringFromGTM);
                JSONObject jSONObject = new JSONObject();
                String mid = cJRQRScanResultModel.getMID();
                String merchantGUID = cJRQRScanResultModel.getMerchantGUID();
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(merchantGUID)) {
                    jSONObject2.put(CJRQRScanResultModel.KEY_MERCHANT_GUID, merchantGUID);
                }
                if (!TextUtils.isEmpty(mid)) {
                    jSONObject2.put("mid", mid);
                }
                jSONObject.put("request", jSONObject2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70222a));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f70222a));
                com.paytm.utility.b.j();
                if (com.paytm.utility.b.c((Context) this.f70222a)) {
                    new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            h.this.b((f) obj);
                        }
                    });
                }
            }
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
    }

    private void p() {
        Activity activity = this.f70222a;
        if (activity != null && !activity.isFinishing()) {
            o();
            m();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            n();
            CJRCashWallet cJRCashWallet = (CJRCashWallet) fVar.f55797b;
            if (cJRCashWallet.getResponse() != null) {
                double totalBalance = cJRCashWallet.getResponse().getTotalBalance();
                String b2 = com.paytm.utility.b.b(Double.valueOf(totalBalance));
                a.a((Context) this.f70222a, totalBalance);
                if (TextUtils.isEmpty(b2)) {
                    i();
                } else if (Double.parseDouble(this.f70226e) > totalBalance) {
                    this.f70222a.getResources().getString(R.string.insufficient_balance_error_title);
                    this.f70222a.getResources().getString(R.string.insufficient_balance_error_message);
                    h();
                } else {
                    i();
                }
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            n();
            if (fVar.f55798c == null || !(fVar.f55798c.f55799a == 410 || fVar.f55798c.f55799a == 401 || fVar.f55798c.f55799a == 403)) {
                m();
            } else {
                b.a().handleError(this.f70222a, fVar.f55798c.f55801c, h.class.getName(), (Bundle) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            n();
            CJRCashWallet cJRCashWallet = (CJRCashWallet) fVar.f55797b;
            if (cJRCashWallet.getResponse() != null) {
                double totalBalance = cJRCashWallet.getResponse().getTotalBalance();
                String b2 = com.paytm.utility.b.b(Double.valueOf(totalBalance));
                a.a((Context) this.f70222a, totalBalance);
                if (!TextUtils.isEmpty(b2)) {
                    double parseDouble = Double.parseDouble(this.f70226e);
                    CJRPGTransactionParams cJRPGTransactionParams = this.m;
                    if (cJRPGTransactionParams != null && cJRPGTransactionParams.isPCF()) {
                        parseDouble = this.m.getPcfAmount().doubleValue();
                    }
                    if (parseDouble > totalBalance) {
                        this.f70222a.getResources().getString(R.string.insufficient_balance_error_title);
                        this.f70222a.getResources().getString(R.string.insufficient_balance_error_message);
                        h();
                        return;
                    }
                    i();
                    return;
                }
                i();
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            n();
            if (fVar.f55798c == null || !(fVar.f55798c.f55799a == 410 || fVar.f55798c.f55799a == 401 || fVar.f55798c.f55799a == 403)) {
                m();
            } else {
                b.a().handleError(this.f70222a, fVar.f55798c.f55801c, h.class.getName(), (Bundle) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            p();
            g gVar = fVar.f55798c;
            if (net.one97.paytm.wallet.utility.b.a(gVar.f55799a, j.f72323b)) {
                net.one97.paytm.wallet.utility.b.a(this.f70222a, net.one97.paytm.p2mNewDesign.d.g.class.getName(), gVar.f55801c);
                return;
            }
            Activity activity = this.f70222a;
            com.paytm.utility.b.b((Context) activity, "Alert", activity.getResources().getString(R.string.wallet_generic_msg));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            p();
            g gVar = fVar.f55798c;
            if (gVar.f55801c.mErrorType == NetworkCustomError.ErrorType.TimeOutError) {
                CJRFastForwardResponse cJRFastForwardResponse = new CJRFastForwardResponse();
                cJRFastForwardResponse.setFastForwardResponseDetail(new CJRFastForwardResponseDetail());
                cJRFastForwardResponse.getFastForwardResponseDetail().setResultInfo(new ResultInfo());
                cJRFastForwardResponse.setHead(new Head());
                cJRFastForwardResponse.getFastForwardResponseDetail().getResultInfo().setResultMsg("");
                cJRFastForwardResponse.getHead().setMid(this.m.getMid());
                cJRFastForwardResponse.getFastForwardResponseDetail().setOrderId(!TextUtils.isEmpty(this.m.getOrderId()) ? this.m.getOrderId() : this.m.getRefId());
                cJRFastForwardResponse.getFastForwardResponseDetail().getResultInfo().setResultStatus("PENDING");
                cJRFastForwardResponse.getFastForwardResponseDetail().setPrn("");
                cJRFastForwardResponse.getFastForwardResponseDetail().setTxnAmount(this.m.getTxnAmount());
                a((IJRPaytmDataModel) cJRFastForwardResponse);
            } else if (net.one97.paytm.wallet.utility.b.a(gVar.f55799a, j.f72323b)) {
                net.one97.paytm.wallet.utility.b.a(this.f70222a, net.one97.paytm.p2mNewDesign.d.g.class.getName(), gVar.f55801c);
            } else {
                Activity activity = this.f70222a;
                com.paytm.utility.b.b((Context) activity, "Alert", activity.getResources().getString(R.string.wallet_fastforward_failure_msg));
            }
        }
    }
}
