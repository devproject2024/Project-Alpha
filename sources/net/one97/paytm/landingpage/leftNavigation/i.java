package net.one97.paytm.landingpage.leftNavigation;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import net.one97.paytm.common.entity.paymentsbank.CJRAccountSummary;
import net.one97.paytm.landingpage.leftNavigation.model.CJRBankInfo;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;

public final class i extends androidx.lifecycle.a implements com.paytm.network.listener.b, net.one97.paytm.landingpage.c.b, a.C1382a, a.C1389a {

    /* renamed from: a  reason: collision with root package name */
    final y<String> f52863a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    y<net.one97.paytm.landingpage.leftNavigation.model.a> f52864b = new y<>();
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final y<CJRBankInfo> f52865c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    final y<CJRAccountSummary> f52866d = new y<>();
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public final y<SanitizedResponseModel> f52867e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    final f f52868f;

    /* renamed from: g  reason: collision with root package name */
    final g f52869g;

    /* renamed from: h  reason: collision with root package name */
    final LiveData<net.one97.paytm.upgradeKyc.editprofile.gallery.b<Boolean>> f52870h;

    /* renamed from: i  reason: collision with root package name */
    final LiveData<net.one97.paytm.upgradeKyc.editprofile.gallery.b<String>> f52871i;
    /* access modifiers changed from: private */
    public final y<SanitizedResponseModel> j = new y<>();
    /* access modifiers changed from: private */
    public final y<SanitizedResponseModel> k = new y<>();
    private boolean l;
    private final y<String> m;
    private final y<Boolean> n;
    private final Application o;

    public final void b(String str) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.o = application;
        Context applicationContext = this.o.getApplicationContext();
        k.a((Object) applicationContext, "app.applicationContext");
        this.f52868f = new f(applicationContext);
        this.f52869g = h.a(new e(this));
        this.m = new y<>();
        this.n = new y<>();
        this.f52870h = net.one97.paytm.upgradeKyc.editprofile.gallery.c.a(this.n);
        this.f52871i = net.one97.paytm.upgradeKyc.editprofile.gallery.c.a(this.m);
    }

    static final class e extends l implements kotlin.g.a.a<w<SanitizedResponseModel>> {
        final /* synthetic */ i this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(i iVar) {
            super(0);
            this.this$0 = iVar;
        }

        public final w<SanitizedResponseModel> invoke() {
            final w<SanitizedResponseModel> wVar = new w<>();
            wVar.addSource(this.this$0.f52867e, new z<S>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    wVar.setValue((SanitizedResponseModel) obj);
                }
            });
            wVar.addSource(this.this$0.j, new z<S>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    wVar.setValue((SanitizedResponseModel) obj);
                }
            });
            return wVar;
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f52864b.setValue(new net.one97.paytm.landingpage.leftNavigation.model.a(i2, networkCustomError, iJRPaytmDataModel));
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBankInfo) {
            this.f52865c.setValue(iJRPaytmDataModel);
        }
        if (iJRPaytmDataModel instanceof CJRAccountSummary) {
            this.f52866d.setValue(iJRPaytmDataModel);
        }
    }

    public final void a(String str) {
        this.f52863a.setValue(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c4, code lost:
        if (r7 == false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c6, code lost:
        r3 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel r7) {
        /*
            r6 = this;
            java.lang.String r0 = "baseDataModel"
            kotlin.g.b.k.c(r7, r0)
            boolean r0 = r7 instanceof net.one97.paytm.upi.common.models.UpiAvailabilityModel
            java.lang.String r1 = "baseDataModel.response"
            if (r0 == 0) goto L_0x0051
            r0 = r7
            net.one97.paytm.upi.common.models.UpiAvailabilityModel r0 = (net.one97.paytm.upi.common.models.UpiAvailabilityModel) r0
            net.one97.paytm.upi.common.models.UpiAvailabilityModel$UpiAvailabilityResponse r2 = r0.getResponse()
            if (r2 == 0) goto L_0x0051
            net.one97.paytm.upi.common.models.UpiAvailabilityModel$UpiAvailabilityResponse r2 = r0.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            boolean r2 = r2.isUpiUser()
            r6.l = r2
            net.one97.paytm.upi.common.models.UpiAvailabilityModel$UpiAvailabilityResponse r2 = r0.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            boolean r2 = r2.isUpiUser()
            if (r2 == 0) goto L_0x004a
            net.one97.paytm.upi.common.models.UpiAvailabilityModel$UpiAvailabilityResponse r0 = r0.getResponse()
            boolean r0 = r0.ismBankAccountAdded()
            if (r0 == 0) goto L_0x004a
            r6.getApplication()
            net.one97.paytm.upi.profile.b.b r0 = net.one97.paytm.upi.g.a()
            r2 = r6
            net.one97.paytm.upi.profile.b.a$a r2 = (net.one97.paytm.upi.profile.b.a.C1382a) r2
            java.lang.String r3 = "javaClass"
            java.lang.String r4 = ""
            r0.a((net.one97.paytm.upi.profile.b.a.C1382a) r2, (java.lang.String) r3, (java.lang.String) r4)
            goto L_0x0051
        L_0x004a:
            androidx.lifecycle.y<java.lang.Boolean> r0 = r6.n
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.setValue(r2)
        L_0x0051:
            boolean r0 = r7 instanceof net.one97.paytm.upi.common.upi.UpiProfileModel
            if (r0 == 0) goto L_0x00d4
            net.one97.paytm.upi.common.upi.UpiProfileModel r7 = (net.one97.paytm.upi.common.upi.UpiProfileModel) r7
            net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r7.getResponse()
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = r7.getStatus()
            r2 = 1
            java.lang.String r3 = "success"
            boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r2)
            if (r0 == 0) goto L_0x00d4
            net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r7.getResponse()
            if (r0 == 0) goto L_0x00d4
            net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r7.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
            java.lang.String r3 = "baseDataModel.response.profileDetail"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.util.ArrayList r0 = r0.getBankAccountList()
            if (r0 == 0) goto L_0x00d4
            java.util.ArrayList r0 = new java.util.ArrayList
            net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r7 = r7.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r7 = r7.getProfileDetail()
            java.lang.String r1 = "baseDataModel.response\n …           .profileDetail"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            java.util.List r7 = r7.getProfileVpaList()
            java.util.Collection r7 = (java.util.Collection) r7
            r0.<init>(r7)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r7 = 0
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r3 = r1
        L_0x00ab:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00c4
            java.lang.Object r4 = r0.next()
            r5 = r4
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r5
            boolean r5 = r5.isPrimary()
            if (r5 == 0) goto L_0x00ab
            if (r7 == 0) goto L_0x00c1
            goto L_0x00c6
        L_0x00c1:
            r3 = r4
            r7 = 1
            goto L_0x00ab
        L_0x00c4:
            if (r7 != 0) goto L_0x00c7
        L_0x00c6:
            r3 = r1
        L_0x00c7:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r3
            androidx.lifecycle.y<java.lang.String> r7 = r6.m
            if (r3 == 0) goto L_0x00d1
            java.lang.String r1 = r3.getVirtualAddress()
        L_0x00d1:
            r7.setValue(r1)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.leftNavigation.i.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void");
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError != null) {
            upiCustomVolleyError.printStackTrace();
        }
    }

    public final void a() {
        net.one97.paytm.common.b.d.a().a((Context) getApplication(), (net.one97.paytm.landingpage.c.b) this);
    }

    public static final class d implements net.one97.paytm.common.b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f52874a;

        d(i iVar) {
            this.f52874a = iVar;
        }

        public final void a(Integer num, String str) {
            this.f52874a.f52865c.setValue(new CJRBankInfo(num, str));
        }
    }

    public final void b() {
        net.one97.paytm.common.b.d.a().a((Context) getApplication(), (net.one97.paytm.common.b.c) new d(this));
    }

    public final void c() {
        SFInterface sFInterface = SFInterface.INSTANCE;
        h hVar = h.f52857a;
        Context applicationContext = this.o.getApplicationContext();
        k.a((Object) applicationContext, "app.applicationContext");
        sFInterface.getStoreFrontReponse(h.a(applicationContext), new HashMap(), a.c.HOME, new a(this), "/", 1005, new b());
    }

    static final class a implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f52872a;

        a(i iVar) {
            this.f52872a = iVar;
        }

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                this.f52872a.j.setValue(sanitizedResponseModel);
                b bVar = b.f52831a;
                b.a(sanitizedResponseModel);
            }
        }
    }

    public static final class b implements IGAEnableListener {
        public final boolean isGAEnabled() {
            return true;
        }

        b() {
        }
    }

    public final void d() {
        SFInterface sFInterface = SFInterface.INSTANCE;
        h hVar = h.f52857a;
        Context applicationContext = this.o.getApplicationContext();
        k.a((Object) applicationContext, "app.applicationContext");
        sFInterface.getRefreshableResponse(h.a(applicationContext), new HashMap(), a.c.HOME, new c(this));
    }

    static final class c implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f52873a;

        c(i iVar) {
            this.f52873a = iVar;
        }

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                this.f52873a.k.setValue(sanitizedResponseModel);
                i.a(this.f52873a.j, this.f52873a.k);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        getApplication();
        this.o.getApplicationContext();
        net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).e(this, "", "javaClass");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x003a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(androidx.lifecycle.y r13, androidx.lifecycle.y r14) {
        /*
            java.lang.Object r0 = r13.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type com.paytmmall.clpartifact.modal.SanitizedResponseModel"
            if (r0 == 0) goto L_0x00ba
            com.paytmmall.clpartifact.modal.SanitizedResponseModel r0 = (com.paytmmall.clpartifact.modal.SanitizedResponseModel) r0
            java.lang.Object r14 = r14.getValue()
            if (r14 == 0) goto L_0x00b4
            com.paytmmall.clpartifact.modal.SanitizedResponseModel r14 = (com.paytmmall.clpartifact.modal.SanitizedResponseModel) r14
            java.util.List r1 = r14.getRvWidgets()
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = com.google.android.gms.common.util.f.a(r1)
            if (r1 != 0) goto L_0x00b3
            java.util.List r1 = r0.getRvWidgets()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View> /* = java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View> */"
            if (r1 == 0) goto L_0x00ad
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.List r14 = r14.getRvWidgets()
            if (r14 == 0) goto L_0x00a7
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            r2 = r14
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r3 = 1
            r4 = 0
            r5 = 0
        L_0x003a:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0086
            java.lang.Object r6 = r2.next()
            com.paytmmall.clpartifact.modal.clpCommon.View r6 = (com.paytmmall.clpartifact.modal.clpCommon.View) r6
            r7 = r1
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0065
            r8 = r7
            java.util.Collection r8 = (java.util.Collection) r8
            int r8 = r8.size()
            r9 = 0
        L_0x0053:
            if (r9 >= r8) goto L_0x0065
            java.lang.Object r10 = r7.get(r9)
            com.paytmmall.clpartifact.modal.clpCommon.View r10 = (com.paytmmall.clpartifact.modal.clpCommon.View) r10
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r6)
            if (r10 == 0) goto L_0x0062
            goto L_0x0066
        L_0x0062:
            int r9 = r9 + 1
            goto L_0x0053
        L_0x0065:
            r9 = -1
        L_0x0066:
            if (r9 < 0) goto L_0x003a
            r1.remove(r9)
            java.util.List r6 = r6.getItems()
            int r6 = r6.size()
            if (r6 == 0) goto L_0x003a
            int r6 = r14.size()
            if (r9 >= r6) goto L_0x003a
            if (r1 == 0) goto L_0x0084
            java.lang.Object r5 = r14.get(r9)
            r1.add(r9, r5)
        L_0x0084:
            r5 = 1
            goto L_0x003a
        L_0x0086:
            if (r5 == 0) goto L_0x00b3
            com.paytmmall.clpartifact.modal.SanitizedResponseModel r14 = new com.paytmmall.clpartifact.modal.SanitizedResponseModel
            r7 = r1
            java.util.List r7 = (java.util.List) r7
            java.util.LinkedHashMap r8 = r0.getSfWidgets()
            java.lang.String r9 = r0.getAdRequestId()
            java.lang.String r10 = r0.getVerticalName()
            r11 = 1005(0x3ed, float:1.408E-42)
            com.paytmmall.clpartifact.listeners.IGAEnableListener r12 = r0.getGaEnableListener()
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r13.setValue(r14)
            goto L_0x00b3
        L_0x00a7:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r2)
            throw r13
        L_0x00ad:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r2)
            throw r13
        L_0x00b3:
            return
        L_0x00b4:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r1)
            throw r13
        L_0x00ba:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r1)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.leftNavigation.i.a(androidx.lifecycle.y, androidx.lifecycle.y):void");
    }
}
