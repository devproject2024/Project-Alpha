package net.one97.paytm.recharge.metro.activity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeOperatorListV4;

@Deprecated
public class AJRMetroRechargeOperatorListV4 extends AJRRechargeOperatorListV4 {

    /* renamed from: a  reason: collision with root package name */
    protected Toolbar f63205a;

    /* renamed from: i  reason: collision with root package name */
    private TextView f63206i;

    public final void c() {
    }

    public final void d() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void a() {
        setContentView(R.layout.metro_grid_operator_activity);
    }

    public final void b() {
        super.b();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("title")) {
            setTitle(extras.getString("title"));
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f63206i.setText("");
    }

    public final void a(int i2) {
        if (this.f60779c != null) {
            this.f60779c.setVisibility(i2);
        }
    }

    public final void e() {
        this.f63205a = (Toolbar) findViewById(R.id.toolbar);
        this.f63205a.setTitle((CharSequence) "");
        setSupportActionBar(this.f63205a);
        getSupportActionBar().b(true);
        this.f63206i = (TextView) findViewById(R.id.toolbar_heading);
    }
}
