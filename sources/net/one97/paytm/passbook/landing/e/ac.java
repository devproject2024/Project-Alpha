package net.one97.paytm.passbook.landing.e;

import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.upi.util.UpiConstants;

public final class ac extends a {

    /* renamed from: a  reason: collision with root package name */
    public final f<UpiAvailabilityModel> f57635a;

    public interface a {
        void a();
    }

    public ac(f<? extends UpiAvailabilityModel> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57635a = fVar;
    }

    public static boolean a() {
        try {
            m.a aVar = m.f59265a;
            net.one97.paytm.passbook.mapping.f b2 = d.b();
            k.a((Object) b2, "PassbookHelper.getImplListener()");
            Context b3 = b2.b();
            k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
            return m.a.a(b3).b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true);
        } catch (NullPointerException e2) {
            l.a("UpiHasVPAOperation", "isInActiveProfileExistForUPI ".concat(String.valueOf(e2)));
            return false;
        }
    }
}
