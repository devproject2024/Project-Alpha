package com.paytmmall.clpartifact.widgets.providers;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import kotlin.g.b.k;

public abstract class BaseWidgetProvider implements IWidgetProvider {
    private final View view;

    public BaseWidgetProvider(View view2) {
        k.c(view2, "view");
        this.view = view2;
    }

    public final View getView() {
        return this.view;
    }
}
