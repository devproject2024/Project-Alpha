package net.one97.paytm.paymentsBank.cifCreation;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;

public abstract class CIFBaseActivity extends PBBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private HashMap f17992b;

    public View a(int i2) {
        if (this.f17992b == null) {
            this.f17992b = new HashMap();
        }
        View view = (View) this.f17992b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17992b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract int e();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e());
    }
}
