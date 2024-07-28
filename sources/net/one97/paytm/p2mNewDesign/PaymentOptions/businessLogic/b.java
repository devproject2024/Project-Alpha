package net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.q;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import easypay.manager.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldPortfolio;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.db.b.a;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchNBResponse;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.RetryInfo;
import net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank;
import net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse;
import net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails;
import net.one97.paytm.p2mNewDesign.g.c;
import net.one97.paytm.p2mNewDesign.models.AmountV2;
import net.one97.paytm.p2mNewDesign.models.CredsAllowedV2;
import net.one97.paytm.p2mNewDesign.models.IsDisabledV2;
import net.one97.paytm.p2mNewDesign.models.MerchantPaymodesLimits;
import net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2;
import net.one97.paytm.p2mNewDesign.models.PaymentModesV2;
import net.one97.paytm.p2mNewDesign.models.SavedInstrumentsV2;
import net.one97.paytm.p2mNewDesign.models.UPIProfileV2;
import net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2;
import net.one97.paytm.p2mNewDesign.models.VpaDetailsV2;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.utility.j;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends a {
    private static volatile b R = null;
    private static char S = '•';
    public String A;
    public boolean B;
    public String C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public c H;
    public ChannelAPIResponse I;
    public ChannelPaymentDetails J;
    public boolean K;
    public boolean L = false;
    public String M;
    public String N;
    public boolean O;
    public boolean P;
    public VpaDetailsV2 Q;
    private InstrumentInfo T;
    private ArrayList<InstrumentInfo> U;
    private ArrayList<InstrumentInfo> V;
    private List<InstrumentInfo> W;
    private List<InstrumentInfo> X;
    private List<InstrumentInfo> Y;
    private boolean Z = false;
    private boolean aa;
    private List<a> ab;
    private String ac;
    private String ad;

    /* renamed from: b  reason: collision with root package name */
    public String f13086b = "";

    /* renamed from: c  reason: collision with root package name */
    public InstrumentInfo f13087c;

    /* renamed from: d  reason: collision with root package name */
    public String f13088d;

    /* renamed from: e  reason: collision with root package name */
    public String f13089e;

    /* renamed from: f  reason: collision with root package name */
    public String f13090f;

    /* renamed from: g  reason: collision with root package name */
    public String f13091g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13092h;

    /* renamed from: i  reason: collision with root package name */
    public InstrumentInfo f13093i;
    public InstrumentInfo j;
    public InstrumentInfo k;
    public InstrumentInfo l;
    public List<InstrumentInfo> m;
    public InstrumentInfo n;
    public List<InstrumentInfo> o;
    public List<InstrumentInfo> p;
    public List<InstrumentInfo> q;
    public List<InstrumentInfo> r;
    public List<InstrumentInfo> s;
    public List<InstrumentInfo> t;
    public List<UpiProfileDefaultBank> u;
    public InstrumentInfo v;
    public boolean w = false;
    public boolean x;
    public boolean y = false;
    public boolean z = false;

    public static final b f() {
        if (R == null) {
            synchronized (b.class) {
                if (R == null) {
                    R = new b();
                }
            }
        }
        return R;
    }

    public final Boolean g() {
        return Boolean.valueOf(this.f13092h);
    }

    public final InstrumentInfo h() {
        return this.f13093i;
    }

    public final InstrumentInfo i() {
        return this.v;
    }

    public final void b(String str) {
        this.f13086b = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 2484(0x9b4, float:3.481E-42)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x0029
            r1 = 1280945827(0x4c59aea3, float:5.7064076E7)
            if (r0 == r1) goto L_0x001f
            r1 = 1878720662(0x6ffb0096, float:1.5536289E29)
            if (r0 == r1) goto L_0x0015
            goto L_0x0033
        L_0x0015:
            java.lang.String r0 = "CREDIT_CARD"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "DEBIT_CARD"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "NB"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 2
            goto L_0x0034
        L_0x0033:
            r4 = -1
        L_0x0034:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            java.lang.String r4 = ""
            return r4
        L_0x003d:
            java.lang.String r4 = "Net Banking"
            return r4
        L_0x0040:
            java.lang.String r4 = "Credit Cards"
            return r4
        L_0x0043:
            java.lang.String r4 = "Debit Cards"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.c(java.lang.String):java.lang.String");
    }

    public final boolean d(String str) {
        List<PaymentModesV2> b2 = b();
        if (b2 == null && !this.O) {
            return true;
        }
        if (b2 != null && b2.size() > 0) {
            Iterator<PaymentModesV2> it2 = b2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PaymentModesV2 next = it2.next();
                if (next != null && next.getPaymentMode() != null && next.getPaymentMode().equalsIgnoreCase(str)) {
                    if (next.isDisabled() != null && next.isDisabled().getStatus().booleanValue()) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final PaymentModesV2 e(String str) {
        List<PaymentModesV2> b2 = b();
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        for (PaymentModesV2 next : b2) {
            if (next.getPaymentMode().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public final InstrumentInfo f(String str) {
        int i2 = 0;
        while (i2 < this.o.size()) {
            try {
                if (this.o.get(i2).getPaymentDetails().equals(str)) {
                    return (InstrumentInfo) this.o.get(i2).clone();
                }
                i2++;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final InstrumentInfo g(String str) {
        int i2 = 0;
        while (i2 < this.p.size()) {
            try {
                if (this.p.get(i2).getPaymentDetails().equals(str)) {
                    return (InstrumentInfo) this.p.get(i2).clone();
                }
                i2++;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private IsDisabledV2 x(String str) {
        List<PaymentModesV2> b2 = b();
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        for (PaymentModesV2 next : b2) {
            if (next.getPaymentMode().equalsIgnoreCase(str)) {
                if (next.isDisabled() != null) {
                    return next.isDisabled();
                }
                Boolean bool = Boolean.TRUE;
                return new IsDisabledV2("", bool, bool, Boolean.FALSE);
            }
        }
        return null;
    }

    private IsDisabledV2 y(String str) {
        List<PaymentModesV2> b2 = b();
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        for (PaymentModesV2 next : b2) {
            if (next.getPaymentMode().equalsIgnoreCase(str)) {
                if (next.getPayChannelOptions().get(0).isDisabled() != null) {
                    return next.getPayChannelOptions().get(0).isDisabled();
                }
                Boolean bool = Boolean.TRUE;
                return new IsDisabledV2("", bool, bool, Boolean.FALSE);
            }
        }
        return null;
    }

    public final InstrumentInfo j() {
        return this.f13087c;
    }

    public final void a(Context context, Double d2, Double d3) {
        this.f13087c = new InstrumentInfo();
        this.f13087c.setPayMode("BALANCE");
        this.f13087c.setPaymentTypeId("BALANCE");
        if (d2.equals(Double.valueOf(Double.NaN))) {
            this.f13087c.setBalance("");
            this.f13087c.setDisplaySecondaryInfo(context.getString(R.string.available_payable_balance));
        } else {
            this.f13087c.setTotalBalance(String.valueOf(d2));
            this.f13087c.setBalance(String.valueOf(d3));
            this.f13087c.setmDisplaythirdInfo(String.format(context.getString(R.string.p2m_available_for_wallet), new Object[]{com.paytm.utility.b.S(String.valueOf(d3)).toString()}));
            this.f13087c.setDisplaySecondaryInfo(String.format(context.getString(R.string.p2m_available_for_baln), new Object[]{com.paytm.utility.b.S(String.valueOf(d2)).toString()}));
        }
        this.f13087c.setDisplayPrimaryInfo(context.getString(R.string.paytm_baln));
    }

    public final InstrumentInfo k() {
        return this.T;
    }

    public final void b(Context context, Double d2, Double d3) {
        this.T = new InstrumentInfo();
        this.T.setPayMode("BALANCE");
        this.T.setPaymentTypeId("BALANCE");
        if (d2.equals(Double.valueOf(Double.NaN))) {
            this.T.setBalance("");
            this.T.setDisplaySecondaryInfo(context.getString(R.string.available_payable_balance));
        } else {
            this.T.setBalance(String.valueOf(d3));
            this.T.setmDisplaythirdInfo(String.format(context.getString(R.string.p2m_available_for_gv, new Object[]{com.paytm.utility.b.S(String.valueOf(d3)).toString()}), new Object[0]));
            this.T.setDisplaySecondaryInfo(String.format(context.getString(R.string.balance_without_format_v2, new Object[]{com.paytm.utility.b.S(String.valueOf(d2)).toString()}), new Object[0]));
        }
        this.T.setDisplayPrimaryInfo(context.getString(R.string.paytm_baln));
    }

    private void a(Context context, String str) {
        ListIterator<SavedInstrumentsV2> listIterator;
        ArrayList<SavedInstrumentsV2> a2;
        if (!str.equals("MERCHANT_SAVED") || (a2 = a()) == null) {
            listIterator = null;
        } else {
            this.U = new ArrayList<>();
            listIterator = a2.listIterator();
        }
        if (listIterator != null) {
            while (listIterator.hasNext()) {
                SavedInstrumentsV2 next = listIterator.next();
                if (next.getCardDetails() != null) {
                    InstrumentInfo instrumentInfo = new InstrumentInfo();
                    instrumentInfo.setPaymentDetails(next.getCardDetails().getCardId());
                    instrumentInfo.setPayMode(next.getCardDetails().getCardType());
                    instrumentInfo.setPaymentTypeId(next.getCardDetails().getCardType().equals(SDKConstants.DEBIT) ? Constants.EASYPAY_PAYTYPE_DEBIT_CARD : Constants.EASYPAY_PAYTYPE_CREDIT_CARD);
                    instrumentInfo.setCardType(next.getChannelCode());
                    instrumentInfo.setIconUrl(next.getIconUrl());
                    instrumentInfo.setEMIavailable(next.isEmiAvailable());
                    instrumentInfo.setmMinAmount(next.getMinAmount());
                    instrumentInfo.setmMaxAmount(next.getMaxAmount());
                    instrumentInfo.setChannelCode(next.getIssuingBank());
                    instrumentInfo.setBankName(next.getIssuingBank());
                    instrumentInfo.setOneClickSupported(next.getOneClickSupported());
                    if (!p(instrumentInfo.getPayMode())) {
                        instrumentInfo.setLimitBreached(this.B);
                    }
                    instrumentInfo.setPriority(next.getPriority());
                    StringBuilder sb = new StringBuilder(next.getCardDetails().getFirstSixDigit().substring(0, 4));
                    sb.append(" ");
                    instrumentInfo.setCardFirstSixDigit(next.getCardDetails().getFirstSixDigit());
                    instrumentInfo.setCardLastFourDigit(next.getCardDetails().getLastFourDigit());
                    instrumentInfo.setExpiryDate(next.getCardDetails().getExpiryDate());
                    for (int i2 = 0; i2 < 10; i2++) {
                        if (i2 % 5 != 0) {
                            sb.append(S);
                        } else {
                            sb.append("  ");
                        }
                    }
                    sb.append("  " + next.getCardDetails().getLastFourDigit());
                    instrumentInfo.setDisplaySecondaryInfo(sb.toString());
                    String issuingBank = next.getIssuingBank();
                    instrumentInfo.setBankCode(issuingBank);
                    String cardType = next.getCardDetails().getCardType();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(issuingBank);
                    sb2.append(" - ");
                    sb2.append(context.getString(cardType.equals(SDKConstants.DEBIT) ? R.string.debit_card_pay_mode : R.string.credit_card));
                    instrumentInfo.setDisplayPrimaryInfo(sb2.toString());
                    if (str.equals("MERCHANT_SAVED")) {
                        this.U.add(instrumentInfo);
                    } else {
                        this.V.add(instrumentInfo);
                    }
                }
            }
        }
        N();
        M();
        L();
        K();
    }

    private void K() {
        if (this.V != null) {
            this.r = new ArrayList();
            ListIterator<InstrumentInfo> listIterator = this.V.listIterator();
            while (listIterator.hasNext()) {
                InstrumentInfo next = listIterator.next();
                if (next.getPayMode().equals(SDKConstants.CREDIT)) {
                    this.r.add(next);
                }
            }
        }
    }

    private void L() {
        if (this.V != null) {
            this.q = new ArrayList();
            ListIterator<InstrumentInfo> listIterator = this.V.listIterator();
            while (listIterator.hasNext()) {
                InstrumentInfo next = listIterator.next();
                if (next.getPayMode().equals(SDKConstants.DEBIT)) {
                    this.q.add(next);
                }
            }
        }
    }

    private void M() {
        if (this.U != null) {
            this.p = new ArrayList();
            ListIterator<InstrumentInfo> listIterator = this.U.listIterator();
            while (listIterator.hasNext()) {
                InstrumentInfo next = listIterator.next();
                if (next.getPayMode().equals(SDKConstants.CREDIT)) {
                    this.p.add(next);
                }
            }
        }
    }

    private void N() {
        if (this.U != null) {
            this.o = new ArrayList();
            ListIterator<InstrumentInfo> listIterator = this.U.listIterator();
            while (listIterator.hasNext()) {
                InstrumentInfo next = listIterator.next();
                if (next.getPayMode().equals(SDKConstants.DEBIT)) {
                    this.o.add(next);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        if (c(r8) == false) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r8, boolean r9) {
        /*
            r7 = this;
            r7.aa = r9
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r7.f13087c
            r0 = 1
            if (r9 == 0) goto L_0x000a
            r9.setAllPaymodeFetched(r0)
        L_0x000a:
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r9 = r7.f13085a
            net.one97.paytm.p2mNewDesign.models.BodyV2 r9 = r9.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantLimitInfoV2 r9 = r9.getMerchantLimitInfo()
            r1 = -99
            if (r9 == 0) goto L_0x007b
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r9 = r7.f13085a
            net.one97.paytm.p2mNewDesign.models.BodyV2 r9 = r9.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantLimitInfoV2 r9 = r9.getMerchantLimitInfo()
            java.util.ArrayList r9 = r9.getMerchantRemainingLimits()
            if (r9 == 0) goto L_0x007b
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r9 = r7.f13085a
            net.one97.paytm.p2mNewDesign.models.BodyV2 r9 = r9.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantLimitInfoV2 r9 = r9.getMerchantLimitInfo()
            java.util.ArrayList r9 = r9.getMerchantRemainingLimits()
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x007b
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r9 = r7.f13085a
            net.one97.paytm.p2mNewDesign.models.BodyV2 r9 = r9.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantLimitInfoV2 r9 = r9.getMerchantLimitInfo()
            java.util.ArrayList r9 = r9.getMerchantRemainingLimits()
            java.util.Iterator r9 = r9.iterator()
            r2 = -99
        L_0x0050:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x007d
            java.lang.Object r3 = r9.next()
            net.one97.paytm.p2mNewDesign.models.MerchantRemainingLimitsV2 r3 = (net.one97.paytm.p2mNewDesign.models.MerchantRemainingLimitsV2) r3
            if (r3 == 0) goto L_0x0050
            java.lang.String r4 = r3.getAmount()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0050
            java.lang.String r3 = r3.getAmount()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            int r3 = r3.intValue()
            if (r2 != r1) goto L_0x0077
            r2 = r3
        L_0x0077:
            if (r2 <= r3) goto L_0x0050
            r2 = r3
            goto L_0x0050
        L_0x007b:
            r2 = -99
        L_0x007d:
            r9 = 0
            if (r2 != 0) goto L_0x0082
            r3 = 1
            goto L_0x0083
        L_0x0082:
            r3 = 0
        L_0x0083:
            r7.B = r3
            if (r2 != r1) goto L_0x0089
            r1 = 0
            goto L_0x008d
        L_0x0089:
            java.lang.String r1 = java.lang.String.valueOf(r2)
        L_0x008d:
            r7.A = r1
            boolean r1 = r7.y
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x009e
            f()
            boolean r1 = c((android.content.Context) r8)
            if (r1 != 0) goto L_0x013b
        L_0x009e:
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.j
            if (r1 != 0) goto L_0x013b
            boolean r1 = r7.n()
            if (r1 == 0) goto L_0x013b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            java.lang.String r3 = "A/c No."
            r1.append(r3)
            r3 = 0
        L_0x00b3:
            java.lang.String r4 = "  "
            r5 = 5
            if (r3 >= r5) goto L_0x00c8
            int r5 = r3 % 5
            if (r5 == 0) goto L_0x00c2
            char r4 = S
            r1.append(r4)
            goto L_0x00c5
        L_0x00c2:
            r1.append(r4)
        L_0x00c5:
            int r3 = r3 + 1
            goto L_0x00b3
        L_0x00c8:
            r1.append(r4)
            java.lang.String r3 = com.paytm.utility.b.ab(r8)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x00d8
            java.lang.String r3 = "XXXX"
            goto L_0x00f2
        L_0x00d8:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x00f2
            int r4 = r3.length()
            r5 = 4
            if (r4 <= r5) goto L_0x00f2
            java.lang.String r4 = com.paytm.utility.b.ab(r8)
            int r3 = r3.length()
            int r3 = r3 - r5
            java.lang.String r3 = r4.substring(r3)
        L_0x00f2:
            r1.append(r3)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = new net.one97.paytm.p2mNewDesign.entity.InstrumentInfo
            r3.<init>()
            r7.j = r3
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.j
            int r4 = net.one97.paytm.wallet.R.string.paytm_payment_bank_account
            java.lang.String r4 = r8.getString(r4)
            r3.setDisplayPrimaryInfo(r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.j
            int r4 = net.one97.paytm.wallet.R.string.check_balance
            java.lang.String r4 = r8.getString(r4)
            r3.setDisplaySecondaryInfo(r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.j
            java.lang.String r1 = r1.toString()
            r3.setmDisplaythirdInfo(r1)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.j
            java.lang.String r3 = "PPBL"
            r1.setPayMode(r3)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.j
            java.lang.String r4 = "NB"
            r1.setPaymentTypeId(r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.j
            r1.setBankCode(r3)
            boolean r1 = r7.p(r3)
            if (r1 != 0) goto L_0x013b
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.j
            boolean r3 = r7.B
            r1.setLimitBreached(r3)
        L_0x013b:
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.f13093i
            if (r1 != 0) goto L_0x0197
            boolean r1 = u()
            if (r1 == 0) goto L_0x0197
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = new net.one97.paytm.p2mNewDesign.entity.InstrumentInfo
            r1.<init>()
            r7.f13093i = r1
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.f13093i
            int r3 = net.one97.paytm.wallet.R.string.paytm_postpaid
            java.lang.String r3 = r8.getString(r3)
            r1.setDisplayPrimaryInfo(r3)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.f13093i
            r1.setDisplaySecondaryInfo(r2)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.f13093i
            java.lang.String r3 = "PAYTM_DIGITAL_CREDIT"
            r1.setPayMode(r3)
            net.one97.paytm.p2mNewDesign.models.PaymentModesV2 r1 = r7.e((java.lang.String) r3)
            if (r1 == 0) goto L_0x018a
            java.util.ArrayList r4 = r1.getPayChannelOptions()
            if (r4 == 0) goto L_0x018a
            java.util.ArrayList r1 = r1.getPayChannelOptions()
            java.lang.Object r1 = r1.get(r9)
            net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r1 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r1
            r1.getBalanceInfo()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.f13093i
            java.lang.String r4 = "Check Balance"
            r1.setDisplaySecondaryInfo(r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.f13093i
            java.lang.String r4 = "false"
            r1.setPasscodeRequired(r4)
        L_0x018a:
            boolean r1 = r7.p(r3)
            if (r1 != 0) goto L_0x0197
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.f13093i
            boolean r3 = r7.B
            r1.setLimitBreached(r3)
        L_0x0197:
            java.lang.String r1 = "MERCHANT_SAVED"
            r7.a((android.content.Context) r8, (java.lang.String) r1)
            java.lang.String r3 = "ADD_MONEY_SAVED"
            r7.a((android.content.Context) r8, (java.lang.String) r3)
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r4 = r7.f13085a
            java.util.List r4 = a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r4, (java.lang.String) r1)
            r7.a((android.content.Context) r8, (boolean) r0, (java.util.List<net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2>) r4, (java.lang.String) r1)
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r1 = r7.f13085a
            java.util.List r1 = a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r1, (java.lang.String) r3)
            r7.a((android.content.Context) r8, (boolean) r0, (java.util.List<net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2>) r1, (java.lang.String) r3)
            r7.e((android.content.Context) r8)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r7.l
            if (r1 != 0) goto L_0x02ef
            java.lang.String r1 = "GIFT_VOUCHER"
            net.one97.paytm.p2mNewDesign.models.PaymentModesV2 r3 = r7.e((java.lang.String) r1)
            if (r3 == 0) goto L_0x0214
            java.util.ArrayList r4 = r3.getPayChannelOptions()
            if (r4 == 0) goto L_0x0214
            java.util.ArrayList r4 = r3.getPayChannelOptions()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0214
            java.util.ArrayList r4 = r3.getPayChannelOptions()
            java.lang.Object r4 = r4.get(r9)
            net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r4 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r4
            net.one97.paytm.p2mNewDesign.models.BalanceInfoV2 r4 = r4.getBalanceInfo()
            if (r4 == 0) goto L_0x0214
            java.util.ArrayList r4 = r3.getPayChannelOptions()
            java.lang.Object r4 = r4.get(r9)
            net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r4 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r4
            net.one97.paytm.p2mNewDesign.models.BalanceInfoV2 r4 = r4.getBalanceInfo()
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r4 = r4.getAccountBalance()
            if (r4 == 0) goto L_0x0214
            java.util.ArrayList r3 = r3.getPayChannelOptions()
            java.lang.Object r3 = r3.get(r9)
            net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r3 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r3
            net.one97.paytm.p2mNewDesign.models.BalanceInfoV2 r3 = r3.getBalanceInfo()
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r3 = r3.getAccountBalance()
            java.lang.String r3 = r3.getValue()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0214
            r3 = 1
            goto L_0x0215
        L_0x0214:
            r3 = 0
        L_0x0215:
            if (r3 == 0) goto L_0x02ef
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = new net.one97.paytm.p2mNewDesign.entity.InstrumentInfo
            r3.<init>()
            r7.l = r3
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.l
            android.content.res.Resources r4 = r8.getResources()
            int r5 = net.one97.paytm.wallet.R.string.p2m_gift_voucher
            java.lang.String r4 = r4.getString(r5)
            r3.setDisplayPrimaryInfo(r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.l
            r3.setDisplaySecondaryInfo(r2)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.l
            r3.setPayMode(r1)
            net.one97.paytm.p2mNewDesign.models.PaymentModesV2 r3 = r7.e((java.lang.String) r1)
            if (r3 == 0) goto L_0x02e2
            java.util.ArrayList r4 = r3.getPayChannelOptions()
            if (r4 == 0) goto L_0x02e2
            java.util.ArrayList r4 = r3.getPayChannelOptions()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x02e2
            java.util.ArrayList r4 = r3.getPayChannelOptions()
            java.lang.Object r4 = r4.get(r9)
            net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r4 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r4
            net.one97.paytm.p2mNewDesign.models.BalanceInfoV2 r4 = r4.getBalanceInfo()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r7.l
            java.util.ArrayList r6 = r3.getPayChannelOptions()
            java.lang.Object r6 = r6.get(r9)
            net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r6 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r6
            java.lang.String r6 = r6.getTemplateId()
            r5.setTempleteId(r6)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r7.l
            java.lang.String r3 = r3.getStoreFrontUrl()
            r5.setStoreFrontUrl(r3)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.l
            java.lang.String r5 = "0"
            if (r4 == 0) goto L_0x029a
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r6 = r4.getAccountBalance()
            if (r6 == 0) goto L_0x029a
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r6 = r4.getAccountBalance()
            java.lang.String r6 = r6.getValue()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x029a
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r6 = r4.getAccountBalance()
            java.lang.String r6 = r6.getValue()
            goto L_0x029b
        L_0x029a:
            r6 = r5
        L_0x029b:
            r3.setBalance(r6)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.l
            if (r4 == 0) goto L_0x02be
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r6 = r4.getAccountBalance()
            if (r6 == 0) goto L_0x02be
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r6 = r4.getAccountBalance()
            java.lang.String r6 = r6.getValue()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x02be
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r5 = r4.getAccountBalance()
            java.lang.String r5 = r5.getValue()
        L_0x02be:
            r3.setTotalBalance(r5)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r7.l
            int r5 = net.one97.paytm.wallet.R.string.p2m_available_for_baln
            java.lang.String r8 = r8.getString(r5)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r5 = r4.getAccountBalance()
            if (r5 == 0) goto L_0x02d9
            net.one97.paytm.p2mNewDesign.models.AccountBalanceV2 r2 = r4.getAccountBalance()
            java.lang.String r2 = r2.getValue()
        L_0x02d9:
            r0[r9] = r2
            java.lang.String r8 = java.lang.String.format(r8, r0)
            r3.setDisplaySecondaryInfo(r8)
        L_0x02e2:
            boolean r8 = r7.p(r1)
            if (r8 != 0) goto L_0x02ef
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r8 = r7.l
            boolean r9 = r7.B
            r8.setLimitBreached(r9)
        L_0x02ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(android.content.Context, boolean):void");
    }

    private void a(Context context, boolean z2, List<PayChannelOptionsV2> list, String str) {
        if (list != null) {
            if (str.equalsIgnoreCase("MERCHANT_SAVED")) {
                if (z2) {
                    this.W = new ArrayList();
                } else {
                    this.s = new ArrayList();
                }
            } else if (z2) {
                this.X = new ArrayList();
            } else {
                this.t = new ArrayList();
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                PayChannelOptionsV2 payChannelOptionsV2 = list.get(i2);
                InstrumentInfo instrumentInfo = new InstrumentInfo();
                instrumentInfo.setDisplayPrimaryInfo(context.getString(R.string.net_banking));
                instrumentInfo.setDisplaySecondaryInfo(payChannelOptionsV2.getChannelName());
                instrumentInfo.setmLowSuccess(payChannelOptionsV2.getHasLowSuccess());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AppConstants.ICON_URL, payChannelOptionsV2.getIconUrl());
                } catch (JSONException e2) {
                    q.d(String.valueOf(e2));
                }
                instrumentInfo.setmAdditionalParams(jSONObject);
                instrumentInfo.setPaymentDetails(payChannelOptionsV2.getChannelCode());
                instrumentInfo.setPayMode("NET_BANKING");
                instrumentInfo.setBankCode(payChannelOptionsV2.getChannelCode());
                instrumentInfo.setPaymentTypeId("NB");
                if (p(instrumentInfo.getPayMode())) {
                    instrumentInfo.setLimitBreached(this.B);
                }
                if (str.equalsIgnoreCase("MERCHANT_SAVED")) {
                    if (z2) {
                        this.W.add(instrumentInfo);
                    } else {
                        this.s.add(instrumentInfo);
                    }
                } else if (z2) {
                    this.X.add(instrumentInfo);
                } else {
                    this.t.add(instrumentInfo);
                }
            }
        }
    }

    private static List<PayChannelOptionsV2> a(CJRFetchPayMethodResponse cJRFetchPayMethodResponse, String str) {
        if (!(!str.equalsIgnoreCase("MERCHANT_SAVED") || cJRFetchPayMethodResponse == null || cJRFetchPayMethodResponse.getBody() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption() == null)) {
            ArrayList<PaymentModesV2> paymentModes = cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getPaymentModes();
            int size = paymentModes != null ? paymentModes.size() : 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (paymentModes.get(i2).getPaymentMode().equals("NET_BANKING")) {
                    return paymentModes.get(i2).getPayChannelOptions();
                }
            }
        }
        return null;
    }

    private static List<PayChannelOptionsV2> a(CJRFetchNBResponse cJRFetchNBResponse) {
        if (cJRFetchNBResponse == null || cJRFetchNBResponse.getBody() == null || cJRFetchNBResponse.getBody().getNbPayOption() == null) {
            return null;
        }
        return cJRFetchNBResponse.getBody().getNbPayOption().getPayChannelOptions();
    }

    public final List<InstrumentInfo> a(boolean z2) {
        if (!z2) {
            return this.W;
        }
        return this.X;
    }

    public final void a(InstrumentInfo instrumentInfo) {
        InstrumentInfo instrumentInfo2 = this.n;
        if (instrumentInfo2 != null) {
            this.ad = instrumentInfo2.getUniqueId();
        }
        this.n = instrumentInfo;
    }

    public final InstrumentInfo l() {
        return this.n;
    }

    public final InstrumentInfo m() {
        return this.k;
    }

    public final void a(Context context, CJRGoldPortfolio cJRGoldPortfolio) {
        InstrumentInfo instrumentInfo = this.k;
        if (instrumentInfo != null && cJRGoldPortfolio != null) {
            instrumentInfo.setmGoldPortfolio(cJRGoldPortfolio);
            if (TextUtils.isEmpty(cJRGoldPortfolio.getError())) {
                String string = net.one97.paytm.wallet.communicator.b.a().getContext().getString(R.string.rs);
                String string2 = net.one97.paytm.wallet.communicator.b.a().getContext().getString(R.string.gold_g_text);
                String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "gold_jeweller_balance_text");
                if (TextUtils.isEmpty(stringFromGTM)) {
                    stringFromGTM = context.getResources().getString(R.string.gold_available_bal_text);
                }
                String str = stringFromGTM + " " + string + "<b>" + cJRGoldPortfolio.getNetWorth() + "</b> | <b>" + cJRGoldPortfolio.getCustomerBalance() + "</b>" + string2;
                this.k.setBalance(String.valueOf(cJRGoldPortfolio.getNetWorth()));
                this.k.setDisplaySecondaryInfo("Today's Gold Price at : <b>" + string + com.paytm.utility.b.x(cJRGoldPortfolio.getGoldBuyPrice()) + "</b> per gram");
                this.k.setmDisplayPrimaryInfo2(str);
                this.k.setMinimumLimitForPayWithGold((double) cJRGoldPortfolio.getMinimumLimitForPayWithGold());
            }
        }
    }

    public final boolean n() {
        PaymentModesV2 e2 = e(SDKConstants.AI_KEY_PPBL);
        if (e2 == null || e2.isDisabled() == null) {
            return true;
        }
        return e2.isDisabled().getUserAccountExist().booleanValue();
    }

    public final InstrumentInfo o() {
        return this.j;
    }

    public final void a(Context context, double d2) {
        InstrumentInfo instrumentInfo = this.j;
        if (instrumentInfo != null) {
            instrumentInfo.setBalance(String.valueOf(d2));
            this.j.setDisplaySecondaryInfo(String.format(context.getString(R.string.balance_without_format_v2), new Object[]{com.paytm.utility.b.S(String.valueOf(d2))}));
        }
    }

    public final void a(Context context, double d2, String str) {
        List<InstrumentInfo> list = this.m;
        if (list != null) {
            for (InstrumentInfo next : list) {
                if (next.getmDisplayPrimaryInfo2().equalsIgnoreCase(str)) {
                    next.setBalance(Double.toString(d2));
                    next.setDisplaySecondaryInfo(String.format(net.one97.paytm.wallet.utility.a.a(context, R.string.balance_without_format_v2), new Object[]{com.paytm.utility.b.S(String.valueOf(d2))}));
                }
            }
        }
    }

    public final void a(String str, String str2, boolean z2) {
        InstrumentInfo instrumentInfo = this.f13093i;
        if (instrumentInfo != null) {
            instrumentInfo.setBalance(str);
            this.f13093i.setDisplaySecondaryInfo(String.format(net.one97.paytm.wallet.communicator.b.a().getContext().getString(R.string.balance_without_format_v2, new Object[]{com.paytm.utility.b.S(String.valueOf(str)).toString()}), new Object[0]));
            this.f13093i.setActive(z2);
            this.f13093i.setPasscodeRequired(str2);
        }
    }

    public final void a(Context context, List<UpiProfileDefaultBank> list) {
        if (list != null && list.size() != 0) {
            this.u = list;
            HashMap hashMap = new HashMap();
            this.m = new ArrayList();
            if (J()) {
                for (UpiProfileDefaultBank next : list) {
                    new UpiInstrumentInfo();
                    if (next.getDebitBank() != null && hashMap.get(next.getDebitBank().getBank()) == null) {
                        hashMap.put(next.getDebitBank().getBank(), 1);
                        if (!b(context, next.getDebitBank().getBank())) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(next.getDebitBank().getBank() + " ");
                            String maskedAccountNumber = next.getDebitBank().getMaskedAccountNumber();
                            sb.append(z(maskedAccountNumber));
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("A/c No.");
                            for (int i2 = 0; i2 < 5; i2++) {
                                if (i2 % 5 != 0) {
                                    sb2.append(S);
                                } else {
                                    sb2.append("  ");
                                }
                            }
                            sb2.append("  ");
                            sb2.append(z(maskedAccountNumber));
                            UpiInstrumentInfo a2 = a(sb.toString(), context, sb2.toString(), next.getVirtualAddress());
                            a2.setPaymentDetails(next.getVirtualAddress());
                            a2.setUpiDataModel(next);
                            a2.setAccountNumber(next.getDebitBank().getAccRefId());
                            if (p(a2.getPayMode())) {
                                a2.setLimitBreached(this.B);
                            }
                            this.m.add(a2);
                        }
                    }
                }
                return;
            }
            for (UpiProfileDefaultBank next2 : list) {
                new UpiInstrumentInfo();
                if (next2.getDebitBank() != null && hashMap.get(next2.getDebitBank().getBank()) == null) {
                    hashMap.put(next2.getDebitBank().getBank(), 1);
                    if (!b(context, next2.getDebitBank().getBank())) {
                        String bank = next2.getDebitBank().getBank();
                        String accRefNumber = next2.getDebitBank().getAccRefNumber();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(bank + " ");
                        int length = accRefNumber.length();
                        sb3.append("XX " + accRefNumber.substring(length + -4));
                        UpiInstrumentInfo a3 = a(sb3.toString(), context, A(next2.getDebitBank().getAccRefNumber()), next2.getVirtualAddress());
                        a3.setPaymentDetails(next2.getVirtualAddress());
                        a3.setUpiDataModel(next2);
                        a3.setAccountNumber(next2.getDebitBank().getAccRefNumber());
                        if (p(a3.getPayMode())) {
                            a3.setLimitBreached(this.B);
                        }
                        this.m.add(a3);
                    }
                }
            }
        }
    }

    public final List<InstrumentInfo> p() {
        return this.m;
    }

    public final void q() {
        this.f13087c = null;
        this.f13093i = null;
        this.m = null;
        this.f13086b = "";
        this.j = null;
        this.k = null;
        this.l = null;
        this.y = false;
        this.z = false;
        this.B = false;
        this.A = null;
        this.C = null;
        this.D = false;
        this.w = false;
        this.E = false;
        this.H = null;
        this.J = null;
        this.I = null;
        this.K = false;
        this.M = null;
        this.N = null;
        this.L = false;
        this.U = null;
        this.W = null;
        this.X = null;
        this.Q = null;
    }

    public final boolean a(Context context) {
        if ((net.one97.paytm.wallet.communicator.b.a().isPPBCustomer(context) || net.one97.paytm.wallet.communicator.b.a().isPaymentBankUser(context)) || u()) {
            return false;
        }
        List<InstrumentInfo> list = this.m;
        if ((list != null && list.size() > 0) || f().d("UPI")) {
            return false;
        }
        return !(f().d(SDKConstants.CREDIT) || f().d(SDKConstants.DEBIT)) && !f().d("NET_BANKING");
    }

    public final boolean b(Context context) {
        if (r()) {
            return false;
        }
        if ((net.one97.paytm.wallet.communicator.b.a().isPPBCustomer(context) || net.one97.paytm.wallet.communicator.b.a().isPaymentBankUser(context)) && s()) {
            return false;
        }
        return (!u() || t()) && f().d("BALANCE");
    }

    public final boolean r() {
        if (d("NET_BANKING") && (x("NET_BANKING") == null || !x("NET_BANKING").getStatus().booleanValue())) {
            return true;
        }
        if (d(SDKConstants.DEBIT) && (x(SDKConstants.DEBIT) == null || !x(SDKConstants.DEBIT).getStatus().booleanValue())) {
            return true;
        }
        if (d(SDKConstants.CREDIT) && (x(SDKConstants.CREDIT) != null || !x(SDKConstants.CREDIT).getStatus().booleanValue())) {
            return true;
        }
        if (d("UPI")) {
            return x("UPI") == null || !x("UPI").getStatus().booleanValue();
        }
        return false;
    }

    public final boolean s() {
        if (d(SDKConstants.AI_KEY_PPBL)) {
            return x(SDKConstants.AI_KEY_PPBL) == null || !x(SDKConstants.AI_KEY_PPBL).getStatus().booleanValue();
        }
        return false;
    }

    public final boolean t() {
        if (d("PAYTM_DIGITAL_CREDIT")) {
            return x("PAYTM_DIGITAL_CREDIT") == null || !x("PAYTM_DIGITAL_CREDIT").getStatus().booleanValue();
        }
        return false;
    }

    public static boolean u() {
        return be.a(net.one97.paytm.wallet.communicator.b.a().getContext()).b("isCreditCard", false, true);
    }

    public final boolean b(InstrumentInfo instrumentInfo) {
        return instrumentInfo.equals(this.n);
    }

    public final List<InstrumentInfo> h(String str) {
        if (str.equalsIgnoreCase(SDKConstants.DEBIT)) {
            return this.o;
        }
        return this.p;
    }

    public final void i(String str) {
        this.f13089e = str;
    }

    public final void j(String str) {
        this.f13090f = str;
    }

    public final void k(String str) {
        this.f13088d = str;
    }

    public final void a(Context context, CJRFetchNBResponse cJRFetchNBResponse) {
        a(context, false, a(cJRFetchNBResponse), "MERCHANT_SAVED");
        a(context, false, a(cJRFetchNBResponse), "ADD_MONEY_SAVED");
    }

    public final BankAccountDetails.BankAccount l(String str) {
        String str2 = str;
        for (UpiProfileDefaultBank next : this.u) {
            if (next.getDebitBank() != null) {
                if (J()) {
                    if (next.getDebitBank().getAccRefId().equalsIgnoreCase(str2)) {
                        return a(next.getDebitBank().getMaskedAccountNumber(), next.getDebitBank().getAccountType(), next.getDebitBank().getAccRefId(), next.getDebitBank().getAccRefId(), next.getDebitBank().getAeba(), next.getDebitBank().getBankLogoUrl(), next.getDebitBank().getBank(), next.getDebitBank().getName(), next.getDebitBank().getIfsc(), next.getDebitBank().getMmid(), next.getDebitBank().getMpinSet(), next.getDebitBank().getCredsAllowed(), next.getVirtualAddress(), next.isPrimary()).getDebitBank();
                    }
                } else if (next.getDebitBank().getAccRefNumber().equalsIgnoreCase(str2)) {
                    String account = next.getDebitBank().getAccount();
                    String accountType = next.getDebitBank().getAccountType();
                    String accRefNumber = next.getDebitBank().getAccRefNumber();
                    String accRefId = next.getDebitBank().getAccRefId();
                    String aeba = next.getDebitBank().getAeba();
                    String bankLogoUrl = next.getDebitBank().getBankLogoUrl();
                    String bank = next.getDebitBank().getBank();
                    String name = next.getDebitBank().getName();
                    String ifsc = next.getDebitBank().getIfsc();
                    String mmid = next.getDebitBank().getMmid();
                    StringBuilder sb = new StringBuilder();
                    sb.append(next.getDebitBank().getMbeba());
                    return a(account, accountType, accRefNumber, accRefId, aeba, bankLogoUrl, bank, name, ifsc, mmid, sb.toString(), next.getDebitBank().getCredsAllowed(), next.getVirtualAddress(), next.isPrimary()).getDebitBank();
                }
            }
        }
        return null;
    }

    public final net.one97.paytm.upi.common.upi.UpiProfileDefaultBank m(String str) {
        if (J()) {
            for (UpiProfileDefaultBank next : this.u) {
                if (next.getDebitBank() != null && next.getDebitBank().getAccRefId().equalsIgnoreCase(str)) {
                    return b(next);
                }
            }
            return null;
        }
        for (UpiProfileDefaultBank next2 : this.u) {
            if (next2.getDebitBank() != null && next2.getDebitBank().getAccRefNumber().equalsIgnoreCase(str)) {
                return b(next2);
            }
        }
        return null;
    }

    public final String n(String str) {
        List<PaymentModesV2> b2 = b();
        if (b2 != null && b2.size() > 0) {
            Iterator<PaymentModesV2> it2 = b2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PaymentModesV2 next = it2.next();
                if (next != null && next.getPaymentMode() != null && next.getPaymentMode().equalsIgnoreCase(str)) {
                    if (next.getPayChannelOptions() != null && next.getPayChannelOptions().size() > 0) {
                        return next.getPayChannelOptions().get(0).getIconUrl();
                    }
                }
            }
        }
        return "";
    }

    public static net.one97.paytm.upi.common.upi.UpiProfileDefaultBank a(UpiProfileDefaultBank upiProfileDefaultBank) {
        net.one97.paytm.upi.common.upi.UpiProfileDefaultBank upiProfileDefaultBank2 = new net.one97.paytm.upi.common.upi.UpiProfileDefaultBank();
        BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
        bankAccount.setAccount(upiProfileDefaultBank.getDebitBank().getMaskedAccountNumber());
        bankAccount.setAccRefNumber(upiProfileDefaultBank.getDebitBank().getAccRefNumber());
        bankAccount.setAccountType(upiProfileDefaultBank.getDebitBank().getAccountType());
        bankAccount.setAccRefId(upiProfileDefaultBank.getDebitBank().getAccRefId());
        bankAccount.setAeba(upiProfileDefaultBank.getDebitBank().getAeba());
        bankAccount.setBankLogoUrl(upiProfileDefaultBank.getDebitBank().getBankLogoUrl());
        bankAccount.setBankName(upiProfileDefaultBank.getDebitBank().getBank());
        bankAccount.setCustomerName(upiProfileDefaultBank.getDebitBank().getName());
        bankAccount.setIfsc(upiProfileDefaultBank.getDebitBank().getIfsc());
        bankAccount.setMbeba(upiProfileDefaultBank.getDebitBank().getMpinSet());
        bankAccount.setMmid(upiProfileDefaultBank.getDebitBank().getMmid());
        ArrayList arrayList = new ArrayList();
        ArrayList<CredsAllowedV2> credsAllowed = upiProfileDefaultBank.getDebitBank().getCredsAllowed();
        if (credsAllowed != null && credsAllowed.size() > 0) {
            for (CredsAllowedV2 next : credsAllowed) {
                BankAccountDetails.BankAccountCredentials bankAccountCredentials = new BankAccountDetails.BankAccountCredentials();
                bankAccountCredentials.setCredsAllowedDLength(next.getCredsAllowedDLength());
                bankAccountCredentials.setCredsAllowedDType(next.getCredsAllowedDType());
                bankAccountCredentials.setCredsAllowedSubType1(next.getCredsAllowedSubType());
                bankAccountCredentials.setCredsAllowedType(next.getCredsAllowedType());
                arrayList.add(bankAccountCredentials);
            }
        }
        bankAccount.setBankCredsAllowed(arrayList);
        upiProfileDefaultBank2.setDebitBank(bankAccount);
        upiProfileDefaultBank2.setVirtualAddress(upiProfileDefaultBank.getVirtualAddress());
        upiProfileDefaultBank2.setPrimary(upiProfileDefaultBank.isPrimary());
        return upiProfileDefaultBank2;
    }

    public static void a(Context context, ImageView imageView, String str, String str2) {
        try {
            if ("BALANCE".equalsIgnoreCase(str2)) {
                imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_wallet));
            } else if (SDKConstants.AI_KEY_PPBL.equalsIgnoreCase(str2)) {
                imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_ppb));
            } else if ("UPI".equalsIgnoreCase(str2)) {
                imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_wallet_upi));
            } else if ("PAYTM_DIGITAL_CREDIT".equalsIgnoreCase(str2)) {
                imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_postpaid));
            } else if (TextUtils.isEmpty(str)) {
                imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.net_banking_icon));
            } else {
                w.a().a(str).a(androidx.core.content.b.a(context, R.drawable.net_banking_icon)).a(imageView, (e) null);
            }
        } catch (RuntimeException unused) {
        }
    }

    public final ArrayList<InstrumentInfo> o(String str) {
        ArrayList<InstrumentInfo> arrayList = new ArrayList<>();
        List<InstrumentInfo> list = this.Y;
        if (list != null) {
            for (InstrumentInfo next : list) {
                if (a(next, str)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static boolean a(InstrumentInfo instrumentInfo, String str) {
        if (instrumentInfo == null || (instrumentInfo.getmIsDisabled() != null && instrumentInfo.getmIsDisabled().getStatus().booleanValue())) {
            return false;
        }
        double d2 = 0.0d;
        Double valueOf = Double.valueOf(instrumentInfo.getmMinAmount() == null ? 0.0d : instrumentInfo.getmMinAmount().getValue().doubleValue());
        if (instrumentInfo.getmMaxAmount() != null) {
            d2 = instrumentInfo.getmMaxAmount().getValue().doubleValue();
        }
        Double valueOf2 = Double.valueOf(d2);
        if (!TextUtils.isEmpty(str)) {
            Double valueOf3 = Double.valueOf(Double.parseDouble(str));
            if (valueOf.doubleValue() > valueOf3.doubleValue() || valueOf3.doubleValue() > valueOf2.doubleValue()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void e(Context context) {
        ArrayList<PayChannelOptionsV2> payChannelOptions;
        this.Y = new ArrayList();
        PaymentModesV2 e2 = e("emi");
        if (e2 != null && (payChannelOptions = e2.getPayChannelOptions()) != null) {
            for (int i2 = 0; i2 < payChannelOptions.size(); i2++) {
                PayChannelOptionsV2 payChannelOptionsV2 = payChannelOptions.get(i2);
                if (!payChannelOptionsV2.getChannelCode().equalsIgnoreCase(SDKConstants.ZEST_MONEY_CHANNEL_CODE) && !payChannelOptionsV2.getChannelName().equalsIgnoreCase("ZestMoney") && !payChannelOptionsV2.getChannelCode().equalsIgnoreCase(SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE) && !payChannelOptionsV2.getChannelName().equalsIgnoreCase("BAJAJ FINSERV EMI CARD")) {
                    InstrumentInfo instrumentInfo = new InstrumentInfo();
                    instrumentInfo.setDisplayPrimaryInfo(context.getString(R.string.net_banking));
                    instrumentInfo.setDisplaySecondaryInfo(payChannelOptionsV2.getChannelName());
                    instrumentInfo.setmLowSuccess(payChannelOptionsV2.getHasLowSuccess());
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(AppConstants.ICON_URL, payChannelOptionsV2.getIconUrl());
                    } catch (JSONException e3) {
                        q.d(String.valueOf(e3));
                    }
                    instrumentInfo.setmAdditionalParams(jSONObject);
                    instrumentInfo.setPaymentDetails(payChannelOptionsV2.getChannelCode());
                    instrumentInfo.setPayMode("emi");
                    instrumentInfo.setBankCode(payChannelOptionsV2.getChannelCode());
                    instrumentInfo.setBankName(payChannelOptionsV2.getChannelName());
                    instrumentInfo.setPaymentTypeId("emi");
                    instrumentInfo.setmMinAmount(payChannelOptionsV2.getMinAmount());
                    instrumentInfo.setCardType(payChannelOptionsV2.getEmiType());
                    instrumentInfo.setmMaxAmount(payChannelOptionsV2.getMaxAmount());
                    if (!p(instrumentInfo.getPayMode())) {
                        instrumentInfo.setLimitBreached(this.B);
                    }
                    this.Y.add(instrumentInfo);
                }
            }
        }
    }

    public final void a(net.one97.paytm.p2mNewDesign.models.a aVar) {
        this.n.setSelectedEMIPlan(aVar);
    }

    public final boolean v() {
        InstrumentInfo instrumentInfo = this.n;
        if (instrumentInfo == null) {
            return false;
        }
        return instrumentInfo.isFromSavedCard();
    }

    public final AmountV2 w() {
        List<InstrumentInfo> list = this.Y;
        AmountV2 amountV2 = null;
        if (list != null) {
            for (InstrumentInfo next : list) {
                if (next.getmMinAmount() != null) {
                    if (amountV2 == null) {
                        amountV2 = next.getmMinAmount();
                    } else if (amountV2.getValue().doubleValue() >= next.getmMinAmount().getValue().doubleValue()) {
                        amountV2 = next.getmMinAmount();
                    }
                }
            }
        }
        return amountV2;
    }

    public final boolean x() {
        List<InstrumentInfo> list = this.W;
        return list != null && list.size() > 0;
    }

    public final boolean a(double d2) {
        AmountV2 w2 = w();
        List<InstrumentInfo> list = this.Y;
        AmountV2 amountV2 = null;
        if (list != null) {
            for (InstrumentInfo next : list) {
                if (next.getmMaxAmount() != null) {
                    if (amountV2 == null) {
                        amountV2 = next.getmMaxAmount();
                    } else if (amountV2.getValue().doubleValue() >= next.getmMaxAmount().getValue().doubleValue()) {
                        amountV2 = next.getmMaxAmount();
                    }
                }
            }
        }
        List<InstrumentInfo> list2 = this.Y;
        if (list2 == null || list2.size() == 0 || w2 == null || amountV2 == null || d2 < w2.getValue().doubleValue() || d2 > amountV2.getValue().doubleValue()) {
            return false;
        }
        return true;
    }

    public final List y() {
        List<PaymentModesV2> b2 = f().b();
        if (b2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.addAll(b2);
        ArrayList<InstrumentInfo> arrayList2 = this.U;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<InstrumentInfo> it2 = this.U.iterator();
            while (it2.hasNext()) {
                InstrumentInfo next = it2.next();
                PaymentModesV2 paymentModesV2 = new PaymentModesV2();
                paymentModesV2.setPriority(next.getPriority());
                paymentModesV2.setDisplayName(next.getPaymentDetails());
                paymentModesV2.setPaymentMode(next.getPaymentTypeId().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD) ? "SAVED_CC" : "SAVED_DC");
                arrayList.add(paymentModesV2);
            }
        }
        List<InstrumentInfo> list = this.m;
        ArrayList arrayList3 = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                PaymentModesV2 paymentModesV22 = (PaymentModesV2) it3.next();
                if (paymentModesV22.getPaymentMode().equalsIgnoreCase("UPI")) {
                    String priority = paymentModesV22.getPriority();
                    it3.remove();
                    for (InstrumentInfo accountNumber : list) {
                        PaymentModesV2 paymentModesV23 = new PaymentModesV2();
                        paymentModesV23.setPriority(priority);
                        paymentModesV23.setPaymentMode("UPI");
                        paymentModesV23.setDisplayName(accountNumber.getAccountNumber());
                        arrayList.add(paymentModesV23);
                        arrayList3.add(paymentModesV23);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean c(Context context) {
        return net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(context, "isPPBToUPIEnabledV2", false);
    }

    public final boolean z() {
        return (this.f13085a == null || this.f13085a.getBody() == null || this.f13085a.getBody().getMerchantDetails() == null || TextUtils.isEmpty(this.f13085a.getBody().getMerchantDetails().getMerchantName()) || TextUtils.isEmpty(this.f13085a.getBody().getMerchantDetails().getMerchantVpa())) ? false : true;
    }

    public final int b(CJRFetchPayMethodResponse cJRFetchPayMethodResponse) {
        List<PaymentModesV2> b2;
        List<PaymentModesV2> b3;
        if (f().J()) {
            if (!(!z() || cJRFetchPayMethodResponse.getBody() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile() == null || !cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getUpiOnboarding().booleanValue())) {
                if (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getPaymentModes() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getVpaDetails() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getVpaDetails().size() <= 0) {
                    if (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getPaymentModes() != null && (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getVpaDetails() != null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getVpaDetails().size() == 0)) {
                        for (PaymentModesV2 paymentMode : b()) {
                            if (paymentMode.getPaymentMode().equalsIgnoreCase("UPI")) {
                                return j.c.NO_UPI.getValue();
                            }
                        }
                    }
                    List<InstrumentInfo> list = this.m;
                    if ((list == null || list.size() == 0) && ((b3 = b()) == null || b3.size() == 0)) {
                        return j.c.MERCHANT_UPI_NOT_AVAILABLE.getValue();
                    }
                    return j.c.UPI_WITH_BANK_LINK.getValue();
                } else if (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getBankAccounts().get(0) == null) {
                    return j.c.UPI_CREATED_NO_BANK_LINK.getValue();
                } else {
                    return j.c.UPI_WITH_BANK_LINK.getValue();
                }
            }
        } else if (z()) {
            if (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getPaymentModes() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getStatus() == null || !"success".equalsIgnoreCase(cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getStatus()) || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse().getVpaDetails() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse().getVpaDetails().size() <= 0) {
                if (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getPaymentModes() != null && (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse().getVpaDetails() == null || cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse().getVpaDetails().size() == 0)) {
                    for (PaymentModesV2 paymentMode2 : b()) {
                        if (paymentMode2.getPaymentMode().equalsIgnoreCase("UPI")) {
                            return j.c.NO_UPI.getValue();
                        }
                    }
                }
                List<InstrumentInfo> list2 = this.m;
                if ((list2 == null || list2.size() == 0) && ((b2 = b()) == null || b2.size() == 0)) {
                    return j.c.MERCHANT_UPI_NOT_AVAILABLE.getValue();
                }
                return j.c.UPI_WITH_BANK_LINK.getValue();
            } else if (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse().getVpaDetails().get(0).getDefaultDebit() == null) {
                return j.c.UPI_CREATED_NO_BANK_LINK.getValue();
            } else {
                return j.c.UPI_WITH_BANK_LINK.getValue();
            }
        }
        return j.c.MERCHANT_UPI_NOT_AVAILABLE.getValue();
    }

    public final void a(UPIProfileV2 uPIProfileV2, UserProfileSarvatraV2 userProfileSarvatraV2) {
        if (this.f13085a != null && this.f13085a.getBody() != null && this.f13085a.getBody().getMerchantPayOption() != null) {
            this.f13085a.getBody().getMerchantPayOption().setUserProfileSarvatra(userProfileSarvatraV2);
            this.f13085a.getBody().getMerchantPayOption().setUpiProfile(uPIProfileV2);
            a(net.one97.paytm.wallet.communicator.b.a().getContext(), this.u);
        }
    }

    public final InstrumentInfo A() {
        return this.l;
    }

    public final void a(List<a> list) {
        this.ab = list;
    }

    public final boolean p(String str) {
        if (this.f13085a.getBody().getMerchantLimitInfo() == null || this.f13085a.getBody().getMerchantLimitInfo().getExcludedPaymodes() == null) {
            return false;
        }
        return this.f13085a.getBody().getMerchantLimitInfo().getExcludedPaymodes().contains(str);
    }

    public final boolean B() {
        return this.B;
    }

    public static boolean q(String str) {
        if ((!f().d(str) || !f().p(str)) && f().d(str) && f().B) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean C() {
        /*
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = f()
            java.util.List r0 = r0.b()
            if (r0 == 0) goto L_0x0057
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = f()
            java.util.List r0 = r0.b()
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r0.next()
            net.one97.paytm.p2mNewDesign.models.PaymentModesV2 r1 = (net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r1
            java.util.ArrayList r2 = r1.getPayChannelOptions()
            if (r2 == 0) goto L_0x0016
            java.util.ArrayList r1 = r1.getPayChannelOptions()
            java.util.Iterator r1 = r1.iterator()
        L_0x0030:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0016
            java.lang.Object r2 = r1.next()
            net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r2 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r2
            java.lang.String r3 = r2.getChannelCode()
            java.lang.String r4 = "UPIPUSHEXPRESS"
            boolean r3 = r4.equalsIgnoreCase(r3)
            r4 = 0
            if (r3 == 0) goto L_0x004a
            return r4
        L_0x004a:
            java.lang.String r2 = r2.getChannelCode()
            java.lang.String r3 = "UPI"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0030
            return r4
        L_0x0057:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.C():boolean");
    }

    public final String D() {
        if (!(this.ac != null || this.f13085a == null || this.f13085a.getBody() == null || this.f13085a.getBody().getOneClickMaxAmount() == null)) {
            this.ac = this.f13085a.getBody().getOneClickMaxAmount();
        }
        return this.ac;
    }

    public final boolean r(String str) {
        return Double.compare(Double.parseDouble(str), j.f72322a.doubleValue()) == 0 && Double.valueOf(this.f13087c.getTotalBalance()).doubleValue() <= 0.0d;
    }

    public final boolean s(String str) {
        if (f().H == null || !f().H.isChecked()) {
            InstrumentInfo instrumentInfo = this.f13087c;
            return instrumentInfo != null && !TextUtils.isEmpty(instrumentInfo.getTotalBalance()) && Double.valueOf(this.f13087c.getTotalBalance()).doubleValue() < Double.valueOf(str).doubleValue();
        } else if ("USER_ENROLMENT".equalsIgnoreCase(this.H.getContext())) {
            String valueOf = String.valueOf(new DecimalFormat("0.00").format(Double.parseDouble(this.H.getBonusPoint()) / 100.0d));
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = "0";
            }
            return Double.valueOf(valueOf).doubleValue() < Double.valueOf(com.paytm.utility.b.Q(str)).doubleValue() - Double.valueOf(f().f13087c.getTotalBalance()).doubleValue();
        } else {
            String valueOf2 = String.valueOf((Double.valueOf(str).doubleValue() * Double.valueOf(this.H.getRedeemablePercentage()).doubleValue()) / 100.0d);
            if (Double.parseDouble(valueOf2) > Double.parseDouble(this.H.getTotalAvailableBalance())) {
                valueOf2 = this.H.getTotalAvailableBalance();
            }
            return Double.valueOf(valueOf2).doubleValue() < Double.valueOf(com.paytm.utility.b.Q(str)).doubleValue() - Double.valueOf(f().f13087c.getTotalBalance()).doubleValue();
        }
    }

    public final boolean E() {
        InstrumentInfo instrumentInfo;
        if (f().J != null && f().H != null) {
            return true;
        }
        if (!j.b.NONE.getValue().equalsIgnoreCase((this.f13085a == null || this.f13085a.getBody() == null) ? "" : this.f13085a.body.getPaymentFlow()) || (instrumentInfo = this.f13087c) == null || instrumentInfo.isWalletAPIFAIL() || !d("BALANCE")) {
            return false;
        }
        return true;
    }

    public static boolean a(RetryInfo retryInfo) {
        if (retryInfo == null || !retryInfo.getPopupEnable() || TextUtils.isEmpty(retryInfo.getFailureHeader()) || TextUtils.isEmpty(retryInfo.getFailureMessage()) || retryInfo.getButtons() == null || retryInfo.getButtons().size() <= 0) {
            return false;
        }
        return UpiConstants.BANK_HEALTH_STATUS_BLOCK.equalsIgnoreCase(retryInfo.getFailureType()) || "PROCEED".equalsIgnoreCase(retryInfo.getFailureType());
    }

    public static boolean F() {
        return (f().e() == null || f().e().getBody() == null || !f().e().getBody().getPcfEnabled()) ? false : true;
    }

    public final c G() {
        return this.H;
    }

    public final String H() {
        return this.ad;
    }

    public final boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!TextUtils.isEmpty(this.ad) && this.ad.contains("BALANCE") && E() && s(str)) {
            return false;
        }
        InstrumentInfo instrumentInfo = this.n;
        if (instrumentInfo == null || !"BALANCE".equalsIgnoreCase(instrumentInfo.getPayMode()) || !E() || !s(str)) {
            return true;
        }
        return false;
    }

    public final boolean I() {
        if (this.f13085a == null || this.f13085a.getBody() == null) {
            return false;
        }
        return this.f13085a.body.getAddDescriptionMandatory();
    }

    public final String d(Context context) {
        if (this.f13085a == null || this.f13085a.getBody() == null || TextUtils.isEmpty(this.f13085a.getBody().getDescriptionTextFormat())) {
            return context.getString(R.string.description);
        }
        return this.f13085a.getBody().getDescriptionTextFormat();
    }

    public static boolean a(IsDisabledV2 isDisabledV2) {
        if (isDisabledV2 == null) {
            return false;
        }
        return isDisabledV2.getStatus().booleanValue();
    }

    public static String a(UPIProfileV2 uPIProfileV2) {
        ArrayList<VpaDetailsV2> vpaDetails = uPIProfileV2.getRespDetails().getProfileDetail().getVpaDetails();
        if (vpaDetails == null || vpaDetails.size() <= 0) {
            return null;
        }
        for (VpaDetailsV2 next : vpaDetails) {
            if (next.getPrimary().booleanValue()) {
                return next.getName();
            }
        }
        return null;
    }

    private static String z(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length() - 1;
        for (int i2 = 6; i2 != 0; i2--) {
            if (i2 == 2) {
                sb.append(" ");
            }
            sb.append(str.charAt(length));
            length--;
        }
        return sb.reverse().toString();
    }

    public final boolean J() {
        try {
            return this.f13085a.getBody().getMerchantPayOption().getUpiProfile() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private static net.one97.paytm.upi.common.upi.UpiProfileDefaultBank b(UpiProfileDefaultBank upiProfileDefaultBank) {
        net.one97.paytm.upi.common.upi.UpiProfileDefaultBank upiProfileDefaultBank2 = new net.one97.paytm.upi.common.upi.UpiProfileDefaultBank();
        upiProfileDefaultBank2.setPrimary(upiProfileDefaultBank.isPrimary());
        BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
        bankAccount.setAccount(upiProfileDefaultBank.getDebitBank().getMaskedAccountNumber());
        bankAccount.setAccountType(upiProfileDefaultBank.getDebitBank().getAccountType());
        bankAccount.setAccRefNumber(upiProfileDefaultBank.getDebitBank().getAccRefNumber());
        bankAccount.setAccRefId(upiProfileDefaultBank.getDebitBank().getAccRefId());
        bankAccount.setAeba(upiProfileDefaultBank.getDebitBank().getAeba());
        bankAccount.setBankLogoUrl(upiProfileDefaultBank.getDebitBank().getBankLogoUrl());
        bankAccount.setBankName(upiProfileDefaultBank.getDebitBank().getBank());
        bankAccount.setCustomerName(upiProfileDefaultBank.getDebitBank().getName());
        bankAccount.setIfsc(upiProfileDefaultBank.getDebitBank().getIfsc());
        bankAccount.setMbeba(upiProfileDefaultBank.getDebitBank().getMpinSet());
        bankAccount.setMmid(upiProfileDefaultBank.getDebitBank().getMmid());
        ArrayList arrayList = new ArrayList();
        ArrayList<CredsAllowedV2> credsAllowed = upiProfileDefaultBank.getDebitBank().getCredsAllowed();
        if (credsAllowed != null && credsAllowed.size() > 0) {
            for (CredsAllowedV2 next : credsAllowed) {
                BankAccountDetails.BankAccountCredentials bankAccountCredentials = new BankAccountDetails.BankAccountCredentials();
                bankAccountCredentials.setCredsAllowedDLength(next.getCredsAllowedDLength());
                bankAccountCredentials.setCredsAllowedDType(next.getCredsAllowedDType());
                bankAccountCredentials.setCredsAllowedSubType1(next.getCredsAllowedSubType());
                bankAccountCredentials.setCredsAllowedType(next.getCredsAllowedType());
                arrayList.add(bankAccountCredentials);
            }
        }
        bankAccount.setBankCredsAllowed(arrayList);
        upiProfileDefaultBank2.setDebitBank(bankAccount);
        upiProfileDefaultBank2.setVirtualAddress(upiProfileDefaultBank.getVirtualAddress());
        upiProfileDefaultBank2.setPrimary(upiProfileDefaultBank.isPrimary());
        return upiProfileDefaultBank2;
    }

    private boolean b(Context context, String str) {
        if (net.one97.paytm.wallet.communicator.b.a().getContext().getResources().getString(R.string.paytm_payment_bank).equalsIgnoreCase(str) && d("UPI")) {
            if (c(context) || !d(SDKConstants.AI_KEY_PPBL)) {
                this.y = true;
            } else {
                this.y = false;
                return true;
            }
        }
        return false;
    }

    private UpiInstrumentInfo a(String str, Context context, String str2, String str3) {
        UpiInstrumentInfo upiInstrumentInfo = new UpiInstrumentInfo();
        upiInstrumentInfo.setDisplayPrimaryInfo(str);
        upiInstrumentInfo.setDisplaySecondaryInfo(context.getString(R.string.check_balance));
        upiInstrumentInfo.setmDisplayPrimaryInfo2(str2);
        upiInstrumentInfo.setmDisplaythirdInfo(str3);
        upiInstrumentInfo.setPaymentTypeId("UPI");
        upiInstrumentInfo.setPayMode("UPI");
        upiInstrumentInfo.setmIsDisabled(y("UPI"));
        return upiInstrumentInfo;
    }

    private static String A(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("A/c No.");
        for (int i2 = 0; i2 < 5; i2++) {
            if (i2 % 5 != 0) {
                sb.append(S);
            } else {
                sb.append("  ");
            }
        }
        sb.append("  ");
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    private static net.one97.paytm.upi.common.upi.UpiProfileDefaultBank a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<CredsAllowedV2> list, String str12, boolean z2) {
        net.one97.paytm.upi.common.upi.UpiProfileDefaultBank upiProfileDefaultBank = new net.one97.paytm.upi.common.upi.UpiProfileDefaultBank();
        BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
        bankAccount.setAccount(str);
        bankAccount.setAccountType(str2);
        bankAccount.setAccRefNumber(str3);
        bankAccount.setAccRefId(str4);
        bankAccount.setAeba(str5);
        bankAccount.setBankLogoUrl(str6);
        bankAccount.setBankName(str7);
        bankAccount.setCustomerName(str8);
        bankAccount.setIfsc(str9);
        bankAccount.setMmid(str10);
        bankAccount.setMbeba(str11);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (CredsAllowedV2 next : list) {
                BankAccountDetails.BankAccountCredentials bankAccountCredentials = new BankAccountDetails.BankAccountCredentials();
                bankAccountCredentials.setCredsAllowedDLength(next.getCredsAllowedDLength());
                bankAccountCredentials.setCredsAllowedDType(next.getCredsAllowedDType());
                bankAccountCredentials.setCredsAllowedSubType1(next.getCredsAllowedSubType());
                bankAccountCredentials.setCredsAllowedType(next.getCredsAllowedType());
                arrayList.add(bankAccountCredentials);
            }
        }
        bankAccount.setBankCredsAllowed(arrayList);
        upiProfileDefaultBank.setDebitBank(bankAccount);
        upiProfileDefaultBank.setVirtualAddress(str12);
        upiProfileDefaultBank.setPrimary(z2);
        return upiProfileDefaultBank;
    }

    public final String u(String str) {
        if (this.f13085a.getBody().getMerchantLimitInfo() == null || this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits() == null || this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits().size() <= 0) {
            return null;
        }
        for (MerchantPaymodesLimits next : this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits()) {
            if (str.equalsIgnoreCase(next.getPayMode()) && !TextUtils.isEmpty(next.getLimit()) && !"0".equalsIgnoreCase(next.getLimit())) {
                return next.getLimit();
            }
        }
        return null;
    }

    public final boolean v(String str) {
        if (this.f13085a.getBody().getMerchantLimitInfo() == null || this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits() == null || this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits().size() <= 0) {
            return false;
        }
        for (MerchantPaymodesLimits next : this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits()) {
            if (str.equalsIgnoreCase(next.getPayMode()) && !TextUtils.isEmpty(next.getLimit()) && !"0".equalsIgnoreCase(next.getLimit())) {
                return next.getShowPopUp();
            }
        }
        return false;
    }

    public final String w(String str) {
        if (this.f13085a.getBody().getMerchantLimitInfo() == null || this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits() == null || this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits().size() <= 0) {
            return null;
        }
        for (MerchantPaymodesLimits next : this.f13085a.getBody().getMerchantLimitInfo().getMerchantPaymodesLimits()) {
            if (str.equalsIgnoreCase(next.getPayMode()) && !TextUtils.isEmpty(next.getLimit()) && !"0".equalsIgnoreCase(next.getLimit())) {
                return next.getMsg();
            }
        }
        return null;
    }
}
