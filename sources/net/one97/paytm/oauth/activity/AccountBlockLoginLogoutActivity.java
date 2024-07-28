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
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.c.a;
import net.one97.paytm.oauth.utils.p;

public final class AccountBlockLoginLogoutActivity extends OAuthBaseActivity implements a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f52505a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f52506b;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_account_block_login_logout);
        int i2 = R.id.toolbar;
        if (this.f52506b == null) {
            this.f52506b = new HashMap();
        }
        View view = (View) this.f52506b.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f52506b.put(Integer.valueOf(i2), view);
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
            m a3 = a2.d().a(R.navigation.account_block_login_logout_nav_graph);
            k.a((Object) a3, "navController.navInflate…k_login_logout_nav_graph)");
            Bundle bundle2 = new Bundle();
            if (getIntent().getBooleanExtra("logout", false)) {
                this.f52505a = true;
                bundle2.putString("mobileNumber", getIntent().getStringExtra("mobileNumber"));
                a3.b(R.id.accountBlockEnterNumberFragment);
            } else {
                this.f52505a = false;
                bundle2.putBoolean("logout", getIntent().getBooleanExtra("logout", false));
                a3.b(R.id.accountBlockReasonFragment);
            }
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

    public final void a() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(false);
        }
    }

    public final void onBackPressed() {
        h a2 = NavHostFragment.a(getSupportFragmentManager().c(R.id.navHostFragment));
        k.a((Object) a2, "NavHostFragment.findNavController(navHostFragment)");
        androidx.navigation.k e2 = a2.e();
        Integer valueOf = e2 != null ? Integer.valueOf(e2.b()) : null;
        int i2 = R.id.accountBlockReasonFragment;
        String str = "diy_block_login";
        String str2 = "diy_block_logout";
        if (valueOf != null && valueOf.intValue() == i2) {
            if (this.f52505a) {
                str = str2;
            }
            a("/diy_block_reason", str, "back_clicked", new ArrayList());
        } else {
            int i3 = R.id.accountBlockEnterPasscodeFragment;
            String str3 = "/diy_block_terminal";
            if (valueOf != null && valueOf.intValue() == i3) {
                str3 = "/passcode_verification";
            } else {
                int i4 = R.id.accountBlockTerminalFragment;
                if (valueOf != null && valueOf.intValue() == i4) {
                    if (!this.f52505a) {
                        str2 = str;
                    }
                }
            }
            a(str3, str2, "back_clicked", new ArrayList());
        }
        finish();
    }

    /* access modifiers changed from: private */
    public static void a(String str, String str2, String str3, ArrayList<String> arrayList) {
        b b2 = OauthModule.b();
        b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), str2, str3, arrayList, (String) null, str, p.f56796a);
    }
}
