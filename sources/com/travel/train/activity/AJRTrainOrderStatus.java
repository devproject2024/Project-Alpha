package com.travel.train.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.cdn.ResourceUtils;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRCancelRequest;
import com.travel.train.model.trainticket.CJRIRCTCRedirect;
import com.travel.train.model.trainticket.CJRTrainOrderStatus;
import com.travel.utils.n;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRTrainOrderStatus extends CJRTrainBaseActivity implements b {
    private String LOG_TAG = "AJRTrainOrderStatus";
    private ImageView irctcLogo;
    private int iretry_count = 1;
    private CJRIRCTCRedirect mIRCTCRedirect;
    private String mOrderID;
    private ProgressBar mProgressBar;
    private int mRetryCount = 3;
    private String mTransactionId;
    private ProgressDialog progressBar;
    private TextView progressTxt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_bookin_confirmation);
        getSupportActionBar().b(true);
        getSupportActionBar();
        getSupportActionBar().c(R.drawable.pre_t_no_home);
        getSupportActionBar().b(R.drawable.pre_t_no_home);
        getSupportActionBar().d(R.string.train_confirmation);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar_payment_confirmation);
        this.progressTxt = (TextView) findViewById(R.id.progress_txt);
        this.irctcLogo = (ImageView) findViewById(R.id.irctc_logo);
        ResourceUtils.loadTrainImagesFromCDN(this.irctcLogo, "irctc_logo_1.png", false, false, n.a.V1);
        com.travel.train.b.a();
        int i2 = com.travel.train.b.b().i();
        if (i2 > 0) {
            this.mRetryCount = i2;
        }
        getDetailsFromIntent();
        checkPGStatus();
        setServerMessage();
    }

    private void getDetailsFromIntent() {
        this.mOrderID = getIntent().getStringExtra("order_id");
        this.mTransactionId = (String) getIntent().getSerializableExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID);
    }

    /* access modifiers changed from: private */
    public void checkPGStatus() {
        StringBuilder sb = new StringBuilder();
        com.travel.train.b.a();
        sb.append(com.travel.train.b.b().b());
        sb.append(this.mTransactionId);
        String sb2 = sb.toString();
        if (URLUtil.isValidUrl(sb2)) {
            String b2 = o.b((Context) this, com.paytm.utility.b.s(this, sb2));
            if (com.paytm.utility.b.c((Context) this)) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.f42878b = a.c.TRAIN;
                bVar.n = a.b.SILENT;
                bVar.o = g.k;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = b2;
                bVar.f42882f = com.travel.train.j.n.b((Context) this);
                bVar.f42885i = new CJRTrainOrderStatus();
                bVar.j = this;
                a l = bVar.l();
                l.f42859c = false;
                l.a();
                return;
            }
            showSearchApiNetworkDialog();
        }
    }

    private void showSearchApiNetworkDialog() {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet_train));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    AJRTrainOrderStatus.this.checkPGStatus();
                }
            });
            builder.show();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRTrainOrderStatus) {
                CJRTrainOrderStatus cJRTrainOrderStatus = (CJRTrainOrderStatus) iJRPaytmDataModel;
                if (cJRTrainOrderStatus.getOrderStatusBody() != null && cJRTrainOrderStatus.getOrderStatusBody().f27718a != null && cJRTrainOrderStatus.getOrderStatusBody().f27718a.f27717a != null) {
                    if (cJRTrainOrderStatus.getOrderStatusBody().f27718a.f27717a.equalsIgnoreCase("SUCCESS") && cJRTrainOrderStatus.getOrderStatusBody().f27719b != null) {
                        Intent intent = new Intent(this, AJRTrainLoginActivity.class);
                        intent.putExtra("irctc_redirect", cJRTrainOrderStatus.getOrderStatusBody().f27719b);
                        intent.putExtra("order_id", this.mOrderID);
                        intent.putExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.mTransactionId);
                        this.mIRCTCRedirect = cJRTrainOrderStatus.getOrderStatusBody().f27719b;
                        startActivity(intent);
                        finish();
                    } else if (cJRTrainOrderStatus.getOrderStatusBody().f27718a.f27717a.equalsIgnoreCase("FAILED") || cJRTrainOrderStatus.getOrderStatusBody().f27718a.f27717a.equalsIgnoreCase("PROCESSING") || cJRTrainOrderStatus.getOrderStatusBody().f27718a.f27717a.equalsIgnoreCase("PENDING")) {
                        this.iretry_count++;
                        if (this.iretry_count <= this.mRetryCount) {
                            try {
                                Thread.sleep(10000);
                                checkPGStatus();
                            } catch (Exception unused) {
                            }
                        } else {
                            callCancelRequest("?paymentPending=Y");
                        }
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRCancelRequest) {
                if (this.progressBar.isShowing()) {
                    this.progressBar.dismiss();
                }
                launchOrderList();
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ProgressDialog progressDialog = this.progressBar;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.progressBar.dismiss();
        }
        launchOrderList();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        displayCancelDialog();
    }

    private void displayCancelDialog() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.train_cancel_transaction));
            builder.setMessage(getResources().getString(R.string.train_cancel_transaction_message));
            builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    AJRTrainOrderStatus.this.callCancelRequest("?backButton=Y");
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void callCancelRequest(String str) {
        if (!isFinishing()) {
            if (this.mTransactionId != null) {
                com.travel.train.b.a();
                String str2 = com.travel.train.b.b().p() + "/" + this.mTransactionId + str;
                if (URLUtil.isValidUrl(str2)) {
                    String b2 = o.b((Context) this, com.paytm.utility.b.s(this, str2));
                    if (com.paytm.utility.b.c((Context) this)) {
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = this;
                        bVar.f42878b = a.c.TRAIN;
                        bVar.n = a.b.SILENT;
                        bVar.o = g.k;
                        bVar.f42879c = a.C0715a.GET;
                        bVar.f42880d = b2;
                        bVar.f42882f = com.travel.train.j.n.b((Context) this);
                        bVar.f42885i = new CJRCancelRequest();
                        bVar.j = this;
                        a l = bVar.l();
                        l.f42859c = false;
                        l.a();
                        if (!isFinishing()) {
                            this.progressBar = ProgressDialog.show(this, getResources().getString(R.string.please_wait_progress_msg), getResources().getString(R.string.train_cancelling_request));
                            return;
                        }
                        return;
                    }
                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet_train));
                    return;
                }
                return;
            }
            Intent a2 = o.a((Context) this);
            a2.putExtra(UpiConstants.FROM, "Payment");
            a2.putExtra("order_id", this.mOrderID);
            a2.putExtra(AppConstants.IS_CANCEL, false);
            startActivity(a2);
            finish();
        }
    }

    private void launchOrderList() {
        Intent a2 = o.a((Context) this);
        a2.putExtra(UpiConstants.FROM, "Payment");
        a2.putExtra("order_id", this.mOrderID);
        a2.putExtra(AppConstants.IS_CANCEL, false);
        startActivity(a2);
        finish();
    }

    private void setServerMessage() {
        if (g.f27551a != null && !TextUtils.isEmpty(g.f27551a.getVerifyPaymentTrainMessage())) {
            this.progressTxt.setText(g.f27551a.getVerifyPaymentTrainMessage());
        }
    }
}
