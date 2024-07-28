package net.one97.paytm.passbook.landing.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.PaymentHistoryPagination;
import net.one97.paytm.passbook.beans.PaymentHistoryResponse;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;

public final class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final f f57778b = new f();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57780a;

        b(y yVar) {
            this.f57780a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof PaymentHistoryResponse) {
                y yVar = this.f57780a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private f() {
    }

    public final LiveData<net.one97.paytm.passbook.mapping.a.f<PaymentHistoryResponse>> a(String str, int i2, String str2, String str3, Context context, String str4) {
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        y yVar = new y();
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String str9 = e.B() + "?pageNo=" + i2 + "&pageSize=20";
        if (str5 != null) {
            str9 = str9 + "&transactionDateEpoch=" + str5;
        }
        if (str6 != null) {
            str9 = str9 + "&paginationTxnId=" + str6;
        }
        if (str7 != null) {
            str9 = str9 + "&paginationStreamSource=" + str7;
        }
        if (str8 != null) {
            str9 = str9 + "&txnCategory=" + str8;
        }
        Map hashMap = new HashMap();
        if (context != null) {
            hashMap.put("Authorization", "{userToken=" + net.one97.paytm.passbook.utility.f.c(context) + '}');
        }
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        k.a((Object) str9, "paymentHistoryUrl");
        a(str9, new PaymentHistoryResponse((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (PaymentHistoryPagination) null, (String) null, (String) null, (String) null, (Integer) null, 2047, (g) null), hashMap, new b(yVar), new a(yVar));
        return yVar;
    }

    static final class a implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57779a;

        a(y yVar) {
            this.f57779a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof PaymentHistoryResponse) {
                y yVar = this.f57779a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
