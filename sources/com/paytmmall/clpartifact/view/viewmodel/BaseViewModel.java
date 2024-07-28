package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import androidx.lifecycle.a;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.common.RedirectorModel;

public class BaseViewModel extends a {
    public static final String KEY_RATING_MODEL = "rating_model";
    public static final String KEY_REVIEW_MODEL = "review_model";
    private y<RedirectorModel> redirectManager = new y<>();
    private SingleEventLiveData<RedirectorModel> redirector = new SingleEventLiveData<>();

    public void removeObserver(q qVar) {
    }

    BaseViewModel(Application application) {
        super(application);
        this.redirector.addSource(this.redirectManager, new z() {
            public final void onChanged(Object obj) {
                BaseViewModel.this.lambda$new$0$BaseViewModel((RedirectorModel) obj);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$BaseViewModel(RedirectorModel redirectorModel) {
        this.redirector.setValue(redirectorModel);
    }

    public void redirect(RedirectorModel redirectorModel) {
        this.redirectManager.setValue(redirectorModel);
    }

    public void setRedirectorObserver(q qVar, z<RedirectorModel> zVar) {
        this.redirector.observe(qVar, zVar);
    }
}
