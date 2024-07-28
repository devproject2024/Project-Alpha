package net.one97.paytm.dynamic.module.mall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.utility.q;
import com.paytmmall.artifact.d.t;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.common.b.d;
import net.one97.paytm.deeplink.w;
import net.one97.paytm.marketplace.a;
import net.one97.paytm.upi.util.UpiConstants;

public class MallInitActivity extends AppCompatActivity {
    private String EXTRA_DEEP_LINK_FLAG = UpiConstants.EXTRA_DEEP_LINK_FLAG;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isFromDeeplink(getIntent())) {
            d.a().a(getApplication());
            JarvisHelper.getInstance().getMallControllerInstance();
            t.a((Context) this, getUrlType(getIntent()), getData(getIntent()));
        } else if (getIntent().getBooleanExtra(this.EXTRA_DEEP_LINK_FLAG, false)) {
            w.a((Context) this);
        } else {
            String stringExtra = getIntent().getStringExtra("target_activity_tag");
            if (stringExtra != null) {
                Intent intent = getIntent();
                intent.setClassName(this, a.d(stringExtra));
                int intExtra = intent.getIntExtra("result_code_required", Integer.MIN_VALUE);
                if (intExtra != Integer.MIN_VALUE) {
                    startActivityForResult(intent, intExtra);
                } else {
                    startActivity(intent);
                }
            }
        }
        finish();
    }

    private HashMap<String, Serializable> getData(Intent intent) {
        if (intent != null) {
            try {
                return (HashMap) intent.getSerializableExtra("PAGE_DATA");
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
        return new HashMap<>();
    }

    private String getUrlType(Intent intent) {
        return intent != null ? intent.getStringExtra("PAGE_URL_TYPE") : "";
    }

    private boolean isFromDeeplink(Intent intent) {
        return intent != null && intent.getBooleanExtra("IS_FROM_DEEPLINK", false);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
