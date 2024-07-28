package net.one97.paytm.passbook.landing.repositories;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.utility.m;

public final class i extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final i f57793b = new i();

    /* renamed from: c  reason: collision with root package name */
    private static final String f57794c = f57794c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f57795d = f57795d;

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57797a;

        b(x.e eVar) {
            this.f57797a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRPPUserProfileKycTnc) {
                f.a aVar = f.f57885d;
                ((y) this.f57797a.element).postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private i() {
    }

    public static String b() {
        return f57794c;
    }

    public static String c() {
        return f57795d;
    }

    public final LiveData<f<CJRPPUserProfileKycTnc>> d() {
        x.e eVar = new x.e();
        eVar.element = new y();
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String uri = Uri.parse(e.d()).buildUpon().appendQueryParameter("fetch_type", "ACCOUNTS").appendQueryParameter("channel", StringSet.Android).appendQueryParameter("version", "2").appendQueryParameter(AppConstants.TAG_SITE_ID, "1").appendQueryParameter(AppConstants.TAG_CHILD_SITE_ID, "1").build().toString();
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (a() != null) {
            if (TextUtils.isEmpty(d.a(f57793b.a()))) {
                return (y) eVar.element;
            }
            String a2 = d.a(f57793b.a());
            k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a2);
        }
        a(uri, new CJRPPUserProfileKycTnc(), hashMap, new b(eVar), new a(eVar));
        return (y) eVar.element;
    }

    static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57796a;

        a(x.e eVar) {
            this.f57796a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CJRPPUserProfileKycTnc) {
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                ((y) this.f57796a.element).postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }

    public final boolean e() {
        m.a aVar = m.f59265a;
        Context applicationContext = a().getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return m.a.a(applicationContext).b("isCreditCard", false, true);
    }

    public final String f() {
        m.a aVar = m.f59265a;
        Context applicationContext = a().getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        String b2 = m.a.a(applicationContext).b("POSTPAID_STATUS", "", true);
        if (k.a((Object) b2, (Object) "")) {
            return null;
        }
        return b2;
    }
}
