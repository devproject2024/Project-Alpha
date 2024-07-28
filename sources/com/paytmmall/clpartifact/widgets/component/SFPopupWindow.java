package com.paytmmall.clpartifact.widgets.component;

import android.view.View;
import android.widget.PopupWindow;
import com.paytmmall.clpartifact.widgets.SFWidgetActions;
import com.paytmmall.clpartifact.widgets.SFWidgetKeys;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.HashMap;

public class SFPopupWindow extends PopupWindow implements SFWidget {
    public SFPopupWindow(View view) {
        super(view, -2, -2);
    }

    public void showWidget(HashMap<String, Object> hashMap) {
        try {
            showView(hashMap);
            performActions(hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void performActions(HashMap<String, Object> hashMap) {
        Object obj = hashMap != null ? hashMap.get(SFWidgetActions.ACTION_CLIP_ENABLED) : null;
        if (obj != null) {
            setClippingEnabled(Boolean.parseBoolean(obj.toString()));
        }
    }

    private void showView(HashMap<String, Object> hashMap) {
        showAsDropDown(SFWidget.CC.getView(hashMap, SFWidgetKeys.KEY_ANCHOR), SFWidget.CC.getInt(hashMap, SFWidgetKeys.KEY_X_OFFSET), SFWidget.CC.getInt(hashMap, SFWidgetKeys.KEY_Y_OFFSET));
    }

    public void setOnDismissListener(SFWidget.DismissListener dismissListener) {
        if (dismissListener != null) {
            dismissListener.getClass();
            super.setOnDismissListener(new PopupWindow.OnDismissListener() {
                public final void onDismiss() {
                    SFWidget.DismissListener.this.onDismiss();
                }
            });
        }
    }

    public void dismissWidget() {
        if (isShowing()) {
            dismiss();
        }
    }
}
