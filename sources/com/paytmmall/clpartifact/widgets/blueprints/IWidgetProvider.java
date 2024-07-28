package com.paytmmall.clpartifact.widgets.blueprints;

import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;

public interface IWidgetProvider {
    SFWidget getWidget(FragmentActivity fragmentActivity, IGAHandlerListener iGAHandlerListener);

    int getWidgetType();

    boolean isValid();
}
