package net.one97.paytm.nativesdk.emiSubvention.views;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.adapters.FetchEmiPlanAdapter;
import net.one97.paytm.nativesdk.emiSubvention.models.EmiPlan;
import net.one97.paytm.nativesdk.emiSubvention.models.EmiValidatePlan;
import net.one97.paytm.nativesdk.emiSubvention.models.FetchPlanModel;
import net.one97.paytm.nativesdk.emiSubvention.models.Gratifications;
import net.one97.paytm.nativesdk.emiSubvention.models.PlanDetail;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.orflow.promo.view.BaseMallPromoActivity;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.json.JSONArray;
import org.json.JSONException;

public class EMIPlanActivity extends BaseMallPromoActivity implements ITenureClickHandler {
    private String andOffers;
    private FetchPlanModel emiTenure;
    private RecyclerView emiplanRecyclerview;
    private String fromView;
    /* access modifiers changed from: private */
    public boolean isFromOrFlow;
    private EmiPlan list;
    private Toolbar mToolbar;
    private ArrayList<PaymentIntent> paymentIntent;
    private List<PlanDetail> planDetail;
    /* access modifiers changed from: private */
    public String planId;
    /* access modifiers changed from: private */
    public Double planInterval = Double.valueOf(0.0d);
    private Button proceedButton;
    /* access modifiers changed from: private */
    public String response;
    private LinearLayout rootView;
    private int selectedItem = 0;
    private String selectedPlanId;
    private LinearLayout showDetail;
    private String title;
    private TextView totalPricetxt;

    public Context getContext() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_emiplan_screen);
        setStausBar();
        init();
        setupData();
        setupToolbar(this.mToolbar, this.title);
        setRecyclerview();
        this.proceedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EMIPlanActivity.this.handleOnClick();
            }
        });
        this.showDetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TextUtils.isEmpty(EMIPlanActivity.this.planId) && EMIPlanActivity.this.planInterval != null) {
                    EMIPlanActivity.this.handleGA("item_level_breakup_clicked");
                    EMIPlanActivity.this.handleGA("item_level_breakup_popup_loaded");
                    EMIPlanActivity eMIPlanActivity = EMIPlanActivity.this;
                    EmiUtil.showBottomSheet(eMIPlanActivity, eMIPlanActivity.response, EMIPlanActivity.this.planInterval, EMIPlanActivity.this.planId);
                }
            }
        });
        if (getIntent() != null) {
            this.fromView = getIntent().getStringExtra(EMIConstants.FROM_VIEW);
        }
        String str = this.fromView;
        if (str == null) {
            str = "";
        }
        this.fromView = str;
        SDKUtility.sendGaEvents(new HashMap<String, Object>() {
            {
                put("event_category", "emi");
                put("event_action", "emi_available_clicked");
                put(SDKConstants.EVENT_KEY_SCREEN_NAME, "emi-plans");
                put("vertical_name", "emi");
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleGA(final String str) {
        SDKUtility.sendGaEvents(new HashMap<String, Object>() {
            {
                put("event_category", "emi");
                put("event_action", str);
                put("event_label2", EMIPlanActivity.this.isFromOrFlow ? "bank offer checkout" : "normal checkout");
                put("vertical_name", "emi");
            }
        });
    }

    private void setStausBar() {
        if (Build.VERSION.SDK_INT >= 23 && getWindow() != null) {
            getWindow().getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            getWindow().setStatusBarColor(-1);
        }
    }

    private void init() {
        this.mToolbar = (Toolbar) findViewById(R.id.emiplanToolbar);
        this.emiplanRecyclerview = (RecyclerView) findViewById(R.id.emiplanRecyclerview);
        this.totalPricetxt = (TextView) findViewById(R.id.PlantotalPrice);
        this.proceedButton = (Button) findViewById(R.id.proceedButton);
        this.showDetail = (LinearLayout) findViewById(R.id.showOrderDetailImg);
        this.rootView = (LinearLayout) findViewById(R.id.tncLayout);
    }

    private void setupData() {
        String str;
        List<PlanDetail> list2 = null;
        if (getIntent() != null) {
            this.response = getIntent().getStringExtra(EMIConstants.TENTURE_RESPONSE);
            str = getIntent().getStringExtra(EMIConstants.TOTAL_PRICE);
            this.andOffers = getIntent().getStringExtra(EMIConstants.AND_OFFERS);
            this.selectedPlanId = getIntent().getStringExtra(EMIConstants.SELECTED_PLAN_ID);
            this.isFromOrFlow = getIntent().getBooleanExtra(EMIConstants.IS_OR_FLOW, false);
        } else {
            str = null;
        }
        if (this.response != null) {
            this.emiTenure = (FetchPlanModel) new f().a(this.response, FetchPlanModel.class);
        }
        FetchPlanModel fetchPlanModel = this.emiTenure;
        this.list = fetchPlanModel != null ? fetchPlanModel.getEmiPlans() : null;
        EmiPlan emiPlan = this.list;
        if (emiPlan != null) {
            list2 = emiPlan.getDetails();
        }
        this.planDetail = list2;
        try {
            this.paymentIntent = (ArrayList) getIntent().getSerializableExtra(EMIConstants.PAYMENT_INTENT);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
        setTitleandHeader(str);
        setSelectedPosition(this.selectedPlanId);
        setTermsandConditions();
    }

    private void setTermsandConditions() {
        if (DirectPaymentBL.getInstance() == null || DirectPaymentBL.getInstance().getGtmStringValues() == null) {
            TextView textView = new TextView(this);
            textView.setText(R.string.bullted_list);
            textView.setTextColor(b.c(this, R.color.emiHeadingColor));
            this.rootView.addView(textView);
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray((String) DirectPaymentBL.getInstance().getGtmStringValues().get("emi_tenures_info"));
            String[] strArr = new String[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                strArr[i2] = jSONArray.getString(i2);
            }
            if (strArr.length > 0) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = getLayoutInflater().inflate(R.layout.bullet_text_view, (ViewGroup) null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.text);
                        textView2.setLayoutParams(layoutParams);
                        textView2.setText(str);
                        this.rootView.addView(inflate);
                    }
                }
            }
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    private void setTitleandHeader(String str) {
        EmiPlan emiPlan = this.list;
        if (emiPlan != null) {
            this.title = emiPlan.getBankName();
        }
        if (!TextUtils.isEmpty(str)) {
            TextView textView = this.totalPricetxt;
            textView.setText(getString(R.string.rupee_symbol) + str);
        }
    }

    private void setRecyclerview() {
        setGratification();
        FetchEmiPlanAdapter fetchEmiPlanAdapter = new FetchEmiPlanAdapter(this, this.list, this.selectedItem);
        this.emiplanRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        this.emiplanRecyclerview.setAdapter(fetchEmiPlanAdapter);
    }

    private void setGratification() {
        List<PlanDetail> list2 = this.planDetail;
        if (list2 != null && list2.size() > 0) {
            for (int i2 = 0; i2 < this.list.getDetails().size(); i2++) {
                this.list.getDetails().get(i2).setGratificationCashBack(this);
            }
        }
    }

    public void setSelectedPlan(int i2) {
        if (i2 >= 0 && i2 < this.planDetail.size() && i2 < this.list.getDetails().size()) {
            this.selectedItem = i2;
            List<PlanDetail> list2 = this.planDetail;
            if (list2 != null && list2.size() > 0 && this.planDetail.get(i2) != null) {
                this.planId = this.list.getDetails().get(i2).getPlanId();
                this.planInterval = this.list.getDetails().get(i2).getInterval();
            }
        }
    }

    public void handleOnClick() {
        List<PlanDetail> list2 = this.planDetail;
        String planId2 = list2 != null ? list2.get(this.selectedItem).getPlanId() : "";
        showVerifyLoader();
        EmiUtil.validateEMIPlan(this.response, planId2, this.paymentIntent, new ISubventionProvider.IBankValidator() {
            public void onBankSuccessResponse(String str, String str2, String str3) {
                EMIPlanActivity.this.handleSuccess(str, str2, str3);
            }

            public void onBankError(String str, String str2) {
                EMIPlanActivity.this.hideVerifyLoader();
                EmiUtil.showErrorPopup(EMIPlanActivity.this, str, str2);
            }

            public void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                EMIPlanActivity.this.hideVerifyLoader();
                if (EmiUtil.isAuthError(apiResponseError)) {
                    EMIPlanActivity.this.handleAuthError(apiResponseError);
                } else {
                    EmiUtil.showErrorPopup(EMIPlanActivity.this, apiResponseError.getErrorTitle(), apiResponseError.getErrorMsg());
                }
            }
        }, this.andOffers);
        SDKUtility.sendGaEvents(new HashMap<String, Object>() {
            {
                put("event_category", "emi");
                put("event_action", "emi_plan_proceed_clicked");
                put("event_label", EMIPlanActivity.this.planInterval);
                put("event_label2", EMIPlanActivity.this.isFromOrFlow ? "bank offer checkout" : "normal checkout");
                put("vertical_name", "emi");
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleSuccess(String str, String str2, String str3) {
        hideVerifyLoader();
        Intent intent = new Intent();
        intent.putExtra(EMIConstants.VALIDATED_DATA, str);
        intent.putExtra(EMIConstants.FINAL_PRICE, str3);
        intent.putExtra(EMIConstants.EFFECTIVE_PRICE, getEffective());
        if (str2 != null) {
            FetchPlanModel fetchPlanModel = (FetchPlanModel) new f().a(str2, FetchPlanModel.class);
            if (fetchPlanModel != null) {
                EmiValidatePlan emiValidatePlans = fetchPlanModel.getEmiValidatePlans();
                if (emiValidatePlans != null) {
                    intent.putExtra(EMIConstants.VALIDATED_RESPONSE, emiValidatePlans);
                    intent.putExtra(EMIConstants.FROM_VIEW, this.fromView);
                    intent.putExtra(EMIConstants.OFFER_MSG, getEmiOfferMsg());
                    setResult(-1, intent);
                    finish();
                    return;
                }
                showToast();
                return;
            }
            showToast();
            return;
        }
        showToast();
    }

    public String getEffective() {
        List<PlanDetail> list2 = this.planDetail;
        if (list2 == null || list2.size() <= 0) {
            return "";
        }
        if (this.planDetail.get(this.selectedItem) != null) {
            return String.valueOf(this.planDetail.get(this.selectedItem).getEffectivePrice());
        }
        return null;
    }

    private String getEmiOfferMsg() {
        int i2;
        List<PlanDetail> list2 = this.planDetail;
        if (list2 == null || list2.isEmpty() || (i2 = this.selectedItem) < 0 || i2 >= this.planDetail.size() || this.planDetail.get(this.selectedItem) == null || this.planDetail.get(this.selectedItem).getGratifications() == null || this.planDetail.get(this.selectedItem).getGratifications().isEmpty()) {
            return "";
        }
        List<Gratifications> gratifications = this.planDetail.get(this.selectedItem).getGratifications();
        StringBuilder sb = new StringBuilder();
        sb.append("EMI offer of ");
        if (gratifications != null && gratifications.size() > 0) {
            for (int i3 = 0; i3 < gratifications.size(); i3++) {
                if (gratifications.get(i3) != null) {
                    String label = gratifications.get(i3).getLabel();
                    int intValue = gratifications.get(i3).getValue().intValue();
                    sb.append("₹ ");
                    sb.append(intValue);
                    sb.append(" ");
                    sb.append(label);
                    if (i3 != gratifications.size() - 1 && !TextUtils.isEmpty(sb)) {
                        sb.append(" and ");
                    }
                }
            }
            sb.append(" successfully applied");
        }
        return sb.toString();
    }

    private void showToast() {
        Toast.makeText(getContext(), "Validation Failed. Please try again.", 1).show();
    }

    public void showBottomSheet(Context context, int i2) {
        String str;
        List<PlanDetail> list2 = this.planDetail;
        Double d2 = null;
        if (list2 == null || list2.size() <= 0) {
            str = null;
        } else {
            d2 = this.planDetail.get(i2).getInterval();
            str = this.planDetail.get(i2).getPlanId();
        }
        handleGA("item_level_breakup_clicked");
        handleGA("item_level_breakup_popup_loaded");
        EmiUtil.showBottomSheet(context, this.response, d2, str);
    }

    private void setSelectedPosition(String str) {
        if (this.planDetail != null) {
            int i2 = 0;
            while (i2 < this.planDetail.size()) {
                if (TextUtils.isEmpty(str) || !isSelectedPlanEqual(str, i2)) {
                    i2++;
                } else {
                    setSelectedPlan(i2);
                    return;
                }
            }
            setSelectedPlan(0);
        }
    }

    private boolean isSelectedPlanEqual(String str, int i2) {
        if (this.planDetail.get(i2) == null || TextUtils.isEmpty(this.planDetail.get(i2).getPlanId()) || !this.planDetail.get(i2).getPlanId().equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
