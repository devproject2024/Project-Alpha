package com.paytmmall.clpartifact.utils;

public final class RecoUtils {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x001e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> getFilteredItemList(java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> r8) {
        /*
            r7 = this;
            java.util.Set r0 = com.paytmmall.clpartifact.utils.ValidateViewResponse.getRecoDisallowedSet()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0017
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r2 = 0
            goto L_0x0018
        L_0x0017:
            r2 = 1
        L_0x0018:
            if (r2 != 0) goto L_0x0095
            java.util.Iterator r8 = r8.iterator()
        L_0x001e:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0095
            java.lang.Object r2 = r8.next()
            com.paytmmall.clpartifact.modal.clpCommon.Item r2 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r2
            com.paytmmall.clpartifact.modal.clpCommon.ItemCTA r3 = r2.getCta()
            java.lang.String r4 = "item"
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x0050
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            com.paytmmall.clpartifact.modal.clpCommon.ItemCTA r3 = r2.getCta()
            java.lang.String r3 = r3.getLabel()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0050
            com.paytmmall.clpartifact.modal.clpCommon.ItemCTA r3 = r2.getCta()
            java.lang.String r3 = r3.getLabel()
            goto L_0x0051
        L_0x0050:
            r3 = r5
        L_0x0051:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r4 = r2.getTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0064
            java.lang.String r5 = r2.getTitle()
        L_0x0064:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r2.getId()
            r4.append(r6)
            r4.append(r3)
            r4.append(r5)
            java.lang.String r3 = r4.toString()
            if (r0 == 0) goto L_0x0085
            boolean r3 = r0.contains(r3)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            if (r3 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x001e
            r1.add(r2)
            goto L_0x001e
        L_0x0095:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.RecoUtils.getFilteredItemList(java.util.ArrayList):java.util.ArrayList");
    }
}
