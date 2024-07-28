package net.one97.paytm.wallet.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.google.zxing.r;
import com.google.zxing.t;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.a.d;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f69840a;

    /* renamed from: b  reason: collision with root package name */
    private c f69841b;

    public b(Context context, c cVar) {
        this.f69840a = context;
        this.f69841b = cVar;
    }

    public final y<d> a(String str, boolean z) {
        int h2;
        y<d> yVar = new y<>();
        if (str == null || (h2 = a.h(str)) == -1) {
            return null;
        }
        c cVar = this.f69841b;
        if (cVar != null) {
            cVar.sendGTMOpenScreenWithDeviceInfo(this.f69840a, "/wallet/pay-send/scan-code", "scan");
        }
        if (h2 == 1) {
            net.one97.paytm.f.b.a().f50402a.setMode("qrFrontEnd");
            net.one97.paytm.f.b.a().f50402a.setRequestType("QR Static");
            try {
                String b2 = com.google.zxing.client.android.d.b.b(str, UpiConstants.QR_KEY);
                a aVar = a.f69839a;
                a.a(z);
                CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                cJRQRScanResultModel.parseData(new JSONObject(b2), this.f69840a);
                j.a().a(this.f69840a, b2, cJRQRScanResultModel.getMobileNo(), 1, 1);
                if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(cJRQRScanResultModel.getRequestType())) {
                    yVar.postValue(new d.C1411d(str, cJRQRScanResultModel.getName(), cJRQRScanResultModel.getMobileNo()));
                } else {
                    yVar.postValue(new d.e(str, b2, Boolean.FALSE, Boolean.TRUE));
                }
            } catch (Exception unused) {
                if (a.m(str)) {
                    a aVar2 = a.f69839a;
                    a.a("deeplink - ".concat(String.valueOf(str)), z);
                } else if (com.paytm.utility.b.r(str)) {
                    a aVar3 = a.f69839a;
                    a.a("paytm url -".concat(String.valueOf(str)), z);
                } else if (com.paytm.utility.b.s(str)) {
                    a aVar4 = a.f69839a;
                    a.a("url - ".concat(String.valueOf(str)), z);
                } else {
                    a aVar5 = a.f69839a;
                    a.a("text - ".concat(String.valueOf(str)), z);
                }
                String C = a.C(str);
                if (!TextUtils.isEmpty(C)) {
                    net.one97.paytm.f.b.a().f50402a.setRequestType("QR All in One");
                    yVar.postValue(new d.i(C, str));
                } else {
                    yVar.postValue(new d.a(str));
                }
            }
        } else if (h2 == 4) {
            yVar.postValue(new d.l(str));
        } else if (h2 == 7) {
            yVar.postValue(new d.c(str));
        } else if (h2 == 3) {
            yVar.postValue(new d.f(str, Boolean.valueOf(z)));
        } else if (h2 == 6) {
            yVar.postValue(new d.k(str, new r(str, (byte[]) null, (t[]) null, com.google.zxing.a.QR_CODE)));
        } else if (h2 == 5) {
            yVar.postValue(new d.b(str));
        } else if (h2 == 9) {
            String substring = Uri.parse(str).getPath().substring(1);
            if (com.paytm.utility.b.c(this.f69840a)) {
                yVar.postValue(new d.h(substring, false));
            } else {
                yVar.postValue(new d.j(str));
            }
        } else {
            net.one97.paytm.f.b.a().f50402a.setMode("qrBackEnd");
            net.one97.paytm.f.b.a().f50402a.setRequestType("QR dynamic");
            if (com.paytm.utility.b.c(this.f69840a)) {
                yVar.postValue(new d.h(str, false));
            } else {
                j.a();
                if (j.a(this.f69840a, str) != null) {
                    yVar.postValue(new d.h(str, true));
                } else {
                    yVar.postValue(new d.j(str));
                }
            }
        }
        return yVar;
    }
}
