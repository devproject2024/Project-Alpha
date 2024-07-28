package com.alipay.mobile.h5container.api;

import com.alipay.mobile.nebula.util.H5Log;

public class H5PageImage {
    public static String TAG = "H5PageImage";
    public long costTime;
    public String size;
    public int statusCode;
    public String url;

    public H5PageImage() {
        this.url = "";
        this.size = "";
        this.statusCode = 0;
        this.costTime = 0;
    }

    public H5PageImage(String str, String str2, int i2, long j) {
        this.url = str;
        this.size = str2;
        this.statusCode = i2;
        this.costTime = j;
        String str3 = TAG;
        H5Log.d(str3, "url=" + str + ", size=" + str2 + ", statusCode" + i2 + ", costTime" + j);
    }

    public String toString() {
        return "H5PageImage{url='" + this.url + '\'' + ", size='" + this.size + '\'' + ", statusCode=" + this.statusCode + ", costTime=" + this.costTime + '}';
    }
}
