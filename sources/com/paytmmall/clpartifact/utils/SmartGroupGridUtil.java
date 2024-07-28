package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;

public class SmartGroupGridUtil {
    public static String getFirstLetter(Item item) {
        return !TextUtils.isEmpty(item.getName()) ? String.valueOf(item.getName().charAt(0)) : "";
    }

    public static GradientDrawable setDrawableColor(int i2, Context context) {
        GradientDrawable gradientDrawable = (GradientDrawable) context.getResources().getDrawable(R.drawable.rounded_profile);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }

    public static GradientDrawable setPopUpBgColor(int i2, Context context) {
        GradientDrawable gradientDrawable = (GradientDrawable) context.getResources().getDrawable(R.drawable.sfs_popup_bg_white);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }
}
