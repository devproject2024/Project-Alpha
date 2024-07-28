package com.travel.citybus.brts;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.paytm.utility.b;
import com.travel.citybus.R;
import com.travel.citybus.a.a;
import com.travel.citybus.brts.utils.c;
import com.travel.citybus.brts.utils.d;
import net.one97.paytm.activity.PaytmActivity;

public abstract class CJRActionBarBaseActivity extends PaytmActivity implements DialogInterface.OnCancelListener {
    private boolean isHomeUpEnabled;
    public ActionBar mActionBar;
    protected DrawerLayout mDrawerLayout;
    protected ProgressDialog mProgressDialog;
    protected CharSequence mTitle;
    private TextView mTitleView;

    public void attachBaseContext(Context context) {
        a.a(context);
        f.d();
        super.attachBaseContext(f.d().a(context));
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        try {
            super.onStop();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.action_bar_layout_brts);
        this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setUpActionBar();
    }

    /* access modifiers changed from: protected */
    public void setUpActionBar() {
        b.f((Context) this);
        this.mActionBar = getSupportActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.b(true);
            this.mActionBar.c(false);
            this.mActionBar.a(true);
            this.mActionBar.b();
            this.mActionBar.a(R.layout.action_bar_title_brts);
            this.mActionBar.a(2.0f);
            this.mTitleView = (TextView) findViewById(R.id.text1);
            this.mTitleView.setInputType(524288);
            this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
            this.mTitleView.setTextSize(19.0f);
            this.mTitleView.setMaxLines(1);
            this.mTitleView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRActionBarBaseActivity.this.homeUpClicked();
                }
            });
            b.d(this.mTitleView);
            this.mActionBar.a((Drawable) new ColorDrawable(getResources().getColor(R.color.brts_white)));
        }
    }

    /* access modifiers changed from: private */
    public void homeUpClicked() {
        if (this.isHomeUpEnabled) {
            onBackPressed();
        } else if (!this.mDrawerLayout.e(8388611)) {
            this.mDrawerLayout.c(8388611);
        } else {
            this.mDrawerLayout.d(8388611);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onPause() {
        b.u();
        super.onPause();
    }

    public void onResume() {
        setNotification();
        super.onResume();
    }

    public void showNetworkDialog(com.paytm.network.a aVar) {
        c.a(aVar, (Context) this, (DialogInterface.OnCancelListener) this);
    }

    public void removeProgressDialog() {
        try {
            if (this.mProgressDialog != null && this.mProgressDialog.isShowing() && !isFinishing()) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
        } catch (Exception e2) {
            com.google.firebase.crashlytics.c.a().a((Throwable) e2);
        }
    }

    public void setNotification() {
        d.a(this).b("cart_item_qty", 0, true);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            hideKeyboard();
            try {
                onBackPressed();
            } catch (IllegalStateException unused) {
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.mTitle = charSequence;
            String charSequence2 = charSequence.toString();
            if (charSequence2 != null && charSequence2.length() > 0) {
                charSequence2 = charSequence2.substring(0, 1).toUpperCase() + charSequence2.substring(1);
            }
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setText(charSequence2);
            }
        }
    }

    public void hideKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception unused) {
            boolean z = b.v;
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCancel(DialogInterface dialogInterface) {
        removeProgressDialog();
    }
}
