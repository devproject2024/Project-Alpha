package com.business.merchant_payments.acceptpayments;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.mapqr.view.AlInOneQrDetailFragment;
import com.business.merchant_payments.mapqr.view.FeedbackCollectionFragment;
import java.util.HashMap;

public final class QRDetailActivity extends BaseActivity {
    public HashMap _$_findViewCache;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mp_activity_qr_not_printed);
        replaceFragmentKeepingBackStack(AlInOneQrDetailFragment.Companion.newInstance());
    }

    public final void onBackPressed() {
        if (GTMDataProviderImpl.Companion.getMInstance().shouldShowSurveyScreen()) {
            Fragment c2 = getSupportFragmentManager().c(R.id.fragment_container);
            if (c2 instanceof AlInOneQrDetailFragment) {
                replaceFragmentKeepingBackStack(FeedbackCollectionFragment.Companion.newInstance());
            } else if (c2 instanceof FeedbackCollectionFragment) {
                getSupportFragmentManager().e();
            }
        } else {
            finish();
        }
    }
}
