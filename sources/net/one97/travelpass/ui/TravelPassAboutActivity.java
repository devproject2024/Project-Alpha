package net.one97.travelpass.ui;

import android.content.Context;
import android.view.View;
import com.travel.utils.q;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.travelpass.b.u;
import net.one97.travelpass.model.TravelPass;
import net.one97.travelpass.model.TravelPassOffers;

public final class TravelPassAboutActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private u f30560a;

    /* renamed from: b  reason: collision with root package name */
    private TravelPass f30561b;

    /* renamed from: c  reason: collision with root package name */
    private TravelPassOffers f30562c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.travelpass.g.a f30563d;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
        r5 = r5.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            r5 = r4
            android.app.Activity r5 = (android.app.Activity) r5
            int r0 = net.one97.travelpass.R.layout.tp_about_activity_view
            androidx.databinding.ViewDataBinding r5 = androidx.databinding.f.a(r5, r0)
            net.one97.travelpass.b.u r5 = (net.one97.travelpass.b.u) r5
            r4.f30560a = r5
            net.one97.travelpass.b.u r5 = r4.f30560a
            if (r5 == 0) goto L_0x0022
            android.widget.ImageView r5 = r5.f30289a
            if (r5 == 0) goto L_0x0022
            net.one97.travelpass.ui.TravelPassAboutActivity$a r0 = new net.one97.travelpass.ui.TravelPassAboutActivity$a
            r0.<init>(r4)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r5.setOnClickListener(r0)
        L_0x0022:
            r5 = r4
            androidx.fragment.app.FragmentActivity r5 = (androidx.fragment.app.FragmentActivity) r5
            androidx.lifecycle.al r5 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r5)
            java.lang.Class<net.one97.travelpass.g.a> r0 = net.one97.travelpass.g.a.class
            androidx.lifecycle.ai r5 = r5.a(r0)
            net.one97.travelpass.g.a r5 = (net.one97.travelpass.g.a) r5
            r4.f30563d = r5
            android.content.Intent r5 = r4.getIntent()
            java.lang.String r0 = "travelPass"
            r1 = 0
            if (r5 == 0) goto L_0x0047
            android.os.Bundle r5 = r5.getExtras()
            if (r5 == 0) goto L_0x0047
            java.io.Serializable r5 = r5.getSerializable(r0)
            goto L_0x0048
        L_0x0047:
            r5 = r1
        L_0x0048:
            boolean r2 = r5 instanceof net.one97.travelpass.model.TravelPass
            if (r2 != 0) goto L_0x004d
            r5 = r1
        L_0x004d:
            net.one97.travelpass.model.TravelPass r5 = (net.one97.travelpass.model.TravelPass) r5
            r4.f30561b = r5
            android.content.Intent r5 = r4.getIntent()
            java.lang.String r2 = "travelPassOffers"
            if (r5 == 0) goto L_0x0064
            android.os.Bundle r5 = r5.getExtras()
            if (r5 == 0) goto L_0x0064
            java.io.Serializable r5 = r5.getSerializable(r2)
            goto L_0x0065
        L_0x0064:
            r5 = r1
        L_0x0065:
            boolean r3 = r5 instanceof net.one97.travelpass.model.TravelPassOffers
            if (r3 != 0) goto L_0x006a
            r5 = r1
        L_0x006a:
            net.one97.travelpass.model.TravelPassOffers r5 = (net.one97.travelpass.model.TravelPassOffers) r5
            r4.f30562c = r5
            net.one97.travelpass.ui.fragment.h r5 = new net.one97.travelpass.ui.fragment.h
            r5.<init>()
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            net.one97.travelpass.model.TravelPass r3 = r4.f30561b
            java.io.Serializable r3 = (java.io.Serializable) r3
            r1.putSerializable(r0, r3)
            net.one97.travelpass.model.TravelPassOffers r0 = r4.f30562c
            java.io.Serializable r0 = (java.io.Serializable) r0
            r1.putSerializable(r2, r0)
            r5.setArguments(r1)
            androidx.fragment.app.j r0 = r4.getSupportFragmentManager()
            java.lang.String r1 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.fragment.app.q r0 = r0.a()
            java.lang.String r1 = "fragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = net.one97.travelpass.R.id.fragment_container
            r0.a((int) r1, (androidx.fragment.app.Fragment) r5)
            r0.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.TravelPassAboutActivity.onCreate(android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TravelPassAboutActivity f30564a;

        a(TravelPassAboutActivity travelPassAboutActivity) {
            this.f30564a = travelPassAboutActivity;
        }

        public final void onClick(View view) {
            this.f30564a.onBackPressed();
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        q.a(context);
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            super.onActivityResult(r5, r6, r7)
            androidx.fragment.app.j r0 = r4.getSupportFragmentManager()
            java.lang.String r1 = "getSupportFragmentManager()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.List r0 = r0.g()
            java.lang.String r1 = "fragmentManager.getFragments()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            if (r0 == 0) goto L_0x0031
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r0.next()
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2.isVisible()
            if (r3 == 0) goto L_0x001c
            goto L_0x0032
        L_0x0031:
            r2 = r1
        L_0x0032:
            boolean r0 = r2 instanceof net.one97.travelpass.ui.fragment.h
            if (r0 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            net.one97.travelpass.ui.fragment.h r1 = (net.one97.travelpass.ui.fragment.h) r1
            if (r1 == 0) goto L_0x003f
            r1.onActivityResult(r5, r6, r7)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.TravelPassAboutActivity.onActivityResult(int, int, android.content.Intent):void");
    }
}
