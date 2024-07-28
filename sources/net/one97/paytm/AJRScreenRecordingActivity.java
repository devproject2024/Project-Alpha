package net.one97.paytm;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;

public final class AJRScreenRecordingActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private final g f51739a = h.a(new e(this));

    /* renamed from: b  reason: collision with root package name */
    private final g f51740b = h.a(a.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f51741c;

    private View a(int i2) {
        if (this.f51741c == null) {
            this.f51741c = new HashMap();
        }
        View view = (View) this.f51741c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f51741c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    private final aa c() {
        return (aa) this.f51740b.getValue();
    }

    public final com.paytm.b.a.a a() {
        return (com.paytm.b.a.a) this.f51739a.getValue();
    }

    static final class e extends l implements kotlin.g.a.a<com.paytm.b.a.a> {
        final /* synthetic */ AJRScreenRecordingActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AJRScreenRecordingActivity aJRScreenRecordingActivity) {
            super(0);
            this.this$0 = aJRScreenRecordingActivity;
        }

        public final com.paytm.b.a.a invoke() {
            ag.a aVar = ag.f69605a;
            Context applicationContext = this.this$0.getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            return ag.a.a(applicationContext);
        }
    }

    static final class a extends l implements kotlin.g.a.a<aa> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final aa invoke() {
            return new aa();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_settings_screen_recorder);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        SwitchMaterial switchMaterial = (SwitchMaterial) a(R.id.security_toggle_button);
        k.a((Object) switchMaterial, "security_toggle_button");
        switchMaterial.setChecked(!a().b("screen_disable_recording", true, true));
        SwitchMaterial switchMaterial2 = (SwitchMaterial) a(R.id.security_toggle_button);
        k.a((Object) switchMaterial2, "security_toggle_button");
        if (switchMaterial2.isChecked()) {
            long b2 = a().b("screen_enable_time", -1, true);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "Calendar.getInstance()");
            long timeInMillis = instance.getTimeInMillis();
            long j = 1800000 + b2;
            int i2 = (b2 > -1 ? 1 : (b2 == -1 ? 0 : -1));
            if (i2 != 0 && timeInMillis >= j) {
                b();
            } else if (i2 != 0 && timeInMillis <= j) {
                a(j - timeInMillis);
            }
        }
        ((SwitchMaterial) a(R.id.security_toggle_button)).setOnCheckedChangeListener(new c(this));
        ((ImageView) a(R.id.back_image)).setOnClickListener(new d(this));
    }

    public final void onBackPressed() {
        net.one97.paytm.j.a.a((Context) this, "allow_screen_recording", "back_clicked", "", "", "", "");
        super.onBackPressed();
    }

    public final void onPause() {
        if (c().isVisible()) {
            SwitchMaterial switchMaterial = (SwitchMaterial) a(R.id.security_toggle_button);
            k.a((Object) switchMaterial, "security_toggle_button");
            switchMaterial.setChecked(false);
            c().dismiss();
        }
        super.onPause();
    }

    static final class c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRScreenRecordingActivity f51744a;

        c(AJRScreenRecordingActivity aJRScreenRecordingActivity) {
            this.f51744a = aJRScreenRecordingActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            net.one97.paytm.j.a.a((Context) this.f51744a, "allow_screen_recording", "toggle_clicked", String.valueOf(z), "", "", "");
            if (z) {
                this.f51744a.c().show(this.f51744a.getSupportFragmentManager().a(), aa.class.getName());
            } else {
                this.f51744a.b();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRScreenRecordingActivity f51745a;

        d(AJRScreenRecordingActivity aJRScreenRecordingActivity) {
            this.f51745a = aJRScreenRecordingActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.j.a.a((Context) this.f51745a, "allow_screen_recording", "back_clicked", "", "", "", "");
            this.f51745a.onBackPressed();
        }
    }

    public final void b() {
        com.paytm.b.a.a a2 = a();
        a2.a("screen_disable_recording", true, true);
        a2.a("screen_enable_time", -1, true);
        SwitchMaterial switchMaterial = (SwitchMaterial) a(R.id.security_toggle_button);
        k.a((Object) switchMaterial, "security_toggle_button");
        switchMaterial.setChecked(false);
        c().f51959a = false;
    }

    public static final class b extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRScreenRecordingActivity f51742a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f51743b;

        public final void onTick(long j) {
        }

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException
            */
        b(long r0, long r2, long r4) {
            /*
                r-1 = this;
                r0.f51742a = r1
                r0.f51743b = r2
                r1 = 1000(0x3e8, double:4.94E-321)
                r0.<init>(r4, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRScreenRecordingActivity.b.<init>(net.one97.paytm.AJRScreenRecordingActivity, long, long):void");
        }

        public final void onFinish() {
            this.f51742a.b();
        }
    }

    public final void a(long j) {
        new b(this, j, j).start();
    }
}
