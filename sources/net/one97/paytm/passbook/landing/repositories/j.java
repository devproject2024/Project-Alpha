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
import net.one97.paytm.passbook.beans.ExtraInfo;
import net.one97.paytm.passbook.beans.SADetailsResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.i;

public final class j extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final j f57798b = new j();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57800a;

        b(y yVar) {
            this.f57800a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof SADetailsResponse) {
                y yVar = this.f57800a;
                f.a aVar = f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private j() {
    }

    public final LiveData<f<SADetailsResponse>> a(String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        y yVar = new y();
        String str10 = d.b().a("getSavingAccountDetailsV2Updated") + "?accType=ISA";
        if (str6 != null) {
            str10 = str10 + "&accNum=" + str6;
        }
        if (str7 != null) {
            str10 = str10 + "&tranDateEpochMilli=" + str7;
        }
        if (str8 != null) {
            str10 = str10 + "&dateTimeEpochMilli=" + str8;
        }
        if (str9 != null) {
            str10 = str10 + "&txnId=" + str9;
        }
        String str11 = str10;
        Map hashMap = new HashMap();
        if (str5 != null) {
            hashMap.put("Authorization", String.valueOf(str5));
        }
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        hashMap.put("Accept-Encoding", "gzip,deflate");
        k.a((Object) str11, "url");
        a(str11, new SADetailsResponse((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, (Integer) null, (ArrayList) null, (ArrayList) null, (Object) null, (String) null, (String) null, (String) null, (ExtraInfo) null, 65535, (g) null), hashMap, new b(yVar), new a(yVar));
        return yVar;
    }

    static final class a implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57799a;

        a(y yVar) {
            this.f57799a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof SADetailsResponse) {
                y yVar = this.f57799a;
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
