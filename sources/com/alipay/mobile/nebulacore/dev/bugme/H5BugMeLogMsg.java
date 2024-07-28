package com.alipay.mobile.nebulacore.dev.bugme;

import com.alibaba.a.e;

public class H5BugMeLogMsg {
    private String mContent;

    H5BugMeLogMsg(e eVar) {
        this.mContent = castToString(eVar);
    }

    public String getContent() {
        return this.mContent;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String castToString(com.alibaba.a.e r10) {
        /*
            r9 = this;
            java.lang.String r0 = "type"
            java.lang.String r0 = r10.getString(r0)
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            switch(r1) {
                case 3433103: goto L_0x003c;
                case 96891546: goto L_0x0032;
                case 101415985: goto L_0x0028;
                case 951510359: goto L_0x001e;
                case 1843485230: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0046
        L_0x0014:
            java.lang.String r1 = "network"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0046
            r0 = 4
            goto L_0x0047
        L_0x001e:
            java.lang.String r1 = "console"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0046
            r0 = 3
            goto L_0x0047
        L_0x0028:
            java.lang.String r1 = "jsapi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0032:
            java.lang.String r1 = "event"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0046
            r0 = 2
            goto L_0x0047
        L_0x003c:
            java.lang.String r1 = "page"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0046
            r0 = 0
            goto L_0x0047
        L_0x0046:
            r0 = -1
        L_0x0047:
            java.lang.String r1 = "subType"
            java.lang.String r7 = ""
            java.lang.String r8 = "line.separator"
            if (r0 == 0) goto L_0x0157
            if (r0 == r6) goto L_0x0121
            if (r0 == r4) goto L_0x0103
            if (r0 == r3) goto L_0x00fb
            if (r0 == r2) goto L_0x005e
            java.lang.String r10 = r10.toJSONString()
            goto L_0x026b
        L_0x005e:
            java.lang.String r0 = "method"
            java.lang.String r0 = r10.getString(r0)
            java.lang.String r1 = "reqUrl"
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r2 = "statusCode"
            java.lang.String r2 = r10.getString(r2)
            java.lang.String r3 = "fromLocalPkg"
            boolean r4 = r10.containsKey(r3)
            if (r4 == 0) goto L_0x0082
            java.lang.Boolean r10 = r10.getBoolean(r3)
            boolean r10 = r10.booleanValue()
            goto L_0x0083
        L_0x0082:
            r10 = 0
        L_0x0083:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r4 = "method - "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            if (r10 == 0) goto L_0x00aa
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r0 = " - fromLocalPkg"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
        L_0x00aa:
            boolean r10 = android.text.TextUtils.isEmpty(r2)
            if (r10 != 0) goto L_0x00d2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r0 = java.lang.System.getProperty(r8)
            r10.append(r0)
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r2
            java.lang.String r2 = "statusCode - %s"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            goto L_0x00d3
        L_0x00d2:
            r10 = r0
        L_0x00d3:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x026b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = java.lang.System.getProperty(r8)
            r0.append(r10)
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r10[r5] = r1
            java.lang.String r1 = "reqUrl - %s"
            java.lang.String r10 = java.lang.String.format(r1, r10)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            goto L_0x026b
        L_0x00fb:
            java.lang.String r0 = "content"
            java.lang.String r10 = r10.getString(r0)
            goto L_0x026b
        L_0x0103:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = r10.getString(r1)
            r0[r5] = r1
            java.lang.String r1 = java.lang.System.getProperty(r8)
            r0[r6] = r1
            java.lang.String r1 = "data"
            java.lang.String r10 = r10.getString(r1)
            r0[r4] = r10
            java.lang.String r10 = "event - %s%sdata - %s"
            java.lang.String r10 = java.lang.String.format(r10, r0)
            goto L_0x026b
        L_0x0121:
            java.lang.String r0 = r10.getString(r1)
            java.lang.String r1 = "request"
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r7 = "response"
            java.lang.String r10 = r10.getString(r7)
            r7 = 5
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r5] = r0
            java.lang.String r0 = java.lang.System.getProperty(r8)
            r7[r6] = r0
            java.lang.String r0 = "{}"
            if (r1 != 0) goto L_0x0142
            r1 = r0
        L_0x0142:
            r7[r4] = r1
            java.lang.String r1 = java.lang.System.getProperty(r8)
            r7[r3] = r1
            if (r10 != 0) goto L_0x014d
            r10 = r0
        L_0x014d:
            r7[r2] = r10
            java.lang.String r10 = "jsApi - %s %srequest - %s %sresponse - %s"
            java.lang.String r10 = java.lang.String.format(r10, r7)
            goto L_0x026b
        L_0x0157:
            java.lang.String r0 = "url"
            java.lang.String r0 = r10.getString(r0)
            java.lang.String r2 = "params"
            java.lang.String r2 = r10.getString(r2)
            java.lang.String r3 = "userAgent"
            java.lang.String r3 = r10.getString(r3)
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r4 = "viewId"
            java.lang.String r10 = r10.getString(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x0192
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = "url - "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            goto L_0x0193
        L_0x0192:
            r0 = r7
        L_0x0193:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x01c9
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01a9
            r0 = r7
            goto L_0x01ad
        L_0x01a9:
            java.lang.String r0 = java.lang.System.getProperty(r8)
        L_0x01ad:
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = "subType - "
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
        L_0x01c9:
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x01ff
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01df
            r0 = r7
            goto L_0x01e3
        L_0x01df:
            java.lang.String r0 = java.lang.System.getProperty(r8)
        L_0x01e3:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "viewId - "
            r1.append(r0)
            r1.append(r10)
            java.lang.String r0 = r1.toString()
        L_0x01ff:
            boolean r10 = android.text.TextUtils.isEmpty(r2)
            if (r10 != 0) goto L_0x0235
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0215
            r0 = r7
            goto L_0x0219
        L_0x0215:
            java.lang.String r0 = java.lang.System.getProperty(r8)
        L_0x0219:
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = "params - "
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
            goto L_0x0236
        L_0x0235:
            r10 = r0
        L_0x0236:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x026b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x024b
            goto L_0x024f
        L_0x024b:
            java.lang.String r7 = java.lang.System.getProperty(r8)
        L_0x024f:
            r0.append(r7)
            java.lang.String r10 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = "userAgent - "
            r0.append(r10)
            r0.append(r3)
            java.lang.String r10 = r0.toString()
        L_0x026b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.bugme.H5BugMeLogMsg.castToString(com.alibaba.a.e):java.lang.String");
    }
}
