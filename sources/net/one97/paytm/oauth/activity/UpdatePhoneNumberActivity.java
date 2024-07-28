package net.one97.paytm.oauth.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.h;
import androidx.navigation.m;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.p;

public final class UpdatePhoneNumberActivity extends OAuthBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f52553a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_update_phone_number);
        int i2 = R.id.toolbar;
        if (this.f52553a == null) {
            this.f52553a = new HashMap();
        }
        View view = (View) this.f52553a.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f52553a.put(Integer.valueOf(i2), view);
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
        if (k.a((Object) "2", (Object) getIntent().getStringExtra("mode")) || getIntent().getBooleanExtra("is_update_email", false)) {
            Fragment c2 = getSupportFragmentManager().c(R.id.navHostFragment);
            if (c2 != null) {
                h a2 = ((NavHostFragment) c2).a();
                k.a((Object) a2, "(navHostFragment as NavHostFragment).navController");
                m a3 = a2.d().a(R.navigation.update_phone_nav_graph);
                k.a((Object) a3, "navController.navInflate…n.update_phone_nav_graph)");
                a3.b(R.id.verifyEmailPhoneOtpFragment);
                Bundle bundle2 = new Bundle();
                Intent intent = getIntent();
                bundle2.putString("stateToken", intent != null ? intent.getStringExtra("stateToken") : null);
                bundle2.putString("mobileNo", b.ab(this));
                bundle2.putString("mode", "2");
                bundle2.putBoolean("is_update_email", getIntent().getBooleanExtra("is_update_email", false));
                a2.a(a3, bundle2);
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        if (valueOf == null || valueOf.intValue() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBackPressed() {
        /*
            r8 = this;
            androidx.fragment.app.j r0 = r8.getSupportFragmentManager()
            int r1 = net.one97.paytm.oauth.R.id.navHostFragment
            androidx.fragment.app.Fragment r0 = r0.c((int) r1)
            androidx.navigation.h r0 = androidx.navigation.fragment.NavHostFragment.a(r0)
            java.lang.String r1 = "NavHostFragment.findNavController(navHostFragment)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = r8
            android.content.Context r1 = (android.content.Context) r1
            boolean r2 = com.paytm.utility.b.r((android.content.Context) r1)
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = "phone_update_login"
            goto L_0x0021
        L_0x001f:
            java.lang.String r2 = "phone_update_logout"
        L_0x0021:
            androidx.navigation.k r3 = r0.e()
            r4 = 0
            if (r3 == 0) goto L_0x0031
            int r3 = r3.b()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0032
        L_0x0031:
            r3 = r4
        L_0x0032:
            int r5 = net.one97.paytm.oauth.R.id.selectIssueFragment
            java.lang.String r6 = "back_button_clicked"
            if (r3 != 0) goto L_0x0039
            goto L_0x0052
        L_0x0039:
            int r7 = r3.intValue()
            if (r7 != r5) goto L_0x0052
            java.lang.String r1 = "need_help_otp_page"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            java.lang.String r2 = "/need_help_otp_page"
            java.lang.String r3 = "login_signup"
            a(r2, r3, r6, r1)
            goto L_0x013f
        L_0x0052:
            int r5 = net.one97.paytm.oauth.R.id.savedCardListFragment
            if (r3 != 0) goto L_0x0057
            goto L_0x006e
        L_0x0057:
            int r7 = r3.intValue()
            if (r7 != r5) goto L_0x006e
            java.lang.String r1 = "list_of_saved_cards"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            java.lang.String r3 = "/list_of_saved_cards"
            a(r3, r2, r6, r1)
            goto L_0x013f
        L_0x006e:
            int r5 = net.one97.paytm.oauth.R.id.verifyEmailPhoneOtpFragment
            if (r3 != 0) goto L_0x0073
            goto L_0x00e3
        L_0x0073:
            int r7 = r3.intValue()
            if (r7 != r5) goto L_0x00e3
            androidx.fragment.app.j r1 = r8.getSupportFragmentManager()
            if (r1 == 0) goto L_0x009d
            java.lang.String r3 = "receiver$0"
            kotlin.g.b.k.c(r1, r3)
            androidx.fragment.app.Fragment r1 = r1.t()
            if (r1 == 0) goto L_0x009d
            androidx.fragment.app.j r1 = r1.getChildFragmentManager()
            if (r1 == 0) goto L_0x009d
            java.util.List r1 = r1.g()
            if (r1 == 0) goto L_0x009d
            java.lang.Object r1 = kotlin.a.k.d(r1)
            r4 = r1
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
        L_0x009d:
            boolean r1 = r4 instanceof net.one97.paytm.oauth.fragment.VerifyEmailPhoneOtpFragment
            if (r1 == 0) goto L_0x013f
            net.one97.paytm.oauth.fragment.VerifyEmailPhoneOtpFragment r4 = (net.one97.paytm.oauth.fragment.VerifyEmailPhoneOtpFragment) r4
            java.lang.String r1 = r4.f56223c
            java.lang.String r3 = "2"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x00d3
            boolean r1 = r4.f56224d
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = "/phone_otp_for_add_email"
            java.lang.String[] r2 = new java.lang.String[]{r1}
            java.util.ArrayList r2 = kotlin.a.k.d(r2)
            java.lang.String r3 = "add_email"
            a(r1, r3, r6, r2)
            goto L_0x013f
        L_0x00c2:
            java.lang.String r1 = "old_number_otp_page"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            java.lang.String r3 = "/old_number_otp_page"
            a(r3, r2, r6, r1)
            goto L_0x013f
        L_0x00d3:
            java.lang.String r1 = "email_otp_page"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            java.lang.String r3 = "/email_otp"
            a(r3, r2, r6, r1)
            goto L_0x013f
        L_0x00e3:
            int r5 = net.one97.paytm.oauth.R.id.enterNewNumberFragment
            if (r3 != 0) goto L_0x00e8
            goto L_0x00fe
        L_0x00e8:
            int r7 = r3.intValue()
            if (r7 != r5) goto L_0x00fe
            java.lang.String r1 = "new_phone_number_page"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            java.lang.String r3 = "/new_phone_number"
            a(r3, r2, r6, r1)
            goto L_0x013f
        L_0x00fe:
            int r5 = net.one97.paytm.oauth.R.id.mobileEnterOtpFragment
            if (r3 != 0) goto L_0x0103
            goto L_0x0119
        L_0x0103:
            int r7 = r3.intValue()
            if (r7 != r5) goto L_0x0119
            java.lang.String r1 = "new_phone_number_otp_page"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            java.lang.String r3 = "/new_phone_number_otp"
            a(r3, r2, r6, r1)
            goto L_0x013f
        L_0x0119:
            int r2 = net.one97.paytm.oauth.R.id.numberUpdateSuccessFragment
            if (r3 != 0) goto L_0x011e
            goto L_0x013f
        L_0x011e:
            int r3 = r3.intValue()
            if (r3 != r2) goto L_0x013f
            boolean r2 = com.paytm.utility.b.r((android.content.Context) r1)
            if (r2 == 0) goto L_0x013f
            net.one97.paytm.oauth.b r2 = net.one97.paytm.oauth.OauthModule.b()
            r3 = r8
            android.app.Activity r3 = (android.app.Activity) r3
            r5 = 0
            r2.onLogout(r3, r5, r4)
            net.one97.paytm.oauth.b r2 = net.one97.paytm.oauth.OauthModule.b()
            r3 = 1
            java.lang.String r4 = "/phone_update_success"
            r2.openHomePage(r1, r5, r4, r3)
        L_0x013f:
            androidx.navigation.k r0 = r0.e()
            if (r0 == 0) goto L_0x014d
            int r0 = r0.b()
            int r1 = net.one97.paytm.oauth.R.id.selectIssueFragment
            if (r0 == r1) goto L_0x0151
        L_0x014d:
            r0 = -1
            r8.setResult(r0)
        L_0x0151:
            r8.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.activity.UpdatePhoneNumberActivity.onBackPressed():void");
    }

    private static void a(String str, String str2, String str3, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), str2, str3, arrayList, (String) null, str, p.f56796a);
    }
}
