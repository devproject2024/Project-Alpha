package com.business.merchant_payments.reports;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import com.business.common_module.events.e;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.i;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.common.viewmodel.BaseViewModel;
import com.business.merchant_payments.model.reportsmodel.DownloadsListModel;
import com.business.merchant_payments.utility.NetworkService;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportsApiCallViewModel extends BaseViewModel {
    public String email;
    public boolean isErrorResponse = true;

    public void setEmail(String str) {
        this.email = str;
    }

    public ReportsApiCallViewModel() {
        new DownloadsListModel();
        new ArrayList();
    }

    public void initiateDownload(final View view, String str, String str2, String str3, String str4) {
        String str5;
        RequestBody requestBody;
        String str6 = "";
        if (APSharedPreferences.getInstance().isMerchantMigrated()) {
            initiateDownloadV2(view, str2, str3, str4);
            return;
        }
        char c2 = 65535;
        int hashCode = str4.hashCode();
        if (hashCode != 115306) {
            if (hashCode == 1985943673 && str4.equals("settled")) {
                c2 = 1;
            }
        } else if (str4.equals(AppConstants.TRANSACTION)) {
            c2 = 0;
        }
        if (c2 == 0) {
            str4 = AppConstants.TRANSACTION;
        } else if (c2 == 1) {
            str4 = "settlement";
        }
        try {
            str5 = APSharedPreferences.getInstance().getMerchantEmail();
        } catch (NullPointerException e2) {
            LogUtility.e("Email Null in Download", String.valueOf(e2));
            str5 = str6;
        }
        String str7 = !TextUtils.isEmpty(str2) ? str2.split(" ")[0] : str6;
        if (!TextUtils.isEmpty(str3)) {
            str6 = str3.split(" ")[0];
        }
        if (PaymentsConfig.getInstance().getMerchantDataProvider().q()) {
            str7 = DateUtility.getFormattedDate(str7, "dd/MM/yyyy", "MM/dd/yyyy");
            str6 = DateUtility.getFormattedDate(str6, "dd/MM/yyyy", "MM/dd/yyyy");
        }
        if (i.a(PaymentsConfig.getInstance().getApplication())) {
            NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();
            String iniateReportAPI = GTMDataProviderImpl.Companion.getMInstance().getIniateReportAPI();
            if (URLUtil.isValidUrl(iniateReportAPI) && (requestBody = RequestParamUtil.getRequestBody(getBody(str5, str6, str7))) != null) {
                showDownlaodStatementSnackBar(view, getContext().getResources().getString(R.string.mp_Download_initiated_toast), false);
                networkService.initiateReportDownload(iniateReportAPI + str4 + "/download", RequestParamUtil.getRequestHeaderMidParam(PaymentsConfig.getInstance().getAppContext()), requestBody).enqueue(new Callback<ResponseBody>() {
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() != 200) {
                            ReportsApiCallViewModel.this.handleErrorCondition(response);
                            ReportsApiCallViewModel reportsApiCallViewModel = ReportsApiCallViewModel.this;
                            reportsApiCallViewModel.showDownlaodStatementSnackBar(view, reportsApiCallViewModel.getContext().getResources().getString(R.string.mp_error_download_statement), false);
                        }
                    }

                    public void onFailure(Call<ResponseBody> call, Throwable th) {
                        ReportsApiCallViewModel reportsApiCallViewModel = ReportsApiCallViewModel.this;
                        reportsApiCallViewModel.showDownlaodStatementSnackBar(view, reportsApiCallViewModel.getContext().getResources().getString(R.string.mp_error_download_statement), false);
                    }
                });
                return;
            }
            return;
        }
        showDownlaodStatementSnackBar(view, getContext().getResources().getString(R.string.mp_no_internet_connection), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007c, code lost:
        if (r11.equals(com.business.merchant_payments.common.utility.AppConstants.TRANSACTION) != false) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initiateDownloadV2(final android.view.View r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            com.business.merchant_payments.PaymentsConfig r0 = com.business.merchant_payments.PaymentsConfig.getInstance()
            android.app.Application r0 = r0.getApplication()
            boolean r0 = com.business.common_module.utilities.i.a((android.app.Application) r0)
            r1 = 0
            if (r0 != 0) goto L_0x0021
            android.content.Context r9 = r7.getContext()
            android.content.res.Resources r9 = r9.getResources()
            int r10 = com.business.merchant_payments.R.string.mp_no_internet_connection
            java.lang.String r9 = r9.getString(r10)
            r7.showDownlaodStatementSnackBar(r8, r9, r1)
            return
        L_0x0021:
            com.business.merchant_payments.common.utility.APSharedPreferences r0 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()     // Catch:{ NullPointerException -> 0x0029 }
            r0.getMerchantEmail()     // Catch:{ NullPointerException -> 0x0029 }
            goto L_0x0033
        L_0x0029:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Email Null in Download"
            com.business.common_module.utilities.LogUtility.e(r2, r0)
        L_0x0033:
            com.business.merchant_payments.PaymentsConfig r0 = com.business.merchant_payments.PaymentsConfig.getInstance()
            android.app.Application r0 = r0.getApplication()
            boolean r0 = com.business.common_module.utilities.i.a((android.app.Application) r0)
            if (r0 == 0) goto L_0x00fd
            com.business.merchant_payments.PaymentsConfig r0 = com.business.merchant_payments.PaymentsConfig.getInstance()
            com.business.merchant_payments.utility.NetworkService r0 = r0.getNetworkService()
            r2 = -1
            int r3 = r11.hashCode()
            r4 = 115306(0x1c26a, float:1.61578E-40)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L_0x0075
            r1 = 73828649(0x4668929, float:2.7099351E-36)
            if (r3 == r1) goto L_0x006a
            r1 = 1985943673(0x765f1879, float:1.1312291E33)
            if (r3 != r1) goto L_0x007f
            java.lang.String r1 = "settled"
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x007f
            r1 = 1
            goto L_0x0080
        L_0x006a:
            java.lang.String r1 = "settlement"
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x007f
            r1 = 2
            goto L_0x0080
        L_0x0075:
            java.lang.String r3 = "txn"
            boolean r11 = r11.equals(r3)
            if (r11 == 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r1 = -1
        L_0x0080:
            if (r1 == 0) goto L_0x00c6
            if (r1 == r6) goto L_0x0086
            if (r1 != r5) goto L_0x00fd
        L_0x0086:
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r11 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r11 = r11.getMInstance()
            java.lang.String r11 = r11.getUMPBaseUrl()
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r1 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r1 = r1.getMInstance()
            java.lang.String r1 = r1.getSettlementV2Download()
            com.business.merchant_payments.reports.ReportsApiCallViewModel$3 r2 = new com.business.merchant_payments.reports.ReportsApiCallViewModel$3
            r2.<init>(r8)
            java.lang.String r8 = r7.getSettlementBodyParams(r9, r10)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r11)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.business.merchant_payments.PaymentsConfig r10 = com.business.merchant_payments.PaymentsConfig.getInstance()
            android.content.Context r10 = r10.getAppContext()
            java.util.HashMap r10 = com.business.merchant_payments.common.utility.RequestParamUtil.getRequestHeaderMidParam(r10)
            retrofit2.Call r8 = r0.downloadSettlement(r9, r10, r8)
            r8.enqueue(r2)
            return
        L_0x00c6:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r1 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r1 = r1.getMInstance()
            java.lang.String r1 = r1.getV2OrderList()
            r11.append(r1)
            java.lang.String r1 = "/download"
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            com.business.merchant_payments.reports.ReportsApiCallViewModel$2 r1 = new com.business.merchant_payments.reports.ReportsApiCallViewModel$2
            r1.<init>(r8)
            com.business.merchant_payments.PaymentsConfig r8 = com.business.merchant_payments.PaymentsConfig.getInstance()
            android.content.Context r8 = r8.getAppContext()
            java.util.HashMap r8 = com.business.merchant_payments.common.utility.RequestParamUtil.getRequestHeaderMidParam(r8)
            java.lang.String r9 = r7.getV2PaymentBodyParams(r10, r9)
            retrofit2.Call r8 = r0.downloadPaymentReport(r11, r8, r9)
            r8.enqueue(r1)
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.reports.ReportsApiCallViewModel.initiateDownloadV2(android.view.View, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public String getV2PaymentBodyParams(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("SUCCESS");
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(TransactionType.ACQUIRING);
        String formattedDate = DateUtility.getFormattedDate(str, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
        String formattedDate2 = DateUtility.getFormattedDate(str2, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
        try {
            jSONObject.put("orderCreatedEndTime", formattedDate);
            jSONObject.put("orderCreatedStartTime", formattedDate2);
            jSONObject.put("downloadSource", "UMP");
            jSONObject.put("orderStatusList", jSONArray);
            jSONObject.put("bizTypeList", jSONArray2);
        } catch (JSONException e2) {
            LogUtility.d("v2Payment_exception", "==>" + e2.toString());
        }
        return jSONObject.toString();
    }

    private String getSettlementBodyParams(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reportType", "BILL_TXN_REPORT");
            jSONObject.put("endDate", DateUtility.getFormattedDate(str2, "dd/MM/yyyy", "yyyy-MM-dd").replace("-", ""));
            jSONObject.put("startDate", DateUtility.getFormattedDate(str, "dd/MM/yyyy", "yyyy-MM-dd").replace("-", ""));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String getBody(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AppConstants.KEY_EMAIL, str);
            jSONObject.put("end", str2);
            jSONObject.put("start", str3);
            jSONObject.put("limit", "100");
            if (str != null) {
                jSONObject.put(AppConstants.KEY_EMAIL, str);
                jSONObject.put("sendToEmail", true);
            } else {
                jSONObject.put("sendToEmail", true);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    public void showDownlaodStatementSnackBar(View view, String str, boolean z) {
        try {
            Snackbar a2 = Snackbar.a(view.getRootView().findViewById(R.id.coordinatorLayout), (CharSequence) str, 0);
            a2.f36659d = 4000;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.mp_custom_snackbar_view, (ViewGroup) null);
            ((CustomTextView) inflate.findViewById(R.id.description_sb_tv)).setText(getContext().getString(R.string.mp_download_pymt_stmt));
            ((CustomTextView) inflate.findViewById(R.id.description_sb_tv)).setTextColor(getContext().getResources().getColor(R.color.white));
            inflate.findViewById(R.id.description_sb_tv).setBackgroundColor(getContext().getResources().getColor(R.color.download_statement_snackbar_bg));
            inflate.findViewById(R.id.sb_view_ll).setBackgroundColor(getContext().getResources().getColor(R.color.download_statement_snackbar_bg));
            if (z) {
                ((CustomTextView) inflate.findViewById(R.id.title_sb_tv)).setText(str);
                ((CustomTextView) inflate.findViewById(R.id.description_sb_tv)).setVisibility(8);
            } else {
                ((CustomTextView) inflate.findViewById(R.id.title_sb_tv)).setText(getContext().getString(R.string.mp_download_in_progress));
            }
            inflate.findViewById(R.id.title_sb_tv).setBackgroundColor(getContext().getResources().getColor(R.color.download_statement_snackbar_bg));
            ((CustomTextView) inflate.findViewById(R.id.title_sb_tv)).setTextColor(getContext().getResources().getColor(R.color.white));
            a2.b().setPadding(0, 0, 0, 0);
            ((ViewGroup) a2.b()).removeAllViews();
            ((ViewGroup) a2.b()).addView(inflate);
            a2.c();
        } catch (Exception e2) {
            LogUtility.e("Snackbar exception", e2.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: private */
    public void handleErrorCondition(Response<?> response) {
        if (this.isErrorResponse) {
            this.isErrorResponse = false;
            if (response.code() == 400) {
                String parseError = ErrorUtil.parseError(response);
                if (!TextUtils.isEmpty(parseError) && parseError.equalsIgnoreCase(AppConstants.INVALID_TOKEN)) {
                    c.a().c(new e(AppConstants.HOME_HELP_SCREEN));
                }
            }
        }
    }
}
