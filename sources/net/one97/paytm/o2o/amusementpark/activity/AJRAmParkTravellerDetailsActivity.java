package net.one97.paytm.o2o.amusementpark.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.c.a.b;
import net.one97.paytm.o2o.amusementpark.utils.m;

public class AJRAmParkTravellerDetailsActivity extends PaytmActivity implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f73346a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f73347b;

    /* renamed from: c  reason: collision with root package name */
    private AmParkTravellerResponseModel f73348c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f73349d;

    /* renamed from: e  reason: collision with root package name */
    private Toolbar f73350e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f73351f = Boolean.FALSE;

    /* renamed from: g  reason: collision with root package name */
    private b f73352g;

    /* renamed from: h  reason: collision with root package name */
    private ScrollView f73353h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f73354i = new Handler();

    public void attachBaseContext(Context context) {
        if (a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.park_traveller_detail_home_page);
        this.f73351f = Boolean.FALSE;
        Intent intent = getIntent();
        if (intent != null) {
            this.f73346a = intent.getIntExtra("traveller-num-of-passenger", 0);
            this.f73347b = intent.getBooleanExtra("traveller-is-static-form", true);
            this.f73348c = (AmParkTravellerResponseModel) intent.getSerializableExtra("traveller-details");
        }
        this.f73349d = (ImageView) findViewById(R.id.back_arrow);
        this.f73350e = (Toolbar) findViewById(R.id.search_toolabar);
        this.f73349d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRAmParkTravellerDetailsActivity.this.onBackPressed();
            }
        });
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.navigation_bar);
        try {
            if (Build.VERSION.SDK_INT < 16) {
                this.f73350e.setBackgroundDrawable(ninePatchDrawable);
            } else {
                this.f73350e.setBackground(ninePatchDrawable);
            }
        } catch (Exception unused) {
        }
        this.f73353h = (ScrollView) findViewById(R.id.event_traveller_activity_scroll_view);
        this.f73352g = new b();
        this.f73352g.f73427c = this;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("traveller-is-static-form", this.f73347b);
        bundle2.putInt("traveller-num-of-passenger", this.f73346a);
        bundle2.putSerializable("traveller-details", this.f73348c);
        this.f73352g.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.event_traveller_detail_container, this.f73352g, (String) null).c();
    }

    /* JADX WARNING: type inference failed for: r4v16, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r11 = this;
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r11.f73351f = r0
            net.one97.paytm.o2o.amusementpark.c.a.b r0 = r11.f73352g
            r0.a()
            android.widget.Button r1 = r0.f73426b     // Catch:{ Exception -> 0x0186 }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x0186 }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x0186 }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x0186 }
            r2 = 0
            r3 = 0
        L_0x0017:
            int r4 = r1.getChildCount()     // Catch:{ Exception -> 0x0186 }
            if (r3 >= r4) goto L_0x0186
            android.view.View r4 = r1.getChildAt(r3)     // Catch:{ Exception -> 0x0186 }
            java.lang.Object r5 = r4.getTag()     // Catch:{ Exception -> 0x0186 }
            net.one97.paytm.common.entity.amPark.AmParkInputForm r5 = (net.one97.paytm.common.entity.amPark.AmParkInputForm) r5     // Catch:{ Exception -> 0x0186 }
            r6 = 8
            if (r5 != 0) goto L_0x00d7
            boolean r5 = r4 instanceof android.widget.LinearLayout     // Catch:{ Exception -> 0x0186 }
            if (r5 == 0) goto L_0x0182
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x0186 }
            r5 = 0
            if (r4 == 0) goto L_0x004a
            int r7 = r4.getChildCount()     // Catch:{ Exception -> 0x0186 }
            r8 = 1
            if (r7 != r8) goto L_0x004a
            android.view.View r7 = r4.getChildAt(r2)     // Catch:{ Exception -> 0x0186 }
            boolean r7 = r7 instanceof android.widget.LinearLayout     // Catch:{ Exception -> 0x0186 }
            if (r7 == 0) goto L_0x004a
            android.view.View r4 = r4.getChildAt(r2)     // Catch:{ Exception -> 0x0186 }
            r5 = r4
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5     // Catch:{ Exception -> 0x0186 }
        L_0x004a:
            if (r5 == 0) goto L_0x0182
            int r4 = r5.getChildCount()     // Catch:{ Exception -> 0x0186 }
            r7 = 21
            if (r4 != r7) goto L_0x0182
            r4 = 0
        L_0x0055:
            int r7 = r5.getChildCount()     // Catch:{ Exception -> 0x0186 }
            int r7 = r7 / 3
            if (r4 >= r7) goto L_0x0182
            int r7 = r4 * 3
            android.view.View r8 = r5.getChildAt(r7)     // Catch:{ Exception -> 0x0186 }
            com.google.android.material.textfield.TextInputLayout r8 = (com.google.android.material.textfield.TextInputLayout) r8     // Catch:{ Exception -> 0x0186 }
            int r7 = r7 + 2
            android.view.View r7 = r5.getChildAt(r7)     // Catch:{ Exception -> 0x0186 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x0186 }
            if (r7 == 0) goto L_0x0072
            r7.setVisibility(r6)     // Catch:{ Exception -> 0x0186 }
        L_0x0072:
            android.view.View r7 = r8.getChildAt(r2)     // Catch:{ Exception -> 0x0186 }
            android.widget.EditText r7 = (android.widget.EditText) r7     // Catch:{ Exception -> 0x0186 }
            java.lang.Object r8 = r7.getTag()     // Catch:{ Exception -> 0x0186 }
            net.one97.paytm.common.entity.amPark.AmParkInputForm r8 = (net.one97.paytm.common.entity.amPark.AmParkInputForm) r8     // Catch:{ Exception -> 0x0186 }
            android.text.Editable r7 = r7.getText()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x0186 }
            if (r8 == 0) goto L_0x00d3
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0186 }
            if (r9 != 0) goto L_0x00d3
            java.lang.String r9 = r8.getRegex()     // Catch:{ Exception -> 0x0186 }
            if (r9 == 0) goto L_0x00c0
            java.lang.String r9 = r8.getRegex()     // Catch:{ Exception -> 0x0186 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0186 }
            if (r10 == 0) goto L_0x00a4
            java.lang.String r9 = ""
        L_0x00a4:
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r10 = r7.trim()     // Catch:{ Exception -> 0x0186 }
            java.util.regex.Matcher r9 = r9.matcher(r10)     // Catch:{ Exception -> 0x0186 }
            boolean r9 = r9.matches()     // Catch:{ Exception -> 0x0186 }
            if (r9 == 0) goto L_0x00d3
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0186 }
            if (r9 != 0) goto L_0x00d3
            r8.setApplied(r7)     // Catch:{ Exception -> 0x0186 }
            goto L_0x00d3
        L_0x00c0:
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0186 }
            if (r9 != 0) goto L_0x00d3
            java.lang.String r9 = r8.getAppliedData()     // Catch:{ Exception -> 0x0186 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0186 }
            if (r9 == 0) goto L_0x00d3
            r8.setApplied(r7)     // Catch:{ Exception -> 0x0186 }
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x0055
        L_0x00d7:
            java.lang.String r7 = r5.getType()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r8 = "textbox"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0186 }
            if (r7 == 0) goto L_0x0157
            int r7 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textinputlayout     // Catch:{ Exception -> 0x0186 }
            r4.findViewById(r7)     // Catch:{ Exception -> 0x0186 }
            int r7 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textview     // Catch:{ Exception -> 0x0186 }
            android.view.View r7 = r4.findViewById(r7)     // Catch:{ Exception -> 0x0186 }
            android.widget.EditText r7 = (android.widget.EditText) r7     // Catch:{ Exception -> 0x0186 }
            int r8 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x0186 }
            android.view.View r4 = r4.findViewById(r8)     // Catch:{ Exception -> 0x0186 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x0186 }
            r4.setVisibility(r6)     // Catch:{ Exception -> 0x0186 }
            android.text.Editable r4 = r7.getText()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r6 = r5.getRegex()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r7 = "FullName"
            if (r6 != 0) goto L_0x012f
            java.lang.String r6 = r5.getId()     // Catch:{ Exception -> 0x0186 }
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0186 }
            if (r6 == 0) goto L_0x011b
            goto L_0x012f
        L_0x011b:
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0186 }
            if (r6 != 0) goto L_0x0182
            java.lang.String r6 = r5.getAppliedData()     // Catch:{ Exception -> 0x0186 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0186 }
            if (r6 == 0) goto L_0x0182
            r5.setApplied(r4)     // Catch:{ Exception -> 0x0186 }
            goto L_0x0182
        L_0x012f:
            java.lang.String r6 = r5.getRegex()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r8 = r5.getId()     // Catch:{ Exception -> 0x0186 }
            boolean r7 = r8.contains(r7)     // Catch:{ Exception -> 0x0186 }
            if (r7 == 0) goto L_0x0141
            if (r6 != 0) goto L_0x0141
            java.lang.String r6 = "[A-Z\\sa-z]+"
        L_0x0141:
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r7 = r4.trim()     // Catch:{ Exception -> 0x0186 }
            java.util.regex.Matcher r6 = r6.matcher(r7)     // Catch:{ Exception -> 0x0186 }
            boolean r6 = r6.matches()     // Catch:{ Exception -> 0x0186 }
            if (r6 == 0) goto L_0x0182
            r5.setApplied(r4)     // Catch:{ Exception -> 0x0186 }
            goto L_0x0182
        L_0x0157:
            java.lang.String r7 = r5.getType()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r8 = "textarea"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0186 }
            if (r7 == 0) goto L_0x0182
            int r7 = net.one97.paytm.o2o.amusementpark.R.id.events_booking_textarea_edittext     // Catch:{ Exception -> 0x0186 }
            android.view.View r7 = r4.findViewById(r7)     // Catch:{ Exception -> 0x0186 }
            android.widget.EditText r7 = (android.widget.EditText) r7     // Catch:{ Exception -> 0x0186 }
            int r8 = net.one97.paytm.o2o.amusementpark.R.id.events_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x0186 }
            android.view.View r4 = r4.findViewById(r8)     // Catch:{ Exception -> 0x0186 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x0186 }
            r4.setVisibility(r6)     // Catch:{ Exception -> 0x0186 }
            android.text.Editable r4 = r7.getText()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0186 }
            r5.setApplied(r4)     // Catch:{ Exception -> 0x0186 }
        L_0x0182:
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0186:
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r0 = r0.f73425a
            r11.a(r0)
            super.onBackPressed()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.activity.AJRAmParkTravellerDetailsActivity.onBackPressed():void");
    }

    public final void a(AmParkTravellerResponseModel amParkTravellerResponseModel) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("AmPark_BACK_CLICK", this.f73351f.booleanValue());
        bundle.putSerializable("traveller-details", amParkTravellerResponseModel);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public final void b(AmParkTravellerResponseModel amParkTravellerResponseModel) {
        if (amParkTravellerResponseModel != null) {
            this.f73348c = amParkTravellerResponseModel;
        }
    }

    public final void a() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("AmPark_BACK_CLICK", this.f73351f.booleanValue());
        bundle.putSerializable("traveller-details", this.f73348c);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }
}
