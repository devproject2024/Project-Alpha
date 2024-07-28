package net.one97.paytm.wallet.newdesign.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.widget.OverlayLayout;

public class ShowCodeOverlayActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("otp_loc_x", 0);
        int intExtra2 = getIntent().getIntExtra("otp_loc_y", 0);
        int intExtra3 = getIntent().getIntExtra("otp_width", 0);
        int intExtra4 = getIntent().getIntExtra("otp_height", 0);
        OverlayLayout overlayLayout = new OverlayLayout(this);
        overlayLayout.setBackgroundColor(Color.parseColor("#cc000000"));
        overlayLayout.setViewDetails(intExtra, intExtra2, intExtra3, intExtra4);
        ImageView imageView = new ImageView(this);
        imageView.setId(R.id.show_code_imageview);
        imageView.setImageResource(R.drawable.coach_arrow);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = intExtra2 + intExtra4 + 20;
        layoutParams.addRule(14);
        overlayLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(getString(R.string.show_code_overlay_text));
        textView.setTextSize(2, 16.0f);
        textView.setTextAlignment(4);
        textView.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = 20;
        layoutParams2.addRule(3, imageView.getId());
        overlayLayout.addView(textView, layoutParams2);
        setContentView(overlayLayout);
        overlayLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShowCodeOverlayActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }
}
