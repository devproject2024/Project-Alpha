package net.one97.paytm.upi.registration.c;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.SignupStepCodeResponse;
import net.one97.paytm.upi.common.upi.UpiCreateProfileResponse;
import net.one97.paytm.upi.common.upi.UpiProfileBaseResponseModel;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;

public final class c extends androidx.lifecycle.a implements a.C1389a {

    /* renamed from: a  reason: collision with root package name */
    public final y<Boolean> f68534a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final String f68535b = "FetchBankAccountsViewModel";

    /* renamed from: c  reason: collision with root package name */
    public final String f68536c = "";

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.upi.registration.b.a.b f68537d;

    /* renamed from: e  reason: collision with root package name */
    public y<b> f68538e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public final y<Integer> f68539f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    private final y<Integer> f68540g = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
        net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) null));
        k.a((Object) a2, "Injection.provideUpiRegi…vices(application, null))");
        this.f68537d = a2;
        this.f68534a.setValue(Boolean.FALSE);
    }

    public static final class d implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f68552a;

        public d(c cVar) {
            this.f68552a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiProfileBaseResponseModel) {
                String respCode = ((UpiProfileBaseResponseModel) upiBaseDataModel).getRespCode();
                if (p.a("0", respCode, true) || p.a("INT-1222", respCode, true)) {
                    this.f68552a.f68534a.setValue(Boolean.TRUE);
                } else if (p.a("1005", respCode, true)) {
                    this.f68552a.f68534a.setValue(Boolean.TRUE);
                } else {
                    y b2 = this.f68552a.f68539f;
                    a.C1391a aVar = a.f68541a;
                    b2.setValue(Integer.valueOf(a.f68548h));
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y b2 = this.f68552a.f68539f;
            a.C1391a aVar = a.f68541a;
            b2.setValue(Integer.valueOf(a.f68548h));
        }
    }

    /* renamed from: net.one97.paytm.upi.registration.c.c$c  reason: collision with other inner class name */
    public static final class C1392c implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f68551a;

        C1392c(c cVar) {
            this.f68551a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiCreateProfileResponse) {
                UpiCreateProfileResponse upiCreateProfileResponse = (UpiCreateProfileResponse) upiBaseDataModel;
                if (!p.a(upiCreateProfileResponse.getStatus(), "SUCCESS", true) || !k.a((Object) "0", (Object) upiCreateProfileResponse.getRespCode())) {
                    y b2 = this.f68551a.f68539f;
                    a.C1391a aVar = a.f68541a;
                    b2.setValue(Integer.valueOf(a.f68548h));
                    return;
                }
                UpiProfileModel.ProfileDetails profileDetails = null;
                UpiCreateProfileResponse.AccountDetails accountDetails = upiCreateProfileResponse.getAccountDetails();
                k.a((Object) accountDetails, "upiCreateProfileResponse.accountDetails");
                Iterator<SignupStepCodeResponse> it2 = accountDetails.getStepResponses().iterator();
                String str = "";
                while (it2.hasNext()) {
                    SignupStepCodeResponse next = it2.next();
                    k.a((Object) next, "stepCodeResponse");
                    if (!p.a(next.getStepCode(), UpiConstants.SignUpStepCodes.REGISTER_DEVICE, true)) {
                        if (p.a(next.getStepCode(), UpiConstants.SignUpStepCodes.CREATE_VPA, true)) {
                            if (k.a((Object) "0", (Object) next.getRespCode())) {
                                SignupStepCodeResponse.Details details = next.getDetails();
                                k.a((Object) details, "stepCodeResponse.details");
                                if (details.getVpaDetails() != null) {
                                    SignupStepCodeResponse.Details details2 = next.getDetails();
                                    k.a((Object) details2, "stepCodeResponse.details");
                                    SignupStepCodeResponse.VpaDetails vpaDetails = details2.getVpaDetails().get(0);
                                    k.a((Object) vpaDetails, "stepCodeResponse.details.vpaDetails[0]");
                                    str = vpaDetails.getVpa();
                                    k.a((Object) str, "stepCodeResponse.details.vpaDetails[0].vpa");
                                }
                            }
                            y b3 = this.f68551a.f68539f;
                            a.C1391a aVar2 = a.f68541a;
                            b3.setValue(Integer.valueOf(a.f68548h));
                            return;
                        }
                        p.a(next.getStepCode(), UpiConstants.SignUpStepCodes.FETCH_ACCOUNT, true);
                        if (p.a(next.getStepCode(), UpiConstants.SignUpStepCodes.LINK_ACCOUNT, true) && k.a((Object) "0", (Object) next.getRespCode())) {
                            UpiCreateProfileResponse.AccountDetails accountDetails2 = upiCreateProfileResponse.getAccountDetails();
                            k.a((Object) accountDetails2, "upiCreateProfileResponse.accountDetails");
                            profileDetails = accountDetails2.getProfileDetail();
                        }
                    }
                }
                this.f68551a.f68538e.setValue(new b(str, profileDetails));
                return;
            }
            y b4 = this.f68551a.f68539f;
            a.C1391a aVar3 = a.f68541a;
            b4.setValue(Integer.valueOf(a.f68548h));
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y b2 = this.f68551a.f68539f;
            a.C1391a aVar = a.f68541a;
            b2.setValue(Integer.valueOf(a.f68548h));
        }
    }

    private final void a() {
        this.f68537d.a(new C1392c(this), this.f68535b);
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            k.a();
        }
        String fullUrl = upiCustomVolleyError.getFullUrl();
        CharSequence charSequence = fullUrl;
        if (!TextUtils.isEmpty(charSequence)) {
            k.a((Object) fullUrl, "url");
            if (p.a(charSequence, (CharSequence) "get-token", false)) {
                a();
            }
        }
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        if (upiBaseDataModel instanceof UpiToken) {
            a();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f68549a;

        /* renamed from: b  reason: collision with root package name */
        public final UpiProfileModel.ProfileDetails f68550b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return k.a((Object) this.f68549a, (Object) bVar.f68549a) && k.a((Object) this.f68550b, (Object) bVar.f68550b);
        }

        public final int hashCode() {
            String str = this.f68549a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            UpiProfileModel.ProfileDetails profileDetails = this.f68550b;
            if (profileDetails != null) {
                i2 = profileDetails.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "FetchAccountModel(vpa=" + this.f68549a + ", profileDetails=" + this.f68550b + ")";
        }

        public b(String str, UpiProfileModel.ProfileDetails profileDetails) {
            k.c(str, "vpa");
            this.f68549a = str;
            this.f68550b = profileDetails;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final C1391a f68541a = new C1391a((byte) 0);

        /* renamed from: b  reason: collision with root package name */
        private static final int f68542b = 1;

        /* renamed from: c  reason: collision with root package name */
        private static final int f68543c = 2;

        /* renamed from: d  reason: collision with root package name */
        private static final int f68544d = 3;

        /* renamed from: e  reason: collision with root package name */
        private static final int f68545e = 4;

        /* renamed from: f  reason: collision with root package name */
        private static final int f68546f = 5;

        /* renamed from: g  reason: collision with root package name */
        private static final int f68547g = 6;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final int f68548h = 7;

        /* renamed from: net.one97.paytm.upi.registration.c.c$a$a  reason: collision with other inner class name */
        public static final class C1391a {
            private C1391a() {
            }

            public /* synthetic */ C1391a(byte b2) {
                this();
            }
        }
    }
}
