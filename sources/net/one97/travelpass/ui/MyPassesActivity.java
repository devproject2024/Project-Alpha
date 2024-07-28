package net.one97.travelpass.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.travelpass.R;
import net.one97.travelpass.b.ac;

public final class MyPassesActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ac f30538a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30539b = "my_pass";

    public final void onCreate(Bundle bundle) {
        ImageView imageView;
        super.onCreate(bundle);
        this.f30538a = (ac) f.a(this, R.layout.tp_passes_activity_view);
        ac acVar = this.f30538a;
        if (!(acVar == null || (imageView = acVar.f30066a) == null)) {
            imageView.setOnClickListener(new a(this));
        }
        Fragment aVar = new net.one97.travelpass.ui.fragment.a();
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        q a2 = supportFragmentManager.a();
        k.a((Object) a2, "fragmentManager.beginTransaction()");
        a2.a(R.id.fragment_container, aVar, this.f30539b);
        Intent intent = getIntent();
        Bundle bundle2 = new Bundle();
        if (intent.hasExtra("deeplinkParams")) {
            Serializable serializableExtra = intent.getSerializableExtra("deeplinkParams");
            if (serializableExtra != null) {
                bundle2.putSerializable("deeplinkParams", (HashMap) serializableExtra);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
            }
        }
        aVar.setArguments(bundle2);
        a2.b();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyPassesActivity f30540a;

        a(MyPassesActivity myPassesActivity) {
            this.f30540a = myPassesActivity;
        }

        public final void onClick(View view) {
            this.f30540a.onBackPressed();
        }
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
            boolean r0 = r2 instanceof net.one97.travelpass.ui.fragment.a
            if (r0 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            net.one97.travelpass.ui.fragment.a r1 = (net.one97.travelpass.ui.fragment.a) r1
            if (r1 == 0) goto L_0x003f
            r1.onActivityResult(r5, r6, r7)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.MyPassesActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        com.travel.utils.q.a(context);
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
}
