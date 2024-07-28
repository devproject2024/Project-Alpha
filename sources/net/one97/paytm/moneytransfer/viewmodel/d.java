package net.one97.paytm.moneytransfer.viewmodel;

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
import net.one97.paytm.moneytransfer.contacts.b.a;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.upi.common.PaymentInstrumentationType;
import net.one97.paytm.upi.common.UpiCustomVolleyError;

public final class d extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<c<a>> f54722a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.b.a.b f54723b;

    /* renamed from: c  reason: collision with root package name */
    public y<c<a.d>> f54724c = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        k.c(application, "application");
        this.f54723b = net.one97.paytm.moneytransfer.b.a(application);
    }

    public static final class b implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f54727a;

        public b(d dVar) {
            this.f54727a = dVar;
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y a2 = this.f54727a.f54722a;
            c.a aVar = c.f54031e;
            a2.setValue(c.a.a(upiCustomVolleyError));
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof ConsolidatePaymentInstrumentationRes) {
                ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = (ConsolidatePaymentInstrumentationRes) iJRPaytmDataModel;
                if (consolidatePaymentInstrumentationRes.getGlobalError() != null) {
                    ConsolidatePaymentInstrumentationRes.GlobalError globalError = consolidatePaymentInstrumentationRes.getGlobalError();
                    k.a((Object) globalError, "response.globalError");
                    if (globalError.getErrorList() != null) {
                        ConsolidatePaymentInstrumentationRes.GlobalError globalError2 = consolidatePaymentInstrumentationRes.getGlobalError();
                        k.a((Object) globalError2, "response.globalError");
                        if (globalError2.getErrorList().size() > 0) {
                            y a2 = this.f54727a.f54722a;
                            c.a aVar = c.f54031e;
                            a2.setValue(c.a.a(new a(false, new ConsolidatePaymentInstrumentationRes.PaymentOptionList())));
                            return;
                        }
                    }
                }
                if (consolidatePaymentInstrumentationRes.getPaymentOptionList() == null || consolidatePaymentInstrumentationRes.getPaymentOptionList().size() <= 0) {
                    y a3 = this.f54727a.f54722a;
                    c.a aVar2 = c.f54031e;
                    a3.setValue(c.a.a(new a(false, new ConsolidatePaymentInstrumentationRes.PaymentOptionList())));
                    return;
                }
                d dVar = this.f54727a;
                List<ConsolidatePaymentInstrumentationRes.PaymentOptionList> paymentOptionList = consolidatePaymentInstrumentationRes.getPaymentOptionList();
                k.a((Object) paymentOptionList, "response.paymentOptionList");
                d.a(dVar, paymentOptionList);
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
                    y a4 = this.f54727a.f54722a;
                    c.a aVar3 = c.f54031e;
                    a4.setValue(c.a.a(new a(true, next)));
                    return;
                }
                y a5 = this.f54727a.f54722a;
                c.a aVar4 = c.f54031e;
                a5.setValue(c.a.a(new a(false, new ConsolidatePaymentInstrumentationRes.PaymentOptionList())));
                return;
            }
            y a6 = this.f54727a.f54722a;
            c.a aVar5 = c.f54031e;
            a6.setValue(c.a.a(new a(false, new ConsolidatePaymentInstrumentationRes.PaymentOptionList())));
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f54725a;

        /* renamed from: b  reason: collision with root package name */
        public final ConsolidatePaymentInstrumentationRes.PaymentOptionList f54726b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f54725a == aVar.f54725a && k.a((Object) this.f54726b, (Object) aVar.f54726b);
        }

        public final int hashCode() {
            boolean z = this.f54725a;
            if (z) {
                z = true;
            }
            int i2 = (z ? 1 : 0) * true;
            ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList = this.f54726b;
            return i2 + (paymentOptionList != null ? paymentOptionList.hashCode() : 0);
        }

        public final String toString() {
            return "NewPhoneNumberModel(userExists=" + this.f54725a + ", destinationPayment=" + this.f54726b + ")";
        }

        public a(boolean z, ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList) {
            this.f54725a = z;
            this.f54726b = paymentOptionList;
        }
    }

    public static final /* synthetic */ void a(d dVar, List list) {
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
        y<c<a.d>> yVar = dVar.f54724c;
        c.a aVar = c.f54031e;
        yVar.setValue(c.a.a(new a.d(str, str2)));
    }
}
