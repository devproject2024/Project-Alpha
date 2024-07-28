package net.one97.paytm.oauth.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.h;
import androidx.navigation.m;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.p;

public final class UpdateEmailActivity extends OAuthBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f52552a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_update_email);
        int i2 = R.id.toolbar;
        if (this.f52552a == null) {
            this.f52552a = new HashMap();
        }
        View view = (View) this.f52552a.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f52552a.put(Integer.valueOf(i2), view);
        }
        setSupportActionBar((Toolbar) view);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.a(0.0f);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.a((CharSequence) "");
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.b(true);
        }
        Fragment c2 = getSupportFragmentManager().c(R.id.navHostFragment);
        if (c2 != null) {
            h a2 = ((NavHostFragment) c2).a();
            k.a((Object) a2, "(navHostFragment as NavHostFragment).navController");
            m a3 = a2.d().a(R.navigation.update_email_nav_graph);
            k.a((Object) a3, "navController.navInflate…n.update_email_nav_graph)");
            a3.b(R.id.verifyPhoneOtpFragment);
            Bundle bundle2 = new Bundle();
            bundle2.putString("mobile", b.ab(this));
            bundle2.putString(AppConstants.KEY_EMAIL, getIntent().getStringExtra(AppConstants.KEY_EMAIL));
            bundle2.putString("stateToken", getIntent().getStringExtra("stateToken"));
            a2.a(a3, bundle2);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        if (valueOf == null || valueOf.intValue() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void onBackPressed() {
        h a2 = NavHostFragment.a(getSupportFragmentManager().c(R.id.navHostFragment));
        k.a((Object) a2, "NavHostFragment.findNavController(navHostFragment)");
        androidx.navigation.k e2 = a2.e();
        Integer valueOf = e2 != null ? Integer.valueOf(e2.b()) : null;
        int i2 = R.id.verifyPhoneOtpFragment;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("/phone_otp_for_add_email", "add_email", "back_button_clicked", kotlin.a.k.d("/phone_otp_for_add_email"));
        } else {
            int i3 = R.id.verifyEmailOtpFragment;
            if (valueOf != null && valueOf.intValue() == i3) {
                a("/email_otp_for_add_email", "add_email", "back_button_clicked", kotlin.a.k.d("/email_otp_for_add_email"));
            }
        }
        finish();
    }

    private static void a(String str, String str2, String str3, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), str2, str3, arrayList, (String) null, str, p.f56796a);
    }
}
