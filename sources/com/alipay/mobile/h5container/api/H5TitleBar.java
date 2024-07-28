package com.alipay.mobile.h5container.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.search.H5SearchType;
import com.alipay.mobile.nebula.search.H5SearchView;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5DimensionUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5StatusBarUtils;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.H5ViewStubUtil;
import com.alipay.mobile.nebula.view.H5TitleBarFrameLayout;
import com.alipay.mobile.nebula.view.H5TitleView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

class H5TitleBar implements View.OnClickListener, H5TitleView {
    public static final String TAG = "H5TitleBar";
    public View btBack;
    public View btClose;
    public View btDotView;
    public View btDotView1;
    public List<View> btDotViewList = new ArrayList();
    public ImageButton btIcon;
    public ImageButton btIcon1;
    public List<ImageButton> btIconList = new ArrayList();
    public View btMenu;
    public View btMenu1;
    public List<View> btMenuList = new ArrayList();
    public TextView btText;
    public TextView btText1;
    public List<TextView> btTextList = new ArrayList();
    public H5TitleBarFrameLayout contentView;
    public ImageView dotImage;
    public ImageView dotImage1;
    public List<ImageView> dotImageList = new ArrayList();
    public TextView dotText;
    public TextView dotText1;
    public List<TextView> dotTextList = new ArrayList();
    public View h5NavOptions;
    public View h5NavOptions1;
    public List<View> h5NavOptionsList = new ArrayList();
    private H5Page h5Page;
    private RelativeLayout h5TitleBarReLayout;
    private View hDivider;
    public ImageView ivImageTitle;
    public LinearLayout llTitle;
    private Context mContext;
    private int progressBarLoadingDrawable = R.drawable.h5_title_bar_progress;
    public RelativeLayout rlTitle;
    private boolean searchPage = false;
    private H5SearchView searchView;
    private boolean showCloseButton;
    private View statusBarAdjustView;
    public TextView tvSubtitle;
    public TextView tvTitle;
    private View vDivider;
    private int visibleOptionNum;

    private boolean isOutOfBound(int i2, int i3) {
        return i3 == 0 || i3 < i2;
    }

    public H5TitleBar(Context context) {
        this.mContext = context;
        this.contentView = (H5TitleBarFrameLayout) LayoutInflater.from(context).inflate(R.layout.h5_navigation_bar, context instanceof Activity ? (ViewGroup) ((Activity) this.mContext).findViewById(16908290) : null, false);
        this.tvTitle = (TextView) this.contentView.findViewById(R.id.h5_tv_title);
        this.tvSubtitle = (TextView) this.contentView.findViewById(R.id.h5_tv_subtitle);
        this.ivImageTitle = (ImageView) this.contentView.findViewById(R.id.h5_tv_title_img);
        this.statusBarAdjustView = this.contentView.findViewById(R.id.h5_status_bar_adjust_view);
        this.tvSubtitle.setVisibility(8);
        this.ivImageTitle.setVisibility(8);
        this.tvTitle.setOnClickListener(this);
        this.tvSubtitle.setOnClickListener(this);
        this.ivImageTitle.setOnClickListener(this);
        this.btBack = this.contentView.findViewById(R.id.h5_tv_nav_back);
        this.btClose = this.contentView.findViewById(R.id.h5_nav_close);
        this.vDivider = this.contentView.findViewById(R.id.h5_v_divider);
        this.hDivider = this.contentView.findViewById(R.id.h5_h_divider_intitle);
        this.rlTitle = (RelativeLayout) this.contentView.findViewById(R.id.h5_rl_title);
        this.llTitle = (LinearLayout) this.contentView.findViewById(R.id.h5_ll_title);
        this.h5NavOptions = this.contentView.findViewById(R.id.h5_nav_options);
        this.btDotView = this.contentView.findViewById(R.id.h5_bt_dot);
        this.btIcon = (ImageButton) this.contentView.findViewById(R.id.h5_bt_image);
        this.btText = (TextView) this.contentView.findViewById(R.id.h5_bt_text);
        this.btMenu = this.contentView.findViewById(R.id.h5_bt_options);
        this.dotImage = (ImageView) this.contentView.findViewById(R.id.h5_bt_dot_bg);
        this.dotText = (TextView) this.contentView.findViewById(R.id.h5_bt_dot_number);
        this.h5NavOptions1 = this.contentView.findViewById(R.id.h5_nav_options1);
        this.btDotView1 = this.contentView.findViewById(R.id.h5_bt_dot1);
        this.btIcon1 = (ImageButton) this.contentView.findViewById(R.id.h5_bt_image1);
        this.btText1 = (TextView) this.contentView.findViewById(R.id.h5_bt_text1);
        this.btMenu1 = this.contentView.findViewById(R.id.h5_bt_options1);
        this.dotImage1 = (ImageView) this.contentView.findViewById(R.id.h5_bt_dot_bg1);
        this.dotText1 = (TextView) this.contentView.findViewById(R.id.h5_bt_dot_number1);
        this.h5NavOptionsList.add(this.h5NavOptions);
        this.h5NavOptionsList.add(this.h5NavOptions1);
        this.btDotViewList.add(this.btDotView);
        this.btDotViewList.add(this.btDotView1);
        this.btIconList.add(this.btIcon);
        this.btIconList.add(this.btIcon1);
        this.btTextList.add(this.btText);
        this.btTextList.add(this.btText1);
        this.btMenuList.add(this.btMenu);
        this.btMenuList.add(this.btMenu1);
        this.dotImageList.add(this.dotImage);
        this.dotImageList.add(this.dotImage1);
        this.dotTextList.add(this.dotText);
        this.dotTextList.add(this.dotText1);
        this.visibleOptionNum = 1;
        ((RelativeLayout) this.contentView.findViewById(R.id.adView)).setTag("adView");
        ((RelativeLayout) this.contentView.findViewById(R.id.h5_custom_view)).setTag("h5_custom_view");
        this.btBack.setOnClickListener(this);
        this.btClose.setOnClickListener(this);
        this.btText.setOnClickListener(this);
        this.btIcon.setOnClickListener(this);
        this.btText1.setOnClickListener(this);
        this.btIcon1.setOnClickListener(this);
        this.btMenu.setOnClickListener(this);
        this.btMenu1.setOnClickListener(this);
        this.h5TitleBarReLayout = (RelativeLayout) this.contentView.findViewById(R.id.h5_title_bar_layout);
        this.searchPage = false;
    }

    public void setBtIcon(Bitmap bitmap, int i2) {
        if (!isOutOfBound(i2, this.btIconList.size())) {
            this.btIconList.get(i2).setImageBitmap(bitmap);
        }
    }

    public String getTitle() {
        TextView textView = this.tvTitle;
        if (textView != null) {
            return textView.getText().toString();
        }
        return null;
    }

    public void setTitle(String str) {
        if (str != null && enableSetTitle(str)) {
            this.tvTitle.setText(str.trim());
            this.tvTitle.setVisibility(0);
            this.ivImageTitle.setVisibility(8);
        }
    }

    private boolean enableSetTitle(String str) {
        return !str.startsWith("http://") && !str.startsWith("https://");
    }

    public void setOptionType(H5Param.OptionType optionType) {
        setOptionType(optionType, 0, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOptionType(com.alipay.mobile.h5container.api.H5Param.OptionType r4, int r5, boolean r6) {
        /*
            r3 = this;
            com.alipay.mobile.h5container.api.H5Param$OptionType r0 = com.alipay.mobile.h5container.api.H5Param.OptionType.ICON
            r1 = 1
            r2 = 0
            if (r4 != r0) goto L_0x000a
            r4 = 1
        L_0x0007:
            r0 = 0
        L_0x0008:
            r1 = 0
            goto L_0x001a
        L_0x000a:
            com.alipay.mobile.h5container.api.H5Param$OptionType r0 = com.alipay.mobile.h5container.api.H5Param.OptionType.TEXT
            if (r4 != r0) goto L_0x0011
            r4 = 0
            r0 = 0
            goto L_0x001a
        L_0x0011:
            com.alipay.mobile.h5container.api.H5Param$OptionType r0 = com.alipay.mobile.h5container.api.H5Param.OptionType.MENU
            if (r4 != r0) goto L_0x0018
            r4 = 0
            r0 = 1
            goto L_0x0008
        L_0x0018:
            r4 = 0
            goto L_0x0007
        L_0x001a:
            if (r1 == 0) goto L_0x001e
            r1 = 0
            goto L_0x0020
        L_0x001e:
            r1 = 8
        L_0x0020:
            r3.ctrlbtText(r5, r1, r6)
            r1 = 4
            if (r4 == 0) goto L_0x0028
            r4 = 0
            goto L_0x0029
        L_0x0028:
            r4 = 4
        L_0x0029:
            r3.ctrlbtIcon(r5, r4, r6)
            if (r0 == 0) goto L_0x002f
            r1 = 0
        L_0x002f:
            r3.ctrlbtMenu(r5, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.h5container.api.H5TitleBar.setOptionType(com.alipay.mobile.h5container.api.H5Param$OptionType, int, boolean):void");
    }

    private void ctrlbtText(int i2, int i3, boolean z) {
        if (!isOutOfBound(i2, this.btTextList.size())) {
            if (z) {
                this.btTextList.get(i2).setVisibility(i3);
                return;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                this.btTextList.get(i4).setVisibility(i3);
            }
        }
    }

    private void ctrlbtIcon(int i2, int i3, boolean z) {
        if (!isOutOfBound(i2, this.btIconList.size())) {
            if (z) {
                this.btIconList.get(i2).setVisibility(i3);
                return;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                this.btIconList.get(i4).setVisibility(i3);
            }
        }
    }

    private void ctrlbtMenu(int i2, int i3, boolean z) {
        if (!isOutOfBound(i2, this.btMenuList.size())) {
            if (z) {
                this.btMenuList.get(i2).setVisibility(i3);
                return;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                this.btMenuList.get(i4).setVisibility(i3);
            }
        }
    }

    private void ctrlbtDotView(int i2, int i3) {
        if (!isOutOfBound(i2, this.btDotViewList.size())) {
            for (int i4 = 0; i4 < i2; i4++) {
                this.btDotViewList.get(i4).setVisibility(i3);
            }
        }
    }

    public void setSubTitle(String str) {
        if (str != null) {
            this.tvSubtitle.setText(str);
        }
        this.tvSubtitle.setVisibility(TextUtils.isEmpty(this.tvSubtitle.getText().toString()) ^ true ? 0 : 8);
    }

    public void setImgTitle(Bitmap bitmap) {
        if (bitmap != null) {
            H5Log.d(TAG, "imgTitle width " + bitmap.getWidth() + ", imgTitle height " + bitmap.getHeight());
            this.ivImageTitle.setImageBitmap(bitmap);
            this.ivImageTitle.setVisibility(0);
            this.tvTitle.setVisibility(8);
            this.tvSubtitle.setVisibility(8);
            H5Log.d(TAG, "ivImageTitle width " + this.ivImageTitle.getWidth() + ", ivImageTitle height " + this.ivImageTitle.getHeight());
        }
    }

    public void setImgTitle(Bitmap bitmap, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ivImageTitle.setContentDescription(str);
        }
        setImgTitle(bitmap);
    }

    public void showCloseButton(boolean z) {
        this.showCloseButton = z;
        this.btClose.setVisibility(z ? 0 : 8);
    }

    public void showBackButton(boolean z) {
        int i2 = 8;
        this.btBack.setVisibility(z ? 0 : 8);
        this.btClose.setVisibility((!z || !this.showCloseButton) ? 8 : 0);
        if (!this.searchPage) {
            View view = this.vDivider;
            if (z) {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
        ((RelativeLayout.LayoutParams) this.rlTitle.getLayoutParams()).setMargins(z ? 0 : 28, 0, 0, 0);
    }

    public void showOptionMenu(boolean z) {
        if (z) {
            int i2 = this.visibleOptionNum;
            if (i2 == 1) {
                this.h5NavOptions.setVisibility(0);
            } else if (i2 == 2) {
                this.h5NavOptions.setVisibility(0);
                this.h5NavOptions1.setVisibility(0);
            }
        } else {
            this.h5NavOptions.setVisibility(8);
            this.h5NavOptions1.setVisibility(8);
        }
    }

    public void showTitleLoading(boolean z) {
        int i2 = 0;
        if (z) {
            Drawable drawable = this.mContext.getResources().getDrawable(this.progressBarLoadingDrawable);
            int dip2px = H5DimensionUtil.dip2px(this.mContext, 17.0f);
            drawable.setBounds(0, 0, dip2px, dip2px);
            ((ProgressBar) H5ViewStubUtil.getView(this.contentView, R.id.h5_nav_loading_stub, R.id.h5_nav_loading)).setIndeterminateDrawable(drawable);
        }
        H5TitleBarFrameLayout h5TitleBarFrameLayout = this.contentView;
        int i3 = R.id.h5_nav_loading_stub;
        int i4 = R.id.h5_nav_loading;
        if (!z) {
            i2 = 8;
        }
        H5ViewStubUtil.setViewVisibility(h5TitleBarFrameLayout, i3, i4, i2);
    }

    public View getContentView() {
        return this.contentView;
    }

    public ColorDrawable getContentBgView() {
        return this.contentView.getContentBgView();
    }

    public TextView getMainTitleView() {
        return this.tvTitle;
    }

    public TextView getSubTitleView() {
        return this.tvSubtitle;
    }

    public void onClick(View view) {
        String str;
        if (this.h5Page != null) {
            e eVar = null;
            if (view.equals(this.btBack)) {
                str = H5Plugin.InternalEvents.H5_TOOLBAR_BACK;
            } else if (view.equals(this.btClose)) {
                str = H5Plugin.InternalEvents.H5_TOOLBAR_CLOSE;
            } else {
                if (view.equals(this.btIcon) || view.equals(this.btText)) {
                    eVar = new e();
                    eVar.put(H5StartParamManager.index, (Object) 0);
                } else if (view.equals(this.btIcon1) || view.equals(this.btText1)) {
                    eVar = new e();
                    eVar.put(H5StartParamManager.index, (Object) 1);
                } else if (view.equals(this.btMenu) || view.equals(this.btMenu1)) {
                    eVar = new e();
                    eVar.put("fromMenu", (Object) Boolean.TRUE);
                    eVar.put(H5StartParamManager.index, (Object) Integer.valueOf(view.equals(this.btMenu) ^ true ? 1 : 0));
                } else {
                    str = (view.equals(this.tvTitle) || view.equals(this.ivImageTitle)) ? H5Plugin.InternalEvents.H5_TITLEBAR_TITLE_CLICK : view.equals(this.tvSubtitle) ? H5Plugin.InternalEvents.H5_TITLEBAR_SUBTITLE_CLICK : null;
                }
                str = H5Plugin.InternalEvents.H5_TITLEBAR_OPTIONS;
            }
            if (view.equals(this.btIcon) || view.equals(this.btText) || view.equals(this.btMenu)) {
                this.btDotView.setVisibility(8);
            }
            if (view.equals(this.btIcon1) || view.equals(this.btText1) || view.equals(this.btMenu1)) {
                this.btDotView1.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.h5Page.sendEvent(str, eVar);
            }
        }
    }

    public void setH5Page(H5Page h5Page2) {
        this.h5Page = h5Page2;
    }

    public void setOptionMenu(e eVar) {
        boolean z = H5Utils.getBoolean(eVar, UpiConstants.UPI_RESET_TOKEN, false);
        boolean z2 = H5Utils.getBoolean(eVar, "override", false);
        boolean equals = TextUtils.equals("tiny", H5Utils.getString(eVar, H5Param.LONG_BIZ_TYPE));
        b jSONArray = H5Utils.getJSONArray(eVar, "menus", (b) null);
        if (!z || equals) {
            int i2 = 2;
            if (jSONArray != null && !jSONArray.isEmpty()) {
                this.visibleOptionNum = 0;
                if (!z2 || equals) {
                    this.visibleOptionNum = 2;
                    setOptionMenuInternal(jSONArray.getJSONObject(0), 1);
                    return;
                }
                if (jSONArray.size() <= 2) {
                    i2 = jSONArray.size();
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    setOptionMenuInternal(jSONArray.getJSONObject(i3), i3);
                    this.visibleOptionNum++;
                }
            } else if (equals) {
                setOptionMenuInternal(eVar, 1);
                this.visibleOptionNum = 2;
            } else {
                setOptionMenuInternal(eVar, 0);
                this.visibleOptionNum = 1;
            }
        } else {
            this.h5NavOptions1.setVisibility(8);
            ctrlbtDotView(1, 8);
            setOptionType(H5Param.OptionType.MENU, 0, true);
            this.visibleOptionNum = 1;
        }
    }

    private void setOptionMenuInternal(e eVar, int i2) {
        String str;
        String string = H5Utils.getString(eVar, "title");
        String string2 = H5Utils.getString(eVar, H5Param.MENU_ICON);
        String string3 = H5Utils.getString(eVar, "icontype");
        String string4 = H5Utils.getString(eVar, "redDot");
        String string5 = H5Utils.getString(eVar, "contentDesc");
        int i3 = -1;
        if (TextUtils.isEmpty(string4)) {
            StringBuilder sb = new StringBuilder();
            sb.append(H5Utils.getInt(eVar, "redDot", -1));
            string4 = sb.toString();
        }
        String string6 = H5Utils.getString(eVar, CLConstants.FIELD_FONT_COLOR);
        int i4 = -15692055;
        if (!TextUtils.isEmpty(string6)) {
            try {
                i4 = Color.parseColor(string6);
            } catch (Throwable unused) {
            }
            this.btTextList.get(i2).setTextColor(i4 | -16777216);
        } else {
            int currentTextColor = this.tvTitle.getCurrentTextColor() | -16777216;
            H5Log.d(TAG, "setOptionMenuInternal currentColor is ".concat(String.valueOf(currentTextColor)));
            if (currentTextColor != -15658735) {
                this.btText.setTextColor(-1);
                this.btText1.setTextColor(-1);
            } else {
                this.btText.setTextColor(-15692055);
                this.btText1.setTextColor(-15692055);
            }
        }
        if (!TextUtils.isEmpty(string)) {
            this.btDotViewList.get(i2).setVisibility(8);
            String trim = string.trim();
            this.btTextList.get(i2).setText(trim);
            setOptionType(H5Param.OptionType.TEXT, i2, true);
            this.btTextList.get(i2).setContentDescription(trim);
        } else if (!TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3)) {
            this.btDotViewList.get(i2).setVisibility(8);
            if (!TextUtils.isEmpty(string5)) {
                this.btIconList.get(i2).setContentDescription(string5);
            }
        }
        if (!TextUtils.isEmpty(string4)) {
            try {
                i3 = Integer.parseInt(string4);
            } catch (NumberFormatException unused2) {
            }
            this.btDotViewList.get(i2).setVisibility(i3 >= 0 ? 0 : 8);
            if (i3 == 0) {
                this.dotImageList.get(i2).setVisibility(0);
                this.dotTextList.get(i2).setVisibility(8);
            } else if (i3 > 0) {
                this.dotTextList.get(i2).setVisibility(0);
                this.dotImageList.get(i2).setVisibility(8);
                if (i3 > 99) {
                    str = "···";
                } else {
                    str = String.valueOf(i3);
                }
                this.dotTextList.get(i2).setText(str);
            }
        }
    }

    public View getDivider() {
        return this.vDivider;
    }

    public View getHdividerInTitle() {
        return this.hDivider;
    }

    public View getPopAnchor() {
        return this.btMenu;
    }

    public void resetTitleColor(int i2) {
        H5TitleBarFrameLayout h5TitleBarFrameLayout = this.contentView;
        if (h5TitleBarFrameLayout != null) {
            h5TitleBarFrameLayout.getContentBgView().setColor(i2);
            if (getH5SearchView() != null) {
                getH5SearchView().setSearchBarColor(i2);
            }
        }
        View view = this.vDivider;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }
    }

    public void switchToWhiteTheme() {
        this.tvTitle.setTextColor(-1);
        this.tvSubtitle.setTextColor(-1);
        this.vDivider.setBackgroundColor(872415231);
        if (this.btText.getCurrentTextColor() == -15692055) {
            this.btText.setTextColor(-1);
        }
        if (this.btText1.getCurrentTextColor() == -15692055) {
            this.btText1.setTextColor(-1);
        }
        ((ImageButton) this.btBack).setImageResource(R.drawable.h5_white_title_bar_back_btn_selector);
        ((ImageButton) this.btClose).setImageResource(R.drawable.h5_white_title_bar_close_btn_selector);
        ((ImageButton) this.btMenu).setImageResource(R.drawable.h5_white_title_bar_more_btn_selector);
        ((ImageButton) this.btMenu1).setImageResource(R.drawable.h5_white_title_bar_more_btn_selector);
        this.progressBarLoadingDrawable = R.drawable.h5_title_bar_progress_white;
        if (this.searchPage && getH5SearchView() != null) {
            this.vDivider.setVisibility(8);
            getH5SearchView().switchToWhiteTheme();
        }
    }

    public void switchToBlueTheme() {
        this.tvTitle.setTextColor(-15658735);
        this.tvSubtitle.setTextColor(-15658735);
        this.vDivider.setBackgroundColor(-2500135);
        if (this.btText.getCurrentTextColor() == -1) {
            this.btText.setTextColor(-15692055);
        }
        if (this.btText1.getCurrentTextColor() == -1) {
            this.btText1.setTextColor(-15692055);
        }
        ((ImageButton) this.btBack).setImageResource(R.drawable.h5_title_bar_back_btn_selector);
        ((ImageButton) this.btClose).setImageResource(R.drawable.h5_title_bar_close_btn_selector);
        ((ImageButton) this.btMenu).setImageResource(R.drawable.h5_title_bar_more_btn_selector);
        ((ImageButton) this.btMenu1).setImageResource(R.drawable.h5_title_bar_more_btn_selector);
        this.progressBarLoadingDrawable = R.drawable.h5_title_bar_progress;
        if (this.searchPage && getH5SearchView() != null) {
            this.vDivider.setVisibility(8);
            getH5SearchView().switchToOriginal();
        }
    }

    public void releaseViewList() {
        List<View> list = this.h5NavOptionsList;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.btDotViewList;
        if (list2 != null) {
            list2.clear();
        }
        List<ImageButton> list3 = this.btIconList;
        if (list3 != null) {
            list3.clear();
        }
        List<TextView> list4 = this.btTextList;
        if (list4 != null) {
            list4.clear();
        }
        List<View> list5 = this.btMenuList;
        if (list5 != null) {
            list5.clear();
        }
        List<ImageView> list6 = this.dotImageList;
        if (list6 != null) {
            list6.clear();
        }
        List<TextView> list7 = this.dotTextList;
        if (list7 != null) {
            list7.clear();
        }
    }

    public void openTranslucentStatusBarSupport(int i2) {
        int statusBarHeight;
        if (H5StatusBarUtils.isSupport() && (statusBarHeight = H5StatusBarUtils.getStatusBarHeight(this.mContext)) != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.statusBarAdjustView.getLayoutParams();
            layoutParams.height = statusBarHeight;
            this.statusBarAdjustView.setLayoutParams(layoutParams);
            this.statusBarAdjustView.setVisibility(0);
            try {
                H5StatusBarUtils.setTransparentColor((Activity) this.mContext, i2);
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
    }

    public void switchToTitleBar() {
        H5ViewStubUtil.setViewVisibility(this.contentView, R.id.h5_full_search_bar_stub, R.id.h5_full_search_bar, 8);
        this.h5TitleBarReLayout.setVisibility(0);
        try {
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.contentView.getWindowToken(), 0);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public View setTitleBarSearch(Bundle bundle) {
        this.searchPage = true;
        if (getH5SearchView() == null) {
            return null;
        }
        String string = H5Utils.getString(bundle, H5Param.LONG_NAV_SEARCH_BAR_TYPE);
        this.vDivider.setVisibility(8);
        getH5SearchView().switchToWhiteTheme();
        if (TextUtils.equals(string, H5SearchType.ENTRANCE)) {
            this.llTitle.setVisibility(8);
            H5ViewStubUtil.setViewVisibility(this.contentView, R.id.h5_embed_title_search_stub, R.id.h5_embed_title_search, 0);
            LinearLayout linearLayout = (LinearLayout) H5ViewStubUtil.getView(this.contentView, R.id.h5_embed_title_search_stub, R.id.h5_embed_title_search);
            linearLayout.setVisibility(0);
            getH5SearchView().showSearch(this.mContext, linearLayout, bundle);
            if (!TextUtils.isEmpty(H5Utils.getString(bundle, H5Param.LONG_TRANSPARENT_TITLE))) {
                ((ImageButton) this.btBack).setImageResource(R.drawable.h5_white_title_bar_back_btn_selector);
            }
            return linearLayout;
        }
        this.h5TitleBarReLayout.setVisibility(8);
        H5ViewStubUtil.setViewVisibility(this.contentView, R.id.h5_full_search_bar_stub, R.id.h5_full_search_bar, 0);
        LinearLayout linearLayout2 = (LinearLayout) H5ViewStubUtil.getView(this.contentView, R.id.h5_full_search_bar_stub, R.id.h5_full_search_bar);
        getH5SearchView().showSearch(this.mContext, linearLayout2, bundle);
        return linearLayout2;
    }

    public void setBackCloseBtnImage(String str) {
        if ("yellow".equalsIgnoreCase(str)) {
            ((ImageButton) this.btBack).setImageResource(R.drawable.h5_gold_title_bar_back_btn_selector);
            ((ImageButton) this.btClose).setImageResource(R.drawable.h5_gold_title_bar_close_btn_selector);
            this.progressBarLoadingDrawable = R.drawable.h5_title_bar_progress_gold;
        }
        if ("black".equalsIgnoreCase(str)) {
            ((ImageButton) this.btBack).setImageResource(R.drawable.h5_black_title_bar_back_btn_selector);
            ((ImageButton) this.btClose).setImageResource(R.drawable.h5_black_title_bar_close_btn_selector);
            this.progressBarLoadingDrawable = R.drawable.h5_title_bar_progress;
        }
    }

    public void setTitleTxtColor(int i2) {
        int i3 = i2 | -16777216;
        this.tvTitle.setTextColor(i3);
        this.tvSubtitle.setTextColor(i3);
    }

    public View getOptionMenuContainer() {
        return this.h5NavOptions;
    }

    public H5SearchView getH5SearchView() {
        H5SearchView h5SearchView = this.searchView;
        if (h5SearchView != null) {
            return h5SearchView;
        }
        this.searchView = (H5SearchView) H5Utils.getProvider(H5SearchView.class.getName());
        return this.searchView;
    }
}
