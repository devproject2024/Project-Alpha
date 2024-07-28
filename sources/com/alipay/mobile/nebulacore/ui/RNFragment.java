package com.alipay.mobile.nebulacore.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.RnService;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class RNFragment extends H5Fragment {
    private static final String TAG = "RNFragment";

    public static void resetToH5FragmentBundle(Bundle bundle) {
        String string = H5Utils.getString(bundle, H5Param.LONG_BIZ_TYPE);
        if (string != null && string.startsWith(RnService.RN_BIZ_TYPE_PREFIX)) {
            string = string.substring(3);
        }
        bundle.putString(H5Param.LONG_BIZ_TYPE, string);
        String string2 = H5Utils.getString(bundle, "url");
        if (string2.contains("bundle")) {
            string2 = string2.replace("rnpages", "pages").replace("bundle", "html");
        }
        bundle.putString("url", string2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RnService rnService = H5Environment.getRnService();
        if (rnService == null) {
            Bundle arguments = getArguments();
            resetToH5FragmentBundle(arguments);
            setArguments(arguments);
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (rnService != null) {
            try {
                rnService.addRnView(this.rootViewHolder.getH5Page(), getChildFragmentManager());
            } catch (Exception e2) {
                H5Log.e(TAG, "onCreateView exception: ".concat(String.valueOf(e2)));
            }
        }
        return onCreateView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        RnService rnService = H5Environment.getRnService();
        if (rnService != null) {
            try {
                rnService.removeRnView(this.rootViewHolder.getH5Page(), getChildFragmentManager());
            } catch (Exception e2) {
                H5Log.e(TAG, "onDestroyView exception: ".concat(String.valueOf(e2)));
            }
        }
    }
}
