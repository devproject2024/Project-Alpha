package net.one97.paytm.chat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.activity.PaytmChatMainActivity;
import com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean;
import com.paytm.android.chat.c;
import com.paytm.android.chat.d;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.b.e;
import net.one97.paytm.deeplink.f;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationListener;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel;

public final class ChatImplProvider implements d, f.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49553a = new a((byte) 0);
    private static final String k = k;
    /* access modifiers changed from: private */
    public static ChatImplProvider l;
    /* access modifiers changed from: private */
    public static boolean m;

    /* renamed from: b  reason: collision with root package name */
    private String f49554b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f49555c = "";

    /* renamed from: d  reason: collision with root package name */
    private final String f49556d = "CHAT";

    /* renamed from: e  reason: collision with root package name */
    private final String f49557e = "SUCCESS";

    /* renamed from: f  reason: collision with root package name */
    private final String f49558f = "FAILURE";

    /* renamed from: g  reason: collision with root package name */
    private final String f49559g = "PENDING";

    /* renamed from: h  reason: collision with root package name */
    private final String f49560h = "TXN_SUCCESS";

    /* renamed from: i  reason: collision with root package name */
    private final String f49561i = "TXN_FAILURE";
    private final String j = "TXN_PENDING";

    public static final void init(Application application) {
        a.a(application);
    }

    public final String a() {
        return "9.1.3";
    }

    public final String b() {
        return "";
    }

    public final String c() {
        return "";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Application application) {
            k.c(application, "application");
            if (!ChatImplProvider.m) {
                a.d();
                if (ChatImplProvider.l == null) {
                    ChatImplProvider chatImplProvider = new ChatImplProvider();
                    f fVar = f.f50341a;
                    f.a((f.b) chatImplProvider);
                    ChatImplProvider.l = chatImplProvider;
                }
                c.a(application, "7CC3E8D0-D35B-4685-B603-135DF578E7DE", UrlProfileList.BASE_URL);
                ChatManager.b().f40989a = ChatImplProvider.l;
                ChatImplProvider.m = true;
            }
        }
    }

    public final void a(HashMap<String, Object> hashMap) {
        net.one97.paytm.j.a.b(hashMap, GAUtil.CUSTOM_EVENT);
    }

    public final void a(Context context, String str) {
        h.a aVar = h.f50349a;
        h.a.a(context, str, (Bundle) null);
    }

    public final void a(Context context) {
        e a2;
        if (context != null && (a2 = net.one97.paytm.common.b.d.a()) != null) {
            context.startActivity(a2.l(context));
        }
    }

    public final void a(Context context, String str, String str2, d.a aVar) {
        k.c(context, "context");
        k.c(str, "channelUrl");
        k.c(aVar, "listener");
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
            net.one97.paytm.wallet.utility.d.a(context, str2, this.f49556d, (ChatPaymentIntegrationListener) new ChatImplProvider$onPayButtonClick$1(this, str, aVar));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        if (r6.equals("NEFT") != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        if (r6.equals("IMPS") != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008a, code lost:
        if (r6.equals(net.one97.paytm.nativesdk.Constants.SDKConstants.TYPE_BANK) != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        r5 = "paytmmp://payment_bank?featuretype=savings_account_passbook_tab";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            if (r5 == 0) goto L_0x005d
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x005d
            net.one97.paytm.chat.b$a r6 = net.one97.paytm.chat.b.f49578a
            java.lang.String r6 = net.one97.paytm.chat.b.f49580c
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r6, (boolean) r7)
            if (r6 == 0) goto L_0x0057
            net.one97.paytm.j.c.a()
            net.one97.paytm.chat.b$a r6 = net.one97.paytm.chat.b.f49578a
            java.lang.String r6 = net.one97.paytm.chat.b.f49581d
            r7 = 1
            boolean r6 = net.one97.paytm.j.c.a((java.lang.String) r6, (boolean) r7)
            if (r6 == 0) goto L_0x0057
            android.content.Context r6 = net.one97.paytm.upi.g.d()
            net.one97.paytm.upi.h.a r6 = net.one97.paytm.upi.h.a.a(r6, r0)
            net.one97.paytm.upi.registration.b.a.b r6 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) r6)
            java.lang.String r7 = "net.one97.paytm.upi.Inje…iServices(context, null))"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            boolean r6 = r6.f()
            if (r6 == 0) goto L_0x0051
            net.one97.paytm.deeplink.h$a r5 = net.one97.paytm.deeplink.h.f50349a
            net.one97.paytm.chat.b$a r5 = net.one97.paytm.chat.b.f49578a
            java.lang.String r5 = net.one97.paytm.chat.b.f49579b
            net.one97.paytm.deeplink.h.a.a(r4, r5, r0)
            return
        L_0x0051:
            net.one97.paytm.deeplink.h$a r6 = net.one97.paytm.deeplink.h.f50349a
            net.one97.paytm.deeplink.h.a.a(r4, r5, r0)
            return
        L_0x0057:
            net.one97.paytm.deeplink.h$a r6 = net.one97.paytm.deeplink.h.f50349a
            net.one97.paytm.deeplink.h.a.a(r4, r5, r0)
            return
        L_0x005d:
            java.lang.String r5 = "paytmmp://cash_wallet?featuretype=cash_ledger"
            if (r6 == 0) goto L_0x00c3
            java.lang.String r6 = r6.toUpperCase()
            java.lang.String r1 = "(this as java.lang.String).toUpperCase()"
            kotlin.g.b.k.b(r6, r1)
            int r1 = r6.hashCode()
            switch(r1) {
                case -1741862919: goto L_0x00a2;
                case 84238: goto L_0x008f;
                case 2031164: goto L_0x0084;
                case 2251303: goto L_0x007b;
                case 2392261: goto L_0x0072;
                default: goto L_0x0071;
            }
        L_0x0071:
            goto L_0x00bd
        L_0x0072:
            java.lang.String r7 = "NEFT"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00bd
            goto L_0x008c
        L_0x007b:
            java.lang.String r7 = "IMPS"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00bd
            goto L_0x008c
        L_0x0084:
            java.lang.String r7 = "BANK"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00bd
        L_0x008c:
            java.lang.String r5 = "paytmmp://payment_bank?featuretype=savings_account_passbook_tab"
            goto L_0x00bd
        L_0x008f:
            java.lang.String r1 = "UPI"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00bd
            java.lang.String r5 = java.lang.String.valueOf(r7)
            java.lang.String r6 = "paytmmp://upi_passbook?featuretype=transactiondetail&txnId="
            java.lang.String r5 = r6.concat(r5)
            goto L_0x00bd
        L_0x00a2:
            java.lang.String r1 = "WALLET"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00bd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "paytmmp://transaction_detail?id="
            r5.<init>(r6)
            r5.append(r7)
            java.lang.String r6 = "&system=wallet"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
        L_0x00bd:
            net.one97.paytm.deeplink.h$a r6 = net.one97.paytm.deeplink.h.f50349a
            net.one97.paytm.deeplink.h.a.a(r4, r5, r0)
            return
        L_0x00c3:
            net.one97.paytm.deeplink.h$a r6 = net.one97.paytm.deeplink.h.f50349a
            net.one97.paytm.deeplink.h.a.a(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.chat.ChatImplProvider.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void c(Context context) {
        k.c(context, "context");
        ChatManager.b();
        ChatManager.f();
        String j2 = b.j(context);
        CharSequence charSequence = j2;
        if (charSequence == null || charSequence.length() == 0) {
            j2 = com.paytm.utility.a.b(context);
        }
        String a2 = com.paytm.utility.a.a(context);
        try {
            k.a((Object) a2, "id");
            SharedPreferencesUtil.saveLong(SharedPreferencesUtil.Key.PF_ID, Long.parseLong(a2));
        } catch (Exception | NumberFormatException unused) {
        }
        SharedPreferencesUtil.saveNickname(j2);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_MOBILE_NUMBER, com.paytm.utility.a.b(context));
        SharedPreferencesUtil.saveProfileImg(b.D(context));
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_TOKEN, t.b(context));
    }

    public final boolean d() {
        return m;
    }

    public final void e() {
        ChatManager.b().c();
        ChatManager.b();
        ChatManager.e();
        ChatManager.b();
        ChatManager.f();
    }

    public final void f() {
        c.d();
    }

    public final y<Integer> g() {
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.b();
        com.paytm.a.a();
        return com.paytm.a.f40822b;
    }

    public final void b(Context context) {
        k.c(context, "context");
        k.a((Object) ChatManager.b(), "ChatManager.getInstance()");
        if (!ChatManager.h()) {
            c(context);
        }
        k.c(context, "context");
        context.startActivity(new Intent(context, PaytmChatMainActivity.class));
        ((Activity) context).overridePendingTransition(R.anim.flyout_slide_in_right, R.anim.slide_out_left);
    }

    public static final /* synthetic */ void a(ChatImplProvider chatImplProvider, String str, ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel, d.a aVar) {
        PFPaymentStatusBean pFPaymentStatusBean = new PFPaymentStatusBean();
        pFPaymentStatusBean.setChannel(str);
        String status = chatPaymentIntegrationResponseModel.getStatus();
        int i2 = 0;
        pFPaymentStatusBean.setStatus((k.a((Object) status, (Object) chatImplProvider.f49557e) || k.a((Object) status, (Object) chatImplProvider.f49560h)) ? 0 : (k.a((Object) status, (Object) chatImplProvider.f49559g) || k.a((Object) status, (Object) chatImplProvider.j)) ? 2 : (k.a((Object) status, (Object) chatImplProvider.f49558f) || k.a((Object) status, (Object) chatImplProvider.f49561i)) ? 1 : -1);
        pFPaymentStatusBean.setDate(chatPaymentIntegrationResponseModel.getDate());
        pFPaymentStatusBean.setThemeId(chatPaymentIntegrationResponseModel.getThemeId());
        pFPaymentStatusBean.setOrderId(chatPaymentIntegrationResponseModel.getOrderId());
        pFPaymentStatusBean.setTxnId(chatPaymentIntegrationResponseModel.getTranscationid());
        pFPaymentStatusBean.setPaymentMode(chatPaymentIntegrationResponseModel.getMode());
        pFPaymentStatusBean.setPayerVpa(chatPaymentIntegrationResponseModel.getPayerVpa());
        pFPaymentStatusBean.setPayeeVpa(chatPaymentIntegrationResponseModel.getPayeeVpa());
        pFPaymentStatusBean.setPayerBankAccountNo(chatPaymentIntegrationResponseModel.getPayerBankAccountNo());
        pFPaymentStatusBean.setPayeeBankAccountNo(chatPaymentIntegrationResponseModel.getPayeeBankAccountNo());
        String str2 = "";
        pFPaymentStatusBean.setMessage(str2);
        pFPaymentStatusBean.setImportantNote(str2);
        String errMsg = chatPaymentIntegrationResponseModel.getErrMsg();
        if (errMsg != null) {
            if (errMsg != null) {
                String obj = p.b(errMsg).toString();
                if (obj != null) {
                    i2 = obj.length();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        if (i2 > 0) {
            str2 = chatPaymentIntegrationResponseModel.getErrMsg();
        }
        pFPaymentStatusBean.setErrorMsg(str2);
        pFPaymentStatusBean.setAmount(chatPaymentIntegrationResponseModel.getAmount());
        aVar.a(pFPaymentStatusBean);
    }
}
