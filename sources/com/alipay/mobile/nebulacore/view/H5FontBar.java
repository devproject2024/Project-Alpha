package com.alipay.mobile.nebulacore.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5Scenario;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebulacore.R;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5FontBar extends H5SimplePlugin implements View.OnClickListener {
    public static final String HIDE_FONT_BAR = "hideFontBar";
    public static final String SHOW_FONT_BAR = "showFontBar";
    public static final String TAG = "H5FontBar";
    private View contentView;
    private View fontBarClose;
    private View fontBlankView;
    private View fontSize1;
    private View fontSize2;
    private View fontSize3;
    private View fontSize4;
    private boolean fontVisible = false;
    private H5Page h5Page;
    private ImageView ivSize1;
    private ImageView ivSize2;
    private ImageView ivSize3;
    private ImageView ivSize4;
    private ViewGroup rootView;

    public H5FontBar(H5Page h5Page2) {
        this.h5Page = h5Page2;
    }

    private void initContentView() {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null) {
            Activity activity = (Activity) h5Page2.getContext().getContext();
            LayoutInflater from = LayoutInflater.from(activity);
            this.rootView = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
            this.contentView = from.inflate(R.layout.h5_font_bar, this.rootView, false);
            this.fontBlankView = this.contentView.findViewById(R.id.h5_font_blank);
            this.fontBlankView.setOnClickListener(this);
            this.contentView.findViewById(R.id.h5_font_bar).setOnClickListener(this);
            this.ivSize1 = (ImageView) this.contentView.findViewById(R.id.h5_iv_font_size1);
            this.ivSize2 = (ImageView) this.contentView.findViewById(R.id.h5_iv_font_size2);
            this.ivSize3 = (ImageView) this.contentView.findViewById(R.id.h5_iv_font_size3);
            this.ivSize4 = (ImageView) this.contentView.findViewById(R.id.h5_iv_font_size4);
            this.fontBarClose = this.contentView.findViewById(R.id.h5_font_close);
            this.fontSize1 = this.contentView.findViewById(R.id.h5_font_size1);
            this.fontSize2 = this.contentView.findViewById(R.id.h5_font_size2);
            this.fontSize3 = this.contentView.findViewById(R.id.h5_font_size3);
            this.fontSize4 = this.contentView.findViewById(R.id.h5_font_size4);
            this.fontSize1.setOnClickListener(this);
            this.fontSize2.setOnClickListener(this);
            this.fontSize3.setOnClickListener(this);
            this.fontSize4.setOnClickListener(this);
            this.fontBarClose.setOnClickListener(this);
            int i2 = 100;
            H5Scenario scenario = this.h5Page.getSession().getScenario();
            if (scenario != null) {
                String str = scenario.getData().get(H5Param.FONT_SIZE);
                if (!TextUtils.isEmpty(str)) {
                    i2 = Integer.parseInt(str);
                }
                updateFontBar(i2);
            }
        }
    }

    public void onClick(View view) {
        int i2;
        if (view.equals(this.fontBlankView) || view.equals(this.fontBarClose)) {
            hideFontBar();
            return;
        }
        if (view.equals(this.fontSize1)) {
            i2 = 75;
        } else if (view.equals(this.fontSize2)) {
            i2 = 100;
        } else if (view.equals(this.fontSize3)) {
            i2 = H5Param.WEBVIEW_FONT_SIZE_LARGER;
        } else {
            i2 = view.equals(this.fontSize4) ? 200 : -1;
        }
        if (i2 != -1) {
            onFontSizeChanged(i2);
        }
    }

    private void onFontSizeChanged(int i2) {
        if (this.h5Page != null) {
            e eVar = new e();
            eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, (Object) Integer.valueOf(i2));
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_FONT_SIZE, eVar);
            updateFontBar(i2);
        }
    }

    private void updateFontBar(int i2) {
        this.ivSize1.setImageResource(R.drawable.h5_font_size1_enable);
        this.ivSize2.setImageResource(R.drawable.h5_font_size2_enable);
        this.ivSize3.setImageResource(R.drawable.h5_font_size3_enable);
        this.ivSize4.setImageResource(R.drawable.h5_font_size4_enable);
        if (i2 == 75) {
            this.ivSize1.setImageResource(R.drawable.h5_font_size1_disable);
        } else if (i2 == 100) {
            this.ivSize2.setImageResource(R.drawable.h5_font_size2_disable);
        } else if (i2 == 150) {
            this.ivSize3.setImageResource(R.drawable.h5_font_size3_disable);
        } else if (i2 == 200) {
            this.ivSize4.setImageResource(R.drawable.h5_font_size4_disable);
        }
    }

    private void showFontBar() {
        ensureRootView();
        this.rootView.addView(this.contentView);
        this.rootView.bringChildToFront(this.contentView);
        this.fontVisible = true;
    }

    private void hideFontBar() {
        ensureRootView();
        this.rootView.removeView(this.contentView);
        this.fontVisible = false;
    }

    public void onRelease() {
        this.h5Page = null;
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!H5Plugin.InternalEvents.H5_PAGE_BACK.equals(h5Event.getAction()) || !this.fontVisible) {
            return false;
        }
        hideFontBar();
        return true;
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (SHOW_FONT_BAR.equals(action)) {
            showFontBar();
            return true;
        } else if (!HIDE_FONT_BAR.equals(action)) {
            return false;
        } else {
            hideFontBar();
            return true;
        }
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(SHOW_FONT_BAR);
        h5EventFilter.addAction(HIDE_FONT_BAR);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACK);
    }

    private void ensureRootView() {
        if (this.rootView == null) {
            initContentView();
        }
    }
}
