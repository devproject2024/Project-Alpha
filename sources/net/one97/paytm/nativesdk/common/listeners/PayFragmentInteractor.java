package net.one97.paytm.nativesdk.common.listeners;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public interface PayFragmentInteractor {
    void addPageVisibleGAEvent();

    void addPayFragment(Bundle bundle);

    void backToCashierPage(Fragment fragment, String str, boolean z);

    void onWebPageFinish();
}
