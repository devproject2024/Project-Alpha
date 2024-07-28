package net.one97.paytm.passbook.subWallet.d;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.v;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.subWallet.model.TransactionHeader;
import net.one97.paytm.passbook.utility.n;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends androidx.lifecycle.a implements g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public y<ArrayList<CJRTransaction>> f58909a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<e> f58910b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f58911c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f58912d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58913e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<CJRTransaction> f58914f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private int f58915g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str;
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        this.f58911c.postValue(Boolean.FALSE);
        if (iJRDataModel instanceof CJRLedger) {
            this.f58912d = false;
            CJRLedger cJRLedger = (CJRLedger) iJRDataModel;
            ArrayList<CJRTransaction> transactionList = cJRLedger.getTransactionList();
            if (transactionList != null) {
                this.f58915g += transactionList.size();
            }
            ArrayList<CJRTransaction> transactionList2 = cJRLedger.getTransactionList();
            k.a((Object) transactionList2, "response.transactionList");
            if (transactionList2.size() == 0) {
                this.f58913e = true;
            }
            if (this.f58914f.size() > 0) {
                str = ((CJRTransaction) kotlin.a.k.f(this.f58914f)).getTxnDate();
                k.a((Object) str, "mFormattedTransactionsList.last().txnDate");
            } else {
                str = "";
            }
            Iterator<CJRTransaction> it2 = transactionList2.iterator();
            while (it2.hasNext()) {
                CJRTransaction next = it2.next();
                k.a((Object) next, "transaction");
                String txnDate = next.getTxnDate();
                k.a((Object) txnDate, "transaction.txnDate");
                String format = new SimpleDateFormat("dd MMM yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(txnDate));
                k.a((Object) format, "outputFormat.format(dt)");
                if (format != null) {
                    String upperCase = format.toUpperCase();
                    k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                    if (this.f58914f.size() == 0) {
                        this.f58914f.add(new TransactionHeader(upperCase));
                    } else if (!p.a(upperCase, str, true)) {
                        this.f58914f.add(new TransactionHeader(upperCase));
                    }
                    String txnDate2 = next.getTxnDate();
                    k.a((Object) txnDate2, "transaction.txnDate");
                    String format2 = new SimpleDateFormat("hh:mm a").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(txnDate2));
                    k.a((Object) format2, "outputFormat.format(dt)");
                    if (format2 != null) {
                        String lowerCase = format2.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        next.setFormattedTxnTime(lowerCase);
                        next.setmTxnDate(upperCase);
                        this.f58914f.add(next);
                        str = upperCase;
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            this.f58909a.postValue(this.f58914f);
        }
    }

    public final void a(int i2, String str, String str2) {
        if (!this.f58913e && !this.f58912d) {
            this.f58911c.postValue(Boolean.TRUE);
            String b2 = b(i2, str, str2);
            k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
            String i3 = net.one97.paytm.passbook.mapping.e.i();
            if (i3 != null && URLUtil.isValidUrl(i3)) {
                String e2 = b.e((Context) getApplication(), i3);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("Accept-Encoding", "gzip");
                String a2 = net.one97.paytm.passbook.mapping.b.a(getApplication());
                if (a2 != null) {
                    hashMap.put("ssotoken", a2);
                }
                a(new net.one97.paytm.passbook.mapping.a.b(e2, this, this, new CJRLedger(), hashMap, b2, a.c.PASSBOOK, a.b.USER_FACING, getClass().getName()));
            }
        }
    }

    public final void a(e eVar) {
        k.c(eVar, "request");
        if (!b.c((Context) getApplication())) {
            this.f58910b.postValue(eVar);
            return;
        }
        getApplication();
        c.a();
        c.b(eVar);
    }

    private final String b(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userGuid", "");
        jSONObject2.put("startLimit", this.f58915g);
        jSONObject2.put("lastLimit", 20);
        JSONObject jSONObject3 = new JSONObject();
        ArrayList arrayList = new ArrayList();
        if (i2 == n.TOLL.getValue()) {
            arrayList.add("TOLL");
            jSONObject3.put("subWalletType", new JSONArray(arrayList));
            jSONObject2.put("subWalletParams", jSONObject3);
            jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
        } else if (i2 == n.GIFT_VOUCHER.getValue()) {
            arrayList.add("GIFT_VOUCHER");
            jSONObject3.put("subWalletType", new JSONArray(arrayList));
            jSONObject2.put("subWalletParams", jSONObject3);
            jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
        } else {
            if (v.a(str) || p.a("MAIN", str, true)) {
                arrayList.add("PAYTM WALLET");
            } else {
                if (str == null) {
                    k.a();
                }
                arrayList.add(str);
            }
            jSONObject3.put("subWalletType", new JSONArray(arrayList));
            jSONObject2.put("subWalletParams", jSONObject3);
            jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
        }
        jSONObject3.put("subWalletType", new JSONArray(arrayList));
        jSONObject2.put("subWalletParams", jSONObject3);
        if (TextUtils.isEmpty(str2)) {
            jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
        } else {
            jSONObject2.put("walletTransactiontype", str2);
        }
        jSONObject.put("request", jSONObject2);
        String jSONObject4 = jSONObject.toString();
        k.a((Object) jSONObject4, "jsonObject.toString()");
        return jSONObject4;
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f58911c.postValue(Boolean.FALSE);
    }
}
