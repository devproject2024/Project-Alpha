package net.one97.paytm.wallet.newdesign.utils;

import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.p2mNewDesign.d.e;
import net.one97.paytm.upi.util.UpiConstants;

public final class P2MPostPaymentFragmentFactory {
    public static final P2MPostPaymentFragmentFactory INSTANCE = new P2MPostPaymentFragmentFactory();

    private P2MPostPaymentFragmentFactory() {
    }

    public final e getPostTxnFragment(Intent intent) {
        k.c(intent, "intent");
        Bundle argumentsFromIntent = getArgumentsFromIntent(intent);
        e eVar = new e();
        eVar.setArguments(argumentsFromIntent);
        return eVar;
    }

    private final Bundle getArgumentsFromIntent(Intent intent) {
        Bundle bundle = new Bundle();
        Serializable serializableExtra = intent.getSerializableExtra("bundle");
        if (!(serializableExtra instanceof IJRDataModel)) {
            serializableExtra = null;
        }
        bundle.putSerializable("data", (IJRDataModel) serializableExtra);
        bundle.putString("phone_no", intent.getStringExtra("phone_no"));
        bundle.putString("name", intent.getStringExtra("name"));
        bundle.putString("amount", intent.getStringExtra("amount"));
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, intent.getStringExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL));
        bundle.putString("paymentMode", intent.getStringExtra("paymentMode"));
        bundle.putBoolean("is_upi", intent.getBooleanExtra("is_upi", false));
        bundle.putBoolean("is_from_deeplink", intent.getBooleanExtra("is_from_deeplink", false));
        bundle.putBoolean("is_offline_pg", intent.getBooleanExtra("is_offline_pg", false));
        bundle.putBoolean("backpress_offline_pg", intent.getBooleanExtra("backpress_offline_pg", false));
        bundle.putString("merchant_logo", intent.getStringExtra("merchant_logo"));
        bundle.putBoolean("is_emi", intent.getBooleanExtra("is_emi", false));
        bundle.putString("emi_message", intent.getStringExtra("emi_message"));
        bundle.putBoolean("is_from_mobile_number", intent.getBooleanExtra("is_from_mobile_number", false));
        bundle.putBoolean("is_pcf", intent.getBooleanExtra("is_pcf", false));
        bundle.putDouble("pcf_amount", intent.getDoubleExtra("pcf_amount", 0.0d));
        bundle.putString("payee_vpa", intent.getStringExtra("payee_vpa"));
        bundle.putString(UpiConstants.EXTRA_PAYER_VPA, intent.getStringExtra(UpiConstants.EXTRA_PAYER_VPA));
        bundle.putBundle("sbBundle", intent.getExtras());
        bundle.putBoolean("is_static_qr_code", intent.getBooleanExtra("is_static_qr_code", false));
        bundle.putString("pay_mode", intent.getStringExtra("pay_mode"));
        bundle.putString("unique_identifier", intent.getStringExtra("unique_identifier"));
        bundle.putString("scan_result", intent.getStringExtra("scan_result"));
        bundle.putBoolean("is_link_based_payment", intent.getBooleanExtra("is_link_based_payment", false));
        bundle.putBoolean("isFromAppEvoke", intent.getBooleanExtra("is_from_app_evoke", false));
        bundle.putInt("launchFrom", intent.getIntExtra("launchFrom", e.C0905e.PAY.getType()));
        bundle.putString("pay_response", intent.getStringExtra("pay_response"));
        bundle.putBoolean("is_from_recent", intent.getBooleanExtra("is_from_recent", false));
        bundle.putBoolean("isAutoFlashTxn", intent.getBooleanExtra("isAutoFlashTxn", false));
        bundle.putBoolean("isSingleAPI", intent.getBooleanExtra("isSingleAPI", false));
        bundle.putBoolean("is_amt_already_present", intent.getBooleanExtra("is_amt_already_present", false));
        bundle.putString("qrScanTime", intent.getStringExtra("qrScanTime"));
        bundle.putString("suggestedInstrument", intent.getStringExtra("suggestedInstrument"));
        bundle.putString("page_load_time", intent.getStringExtra("pay_mode_load_time"));
        bundle.putString("page_load_type", intent.getStringExtra("pay_mode_type"));
        if (intent.getBooleanExtra("backpress_offline_pg", false)) {
            bundle.putString("order_id", intent.getStringExtra("order_id"));
            bundle.putString("mid", intent.getStringExtra("mid"));
        }
        return bundle;
    }

    public final net.one97.paytm.p2mNewDesign.d.e getMlvPostTxnFragment(Intent intent) {
        k.c(intent, "intent");
        Bundle bundle = new Bundle();
        net.one97.paytm.p2mNewDesign.d.e eVar = new net.one97.paytm.p2mNewDesign.d.e();
        bundle.putBoolean("isMLVEnabledPayment", true);
        bundle.putString("mlvOrderId", intent.getStringExtra("mlvOrderId"));
        bundle.putString("mlvMyOrdersAPIUrl", intent.getStringExtra("mlvMyOrdersAPIUrl"));
        bundle.putString("mlvMerchantName", intent.getStringExtra("mlvMerchantName"));
        bundle.putString("provider", intent.getStringExtra("provider"));
        bundle.putString("mlvAmount", intent.getStringExtra("mlvAmount"));
        bundle.putString("phone_no", intent.getStringExtra("phone_no"));
        bundle.putString("name", intent.getStringExtra("name"));
        bundle.putBoolean("is_pcf", intent.getBooleanExtra("is_pcf", false));
        bundle.putDouble("pcf_amount", intent.getDoubleExtra("pcf_amount", 0.0d));
        bundle.putBoolean("is_emi", intent.getBooleanExtra("is_emi", false));
        bundle.putString("emi_message", intent.getStringExtra("emi_message"));
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, intent.getStringExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL));
        bundle.putString("pay_mode", intent.getStringExtra("pay_mode"));
        bundle.putString("unique_identifier", intent.getStringExtra("unique_identifier"));
        bundle.putString("payee_vpa", intent.getStringExtra("payee_vpa"));
        bundle.putString(UpiConstants.EXTRA_PAYER_VPA, intent.getStringExtra(UpiConstants.EXTRA_PAYER_VPA));
        bundle.putInt("launchFrom", intent.getIntExtra("launchFrom", e.C0905e.PAY.getType()));
        eVar.setArguments(bundle);
        return eVar;
    }
}
