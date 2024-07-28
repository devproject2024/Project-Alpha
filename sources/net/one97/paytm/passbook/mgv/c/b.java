package net.one97.paytm.passbook.mgv.c;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.s;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo;
import net.one97.paytm.passbook.beans.mgv.FetchTransactionsResponse;
import net.one97.paytm.passbook.beans.mgv.TransactionListPGResponse;
import net.one97.paytm.passbook.beans.mgv.UserCardDetail;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class b extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    int f57977a;

    /* renamed from: b  reason: collision with root package name */
    int f57978b = 20;

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f57979c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<e> f57980d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<ArrayList<AccountTransactionInfo>> f57981e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<s<Integer, IJRPaytmDataModel, NetworkCustomError>> f57982f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<String> f57983g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<AccountTransactionInfo> f57984h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    boolean f57985i;
    String j = "";
    String k = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.j = str;
    }

    public final void a(String str, String str2, String str3, UserCardDetail userCardDetail) {
        String str4 = str2;
        UserCardDetail userCardDetail2 = userCardDetail;
        k.c(str, PayUtility.TEMPLATE_ID);
        k.c(str4, "changedDateStart");
        k.c(str3, "cardNo");
        k.c(userCardDetail2, "mUserCardDetail");
        if (!this.f57985i) {
            x.e eVar = new x.e();
            eVar.element = "yyyy-MM-dd";
            x.e eVar2 = new x.e();
            eVar2.element = "yyyy-MM-dd'T'HH:mm:ss";
            if (TextUtils.isEmpty(this.j)) {
                this.k = str4;
                String k2 = net.one97.paytm.passbook.mapping.a.k(str4, (String) eVar2.element);
                k.a((Object) k2, "CJRAppUtility.addDaysToD…t, 30, dateFormatEndDate)");
                this.j = k2;
                String l = net.one97.paytm.passbook.mapping.a.l(this.j, (String) eVar2.element);
                k.a((Object) l, "CJRAppUtility.dateValida…teEnd, dateFormatEndDate)");
                this.j = l;
            }
            if (net.one97.paytm.passbook.mapping.a.k(this.k, this.j, (String) eVar.element) == 0) {
                this.f57985i = true;
                this.f57984h.add(new AccountTransactionInfo("PURCHASED", userCardDetail.getTotalAmount(), "", "", userCardDetail.getCreateTime(), "", "", "", userCardDetail.getTotalAmount()));
                this.f57981e.postValue(this.f57984h);
                return;
            }
            net.one97.paytm.passbook.mgv.b.a aVar = net.one97.paytm.passbook.mgv.b.a.f57962a;
            Application application = getApplication();
            k.a((Object) application, "getApplication()");
            int i2 = this.f57978b;
            String str5 = this.k;
            String str6 = this.j;
            a(net.one97.paytm.passbook.mgv.b.a.a(application, i2, this.f57977a + 1, str5, str6, str3, new a(this, eVar, eVar2, userCardDetail2), new C1102b(this)));
        }
    }

    public static final class a implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57986a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57987b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f57988c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ UserCardDetail f57989d;

        a(b bVar, x.e eVar, x.e eVar2, UserCardDetail userCardDetail) {
            this.f57986a = bVar;
            this.f57987b = eVar;
            this.f57988c = eVar2;
            this.f57989d = userCardDetail;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            k.c(iJRDataModel, Payload.RESPONSE);
            this.f57986a.f57979c.postValue(Boolean.FALSE);
            FetchTransactionsResponse fetchTransactionsResponse = (FetchTransactionsResponse) iJRDataModel;
            if ("SUCCESS".equals(fetchTransactionsResponse.getStatus())) {
                TransactionListPGResponse data = fetchTransactionsResponse.getData();
                if (data != null) {
                    int i2 = this.f57986a.f57977a + 1;
                    TransactionListPGResponse data2 = fetchTransactionsResponse.getData();
                    if (data2 == null) {
                        k.a();
                    }
                    if (i2 >= data2.getPaginator().getPageSize()) {
                        b bVar = this.f57986a;
                        bVar.f57977a = 0;
                        String l = net.one97.paytm.passbook.mapping.a.l(bVar.j, (String) this.f57987b.element);
                        k.a((Object) l, "CJRAppUtility.dateValida…angedDateEnd, dateFormat)");
                        k.c(l, "<set-?>");
                        bVar.k = l;
                        b bVar2 = this.f57986a;
                        String k = net.one97.paytm.passbook.mapping.a.k(bVar2.j, (String) this.f57988c.element);
                        k.a((Object) k, "CJRAppUtility.addDaysToD…d, 30, dateFormatEndDate)");
                        bVar2.a(k);
                        b bVar3 = this.f57986a;
                        String l2 = net.one97.paytm.passbook.mapping.a.l(bVar3.j, (String) this.f57988c.element);
                        k.a((Object) l2, "CJRAppUtility.dateValida…teEnd, dateFormatEndDate)");
                        bVar3.a(l2);
                    }
                    this.f57986a.f57977a++;
                    if (data.getAccountTransactionInfos().size() < this.f57986a.f57978b) {
                        this.f57986a.f57985i = true;
                    }
                    this.f57986a.f57984h.addAll(data.getAccountTransactionInfos());
                    if (this.f57986a.f57985i) {
                        this.f57986a.f57984h.add(new AccountTransactionInfo("PURCHASED", this.f57989d.getTotalAmount(), "", "", this.f57989d.getCreateTime(), "", "", "", this.f57989d.getTotalAmount()));
                    }
                    this.f57986a.f57981e.postValue(this.f57986a.f57984h);
                    return;
                }
                return;
            }
            this.f57986a.f57983g.postValue(fetchTransactionsResponse.getErrorMessage());
        }
    }

    /* renamed from: net.one97.paytm.passbook.mgv.c.b$b  reason: collision with other inner class name */
    static final class C1102b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57990a;

        C1102b(b bVar) {
            this.f57990a = bVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f57990a.f57979c.postValue(Boolean.FALSE);
            this.f57990a.f57982f.postValue(new s(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError));
        }
    }

    public final void a(e eVar) {
        k.c(eVar, "request");
        if (net.one97.paytm.passbook.mapping.a.c((Context) getApplication())) {
            getApplication();
            c.a();
            c.b(eVar);
            this.f57979c.postValue(Boolean.TRUE);
            return;
        }
        this.f57980d.postValue(eVar);
    }
}
