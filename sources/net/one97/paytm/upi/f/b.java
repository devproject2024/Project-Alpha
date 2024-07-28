package net.one97.paytm.upi.f;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel;
import net.one97.paytm.common.entity.moneytransfer.UPISuggestedBankModel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.ApiCallDataSource;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    a f66937a;

    public interface a {
        void a(NetworkCustomError networkCustomError);

        void a(UPIBankHealthResponseModel uPIBankHealthResponseModel);
    }

    public final void a(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        a aVar2 = aVar;
        k.c(aVar2, "apiCallback");
        this.f66937a = aVar2;
        i a2 = i.a();
        HashMap<String, String> hashMap = null;
        String f2 = a2 != null ? a2.f() : null;
        if (!TextUtils.isEmpty(f2)) {
            if (f2 != null) {
                hashMap = a(f2);
            }
            String upiSequenceNo = UpiUtils.getUpiSequenceNo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, upiSequenceNo);
            jSONObject.put("amount", str == null ? "0" : str);
            jSONObject.put(UpiRequestBuilder.KEY_PAYER_VPA, str2);
            jSONObject.put("payerBankIfsc", str3);
            jSONObject.put("payerAccNo", str4);
            jSONObject.put("payerName", str5);
            jSONObject.put("payeeName", str6);
            String str10 = "";
            jSONObject.put("payeeBankName", str7 == null ? str10 : str7);
            if (str8 != null) {
                str10 = str8;
            }
            jSONObject.put("payeeBankIfsc", str10);
            jSONObject.put("payeeVpa", str9);
            Map hashMap2 = new HashMap();
            k.a((Object) upiSequenceNo, CJRPGTransactionRequestUtils.UPI_SEQUENCE_NUM);
            hashMap2.put("seq-no", upiSequenceNo);
            ApiCallDataSource.Companion.postRequestCommonNetworkCallBuilder().a((Map<String, String>) hashMap).a(UpiRequestBuilder.getUPIBankHealthUrl()).b(hashMap2).b(jSONObject.toString()).a((IJRPaytmDataModel) new UPIBankHealthResponseModel("", "", "", "", "", "", "", "", "", (String) null, (List<UPISuggestedBankModel>) null)).a((com.paytm.network.listener.b) new C1346b(this)).l().a();
        }
    }

    /* renamed from: net.one97.paytm.upi.f.b$b  reason: collision with other inner class name */
    public static final class C1346b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66938a;

        C1346b(b bVar) {
            this.f66938a = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            a aVar;
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof UPIBankHealthResponseModel) && (aVar = this.f66938a.f66937a) != null) {
                aVar.a((UPIBankHealthResponseModel) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            a aVar;
            NetworkResponse networkResponse = null;
            if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
                if (networkCustomError != null) {
                    networkResponse = networkCustomError.networkResponse;
                }
                if (UpiUtils.isAuthenticationFailure(String.valueOf(networkResponse.statusCode))) {
                    return;
                }
            }
            if (networkCustomError != null && (aVar = this.f66938a.f66937a) != null) {
                aVar.a(networkCustomError);
            }
        }
    }

    private static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put(UpiConstants.CHANNEL_TOKEN, str);
        String str2 = UpiRequestBuilder.PAYTM_CHANNEL;
        k.a((Object) str2, "UpiRequestBuilder.PAYTM_CHANNEL");
        map.put("channel", str2);
        map.put("Content-type", "application/json");
        return hashMap;
    }
}
