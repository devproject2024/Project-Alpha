package net.one97.paytm.upgradeKyc.kycV3.c;

import android.app.Application;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.upgradeKyc.ConsentSaveForm60;
import net.one97.paytm.common.entity.upgradeKyc.ConsentSaveObject;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.common.entity.upgradeKyc.PostAppointmentResponse;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycSlotPickerActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;
import org.json.JSONObject;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<ConsentSaveObject> f66198a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> f66199b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> f66200c;

    /* renamed from: d  reason: collision with root package name */
    final y<String> f66201d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> f66202e;

    /* renamed from: f  reason: collision with root package name */
    private final y<String> f66203f;

    /* renamed from: g  reason: collision with root package name */
    private final Application f66204g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final net.one97.paytm.upgradeKyc.kycV3.b.c f66205h;

    /* renamed from: net.one97.paytm.upgradeKyc.kycV3.c.a$a  reason: collision with other inner class name */
    static final class C1327a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66206a;

        C1327a(a aVar) {
            this.f66206a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ConsentSaveObject consentSaveObject = (ConsentSaveObject) obj;
            net.one97.paytm.upgradeKyc.kycV3.b.c a2 = this.f66206a.f66205h;
            k.a((Object) consentSaveObject, "it");
            k.c(consentSaveObject, "consentSaveObject");
            y yVar = new y();
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            d.a aVar2 = d.f66026a;
            String a3 = d.a.a() != null ? d.a("consentSaveUrl") : null;
            if (!URLUtil.isValidUrl(a3)) {
                b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.a()));
            }
            Map hashMap = new HashMap();
            String a4 = com.paytm.utility.d.a(a2.f66175b);
            k.a((Object) a4, "CJRNetUtility.getSSOToken(appContext)");
            hashMap.put("session_token", a4);
            hashMap.put("Content-Type", "application/json");
            a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a5 = a.C1317a.a().a(a2.f66175b).a(a.C0715a.POST).a((Map<String, String>) hashMap);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nonMinorConsent", consentSaveObject.getNonMinorConsent());
            jSONObject.put("fatca", consentSaveObject.getFatca());
            jSONObject.put("biometricConsent", consentSaveObject.getBiometricConsent());
            jSONObject.put("form60Consent", consentSaveObject.getForm60Consent());
            jSONObject.put("pan", consentSaveObject.getPan());
            jSONObject.put("productSelected", consentSaveObject.getProductSelected());
            jSONObject.put("fastagKycConsent", consentSaveObject.getFastagKycConsent());
            JSONObject jSONObject2 = new JSONObject();
            ConsentSaveForm60 form60 = consentSaveObject.getForm60();
            jSONObject2.put("agriculturalIncome", form60 != null ? form60.getAgriculturalIncome() : null);
            ConsentSaveForm60 form602 = consentSaveObject.getForm60();
            jSONObject2.put("nonAgriculturalIncome", form602 != null ? form602.getNonAgriculturalIncome() : null);
            ConsentSaveForm60 form603 = consentSaveObject.getForm60();
            jSONObject2.put("panAckNumber", form603 != null ? form603.getPanAckNumber() : null);
            ConsentSaveForm60 form604 = consentSaveObject.getForm60();
            jSONObject2.put("panAckDate", form604 != null ? form604.getPanAckDate() : null);
            jSONObject.put("form60", jSONObject2);
            q.b(jSONObject.toString());
            String jSONObject3 = jSONObject.toString();
            k.a((Object) jSONObject3, "obj.toString()");
            com.paytm.network.a l = a5.b(jSONObject3).a((IJRPaytmDataModel) new PostAppointmentResponse((String) null, 1, (g) null)).a(a.c.KYC).a(a3).c(KycSlotPickerActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.d(yVar)).l();
            if (com.paytm.utility.b.c(a2.f66175b)) {
                l.a();
            } else {
                b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.c()));
            }
            return ah.a(yVar, new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C1327a f66207a;

                {
                    this.f66207a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
                    k.a((Object) bVar, "it");
                    return a.a(bVar);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application, net.one97.paytm.upgradeKyc.kycV3.b.c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.f66204g = application;
        this.f66205h = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> b2 = ah.b(this.f66198a, new C1327a(this));
        k.a((Object) b2, "Transformations.switchMa… mapToUiModel(it) }\n    }");
        this.f66199b = b2;
        this.f66203f = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> b3 = ah.b(this.f66203f, new b(this));
        k.a((Object) b3, "Transformations.switchMa…ailsToUiModel(it) }\n    }");
        this.f66200c = b3;
        this.f66201d = new y<>();
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> b4 = ah.b(this.f66201d, new c(this));
        k.a((Object) b4, "Transformations.switchMa…a.value.toString())\n    }");
        this.f66202e = b4;
    }

    public final void a(String str) {
        k.c(str, Item.KEY_REASON);
        this.f66203f.setValue(str);
    }

    public final void b(String str) {
        k.c(str, "tncSet");
        this.f66201d.setValue(str);
    }

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66208a;

        b(a aVar) {
            this.f66208a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str;
            net.one97.paytm.upgradeKyc.kycV3.b.c a2 = this.f66208a.f66205h;
            y yVar = new y();
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            d.a aVar2 = d.f66026a;
            if (d.a.a() != null) {
                d.a aVar3 = d.f66026a;
                if (d.a.a() == null) {
                    k.a();
                }
                str = d.a("mwGetAppointmentV3Url");
            } else {
                str = null;
            }
            if (!URLUtil.isValidUrl(str)) {
                b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.a()));
            } else {
                Map hashMap = new HashMap();
                String a3 = com.paytm.utility.d.a(a2.f66175b);
                k.a((Object) a3, "CJRNetUtility.getSSOToken(appContext)");
                hashMap.put("session_token", a3);
                hashMap.put("Content-Type", "application/json");
                hashMap.put("Accept", "application/json");
                a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l = a.C1317a.a().a(a2.f66175b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new KycSavedUserData()).a(com.paytm.utility.b.e(a2.f66175b, str) + "&userInterest=true&leadSource=App").a(a.c.KYC).a(false).c(a2.getClass().getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.j(yVar)).l();
                if (com.paytm.utility.b.c(a2.f66175b)) {
                    l.a();
                } else {
                    b.a aVar6 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                    yVar.setValue(b.a.a(a2.c()));
                }
            }
            return ah.a(yVar, new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f66209a;

                {
                    this.f66209a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
                    k.a((Object) bVar, "it");
                    return a.b(bVar);
                }
            });
        }
    }

    static final class c<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66210a;

        c(a aVar) {
            this.f66210a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            return net.one97.paytm.upgradeKyc.kycV3.b.c.a(this.f66210a.f66205h, String.valueOf(this.f66210a.f66201d.getValue()), (String) null, 2);
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.b.b a(net.one97.paytm.upgradeKyc.kycV3.b.b bVar) {
        int i2 = b.f66211a[bVar.f66168a.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                return b.a.a();
            } else if (i2 == 3) {
                b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                return b.a.a(bVar.f66170c);
            }
        } else if (bVar.f66169b != null) {
            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            ResultType resulttype = bVar.f66169b;
            if (resulttype == null) {
                k.a();
            }
            return b.a.a(resulttype);
        }
        b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
        ResultType resulttype2 = bVar.f66169b;
        if (resulttype2 == null) {
            k.a();
        }
        return b.a.a(resulttype2);
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.b.b b(net.one97.paytm.upgradeKyc.kycV3.b.b bVar) {
        int i2 = b.f66212b[bVar.f66168a.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                return b.a.a();
            } else if (i2 == 3) {
                b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                return b.a.a(bVar.f66170c);
            }
        } else if (bVar.f66169b != null) {
            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            ResultType resulttype = bVar.f66169b;
            if (resulttype == null) {
                k.a();
            }
            return b.a.a(resulttype);
        }
        b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
        ResultType resulttype2 = bVar.f66169b;
        if (resulttype2 == null) {
            k.a();
        }
        return b.a.a(resulttype2);
    }
}
