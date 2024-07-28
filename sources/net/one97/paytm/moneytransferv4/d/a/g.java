package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.upi.registration.b.a.b;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55384a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final net.one97.paytm.upi.profile.b.b.a a(Context context) {
        k.c(context, "context");
        net.one97.paytm.upi.profile.b.b.a a2 = net.one97.paytm.upi.profile.b.b.a.a(context);
        k.a((Object) a2, "UpiProfileRemoteDataSource.getInstance(context)");
        return a2;
    }

    public static final net.one97.paytm.upi.profile.b.a.a b(Context context) {
        k.c(context, "context");
        net.one97.paytm.upi.profile.b.a.a a2 = net.one97.paytm.upi.profile.b.a.a.a(context);
        k.a((Object) a2, "UpiProfileLocalDataSource.getInstance(context)");
        return a2;
    }

    public static final net.one97.paytm.upi.registration.b.a.a.a c(Context context) {
        k.c(context, "context");
        net.one97.paytm.upi.registration.b.a.a.a a2 = net.one97.paytm.upi.registration.b.a.a.a.a(context);
        k.a((Object) a2, "UpiRegistrationLocalData…urce.getInstance(context)");
        return a2;
    }

    public static final net.one97.paytm.upi.registration.b.a.b.a d(Context context) {
        k.c(context, "context");
        net.one97.paytm.upi.registration.b.a.b.a a2 = net.one97.paytm.upi.registration.b.a.b.a.a(context);
        k.a((Object) a2, "UpiRegistrationRemoteDat…urce.getInstance(context)");
        return a2;
    }

    public static final b a(net.one97.paytm.upi.registration.b.a.a.a aVar, net.one97.paytm.upi.registration.b.a.b.a aVar2, net.one97.paytm.upi.h.a aVar3) {
        k.c(aVar, "upiRegistrationLocalDataSource");
        k.c(aVar2, "upiRegistrationRemoteDataSource");
        k.c(aVar3, "npciServices");
        b a2 = b.a((net.one97.paytm.upi.registration.b.a.a) aVar, (net.one97.paytm.upi.registration.b.a.a) aVar2, aVar3);
        k.a((Object) a2, "UpiRegistrationRepositor…DataSource, npciServices)");
        return a2;
    }

    public static final net.one97.paytm.upi.profile.b.a a(net.one97.paytm.upi.profile.b.b.a aVar, net.one97.paytm.upi.profile.b.a.a aVar2, b bVar) {
        k.c(aVar, "remoteDataSource");
        k.c(aVar2, "localDataSource");
        k.c(bVar, "registrationRepository");
        net.one97.paytm.upi.profile.b.b a2 = net.one97.paytm.upi.profile.b.b.a(aVar, aVar2, bVar);
        k.a((Object) a2, "UpiProfileRepository.get…, registrationRepository)");
        return a2;
    }

    public static final net.one97.paytm.upi.passbook.b.a.a.a e(Context context) {
        k.c(context, "context");
        net.one97.paytm.upi.passbook.b.a.a.a a2 = net.one97.paytm.upi.passbook.b.a.a.a.a(context);
        k.a((Object) a2, "UpiPassbookLocalDataSource.getInstance(context)");
        return a2;
    }

    public static final net.one97.paytm.upi.passbook.b.a.b.a f(Context context) {
        k.c(context, "context");
        net.one97.paytm.upi.passbook.b.a.b.a a2 = net.one97.paytm.upi.passbook.b.a.b.a.a(context);
        k.a((Object) a2, "UpiPassbookRemoteDataSource.getInstance(context)");
        return a2;
    }

    public static final net.one97.paytm.upi.passbook.b.a.a a(net.one97.paytm.upi.passbook.b.a.b.a aVar, net.one97.paytm.upi.passbook.b.a.a.a aVar2) {
        k.c(aVar, "remoteDataSource");
        k.c(aVar2, "localDataSource");
        net.one97.paytm.upi.passbook.b.a.b a2 = net.one97.paytm.upi.passbook.b.a.b.a(aVar2, aVar);
        k.a((Object) a2, "UpiPassbookRepository.ge…Source, remoteDataSource)");
        return a2;
    }
}
