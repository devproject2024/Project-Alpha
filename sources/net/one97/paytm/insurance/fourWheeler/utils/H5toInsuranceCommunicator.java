package net.one97.paytm.insurance.fourWheeler.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.l;
import com.google.gsonhtcfix.q;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.insurance.Configuration;
import net.one97.paytm.common.entity.insurance.SelectQuoteResponse;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.b.c;
import net.one97.paytm.insurance.b.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class H5toInsuranceCommunicator extends AppCompatActivity {
    public final void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        setContentView(R.layout.activity_insurance_h5);
        Activity activity = this;
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        k.a((Object) bundleExtra, "intent.getBundleExtra(\"data\")");
        k.c(activity, "activity");
        k.c(bundleExtra, "bundle");
        String string = bundleExtra.getString("target", "");
        if (string != null) {
            switch (string.hashCode()) {
                case -1449401609:
                    if (string.equals("insOpenUrl")) {
                        new q();
                        l a2 = q.a(a(bundleExtra));
                        k.a((Object) a2, "JsonParser().parse(getJson(bundle))");
                        l b2 = a2.g().b("url");
                        k.a((Object) b2, "JsonParser().parse(getJs…t\n                (\"url\")");
                        String b3 = b2.b();
                        k.a((Object) b3, "JsonParser().parse(getJs…         (\"url\").asString");
                        new q();
                        l a3 = q.a(a(bundleExtra));
                        k.a((Object) a3, "JsonParser().parse(getJson(bundle))");
                        l b4 = a3.g().b("title");
                        k.a((Object) b4, "JsonParser().parse(getJs…                (\"title\")");
                        String b5 = b4.b();
                        k.a((Object) b5, "JsonParser().parse(getJs…       (\"title\").asString");
                        k.c(activity, "activity");
                        k.c(b3, "url");
                        k.c(b5, "title");
                        HashMap hashMap = new HashMap(2);
                        Map map = hashMap;
                        map.put("url", b3);
                        map.put("title", b5);
                        String str = (String) hashMap.get("url");
                        String str2 = (String) hashMap.get("title");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                net.one97.paytm.insurance.a.a a4 = c.a();
                                k.a((Object) a4, "InsuranceHelper.getInsuranceListener()");
                                intent = new Intent(activity, Class.forName(a4.getEmbedWebViewClassName()));
                            } catch (ClassNotFoundException e2) {
                                e2.printStackTrace();
                                intent = null;
                            }
                            if (intent != null) {
                                intent.putExtra("url", str);
                                intent.putExtra("title", str2);
                                activity.startActivity(intent);
                            }
                        }
                        finish();
                        return;
                    }
                    return;
                case -1337282948:
                    if (string.equals("insDownloadPDF")) {
                        new q();
                        l a5 = q.a(a(bundleExtra));
                        k.a((Object) a5, "JsonParser().parse(getJson(bundle))");
                        l b6 = a5.g().b("url");
                        k.a((Object) b6, "JsonParser().parse(getJs…t\n                (\"url\")");
                        String b7 = b6.b();
                        k.a((Object) b7, "JsonParser().parse(getJs…         (\"url\").asString");
                        new q();
                        l a6 = q.a(a(bundleExtra));
                        k.a((Object) a6, "JsonParser().parse(getJson(bundle))");
                        l b8 = a6.g().b("title");
                        k.a((Object) b8, "JsonParser().parse(getJs…                (\"title\")");
                        String b9 = b8.b();
                        k.a((Object) b9, "JsonParser().parse(getJs…       (\"title\").asString");
                        k.c(activity, "activity");
                        k.c(b7, "mDownloadUrl");
                        k.c(b9, "title");
                        if (!TextUtils.isEmpty(b7)) {
                            try {
                                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(b7));
                                request.allowScanningByMediaScanner();
                                request.setNotificationVisibility(1);
                                String guessFileName = URLUtil.guessFileName(b7, (String) null, MimeTypeMap.getFileExtensionFromUrl(b7));
                                request.setDestinationInExternalFilesDir(activity, Environment.DIRECTORY_DOWNLOADS, guessFileName + ".pdf");
                                DownloadManager downloadManager = (DownloadManager) activity.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                                activity.registerReceiver(new H5toInsuranceCommunicator$downloadPDF$1(activity), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                                if (downloadManager == null) {
                                    k.a();
                                }
                                downloadManager.enqueue(request);
                            } catch (Exception unused) {
                            }
                        }
                        finish();
                        return;
                    }
                    return;
                case -1334939880:
                    if (!string.equals("insOpenCSTScreen")) {
                        return;
                    }
                    return;
                case -731041269:
                    if (string.equals("insProceedToPayment")) {
                        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
                        cJRRechargePayment.parseJSONObject(new JSONObject(a(bundleExtra)).getString("checkout"));
                        new q();
                        l a7 = q.a(a(bundleExtra));
                        k.a((Object) a7, "JsonParser().parse(getJson(bundle))");
                        if (a7.g().b(CLConstants.INPUT_KEY_CONFIGURATION) != null) {
                            f.a.a aVar = f.a.a.f13515a;
                            f fVar = new f();
                            new q();
                            l a8 = q.a(a(bundleExtra));
                            k.a((Object) a8, "JsonParser().parse(getJson(bundle))");
                            l b10 = a8.g().b(CLConstants.INPUT_KEY_CONFIGURATION);
                            k.a((Object) b10, "JsonParser().parse(getJs…       (\"configuration\"))");
                            f.a.a.f(((Configuration) fVar.a(b10.b(), Configuration.class)).getInsuranceProduct());
                        }
                        c.a().openPaymentPage(activity, cJRRechargePayment);
                        return;
                    }
                    return;
                case -467819670:
                    if (string.equals("insShowErrorToast")) {
                        if (bundleExtra.get("message") != null) {
                            CharSequence obj = bundleExtra.get("message").toString();
                            if (!TextUtils.isEmpty(obj)) {
                                Toast.makeText(this, obj, 0).show();
                            }
                        }
                        finish();
                        return;
                    }
                    return;
                case 1657675760:
                    if (string.equals("insOpenOrderSummary")) {
                        new q();
                        l a9 = q.a(a(bundleExtra));
                        k.a((Object) a9, "JsonParser().parse(getJson(bundle))");
                        l b11 = a9.g().b("orderId");
                        k.a((Object) b11, "JsonParser().parse(getJs…              (\"orderId\")");
                        String b12 = b11.b();
                        k.a((Object) b12, "JsonParser().parse(getJs…     (\"orderId\").asString");
                        new q();
                        l a10 = q.a(a(bundleExtra));
                        k.a((Object) a10, "JsonParser().parse(getJson(bundle))");
                        l b13 = a10.g().b("type");
                        k.a((Object) b13, "JsonParser().parse(getJs…                 (\"type\")");
                        String b14 = b13.b();
                        k.a((Object) b14, "JsonParser().parse(getJs…        (\"type\").asString");
                        k.c(activity, "activity");
                        k.c(b12, "orderId");
                        k.c(b14, "insuranceType");
                        c.a().openOrderSummary(activity, String.valueOf((long) Double.valueOf(b14).doubleValue()), b12);
                        finish();
                        return;
                    }
                    return;
                case 1847173268:
                    if (string.equals("insCheckoutCart")) {
                        String a11 = a(bundleExtra);
                        if (b.c((Context) activity)) {
                            try {
                                new common.insuranceOrderSummary.b(activity, (SelectQuoteResponse) new f().a(a11, SelectQuoteResponse.class)).a();
                                return;
                            } catch (Exception e3) {
                                if (b.v) {
                                    e3.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle(getResources().getString(R.string.ins_no_connection));
                            builder.setMessage(getResources().getString(R.string.ins_no_internet));
                            builder.setPositiveButton(getResources().getString(R.string.ins_ok), new a(this));
                            if (!isFinishing()) {
                                builder.show();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H5toInsuranceCommunicator f14029a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f14030b = false;

        a(H5toInsuranceCommunicator h5toInsuranceCommunicator) {
            this.f14029a = h5toInsuranceCommunicator;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (this.f14030b) {
                this.f14029a.finish();
            }
        }
    }

    private final String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            bundle.get(str);
            try {
                jSONObject.put(str, a(bundle.get(str)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    private Object a(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || k.a(obj, JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return b(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short)) {
                return obj;
            }
            if (obj instanceof String) {
                return obj;
            }
            Package packageR = obj.getClass().getPackage();
            k.a((Object) packageR, "o.javaClass.getPackage()");
            String name = packageR.getName();
            k.a((Object) name, "o.javaClass.getPackage().name");
            if (p.b(name, "java.", false)) {
                return obj.toString();
            }
            return null;
        } catch (Exception unused) {
        }
    }

    private JSONArray b(Object obj) throws JSONException {
        k.c(obj, "array");
        JSONArray jSONArray = new JSONArray();
        if (obj.getClass().isArray()) {
            for (Object a2 : (Object[]) obj) {
                jSONArray.put(a(a2));
            }
            return jSONArray;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 344 && intent != null) {
            String stringExtra = intent.getStringExtra("order_id");
            boolean booleanExtra = intent.getBooleanExtra(AppConstants.IS_CANCEL, false);
            if (booleanExtra) {
                finish();
            } else if (!booleanExtra) {
                finish();
                k.a((Object) stringExtra, "mOrderID");
                Intent a2 = d.a(this, Boolean.FALSE, Boolean.TRUE);
                a2.putExtra("order_id", stringExtra);
                f.a.a aVar = f.a.a.f13515a;
                a2.putExtra("insurance_type", String.valueOf(((Number) Objects.requireNonNull(f.a.a.c())).intValue()));
                startActivity(a2);
            }
        }
    }
}
