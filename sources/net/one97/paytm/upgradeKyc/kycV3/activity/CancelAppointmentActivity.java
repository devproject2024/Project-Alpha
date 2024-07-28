package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.c.j;
import net.one97.paytm.upgradeKyc.utils.l;

public final class CancelAppointmentActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public j f66078a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f66079b;

    public final View a(int i2) {
        if (this.f66079b == null) {
            this.f66079b = new HashMap();
        }
        View view = (View) this.f66079b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66079b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    static final class a<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancelAppointmentActivity f66080a;

        a(CancelAppointmentActivity cancelAppointmentActivity) {
            this.f66080a = cancelAppointmentActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = b.f66152a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66080a.a(R.id.wallet_loader));
                    CancelAppointmentActivity cancelAppointmentActivity = this.f66080a;
                    String string = cancelAppointmentActivity.getString(R.string.app_cancelled);
                    k.a((Object) string, "getString(R.string.app_cancelled)");
                    CancelAppointmentActivity.a(cancelAppointmentActivity, string);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66080a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66080a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66080a.a(R.id.wallet_loader));
                        Snackbar.a((View) (ConstraintLayout) this.f66080a.a(R.id.cancel_app_parent_lyt), (CharSequence) this.f66080a.getString(R.string.some_went_wrong), -1).c();
                    }
                }
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a("/kyc/reschedule-screen", "kyc_new", "signal");
        ((Button) a(R.id.cancel_app_btn)).setOnClickListener(new b(this));
        ((ImageView) a(R.id.iv_back)).setOnClickListener(new c(this));
        ((RadioGroup) a(R.id.cancel_reason_lyt_rg)).setOnCheckedChangeListener(new d(this));
        this.f66078a = (j) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, j.class);
        j jVar = this.f66078a;
        if (jVar == null) {
            k.a("viewModel");
        }
        jVar.f66248a.observe(this, new a(this));
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        super.attachBaseContext(e.a.b().a(context));
    }

    public final int a() {
        return R.layout.cancel_appointment_lyt;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancelAppointmentActivity f66081a;

        b(CancelAppointmentActivity cancelAppointmentActivity) {
            this.f66081a = cancelAppointmentActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f66081a, "/kyc/reschedule-screen", "cancel_appoitment_clicked", (HashMap) null, (String) null, 12);
            RadioGroup radioGroup = (RadioGroup) this.f66081a.a(R.id.cancel_reason_lyt_rg);
            k.a((Object) radioGroup, "cancel_reason_lyt_rg");
            RadioButton radioButton = (RadioButton) this.f66081a.findViewById(radioGroup.getCheckedRadioButtonId());
            j jVar = this.f66081a.f66078a;
            if (jVar == null) {
                k.a("viewModel");
            }
            k.a((Object) radioButton, "rb");
            j.a(jVar, (String) null, false, (String) null, (String) null, true, radioButton.getText().toString(), 15);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancelAppointmentActivity f66082a;

        c(CancelAppointmentActivity cancelAppointmentActivity) {
            this.f66082a = cancelAppointmentActivity;
        }

        public final void onClick(View view) {
            this.f66082a.onBackPressed();
        }
    }

    static final class d implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancelAppointmentActivity f66083a;

        d(CancelAppointmentActivity cancelAppointmentActivity) {
            this.f66083a = cancelAppointmentActivity;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            UpgradeKycBaseActivity.a(this.f66083a, "/kyc/reschedule-screen", "reason_radio_button_selected", (HashMap) null, (String) null, 12);
        }
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancelAppointmentActivity f66084a;

        e(CancelAppointmentActivity cancelAppointmentActivity) {
            this.f66084a = cancelAppointmentActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            e.a.b().a((Activity) this.f66084a);
        }
    }

    public static final /* synthetic */ void a(CancelAppointmentActivity cancelAppointmentActivity, String str) {
        c.a aVar = new c.a(cancelAppointmentActivity);
        aVar.b((CharSequence) str);
        aVar.a(false);
        aVar.a((CharSequence) "Ok", (DialogInterface.OnClickListener) new e(cancelAppointmentActivity));
        if (!cancelAppointmentActivity.isFinishing()) {
            aVar.b();
        }
    }
}
