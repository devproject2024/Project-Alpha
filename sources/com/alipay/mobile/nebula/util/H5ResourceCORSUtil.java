package com.alipay.mobile.nebula.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.a.e;
import com.alibaba.a.a;
import com.alibaba.a.b;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class H5ResourceCORSUtil {
    private static e<String, Boolean> sNeedHeaderMap = new e<>(20);
    private static List<Pattern> sWhiteListPattern;

    static {
        initConfig();
    }

    private static void initConfig() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            String config = h5ConfigProvider.getConfig("h5_CORSWhiteList");
            if (!TextUtils.isEmpty(config)) {
                try {
                    b jSONArray = a.parseObject(config).getJSONArray("white_list");
                    if (jSONArray != null && jSONArray.size() > 0) {
                        sWhiteListPattern = new ArrayList();
                        int size = jSONArray.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            Pattern compile = H5PatternHelper.compile(jSONArray.getString(i2));
                            if (compile != null) {
                                sWhiteListPattern.add(compile);
                            }
                        }
                    }
                } catch (PatternSyntaxException e2) {
                    H5Log.e("H5ResourceCORSUtil", "pattern error", e2);
                } catch (Throwable th) {
                    H5Log.e("H5ResourceCORSUtil", "parse config error", th);
                }
            }
        }
    }

    public static boolean needAddHeader(String str) {
        int i2 = 0;
        try {
            if (sWhiteListPattern == null) {
                return false;
            }
            if (sWhiteListPattern.size() == 0) {
                return false;
            }
            String purifyUrl = H5UrlHelper.purifyUrl(str);
            Boolean bool = sNeedHeaderMap.get(purifyUrl);
            if (bool != null) {
                return bool.booleanValue();
            }
            int size = sWhiteListPattern.size();
            boolean z = false;
            while (i2 < size) {
                try {
                    if (sWhiteListPattern.get(i2).matcher(purifyUrl).matches()) {
                        z = true;
                    }
                    i2++;
                } catch (Throwable unused) {
                    return z;
                }
            }
            sNeedHeaderMap.put(purifyUrl, Boolean.valueOf(z));
            return z;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static String getCORSUrl(String str) {
        try {
            Uri parseUrl = H5UrlHelper.parseUrl(str);
            return parseUrl.getScheme() + "://" + parseUrl.getAuthority();
        } catch (Throwable unused) {
            return null;
        }
    }
}
