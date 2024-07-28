package net.one97.travelpass.e;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.travelpass.model.InternalOfferData;
import net.one97.travelpass.model.PartnersOfferData;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.model.TPAboutResponse;
import net.one97.travelpass.model.TravelPass;
import net.one97.travelpass.model.TravelPassData;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.model.VerticalData;
import net.one97.travelpass.model.VerticalPassesData;
import net.one97.travelpass.ui.b.b;
import net.one97.travelpass.ui.c.j;

public class h {
    public static VerticalPassesData a(String str, TravelPass travelPass) {
        k.c(str, "type");
        k.c(travelPass, "travelPass");
        TravelPassData body = travelPass.getBody();
        k.a((Object) body, "travelPass.body");
        List<VerticalPassesData> verticalPassesData = body.getVerticalPassesData();
        k.a((Object) verticalPassesData, "travelPass.body.verticalPassesData");
        VerticalPassesData verticalPassesData2 = null;
        if (verticalPassesData != null && (!verticalPassesData.isEmpty())) {
            for (VerticalPassesData next : verticalPassesData) {
                if (p.a(next.getVerticalType(), str, true)) {
                    verticalPassesData2 = a(next, (Integer) 10);
                }
            }
        }
        return verticalPassesData2;
    }

    /* access modifiers changed from: private */
    public static VerticalPassesData a(VerticalPassesData verticalPassesData, Integer num) {
        if (verticalPassesData != null) {
            Collection verticalPassesData2 = verticalPassesData.getVerticalPassesData();
            if (!(verticalPassesData2 == null || verticalPassesData2.isEmpty())) {
                for (PassData next : verticalPassesData.getVerticalPassesData()) {
                    k.a((Object) next, "passData");
                    if (num == null) {
                        k.a();
                    }
                    next.setMaxPurchaseCount(num.intValue());
                }
            }
        }
        return verticalPassesData;
    }

    private static ArrayList<VerticalData> c(TravelPass travelPass) {
        ArrayList<VerticalData> arrayList = new ArrayList<>();
        if (travelPass != null) {
            TravelPassData body = travelPass.getBody();
            k.a((Object) body, "travelPass.body");
            List<VerticalPassesData> verticalPassesData = body.getVerticalPassesData();
            k.a((Object) verticalPassesData, "travelPass.body.verticalPassesData");
            if (verticalPassesData != null && (!verticalPassesData.isEmpty())) {
                for (VerticalPassesData next : verticalPassesData) {
                    VerticalData verticalData = new VerticalData();
                    verticalData.setTitle(next.getTitle());
                    verticalData.setType(next.getVerticalType());
                    arrayList.add(verticalData);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r1 = (r1 = r2.getBody()).getMetadata();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.travelpass.ui.c.j a(net.one97.travelpass.model.TravelPass r2, net.one97.travelpass.ui.b.b r3) {
        /*
            java.lang.String r0 = "parentLayoutType"
            kotlin.g.b.k.c(r3, r0)
            net.one97.travelpass.ui.c.j r0 = new net.one97.travelpass.ui.c.j
            r0.<init>()
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_ABOUT_INFO
            r0.a((net.one97.travelpass.ui.b.b) r1)
            if (r2 == 0) goto L_0x0022
            net.one97.travelpass.model.TravelPassData r1 = r2.getBody()
            if (r1 == 0) goto L_0x0022
            net.one97.travelpass.model.TravelPassMetaData r1 = r1.getMetadata()
            if (r1 == 0) goto L_0x0022
            net.one97.travelpass.model.TravelPassMetaData$PassAboutInfo r1 = r1.getKnowMore()
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            if (r2 == 0) goto L_0x002f
            if (r1 == 0) goto L_0x002f
            r2 = r1
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            r0.a((com.paytm.network.model.IJRPaytmDataModel) r2)
            r1.mType = r3
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.h.a(net.one97.travelpass.model.TravelPass, net.one97.travelpass.ui.b.b):net.one97.travelpass.ui.c.j");
    }

    public static j a(TravelPass travelPass, String str) {
        j jVar = new j();
        jVar.a(b.TRAVEL_PASS_TABS);
        o<ArrayList<j>, Integer> i2 = i(travelPass, str);
        jVar.a(i2.getFirst());
        jVar.b(i2.getSecond().intValue());
        return jVar;
    }

    public static j b(TravelPass travelPass, String str) {
        VerticalPassesData a2;
        j jVar = new j();
        jVar.a(b.TRAVEL_PASS_CAROUSEL);
        if (!(travelPass == null || str == null)) {
            if (!(str.length() == 0) && (a2 = a(str, travelPass)) != null) {
                List<PassData> verticalPassesData = a2.getVerticalPassesData();
                k.a((Object) verticalPassesData, "verticalPassesData.verticalPassesData");
                if (!verticalPassesData.isEmpty()) {
                    jVar.a(c((List<? extends PassData>) a2.getVerticalPassesData()));
                }
            }
        }
        return jVar;
    }

    private static ArrayList<j> c(List<? extends PassData> list) {
        ArrayList<j> arrayList = new ArrayList<>();
        Collection collection = list;
        int i2 = 0;
        if (!(collection == null || collection.isEmpty())) {
            Integer valueOf = list != null ? Integer.valueOf(kotlin.a.k.a(list)) : null;
            if (valueOf == null) {
                k.a();
            }
            int intValue = valueOf.intValue();
            if (intValue >= 0) {
                while (true) {
                    PassData passData = list != null ? (PassData) list.get(i2) : null;
                    if (!(passData instanceof PassData)) {
                        passData = null;
                    }
                    j jVar = new j();
                    jVar.a(b.TRAVEL_PASS_CAROUSEL_ITEM);
                    jVar.a((IJRPaytmDataModel) passData);
                    arrayList.add(jVar);
                    if (i2 == intValue) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<j> a(ArrayList<PassData.PassFields> arrayList) {
        ArrayList<j> arrayList2 = new ArrayList<>();
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            Iterator<PassData.PassFields> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                PassData.PassFields next = it2.next();
                j jVar = new j();
                if (next != null) {
                    jVar.a((IJRPaytmDataModel) next);
                    jVar.a(b.TRAVEL_PASS_PRICE_DETAILS_ITEM);
                    arrayList2.add(jVar);
                } else {
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.IJRPaytmDataModel");
                }
            }
        }
        return arrayList2;
    }

    public static PassData a(TravelPass travelPass, String str, int i2) {
        VerticalPassesData a2;
        if (travelPass == null || str == null) {
            return null;
        }
        if ((str.length() == 0) || (a2 = a(str, travelPass)) == null) {
            return null;
        }
        List<PassData> verticalPassesData = a2.getVerticalPassesData();
        k.a((Object) verticalPassesData, "verticalPassesData.verticalPassesData");
        if (!(!verticalPassesData.isEmpty())) {
            return null;
        }
        List<PassData> verticalPassesData2 = a2.getVerticalPassesData();
        k.a((Object) verticalPassesData2, "verticalPassesData.verticalPassesData");
        return verticalPassesData2.get(i2);
    }

    public static ArrayList<j> a(List<? extends PartnersOfferData> list) {
        ArrayList<j> arrayList = new ArrayList<>();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (PartnersOfferData a2 : list) {
                j jVar = new j();
                jVar.a(b.TRAVEL_PASS_PARTNER_OFFERS_ITEM);
                jVar.a((IJRPaytmDataModel) a2);
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public static ArrayList<j> b(List<? extends InternalOfferData> list) {
        ArrayList<j> arrayList = new ArrayList<>();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (InternalOfferData a2 : list) {
                j jVar = new j();
                jVar.a(b.TRAVEL_PASS_INTERNAL_OFFERS_ITEM);
                jVar.a((IJRPaytmDataModel) a2);
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public static ArrayList<j> c(TravelPass travelPass, String str) {
        k.c(str, "howToUseId");
        ArrayList<j> arrayList = new ArrayList<>();
        ArrayList<TravelPassMetaData.TypeCardData> g2 = g(travelPass, str);
        int size = g2.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                TravelPassMetaData.TypeCardData typeCardData = g2.get(i2);
                k.a((Object) typeCardData, "howToUseList.get(i)");
                TravelPassMetaData.TypeCardData typeCardData2 = typeCardData;
                j jVar = new j();
                if (typeCardData2 != null) {
                    jVar.a((IJRPaytmDataModel) typeCardData2);
                    if (i2 == 0) {
                        jVar.e();
                    }
                    if (i2 == g2.size() - 1) {
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
        r4 = (r4 = (r4 = (r4 = r4.getBody()).getMetadata()).getHowtos()).getHowtouse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.TypeCardData> g(net.one97.travelpass.model.TravelPass r4, java.lang.String r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r4 == 0) goto L_0x0024
            net.one97.travelpass.model.TravelPassData r4 = r4.getBody()
            if (r4 == 0) goto L_0x0024
            net.one97.travelpass.model.TravelPassMetaData r4 = r4.getMetadata()
            if (r4 == 0) goto L_0x0024
            net.one97.travelpass.model.TravelPassMetaData$HowToData r4 = r4.getHowtos()
            if (r4 == 0) goto L_0x0024
            net.one97.travelpass.model.TravelPassMetaData$HowToUse r4 = r4.getHowtouse()
            if (r4 == 0) goto L_0x0024
            java.util.List r4 = r4.getCards()
            goto L_0x0025
        L_0x0024:
            r4 = 0
        L_0x0025:
            if (r4 == 0) goto L_0x0071
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x0071
            java.util.Iterator r4 = r4.iterator()
        L_0x0036:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0071
            java.lang.Object r1 = r4.next()
            net.one97.travelpass.model.TravelPassMetaData$TypeCard r1 = (net.one97.travelpass.model.TravelPassMetaData.TypeCard) r1
            java.lang.String r3 = r1.getHowToUseId()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0036
            java.util.List r3 = r1.getHowToUseContent()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x005d
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r3 = 0
            goto L_0x005e
        L_0x005d:
            r3 = 1
        L_0x005e:
            if (r3 != 0) goto L_0x0036
            java.util.List r0 = r1.getHowToUseContent()
            if (r0 == 0) goto L_0x0069
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            goto L_0x0036
        L_0x0069:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.travelpass.model.TravelPassMetaData.TypeCardData> /* = java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.TypeCardData> */"
            r4.<init>(r5)
            throw r4
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.h.g(net.one97.travelpass.model.TravelPass, java.lang.String):java.util.ArrayList");
    }

    public static ArrayList<j> d(TravelPass travelPass, String str) {
        ArrayList<j> arrayList = new ArrayList<>();
        ArrayList<TravelPassMetaData.FaqContent> h2 = h(travelPass, str);
        int size = h2.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                TravelPassMetaData.FaqContent faqContent = h2.get(i2);
                k.a((Object) faqContent, "faqList.get(i)");
                TravelPassMetaData.FaqContent faqContent2 = faqContent;
                j jVar = new j();
                if (faqContent2 != null) {
                    jVar.a((IJRPaytmDataModel) faqContent2);
                    if (i2 == 0) {
                        jVar.e();
                    }
                    if (i2 == h2.size() - 1) {
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
    private static java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.FaqContent> h(net.one97.travelpass.model.TravelPass r3, java.lang.String r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0018
            net.one97.travelpass.model.TravelPassData r3 = r3.getBody()
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.h.h(net.one97.travelpass.model.TravelPass, java.lang.String):java.util.ArrayList");
    }

    private static o<ArrayList<j>, Integer> i(TravelPass travelPass, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<VerticalData> c2 = c(travelPass);
        int a2 = kotlin.a.k.a(c2);
        int i2 = 0;
        if (a2 >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                j jVar = new j();
                VerticalData verticalData = c2.get(i3);
                k.a((Object) verticalData, "verticals.get(i)");
                VerticalData verticalData2 = verticalData;
                jVar.a(b.TRAVEL_PASS_TAB_ITEM);
                jVar.a((IJRPaytmDataModel) verticalData2);
                if (p.a(verticalData2.getType(), str, true)) {
                    jVar.a(true);
                    i4 = i3;
                }
                CharSequence charSequence = str;
                if ((charSequence == null || charSequence.length() == 0) && !arrayList.isEmpty()) {
                    Object obj = arrayList.get(0);
                    k.a(obj, "viewHolderModelList.get(0)");
                    ((j) obj).a(true);
                    i4 = 0;
                }
                arrayList.add(jVar);
                if (i3 == a2) {
                    break;
                }
                i3++;
            }
            i2 = i4;
        }
        return new o<>(arrayList, Integer.valueOf(i2));
    }

    public static String a(TravelPass travelPass) {
        if (travelPass != null) {
            ArrayList<VerticalData> c2 = c(travelPass);
            if (!c2.isEmpty()) {
                VerticalData verticalData = c2.get(0);
                k.a((Object) verticalData, "verticals.get(0)");
                String type = verticalData.getType();
                if (type == null) {
                    return "";
                }
                return type;
            }
        }
        return "";
    }

    public static ArrayList<j> b(ArrayList<TravelPassMetaData.KnowMore> arrayList) {
        int a2;
        ArrayList<j> arrayList2 = new ArrayList<>();
        Collection collection = arrayList;
        int i2 = 0;
        if (!(collection == null || collection.isEmpty()) && (a2 = kotlin.a.k.a(arrayList)) >= 0) {
            while (true) {
                TravelPassMetaData.KnowMore knowMore = arrayList.get(i2);
                k.a((Object) knowMore, "howToUseKnowMore.get(i)");
                j jVar = new j();
                jVar.a((IJRPaytmDataModel) knowMore);
                jVar.a(b.TRAVEL_PASS_KNOW_MORE_ITEMS);
                arrayList2.add(jVar);
                if (i2 == a2) {
                    break;
                }
                i2++;
            }
        }
        return arrayList2;
    }

    public static ArrayList<j> c(ArrayList<TravelPassMetaData.KnowMore> arrayList) {
        int a2;
        ArrayList<j> arrayList2 = new ArrayList<>();
        Collection collection = arrayList;
        int i2 = 0;
        if (!(collection == null || collection.isEmpty()) && (a2 = kotlin.a.k.a(arrayList)) >= 0) {
            while (true) {
                TravelPassMetaData.KnowMore knowMore = arrayList.get(i2);
                k.a((Object) knowMore, "howToUseKnowMore.get(i)");
                j jVar = new j();
                jVar.a((IJRPaytmDataModel) knowMore);
                jVar.a(b.TRAVEL_PASS_KNOW_MORE_ITEMS);
                arrayList2.add(jVar);
                if (i2 == a2) {
                    break;
                }
                i2++;
            }
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r7 = r7.getMetadata();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.String> a(net.one97.travelpass.model.PartnersOfferData r6, net.one97.travelpass.model.TravelPass r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r7 == 0) goto L_0x0053
            if (r6 == 0) goto L_0x0053
            net.one97.travelpass.model.TravelPassData r7 = r7.getBody()
            if (r7 == 0) goto L_0x001a
            net.one97.travelpass.model.TravelPassMetaData r7 = r7.getMetadata()
            if (r7 == 0) goto L_0x001a
            java.util.List r7 = r7.getTnc()
            goto L_0x001b
        L_0x001a:
            r7 = 0
        L_0x001b:
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            r2 = 0
            if (r1 == 0) goto L_0x002a
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r1 = 0
            goto L_0x002b
        L_0x002a:
            r1 = 1
        L_0x002b:
            if (r1 != 0) goto L_0x0053
            int r1 = kotlin.a.k.a(r7)
            if (r1 < 0) goto L_0x0053
        L_0x0033:
            java.lang.Object r3 = r7.get(r2)
            net.one97.travelpass.model.TravelPassMetaData$TncData r3 = (net.one97.travelpass.model.TravelPassMetaData.TncData) r3
            if (r3 == 0) goto L_0x004e
            java.lang.String r4 = r3.getTncId()
            java.lang.String r5 = r6.getTncId()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x004e
            java.util.ArrayList r6 = r3.getTncContent()
            return r6
        L_0x004e:
            if (r2 == r1) goto L_0x0053
            int r2 = r2 + 1
            goto L_0x0033
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.h.a(net.one97.travelpass.model.PartnersOfferData, net.one97.travelpass.model.TravelPass):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r7 = r7.getMetadata();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.String> a(net.one97.travelpass.model.InternalOfferData r6, net.one97.travelpass.model.TravelPass r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r7 == 0) goto L_0x0053
            if (r6 == 0) goto L_0x0053
            net.one97.travelpass.model.TravelPassData r7 = r7.getBody()
            if (r7 == 0) goto L_0x001a
            net.one97.travelpass.model.TravelPassMetaData r7 = r7.getMetadata()
            if (r7 == 0) goto L_0x001a
            java.util.List r7 = r7.getTnc()
            goto L_0x001b
        L_0x001a:
            r7 = 0
        L_0x001b:
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            r2 = 0
            if (r1 == 0) goto L_0x002a
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r1 = 0
            goto L_0x002b
        L_0x002a:
            r1 = 1
        L_0x002b:
            if (r1 != 0) goto L_0x0053
            int r1 = kotlin.a.k.a(r7)
            if (r1 < 0) goto L_0x0053
        L_0x0033:
            java.lang.Object r3 = r7.get(r2)
            net.one97.travelpass.model.TravelPassMetaData$TncData r3 = (net.one97.travelpass.model.TravelPassMetaData.TncData) r3
            if (r3 == 0) goto L_0x004e
            java.lang.String r4 = r3.getTncId()
            java.lang.String r5 = r6.getTncId()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x004e
            java.util.ArrayList r6 = r3.getTncContent()
            return r6
        L_0x004e:
            if (r2 == r1) goto L_0x0053
            int r2 = r2 + 1
            goto L_0x0033
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.h.a(net.one97.travelpass.model.InternalOfferData, net.one97.travelpass.model.TravelPass):java.util.ArrayList");
    }

    public static ArrayList<String> a(InternalOfferData internalOfferData, TPAboutResponse tPAboutResponse) {
        int a2;
        ArrayList<String> arrayList = new ArrayList<>();
        if (tPAboutResponse != null && internalOfferData != null) {
            TPAboutResponse.TPResponseBody tpAboutData = tPAboutResponse.getTpAboutData();
            ArrayList<TravelPassMetaData.TncData> tnc = tpAboutData != null ? tpAboutData.getTnc() : null;
            Collection collection = tnc;
            int i2 = 0;
            if (!(collection == null || collection.isEmpty()) && (a2 = kotlin.a.k.a(tnc)) >= 0) {
                while (true) {
                    TravelPassMetaData.TncData tncData = tnc.get(i2);
                    k.a((Object) tncData, "offersTncList.get(i)");
                    TravelPassMetaData.TncData tncData2 = tncData;
                    if (tncData2 == null || !tncData2.getTncId().equals(internalOfferData.getTncId())) {
                        if (i2 == a2) {
                            break;
                        }
                        i2++;
                    } else {
                        return tncData2.getTncContent();
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r3 = r3.getMetadata();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.network.model.IJRPaytmDataModel e(net.one97.travelpass.model.TravelPass r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0036
            if (r4 == 0) goto L_0x0036
            net.one97.travelpass.model.TravelPassData r3 = r3.getBody()
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.h.e(net.one97.travelpass.model.TravelPass, java.lang.String):com.paytm.network.model.IJRPaytmDataModel");
    }

    public static ArrayList<PartnersOfferData> a(TravelPass travelPass, List<String> list) {
        TravelPassMetaData metadata;
        ArrayList<PartnersOfferData> arrayList = new ArrayList<>();
        if (travelPass != null) {
            Collection collection = list;
            boolean z = false;
            if (!(collection == null || collection.isEmpty())) {
                TravelPassData body = travelPass.getBody();
                List<PartnersOfferData> partnerOffers = (body == null || (metadata = body.getMetadata()) == null) ? null : metadata.getPartnerOffers();
                Collection collection2 = partnerOffers;
                if (collection2 == null || collection2.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    for (String next : list) {
                        for (PartnersOfferData next2 : partnerOffers) {
                            k.a((Object) next2, "offers");
                            if (next2.getPartnerOfferId().equals(next)) {
                                arrayList.add(next2);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<j> d(ArrayList<PartnersOfferData> arrayList) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r8 = r8.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.o<java.lang.String, java.lang.Integer> f(net.one97.travelpass.model.TravelPass r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x000e
            net.one97.travelpass.model.TravelPassData r8 = r8.getBody()
            if (r8 == 0) goto L_0x000e
            java.util.List r8 = r8.getVerticalPassesData()
            goto L_0x000f
        L_0x000e:
            r8 = r0
        L_0x000f:
            boolean r1 = r8 instanceof java.util.List
            if (r1 != 0) goto L_0x0014
            r8 = r0
        L_0x0014:
            r0 = r8
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            if (r0 != 0) goto L_0x006b
            java.util.Iterator r8 = r8.iterator()
        L_0x002b:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x006b
            java.lang.Object r0 = r8.next()
            net.one97.travelpass.model.VerticalPassesData r0 = (net.one97.travelpass.model.VerticalPassesData) r0
            java.lang.String r3 = r0.getVerticalType()
            java.util.List r0 = r0.getVerticalPassesData()
            int r4 = r0.size()
            int r4 = r4 - r2
            if (r4 < 0) goto L_0x002b
            r5 = 0
        L_0x0047:
            java.lang.Object r6 = r0.get(r5)
            java.lang.String r7 = "passesData.get(i)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.travelpass.model.PassData r6 = (net.one97.travelpass.model.PassData) r6
            java.lang.String r6 = r6.getTravelPassId()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x0066
            kotlin.o r8 = new kotlin.o
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r8.<init>(r3, r9)
            return r8
        L_0x0066:
            if (r5 == r4) goto L_0x002b
            int r5 = r5 + 1
            goto L_0x0047
        L_0x006b:
            kotlin.o r8 = new kotlin.o
            r9 = -1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = ""
            r8.<init>(r0, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.e.h.f(net.one97.travelpass.model.TravelPass, java.lang.String):kotlin.o");
    }

    public static ArrayList<InternalOfferData> b(TravelPass travelPass, List<String> list) {
        TravelPassMetaData metadata;
        ArrayList<InternalOfferData> arrayList = new ArrayList<>();
        if (travelPass != null) {
            Collection collection = list;
            boolean z = false;
            if (!(collection == null || collection.isEmpty())) {
                TravelPassData body = travelPass.getBody();
                List<InternalOfferData> internalOffers = (body == null || (metadata = body.getMetadata()) == null) ? null : metadata.getInternalOffers();
                Collection collection2 = internalOffers;
                if (collection2 == null || collection2.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    for (String next : list) {
                        for (InternalOfferData next2 : internalOffers) {
                            k.a((Object) next2, "offers");
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

    public static ArrayList<j> e(ArrayList<InternalOfferData> arrayList) {
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

    public static boolean b(TravelPass travelPass) {
        boolean z;
        if (travelPass != null) {
            TravelPassData body = travelPass.getBody();
            Collection verticalPassesData = body != null ? body.getVerticalPassesData() : null;
            if (!(verticalPassesData == null || verticalPassesData.isEmpty())) {
                TravelPassData body2 = travelPass.getBody();
                k.a((Object) body2, "travelPass!!.body");
                Iterator<VerticalPassesData> it2 = body2.getVerticalPassesData().iterator();
                while (it2.hasNext()) {
                    VerticalPassesData next = it2.next();
                    Collection verticalPassesData2 = next != null ? next.getVerticalPassesData() : null;
                    if (verticalPassesData2 == null || verticalPassesData2.isEmpty()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
