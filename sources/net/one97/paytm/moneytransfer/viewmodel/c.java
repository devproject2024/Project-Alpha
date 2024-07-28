package net.one97.paytm.moneytransfer.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.viewmodel.b;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.requestmoney.b.a.a;

public final class c extends androidx.lifecycle.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f54709f = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final y<ArrayList<String>> f54710a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<b.C0979b>> f54711b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<b>> f54712c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<List<IJRDataModel>>> f54713d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public final net.one97.paytm.upi.registration.b.a.b f54714e;

    /* renamed from: g  reason: collision with root package name */
    private final String f54715g = "MoneyTransferBankAccountOrUPIViewModel";

    /* renamed from: h  reason: collision with root package name */
    private final String f54716h = "AddBankAccountOrUPI";

    /* renamed from: i  reason: collision with root package name */
    private final ArrayList<String> f54717i = new ArrayList<>();
    private net.one97.paytm.upi.requestmoney.b.a.b j;
    private net.one97.paytm.moneytransfer.b.a.b k;
    private net.one97.paytm.moneytransfer.b.a.a l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
        getApplication();
        this.f54714e = g.a((net.one97.paytm.upi.h.a) null);
        this.j = g.c();
        Context context = application;
        this.k = net.one97.paytm.moneytransfer.b.a(context);
        this.l = net.one97.paytm.moneytransfer.b.a.a.d.a(context);
    }

    public final void a(String str) {
        k.c(str, "query");
        String substring = str.substring(p.a((CharSequence) str, "@", 0, false, 6) + 1, str.length());
        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ArrayList<String> arrayList = this.f54717i;
        if (arrayList == null || arrayList.size() == 0) {
            c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
            List<String> a2 = p.a((CharSequence) net.one97.paytm.moneytransfer.d.c.a(c.a.a().f53991f), new String[]{AppConstants.COMMA});
            if (a2 != null && (!a2.isEmpty())) {
                for (String next : a2) {
                    ArrayList<String> arrayList2 = this.f54717i;
                    if (arrayList2 != null) {
                        arrayList2.add(next);
                    }
                }
                this.f54710a.setValue(this.f54717i);
                return;
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList<String> arrayList4 = this.f54717i;
        if (arrayList4 != null) {
            Iterator<String> it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                k.a((Object) next2, "t");
                if (next2 != null) {
                    String lowerCase = next2.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (p.b(lowerCase, substring, false)) {
                        arrayList3.add(next2);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
        }
        y<ArrayList<String>> yVar = this.f54710a;
        if (yVar != null) {
            yVar.setValue(arrayList3);
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.viewmodel.c$c  reason: collision with other inner class name */
    public static final class C0980c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f54719a;

        C0980c(c cVar) {
            this.f54719a = cVar;
        }

        public final void onSuccess(CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase) {
            ArrayList<BeneficiaryEntity> beneficiariesList = cJRKYCBeneficiaryBase != null ? cJRKYCBeneficiaryBase.getBeneficiariesList() : null;
            if (beneficiariesList != null && beneficiariesList.size() > 0) {
                y a2 = this.f54719a.f54713d;
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                a2.setValue(c.a.a(beneficiariesList));
            }
        }
    }

    public final void a() {
        net.one97.paytm.moneytransfer.b.a.a aVar = this.l;
        if (aVar != null) {
            aVar.a((a.C0960a) null, (a.b) new C0980c(this));
        }
    }

    public final void b(String str) {
        k.c(str, "vpa");
        y<net.one97.paytm.moneytransfer.model.c<b.C0979b>> yVar = this.f54711b;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        if (com.paytm.utility.a.m(getApplication())) {
            net.one97.paytm.upi.requestmoney.b.a.b bVar = this.j;
            if (bVar != null) {
                bVar.b(new e(this), this.f54715g, str, "xyz", this.f54716h);
                return;
            }
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setAlertMessage("We can not detect any internet connectivity. Please check your internet connection and try again.");
        upiCustomVolleyError.setmAlertTitle("No Internet Connection");
        y<net.one97.paytm.moneytransfer.model.c<b.C0979b>> yVar2 = this.f54711b;
        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar2.setValue(c.a.a(upiCustomVolleyError));
    }

    public static final class e implements a.C1402a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f54721a;

        e(c cVar) {
            this.f54721a = cVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof ValidateVpaResponse) {
                ValidateVpaResponse validateVpaResponse = (ValidateVpaResponse) upiBaseDataModel;
                String respCode = validateVpaResponse.getRespCode();
                if (respCode == null) {
                    respCode = "";
                }
                if (p.a(validateVpaResponse.getStatus(), "success", true) && p.a("0", respCode, true)) {
                    String name = validateVpaResponse.getName();
                    if (name == null) {
                        name = "";
                    }
                    if (!TextUtils.isEmpty(name)) {
                        y b2 = this.f54721a.f54711b;
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        String signStatus = validateVpaResponse.getSignStatus();
                        if (signStatus == null) {
                            signStatus = "";
                        }
                        b2.setValue(c.a.a(new b.C0979b(0, name, "", signStatus)));
                        return;
                    }
                    y b3 = this.f54721a.f54711b;
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b3.setValue(c.a.a(new b.C0979b(1, name, respCode, "")));
                } else if ("37".equals(respCode)) {
                    y b4 = this.f54721a.f54711b;
                    c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b4.setValue(c.a.a(new b.C0979b(1, "", respCode, "")));
                } else {
                    y b5 = this.f54721a.f54711b;
                    c.a aVar4 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b5.setValue(c.a.a(new b.C0979b(2, "", respCode, "")));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y b2 = this.f54721a.f54711b;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            b2.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public final void c(String str) {
        k.c(str, "ifsc");
        y<net.one97.paytm.moneytransfer.model.c<b>> yVar = this.f54712c;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        if (com.paytm.utility.a.m(getApplication())) {
            net.one97.paytm.moneytransfer.b.a.b bVar = this.k;
            if (bVar != null) {
                bVar.a((a.C0960a) new d(this), this.f54715g, str);
                return;
            }
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setAlertMessage("We can not detect any internet connectivity. Please check your internet connection and try again.");
        upiCustomVolleyError.setmAlertTitle("No Internet Connection");
        y<net.one97.paytm.moneytransfer.model.c<b.C0979b>> yVar2 = this.f54711b;
        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar2.setValue(c.a.a(upiCustomVolleyError));
    }

    public static final class d implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f54720a;

        d(c cVar) {
            this.f54720a = cVar;
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y c2 = this.f54720a.f54712c;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            c2.setValue(c.a.a(upiCustomVolleyError));
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null) {
                CJRBankDetails cJRBankDetails = (CJRBankDetails) iJRPaytmDataModel;
                if (cJRBankDetails.getStatusCode() == null || !p.a(cJRBankDetails.getStatusCode(), "SUCCESS", true) || cJRBankDetails.getResponse() == null) {
                    y c2 = this.f54720a.f54712c;
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    c2.setValue(c.a.a(new b(cJRBankDetails)));
                    return;
                }
                y c3 = this.f54720a.f54712c;
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c3.setValue(c.a.a(new b(cJRBankDetails)));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.wallet.CJRBankDetails");
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final CJRBankDetails f54718a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && k.a((Object) this.f54718a, (Object) ((b) obj).f54718a);
            }
            return true;
        }

        public final int hashCode() {
            CJRBankDetails cJRBankDetails = this.f54718a;
            if (cJRBankDetails != null) {
                return cJRBankDetails.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "UPIIfscVerifyModel(cjrBankDetails=" + this.f54718a + ")";
        }

        public b(CJRBankDetails cJRBankDetails) {
            k.c(cJRBankDetails, "cjrBankDetails");
            this.f54718a = cJRBankDetails;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
