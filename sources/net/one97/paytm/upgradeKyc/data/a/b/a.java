package net.one97.paytm.upgradeKyc.data.a.b;

import com.paytm.network.model.NetworkCustomError;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.x;
import net.one97.paytm.upgradeKyc.data.models.requestotp.RequestOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.resendotp.KycResendOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.verifykycotp.KycVerifyOtpResponse;
import net.one97.paytm.upgradeKyc.kycV3.b.b;

public final class a implements net.one97.paytm.upgradeKyc.data.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1303a f65793a = new C1303a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static a f65794b;

    public final Object a(String str, String str2, d<? super b<RequestOtpResponse>> dVar) {
        return new b(net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS, new RequestOtpResponse(), (NetworkCustomError) null, 12);
    }

    public final Object a(String str, d<? super b<KycResendOtpResponse>> dVar) {
        return new b(net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS, new KycResendOtpResponse(), (NetworkCustomError) null, 12);
    }

    public final Object b(String str, String str2, d<? super b<KycVerifyOtpResponse>> dVar) {
        return new b(net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS, new KycVerifyOtpResponse(), (NetworkCustomError) null, 12);
    }

    /* renamed from: net.one97.paytm.upgradeKyc.data.a.b.a$a  reason: collision with other inner class name */
    public static final class C1303a {
        private C1303a() {
        }

        public /* synthetic */ C1303a(byte b2) {
            this();
        }

        public static a a() {
            if (a.f65794b == null) {
                synchronized (y.b(a.class)) {
                    C1303a aVar = a.f65793a;
                    if (a.f65794b == null) {
                        C1303a aVar2 = a.f65793a;
                        a.f65794b = new a();
                    }
                    x xVar = x.f47997a;
                }
            }
            a a2 = a.f65794b;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
