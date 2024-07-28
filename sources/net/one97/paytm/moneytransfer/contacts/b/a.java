package net.one97.paytm.moneytransfer.contacts.b;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.upi.common.PaymentInstrumentationType;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends androidx.lifecycle.a {

    /* renamed from: h  reason: collision with root package name */
    public static final C0965a f53968h = new C0965a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upi.registration.b.a.b f53969a;

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<b>> f53970b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<d>> f53971c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<String>> f53972d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public String f53973e;

    /* renamed from: f  reason: collision with root package name */
    public String f53974f;

    /* renamed from: g  reason: collision with root package name */
    public String f53975g;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.b.a.b f53976i;
    private String j = "";
    /* access modifiers changed from: private */
    public c k;

    public final String a() {
        CharSequence charSequence = this.f53974f;
        if (!(charSequence == null || p.a(charSequence))) {
            return this.f53974f;
        }
        String str = this.f53973e;
        if (str == null) {
            k.a();
        }
        return str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
        this.f53976i = net.one97.paytm.moneytransfer.b.a(application);
        this.f53969a = g.a(g.a((a.C1347a) null));
    }

    public final c b() {
        c cVar = this.k;
        if (cVar == null) {
            k.a("merchantResponseBody");
        }
        return cVar;
    }

    public static final class e implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53984a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f53985b;

        e(a aVar, String str) {
            this.f53984a = aVar;
            this.f53985b = str;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof ConsolidatePaymentInstrumentationRes) {
                ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = (ConsolidatePaymentInstrumentationRes) iJRPaytmDataModel;
                boolean z = false;
                if (consolidatePaymentInstrumentationRes.getGlobalError() != null) {
                    ConsolidatePaymentInstrumentationRes.GlobalError globalError = consolidatePaymentInstrumentationRes.getGlobalError();
                    k.a((Object) globalError, "response.globalError");
                    if (globalError.getErrorList() != null) {
                        ConsolidatePaymentInstrumentationRes.GlobalError globalError2 = consolidatePaymentInstrumentationRes.getGlobalError();
                        k.a((Object) globalError2, "response.globalError");
                        if (globalError2.getErrorList().size() > 0) {
                            y a2 = this.f53984a.f53970b;
                            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                            ConsolidatePaymentInstrumentationRes.GlobalError globalError3 = consolidatePaymentInstrumentationRes.getGlobalError();
                            k.a((Object) globalError3, "response.globalError");
                            ConsolidatePaymentInstrumentationRes.Error error = globalError3.getErrorList().get(0);
                            k.a((Object) error, "response.globalError.errorList[0]");
                            String message = error.getMessage();
                            k.a((Object) message, "response.globalError.errorList[0].message");
                            a2.setValue(c.a.a(new b((ConsolidatePaymentInstrumentationRes.PaymentOptionList) null, message, true)));
                            return;
                        }
                    }
                }
                if (consolidatePaymentInstrumentationRes.getPaymentOptionList() == null || consolidatePaymentInstrumentationRes.getPaymentOptionList().size() <= 0) {
                    CharSequence merchantId = consolidatePaymentInstrumentationRes.getMerchantId();
                    if (merchantId == null || p.a(merchantId)) {
                        z = true;
                    }
                    if (!z) {
                        this.f53984a.k = new c(this.f53985b, consolidatePaymentInstrumentationRes);
                        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                        upiCustomVolleyError.setmErrorCode("1997");
                        y a3 = this.f53984a.f53970b;
                        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                        a3.setValue(c.a.a(upiCustomVolleyError));
                        return;
                    }
                    y a4 = this.f53984a.f53970b;
                    c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    a4.setValue(c.a.a((UpiCustomVolleyError) null));
                    return;
                }
                a aVar4 = this.f53984a;
                List<ConsolidatePaymentInstrumentationRes.PaymentOptionList> paymentOptionList = consolidatePaymentInstrumentationRes.getPaymentOptionList();
                k.a((Object) paymentOptionList, "response.paymentOptionList");
                a.a(aVar4, (List) paymentOptionList);
                for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : consolidatePaymentInstrumentationRes.getPaymentOptionList()) {
                    k.a((Object) next, "paymentOptionListItem");
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment = next.getDestinationPayment();
                    k.a((Object) destinationPayment, "paymentOptionListItem.destinationPayment");
                    if (!p.a(destinationPayment.getPaymentType(), PaymentInstrumentationType.UPI.name(), true)) {
                        ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment2 = next.getDestinationPayment();
                        k.a((Object) destinationPayment2, "paymentOptionListItem.destinationPayment");
                        if (p.a(destinationPayment2.getPaymentType(), PaymentInstrumentationType.BANK.name(), true)) {
                        }
                    }
                    y a5 = this.f53984a.f53970b;
                    c.a aVar5 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    a5.setValue(c.a.a(new b(next, "", false)));
                    return;
                }
                y a6 = this.f53984a.f53970b;
                c.a aVar6 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a6.setValue(c.a.a((UpiCustomVolleyError) null));
                return;
            }
            y a7 = this.f53984a.f53970b;
            c.a aVar7 = net.one97.paytm.moneytransfer.model.c.f54031e;
            a7.setValue(c.a.a((UpiCustomVolleyError) null));
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if ("BT_ISE_436".equals(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                if (upiCustomVolleyError != null) {
                    upiCustomVolleyError.setmErrorCode(UpiUtils.AUTHENTICATION_FAILURE_401);
                }
                y a2 = this.f53984a.f53970b;
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                a2.setValue(c.a.a(upiCustomVolleyError));
                return;
            }
            y a3 = this.f53984a.f53970b;
            c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
            a3.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public final void a(String str) {
        k.c(str, "phoneNumber");
        y<net.one97.paytm.moneytransfer.model.c<b>> yVar = this.f53970b;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        net.one97.paytm.moneytransfer.b.a.b bVar = this.f53976i;
        if (bVar != null) {
            bVar.a((a.C0960a) new e(this, str), str);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ConsolidatePaymentInstrumentationRes.PaymentOptionList f53977a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f53978b;

        /* renamed from: c  reason: collision with root package name */
        private String f53979c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return k.a((Object) this.f53977a, (Object) bVar.f53977a) && k.a((Object) this.f53979c, (Object) bVar.f53979c) && this.f53978b == bVar.f53978b;
        }

        public final int hashCode() {
            ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList = this.f53977a;
            int i2 = 0;
            int hashCode = (paymentOptionList != null ? paymentOptionList.hashCode() : 0) * 31;
            String str = this.f53979c;
            if (str != null) {
                i2 = str.hashCode();
            }
            int i3 = (hashCode + i2) * 31;
            boolean z = this.f53978b;
            if (z) {
                z = true;
            }
            return i3 + (z ? 1 : 0);
        }

        public final String toString() {
            return "ContactsVpaBankDataModel(paymentOptionListItem=" + this.f53977a + ", message=" + this.f53979c + ", isGlobalError=" + this.f53978b + ")";
        }

        public b(ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList, String str, boolean z) {
            k.c(str, "message");
            this.f53977a = paymentOptionList;
            this.f53979c = str;
            this.f53978b = z;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f53982a;

        /* renamed from: b  reason: collision with root package name */
        public String f53983b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return k.a((Object) this.f53982a, (Object) dVar.f53982a) && k.a((Object) this.f53983b, (Object) dVar.f53983b);
        }

        public final int hashCode() {
            String str = this.f53982a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f53983b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "PayeeDetailsDataModel(payeeName=" + this.f53982a + ", payeePicUrl=" + this.f53983b + ")";
        }

        public d(String str, String str2) {
            k.c(str, "payeeName");
            k.c(str2, "payeePicUrl");
            this.f53982a = str;
            this.f53983b = str2;
        }
    }

    public final void c() {
        this.f53974f = "";
        this.f53975g = "";
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f53980a;

        /* renamed from: b  reason: collision with root package name */
        public final ConsolidatePaymentInstrumentationRes f53981b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return k.a((Object) this.f53980a, (Object) cVar.f53980a) && k.a((Object) this.f53981b, (Object) cVar.f53981b);
        }

        public final int hashCode() {
            String str = this.f53980a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.f53981b;
            if (consolidatePaymentInstrumentationRes != null) {
                i2 = consolidatePaymentInstrumentationRes.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "MerchantResponseBody(mobile=" + this.f53980a + ", paymentInstrumentationRes=" + this.f53981b + ")";
        }

        public c(String str, ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes) {
            k.c(str, "mobile");
            k.c(consolidatePaymentInstrumentationRes, "paymentInstrumentationRes");
            this.f53980a = str;
            this.f53981b = consolidatePaymentInstrumentationRes;
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.contacts.b.a$a  reason: collision with other inner class name */
    public static final class C0965a {
        private C0965a() {
        }

        public /* synthetic */ C0965a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(a aVar, List list) {
        Iterator it2 = list.iterator();
        String str = "";
        String str2 = str;
        while (it2.hasNext()) {
            ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList = (ConsolidatePaymentInstrumentationRes.PaymentOptionList) it2.next();
            ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment = paymentOptionList.getDestinationPayment();
            k.a((Object) destinationPayment, "paymentOptionListItem.destinationPayment");
            if (p.a(destinationPayment.getPaymentType(), PaymentInstrumentationType.WALLET.name(), true)) {
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment2 = paymentOptionList.getDestinationPayment();
                k.a((Object) destinationPayment2, "paymentOptionListItem.destinationPayment");
                if (!TextUtils.isEmpty(destinationPayment2.getDisplayName())) {
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment3 = paymentOptionList.getDestinationPayment();
                    k.a((Object) destinationPayment3, "paymentOptionListItem.destinationPayment");
                    str = destinationPayment3.getDisplayName();
                    k.a((Object) str, "paymentOptionListItem.de…nationPayment.displayName");
                }
            }
            ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment4 = paymentOptionList.getDestinationPayment();
            k.a((Object) destinationPayment4, "paymentOptionListItem.destinationPayment");
            if (p.a(destinationPayment4.getPaymentType(), PaymentInstrumentationType.WALLET.name(), true)) {
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment5 = paymentOptionList.getDestinationPayment();
                k.a((Object) destinationPayment5, "paymentOptionListItem.destinationPayment");
                if (!TextUtils.isEmpty(destinationPayment5.getUserPicture())) {
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment6 = paymentOptionList.getDestinationPayment();
                    k.a((Object) destinationPayment6, "paymentOptionListItem.destinationPayment");
                    str2 = destinationPayment6.getUserPicture();
                    k.a((Object) str2, "paymentOptionListItem.de…nationPayment.userPicture");
                }
            }
        }
        y<net.one97.paytm.moneytransfer.model.c<d>> yVar = aVar.f53971c;
        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a(new d(str, str2)));
    }
}
