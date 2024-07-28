package net.one97.paytm.o2o.movies.utils;

import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;
import net.one97.paytm.common.entity.movies.moviepass.CJRMPMataDataModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemInstructionModel;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static String f75961a = m.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<Integer> f75962b = new Comparator<Integer>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static Comparator<String> f75963c = new Comparator<String>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            int compare = String.CASE_INSENSITIVE_ORDER.compare(String.valueOf(str.charAt(0)), String.valueOf(str2.charAt(0)));
            return compare == 0 ? Integer.compare(Integer.parseInt(str.substring(1)), Integer.parseInt(str2.substring(1))) : compare;
        }
    };

    public static ArrayList<CJRTaxInfo> a(Object obj) {
        ArrayList arrayList;
        Set<String> keySet;
        HashMap<String, String> b2 = b(obj);
        HashMap<String, String> d2 = d(obj);
        HashMap<String, String> d3 = d(obj);
        if (d3 == null || d3.size() <= 0 || (keySet = d3.keySet()) == null || keySet.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(keySet);
            if (arrayList.size() > 0) {
                arrayList.trimToSize();
            }
        }
        ArrayList<CJRTaxInfo> a2 = a(b2, arrayList, d2);
        if (a2.size() <= 0) {
            return null;
        }
        a2.trimToSize();
        return a2;
    }

    public static CJROrderSummaryMetadataResponseV2 a(CJROrderedCart cJROrderedCart) {
        Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
        f fVar = new f();
        return (CJROrderSummaryMetadataResponseV2) fVar.a(fVar.a(metaDataResponse), CJROrderSummaryMetadataResponseV2.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> b(java.lang.Object r4) {
        /*
            r0 = 0
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ JSONException -> 0x0038 }
            r1.<init>()     // Catch:{ JSONException -> 0x0038 }
            java.lang.String r4 = r1.a((java.lang.Object) r4)     // Catch:{ JSONException -> 0x0038 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ JSONException -> 0x0038 }
            r1.<init>()     // Catch:{ JSONException -> 0x0038 }
            if (r4 == 0) goto L_0x0045
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0036 }
            if (r0 != 0) goto L_0x0045
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0036 }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x0036 }
            java.util.Iterator r4 = r0.keys()     // Catch:{ JSONException -> 0x0036 }
            if (r4 == 0) goto L_0x0045
        L_0x0022:
            boolean r2 = r4.hasNext()     // Catch:{ JSONException -> 0x0036 }
            if (r2 == 0) goto L_0x0045
            java.lang.Object r2 = r4.next()     // Catch:{ JSONException -> 0x0036 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0036 }
            java.lang.String r3 = r0.getString(r2)     // Catch:{ JSONException -> 0x0036 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0036 }
            goto L_0x0022
        L_0x0036:
            r4 = move-exception
            goto L_0x003a
        L_0x0038:
            r4 = move-exception
            r1 = r0
        L_0x003a:
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x0045
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.m.b(java.lang.Object):java.util.HashMap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = new com.google.gsonhtcfix.f();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashMap<java.lang.String, java.lang.String> d(java.lang.Object r2) {
        /*
            if (r2 == 0) goto L_0x001c
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            java.lang.String r2 = r0.a((java.lang.Object) r2)
            if (r2 == 0) goto L_0x001c
            java.lang.Class<net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2> r1 = net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2.class
            java.lang.Object r2 = r0.a((java.lang.String) r2, r1)
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r2 = (net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2) r2
            if (r2 == 0) goto L_0x001c
            java.util.LinkedHashMap r2 = r2.getTaxInfo()
            return r2
        L_0x001c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.m.d(java.lang.Object):java.util.HashMap");
    }

    private static ArrayList<CJRTaxInfo> a(HashMap<String, String> hashMap, ArrayList<String> arrayList, HashMap<String, String> hashMap2) {
        ArrayList<CJRTaxInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0 && hashMap != null && hashMap.size() > 0 && hashMap2 != null && hashMap2.size() > 0) {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                CJRTaxInfo cJRTaxInfo = new CJRTaxInfo();
                cJRTaxInfo.setLabel(hashMap2.get(next));
                cJRTaxInfo.setValue(hashMap.get(next));
                if (hashMap.get(next) != null) {
                    arrayList2.add(cJRTaxInfo);
                }
            }
        }
        return arrayList2;
    }

    public static CJRMPMataDataModel b(CJROrderedCart cJROrderedCart) {
        Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
        f fVar = new f();
        return (CJRMPMataDataModel) fVar.a(fVar.a(metaDataResponse), CJRMPMataDataModel.class);
    }

    public static CJRMoviePassRedeemInstructionModel c(Object obj) {
        f fVar = new f();
        return (CJRMoviePassRedeemInstructionModel) fVar.a(fVar.a(obj), CJRMoviePassRedeemInstructionModel.class);
    }

    public static String a(String str) {
        ArrayList arrayList;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    String trim = str.substring(0, str.indexOf("-")).trim();
                    List asList = Arrays.asList(str.substring(str.indexOf("-") + 1).trim().split("\\s*,\\s*"));
                    if (asList != null) {
                        arrayList = new ArrayList(asList);
                        Collections.sort(arrayList, f75963c);
                    } else {
                        arrayList = null;
                    }
                    String a2 = a((ArrayList<String>) arrayList);
                    if (!TextUtils.isEmpty(a2)) {
                        if (!TextUtils.isEmpty(trim)) {
                            sb.append(trim);
                            sb.append(" - ");
                        }
                        sb.append(a2);
                    } else {
                        sb.append(str);
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        return null;
    }

    private static String a(ArrayList<String> arrayList) {
        try {
            StringBuilder sb = new StringBuilder();
            char charAt = arrayList.get(0).charAt(0);
            int parseInt = Integer.parseInt(arrayList.get(0).substring(1));
            int i2 = parseInt;
            char c2 = charAt;
            int i3 = 1;
            while (i3 <= arrayList.size()) {
                char c3 = '*';
                int i4 = -1;
                if (i3 != arrayList.size()) {
                    String str = arrayList.get(i3);
                    i4 = Integer.parseInt(str.substring(1));
                    c3 = str.charAt(0);
                }
                if (c3 != c2 || i4 - i2 > 1 || i3 == arrayList.size()) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(c2);
                    sb.append(parseInt);
                    int i5 = i2 - parseInt;
                    if (i5 > 1) {
                        sb.append("-");
                        sb.append(c2);
                        sb.append(i2);
                    } else if (i5 == 1) {
                        sb.append(", ");
                        sb.append(c2);
                        sb.append(i2);
                    }
                    if (c3 != c2) {
                        c2 = c3;
                    }
                    parseInt = i4;
                }
                i3++;
                i2 = i4;
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
