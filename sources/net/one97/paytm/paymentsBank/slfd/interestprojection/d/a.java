package net.one97.paytm.paymentsBank.slfd.interestprojection.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdModel;
import net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDInterestRateListModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDMaxLimitModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDTrialRedeemAmount;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f19201d;

    /* renamed from: a  reason: collision with root package name */
    public Context f19202a;

    /* renamed from: b  reason: collision with root package name */
    public String f19203b;

    /* renamed from: c  reason: collision with root package name */
    public SlfdModel f19204c;

    /* renamed from: e  reason: collision with root package name */
    private String f19205e;

    private a(Context context) {
        this.f19202a = context;
    }

    public static a a(Context context) {
        if (f19201d == null) {
            synchronized (a.class) {
                f19201d = new a(context);
            }
        }
        return f19201d;
    }

    public final void b(Context context) {
        this.f19202a = context;
    }

    public final void a(String str, g.b bVar, g.a aVar) {
        String str2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userToken", com.paytm.utility.a.q(this.f19202a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("Authorization", jSONObject.toString());
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", "App");
        StringBuilder sb = new StringBuilder();
        d.b();
        if (!TextUtils.isEmpty(d.a("fdInterestRate"))) {
            str2 = d.a("fdInterestRate");
        } else {
            str2 = f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v1/fd/interest" : "https://secure.paytmbank.com/transaction/ext/v1/fd/interest";
        }
        sb.append(str2);
        sb.append("?account_type=");
        sb.append(str);
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(sb.toString(), bVar, aVar, (IJRPaytmDataModel) new FDInterestRateListModel(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        this.f19202a.getApplicationContext();
        new c();
        c.a(aVar2);
    }

    public final void a(String str, String str2, g.b bVar, g.a aVar) {
        String str3 = str;
        net.one97.paytm.paymentsBank.slfd.a.a.b.a aVar2 = new net.one97.paytm.paymentsBank.slfd.a.a.b.a(this.f19202a);
        $$Lambda$a$PuCCGB2IelcSdalCUjgZdk7nVp8 r6 = new g.b() {
            public final void onResponse(Object obj) {
                g.b.this.onResponse((IJRPaytmDataModel) obj);
            }
        };
        $$Lambda$a$G2CDXcYyL5SHMPRhRcLG9C8BdRw r7 = new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                g.a.this.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        k.c(str, "orderId");
        k.c(str2, "accountType");
        k.c(r6, "listener");
        k.c(r7, "errorListener");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        String simpleName = aVar2.getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap2.put("screen_name", simpleName);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userToken", com.paytm.utility.a.q(aVar2.f18950a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Map map = hashMap;
        String jSONObject2 = jSONObject.toString();
        k.a((Object) jSONObject2, "jsonObject.toString()");
        map.put("Authorization", jSONObject2);
        map.put("Content-Type", "application/json");
        map.put("client", "App");
        k.a((Object) d.b(), "PBGTMHelper.getInstance()");
        Uri.Builder buildUpon = Uri.parse(d.a("fdTransactionDetails")).buildUpon();
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("entity_id", net.one97.paytm.bankCommon.h.c.d(aVar2.f18950a));
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        buildUpon.appendQueryParameter("order_id", str);
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), (g.b) r6, (g.a) r7, (IJRPaytmDataModel) new FDPostTransactionModel(), (Map<String, String>) null, (Map<String, String>) map, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        aVar2.f18950a.getApplicationContext();
        new c();
        c.a(aVar3);
    }

    public final void a(g.b bVar, g.a aVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userToken", com.paytm.utility.a.q(this.f19202a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("Authorization", jSONObject.toString());
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", "App");
        d.b();
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(d.a("fdMaxLimit"), bVar, aVar, (IJRPaytmDataModel) new FDMaxLimitModel(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        this.f19202a.getApplicationContext();
        new c();
        c.a(aVar2);
    }

    public final void b(String str, g.b bVar, g.a aVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        try {
            new JSONObject().put("userToken", com.paytm.utility.a.q(this.f19202a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("authorization", com.paytm.utility.a.q(this.f19202a));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", "App");
        d.b();
        Uri.Builder buildUpon = Uri.parse(d.a("fdTrialRedeemAmount")).buildUpon();
        buildUpon.appendQueryParameter("amount", str);
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("caId", net.one97.paytm.bankCommon.h.c.d(this.f19202a));
            buildUpon.appendQueryParameter("strategy", "IBL");
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
            buildUpon.appendQueryParameter("strategy", "INHOUSE");
        }
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, (IJRPaytmDataModel) new FDTrialRedeemAmount(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        this.f19202a.getApplicationContext();
        new c();
        c.a(aVar2);
    }

    public final void b(g.b bVar, g.a aVar) {
        net.one97.paytm.paymentsBank.slfd.a.a.b.a aVar2 = new net.one97.paytm.paymentsBank.slfd.a.a.b.a(this.f19202a);
        this.f19203b = String.valueOf(this.f19204c.getNetInvestedAmount());
        this.f19205e = String.valueOf(this.f19204c.getNetInvestedAmount());
        aVar2.a("IBPAN", String.valueOf(this.f19204c.getNetInvestedAmount()), "20265", (g.b<IJRPaytmDataModel>) new g.b() {
            public final void onResponse(Object obj) {
                a.b(g.b.this, (IJRPaytmDataModel) obj);
            }
        }, (g.a) new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                g.a.this.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(g.b bVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof ValidateAmountLimit) {
            bVar.onResponse(iJRPaytmDataModel);
        }
    }

    public final void a(JSONArray jSONArray, String str, String str2, g.b bVar, g.a aVar) {
        new net.one97.paytm.paymentsBank.slfd.a.a.b.a(this.f19202a).a(jSONArray, str, str2, (g.b<IJRPaytmDataModel>) new g.b() {
            public final void onResponse(Object obj) {
                a.a(g.b.this, (IJRPaytmDataModel) obj);
            }
        }, (g.a) new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                g.a.this.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(g.b bVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof SlfdCreateRedeemResponse) {
            bVar.onResponse(iJRPaytmDataModel);
        }
    }
}
