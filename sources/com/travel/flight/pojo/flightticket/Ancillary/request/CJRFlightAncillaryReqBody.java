package com.travel.flight.pojo.flightticket.Ancillary.request;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightAncillaryReqBody implements IJRDataModel {
    private static CJRFlightAncillaryReqBody instance;
    private transient Double mSelectedBaggageTotalAmount;
    private transient Double mSelectedMealsTotalAmount;
    @c(a = "onward")
    private ArrayList<CJRFlightAncillaryReqBodyItemDetail> onwardJrny = new ArrayList<>();
    @c(a = "return")
    private ArrayList<CJRFlightAncillaryReqBodyItemDetail> returnJrny = new ArrayList<>();

    private CJRFlightAncillaryReqBody() {
        Double valueOf = Double.valueOf(0.0d);
        this.mSelectedBaggageTotalAmount = valueOf;
        this.mSelectedMealsTotalAmount = valueOf;
    }

    public static CJRFlightAncillaryReqBody getInstance() {
        if (instance == null) {
            instance = new CJRFlightAncillaryReqBody();
        }
        return instance;
    }

    public static void clear() {
        instance = null;
    }

    public ArrayList<CJRFlightAncillaryReqBodyItemDetail> getOnwardJrny() {
        return this.onwardJrny;
    }

    public ArrayList<CJRFlightAncillaryReqBodyItemDetail> getReturnJrny() {
        return this.returnJrny;
    }

    public Double getmSelectedBaggageTotalAmount() {
        return this.mSelectedBaggageTotalAmount;
    }

    public void setmSelectedBaggageTotalAmount(Double d2) {
        this.mSelectedBaggageTotalAmount = Double.valueOf(this.mSelectedBaggageTotalAmount.doubleValue() + d2.doubleValue());
    }

    public Double getmSelectedMealsTotalAmount() {
        return this.mSelectedMealsTotalAmount;
    }

    public void setmSelectedMealsTotalAmount(Double d2) {
        this.mSelectedMealsTotalAmount = Double.valueOf(this.mSelectedMealsTotalAmount.doubleValue() + d2.doubleValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x013c, code lost:
        r16 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSelectedAncillary(boolean r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, int r25, boolean r26, double r27, boolean r29) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r11 = r29
            if (r18 == 0) goto L_0x001b
            java.util.ArrayList<com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail> r12 = r0.onwardJrny
            goto L_0x001d
        L_0x001b:
            java.util.ArrayList<com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail> r12 = r0.returnJrny
        L_0x001d:
            r14 = 0
        L_0x001e:
            int r15 = r12.size()
            r16 = 1
            if (r14 >= r15) goto L_0x013a
            java.lang.Object r15 = r12.get(r14)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail r15 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail) r15
            java.lang.String r13 = r15.getFlight_number()
            boolean r13 = r13.equalsIgnoreCase(r2)
            if (r13 == 0) goto L_0x0134
            java.lang.String r13 = r15.getOrigin()
            boolean r13 = r13.equalsIgnoreCase(r3)
            if (r13 == 0) goto L_0x0134
            java.lang.String r13 = r15.getDestination()
            boolean r13 = r13.equalsIgnoreCase(r4)
            if (r13 == 0) goto L_0x0134
            java.util.ArrayList r13 = r15.getSsrs()
            if (r13 == 0) goto L_0x0106
            java.util.ArrayList r13 = r15.getSsrs()
            int r13 = r13.size()
            if (r13 <= r1) goto L_0x0106
            java.util.ArrayList r13 = r15.getSsrs()
            java.lang.Object r13 = r13.get(r1)
            if (r13 == 0) goto L_0x0106
            java.util.ArrayList r13 = r15.getSsrs()
            java.lang.Object r13 = r13.get(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r13 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody) r13
            int r13 = r13.getPassenger_id()
            if (r13 != r1) goto L_0x0106
            r13 = 0
        L_0x0075:
            java.util.ArrayList r0 = r15.getSsrs()
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r0 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody) r0
            java.util.ArrayList r0 = r0.getItems()
            int r0 = r0.size()
            if (r13 >= r0) goto L_0x00d7
            java.util.ArrayList r0 = r15.getSsrs()
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r0 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody) r0
            java.util.ArrayList r0 = r0.getItems()
            java.lang.Object r0 = r0.get(r13)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem r0 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem) r0
            java.lang.String r0 = r0.getCode()
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00d4
            if (r7 != 0) goto L_0x00bb
            java.util.ArrayList r0 = r15.getSsrs()
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r0 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody) r0
            java.util.ArrayList r0 = r0.getItems()
            r0.remove(r13)
            goto L_0x00d2
        L_0x00bb:
            java.util.ArrayList r0 = r15.getSsrs()
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r0 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody) r0
            java.util.ArrayList r0 = r0.getItems()
            java.lang.Object r0 = r0.get(r13)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem r0 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem) r0
            r0.setCount(r7)
        L_0x00d2:
            r13 = 1
            goto L_0x00d8
        L_0x00d4:
            int r13 = r13 + 1
            goto L_0x0075
        L_0x00d7:
            r13 = 0
        L_0x00d8:
            if (r13 != 0) goto L_0x0104
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem r0 = new com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem
            r0.<init>()
            r0.setCode(r5)
            r0.setPrice(r9)
            r0.setCount(r7)
            r0.setBaggage(r8)
            r0.setName(r6)
            r0.setIsVeg(r11)
            java.lang.Object r14 = r12.get(r14)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail r14 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail) r14
            java.util.ArrayList r14 = r14.getSsrs()
            java.lang.Object r14 = r14.get(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r14 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody) r14
            r14.setItems(r0)
        L_0x0104:
            r0 = 1
            goto L_0x013c
        L_0x0106:
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r0 = new com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody
            r0.<init>()
            r0.setPassenger_id(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem r13 = new com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem
            r13.<init>()
            r13.setCode(r5)
            r13.setPrice(r9)
            r13.setCount(r7)
            r13.setBaggage(r8)
            r13.setName(r6)
            r13.setIsVeg(r11)
            r0.setItems(r13)
            java.lang.Object r13 = r12.get(r14)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail r13 = (com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail) r13
            r13.setSsrs(r0)
            r0 = 0
            r13 = 0
            goto L_0x013e
        L_0x0134:
            int r14 = r14 + 1
            r0 = r17
            goto L_0x001e
        L_0x013a:
            r0 = 0
            r13 = 0
        L_0x013c:
            r16 = 0
        L_0x013e:
            if (r16 != 0) goto L_0x017a
            if (r0 != 0) goto L_0x017a
            if (r13 != 0) goto L_0x017a
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail r0 = new com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail
            r0.<init>()
            r0.setFlight_number(r2)
            r0.setOrigin(r3)
            r0.setDestination(r4)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody r2 = new com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody
            r2.<init>()
            r2.setPassenger_id(r1)
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem r1 = new com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem
            r1.<init>()
            r1.setCode(r5)
            r1.setPrice(r9)
            r1.setCount(r7)
            r1.setBaggage(r8)
            r1.setName(r6)
            r1.setIsVeg(r11)
            r2.setItems(r1)
            r0.setSsrs(r2)
            r12.add(r0)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.updateSelectedAncillary(boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, double, boolean):void");
    }

    public int getSelectedAncillaryCount(boolean z, int i2, String str, String str2, String str3, String str4) {
        ArrayList<CJRFlightAncillaryReqBodyItemDetail> arrayList;
        if (z) {
            try {
                arrayList = this.onwardJrny;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        } else {
            arrayList = this.returnJrny;
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            CJRFlightAncillaryReqBodyItemDetail cJRFlightAncillaryReqBodyItemDetail = arrayList.get(i3);
            if (!cJRFlightAncillaryReqBodyItemDetail.getFlight_number().equalsIgnoreCase(str) || !cJRFlightAncillaryReqBodyItemDetail.getOrigin().equalsIgnoreCase(str2) || !cJRFlightAncillaryReqBodyItemDetail.getDestination().equalsIgnoreCase(str3)) {
                i3++;
            } else {
                if (cJRFlightAncillaryReqBodyItemDetail.getSsrs() != null && cJRFlightAncillaryReqBodyItemDetail.getSsrs().size() > i2 && cJRFlightAncillaryReqBodyItemDetail.getSsrs().get(i2) != null && cJRFlightAncillaryReqBodyItemDetail.getSsrs().get(i2).getPassenger_id() == i2) {
                    for (int i4 = 0; i4 < cJRFlightAncillaryReqBodyItemDetail.getSsrs().get(i2).getItems().size(); i4++) {
                        if (cJRFlightAncillaryReqBodyItemDetail.getSsrs().get(i2).getItems().get(i4).getCode().equalsIgnoreCase(str4)) {
                            return cJRFlightAncillaryReqBodyItemDetail.getSsrs().get(i2).getItems().get(i4).getCount();
                        }
                    }
                }
                return 0;
            }
        }
        return 0;
    }
}
