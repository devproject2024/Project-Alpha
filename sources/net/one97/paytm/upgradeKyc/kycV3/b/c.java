package net.one97.paytm.upgradeKyc.kycV3.b;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.upgradeKyc.Address;
import net.one97.paytm.common.entity.upgradeKyc.AppointmentSlots;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.CersaiSaveKycResponse;
import net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress;
import net.one97.paytm.common.entity.upgradeKyc.DocData;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.Form60Data;
import net.one97.paytm.common.entity.upgradeKyc.Form60Model;
import net.one97.paytm.common.entity.upgradeKyc.KYCWaitTimeResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP;
import net.one97.paytm.common.entity.upgradeKyc.KycCheckDoc;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.entity.upgradeKyc.PostAppointmentResponse;
import net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.common.entity.upgradeKyc.VideoKYCLeadResponse;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.MyOrderApiResponse;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.AadhaarOtpActivity;
import net.one97.paytm.upgradeKyc.activity.BankProfileActivity;
import net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity;
import net.one97.paytm.upgradeKyc.activity.PanUpdateActivity;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarOtpActivity;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycSlotPickerActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f66172c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static c f66173d;

    /* renamed from: a  reason: collision with root package name */
    public a f66174a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f66175b;

    public c(Context context) {
        kotlin.g.b.k.c(context, "appContext");
        this.f66175b = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final LiveData<b<UADPincode>> a(String str) {
        String str2;
        String str3;
        kotlin.g.b.k.c(str, AddEditGstinViewModelKt.BODY_PARAM_PINCODE);
        y yVar = new y();
        b.a aVar = b.f66167d;
        yVar.setValue(b.a.a());
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar3 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() == null) {
                kotlin.g.b.k.a();
            }
            str2 = net.one97.paytm.upgradeKyc.helper.d.a("uadPincode");
        } else {
            str2 = null;
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        String a2 = com.paytm.utility.d.a(this.f66175b);
        kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(appContext)");
        hashMap.put("session_token", a2);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("pincodes", jSONArray);
            jSONObject.put("addressResponseType", "SECONDARY");
            jSONObject.put("tier3Type", "UNIQUE");
            str3 = jSONObject.toString();
            kotlin.g.b.k.a((Object) str3, "jsonObject.toString()");
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
            str3 = "";
        }
        UADPincode uADPincode = new UADPincode();
        uADPincode.setPincode(str);
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) uADPincode).a(a.c.KYC).c(KycSlotPickerActivity.class.getName()).b(str3).a(str2).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new w(yVar)).l();
        if (com.paytm.utility.b.c(this.f66175b)) {
            l2.a();
        } else {
            b.a aVar5 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
        return yVar;
    }

    public static final class w implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66197a;

        w(y yVar) {
            this.f66197a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof UADPincode) {
                y yVar = this.f66197a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66197a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class v implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66196a;

        public v(y yVar) {
            this.f66196a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof AppointmentSlots) {
                y yVar = this.f66196a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66196a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class n implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66188a;

        public n(y yVar) {
            this.f66188a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof PostAppointmentResponse) {
                y yVar = this.f66188a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
                com.paytm.utility.q.d(iJRPaytmDataModel.toString());
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66188a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class l implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66186a;

        public l(y yVar) {
            this.f66186a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            y yVar = this.f66186a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66186a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class o implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66189a;

        public o(y yVar) {
            this.f66189a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof PayTMPartnerListModal) {
                y yVar = this.f66189a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66189a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66178a;

        public d(y yVar) {
            this.f66178a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof PostAppointmentResponse) {
                y yVar = this.f66178a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66178a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class j implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66184a;

        public j(y yVar) {
            this.f66184a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KycSavedUserData) {
                y yVar = this.f66184a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66184a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class g implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66181a;

        g(y yVar) {
            this.f66181a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KYCFetchTnc) {
                y yVar = this.f66181a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66181a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final LiveData<b<KYCTncAccept>> a(int i2, String str) {
        String str2;
        kotlin.g.b.k.c(str, "tncCode");
        y yVar = new y();
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() == null) {
                kotlin.g.b.k.a();
            }
            str2 = net.one97.paytm.upgradeKyc.helper.d.a("kyc_tnc_user_url");
        } else {
            str2 = null;
        }
        if (!URLUtil.isValidUrl(str2)) {
            b.a aVar3 = b.f66167d;
            yVar.setValue(b.a.a());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "clickthrough");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", str);
            jSONObject2.put("version", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put("tnCList", jSONArray);
        } catch (JSONException e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
        String jSONObject3 = jSONObject.toString();
        kotlin.g.b.k.a((Object) jSONObject3, "requestBody.toString()");
        com.paytm.utility.q.d(jSONObject3);
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        Map<String, String> a2 = a.C1317a.a(this.f66175b);
        a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a3 = a.C1317a.a();
        e.a aVar6 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        com.paytm.network.a l2 = a3.a(e.a.b().a()).a(a.C0715a.PUT).a(a2).a((IJRPaytmDataModel) new KYCTncAccept()).c(Form60Model.class.getName()).b(jSONObject3).a(str2).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new t(yVar)).l();
        if (com.paytm.utility.b.c(this.f66175b)) {
            b.a aVar7 = b.f66167d;
            yVar.setValue(b.a.a());
            l2.a();
        } else {
            b.a aVar8 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
        return yVar;
    }

    public static final class t implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66194a;

        t(y yVar) {
            this.f66194a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KYCTncAccept) {
                y yVar = this.f66194a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66194a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A[Catch:{ JSONException -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<net.one97.paytm.common.entity.auth.KYCTncAccept>> a(java.util.ArrayList<net.one97.paytm.common.entity.auth.TncData> r9) {
        /*
            r8 = this;
            androidx.lifecycle.y r0 = new androidx.lifecycle.y
            r0.<init>()
            net.one97.paytm.upgradeKyc.helper.d$a r1 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r1 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r1 == 0) goto L_0x001f
            net.one97.paytm.upgradeKyc.helper.d$a r1 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r1 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r1 != 0) goto L_0x0018
            kotlin.g.b.k.a()
        L_0x0018:
            java.lang.String r1 = "kyc_tnc_user_url"
            java.lang.String r1 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r1)
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            boolean r2 = android.webkit.URLUtil.isValidUrl(r1)
            if (r2 != 0) goto L_0x002f
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            net.one97.paytm.upgradeKyc.kycV3.b.b r2 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a()
            r0.setValue(r2)
        L_0x002f:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "mode"
            java.lang.String r4 = "clickthrough"
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x00a4 }
            android.content.Context r3 = r8.f66175b     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r4 = "phone"
            java.lang.Object r3 = r3.getSystemService(r4)     // Catch:{ JSONException -> 0x00a4 }
            if (r3 == 0) goto L_0x009c
            java.lang.String r3 = "deviceId"
            android.content.Context r4 = r8.f66175b     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r4 = com.paytm.utility.b.e((android.content.Context) r4)     // Catch:{ JSONException -> 0x00a4 }
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x00a4 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00a4 }
            r3.<init>()     // Catch:{ JSONException -> 0x00a4 }
            r4 = r9
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ JSONException -> 0x00a4 }
            if (r4 == 0) goto L_0x0063
            boolean r4 = r4.isEmpty()     // Catch:{ JSONException -> 0x00a4 }
            if (r4 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r4 = 0
            goto L_0x0064
        L_0x0063:
            r4 = 1
        L_0x0064:
            if (r4 != 0) goto L_0x0096
            java.util.Iterator r9 = r9.iterator()     // Catch:{ JSONException -> 0x00a4 }
        L_0x006a:
            boolean r4 = r9.hasNext()     // Catch:{ JSONException -> 0x00a4 }
            if (r4 == 0) goto L_0x0096
            java.lang.Object r4 = r9.next()     // Catch:{ JSONException -> 0x00a4 }
            net.one97.paytm.common.entity.auth.TncData r4 = (net.one97.paytm.common.entity.auth.TncData) r4     // Catch:{ JSONException -> 0x00a4 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a4 }
            r5.<init>()     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r6 = "code"
            java.lang.String r7 = "tncData"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r7 = r4.getCode()     // Catch:{ JSONException -> 0x00a4 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r6 = "version"
            int r4 = r4.getVersion()     // Catch:{ JSONException -> 0x00a4 }
            r5.put(r6, r4)     // Catch:{ JSONException -> 0x00a4 }
            r3.put(r5)     // Catch:{ JSONException -> 0x00a4 }
            goto L_0x006a
        L_0x0096:
            java.lang.String r9 = "tnCList"
            r2.put(r9, r3)     // Catch:{ JSONException -> 0x00a4 }
            goto L_0x00b8
        L_0x009c:
            kotlin.u r9 = new kotlin.u     // Catch:{ JSONException -> 0x00a4 }
            java.lang.String r3 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            r9.<init>(r3)     // Catch:{ JSONException -> 0x00a4 }
            throw r9     // Catch:{ JSONException -> 0x00a4 }
        L_0x00a4:
            r9 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r9 = r9.getMessage()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.paytm.utility.q.b(r9)
        L_0x00b8:
            java.lang.String r9 = r2.toString()
            java.lang.String r2 = "requestBody.toString()"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
            com.paytm.utility.q.d(r9)
            net.one97.paytm.upgradeKyc.helper.a$a r2 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            android.content.Context r2 = r8.f66175b
            java.util.Map r2 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a(r2)
            net.one97.paytm.upgradeKyc.helper.a$a r3 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            com.paytm.network.b r3 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
            net.one97.paytm.upgradeKyc.helper.e$a r4 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r4 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            android.content.Context r4 = r4.a()
            com.paytm.network.b r3 = r3.a((android.content.Context) r4)
            com.paytm.network.a$a r4 = com.paytm.network.a.C0715a.PUT
            com.paytm.network.b r3 = r3.a((com.paytm.network.a.C0715a) r4)
            com.paytm.network.b r2 = r3.a((java.util.Map<java.lang.String, java.lang.String>) r2)
            net.one97.paytm.common.entity.auth.KYCTncAccept r3 = new net.one97.paytm.common.entity.auth.KYCTncAccept
            r3.<init>()
            com.paytm.network.model.IJRPaytmDataModel r3 = (com.paytm.network.model.IJRPaytmDataModel) r3
            com.paytm.network.b r2 = r2.a((com.paytm.network.model.IJRPaytmDataModel) r3)
            java.lang.Class<net.one97.paytm.common.entity.upgradeKyc.Form60Model> r3 = net.one97.paytm.common.entity.upgradeKyc.Form60Model.class
            java.lang.String r3 = r3.getName()
            com.paytm.network.b r2 = r2.c(r3)
            com.paytm.network.b r9 = r2.b((java.lang.String) r9)
            com.paytm.network.b r9 = r9.a((java.lang.String) r1)
            com.paytm.network.a$b r1 = com.paytm.network.a.b.USER_FACING
            com.paytm.network.b r9 = r9.a((com.paytm.network.a.b) r1)
            net.one97.paytm.upgradeKyc.kycV3.b.c$u r1 = new net.one97.paytm.upgradeKyc.kycV3.b.c$u
            r1.<init>(r0)
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            com.paytm.network.b r9 = r9.a((com.paytm.network.listener.b) r1)
            com.paytm.network.a r9 = r9.l()
            android.content.Context r1 = r8.f66175b
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x0131
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r1 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            net.one97.paytm.upgradeKyc.kycV3.b.b r1 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a()
            r0.setValue(r1)
            r9.a()
            goto L_0x013e
        L_0x0131:
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r9 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r9 = r8.c()
            net.one97.paytm.upgradeKyc.kycV3.b.b r9 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r9)
            r0.setValue(r9)
        L_0x013e:
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.b.c.a(java.util.ArrayList):androidx.lifecycle.LiveData");
    }

    public static final class u implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66195a;

        u(y yVar) {
            this.f66195a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KYCTncAccept) {
                y yVar = this.f66195a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66195a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final LiveData<b<CJRAadharPanSave>> a(String str, String str2, String str3) {
        kotlin.g.b.k.c(str, "docCode");
        kotlin.g.b.k.c(str2, "adharNum");
        kotlin.g.b.k.c(str3, "adharName");
        y yVar = new y();
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kyc_save_profile_info") : null;
        if (!URLUtil.isValidUrl(a2)) {
            b.a aVar2 = b.f66167d;
            yVar.setValue(b.a.a(a()));
        }
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        String a3 = com.paytm.utility.d.a(this.f66175b);
        kotlin.g.b.k.a((Object) a3, "CJRNetUtility.getSSOToken(appContext)");
        map.put("session_token", a3);
        String e2 = com.paytm.utility.b.e();
        String f2 = com.paytm.utility.b.f();
        try {
            e.a aVar3 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            String a4 = net.one97.paytm.common.utility.f.a(e.a.b().c(), e2 + ':' + f2);
            kotlin.g.b.k.a((Object) a4, "encryptedKeyIV");
            hashMap.put("x-keyiv", a4);
        } catch (Exception e3) {
            com.paytm.utility.q.b(e3.getMessage());
        }
        CJRAadharPanSave cJRAadharPanSave = new CJRAadharPanSave();
        cJRAadharPanSave.setIv(f2);
        cJRAadharPanSave.setKey(e2);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("docCode", str);
            jSONObject2.put("docValue", str2);
            jSONArray.put(jSONObject2);
            jSONObject.put("documents", jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", str3);
            jSONObject.put("data", jSONObject3);
        } catch (JSONException e4) {
            com.paytm.utility.q.b(e4.getMessage());
        }
        String jSONObject4 = jSONObject.toString();
        kotlin.g.b.k.a((Object) jSONObject4, "requestBody.toString()");
        try {
            String a5 = net.one97.paytm.common.utility.f.a(f2, e2, jSONObject4);
            kotlin.g.b.k.a((Object) a5, "KycDataEncryption.encryptRequest(iv, key, body)");
            jSONObject4 = a5;
        } catch (Exception e5) {
            com.paytm.utility.q.b(e5.getMessage());
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(a.C0715a.POST).a((Map<String, String>) map).a((IJRPaytmDataModel) cJRAadharPanSave).a(a2).e("text/plain").b(jSONObject4).c(UpgradeKycActivity.class.getName()).a(a.b.USER_FACING).a(a.c.KYC).a((com.paytm.network.listener.b) new s(yVar)).l();
        if (com.paytm.utility.b.c(this.f66175b)) {
            b.a aVar5 = b.f66167d;
            yVar.setValue(b.a.a());
            l2.a();
        } else {
            b.a aVar6 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
        return yVar;
    }

    public static final class s implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66193a;

        s(y yVar) {
            this.f66193a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof CJRAadharPanSave) {
                y yVar = this.f66193a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66193a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0180  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP>> a(boolean r12, java.lang.String r13, boolean r14) {
        /*
            r11 = this;
            java.lang.String r0 = "adharNnum"
            kotlin.g.b.k.c(r13, r0)
            androidx.lifecycle.y r0 = new androidx.lifecycle.y
            r0.<init>()
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r1 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            net.one97.paytm.upgradeKyc.kycV3.b.b r1 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a()
            r0.setValue(r1)
            net.one97.paytm.upgradeKyc.helper.d$a r1 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r1 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = "ekyc_gen_otp_v4_updated"
            java.lang.String r1 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r1)
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            boolean r2 = android.webkit.URLUtil.isValidUrl(r1)
            if (r2 != 0) goto L_0x0036
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r2 = r11.a()
            net.one97.paytm.upgradeKyc.kycV3.b.b r2 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r2)
            r0.setValue(r2)
        L_0x0036:
            android.content.Context r2 = r11.f66175b
            java.lang.String r2 = com.paytm.utility.d.a(r2)
            if (r2 != 0) goto L_0x004e
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r12 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r12 = r11.b()
            net.one97.paytm.upgradeKyc.kycV3.b.b r12 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r12)
            r0.setValue(r12)
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            return r0
        L_0x004e:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = r2
            java.util.Map r3 = (java.util.Map) r3
            android.content.Context r4 = r11.f66175b
            java.lang.String r4 = com.paytm.utility.d.a(r4)
            java.lang.String r5 = "CJRNetUtility.getSSOToken(appContext)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r5 = "session_token"
            r3.put(r5, r4)
            java.lang.String r4 = com.paytm.utility.b.e()
            java.lang.String r5 = com.paytm.utility.b.f()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
            r6.<init>(r4)     // Catch:{ Exception -> 0x009a }
            r7 = 58
            r6.append(r7)     // Catch:{ Exception -> 0x009a }
            r6.append(r5)     // Catch:{ Exception -> 0x009a }
            net.one97.paytm.upgradeKyc.helper.e$a r7 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ Exception -> 0x009a }
            net.one97.paytm.upgradeKyc.helper.f r7 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ Exception -> 0x009a }
            java.lang.String r7 = r7.c()     // Catch:{ Exception -> 0x009a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x009a }
            java.lang.String r6 = net.one97.paytm.common.utility.f.a(r7, r6)     // Catch:{ Exception -> 0x009a }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x009a }
            java.lang.String r7 = "x-keyiv"
            java.lang.String r8 = "encryptedKeyIV"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)     // Catch:{ Exception -> 0x009a }
            r2.put(r7, r6)     // Catch:{ Exception -> 0x009a }
            goto L_0x00ae
        L_0x009a:
            r2 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = r2.getMessage()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            com.paytm.utility.q.b(r2)
        L_0x00ae:
            net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP r2 = new net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP
            r2.<init>()
            r2.setIv(r5)
            r2.setKey(r4)
            java.lang.String r6 = ""
            java.lang.String r7 = "jsonObject.toString()"
            java.lang.String r8 = "aadhar"
            if (r12 == 0) goto L_0x00f3
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            r12.put(r8, r13)     // Catch:{ Exception -> 0x00df }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00df }
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r7)     // Catch:{ Exception -> 0x00df }
            java.lang.String r6 = net.one97.paytm.common.utility.f.a(r5, r4, r12)     // Catch:{ Exception -> 0x00da }
            java.lang.String r9 = "KycDataEncryption.encryptRequest(iv, key, body)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)     // Catch:{ Exception -> 0x00da }
            goto L_0x00f3
        L_0x00da:
            r6 = move-exception
            r10 = r6
            r6 = r12
            r12 = r10
            goto L_0x00e0
        L_0x00df:
            r12 = move-exception
        L_0x00e0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = r12.getMessage()
            r9.append(r12)
            java.lang.String r12 = r9.toString()
            com.paytm.utility.q.b(r12)
        L_0x00f3:
            if (r14 == 0) goto L_0x0125
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            r12.put(r8, r13)     // Catch:{ Exception -> 0x0111 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0111 }
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r7)     // Catch:{ Exception -> 0x0111 }
            java.lang.String r6 = net.one97.paytm.common.utility.f.a(r5, r4, r12)     // Catch:{ Exception -> 0x010e }
            java.lang.String r13 = "KycDataEncryption.encryptRequest(iv,key,body)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r13)     // Catch:{ Exception -> 0x010e }
            goto L_0x0125
        L_0x010e:
            r13 = move-exception
            r6 = r12
            goto L_0x0112
        L_0x0111:
            r13 = move-exception
        L_0x0112:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = r13.getMessage()
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.paytm.utility.q.b(r12)
        L_0x0125:
            net.one97.paytm.upgradeKyc.helper.a$a r12 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            com.paytm.network.b r12 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
            android.content.Context r13 = r11.f66175b
            com.paytm.network.b r12 = r12.a((android.content.Context) r13)
            com.paytm.network.a$a r13 = com.paytm.network.a.C0715a.POST
            com.paytm.network.b r12 = r12.a((com.paytm.network.a.C0715a) r13)
            com.paytm.network.b r12 = r12.a((java.util.Map<java.lang.String, java.lang.String>) r3)
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            com.paytm.network.b r12 = r12.a((com.paytm.network.model.IJRPaytmDataModel) r2)
            java.lang.String r13 = "text/plain"
            com.paytm.network.b r12 = r12.e(r13)
            com.paytm.network.b r12 = r12.b((java.lang.String) r6)
            com.paytm.network.b r12 = r12.a((java.lang.String) r1)
            com.paytm.network.a$b r13 = com.paytm.network.a.b.USER_FACING
            com.paytm.network.b r12 = r12.a((com.paytm.network.a.b) r13)
            com.paytm.network.a$c r13 = com.paytm.network.a.c.KYC
            com.paytm.network.b r12 = r12.a((com.paytm.network.a.c) r13)
            java.lang.Class<net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity> r13 = net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity.class
            java.lang.String r13 = r13.getName()
            com.paytm.network.b r12 = r12.c(r13)
            net.one97.paytm.upgradeKyc.kycV3.b.c$i r13 = new net.one97.paytm.upgradeKyc.kycV3.b.c$i
            r13.<init>(r0)
            com.paytm.network.listener.b r13 = (com.paytm.network.listener.b) r13
            com.paytm.network.b r12 = r12.a((com.paytm.network.listener.b) r13)
            com.paytm.network.a r12 = r12.l()
            android.content.Context r13 = r11.f66175b
            boolean r13 = com.paytm.utility.b.c((android.content.Context) r13)
            if (r13 == 0) goto L_0x0180
            r12.a()
            goto L_0x018d
        L_0x0180:
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r12 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r12 = r11.c()
            net.one97.paytm.upgradeKyc.kycV3.b.b r12 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r12)
            r0.setValue(r12)
        L_0x018d:
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.b.c.a(boolean, java.lang.String, boolean):androidx.lifecycle.LiveData");
    }

    public static final class i implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66183a;

        i(y yVar) {
            this.f66183a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KycAadharGenOTP) {
                y yVar = this.f66183a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66183a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails>> a(java.lang.String r21, java.lang.String r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            java.lang.String r3 = "(this as java.lang.String).getBytes(charset)"
            java.lang.String r4 = ""
            java.lang.String r5 = "referenceNumber"
            kotlin.g.b.k.c(r0, r5)
            java.lang.String r6 = "otp"
            kotlin.g.b.k.c(r2, r6)
            androidx.lifecycle.y r6 = new androidx.lifecycle.y
            r6.<init>()
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r7 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            net.one97.paytm.upgradeKyc.kycV3.b.b r7 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a()
            r6.setValue(r7)
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 21
            if (r7 >= r8) goto L_0x0038
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r0 = r20.c()
            net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r0)
            r6.setValue(r0)
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            return r6
        L_0x0038:
            net.one97.paytm.upgradeKyc.helper.d$a r7 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r7 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r7 == 0) goto L_0x0047
            java.lang.String r7 = "ekyc_otp_verify_v3"
            java.lang.String r7 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r7)
            goto L_0x0048
        L_0x0047:
            r7 = 0
        L_0x0048:
            boolean r8 = android.webkit.URLUtil.isValidUrl(r7)
            if (r8 != 0) goto L_0x005e
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r0 = r20.a()
            net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r0)
            r6.setValue(r0)
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            return r6
        L_0x005e:
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r9 = r8
            java.util.Map r9 = (java.util.Map) r9
            android.content.Context r10 = r1.f66175b
            java.lang.String r10 = com.paytm.utility.d.a(r10)
            java.lang.String r11 = "CJRNetUtility.getSSOToken(appContext)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.lang.String r11 = "session_token"
            r9.put(r11, r10)
            java.lang.String r10 = com.paytm.utility.b.e()
            java.lang.String r11 = com.paytm.utility.b.f()
            net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails r12 = new net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails
            r12.<init>()
            r12.setIv(r11)
            r12.setKey(r10)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023b }
            r14.<init>(r10)     // Catch:{ Exception -> 0x023b }
            r15 = 58
            r14.append(r15)     // Catch:{ Exception -> 0x023b }
            r14.append(r11)     // Catch:{ Exception -> 0x023b }
            net.one97.paytm.upgradeKyc.helper.e$a r15 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ Exception -> 0x023b }
            net.one97.paytm.upgradeKyc.helper.f r15 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ Exception -> 0x023b }
            java.lang.String r15 = r15.c()     // Catch:{ Exception -> 0x023b }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x023b }
            java.lang.String r14 = net.one97.paytm.common.utility.f.a(r15, r14)     // Catch:{ Exception -> 0x023b }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x023b }
            java.lang.String r15 = "x-keyiv"
            r16 = r7
            java.lang.String r7 = "encryptedKeyIV"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)     // Catch:{ Exception -> 0x0237 }
            r8.put(r15, r14)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r7 = "uidai_auth.cer"
            net.one97.paytm.upgradeKyc.utils.a r8 = new net.one97.paytm.upgradeKyc.utils.a     // Catch:{ Exception -> 0x0237 }
            android.content.Context r14 = r1.f66175b     // Catch:{ Exception -> 0x0237 }
            android.content.res.AssetManager r14 = r14.getAssets()     // Catch:{ Exception -> 0x0237 }
            java.io.InputStream r7 = r14.open(r7)     // Catch:{ Exception -> 0x0237 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x0237 }
            byte[] r7 = net.one97.paytm.upgradeKyc.utils.a.a()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r14 = r8.a(r7)     // Catch:{ Exception -> 0x0237 }
            java.util.Calendar r15 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0237 }
            r17 = r12
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0231 }
            r18 = r9
            java.lang.String r9 = "yyyy-MM-dd'T'HH:mm:ss"
            r19 = r6
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x022b }
            r12.<init>(r9, r6)     // Catch:{ Exception -> 0x022b }
            java.lang.String r6 = "calendar"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)     // Catch:{ Exception -> 0x022b }
            java.util.Date r6 = r15.getTime()     // Catch:{ Exception -> 0x022b }
            java.lang.String r6 = r12.format(r6)     // Catch:{ Exception -> 0x022b }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022b }
            java.lang.String r12 = "<Pid ts=\""
            r9.<init>(r12)     // Catch:{ Exception -> 0x022b }
            r9.append(r6)     // Catch:{ Exception -> 0x022b }
            java.lang.String r12 = "\" ver=\"2.0\" wadh=\"pc0K1hVqt6oaWRjtxuFDfkB7aCL356jpGa28E1WIZ/4=\"><Pv otp=\""
            r9.append(r12)     // Catch:{ Exception -> 0x022b }
            r9.append(r2)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "\" /></Pid>"
            r9.append(r2)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x022b }
            net.one97.paytm.upgradeKyc.utils.g r9 = new net.one97.paytm.upgradeKyc.utils.g     // Catch:{ Exception -> 0x022b }
            r9.<init>()     // Catch:{ Exception -> 0x022b }
            java.nio.charset.Charset r9 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x022b }
            java.lang.String r12 = "null cannot be cast to non-null type java.lang.String"
            if (r2 == 0) goto L_0x0225
            byte[] r9 = r2.getBytes(r9)     // Catch:{ Exception -> 0x022b }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)     // Catch:{ Exception -> 0x022b }
            byte[] r9 = net.one97.paytm.upgradeKyc.utils.g.a(r9)     // Catch:{ Exception -> 0x022b }
            r15 = 0
            java.lang.String r9 = net.one97.paytm.upgradeKyc.utils.a.a(r7, r9, r6, r15)     // Catch:{ Exception -> 0x022b }
            java.nio.charset.Charset r15 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x022b }
            if (r2 == 0) goto L_0x021f
            byte[] r2 = r2.getBytes(r15)     // Catch:{ Exception -> 0x022b }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x022b }
            r3 = 1
            java.lang.String r2 = net.one97.paytm.upgradeKyc.utils.a.a(r7, r2, r6, r3)     // Catch:{ Exception -> 0x022b }
            android.content.Context r3 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r7 = "phone"
            r3.getSystemService(r7)     // Catch:{ Exception -> 0x022b }
            java.lang.String r3 = "userId"
            android.content.Context r7 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r7 = com.paytm.utility.b.n((android.content.Context) r7)     // Catch:{ Exception -> 0x022b }
            r13.put(r3, r7)     // Catch:{ Exception -> 0x022b }
            r13.put(r5, r0)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "encHMac"
            r13.put(r0, r9)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "encryptedPid"
            r13.put(r0, r2)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "certificateExpiry"
            java.lang.String r2 = r8.b()     // Catch:{ Exception -> 0x022b }
            r13.put(r0, r2)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "sessionKey"
            r13.put(r0, r14)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "pincode"
            java.lang.String r2 = "201301"
            r13.put(r0, r2)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "timeStamp"
            r13.put(r0, r6)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "channel"
            java.lang.String r2 = "mobile"
            r13.put(r0, r2)     // Catch:{ Exception -> 0x022b }
            android.content.Context r0 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = com.paytm.utility.b.d((android.content.Context) r0)     // Catch:{ Exception -> 0x022b }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x022b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "deviceCode"
            if (r0 != 0) goto L_0x0194
            android.content.Context r0 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = com.paytm.utility.b.d((android.content.Context) r0)     // Catch:{ Exception -> 0x022b }
            r13.put(r2, r0)     // Catch:{ Exception -> 0x022b }
            goto L_0x0199
        L_0x0194:
            java.lang.String r0 = "0-0"
            r13.put(r2, r0)     // Catch:{ Exception -> 0x022b }
        L_0x0199:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x022b }
            r0.<init>()     // Catch:{ Exception -> 0x022b }
            android.content.Context r2 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = com.paytm.utility.b.s((android.content.Context) r2)     // Catch:{ Exception -> 0x022b }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x022b }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x022b }
            java.lang.String r3 = "0.0"
            java.lang.String r5 = "latitude"
            if (r2 != 0) goto L_0x01ba
            android.content.Context r2 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = com.paytm.utility.b.s((android.content.Context) r2)     // Catch:{ Exception -> 0x022b }
            r0.put(r5, r2)     // Catch:{ Exception -> 0x022b }
            goto L_0x01bd
        L_0x01ba:
            r0.put(r5, r3)     // Catch:{ Exception -> 0x022b }
        L_0x01bd:
            android.content.Context r2 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = com.paytm.utility.b.t((android.content.Context) r2)     // Catch:{ Exception -> 0x022b }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x022b }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x022b }
            java.lang.String r5 = "longitude"
            if (r2 != 0) goto L_0x01d7
            android.content.Context r2 = r1.f66175b     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = com.paytm.utility.b.t((android.content.Context) r2)     // Catch:{ Exception -> 0x022b }
            r0.put(r5, r2)     // Catch:{ Exception -> 0x022b }
            goto L_0x01da
        L_0x01d7:
            r0.put(r5, r3)     // Catch:{ Exception -> 0x022b }
        L_0x01da:
            java.lang.String r2 = "location"
            r13.put(r2, r0)     // Catch:{ Exception -> 0x022b }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x022b }
            r0.<init>()     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "deviceDetails"
            r13.put(r2, r0)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "rdsId"
            r0.put(r2, r4)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "rdsVer"
            r0.put(r2, r4)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "dpId"
            r0.put(r2, r4)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "dc"
            r0.put(r2, r4)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "mi"
            r0.put(r2, r4)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = "mc"
            r0.put(r2, r4)     // Catch:{ Exception -> 0x022b }
            java.lang.String r2 = r13.toString()     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = "reqJsonObject.toString()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x022b }
            java.lang.String r0 = net.one97.paytm.common.utility.f.a(r11, r10, r2)     // Catch:{ Exception -> 0x021c }
            java.lang.String r3 = "KycDataEncryption.encryptRequest(iv, key, body)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x021c }
            r3 = r19
            goto L_0x0267
        L_0x021c:
            r0 = move-exception
            r4 = r2
            goto L_0x0244
        L_0x021f:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x022b }
            r0.<init>(r12)     // Catch:{ Exception -> 0x022b }
            throw r0     // Catch:{ Exception -> 0x022b }
        L_0x0225:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x022b }
            r0.<init>(r12)     // Catch:{ Exception -> 0x022b }
            throw r0     // Catch:{ Exception -> 0x022b }
        L_0x022b:
            r0 = move-exception
            goto L_0x0244
        L_0x022d:
            r0 = move-exception
            r19 = r6
            goto L_0x0244
        L_0x0231:
            r0 = move-exception
            r19 = r6
            r18 = r9
            goto L_0x0244
        L_0x0237:
            r0 = move-exception
            r19 = r6
            goto L_0x0240
        L_0x023b:
            r0 = move-exception
            r19 = r6
            r16 = r7
        L_0x0240:
            r18 = r9
            r17 = r12
        L_0x0244:
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r2 = r20.c()
            net.one97.paytm.upgradeKyc.kycV3.b.b r2 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r2)
            r3 = r19
            r3.setValue(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.paytm.utility.q.b(r0)
            r0 = r4
        L_0x0267:
            net.one97.paytm.upgradeKyc.helper.a$a r2 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            com.paytm.network.b r2 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
            android.content.Context r4 = r1.f66175b
            com.paytm.network.b r2 = r2.a((android.content.Context) r4)
            com.paytm.network.a$a r4 = com.paytm.network.a.C0715a.POST
            com.paytm.network.b r2 = r2.a((com.paytm.network.a.C0715a) r4)
            r8 = r18
            com.paytm.network.b r2 = r2.a((java.util.Map<java.lang.String, java.lang.String>) r8)
            r12 = r17
            com.paytm.network.model.IJRPaytmDataModel r12 = (com.paytm.network.model.IJRPaytmDataModel) r12
            com.paytm.network.b r2 = r2.a((com.paytm.network.model.IJRPaytmDataModel) r12)
            java.lang.String r4 = "text/plain"
            com.paytm.network.b r2 = r2.e(r4)
            com.paytm.network.b r0 = r2.b((java.lang.String) r0)
            r7 = r16
            com.paytm.network.b r0 = r0.a((java.lang.String) r7)
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.AadhaarOtpActivity> r2 = net.one97.paytm.upgradeKyc.activity.AadhaarOtpActivity.class
            java.lang.String r2 = r2.getName()
            com.paytm.network.b r0 = r0.c(r2)
            com.paytm.network.a$b r2 = com.paytm.network.a.b.USER_FACING
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.b) r2)
            com.paytm.network.a$c r2 = com.paytm.network.a.c.KYC
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.c) r2)
            net.one97.paytm.upgradeKyc.kycV3.b.c$h r2 = new net.one97.paytm.upgradeKyc.kycV3.b.c$h
            r2.<init>(r3)
            com.paytm.network.listener.b r2 = (com.paytm.network.listener.b) r2
            com.paytm.network.b r0 = r0.a((com.paytm.network.listener.b) r2)
            com.paytm.network.a r0 = r0.l()
            android.content.Context r2 = r1.f66175b
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            if (r2 == 0) goto L_0x02c8
            r0.a()
            goto L_0x02d5
        L_0x02c8:
            net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
            com.paytm.network.model.NetworkCustomError r0 = r20.c()
            net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a((com.paytm.network.model.NetworkCustomError) r0)
            r3.setValue(r0)
        L_0x02d5:
            r6 = r3
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.b.c.a(java.lang.String, java.lang.String):androidx.lifecycle.LiveData");
    }

    public static final class h implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66182a;

        h(y yVar) {
            this.f66182a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KycAadharEkycDetails) {
                y yVar = this.f66182a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66182a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final LiveData<b<EkycDataResponse>> b(String str) {
        String str2;
        kotlin.g.b.k.c(str, "eRefnum");
        y yVar = new y();
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("saveEkycRefNumber") : null;
        if (!URLUtil.isValidUrl(a2)) {
            b.a aVar2 = b.f66167d;
            yVar.setValue(b.a.a());
        }
        Map hashMap = new HashMap();
        String a3 = com.paytm.utility.d.a(this.f66175b);
        kotlin.g.b.k.a((Object) a3, "CJRNetUtility.getSSOToken(appContext)");
        hashMap.put("session_token", a3);
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("uuid", str);
            }
            str2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) str2, "reqJsonObject.toString()");
        } catch (JSONException e2) {
            com.paytm.utility.q.b(e2.getMessage());
            str2 = "";
        }
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new EkycDataResponse()).b(str2).c(AadhaarOtpActivity.class.getName()).a(a.b.USER_FACING).a(a.c.KYC).a(a2).a((com.paytm.network.listener.b) new r(yVar)).l();
        if (com.paytm.utility.b.c(this.f66175b)) {
            l2.a();
        } else {
            b.a aVar4 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
        return yVar;
    }

    public static final class r implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66192a;

        r(y yVar) {
            this.f66192a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof EkycDataResponse) {
                y yVar = this.f66192a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66192a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static /* synthetic */ LiveData a(c cVar, DocData docData, Form60Data form60Data, String str, int i2) {
        if ((i2 & 1) != 0) {
            docData = null;
        }
        if ((i2 & 2) != 0) {
            form60Data = null;
        }
        return cVar.a(docData, form60Data, str);
    }

    private LiveData<b<CJRAadharPanSave>> a(DocData docData, Form60Data form60Data, String str) {
        kotlin.g.b.k.c(str, "apiType");
        y yVar = new y();
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kyc_save_profile_info") : null;
        if (!URLUtil.isValidUrl(a2)) {
            b.a aVar2 = b.f66167d;
            yVar.setValue(b.a.a());
        }
        String e2 = com.paytm.utility.b.e(this.f66175b, a2);
        Map hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.d.a(this.f66175b));
        String e3 = com.paytm.utility.b.e();
        String f2 = com.paytm.utility.b.f();
        try {
            e.a aVar3 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            String c2 = e.a.b().c();
            hashMap.put("x-keyiv", net.one97.paytm.common.utility.f.a(c2, e3 + ':' + f2));
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        } catch (Exception e4) {
            com.paytm.utility.q.b(e4.getMessage());
        }
        CJRAadharPanSave cJRAadharPanSave = new CJRAadharPanSave();
        cJRAadharPanSave.setIv(f2);
        cJRAadharPanSave.setKey(e3);
        JSONObject jSONObject = new JSONObject();
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1268780418) {
                if (hashCode == 678626103) {
                    if (str.equals("defaultDoc")) {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        if (docData == null) {
                            kotlin.g.b.k.a();
                        }
                        jSONObject2.put("docCode", docData.getDocCode());
                        jSONObject2.put("docValue", docData.getDocValue());
                        jSONArray.put(jSONObject2);
                        jSONObject.put("documents", jSONArray);
                        if (docData.getDocName().length() > 0) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", docData.getDocName());
                            jSONObject.put("data", jSONObject3);
                        }
                    }
                }
            } else if (str.equals("form60")) {
                JSONObject jSONObject4 = new JSONObject();
                if (form60Data == null) {
                    kotlin.g.b.k.a();
                }
                jSONObject4.put("nonAgriculturalIncome", form60Data.getNonAgricultureIncome());
                jSONObject4.put("agriculturalIncome", form60Data.getAgricultureIncome());
                jSONObject.put("form60Data", jSONObject4);
            }
        } catch (Exception e5) {
            e5.getStackTrace();
        }
        String jSONObject5 = jSONObject.toString();
        try {
            jSONObject5 = net.one97.paytm.common.utility.f.a(f2, e3, jSONObject5);
        } catch (Exception e6) {
            com.paytm.utility.q.b(e6.getMessage());
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) cJRAadharPanSave).b(jSONObject5).a(e2).a(false).c(PanUpdateActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new q(yVar)).l();
        if (com.paytm.utility.b.c(this.f66175b)) {
            l2.a();
        } else {
            b.a aVar5 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
        return yVar;
    }

    public static final class q implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66191a;

        q(y yVar) {
            this.f66191a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof CJRAadharPanSave) {
                y yVar = this.f66191a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66191a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final LiveData<b<KycCheckDoc>> b(String str, String str2) {
        kotlin.g.b.k.c(str, "mReferenceNumber");
        kotlin.g.b.k.c(str2, "mUserAadhaarNum");
        y yVar = new y();
        b.a aVar = b.f66167d;
        yVar.setValue(b.a.a());
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kyc_checkdoc_url") : null;
        if (!URLUtil.isValidUrl(a2)) {
            b.a aVar3 = b.f66167d;
            yVar.setValue(b.a.a(a()));
        }
        Map hashMap = new HashMap();
        String a3 = com.paytm.utility.d.a(this.f66175b);
        kotlin.g.b.k.a((Object) a3, "CJRNetUtility.getSSOToken(appContext)");
        hashMap.put("session_token", a3);
        hashMap.put("reference_number", str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("docCode", "aadhar");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("docId", str2);
            }
        } catch (JSONException e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        kotlin.g.b.k.a((Object) jSONObject2, "reqJsonObject.toString()");
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new KycCheckDoc()).e("application/json").b(jSONObject2).a(a2).c(EnterAadhaarOtpActivity.class.getName()).a(a.b.USER_FACING).a(a.c.KYC).a((com.paytm.network.listener.b) new b(yVar)).l();
        if (com.paytm.utility.b.c(this.f66175b)) {
            l2.a();
        } else {
            b.a aVar5 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
        return yVar;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66176a;

        b(y yVar) {
            this.f66176a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KycCheckDoc) {
                y yVar = this.f66176a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66176a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66180a;

        public f(y yVar) {
            this.f66180a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof KycSavedUserData) {
                y yVar = this.f66180a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f66180a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final NetworkCustomError a() {
        return new NetworkCustomError(this.f66175b.getString(R.string.msg_invalid_url));
    }

    public final NetworkCustomError b() {
        return new NetworkCustomError(this.f66175b.getString(R.string.some_went_wrong));
    }

    public final NetworkCustomError c() {
        return new NetworkCustomError(this.f66175b.getString(R.string.no_connection));
    }

    public final void a(y<b<IJRPaytmDataModel>> yVar) {
        String str;
        kotlin.g.b.k.c(yVar, "kycDetailsLiveData");
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() == null) {
                kotlin.g.b.k.a();
            }
            str = net.one97.paytm.upgradeKyc.helper.d.a("kycFetchProfileInfoV2");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str) && !TextUtils.isEmpty(com.paytm.utility.d.a(this.f66175b))) {
            Map hashMap = new HashMap();
            String a2 = com.paytm.utility.d.a(this.f66175b);
            kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(this.appContext)");
            hashMap.put("session_token", a2);
            CJRAadharPanGet cJRAadharPanGet = new CJRAadharPanGet();
            a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) cJRAadharPanGet).a(com.paytm.utility.b.e(this.f66175b, str) + "&fields=cersai").c(MinKycPanAadharUpgradeActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new k(yVar)).l();
            if (com.paytm.utility.b.c(this.f66175b)) {
                l2.a();
            }
        }
    }

    public static final class k implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66185a;

        k(y yVar) {
            this.f66185a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            y yVar = this.f66185a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66185a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final void a(CersaiDetails cersaiDetails, y<b<IJRPaytmDataModel>> yVar) {
        String str;
        CorrespondenceAddress coresspondenceAddress;
        CorrespondenceAddress coresspondenceAddress2;
        CorrespondenceAddress coresspondenceAddress3;
        CorrespondenceAddress coresspondenceAddress4;
        CorrespondenceAddress coresspondenceAddress5;
        CorrespondenceAddress coresspondenceAddress6;
        CorrespondenceAddress coresspondenceAddress7;
        CorrespondenceAddress coresspondenceAddress8;
        CorrespondenceAddress coresspondenceAddress9;
        CorrespondenceAddress coresspondenceAddress10;
        CorrespondenceAddress coresspondenceAddress11;
        RelationShipDetails relationShipDetails;
        RelationShipDetails relationShipDetails2;
        RelationShipDetails relationShipDetails3;
        RelationShipDetails relationShipDetails4;
        kotlin.g.b.k.c(cersaiDetails, "ckycData");
        kotlin.g.b.k.c(yVar, "data");
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            kotlin.g.b.k.a();
        }
        String a2 = net.one97.paytm.upgradeKyc.helper.d.a("URLCersaiAddDetailsSaveAPI");
        if (URLUtil.isValidUrl(a2)) {
            if (com.paytm.utility.d.a(this.f66175b) == null) {
                b.a aVar2 = b.f66167d;
                yVar.setValue(b.a.a(b()));
                return;
            }
            String e2 = com.paytm.utility.b.e(this.f66175b, a2);
            kotlin.g.b.k.a((Object) e2, "CJRAppCommonUtility.addA…ltParams(appContext, url)");
            JSONObject jSONObject = new JSONObject();
            new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(cersaiDetails.getMaritalStatus())) {
                    jSONObject2.put("maritalStatus", cersaiDetails.getMaritalStatus());
                }
                if (!TextUtils.isEmpty(cersaiDetails.getProfession())) {
                    jSONObject2.put("profession", cersaiDetails.getProfession());
                }
                JSONArray jSONArray = new JSONArray();
                String str2 = null;
                boolean z = false;
                if (cersaiDetails.getRelationships() != null) {
                    ArrayList<RelationShipDetails> relationships = cersaiDetails.getRelationships();
                    Integer valueOf = relationships != null ? Integer.valueOf(relationships.size()) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (valueOf.intValue() > 0) {
                        ArrayList<RelationShipDetails> relationships2 = cersaiDetails.getRelationships();
                        kotlin.j.d a3 = relationships2 != null ? kotlin.a.k.a((Collection<?>) relationships2) : null;
                        if (a3 == null) {
                            kotlin.g.b.k.a();
                        }
                        int i2 = a3.f47939a;
                        int i3 = a3.f47940b;
                        if (i2 <= i3) {
                            while (true) {
                                JSONObject jSONObject3 = new JSONObject();
                                ArrayList<RelationShipDetails> relationships3 = cersaiDetails.getRelationships();
                                if (relationships3 == null) {
                                    kotlin.g.b.k.a();
                                }
                                if (!TextUtils.isEmpty(relationships3.get(i2).getAction())) {
                                    ArrayList<RelationShipDetails> relationships4 = cersaiDetails.getRelationships();
                                    jSONObject3.put("action", (relationships4 == null || (relationShipDetails4 = relationships4.get(i2)) == null) ? null : relationShipDetails4.getAction());
                                    ArrayList<RelationShipDetails> relationships5 = cersaiDetails.getRelationships();
                                    jSONObject3.put("relationShip", (relationships5 == null || (relationShipDetails3 = relationships5.get(i2)) == null) ? null : relationShipDetails3.getRelationShip());
                                    ArrayList<RelationShipDetails> relationships6 = cersaiDetails.getRelationships();
                                    jSONObject3.put("firstName", (relationships6 == null || (relationShipDetails2 = relationships6.get(i2)) == null) ? null : relationShipDetails2.getFirstName());
                                    ArrayList<RelationShipDetails> relationships7 = cersaiDetails.getRelationships();
                                    jSONObject3.put("lastName", (relationships7 == null || (relationShipDetails = relationships7.get(i2)) == null) ? null : relationShipDetails.getLastName());
                                    jSONArray.put(jSONObject3);
                                    z = true;
                                }
                                if (i2 == i3) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                }
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                Address address = cersaiDetails.getAddress();
                jSONObject5.put("action", (address == null || (coresspondenceAddress11 = address.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress11.getAction());
                Address address2 = cersaiDetails.getAddress();
                jSONObject5.put("sameAsPermanent", (address2 == null || (coresspondenceAddress10 = address2.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress10.isSameAsPermanent());
                Address address3 = cersaiDetails.getAddress();
                if (kotlin.g.b.k.a((Object) (address3 == null || (coresspondenceAddress9 = address3.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress9.isSameAsPermanent(), (Object) Boolean.FALSE)) {
                    Address address4 = cersaiDetails.getAddress();
                    jSONObject5.put("street_1", (address4 == null || (coresspondenceAddress8 = address4.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress8.getAddressOne());
                    Address address5 = cersaiDetails.getAddress();
                    jSONObject5.put("street_2", (address5 == null || (coresspondenceAddress7 = address5.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress7.getAddressTwo());
                    Address address6 = cersaiDetails.getAddress();
                    jSONObject5.put("locality", (address6 == null || (coresspondenceAddress6 = address6.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress6.getAddressThree());
                    Address address7 = cersaiDetails.getAddress();
                    jSONObject5.put("postal_code", (address7 == null || (coresspondenceAddress5 = address7.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress5.getPostalCode());
                    Address address8 = cersaiDetails.getAddress();
                    jSONObject5.put("city", (address8 == null || (coresspondenceAddress4 = address8.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress4.getCity());
                    Address address9 = cersaiDetails.getAddress();
                    jSONObject5.put("state", (address9 == null || (coresspondenceAddress3 = address9.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress3.getState());
                    Address address10 = cersaiDetails.getAddress();
                    jSONObject5.put(AddEditGstinViewModelKt.BODY_PARAM_COUNTRY, (address10 == null || (coresspondenceAddress2 = address10.getCoresspondenceAddress()) == null) ? null : coresspondenceAddress2.getCountry());
                    Address address11 = cersaiDetails.getAddress();
                    if (!(address11 == null || (coresspondenceAddress = address11.getCoresspondenceAddress()) == null)) {
                        str2 = coresspondenceAddress.getAddressType();
                    }
                    jSONObject5.put("addressType", str2);
                }
                jSONObject4.put("correspondenceAddress", jSONObject5);
                jSONObject2.put("completeAddress", jSONObject4);
                if (z) {
                    jSONObject2.put("relationships", jSONArray);
                }
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e3) {
                com.paytm.utility.q.b(e3.getMessage());
            }
            HashMap hashMap = new HashMap();
            String e4 = com.paytm.utility.b.e();
            String f2 = com.paytm.utility.b.f();
            try {
                e.a aVar3 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
                String a4 = net.one97.paytm.common.utility.f.a(e.a.b().c(), e4 + ':' + f2);
                kotlin.g.b.k.a((Object) a4, "encryptedKeyIV");
                hashMap.put("x-keyiv", a4);
            } catch (Exception e5) {
                com.paytm.utility.q.b(e5.getMessage());
            }
            CersaiSaveKycResponse cersaiSaveKycResponse = new CersaiSaveKycResponse((String) null, (String) null, (String) null, (String) null, 15, (kotlin.g.b.g) null);
            cersaiSaveKycResponse.setIv(f2);
            cersaiSaveKycResponse.setKey(e4);
            String jSONObject6 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject6, "requestBody.toString()");
            com.paytm.utility.q.d(jSONObject6);
            try {
                str = net.one97.paytm.common.utility.f.a(f2, e4, jSONObject6);
                kotlin.g.b.k.a((Object) str, "KycDataEncryption.encryptRequest(iv, key, body)");
            } catch (Exception e6) {
                com.paytm.utility.q.b(e6.getMessage());
                str = jSONObject6;
            }
            Map map = hashMap;
            String a5 = com.paytm.utility.d.a(this.f66175b);
            kotlin.g.b.k.a((Object) a5, "CJRNetUtility.getSSOToken(appContext)");
            map.put("session_token", a5);
            map.put("Content-Type", "application/json");
            a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(a.C0715a.POST).a((Map<String, String>) map).a((IJRPaytmDataModel) cersaiSaveKycResponse).e("text/plain").b(str).a(e2).c(BankProfileActivity.class.getName()).a(a.b.USER_FACING).a(a.c.KYC).a((com.paytm.network.listener.b) new p(yVar)).l();
            if (com.paytm.utility.b.c(this.f66175b)) {
                l2.a();
                return;
            }
            b.a aVar5 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
    }

    public static final class p implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66190a;

        p(y yVar) {
            this.f66190a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            y yVar = this.f66190a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66190a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static final class m implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66187a;

        public m(y yVar) {
            this.f66187a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KYCWaitTimeResponse) {
                y yVar = this.f66187a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66187a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final void a(y<b<VideoKYCLeadResponse>> yVar, Location location, String str, int i2, String str2, boolean z, String str3) {
        String str4;
        kotlin.g.b.k.c(yVar, "data");
        kotlin.g.b.k.c(location, "location");
        kotlin.g.b.k.c(str, "userPrefLanguage");
        kotlin.g.b.k.c(str2, "flow");
        kotlin.g.b.k.c(str3, "routingSource");
        b.a aVar = b.f66167d;
        yVar.setValue(b.a.a());
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar3 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() == null) {
                kotlin.g.b.k.a();
            }
            str4 = net.one97.paytm.upgradeKyc.helper.d.a("createVideoKycleadURL");
        } else {
            str4 = null;
        }
        if (!URLUtil.isValidUrl(str4)) {
            b.a aVar4 = b.f66167d;
            yVar.setValue(b.a.a(b()));
        } else if (TextUtils.isEmpty(com.paytm.utility.d.a(this.f66175b))) {
            b.a aVar5 = b.f66167d;
            yVar.setValue(b.a.a(b()));
        } else {
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            String a2 = com.paytm.utility.d.a(this.f66175b);
            kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(this.appContext)");
            map.put("session_token", a2);
            String z2 = com.paytm.utility.b.z(this.f66175b);
            kotlin.g.b.k.a((Object) z2, "CJRAppCommonUtility.getF…iceIdentifier(appContext)");
            map.put("deviceIdentifier", z2);
            map.put("Content-Type", "application/json");
            hashMap.put("Accept-Encoding", "gzip, deflate");
            hashMap.put("Accept", "*/*");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("languagePreference", str);
            StringBuilder sb = new StringBuilder();
            sb.append(location.getLatitude());
            jSONObject.put("latitude", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(location.getLongitude());
            jSONObject.put("longitude", sb2.toString());
            jSONObject.put("priority", String.valueOf(i2));
            jSONObject.put("flow", str2);
            jSONObject.put("isInternalRouting", z);
            jSONObject.put("routingSource", str3);
            VideoKYCLeadResponse videoKYCLeadResponse = new VideoKYCLeadResponse();
            a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.a l2 = a.C1317a.a().a(this.f66175b).a(false).a(a.C0715a.POST).a((Map<String, String>) map).a((IJRPaytmDataModel) videoKYCLeadResponse).a(str4 + "?client=androidapp&version=" + com.paytm.utility.b.Q(this.f66175b)).b(jSONObject.toString()).a(a.c.KYC).c(VideoKycActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new e(yVar)).l();
            if (com.paytm.utility.b.c(this.f66175b)) {
                l2.a();
                return;
            }
            b.a aVar7 = b.f66167d;
            yVar.setValue(b.a.a(c()));
        }
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66179a;

        e(y yVar) {
            this.f66179a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof VideoKYCLeadResponse) {
                y yVar = this.f66179a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66179a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.kycV3.b.c$c  reason: collision with other inner class name */
    public static final class C1326c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f66177a;

        public C1326c(y yVar) {
            this.f66177a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof MyOrderApiResponse) {
                y yVar = this.f66177a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(iJRPaytmDataModel));
            }
            iJRPaytmDataModel.getNetworkResponse();
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            y yVar = this.f66177a;
            b.a aVar = b.f66167d;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static /* synthetic */ LiveData a(c cVar, String str, String str2, int i2) {
        String str3 = null;
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        y yVar = new y();
        if (str2 == null) {
            d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() != null) {
                str3 = net.one97.paytm.upgradeKyc.helper.d.a("kyc_tnc_base_url");
            }
            str2 = kotlin.g.b.k.a(str3, (Object) str);
        }
        if (URLUtil.isValidUrl(str2)) {
            String e2 = com.paytm.utility.b.e(cVar.f66175b, str2);
            a.C1317a aVar2 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            Map<String, String> a2 = a.C1317a.a(cVar.f66175b);
            a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.a l2 = a.C1317a.a().a(cVar.f66175b).a(a.C0715a.GET).a(a2).a((IJRPaytmDataModel) new KYCFetchTnc()).a(e2).a(a.c.KYC).a(false).c(KYCFetchTnc.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new g(yVar)).l();
            if (com.paytm.utility.b.c(cVar.f66175b)) {
                l2.a();
            } else {
                b.a aVar4 = b.f66167d;
                yVar.setValue(b.a.a(cVar.c()));
            }
        } else {
            b.a aVar5 = b.f66167d;
            yVar.setValue(b.a.a(cVar.a()));
        }
        return yVar;
    }
}
