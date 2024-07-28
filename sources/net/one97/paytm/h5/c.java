package net.one97.paytm.h5;

import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.analytics.b;
import com.paytm.analytics.models.PaytmLocation;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f50543a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, b> f50544b = new HashMap<>();

    public interface a {
        void onLocationUpdate(double d2, double d3, long j);
    }

    public interface b {
        void provideValuesForKeys(String str, C0910c cVar);
    }

    /* renamed from: net.one97.paytm.h5.c$c  reason: collision with other inner class name */
    public interface C0910c {
        void onResult(Object obj);
    }

    private c() {
    }

    public static Object a(String str, String str2, C0910c cVar) {
        k.c(str, "verticalName");
        k.c(str2, "key");
        k.c(cVar, H5Event.TYPE_CALL_BACK);
        q.d("provideValuesForKeys verticalName: ".concat(String.valueOf(str)));
        q.d("provideValuesForKeys key: ".concat(String.valueOf(str2)));
        b bVar = f50544b.get(str);
        if (bVar == null) {
            return null;
        }
        bVar.provideValuesForKeys(str2, cVar);
        return x.f47997a;
    }

    public static void a(String str, b bVar) {
        k.c(str, "verticalName");
        k.c(bVar, "verticalDataProvider");
        f50544b.put(str, bVar);
    }

    public static final class d implements com.paytm.analytics.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50545a;

        d(a aVar) {
            this.f50545a = aVar;
        }

        public final void a(PaytmLocation paytmLocation) {
            k.c(paytmLocation, "paytmLocation");
            a aVar = this.f50545a;
            Float latitude = paytmLocation.getLatitude();
            if (latitude == null) {
                k.a();
            }
            double floatValue = (double) latitude.floatValue();
            Float longitude = paytmLocation.getLongitude();
            if (longitude == null) {
                k.a();
            }
            double floatValue2 = (double) longitude.floatValue();
            Long time = paytmLocation.getTime();
            if (time == null) {
                k.a();
            }
            aVar.onLocationUpdate(floatValue, floatValue2, time.longValue());
        }
    }

    public static void a(a aVar) {
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        b.C0683b bVar = com.paytm.analytics.b.f40911e;
        com.paytm.analytics.d dVar = new d(aVar);
        k.c(dVar, "locationCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new b.C0683b.C0684b(dVar, (kotlin.d.d) null), 2, (Object) null);
    }
}
