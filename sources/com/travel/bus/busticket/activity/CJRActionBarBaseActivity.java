package com.travel.bus.busticket.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.google.android.play.core.splitcompat.a;
import com.google.firebase.crashlytics.c;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.bus.R;
import net.one97.paytm.activity.PaytmActivity;

public abstract class CJRActionBarBaseActivity extends PaytmActivity {
    private boolean isHomeUpEnabled;
    public ActionBar mActionBar;
    protected FrameLayout mFrameLayout;
    protected ProgressDialog mProgressDialog;
    private TextView mTitleView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_action_bar_layout);
        setUpActionBar();
    }

    /* access modifiers changed from: protected */
    public void setUpActionBar() {
        this.mActionBar = getSupportActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.b(true);
            this.mActionBar.c(false);
            this.mActionBar.a(true);
            this.mActionBar.b();
            this.mActionBar.a(R.layout.pre_b_action_bar_title);
            this.mActionBar.a(2.0f);
            this.mTitleView = (TextView) findViewById(R.id.text1);
            this.mTitleView.setInputType(524288);
            this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
            this.mTitleView.setTextSize(19.0f);
            this.mTitleView.setMaxLines(1);
            this.mTitleView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRActionBarBaseActivity.this.lambda$setUpActionBar$0$CJRActionBarBaseActivity(view);
                }
            });
            b.d(this.mTitleView);
            this.mActionBar.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        }
    }

    public /* synthetic */ void lambda$setUpActionBar$0$CJRActionBarBaseActivity(View view) {
        homeUpClicked();
    }

    private void homeUpClicked() {
        if (this.isHomeUpEnabled) {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
        removeProgressDialog();
    }

    public void onResume() {
        super.onResume();
        a.b((Context) this);
    }

    /* access modifiers changed from: protected */
    public void setBackButtonEnabled(boolean z) {
        this.isHomeUpEnabled = z;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void showProgressDialog(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.mProgressDialog = new ProgressDialog(context);
                try {
                    this.mProgressDialog.setProgressStyle(0);
                    this.mProgressDialog.setMessage(str);
                    this.mProgressDialog.setCancelable(false);
                    this.mProgressDialog.setCanceledOnTouchOutside(false);
                    this.mProgressDialog.show();
                } catch (IllegalArgumentException e2) {
                    if (b.v) {
                        q.c(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void removeProgressDialog() {
        try {
            if (this.mProgressDialog != null && this.mProgressDialog.isShowing() && !isFinishing()) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
        } catch (Exception e2) {
            c.a().a((Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
    }

    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        a.b((Context) this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a.b((Context) this);
    }
}
