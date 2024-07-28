package com.alipay.mobile.nebulacore.data;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5PrefData implements H5Data {
    private SharedPreferences sp;

    public H5PrefData(String str) {
        String str2 = "h5_data_";
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + str;
        }
        this.sp = H5Environment.getContext().getSharedPreferences(str2, 0);
    }

    public void set(String str, String str2) {
        this.sp.edit().putString(str, str2).apply();
    }

    public String get(String str) {
        return this.sp.getString(str, (String) null);
    }

    public String remove(String str) {
        String string = this.sp.getString(str, (String) null);
        if (!TextUtils.isEmpty(string)) {
            this.sp.edit().remove(str).apply();
        }
        return string;
    }

    public boolean has(String str) {
        return this.sp.contains(str);
    }
}
