package com.business.merchant_payments.common.viewmodel;

import androidx.databinding.i;

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
