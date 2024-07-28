package net.one97.paytm.upgradeKyc.editprofile.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upgradeKyc.editprofile.b.a;
import net.one97.paytm.upgradeKyc.editprofile.d.a;
import net.one97.paytm.upgradeKyc.editprofile.e.e;

public final class StandAloneCersaiActivity extends PaytmActivity implements a.f {

    /* renamed from: a  reason: collision with root package name */
    private LottieAnimationView f65900a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f65901b;

    /* renamed from: c  reason: collision with root package name */
    private e f65902c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f65903d;

    private View a(int i2) {
        if (this.f65903d == null) {
            this.f65903d = new HashMap();
        }
        View view = (View) this.f65903d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65903d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(CersaiDetails cersaiDetails) {
        b(cersaiDetails);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.profile_cersai_activity);
        this.f65900a = (LottieAnimationView) findViewById(R.id.wallet_loader);
        a.f fVar = this;
        a.C1308a aVar = net.one97.paytm.upgradeKyc.editprofile.d.a.f65816b;
        net.one97.paytm.common.b.a b2 = d.b();
        k.a((Object) b2, "HomeHelper.getAppLaunchModuleInterface()");
        Context a2 = b2.a();
        k.a((Object) a2, "HomeHelper.getAppLaunchM…face().applicationContext");
        net.one97.paytm.upgradeKyc.editprofile.d.a a3 = a.C1308a.a(a2);
        if (a3 == null) {
            k.a();
        }
        this.f65902c = new e(fVar, a3);
        if (getIntent() != null && getIntent().hasExtra("coming_from_screen")) {
            this.f65901b = getIntent().getBooleanExtra("coming_from_screen", false);
        }
        if (this.f65901b) {
            e eVar = this.f65902c;
            if (eVar != null) {
                a.f fVar2 = eVar.f65834a;
                if (fVar2 != null) {
                    fVar2.a();
                }
                net.one97.paytm.upgradeKyc.editprofile.d.a aVar2 = eVar.f65835b;
                if (aVar2 != null) {
                    aVar2.a((a.d) eVar);
                }
            }
        } else {
            b((CersaiDetails) getIntent().getSerializableExtra("aadhaarData"));
        }
        ((ImageView) a(R.id.cersai_iv_back_button)).setOnClickListener(new a(this));
        a(R.id.back_button_tap_handle_view).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StandAloneCersaiActivity f65904a;

        a(StandAloneCersaiActivity standAloneCersaiActivity) {
            this.f65904a = standAloneCersaiActivity;
        }

        public final void onClick(View view) {
            this.f65904a.onBackPressed();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StandAloneCersaiActivity f65905a;

        b(StandAloneCersaiActivity standAloneCersaiActivity) {
            this.f65905a = standAloneCersaiActivity;
        }

        public final void onClick(View view) {
            this.f65905a.onBackPressed();
        }
    }

    private final void b(CersaiDetails cersaiDetails) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("standaloneCersai", true);
        if (cersaiDetails != null) {
            bundle.putSerializable("aadhaarData", cersaiDetails);
        }
        aVar.setArguments(bundle);
        j supportFragmentManager = getSupportFragmentManager();
        q a2 = supportFragmentManager != null ? supportFragmentManager.a() : null;
        k.a((Object) a2, "supportFragmentManager?.beginTransaction()");
        if (a2 != null) {
            a2.a(R.id.cersai_frag_container, (Fragment) aVar).b();
        }
    }

    public final void a() {
        net.one97.paytm.common.widgets.a.a(this.f65900a);
    }

    public final void b() {
        net.one97.paytm.common.widgets.a.b(this.f65900a);
    }
}
