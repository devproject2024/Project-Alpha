package net.one97.paytm.upgradeKyc.kycV3.c;

import android.app.Application;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.upgradeKyc.AppointmentSlots;
import net.one97.paytm.common.entity.upgradeKyc.TimeSlots;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycDoorStepActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;

public final class e extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<String> f66223a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<List<IJRDataModel>>> f66224b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<UADPincode>> f66225c;

    /* renamed from: d  reason: collision with root package name */
    private final List<IJRDataModel> f66226d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final y<String> f66227e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    private final Application f66228f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final c f66229g;

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f66230a;

        a(e eVar) {
            this.f66230a = eVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            c a2 = this.f66230a.f66229g;
            k.a((Object) str, "it");
            return ah.a(a2.a(str), new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f66231a;

                {
                    this.f66231a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
                    k.a((Object) bVar, "it");
                    return e.a(bVar);
                }
            });
        }
    }

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f66232a;

        b(e eVar) {
            this.f66232a = eVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            c a2 = this.f66232a.f66229g;
            k.a((Object) str, "it");
            k.c(str, "pinCode");
            y yVar = new y();
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            d.a aVar2 = d.f66026a;
            String a3 = k.a(d.a.a() != null ? d.a("kycTimeSlots") : null, (Object) "?pincode=".concat(String.valueOf(str)));
            Map hashMap = new HashMap();
            String a4 = com.paytm.utility.d.a(a2.f66175b);
            k.a((Object) a4, "CJRNetUtility.getSSOToken(appContext)");
            hashMap.put("session_token", a4);
            hashMap.put("channel", "androidapp");
            if (!URLUtil.isValidUrl(a3)) {
                b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.a()));
            }
            a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.a l = a.C1317a.a().a(a2.f66175b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new AppointmentSlots((List) null, 1, (g) null)).a(a3).a(a.c.KYC).c(KycDoorStepActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.v(yVar)).l();
            if (com.paytm.utility.b.c(a2.f66175b)) {
                l.a();
            } else {
                b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.c()));
            }
            return ah.a(yVar, new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f66233a;

                {
                    this.f66233a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
                    e eVar = this.f66233a.f66232a;
                    k.a((Object) bVar, "it");
                    return e.a(eVar, bVar);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Application application, c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.f66228f = application;
        this.f66229g = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<List<IJRDataModel>>> b2 = ah.b(this.f66227e, new b(this));
        k.a((Object) b2, "Transformations.switchMa… mapToUiModel(it) }\n    }");
        this.f66224b = b2;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<UADPincode>> b3 = ah.b(this.f66223a, new a(this));
        k.a((Object) b3, "Transformations.switchMa…oUiUadPincode(it) }\n    }");
        this.f66225c = b3;
    }

    public final void a(String str) {
        k.c(str, "pinCode");
        this.f66227e.setValue(str);
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.b.b a(e eVar, net.one97.paytm.upgradeKyc.kycV3.b.b bVar) {
        List<TimeSlots> timeSlotList;
        int i2 = f.f66234a[bVar.f66168a.ordinal()];
        if (i2 == 1) {
            AppointmentSlots appointmentSlots = (AppointmentSlots) bVar.f66169b;
            if (!(appointmentSlots == null || (timeSlotList = appointmentSlots.getTimeSlotList()) == null || !(!timeSlotList.isEmpty()))) {
                AppointmentSlots appointmentSlots2 = (AppointmentSlots) bVar.f66169b;
                List<TimeSlots> timeSlotList2 = appointmentSlots2 != null ? appointmentSlots2.getTimeSlotList() : null;
                if (timeSlotList2 != null) {
                    eVar.f66226d.addAll(timeSlotList2);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.IJRDataModel>");
                }
            }
        } else if (i2 == 2) {
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            return b.a.a();
        } else if (i2 == 3) {
            b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            return b.a.a(bVar.f66170c);
        }
        b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
        return b.a.a(eVar.f66226d);
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.b.b a(net.one97.paytm.upgradeKyc.kycV3.b.b bVar) {
        String responseCode;
        int i2 = f.f66235b[bVar.f66168a.ordinal()];
        if (i2 == 1) {
            UADPincode uADPincode = (UADPincode) bVar.f66169b;
            if (!(uADPincode == null || (responseCode = uADPincode.getResponseCode()) == null || !p.a(responseCode, "200", true))) {
                b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                ResultType resulttype = bVar.f66169b;
                if (resulttype == null) {
                    k.a();
                }
                return b.a.a(resulttype);
            }
        } else if (i2 == 2) {
            b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            return b.a.a();
        } else if (i2 == 3) {
            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            return b.a.a(bVar.f66170c);
        }
        b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
        ResultType resulttype2 = bVar.f66169b;
        if (resulttype2 == null) {
            k.a();
        }
        return b.a.a(resulttype2);
    }
}
