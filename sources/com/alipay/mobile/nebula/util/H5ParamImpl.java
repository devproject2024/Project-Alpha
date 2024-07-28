package com.alipay.mobile.nebula.util;

import com.alipay.mobile.h5container.api.H5Param;

public class H5ParamImpl {
    public static final String TAG = "H5ParamImpl";
    private Object defaultValue;
    private String longName;
    private String shortName;
    private H5Param.ParamType type;

    public H5ParamImpl(String str, String str2, H5Param.ParamType paramType, Object obj) {
        this.longName = str;
        this.shortName = str2;
        this.type = paramType;
        this.defaultValue = obj;
    }

    public void setDefaultValue(Object obj) {
        this.defaultValue = obj;
    }

    public String getLongName() {
        return this.longName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public H5Param.ParamType getType() {
        return this.type;
    }

    public void setType(H5Param.ParamType paramType) {
        this.type = paramType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0070, code lost:
        if ("true".equalsIgnoreCase(r0) != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle unify(android.os.Bundle r6, boolean r7) {
        /*
            r5 = this;
            if (r7 != 0) goto L_0x0013
            java.lang.String r7 = r5.longName
            boolean r7 = com.alipay.mobile.nebula.util.H5Utils.contains((android.os.Bundle) r6, (java.lang.String) r7)
            if (r7 != 0) goto L_0x0013
            java.lang.String r7 = r5.shortName
            boolean r7 = com.alipay.mobile.nebula.util.H5Utils.contains((android.os.Bundle) r6, (java.lang.String) r7)
            if (r7 != 0) goto L_0x0013
            return r6
        L_0x0013:
            com.alipay.mobile.h5container.api.H5Param$ParamType r7 = com.alipay.mobile.h5container.api.H5Param.ParamType.BOOLEAN
            com.alipay.mobile.h5container.api.H5Param$ParamType r0 = r5.type
            java.lang.String r1 = "H5ParamImpl"
            r2 = 0
            if (r7 != r0) goto L_0x0084
            java.lang.Object r7 = r5.defaultValue
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.lang.String r0 = r5.shortName
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r5.shortName
            java.lang.Object r2 = r6.get(r0)
            goto L_0x0041
        L_0x0033:
            java.lang.String r0 = r5.longName
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r5.longName
            java.lang.Object r2 = r6.get(r0)
        L_0x0041:
            boolean r0 = r2 instanceof java.lang.String
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0073
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r0 = r2.trim()
            java.lang.String r2 = "YES"
            boolean r2 = r2.equalsIgnoreCase(r0)
            if (r2 == 0) goto L_0x0057
        L_0x0055:
            r7 = 1
            goto L_0x007d
        L_0x0057:
            java.lang.String r2 = "NO"
            boolean r2 = r2.equalsIgnoreCase(r0)
            if (r2 == 0) goto L_0x0061
        L_0x005f:
            r7 = 0
            goto L_0x007d
        L_0x0061:
            java.lang.String r2 = "false"
            boolean r2 = r2.equalsIgnoreCase(r0)
            if (r2 == 0) goto L_0x006a
            goto L_0x005f
        L_0x006a:
            java.lang.String r2 = "true"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x007d
            goto L_0x0055
        L_0x0073:
            boolean r0 = r2 instanceof java.lang.Boolean
            if (r0 == 0) goto L_0x007d
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r7 = r2.booleanValue()
        L_0x007d:
            java.lang.String r0 = r5.longName
            r6.putBoolean(r0, r7)
            goto L_0x0166
        L_0x0084:
            com.alipay.mobile.h5container.api.H5Param$ParamType r7 = com.alipay.mobile.h5container.api.H5Param.ParamType.STRING
            com.alipay.mobile.h5container.api.H5Param$ParamType r0 = r5.type
            if (r7 != r0) goto L_0x00b8
            java.lang.Object r7 = r5.defaultValue
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r0 = r5.shortName
            boolean r0 = com.alipay.mobile.nebula.util.H5Utils.contains((android.os.Bundle) r6, (java.lang.String) r0)
            if (r0 == 0) goto L_0x009d
            java.lang.String r0 = r5.shortName
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r6, (java.lang.String) r0, (java.lang.String) r7)
            goto L_0x00ab
        L_0x009d:
            java.lang.String r0 = r5.longName
            boolean r0 = com.alipay.mobile.nebula.util.H5Utils.contains((android.os.Bundle) r6, (java.lang.String) r0)
            if (r0 == 0) goto L_0x00ab
            java.lang.String r0 = r5.longName
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r6, (java.lang.String) r0, (java.lang.String) r7)
        L_0x00ab:
            if (r7 == 0) goto L_0x00b1
            java.lang.String r7 = r7.trim()
        L_0x00b1:
            java.lang.String r0 = r5.longName
            r6.putString(r0, r7)
            goto L_0x0166
        L_0x00b8:
            com.alipay.mobile.h5container.api.H5Param$ParamType r7 = com.alipay.mobile.h5container.api.H5Param.ParamType.INT
            com.alipay.mobile.h5container.api.H5Param$ParamType r0 = r5.type
            boolean r7 = r7.equals(r0)
            java.lang.String r0 = "Exception"
            if (r7 == 0) goto L_0x0113
            java.lang.Object r7 = r5.defaultValue
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.String r3 = r5.shortName
            boolean r3 = r6.containsKey(r3)
            if (r3 == 0) goto L_0x00db
            java.lang.String r2 = r5.shortName
            java.lang.Object r2 = r6.get(r2)
            goto L_0x00e9
        L_0x00db:
            java.lang.String r3 = r5.longName
            boolean r3 = r6.containsKey(r3)
            if (r3 == 0) goto L_0x00e9
            java.lang.String r2 = r5.longName
            java.lang.Object r2 = r6.get(r2)
        L_0x00e9:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x0103
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00fe }
            if (r3 != 0) goto L_0x010d
            int r7 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x00fe }
            goto L_0x010d
        L_0x00fe:
            r2 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r2)
            goto L_0x010d
        L_0x0103:
            boolean r0 = r2 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x010d
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r7 = r2.intValue()
        L_0x010d:
            java.lang.String r0 = r5.longName
            r6.putInt(r0, r7)
            goto L_0x0166
        L_0x0113:
            com.alipay.mobile.h5container.api.H5Param$ParamType r7 = com.alipay.mobile.h5container.api.H5Param.ParamType.DOUBLE
            com.alipay.mobile.h5container.api.H5Param$ParamType r3 = r5.type
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0166
            java.lang.Object r7 = r5.defaultValue
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            double r3 = (double) r7
            java.lang.String r7 = r5.shortName
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x0135
            java.lang.String r7 = r5.shortName
            java.lang.Object r2 = r6.get(r7)
            goto L_0x0143
        L_0x0135:
            java.lang.String r7 = r5.longName
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x0143
            java.lang.String r7 = r5.longName
            java.lang.Object r2 = r6.get(r7)
        L_0x0143:
            boolean r7 = r2 instanceof java.lang.String
            if (r7 == 0) goto L_0x0157
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r7 = r2.trim()
            double r3 = java.lang.Double.parseDouble(r7)     // Catch:{ Exception -> 0x0152 }
            goto L_0x0161
        L_0x0152:
            r7 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r7)
            goto L_0x0161
        L_0x0157:
            boolean r7 = r2 instanceof java.lang.Double
            if (r7 == 0) goto L_0x0161
            java.lang.Double r2 = (java.lang.Double) r2
            double r3 = r2.doubleValue()
        L_0x0161:
            java.lang.String r7 = r5.longName
            r6.putDouble(r7, r3)
        L_0x0166:
            java.lang.String r7 = r5.longName
            java.lang.String r0 = r5.shortName
            boolean r7 = android.text.TextUtils.equals(r7, r0)
            if (r7 != 0) goto L_0x017a
            java.lang.String r7 = r5.shortName     // Catch:{ Exception -> 0x0176 }
            r6.remove(r7)     // Catch:{ Exception -> 0x0176 }
            goto L_0x017a
        L_0x0176:
            r7 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r7)
        L_0x017a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5ParamImpl.unify(android.os.Bundle, boolean):android.os.Bundle");
    }
}
