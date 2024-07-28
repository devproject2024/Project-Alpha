package net.one97.paytm.upgradeKyc.f;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.CJRAadharPanDocList;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.utils.j;

public class c implements com.paytm.network.listener.b {

    /* renamed from: i  reason: collision with root package name */
    private static c f65973i;

    /* renamed from: a  reason: collision with root package name */
    public String f65974a;

    /* renamed from: b  reason: collision with root package name */
    public C1315c f65975b;

    /* renamed from: c  reason: collision with root package name */
    public Context f65976c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65977d = false;

    /* renamed from: e  reason: collision with root package name */
    private String f65978e;

    /* renamed from: f  reason: collision with root package name */
    private String f65979f;

    /* renamed from: g  reason: collision with root package name */
    private b f65980g;

    /* renamed from: h  reason: collision with root package name */
    private a f65981h;

    public interface a {
    }

    public interface b {
        void onNameInitializationError(String str);

        void onNameInitialize(String str);
    }

    /* renamed from: net.one97.paytm.upgradeKyc.f.c$c  reason: collision with other inner class name */
    public interface C1315c {
        void onPanRecieved(String str);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        List<CJRAadharPanDocList> documents;
        b bVar;
        if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
            CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRPaytmDataModel;
            if (cJRAadharPanGet == null || cJRAadharPanGet.getStatus() == null || !cJRAadharPanGet.getStatus().equalsIgnoreCase(AppConstants.TRANSACTION_STATUS_ERROR) || (bVar = this.f65980g) == null) {
                String firstname = !TextUtils.isEmpty(cJRAadharPanGet.getFirstname()) ? cJRAadharPanGet.getFirstname() : "";
                if (!TextUtils.isEmpty(cJRAadharPanGet.getLastname())) {
                    firstname = firstname + " " + cJRAadharPanGet.getLastname();
                }
                if (!TextUtils.isEmpty(firstname)) {
                    this.f65978e = firstname;
                    j.f(this.f65976c, this.f65978e);
                    b bVar2 = this.f65980g;
                    if (bVar2 != null) {
                        bVar2.onNameInitialize(com.paytm.utility.b.v(this.f65978e));
                    }
                } else {
                    b bVar3 = this.f65980g;
                    if (bVar3 != null) {
                        bVar3.onNameInitializationError(c());
                    }
                }
            } else {
                bVar.onNameInitializationError(c());
            }
            if (cJRAadharPanGet.getStatus() != null && cJRAadharPanGet.getDocuments() != null && (documents = cJRAadharPanGet.getDocuments()) != null) {
                for (int i2 = 0; i2 < documents.size(); i2++) {
                    if (documents.get(i2).getDocCode() != null) {
                        if (documents.get(i2).getDocCode().equalsIgnoreCase("aadhar")) {
                            j.a(this.f65976c, documents.get(i2).getDocValue());
                            if (this.f65981h != null) {
                                documents.get(i2).getDocValue();
                            }
                        } else if (documents.get(i2).getDocCode().equalsIgnoreCase("pan")) {
                            j.b(this.f65976c, documents.get(i2).getDocValue());
                            C1315c cVar = this.f65975b;
                            if (cVar != null) {
                                cVar.onPanRecieved(documents.get(i2).getDocValue());
                            }
                        }
                    }
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b bVar = this.f65980g;
        if (bVar != null) {
            bVar.onNameInitializationError(c());
        }
    }

    private c() {
    }

    public static c a() {
        if (f65973i == null) {
            f65973i = new c();
        }
        return f65973i;
    }

    public final void b() {
        this.f65978e = "";
        this.f65974a = "";
        this.f65979f = "";
        f65973i = null;
    }

    public final void a(Context context, b bVar) {
        if (context != null) {
            this.f65980g = bVar;
            if (TextUtils.isEmpty(this.f65978e)) {
                this.f65978e = j.l(context);
                if (TextUtils.isEmpty(this.f65978e)) {
                    this.f65980g = bVar;
                    this.f65976c = context.getApplicationContext();
                    a(context, (com.paytm.network.listener.b) this);
                    return;
                }
            }
            b bVar2 = this.f65980g;
            if (bVar2 != null) {
                bVar2.onNameInitialize(com.paytm.utility.b.v(this.f65978e));
            }
        }
    }

    public final void a(Context context, final com.paytm.network.listener.b bVar) {
        String str;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("kycFetchProfileInfoV2");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str) && !TextUtils.isEmpty(com.paytm.utility.a.q(context))) {
            String e2 = com.paytm.utility.b.e(context, str);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", com.paytm.utility.a.q(context));
            CJRAadharPanGet cJRAadharPanGet = new CJRAadharPanGet();
            a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a2 = a.C1317a.a();
            a2.f42877a = context;
            a2.f42879c = a.C0715a.GET;
            a2.f42882f = hashMap;
            a2.f42885i = cJRAadharPanGet;
            a2.f42880d = e2;
            a2.o = c.class.getName();
            a2.f42878b = a.c.KYC;
            a2.n = a.b.USER_FACING;
            a2.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    c.a(c.this, iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    com.paytm.network.listener.b bVar = bVar;
                    if (bVar != null) {
                        bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                    }
                }
            };
            com.paytm.network.a l = a2.l();
            if (com.paytm.utility.b.c(context)) {
                l.a();
            }
        }
    }

    private String c() {
        String str = "";
        if (this.f65977d) {
            return str;
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.h(this.f65976c))) {
            str = com.paytm.utility.b.h(this.f65976c).trim();
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.i(this.f65976c))) {
            str = str + " " + com.paytm.utility.b.i(this.f65976c).trim();
        }
        return com.paytm.utility.b.v(str.trim());
    }

    static /* synthetic */ void a(c cVar, IJRPaytmDataModel iJRPaytmDataModel) {
        List<CJRAadharPanDocList> documents;
        b bVar;
        if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
            CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRPaytmDataModel;
            if (cJRAadharPanGet == null || cJRAadharPanGet.getStatus() == null || !cJRAadharPanGet.getStatus().equalsIgnoreCase(AppConstants.TRANSACTION_STATUS_ERROR) || (bVar = cVar.f65980g) == null) {
                String firstname = !TextUtils.isEmpty(cJRAadharPanGet.getFirstname()) ? cJRAadharPanGet.getFirstname() : "";
                if (!TextUtils.isEmpty(cJRAadharPanGet.getLastname())) {
                    firstname = firstname + " " + cJRAadharPanGet.getLastname();
                }
                if (!TextUtils.isEmpty(firstname)) {
                    cVar.f65978e = firstname;
                    j.f(cVar.f65976c, cVar.f65978e);
                    b bVar2 = cVar.f65980g;
                    if (bVar2 != null) {
                        bVar2.onNameInitialize(com.paytm.utility.b.v(cVar.f65978e));
                    }
                } else {
                    b bVar3 = cVar.f65980g;
                    if (bVar3 != null) {
                        bVar3.onNameInitializationError(cVar.c());
                    }
                }
            } else {
                bVar.onNameInitializationError(cVar.c());
            }
            if (cJRAadharPanGet.getStatus() != null && cJRAadharPanGet.getDocuments() != null && (documents = cJRAadharPanGet.getDocuments()) != null) {
                for (int i2 = 0; i2 < documents.size(); i2++) {
                    if (documents.get(i2).getDocCode() != null) {
                        if (documents.get(i2).getDocCode().equalsIgnoreCase("aadhar")) {
                            j.a(cVar.f65976c, documents.get(i2).getDocValue());
                            if (cVar.f65981h != null) {
                                documents.get(i2).getDocValue();
                            }
                        } else if (documents.get(i2).getDocCode().equalsIgnoreCase("pan")) {
                            j.b(cVar.f65976c, documents.get(i2).getDocValue());
                            C1315c cVar2 = cVar.f65975b;
                            if (cVar2 != null) {
                                cVar2.onPanRecieved(documents.get(i2).getDocValue());
                            }
                        }
                    }
                }
            }
        }
    }
}
