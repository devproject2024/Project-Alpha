package net.one97.paytm.upgradeKyc.data.a.a.a;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.paytmmoney.lite.mod.util.PMConstants;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.n;
import kotlin.x;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3;
import net.one97.paytm.upgradeKyc.data.models.aotpexpire.AOTPExpireApiResponse;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.utils.c;
import net.one97.paytm.upgradeKyc.utils.j;

public final class a implements net.one97.paytm.upgradeKyc.data.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1300a f65775a = new C1300a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f65776c;

    /* renamed from: b  reason: collision with root package name */
    private final Application f65777b;

    private a(Application application) {
        this.f65777b = application;
    }

    public /* synthetic */ a(Application application, byte b2) {
        this(application);
    }

    public final Object a(d<? super b<KYCFetchTnc>> dVar) {
        throw new n("An operation is not implemented: ".concat("Not yet implemented"));
    }

    public final Object a(int i2, String str, d<? super b<KYCTncAccept>> dVar) {
        b.a aVar = b.f66167d;
        return b.a.a(new KYCTncAccept());
    }

    public final Object b(d<? super b<AOTPExpireApiResponse>> dVar) {
        b.a aVar = b.f66167d;
        return b.a.a(new AOTPExpireApiResponse());
    }

    public final Object c(d<? super b<KYCStatusV3>> dVar) {
        b.a aVar = b.f66167d;
        return b.a.a(new KYCStatusV3());
    }

    public final void a(KYCStatusV3 kYCStatusV3) {
        k.c(kYCStatusV3, PMConstants.KYC_STATUS_KEY);
        if (!TextUtils.isEmpty(kYCStatusV3.getExpiryType())) {
            j.g(this.f65777b, kYCStatusV3.getExpiryType());
        }
        j.b((Context) this.f65777b, kYCStatusV3.isMinKycEligible());
        j.c((Context) this.f65777b, kYCStatusV3.getKycType());
        j.a((Context) this.f65777b, kYCStatusV3.isMinKycStatus());
        j.a((Context) this.f65777b, kYCStatusV3.getIsKycDone());
        j.b((Context) this.f65777b, kYCStatusV3.isKycExpired());
        j.c((Context) this.f65777b, kYCStatusV3.isAadharVerified());
        j.a(k.a((Object) "true", (Object) kYCStatusV3.getIsPanVerified()));
        j.a(kYCStatusV3.getPanSubmittedAs());
        j.b(kYCStatusV3.isForm60());
        j.a(kYCStatusV3.getIsKycDone());
        j.b(kYCStatusV3.getAadhaarSubmittedAs());
        String kycExpiryTime = kYCStatusV3.getKycExpiryTime();
        if (kycExpiryTime == null) {
            kycExpiryTime = "";
        }
        if (!TextUtils.isEmpty(kycExpiryTime)) {
            j.d(this.f65777b, c.a(kycExpiryTime));
        }
        if (!TextUtils.isEmpty(kYCStatusV3.getIsMinor())) {
            j.e(this.f65777b, kYCStatusV3.getIsMinor());
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.data.a.a.a.a$a  reason: collision with other inner class name */
    public static final class C1300a {
        private C1300a() {
        }

        public /* synthetic */ C1300a(byte b2) {
            this();
        }

        public static a a(Application application) {
            k.c(application, "application");
            if (a.f65776c == null) {
                synchronized (net.one97.paytm.upgradeKyc.data.a.a.b.a.class) {
                    C1300a aVar = a.f65775a;
                    if (a.f65776c == null) {
                        C1300a aVar2 = a.f65775a;
                        a.f65776c = new a(application, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            a a2 = a.f65776c;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
