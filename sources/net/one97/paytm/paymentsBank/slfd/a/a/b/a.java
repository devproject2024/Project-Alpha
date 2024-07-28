package net.one97.paytm.paymentsBank.slfd.a.a.b;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import com.google.gson.l;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gsonhtcfix.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFCreationResponse;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFStatusResponse;
import net.one97.paytm.paymentsBank.createfd.model.CreateFdModel;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.model.slfd.AmountDetailsResponse;
import net.one97.paytm.paymentsBank.model.slfd.BookingResponse;
import net.one97.paytm.paymentsBank.model.slfd.FdDetailsResponse;
import net.one97.paytm.paymentsBank.model.slfd.NomineeDetailsResponse;
import net.one97.paytm.paymentsBank.model.slfd.RedemptionResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdBalanceResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdListModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeListModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse;
import net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit;
import net.one97.paytm.paymentsBank.model.slfd.ValidateSlfdModel;
import net.one97.paytm.paymentsBank.model.slfd.ViewLifoFdResponse;
import net.one97.paytm.paymentsBank.si.response.SICreationResponse;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements net.one97.paytm.paymentsBank.slfd.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0327a f18948b = new C0327a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f18949c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f18950a;

    static final class b<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18951a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.b f18952b;

        b(a aVar, g.b bVar) {
            this.f18951a = aVar;
            this.f18952b = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            if (iJRPaytmDataModel instanceof SlfdMetaApiResponseModel) {
                net.one97.paytm.bankCommon.h.b.h(this.f18951a.f18950a, new f().a((Object) iJRPaytmDataModel));
            }
            this.f18952b.onResponse(iJRPaytmDataModel);
        }
    }

    public a(Context context) {
        k.c(context, "context");
        this.f18950a = context;
    }

    /* renamed from: net.one97.paytm.paymentsBank.slfd.a.a.b.a$a  reason: collision with other inner class name */
    public static final class C0327a {
        private C0327a() {
        }

        public /* synthetic */ C0327a(byte b2) {
            this();
        }
    }

    public final void e(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        g.a aVar2 = aVar;
        g.b<IJRPaytmDataModel> bVar2 = bVar;
        k.c(bVar2, "onSuccess");
        k.c(aVar2, "onFailure");
        String s = n.s();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("amount", str);
        jSONObject.put("type", "SWEEP_OUT");
        jSONObject.put("sourceAccountNumber", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.b bVar3 = new net.one97.paytm.bankCommon.g.b(s, bVar2, aVar, (IJRPaytmDataModel) new SICreationResponse(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(bVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new SICreationResponse(), new NetworkCustomError());
    }

    public final void f(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        g.a aVar2 = aVar;
        g.b<IJRPaytmDataModel> bVar2 = bVar;
        k.c(bVar2, "onSuccess");
        k.c(aVar2, "onFailure");
        String u = n.u();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("siId", str);
        jSONObject.put("amount", str2);
        jSONObject.put("type", "SWEEP_OUT");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.b bVar3 = new net.one97.paytm.bankCommon.g.b(u, bVar2, aVar, (IJRPaytmDataModel) new SICreationResponse(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(bVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new SICreationResponse(), new NetworkCustomError());
    }

    public final void d(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        Uri.Builder buildUpon = Uri.parse(n.m()).buildUpon();
        buildUpon.appendQueryParameter("amount", str2).appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, str);
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userToken", d.a(this.f18950a));
        hashMap.put("authorization", jSONObject.toString());
        hashMap.put("client", "androidapp");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new FDProjectionListModel(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new FDProjectionListModel(), new NetworkCustomError());
    }

    public final void c(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        String str3 = str;
        String str4 = str2;
        g.a aVar2 = aVar;
        k.c(str, "orderId");
        k.c(str4, "accountType");
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        Uri.Builder buildUpon = Uri.parse(n.l()).buildUpon();
        buildUpon.appendQueryParameter("order_id", str).appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, str4).appendQueryParameter("client", "androidapp");
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userToken", d.a(this.f18950a));
        hashMap.put("authorization", jSONObject.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new TransactionDetailResponse((BookingResponse) null, (RedemptionResponse) null, 3, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new TransactionDetailResponse((BookingResponse) null, (RedemptionResponse) null, 3, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void b(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        String str3 = str;
        String str4 = str2;
        g.a aVar2 = aVar;
        k.c(str3, StringSet.token);
        k.c(str4, "amt");
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        String j = n.j();
        HashMap hashMap = new HashMap();
        hashMap.put(UpiRequestBuilder.SESSION_TOKEN, str3);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("amount", str4);
        jSONObject.put("channel", "MOB");
        jSONObject.put("channel_id", "APP");
        jSONObject.put("nominee_preference", false);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(j, bVar, aVar, new CreateFdModel((String) null, (String) null, (String) null, (String) null, 15, (kotlin.g.b.g) null), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(bVar2);
            return;
        }
        aVar2.onErrorResponse(-1, new CreateFdModel((String) null, (String) null, (String) null, (String) null, 15, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void b(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        String str4 = str;
        String str5 = str3;
        g.a aVar2 = aVar;
        k.c(str4, "amt");
        k.c(str2, "accountType");
        k.c(str5, SDKConstants.TXN_TYPE);
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        Uri.Builder buildUpon = Uri.parse(n.k()).buildUpon();
        buildUpon.appendQueryParameter("amount", str4).appendQueryParameter("txn_type", str5).appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new ValidateAmountLimit(false, (String) null, 0, (String) null, (String) null, 31, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new ValidateAmountLimit(false, (String) null, 0, (String) null, (String) null, 31, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String n = net.one97.paytm.bankCommon.utils.d.n();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(n, new b(this, bVar), aVar, new SlfdMetaApiResponseModel(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new SlfdMetaApiResponseModel(), new NetworkCustomError());
    }

    public final void b(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        Uri.Builder buildUpon = Uri.parse(n.f()).buildUpon();
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("caId", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        String builder = buildUpon.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(builder, bVar, aVar, new SlfdBalanceResponseModel(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new SlfdBalanceResponseModel(), new NetworkCustomError());
    }

    public final void g(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String A = net.one97.paytm.bankCommon.utils.d.A();
        HashMap hashMap = new HashMap();
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap.put("client", com.paytm.utility.b.k());
        hashMap.put("ccontent-type", "application/json");
        hashMap.put("user-token", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(A, bVar, aVar, new FGHStatusModel(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new FGHStatusModel(), new NetworkCustomError());
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, int i2) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "status");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        Uri.Builder buildUpon = Uri.parse(net.one97.paytm.bankCommon.utils.d.p()).buildUpon();
        buildUpon.appendQueryParameter("status", str);
        buildUpon.appendQueryParameter("pageNumber", String.valueOf(i2));
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter("caId", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new SlfdListModel(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new SlfdListModel(), new NetworkCustomError());
    }

    public final void a(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        String str4 = str2;
        String str5 = str3;
        g.a aVar2 = aVar;
        k.c(str, "productType");
        k.c(str4, "amount");
        k.c(str5, SDKConstants.TXN_TYPE);
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        Uri.Builder buildUpon = Uri.parse(net.one97.paytm.bankCommon.utils.d.r()).buildUpon();
        buildUpon.appendQueryParameter("amount", str4).appendQueryParameter("txn_type", str5);
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("caId", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new ValidateAmountLimit(false, (String) null, 0, (String) null, (String) null, 31, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new ValidateAmountLimit(false, (String) null, 0, (String) null, (String) null, 31, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void a(JSONArray jSONArray, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        JSONArray jSONArray2 = jSONArray;
        String str3 = str;
        String str4 = str2;
        g.a aVar2 = aVar;
        k.c(str3, "amount");
        k.c(str4, "txnToken");
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String M = net.one97.paytm.bankCommon.utils.d.M();
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userToken", str4);
        hashMap.put("authorization", jSONObject.toString());
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept", "application/json");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("amount", str3);
        jSONObject2.put("channel", "MOB");
        jSONObject2.put("channel_id", "APP");
        if (jSONArray2 != null) {
            jSONObject2.put("fd_list", jSONArray2);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        if (j.a().equals("ICA")) {
            jSONObject2.put("entity_id", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
            jSONObject2.put(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
        } else {
            jSONObject2.put("entity_id", "");
            jSONObject2.put(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        String jSONObject3 = jSONObject2.toString();
        a.C0715a aVar3 = a.C0715a.POST;
        a.c cVar = a.c.PAYMENTSBANK;
        net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(M, bVar, aVar, new SlfdCreateRedeemResponse((String) null, (String) null, (Integer) null, (String) null, (String) null, 31, (kotlin.g.b.g) null), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject3, aVar3, cVar, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(bVar2);
            return;
        }
        aVar2.onErrorResponse(-1, new SlfdCreateRedeemResponse((String) null, (String) null, (Integer) null, (String) null, (String) null, 31, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        String str2 = str;
        g.a aVar2 = aVar;
        k.c(str2, "amount");
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String o = net.one97.paytm.bankCommon.utils.d.o();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        Uri.Builder buildUpon = Uri.parse(o).buildUpon();
        buildUpon.appendQueryParameter("amount", str2);
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("caId", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
            buildUpon.appendQueryParameter("strategy", "IBL");
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
            buildUpon.appendQueryParameter("strategy", "INHOUSE");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new ViewLifoFdResponse((String) null, 0, (String) null, (String) null, (List) null, 31, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new ViewLifoFdResponse((String) null, 0, (String) null, (String) null, (List) null, 31, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void b(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        String str2 = str;
        g.a aVar2 = aVar;
        k.c(str2, "fdId");
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String t = net.one97.paytm.bankCommon.utils.d.t();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        Uri.Builder buildUpon = Uri.parse(t).buildUpon();
        buildUpon.appendPath(str2);
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("caId", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
            buildUpon.appendQueryParameter("strategy", "IBL");
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new FdDetailsResponse(0.0d, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, 0.0d, 0.0d, 0.0d, (String) null, (String) null, (String) null, (String) null, 0.0d, (Double) null, (NomineeDetailsResponse) null, 262143, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new FdDetailsResponse(0.0d, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, 0.0d, 0.0d, 0.0d, (String) null, (String) null, (String) null, (String) null, 0.0d, (Double) null, (NomineeDetailsResponse) null, 262143, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void a(String str, Double d2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        g.a aVar2 = aVar;
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String t = net.one97.paytm.bankCommon.utils.d.t();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        Uri.Builder buildUpon = Uri.parse(t).buildUpon();
        buildUpon.appendPath(str);
        buildUpon.appendPath("trial-closure");
        buildUpon.appendQueryParameter("amount", String.valueOf(d2));
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("caId", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
            buildUpon.appendQueryParameter("strategy", "IBL");
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new AmountDetailsResponse(0.0d, 0.0d, (String) null, 0.0d, 0, (String) null, 0.0d, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new AmountDetailsResponse(0.0d, 0.0d, (String) null, 0.0d, 0, (String) null, 0.0d, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void c(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String q = net.one97.paytm.bankCommon.utils.d.q();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Token", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(q, bVar, aVar, new SlfdNomineeListModel(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new SlfdNomineeListModel(), new NetworkCustomError());
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, String str3) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "productType");
        k.c(str2, "amount");
        k.c(str3, SDKConstants.TXN_TYPE);
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        Uri.Builder buildUpon = Uri.parse(net.one97.paytm.bankCommon.utils.d.r()).buildUpon();
        buildUpon.appendQueryParameter("amount", str2).appendQueryParameter("txn_type", str3);
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new ValidateSlfdModel(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new ValidateSlfdModel(), new NetworkCustomError());
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, boolean z, String str3) {
        l lVar;
        g.a aVar2 = aVar;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.c(str4, "amount");
        k.c(str5, "nomineeId");
        k.c(str6, "txnToken");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String m = net.one97.paytm.bankCommon.utils.d.m();
        HashMap hashMap = new HashMap();
        hashMap.put(UpiRequestBuilder.SESSION_TOKEN, str6);
        o oVar = new o();
        oVar.a("amount", str4);
        oVar.a("channel", "MOB");
        oVar.a("channel_id", "APP");
        Boolean valueOf = Boolean.valueOf(z);
        if (valueOf == null) {
            lVar = com.google.gson.n.f39635a;
        } else {
            lVar = new r(valueOf);
        }
        oVar.a("nominee_preference", lVar);
        if (z) {
            oVar.a("nominee_id", str5);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(m, bVar, aVar, new SlfdCreateRedeemResponse((String) null, (String) null, (Integer) null, (String) null, (String) null, 31, (kotlin.g.b.g) null), hashMap, oVar.toString(), a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(bVar2);
            return;
        }
        aVar2.onErrorResponse(-1, new SlfdCreateRedeemResponse((String) null, (String) null, (Integer) null, (String) null, (String) null, 31, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void a(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        String str3 = str;
        String str4 = str2;
        g.a aVar2 = aVar;
        k.c(str3, "orderId");
        k.c(str4, "custId");
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String s = net.one97.paytm.bankCommon.utils.d.s();
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", d.a(this.f18950a));
        Uri.Builder buildUpon = Uri.parse(s).buildUpon();
        buildUpon.appendQueryParameter("order_id", str3).appendQueryParameter("cust_id", str4);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), bVar, aVar, new TransactionDetailResponse((BookingResponse) null, (RedemptionResponse) null, 3, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(aVar3);
            return;
        }
        aVar2.onErrorResponse(-1, new TransactionDetailResponse((BookingResponse) null, (RedemptionResponse) null, 3, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void c(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "accNo");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", "Slfd");
        net.one97.paytm.bankCommon.g.f c2 = net.one97.paytm.paymentsBank.b.a.c(this.f18950a, str, bVar, aVar, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(c2);
            return;
        }
        aVar.onErrorResponse(-1, new PBCJRAccountSummary(), new NetworkCustomError());
    }

    public final void d(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String e2 = net.one97.paytm.bankCommon.utils.d.e();
        if (URLUtil.isValidUrl(e2)) {
            String e3 = com.paytm.utility.b.e(this.f18950a, e2);
            Map<String, String> e4 = net.one97.paytm.bankCommon.mapping.d.e(this.f18950a);
            if (com.paytm.utility.b.c(this.f18950a)) {
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                this.f18950a.getApplicationContext();
                c.a();
                c.a(new net.one97.paytm.bankCommon.g.a(e3, bVar, aVar, new PBKYCFetchTnc(), e4, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
                return;
            }
            aVar.onErrorResponse(-1, new PBKYCFetchTnc(), new NetworkCustomError());
        }
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, ArrayList<PBTncData> arrayList) {
        g.a aVar2 = aVar;
        g.b<IJRPaytmDataModel> bVar2 = bVar;
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.c(arrayList, "tncDataList");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String d2 = net.one97.paytm.bankCommon.utils.d.d();
        if (URLUtil.isValidUrl(d2)) {
            String e2 = com.paytm.utility.b.e(this.f18950a, d2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mode", "clickthrough");
                if (this.f18950a.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
                    jSONObject.put("deviceId", com.paytm.utility.b.e(this.f18950a));
                    JSONArray jSONArray = new JSONArray();
                    Iterator<PBTncData> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        PBTncData next = it2.next();
                        if (next != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", next.getCode());
                            jSONObject2.put("version", next.getVersion());
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("tnCList", jSONArray);
                    String jSONObject3 = jSONObject.toString();
                    k.a((Object) jSONObject3, "requestBody.toString()");
                    Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(this.f18950a);
                    if (com.paytm.utility.b.c(this.f18950a)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("screen_name", getClass().getSimpleName());
                        this.f18950a.getApplicationContext();
                        c.a();
                        c.a(new net.one97.paytm.bankCommon.g.b(e2, bVar, aVar, (IJRPaytmDataModel) new PBKYCTncAccept(), (Map<String, String>) null, e3, jSONObject3, a.C0715a.PUT, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap));
                        return;
                    }
                    aVar2.onErrorResponse(-1, new PBKYCTncAccept(), new NetworkCustomError());
                    return;
                }
                throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    private final String a(String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
            buildUpon.appendQueryParameter("entity_id", net.one97.paytm.bankCommon.h.c.d(this.f18950a));
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        String builder = buildUpon.toString();
        k.a((Object) builder, "builder.toString()");
        return builder;
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2) {
        g.a aVar2 = aVar;
        String str3 = str;
        String str4 = str2;
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        k.c(str3, "type");
        HashMap hashMap = new HashMap();
        String a2 = d.a(this.f18950a);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userToken", a2);
        hashMap.put("authorization", jSONObject.toString());
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept", "application/json");
        hashMap.put("client", "APP");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String L = net.one97.paytm.bankCommon.utils.d.L();
        k.a((Object) L, "url");
        String a3 = a(L);
        o oVar = new o();
        if (str4 != null) {
            oVar.a("order_id", str4);
        }
        oVar.a("page_size", (Number) 20);
        oVar.a("txn_type", str3);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(a3, bVar, aVar, new SlfdTransactionModel((String) null, (String) null, (ArrayList) null, false, 15, (kotlin.g.b.g) null), hashMap, oVar.toString(), a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(bVar2);
            return;
        }
        aVar2.onErrorResponse(-1, new SlfdTransactionModel((String) null, (String) null, (ArrayList) null, false, 15, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str) {
        k.c(context, "mContext");
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.c(str, "accountType");
        try {
            if (com.paytm.utility.b.c(context)) {
                HashMap hashMap = new HashMap();
                String simpleName = getClass().getSimpleName();
                k.a((Object) simpleName, "javaClass.simpleName");
                hashMap.put("screen_name", simpleName);
                net.one97.paytm.bankCommon.g.f b2 = net.one97.paytm.paymentsBank.b.a.b(context, "ISA", bVar, aVar, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
                context.getApplicationContext();
                c.a();
                c.a(b2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        g.a aVar2 = aVar;
        k.c(bVar, "onSuccess");
        k.c(aVar2, "onFailure");
        HashMap hashMap = new HashMap();
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap.put("screen_name", simpleName);
        String str = "ICA";
        if (!k.a((Object) j.a(), (Object) str)) {
            str = "ISA";
        }
        String i2 = n.i();
        Map hashMap2 = new HashMap();
        String a2 = d.a(this.f18950a);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        hashMap2.put("user-token", a2);
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("accept", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, "IBL");
        jSONObject.put("cifType", str);
        jSONObject.put("requestType", "impulse_booking");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("SLFD_IBL_CIF");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("iblCifCustomisation", jSONObject);
        jSONObject2.put("products", jSONArray);
        net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(i2, bVar, aVar, (IJRPaytmDataModel) new CIFCreationResponse((String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Boolean) null, 127, (kotlin.g.b.g) null), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject2.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        if (com.paytm.utility.b.c(this.f18950a)) {
            c.a();
            c.a(bVar2);
            return;
        }
        aVar2.onErrorResponse(-1, new CIFCreationResponse((String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Boolean) null, 127, (kotlin.g.b.g) null), new NetworkCustomError());
    }

    public final void f(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        String h2 = n.h();
        Map hashMap = new HashMap();
        String a2 = d.a(this.f18950a);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        hashMap.put("user-token", a2);
        hashMap.put("client-id", UpiConstants.B2C_ANDROID);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept", "application/json");
        HashMap hashMap2 = new HashMap();
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap2.put("screen_name", simpleName);
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(h2, bVar, aVar, new CIFStatusResponse(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        if (com.paytm.utility.b.c(this.f18950a)) {
            this.f18950a.getApplicationContext();
            c.a();
            net.one97.paytm.bankCommon.g.f fVar = aVar2;
            c.b(fVar);
            this.f18950a.getApplicationContext();
            c.a();
            c.a(fVar);
            return;
        }
        aVar.onErrorResponse(-1, new CIFStatusResponse(), new NetworkCustomError());
    }
}
