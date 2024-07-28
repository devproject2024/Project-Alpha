package net.one97.paytm.nativesdk.transcation.viewmodel;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.i;
import com.business.merchant_payments.common.utility.AppUtility;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.transcation.listners.TranscationStatusListner;
import net.one97.paytm.nativesdk.transcation.view.TranscationStatus;
import org.json.JSONObject;

public class TranscationStatusViewmodel extends BaseViewModel {
    private String amount;
    public i<String> decimalAmount = new i<>();
    private TranscationStatusListner listner;
    private Context mContext;
    public i<String> rsAmount = new i<>();
    private String status;
    public i<String> transcationStatus = new i<>();

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public TranscationStatusViewmodel(Context context, String str, TranscationStatusListner transcationStatusListner) {
        super(context, (BaseViewActions) null);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mContext = context;
            this.amount = jSONObject.getString(SDKConstants.AI_TXN_AMOUNT);
            this.status = jSONObject.getString(SDKConstants.STATUS);
        } catch (Exception unused) {
            this.amount = MerchantBL.getMerchantInstance().getAmount();
            this.status = "invalid";
        }
        this.listner = transcationStatusListner;
        setAmountToView();
        setTranscationStatus();
    }

    private void setAmountToView() {
        if (this.amount.contains(AppUtility.CENTER_DOT)) {
            i<String> iVar = this.rsAmount;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mContext.getString(R.string.rupee_symbol));
            sb.append(" ");
            String str = this.amount;
            sb.append(str.substring(0, str.indexOf(AppUtility.CENTER_DOT)));
            iVar.set(sb.toString());
            i<String> iVar2 = this.decimalAmount;
            String str2 = this.amount;
            iVar2.set(str2.substring(str2.indexOf(AppUtility.CENTER_DOT), this.amount.length()));
            return;
        }
        i<String> iVar3 = this.rsAmount;
        iVar3.set(this.mContext.getString(R.string.rupee_symbol) + " " + this.amount);
        this.decimalAmount.set(".00");
    }

    private void setTranscationStatus() {
        if (this.status.equalsIgnoreCase(TranscationStatus.TXN_SUCCESS.name())) {
            this.transcationStatus.set(this.mContext.getString(R.string.paid_successfully));
            this.listner.onTranscationStatus(TranscationStatus.TXN_SUCCESS.getStatus());
        } else if (this.status.equalsIgnoreCase(TranscationStatus.TXN_FAILURE.name())) {
            this.transcationStatus.set(this.mContext.getString(R.string.failure));
            this.listner.onTranscationStatus(TranscationStatus.TXN_FAILURE.getStatus());
        } else if (this.status.equalsIgnoreCase(TranscationStatus.PENDING.name())) {
            this.transcationStatus.set(this.mContext.getString(R.string.pending));
            this.listner.onTranscationStatus(TranscationStatus.PENDING.getStatus());
        } else {
            this.transcationStatus.set(this.status);
            this.listner.onTranscationStatus(TranscationStatus.UNKNOWN.getStatus());
        }
    }
}
