package net.one97.paytm.upgradeKyc.editprofile.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.home.CkycResponse;
import net.one97.paytm.common.entity.paymentsbank.UADPincode;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails;
import net.one97.paytm.upgradeKyc.editprofile.b.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C1308a f65816b = new C1308a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static a f65817e;

    /* renamed from: a  reason: collision with root package name */
    public Context f65818a;

    /* renamed from: c  reason: collision with root package name */
    private final String f65819c = "KycProfileModel";

    /* renamed from: d  reason: collision with root package name */
    private boolean f65820d;

    public a(Context context) {
        k.c(context, "ctx");
        this.f65818a = context;
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.d f65825a;

        public f(a.d dVar) {
            this.f65825a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof CJRUserInfo) {
                this.f65825a.a((IJRDataModel) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            net.one97.paytm.prime.f.a aVar = new net.one97.paytm.prime.f.a();
            aVar.setAlertMessage(networkCustomError.getAlertMessage());
            aVar.setmAlertTitle(networkCustomError.getAlertTitle());
            aVar.setmErrorCode(networkCustomError.getErrorType().toString());
            aVar.setUniqueReference(networkCustomError.getUniqueReference());
            aVar.setUrl(networkCustomError.getFullUrl());
            this.f65825a.a(networkCustomError);
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.d.a$a  reason: collision with other inner class name */
    public static final class C1308a {
        private C1308a() {
        }

        public /* synthetic */ C1308a(byte b2) {
            this();
        }

        public static a a(Context context) {
            k.c(context, "ctx");
            if (a.f65817e == null) {
                a.f65817e = new a(context);
            }
            return a.f65817e;
        }
    }

    public static void a() {
        f65817e = null;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.d f65821a;

        public b(a.d dVar) {
            this.f65821a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof CJRUserInfoV2) {
                this.f65821a.a((IJRDataModel) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            net.one97.paytm.prime.f.a aVar = new net.one97.paytm.prime.f.a();
            aVar.setAlertMessage(networkCustomError.getAlertMessage());
            aVar.setmAlertTitle(networkCustomError.getAlertTitle());
            aVar.setmErrorCode(networkCustomError.getErrorType().toString());
            aVar.setUniqueReference(networkCustomError.getUniqueReference());
            aVar.setUrl(networkCustomError.getFullUrl());
            this.f65821a.a(networkCustomError);
        }
    }

    public final void a(a.d dVar) {
        k.c(dVar, H5Event.TYPE_CALL_BACK);
        String a2 = net.one97.paytm.common.b.d.b().a("kycFetchProfileInfoV2");
        if (!URLUtil.isValidUrl(a2)) {
            dVar.a();
            return;
        }
        String str = com.paytm.utility.b.e(this.f65818a, a2) + "&fields=cersai";
        Map hashMap = new HashMap();
        String b2 = net.one97.paytm.common.b.d.a().b(this.f65818a);
        k.a((Object) b2, "HomeHelper.getModuleInte…e().getSSOToken(mContext)");
        hashMap.put("session_token", b2);
        com.paytm.network.a a3 = net.one97.paytm.common.b.d.a(this.f65818a, str, new c(dVar), hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRAadharPanGet(), a.c.HOME, a.b.SILENT);
        if (!com.paytm.utility.a.m(this.f65818a)) {
            dVar.a();
        } else if (a3 != null) {
            a3.a();
        } else {
            com.paytm.utility.a.c();
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.d f65822a;

        c(a.d dVar) {
            this.f65822a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
                this.f65822a.a((IJRDataModel) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            net.one97.paytm.prime.f.a aVar = new net.one97.paytm.prime.f.a();
            aVar.setAlertMessage(networkCustomError.getAlertMessage());
            aVar.setmAlertTitle(networkCustomError.getAlertTitle());
            aVar.setmErrorCode(networkCustomError.getErrorType().toString());
            aVar.setUniqueReference(networkCustomError.getUniqueReference());
            aVar.setUrl(networkCustomError.getFullUrl());
            this.f65822a.a(networkCustomError);
        }
    }

    public final void a(CersaiDetails cersaiDetails, a.d dVar) {
        String str;
        RelationShipDetails relationShipDetails;
        RelationShipDetails relationShipDetails2;
        RelationShipDetails relationShipDetails3;
        RelationShipDetails relationShipDetails4;
        k.c(cersaiDetails, "ckycData");
        k.c(dVar, H5Event.TYPE_CALL_BACK);
        String a2 = net.one97.paytm.common.b.d.b().a("URLCersaiAddDetailsSaveAPI");
        if (!URLUtil.isValidUrl(a2)) {
            dVar.a();
            return;
        }
        String e2 = com.paytm.utility.b.e(this.f65818a, a2);
        JSONObject jSONObject = new JSONObject();
        new JSONArray();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(cersaiDetails.getMaritalStatus())) {
                jSONObject2.put("maritalStatus", cersaiDetails.getMaritalStatus());
            }
            if (!TextUtils.isEmpty(cersaiDetails.getProfessionCategory())) {
                jSONObject2.put("professionCategory", cersaiDetails.getProfessionCategory());
            }
            if (!TextUtils.isEmpty(cersaiDetails.getProfession())) {
                jSONObject2.put("profession", cersaiDetails.getProfession());
            }
            if (!TextUtils.isEmpty(cersaiDetails.getAnnualIncome())) {
                jSONObject2.put("annualIncome", cersaiDetails.getAnnualIncome());
            }
            JSONArray jSONArray = new JSONArray();
            if (cersaiDetails.getRelationships() != null) {
                ArrayList<RelationShipDetails> relationships = cersaiDetails.getRelationships();
                Integer valueOf = relationships != null ? Integer.valueOf(relationships.size()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.intValue() > 0) {
                    ArrayList<RelationShipDetails> relationships2 = cersaiDetails.getRelationships();
                    kotlin.j.d a3 = relationships2 != null ? kotlin.a.k.a((Collection<?>) relationships2) : null;
                    if (a3 == null) {
                        k.a();
                    }
                    int i2 = a3.f47939a;
                    int i3 = a3.f47940b;
                    if (i2 <= i3) {
                        while (true) {
                            JSONObject jSONObject3 = new JSONObject();
                            ArrayList<RelationShipDetails> relationships3 = cersaiDetails.getRelationships();
                            if (relationships3 == null) {
                                k.a();
                            }
                            if (!TextUtils.isEmpty(relationships3.get(i2).getAction())) {
                                this.f65820d = true;
                                ArrayList<RelationShipDetails> relationships4 = cersaiDetails.getRelationships();
                                jSONObject3.put("action", (relationships4 == null || (relationShipDetails4 = relationships4.get(i2)) == null) ? null : relationShipDetails4.getAction());
                                ArrayList<RelationShipDetails> relationships5 = cersaiDetails.getRelationships();
                                jSONObject3.put("relationShip", (relationships5 == null || (relationShipDetails3 = relationships5.get(i2)) == null) ? null : relationShipDetails3.getRelationShip());
                                ArrayList<RelationShipDetails> relationships6 = cersaiDetails.getRelationships();
                                jSONObject3.put("firstName", (relationships6 == null || (relationShipDetails2 = relationships6.get(i2)) == null) ? null : relationShipDetails2.getFirstName());
                                ArrayList<RelationShipDetails> relationships7 = cersaiDetails.getRelationships();
                                jSONObject3.put("lastName", (relationships7 == null || (relationShipDetails = relationships7.get(i2)) == null) ? null : relationShipDetails.getLastName());
                                jSONArray.put(jSONObject3);
                            }
                            if (i2 == i3) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
            if (this.f65820d) {
                jSONObject2.put("relationships", jSONArray);
            }
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e3) {
            q.b(e3.getMessage());
        }
        HashMap hashMap = new HashMap();
        String e4 = com.paytm.utility.b.e();
        String f2 = com.paytm.utility.b.f();
        try {
            hashMap.put("x-keyiv", net.one97.paytm.common.utility.f.a(net.one97.paytm.common.b.d.a().E(), e4 + ':' + f2));
        } catch (Exception e5) {
            q.b(e5.getMessage());
        }
        CkycResponse ckycResponse = new CkycResponse((String) null, (String) null, (String) null, (String) null, 15, (g) null);
        ckycResponse.setIv(f2);
        ckycResponse.setKey(e4);
        String jSONObject4 = jSONObject.toString();
        k.a((Object) jSONObject4, "requestBody.toString()");
        q.d(jSONObject4);
        try {
            String a4 = net.one97.paytm.common.utility.f.a(f2, e4, jSONObject4);
            k.a((Object) a4, "KycDataEncryption.encryptRequest(iv, key, body)");
            str = a4;
        } catch (Exception e6) {
            q.b(e6.getMessage());
            str = jSONObject4;
        }
        Map map = hashMap;
        String b2 = net.one97.paytm.common.b.d.a().b(this.f65818a);
        k.a((Object) b2, "HomeHelper.getModuleInte…e().getSSOToken(mContext)");
        map.put("session_token", b2);
        map.put("Content-Type", "application/json");
        com.paytm.network.a a5 = net.one97.paytm.common.b.d.a(this.f65818a, e2, new e(dVar), map, (Map<String, String>) null, a.C0715a.POST, str, ckycResponse, a.c.HOME, a.b.SILENT);
        if (!com.paytm.utility.a.m(this.f65818a)) {
            dVar.a();
        } else if (a5 != null) {
            a5.a();
        } else {
            com.paytm.utility.a.c();
        }
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.d f65824a;

        e(a.d dVar) {
            this.f65824a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof IJRDataModel) {
                this.f65824a.a((IJRDataModel) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            net.one97.paytm.prime.f.a aVar = new net.one97.paytm.prime.f.a();
            aVar.setAlertMessage(networkCustomError.getAlertMessage());
            aVar.setmAlertTitle(networkCustomError.getAlertTitle());
            aVar.setmErrorCode(networkCustomError.getErrorType().toString());
            aVar.setUniqueReference(networkCustomError.getUniqueReference());
            aVar.setUrl(networkCustomError.getFullUrl());
            this.f65824a.a(networkCustomError);
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.d f65823a;

        public d(a.d dVar) {
            this.f65823a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof UADPincode) {
                this.f65823a.a((IJRDataModel) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            net.one97.paytm.prime.f.a aVar = new net.one97.paytm.prime.f.a();
            aVar.setAlertMessage(networkCustomError.getAlertMessage());
            aVar.setmAlertTitle(networkCustomError.getAlertTitle());
            aVar.setmErrorCode(networkCustomError.getErrorType().toString());
            aVar.setUniqueReference(networkCustomError.getUniqueReference());
            aVar.setUrl(networkCustomError.getFullUrl());
            this.f65823a.a(networkCustomError);
        }
    }
}
