package com.paytmmall.clpartifact.widgets.providers;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.util.f;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.FloatingNavigationView;
import com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory;

class NavWidgetProvider extends BaseWidgetProvider {
    public int getWidgetType() {
        return 104;
    }

    NavWidgetProvider(View view) {
        super(view);
    }

    public IStaticWidget getWidget(FragmentActivity fragmentActivity, IGAHandlerListener iGAHandlerListener) {
        try {
            if (!SFWidgetFactory.TYPE_FLOATING_NAV.equalsIgnoreCase(getView().getType()) || !isValid()) {
                return null;
            }
            return getNavigationView(fragmentActivity, getView(), iGAHandlerListener);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isValid() {
        return !f.a(getView().getItems());
    }

    private IStaticWidget getNavigationView(FragmentActivity fragmentActivity, View view, IGAHandlerListener iGAHandlerListener) {
        return new FloatingNavigationView(fragmentActivity, view, iGAHandlerListener);
    }
}
