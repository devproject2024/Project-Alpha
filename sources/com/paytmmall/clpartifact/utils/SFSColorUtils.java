package com.paytmmall.clpartifact.utils;

import android.content.Context;
import com.paytmmall.clpartifact.R;

public class SFSColorUtils {
    public static int getParsedColor(String str, Context context) {
        return getParsedColor(str, context, R.color.clp_white);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        return r1.getResources().getColor(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return r1.getResources().getColor(com.paytmmall.clpartifact.R.color.clp_white);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getParsedColor(java.lang.String r0, android.content.Context r1, int r2) {
        /*
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ Exception -> 0x0005 }
            return r0
        L_0x0005:
            android.content.res.Resources r0 = r1.getResources()     // Catch:{ NotFoundException -> 0x000e }
            int r0 = r0.getColor(r2)     // Catch:{ NotFoundException -> 0x000e }
            return r0
        L_0x000e:
            android.content.res.Resources r0 = r1.getResources()
            int r1 = com.paytmmall.clpartifact.R.color.clp_white
            int r0 = r0.getColor(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.SFSColorUtils.getParsedColor(java.lang.String, android.content.Context, int):int");
    }
}
