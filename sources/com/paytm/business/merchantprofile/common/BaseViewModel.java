package com.paytm.business.merchantprofile.common;

import android.content.Context;
import androidx.databinding.a;
import com.paytm.business.merchantprofile.ProfileConfig;

public abstract class BaseViewModel extends a {
    public Context getContext() {
        return ProfileConfig.getInstance().getAppContext();
    }
}
