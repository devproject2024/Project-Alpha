package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import com.squareup.a.a;

public class SheroesThumbor {
    private static a thumbor;

    public static a getInstance() {
        if (thumbor == null) {
            if (CommonUtil.isNotEmpty(CommonUtil.getPref(AppConstants.THUMBOR_KEY))) {
                String pref = CommonUtil.getPref(AppConstants.THUMBOR_KEY);
                if (pref == null || pref.length() == 0) {
                    throw new IllegalArgumentException("Key must not be blank.");
                }
                thumbor = new a("https://t.sheroes.in", pref);
            } else {
                thumbor = new a("https://t.sheroes.in", (String) null);
            }
        }
        return thumbor;
    }
}
