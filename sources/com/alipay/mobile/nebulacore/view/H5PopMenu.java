package com.alipay.mobile.nebulacore.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.provider.H5SharePanelProvider;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5NavMenuItem;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class H5PopMenu {
    private static final int MAX_MENU_LEN = 8;
    private static final int MAX_TEMP_COUNT = 11;
    public static final String TAG = "H5PopMenu";
    H5Page h5Page;
    boolean isShowPopMenu;
    List<H5NavMenuItem> menuList;
    boolean menuUpdated;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (H5PopMenu.this.popupWindow != null && H5PopMenu.this.popupWindow.isShowing()) {
                H5PopMenu.this.popupWindow.dismiss();
            }
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                H5NavMenuItem h5NavMenuItem = H5PopMenu.this.menuList.get(((Integer) tag).intValue());
                h5NavMenuItem.setRedDotNum(H5BridgeContext.INVALID_ID);
                e eVar = new e();
                eVar.put("name", (Object) h5NavMenuItem.name);
                eVar.put("tag", (Object) h5NavMenuItem.tag);
                eVar.put("title", (Object) h5NavMenuItem.name);
                eVar.put("url", (Object) H5PopMenu.this.h5Page.getUrl());
                if (H5PopMenu.this.isShowPopMenu) {
                    eVar.put(H5Param.POP_MENU_TYPE, (Object) "popmenu");
                }
                H5PopMenu.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_TOOLBAR_MENU_BT, eVar);
            }
        }
    };
    PopupWindow popupWindow;
    List<H5NavMenuItem> tempList;

    public abstract void clearMenuList();

    public abstract void initMenu();

    public abstract void refreshIcon(int i2);

    public abstract void showMenu(View view);

    public H5PopMenu() {
        initMenu();
        this.menuUpdated = true;
        this.isShowPopMenu = false;
    }

    public void setPage(H5Page h5Page2) {
        this.h5Page = h5Page2;
    }

    public void setIsShowPopMenu(boolean z) {
        this.isShowPopMenu = z;
    }

    public boolean hasMenu(String str) {
        List<H5NavMenuItem> list = this.menuList;
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (int size = this.menuList.size() - 1; size >= 0; size--) {
                H5NavMenuItem h5NavMenuItem = this.menuList.get(size);
                if (h5NavMenuItem != null && str.equals(h5NavMenuItem.tag)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setMenu(H5Event h5Event, boolean z) {
        int i2;
        int i3;
        int i4;
        List<H5NavMenuItem> list;
        e param = h5Event.getParam();
        boolean z2 = false;
        if (H5Utils.getBoolean(param, UpiConstants.UPI_RESET_TOKEN, false)) {
            resetMenu();
            return;
        }
        b jSONArray = H5Utils.getJSONArray(param, "menus", (b) null);
        if (H5Utils.getBoolean(param, "override", this.isShowPopMenu) && (list = this.menuList) != null) {
            list.clear();
        }
        if (this.isShowPopMenu) {
            this.menuList.clear();
        }
        if (!z || (jSONArray != null && !jSONArray.isEmpty())) {
            synchronized (this.menuList) {
                i2 = 0;
                for (int i5 = 0; i5 < this.menuList.size(); i5++) {
                    if (this.menuList.get(i5).temp) {
                        i2++;
                    }
                }
            }
            if (z && i2 >= 11) {
                H5Log.e(TAG, "reach max temp count!");
            } else if (jSONArray == null || this.menuList.size() + jSONArray.size() < 11) {
                int i6 = 11 - i2;
                this.tempList = new ArrayList();
                for (int i7 = 0; i7 < jSONArray.size(); i7++) {
                    e jSONObject = jSONArray.getJSONObject(i7);
                    String string = H5Utils.getString(jSONObject, "name");
                    String string2 = H5Utils.getString(jSONObject, "tag");
                    String string3 = H5Utils.getString(jSONObject, H5Param.MENU_ICON);
                    String string4 = H5Utils.getString(jSONObject, "redDot");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        if (!hasMenu(string, string2)) {
                            if (string.length() > 8) {
                                string = string.substring(0, 8);
                            }
                            Drawable drawable = getDrawable(string2);
                            if (this.isShowPopMenu) {
                                drawable = null;
                            }
                            H5NavMenuItem h5NavMenuItem = new H5NavMenuItem(string, string2, drawable, z);
                            if (this.isShowPopMenu && !TextUtils.isEmpty(string4)) {
                                h5NavMenuItem.setRedDotNum(string4);
                            }
                            h5NavMenuItem.iconUrl = string3;
                            if (this.tempList.size() >= i6) {
                                break;
                            } else if (H5Param.MENU_SHARE.equals(string2)) {
                                h5NavMenuItem.temp = false;
                                this.menuList.add(0, h5NavMenuItem);
                            } else if (H5Param.MENU_COMPLAIN.equals(string2)) {
                                h5NavMenuItem.temp = false;
                                this.menuList.add(h5NavMenuItem);
                            } else {
                                this.tempList.add(h5NavMenuItem);
                            }
                        } else {
                            H5Log.w(TAG, "existed tag: " + string2 + " name: " + string);
                        }
                    } else {
                        H5Log.w(TAG, "invalid tag: " + string2 + " name: " + string);
                    }
                }
                synchronized (this.menuList) {
                    i3 = -1;
                    i4 = -1;
                    for (int i8 = 0; i8 < this.menuList.size(); i8++) {
                        H5NavMenuItem h5NavMenuItem2 = this.menuList.get(i8);
                        if (h5NavMenuItem2.temp) {
                            if (i3 < 0) {
                                i3 = i8;
                            }
                        } else if (i4 < 0 && (i8 != 0 || !H5Param.MENU_SHARE.equals(h5NavMenuItem2.tag))) {
                            i4 = i8;
                        }
                    }
                }
                if (i3 == -1) {
                    i3 = (this.menuList.size() <= 0 || !H5Param.MENU_SHARE.equals(this.menuList.get(0).tag)) ? 0 : 1;
                }
                if (i4 == -1) {
                    i4 = 0;
                }
                if (z) {
                    this.menuList.addAll(i3, this.tempList);
                } else {
                    this.menuList.addAll(i4, this.tempList);
                }
                getMenuIcon();
                H5SharePanelProvider h5SharePanelProvider = (H5SharePanelProvider) Nebula.getProviderManager().getProvider(H5SharePanelProvider.class.getName());
                if (h5SharePanelProvider == null || this.h5Page == null || this.isShowPopMenu) {
                    StringBuilder sb = new StringBuilder("h5SharePanelProvider null ? ");
                    sb.append(h5SharePanelProvider == null);
                    sb.append("   h5Page null ? ");
                    if (this.h5Page == null) {
                        z2 = true;
                    }
                    sb.append(z2);
                    H5Log.d(TAG, sb.toString());
                    return;
                }
                H5Log.d("H5SharePanelProviderImp", "param = ".concat(String.valueOf(param)));
                H5Log.d("H5SharePanelProviderImp", "h5page = " + this.h5Page.hashCode());
                h5SharePanelProvider.addMenuList(this.h5Page.hashCode(), this.menuList);
                for (H5NavMenuItem next : this.menuList) {
                    H5Log.d("H5SharePanelProviderImp", "### addMenuList ### menu : " + next.name + " tag:" + next.tag);
                }
            } else {
                H5Log.e(TAG, "(oriCount + addCount) >= MAX_TEMP_COUNT!");
            }
        } else {
            H5Log.d(TAG, "menu not set");
        }
    }

    public void getMenuIcon() {
        for (H5NavMenuItem next : this.menuList) {
            String str = next.iconUrl;
            boolean z = next.iconDownloading;
            final String str2 = next.name;
            if (!TextUtils.isEmpty(str) && !z) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    Nebula.loadImage(str, new H5ImageListener() {
                        public void onImage(Bitmap bitmap) {
                            H5PopMenu.this.setMenuIcon(str2, new BitmapDrawable(bitmap));
                        }
                    });
                } else {
                    setMenuIcon(str2, H5ImageUtil.byteToDrawable(str));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setMenuIcon(java.lang.String r5, android.graphics.drawable.Drawable r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x0035
            if (r6 != 0) goto L_0x000a
            goto L_0x0035
        L_0x000a:
            r0 = 0
            java.util.List<com.alipay.mobile.nebula.view.H5NavMenuItem> r1 = r4.menuList     // Catch:{ all -> 0x0037 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0011:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0037 }
            com.alipay.mobile.nebula.view.H5NavMenuItem r2 = (com.alipay.mobile.nebula.view.H5NavMenuItem) r2     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = r2.name     // Catch:{ all -> 0x0037 }
            boolean r3 = android.text.TextUtils.equals(r3, r5)     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0030
            r2.icon = r6     // Catch:{ all -> 0x0037 }
            boolean r5 = r4.isShowPopMenu     // Catch:{ all -> 0x0037 }
            if (r5 == 0) goto L_0x0033
            r4.refreshIcon(r0)     // Catch:{ all -> 0x0037 }
            monitor-exit(r4)
            return
        L_0x0030:
            int r0 = r0 + 1
            goto L_0x0011
        L_0x0033:
            monitor-exit(r4)
            return
        L_0x0035:
            monitor-exit(r4)
            return
        L_0x0037:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.view.H5PopMenu.setMenuIcon(java.lang.String, android.graphics.drawable.Drawable):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hasMenu(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.util.List<com.alipay.mobile.nebula.view.H5NavMenuItem> r0 = r3.menuList
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0024
            java.lang.Object r1 = r0.next()
            com.alipay.mobile.nebula.view.H5NavMenuItem r1 = (com.alipay.mobile.nebula.view.H5NavMenuItem) r1
            java.lang.String r2 = r1.name
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0022
            java.lang.String r1 = r1.tag
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0006
        L_0x0022:
            r4 = 1
            return r4
        L_0x0024:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.view.H5PopMenu.hasMenu(java.lang.String, java.lang.String):boolean");
    }

    public void addMenu(int i2, H5NavMenuItem h5NavMenuItem) {
        List<H5NavMenuItem> list = this.menuList;
        if (list != null && h5NavMenuItem != null) {
            list.add(i2, h5NavMenuItem);
        }
    }

    public void removeMenu(String str) {
        List<H5NavMenuItem> list = this.menuList;
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            int size = this.menuList.size() - 1;
            while (size >= 0) {
                H5NavMenuItem h5NavMenuItem = this.menuList.get(size);
                if (h5NavMenuItem == null || !str.equals(h5NavMenuItem.tag)) {
                    size--;
                } else {
                    this.menuList.remove(size);
                    return;
                }
            }
        }
    }

    private Drawable getDrawable(String str) {
        Resources resources = H5Environment.getResources();
        if (H5Param.MENU_COMPLAIN.equals(str)) {
            return resources.getDrawable(R.drawable.h5_nav_complain);
        }
        if (H5Param.MENU_SHARE.equals(str) || H5Param.MENU_SHARE_FRIEND.equals(str)) {
            return resources.getDrawable(R.drawable.h5_nav_share_friend);
        }
        return resources.getDrawable(R.drawable.h5_nav_default);
    }

    public void resetMenu() {
        for (int size = this.menuList.size() - 1; size >= 0; size--) {
            if (this.menuList.get(size).temp) {
                this.menuList.remove(size);
            }
        }
        this.menuUpdated = true;
        if (this.menuList.size() == 0) {
            initMenu();
        }
    }
}
