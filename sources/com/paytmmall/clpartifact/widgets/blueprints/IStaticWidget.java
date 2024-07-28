package com.paytmmall.clpartifact.widgets.blueprints;

import android.graphics.Point;
import android.view.View;

public interface IStaticWidget extends SFWidget {
    void AnimateView(String str);

    View getView();

    Point getViewPoint(String str);
}
