package net.one97.paytm.recharge.common.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.appcompat.widget.Toolbar;
import com.paytm.utility.n;
import java.util.Locale;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public abstract class CJRRechargeToolbarActivity extends CJRRechargeBaseActivity {
    protected Toolbar u;

    /* access modifiers changed from: protected */
    public final void n() {
    }

    public void onStart() {
        super.onStart();
        try {
            Context applicationContext = CJRRechargeUtilities.INSTANCE.getApplicationContext();
            Locale locale = new Locale(n.a(applicationContext, n.a()));
            Resources resources = applicationContext.getResources();
            Configuration configuration = resources.getConfiguration();
            Locale.setDefault(locale);
            if (Build.VERSION.SDK_INT >= 17) {
                configuration.setLocale(locale);
                applicationContext.createConfigurationContext(configuration);
                return;
            }
            configuration.locale = locale;
            applicationContext.getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    public void al_() {
        this.u = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.u);
        this.p = getSupportActionBar();
        if (this.p != null) {
            this.p.b(true);
        }
        this.s = true;
        setTitle("");
    }

    public void setTitle(CharSequence charSequence) {
        this.r = charSequence;
        if (getSupportActionBar() != null) {
            getSupportActionBar().a(charSequence);
        }
    }
}
