package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5ActionSheetProvider;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.ArrayList;

public class H5ActionSheetPlugin extends H5SimplePlugin {
    private final String TAG = "H5ActionSheetPlugin";
    private H5ActionSheetProvider actionSheetProvider;
    private ViewGroup contentView;
    private Dialog dialog;
    private ViewGroup rootView;
    private boolean sheetVisible = false;

    public void onRelease() {
        hide();
        H5ActionSheetProvider h5ActionSheetProvider = this.actionSheetProvider;
        if (h5ActionSheetProvider != null) {
            h5ActionSheetProvider.onRelease();
        }
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.ACTION_SHEET);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACK);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.InternalEvents.H5_PAGE_BACK.equals(action)) {
            if (hide()) {
                return true;
            }
            return false;
        } else if (!H5Plugin.CommonEvents.ACTION_SHEET.equals(action)) {
            return false;
        } else {
            hide();
            show(h5Event, h5BridgeContext);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean hide() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            if (!dialog2.isShowing()) {
                return false;
            }
            this.dialog.cancel();
            return true;
        } else if (!this.sheetVisible) {
            return false;
        } else {
            this.rootView.removeView(this.contentView);
            this.sheetVisible = false;
            return true;
        }
    }

    private void show(H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        int i2;
        e param = h5Event.getParam();
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            return;
        }
        String string = H5Utils.getString(param, "title");
        String string2 = H5Utils.getString(param, "cancelBtn");
        b jSONArray = H5Utils.getJSONArray(param, "btns", (b) null);
        String string3 = H5Utils.getString(param, "destructiveBtnIndex");
        int i3 = 0;
        this.actionSheetProvider = (H5ActionSheetProvider) Nebula.getProviderManager().getProviderUseCache(H5ActionSheetProvider.class.getName(), false);
        if (this.actionSheetProvider != null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(string3)) {
                arrayList.add(string3);
            }
            if (jSONArray != null && !jSONArray.isEmpty()) {
                while (i3 < jSONArray.size()) {
                    arrayList.add((String) jSONArray.get(i3));
                    i3++;
                }
            }
            this.actionSheetProvider.setContextAndContent(activity, arrayList, string.trim(), h5BridgeContext, (View.OnClickListener) null);
            this.dialog = this.actionSheetProvider.getAntUIActionSheet();
            Dialog dialog2 = this.dialog;
            if (dialog2 != null) {
                dialog2.show();
                return;
            }
            return;
        }
        if (this.rootView == null) {
            this.rootView = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
        }
        LayoutInflater from = LayoutInflater.from(activity);
        this.contentView = (ViewGroup) from.inflate(R.layout.h5_action_sheet, this.rootView, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int dip2px = H5Utils.dip2px(H5Environment.getContext(), 7);
        layoutParams.setMargins(dip2px, dip2px, dip2px, dip2px);
        AnonymousClass1 r6 = new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = H5ActionSheetPlugin.this.hide();
                e eVar = new e();
                eVar.put("success", (Object) "true");
                eVar.put(H5StartParamManager.index, (Object) -1);
                h5BridgeContext.sendBridgeResult(eVar);
            }
        };
        View findViewById = this.contentView.findViewById(R.id.rl_h5_action_sheet);
        LinearLayout linearLayout = (LinearLayout) this.contentView.findViewById(R.id.h5_action_sheet_content);
        findViewById.setOnClickListener(r6);
        linearLayout.setOnClickListener(r6);
        TextView textView = (TextView) this.contentView.findViewById(R.id.h5_action_sheet_title);
        if (!TextUtils.isEmpty(string)) {
            textView.setText(string);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        AnonymousClass2 r12 = new View.OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                boolean unused = H5ActionSheetPlugin.this.hide();
                e eVar = new e();
                eVar.put("success", (Object) "true");
                eVar.put(H5StartParamManager.index, (Object) Integer.valueOf(intValue));
                h5BridgeContext.sendBridgeResult(eVar);
            }
        };
        if (!TextUtils.isEmpty(string3)) {
            Button button = (Button) from.inflate(R.layout.h5_as_default_button, (ViewGroup) null);
            button.setText(string3);
            button.setTag(0);
            button.setOnClickListener(r12);
            button.setLayoutParams(layoutParams);
            linearLayout.addView(button, 1);
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONArray != null && !jSONArray.isEmpty()) {
            while (i3 < jSONArray.size()) {
                String str = (String) jSONArray.get(i3);
                H5Log.d("H5ActionSheetPlugin", "otherButton =".concat(String.valueOf(str)));
                Button button2 = (Button) from.inflate(R.layout.h5_as_default_button, (ViewGroup) null);
                button2.setText(str);
                button2.setTag(Integer.valueOf(i2));
                button2.setOnClickListener(r12);
                button2.setLayoutParams(layoutParams);
                i2++;
                linearLayout.addView(button2, i2);
                i3++;
            }
        }
        if (!TextUtils.isEmpty(string2)) {
            Button button3 = (Button) from.inflate(R.layout.h5_as_cancel_button, (ViewGroup) null);
            button3.setText(string2);
            button3.setTag(Integer.valueOf(i2));
            button3.setOnClickListener(r12);
            button3.setLayoutParams(layoutParams);
            linearLayout.addView(button3, i2 + 1);
        }
        this.rootView.addView(this.contentView);
        this.rootView.bringChildToFront(this.contentView);
        this.sheetVisible = true;
    }
}
