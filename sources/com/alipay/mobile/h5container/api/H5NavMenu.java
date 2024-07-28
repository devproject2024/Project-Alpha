package com.alipay.mobile.h5container.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.view.H5NavMenuItem;
import com.alipay.mobile.nebula.view.H5NavMenuView;
import java.util.List;

public class H5NavMenu implements H5NavMenuView {
    public List<H5NavMenuItem> menuList;

    public void setList(List<H5NavMenuItem> list) {
        this.menuList = list;
    }

    public int getListCount() {
        return this.menuList.size();
    }

    public View getItemView(int i2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.h5_nav_menu_item, viewGroup, false);
        inflate.setTag(Integer.valueOf(i2));
        H5NavMenuItem h5NavMenuItem = this.menuList.get(i2);
        ((TextView) inflate.findViewById(R.id.h5_tv_title)).setText(h5NavMenuItem.name);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.h5_iv_icon);
        if (h5NavMenuItem.icon != null) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(h5NavMenuItem.icon);
        } else {
            imageView.setVisibility(8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.h5_popmenu_dot);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.h5_popmenu_dot_bg);
        TextView textView = (TextView) inflate.findViewById(R.id.h5_popmenu_dot_num);
        String str = h5NavMenuItem.redDotNum;
        if (TextUtils.isEmpty(str)) {
            str = H5BridgeContext.INVALID_ID;
        }
        if (!TextUtils.isEmpty(str)) {
            int i3 = -1;
            try {
                i3 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
            relativeLayout.setVisibility(i3 >= 0 ? 0 : 8);
            if (i3 == 0) {
                imageView2.setVisibility(0);
                textView.setVisibility(8);
            } else if (i3 > 0) {
                textView.setVisibility(0);
                imageView2.setVisibility(8);
                textView.setText(i3 > 99 ? context.getString(R.string.h5_more_dot) : String.valueOf(i3));
            }
        }
        return inflate;
    }
}
