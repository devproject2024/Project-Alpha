package com.business.merchant_payments.newhome.listener;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.kyc.KycBankInfoModel;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;

public interface IAcceptPaymentMainActivityListener {
    void addBasicInfoObserver(z<b<KycBankInfoModel>> zVar);

    void addFragment(Class<? extends Fragment> cls, Bundle bundle, int i2);

    void closeDrawer();

    void closeInactiveMerchantBottomSheet();

    void initialiseInactiveMerchantListener(InactiveMerchantListener inactiveMerchantListener);

    void onRefresh();

    void removeBasicInfoObserver(z<b<KycBankInfoModel>> zVar);

    void removeFragment(Class<? extends Fragment> cls);

    void showInactiveMerchantBottomSheet();

    void showQR(boolean z);

    void updateRewardPoints(String str);
}
