package net.one97.paytm.coins.d;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.coins.model.BalanceModel;
import net.one97.paytm.coins.model.CheckBalanceApiModel;
import net.one97.paytm.coins.model.LoyaltyModel;
import net.one97.paytm.coins.model.PaginatorModel;
import net.one97.paytm.coins.model.PaytmCoinsPassBookModel;
import net.one97.paytm.coins.model.ResponseModel;
import net.one97.paytm.coins.model.ResultModel;
import net.one97.paytm.coins.model.TransactionHeader;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;
import org.json.JSONObject;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<CheckBalanceApiModel> f16754a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<ArrayList<LoyaltyModel>> f16755b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f16756c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f16757d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public PaginatorModel f16758e = new PaginatorModel((Integer) null, (Integer) null, (Integer) null, (Integer) null, 15, (g) null);

    /* renamed from: f  reason: collision with root package name */
    public y<NetworkCustomError> f16759f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public String f16760g = "0";

    /* renamed from: h  reason: collision with root package name */
    public boolean f16761h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f16762i = 1;
    /* access modifiers changed from: private */
    public ArrayList<LoyaltyModel> j = new ArrayList<>();

    public final int a() {
        ArrayList<LoyaltyModel> arrayList = this.j;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void b() {
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String z = f.z();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("body", new JSONObject());
        jSONObject.put("request", jSONObject2);
        d.a aVar = d.f20859a;
        d.a.c().a(a.C0715a.POST).a(z).b(jSONObject.toString()).a((Map<String, String>) d()).a((IJRPaytmDataModel) new CheckBalanceApiModel((BalanceModel) null, 1, (g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("PaytmCoinLandingActivity").a((com.paytm.network.listener.b) new C0248a(this)).l().a();
    }

    /* renamed from: net.one97.paytm.coins.d.a$a  reason: collision with other inner class name */
    public static final class C0248a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16763a;

        C0248a(a aVar) {
            this.f16763a = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            String activeBalance;
            if (iJRPaytmDataModel == null) {
                this.f16763a.f16757d.postValue(Boolean.TRUE);
            } else if (iJRPaytmDataModel instanceof CheckBalanceApiModel) {
                this.f16763a.f16754a.postValue(iJRPaytmDataModel);
                BalanceModel response = ((CheckBalanceApiModel) iJRPaytmDataModel).getResponse();
                if (response != null && (activeBalance = response.getActiveBalance()) != null) {
                    this.f16763a.f16760g = activeBalance;
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "p1");
            k.c(networkCustomError, "p2");
            this.f16763a.f16759f.postValue(networkCustomError);
            this.f16763a.f16757d.postValue(Boolean.TRUE);
        }
    }

    private static HashMap<String, String> d() {
        HashMap<String, String> appCommonHeaders = net.one97.paytm.vipcashback.c.a.b().getAppCommonHeaders();
        if (appCommonHeaders == null) {
            appCommonHeaders = new HashMap<>();
        }
        appCommonHeaders.put("Content-Type", "application/json");
        net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
        k.a((Object) b2, "CashbackHelper.getImplListener()");
        appCommonHeaders.put("ssotoken", b2.getSSOToken());
        return appCommonHeaders;
    }

    public final void c() {
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String B = f.B();
        String a2 = a(this.f16762i);
        d.a aVar = d.f20859a;
        d.a.c().a(a.C0715a.POST).a(B).b(a2).a((Map<String, String>) d()).a((IJRPaytmDataModel) new PaytmCoinsPassBookModel((ResponseModel) null, 1, (g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("PaytmCoinLandingActivity").a((com.paytm.network.listener.b) new b(this)).l().a();
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16764a;

        b(a aVar) {
            this.f16764a = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null) {
                this.f16764a.f16756c.postValue(Boolean.TRUE);
            } else if (iJRPaytmDataModel instanceof PaytmCoinsPassBookModel) {
                PaytmCoinsPassBookModel paytmCoinsPassBookModel = (PaytmCoinsPassBookModel) iJRPaytmDataModel;
                ResponseModel response = paytmCoinsPassBookModel.getResponse();
                PaginatorModel paginatorModel = null;
                if ((response != null ? response.getResult() : null) != null) {
                    ResponseModel response2 = paytmCoinsPassBookModel.getResponse();
                    if (response2 == null) {
                        k.a();
                    }
                    ResultModel result = response2.getResult();
                    if (result == null) {
                        k.a();
                    }
                    if ("S".equals(result.getResultStatus())) {
                        ResponseModel response3 = paytmCoinsPassBookModel.getResponse();
                        if (response3 != null) {
                            paginatorModel = response3.getPaginator();
                        }
                        if (paginatorModel != null) {
                            a aVar = this.f16764a;
                            ResponseModel response4 = paytmCoinsPassBookModel.getResponse();
                            if (response4 == null) {
                                k.a();
                            }
                            PaginatorModel paginator = response4.getPaginator();
                            if (paginator == null) {
                                k.a();
                            }
                            aVar.f16758e = paginator;
                        }
                        ResponseModel response5 = paytmCoinsPassBookModel.getResponse();
                        if (response5 == null) {
                            k.a();
                        }
                        ArrayList<LoyaltyModel> loyaltyPoints = response5.getLoyaltyPoints();
                        if (loyaltyPoints != null) {
                            a.a(this.f16764a, (ArrayList) loyaltyPoints);
                            this.f16764a.f16755b.postValue(this.f16764a.j);
                            a aVar2 = this.f16764a;
                            aVar2.f16762i = aVar2.f16762i + 1;
                            return;
                        }
                        this.f16764a.f16756c.postValue(Boolean.TRUE);
                        return;
                    }
                    this.f16764a.f16756c.postValue(Boolean.TRUE);
                    return;
                }
                this.f16764a.f16756c.postValue(Boolean.TRUE);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "p1");
            k.c(networkCustomError, "error");
            this.f16764a.f16756c.postValue(Boolean.TRUE);
            this.f16764a.f16759f.postValue(networkCustomError);
        }
    }

    private static String a(int i2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject.put("request", jSONObject2);
        jSONObject2.put("body", jSONObject3);
        jSONObject3.put("pageNum", i2);
        jSONObject3.put("pageSize", 20);
        String jSONObject4 = jSONObject.toString();
        k.a((Object) jSONObject4, "jsonObject.toString()");
        return jSONObject4;
    }

    public static final /* synthetic */ void a(a aVar, ArrayList arrayList) {
        String str;
        String str2;
        if (arrayList.size() == 0) {
            aVar.f16761h = false;
        }
        if (aVar.j.size() > 0) {
            str = ((LoyaltyModel) kotlin.a.k.f(aVar.j)).getAccountingTimestamp();
            if (str == null) {
                k.a();
            }
        } else {
            str = "";
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            LoyaltyModel loyaltyModel = (LoyaltyModel) it2.next();
            net.one97.paytm.coins.c.d dVar = net.one97.paytm.coins.c.d.f16733a;
            String accountingTimestamp = loyaltyModel.getAccountingTimestamp();
            if (accountingTimestamp == null) {
                k.a();
            }
            String a2 = net.one97.paytm.coins.c.d.a(accountingTimestamp, "yyyy-MM-dd HH:mm:ss", "dd MMM yyyy");
            net.one97.paytm.coins.c.d dVar2 = net.one97.paytm.coins.c.d.f16733a;
            k.c(a2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            Date parse = new SimpleDateFormat("dd MMM yyyy").parse(a2);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "_calender");
            instance.setTime(parse);
            Calendar instance2 = Calendar.getInstance();
            if (instance2.get(5) == instance.get(5)) {
                str2 = "Today, ".concat(String.valueOf(a2));
            } else if (instance2.get(5) - instance.get(5) == 1) {
                str2 = "Yesterday, ".concat(String.valueOf(a2));
            } else {
                str2 = net.one97.paytm.coins.c.d.a(a2, "dd MMM yyyy", "EEEE, dd MMM yyyy");
            }
            if (aVar.j.size() == 0) {
                aVar.j.add(new TransactionHeader(str2));
            } else if (!p.a(a2, str, true)) {
                aVar.j.add(new TransactionHeader(str2));
            }
            net.one97.paytm.coins.c.d dVar3 = net.one97.paytm.coins.c.d.f16733a;
            String accountingTimestamp2 = loyaltyModel.getAccountingTimestamp();
            if (accountingTimestamp2 == null) {
                k.a();
            }
            loyaltyModel.setFormattedTxnTime(net.one97.paytm.coins.c.d.a(accountingTimestamp2, "yyyy-MM-dd HH:mm:ss", "hh:mm a"));
            loyaltyModel.setTxnDate(a2);
            aVar.j.add(loyaltyModel);
            str = a2;
        }
    }
}
