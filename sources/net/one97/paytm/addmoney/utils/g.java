package net.one97.paytm.addmoney.utils;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.b;
import net.one97.paytm.addmoney.common.model.AbstractPaymentBl;
import net.one97.paytm.addmoney.common.model.BankUtils;
import net.one97.paytm.addmoney.common.paymethodresponse.AddMoneyPayMethod;
import net.one97.paytm.addmoney.common.paymethodresponse.BalanceInfo;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.addmoney.common.paymethodresponse.CJRPayMethods;
import net.one97.paytm.addmoney.common.paymethodresponse.MerchantPayMethod;
import net.one97.paytm.addmoney.common.paymethodresponse.PayChannelOption;
import net.one97.paytm.addmoney.common.paymethodresponse.PayMethodViews;
import net.one97.paytm.helper.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends AbstractPaymentBl {
    private static volatile g m = null;
    private static char n = '•';

    /* renamed from: a  reason: collision with root package name */
    public String f48974a = "";

    /* renamed from: b  reason: collision with root package name */
    public b f48975b;

    /* renamed from: c  reason: collision with root package name */
    public b f48976c;

    /* renamed from: d  reason: collision with root package name */
    public b f48977d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f48978e;

    /* renamed from: f  reason: collision with root package name */
    public b f48979f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f48980g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f48981h;

    /* renamed from: i  reason: collision with root package name */
    public List<b> f48982i;
    public List<b> j;
    public List<b> k;
    public boolean l = false;
    private ArrayList<b> o;
    private ArrayList<b> p;
    private List<b> q;
    private List<b> r;
    private List<b> s;

    public static final g a() {
        if (m == null) {
            synchronized (g.class) {
                if (m == null) {
                    m = new g();
                }
            }
        }
        return m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043 A[LOOP:0: B:14:0x0043->B:34:0x0043, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "MERCHANT_SAVED"
            boolean r1 = r9.equals(r0)
            if (r1 == 0) goto L_0x0024
            net.one97.paytm.addmoney.common.paymethodresponse.MerchantSavedInstruments r1 = r8.getMerchantSavedMethods()
            if (r1 == 0) goto L_0x0040
            net.one97.paytm.addmoney.common.paymethodresponse.MerchantSavedInstruments r1 = r8.getMerchantSavedMethods()
            java.util.List r1 = r1.getSavedCards()
            if (r1 == 0) goto L_0x0040
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r8.o = r2
            java.util.ListIterator r1 = r1.listIterator()
            goto L_0x0041
        L_0x0024:
            net.one97.paytm.addmoney.common.paymethodresponse.MerchantSavedInstruments r1 = r8.getMerchantSavedMethods()
            if (r1 == 0) goto L_0x0040
            net.one97.paytm.addmoney.common.paymethodresponse.AddMoneySavedInstruments r1 = r8.getAddMoneySavedMethods()
            java.util.List r1 = r1.getSavedCards()
            if (r1 == 0) goto L_0x0040
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r8.p = r2
            java.util.ListIterator r1 = r1.listIterator()
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            if (r1 == 0) goto L_0x00ed
        L_0x0043:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ed
            java.lang.Object r2 = r1.next()
            net.one97.paytm.addmoney.common.paymethodresponse.SavedCard r2 = (net.one97.paytm.addmoney.common.paymethodresponse.SavedCard) r2
            net.one97.paytm.addmoney.common.b r3 = new net.one97.paytm.addmoney.common.b
            r3.<init>()
            net.one97.paytm.addmoney.common.paymethodresponse.CardDetail r4 = r2.getCardDetails()
            java.lang.String r4 = r4.getCardId()
            r3.f48421c = r4
            java.lang.String r4 = r2.getPayMethod()
            r3.f48422d = r4
            java.lang.String r4 = r2.getPayMethod()
            java.lang.String r5 = "DEBIT_CARD"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = "DC"
            goto L_0x0075
        L_0x0073:
            java.lang.String r4 = "CC"
        L_0x0075:
            r3.f48423e = r4
            java.lang.String r4 = r2.getInstId()
            r3.f48424f = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            net.one97.paytm.addmoney.common.paymethodresponse.CardDetail r5 = r2.getCardDetails()
            java.lang.String r5 = r5.getFirstSixDigit()
            r6 = 4
            r7 = 0
            java.lang.String r5 = r5.substring(r7, r6)
            r4.<init>(r5)
            java.lang.String r5 = " "
            r4.append(r5)
        L_0x0095:
            r5 = 10
            java.lang.String r6 = "  "
            if (r7 >= r5) goto L_0x00ab
            int r5 = r7 % 5
            if (r5 == 0) goto L_0x00a5
            char r5 = n
            r4.append(r5)
            goto L_0x00a8
        L_0x00a5:
            r4.append(r6)
        L_0x00a8:
            int r7 = r7 + 1
            goto L_0x0095
        L_0x00ab:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r6)
            net.one97.paytm.addmoney.common.paymethodresponse.CardDetail r6 = r2.getCardDetails()
            java.lang.String r6 = r6.getLastFourDigit()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.f48419a = r4
            java.lang.String r4 = r2.getIssuingBank()
            r2.getPayMethod()
            r3.f48420b = r4
            java.lang.String r2 = r2.getIconUrl()
            r3.f48425g = r2
            r3.k = r4
            boolean r2 = r9.equals(r0)
            if (r2 == 0) goto L_0x00e6
            java.util.ArrayList<net.one97.paytm.addmoney.common.b> r2 = r8.o
            r2.add(r3)
            goto L_0x0043
        L_0x00e6:
            java.util.ArrayList<net.one97.paytm.addmoney.common.b> r2 = r8.p
            r2.add(r3)
            goto L_0x0043
        L_0x00ed:
            r8.e()
            r8.d()
            r8.c()
            r8.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.utils.g.b(java.lang.String):void");
    }

    private void b() {
        if (this.p != null) {
            this.r = new ArrayList();
            ListIterator<b> listIterator = this.p.listIterator();
            while (listIterator.hasNext()) {
                b next = listIterator.next();
                if (next.f48422d.equals(SDKConstants.CREDIT)) {
                    this.r.add(next);
                }
            }
        }
    }

    private void c() {
        if (this.p != null) {
            this.q = new ArrayList();
            ListIterator<b> listIterator = this.p.listIterator();
            while (listIterator.hasNext()) {
                b next = listIterator.next();
                if (next.f48422d.equals(SDKConstants.DEBIT)) {
                    this.q.add(next);
                }
            }
        }
    }

    private void d() {
        if (this.o != null) {
            this.f48981h = new ArrayList();
            ListIterator<b> listIterator = this.o.listIterator();
            while (listIterator.hasNext()) {
                b next = listIterator.next();
                if (next.f48422d.equals(SDKConstants.CREDIT)) {
                    this.f48981h.add(next);
                }
            }
        }
    }

    private void e() {
        if (this.o != null) {
            this.f48980g = new ArrayList();
            ListIterator<b> listIterator = this.o.listIterator();
            while (listIterator.hasNext()) {
                b next = listIterator.next();
                if (next.f48422d.equals(SDKConstants.DEBIT)) {
                    this.f48980g.add(next);
                }
            }
        }
    }

    public final void a(Context context, boolean z, List<PayChannelOption> list, String str) {
        if (list != null) {
            if (str.equalsIgnoreCase("MERCHANT_SAVED")) {
                if (z) {
                    this.f48982i = new ArrayList();
                } else {
                    this.j = new ArrayList();
                }
            } else if (z) {
                this.s = new ArrayList();
            } else {
                this.k = new ArrayList();
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                PayChannelOption payChannelOption = list.get(i2);
                b bVar = new b();
                if (context != null) {
                    bVar.f48419a = context.getString(R.string.net_banking);
                }
                bVar.f48420b = payChannelOption.getInstName();
                bVar.f48427i = payChannelOption.getHasLowSuccess();
                bVar.f48425g = payChannelOption.getIconUrl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AppConstants.ICON_URL, payChannelOption.getIconUrl());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                bVar.j = jSONObject;
                bVar.f48421c = payChannelOption.getInstId();
                bVar.f48422d = "NET_BANKING";
                bVar.k = payChannelOption.getInstId();
                bVar.f48423e = "NB";
                if (str.equalsIgnoreCase("MERCHANT_SAVED")) {
                    if (z) {
                        this.f48982i.add(bVar);
                    } else {
                        this.j.add(bVar);
                    }
                } else if (z) {
                    this.s.add(bVar);
                } else {
                    this.k.add(bVar);
                }
            }
        }
    }

    public static List<PayChannelOption> a(CJPayMethodResponse cJPayMethodResponse, String str) {
        CJRPayMethods cjrPayMethods;
        PayMethodViews payMethodViews;
        if (cJPayMethodResponse == null || (cjrPayMethods = cJPayMethodResponse.getCjrPayMethods()) == null || (payMethodViews = cjrPayMethods.getPayMethodViews()) == null) {
            return null;
        }
        List<MerchantPayMethod> merchantPayMethods = payMethodViews.getMerchantPayMethods();
        int i2 = 0;
        if (str.equalsIgnoreCase("MERCHANT_SAVED")) {
            int size = merchantPayMethods != null ? merchantPayMethods.size() : 0;
            while (i2 < size) {
                if (merchantPayMethods.get(i2).getPayMethod().equals("NET_BANKING")) {
                    return merchantPayMethods.get(i2).getPayChannelOptions();
                }
                i2++;
            }
            return null;
        }
        List<AddMoneyPayMethod> addMoneyPayMethods = cJPayMethodResponse.getCjrPayMethods().getPayMethodViews().getAddMoneyPayMethods();
        int size2 = addMoneyPayMethods != null ? addMoneyPayMethods.size() : 0;
        while (i2 < size2) {
            if (addMoneyPayMethods.get(i2).getPayMethod().equals("NET_BANKING")) {
                return addMoneyPayMethods.get(i2).getPayChannelOptions();
            }
            i2++;
        }
        return null;
    }

    public final List<b> a(String str) {
        if (str.equalsIgnoreCase(SDKConstants.DEBIT)) {
            return this.f48980g;
        }
        return this.f48981h;
    }

    public final void a(Context context) {
        MerchantPayMethod merchantPayMethod;
        if (this.f48977d == null && context != null) {
            if (BankUtils.isPPBCustomer(context) || BankUtils.isPaymentBankUser(context)) {
                this.f48977d = new b();
                this.f48977d.f48419a = context.getString(R.string.paytm_payment_bank_account);
                b bVar = this.f48977d;
                bVar.f48420b = "";
                bVar.f48422d = "NET_BANKING_PPBL";
                bVar.f48423e = "NB";
                bVar.k = SDKConstants.AI_KEY_PPBL;
            }
        }
        if (this.f48976c == null && h.a(a.b().j()).b("isCreditCard", false, true)) {
            this.f48976c = new b();
            if (context != null) {
                this.f48976c.f48419a = context.getString(R.string.paytm_postpaid);
            }
            b bVar2 = this.f48976c;
            bVar2.f48420b = "";
            bVar2.f48422d = "PAYTM_DIGITAL_CREDIT";
            List<MerchantPayMethod> merchantPayMethods = getMerchantPayMethods();
            if (merchantPayMethods != null && merchantPayMethods.size() > 0) {
                Iterator<MerchantPayMethod> it2 = merchantPayMethods.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    merchantPayMethod = it2.next();
                    if (merchantPayMethod.getPayMethod().equalsIgnoreCase("PAYTM_DIGITAL_CREDIT")) {
                        break;
                    }
                }
            }
            merchantPayMethod = null;
            if (!(merchantPayMethod == null || merchantPayMethod.getPayChannelOptions() == null)) {
                BalanceInfo balanceInfo = merchantPayMethod.getPayChannelOptions().get(0).getBalanceInfo();
                b bVar3 = this.f48976c;
                bVar3.f48421c = balanceInfo.getPayerAccountNo() + "|" + balanceInfo.getExtendInfo().getLenderId() + "|";
                this.f48976c.f48420b = String.format(a.b().j().getString(R.string.available_balance_addmoney), new Object[]{balanceInfo.getAccountBalance().getValue()});
            }
        }
        b("MERCHANT_SAVED");
        b("ADD_MONEY_SAVED");
        a(context, true, a(this.mPayMethodResponse, "MERCHANT_SAVED"), "MERCHANT_SAVED");
        a(context, true, a(this.mPayMethodResponse, "ADD_MONEY_SAVED"), "ADD_MONEY_SAVED");
    }
}
