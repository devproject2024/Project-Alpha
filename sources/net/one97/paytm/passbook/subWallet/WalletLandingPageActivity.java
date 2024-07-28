package net.one97.paytm.passbook.subWallet;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.passbook.R;

public class WalletLandingPageActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f58789a;

    /* renamed from: b  reason: collision with root package name */
    private Button f58790b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f58791c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f58792d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f58793e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f58794f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f58795g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f58796h;

    /* renamed from: i  reason: collision with root package name */
    private ScrollView f58797i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_wallet_landing_page);
        this.f58789a = (RelativeLayout) findViewById(R.id.rl_continue_reading);
        this.f58790b = (Button) findViewById(R.id.btn_continue_reading);
        this.f58791c = (TextView) findViewById(R.id.tv_add_link_wallet_landing);
        this.f58793e = (LinearLayout) findViewById(R.id.ll_page2_text);
        this.f58795g = (ImageView) findViewById(R.id.iv_bottom_image_wallet_landing_page);
        this.f58796h = (ImageView) findViewById(R.id.iv_back);
        this.f58797i = (ScrollView) findViewById(R.id.scrollViewLandingPage);
        this.f58794f = (LinearLayout) findViewById(R.id.llBottomImage);
        this.f58792d = (LinearLayout) findViewById(R.id.llRoot);
        this.f58796h.setOnClickListener(this);
        this.f58790b.setOnClickListener(this);
        this.f58794f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, WalletLandingPageActivity.this.f58792d.getMeasuredHeight() - (WalletLandingPageActivity.this.f58794f.getMeasuredHeight() + WalletLandingPageActivity.this.findViewById(R.id.backHeaderLL).getMeasuredHeight()), 0, 0);
                WalletLandingPageActivity.this.f58794f.setLayoutParams(layoutParams);
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            onBackPressed();
        } else if (view.getId() == R.id.btn_continue_reading) {
            this.f58793e.setVisibility(0);
            this.f58797i.smoothScrollTo(0, this.f58792d.getMeasuredHeight() - findViewById(R.id.backHeaderLL).getMeasuredHeight());
        }
    }
}
