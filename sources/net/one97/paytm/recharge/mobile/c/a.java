package net.one97.paytm.recharge.mobile.c;

import android.os.AsyncTask;
import androidx.lifecycle.y;
import java.util.LinkedList;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.utils.ac;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;

public final class a extends AsyncTask<ac, Void, LinkedList<CJRSelectedGroupItem>> {

    /* renamed from: a  reason: collision with root package name */
    private final CJRCategoryDataHelper f63698a;

    /* renamed from: b  reason: collision with root package name */
    private final y<LinkedList<CJRSelectedGroupItem>> f63699b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f63700c;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r13) {
        /*
            r12 = this;
            net.one97.paytm.recharge.common.utils.ac[] r13 = (net.one97.paytm.recharge.common.utils.ac[]) r13
            java.lang.String r0 = "params"
            kotlin.g.b.k.c(r13, r0)
            int r0 = r13.length
            r1 = 0
            if (r0 < 0) goto L_0x0101
            r0 = 0
            r13 = r13[r0]
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r12.f63698a
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r2 = r2.getNextGroupItemData()
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
        L_0x0019:
            if (r2 == 0) goto L_0x0100
            java.lang.String r4 = r2.getGroupName()
            if (r4 == 0) goto L_0x0035
            if (r4 == 0) goto L_0x002d
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            goto L_0x0036
        L_0x002d:
            kotlin.u r13 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r13.<init>(r0)
            throw r13
        L_0x0035:
            r4 = r1
        L_0x0036:
            if (r4 != 0) goto L_0x003b
            java.lang.String r5 = ""
            goto L_0x003c
        L_0x003b:
            r5 = r4
        L_0x003c:
            boolean r5 = r13.containsKey((java.lang.Object) r5)
            if (r5 == 0) goto L_0x00fd
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r5 = r2.getGroupAttributesItem()
            r6 = 1
            if (r5 == 0) goto L_0x004e
            boolean r5 = r5.getShowAfterInputfield()
            goto L_0x004f
        L_0x004e:
            r5 = 1
        L_0x004f:
            if (r5 != 0) goto L_0x00fd
            java.util.List r5 = r2.getAggs()
            if (r5 == 0) goto L_0x0090
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r5 = r5.iterator()
        L_0x0064:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x008c
            java.lang.Object r8 = r5.next()
            r9 = r8
            net.one97.paytm.recharge.model.v4.CJRAggsItem r9 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r9
            java.lang.String r9 = r9.getValue()
            if (r9 == 0) goto L_0x0085
            r10 = r13
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r10 = r10.get(r4)
            java.lang.String r10 = (java.lang.String) r10
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r6)
            goto L_0x0086
        L_0x0085:
            r9 = 0
        L_0x0086:
            if (r9 == 0) goto L_0x0064
            r7.add(r8)
            goto L_0x0064
        L_0x008c:
            r4 = r7
            java.util.List r4 = (java.util.List) r4
            goto L_0x0091
        L_0x0090:
            r4 = r1
        L_0x0091:
            if (r4 == 0) goto L_0x00ef
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x00ef
            java.lang.Object r4 = r4.get(r0)
            r11 = r4
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r4 = new net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r5 = r2.getGroupAttributesItem()
            if (r5 == 0) goto L_0x00ae
            java.lang.String r5 = r5.getName()
            r6 = r5
            goto L_0x00af
        L_0x00ae:
            r6 = r1
        L_0x00af:
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r5 = r2.getGroupAttributesItem()
            if (r5 == 0) goto L_0x00c1
            net.one97.paytm.recharge.model.v4.CJRDeviceType r5 = r5.getType()
            if (r5 == 0) goto L_0x00c1
            java.lang.String r5 = r5.getAndroid()
            r7 = r5
            goto L_0x00c2
        L_0x00c1:
            r7 = r1
        L_0x00c2:
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r5 = r2.getGroupAttributesItem()
            if (r5 == 0) goto L_0x00ce
            java.lang.String r5 = r5.getDisplayName()
            r8 = r5
            goto L_0x00cf
        L_0x00ce:
            r8 = r1
        L_0x00cf:
            java.lang.String r9 = r11.getValue()
            int r10 = r2.getGroupLevel()
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r3.add(r4)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r12.f63698a
            int r2 = r2.getGroupLevel()
            r5.addSelectedGroupItem(r2, r4)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r12.f63698a
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r2 = r2.getNextGroupItemData()
            goto L_0x0019
        L_0x00ef:
            r3.clear()
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r12.f63698a
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r2.getCategoryData()
            if (r2 == 0) goto L_0x00fd
            r2.removeAllSelections()
        L_0x00fd:
            r2 = r1
            goto L_0x0019
        L_0x0100:
            return r3
        L_0x0101:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.c.a.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        LinkedList linkedList = (LinkedList) obj;
        if (this.f63700c) {
            this.f63699b.setValue(linkedList);
        }
    }

    public a(CJRCategoryDataHelper cJRCategoryDataHelper, y<LinkedList<CJRSelectedGroupItem>> yVar, boolean z) {
        k.c(cJRCategoryDataHelper, "categoryDataHelper");
        k.c(yVar, "selectedGroup");
        this.f63698a = cJRCategoryDataHelper;
        this.f63699b = yVar;
        this.f63700c = z;
        CJRCategoryData categoryData = this.f63698a.getCategoryData();
        if (categoryData != null) {
            categoryData.removeAllSelections();
        }
    }
}
