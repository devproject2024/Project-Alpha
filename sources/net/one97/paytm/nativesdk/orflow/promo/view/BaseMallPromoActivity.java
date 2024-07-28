package net.one97.paytm.nativesdk.orflow.promo.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class BaseMallPromoActivity extends PaytmActivity {
    private ProgressDialog mProgressDialog = null;

    public final void hideVerifyLoader() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        screenRecordingCheck();
    }

    /* access modifiers changed from: protected */
    public final void showVerifyLoader() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.mProgressDialog = new ProgressDialog(this);
            try {
                this.mProgressDialog.setIndeterminateDrawable(b.a((Context) this, R.drawable.promo_custom_progress_bar));
                this.mProgressDialog.setMessage(getString(R.string.please_wait_progress_msg));
                this.mProgressDialog.setCancelable(false);
                this.mProgressDialog.setCanceledOnTouchOutside(false);
                this.mProgressDialog.show();
            } catch (IllegalArgumentException e2) {
                LogUtility.printStackTrace(e2);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void setupToolbar(Toolbar toolbar, String str) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
            getSupportActionBar().b(true);
            getSupportActionBar().a(true);
        }
        if (Build.VERSION.SDK_INT >= 21 && toolbar != null) {
            toolbar.setTitle((CharSequence) str);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BaseMallPromoActivity.this.onBackPressed();
                }
            });
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void handleAuthError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        Intent intent = new Intent();
        intent.putExtra(EMIConstants.AUTH_ERROR, apiResponseError);
        setResult(0, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void screenRecordingCheck() {
        if (PaytmSDK.isRecordingDisable()) {
            getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
    }
}
