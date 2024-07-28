package net.one97.paytm.paymentsBank.activity;

import android.os.Bundle;
import android.view.View;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;

public final class RootedDeviceActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f17414a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rooted_device_layout);
        int i2 = R.id.btn_got_it;
        if (this.f17414a == null) {
            this.f17414a = new HashMap();
        }
        View view = (View) this.f17414a.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f17414a.put(Integer.valueOf(i2), view);
        }
        ((RoboTextView) view).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RootedDeviceActivity f17415a;

        a(RootedDeviceActivity rootedDeviceActivity) {
            this.f17415a = rootedDeviceActivity;
        }

        public final void onClick(View view) {
            this.f17415a.finish();
        }
    }
}
