package com.alipay.mobile.nebula.util;

import android.net.Uri;
import com.alibaba.a.b;
import java.util.List;

public class H5DomainUtil {
    private static final String TAG = "H5DomainUtil";

    public static String getNewDomainSuffix(String str) {
        Uri parseUrl = H5UrlHelper.parseUrl(str);
        if (parseUrl == null) {
            return null;
        }
        return parseUrl.getScheme() + "://" + parseUrl.getHost();
    }

    public static boolean isSomeDomainInternal(String str, String str2) {
        if (str == null) {
            return false;
        }
        try {
            b parseArray = H5Utils.parseArray(str2);
            if (parseArray != null) {
                for (int i2 = 0; i2 < parseArray.size(); i2++) {
                    if (H5PatternHelper.matchRegex(parseArray.getString(i2), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            H5Log.e(TAG, "exception detail.", th);
        }
        return false;
    }

    public static boolean isInDomain(String str, List<String> list) {
        if (!(str == null || list == null)) {
            try {
                if (!list.isEmpty()) {
                    for (String matchRegex : list) {
                        if (H5PatternHelper.matchRegex(matchRegex, str)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                H5Log.e(TAG, "exception detail.", th);
            }
        }
        return false;
    }
}
