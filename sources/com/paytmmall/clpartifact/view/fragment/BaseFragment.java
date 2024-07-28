package com.paytmmall.clpartifact.view.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.view.viewmodel.BaseViewModel;
import net.one97.paytm.i.h;

public abstract class BaseFragment extends h {
    /* access modifiers changed from: protected */
    public abstract BaseViewModel getViewModel();

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BaseViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.setRedirectorObserver(this, new z() {
                public final void onChanged(Object obj) {
                    BaseFragment.this.handleRedirection((RedirectorModel) obj);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void handleRedirection(RedirectorModel redirectorModel) {
        if (redirectorModel != null && redirectorModel.getRequest() == 1006) {
            CLPArtifact.getInstance().getCommunicationListener().openLoginScreen(getContext());
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        BaseViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.removeObserver(this);
        }
    }
}
