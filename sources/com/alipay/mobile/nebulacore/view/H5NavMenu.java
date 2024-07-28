package com.alipay.mobile.nebulacore.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ViewProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5NavMenuItem;
import com.alipay.mobile.nebula.view.H5NavMenuView;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H5NavMenu extends H5PopMenu {
    public static final String TAG = "H5NavMenu";
    /* access modifiers changed from: private */
    public FrameLayout contentView;
    private Context context;
    private H5NavMenuView h5NavMenuView;
    private boolean hasClearList4Tiny = false;
    /* access modifiers changed from: private */
    public List<View> itemViewList;
    private ViewGroup.LayoutParams mMatchParentLP;
    /* access modifiers changed from: private */
    public View maskView;
    /* access modifiers changed from: private */
    public LinearLayout popContainer;
    private View rootView;
    private int xOffset;
    private int yOffset;

    public H5NavMenu(Context context2) {
        if (context2 instanceof Activity) {
            this.contentView = (FrameLayout) ((Activity) context2).findViewById(16908290);
        }
        this.context = context2;
    }

    private void tryInitView() {
        Context context2 = this.context;
        if (context2 != null && this.maskView == null) {
            this.maskView = new View(context2);
            this.maskView.setBackgroundColor(-16777216);
            this.maskView.setAlpha(0.4f);
            this.mMatchParentLP = new ViewGroup.LayoutParams(-1, -1);
            this.rootView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.h5_popmenu, this.contentView, false);
            this.popContainer = (LinearLayout) this.rootView.findViewById(R.id.h5_popmenu_container);
        }
    }

    public void clearMenuList() {
        if (this.menuList != null && !this.hasClearList4Tiny) {
            this.menuList.clear();
            this.hasClearList4Tiny = true;
        }
    }

    public void initMenu() {
        Resources resources = H5Environment.getResources();
        H5ViewProvider h5ViewProvider = (H5ViewProvider) H5ProviderManagerImpl.getInstance().getProvider(H5ViewProvider.class.getName());
        if (h5ViewProvider == null) {
            this.h5NavMenuView = new com.alipay.mobile.h5container.api.H5NavMenu();
        } else {
            this.h5NavMenuView = h5ViewProvider.createNavMenu();
            if (this.h5NavMenuView == null) {
                this.h5NavMenuView = new com.alipay.mobile.h5container.api.H5NavMenu();
            }
        }
        this.menuList = Collections.synchronizedList(new ArrayList());
        this.menuList.add(new H5NavMenuItem(resources.getString(R.string.h5_menu_copy), H5Param.MENU_COPY, resources.getDrawable(R.drawable.h5_nav_copy), false));
        this.menuList.add(new H5NavMenuItem(resources.getString(R.string.h5_menu_refresh), H5Param.MENU_REFRESH, resources.getDrawable(R.drawable.h5_nav_refresh), false));
        this.menuList.add(new H5NavMenuItem(resources.getString(R.string.h5_menu_open_in_browser), "openInBrowser", resources.getDrawable(R.drawable.h5_nav_browse), false));
        this.menuList.add(new H5NavMenuItem(resources.getString(R.string.h5_menu_font), H5Param.MENU_FONT, resources.getDrawable(R.drawable.h5_nav_font), false));
        this.h5NavMenuView.setList(this.menuList);
    }

    public void showMenu(View view) {
        tryInitView();
        if (this.popupWindow != null && this.popupWindow.isShowing()) {
            H5Log.d(TAG, "menu is showing!");
        } else if (this.menuUpdated || this.popupWindow == null) {
            this.popContainer.setVerticalScrollBarEnabled(true);
            this.popContainer.setOnClickListener(this.onClickListener);
            if (this.isShowPopMenu) {
                this.itemViewList = new ArrayList();
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.h5NavMenuView.getListCount(); i3++) {
                if (i3 != 0) {
                    View view2 = new View(this.context);
                    view2.setBackgroundResource(R.drawable.h5_popmenu_divider);
                    this.popContainer.addView(view2, new ViewGroup.LayoutParams(-1, 1));
                }
                View itemView = this.h5NavMenuView.getItemView(i3, this.popContainer);
                itemView.setOnClickListener(this.onClickListener);
                try {
                    itemView.measure(0, 0);
                } catch (Exception unused) {
                    i2 = H5Utils.dip2px(this.context, 200);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                if (i2 <= measuredWidth) {
                    i2 = measuredWidth;
                }
                this.popContainer.addView(itemView);
                if (this.isShowPopMenu) {
                    this.itemViewList.add(itemView);
                }
            }
            this.xOffset = (-i2) + (view.getWidth() / 2) + 28;
            this.yOffset = 0;
            this.popupWindow = new PopupWindow(this.rootView, i2, -2);
            this.popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.popupWindow.setTouchable(true);
            this.popupWindow.setFocusable(true);
            this.popupWindow.setOutsideTouchable(true);
            this.popupWindow.setClippingEnabled(false);
            this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    H5Log.d(H5NavMenu.TAG, "popupMenu onDismiss");
                    if (H5NavMenu.this.isShowPopMenu && H5NavMenu.this.itemViewList != null) {
                        H5NavMenu.this.itemViewList.clear();
                    }
                    H5NavMenu.this.contentView.removeView(H5NavMenu.this.maskView);
                    H5NavMenu.this.popContainer.removeAllViews();
                }
            });
            this.contentView.addView(this.maskView, this.mMatchParentLP);
            this.popupWindow.showAsDropDown(view, this.xOffset, this.yOffset);
            this.popupWindow.update();
        }
    }

    public void refreshIcon(int i2) {
        List<View> list;
        if (this.isShowPopMenu && (list = this.itemViewList) != null && !list.isEmpty()) {
            ((ImageView) this.itemViewList.get(i2).findViewById(com.alipay.mobile.nebula.R.id.h5_iv_icon)).setImageDrawable(((H5NavMenuItem) this.menuList.get(i2)).icon);
        }
    }
}
