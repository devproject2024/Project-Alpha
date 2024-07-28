package com.paytmmall.clpartifact.widgets.providers;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.util.f;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.component.SFNotificationPopup;
import com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory;

public class P4BNotificationWidgetProvider extends BaseWidgetProvider {
    public int getWidgetType() {
        return 103;
    }

    P4BNotificationWidgetProvider(View view) {
        super(view);
    }

    public SFNotificationPopup getWidget(FragmentActivity fragmentActivity, IGAHandlerListener iGAHandlerListener) {
        try {
            View view = getView();
            if (!SFWidgetFactory.TYPE_OVERLAY_BANNER.equalsIgnoreCase(view.getType()) || !isValid()) {
                return null;
            }
            return new SFNotificationPopup(fragmentActivity, view.getItems().get(0), iGAHandlerListener);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isValid() {
        View view = getView();
        return !f.a(view.getItems()) && !TextUtils.isEmpty(view.getItems().get(0).getImageUrl());
    }
}
