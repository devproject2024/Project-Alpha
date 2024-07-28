package com.paytmmall.clpartifact.widgets;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.k;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import com.paytmmall.clpartifact.widgets.component.SFISView;
import java.io.Serializable;
import java.util.HashMap;

public class SFSFlashPopUpView extends SFISView {
    private FragmentActivity activity;
    private Intent intent;

    public void dismissWidget() {
    }

    public void setOnDismissListener(SFWidget.DismissListener dismissListener) {
    }

    public SFSFlashPopUpView(FragmentActivity fragmentActivity, Class<? extends Activity> cls) {
        this.activity = fragmentActivity;
        this.intent = new Intent(fragmentActivity, cls);
    }

    public void showWidget(HashMap<String, Object> hashMap) {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            boolean isAtLeast = fragmentActivity.getLifecycle().a().isAtLeast(k.b.RESUMED);
            if (!this.activity.isFinishing() && !this.activity.isDestroyed() && isAtLeast) {
                setItemId(this.activity, this.intent.getSerializableExtra(CLPConstants.ISV_AD_ITEM));
                this.activity.startActivity(this.intent);
                FragmentActivity fragmentActivity2 = this.activity;
                int i2 = R.anim.sf_fade_in;
                fragmentActivity2.overridePendingTransition(i2, i2);
            }
        }
    }

    public void putExtra(String str, Serializable serializable) {
        Intent intent2 = this.intent;
        if (intent2 != null) {
            intent2.putExtra(str, serializable);
        }
    }
}
