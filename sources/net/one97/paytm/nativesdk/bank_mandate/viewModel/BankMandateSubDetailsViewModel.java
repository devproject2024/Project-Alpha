package net.one97.paytm.nativesdk.bank_mandate.viewModel;

import android.content.Context;
import android.text.Html;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;

public class BankMandateSubDetailsViewModel extends BaseViewModel {
    public i<String> acType = new i<>();
    public i<String> authText = new i<>();
    public i<String> bankAcNo = new i<>();
    public i<String> custName = new i<>();
    private final String debitCard = SDKConstants.DEBIT;
    public ObservableInt deductedTextVisibility = new ObservableInt(0);
    public i<String> expiryDate = new i<>();
    public i<String> frequency = new i<>();
    public i<String> ifscCode = new i<>();
    private Context mContext;
    public ObservableInt mLogoVisibility = new ObservableInt(8);
    public ObservableInt mNameVisibility = new ObservableInt(8);
    public i<String> maxAmount = new i<>();
    public i<String> merchantName = new i<>();
    private final String netBanking = "NET_BANKING";
    public i<String> payText = new i<>();
    public i<String> purpose = new i<>();
    public i<String> startDate = new i<>();
    private SubscriptionDetailsInfo subscriptionDetailsInfo;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public BankMandateSubDetailsViewModel(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        super(context, (BaseViewActions) null);
        this.mContext = context;
        try {
            if (DirectPaymentBL.getInstance().getCjPayMethodResponse() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getSubscriptionDetailsInfo() != null) {
                this.subscriptionDetailsInfo = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getSubscriptionDetailsInfo();
                setSubscriptionDetailsData(str, str2, str3, str4, str5, str6);
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    private void setSubscriptionDetailsData(String str, String str2, String str3, String str4, String str5, String str6) {
        this.custName.set(str);
        i<String> iVar = this.bankAcNo;
        iVar.set(str2 + " " + getMaskedNumber(str3));
        i<String> iVar2 = this.ifscCode;
        iVar2.set(this.mContext.getResources().getString(R.string.ifsc_code_text) + AppConstants.COLON + str4);
        if (str5.equals("SAVINGS")) {
            this.acType.set(this.mContext.getResources().getString(R.string.savings_ac_text));
        } else {
            this.acType.set(str5);
        }
        this.frequency.set(this.subscriptionDetailsInfo.getSubsfrequency());
        this.maxAmount.set(this.mContext.getResources().getString(R.string.native_emi_per_month, new Object[]{SDKUtility.priceWithoutDecimal(this.subscriptionDetailsInfo.getMaxAmount())}));
        if (SDKUtility.priceWithoutDecimal(MerchantBL.getMerchantInstance().getWithoutDoubleAmount()).equals("0")) {
            this.payText.set("");
            this.deductedTextVisibility.set(8);
        } else {
            this.payText.set(Html.fromHtml(this.mContext.getString(R.string.nativesdk_amount_pay, new Object[]{SDKUtility.priceWithoutDecimal(MerchantBL.getMerchantInstance().getWithoutDoubleAmount())})).toString());
            this.deductedTextVisibility.set(0);
        }
        this.startDate.set(SDKUtility.formatDateIntoDateMonthYear(this.subscriptionDetailsInfo.getStartDate()));
        this.expiryDate.set(SDKUtility.formatDateIntoDateMonthYear(this.subscriptionDetailsInfo.getEndDate()));
        this.purpose.set(this.subscriptionDetailsInfo.getSubscriptionPurpose());
        if (str6.equals("NET_BANKING")) {
            this.authText.set(this.mContext.getResources().getString(R.string.net_banking_auth_text));
        } else if (str6.equals(SDKConstants.DEBIT)) {
            this.authText.set(this.mContext.getResources().getString(R.string.debit_card_auth_text));
        }
    }

    private String getMaskedNumber(String str) {
        if (str.length() <= 4 || str.length() <= 4) {
            return str;
        }
        return "XX " + str.substring(str.length() - 4);
    }
}
