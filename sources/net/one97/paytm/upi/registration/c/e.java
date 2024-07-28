package net.one97.paytm.upi.registration.c;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.SmartTransferReponse;
import net.one97.paytm.upi.common.models.UPIDeregister;
import net.one97.paytm.upi.common.models.UPIProfileMultipartResponse;
import net.one97.paytm.upi.common.models.UserPreference;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.j;
import net.one97.paytm.upi.l;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class e extends ai {

    /* renamed from: a  reason: collision with root package name */
    public boolean f68570a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68571b;

    /* renamed from: c  reason: collision with root package name */
    public BankAccountDetails.BankAccount f68572c;

    /* renamed from: d  reason: collision with root package name */
    public BankAccountDetails.BankAccount f68573d;

    /* renamed from: e  reason: collision with root package name */
    public UpiProfileDefaultBank f68574e;

    /* renamed from: f  reason: collision with root package name */
    public final String f68575f = "UpiSettingPage";

    /* renamed from: g  reason: collision with root package name */
    public final String f68576g = UpiConstants.UPI_SETTINGS_SMART_TRANSFER_PREFERENCE;

    /* renamed from: h  reason: collision with root package name */
    public String f68577h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f68578i = "";
    public UpiProfileModel j;
    public List<? extends BankAccountDetails.BankAccount> k;
    public final y<net.one97.paytm.upi.j<UPIDeregister>> l = new y<>();
    public final y<net.one97.paytm.upi.j<UpiProfileModel>> m = new y<>();
    public final y<net.one97.paytm.upi.j<o<String, Integer>>> n = new y<>();
    public final y<net.one97.paytm.upi.j<String>> o = new y<>();
    public final y<o<UPIProfileMultipartResponse, NetworkCustomError>> p = new y<>();
    public final y<net.one97.paytm.upi.j<o<BankAccountDetails.BankAccount, o<Integer, Integer>>>> q = new y<>();
    public final y<net.one97.paytm.upi.j<o<SmartTransferReponse, UpiCustomVolleyError>>> r = new y<>();
    public int s = -1;
    public boolean t;
    public final net.one97.paytm.upi.profile.b.b u;
    private long v;
    /* access modifiers changed from: private */
    public final y<net.one97.paytm.upi.j<o<UserPreference, UpiCustomVolleyError>>> w = new y<>();
    private String x = "";
    private final Set<String> y;
    /* access modifiers changed from: private */
    public final Context z;

    public static final class b implements a.C1389a {
        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        }
    }

    public static final /* synthetic */ BankAccountDetails.BankAccount d(e eVar) {
        BankAccountDetails.BankAccount bankAccount = eVar.f68573d;
        if (bankAccount == null) {
            k.a("selectedBank");
        }
        return bankAccount;
    }

    public e(net.one97.paytm.upi.profile.b.b bVar, Context context) {
        k.c(bVar, "upiProfileRepository");
        k.c(context, "context");
        this.u = bVar;
        this.z = context;
        String[] strArr = {"PAYTM_BASIC_PLUS", "PAYTM_PRIME_WALLET", "PAYTM_ADHAAR_OTP_KYC", "PAYTM_MIN_KYC", "PAYTM_PRIME_RESTRICTED"};
        k.d(strArr, "elements");
        this.y = (HashSet) kotlin.a.f.a((T[]) strArr, new HashSet(ae.a(5)));
    }

    public final UpiProfileDefaultBank a() {
        UpiProfileDefaultBank upiProfileDefaultBank = this.f68574e;
        if (upiProfileDefaultBank == null) {
            k.a("primaryBank");
        }
        return upiProfileDefaultBank;
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        k.c(upiProfileDefaultBank, "<set-?>");
        this.f68574e = upiProfileDefaultBank;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f68577h = str;
    }

    public final UpiProfileModel b() {
        UpiProfileModel upiProfileModel = this.j;
        if (upiProfileModel == null) {
            k.a("upiProfileModel");
        }
        return upiProfileModel;
    }

    public final List<BankAccountDetails.BankAccount> c() {
        List<? extends BankAccountDetails.BankAccount> list = this.k;
        if (list == null) {
            k.a("bankAccountList");
        }
        return list;
    }

    public final void d() {
        y<net.one97.paytm.upi.j<UPIDeregister>> yVar = this.l;
        j.a aVar = net.one97.paytm.upi.j.f67003d;
        yVar.setValue(j.a.a());
        this.u.b((a.C1382a) new d(this), this.f68575f, this.f68578i);
    }

    public static final class d implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68584a;

        d(e eVar) {
            this.f68584a = eVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    upiCustomVolleyError.setAlertMessage(baseUpiResponse.getMessage());
                    upiCustomVolleyError.setmErrorCode(baseUpiResponse.getResponse());
                    y a2 = this.f68584a.l;
                    j.a aVar = net.one97.paytm.upi.j.f67003d;
                    a2.setValue(j.a.a(upiCustomVolleyError));
                    return;
                }
                e eVar = this.f68584a;
                eVar.t = true;
                y a3 = eVar.l;
                j.a aVar2 = net.one97.paytm.upi.j.f67003d;
                a3.setValue(j.a.a((Object) new UPIDeregister("0", (String) null, (String) null)));
                return;
            }
            y a4 = this.f68584a.l;
            j.a aVar3 = net.one97.paytm.upi.j.f67003d;
            a4.setValue(j.a.a((UpiCustomVolleyError) null));
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            upiCustomVolleyError.setAlertMessage("");
            y a2 = this.f68584a.l;
            j.a aVar = net.one97.paytm.upi.j.f67003d;
            a2.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    public final boolean e() {
        PaytmUpiPrefUtil.Companion companion = PaytmUpiPrefUtil.Companion;
        Context applicationContext = this.z.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return companion.getPref(applicationContext).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    /* renamed from: net.one97.paytm.upi.registration.c.e$e  reason: collision with other inner class name */
    public static final class C1394e implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68585a;

        C1394e(e eVar) {
            this.f68585a = eVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                boolean z = true;
                if (p.a(upiProfileModel.getStatus(), "SUCCESS", true) && p.a("0", upiProfileModel.getRespCode(), true) && upiProfileModel.getResponse() != null) {
                    UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                    k.a((Object) response, "profileModel.response");
                    if (response.getProfileDetail() != null) {
                        e eVar = this.f68585a;
                        k.c(upiProfileModel, "<set-?>");
                        eVar.j = upiProfileModel;
                        UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                        k.a((Object) response2, "profileModel.response");
                        UpiProfileModel.ProfileDetails profileDetail = response2.getProfileDetail();
                        k.a((Object) profileDetail, "profileModel.response.profileDetail");
                        Iterator<UpiProfileDefaultBank> it2 = profileDetail.getProfileVpaList().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            UpiProfileDefaultBank next = it2.next();
                            k.a((Object) next, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
                            if (next.isPrimary()) {
                                e eVar2 = this.f68585a;
                                String virtualAddress = next.getVirtualAddress();
                                k.a((Object) virtualAddress, "bank.virtualAddress");
                                eVar2.a(virtualAddress);
                                this.f68585a.a(next);
                                break;
                            }
                        }
                        if (this.f68585a.f68574e == null) {
                            z = false;
                        }
                        if (!z) {
                            UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                            k.a((Object) response3, "profileModel.response");
                            UpiProfileModel.ProfileDetails profileDetail2 = response3.getProfileDetail();
                            k.a((Object) profileDetail2, "profileModel.response.profileDetail");
                            if (profileDetail2.getProfileVpaList().size() > 0) {
                                e eVar3 = this.f68585a;
                                UpiProfileModel.AccountDetails response4 = upiProfileModel.getResponse();
                                k.a((Object) response4, "profileModel.response");
                                UpiProfileModel.ProfileDetails profileDetail3 = response4.getProfileDetail();
                                k.a((Object) profileDetail3, "profileModel.response.profileDetail");
                                UpiProfileDefaultBank upiProfileDefaultBank = profileDetail3.getProfileVpaList().get(0);
                                k.a((Object) upiProfileDefaultBank, "profileModel.response.pr…eDetail.profileVpaList[0]");
                                eVar3.a(upiProfileDefaultBank);
                                e eVar4 = this.f68585a;
                                String virtualAddress2 = eVar4.a().getVirtualAddress();
                                k.a((Object) virtualAddress2, "primaryBank.virtualAddress");
                                eVar4.a(virtualAddress2);
                            }
                        }
                        if (this.f68585a.f68574e != null) {
                            UpiProfileModel.AccountDetails response5 = upiProfileModel.getResponse();
                            k.a((Object) response5, "profileModel.response");
                            UpiProfileModel.ProfileDetails profileDetail4 = response5.getProfileDetail();
                            k.a((Object) profileDetail4, "profileModel.response.profileDetail");
                            Iterator<BankAccountDetails.BankAccount> it3 = profileDetail4.getBankAccountList().iterator();
                            while (it3.hasNext()) {
                                BankAccountDetails.BankAccount next2 = it3.next();
                                k.a((Object) next2, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
                                BankAccountDetails.BankAccount debitBank = this.f68585a.a().getDebitBank();
                                k.a((Object) debitBank, "primaryBank.debitBank");
                                next2.setSelected(k.a((Object) debitBank.getAccRefId(), (Object) next2.getAccRefId()));
                            }
                        }
                        e eVar5 = this.f68585a;
                        UpiProfileModel.AccountDetails response6 = upiProfileModel.getResponse();
                        k.a((Object) response6, "profileModel.response");
                        UpiProfileModel.ProfileDetails profileDetail5 = response6.getProfileDetail();
                        k.a((Object) profileDetail5, "profileModel.response.profileDetail");
                        ArrayList<BankAccountDetails.BankAccount> bankAccountList = profileDetail5.getBankAccountList();
                        k.a((Object) bankAccountList, "profileModel.response.pr…ileDetail.bankAccountList");
                        List<? extends BankAccountDetails.BankAccount> list = bankAccountList;
                        k.c(list, "<set-?>");
                        eVar5.k = list;
                        y b2 = this.f68585a.m;
                        j.a aVar = net.one97.paytm.upi.j.f67003d;
                        b2.setValue(j.a.a((Object) this.f68585a.b()));
                        return;
                    }
                }
                y b3 = this.f68585a.m;
                j.a aVar2 = net.one97.paytm.upi.j.f67003d;
                b3.setValue(j.a.a((UpiCustomVolleyError) null));
                return;
            }
            y b4 = this.f68585a.m;
            j.a aVar3 = net.one97.paytm.upi.j.f67003d;
            b4.setValue(j.a.a((UpiCustomVolleyError) null));
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y b2 = this.f68585a.m;
            j.a aVar = net.one97.paytm.upi.j.f67003d;
            b2.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    public final void f() {
        y<net.one97.paytm.upi.j<UpiProfileModel>> yVar = this.m;
        j.a aVar = net.one97.paytm.upi.j.f67003d;
        yVar.setValue(j.a.a());
        this.u.a((a.C1382a) new C1394e(this), this.f68575f, this.f68578i);
    }

    public static final class c implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68582a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f68583b;

        public c(e eVar, int i2) {
            this.f68582a = eVar;
            this.f68583b = i2;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    upiCustomVolleyError.setmErrorCode(baseUpiResponse.getResponse());
                    this.f68582a.n.setValue(new net.one97.paytm.upi.j(l.ERROR, new o(null, Integer.valueOf(this.f68583b)), upiCustomVolleyError, 8));
                    return;
                }
                y c2 = this.f68582a.n;
                j.a aVar = net.one97.paytm.upi.j.f67003d;
                c2.setValue(j.a.a((Object) new o(null, Integer.valueOf(this.f68583b))));
                return;
            }
            this.f68582a.n.setValue(new net.one97.paytm.upi.j(l.ERROR, new o(null, Integer.valueOf(this.f68583b)), (UpiCustomVolleyError) null, 8));
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            this.f68582a.n.setValue(new net.one97.paytm.upi.j(l.ERROR, new o(null, Integer.valueOf(this.f68583b)), upiCustomVolleyError, 8));
        }
    }

    public static final class a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68579a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f68580b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f68581c = 0;

        /* JADX WARNING: type inference failed for: r1v0, types: [int, net.one97.paytm.upi.registration.c.e] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(int r1, int r2) {
            /*
                r0 = this;
                r0.f68579a = r1
                r0.f68580b = r2
                r1 = 0
                r0.f68581c = r1
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.registration.c.e.a.<init>(net.one97.paytm.upi.registration.c.e, int):void");
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    upiCustomVolleyError.setAlertMessage(baseUpiResponse.getMessage());
                    y e2 = this.f68579a.q;
                    j.a aVar = net.one97.paytm.upi.j.f67003d;
                    e2.setValue(j.a.a(upiCustomVolleyError));
                    return;
                }
                e.d(this.f68579a).setSelected(true);
                y e3 = this.f68579a.q;
                j.a aVar2 = net.one97.paytm.upi.j.f67003d;
                e3.setValue(j.a.a((Object) new o(e.d(this.f68579a), new o(Integer.valueOf(this.f68580b), Integer.valueOf(this.f68581c)))));
                return;
            }
            y e4 = this.f68579a.q;
            j.a aVar3 = net.one97.paytm.upi.j.f67003d;
            e4.setValue(j.a.a((UpiCustomVolleyError) null));
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            y e2 = this.f68579a.q;
            j.a aVar = net.one97.paytm.upi.j.f67003d;
            e2.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    public final UserUpiDetails g() {
        ArrayList arrayList = new ArrayList();
        BankAccountDetails.BankAccount bankAccount = this.f68573d;
        if (bankAccount == null) {
            k.a("selectedBank");
        }
        arrayList.add(bankAccount);
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, this.f68577h).setBankAccountList(arrayList).build();
        k.a((Object) build, "userUpiDetails");
        return build;
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        this.f68573d = bankAccount;
    }

    public static final class j implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68589a;

        public j(e eVar) {
            this.f68589a = eVar;
        }

        public final void a(UPIProfileMultipartResponse uPIProfileMultipartResponse) {
            this.f68589a.p.setValue(new o(uPIProfileMultipartResponse, null));
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f68589a.p.setValue(new o(null, networkCustomError));
        }
    }

    public static Object b(String str) {
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            if (uRLConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            throw new u("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (IOException | Exception unused) {
            return null;
        }
    }

    public static final class i implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68588a;

        public i(e eVar) {
            this.f68588a = eVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof UserPreference)) {
                y h2 = this.f68588a.w;
                j.a aVar = net.one97.paytm.upi.j.f67003d;
                h2.setValue(j.a.a((UpiCustomVolleyError) null));
                return;
            }
            y h3 = this.f68588a.w;
            j.a aVar2 = net.one97.paytm.upi.j.f67003d;
            h3.setValue(j.a.a((Object) new o(iJRPaytmDataModel, null)));
            this.f68588a.u.c();
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y h2 = this.f68588a.w;
            j.a aVar = net.one97.paytm.upi.j.f67003d;
            h2.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    public static final class f implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68586a;

        f(e eVar) {
            this.f68586a = eVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof UserPreference)) {
                y h2 = this.f68586a.w;
                j.a aVar = net.one97.paytm.upi.j.f67003d;
                h2.setValue(j.a.a((UpiCustomVolleyError) null));
                return;
            }
            y h3 = this.f68586a.w;
            j.a aVar2 = net.one97.paytm.upi.j.f67003d;
            h3.setValue(j.a.a((Object) new o(iJRPaytmDataModel, null)));
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y h2 = this.f68586a.w;
            j.a aVar = net.one97.paytm.upi.j.f67003d;
            h2.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    public final y<net.one97.paytm.upi.j<o<UserPreference, UpiCustomVolleyError>>> c(String str) {
        k.c(str, "prefereneKey");
        this.u.a((a.c) new f(this), str);
        return this.w;
    }

    public static final class h implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68587a;

        h(e eVar) {
            this.f68587a = eVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof SmartTransferReponse) {
                y j = this.f68587a.r;
                j.a aVar = net.one97.paytm.upi.j.f67003d;
                j.setValue(j.a.a((Object) new o(iJRPaytmDataModel, null)));
                this.f68587a.u.c();
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y j = this.f68587a.r;
            j.a aVar = net.one97.paytm.upi.j.f67003d;
            j.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "prefereneKey");
        k.c(str2, "value");
        this.u.b((a.c) new h(this), str, str2);
    }

    public final boolean h() {
        if (SystemClock.elapsedRealtime() - this.v < 750) {
            return true;
        }
        this.v = SystemClock.elapsedRealtime();
        return false;
    }

    public final boolean i() {
        PaytmUpiPrefUtil.Companion companion = PaytmUpiPrefUtil.Companion;
        Context applicationContext = this.z.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        String b2 = companion.getPref(applicationContext).b("kyc_state", "", true);
        if (b2 == null) {
            b2 = "";
        }
        if (!a(this.z) || !this.y.contains(b2)) {
            return false;
        }
        return true;
    }

    private static boolean a(Context context) {
        if (p.a("SD_MERCHANT", com.paytm.utility.b.J(context), true) || p.a("merchant", com.paytm.utility.b.K(context), true)) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        k.a((Object) instance, "UpiGTMLoader.getInstance()");
        Boolean isRecurringMandateEnabled = instance.isRecurringMandateEnabled();
        k.a((Object) isRecurringMandateEnabled, "UpiGTMLoader.getInstance…isRecurringMandateEnabled");
        return isRecurringMandateEnabled.booleanValue();
    }

    @kotlin.d.b.a.f(b = "UpiSettingsViewModel.kt", c = {413}, d = "invokeSuspend", e = "net.one97.paytm.upi.registration.viewmodel.UpiSettingsViewModel$saveProfileImage$1")
    public static final class g extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $imageUrl;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(e eVar, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = eVar;
            this.$imageUrl = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            g gVar = new g(this.this$0, this.$imageUrl, dVar);
            gVar.p$ = (CoroutineScope) obj;
            return gVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((g) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00fd A[SYNTHETIC, Splitter:B:43:0x00fd] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0108 A[SYNTHETIC, Splitter:B:48:0x0108] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r1 = r5.label
                java.lang.String r2 = "/profilePicture.jpg"
                r3 = 1
                if (r1 == 0) goto L_0x0017
                if (r1 != r3) goto L_0x000f
                kotlin.ResultKt.a((java.lang.Object) r6)
                goto L_0x0068
            L_0x000f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0017:
                kotlin.ResultKt.a((java.lang.Object) r6)
                kotlinx.coroutines.CoroutineScope r6 = r5.p$
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
                r1.<init>()     // Catch:{ all -> 0x0057 }
                java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0057 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0057 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0057 }
                r1.append(r4)     // Catch:{ all -> 0x0057 }
                net.one97.paytm.upi.registration.c.e r4 = r5.this$0     // Catch:{ all -> 0x0057 }
                android.content.Context r4 = r4.z     // Catch:{ all -> 0x0057 }
                android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0057 }
                java.lang.String r4 = com.paytm.utility.b.am(r4)     // Catch:{ all -> 0x0057 }
                r1.append(r4)     // Catch:{ all -> 0x0057 }
                r1.append(r2)     // Catch:{ all -> 0x0057 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0057 }
                java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0057 }
                r4.<init>(r1)     // Catch:{ all -> 0x0057 }
                boolean r1 = r4.exists()     // Catch:{ all -> 0x0057 }
                if (r1 == 0) goto L_0x005b
                r4.delete()     // Catch:{ all -> 0x0057 }
                goto L_0x005b
            L_0x0057:
                r1 = move-exception
                r1.printStackTrace()
            L_0x005b:
                java.lang.String r1 = r5.$imageUrl
                r5.L$0 = r6
                r5.label = r3
                java.lang.Object r6 = net.one97.paytm.upi.registration.c.e.b((java.lang.String) r1)
                if (r6 != r0) goto L_0x0068
                return r0
            L_0x0068:
                android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
                java.lang.String r0 = android.os.Environment.getExternalStorageState()
                java.lang.String r1 = "mounted"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
                if (r0 == 0) goto L_0x0111
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                net.one97.paytm.upi.registration.c.e r1 = r5.this$0
                android.content.Context r1 = r1.z
                java.lang.String r1 = com.paytm.utility.b.am(r1)
                r0.append(r1)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
                java.lang.String r2 = r2.toString()
                r1.append(r2)
                net.one97.paytm.upi.registration.c.e r2 = r5.this$0
                android.content.Context r2 = r2.z
                java.lang.String r2 = com.paytm.utility.b.am(r2)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.io.File r2 = new java.io.File
                r2.<init>(r1)
                boolean r1 = r2.exists()
                if (r1 != 0) goto L_0x00ca
                boolean r3 = r2.mkdirs()
            L_0x00ca:
                if (r3 == 0) goto L_0x0111
                r1 = 0
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00f7 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x00f7 }
                if (r6 == 0) goto L_0x00e8
                android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
                r1 = 100
                r3 = r2
                java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
                boolean r0 = r6.compress(r0, r1, r3)     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
                java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
                goto L_0x00e8
            L_0x00e3:
                r6 = move-exception
                goto L_0x0106
            L_0x00e5:
                r6 = move-exception
                r1 = r2
                goto L_0x00f8
            L_0x00e8:
                if (r6 == 0) goto L_0x00ed
                r6.recycle()     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            L_0x00ed:
                r2.close()     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
                r2.close()     // Catch:{ IOException -> 0x0101 }
                goto L_0x0111
            L_0x00f4:
                r6 = move-exception
                r2 = r1
                goto L_0x0106
            L_0x00f7:
                r6 = move-exception
            L_0x00f8:
                r6.printStackTrace()     // Catch:{ all -> 0x00f4 }
                if (r1 == 0) goto L_0x0111
                r1.close()     // Catch:{ IOException -> 0x0101 }
                goto L_0x0111
            L_0x0101:
                r6 = move-exception
                r6.printStackTrace()
                goto L_0x0111
            L_0x0106:
                if (r2 == 0) goto L_0x0110
                r2.close()     // Catch:{ IOException -> 0x010c }
                goto L_0x0110
            L_0x010c:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0110:
                throw r6
            L_0x0111:
                kotlin.x r6 = kotlin.x.f47997a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.registration.c.e.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
