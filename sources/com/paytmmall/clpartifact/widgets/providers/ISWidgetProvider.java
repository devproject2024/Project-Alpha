package com.paytmmall.clpartifact.widgets.providers;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import com.google.android.gms.common.util.f;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.activity.InterstetialActivity;
import com.paytmmall.clpartifact.widgets.component.SFISView;
import com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory;
import com.paytmmall.clpartifact.widgets.viewmodel.InterStitialSharedViewModel;

public class ISWidgetProvider extends BaseWidgetProvider {
    public int getWidgetType() {
        return 101;
    }

    ISWidgetProvider(View view) {
        super(view);
    }

    public SFISView getWidget(FragmentActivity fragmentActivity, IGAHandlerListener iGAHandlerListener) {
        try {
            View view = getView();
            if (!SFWidgetFactory.TYPE_INTERSTETIAL.equalsIgnoreCase(view.getType()) || !isValid()) {
                return null;
            }
            Item item = view.getItems().get(0);
            return getWidget(fragmentActivity, item.getImageUrl(), item.getMUrl(), item);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isValid() {
        View view = getView();
        return !f.a(view.getItems()) && !TextUtils.isEmpty(view.getItems().get(0).getImageUrl());
    }

    private SFISView getWidget(FragmentActivity fragmentActivity, String str, String str2, Item item) {
        if (!isUniqueWidget(fragmentActivity, item.getId())) {
            return null;
        }
        SFISView sFISView = new SFISView(fragmentActivity, InterstetialActivity.class);
        sFISView.putExtra(CLPConstants.ISV_IMG_URL, str);
        sFISView.putExtra(CLPConstants.ISV_CLICK_URL, str2);
        sFISView.putExtra(CLPConstants.ISV_AD_ITEM, item);
        sFISView.putExtra(CLPConstants.IS_BG_ACTIVE, Boolean.valueOf(getView().isBGActive()));
        return sFISView;
    }

    /* access modifiers changed from: protected */
    public boolean isUniqueWidget(FragmentActivity fragmentActivity, String str) {
        return ((InterStitialSharedViewModel) am.a(fragmentActivity).a(InterStitialSharedViewModel.class)).isUniqueWidget(str);
    }
}
