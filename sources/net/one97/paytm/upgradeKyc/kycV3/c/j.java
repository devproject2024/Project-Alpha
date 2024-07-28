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
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.upgradeKyc.PostAppointmentResponse;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycSlotPickerActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;
import org.json.JSONObject;

public final class j extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> f66248a;

    /* renamed from: b  reason: collision with root package name */
    private final y<a> f66249b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private final Application f66250c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final c f66251d;

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f66259a;

        b(j jVar) {
            this.f66259a = jVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str;
            String str2;
            a aVar = (a) obj;
            c a2 = this.f66259a.f66251d;
            k.a((Object) aVar, "it");
            k.c(aVar, "postAppParams");
            y yVar = new y();
            b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            d.a aVar3 = d.f66026a;
            if (d.a.a() != null) {
                d.a aVar4 = d.f66026a;
                if (d.a.a() == null) {
                    k.a();
                }
                str = d.a("mw_post_appointment_url");
            } else {
                str = null;
            }
            if (!URLUtil.isValidUrl(str)) {
                b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.a()));
            }
            Map hashMap = new HashMap();
            String a3 = com.paytm.utility.d.a(a2.f66175b);
            k.a((Object) a3, "CJRNetUtility.getSSOToken(appContext)");
            hashMap.put("session_token", a3);
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept-Encoding", AppConstants.UTF_8);
            a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a4 = a.C1317a.a().a(a2.f66175b).a(a.C0715a.POST).a((Map<String, String>) hashMap);
            a2.f66174a = new net.one97.paytm.upgradeKyc.kycV3.b.a(a2.f66175b);
            JSONObject jSONObject = new JSONObject(a2.f66174a != null ? net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData") : null);
            if (aVar.f66256e) {
                jSONObject.put("cancelAppointment", "true");
                jSONObject.put("cancelReason", aVar.f66257f);
                if (a2.f66174a != null) {
                    net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData", jSONObject.toString());
                }
                str2 = jSONObject.toString();
                k.a((Object) str2, "obj.toString()");
            } else {
                jSONObject.put("appointmentDate", aVar.f66252a);
                jSONObject.put("appointmentTimeSlot", aVar.f66253b);
                if (aVar.f66254c) {
                    jSONObject.put("reSchedule", "true");
                    jSONObject.put("reScheduleReason", aVar.f66255d);
                } else {
                    jSONObject.put("reSchedule", "false");
                    jSONObject.put("reScheduleReason", "");
                }
                jSONObject.put("cancelAppointment", "false");
                jSONObject.put("cancelReason", "");
                if (a2.f66174a != null) {
                    net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData", jSONObject.toString());
                }
                q.b(jSONObject.toString());
                str2 = jSONObject.toString();
                k.a((Object) str2, "obj.toString()");
            }
            com.paytm.network.a l = a4.b(str2).a((IJRPaytmDataModel) new PostAppointmentResponse((String) null, 1, (g) null)).a(str).a(a.c.KYC).c(KycSlotPickerActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.n(yVar)).l();
            if (com.paytm.utility.b.c(a2.f66175b)) {
                l.a();
            } else {
                b.a aVar7 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.c()));
            }
            return ah.a(yVar, new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f66260a;

                {
                    this.f66260a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
                    k.a((Object) bVar, "it");
                    return j.a(bVar);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Application application, c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.f66250c = application;
        this.f66251d = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> b2 = ah.b(this.f66249b, new b(this));
        k.a((Object) b2, "Transformations.switchMa… mapToUiModel(it) }\n    }");
        this.f66248a = b2;
    }

    public static /* synthetic */ void a(j jVar, String str, boolean z, String str2, String str3, boolean z2, String str4, int i2) {
        String str5 = (i2 & 1) != 0 ? "" : str;
        boolean z3 = (i2 & 2) != 0 ? false : z;
        String str6 = (i2 & 4) != 0 ? "" : str2;
        String str7 = (i2 & 8) != 0 ? "" : str3;
        boolean z4 = (i2 & 16) != 0 ? false : z2;
        String str8 = (i2 & 32) != 0 ? "" : str4;
        k.c(str5, "rescheduleReason");
        k.c(str6, "pickedDate");
        k.c(str7, "pickedTime");
        k.c(str8, "cancelReason");
        jVar.f66249b.setValue(new a(str6, str7, z3, str5, z4, str8, (byte) 0));
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f66252a;

        /* renamed from: b  reason: collision with root package name */
        public final String f66253b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f66254c;

        /* renamed from: d  reason: collision with root package name */
        public String f66255d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f66256e;

        /* renamed from: f  reason: collision with root package name */
        public String f66257f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f66258g;

        private a(String str, String str2, boolean z, String str3, boolean z2, String str4) {
            k.c(str, "pickedDate");
            k.c(str2, "pickedTime");
            k.c(str3, "rescheduleReason");
            k.c(str4, "cancelReason");
            this.f66252a = str;
            this.f66253b = str2;
            this.f66254c = z;
            this.f66255d = str3;
            this.f66258g = false;
            this.f66256e = z2;
            this.f66257f = str4;
        }

        public /* synthetic */ a(String str, String str2, boolean z, String str3, boolean z2, String str4, byte b2) {
            this(str, str2, z, str3, z2, str4);
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.b.b a(net.one97.paytm.upgradeKyc.kycV3.b.b bVar) {
        int i2 = k.f66261a[bVar.f66168a.ordinal()];
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
