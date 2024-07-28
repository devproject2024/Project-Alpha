package com.travel.train.activity;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.fragment.am;
import com.travel.train.fragment.o;
import com.travel.train.model.trainticket.CJRTrainSmartIcons;
import kotlin.g.b.k;

public final class AJRTrainHomeV2Activity extends CJRTrainBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private am f25983a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f25984b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainSmartIcons f25985c;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            com.google.android.play.core.splitcompat.a.b((android.content.Context) r6)
            int r6 = com.travel.train.R.layout.pre_t_action_bar_layout
            r5.setContentView((int) r6)
            int r6 = com.travel.train.R.id.base_toolbar
            android.view.View r6 = r5.findViewById(r6)
            java.lang.String r0 = "findViewById(R.id.base_toolbar)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            androidx.appcompat.widget.Toolbar r6 = (androidx.appcompat.widget.Toolbar) r6
            r5.setSupportActionBar(r6)
            androidx.appcompat.app.ActionBar r6 = r5.getSupportActionBar()
            if (r6 == 0) goto L_0x0028
            r0 = 0
            r6.c((boolean) r0)
        L_0x0028:
            int r6 = com.travel.train.R.id.train_toolbar_back_arrow
            android.view.View r6 = r5.findViewById(r6)
            java.lang.String r0 = "findViewById(R.id.train_toolbar_back_arrow)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            com.travel.train.activity.AJRTrainHomeV2Activity$a r0 = new com.travel.train.activity.AJRTrainHomeV2Activity$a
            r0.<init>(r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            int r6 = com.travel.train.R.id.train_toolbar_title
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.f25984b = r6
            android.widget.TextView r6 = r5.f25984b
            java.lang.String r0 = "BOOK TICKETS"
            if (r6 == 0) goto L_0x0055
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
        L_0x0055:
            android.content.Intent r6 = r5.getIntent()
            if (r6 == 0) goto L_0x007e
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r1 = "intent_home_v2_icon_selected"
            boolean r6 = r6.hasExtra(r1)
            if (r6 == 0) goto L_0x007e
            android.content.Intent r6 = r5.getIntent()
            java.io.Serializable r6 = r6.getSerializableExtra(r1)
            if (r6 == 0) goto L_0x0076
            com.travel.train.model.trainticket.CJRTrainSmartIcons r6 = (com.travel.train.model.trainticket.CJRTrainSmartIcons) r6
            r5.f25985c = r6
            goto L_0x007e
        L_0x0076:
            kotlin.u r6 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainSmartIcons"
            r6.<init>(r0)
            throw r6
        L_0x007e:
            androidx.fragment.app.j r6 = r5.getSupportFragmentManager()
            java.lang.String r1 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            androidx.fragment.app.q r6 = r6.a()
            java.lang.String r1 = "fragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            com.travel.train.model.trainticket.CJRTrainSmartIcons r1 = r5.f25985c
            r2 = 0
            if (r1 == 0) goto L_0x009b
            java.lang.String r1 = r1.getUrlType()
            goto L_0x009c
        L_0x009b:
            r1 = r2
        L_0x009c:
            android.widget.TextView r3 = r5.f25984b
            if (r3 == 0) goto L_0x00ad
            com.travel.train.model.trainticket.CJRTrainSmartIcons r4 = r5.f25985c
            if (r4 == 0) goto L_0x00a8
            java.lang.String r2 = r4.getName()
        L_0x00a8:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x00ad:
            if (r1 != 0) goto L_0x00b1
            goto L_0x016e
        L_0x00b1:
            int r2 = r1.hashCode()
            java.lang.String r3 = "intent"
            switch(r2) {
                case -1554915439: goto L_0x0133;
                case -805594500: goto L_0x0112;
                case -441606408: goto L_0x00de;
                case 1141700701: goto L_0x00bc;
                default: goto L_0x00ba;
            }
        L_0x00ba:
            goto L_0x016e
        L_0x00bc:
            java.lang.String r2 = "pnr_status"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x016e
            android.content.Intent r0 = r5.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.os.Bundle r0 = r0.getExtras()
            com.travel.train.fragment.x r0 = com.travel.train.fragment.x.a((android.os.Bundle) r0)
            java.lang.String r1 = "FJRTrainPNRFragment.newInstance(bundle)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.travel.train.fragment.am r0 = (com.travel.train.fragment.am) r0
            r5.f25983a = r0
            goto L_0x017f
        L_0x00de:
            java.lang.String r2 = "metro_rail"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x016e
            android.content.Intent r0 = r5.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.os.Bundle r0 = r0.getExtras()
            if (r0 != 0) goto L_0x00f8
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x00f8:
            com.travel.train.fragment.FJRMetroHomeFragment$a r1 = com.travel.train.fragment.FJRMetroHomeFragment.Factory
            java.lang.String r1 = "args"
            kotlin.g.b.k.c(r0, r1)
            com.travel.train.fragment.FJRMetroHomeFragment r1 = new com.travel.train.fragment.FJRMetroHomeFragment
            r1.<init>()
            r2 = 1
            java.lang.String r3 = "from"
            r0.putBoolean(r3, r2)
            r1.setArguments(r0)
            com.travel.train.fragment.am r1 = (com.travel.train.fragment.am) r1
            r5.f25983a = r1
            goto L_0x017f
        L_0x0112:
            java.lang.String r2 = "live_train_status"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x016e
            android.content.Intent r0 = r5.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.os.Bundle r0 = r0.getExtras()
            com.travel.train.fragment.u r0 = com.travel.train.fragment.u.a((android.os.Bundle) r0)
            java.lang.String r1 = "FJRTrainLiveStatusFragment.newInstance(bundle)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.travel.train.fragment.am r0 = (com.travel.train.fragment.am) r0
            r5.f25983a = r0
            goto L_0x017f
        L_0x0133:
            java.lang.String r2 = "book_tickets"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x016e
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r0 = com.travel.train.j.g.f27551a
            if (r0 == 0) goto L_0x0164
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r0 = com.travel.train.j.g.f27551a
            java.lang.String r1 = "CJRTrainConstants.trainMessages"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isSearchByTrainFeature()
            if (r0 == 0) goto L_0x0164
            android.content.Intent r0 = r5.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.os.Bundle r0 = r0.getExtras()
            com.travel.train.fragment.p$a r1 = com.travel.train.fragment.p.f27120a
            com.travel.train.fragment.p r1 = new com.travel.train.fragment.p
            r1.<init>()
            r1.setArguments(r0)
            com.travel.train.fragment.am r1 = (com.travel.train.fragment.am) r1
            goto L_0x016b
        L_0x0164:
            com.travel.train.fragment.o r0 = r5.a()
            r1 = r0
            com.travel.train.fragment.am r1 = (com.travel.train.fragment.am) r1
        L_0x016b:
            r5.f25983a = r1
            goto L_0x017f
        L_0x016e:
            com.travel.train.fragment.o r1 = r5.a()
            com.travel.train.fragment.am r1 = (com.travel.train.fragment.am) r1
            r5.f25983a = r1
            android.widget.TextView r1 = r5.f25984b
            if (r1 == 0) goto L_0x017f
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x017f:
            com.travel.train.fragment.am r0 = r5.f25983a
            if (r0 == 0) goto L_0x0194
            int r0 = com.travel.train.R.id.content_frame
            com.travel.train.fragment.am r1 = r5.f25983a
            if (r1 != 0) goto L_0x018c
            kotlin.g.b.k.a()
        L_0x018c:
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            r6.b(r0, r1)
            r6.b()
        L_0x0194:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJRTrainHomeV2Activity.onCreate(android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTrainHomeV2Activity f25986a;

        a(AJRTrainHomeV2Activity aJRTrainHomeV2Activity) {
            this.f25986a = aJRTrainHomeV2Activity;
        }

        public final void onClick(View view) {
            this.f25986a.onBackPressed();
        }
    }

    private final o a() {
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        o a2 = o.a(intent.getExtras());
        k.a((Object) a2, "FJRTrainBookingFragment.newInstance(bundle)");
        return a2;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        am amVar;
        super.onActivityResult(i2, i3, intent);
        if ((i3 == -1 || i3 == 0) && intent != null && (amVar = this.f25983a) != null) {
            amVar.onActivityResult(i2, i3, intent);
        }
    }

    public final void onBackPressed() {
        am amVar = this.f25983a;
        if (amVar != null && !amVar.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
