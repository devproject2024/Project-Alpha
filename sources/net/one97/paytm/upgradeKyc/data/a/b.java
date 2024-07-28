package net.one97.paytm.upgradeKyc.data.a;

import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.upgradeKyc.data.models.requestotp.RequestOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.resendotp.KycResendOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.verifykycotp.KycVerifyOtpResponse;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65789a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static b f65790d;

    /* renamed from: b  reason: collision with root package name */
    private final a f65791b;

    /* renamed from: c  reason: collision with root package name */
    private final a f65792c;

    private b(a aVar, a aVar2) {
        this.f65791b = aVar;
        this.f65792c = aVar2;
    }

    public /* synthetic */ b(a aVar, a aVar2, byte b2) {
        this(aVar, aVar2);
    }

    public final Object a(String str, String str2, d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<RequestOtpResponse>> dVar) {
        return this.f65792c.a(str, str2, dVar);
    }

    public final Object a(String str, d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KycResendOtpResponse>> dVar) {
        return this.f65792c.a(str, dVar);
    }

    public final Object b(String str, String str2, d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KycVerifyOtpResponse>> dVar) {
        return this.f65792c.b(str, str2, dVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(a aVar, a aVar2) {
            k.c(aVar, "localDataSource");
            k.c(aVar2, "remoteDataSource");
            if (b.f65790d == null) {
                synchronized (b.f65789a) {
                    if (b.f65790d == null) {
                        b.f65790d = new b(aVar, aVar2, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            b a2 = b.f65790d;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
