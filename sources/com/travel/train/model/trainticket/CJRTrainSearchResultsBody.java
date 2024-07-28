package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsBody extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "alternate_dates")
    private List<String> alternate_dates;
    @a
    @b(a = "filters")
    private ArrayList<CJRTrainFilters> filters;
    @a
    @b(a = "tip_enabled")
    private final boolean isTipEnabled;
    @b(a = "promotional_messages")
    private final CJRTrainPromoMessageModel promoMessageModel;
    @a
    @b(a = "quota")
    private List<String> quota;
    @a
    @b(a = "serverid")
    private String serverid;
    @a
    @b(a = "sort")
    private CJRTrainSearchResultsTrainSort sort;
    @a
    @b(a = "tip_text")
    private final String tipText;
    @a
    @b(a = "trains")
    private List<CJRTrainSearchResultsTrain> trains;

    public CJRTrainSearchResultsBody() {
        this((List) null, (ArrayList) null, (String) null, (List) null, false, (String) null, (List) null, (CJRTrainSearchResultsTrainSort) null, (CJRTrainPromoMessageModel) null, 511, (g) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainSearchResultsBody(java.util.List r11, java.util.ArrayList r12, java.lang.String r13, java.util.List r14, boolean r15, java.lang.String r16, java.util.List r17, com.travel.train.model.trainticket.CJRTrainSearchResultsTrainSort r18, com.travel.train.model.trainticket.CJRTrainPromoMessageModel r19, int r20, kotlin.g.b.g r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            goto L_0x000f
        L_0x000e:
            r1 = r11
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0019
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            goto L_0x001a
        L_0x0019:
            r2 = r12
        L_0x001a:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0021
            r3 = r4
            goto L_0x0022
        L_0x0021:
            r3 = r13
        L_0x0022:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002e
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            goto L_0x002f
        L_0x002e:
            r5 = r14
        L_0x002f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0035
            r6 = 0
            goto L_0x0036
        L_0x0035:
            r6 = r15
        L_0x0036:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003c
            r7 = r4
            goto L_0x003e
        L_0x003c:
            r7 = r16
        L_0x003e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x004a
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            goto L_0x004c
        L_0x004a:
            r8 = r17
        L_0x004c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0052
            r9 = r4
            goto L_0x0054
        L_0x0052:
            r9 = r18
        L_0x0054:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r4 = r19
        L_0x005b:
            r11 = r10
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r4
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainSearchResultsBody.<init>(java.util.List, java.util.ArrayList, java.lang.String, java.util.List, boolean, java.lang.String, java.util.List, com.travel.train.model.trainticket.CJRTrainSearchResultsTrainSort, com.travel.train.model.trainticket.CJRTrainPromoMessageModel, int, kotlin.g.b.g):void");
    }

    public final List<CJRTrainSearchResultsTrain> getTrains() {
        return this.trains;
    }

    public final void setTrains(List<CJRTrainSearchResultsTrain> list) {
        k.c(list, "<set-?>");
        this.trains = list;
    }

    public final ArrayList<CJRTrainFilters> getFilters() {
        return this.filters;
    }

    public final void setFilters(ArrayList<CJRTrainFilters> arrayList) {
        k.c(arrayList, "<set-?>");
        this.filters = arrayList;
    }

    public final String getServerid() {
        return this.serverid;
    }

    public final void setServerid(String str) {
        this.serverid = str;
    }

    public final List<String> getQuota() {
        return this.quota;
    }

    public final void setQuota(List<String> list) {
        k.c(list, "<set-?>");
        this.quota = list;
    }

    public final boolean isTipEnabled() {
        return this.isTipEnabled;
    }

    public final String getTipText() {
        return this.tipText;
    }

    public final List<String> getAlternate_dates() {
        return this.alternate_dates;
    }

    public final void setAlternate_dates(List<String> list) {
        k.c(list, "<set-?>");
        this.alternate_dates = list;
    }

    public final CJRTrainSearchResultsTrainSort getSort() {
        return this.sort;
    }

    public final void setSort(CJRTrainSearchResultsTrainSort cJRTrainSearchResultsTrainSort) {
        this.sort = cJRTrainSearchResultsTrainSort;
    }

    public final CJRTrainPromoMessageModel getPromoMessageModel() {
        return this.promoMessageModel;
    }

    public CJRTrainSearchResultsBody(List<CJRTrainSearchResultsTrain> list, ArrayList<CJRTrainFilters> arrayList, String str, List<String> list2, boolean z, String str2, List<String> list3, CJRTrainSearchResultsTrainSort cJRTrainSearchResultsTrainSort, CJRTrainPromoMessageModel cJRTrainPromoMessageModel) {
        k.c(list, "trains");
        k.c(arrayList, "filters");
        k.c(list2, "quota");
        k.c(list3, "alternate_dates");
        this.trains = list;
        this.filters = arrayList;
        this.serverid = str;
        this.quota = list2;
        this.isTipEnabled = z;
        this.tipText = str2;
        this.alternate_dates = list3;
        this.sort = cJRTrainSearchResultsTrainSort;
        this.promoMessageModel = cJRTrainPromoMessageModel;
    }
}
