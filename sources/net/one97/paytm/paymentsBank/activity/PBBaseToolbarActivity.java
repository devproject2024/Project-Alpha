package net.one97.paytm.paymentsBank.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.paytm.utility.b;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;

public abstract class PBBaseToolbarActivity extends PBBaseActivity implements g.a {

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f17395e;

    public abstract int e();

    public abstract int f();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toolbar_payment_bank);
        if (f() != -1) {
            setTheme(net.one97.paytm.common.assets.R.style.JarvisAppThemeNoActionBar);
            View inflate = getLayoutInflater().inflate(f(), (ViewGroup) null);
            ((ViewGroup) findViewById(R.id.toolbarLayout)).addView(inflate);
            setSupportActionBar((Toolbar) inflate.findViewById(R.id.toolbar));
            ag_();
            getSupportActionBar().e(net.one97.paytm.common.assets.R.drawable.back_arrow);
            getSupportActionBar().a(true);
            getSupportActionBar().b(true);
            getSupportActionBar().c(false);
            getSupportActionBar().a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        } else {
            setTheme(net.one97.paytm.common.assets.R.style.JarvisAppThemeNoActionBar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().f();
            }
        }
        this.f17395e = (FrameLayout) findViewById(R.id.container_framelayout);
        if (e() != 0) {
            this.f17395e.addView(getLayoutInflater().inflate(e(), (ViewGroup) null));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        try {
            onBackPressed();
            return true;
        } catch (IllegalStateException unused) {
            return true;
        }
    }

    public final void b(f fVar) {
        a(fVar, "");
    }

    private void a(f fVar, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(str, fVar) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ f f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                PBBaseToolbarActivity.this.a(this.f$1, this.f$2, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, f fVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (b.c((Context) this)) {
            a(this, str);
            getApplicationContext();
            new c();
            c.a(fVar);
            return;
        }
        a(fVar, "");
    }
}
