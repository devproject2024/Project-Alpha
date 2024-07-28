package net.one97.paytm.transport.iocl_v1.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.utils.GAUtil;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.a;
import net.one97.paytm.transport.iocl_v1.a.d;
import net.one97.paytm.transport.iocl_v1.a.e;
import net.one97.paytm.transport.iocl_v1.a.h;
import net.one97.paytm.transport.iocl_v1.c.b;
import net.one97.paytm.transport.iocl_v1.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;
import net.one97.paytm.transport.iocl_v1.data.User;

public abstract class IOCLBaseActivity extends AppCompatActivity {
    public abstract b b();

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment) {
        getSupportFragmentManager().a().b(R.id.iocl_screen_container, fragment, (String) null).c();
    }

    private void b(Fragment fragment) {
        q a2 = getSupportFragmentManager().a();
        a2.a("back_stack");
        a2.b(R.id.iocl_screen_container, fragment, (String) null).c();
    }

    public final void c() {
        a((Fragment) e.a(new Bundle()));
    }

    public final void a(IOCLCommonResponse iOCLCommonResponse) {
        Bundle bundle = new Bundle();
        User user = new User();
        user.setMobile(com.paytm.utility.b.l((Context) this));
        iOCLCommonResponse.setUser(user);
        bundle.putSerializable("common_response", iOCLCommonResponse);
        b(h.a(bundle));
    }

    public final void a(Object obj) {
        if (obj instanceof IOCLBaseModel) {
            Intent intent = new Intent(this, AJRIOCLRedeemPointsStatusActivity.class);
            intent.putExtra("common_response", (IOCLBaseModel) obj);
            startActivity(intent);
        }
    }

    public final void d() {
        b(d.a());
    }

    public final void e() {
        a.b().showSessionTimeoutAlert(this, (String) null, (Bundle) null, (NetworkCustomError) null, net.one97.paytm.transport.iocl.b.b.f14271c);
    }

    public final void a(String str) {
        com.paytm.utility.b.a((Context) this, str, false);
    }

    public final void f() {
        a(getString(R.string.session_error_title_iocl), getString(R.string.session_error_msg_iocl));
    }

    private void a(String str, String str2) {
        g.b(this, str, str2, new g.c() {
            public final void onDialogDismissed() {
                Intent intent = new Intent(IOCLBaseActivity.this, a.b().getAJRAuthActivity());
                intent.putExtra("authError", false);
                intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                IOCLBaseActivity.this.startActivity(intent);
                IOCLBaseActivity.this.finish();
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
