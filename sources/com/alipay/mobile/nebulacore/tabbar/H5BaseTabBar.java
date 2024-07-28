package com.alipay.mobile.nebulacore.tabbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5TabbarItem;
import com.alipay.mobile.nebula.view.H5TabbarLayout;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.ui.H5ViewHolder;
import java.lang.ref.WeakReference;

public abstract class H5BaseTabBar extends H5SimplePlugin {
    public static final String TAG = "H5BaseTabBar";
    public WeakReference<Activity> context;
    H5ViewHolder pageViewHolder;
    LinearLayout tabBarView;
    H5TabbarLayout tabHost;

    public abstract void addTabBar();

    public abstract void setPageViewHolder(H5ViewHolder h5ViewHolder);

    public View getContent() {
        return this.tabBarView;
    }

    public void createTabBar(e eVar, H5BridgeContext h5BridgeContext, Bundle bundle) {
        int i2;
        int i3;
        String str;
        e eVar2 = eVar;
        String str2 = TAG;
        H5Log.d(str2, "createTabBar");
        int i4 = H5Utils.getInt(eVar2, "textColor");
        int i5 = H5Utils.getInt(eVar2, "selectedColor");
        int i6 = H5Utils.getInt(eVar2, "selectedIndex");
        int i7 = H5Utils.getInt(eVar2, "backgroundColor", -460551) | -16777216;
        int i8 = H5Utils.getInt(eVar2, "shadowColor", -5526610);
        b jSONArray = H5Utils.getJSONArray(eVar2, "items", (b) null);
        if (jSONArray != null && !jSONArray.isEmpty()) {
            this.tabBarView = new LinearLayout((Context) this.context.get());
            this.tabBarView.setId(R.id.h5_tabrootview);
            this.tabBarView.setOrientation(1);
            this.tabHost = new H5TabbarLayout((Context) this.context.get());
            this.tabHost.setId(R.id.h5_tabhost);
            final H5BridgeContext h5BridgeContext2 = h5BridgeContext;
            this.tabHost.setTabListener(new H5TabbarLayout.H5TabListener() {
                public void onTabItemClicked(int i2, View view) {
                    H5BaseTabBar.this.tabHost.selectTab(i2);
                    if (h5BridgeContext2 != null) {
                        e eVar = new e();
                        eVar.put("tag", view.getTag());
                        e eVar2 = new e();
                        eVar2.put("data", (Object) eVar);
                        h5BridgeContext2.sendToWeb("tabClick", eVar2, (H5CallBack) null);
                    }
                }
            });
            int size = jSONArray.size();
            int i9 = 0;
            int i10 = 0;
            while (i10 < size && i10 < 5) {
                e jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject == null || jSONObject.isEmpty()) {
                    i3 = i10;
                    i2 = size;
                    str = str2;
                } else {
                    String string = jSONObject.getString("name");
                    String string2 = jSONObject.getString("tag");
                    String string3 = jSONObject.getString(H5Param.MENU_ICON);
                    String string4 = jSONObject.getString("activeIcon");
                    String string5 = jSONObject.getString("redDot");
                    H5Log.d(str2, "createTabBar badge value is ".concat(String.valueOf(string5)));
                    H5TabbarItem h5TabbarItem = new H5TabbarItem((Context) this.context.get());
                    h5TabbarItem.setTag(string2);
                    TextView textView = (TextView) h5TabbarItem.getIconAreaView();
                    textView.setText(string);
                    textView.setTextColor(h5TabbarItem.generateTextColor(i4, i5));
                    StateListDrawable generateEmptyTopDrawable = h5TabbarItem.generateEmptyTopDrawable();
                    int dimensionPixelSize = ((Activity) this.context.get()).getResources().getDimensionPixelSize(R.dimen.h5_bottom_height_tab_icon);
                    generateEmptyTopDrawable.setBounds(i9, i9, dimensionPixelSize, dimensionPixelSize);
                    int i11 = dimensionPixelSize;
                    StateListDrawable stateListDrawable = generateEmptyTopDrawable;
                    StateListDrawable stateListDrawable2 = stateListDrawable;
                    i3 = i10;
                    str = str2;
                    int i12 = i11;
                    i2 = size;
                    H5TabbarItem h5TabbarItem2 = h5TabbarItem;
                    Bundle bundle2 = bundle;
                    loadImageAsync(string4, h5TabbarItem, stateListDrawable2, (Context) this.context.get(), i12, true, bundle2);
                    loadImageAsync(string3, h5TabbarItem2, stateListDrawable2, (Context) this.context.get(), i12, false, bundle2);
                    if (!TextUtils.isEmpty(string5)) {
                        String trim = string5.trim();
                        if (!TextUtils.equals(H5BridgeContext.INVALID_ID, trim)) {
                            if (TextUtils.equals("0", trim)) {
                                ((ImageView) h5TabbarItem2.getSmallBadgeAreaView()).setVisibility(0);
                            } else {
                                TextView textView2 = (TextView) h5TabbarItem2.getBadgeAreaView();
                                textView2.setVisibility(0);
                                textView2.setText(trim);
                            }
                        }
                    }
                    this.tabHost.addTab(h5TabbarItem2.getRootView());
                }
                i10 = i3 + 1;
                str2 = str;
                size = i2;
                i9 = 0;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            View view = new View((Context) this.context.get());
            view.setBackgroundColor(i8);
            this.tabBarView.addView(view, layoutParams);
            this.tabHost.selectTab(i6);
            this.tabHost.setBackgroundColor(i7);
            this.tabBarView.addView(this.tabHost, new LinearLayout.LayoutParams(-1, -1));
            addTabBar();
        }
    }

    public void createTabBadge(e eVar, H5BridgeContext h5BridgeContext) {
        H5Log.d(TAG, "createTabBadge ".concat(String.valueOf(h5BridgeContext)));
        if (this.tabHost != null) {
            String string = H5Utils.getString(eVar, "tag");
            String string2 = H5Utils.getString(eVar, "redDot");
            H5Log.d(TAG, "createTabBadge value is ".concat(String.valueOf(string2)));
            int childCount = this.tabHost.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.tabHost.getChildAt(i2);
                if (TextUtils.equals((String) childAt.getTag(), string)) {
                    TextView textView = (TextView) childAt.findViewById(com.alipay.mobile.nebula.R.id.h5_tabbaritem_badge);
                    ImageView imageView = (ImageView) childAt.findViewById(com.alipay.mobile.nebula.R.id.h5_tabbaritem_badge_small);
                    if (TextUtils.isEmpty(string2)) {
                        textView.setVisibility(8);
                        imageView.setVisibility(8);
                        return;
                    }
                    String trim = string2.trim();
                    if (TextUtils.equals(H5BridgeContext.INVALID_ID, trim)) {
                        textView.setVisibility(8);
                        imageView.setVisibility(8);
                        return;
                    } else if (TextUtils.equals("0", trim)) {
                        textView.setVisibility(8);
                        imageView.setVisibility(0);
                        return;
                    } else {
                        textView.setText(trim);
                        textView.setVisibility(0);
                        imageView.setVisibility(8);
                        return;
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void loadImageAsync(String str, H5TabbarItem h5TabbarItem, StateListDrawable stateListDrawable, Context context2, int i2, boolean z, Bundle bundle) {
        String string = H5Utils.getString(bundle, H5Param.ONLINE_HOST);
        String string2 = H5Utils.getString(bundle, H5Param.CDN_HOST);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && str.startsWith(string)) {
            str = str.replace(string, string2);
            H5Log.d(TAG, " after replace ".concat(String.valueOf(str)));
        }
        if (!str.startsWith("http")) {
            Bitmap base64ToBitmap = H5ImageUtil.base64ToBitmap(str);
            if (base64ToBitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context2.getResources(), base64ToBitmap);
                bitmapDrawable.setBounds(0, 0, i2, i2);
                if (z) {
                    h5TabbarItem.addCheckedState(stateListDrawable, bitmapDrawable);
                } else {
                    h5TabbarItem.addNormalState(stateListDrawable, bitmapDrawable);
                }
                ((TextView) h5TabbarItem.getIconAreaView()).setCompoundDrawables((Drawable) null, stateListDrawable, (Drawable) null, (Drawable) null);
                return;
            }
            return;
        }
        final Context context3 = context2;
        final int i3 = i2;
        final boolean z2 = z;
        final H5TabbarItem h5TabbarItem2 = h5TabbarItem;
        final StateListDrawable stateListDrawable2 = stateListDrawable;
        Nebula.loadImage(str, new H5ImageListener() {
            public void onImage(Bitmap bitmap) {
                if (bitmap != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(context3.getResources(), bitmap);
                    int i2 = i3;
                    bitmapDrawable.setBounds(0, 0, i2, i2);
                    if (z2) {
                        h5TabbarItem2.addCheckedState(stateListDrawable2, bitmapDrawable);
                    } else {
                        h5TabbarItem2.addNormalState(stateListDrawable2, bitmapDrawable);
                    }
                    H5Utils.runOnMain(new Runnable() {
                        public void run() {
                            ((TextView) h5TabbarItem2.getIconAreaView()).setCompoundDrawables((Drawable) null, stateListDrawable2, (Drawable) null, (Drawable) null);
                        }
                    });
                }
            }
        });
    }
}
