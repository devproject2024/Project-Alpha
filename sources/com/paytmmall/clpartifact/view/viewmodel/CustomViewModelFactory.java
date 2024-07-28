package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;

public class CustomViewModelFactory implements al.b {
    private Application mApplication;
    private Bundle mBundle;

    public CustomViewModelFactory(Application application, Bundle bundle) {
        this.mApplication = application;
        this.mBundle = bundle;
    }

    public <T extends ai> T create(Class<T> cls) {
        if (cls.getSimpleName().equalsIgnoreCase(VoucherViewModel.class.getSimpleName())) {
            return new VoucherViewModel(this.mApplication, this.mBundle);
        }
        throw new IllegalStateException("No ViewModel found for Factory CustomViewModelFactory");
    }
}
