package com.paytm.business.c.a;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import com.business.merchant_payments.notificationsettings.model.NotificationsSettingsDataModel;
import com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel;
import com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider;
import com.business.merchant_payments.notificationsettings.repository.NotificationsRepository;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import kotlin.g.b.l;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public static final C0710a f42663a = new C0710a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public final String f42664b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42665c = SDKConstants.ALL_TYPE;

    /* renamed from: d  reason: collision with root package name */
    public final kotlin.g f42666d = kotlin.h.a(d.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.g f42667e = kotlin.h.a(g.INSTANCE);

    /* renamed from: f  reason: collision with root package name */
    public final kotlin.g f42668f = kotlin.h.a(j.INSTANCE);

    /* renamed from: g  reason: collision with root package name */
    public final kotlin.g f42669g = kotlin.h.a(b.INSTANCE);

    /* renamed from: h  reason: collision with root package name */
    public String f42670h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42671i;
    public final kotlin.g j = kotlin.h.a(f.INSTANCE);
    public final kotlin.g k = kotlin.h.a(e.INSTANCE);
    public final kotlin.g l = kotlin.h.a(i.INSTANCE);
    public final kotlin.g m = kotlin.h.a(c.INSTANCE);
    public LiveData<com.business.common_module.utilities.a.b<NotificationsSettingsDataModel>> n;
    public LiveData<com.business.common_module.utilities.a.b<NotificationOnOffDataModel>> o;
    public ArrayList<NotificationReceiverModel> p;
    public ArrayList<NotificationReceiverModel> q;

    private final y<Boolean> k() {
        return (y) this.f42668f.getValue();
    }

    public final y<Boolean> a() {
        return (y) this.f42666d.getValue();
    }

    public final y<Integer> b() {
        return (y) this.f42669g.getValue();
    }

    public final y<Boolean> c() {
        return (y) this.j.getValue();
    }

    public final y<Boolean> d() {
        return (y) this.k.getValue();
    }

    public final y<String> e() {
        return (y) this.l.getValue();
    }

    public final y<String> f() {
        return (y) this.m.getValue();
    }

    public static final class h<I, O> implements androidx.arch.core.c.a<Boolean, LiveData<com.business.common_module.utilities.a.b<NotificationsSettingsDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42672a;

        public h(a aVar) {
            this.f42672a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.b(bool, "flag");
            if (bool.booleanValue()) {
                return NotificationsRepository.INSTANCE.getNotificationSettings(this.f42672a.f42665c);
            }
            return com.business.common_module.utilities.a.a.a();
        }
    }

    public static final class k<I, O> implements androidx.arch.core.c.a<Boolean, LiveData<com.business.common_module.utilities.a.b<NotificationOnOffDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42673a;

        public k(a aVar) {
            this.f42673a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.b(bool, "flag");
            if (bool.booleanValue()) {
                return NotificationsRepository.INSTANCE.updateNotificationSettings(this.f42673a.f42670h);
            }
            return com.business.common_module.utilities.a.a.a();
        }
    }

    public a() {
        String simpleName = a.class.getSimpleName();
        kotlin.g.b.k.b(simpleName, "MpNotificationViewModel::class.java.simpleName");
        this.f42664b = simpleName;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
        this.f42671i = instance.getMerchantDataProvider().s();
        LiveData<com.business.common_module.utilities.a.b<NotificationsSettingsDataModel>> b2 = ah.b(a(), new h(this));
        kotlin.g.b.k.b(b2, "Transformations.switchMa….create()\n        }\n    }");
        this.n = b2;
        LiveData<com.business.common_module.utilities.a.b<NotificationOnOffDataModel>> b3 = ah.b(k(), new k(this));
        kotlin.g.b.k.b(b3, "Transformations.switchMa…create()\n        }\n\n    }");
        this.o = b3;
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
    }

    public static final class d extends l implements kotlin.g.a.a<y<Boolean>> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        public final y<Boolean> invoke() {
            return new y<>();
        }
    }

    public static final class g extends l implements kotlin.g.a.a<y<Boolean>> {
        public static final g INSTANCE = new g();

        public g() {
            super(0);
        }

        public final y<Boolean> invoke() {
            return new y<>(Boolean.TRUE);
        }
    }

    public static final class j extends l implements kotlin.g.a.a<y<Boolean>> {
        public static final j INSTANCE = new j();

        public j() {
            super(0);
        }

        public final y<Boolean> invoke() {
            return new y<>();
        }
    }

    public static final class b extends l implements kotlin.g.a.a<y<Integer>> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        public final y<Integer> invoke() {
            return new y<>();
        }
    }

    /* renamed from: com.paytm.business.c.a.a$a  reason: collision with other inner class name */
    public static final class C0710a {
        public C0710a() {
        }

        public /* synthetic */ C0710a(byte b2) {
            this();
        }
    }

    public static final class f extends l implements kotlin.g.a.a<y<Boolean>> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        public final y<Boolean> invoke() {
            return new y<>(Boolean.FALSE);
        }
    }

    public static final class e extends l implements kotlin.g.a.a<y<Boolean>> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        public final y<Boolean> invoke() {
            return new y<>(Boolean.FALSE);
        }
    }

    public static final class i extends l implements kotlin.g.a.a<y<String>> {
        public static final i INSTANCE = new i();

        public i() {
            super(0);
        }

        public final y<String> invoke() {
            return new y<>();
        }
    }

    public static final class c extends l implements kotlin.g.a.a<y<String>> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        public final y<String> invoke() {
            return new y<>();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r11 = r1.getTransaction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "event"
            com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider r1 = com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider.INSTANCE
            com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel r1 = r1.getNotificationSettings()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r5 = 0
            java.lang.String r6 = "smsAllowed"
            java.lang.String r7 = "emailAllowed"
            r8 = 1
            if (r11 == r8) goto L_0x0049
            r8 = 2
            if (r11 != r8) goto L_0x006f
            r3.put(r6, r10)     // Catch:{ JSONException -> 0x007a }
            if (r1 == 0) goto L_0x0032
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r11 = r1.getTransaction()     // Catch:{ JSONException -> 0x007a }
            if (r11 == 0) goto L_0x0032
            boolean r11 = r11.getEmailAllowed()     // Catch:{ JSONException -> 0x007a }
            goto L_0x0033
        L_0x0032:
            r11 = 0
        L_0x0033:
            r3.put(r7, r11)     // Catch:{ JSONException -> 0x007a }
            if (r1 == 0) goto L_0x0042
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r11 = r1.getRefund()     // Catch:{ JSONException -> 0x007a }
            if (r11 == 0) goto L_0x0042
            boolean r5 = r11.getEmailAllowed()     // Catch:{ JSONException -> 0x007a }
        L_0x0042:
            r4.put(r7, r5)     // Catch:{ JSONException -> 0x007a }
            r4.put(r6, r10)     // Catch:{ JSONException -> 0x007a }
            goto L_0x006f
        L_0x0049:
            r3.put(r7, r10)     // Catch:{ JSONException -> 0x007a }
            if (r1 == 0) goto L_0x0059
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r11 = r1.getTransaction()     // Catch:{ JSONException -> 0x007a }
            if (r11 == 0) goto L_0x0059
            boolean r11 = r11.getSmsAllowed()     // Catch:{ JSONException -> 0x007a }
            goto L_0x005a
        L_0x0059:
            r11 = 0
        L_0x005a:
            r3.put(r6, r11)     // Catch:{ JSONException -> 0x007a }
            r4.put(r7, r10)     // Catch:{ JSONException -> 0x007a }
            if (r1 == 0) goto L_0x006c
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r10 = r1.getRefund()     // Catch:{ JSONException -> 0x007a }
            if (r10 == 0) goto L_0x006c
            boolean r5 = r10.getSmsAllowed()     // Catch:{ JSONException -> 0x007a }
        L_0x006c:
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x007a }
        L_0x006f:
            java.lang.String r10 = "SUCCESS"
            r3.put(r0, r10)     // Catch:{ JSONException -> 0x007a }
            java.lang.String r10 = "BOTH"
            r4.put(r0, r10)     // Catch:{ JSONException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r10 = move-exception
            r10.printStackTrace()
        L_0x007e:
            java.lang.String r10 = "transaction"
            r2.put(r10, r3)
            java.lang.String r10 = "refund"
            r2.put(r10, r4)
            java.lang.String r10 = r2.toString()
            r9.f42670h = r10
            r9.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.c.a.a.a(boolean, int):void");
    }

    public final void g() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
        if (com.business.common_module.utilities.i.a(instance.getApplication())) {
            k().setValue(Boolean.TRUE);
            return;
        }
        b().setValue(10);
        j();
    }

    public static void h() {
        NotificationSettingsDataProvider.INSTANCE.setNotificationSettings(new NotificationOnOffDataModel(new SmsEmailOnOffDataModel("", false, false), new SmsEmailOnOffDataModel("", false, false)));
    }

    public final String i() {
        ArrayList<NotificationReceiverModel> arrayList = this.q;
        if (arrayList.size() <= 1) {
            return "";
        }
        int size = arrayList.size();
        String str = "";
        for (int i2 = 1; i2 < size; i2++) {
            if (i2 == 1) {
                str = arrayList.get(i2).getReceiverString();
            } else {
                str = kotlin.g.b.k.a(str, (Object) AppConstants.COMMA + arrayList.get(i2).getReceiverString());
            }
        }
        return str;
    }

    public final void a(int i2) {
        if (i2 == 1) {
            d().setValue(Boolean.TRUE);
        } else if (i2 == 2) {
            c().setValue(Boolean.TRUE);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (((r0 == null || (r0 = r0.getRefund()) == null) ? false : r0.getSmsAllowed()) == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r3 = r0.getTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r5 = this;
            com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider r0 = com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider.INSTANCE
            com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel r0 = r0.getNotificationSettings()
            androidx.lifecycle.y r1 = r5.d()
            r2 = 0
            if (r0 == 0) goto L_0x0018
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r3 = r0.getTransaction()
            if (r3 == 0) goto L_0x0018
            boolean r3 = r3.getEmailAllowed()
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            r4 = 1
            if (r3 != 0) goto L_0x002e
            if (r0 == 0) goto L_0x0029
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r3 = r0.getRefund()
            if (r3 == 0) goto L_0x0029
            boolean r3 = r3.getEmailAllowed()
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r3 != 0) goto L_0x002e
            r3 = 0
            goto L_0x002f
        L_0x002e:
            r3 = 1
        L_0x002f:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r1.setValue(r3)
            androidx.lifecycle.y r1 = r5.c()
            if (r0 == 0) goto L_0x0047
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r3 = r0.getTransaction()
            if (r3 == 0) goto L_0x0047
            boolean r3 = r3.getSmsAllowed()
            goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            if (r3 != 0) goto L_0x005b
            if (r0 == 0) goto L_0x0057
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r0 = r0.getRefund()
            if (r0 == 0) goto L_0x0057
            boolean r0 = r0.getSmsAllowed()
            goto L_0x0058
        L_0x0057:
            r0 = 0
        L_0x0058:
            if (r0 != 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r2 = 1
        L_0x005c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r1.setValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.c.a.a.j():void");
    }
}
