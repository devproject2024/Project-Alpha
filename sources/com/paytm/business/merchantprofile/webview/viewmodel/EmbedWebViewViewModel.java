package com.paytm.business.merchantprofile.webview.viewmodel;

import androidx.databinding.i;
import com.paytm.business.merchantprofile.common.BaseViewModel;

public class EmbedWebViewViewModel extends BaseViewModel {
    public i<Integer> progressBarVisibility = new i<>(0);
    public i<String> url;

    public EmbedWebViewViewModel(String str) {
        this.url = new i<>(str);
    }

    public void setProgressBarVisibility(int i2) {
        this.progressBarVisibility.set(Integer.valueOf(i2));
    }
}
