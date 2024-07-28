package net.one97.paytm.wallet.newdesign.universalp2p.c;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.j;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.common.entity.wallet.universalp2p.FetchMerchantUserInfoResponse;
import net.one97.paytm.common.entity.wallet.universalp2p.P2PreferShopResponse;
import net.one97.paytm.common.entity.wallet.universalp2p.UserPaymentInstrumentationResDataModel;
import net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.UserVpaInfo;
import net.one97.paytm.utils.z;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.universalp2p.a;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;
import net.one97.paytm.wallet.newdesign.utils.NoInternetAlertDialogFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static b u;
    private boolean A;
    private boolean B;
    private boolean C;
    /* access modifiers changed from: private */
    public List<UserVpaInfo> D;
    private boolean E;
    private String F;
    private List<ConsolidatePaymentInstrumentationRes.Error> G = new ArrayList();
    private List<ConsolidatePaymentInstrumentationRes.PaymentOptionList> H = new ArrayList();
    private FetchMerchantUserInfoResponse I;

    /* renamed from: a  reason: collision with root package name */
    List<c> f71398a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    boolean f71399b;

    /* renamed from: c  reason: collision with root package name */
    public UserPaymentInstrumentationResDataModel f71400c;

    /* renamed from: d  reason: collision with root package name */
    public UserPaymentInstrumentationResDataModel f71401d;

    /* renamed from: e  reason: collision with root package name */
    public CJRCashWallet f71402e;

    /* renamed from: f  reason: collision with root package name */
    public CustProductList f71403f;

    /* renamed from: g  reason: collision with root package name */
    public WalletLimitsResDataModel f71404g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71405h = false;

    /* renamed from: i  reason: collision with root package name */
    z f71406i;
    public f j = null;
    boolean k;
    boolean l;
    public String m = "";
    public String n;
    public String o;
    boolean p;
    public boolean q;
    public List<c> r = new ArrayList();
    public ConsolidatePaymentInstrumentationRes s;
    public List<f> t = new ArrayList();
    private net.one97.paytm.wallet.newdesign.universalp2p.a v;
    private Activity w;
    private List<c> x = new ArrayList();
    private List<c> y = new ArrayList();
    /* access modifiers changed from: private */
    public boolean z;

    public enum a {
        ACCOUNT_NUMBER,
        AADHAR,
        VPA
    }

    public enum d {
        PPB,
        UPI,
        WALLET,
        BANK,
        UPI_LEAD,
        KYC
    }

    public interface e<T> {
        void a(NetworkCustomError networkCustomError);

        void a(T t);
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        String f71415a;

        /* renamed from: b  reason: collision with root package name */
        String f71416b;

        /* renamed from: c  reason: collision with root package name */
        public String f71417c;

        /* renamed from: d  reason: collision with root package name */
        String f71418d;

        /* renamed from: e  reason: collision with root package name */
        public d f71419e;

        /* renamed from: f  reason: collision with root package name */
        String f71420f;

        /* renamed from: g  reason: collision with root package name */
        String f71421g;

        /* renamed from: h  reason: collision with root package name */
        public String f71422h;
    }

    private b(Activity activity) {
        this.w = activity;
        this.v = new net.one97.paytm.wallet.newdesign.universalp2p.a(activity);
        this.f71406i = new z(activity, R.style.ThemeDialogLoaderwhite);
        this.f71406i.setCancelable(false);
        this.f71406i.setCanceledOnTouchOutside(false);
        t();
    }

    public static b a(Activity activity) {
        if (u == null) {
            synchronized (b.class) {
                u = new b(activity);
            }
        }
        return u;
    }

    public static void a() {
        if (u != null) {
            synchronized (b.class) {
                u = null;
            }
        }
    }

    public static boolean a(Context context) {
        return !net.one97.paytm.wallet.communicator.b.a().isMinKycDone(context);
    }

    public final void a(AppCompatActivity appCompatActivity, String str, String str2, String str3, e eVar) {
        this.C = true;
        Double valueOf = Double.valueOf(0.0d);
        CJRCashWallet cJRCashWallet = this.f71402e;
        if (!(cJRCashWallet == null || cJRCashWallet.getResponse() == null)) {
            valueOf = Double.valueOf(this.f71402e.getResponse().getTotalBalance());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", appCompatActivity.getClass().getSimpleName());
        String b2 = this.v.b(a.C1448a.WALLET_LIMITS, new Object[0]);
        String c2 = this.v.c(a.C1448a.WALLET_LIMITS, str2, str, str3, valueOf);
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(b2, new WalletLimitsResDataModel(), hashMap, this.v.a(a.C1448a.WALLET_LIMITS, new Object[0]), c2);
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) appCompatActivity, "walletLimitApiTimeout")));
        bVar.c().observe(appCompatActivity, new androidx.lifecycle.z(eVar) {
            private final /* synthetic */ b.e f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                b.this.c(this.f$1, (f) obj);
            }
        });
    }

    public final boolean a(j jVar) {
        if (com.paytm.utility.b.c((Context) this.w)) {
            return true;
        }
        try {
            NoInternetAlertDialogFragment newInstance = NoInternetAlertDialogFragment.newInstance(true);
            newInstance.show(jVar.a(), "dialog");
            newInstance.setCancelable(false);
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.c.b$b  reason: collision with other inner class name */
    public class C1451b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71412a;

        /* renamed from: b  reason: collision with root package name */
        private e f71413b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f71414c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            if (!isCancelled()) {
                this.f71413b.a(Boolean.TRUE);
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            while (!isCancelled()) {
                if (!this.f71414c) {
                    b bVar = this.f71412a;
                    if (bVar.b() && bVar.f71399b) {
                        break;
                    }
                } else if (this.f71412a.b()) {
                    break;
                }
            }
            return Boolean.TRUE;
        }
    }

    public final boolean b() {
        return this.B && this.A && this.z;
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.c.b$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f71411a = new int[d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d[] r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f71411a = r0
                int[] r0 = f71411a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.PPB     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f71411a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.c.b.AnonymousClass3.<clinit>():void");
        }
    }

    public final UpiBaseDataModel a(c cVar) {
        for (UserVpaInfo next : this.D) {
            if (next.getVpa().equalsIgnoreCase(cVar.getPaymentInstrumentationMetaData())) {
                return next;
            }
        }
        return null;
    }

    public final Boolean a(WalletLimitsResDataModel walletLimitsResDataModel) {
        Boolean bool = Boolean.FALSE;
        if (walletLimitsResDataModel == null || walletLimitsResDataModel.getResponse() == null || !net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.w, "is_add_pay_allowed", false)) {
            return bool;
        }
        Iterator<WalletLimitsResDataModel.Response> it2 = walletLimitsResDataModel.getResponse().iterator();
        while (it2.hasNext()) {
            WalletLimitsResDataModel.Response next = it2.next();
            if ("SUCCESS".equalsIgnoreCase(walletLimitsResDataModel.getStatusCode()) && !next.getIsLimitApplicable().booleanValue() && next.getAddMoneyDestination().equalsIgnoreCase("MAIN")) {
                return Boolean.TRUE;
            }
            if ("P2P_TRANSFER".equalsIgnoreCase(next.getWalletOperationType()) && "AL_0006".equalsIgnoreCase(next.getLimitMessage().toString())) {
                return null;
            }
        }
        return bool;
    }

    public static boolean b(WalletLimitsResDataModel walletLimitsResDataModel) {
        if (!(walletLimitsResDataModel == null || walletLimitsResDataModel.getResponse() == null)) {
            Iterator<WalletLimitsResDataModel.Response> it2 = walletLimitsResDataModel.getResponse().iterator();
            while (it2.hasNext()) {
                WalletLimitsResDataModel.Response next = it2.next();
                if (next.getWalletOperationType() != null && next.getLimitMessage() != null && "P2P_TRANSFER".equalsIgnoreCase(next.getWalletOperationType()) && "AL_0007".equalsIgnoreCase(next.getLimitMessage().toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class c implements Serializable {
        private String accRefId;
        private String accountType;
        private String availBalance;
        private ArrayList<ConsolidatePaymentInstrumentationRes.BankAccountCredentials> credsAlolowed;
        private String identifier;
        private String ifscCode;
        private boolean isAddMoney = false;
        private boolean isDisabled;
        private String mpinSet;
        private String paymentInstrumentAccount;
        private String paymentInstrumentationMetaData;
        private Integer paymentInstrumentationMetaDataTextColor;
        private String paymentInstrumentationName;
        private d paymentInstrumentationType;
        private String vpaId;

        public final String getAvailBalance() {
            return this.availBalance;
        }

        public final void setAvailBalance(String str) {
            this.availBalance = str;
        }

        public final String getIfscCode() {
            return this.ifscCode;
        }

        public final void setIfscCode(String str) {
            this.ifscCode = str;
        }

        public final String getVpaId() {
            return this.vpaId;
        }

        public final void setVpaId(String str) {
            this.vpaId = str;
        }

        public final String getAccountType() {
            return this.accountType;
        }

        public final void setAccountType(String str) {
            this.accountType = str;
        }

        public final String getMpinSet() {
            return this.mpinSet;
        }

        public final void setMpinSet(String str) {
            this.mpinSet = str;
        }

        public final ArrayList<ConsolidatePaymentInstrumentationRes.BankAccountCredentials> getCredsAlolowed() {
            return this.credsAlolowed;
        }

        public final void setCredsAlolowed(ArrayList<ConsolidatePaymentInstrumentationRes.BankAccountCredentials> arrayList) {
            this.credsAlolowed = arrayList;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final void setIdentifier(String str) {
            this.identifier = str;
        }

        public final boolean isDisabled() {
            return this.isDisabled;
        }

        public final void setDisabled(boolean z) {
            this.isDisabled = z;
        }

        public final boolean isAddMoney() {
            return this.isAddMoney;
        }

        public final void setAddMoney(boolean z) {
            this.isAddMoney = z;
        }

        public final Integer getPaymentInstrumentationMetaDataTextColor() {
            return this.paymentInstrumentationMetaDataTextColor;
        }

        public final void setPaymentInstrumentationMetaDataTextColor(Integer num) {
            this.paymentInstrumentationMetaDataTextColor = num;
        }

        public final d getPaymentInstrumentationType() {
            return this.paymentInstrumentationType;
        }

        public final void setPaymentInstrumentationType(d dVar) {
            this.paymentInstrumentationType = dVar;
        }

        public final String getPaymentInstrumentationName() {
            return this.paymentInstrumentationName;
        }

        public final void setPaymentInstrumentationName(String str) {
            this.paymentInstrumentationName = str;
        }

        public final String getPaymentInstrumentationMetaData() {
            return this.paymentInstrumentationMetaData;
        }

        public final void setPaymentInstrumentationMetaData(String str) {
            this.paymentInstrumentationMetaData = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.paymentInstrumentationName.equals(((c) obj).paymentInstrumentationName);
        }

        public final int hashCode() {
            return this.paymentInstrumentationName.hashCode();
        }

        public final void setPaymentInstrumentAccount(String str) {
            this.paymentInstrumentAccount = str;
        }

        public final String getPaymentInstrumentAccount() {
            return this.paymentInstrumentAccount;
        }

        public final String getAccRefId() {
            return this.accRefId;
        }

        public final c setAccRefId(String str) {
            this.accRefId = str;
            return this;
        }
    }

    public final void a(e eVar, String str, String str2, JSONObject jSONObject) {
        if (com.paytm.utility.b.c((Context) this.w)) {
            String str3 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.w, "sd_merchant_refer") + "?channel=PAYTM_APP&entityType=INDIVIDUAL";
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", com.paytm.utility.a.q(this.w));
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                try {
                    jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, jSONObject);
                } catch (Exception e2) {
                    q.d(String.valueOf(e2));
                }
            }
            jSONObject2.put("appVersion", com.paytm.utility.c.b(this.w));
            jSONObject2.put("latitude", com.paytm.utility.b.s((Context) this.w));
            jSONObject2.put("longitude", com.paytm.utility.b.t((Context) this.w));
            jSONObject2.put("manufacturer", Build.MANUFACTURER);
            jSONObject2.put("osVersion", com.paytm.utility.c.a());
            jSONObject2.put("model", Build.MODEL);
            jSONObject2.put("merchantMobileNumber", str);
            jSONObject2.put("merchantName", str2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", this.w.getClass().getSimpleName());
            new net.one97.paytm.network.b(str3, new P2PreferShopResponse(), hashMap2, hashMap, jSONObject2.toString()).c().observeForever(new androidx.lifecycle.z() {
                public final void onChanged(Object obj) {
                    b.b(b.e.this, (f) obj);
                }
            });
        }
    }

    private void r() {
        this.t.clear();
        this.r.clear();
        f fVar = new f();
        fVar.f71417c = this.w.getString(R.string.uni_p2p_wallet);
        fVar.f71418d = this.w.getString(R.string.uni_p2p_rs_balance, new Object[]{j()});
        fVar.f71415a = "HIDE";
        Activity activity = this.w;
        int i2 = R.string.uni_p2p_money_will_be_sent_to;
        fVar.f71416b = activity.getString(i2, new Object[]{f() + "'s", "Paytm Wallet"});
        fVar.f71419e = d.WALLET;
        fVar.f71422h = d.WALLET.name();
        this.t.add(fVar);
        ArrayList arrayList = new ArrayList();
        ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList = new ConsolidatePaymentInstrumentationRes.PaymentOptionList();
        ConsolidatePaymentInstrumentationRes.SourcePayment sourcePayment = new ConsolidatePaymentInstrumentationRes.SourcePayment();
        sourcePayment.setPaymentType(d.WALLET.name());
        sourcePayment.setBalance(j());
        ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment = new ConsolidatePaymentInstrumentationRes.DestinationPayment();
        destinationPayment.setPaymentType(d.WALLET.name());
        destinationPayment.setDisplayName(this.n);
        destinationPayment.setPhoneNumber(this.o);
        paymentOptionList.setDestinationPayment(destinationPayment);
        paymentOptionList.setSourcePayment(sourcePayment);
        arrayList.add(paymentOptionList);
        this.H = arrayList;
        v();
    }

    public final f c() {
        for (f next : this.t) {
            if (next.f71419e.equals(d.WALLET)) {
                return next;
            }
        }
        return null;
    }

    public final f d() {
        for (f next : this.t) {
            if (next.f71419e.equals(d.UPI)) {
                return next;
            }
        }
        return null;
    }

    public final String e() {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getPaymentOptionList() == null) {
            return null;
        }
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.s.getPaymentOptionList()) {
            if (d.WALLET.name().equals(next.getSourcePayment().getPaymentType())) {
                return next.getDestinationPayment().getUserPicture();
            }
        }
        return null;
    }

    public final String f() {
        String str = this.n;
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (!(consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getPaymentOptionList() == null)) {
            for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.s.getPaymentOptionList()) {
                if (d.WALLET.name().equals(next.getSourcePayment().getPaymentType()) && TextUtils.isEmpty(str)) {
                    str = next.getDestinationPayment().getDisplayName();
                }
            }
        }
        return TextUtils.isEmpty(str) ? this.o : str;
    }

    public final String g() {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getPaymentOptionList() == null) {
            return null;
        }
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.s.getPaymentOptionList()) {
            if (d.WALLET.name().equals(next.getSourcePayment().getPaymentType())) {
                return next.getDestinationPayment().getDisplayName();
            }
        }
        return null;
    }

    public final String h() {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getPaymentOptionList() == null) {
            return null;
        }
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.s.getPaymentOptionList()) {
            if (d.UPI.name().equals(next.getSourcePayment().getPaymentType())) {
                return next.getDestinationPayment().getDisplayName();
            }
        }
        return null;
    }

    public final String i() {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getPaymentOptionList() == null) {
            return null;
        }
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.s.getPaymentOptionList()) {
            if (d.WALLET.name().equals(next.getSourcePayment().getPaymentType())) {
                return next.getDestinationPayment().getPhoneNumber();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r0 = r5.s;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String j() {
        /*
            r5 = this;
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r5.s
            r1 = 0
            if (r0 == 0) goto L_0x003e
            java.util.List r0 = r0.getPaymentOptionList()
            if (r0 == 0) goto L_0x003e
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r5.s
            java.util.List r0 = r0.getPaymentOptionList()
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x003e
            java.lang.Object r2 = r0.next()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$PaymentOptionList r2 = (net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r2
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r3 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET
            java.lang.String r3 = r3.name()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r4 = r2.getSourcePayment()
            java.lang.String r4 = r4.getPaymentType()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0015
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r1 = r2.getSourcePayment()
            java.lang.String r1 = r1.getBalance()
            goto L_0x0015
        L_0x003e:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x0068
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r5.s
            if (r0 == 0) goto L_0x0068
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$MerchantInfo r0 = r0.getMerchantInfo()
            if (r0 == 0) goto L_0x0068
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r5.s
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$MerchantInfo r0 = r0.getMerchantInfo()
            java.lang.String r0 = r0.getSenderTotalBalance()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0068
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r5.s
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$MerchantInfo r0 = r0.getMerchantInfo()
            java.lang.String r1 = r0.getSenderTotalBalance()
        L_0x0068:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.c.b.j():java.lang.String");
    }

    public final String k() {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (!(consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getPaymentOptionList() == null)) {
            for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.s.getPaymentOptionList()) {
                if (d.UPI.name().equals(next.getSourcePayment().getPaymentType())) {
                    return next.getSourcePayment().getVpaId();
                }
            }
        }
        return null;
    }

    private void s() {
        for (int i2 = 0; i2 < this.G.size(); i2++) {
            if (i2 < this.G.size() - 1) {
                this.F = this.G.get(i2).getMessage() + " & ";
            } else {
                this.F = this.G.get(i2).getMessage();
            }
        }
        if (this.G.size() > 0) {
            this.p = true;
        }
    }

    public final void a(AppCompatActivity appCompatActivity, final e eVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", appCompatActivity.getClass().getSimpleName());
        net.one97.paytm.network.a aVar = new net.one97.paytm.network.a(this.v.b(a.C1448a.CONSOLIDATE_PAYMENT_INST, new Object[0]), new ConsolidatePaymentInstrumentationRes(), hashMap, this.v.a(a.C1448a.CONSOLIDATE_PAYMENT_INST, str));
        aVar.e();
        aVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) appCompatActivity, "payment_combination_api_timeout")));
        aVar.c().observe(appCompatActivity, new androidx.lifecycle.z(appCompatActivity, eVar) {
            private final /* synthetic */ AppCompatActivity f$1;
            private final /* synthetic */ b.e f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onChanged(Object obj) {
                b.this.a(this.f$1, this.f$2, (f) obj);
            }
        });
        int integerFromGTM = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) this.w, "payment_combination_api_timeout") * 1000;
        if (integerFromGTM > 0) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    if (!b.this.f71405h) {
                        boolean unused = b.this.f71405h = false;
                        b.this.t();
                        boolean unused2 = b.this.q = true;
                        b.this.p = true;
                        eVar.a((NetworkCustomError) null);
                    }
                }
            }, (long) integerFromGTM);
        }
    }

    public final void a(e eVar, String str) {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes;
        b bVar = u;
        if (bVar != null && (consolidatePaymentInstrumentationRes = bVar.s) != null && consolidatePaymentInstrumentationRes.getMerchantId() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", this.w.getClass().getSimpleName());
            new HashMap().put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2.put("version", "v1");
                jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, "Time");
                jSONObject2.put("channelId", "WEB");
                jSONObject2.put("tokenType", SDKConstants.SSO);
                jSONObject2.put(StringSet.token, com.paytm.utility.a.q(this.w));
                jSONObject3.put("mid", u.s.getMerchantId());
                jSONObject3.put("orderId", "");
                jSONObject.put("head", jSONObject2);
                jSONObject.put("body", jSONObject3);
            } catch (JSONException e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
            new net.one97.paytm.network.b(this.v.b(a.C1448a.FETCH_MERCHANTINFO, new Object[0]) + u.s.getMerchantId(), new FetchMerchantUserInfoResponse(), hashMap, this.v.a(a.C1448a.CONSOLIDATE_PAYMENT_INST, str), (String) null).c().observeForever(new androidx.lifecycle.z(eVar) {
                private final /* synthetic */ b.e f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    b.this.a(this.f$1, (f) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        this.t.clear();
        this.r.clear();
        f fVar = new f();
        fVar.f71417c = this.w.getString(R.string.uni_p2p_wallet);
        fVar.f71418d = this.w.getString(R.string.uni_p2p_rs_balance, new Object[]{"---"});
        fVar.f71415a = "HIDE";
        Activity activity = this.w;
        int i2 = R.string.uni_p2p_money_will_be_sent_to;
        fVar.f71416b = activity.getString(i2, new Object[]{f() + "'s", "Paytm Wallet"});
        fVar.f71419e = d.WALLET;
        fVar.f71422h = d.WALLET.name();
        this.t.add(fVar);
        ArrayList arrayList = new ArrayList();
        ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList = new ConsolidatePaymentInstrumentationRes.PaymentOptionList();
        ConsolidatePaymentInstrumentationRes.SourcePayment sourcePayment = new ConsolidatePaymentInstrumentationRes.SourcePayment();
        sourcePayment.setPaymentType(d.WALLET.name());
        ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment = new ConsolidatePaymentInstrumentationRes.DestinationPayment();
        destinationPayment.setPaymentType(d.WALLET.name());
        destinationPayment.setDisplayName(this.n);
        destinationPayment.setPhoneNumber(this.o);
        paymentOptionList.setDestinationPayment(destinationPayment);
        paymentOptionList.setSourcePayment(sourcePayment);
        arrayList.add(paymentOptionList);
        this.H = arrayList;
        v();
    }

    private boolean u() {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getPaymentOptionList() == null) {
            return false;
        }
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.s.getPaymentOptionList()) {
            if ((next.getSourcePayment().getPaymentType().equals(d.BANK.name()) || next.getSourcePayment().getPaymentType().equals(d.UPI.name())) && next.getSourcePayment().getError() == null && next.getDestinationPayment().getError() == null) {
                return true;
            }
        }
        return false;
    }

    public final f b(c cVar) {
        f fVar = new f();
        for (f next : this.t) {
            if (next.f71422h.equals(cVar.getIdentifier())) {
                fVar = next;
            }
        }
        return fVar;
    }

    public final ConsolidatePaymentInstrumentationRes.PaymentOptionList a(f fVar) {
        if (fVar == null) {
            return null;
        }
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.H) {
            if ((next.getSourcePayment().getError() == null && next.getDestinationPayment().getError() == null && d.UPI.equals(fVar.f71419e) && fVar.f71422h.equals(next.getSourcePayment().getBankAccountNumber())) || (!d.UPI.equals(fVar.f71419e) && fVar.f71422h.equals(next.getSourcePayment().getPaymentType()))) {
                return next;
            }
        }
        return null;
    }

    private void v() {
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : this.H) {
            c cVar = new c();
            boolean z2 = true;
            if (d.WALLET.name().equals(next.getSourcePayment().getPaymentType()) && next.getDestinationPayment().getError() == null && next.getSourcePayment().getError() == null) {
                cVar.setPaymentInstrumentationType(d.WALLET);
                cVar.setPaymentInstrumentationName(this.w.getString(R.string.uni_p2p_your_paytm_wallet_account));
                if (next.getSourcePayment() == null || TextUtils.isEmpty(next.getSourcePayment().getBalance())) {
                    cVar.setPaymentInstrumentationMetaData((String) null);
                } else {
                    String balance = next.getSourcePayment().getBalance();
                    cVar.setPaymentInstrumentationMetaData(this.w.getString(R.string.uni_p2p_wallet_balance, new Object[]{balance}));
                }
                cVar.setIdentifier(next.getSourcePayment().getPaymentType());
                if (a((Context) this.w) || !m()) {
                    this.E = false;
                } else {
                    this.r.add(cVar);
                    this.E = true;
                }
            } else if (d.BANK.name().equals(next.getSourcePayment().getPaymentType()) && next.getDestinationPayment().getError() == null && next.getSourcePayment().getError() == null) {
                cVar.setPaymentInstrumentationType(d.PPB);
                if (next.getSourcePayment() == null || TextUtils.isEmpty(next.getSourcePayment().getBalance())) {
                    cVar.setPaymentInstrumentationMetaData((String) null);
                } else {
                    cVar.setPaymentInstrumentationMetaData(this.w.getString(R.string.uni_p2p_bank_balance, new Object[]{next.getSourcePayment().getBalance()}));
                }
                cVar.setPaymentInstrumentationName(this.w.getString(R.string.uni_p2p_bank));
                if (TextUtils.isEmpty(next.getSourcePayment().getBalance())) {
                    cVar.setPaymentInstrumentAccount(next.getSourcePayment().getBankAccountNumber());
                }
                cVar.setIdentifier(next.getSourcePayment().getPaymentType());
                cVar.setAccountType("Savings");
                cVar.setMpinSet(next.getSourcePayment().getMpinSet());
                cVar.setCredsAlolowed(next.getSourcePayment().getCredsAllowed());
                cVar.setVpaId(next.getSourcePayment().getVpaId());
                cVar.setIfscCode(next.getSourcePayment().getIfscCode());
                this.r.add(cVar);
            } else if (d.UPI.name().equals(next.getSourcePayment().getPaymentType())) {
                String vpaId = next.getSourcePayment().getVpaId();
                Iterator<c> it2 = this.r.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().getIdentifier().equals(vpaId)) {
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2 && next.getDestinationPayment().getError() == null && next.getSourcePayment().getError() == null) {
                    cVar.setPaymentInstrumentationType(d.UPI);
                    cVar.setPaymentInstrumentationMetaData(next.getSourcePayment().getVpaId());
                    cVar.setPaymentInstrumentationName(next.getSourcePayment().getBankName());
                    cVar.setPaymentInstrumentAccount(next.getSourcePayment().getBankAccountNumber());
                    cVar.setAccRefId(next.getSourcePayment().getAccRefId());
                    if (!TextUtils.isEmpty(next.getSourcePayment().getBankAccountNumber())) {
                        cVar.setIdentifier(next.getSourcePayment().getBankAccountNumber());
                    } else {
                        cVar.setIdentifier(next.getSourcePayment().getVpaId());
                    }
                    cVar.setAccountType(next.getSourcePayment().getAccountType());
                    cVar.setMpinSet(next.getSourcePayment().getMpinSet());
                    cVar.setCredsAlolowed(next.getSourcePayment().getCredsAllowed());
                    cVar.setVpaId(next.getSourcePayment().getVpaId());
                    cVar.setIfscCode(next.getSourcePayment().getIfscCode());
                    this.r.add(cVar);
                }
            }
        }
    }

    public final List<c> a(Object... objArr) {
        Boolean bool;
        int i2 = 0;
        Boolean bool2 = objArr[0];
        try {
            bool = objArr[1];
        } catch (Exception unused) {
            bool = null;
        }
        if (!bool2.booleanValue() || bool == null || !bool.booleanValue()) {
            return this.r;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.r);
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            } else if (d.WALLET.equals(((c) arrayList.get(i2)).getPaymentInstrumentationType())) {
                arrayList.remove(i2);
                break;
            } else {
                i2++;
            }
        }
        return arrayList;
    }

    public final int b(f fVar) {
        if (fVar == null) {
            return 0;
        }
        int i2 = 0;
        for (c identifier : this.r) {
            if (identifier.getIdentifier().equals(fVar.f71422h)) {
                return i2;
            }
            i2++;
        }
        return 0;
    }

    public final c c(f fVar) {
        for (c next : this.r) {
            if (next.getIdentifier().equals(fVar.f71422h)) {
                return next;
            }
        }
        return null;
    }

    private boolean a(ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList) {
        for (f next : this.t) {
            if (paymentOptionList.getSourcePayment().getVpaId() != null && paymentOptionList.getSourcePayment().getVpaId().equals(next.f71422h)) {
                return true;
            }
            if (paymentOptionList.getSourcePayment().getPaymentType() != null && paymentOptionList.getSourcePayment().getPaymentType().equals(next.f71422h)) {
                return true;
            }
            if (paymentOptionList.getSourcePayment().getBankAccountNumber() != null && paymentOptionList.getSourcePayment().getBankAccountNumber().equals(next.f71422h)) {
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        for (ConsolidatePaymentInstrumentationRes.PaymentOptionList sourcePayment : this.H) {
            if (sourcePayment.getSourcePayment().getPaymentType().equals(d.UPI_LEAD.name())) {
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (consolidatePaymentInstrumentationRes != null) {
            return consolidatePaymentInstrumentationRes.isReceiverKyced();
        }
        return true;
    }

    public final boolean n() {
        return this.t.size() <= 1;
    }

    public final String o() {
        StringBuilder sb = new StringBuilder();
        ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = this.s;
        if (consolidatePaymentInstrumentationRes == null || consolidatePaymentInstrumentationRes.getGlobalError() == null || this.s.getGlobalError().getErrorList() == null || this.s.getGlobalError().getErrorList().size() <= 0) {
            int i2 = 0;
            ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes2 = this.s;
            if (!(consolidatePaymentInstrumentationRes2 == null || consolidatePaymentInstrumentationRes2.getPaymentOptionList() == null || this.s.getPaymentOptionList().size() <= 0)) {
                Iterator<ConsolidatePaymentInstrumentationRes.PaymentOptionList> it2 = this.s.getPaymentOptionList().iterator();
                while (it2.hasNext() && i2 < 2) {
                    String b2 = b(it2.next());
                    if (!TextUtils.isEmpty(b2)) {
                        if (i2 > 1) {
                            sb.append(StringUtility.NEW_LINE);
                        }
                        sb.append(b2);
                        i2++;
                    }
                }
            }
        } else {
            for (ConsolidatePaymentInstrumentationRes.Error next : this.s.getGlobalError().getErrorList()) {
                if (next != null && !TextUtils.isEmpty(next.getMessage())) {
                    sb.append(next.getMessage());
                }
            }
        }
        return sb.toString();
    }

    private static String b(ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList) {
        if (paymentOptionList != null && paymentOptionList.getSourcePayment() != null && paymentOptionList.getSourcePayment().getError() != null && !TextUtils.isEmpty(paymentOptionList.getSourcePayment().getError().getMessage())) {
            return paymentOptionList.getSourcePayment().getError().getMessage();
        }
        if (paymentOptionList == null || paymentOptionList.getDestinationPayment() == null || paymentOptionList.getDestinationPayment().getError() == null || TextUtils.isEmpty(paymentOptionList.getDestinationPayment().getError().getMessage())) {
            return null;
        }
        return paymentOptionList.getDestinationPayment().getError().getMessage();
    }

    public final void p() {
        try {
            if (this.w != null && !this.w.isFinishing() && this.f71406i != null && !this.f71406i.isShowing()) {
                this.f71406i.show();
            }
        } catch (Exception unused) {
        }
    }

    public final void q() {
        try {
            if (this.w != null && !this.w.isFinishing() && this.f71406i != null && this.f71406i.isShowing()) {
                this.f71406i.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e eVar, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if (fVar.f55797b instanceof FetchMerchantUserInfoResponse) {
                FetchMerchantUserInfoResponse fetchMerchantUserInfoResponse = (FetchMerchantUserInfoResponse) fVar.f55797b;
                this.I = fetchMerchantUserInfoResponse;
                if (fetchMerchantUserInfoResponse == null || fetchMerchantUserInfoResponse.getBody() == null || fetchMerchantUserInfoResponse.getBody().getMerchantInfoResp() == null || TextUtils.isEmpty(fetchMerchantUserInfoResponse.getBody().getMerchantInfoResp().getMerDispname())) {
                    eVar.a((NetworkCustomError) null);
                }
                if (fetchMerchantUserInfoResponse.getBody().getMerchantInfoResp() != null) {
                    eVar.a(fetchMerchantUserInfoResponse.getBody().getMerchantInfoResp());
                    return;
                }
                return;
            }
            eVar.a((NetworkCustomError) null);
        } else if (fVar.f55796a == h.ERROR) {
            eVar.a(fVar.f55798c.f55801c);
        }
    }

    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r13v5, types: [int, boolean] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(androidx.appcompat.app.AppCompatActivity r19, net.one97.paytm.wallet.newdesign.universalp2p.c.b.e r20, net.one97.paytm.network.f r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            net.one97.paytm.network.h r4 = r3.f55796a
            net.one97.paytm.network.h r5 = net.one97.paytm.network.h.SUCCESS
            r6 = 1
            if (r4 != r5) goto L_0x04b4
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r4 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$e r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.e.WALLET_PAY
            r4.j = r5
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$b r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.b.WAlLET_SEND_MONEY
            r4.k = r5
            r0.f71405h = r6
            com.paytm.network.model.IJRPaytmDataModel r5 = r3.f55797b
            boolean r5 = r5 instanceof net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes
            if (r5 == 0) goto L_0x04a4
            com.paytm.network.model.IJRPaytmDataModel r3 = r3.f55797b
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r3 = (net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes) r3
            net.one97.paytm.wallet.communicator.c r5 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r7 = r0.w
            int r5 = r5.getKYCUserStatus(r7)
            r7 = 0
            if (r5 != 0) goto L_0x0042
            net.one97.paytm.wallet.communicator.c r5 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r8 = r0.w
            boolean r5 = r5.getIsMinKyc(r8)
            if (r5 == 0) goto L_0x0042
            r5 = 1
            goto L_0x0043
        L_0x0042:
            r5 = 0
        L_0x0043:
            if (r5 == 0) goto L_0x0093
            if (r3 == 0) goto L_0x0093
            java.util.List r5 = r3.getPaymentOptionList()
            if (r5 == 0) goto L_0x0093
            java.util.List r5 = r3.getPaymentOptionList()
            java.util.Iterator r5 = r5.iterator()
        L_0x0055:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0093
            java.lang.Object r8 = r5.next()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$PaymentOptionList r8 = (net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r8
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r8 = r8.getSourcePayment()
            if (r8 == 0) goto L_0x0055
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r9 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET
            java.lang.String r9 = r9.name()
            java.lang.String r10 = r8.getPaymentType()
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x0055
            java.lang.String r8 = r8.getBalance()
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x0055
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            double r8 = r8.doubleValue()
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x0055
            r5.remove()
            goto L_0x0055
        L_0x0093:
            r0.s = r3
            java.lang.String r5 = r3.getMerchantId()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0496
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$a r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.C1450a.PAY_TYPE_P2P
            r4.l = r5
            java.util.List<net.one97.paytm.wallet.newdesign.universalp2p.c.b$f> r5 = r0.t
            r5.clear()
            java.util.List<net.one97.paytm.wallet.newdesign.universalp2p.c.b$c> r5 = r0.r
            r5.clear()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r5 = r0.s
            if (r5 == 0) goto L_0x0475
            java.util.List r5 = r5.getPaymentOptionList()
            if (r5 == 0) goto L_0x0475
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r5 = r0.s
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$GlobalError r5 = r5.getGlobalError()
            java.util.List r5 = r5.getErrorList()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00d6
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r8 = r0.s
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$GlobalError r8 = r8.getGlobalError()
            java.util.List r8 = r8.getErrorList()
            r5.addAll(r8)
        L_0x00d6:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r5 = r0.s
            java.util.List r5 = r5.getPaymentOptionList()
            java.util.Iterator r5 = r5.iterator()
        L_0x00e0:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0475
            java.lang.Object r8 = r5.next()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$PaymentOptionList r8 = (net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r8
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$f r9 = new net.one97.paytm.wallet.newdesign.universalp2p.c.b$f
            r9.<init>()
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r10 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.UPI
            java.lang.String r10 = r10.name()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r11 = r8.getSourcePayment()
            java.lang.String r11 = r11.getPaymentType()
            boolean r10 = r10.equals(r11)
            java.lang.String r11 = "Bank Account"
            java.lang.String r12 = "'s"
            java.lang.String r14 = "Paytm Wallet"
            if (r10 == 0) goto L_0x021a
            boolean r10 = r0.a((net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r8)
            if (r10 != 0) goto L_0x021a
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r10 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r10 = r10.getError()
            if (r10 != 0) goto L_0x01c6
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r10 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r10 = r10.getError()
            if (r10 != 0) goto L_0x01c6
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r10 = r8.getSourcePayment()
            java.lang.String r10 = r10.getBankName()
            r9.f71417c = r10
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r10 = r8.getSourcePayment()
            java.lang.String r10 = r10.getVpaId()
            r9.f71418d = r10
            android.app.Activity r10 = r0.w
            int r15 = net.one97.paytm.wallet.R.string.uni_p2p_or_send_money_to
            java.lang.Object[] r13 = new java.lang.Object[r6]
            r13[r7] = r14
            java.lang.String r10 = r10.getString(r15, r13)
            r9.f71415a = r10
            android.app.Activity r10 = r0.w
            int r13 = net.one97.paytm.wallet.R.string.uni_p2p_money_will_be_sent_to
            r14 = 2
            java.lang.Object[] r14 = new java.lang.Object[r14]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = r18.f()
            r15.append(r6)
            r15.append(r12)
            java.lang.String r6 = r15.toString()
            r14[r7] = r6
            r6 = 1
            r14[r6] = r11
            java.lang.String r6 = r10.getString(r13, r14)
            r9.f71416b = r6
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r6 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.UPI
            r9.f71419e = r6
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getBankAccountNumber()
            r9.f71420f = r6
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getAccRefId()
            r9.f71421g = r6
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getBankAccountNumber()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x019d
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getBankAccountNumber()
            r9.f71422h = r6
            goto L_0x01a7
        L_0x019d:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getVpaId()
            r9.f71422h = r6
        L_0x01a7:
            android.app.Activity r6 = r0.w
            int r10 = net.one97.paytm.wallet.R.string.paytm_payment_bank
            java.lang.String r6 = r6.getString(r10)
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r8 = r8.getSourcePayment()
            java.lang.String r8 = r8.getBankName()
            boolean r6 = r6.equalsIgnoreCase(r8)
            if (r6 == 0) goto L_0x01bf
            r0.j = r9
        L_0x01bf:
            java.util.List<net.one97.paytm.wallet.newdesign.universalp2p.c.b$f> r6 = r0.t
            r6.add(r9)
            goto L_0x0472
        L_0x01c6:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            if (r6 == 0) goto L_0x01ed
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r6 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r9 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r9 = r9.getError()
            boolean r6 = r6.contains(r9)
            if (r6 != 0) goto L_0x01ed
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r6 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r9 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r9 = r9.getError()
            r6.add(r9)
        L_0x01ed:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r6 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            if (r6 == 0) goto L_0x0216
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r6 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r9 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r9 = r9.getError()
            boolean r6 = r6.contains(r9)
            if (r6 != 0) goto L_0x0216
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r6 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r8 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r8 = r8.getError()
            r6.add(r8)
            goto L_0x0472
        L_0x0216:
            r17 = r5
            goto L_0x0470
        L_0x021a:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r6 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET
            java.lang.String r6 = r6.name()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r10 = r8.getSourcePayment()
            java.lang.String r10 = r10.getPaymentType()
            boolean r6 = r6.equals(r10)
            java.lang.String r10 = "---"
            if (r6 == 0) goto L_0x0338
            boolean r6 = r0.a((net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r8)
            if (r6 != 0) goto L_0x0338
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            if (r6 != 0) goto L_0x02e6
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r6 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            if (r6 != 0) goto L_0x02e6
            android.app.Activity r6 = r0.w
            int r13 = net.one97.paytm.wallet.R.string.uni_p2p_wallet
            java.lang.String r6 = r6.getString(r13)
            r9.f71417c = r6
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getBalance()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0280
            android.app.Activity r6 = r0.w
            int r10 = net.one97.paytm.wallet.R.string.uni_p2p_rs_balance
            r13 = 1
            java.lang.Object[] r15 = new java.lang.Object[r13]
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r16 = r8.getSourcePayment()
            java.lang.String r16 = r16.getBalance()
            java.lang.String r16 = com.paytm.utility.b.T((java.lang.String) r16)
            r15[r7] = r16
            java.lang.String r6 = r6.getString(r10, r15)
            r9.f71418d = r6
            r17 = r5
            goto L_0x0291
        L_0x0280:
            r13 = 1
            android.app.Activity r6 = r0.w
            int r15 = net.one97.paytm.wallet.R.string.uni_p2p_rs_balance
            r17 = r5
            java.lang.Object[] r5 = new java.lang.Object[r13]
            r5[r7] = r10
            java.lang.String r5 = r6.getString(r15, r5)
            r9.f71418d = r5
        L_0x0291:
            boolean r5 = r18.u()
            if (r5 == 0) goto L_0x02a6
            android.app.Activity r5 = r0.w
            int r6 = net.one97.paytm.wallet.R.string.uni_p2p_or_send_money_to
            java.lang.Object[] r10 = new java.lang.Object[r13]
            r10[r7] = r11
            java.lang.String r5 = r5.getString(r6, r10)
            r9.f71415a = r5
            goto L_0x02ac
        L_0x02a6:
            r0.p = r13
            java.lang.String r5 = "HIDE"
            r9.f71415a = r5
        L_0x02ac:
            android.app.Activity r5 = r0.w
            int r6 = net.one97.paytm.wallet.R.string.uni_p2p_money_will_be_sent_to
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = r18.f()
            r11.append(r13)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10[r7] = r11
            r11 = 1
            r10[r11] = r14
            java.lang.String r5 = r5.getString(r6, r10)
            r9.f71416b = r5
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET
            r9.f71419e = r5
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            java.lang.String r5 = r5.getPaymentType()
            r9.f71422h = r5
            java.util.List<net.one97.paytm.wallet.newdesign.universalp2p.c.b$f> r5 = r0.t
            r5.add(r9)
            goto L_0x0470
        L_0x02e6:
            r17 = r5
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r5 = r5.getError()
            if (r5 == 0) goto L_0x030f
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x030f
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            r5.add(r6)
        L_0x030f:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r5 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r5 = r5.getError()
            if (r5 == 0) goto L_0x0470
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r6 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x0470
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r6 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            r5.add(r6)
            goto L_0x0470
        L_0x0338:
            r17 = r5
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.BANK
            java.lang.String r5 = r5.name()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getPaymentType()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0459
            boolean r5 = r0.a((net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r8)
            if (r5 != 0) goto L_0x0459
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r5 = r5.getError()
            if (r5 != 0) goto L_0x040a
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r5 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r5 = r5.getError()
            if (r5 != 0) goto L_0x040a
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            java.lang.String r5 = r5.getBankName()
            r9.f71417c = r5
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            java.lang.String r5 = r5.getBankName()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x038a
            android.app.Activity r5 = r0.w
            int r6 = net.one97.paytm.wallet.R.string.uni_p2p_bank_name
            java.lang.String r5 = r5.getString(r6)
            r9.f71417c = r5
        L_0x038a:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            java.lang.String r5 = r5.getBalance()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x03b4
            android.app.Activity r5 = r0.w
            int r6 = net.one97.paytm.wallet.R.string.uni_p2p_rs_balance
            r13 = 1
            java.lang.Object[] r10 = new java.lang.Object[r13]
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r15 = r8.getSourcePayment()
            java.lang.String r15 = r15.getBalance()
            java.lang.String r15 = com.paytm.utility.b.T((java.lang.String) r15)
            r10[r7] = r15
            java.lang.String r5 = r5.getString(r6, r10)
            r9.f71418d = r5
            goto L_0x03c3
        L_0x03b4:
            r13 = 1
            android.app.Activity r5 = r0.w
            int r6 = net.one97.paytm.wallet.R.string.uni_p2p_rs_balance
            java.lang.Object[] r15 = new java.lang.Object[r13]
            r15[r7] = r10
            java.lang.String r5 = r5.getString(r6, r15)
            r9.f71418d = r5
        L_0x03c3:
            android.app.Activity r5 = r0.w
            int r6 = net.one97.paytm.wallet.R.string.uni_p2p_or_send_money_to
            java.lang.Object[] r10 = new java.lang.Object[r13]
            r10[r7] = r14
            java.lang.String r5 = r5.getString(r6, r10)
            r9.f71415a = r5
            android.app.Activity r5 = r0.w
            int r6 = net.one97.paytm.wallet.R.string.uni_p2p_money_will_be_sent_to
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r18.f()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r10[r7] = r12
            r12 = 1
            r10[r12] = r11
            java.lang.String r5 = r5.getString(r6, r10)
            r9.f71416b = r5
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.BANK
            r9.f71419e = r5
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            java.lang.String r5 = r5.getPaymentType()
            r9.f71422h = r5
            java.util.List<net.one97.paytm.wallet.newdesign.universalp2p.c.b$f> r5 = r0.t
            r5.add(r9)
            goto L_0x0470
        L_0x040a:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r5 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r5 = r5.getError()
            if (r5 == 0) goto L_0x0431
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x0431
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            r5.add(r6)
        L_0x0431:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r5 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r5 = r5.getError()
            if (r5 == 0) goto L_0x0470
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r6 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x0470
            java.util.List<net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error> r5 = r0.G
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r6 = r8.getDestinationPayment()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r6 = r6.getError()
            r5.add(r6)
            goto L_0x0470
        L_0x0459:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.UPI_LEAD
            java.lang.String r5 = r5.name()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r6 = r8.getSourcePayment()
            java.lang.String r6 = r6.getPaymentType()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0470
            r0.a((net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r8)
        L_0x0470:
            r5 = r17
        L_0x0472:
            r6 = 1
            goto L_0x00e0
        L_0x0475:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r5 = r0.s
            java.util.List r5 = r5.getPaymentOptionList()
            r0.H = r5
            r18.v()
            net.one97.paytm.wallet.communicator.c r5 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r6 = r0.w
            android.content.Context r6 = r6.getApplicationContext()
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$2 r7 = new net.one97.paytm.wallet.newdesign.universalp2p.c.b$2
            r7.<init>()
            r5.getUserVpaInfo(r6, r7)
            r18.s()
            goto L_0x049d
        L_0x0496:
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$a r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.C1450a.PAY_TYPE_P2M
            r4.l = r5
            r18.r()
        L_0x049d:
            r4.b((android.content.Context) r1)
            r2.a(r3)
            return
        L_0x04a4:
            r4.b((android.content.Context) r1)
            r18.t()
            r1 = 1
            r0.q = r1
            r0.p = r1
            r1 = 0
            r2.a((com.paytm.network.model.NetworkCustomError) r1)
            return
        L_0x04b4:
            net.one97.paytm.network.h r4 = r3.f55796a
            net.one97.paytm.network.h r5 = net.one97.paytm.network.h.ERROR
            if (r4 != r5) goto L_0x04de
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r4 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$e r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.e.WALLET_PAY
            r4.j = r5
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$b r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.b.WAlLET_SEND_MONEY
            r4.k = r5
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$a r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.C1450a.PAY_TYPE_P2P
            r4.l = r5
            r4.b((android.content.Context) r1)
            r1 = 1
            r0.f71405h = r1
            r18.t()
            r0.q = r1
            r0.p = r1
            net.one97.paytm.network.g r1 = r3.f55798c
            com.paytm.network.model.NetworkCustomError r1 = r1.f55801c
            r2.a((com.paytm.network.model.NetworkCustomError) r1)
        L_0x04de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.c.b.a(androidx.appcompat.app.AppCompatActivity, net.one97.paytm.wallet.newdesign.universalp2p.c.b$e, net.one97.paytm.network.f):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(e eVar, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            eVar.a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            eVar.a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(e eVar, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if (fVar.f55797b instanceof WalletLimitsResDataModel) {
                this.f71404g = (WalletLimitsResDataModel) fVar.f55797b;
                this.C = false;
                if (eVar != null) {
                    eVar.a(this.f71404g);
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            this.C = false;
            if (eVar != null) {
                eVar.a(fVar.f55798c.f55801c);
            }
        }
    }
}
