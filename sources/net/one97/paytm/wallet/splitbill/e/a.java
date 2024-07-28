package net.one97.paytm.wallet.splitbill.e;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse.SBRequestHistory;
import net.one97.paytm.wallet.splitbill.model.b;

public final class a {
    public static List<b> a(List<SBRequestHistory> list) {
        TreeMap treeMap = new TreeMap(new Comparator<String>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                if (a.a(str.split(" ")[0]) > a.a(str2.split(" ")[0])) {
                    return -1;
                }
                if (a.a(str.split(" ")[0]) == a.a(str2.split(" ")[0])) {
                    return 0;
                }
                return 1;
            }
        });
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SBRequestHistory next : list) {
                String format = new SimpleDateFormat("MMMM yyyy ").format(new Date(Long.parseLong(next.getCreatedAt())));
                if (treeMap.containsKey(format)) {
                    ((List) treeMap.get(format)).add(next);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next);
                    treeMap.put(String.valueOf(format), arrayList2);
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(new b(true, (SBRequestHistory) null, (String) entry.getKey()));
            for (SBRequestHistory bVar : (List) entry.getValue()) {
                arrayList.add(new b(false, bVar, ""));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int a(java.lang.String r13) {
        /*
            int r0 = r13.hashCode()
            r1 = 11
            r2 = 10
            r3 = 9
            r4 = 8
            r5 = 7
            r6 = 6
            r7 = 5
            r8 = 4
            r9 = 3
            r10 = 2
            r11 = 1
            r12 = -1
            switch(r0) {
                case -199248958: goto L_0x008d;
                case -162006966: goto L_0x0083;
                case -25881423: goto L_0x0078;
                case 77125: goto L_0x006e;
                case 2320440: goto L_0x0064;
                case 2320482: goto L_0x005a;
                case 43165376: goto L_0x004f;
                case 63478374: goto L_0x0045;
                case 74113571: goto L_0x003b;
                case 626483269: goto L_0x0030;
                case 1703773522: goto L_0x0024;
                case 1972131363: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0097
        L_0x0019:
            java.lang.String r0 = "August"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 7
            goto L_0x0098
        L_0x0024:
            java.lang.String r0 = "November"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 10
            goto L_0x0098
        L_0x0030:
            java.lang.String r0 = "December"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 11
            goto L_0x0098
        L_0x003b:
            java.lang.String r0 = "March"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 2
            goto L_0x0098
        L_0x0045:
            java.lang.String r0 = "April"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 3
            goto L_0x0098
        L_0x004f:
            java.lang.String r0 = "October"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 9
            goto L_0x0098
        L_0x005a:
            java.lang.String r0 = "June"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 5
            goto L_0x0098
        L_0x0064:
            java.lang.String r0 = "July"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 6
            goto L_0x0098
        L_0x006e:
            java.lang.String r0 = "May"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 4
            goto L_0x0098
        L_0x0078:
            java.lang.String r0 = "September"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 8
            goto L_0x0098
        L_0x0083:
            java.lang.String r0 = "January"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 0
            goto L_0x0098
        L_0x008d:
            java.lang.String r0 = "February"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0097
            r13 = 1
            goto L_0x0098
        L_0x0097:
            r13 = -1
        L_0x0098:
            switch(r13) {
                case 0: goto L_0x00a9;
                case 1: goto L_0x00a8;
                case 2: goto L_0x00a7;
                case 3: goto L_0x00a6;
                case 4: goto L_0x00a5;
                case 5: goto L_0x00a4;
                case 6: goto L_0x00a3;
                case 7: goto L_0x00a2;
                case 8: goto L_0x00a1;
                case 9: goto L_0x00a0;
                case 10: goto L_0x009f;
                case 11: goto L_0x009c;
                default: goto L_0x009b;
            }
        L_0x009b:
            return r12
        L_0x009c:
            r13 = 12
            return r13
        L_0x009f:
            return r1
        L_0x00a0:
            return r2
        L_0x00a1:
            return r3
        L_0x00a2:
            return r4
        L_0x00a3:
            return r5
        L_0x00a4:
            return r6
        L_0x00a5:
            return r7
        L_0x00a6:
            return r8
        L_0x00a7:
            return r9
        L_0x00a8:
            return r10
        L_0x00a9:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.splitbill.e.a.a(java.lang.String):int");
    }
}
