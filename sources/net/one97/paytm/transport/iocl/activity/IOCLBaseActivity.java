package net.one97.paytm.transport.iocl.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.a.b;
import net.one97.paytm.transport.iocl.a.d;
import net.one97.paytm.transport.iocl.a.e;
import net.one97.paytm.transport.iocl.c.a;
import net.one97.paytm.transport.iocl.data.IOCLBaseModel;

public abstract class IOCLBaseActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    b f14263b;

    /* renamed from: c  reason: collision with root package name */
    e f14264c;

    public abstract a a();

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment) {
        getSupportFragmentManager().a().b(R.id.iocl_screen_container, fragment, (String) null).c();
    }

    /* access modifiers changed from: package-private */
    public final void b(Fragment fragment) {
        q a2 = getSupportFragmentManager().a();
        a2.a("back_stack");
        a2.b(R.id.iocl_screen_container, fragment, (String) null).c();
    }

    public final void b() {
        this.f14264c = e.a(new Bundle());
        b(this.f14264c);
    }

    public final void a(Object obj) {
        if (obj instanceof IOCLBaseModel) {
            Intent intent = new Intent(this, AJRIOCLRedeemPointsStatusActivity.class);
            intent.putExtra("common_response", (IOCLBaseModel) obj);
            startActivity(intent);
        }
    }

    public final void c() {
        b(d.a());
    }

    public final void d() {
        net.one97.paytm.transport.iocl.a.b().showSessionTimeoutAlert(this, (String) null, (Bundle) null, (NetworkCustomError) null, net.one97.paytm.transport.iocl.b.b.f14271c);
    }

    public final void a(String str) {
        com.paytm.utility.b.a((Context) this, str, false);
    }

    public final void a(int i2, NetworkCustomError networkCustomError) {
        net.one97.paytm.transport.iocl.a.b().showSessionTimeoutAlert(this, (String) null, (Bundle) null, networkCustomError, i2);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
