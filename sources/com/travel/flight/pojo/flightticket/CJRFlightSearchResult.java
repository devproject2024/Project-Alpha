package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.travel.flight.flightSRPV2.a.ae;
import com.travel.flight.flightSRPV2.a.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CJRFlightSearchResult extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private String mError;
    private HashMap<String, ArrayList<CJRIntlFlightMapping>> mFlightChildBucketMap;
    private ArrayList<CJRIntlFlightList> mInternationalFlightList = new ArrayList<>();
    @b(a = "meta")
    private CJRMetadetails mMetaDetails;
    @b(a = "body")
    private CJROnwardReturnFlightInformation mOnwardReturnFlights;
    @b(a = "status")
    private CJRStatus mStatus;

    public String getmError() {
        return this.mError;
    }

    public void setmError(String str) {
        this.mError = str;
    }

    public CJRStatus getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(CJRStatus cJRStatus) {
        this.mStatus = cJRStatus;
    }

    public CJROnwardReturnFlightInformation getmOnwardReturnFlights() {
        return this.mOnwardReturnFlights;
    }

    public void setmOnwardReturnFlights(CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation) {
        this.mOnwardReturnFlights = cJROnwardReturnFlightInformation;
    }

    public CJRMetadetails getmMetaDetails() {
        return this.mMetaDetails;
    }

    public void setmMetaDetails(CJRMetadetails cJRMetadetails) {
        this.mMetaDetails = cJRMetadetails;
    }

    public ArrayList<CJRIntlFlightList> getmInternationalFlightList() {
        ArrayList<CJRIntlFlightList> arrayList = this.mInternationalFlightList;
        if (arrayList == null || arrayList.size() == 0) {
            return new ArrayList<>();
        }
        return this.mInternationalFlightList;
    }

    public void setmInternationalFlightList(ae aeVar) {
        CJRIntlFlightMapping cJRIntlFlightMapping;
        ArrayList arrayList = new ArrayList();
        this.mInternationalFlightList = new ArrayList<>();
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = this.mOnwardReturnFlights;
        if (cJROnwardReturnFlightInformation != null && cJROnwardReturnFlightInformation.getmMapping() != null && this.mOnwardReturnFlights.getmMapping().size() > 0) {
            this.mFlightChildBucketMap = new HashMap<>();
            for (int i2 = 0; i2 < this.mOnwardReturnFlights.getmMapping().size(); i2++) {
                if (!(this.mOnwardReturnFlights.getmMapping().get(i2) == null || (cJRIntlFlightMapping = this.mOnwardReturnFlights.getmMapping().get(i2)) == null)) {
                    List<Integer> onward = cJRIntlFlightMapping.getOnward();
                    List<Integer> list = cJRIntlFlightMapping.getReturn();
                    CJRIntlFlightPricing pricing = cJRIntlFlightMapping.getPricing();
                    if (!(pricing == null || onward == null || list == null || onward.size() <= 0 || list.size() <= 0)) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(cJRIntlFlightMapping);
                        int intValue = onward.size() > 0 ? onward.get(0).intValue() : 0;
                        int intValue2 = list.size() > 0 ? list.get(0).intValue() : 0;
                        try {
                            CJRFlightDetailsItem clone = this.mOnwardReturnFlights.getmOnwardFlights().getmFlightDetails().get(intValue).clone();
                            CJRFlightDetailsItem clone2 = this.mOnwardReturnFlights.getmReturnFlights().getmFlightDetails().get(intValue2).clone();
                            if (!(clone == null || clone2 == null)) {
                                cJRIntlFlightMapping.setOnwardItem(clone);
                                cJRIntlFlightMapping.setReturnItem(clone2);
                                if (!this.mFlightChildBucketMap.isEmpty()) {
                                    CJRIntlFlightMapping cJRIntlFlightMapping2 = this.mOnwardReturnFlights.getmMapping().get(i2 - 1);
                                    if (!t.a(aeVar, cJRIntlFlightMapping2, cJRIntlFlightMapping) || (!cJRIntlFlightMapping2.getParentId().equals(cJRIntlFlightMapping.getParentId()) && !cJRIntlFlightMapping2.getFlightId().equals(cJRIntlFlightMapping.getParentId()) && !cJRIntlFlightMapping2.getParentId().equals(cJRIntlFlightMapping.getFlightId()))) {
                                        cJRIntlFlightMapping.setParent(true);
                                        cJRIntlFlightMapping.setGroupKey(cJRIntlFlightMapping.getParentId() + aeVar.b(cJRIntlFlightMapping));
                                        addMappingWithoutChild(pricing, cJRIntlFlightMapping, clone, clone2);
                                        this.mFlightChildBucketMap.put(cJRIntlFlightMapping.getGroupKey(), arrayList2);
                                    } else {
                                        cJRIntlFlightMapping.setParent(false);
                                        cJRIntlFlightMapping.setGroupKey(cJRIntlFlightMapping2.getGroupKey());
                                        this.mFlightChildBucketMap.get(cJRIntlFlightMapping2.getGroupKey()).add(cJRIntlFlightMapping);
                                    }
                                } else if (cJRIntlFlightMapping.isParent()) {
                                    cJRIntlFlightMapping.setGroupKey(cJRIntlFlightMapping.getParentId() + aeVar.b(cJRIntlFlightMapping));
                                    addMappingWithoutChild(pricing, cJRIntlFlightMapping, clone, clone2);
                                    this.mFlightChildBucketMap.put(cJRIntlFlightMapping.getGroupKey(), arrayList2);
                                } else {
                                    cJRIntlFlightMapping.setParent(true);
                                    cJRIntlFlightMapping.setGroupKey(cJRIntlFlightMapping.getParentId() + aeVar.b(cJRIntlFlightMapping));
                                    addMappingWithoutChild(pricing, cJRIntlFlightMapping, clone, clone2);
                                    this.mFlightChildBucketMap.put(cJRIntlFlightMapping.getGroupKey(), arrayList2);
                                }
                                arrayList.add(cJRIntlFlightMapping);
                            }
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                }
            }
            this.mOnwardReturnFlights.setmMapping(arrayList);
        }
    }

    private void addMappingWithoutChild(CJRIntlFlightPricing cJRIntlFlightPricing, CJRIntlFlightMapping cJRIntlFlightMapping, CJRFlightDetailsItem cJRFlightDetailsItem, CJRFlightDetailsItem cJRFlightDetailsItem2) {
        CJRIntlFlightList cJRIntlFlightList = new CJRIntlFlightList();
        cJRIntlFlightList.setmFlightMapping(cJRIntlFlightMapping);
        cJRIntlFlightList.setMappedPrice(cJRIntlFlightPricing);
        cJRIntlFlightList.setmTotalPrice(cJRIntlFlightPricing.getTotalfare());
        cJRIntlFlightList.setmDisplayPrice(cJRIntlFlightPricing.getmDisplayPrice());
        cJRIntlFlightList.setmOnwardFlights(cJRFlightDetailsItem);
        cJRIntlFlightList.setmReturnFlights(cJRFlightDetailsItem2);
        this.mInternationalFlightList.add(cJRIntlFlightList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.travel.flight.pojo.flightticket.CJRIntlFlightList getChildForParentInternationalList(com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r17, com.travel.flight.pojo.flightticket.CJRIntlFlightPricing r18, com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r19) {
        /*
            r16 = this;
            r1 = r16
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r2 = new com.travel.flight.pojo.flightticket.CJRIntlFlightList
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r5 = r17.getGroupKey()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r0 = r17.getOnward()
            r8 = 0
            if (r0 == 0) goto L_0x003f
            java.util.List r0 = r17.getOnward()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x003f
            java.util.List r0 = r17.getOnward()
            java.lang.Object r0 = r0.get(r8)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            java.util.List r9 = r17.getReturn()
            if (r9 == 0) goto L_0x005f
            java.util.List r9 = r17.getReturn()
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x005f
            java.util.List r9 = r17.getReturn()
            java.lang.Object r9 = r9.get(r8)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            goto L_0x0060
        L_0x005f:
            r9 = 0
        L_0x0060:
            boolean r10 = android.text.TextUtils.isEmpty(r5)
            r11 = 0
            if (r10 == 0) goto L_0x0068
            return r11
        L_0x0068:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r10 = r1.mOnwardReturnFlights     // Catch:{ CloneNotSupportedException -> 0x0094 }
            com.travel.flight.pojo.flightticket.CJROnwardFlights r10 = r10.getmOnwardFlights()     // Catch:{ CloneNotSupportedException -> 0x0094 }
            java.util.ArrayList r10 = r10.getmFlightDetails()     // Catch:{ CloneNotSupportedException -> 0x0094 }
            java.lang.Object r0 = r10.get(r0)     // Catch:{ CloneNotSupportedException -> 0x0094 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0     // Catch:{ CloneNotSupportedException -> 0x0094 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r10 = r0.clone()     // Catch:{ CloneNotSupportedException -> 0x0094 }
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r0 = r1.mOnwardReturnFlights     // Catch:{ CloneNotSupportedException -> 0x0092 }
            com.travel.flight.pojo.flightticket.CJROnwardFlights r0 = r0.getmReturnFlights()     // Catch:{ CloneNotSupportedException -> 0x0092 }
            java.util.ArrayList r0 = r0.getmFlightDetails()     // Catch:{ CloneNotSupportedException -> 0x0092 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ CloneNotSupportedException -> 0x0092 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0     // Catch:{ CloneNotSupportedException -> 0x0092 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.clone()     // Catch:{ CloneNotSupportedException -> 0x0092 }
            r9 = r0
            goto L_0x009e
        L_0x0092:
            r0 = move-exception
            goto L_0x0096
        L_0x0094:
            r0 = move-exception
            r10 = r11
        L_0x0096:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            r9 = r11
        L_0x009e:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRIntlFlightMapping>> r0 = r1.mFlightChildBucketMap
            if (r0 == 0) goto L_0x0199
            java.lang.Object r0 = r0.get(r5)
            if (r0 == 0) goto L_0x0199
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRIntlFlightMapping>> r0 = r1.mFlightChildBucketMap
            java.lang.Object r0 = r0.get(r5)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0199
            r12 = 0
        L_0x00b7:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRIntlFlightMapping>> r0 = r1.mFlightChildBucketMap
            java.lang.Object r0 = r0.get(r5)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            if (r12 >= r0) goto L_0x0161
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRIntlFlightMapping>> r0 = r1.mFlightChildBucketMap
            java.lang.Object r0 = r0.get(r5)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r12)
            if (r0 == 0) goto L_0x015c
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRIntlFlightMapping>> r0 = r1.mFlightChildBucketMap
            java.lang.Object r0 = r0.get(r5)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r12)
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r0 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r0
            java.lang.String r0 = r0.getFlightId()
            java.lang.String r13 = ":"
            java.lang.String[] r0 = r0.split(r13)
            java.lang.String r13 = ""
            if (r0 == 0) goto L_0x00f6
            r14 = r0[r8]
            if (r14 == 0) goto L_0x00f6
            r14 = r0[r8]
            goto L_0x00f7
        L_0x00f6:
            r14 = r13
        L_0x00f7:
            if (r0 == 0) goto L_0x0103
            int r15 = r0.length
            r8 = 1
            if (r15 <= r8) goto L_0x0103
            r15 = r0[r8]
            if (r15 == 0) goto L_0x0103
            r13 = r0[r8]
        L_0x0103:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r0 = r1.mOnwardReturnFlights     // Catch:{ CloneNotSupportedException -> 0x0136 }
            com.travel.flight.pojo.flightticket.CJROnwardFlights r0 = r0.getmOnwardFlights()     // Catch:{ CloneNotSupportedException -> 0x0136 }
            java.util.ArrayList r0 = r0.getmFlightDetails()     // Catch:{ CloneNotSupportedException -> 0x0136 }
            int r8 = r1.getOnwardFlightPosition(r14)     // Catch:{ CloneNotSupportedException -> 0x0136 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ CloneNotSupportedException -> 0x0136 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0     // Catch:{ CloneNotSupportedException -> 0x0136 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r8 = r0.clone()     // Catch:{ CloneNotSupportedException -> 0x0136 }
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r0 = r1.mOnwardReturnFlights     // Catch:{ CloneNotSupportedException -> 0x0134 }
            com.travel.flight.pojo.flightticket.CJROnwardFlights r0 = r0.getmReturnFlights()     // Catch:{ CloneNotSupportedException -> 0x0134 }
            java.util.ArrayList r0 = r0.getmFlightDetails()     // Catch:{ CloneNotSupportedException -> 0x0134 }
            int r15 = r1.getReturnFlightPosition(r13)     // Catch:{ CloneNotSupportedException -> 0x0134 }
            java.lang.Object r0 = r0.get(r15)     // Catch:{ CloneNotSupportedException -> 0x0134 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0     // Catch:{ CloneNotSupportedException -> 0x0134 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.clone()     // Catch:{ CloneNotSupportedException -> 0x0134 }
            goto L_0x0140
        L_0x0134:
            r0 = move-exception
            goto L_0x0138
        L_0x0136:
            r0 = move-exception
            r8 = r11
        L_0x0138:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            r0 = r11
        L_0x0140:
            if (r8 == 0) goto L_0x014e
            java.lang.Object r15 = r3.get(r14)
            if (r15 != 0) goto L_0x014e
            r6.add(r8)
            r3.put(r14, r8)
        L_0x014e:
            if (r0 == 0) goto L_0x015c
            java.lang.Object r8 = r4.get(r13)
            if (r8 != 0) goto L_0x015c
            r7.add(r0)
            r4.put(r13, r0)
        L_0x015c:
            int r12 = r12 + 1
            r8 = 0
            goto L_0x00b7
        L_0x0161:
            r3.clear()
            r4.clear()
            r3 = r19
            r2.setmFlightMapping(r3)
            r3 = r18
            r2.setMappedPrice(r3)
            r2.setmIntOnwardFlightList(r6)
            r2.setmIntReturnFlightList(r7)
            java.lang.String r0 = r18.getTotalfare()
            r2.setmTotalPrice(r0)
            java.lang.String r0 = r18.getmDisplayPrice()
            r2.setmDisplayPrice(r0)
            r2.setmOnwardFlights(r10)
            r2.setmReturnFlights(r9)
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRIntlFlightMapping>> r0 = r1.mFlightChildBucketMap
            java.lang.Object r0 = r0.get(r5)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r2.setChildItems(r0)
            r2.setParentIdForChildBucket(r5)
        L_0x0199:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.flightticket.CJRFlightSearchResult.getChildForParentInternationalList(com.travel.flight.pojo.flightticket.CJRIntlFlightMapping, com.travel.flight.pojo.flightticket.CJRIntlFlightPricing, com.travel.flight.pojo.flightticket.CJRIntlFlightMapping):com.travel.flight.pojo.flightticket.CJRIntlFlightList");
    }

    private int getOnwardFlightPosition(String str) {
        for (int i2 = 0; i2 < this.mOnwardReturnFlights.getmOnwardFlights().getmFlightDetails().size(); i2++) {
            if (this.mOnwardReturnFlights.getmOnwardFlights().getmFlightDetails().get(i2).getmFlightId().equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return 0;
    }

    private int getReturnFlightPosition(String str) {
        for (int i2 = 0; i2 < this.mOnwardReturnFlights.getmReturnFlights().getmFlightDetails().size(); i2++) {
            if (this.mOnwardReturnFlights.getmReturnFlights().getmFlightDetails().get(i2).getmFlightId().equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return 0;
    }
}
