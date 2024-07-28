package com.alipay.mobile.nebula.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.mobile.nebula.R;

public class H5TabbarItem {
    private TextView badgeArea = ((TextView) this.rootView.findViewById(R.id.h5_tabbaritem_badge));
    private TextView iconArea = ((TextView) this.rootView.findViewById(R.id.h5_tabbaritem_txticon));
    private RelativeLayout rootView;
    private ImageView smallbadgeArea = ((ImageView) this.rootView.findViewById(R.id.h5_tabbaritem_badge_small));

    public H5TabbarItem(Context context) {
        this.rootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.h5_tabbaritem, (ViewGroup) null);
    }

    public View getRootView() {
        return this.rootView;
    }

    public View getIconAreaView() {
        return this.iconArea;
    }

    public View getBadgeAreaView() {
        return this.badgeArea;
    }

    public View getSmallBadgeAreaView() {
        return this.smallbadgeArea;
    }

    public void setTag(String str) {
        this.rootView.setTag(str);
    }

    public String getTag() {
        return (String) this.rootView.getTag();
    }

    public StateListDrawable generateTopDrawable(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            return null;
        }
        if (drawable2 == null) {
            drawable2 = drawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public StateListDrawable generateEmptyTopDrawable() {
        return new StateListDrawable();
    }

    public void addCheckedState(StateListDrawable stateListDrawable, Drawable drawable) {
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[]{16842913}, drawable);
    }

    public void addNormalState(StateListDrawable stateListDrawable, Drawable drawable) {
        stateListDrawable.addState(new int[0], drawable);
    }

    public ColorStateList generateTextColor(int i2, int i3) {
        int i4 = i3 | -16777216;
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[0]}, new int[]{i4, i4, i2 | -16777216});
    }
}
