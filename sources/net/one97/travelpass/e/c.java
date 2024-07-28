package net.one97.travelpass.e;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.travelpass.model.InternalOfferData;
import net.one97.travelpass.model.MyPasses;
import net.one97.travelpass.model.MyPassesResponse;
import net.one97.travelpass.model.PartnersOfferData;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.ui.b.b;
import net.one97.travelpass.ui.c.j;

public final class c {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        r2 = r2.getMetadata();
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<net.one97.travelpass.ui.c.j> a(net.one97.travelpass.model.MyPassesResponse r7, long r8, int r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = -1
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x000f
            int r10 = a((net.one97.travelpass.model.MyPassesResponse) r7, (long) r8)
        L_0x000f:
            net.one97.travelpass.model.PassData r8 = a((net.one97.travelpass.model.MyPassesResponse) r7, (int) r10)
            net.one97.travelpass.ui.c.j r9 = new net.one97.travelpass.ui.c.j
            r9.<init>()
            r1 = 0
            if (r7 == 0) goto L_0x0037
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.MY_PASS_HEADER_INFO
            r9.a((net.one97.travelpass.ui.b.b) r2)
            net.one97.travelpass.model.MyPasses r2 = r7.getBody()
            if (r2 == 0) goto L_0x0031
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x0031
            net.one97.travelpass.model.TravelPassMetaData$UserPassInfo r2 = r2.getUserPassInfo()
            goto L_0x0032
        L_0x0031:
            r2 = r1
        L_0x0032:
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            r9.a((com.paytm.network.model.IJRPaytmDataModel) r2)
        L_0x0037:
            com.paytm.network.model.IJRPaytmDataModel r2 = r9.b()
            if (r2 == 0) goto L_0x0040
            r0.add(r9)
        L_0x0040:
            java.lang.Integer.valueOf(r10)
            net.one97.travelpass.ui.c.j r9 = new net.one97.travelpass.ui.c.j
            r9.<init>()
            r2 = 0
            if (r7 == 0) goto L_0x005a
            net.one97.travelpass.ui.b.b r3 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL
            r9.a((net.one97.travelpass.ui.b.b) r3)
            java.lang.Integer.valueOf(r2)
            java.util.ArrayList r3 = a((net.one97.travelpass.model.MyPassesResponse) r7)
            r9.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r3)
        L_0x005a:
            java.util.ArrayList r3 = r9.a()
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = 1
            if (r3 == 0) goto L_0x006c
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r3 = 0
            goto L_0x006d
        L_0x006c:
            r3 = 1
        L_0x006d:
            if (r3 != 0) goto L_0x0078
            r3 = -1
            if (r10 == r3) goto L_0x0075
            r9.a((int) r10)
        L_0x0075:
            r0.add(r9)
        L_0x0078:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            net.one97.travelpass.ui.c.j r3 = new net.one97.travelpass.ui.c.j
            r3.<init>()
            if (r7 == 0) goto L_0x0122
            net.one97.travelpass.ui.b.b r5 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PRICE_DETAILS
            r3.a((net.one97.travelpass.ui.b.b) r5)
            java.util.ArrayList r5 = a((net.one97.travelpass.model.MyPassesResponse) r7, (java.lang.Integer) r9)
            r3.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r5)
            net.one97.travelpass.model.MyPasses r5 = r7.getBody()
            if (r5 == 0) goto L_0x009a
            java.util.List r5 = r5.getVerticalPassesData()
            goto L_0x009b
        L_0x009a:
            r5 = r1
        L_0x009b:
            if (r5 == 0) goto L_0x0122
            net.one97.travelpass.model.MyPasses r5 = r7.getBody()
            if (r5 == 0) goto L_0x00a8
            java.util.List r5 = r5.getVerticalPassesData()
            goto L_0x00a9
        L_0x00a8:
            r5 = r1
        L_0x00a9:
            if (r5 != 0) goto L_0x00ae
            kotlin.g.b.k.a()
        L_0x00ae:
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0122
            net.one97.travelpass.model.MyPasses r5 = r7.getBody()
            if (r5 == 0) goto L_0x00d6
            java.util.List r5 = r5.getVerticalPassesData()
            if (r5 == 0) goto L_0x00d6
            if (r9 != 0) goto L_0x00c5
            kotlin.g.b.k.a()
        L_0x00c5:
            int r6 = r9.intValue()
            java.lang.Object r5 = r5.get(r6)
            net.one97.travelpass.model.PassData r5 = (net.one97.travelpass.model.PassData) r5
            if (r5 == 0) goto L_0x00d6
            java.lang.String r5 = r5.getHotelPassDisclaimerIcon()
            goto L_0x00d7
        L_0x00d6:
            r5 = r1
        L_0x00d7:
            net.one97.travelpass.model.MyPasses r6 = r7.getBody()
            if (r6 == 0) goto L_0x00f9
            java.util.List r6 = r6.getVerticalPassesData()
            if (r6 == 0) goto L_0x00f9
            if (r9 != 0) goto L_0x00e8
            kotlin.g.b.k.a()
        L_0x00e8:
            int r9 = r9.intValue()
            java.lang.Object r9 = r6.get(r9)
            net.one97.travelpass.model.PassData r9 = (net.one97.travelpass.model.PassData) r9
            if (r9 == 0) goto L_0x00f9
            java.lang.String r9 = r9.getHotelPassDisclaimerText()
            goto L_0x00fa
        L_0x00f9:
            r9 = r1
        L_0x00fa:
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0108
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0106
            goto L_0x0108
        L_0x0106:
            r6 = 0
            goto L_0x0109
        L_0x0108:
            r6 = 1
        L_0x0109:
            if (r6 != 0) goto L_0x0122
            r6 = r9
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0119
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0117
            goto L_0x0119
        L_0x0117:
            r6 = 0
            goto L_0x011a
        L_0x0119:
            r6 = 1
        L_0x011a:
            if (r6 != 0) goto L_0x0122
            r3.c(r5)
            r3.d(r9)
        L_0x0122:
            java.util.ArrayList r9 = r3.a()
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x0133
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0131
            goto L_0x0133
        L_0x0131:
            r9 = 0
            goto L_0x0134
        L_0x0133:
            r9 = 1
        L_0x0134:
            if (r9 != 0) goto L_0x0139
            r0.add(r3)
        L_0x0139:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            net.one97.travelpass.ui.c.j r3 = new net.one97.travelpass.ui.c.j
            r3.<init>()
            net.one97.travelpass.ui.b.b r5 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS
            r3.a((net.one97.travelpass.ui.b.b) r5)
            if (r7 == 0) goto L_0x015a
            net.one97.travelpass.model.MyPasses r5 = r7.getBody()
            if (r5 == 0) goto L_0x015a
            net.one97.travelpass.model.TravelPassMetaData r5 = r5.getMetadata()
            if (r5 == 0) goto L_0x015a
            java.lang.String r5 = r5.getCardLevelPartnerOfferHeading()
            goto L_0x015b
        L_0x015a:
            r5 = r1
        L_0x015b:
            r3.a((java.lang.String) r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r7 == 0) goto L_0x018e
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            if (r7 == 0) goto L_0x0188
            if (r9 != 0) goto L_0x0173
            kotlin.g.b.k.a()
        L_0x0173:
            int r9 = r9.intValue()
            net.one97.travelpass.model.PassData r9 = a((net.one97.travelpass.model.MyPassesResponse) r7, (int) r9)
            if (r9 == 0) goto L_0x0188
            java.util.List r5 = r9.getPartnerOffers()
            java.util.ArrayList r9 = b(r9, r7, r5)
            r5 = r9
            java.util.List r5 = (java.util.List) r5
        L_0x0188:
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.ArrayList r5 = b(r5)
        L_0x018e:
            r3.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r5)
            java.util.ArrayList r9 = r3.a()
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x01a2
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x01a0
            goto L_0x01a2
        L_0x01a0:
            r9 = 0
            goto L_0x01a3
        L_0x01a2:
            r9 = 1
        L_0x01a3:
            if (r9 != 0) goto L_0x01a8
            r0.add(r3)
        L_0x01a8:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            net.one97.travelpass.ui.c.j r10 = new net.one97.travelpass.ui.c.j
            r10.<init>()
            net.one97.travelpass.ui.b.b r3 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_INTERNAL_OFFERS
            r10.a((net.one97.travelpass.ui.b.b) r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r7 == 0) goto L_0x01e6
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            if (r7 == 0) goto L_0x01e0
            if (r9 != 0) goto L_0x01cb
            kotlin.g.b.k.a()
        L_0x01cb:
            int r9 = r9.intValue()
            net.one97.travelpass.model.PassData r9 = a((net.one97.travelpass.model.MyPassesResponse) r7, (int) r9)
            if (r9 == 0) goto L_0x01e0
            java.util.List r3 = r9.getInternalOffers()
            java.util.ArrayList r9 = a((net.one97.travelpass.model.PassData) r9, (net.one97.travelpass.model.MyPassesResponse) r7, (java.util.List<java.lang.String>) r3)
            r3 = r9
            java.util.List r3 = (java.util.List) r3
        L_0x01e0:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.ArrayList r3 = a((java.util.ArrayList<net.one97.travelpass.model.InternalOfferData>) r3)
        L_0x01e6:
            r10.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r3)
            java.util.ArrayList r9 = r10.a()
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x01fa
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x01f8
            goto L_0x01fa
        L_0x01f8:
            r9 = 0
            goto L_0x01fb
        L_0x01fa:
            r9 = 1
        L_0x01fb:
            if (r9 != 0) goto L_0x0200
            r0.add(r10)
        L_0x0200:
            if (r8 == 0) goto L_0x0229
            java.lang.String r9 = r8.getHowToUseId()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0213
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0211
            goto L_0x0213
        L_0x0211:
            r9 = 0
            goto L_0x0214
        L_0x0213:
            r9 = 1
        L_0x0214:
            if (r9 != 0) goto L_0x0229
            java.lang.String r9 = r8.getHowToUseId()
            java.util.ArrayList r9 = b(r7, r9)
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r10 = r9.isEmpty()
            if (r10 != 0) goto L_0x0229
            r0.addAll(r9)
        L_0x0229:
            if (r8 == 0) goto L_0x025a
            java.lang.String r9 = r8.getFaqId()
            if (r9 == 0) goto L_0x025a
            java.lang.String r9 = r8.getFaqId()
            net.one97.travelpass.ui.c.j r10 = new net.one97.travelpass.ui.c.j
            r10.<init>()
            net.one97.travelpass.ui.b.b r3 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_FAQ
            r10.a((net.one97.travelpass.ui.b.b) r3)
            java.util.ArrayList r9 = d(r7, r9)
            r10.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r9)
            java.util.ArrayList r9 = r10.a()
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x0254
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0255
        L_0x0254:
            r2 = 1
        L_0x0255:
            if (r2 != 0) goto L_0x025a
            r0.add(r10)
        L_0x025a:
            if (r8 == 0) goto L_0x0284
            java.lang.String r9 = r8.getTncId()
            if (r9 == 0) goto L_0x0284
            java.lang.String r8 = r8.getTncId()
            net.one97.travelpass.ui.c.j r9 = new net.one97.travelpass.ui.c.j
            r9.<init>()
            net.one97.travelpass.ui.b.b r10 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TEAMS_CONDITIONS
            r9.a((net.one97.travelpass.ui.b.b) r10)
            if (r7 == 0) goto L_0x0278
            if (r8 == 0) goto L_0x0278
            com.paytm.network.model.IJRPaytmDataModel r1 = a((net.one97.travelpass.model.MyPassesResponse) r7, (java.lang.String) r8)
        L_0x0278:
            r9.a((com.paytm.network.model.IJRPaytmDataModel) r1)
            com.paytm.network.model.IJRPaytmDataModel r7 = r9.b()
            if (r7 == 0) goto L_0x0284
            r0.add(r9)
        L_0x0284:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.c.a(net.one97.travelpass.model.MyPassesResponse, long, int):java.util.ArrayList");
    }

    private static PassData a(MyPassesResponse myPassesResponse, int i2) {
        if (myPassesResponse != null) {
            MyPasses body = myPassesResponse.getBody();
            List<PassData> verticalPassesData = body != null ? body.getVerticalPassesData() : null;
            Collection collection = verticalPassesData;
            if (!(collection == null || collection.isEmpty()) && k.a(verticalPassesData) >= i2) {
                return verticalPassesData.get(i2);
            }
        }
        return null;
    }

    private static int a(MyPassesResponse myPassesResponse, long j) {
        int size;
        if (myPassesResponse != null) {
            MyPasses body = myPassesResponse.getBody();
            List<PassData> verticalPassesData = body != null ? body.getVerticalPassesData() : null;
            Collection collection = verticalPassesData;
            if (!(collection == null || collection.isEmpty()) && (size = verticalPassesData.size() - 1) >= 0) {
                int i2 = 0;
                while (true) {
                    PassData passData = verticalPassesData.get(i2);
                    kotlin.g.b.k.a((Object) passData, "(passesData[i])");
                    Long itemId = passData.getItemId();
                    if (itemId == null || j != itemId.longValue()) {
                        if (i2 == size) {
                            break;
                        }
                        i2++;
                    } else {
                        return i2;
                    }
                }
            }
        }
        return 0;
    }

    private static ArrayList<j> a(MyPassesResponse myPassesResponse) {
        ArrayList<j> arrayList = new ArrayList<>();
        if (myPassesResponse != null) {
            MyPasses body = myPassesResponse.getBody();
            List<PassData> verticalPassesData = body != null ? body.getVerticalPassesData() : null;
            if (verticalPassesData != null && !verticalPassesData.isEmpty()) {
                int i2 = 0;
                int a2 = k.a(verticalPassesData);
                if (a2 >= 0) {
                    while (true) {
                        j jVar = new j();
                        jVar.a(b.TRAVEL_PASS_CAROUSEL_ITEM);
                        jVar.a((IJRPaytmDataModel) verticalPassesData.get(i2));
                        arrayList.add(jVar);
                        if (i2 == a2) {
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<j> a(MyPassesResponse myPassesResponse, Integer num) {
        List<PassData> verticalPassesData;
        List<PassData> verticalPassesData2;
        ArrayList<j> arrayList = new ArrayList<>();
        if (myPassesResponse != null) {
            MyPasses body = myPassesResponse.getBody();
            List<PassData.PassFields> list = null;
            if ((body != null ? body.getVerticalPassesData() : null) != null) {
                MyPasses body2 = myPassesResponse.getBody();
                Boolean valueOf = (body2 == null || (verticalPassesData2 = body2.getVerticalPassesData()) == null) ? null : Boolean.valueOf(verticalPassesData2.isEmpty());
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (!valueOf.booleanValue()) {
                    MyPasses body3 = myPassesResponse.getBody();
                    if (!(body3 == null || (verticalPassesData = body3.getVerticalPassesData()) == null)) {
                        if (num == null) {
                            kotlin.g.b.k.a();
                        }
                        PassData passData = verticalPassesData.get(num.intValue());
                        if (passData != null) {
                            list = passData.getFields();
                        }
                    }
                    if (list != null && !list.isEmpty()) {
                        int i2 = 0;
                        int a2 = k.a(list);
                        if (a2 >= 0) {
                            while (true) {
                                j jVar = new j();
                                jVar.a(b.TRAVEL_PASS_PRICE_DETAILS_ITEM);
                                jVar.a((IJRPaytmDataModel) list.get(i2));
                                arrayList.add(jVar);
                                if (i2 == a2) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<j> b(MyPassesResponse myPassesResponse, String str) {
        ArrayList<j> arrayList = new ArrayList<>();
        ArrayList<TravelPassMetaData.TypeCardData> c2 = c(myPassesResponse, str);
        int size = c2.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                TravelPassMetaData.TypeCardData typeCardData = c2.get(i2);
                kotlin.g.b.k.a((Object) typeCardData, "howToUseList.get(i)");
                TravelPassMetaData.TypeCardData typeCardData2 = typeCardData;
                j jVar = new j();
                if (typeCardData2 != null) {
                    jVar.a((IJRPaytmDataModel) typeCardData2);
                    if (i2 == 0) {
                        jVar.e();
                    }
                    if (i2 == c2.size() - 1) {
                        jVar.g();
                    }
                    jVar.a(b.TRAVEL_PASS_HOW_TO_USE);
                    arrayList.add(jVar);
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.IJRPaytmDataModel");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r3 = (r3 = (r3 = (r3 = r3.getBody()).getMetadata()).getHowtos()).getHowtouse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.TypeCardData> c(net.one97.travelpass.model.MyPassesResponse r3, java.lang.String r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0024
            net.one97.travelpass.model.MyPasses r3 = r3.getBody()
            if (r3 == 0) goto L_0x0024
            net.one97.travelpass.model.TravelPassMetaData r3 = r3.getMetadata()
            if (r3 == 0) goto L_0x0024
            net.one97.travelpass.model.TravelPassMetaData$HowToData r3 = r3.getHowtos()
            if (r3 == 0) goto L_0x0024
            net.one97.travelpass.model.TravelPassMetaData$HowToUse r3 = r3.getHowtouse()
            if (r3 == 0) goto L_0x0024
            java.util.List r3 = r3.getCards()
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            if (r3 == 0) goto L_0x005d
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x005d
            java.util.Iterator r3 = r3.iterator()
        L_0x0036:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r3.next()
            net.one97.travelpass.model.TravelPassMetaData$TypeCard r1 = (net.one97.travelpass.model.TravelPassMetaData.TypeCard) r1
            java.lang.String r2 = r1.getHowToUseId()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0036
            java.util.List r0 = r1.getHowToUseContent()
            if (r0 == 0) goto L_0x0055
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            goto L_0x0036
        L_0x0055:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.travelpass.model.TravelPassMetaData.TypeCardData> /* = java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.TypeCardData> */"
            r3.<init>(r4)
            throw r3
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.c.c(net.one97.travelpass.model.MyPassesResponse, java.lang.String):java.util.ArrayList");
    }

    private static ArrayList<j> d(MyPassesResponse myPassesResponse, String str) {
        ArrayList<j> arrayList = new ArrayList<>();
        ArrayList<TravelPassMetaData.FaqContent> e2 = e(myPassesResponse, str);
        int size = e2.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                TravelPassMetaData.FaqContent faqContent = e2.get(i2);
                kotlin.g.b.k.a((Object) faqContent, "faqList.get(i)");
                TravelPassMetaData.FaqContent faqContent2 = faqContent;
                j jVar = new j();
                if (faqContent2 != null) {
                    jVar.a((IJRPaytmDataModel) faqContent2);
                    if (i2 == 0) {
                        jVar.e();
                    }
                    if (i2 == e2.size() - 1) {
                        jVar.g();
                    }
                    jVar.a(b.TRAVEL_PASS_FAQ_ITEM);
                    arrayList.add(jVar);
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.IJRPaytmDataModel");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r3 = (r3 = r3.getBody()).getMetadata();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.FaqContent> e(net.one97.travelpass.model.MyPassesResponse r3, java.lang.String r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0018
            net.one97.travelpass.model.MyPasses r3 = r3.getBody()
            if (r3 == 0) goto L_0x0018
            net.one97.travelpass.model.TravelPassMetaData r3 = r3.getMetadata()
            if (r3 == 0) goto L_0x0018
            java.util.List r3 = r3.getFaq()
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            if (r3 == 0) goto L_0x004a
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x004a
            java.util.Iterator r3 = r3.iterator()
        L_0x002a:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x004a
            java.lang.Object r1 = r3.next()
            net.one97.travelpass.model.TravelPassMetaData$FaqData r1 = (net.one97.travelpass.model.TravelPassMetaData.FaqData) r1
            java.lang.String r2 = r1.getFaqId()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x002a
            java.util.ArrayList r0 = r1.getFaqContent()
            java.lang.String r1 = "faqData.faqContent"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            goto L_0x002a
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.c.e(net.one97.travelpass.model.MyPassesResponse, java.lang.String):java.util.ArrayList");
    }

    private static ArrayList<j> a(ArrayList<InternalOfferData> arrayList) {
        ArrayList<j> arrayList2 = new ArrayList<>();
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            Iterator<InternalOfferData> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                j jVar = new j();
                jVar.a(b.TRAVEL_PASS_INTERNAL_OFFERS_ITEM);
                jVar.a((IJRPaytmDataModel) it2.next());
                arrayList2.add(jVar);
            }
        }
        return arrayList2;
    }

    private static ArrayList<InternalOfferData> a(PassData passData, MyPassesResponse myPassesResponse, List<String> list) {
        TravelPassMetaData metadata;
        kotlin.g.b.k.c(passData, "selectedPassData");
        ArrayList<InternalOfferData> arrayList = new ArrayList<>();
        if (myPassesResponse != null) {
            Collection collection = list;
            boolean z = false;
            if (!(collection == null || collection.isEmpty())) {
                MyPasses body = myPassesResponse.getBody();
                List<InternalOfferData> internalOffers = (body == null || (metadata = body.getMetadata()) == null) ? null : metadata.getInternalOffers();
                Collection collection2 = internalOffers;
                if (collection2 == null || collection2.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    for (String next : list) {
                        for (InternalOfferData next2 : internalOffers) {
                            kotlin.g.b.k.a((Object) next2, "offers");
                            if (next2.getInternalOfferId().equals(next)) {
                                arrayList.add(next2);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<PartnersOfferData> b(PassData passData, MyPassesResponse myPassesResponse, List<String> list) {
        String str;
        TravelPassMetaData metadata;
        kotlin.g.b.k.c(passData, "selectedPassData");
        ArrayList<PartnersOfferData> arrayList = new ArrayList<>();
        if (myPassesResponse != null) {
            Collection collection = list;
            if (!(collection == null || collection.isEmpty())) {
                MyPasses body = myPassesResponse.getBody();
                List<PartnersOfferData> partnerOffers = (body == null || (metadata = body.getMetadata()) == null) ? null : metadata.getPartnerOffers();
                Collection collection2 = partnerOffers;
                if (!(collection2 == null || collection2.isEmpty())) {
                    for (String next : list) {
                        for (PartnersOfferData next2 : partnerOffers) {
                            kotlin.g.b.k.a((Object) next2, "offers");
                            if (next2.getPartnerOfferId().equals(next)) {
                                String partnerOfferId = next2.getPartnerOfferId();
                                if (passData != null) {
                                    CharSequence charSequence = partnerOfferId;
                                    if (!(charSequence == null || p.a(charSequence))) {
                                        PassData.AdditionalBenefitPromos additionalBenefitPromos = passData.getAdditionalBenefitPromos();
                                        kotlin.g.b.k.a((Object) additionalBenefitPromos, "selectedPassData.additionalBenefitPromos");
                                        if (additionalBenefitPromos.getPartnerOfferMapping() != null) {
                                            PassData.AdditionalBenefitPromos additionalBenefitPromos2 = passData.getAdditionalBenefitPromos();
                                            kotlin.g.b.k.a((Object) additionalBenefitPromos2, "selectedPassData.additionalBenefitPromos");
                                            if (additionalBenefitPromos2.getPartnerOfferMapping().containsKey(partnerOfferId)) {
                                                PassData.AdditionalBenefitPromos additionalBenefitPromos3 = passData.getAdditionalBenefitPromos();
                                                kotlin.g.b.k.a((Object) additionalBenefitPromos3, "selectedPassData.additionalBenefitPromos");
                                                str = additionalBenefitPromos3.getPartnerOfferMapping().get(partnerOfferId);
                                                next2.setPromocode(str);
                                                arrayList.add(next2);
                                            }
                                        }
                                    }
                                }
                                str = "";
                                next2.setPromocode(str);
                                arrayList.add(next2);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<j> b(ArrayList<PartnersOfferData> arrayList) {
        ArrayList<j> arrayList2 = new ArrayList<>();
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            Iterator<PartnersOfferData> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                j jVar = new j();
                jVar.a(b.TRAVEL_PASS_PARTNER_OFFERS_ITEM);
                jVar.a((IJRPaytmDataModel) it2.next());
                arrayList2.add(jVar);
            }
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r3 = r3.getMetadata();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.network.model.IJRPaytmDataModel a(net.one97.travelpass.model.MyPassesResponse r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0036
            if (r4 == 0) goto L_0x0036
            net.one97.travelpass.model.MyPasses r3 = r3.getBody()
            if (r3 == 0) goto L_0x0016
            net.one97.travelpass.model.TravelPassMetaData r3 = r3.getMetadata()
            if (r3 == 0) goto L_0x0016
            java.util.List r3 = r3.getTnc()
            goto L_0x0017
        L_0x0016:
            r3 = r0
        L_0x0017:
            if (r3 == 0) goto L_0x0036
            java.util.Iterator r3 = r3.iterator()
        L_0x001d:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r3.next()
            net.one97.travelpass.model.TravelPassMetaData$TncData r1 = (net.one97.travelpass.model.TravelPassMetaData.TncData) r1
            java.lang.String r2 = r1.getTncId()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x001d
            com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
            return r1
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.c.a(net.one97.travelpass.model.MyPassesResponse, java.lang.String):com.paytm.network.model.IJRPaytmDataModel");
    }

    public static j a(List<? extends j> list) {
        kotlin.g.b.k.c(list, "viewHolderModelList");
        if (list.isEmpty()) {
            return null;
        }
        for (j jVar : list) {
            if (jVar.c() == b.TRAVEL_PASS_CAROUSEL) {
                ArrayList<j> a2 = jVar.a();
                Collection collection = a2;
                if (!(collection == null || collection.isEmpty())) {
                    return a2.get(jVar.j());
                }
            }
        }
        return null;
    }
}
