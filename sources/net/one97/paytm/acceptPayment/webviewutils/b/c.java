package net.one97.paytm.acceptPayment.webviewutils.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.business.merchant_payments.event.AcceptPaymentSettingsChangedEvent;
import com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetwork;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity;
import net.one97.paytm.acceptPayment.configs.a;
import net.one97.paytm.acceptPayment.model.onBoarding.DownloadQRModel;
import net.one97.paytm.acceptPayment.webview.AcceptPaymentWebViewActivity;
import net.one97.paytm.acceptPayment.webview.VideoEnabledWebView;
import net.one97.paytm.acceptPayment.webviewutils.a.b;
import net.one97.paytm.acceptPayment.webviewutils.a.d;
import net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends Handler {
    protected final WeakReference<BaseWebViewActivity> mActivity;
    protected final WeakReference<Object> mFragment = null;

    public c(BaseWebViewActivity baseWebViewActivity) {
        super(Looper.getMainLooper());
        this.mActivity = new WeakReference<>(baseWebViewActivity);
    }

    /* access modifiers changed from: protected */
    public Intent getShareIntent(Message message) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "Check out my new Offer");
        intent.putExtra("android.intent.extra.TEXT", (String) message.obj);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void openWebView(Message message) {
        WeakReference<BaseWebViewActivity> weakReference;
        if ((message.obj instanceof b) && (weakReference = this.mActivity) != null && weakReference.get() != null) {
            b bVar = (b) message.obj;
            Intent intent = new Intent((Context) this.mActivity.get(), a.f52046a.f52049d.b());
            intent.putExtra("url", bVar.f52238a);
            intent.putExtra("title", bVar.f52239b);
            ((BaseWebViewActivity) this.mActivity.get()).startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void processLink(Message message) {
        WeakReference<BaseWebViewActivity> weakReference;
        if ((message.obj instanceof String) && (weakReference = this.mActivity) != null && weakReference.get() != null) {
            a.f52046a.f52049d.a((Context) this.mActivity.get(), (String) message.obj);
        }
    }

    private void downloadQR(DownloadQRModel downloadQRModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("qr_id", downloadQRModel.getQrCodeId());
        hashMap.put("qr_name", downloadQRModel.getDisplayName());
        String a2 = net.one97.paytm.acceptPayment.utils.b.a("paytmmp://accept_money?featuretype=download_qr", (Map<String, String>) hashMap);
        Intent intent = new Intent((Context) this.mActivity.get(), AcceptPaymentInitActivity.class);
        intent.putExtra("deeplinkdata", net.one97.paytm.acceptPayment.utils.b.a(a2));
        ((BaseWebViewActivity) this.mActivity.get()).startActivity(intent);
    }

    private void getSettlementAmount() {
        f e2;
        Object b2 = ((BaseWebViewActivity) this.mActivity.get()).b("settlementValue");
        if ((b2 instanceof String) && (e2 = ((BaseWebViewActivity) this.mActivity.get()).e()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("settlementValue", (String) b2);
                ((BaseWebViewActivity) this.mActivity.get()).a(net.one97.paytm.acceptPayment.utils.b.a(e2.a(), "settlementAmountCallback", f.a(jSONObject)));
            } catch (JSONException e3) {
                e3.getMessage();
            }
        }
    }

    public void handleMessage(Message message) {
        WeakReference<BaseWebViewActivity> weakReference;
        WeakReference<Object> weakReference2;
        WeakReference<BaseWebViewActivity> weakReference3 = this.mActivity;
        if (((weakReference3 != null && weakReference3.get() != null) || ((weakReference2 = this.mFragment) != null && weakReference2.get() != null)) && (weakReference = this.mActivity) != null && weakReference.get() != null) {
            Activity activity = (Activity) this.mActivity.get();
            int i2 = message.what;
            if (i2 != 224) {
                if (i2 == 225) {
                    Object obj = message.obj;
                    if (obj != null && ((JSONObject) obj).optString("status").equals("SUCCESS")) {
                        org.greenrobot.eventbus.c.a().c(new AcceptPaymentSettingsChangedEvent(false));
                    }
                } else if (i2 == 267) {
                    getAadharFlag(message);
                } else if (i2 == 288) {
                    org.greenrobot.eventbus.c.a().c(new AcceptPaymentSettingsChangedEvent(true));
                } else if (i2 == 367) {
                    getRedeem(message);
                } else if (i2 != 879) {
                    switch (i2) {
                        case H5ErrorCode.ERROR_TIMEOUT:
                            Context context = (Context) this.mActivity.get();
                            String str = (String) message.obj;
                            if (context != null && !TextUtils.isEmpty(str)) {
                                Intent intent = new Intent("android.intent.action.DIAL");
                                if (str.toLowerCase().startsWith("tel:")) {
                                    intent.setData(Uri.parse(str));
                                } else {
                                    intent.setData(Uri.parse("tel:".concat(String.valueOf(str))));
                                }
                                context.startActivity(intent);
                                return;
                            }
                            return;
                        case H5ErrorCode.ERROR_IO:
                            processLink(message);
                            return;
                        case H5ErrorCode.ERROR_CONNECT:
                            return;
                        case H5ErrorCode.ERROR_PROXY_AUTHENTICATION:
                            openWebView(message);
                            return;
                        case H5ErrorCode.ERROR_AUTHENTICATION:
                            net.one97.paytm.acceptPayment.webviewutils.a.a aVar = (net.one97.paytm.acceptPayment.webviewutils.a.a) message.obj;
                            ((BaseWebViewActivity) this.mActivity.get()).a(aVar.f52235a, aVar.f52236b);
                            return;
                        case -3:
                            ((BaseWebViewActivity) this.mActivity.get()).d();
                            return;
                        case -2:
                            getClass().getSimpleName();
                            return;
                        case -1:
                            Object obj2 = message.obj;
                            getClass().getSimpleName();
                            return;
                        case 0:
                            WeakReference<BaseWebViewActivity> weakReference4 = this.mActivity;
                            if (weakReference4 != null && weakReference4.get() != null) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("deeplinkdata", net.one97.paytm.acceptPayment.utils.b.a(((BaseWebViewActivity) this.mActivity.get()).c()));
                                String name = AcceptPaymentInitActivity.class.getName();
                                new NetworkCustomError();
                                a.f52046a.f52049d.a((Activity) this.mActivity.get(), name, bundle);
                                return;
                            }
                            return;
                        case 1:
                            activity.finish();
                            return;
                        default:
                            switch (i2) {
                                case 3:
                                    ((BaseWebViewActivity) this.mActivity.get()).a((String) message.obj);
                                    return;
                                case 4:
                                    d dVar = (d) message.obj;
                                    Context context2 = (Context) this.mActivity.get();
                                    String str2 = dVar.f52243b;
                                    String str3 = dVar.f52242a;
                                    String str4 = dVar.f52244c;
                                    HashMap hashMap = new HashMap();
                                    if (!TextUtils.isEmpty(net.one97.paytm.acceptPayment.d.a.f52050a.D())) {
                                        hashMap.put("merchant_id", net.one97.paytm.acceptPayment.d.a.f52050a.D());
                                    }
                                    if (!TextUtils.isEmpty(net.one97.paytm.acceptPayment.d.a.f52050a.t())) {
                                        hashMap.put("merchant_type", net.one97.paytm.acceptPayment.d.a.f52050a.t());
                                    }
                                    net.one97.paytm.acceptPayment.d.a aVar2 = net.one97.paytm.acceptPayment.d.a.f52050a;
                                    if (!TextUtils.isEmpty(net.one97.paytm.acceptPayment.d.a.N())) {
                                        net.one97.paytm.acceptPayment.d.a aVar3 = net.one97.paytm.acceptPayment.d.a.f52050a;
                                        hashMap.put("user_id", net.one97.paytm.acceptPayment.d.a.N());
                                    }
                                    hashMap.put("event_category", str2);
                                    hashMap.put("event_action", str3);
                                    if (!TextUtils.isEmpty("Channels")) {
                                        hashMap.put("event_label", "Channels");
                                    }
                                    if (!TextUtils.isEmpty(str4)) {
                                        hashMap.put("event_label2", str4);
                                    }
                                    if (!TextUtils.isEmpty("")) {
                                        hashMap.put("event_label3", "");
                                    }
                                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "");
                                    hashMap.put("vertical_name", "business_accept_payment");
                                    net.one97.paytm.acceptPayment.utils.b.a(GAUtil.CUSTOM_EVENT, (HashMap<String, Object>) hashMap, context2);
                                    return;
                                case 5:
                                    Toast.makeText((Context) this.mActivity.get(), (String) message.obj, 0).show();
                                    return;
                                case 6:
                                    ((BaseWebViewActivity) this.mActivity.get()).startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.paytm.business")));
                                    return;
                                case 7:
                                    Intent shareIntent = getShareIntent(message);
                                    if (shareIntent.resolveActivity(((BaseWebViewActivity) this.mActivity.get()).getPackageManager()) != null) {
                                        ((BaseWebViewActivity) this.mActivity.get()).startActivity(Intent.createChooser(shareIntent, "Share URL"));
                                        return;
                                    }
                                    return;
                                case 8:
                                    net.one97.paytm.acceptPayment.webviewutils.a.c cVar = (net.one97.paytm.acceptPayment.webviewutils.a.c) message.obj;
                                    ((BaseWebViewActivity) this.mActivity.get()).a(cVar.f52240a, cVar.f52241b);
                                    return;
                                case 9:
                                    ((BaseWebViewActivity) this.mActivity.get()).a("", ((Integer) message.obj).intValue());
                                    return;
                                case 10:
                                    ((BaseWebViewActivity) this.mActivity.get()).a("image/*", ((Integer) message.obj).intValue());
                                    return;
                                case 11:
                                    net.one97.paytm.acceptPayment.utils.b.a(activity);
                                    activity.finish();
                                    return;
                                case 12:
                                    ((BaseWebViewActivity) this.mActivity.get()).a(12);
                                    return;
                                case 13:
                                    downloadQR((DownloadQRModel) message.obj);
                                    break;
                                case 14:
                                    a.f52046a.f52049d.a((Context) this.mActivity.get(), "paytmmp://grid?url=https://catalog.paytm.com/merchandising-store-llpid-160663?channel=web&site_id=1&version=2");
                                    return;
                                case 15:
                                    message.obj = "paytmmp://accept_money";
                                    processLink(message);
                                    return;
                                default:
                                    switch (i2) {
                                        case 17:
                                            break;
                                        case 18:
                                            message.obj = "paytmmp://payment_bank?featuretype=open_acc_base";
                                            if (com.business.common_module.utilities.a.a(((Context) this.mActivity.get()).getApplicationContext()).b("isPrime", false, true)) {
                                                message.obj = "paytmmp://upgrade_wallet";
                                            }
                                            processLink(message);
                                            return;
                                        case 19:
                                            getSettlementAmount();
                                            return;
                                        case 20:
                                            message.obj = "paytmmp://upgrade_wallet";
                                            processLink(message);
                                            return;
                                        case 21:
                                            ((BaseWebViewActivity) this.mActivity.get()).f();
                                            return;
                                        default:
                                            getClass().getSimpleName();
                                            return;
                                    }
                            }
                            ((BaseWebViewActivity) this.mActivity.get()).a(17);
                            return;
                    }
                } else {
                    onWindowClose(message);
                }
            } else if (((JSONObject) message.obj).optString("leadStatus").equals(ReactivationStatusNetwork.LEAD_CLOSED)) {
                org.greenrobot.eventbus.c.a().c(new AcceptPaymentSettingsChangedEvent(false));
            }
        }
    }

    private void onWindowClose(Message message) {
        if (this.mActivity.get() instanceof AcceptPaymentWebViewActivity) {
            AcceptPaymentWebViewActivity acceptPaymentWebViewActivity = (AcceptPaymentWebViewActivity) this.mActivity.get();
            Object obj = message.obj;
            if (obj != null) {
                String obj2 = obj.toString();
                try {
                    VideoEnabledWebView videoEnabledWebView = acceptPaymentWebViewActivity.f52208d;
                    if (videoEnabledWebView == null) {
                        k.a("videoEnabledWebView");
                    }
                    String str = null;
                    if ((videoEnabledWebView != null ? Integer.valueOf(videoEnabledWebView.getChildCount()) : null).intValue() != 0) {
                        VideoEnabledWebView videoEnabledWebView2 = acceptPaymentWebViewActivity.f52208d;
                        if (videoEnabledWebView2 == null) {
                            k.a("videoEnabledWebView");
                        }
                        if (videoEnabledWebView2 != null) {
                            videoEnabledWebView2.removeAllViews();
                        }
                    }
                    String a2 = f.a(new JSONObject(obj2));
                    f fVar = acceptPaymentWebViewActivity.f52207c;
                    if (fVar != null) {
                        str = fVar.a();
                    }
                    String a3 = net.one97.paytm.acceptPayment.utils.b.a(str, "aadharCallback", a2);
                    k.b(a3, "loadUrlScriptString(mWeb…ALLBACK, stringifiedJSON)");
                    acceptPaymentWebViewActivity.a(a3);
                } catch (Exception e2) {
                    new StringBuilder("======>").append(e2.toString());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f A[Catch:{ JSONException -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[Catch:{ JSONException -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getAadharFlag(android.os.Message r8) {
        /*
            r7 = this;
            java.lang.ref.WeakReference<net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity> r0 = r7.mActivity
            java.lang.Object r0 = r0.get()
            boolean r0 = r0 instanceof net.one97.paytm.acceptPayment.webview.AcceptPaymentWebViewActivity
            if (r0 == 0) goto L_0x00a8
            java.lang.ref.WeakReference<net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity> r0 = r7.mActivity
            java.lang.Object r0 = r0.get()
            net.one97.paytm.acceptPayment.webview.AcceptPaymentWebViewActivity r0 = (net.one97.paytm.acceptPayment.webview.AcceptPaymentWebViewActivity) r0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a4 }
            java.lang.Object r8 = r8.obj     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ JSONException -> 0x00a4 }
            r1.<init>(r8)     // Catch:{ JSONException -> 0x00a4 }
            net.one97.paytm.acceptPayment.b.b.a()     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r8 = "onboarding_react_aadhar_flag"
            boolean r8 = net.one97.paytm.acceptPayment.b.b.b(r8)     // Catch:{ JSONException -> 0x00a4 }
            net.one97.paytm.acceptPayment.b.b.a()     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r2 = "onboarding_react_upi_flag"
            boolean r2 = net.one97.paytm.acceptPayment.b.b.b(r2)     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r3 = "jsonObj"
            kotlin.g.b.k.d(r1, r3)     // Catch:{ JSONException -> 0x00a4 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a4 }
            r3.<init>()     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r4 = "show"
            java.lang.String r5 = "argument1"
            if (r8 == 0) goto L_0x005b
            boolean r8 = r1.has(r5)     // Catch:{ JSONException -> 0x00a4 }
            if (r8 == 0) goto L_0x005b
            java.lang.String r8 = r1.getString(r5)     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r6 = "upm_aadhar"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x00a4 }
            if (r8 == 0) goto L_0x005b
            java.lang.String r8 = r1.getString(r5)     // Catch:{ JSONException -> 0x00a4 }
            r3.put(r8, r4)     // Catch:{ JSONException -> 0x00a4 }
            goto L_0x0087
        L_0x005b:
            if (r2 == 0) goto L_0x0078
            boolean r8 = r1.has(r5)     // Catch:{ JSONException -> 0x00a4 }
            if (r8 == 0) goto L_0x0078
            java.lang.String r8 = r1.getString(r5)     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r2 = "upm_upi"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00a4 }
            if (r8 == 0) goto L_0x0078
            java.lang.String r8 = r1.getString(r5)     // Catch:{ JSONException -> 0x00a4 }
            r3.put(r8, r4)     // Catch:{ JSONException -> 0x00a4 }
            goto L_0x0087
        L_0x0078:
            boolean r8 = r1.has(r5)     // Catch:{ JSONException -> 0x00a4 }
            if (r8 == 0) goto L_0x0087
            java.lang.String r8 = r1.getString(r5)     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r1 = "hide"
            r3.put(r8, r1)     // Catch:{ JSONException -> 0x00a4 }
        L_0x0087:
            java.lang.String r8 = net.one97.paytm.acceptPayment.webviewutils.b.f.a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x00a4 }
            net.one97.paytm.acceptPayment.webviewutils.b.f r1 = r0.f52207c     // Catch:{ JSONException -> 0x00a4 }
            if (r1 == 0) goto L_0x0094
            java.lang.String r1 = r1.a()     // Catch:{ JSONException -> 0x00a4 }
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            java.lang.String r2 = "appManagerCallback"
            java.lang.String r8 = net.one97.paytm.acceptPayment.utils.b.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r8)     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r1 = "loadUrlScriptString(mWeb…ALLBACK, stringifiedJson)"
            kotlin.g.b.k.b(r8, r1)     // Catch:{ JSONException -> 0x00a4 }
            r0.a((java.lang.String) r8)     // Catch:{ JSONException -> 0x00a4 }
            return
        L_0x00a4:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.webviewutils.b.c.getAadharFlag(android.os.Message):void");
    }

    private void getRedeem(Message message) {
        if (message.obj != null) {
            try {
                a.f52046a.f52049d.a((Activity) this.mActivity.get(), new JSONObject(String.valueOf(message.obj)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
