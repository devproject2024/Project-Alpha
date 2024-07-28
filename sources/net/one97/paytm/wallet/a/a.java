package net.one97.paytm.wallet.a;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.models.QrData;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f69839a = new a();

    private a() {
    }

    public static Context a() {
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        return a2.getContext();
    }

    public static void a(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("new_wallet_screen_type", "send_money");
        hashMap.put("scan_source_screen_type", z ? "scan_icon" : "pay_icon");
        b.a().sendCustomGTMEvent(a(), "new_wallet_pay_qr_scan_successful", hashMap);
    }

    public static void a(String str, boolean z) {
        k.c(str, "type");
        Map hashMap = new HashMap();
        hashMap.put("scan_source_screen_type", z ? "scan_icon" : "pay_icon");
        hashMap.put("scan_destination_screen", str);
        b.a().sendCustomGTMEvent(a(), "scan_qr_code_successful", hashMap);
    }

    public static void b(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("new_wallet_screen_type", "send_money");
        hashMap.put("scan_source_screen_type", z ? "scan_icon" : "pay_icon");
        b.a().sendCustomGTMEvent(a(), "new_wallet_pay_gallery_icon_clicked", hashMap);
        String str = z ? "flow_through_scan_icon" : "flow_through_pay_icon";
        Context a2 = a();
        k.a((Object) a2, "getContext()");
        a("offline_payments", "scan_screen_gallery_clicked", str, a2, "home/pay-send/post-scan");
    }

    public static void c(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("new_wallet_screen_type", "scan");
        hashMap.put("scan_source_screen_type", z ? "scan icon" : "pay icon");
        b.a().sendCustomGTMEvent(a(), "new_wallet_discovery_qr_scan_successful", hashMap);
    }

    public static void d(boolean z) {
        String str = z ? "flow_through_scan_icon" : "flow_through_pay_icon";
        Context a2 = a();
        k.a((Object) a2, "getContext()");
        a("offline_payments", "scan_screen_showcode_clicked", str, a2, "home/pay-send/show-code");
    }

    public static void a(String str, String str2, String str3, Context context, String str4) {
        k.c(str, "eventCategory");
        k.c(str2, "event_action");
        k.c(str3, "event_label");
        k.c(context, "context");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        try {
            b.a().sendCustomGTMEvents(str, str2, str3, "0", context, str4, "offline_payments");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(e2.getMessage());
            }
        }
    }

    public static void a(String str, String str2, String str3, Context context, String str4, String str5) {
        k.c(str, "eventCategory");
        k.c(str2, "event_action");
        k.c(str3, "event_label");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str5, "verticalId");
        try {
            b.a().sendCustomGTMEvents(str, str2, str3, (String) null, context, str4, str5);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(e2.getMessage());
            }
        }
    }

    public static void a(boolean z, String str, Long l, long j, int i2, String str2) {
        k.c(str, "payload");
        QrData qrData = new QrData();
        qrData.setEventName("qrScanSession");
        qrData.setIsMultiQREnabled(String.valueOf(b.a().getBooleanFromGTM(a(), "multi_scan_enable", false)));
        qrData.setScanDuration(String.valueOf(j));
        qrData.setScannedCount(String.valueOf(i2));
        qrData.setIsSuccess(String.valueOf(z));
        qrData.setScanSessionId(str2);
        if (z) {
            qrData.setFirstQrDetectedTime(String.valueOf(l));
            qrData.setQrPayload(str);
        } else {
            qrData.setFailReason("Back Button Pressed");
        }
        if (z && !TextUtils.isEmpty(str)) {
            b.a().pushScanSessionHawkeyeEvent(a(), qrData);
        } else if (!z) {
            b.a().pushScanSessionHawkeyeEvent(a(), qrData);
        }
    }

    public static void a(String str, boolean z, long j, String str2) {
        k.c(str, "payload");
        QrData qrData = new QrData();
        qrData.setEventName("qrScanCode");
        qrData.setIsWinner(String.valueOf(z));
        qrData.setIsMultiQREnabled(String.valueOf(b.a().getBooleanFromGTM(a(), "multi_scan_enable", false)));
        qrData.setScanDuration(String.valueOf(j));
        qrData.setQrPayload(str);
        qrData.setCorrectionLevel("L");
        qrData.setScanSessionId(str2);
        b.a().pushScanCodeHawkeyeEvent(a(), qrData);
    }

    public static void b() {
        try {
            Map hashMap = new HashMap();
            hashMap.put("wallet_screen_type", "send money");
            c a2 = b.a();
            c a3 = b.a();
            k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
            a2.sendCustomGTMEvent(a3.getContext(), "wallet_screen_loaded", hashMap);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(e2.toString());
            }
        }
    }
}
