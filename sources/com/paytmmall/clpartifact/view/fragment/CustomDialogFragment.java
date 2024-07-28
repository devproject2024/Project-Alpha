package com.paytmmall.clpartifact.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.utils.PopupUtils;
import net.one97.paytm.i.g;

public class CustomDialogFragment extends g {
    PopupUtils.DialogDataModel dataModel;

    public void setDataModel(PopupUtils.DialogDataModel dialogDataModel) {
        this.dataModel = dialogDataModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewDataBinding a2 = f.a(LayoutInflater.from(getContext()), R.layout.clp_custom_dialog, viewGroup, false);
        a2.setVariable(BR.dialogDataModel, this.dataModel);
        return a2.getRoot();
    }
}
