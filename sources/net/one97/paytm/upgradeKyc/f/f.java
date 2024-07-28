package net.one97.paytm.upgradeKyc.f;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.utils.c;
import net.one97.paytm.upgradeKyc.utils.j;

public final class f implements Response.ErrorListener, Response.Listener<IJRDataModel> {

    /* renamed from: c  reason: collision with root package name */
    public static f f65990c;

    /* renamed from: a  reason: collision with root package name */
    public a f65991a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65992b;

    /* renamed from: d  reason: collision with root package name */
    private int f65993d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f65994e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f65995f = false;

    /* renamed from: g  reason: collision with root package name */
    private String f65996g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f65997h = null;

    /* renamed from: i  reason: collision with root package name */
    private int f65998i = -1;

    public interface a {
        void a(int i2);

        void a(boolean z);

        void b(boolean z);
    }

    public final void onErrorResponse(VolleyError volleyError) {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (iJRDataModel instanceof KYCStatusV2) {
            KYCStatusV2 kYCStatusV2 = (KYCStatusV2) iJRDataModel;
            int isKycDone = kYCStatusV2.getIsKycDone();
            boolean isMinKycStatus = kYCStatusV2.isMinKycStatus();
            boolean isMinKycEligible = kYCStatusV2.isMinKycEligible();
            String kycType = kYCStatusV2.getKycType();
            String kycExpiryTime = kYCStatusV2.getKycExpiryTime();
            int isKycExpired = kYCStatusV2.isKycExpired();
            if (!TextUtils.isEmpty(kycExpiryTime)) {
                this.f65997h = c.a(kycExpiryTime);
            }
            if (!TextUtils.isEmpty(kycType)) {
                this.f65996g = kycType;
            }
            this.f65993d = isKycDone;
            this.f65994e = isMinKycStatus;
            this.f65998i = isKycExpired;
            this.f65995f = isMinKycEligible;
            j.a(this.f65992b.getApplicationContext(), this.f65993d);
            j.a(this.f65992b.getApplicationContext(), isMinKycStatus);
            j.c(this.f65992b.getApplicationContext(), this.f65996g);
            j.b(this.f65992b.getApplicationContext(), this.f65998i);
            j.d(this.f65992b.getApplicationContext(), this.f65997h);
            j.b(this.f65992b.getApplicationContext(), this.f65995f);
            a aVar = this.f65991a;
            if (aVar != null) {
                aVar.a(this.f65998i);
                this.f65991a.a(this.f65994e);
                this.f65991a.b(this.f65995f);
            }
        }
    }

    private f() {
    }

    public static f a() {
        if (f65990c == null) {
            f65990c = new f();
        }
        return f65990c;
    }

    public final void b() {
        this.f65996g = null;
        this.f65993d = -1;
        this.f65998i = -1;
        this.f65997h = null;
        this.f65994e = false;
        this.f65995f = false;
    }

    public final void a(Context context, a aVar) {
        if (context != null) {
            this.f65991a = aVar;
            if (this.f65993d == -1) {
                this.f65993d = j.b(context);
                this.f65994e = j.j(context);
                this.f65995f = j.i(context);
                this.f65996g = j.c(context);
                this.f65998i = j.d(context);
                this.f65997h = j.g(context);
                if (this.f65993d == -1) {
                    this.f65991a = aVar;
                    this.f65992b = context;
                    Context context2 = this.f65992b;
                    String str = null;
                    d.a aVar2 = d.f66026a;
                    if (d.a.a() != null) {
                        d.a aVar3 = d.f66026a;
                        d.a.a();
                        str = d.a("min_kyc_status_v3_url");
                    }
                    if (URLUtil.isValidUrl(str)) {
                        String e2 = b.e(context2, str);
                        HashMap hashMap = new HashMap();
                        hashMap.put("session_token", com.paytm.utility.a.q(context2));
                        KYCStatusV2 kYCStatusV2 = new KYCStatusV2();
                        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                        com.paytm.network.b a2 = a.C1317a.a();
                        a2.f42877a = context2;
                        a2.f42879c = a.C0715a.GET;
                        a2.f42882f = hashMap;
                        a2.f42885i = kYCStatusV2;
                        a2.f42880d = e2;
                        a2.o = c.class.getName();
                        a2.n = a.b.USER_FACING;
                        a2.j = new com.paytm.network.listener.b() {
                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            }

                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                f.a(f.this, iJRPaytmDataModel);
                            }
                        };
                        com.paytm.network.a l = a2.l();
                        if (b.c(context2)) {
                            l.a();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            a aVar5 = this.f65991a;
            if (aVar5 != null) {
                aVar5.a(this.f65998i);
                this.f65991a.a(this.f65994e);
                this.f65991a.b(this.f65995f);
            }
        }
    }

    static /* synthetic */ void a(f fVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof KYCStatusV2) {
            KYCStatusV2 kYCStatusV2 = (KYCStatusV2) iJRPaytmDataModel;
            int isKycDone = kYCStatusV2.getIsKycDone();
            boolean isMinKycStatus = kYCStatusV2.isMinKycStatus();
            boolean isMinKycEligible = kYCStatusV2.isMinKycEligible();
            String kycType = kYCStatusV2.getKycType();
            String kycExpiryTime = kYCStatusV2.getKycExpiryTime();
            int isKycExpired = kYCStatusV2.isKycExpired();
            if (!TextUtils.isEmpty(kycExpiryTime)) {
                fVar.f65997h = c.a(kycExpiryTime);
            }
            if (!TextUtils.isEmpty(kycType)) {
                fVar.f65996g = kycType;
            }
            fVar.f65993d = isKycDone;
            fVar.f65994e = isMinKycStatus;
            fVar.f65998i = isKycExpired;
            fVar.f65995f = isMinKycEligible;
            j.a(fVar.f65992b.getApplicationContext(), fVar.f65993d);
            j.a(fVar.f65992b.getApplicationContext(), isMinKycStatus);
            j.c(fVar.f65992b.getApplicationContext(), fVar.f65996g);
            j.b(fVar.f65992b.getApplicationContext(), fVar.f65998i);
            j.d(fVar.f65992b.getApplicationContext(), fVar.f65997h);
            j.b(fVar.f65992b.getApplicationContext(), fVar.f65995f);
            a aVar = fVar.f65991a;
            if (aVar != null) {
                aVar.a(fVar.f65998i);
                fVar.f65991a.a(fVar.f65994e);
                fVar.f65991a.b(fVar.f65995f);
            }
        }
    }
}
