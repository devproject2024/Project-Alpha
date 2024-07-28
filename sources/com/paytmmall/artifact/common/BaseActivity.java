package com.paytmmall.artifact.common;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.google.android.play.core.splitcompat.a;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.d;
import net.one97.paytm.activity.PaytmActivity;

public class BaseActivity extends PaytmActivity {
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void setContentView(int i2) {
        super.setContentView(i2);
        a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 23) {
            d.a((Activity) this, getColor(R.color.tool_bar_color_paytm));
        }
    }
}
