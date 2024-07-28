package net.one97.paytm.newaddmoney.c;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.i;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.b.g;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.addmoney.utils.n;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.common.entity.wallet.CJRSubWallet;
import net.one97.paytm.wallet.d.c;
import net.one97.paytm.wallet.f.e;
import net.one97.paytm.wallet.f.f;
import net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers;
import net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney;
import org.json.JSONObject;

public final class a extends androidx.lifecycle.a implements e, f {
    public double A;
    public boolean B;
    public final i<Integer> C = new i<>(0);
    public final i<String> D = new i<>(this.f55836f.get());
    public final i<Integer> E = new i<>(8);
    public final y<Boolean> F = new y<>(Boolean.FALSE);
    public final net.one97.paytm.addmoney.common.d.b G;

    /* renamed from: a  reason: collision with root package name */
    public c f55831a;

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.autoaddmoney.a<NetworkCustomError>> f55832b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<String> f55833c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<o<Boolean, WalletLimitsResponseModelAddMoney>> f55834d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public final i<String> f55835e = new i<>();

    /* renamed from: f  reason: collision with root package name */
    public final i<String> f55836f = new i<>();

    /* renamed from: g  reason: collision with root package name */
    public final y<Boolean> f55837g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final y<Boolean> f55838h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public final y<x> f55839i = new y<>();
    public final i<String> j = new i<>();
    public final i<String> k = new i<>("");
    public final i<String> l = new i<>();
    public final i<String> m = new i<>();
    public final i<String> n = new i<>();
    public final y<net.one97.paytm.newaddmoney.utils.b> o = new y<>();
    public final y<String> p = new y<>();
    public final y<x> q = new y<>();
    public final y<Boolean> r = new y<>();
    public final y<ArrayList<AddMoneyOffers.AddMoneyCodeOffers>> s = new y<>();
    public final y<Boolean> t = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<com.paytm.network.a>> u = new y<>();
    public final y<net.one97.paytm.autoaddmoney.a<net.one97.paytm.autoaddmoney.b.f>> v = new y<>();
    public final y<Boolean> w = new y<>();
    public final y<Double> x = new y<>();
    public final y<List<net.one97.paytm.newaddmoney.b.a>> y = new y<>();
    public io.reactivex.rxjava3.b.b z;

    public static void a(CharSequence charSequence) {
        k.c(charSequence, "s");
    }

    public final void onAddMoneyRequestStart() {
    }

    public final void onAddMoneyVerifyResponse(String str) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(net.one97.paytm.addmoney.common.d.b bVar, Application application) {
        super(application);
        k.c(bVar, "addMoneyRepository");
        k.c(application, "application");
        this.G = bVar;
    }

    public static final class b implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55841a;

        b(a aVar) {
            this.f55841a = aVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRCashWallet) {
                CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                CJRCashWalletResponse response = cJRCashWallet.getResponse();
                String str = null;
                Double valueOf = response != null ? Double.valueOf(response.getPaytmWalletBalance()) : null;
                if (valueOf != null) {
                    valueOf.doubleValue();
                    j.c((Context) this.f55841a.getApplication(), valueOf.doubleValue());
                }
                CJRCashWalletResponse response2 = cJRCashWallet.getResponse();
                k.a((Object) response2, "cashWallet.getResponse()");
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (CJRSubWallet next : response2.getSubWalletDetailList()) {
                    k.a((Object) next, "cashSubWallet");
                    if (next.getSubWalletType() == n.GIFT_VOUCHER.getValue()) {
                        d3 = next.getBalance();
                    }
                }
                j.b((Context) this.f55841a.getApplication(), d3);
                double a2 = j.a(cJRCashWallet.getResponse());
                double b2 = j.b(cJRCashWallet.getResponse());
                j.a((Context) this.f55841a.getApplication(), a2);
                j.d((Context) this.f55841a.getApplication(), b2);
                a aVar = this.f55841a;
                CJRCashWalletResponse response3 = cJRCashWallet.getResponse();
                k.a((Object) response3, "cashWallet?.response");
                aVar.A = response3.getAddableAmount();
                a aVar2 = this.f55841a;
                Context application = aVar2.getApplication();
                CJRCashWalletResponse response4 = cJRCashWallet.getResponse();
                if (response4 != null) {
                    str = response4.getWalletGrade();
                }
                a.a(aVar2, application, str);
                this.f55841a.r.setValue(Boolean.FALSE);
                try {
                    Object a3 = new com.google.gsonhtcfix.f().a(new JSONObject(g.a(g.a(((CJRCashWallet) iJRPaytmDataModel).getNetworkResponse().data))).getJSONObject(Payload.RESPONSE).getJSONArray("subWalletDetailsList").toString(), new C1045a().getType());
                    if (a3 != null) {
                        this.f55841a.y.setValue(a.a((List) a3));
                        List<net.one97.paytm.newaddmoney.b.a> list = (List) this.f55841a.y.getValue();
                        if (list != null) {
                            for (net.one97.paytm.newaddmoney.b.a aVar3 : list) {
                                d2 += aVar3.f55820c;
                            }
                        }
                        this.f55841a.x.setValue(Double.valueOf(d2));
                        this.f55841a.f55837g.postValue(Boolean.TRUE);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.newaddmoney.model.AMSubWallet>");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* renamed from: net.one97.paytm.newaddmoney.c.a$b$a  reason: collision with other inner class name */
        public static final class C1045a extends com.google.gsonhtcfix.c.a<List<? extends net.one97.paytm.newaddmoney.b.a>> {
            C1045a() {
            }
        }

        public final void b(NetworkCustomError networkCustomError) {
            if (this.f55841a.B) {
                if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null && (networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                    this.f55841a.w.setValue(Boolean.TRUE);
                    this.f55841a.r.setValue(Boolean.FALSE);
                    this.f55841a.f55837g.postValue(Boolean.FALSE);
                }
            }
            this.f55841a.f55832b.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
            this.f55841a.r.setValue(Boolean.FALSE);
            this.f55841a.f55837g.postValue(Boolean.FALSE);
        }
    }

    public final void c() {
        this.r.setValue(Boolean.TRUE);
        this.G.c(new b(this), "AddMoney");
    }

    /* renamed from: net.one97.paytm.newaddmoney.c.a$a  reason: collision with other inner class name */
    public static final class C1044a implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55840a;

        public C1044a(a aVar) {
            this.f55840a = aVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof AddMoneyOffers) {
                this.f55840a.s.setValue(((AddMoneyOffers) iJRPaytmDataModel).getOfferCodes());
            }
        }

        public final void b(NetworkCustomError networkCustomError) {
            if (this.f55840a.B) {
                if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null && (networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                    this.f55840a.w.setValue(Boolean.TRUE);
                    return;
                }
            }
            this.f55840a.f55832b.setValue(new net.one97.paytm.autoaddmoney.a(networkCustomError));
        }
    }

    public final void a(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.p.setValue(str);
            }
        }
    }

    public final boolean b(String str) {
        k.c(str, "amount");
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("maxAmountPaytmcash");
        if (TextUtils.isEmpty(str)) {
            this.q.setValue(x.f47997a);
            return false;
        }
        String Q = com.paytm.utility.b.Q(str);
        k.a((Object) Q, "CJRAppCommonUtility.getCleanString(amount)");
        double parseDouble = Double.parseDouble(Q);
        String Q2 = com.paytm.utility.b.Q(f2);
        k.a((Object) Q2, "CJRAppCommonUtility.getCleanString(walletLimit)");
        if (parseDouble <= Double.parseDouble(Q2)) {
            return true;
        }
        a(f2);
        this.f55838h.setValue(Boolean.TRUE);
        return false;
    }

    public final void onAddMoneyInvalidAmountEntered(String str) {
        this.q.setValue(x.f47997a);
    }

    public final void onAddMoneyRequestComplete() {
        this.t.setValue(Boolean.FALSE);
    }

    public final void a() {
        this.w.setValue(Boolean.TRUE);
    }

    public final void a(String str, net.one97.paytm.newaddmoney.utils.b bVar) {
        k.c(str, "amount");
        if (bVar == null || !bVar.equals(net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER)) {
            c cVar = this.f55831a;
            if (cVar != null) {
                cVar.b(false);
            }
        } else {
            c cVar2 = this.f55831a;
            if (cVar2 != null) {
                cVar2.b(true);
            }
        }
        c cVar3 = this.f55831a;
        if (cVar3 != null) {
            cVar3.d(str);
        }
        this.t.setValue(Boolean.TRUE);
    }

    public final void d() {
        this.t.setValue(Boolean.TRUE);
    }

    public final void b() {
        Object value = this.F.getValue();
        if (value == null) {
            k.a();
        }
        k.a(value, "subWalletVisibile.value!!");
        if (((Boolean) value).booleanValue()) {
            this.C.set(0);
            this.D.set(this.f55836f.get());
            this.E.set(8);
            this.F.setValue(Boolean.FALSE);
        }
    }

    public static final /* synthetic */ void a(a aVar, Context context, String str) {
        if (str != null) {
            j.a(context, str);
            aVar.f55833c.setValue(AddMoneyUtils.g(str));
        }
    }

    public static final /* synthetic */ List a(List list) {
        List arrayList = new ArrayList();
        Map linkedHashMap = new LinkedHashMap();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!(((net.one97.paytm.newaddmoney.b.a) list.get(i2)).f55821d == n.LOYALTY_WALLET.getValue() || ((net.one97.paytm.newaddmoney.b.a) list.get(i2)).f55821d == n.LOYALTY_WALLET_TYPE_7.getValue())) {
                if (((net.one97.paytm.newaddmoney.b.a) list.get(i2)).f55821d == n.ALLOWALANCE_WALLET.getValue()) {
                    arrayList.add(list.get(i2));
                } else if (linkedHashMap.containsKey(Integer.valueOf(((net.one97.paytm.newaddmoney.b.a) list.get(i2)).f55821d))) {
                    Integer num = (Integer) linkedHashMap.get(Integer.valueOf(((net.one97.paytm.newaddmoney.b.a) list.get(i2)).f55821d));
                    if (num != null) {
                        ((net.one97.paytm.newaddmoney.b.a) arrayList.get(num.intValue())).f55820c += ((net.one97.paytm.newaddmoney.b.a) list.get(i2)).f55820c;
                    }
                } else {
                    linkedHashMap.put(Integer.valueOf(((net.one97.paytm.newaddmoney.b.a) list.get(i2)).f55821d), Integer.valueOf(arrayList.size()));
                    arrayList.add(list.get(i2));
                }
            }
        }
        return arrayList;
    }
}
