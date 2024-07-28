package com.paytmmall.artifact.flyout;

import android.os.Bundle;
import androidx.fragment.app.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.common.BaseActivity;

public class AJRWeexFullPageFlyoutActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mall_activity_weex_full_page_flyout);
        q a2 = getSupportFragmentManager().a();
        a2.a(R.id.weex_fragment_container, new a(), "");
        a2.b();
    }
}
