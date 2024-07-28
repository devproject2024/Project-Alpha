package net.one97.paytm.upi.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.deeplink.b;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GAHelper;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class UPIDeeplinkActivity extends PaytmActivity implements b.a {

    /* renamed from: a  reason: collision with root package name */
    Uri f66670a;

    /* renamed from: b  reason: collision with root package name */
    int f66671b;

    /* renamed from: c  reason: collision with root package name */
    private final int f66672c = 3;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_deeplink);
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            this.f66670a = intent.getData();
            this.f66671b = getIntent().getIntExtra(UpiConstants.UPI_SOURCE, 0);
        }
        b();
        getApplicationContext();
        getApplicationContext();
        String str = null;
        net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) null));
        ArrayList arrayList = new ArrayList();
        arrayList.add("upi_intent_link");
        StringBuilder sb = new StringBuilder();
        k.a((Object) a2, "upi");
        sb.append(a2.e());
        arrayList.add(sb.toString());
        arrayList.add(String.valueOf(this.f66670a));
        Context applicationContext = getApplicationContext();
        String valueOf = String.valueOf(a2.e());
        String valueOf2 = String.valueOf(this.f66670a);
        Uri uri = this.f66670a;
        String queryParameter = uri != null ? uri.getQueryParameter("pa") : null;
        Uri uri2 = this.f66670a;
        if (uri2 != null) {
            str = uri2.getQueryParameter("am");
        }
        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(applicationContext, Events.Category.INTENT, Events.Action.DEEPLINK_OPENED, "upi_intent_link", valueOf, valueOf2, queryParameter, str, "none", "");
    }

    private final void b() {
        h c2;
        if (UpiUtils.isP2MIntentFlow(this.f66670a)) {
            i a2 = i.a();
            if (!(a2 == null || (c2 = a2.c()) == null)) {
                c2.a((Activity) this, this.f66670a);
            }
            finish();
        } else if (!com.paytm.utility.a.p(getApplicationContext())) {
            d();
        } else if (this.f66671b == 0) {
            c();
        } else {
            a((UpiAvailabilityModel.UpiAvailabilityResponse) null);
            e();
        }
    }

    private final void c() {
        b bVar = new b();
        bVar.f66687b = this.f66670a;
        bVar.f66690e = this.f66671b;
        bVar.f66691f = this;
        j supportFragmentManager = getSupportFragmentManager();
        q a2 = supportFragmentManager != null ? supportFragmentManager.a() : null;
        k.a((Object) a2, "supportFragmentManager?.beginTransaction()");
        if (a2 != null) {
            a2.a(R.id.container, bVar, bVar.f66686a).a(bVar.f66686a).c();
        }
    }

    private final void d() {
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().a(this.f66672c, (Context) this);
    }

    public final void a(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
        GAHelper.Companion.sendCaptureEventRequestForIntentFlow(getApplicationContext(), this.f66670a);
        i a2 = i.a();
        Boolean bool = (a2 == null || a2.c() == null) ? null : Boolean.TRUE;
        if (bool == null) {
            k.a();
        }
        if (bool.booleanValue()) {
            GAHelper.Companion.sendIntentFlowGAEvent(getApplicationContext(), Integer.valueOf(this.f66671b), this.f66670a, upiAvailabilityResponse);
        } else {
            y.a(new a(this, upiAvailabilityResponse)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new b());
        }
    }

    public static final class b implements aa<Object> {
        public final void onError(Throwable th) {
            k.c(th, "e");
        }

        public final void onSubscribe(c cVar) {
            k.c(cVar, "d");
        }

        public final void onSuccess(Object obj) {
            k.c(obj, "t");
        }

        b() {
        }
    }

    private final void e() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(UpiConstants.EXTRA_VPA_DATA, this.f66670a);
        bundle.putBoolean(UpiConstants.IS_FROM_SCAN, getIntent().getBooleanExtra(UpiConstants.IS_FROM_SCAN, false));
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().a((Context) this, bundle);
        finish();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != this.f66672c) {
            return;
        }
        if (i3 == -1) {
            b();
        } else {
            finish();
        }
    }

    public final void a() {
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.e();
        }
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().b((Context) this);
    }

    public final void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    static final class a<V> implements Callable<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPIDeeplinkActivity f66673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiAvailabilityModel.UpiAvailabilityResponse f66674b;

        a(UPIDeeplinkActivity uPIDeeplinkActivity, UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
            this.f66673a = uPIDeeplinkActivity;
            this.f66674b = upiAvailabilityResponse;
        }

        public final /* synthetic */ Object call() {
            h c2;
            i a2 = i.a();
            if (a2 == null || (c2 = a2.c()) == null) {
                return null;
            }
            this.f66673a.getApplicationContext();
            c2.a((h.a) new h.a(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f66675a;

                {
                    this.f66675a = r1;
                }

                public final void a() {
                    GAHelper.Companion.sendIntentFlowGAEvent(this.f66675a.f66673a.getApplicationContext(), Integer.valueOf(this.f66675a.f66673a.f66671b), this.f66675a.f66673a.f66670a, this.f66675a.f66674b);
                }
            });
            return x.f47997a;
        }
    }
}
