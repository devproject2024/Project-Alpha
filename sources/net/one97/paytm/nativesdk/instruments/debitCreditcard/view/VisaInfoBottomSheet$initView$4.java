package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.WebViewActivity;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;

final class VisaInfoBottomSheet$initView$4 implements View.OnClickListener {
    final /* synthetic */ VisaInfoBottomSheet this$0;

    VisaInfoBottomSheet$initView$4(VisaInfoBottomSheet visaInfoBottomSheet) {
        this.this$0 = visaInfoBottomSheet;
    }

    public final void onClick(View view) {
        SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_TNC_CLICKED, VisaInfoBottomSheet.access$getFlowType$p(this.this$0), VisaInfoBottomSheet.access$getCardType$p(this.this$0)));
        if (SDKUtility.isNetworkAvailable(this.this$0.getContext())) {
            Intent intent = new Intent(this.this$0.getContext(), WebViewActivity.class);
            intent.putExtra(Constants.WEB_URL, SDKConstants.VISA_TNC_URL);
            intent.putExtra("show_cross_button", true);
            intent.putExtra(WebViewActivity.ENABLE_WEB_SETTINGS, false);
            Context context = this.this$0.getContext();
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        Context context2 = this.this$0.getContext();
        Context context3 = this.this$0.getContext();
        Toast.makeText(context2, context3 != null ? context3.getString(R.string.no_internet) : null, 0).show();
    }
}
