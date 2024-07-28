package com.paytmmall.clpartifact.widgets.blueprints;

import android.view.View;
import com.paytmmall.clpartifact.widgets.SFWidgetActions;
import com.paytmmall.clpartifact.widgets.SFWidgetKeys;
import java.util.HashMap;

public interface SFWidget extends SFWidgetActions, SFWidgetKeys {

    public interface DismissListener {
        void onDismiss();
    }

    void dismissWidget();

    void setOnDismissListener(DismissListener dismissListener);

    void showWidget(HashMap<String, Object> hashMap);

    /* renamed from: com.paytmmall.clpartifact.widgets.blueprints.SFWidget$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int getInt(HashMap<String, Object> hashMap, String str) {
            Object obj = hashMap != null ? hashMap.get(str) : null;
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }

        public static View getView(HashMap<String, Object> hashMap, String str) {
            Object obj = hashMap != null ? hashMap.get(str) : null;
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        }
    }
}
