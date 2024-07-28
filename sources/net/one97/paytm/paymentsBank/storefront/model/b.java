package net.one97.paytm.paymentsBank.storefront.model;

import android.app.Application;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmoney.lite.mod.util.PMConstants;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.common.entity.CJRAadharPanDocList;
import net.one97.paytm.common.entity.CJRAadharPanGet;

public final class b extends androidx.lifecycle.a implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public final String f19420a = "STOREFRONT_API_POST_REQUEST";

    /* renamed from: b  reason: collision with root package name */
    public y<StoreFrontRootResponse> f19421b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<List<StoreFrontViews>> f19422c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f19423d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<c<Object>> f19424e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<c<Object>> f19425f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public final Application f19426g;

    /* renamed from: net.one97.paytm.paymentsBank.storefront.model.b$b  reason: collision with other inner class name */
    public static final class C0347b implements g.a {
        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fb, code lost:
        if (kotlin.m.p.a(r0.get(0).getRelationShip(), "MOTHER", false) != false) goto L_0x00fd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onResponse(java.lang.Object r6) {
        /*
            r5 = this;
            com.paytm.network.model.IJRPaytmDataModel r6 = (com.paytm.network.model.IJRPaytmDataModel) r6
            boolean r0 = r6 instanceof net.one97.paytm.paymentsBank.storefront.model.StoreFrontRootResponse
            if (r0 == 0) goto L_0x0011
            androidx.lifecycle.y<net.one97.paytm.paymentsBank.storefront.model.StoreFrontRootResponse> r0 = r5.f19421b
            if (r0 != 0) goto L_0x000d
            kotlin.g.b.k.a()
        L_0x000d:
            r0.postValue(r6)
            return
        L_0x0011:
            boolean r0 = r6 instanceof net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2
            if (r0 == 0) goto L_0x003f
            net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2 r6 = (net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2) r6
            net.one97.paytm.bankCommon.model.auth.CJRUserDefaultInfo r0 = r6.getUserDefaultInfo()
            if (r0 == 0) goto L_0x0149
            net.one97.paytm.bankCommon.model.auth.CJRUserDefaultInfo r6 = r6.getUserDefaultInfo()
            java.lang.String r0 = "userInfoV2.userDefaultInfo"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            java.lang.String r6 = r6.getEmail()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0149
            androidx.lifecycle.y<java.lang.Boolean> r6 = r5.f19423d
            if (r6 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r6.postValue(r0)
            return
        L_0x003f:
            boolean r0 = r6 instanceof net.one97.paytm.common.entity.CJRAadharPanGet
            if (r0 == 0) goto L_0x0149
            net.one97.paytm.common.entity.CJRAadharPanGet r6 = (net.one97.paytm.common.entity.CJRAadharPanGet) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            if (r0 == 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.lang.String r0 = r0.getProfession()
            if (r0 == 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.lang.String r0 = r0.getProfession()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x006d
            r0 = 1
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            if (r0 != 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.lang.String r0 = r0.getMaritalStatus()
            if (r0 == 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.lang.String r0 = r0.getMaritalStatus()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0090
            r0 = 1
            goto L_0x0091
        L_0x0090:
            r0 = 0
        L_0x0091:
            if (r0 != 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.util.ArrayList r0 = r0.getRelationships()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x00a8
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r0 = 0
            goto L_0x00a9
        L_0x00a8:
            r0 = 1
        L_0x00a9:
            if (r0 != 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 != 0) goto L_0x00b8
            kotlin.g.b.k.a()
        L_0x00b8:
            int r0 = r0.size()
            r3 = 2
            if (r0 < r3) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 != 0) goto L_0x00cc
            kotlin.g.b.k.a()
        L_0x00cc:
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r0 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r0
            java.lang.String r0 = r0.getRelationShip()
            java.lang.String r3 = "FATHER"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            java.lang.String r4 = "MOTHER"
            if (r0 != 0) goto L_0x00fd
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 != 0) goto L_0x00ed
            kotlin.g.b.k.a()
        L_0x00ed:
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r0 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r0
            java.lang.String r0 = r0.getRelationShip()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r2)
            if (r0 == 0) goto L_0x0137
        L_0x00fd:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r6.getCersaiInfo()
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 != 0) goto L_0x010a
            kotlin.g.b.k.a()
        L_0x010a:
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r0 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r0
            java.lang.String r0 = r0.getRelationShip()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r0 != 0) goto L_0x0149
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r6.getCersaiInfo()
            java.util.ArrayList r6 = r6.getRelationships()
            if (r6 != 0) goto L_0x0127
            kotlin.g.b.k.a()
        L_0x0127:
            java.lang.Object r6 = r6.get(r1)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r6 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r6
            java.lang.String r6 = r6.getRelationShip()
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r4, (boolean) r2)
            if (r6 != 0) goto L_0x0149
        L_0x0137:
            androidx.lifecycle.y<net.one97.paytm.bankCommon.b.c<java.lang.Object>> r6 = r5.f19424e
            if (r6 != 0) goto L_0x013e
            kotlin.g.b.k.a()
        L_0x013e:
            net.one97.paytm.bankCommon.b.c$a r0 = net.one97.paytm.bankCommon.b.c.f16215d
            java.lang.String r0 = "true"
            net.one97.paytm.bankCommon.b.c r0 = net.one97.paytm.bankCommon.b.c.a.a(r0)
            r6.postValue(r0)
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.storefront.model.b.onResponse(java.lang.Object):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "applicationContext");
        this.f19426g = application;
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof StoreFrontRootResponse) {
            y<StoreFrontRootResponse> yVar = this.f19421b;
            if (yVar == null) {
                k.a();
            }
            yVar.postValue(iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
            c.a aVar = c.f16215d;
            if (networkCustomError == null) {
                k.a();
            }
            c a2 = c.a.a((Throwable) networkCustomError);
            y<c<Object>> yVar2 = this.f19424e;
            if (yVar2 == null) {
                k.a();
            }
            yVar2.postValue(a2);
        }
    }

    public static final class a implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19427a;

        public a(b bVar) {
            this.f19427a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            boolean z = false;
            if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
                CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRPaytmDataModel;
                if (cJRAadharPanGet.getDocuments() != null) {
                    for (CJRAadharPanDocList next : cJRAadharPanGet.getDocuments()) {
                        k.a((Object) next, PMConstants.UploadTypes.DOC);
                        if (k.a((Object) next.getDocCode(), (Object) "aadhar") && !TextUtils.isEmpty(next.getDocValue())) {
                            z = true;
                        }
                    }
                }
            }
            y<c<Object>> yVar = this.f19427a.f19425f;
            c.a aVar = c.f16215d;
            yVar.postValue(c.a.a(new a(z)));
        }
    }
}
