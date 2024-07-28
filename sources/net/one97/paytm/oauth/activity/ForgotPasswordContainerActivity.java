package net.one97.paytm.oauth.activity;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.h;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.utils.p;

public final class ForgotPasswordContainerActivity extends OAuthBaseActivity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_forgot_password_container);
    }

    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
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
    }

    public final boolean onSupportNavigateUp() {
        return NavHostFragment.a(getSupportFragmentManager().c(R.id.navHostFragment)).b();
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
        int i2 = R.id.enterNumberFragment;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("/forgot-password-phone-number", "back_button_clicked", kotlin.a.k.d("forgot_password_phone_number"));
        } else {
            int i3 = R.id.enterOtpFragment;
            if (valueOf != null && valueOf.intValue() == i3) {
                a("/forgot-password-sms", "back_button_clicked", kotlin.a.k.d("forgot_password_sms"));
            } else {
                int i4 = R.id.setNewPwdFragment;
                if (valueOf != null && valueOf.intValue() == i4) {
                    a2.a();
                    a("/forgot-password-set-new", "back_button_clicked", kotlin.a.k.d("forgot_password_set_new"));
                }
            }
        }
        super.onBackPressed();
    }

    private static void a(String str, String str2, ArrayList<String> arrayList) {
        b b2 = OauthModule.b();
        b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "forgot_password", str2, arrayList, (String) null, str, p.f56796a);
    }
}
