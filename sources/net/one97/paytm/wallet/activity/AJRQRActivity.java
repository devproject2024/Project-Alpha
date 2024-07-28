package net.one97.paytm.wallet.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.gsonhtcfix.f;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytm.utility.v;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.AJRLockActivity;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.p2mNewDesign.d.g;
import net.one97.paytm.p2mNewDesign.e.c;
import net.one97.paytm.p2mNewDesign.entity.CJROrderSummary;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.c.j;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.f.m;
import net.one97.paytm.wallet.utility.a;

public class AJRQRActivity extends AJRLockActivity implements View.OnClickListener, m {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f69910b = AJRQRActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    boolean f69911a = false;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f69912c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f69913e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f69914f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f69915g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f69916h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f69917i;
    private CReceiver j;
    private IntentFilter k;
    private boolean l;
    private String m;
    private boolean n;
    private boolean o;

    public final void a(String str) {
        setTitle(str);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            r11 = r17
            super.onCreate(r18)
            int r0 = net.one97.paytm.wallet.R.layout.qr_activity
            r11.setContentView((int) r0)
            net.one97.paytm.wallet.activity.AJRQRActivity$CReceiver r0 = new net.one97.paytm.wallet.activity.AJRQRActivity$CReceiver
            r0.<init>()
            r11.j = r0
            android.content.IntentFilter r0 = new android.content.IntentFilter
            java.lang.String r1 = "com.android.wallet.TAGLINE_REFERER"
            r0.<init>(r1)
            r11.k = r0
            net.one97.paytm.wallet.activity.AJRQRActivity$CReceiver r0 = r11.j
            android.content.IntentFilter r1 = r11.k
            r11.registerReceiver(r0, r1)
            android.content.Intent r0 = r17.getIntent()
            r12 = 0
            java.lang.String r1 = "scan_only"
            boolean r0 = r0.getBooleanExtra(r1, r12)
            r11.f69913e = r0
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r1 = "isGalleryScan"
            boolean r0 = r0.getBooleanExtra(r1, r12)
            r11.o = r0
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r1 = "read_text"
            boolean r0 = r0.getBooleanExtra(r1, r12)
            r11.f69914f = r0
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r1 = "from_universal_scanner"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L_0x005c
            android.content.Intent r0 = r17.getIntent()
            boolean r0 = r0.getBooleanExtra(r1, r12)
            r11.f69915g = r0
        L_0x005c:
            int r0 = net.one97.paytm.wallet.R.string.pay_process_title
            java.lang.String r0 = r11.getString(r0)
            r11.setTitle(r0)
            android.content.Intent r0 = r17.getIntent()
            if (r0 == 0) goto L_0x0076
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r1 = "isStaticQRWithEncryptData"
            boolean r0 = r0.getBooleanExtra(r1, r12)
            goto L_0x0077
        L_0x0076:
            r0 = 0
        L_0x0077:
            r11.l = r0
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r1 = "extra_home_data"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            r13 = r0
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r13 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r13
            if (r13 == 0) goto L_0x01e9
            java.lang.String r14 = r13.getURLType()
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x01e5
            java.lang.String r0 = "link_payment"
            boolean r1 = r14.equalsIgnoreCase(r0)
            java.lang.String r15 = "scan_pay"
            if (r1 != 0) goto L_0x00a2
            boolean r1 = r14.equalsIgnoreCase(r15)
            if (r1 == 0) goto L_0x01e5
        L_0x00a2:
            boolean r0 = r14.equalsIgnoreCase(r0)
            r10 = 0
            if (r0 == 0) goto L_0x016f
            r17.e()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "linkBasePaymentUrl"
            java.lang.String r1 = r1.getStringFromGTM(r11, r2)
            r0.append(r1)
            java.lang.String r1 = r13.getLinkId()
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            java.lang.String r1 = r13.getLinkName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = com.paytm.utility.b.e((android.content.Context) r11, (java.lang.String) r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = com.paytm.utility.a.q(r17)
            java.lang.String r2 = "ssotoken"
            r0.put(r2, r1)
            java.lang.String r1 = "osType"
            java.lang.String r2 = "Android"
            r0.put(r1, r2)
            java.lang.String r1 = r13.getReferralSource()
            java.lang.String r2 = "referer"
            r0.put(r2, r1)
            java.lang.String r1 = com.paytm.utility.b.Q((android.content.Context) r17)
            java.lang.String r2 = "appVersion"
            r0.put(r2, r1)
            java.lang.String r1 = com.paytm.utility.b.c()
            java.lang.String r2 = "phoneModel"
            r0.put(r2, r1)
            java.lang.String r1 = "channel_id"
            java.lang.String r2 = "APP"
            r0.put(r1, r2)
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r17)
            if (r1 == 0) goto L_0x0144
            net.one97.paytm.network.a r1 = new net.one97.paytm.network.a
            net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse r2 = new net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse
            r2.<init>()
            r1.<init>(r3, r2, r10, r0)
            r1.e()
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "p2mGenericAPITimeOut"
            int r0 = r0.getIntegerFromGTM((android.content.Context) r11, (java.lang.String) r2)
            int r0 = net.one97.paytm.wallet.utility.a.a((int) r0)
            r1.a(r0)
            r17.e()
            androidx.lifecycle.y r0 = r1.c()
            net.one97.paytm.wallet.activity.-$$Lambda$AJRQRActivity$2t3Qz3kbK8Ms2G66NlfI7gUUILM r1 = new net.one97.paytm.wallet.activity.-$$Lambda$AJRQRActivity$2t3Qz3kbK8Ms2G66NlfI7gUUILM
            r1.<init>()
            r0.observeForever(r1)
            goto L_0x016f
        L_0x0144:
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.String r0 = f69910b
            java.lang.String r1 = "screen_name"
            r9.put(r1, r0)
            java.lang.String r0 = "flowName"
            java.lang.String r1 = "Offline_Payments"
            r9.put(r0, r1)
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            r2 = -1
            r6 = 0
            com.paytm.network.a$b r8 = com.paytm.network.a.b.USER_FACING
            com.paytm.network.a$c r16 = com.paytm.network.a.c.PAY
            java.lang.String r4 = "NA"
            java.lang.String r5 = "Sorry,no internet connectivity detected.Please reconnect and try again"
            r1 = r17
            r12 = r10
            r10 = r16
            r0.pushHawkeyeEvent(r1, r2, r3, r4, r5, r6, r8, r9, r10)
            goto L_0x0170
        L_0x016f:
            r12 = r10
        L_0x0170:
            boolean r0 = r14.equalsIgnoreCase(r15)
            if (r0 == 0) goto L_0x01e8
            android.content.Intent r0 = r17.getIntent()
            if (r0 == 0) goto L_0x01e8
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r1 = "scan_result"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L_0x01e8
            android.content.Intent r0 = r17.getIntent()
            java.lang.String r0 = r0.getStringExtra(r1)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{  }
            r1.<init>(r0)     // Catch:{  }
            java.lang.String r0 = "mode"
            java.lang.String r2 = "DEEPLINK"
            r1.put(r0, r2)     // Catch:{  }
            java.lang.String r0 = "ORIGIN"
            java.lang.String r2 = r13.getOrigin()     // Catch:{  }
            r1.put(r0, r2)     // Catch:{  }
            net.one97.paytm.f.b r0 = net.one97.paytm.f.b.a()     // Catch:{  }
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r0 = r0.f50402a     // Catch:{  }
            java.lang.String r2 = "Deeplink"
            r0.setRequestType(r2)     // Catch:{  }
            java.lang.String r1 = r1.toString()     // Catch:{  }
            boolean r0 = r11.f69911a     // Catch:{  }
            if (r0 != 0) goto L_0x01e4
            androidx.fragment.app.j r0 = r17.getSupportFragmentManager()     // Catch:{ JSONException -> 0x01e4 }
            r0.a((java.lang.String) r12)     // Catch:{ JSONException -> 0x01e4 }
            androidx.fragment.app.j r0 = r17.getSupportFragmentManager()     // Catch:{ JSONException -> 0x01e4 }
            androidx.fragment.app.q r0 = r0.a()     // Catch:{ JSONException -> 0x01e4 }
            r2 = 0
            androidx.fragment.app.q r0 = r0.a((int) r2, (int) r2)     // Catch:{ JSONException -> 0x01e4 }
            int r7 = net.one97.paytm.wallet.R.id.qr_fragment_container     // Catch:{ JSONException -> 0x01e4 }
            boolean r3 = r11.f69913e     // Catch:{ JSONException -> 0x01e4 }
            java.lang.String r4 = r11.m     // Catch:{ JSONException -> 0x01e4 }
            boolean r5 = r11.n     // Catch:{ JSONException -> 0x01e4 }
            boolean r6 = r11.f69917i     // Catch:{ JSONException -> 0x01e4 }
            r2 = r13
            net.one97.paytm.p2mNewDesign.d.g r1 = net.one97.paytm.p2mNewDesign.d.g.a(r1, r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x01e4 }
            java.lang.String r2 = f69910b     // Catch:{ JSONException -> 0x01e4 }
            androidx.fragment.app.q r0 = r0.b(r7, r1, r2)     // Catch:{ JSONException -> 0x01e4 }
            r0.c()     // Catch:{ JSONException -> 0x01e4 }
        L_0x01e4:
            return
        L_0x01e5:
            r17.f()
        L_0x01e8:
            return
        L_0x01e9:
            r17.f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.activity.AJRQRActivity.onCreate(android.os.Bundle):void");
    }

    public void onClick(View view) {
        if (view.getId() == R.id.toolbar_btn_back) {
            finish();
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    private void b() {
        Intent intent = getIntent();
        String str = null;
        if (intent != null && "scan".equals(intent.getStringExtra("OPERATION"))) {
            net.one97.paytm.f.b.a().f50402a.setScanType("active");
            String stringExtra = intent.getStringExtra("scan_result");
            boolean booleanExtra = intent.getBooleanExtra("is_from_repeat_payment", false);
            this.f69916h = intent.getBooleanExtra("showTagline", false);
            this.f69917i = intent.getBooleanExtra("isAutoFlashTxn", false);
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    com.paytm.utility.b.j();
                    if (intent.hasExtra("orderId")) {
                        str = intent.getStringExtra("orderId");
                    }
                    if (stringExtra != null) {
                        a(stringExtra, this.f69916h, booleanExtra, str);
                    }
                } catch (Exception e2) {
                    a(getString(R.string.error), getString(R.string.not_paytm_qr_message));
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                }
            }
        } else if (intent != null && "deeplink".equals(intent.getStringExtra("OPERATION"))) {
            net.one97.paytm.f.b.a().f50402a.setScanType("active");
            String stringExtra2 = intent.getStringExtra("deeplink");
            if (!TextUtils.isEmpty(stringExtra2)) {
                try {
                    com.paytm.utility.b.j();
                    if (intent.hasExtra("orderId")) {
                        str = intent.getStringExtra("orderId");
                    }
                    if (stringExtra2 != null) {
                        a(stringExtra2, this.f69916h, false, str);
                    }
                } catch (Exception e3) {
                    a(getString(R.string.error), getString(R.string.not_paytm_qr_message));
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e3));
                    }
                }
            }
        } else if (intent != null && "contact".equals(intent.getStringExtra("OPERATION"))) {
            net.one97.paytm.f.b.a().f50402a.setScanType("active");
            if (!intent.hasExtra("paysend_result")) {
                return;
            }
            if (b.a().getBooleanFromGTM(this, "mt_revamp_enabled", true)) {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) intent.getSerializableExtra("paysend_result");
                int intExtra = intent.getIntExtra("launchFrom", e.C0905e.PAY.getType());
                String stringExtra3 = intent.getStringExtra("mobile");
                boolean booleanExtra2 = intent.getBooleanExtra("is_from_mobile_number", false);
                boolean booleanExtra3 = intent.getBooleanExtra("is_from_app_evoke", false);
                if (paymentCombinationAPIResponse != null && paymentCombinationAPIResponse != null) {
                    try {
                        Bundle extras = getIntent().getExtras();
                        if (!this.f69911a) {
                            try {
                                getSupportFragmentManager().a((String) null);
                                getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, g.a(paymentCombinationAPIResponse, stringExtra3, this.f69913e, booleanExtra2, extras, this.m, this.n, this.f69917i, booleanExtra3, intExtra), f69910b).c();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception e4) {
                        a(getString(R.string.error), getString(R.string.not_paytm_qr_message));
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e4));
                        }
                    }
                }
            } else {
                ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = (ConsolidatePaymentInstrumentationRes) intent.getSerializableExtra("paysend_result");
                String stringExtra4 = intent.getStringExtra("mobile");
                boolean booleanExtra4 = intent.getBooleanExtra("is_from_mobile_number", false);
                if (consolidatePaymentInstrumentationRes != null && consolidatePaymentInstrumentationRes != null) {
                    try {
                        Bundle extras2 = getIntent().getExtras();
                        if (!this.f69911a) {
                            try {
                                getSupportFragmentManager().a((String) null);
                                getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, g.a(consolidatePaymentInstrumentationRes, stringExtra4, this.f69913e, booleanExtra4, extras2, this.m, this.n, this.f69917i), f69910b).c();
                            } catch (Exception unused2) {
                            }
                        }
                    } catch (Exception e5) {
                        a(getString(R.string.error), getString(R.string.not_paytm_qr_message));
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e5));
                        }
                    }
                }
            }
        } else if (intent == null || !intent.hasExtra("p2mUPIDeeplink")) {
            getSupportFragmentManager().a((String) null);
            getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, j.a(), f69910b).c();
        } else {
            String w = a.w(intent.getStringExtra("p2mUPIDeeplink"));
            String stringExtra5 = intent.hasExtra("orderId") ? intent.getStringExtra("orderId") : null;
            if (!TextUtils.isEmpty(w)) {
                String stringExtra6 = intent.getStringExtra("p2mUPIDeeplink");
                boolean z = this.f69916h;
                if (!this.f69911a) {
                    try {
                        getSupportFragmentManager().a((String) null);
                        getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, g.a(stringExtra6, this.f69913e, z, this.l, this.m, this.n, stringExtra5, this.f69917i), f69910b).c();
                    } catch (Exception unused3) {
                    }
                }
            } else {
                Toast.makeText(this, "mid is null", 1).show();
                finish();
            }
        }
    }

    public void onBackPressed() {
        if (!isFinishing()) {
            super.onBackPressed();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.j);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = i2;
        int i5 = i3;
        Intent intent2 = intent;
        super.onActivityResult(i2, i3, intent);
        if (i4 == 123 && i5 == 0) {
            finish();
        }
        com.paytm.utility.b.j();
        if (i5 == SDKConstants.SHOW_ALERT) {
            g gVar = (g) getSupportFragmentManager().c(f69910b);
            PaytmSDK.getPaymentsHelper().hitCloseOrderApi();
            ChannelAPIResponse channelAPIResponse = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().I;
            if (channelAPIResponse != null) {
                gVar.a(channelAPIResponse);
            }
        }
        boolean z = true;
        if (i4 == 105) {
            if (i5 == -1) {
                String stringExtra = intent2.getStringExtra("qr_data");
                if (!TextUtils.isEmpty(stringExtra)) {
                    q.d("scanResult=".concat(String.valueOf(stringExtra)));
                    try {
                        String b2 = com.google.zxing.client.android.d.b.b(stringExtra, UpiConstants.QR_KEY);
                        com.paytm.utility.b.j();
                        a(b2, this.f69916h, false, (String) null);
                    } catch (Exception e2) {
                        Toast.makeText(this, R.string.qr_image_scan_error_message, 1).show();
                        finish();
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                }
            } else {
                finish();
            }
        } else if (i4 == 104 && i5 == -1) {
            Fragment c2 = getSupportFragmentManager().c(f69910b);
            if (c2 instanceof g) {
                g gVar2 = (g) c2;
                if (intent2 != null) {
                    String stringExtra2 = intent2.getStringExtra("intent_extra_wallet_order_id");
                    boolean booleanExtra = intent2.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false);
                    if (!gVar2.f51122b) {
                        String stringExtra3 = intent2.getStringExtra("intent_extra_wallet_email");
                        String stringExtra4 = intent2.getStringExtra("intent_extra_wallet_phone_number");
                        String stringExtra5 = intent2.getStringExtra("intent_extra_wallet_payee_sso_id");
                        String stringExtra6 = intent2.getStringExtra("intent_extra_wallet_send_money_amount");
                        String stringExtra7 = intent2.getStringExtra("intent_extra_wallet_comment");
                        String stringExtra8 = intent2.getStringExtra("intent_extra_wallet_is_to_verify");
                        String stringExtra9 = intent2.getStringExtra("intent_extra_wallet_is_limit_applicable");
                        if ((!TextUtils.isEmpty(stringExtra3) || !TextUtils.isEmpty(stringExtra4) || !TextUtils.isEmpty(stringExtra5)) && gVar2.f51123c != null) {
                            gVar2.f51123c.a(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, stringExtra8, stringExtra9, booleanExtra);
                        }
                    } else if (gVar2.f51124e != null && !booleanExtra) {
                        gVar2.f51124e.b(stringExtra2);
                    }
                }
            }
        } else if (i4 == 1802) {
            if (i5 == -1) {
                setResult(-1);
                finish();
            }
        } else if (i4 == 13) {
            Fragment c3 = getSupportFragmentManager().c(f69910b);
            if (c3 instanceof g) {
                g gVar3 = (g) c3;
                if (i5 != -1) {
                    z = false;
                }
                c cVar = gVar3.f51127h.f13378f;
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f2, "DirectPaymentBl.getInstance()");
                if (f2.n != null) {
                    for (net.one97.paytm.p2mNewDesign.e.a aVar : cVar.f51255b) {
                        String a2 = aVar.a();
                        StringBuilder sb = new StringBuilder("UPI");
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                        k.a((Object) f3, "DirectPaymentBl.getInstance()");
                        InstrumentInfo instrumentInfo = f3.n;
                        k.a((Object) instrumentInfo, "DirectPaymentBl.getInsta…().selectedInstrumentInfo");
                        sb.append(instrumentInfo.getAccountNumber());
                        if (p.a(a2, sb.toString(), false)) {
                            if (aVar != null) {
                                net.one97.paytm.p2mNewDesign.e.a.g gVar4 = (net.one97.paytm.p2mNewDesign.e.a.g) aVar;
                                gVar4.d(false);
                                if (z) {
                                    gVar4.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m(gVar4.f13335b.getAccountNumber()));
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.instruments.controllers.UPIInstrumentController");
                            }
                        }
                    }
                }
            }
        } else if (i5 == -1 && i4 == 2001) {
            setResult(-1);
            finish();
        } else if (i5 == 0 && i4 == 2001) {
            setResult(0);
            finish();
        } else if (i5 == -1 && i4 == 2002) {
            setResult(-1, intent2);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 51) {
            return;
        }
        if (s.a(iArr)) {
            b();
            return;
        }
        int a2 = s.a(strArr, iArr, "android.permission.CAMERA", this);
        if (a2 == 1) {
            finish();
        } else if (a2 == 0) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.camera_permission_title)).setMessage(getResources().getString(R.string.camera_permission)).setCancelable(false);
                builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AJRQRActivity.this.b(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AJRQRActivity.this.a(dialogInterface, i2);
                    }
                });
                builder.show();
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.f69911a = true;
    }

    public void onResume() {
        super.onResume();
        this.f69911a = false;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            net.one97.paytm.p2mNewDesign.models.b.c().g();
            net.one97.paytm.p2mNewDesign.models.b.c().b("Scan");
        }
        super.onWindowFocusChanged(z);
    }

    private void c() {
        Intent intent = getIntent();
        this.n = intent.getBooleanExtra("is_from_recent", false);
        if (intent.hasExtra("qrScanTime")) {
            this.m = intent.getStringExtra("qrScanTime");
        }
        b();
    }

    private void b(String str, String str2) {
        h hVar = new h(this);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.a(-3, getResources().getString(R.string.p2p_ok), new View.OnClickListener(hVar, true) {
            private final /* synthetic */ h f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                AJRQRActivity.this.a(this.f$1, this.f$2, view);
            }
        });
        hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AJRQRActivity.this.a(dialogInterface);
            }
        });
        if (!isFinishing()) {
            hVar.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, boolean z, View view) {
        hVar.cancel();
        if (z) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        setResult(-1);
        finish();
    }

    private void d() {
        try {
            if (this.f69912c != null && this.f69912c.isShowing()) {
                this.f69912c.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private void e() {
        try {
            if (this.f69912c == null) {
                this.f69912c = a.b((Activity) this);
            }
            if (this.f69912c != null && !this.f69912c.isShowing()) {
                this.f69912c.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        finish();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        String B = com.paytm.utility.b.B((Context) this);
        if (!TextUtils.isEmpty(B)) {
            intent.setData(Uri.parse("package:".concat(String.valueOf(B))));
        }
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        finish();
    }

    private void a(String str, boolean z, boolean z2, String str2) {
        if (!this.f69911a) {
            try {
                getSupportFragmentManager().a((String) null);
                getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, g.a(str, getIntent().getStringExtra("QR_CODE_ID"), this.f69913e, z, this.l, z2, this.m, this.n, str2, this.f69917i, this.o), f69910b).c();
            } catch (Exception unused) {
            }
        }
    }

    private void f() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        c();
    }

    public class CReceiver extends BroadcastReceiver {
        public CReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            g gVar;
            if (intent.getAction().equals("com.android.wallet.TAGLINE_REFERER")) {
                StringBuilder sb = new StringBuilder("CReceiver: ");
                sb.append(intent.getStringExtra("merchant_tagline"));
                sb.append(System.currentTimeMillis());
                String stringExtra = intent.getStringExtra("merchant_tagline");
                if (!TextUtils.isEmpty(stringExtra) && (gVar = (g) AJRQRActivity.this.getSupportFragmentManager().c(AJRQRActivity.f69910b)) != null) {
                    gVar.c(stringExtra);
                }
            }
        }
    }

    public void onNewIntent(Intent intent) {
        String str;
        super.onNewIntent(intent);
        if (intent != null) {
            Fragment c2 = getSupportFragmentManager().c(f69910b);
            if ((c2 instanceof g) && intent.getExtras() != null) {
                g gVar = (g) c2;
                try {
                    CJROrderSummary cJROrderSummary = (CJROrderSummary) new f().a(intent.getExtras().getString("orderResponse", "no result"), CJROrderSummary.class);
                    String str2 = null;
                    if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || cJROrderSummary.getOrderedCartList().get(0) == null || cJROrderSummary.getOrderedCartList().get(0).getItemStatus() == null) {
                        str = null;
                    } else {
                        str2 = String.valueOf(cJROrderSummary.getOrderStatus());
                        str = cJROrderSummary.getOrderedCartList().get(0).getItemStatus();
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        if ("2".equalsIgnoreCase(str2)) {
                            if ("7".equalsIgnoreCase(str)) {
                                if (gVar.f51127h != null) {
                                    gVar.f51127h.e("SUCCESS");
                                }
                            } else if ("6".equalsIgnoreCase(str)) {
                                Toast.makeText(gVar.f51125f, gVar.f51126g.getString(R.string.unable_to_add_balance_in_gv), 0).show();
                            } else if (gVar.f51127h != null) {
                                gVar.f51127h.e("in process");
                            }
                        } else if (!"4".equalsIgnoreCase(str2)) {
                            gVar.a(gVar.f51126g.getString(R.string.unable_to_add_balance_in_gv), false, false);
                        } else if (gVar.f51127h != null) {
                            gVar.f51127h.e("in process");
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            d();
            if (fVar.f55797b instanceof CJRLinkBasePaymentResponse) {
                CJRLinkBasePaymentResponse cJRLinkBasePaymentResponse = (CJRLinkBasePaymentResponse) fVar.f55797b;
                if (cJRLinkBasePaymentResponse.errorMessage == null) {
                    try {
                        getSupportFragmentManager().a((String) null);
                        getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, g.a(cJRLinkBasePaymentResponse, this.m, this.n, this.f69917i), f69910b).c();
                        getSupportFragmentManager().b();
                    } catch (Exception unused) {
                    }
                } else {
                    String string = getString(R.string.oops_something_went_wrong);
                    if (!v.a(cJRLinkBasePaymentResponse.errorMessage)) {
                        string = cJRLinkBasePaymentResponse.errorMessage;
                    }
                    b(getString(R.string.error), string);
                }
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            d();
            net.one97.paytm.network.g gVar = fVar.f55798c;
            if (gVar == null || !(gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                b(getString(R.string.error), getString(R.string.some_went_wrong));
                return;
            }
            b.a().handleError(this, gVar.f55801c, "ScanNowFragment", (Bundle) null, false);
        }
    }
}
