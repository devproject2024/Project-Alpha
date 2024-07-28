package net.one97.paytm.h5.helper;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.utility.a;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class H5LoginHelperActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private final int f16945a = 567;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Integer valueOf = Integer.valueOf(getIntent().getIntExtra(CLConstants.FIELD_ERROR_CODE, 0));
        Intent intent = new Intent(this, AJRAuthActivity.class);
        if (valueOf.intValue() == 401 || valueOf.intValue() == 410) {
            intent.putExtra("authError", true);
            intent.putExtra("prev_token", a.q(this));
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("close_pop_up", true);
            intent.putExtra("resultant activity_bundle", bundle2);
        }
        startActivityForResult(intent, 567);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        StringBuilder sb = new StringBuilder("requestCode ");
        sb.append(i2);
        sb.append(" resultCode");
        sb.append(i3);
        sb.append(" ok code-1");
        if (i2 == 567) {
            a a2 = a.a();
            boolean z = i3 == -1;
            if (a2.f16947a != null) {
                a2.f16947a.a(Boolean.valueOf(z));
            }
        }
        finish();
    }
}
