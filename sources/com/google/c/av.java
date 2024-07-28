package com.google.c;

import com.business.merchant_payments.utility.StringUtility;
import java.util.List;
import java.util.Map;

final class av {
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a7, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ba, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01cb, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01dd, code lost:
        if (((java.lang.Double) r6).doubleValue() == 0.0d) goto L_0x01a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0216  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(com.google.c.at r13, java.lang.StringBuilder r14, int r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.TreeSet r2 = new java.util.TreeSet
            r2.<init>()
            java.lang.Class r3 = r13.getClass()
            java.lang.reflect.Method[] r3 = r3.getDeclaredMethods()
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x001a:
            java.lang.String r7 = "get"
            if (r6 >= r4) goto L_0x0049
            r8 = r3[r6]
            java.lang.String r9 = r8.getName()
            r1.put(r9, r8)
            java.lang.Class[] r9 = r8.getParameterTypes()
            int r9 = r9.length
            if (r9 != 0) goto L_0x0046
            java.lang.String r9 = r8.getName()
            r0.put(r9, r8)
            java.lang.String r9 = r8.getName()
            boolean r7 = r9.startsWith(r7)
            if (r7 == 0) goto L_0x0046
            java.lang.String r7 = r8.getName()
            r2.add(r7)
        L_0x0046:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x022f
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = r3.startsWith(r7)
            r6 = 3
            if (r4 == 0) goto L_0x0065
            java.lang.String r4 = r3.substring(r6)
            goto L_0x0066
        L_0x0065:
            r4 = r3
        L_0x0066:
            java.lang.String r8 = "List"
            boolean r9 = r4.endsWith(r8)
            r10 = 1
            if (r9 == 0) goto L_0x00c0
            java.lang.String r9 = "OrBuilderList"
            boolean r9 = r4.endsWith(r9)
            if (r9 != 0) goto L_0x00c0
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x00c0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r4.substring(r5, r10)
            java.lang.String r9 = r9.toLowerCase()
            r8.append(r9)
            int r9 = r4.length()
            int r9 = r9 + -4
            java.lang.String r9 = r4.substring(r10, r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object r9 = r0.get(r3)
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            if (r9 == 0) goto L_0x00c0
            java.lang.Class r11 = r9.getReturnType()
            java.lang.Class<java.util.List> r12 = java.util.List.class
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x00c0
            java.lang.String r3 = a(r8)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.c.aa.a((java.lang.reflect.Method) r9, (java.lang.Object) r13, (java.lang.Object[]) r4)
            a(r14, r15, r3, r4)
            goto L_0x004d
        L_0x00c0:
            java.lang.String r8 = "Map"
            boolean r9 = r4.endsWith(r8)
            if (r9 == 0) goto L_0x0123
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x0123
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r4.substring(r5, r10)
            java.lang.String r9 = r9.toLowerCase()
            r8.append(r9)
            int r9 = r4.length()
            int r9 = r9 - r6
            java.lang.String r6 = r4.substring(r10, r9)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.Object r3 = r0.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x0123
            java.lang.Class r8 = r3.getReturnType()
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0123
            java.lang.Class<java.lang.Deprecated> r8 = java.lang.Deprecated.class
            boolean r8 = r3.isAnnotationPresent(r8)
            if (r8 != 0) goto L_0x0123
            int r8 = r3.getModifiers()
            boolean r8 = java.lang.reflect.Modifier.isPublic(r8)
            if (r8 == 0) goto L_0x0123
            java.lang.String r4 = a(r6)
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Object r3 = com.google.c.aa.a((java.lang.reflect.Method) r3, (java.lang.Object) r13, (java.lang.Object[]) r6)
            a(r14, r15, r4, r3)
            goto L_0x004d
        L_0x0123:
            java.lang.String r3 = java.lang.String.valueOf(r4)
            java.lang.String r6 = "set"
            java.lang.String r3 = r6.concat(r3)
            java.lang.Object r3 = r1.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = "Bytes"
            boolean r3 = r4.endsWith(r3)
            if (r3 == 0) goto L_0x0159
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r7)
            int r6 = r4.length()
            int r6 = r6 + -5
            java.lang.String r6 = r4.substring(r5, r6)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            boolean r3 = r0.containsKey(r3)
            if (r3 != 0) goto L_0x004d
        L_0x0159:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.substring(r5, r10)
            java.lang.String r6 = r6.toLowerCase()
            r3.append(r6)
            java.lang.String r6 = r4.substring(r10)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            java.lang.String r6 = java.lang.String.valueOf(r4)
            java.lang.String r6 = r7.concat(r6)
            java.lang.Object r6 = r0.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r8 = "has"
            java.lang.String r4 = r8.concat(r4)
            java.lang.Object r4 = r0.get(r4)
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            if (r6 == 0) goto L_0x004d
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r6 = com.google.c.aa.a((java.lang.reflect.Method) r6, (java.lang.Object) r13, (java.lang.Object[]) r8)
            if (r4 != 0) goto L_0x0218
            boolean r4 = r6 instanceof java.lang.Boolean
            if (r4 == 0) goto L_0x01af
            r4 = r6
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x01ac
        L_0x01a9:
            r4 = 1
            goto L_0x0212
        L_0x01ac:
            r4 = 0
            goto L_0x0212
        L_0x01af:
            boolean r4 = r6 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x01bd
            r4 = r6
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 != 0) goto L_0x01ac
            goto L_0x01a9
        L_0x01bd:
            boolean r4 = r6 instanceof java.lang.Float
            if (r4 == 0) goto L_0x01ce
            r4 = r6
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x01ac
            goto L_0x01a9
        L_0x01ce:
            boolean r4 = r6 instanceof java.lang.Double
            if (r4 == 0) goto L_0x01e0
            r4 = r6
            java.lang.Double r4 = (java.lang.Double) r4
            double r8 = r4.doubleValue()
            r11 = 0
            int r4 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x01ac
            goto L_0x01a9
        L_0x01e0:
            boolean r4 = r6 instanceof java.lang.String
            if (r4 == 0) goto L_0x01eb
            java.lang.String r4 = ""
            boolean r4 = r6.equals(r4)
            goto L_0x0212
        L_0x01eb:
            boolean r4 = r6 instanceof com.google.c.j
            if (r4 == 0) goto L_0x01f6
            com.google.c.j r4 = com.google.c.j.EMPTY
            boolean r4 = r6.equals(r4)
            goto L_0x0212
        L_0x01f6:
            boolean r4 = r6 instanceof com.google.c.at
            if (r4 == 0) goto L_0x0204
            r4 = r6
            com.google.c.at r4 = (com.google.c.at) r4
            com.google.c.at r4 = r4.o()
            if (r6 != r4) goto L_0x01ac
            goto L_0x01a9
        L_0x0204:
            boolean r4 = r6 instanceof java.lang.Enum
            if (r4 == 0) goto L_0x01ac
            r4 = r6
            java.lang.Enum r4 = (java.lang.Enum) r4
            int r4 = r4.ordinal()
            if (r4 != 0) goto L_0x01ac
            goto L_0x01a9
        L_0x0212:
            if (r4 != 0) goto L_0x0216
            r4 = 1
            goto L_0x0224
        L_0x0216:
            r4 = 0
            goto L_0x0224
        L_0x0218:
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.c.aa.a((java.lang.reflect.Method) r4, (java.lang.Object) r13, (java.lang.Object[]) r8)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
        L_0x0224:
            if (r4 == 0) goto L_0x004d
            java.lang.String r3 = a(r3)
            a(r14, r15, r3, r6)
            goto L_0x004d
        L_0x022f:
            boolean r0 = r13 instanceof com.google.c.aa.c
            if (r0 == 0) goto L_0x026b
            r0 = r13
            com.google.c.aa$c r0 = (com.google.c.aa.c) r0
            com.google.c.w<com.google.c.aa$e> r0 = r0.f37686a
            java.util.Iterator r0 = r0.d()
        L_0x023c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x026b
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "["
            r2.<init>(r3)
            java.lang.Object r3 = r1.getKey()
            com.google.c.aa$e r3 = (com.google.c.aa.e) r3
            int r3 = r3.f37688b
            r2.append(r3)
            java.lang.String r3 = "]"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object r1 = r1.getValue()
            a(r14, r15, r2, r1)
            goto L_0x023c
        L_0x026b:
            com.google.c.aa r13 = (com.google.c.aa) r13
            com.google.c.bu r0 = r13.f37680e
            if (r0 == 0) goto L_0x0276
            com.google.c.bu r13 = r13.f37680e
            r13.a((java.lang.StringBuilder) r14, (int) r15)
        L_0x0276:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.av.a(com.google.c.at, java.lang.StringBuilder, int):void");
    }

    static final void a(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object a2 : (List) obj) {
                a(sb, i2, str, a2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry a3 : ((Map) obj).entrySet()) {
                a(sb, i2, str, a3);
            }
        } else {
            sb.append(10);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(br.a(j.copyFromUtf8((String) obj)));
                sb.append('\"');
            } else if (obj instanceof j) {
                sb.append(": \"");
                sb.append(br.a((j) obj));
                sb.append('\"');
            } else if (obj instanceof aa) {
                sb.append(" {");
                a((aa) obj, sb, i2 + 2);
                sb.append(StringUtility.NEW_LINE);
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i5 = i2 + 2;
                a(sb, i5, "key", entry.getKey());
                a(sb, i5, "value", entry.getValue());
                sb.append(StringUtility.NEW_LINE);
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
