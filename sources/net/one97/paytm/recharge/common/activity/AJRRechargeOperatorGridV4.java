package net.one97.paytm.recharge.common.activity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import net.one97.paytm.recharge.R;

@Deprecated
public class AJRRechargeOperatorGridV4 extends AJRRechargeOperatorListV4 {

    /* renamed from: a  reason: collision with root package name */
    protected Toolbar f60776a;

    /* access modifiers changed from: protected */
    public final void c() {
    }

    public final void d() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void a() {
        setContentView(R.layout.grid_operator_activity);
    }

    public final void b() {
        super.b();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("title")) {
            setTitle(extras.getString("title"));
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f60776a.setTitle(charSequence);
    }

    public final void a(int i2) {
        if (this.f60779c != null) {
            this.f60779c.setVisibility(i2);
        }
    }

    public final void e() {
        this.f60776a = (Toolbar) findViewById(R.id.toolbar);
        this.f60776a.setTitle((CharSequence) "");
        setSupportActionBar(this.f60776a);
        getSupportActionBar().b(true);
    }
}
