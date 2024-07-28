package net.one97.paytm.nativesdk.emiSubvention.views;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.adapters.SelectBankAdapter;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.orflow.promo.view.BaseMallPromoActivity;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class SelectBankActivity extends BaseMallPromoActivity implements IBankDataProvider {
    private RecyclerView recyclerView;

    public Context getContext() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_select_bank);
        if (Build.VERSION.SDK_INT >= 23 && getWindow() != null) {
            getWindow().getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            getWindow().setStatusBarColor(getColor(R.color.emiheaderColor));
        }
        this.recyclerView = (RecyclerView) findViewById(R.id.rv_bank_list);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(new SelectBankAdapter(this, getBankData(getIntent())));
        setupToolbar((Toolbar) findViewById(R.id.emiToolbar), getString(R.string.select_a_bank));
        SDKUtility.sendGaEvents(new HashMap<String, Object>() {
            {
                put("event_category", "emi");
                put("event_action", "emi_available_clicked");
                put(SDKConstants.EVENT_KEY_SCREEN_NAME, "emi-bank-list");
                put("vertical_name", "emi");
            }
        });
    }

    private ArrayList<BankData> getBankData(Intent intent) {
        ArrayList<BankData> parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(EMIConstants.EMI_DATA) : null;
        if (parcelableArrayListExtra != null) {
            return parcelableArrayListExtra;
        }
        return new ArrayList<>();
    }

    public void handleOnClick(final BankData bankData) {
        if (bankData != null && bankData.isEnabled()) {
            showVerifyLoader();
            EmiUtil.fetchTenures(bankData, new ISubventionProvider.IBankTenureListener() {
                public void onBankError(String str, String str2) {
                    SelectBankActivity.this.handleFetchTenureError(str, str2, bankData);
                }

                public void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                    if (EmiUtil.isAuthError(apiResponseError)) {
                        SelectBankActivity.this.handleAuthError(apiResponseError);
                    } else {
                        SelectBankActivity.this.handleFetchTenureNetworkError(apiResponseError.getErrorTitle(), apiResponseError.getErrorMsg());
                    }
                }

                public void onBankSuccessResponse(String str) {
                    SelectBankActivity.this.handlefetchTenureSuccess(str, bankData);
                }
            }, (ArrayList<PaymentIntent>) null);
            SDKUtility.sendGaEvents(new HashMap<String, Object>() {
                {
                    put("event_category", "emi");
                    put("event_action", "bank_selected");
                    put("event_label", bankData.getBankName());
                    put("event_label2", SelectBankActivity.this.getBankType(bankData.getType()));
                    put(SDKConstants.EVENT_KEY_SCREEN_NAME, "emi-bank-list");
                    put("vertical_name", "emi");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public Object getBankType(String str) {
        return "SUBVENTION".equalsIgnoreCase(str) ? "Zero/Low Cost EMI" : "Standard EMI";
    }

    /* access modifiers changed from: private */
    public void handleFetchTenureNetworkError(String str, String str2) {
        showErrorPopup(str, str2);
    }

    /* access modifiers changed from: private */
    public void handleFetchTenureError(String str, String str2, BankData bankData) {
        showErrorPopup(str, str2);
        disableBank(bankData);
    }

    private void disableBank(BankData bankData) {
        bankData.setEnabled(false);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null && recyclerView2.getAdapter() != null) {
            this.recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    private void showErrorPopup(String str, String str2) {
        hideVerifyLoader();
        EmiUtil.showErrorPopup(this, str, str2);
    }

    /* access modifiers changed from: private */
    public void handlefetchTenureSuccess(String str, BankData bankData) {
        hideVerifyLoader();
        Intent intent = new Intent();
        intent.putExtra(EMIConstants.SELECTED_BANK, bankData);
        setResult(-1, intent);
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
