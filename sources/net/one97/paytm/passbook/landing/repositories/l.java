package net.one97.paytm.passbook.landing.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse;
import net.one97.paytm.passbook.beans.RepeatPayment;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;

public final class l extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final l f57811b = new l();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57813a;

        b(y yVar) {
            this.f57813a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof PassbookTransactionHistoryResponse) {
                y yVar = this.f57813a;
                f.a aVar = f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private l() {
    }

    public final LiveData<f<PassbookTransactionHistoryResponse>> a(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        y yVar = new y();
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String C = e.C();
        if (str5 != null) {
            C = C + '/' + str5 + "/detail";
        }
        if (str4 != null) {
            C = C + "?txnId=" + str4;
        }
        String str7 = C;
        Map hashMap = new HashMap();
        if (str6 != null) {
            hashMap.put("Authorization", "{userToken=" + str6 + '}');
        }
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        hashMap.put("Accept-Encoding", "gzip,deflate");
        k.a((Object) str7, "url");
        a(str7, new PassbookTransactionHistoryResponse((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, (Integer) null, (ArrayList) null, (ArrayList) null, (Object) null, (String) null, (String) null, (Integer) null, (String) null, (RepeatPayment) null, (String) null, 262143, (g) null), hashMap, new b(yVar), new a(yVar));
        return yVar;
    }

    static final class a implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57812a;

        a(y yVar) {
            this.f57812a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof PassbookTransactionHistoryResponse) {
                y yVar = this.f57812a;
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
