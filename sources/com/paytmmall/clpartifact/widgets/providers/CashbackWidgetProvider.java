package com.paytmmall.clpartifact.widgets.providers;

import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;

public class CashbackWidgetProvider extends BaseWidgetProvider implements IClientWidgetListener {
    private SFWidget clientWidget = null;

    public int getWidgetType() {
        return 102;
    }

    public boolean isValid() {
        return true;
    }

    CashbackWidgetProvider(View view) {
        super(view);
    }

    public SFWidget getWidget(FragmentActivity fragmentActivity, IGAHandlerListener iGAHandlerListener) {
        return this.clientWidget;
    }

    public void setClientWidget(SFWidget sFWidget) {
        this.clientWidget = sFWidget;
    }
}
