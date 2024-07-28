package com.alipay.mobile.h5container.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.search.H5SearchView;

public abstract class BaseTitleBarPlugin extends H5TitleBar implements H5Plugin {
    /* access modifiers changed from: private */
    public boolean backEnabled = true;

    public void onInitialize(H5CoreNode h5CoreNode) {
    }

    public void onRelease() {
    }

    public /* bridge */ /* synthetic */ ColorDrawable getContentBgView() {
        return super.getContentBgView();
    }

    public /* bridge */ /* synthetic */ View getContentView() {
        return super.getContentView();
    }

    public /* bridge */ /* synthetic */ View getDivider() {
        return super.getDivider();
    }

    public /* bridge */ /* synthetic */ H5SearchView getH5SearchView() {
        return super.getH5SearchView();
    }

    public /* bridge */ /* synthetic */ View getHdividerInTitle() {
        return super.getHdividerInTitle();
    }

    public /* bridge */ /* synthetic */ TextView getMainTitleView() {
        return super.getMainTitleView();
    }

    public /* bridge */ /* synthetic */ View getOptionMenuContainer() {
        return super.getOptionMenuContainer();
    }

    public /* bridge */ /* synthetic */ View getPopAnchor() {
        return super.getPopAnchor();
    }

    public /* bridge */ /* synthetic */ TextView getSubTitleView() {
        return super.getSubTitleView();
    }

    public /* bridge */ /* synthetic */ String getTitle() {
        return super.getTitle();
    }

    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    public /* bridge */ /* synthetic */ void openTranslucentStatusBarSupport(int i2) {
        super.openTranslucentStatusBarSupport(i2);
    }

    public /* bridge */ /* synthetic */ void releaseViewList() {
        super.releaseViewList();
    }

    public /* bridge */ /* synthetic */ void resetTitleColor(int i2) {
        super.resetTitleColor(i2);
    }

    public /* bridge */ /* synthetic */ void setBackCloseBtnImage(String str) {
        super.setBackCloseBtnImage(str);
    }

    public /* bridge */ /* synthetic */ void setBtIcon(Bitmap bitmap, int i2) {
        super.setBtIcon(bitmap, i2);
    }

    public /* bridge */ /* synthetic */ void setImgTitle(Bitmap bitmap) {
        super.setImgTitle(bitmap);
    }

    public /* bridge */ /* synthetic */ void setImgTitle(Bitmap bitmap, String str) {
        super.setImgTitle(bitmap, str);
    }

    public /* bridge */ /* synthetic */ void setOptionMenu(e eVar) {
        super.setOptionMenu(eVar);
    }

    public /* bridge */ /* synthetic */ void setOptionType(H5Param.OptionType optionType) {
        super.setOptionType(optionType);
    }

    public /* bridge */ /* synthetic */ void setOptionType(H5Param.OptionType optionType, int i2, boolean z) {
        super.setOptionType(optionType, i2, z);
    }

    public /* bridge */ /* synthetic */ void setSubTitle(String str) {
        super.setSubTitle(str);
    }

    public /* bridge */ /* synthetic */ void setTitle(String str) {
        super.setTitle(str);
    }

    public /* bridge */ /* synthetic */ View setTitleBarSearch(Bundle bundle) {
        return super.setTitleBarSearch(bundle);
    }

    public /* bridge */ /* synthetic */ void setTitleTxtColor(int i2) {
        super.setTitleTxtColor(i2);
    }

    public /* bridge */ /* synthetic */ void showBackButton(boolean z) {
        super.showBackButton(z);
    }

    public /* bridge */ /* synthetic */ void showCloseButton(boolean z) {
        super.showCloseButton(z);
    }

    public /* bridge */ /* synthetic */ void showOptionMenu(boolean z) {
        super.showOptionMenu(z);
    }

    public /* bridge */ /* synthetic */ void showTitleLoading(boolean z) {
        super.showTitleLoading(z);
    }

    public /* bridge */ /* synthetic */ void switchToBlueTheme() {
        super.switchToBlueTheme();
    }

    public /* bridge */ /* synthetic */ void switchToTitleBar() {
        super.switchToTitleBar();
    }

    public /* bridge */ /* synthetic */ void switchToWhiteTheme() {
        super.switchToWhiteTheme();
    }

    public BaseTitleBarPlugin(Context context) {
        super(context);
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_BACK_BUTTON);
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_CLOSE_BUTTON);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOW_CLOSE);
    }

    public void setH5Page(H5Page h5Page) {
        super.setH5Page(h5Page);
        h5Page.getPluginManager().register((H5Plugin) this);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE.equals(action)) {
            enableBtton();
        }
        return H5Plugin.InternalEvents.H5_PAGE_SHOW_CLOSE.equals(action);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.SET_CLOSE_BUTTON.equals(action)) {
            enableButton(h5Event, this.btClose);
        } else if (H5Plugin.CommonEvents.SET_BACK_BUTTON.equals(action)) {
            enableButton(h5Event, this.btBack);
        } else if (H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK.equals(action) && this.backEnabled) {
            return false;
        }
        h5BridgeContext.sendSuccess();
        return true;
    }

    private void enableBtton() {
        enableButton(this.btClose, true);
        enableButton(this.btBack, true);
    }

    private void enableButton(H5Event h5Event, View view) {
        e param = h5Event.getParam();
        if (param != null) {
            String string = param.getString("action");
            if (TextUtils.equals(string, "disable")) {
                enableButton(view, false);
            } else if (TextUtils.equals(string, "enable")) {
                enableButton(view, true);
            } else if (TextUtils.equals(string, "hide")) {
                showButton(view, false);
            } else if (TextUtils.equals(string, "show")) {
                showButton(view, true);
            }
        }
    }

    private void enableButton(final View view, final boolean z) {
        view.post(new Runnable() {
            public void run() {
                boolean unused = BaseTitleBarPlugin.this.backEnabled = z;
                if (!z) {
                    view.setOnClickListener((View.OnClickListener) null);
                } else {
                    view.setOnClickListener(BaseTitleBarPlugin.this);
                }
            }
        });
    }

    private void showButton(final View view, final boolean z) {
        view.post(new Runnable() {
            public void run() {
                if (view == BaseTitleBarPlugin.this.btBack) {
                    view.setVisibility(z ? 0 : 8);
                } else if (view == BaseTitleBarPlugin.this.btClose) {
                    BaseTitleBarPlugin.this.showCloseButton(z);
                }
            }
        });
    }
}
