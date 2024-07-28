package com.alipay.mobile.nebulacore.ui;

import android.os.Build;
import android.os.Bundle;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5StatusBarUtils;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5TransActivity extends H5Activity {
    public static final String TAG = "H5TransActivity";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H5Log.d(TAG, "onCreate");
        initStatusBar();
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
    }

    private void initStatusBar() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                if (H5Utils.getBoolean(extras, H5Param.LONG_TRANS_ANIMATE, false)) {
                    H5StatusBarUtils.setTransparentColor(this, 855638016);
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
    }

    public static class H5TransActivity1 extends H5TransActivity {
        public void onCreate(Bundle bundle) {
            H5TransActivity.super.onCreate(bundle);
            H5Log.d(H5TransActivity.TAG, "onCreate H5TransActivity1");
        }
    }

    public static class H5TransActivity2 extends H5TransActivity {
        public void onCreate(Bundle bundle) {
            H5TransActivity.super.onCreate(bundle);
            H5Log.d(H5TransActivity.TAG, "onCreate H5TransActivity2");
        }
    }

    public static class H5TransActivity3 extends H5TransActivity {
        public void onCreate(Bundle bundle) {
            H5TransActivity.super.onCreate(bundle);
            H5Log.d(H5TransActivity.TAG, "onCreate H5TransActivity3");
        }
    }

    public static class H5TransActivity4 extends H5TransActivity {
        public void onCreate(Bundle bundle) {
            H5TransActivity.super.onCreate(bundle);
            H5Log.d(H5TransActivity.TAG, "onCreate H5TransActivity4");
        }
    }

    public static class H5TransActivity5 extends H5TransActivity {
        public void onCreate(Bundle bundle) {
            H5TransActivity.super.onCreate(bundle);
            H5Log.d(H5TransActivity.TAG, "onCreate H5TransActivity5");
        }
    }
}
