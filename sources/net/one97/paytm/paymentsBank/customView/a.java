package net.one97.paytm.paymentsBank.customView;

import android.os.CountDownTimer;
import net.one97.paytm.bankCommon.model.PBCardDetailModel;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static c f18221a = c.MASKED_CARD;

    /* renamed from: b  reason: collision with root package name */
    private static CountDownTimer f18222b;

    /* renamed from: c  reason: collision with root package name */
    private static PBCardDetailModel f18223c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static long f18224d = 0;

    /* renamed from: net.one97.paytm.paymentsBank.customView.a$a  reason: collision with other inner class name */
    public interface C0308a {
        void onCardTimerFinish();
    }

    public static void a(c cVar) {
        f18221a = cVar;
    }

    public static c a() {
        return f18221a;
    }

    public static void a(PBCardDetailModel pBCardDetailModel) {
        f18223c = pBCardDetailModel;
    }

    public static PBCardDetailModel b() {
        return f18223c;
    }

    public static void a(final C0308a aVar) {
        CountDownTimer countDownTimer = f18222b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            f18222b = null;
        }
        long j = 120000;
        long j2 = f18224d;
        if (j2 > 0) {
            j = j2;
        }
        AnonymousClass1 r2 = new CountDownTimer(j) {
            public final void onTick(long j) {
                long unused = a.f18224d = j;
            }

            public final void onFinish() {
                c unused = a.f18221a = c.MASKED_CARD;
                long unused2 = a.f18224d = 0;
                C0308a aVar = aVar;
                if (aVar != null) {
                    aVar.onCardTimerFinish();
                }
            }
        };
        f18222b = r2;
        r2.start();
    }

    public static void c() {
        CountDownTimer countDownTimer = f18222b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            f18222b = null;
            f18224d = 0;
        }
    }
}
