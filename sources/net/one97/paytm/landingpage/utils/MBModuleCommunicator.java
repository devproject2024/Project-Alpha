package net.one97.paytm.landingpage.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.x;
import net.one97.paytm.managebeneficiary.f;
import net.one97.paytm.managebeneficiary.g;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.utils.a.a;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.activity.AJRConfirmIFSCActivity;
import net.one97.paytm.wallet.d.d;

public final class MBModuleCommunicator implements g {
    public static final a Companion = new a((byte) 0);
    /* access modifiers changed from: private */
    public static MBModuleCommunicator instance;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String getBeneficiaryAddSuccessMsg(Activity activity) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("beneficiaryAddSuccessMsg", (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().…eneficiaryAddSuccessMsg()");
        return a2;
    }

    public final Intent getIfscConfirmActivity(Context context) {
        return new Intent(context, AJRConfirmIFSCActivity.class);
    }

    public final String getBeneficiaryURLV2(Context context) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("getBeneficiaryKYC_V2", (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().getBeneficiaryURLV2()");
        return a2;
    }

    public final void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context) {
        net.one97.paytm.j.a.b(str, (Map<String, Object>) hashMap, context);
    }

    public final String deeplinkSchemaName() {
        String a2 = net.one97.paytm.payments.d.a.a();
        k.a((Object) a2, "DeeplinkManager.deeplinkSchemaName()");
        return a2;
    }

    public final void showAlertForBeneficiary(Activity activity, String str, String str2) {
        net.one97.paytm.wallet.utility.a.a(activity, str, str2);
    }

    public final void sendOpenScreenWithDeviceInfo(String str, String str2, Activity activity) {
        net.one97.paytm.j.a.b(str, str2, (Context) activity);
    }

    public final String editBeneficiaryURL(Context context) {
        net.one97.paytm.j.c.a();
        String N = net.one97.paytm.j.c.N();
        k.a((Object) N, "GTMLoader.getInstance().editBeneficiaryURL()");
        return N;
    }

    public final boolean getBooleanFromGTM(Context context, String str, boolean z) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public final void deleteBeneficiaryFromDb(Context context, String str, String str2) {
        new net.one97.paytm.moneytransfer.b.a.a.b(context, str, str2).execute(new Object[0]);
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.managebeneficiary.a.b f52885a;

        c(net.one97.paytm.managebeneficiary.a.b bVar) {
            this.f52885a = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            net.one97.paytm.managebeneficiary.a.b bVar = this.f52885a;
            if (bVar == null) {
                k.a();
            }
            bVar.a(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            net.one97.paytm.managebeneficiary.a.b bVar = this.f52885a;
            if (bVar == null) {
                k.a();
            }
            bVar.a();
        }
    }

    public final void initIfscHelper(Activity activity, String str, net.one97.paytm.managebeneficiary.a.b bVar) {
        d.a((Context) activity, str, (com.paytm.network.listener.b) new c(bVar));
    }

    public final String addBeneficiaryURL(Context context) {
        net.one97.paytm.j.c.a();
        String L = net.one97.paytm.j.c.L();
        k.a((Object) L, "GTMLoader.getInstance().addBeneficiaryURL()");
        return L;
    }

    public final String deleteBeneficiaryURL(Context context) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a(UpiConstantServiceApi.DELETE_BENEFICIARY_URL, (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().deleteBeneficiaryURL()");
        return a2;
    }

    public final boolean getBoolean(String str, boolean z) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public final String getBeneficiaryLimitUpdateMsg(Context context) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("beneficiaryLimitUpdateMsg", (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().…neficiaryLimitUpdateMsg()");
        return a2;
    }

    public final void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        r.a(activity, exc, str, bundle);
    }

    public final String getValidateBeneficiaryUrl(Context context) {
        net.one97.paytm.j.c.a();
        String M = net.one97.paytm.j.c.M();
        k.a((Object) M, "GTMLoader.getInstance().…tValidateBeneficiaryUrl()");
        return M;
    }

    public final boolean showDeleteBeneficiaryButton() {
        return getBoolean("showBeneficiaryDelete", true);
    }

    public final String getBeneficiaryDetailUpdatesMsg(Context context) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("beneficiaryDetailUpdateMsg", (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().…ficiaryDetailUpdatesMsg()");
        return a2;
    }

    public static final class b implements a.C1407a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.managebeneficiary.a.a f52884a;

        b(net.one97.paytm.managebeneficiary.a.a aVar) {
            this.f52884a = aVar;
        }

        public final void a(int i2) {
            net.one97.paytm.managebeneficiary.a.a aVar = this.f52884a;
            if (aVar == null) {
                k.a();
            }
            aVar.a(i2);
        }
    }

    public final void getBankAccStatus(Context context, net.one97.paytm.managebeneficiary.a.a aVar) {
        net.one97.paytm.utils.a.a.a().a(context, new b(aVar));
    }

    public final String getSSOToken(Context context) {
        String b2 = t.b(context);
        k.a((Object) b2, "CJRServerUtility.getSSOToken(context)");
        return b2;
    }

    public final void checkDeepLinking(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final String getBankIconUrl(Context context, String str) {
        if (context == null) {
            k.a();
        }
        String bankIconUrl = UpiRequestBuilder.getBankIconUrl(context.getApplicationContext(), str);
        k.a((Object) bankIconUrl, "UpiRequestBuilder.getBan…ationContext(), ifscCode)");
        return bankIconUrl;
    }

    public static final void init() {
        if (instance == null) {
            synchronized (y.b(g.class)) {
                if (instance == null) {
                    instance = new MBModuleCommunicator();
                }
                x xVar = x.f47997a;
            }
        }
        f.a(instance);
    }
}
