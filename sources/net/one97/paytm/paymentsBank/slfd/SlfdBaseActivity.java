package net.one97.paytm.paymentsBank.slfd;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;

public abstract class SlfdBaseActivity extends PBBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private HashMap f18940b;

    public View a(int i2) {
        if (this.f18940b == null) {
            this.f18940b = new HashMap();
        }
        View view = (View) this.f18940b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f18940b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract int e();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e());
    }
}
