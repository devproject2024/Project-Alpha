package net.one97.paytm.passbook.landing.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import easypay.manager.Constants;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity;
import net.one97.paytm.passbook.genericPassbook.d.a.f;
import net.one97.paytm.passbook.main.AppCompatLockActivity;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class PassbookLandingActivity extends AppCompatLockActivity {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.landing.c.a f57578a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f57579b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f57580c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_landing_screen);
        if (!d.a()) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                View decorView = window != null ? window.getDecorView() : null;
                if (window != null) {
                    window.addFlags(Integer.MIN_VALUE);
                }
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                if (window != null) {
                    window.setStatusBarColor(androidx.core.content.b.c(this, R.color.color_fafafa));
                }
            }
            f fVar = f.f57462b;
            f.b();
            String str = getIntent().getIntExtra("extra_module_open_source", 0) == 1 ? Constants.DEFAULT_BANK : CLPConstants.CHANNEL_NAME;
            Context context = this;
            d.b().b(context, str, "Passbook_icon_clicked", (String) null, str, "/passbook", "PASSBOOK");
            if (!d.b().h(context)) {
                d.b().g(context);
                d.b().i(context);
            }
        }
        int i2 = R.id.imvBackArrow;
        if (this.f57580c == null) {
            this.f57580c = new HashMap();
        }
        View view = (View) this.f57580c.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f57580c.put(Integer.valueOf(i2), view);
        }
        ((ImageView) view).setOnClickListener(new a(this));
        this.f57578a = new net.one97.paytm.passbook.landing.c.a();
        d.b().b("/uth_passbook_myaccounts", "PASSBOOK", this);
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        if (e.E()) {
            q a2 = getSupportFragmentManager().a();
            int i3 = R.id.balanceSummaryFragmentWithPaymentHistory;
            net.one97.paytm.passbook.landing.c.a aVar = this.f57578a;
            if (aVar == null) {
                k.a("balanceSummaryFragment");
            }
            a2.b(i3, aVar).c();
            getSupportFragmentManager().a().b(R.id.paymentHistoryFragmentContainer, new net.one97.paytm.passbook.landing.c.b()).c();
            return;
        }
        q a3 = getSupportFragmentManager().a();
        int i4 = R.id.balanceSummaryFragmentWithoutPaymentHistory;
        net.one97.paytm.passbook.landing.c.a aVar2 = this.f57578a;
        if (aVar2 == null) {
            k.a("balanceSummaryFragment");
        }
        a3.b(i4, aVar2).c();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookLandingActivity f57581a;

        a(PassbookLandingActivity passbookLandingActivity) {
            this.f57581a = passbookLandingActivity;
        }

        public final void onClick(View view) {
            this.f57581a.onBackPressed();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (!isFinishing()) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 3) {
                net.one97.paytm.passbook.landing.c.a aVar = this.f57578a;
                if (aVar == null) {
                    k.a("balanceSummaryFragment");
                }
                aVar.onActivityResult(i2, i3, intent);
            }
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        if (d.a()) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(d.b().a(context));
        }
    }

    public final void onResume() {
        super.onResume();
        new Handler().postDelayed(new b(this), 300);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookLandingActivity f57582a;

        b(PassbookLandingActivity passbookLandingActivity) {
            this.f57582a = passbookLandingActivity;
        }

        public final void run() {
            PassbookLandingActivity.a(this.f57582a);
        }
    }

    public static final /* synthetic */ void a(PassbookLandingActivity passbookLandingActivity) {
        int intExtra = passbookLandingActivity.getIntent().getIntExtra("outerTab", -1);
        if (intExtra == 2 && !passbookLandingActivity.f57579b) {
            Intent intent = new Intent(passbookLandingActivity, PassbookL2Activity.class);
            intent.putExtra("passbook_type", n.SAVINGS_ACCOUNT.getValue());
            passbookLandingActivity.startActivity(intent);
            passbookLandingActivity.f57579b = true;
        } else if (intExtra == 1) {
            Intent intent2 = new Intent(passbookLandingActivity, PassbookL2Activity.class);
            intent2.putExtra("passbook_type", n.PAYTM_WALLET.getValue());
            passbookLandingActivity.startActivity(intent2);
            passbookLandingActivity.finish();
        } else if (intExtra == 4) {
            Intent intent3 = new Intent(passbookLandingActivity, PassbookL2Activity.class);
            intent3.putExtra("passbook_type", n.LOYALTY_WALLET_TYPE_7.getValue());
            intent3.putExtra("passbookTypeFirstGames", n.PAYTM_FIRST_GAMES_WALLET);
            passbookLandingActivity.startActivity(intent3);
            passbookLandingActivity.finish();
        }
    }
}
