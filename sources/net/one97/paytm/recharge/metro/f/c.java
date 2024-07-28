package net.one97.paytm.recharge.metro.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.google.gsonhtcfix.l;
import com.paytm.utility.f;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;
import org.json.JSONException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f63576a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final int f63577b = 4;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f63578c = f63578c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f63579d = f63579d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f63580e = f63580e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f63581f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final int f63582g = 1;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final int f63583h = 2;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static List<? extends CJRActiveMetroTicketModel> f63584i;
    /* access modifiers changed from: private */
    public static List<? extends CJRActiveMetroTicketModel> j;
    /* access modifiers changed from: private */
    public static List<? extends CJRActiveMetroTicketModel> k;
    /* access modifiers changed from: private */
    public static boolean l;
    /* access modifiers changed from: private */
    public static HashMap<String, CJRMetroQRFrequentOrderList> m = new HashMap<>();

    public static final class a {

        public static final class b extends com.google.gsonhtcfix.c.a<ArrayList<String>> {
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(String str) {
            String str2;
            if (str == null) {
                str2 = null;
            } else if (str != null) {
                str2 = str.toLowerCase();
                k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = "Mumbai Metro".toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase)) {
                String lowerCase2 = "MUMBAI_METRO".toLowerCase();
                k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                return lowerCase2;
            }
            String lowerCase3 = "Delhi Metro".toLowerCase();
            k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase3)) {
                String lowerCase4 = "DELHI_METRO".toLowerCase();
                k.a((Object) lowerCase4, "(this as java.lang.String).toLowerCase()");
                return lowerCase4;
            }
            String lowerCase5 = "Hyderabad Metro".toLowerCase();
            k.a((Object) lowerCase5, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase5)) {
                String lowerCase6 = "HYDERABAD_METRO".toLowerCase();
                k.a((Object) lowerCase6, "(this as java.lang.String).toLowerCase()");
                return lowerCase6;
            }
            String lowerCase7 = "MUMBAI_METRO".toLowerCase();
            k.a((Object) lowerCase7, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase7)) {
                String lowerCase8 = "MUMBAI_METRO".toLowerCase();
                k.a((Object) lowerCase8, "(this as java.lang.String).toLowerCase()");
                return lowerCase8;
            }
            String lowerCase9 = "DELHI_METRO".toLowerCase();
            k.a((Object) lowerCase9, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase9)) {
                String lowerCase10 = "DELHI_METRO".toLowerCase();
                k.a((Object) lowerCase10, "(this as java.lang.String).toLowerCase()");
                return lowerCase10;
            }
            String lowerCase11 = "HYDERABAD_METRO".toLowerCase();
            k.a((Object) lowerCase11, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase11)) {
                String lowerCase12 = "HYDERABAD_METRO".toLowerCase();
                k.a((Object) lowerCase12, "(this as java.lang.String).toLowerCase()");
                return lowerCase12;
            }
            String lowerCase13 = "metro".toLowerCase();
            k.a((Object) lowerCase13, "(this as java.lang.String).toLowerCase()");
            return lowerCase13;
        }

        public static int a(CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
            String str = null;
            if (!p.a(e.STORE_VALUE.getValue(), cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getProductType() : null, true)) {
                if (!p.a(e.SVP.getValue(), cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getProductType() : null, true)) {
                    if (!p.a(e.STORE_VALUE.getValue(), cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getSubType() : null, true)) {
                        if (!p.a(e.SVP.getValue(), cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getSubType() : null, true)) {
                            if (!p.a(e.TRIP_PASS.getValue(), cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getProductType() : null, true)) {
                                if (!p.a(e.TP.getValue(), cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getProductType() : null, true)) {
                                    if (!p.a(e.TRIP_PASS.getValue(), cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getSubType() : null, true)) {
                                        String value = e.TP.getValue();
                                        if (cJRActiveMetroTicketModel != null) {
                                            str = cJRActiveMetroTicketModel.getSubType();
                                        }
                                        if (!p.a(value, str, true)) {
                                            return c.f63581f;
                                        }
                                    }
                                }
                            }
                            return c.f63582g;
                        }
                    }
                }
            }
            return c.f63583h;
        }

        public static int b(String str) {
            k.c(str, "productType");
            if (p.a(e.STORE_VALUE.getValue(), str, true) || p.a(e.SVP.getValue(), str, true)) {
                return c.f63583h;
            }
            if (p.a(e.TRIP_PASS.getValue(), str, true) || p.a(e.TP.getValue(), str, true)) {
                return c.f63582g;
            }
            return c.f63581f;
        }

        public static void a(long j, Context context) {
            k.c(context, "context");
            List<CJRActiveMetroTicketModel> a2 = a(context);
            if (a2 != null) {
                CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(a2);
                Iterator it2 = copyOnWriteArraySet.iterator();
                while (it2.hasNext()) {
                    CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) it2.next();
                    if (j > 0) {
                        Long valueOf = Long.valueOf(j);
                        k.a((Object) cJRActiveMetroTicketModel, "ticket");
                        if (valueOf.equals(Long.valueOf(cJRActiveMetroTicketModel.getProductId()))) {
                            copyOnWriteArraySet.remove(cJRActiveMetroTicketModel);
                        }
                    }
                }
                ax.a aVar = ax.f61521a;
                Context applicationContext = context.getApplicationContext();
                k.a((Object) applicationContext, "context.applicationContext");
                com.paytm.b.a.a a3 = ax.a.a(applicationContext, f.a.METRO_PREF);
                String n = com.paytm.utility.b.n(context);
                k.a((Object) n, "CJRAppCommonUtility.getUserId(context)");
                a3.a(n, new com.google.gsonhtcfix.f().a((Object) copyOnWriteArraySet), false);
                a3.a("metroActiveTickets", com.paytm.utility.b.n(context), false);
            }
        }

        public static void a(Context context, String str) {
            k.c(context, "context");
            k.c(str, "userId");
            ax.a aVar = ax.f61521a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            com.paytm.b.a.a a2 = ax.a.a(applicationContext, f.a.METRO_PREF);
            a2.a(str, new com.google.gsonhtcfix.f().a((l) null), false);
            a2.a("metroActiveTickets", str, false);
        }

        public static List<CJRActiveMetroTicketModel> a(Context context) {
            k.c(context, "context");
            ax.a aVar = ax.f61521a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            com.paytm.b.a.a a2 = ax.a.a(applicationContext, f.a.METRO_PREF);
            String b2 = a2.b("metroActiveTickets", "", false);
            if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(com.paytm.utility.b.n(context)) && !com.paytm.utility.b.n(context).equals(b2)) {
                if (b2 == null) {
                    k.a();
                }
                a(context, b2);
            }
            String n = com.paytm.utility.b.n(context);
            k.a((Object) n, "CJRAppCommonUtility.getUserId(context)");
            try {
                return (List) new com.google.gsonhtcfix.f().a(a2.b(n, "", false), new d().getType());
            } catch (JSONException e2) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                return null;
            }
        }

        public static final class d extends com.google.gsonhtcfix.c.a<List<? extends CJRActiveMetroTicketModel>> {
            d() {
            }
        }

        public static String b(CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
            k.c(cJRActiveMetroTicketModel, "ticketModel");
            try {
                a aVar = c.f63576a;
                List h2 = c.f63584i;
                if (h2 == null) {
                    return null;
                }
                int size = h2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (cJRActiveMetroTicketModel.getProductId() == ((CJRActiveMetroTicketModel) h2.get(i2)).getProductId() && ((CJRActiveMetroTicketModel) h2.get(i2)).getQrCodes() == null) {
                        return ((CJRActiveMetroTicketModel) h2.get(i2)).getBalanceAmount();
                    }
                }
                return null;
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }

        public static Integer c(CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
            k.c(cJRActiveMetroTicketModel, "ticketModel");
            try {
                a aVar = c.f63576a;
                List h2 = c.f63584i;
                if (h2 == null) {
                    return null;
                }
                int size = h2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (cJRActiveMetroTicketModel.getProductId() == ((CJRActiveMetroTicketModel) h2.get(i2)).getProductId() && ((CJRActiveMetroTicketModel) h2.get(i2)).getQrCodes() == null) {
                        return Integer.valueOf(((CJRActiveMetroTicketModel) h2.get(i2)).getBalanceTrip_2());
                    }
                }
                return 0;
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }

        public static boolean c(String str) {
            k.c(str, "expiryDateString");
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "cc");
            instance.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date time = instance.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                Date parse = simpleDateFormat.parse(str);
                k.a((Object) parse, "format.parse(expiryDateString)");
                if (time.after(parse)) {
                    return true;
                }
                return false;
            } catch (ParseException e2) {
                q.d(e2.getMessage());
                return false;
            }
        }

        public static SpannableString a(Context context, String str, String str2, String str3, String str4, boolean z) {
            SpannableString spannableString;
            Context context2 = context;
            k.c(context2, "context");
            d.a aVar = d.Companion;
            int a2 = d.a.a(str);
            String str5 = "-";
            if (a2 == d.MUMBAI_METRO_SVP.getValue()) {
                int i2 = R.string.metro_mumbai_balance;
                Object[] objArr = new Object[1];
                if (str4 != null) {
                    str5 = str4;
                }
                objArr[0] = str5;
                spannableString = new SpannableString(context2.getString(i2, objArr));
            } else if (a2 == d.MUMBAI_METRO_TP.getValue()) {
                int i3 = R.string.metro_mumbai_station;
                Object[] objArr2 = new Object[2];
                String a3 = k.a(j(str2), (Object) "  ");
                if (a3 == null) {
                    a3 = str5;
                }
                objArr2[0] = a3;
                StringBuilder sb = new StringBuilder("  ");
                String j = j(str3);
                if (j == null) {
                    j = str5;
                }
                sb.append(j);
                objArr2[1] = sb.toString();
                spannableString = new SpannableString(context2.getString(i3, objArr2));
                String string = context2.getString(R.string.metro_mumbai_station, new Object[]{"", ""});
                k.a((Object) string, "context.getString(R.stri…tro_mumbai_station,\"\",\"\")");
                String spannableString2 = spannableString.toString();
                k.a((Object) spannableString2, "spannable.toString()");
                int a4 = p.a((CharSequence) spannableString2, string, 0, false, 6);
                Drawable a5 = androidx.appcompat.widget.f.b().a(context2, R.drawable.ic_trip_pass_arrow);
                if (z) {
                    a5.setBounds(0, 0, com.paytm.utility.b.c(25), com.paytm.utility.b.c(25));
                } else {
                    a5.setBounds(0, 0, com.paytm.utility.b.c(20), com.paytm.utility.b.c(20));
                }
                ImageSpan imageSpan = new ImageSpan(a5);
                Integer valueOf = string != null ? Integer.valueOf(string.length()) : null;
                if (valueOf == null) {
                    k.a();
                }
                spannableString.setSpan(imageSpan, a4, valueOf.intValue() + a4, 33);
            } else {
                int i4 = R.string.metro_mumbai_station;
                Object[] objArr3 = new Object[2];
                String a6 = k.a(j(str2), (Object) "  ");
                if (a6 == null) {
                    a6 = str5;
                }
                objArr3[0] = a6;
                StringBuilder sb2 = new StringBuilder("  ");
                String j2 = j(str3);
                if (j2 == null) {
                    j2 = str5;
                }
                sb2.append(j2);
                objArr3[1] = sb2.toString();
                spannableString = new SpannableString(context2.getString(i4, objArr3));
                String string2 = context2.getString(R.string.metro_mumbai_station, new Object[]{"", ""});
                k.a((Object) string2, "context.getString(R.stri…tro_mumbai_station,\"\",\"\")");
                String spannableString3 = spannableString.toString();
                k.a((Object) spannableString3, "spannable.toString()");
                int a7 = p.a((CharSequence) spannableString3, string2, 0, false, 6);
                Drawable a8 = androidx.appcompat.widget.f.b().a(context2, R.drawable.ic_to_arrow);
                if (z) {
                    a8.setBounds(0, 0, com.paytm.utility.b.c(25), com.paytm.utility.b.c(25));
                } else {
                    a8.setBounds(0, 0, com.paytm.utility.b.c(16), com.paytm.utility.b.c(16));
                }
                ImageSpan imageSpan2 = new ImageSpan(a8);
                Integer valueOf2 = string2 != null ? Integer.valueOf(string2.length()) : null;
                if (valueOf2 == null) {
                    k.a();
                }
                spannableString.setSpan(imageSpan2, a7, valueOf2.intValue() + a7, 33);
            }
            return spannableString;
        }

        public static HashMap<Integer, String> a(Context context, String str, CJRActiveMetroTicketModel cJRActiveMetroTicketModel, CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel, String str2) {
            String str3;
            k.c(context, "context");
            k.c(cJRActiveMetroTicketModel, "ticket");
            k.c(cJRActiveMetroTicketQRItemModel, "qrCode");
            k.c(str2, "balanceAmount");
            HashMap<Integer, String> hashMap = new HashMap<>();
            d.a aVar = d.Companion;
            int a2 = d.a.a(str);
            if (a2 == d.MUMBAI_METRO_SVP.getValue()) {
                Map map = hashMap;
                String string = context.getString(R.string.rupees_amount_re, new Object[]{str2});
                k.a((Object) string, "context.getString(R.stri…amount_re, balanceAmount)");
                map.put(0, string);
                String expiry = cJRActiveMetroTicketQRItemModel.getExpiry();
                k.a((Object) expiry, "qrCode.expiry");
                map.put(1, expiry);
                String operatorRefId = cJRActiveMetroTicketQRItemModel.getOperatorRefId();
                k.a((Object) operatorRefId, "qrCode.operatorRefId");
                map.put(2, operatorRefId);
                String qrCodeId = cJRActiveMetroTicketQRItemModel.getQrCodeId();
                k.a((Object) qrCodeId, "qrCode.qrCodeId");
                map.put(3, qrCodeId);
            } else if (a2 == d.MUMBAI_METRO_TP.getValue()) {
                try {
                    str3 = cJRActiveMetroTicketQRItemModel.getAmount();
                    k.a((Object) str3, "qrCode.amount");
                } catch (Exception e2) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                    str3 = "0";
                }
                Map map2 = hashMap;
                map2.put(0, String.valueOf(cJRActiveMetroTicketModel.getBalanceTrip_2()));
                String expiry2 = cJRActiveMetroTicketQRItemModel.getExpiry();
                k.a((Object) expiry2, "qrCode.expiry");
                map2.put(1, expiry2);
                String string2 = context.getString(R.string.rupees_amount_re, new Object[]{str3});
                k.a((Object) string2, "context.getString(R.stri…rupees_amount_re, amount)");
                map2.put(2, string2);
                String operatorRefId2 = cJRActiveMetroTicketQRItemModel.getOperatorRefId();
                k.a((Object) operatorRefId2, "qrCode.operatorRefId");
                map2.put(3, operatorRefId2);
                String qrCodeId2 = cJRActiveMetroTicketQRItemModel.getQrCodeId();
                k.a((Object) qrCodeId2, "qrCode.qrCodeId");
                map2.put(4, qrCodeId2);
            } else {
                Map map3 = hashMap;
                String issuedOn = cJRActiveMetroTicketQRItemModel.getIssuedOn();
                k.a((Object) issuedOn, "qrCode.issuedOn");
                map3.put(0, issuedOn);
                String operatorRefId3 = cJRActiveMetroTicketQRItemModel.getOperatorRefId();
                k.a((Object) operatorRefId3, "qrCode.operatorRefId");
                map3.put(1, operatorRefId3);
                String qrCodeId3 = cJRActiveMetroTicketQRItemModel.getQrCodeId();
                k.a((Object) qrCodeId3, "qrCode.qrCodeId");
                map3.put(2, qrCodeId3);
            }
            return hashMap;
        }

        public static List<CJRActiveMetroTicketModel> a(List<? extends CJRActiveMetroTicketModel> list, List<? extends CJRActiveMetroTicketModel> list2) {
            int i2 = 0;
            int size = list != null ? list.size() : 0;
            if (list2 != null) {
                i2 = list2.size();
            }
            ArrayList arrayList = new ArrayList(size + i2);
            if (size > 0) {
                if (list != null) {
                    for (CJRActiveMetroTicketModel cJRActiveMetroTicketModel : list) {
                        List<CJRActiveMetroTicketQRItemModel> qrCodes = cJRActiveMetroTicketModel.getQrCodes();
                        if (qrCodes != null) {
                            for (CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel : qrCodes) {
                                k.a((Object) cJRActiveMetroTicketQRItemModel, "qr");
                                cJRActiveMetroTicketQRItemModel.setPenaltyTicket(p.a("PENALTY", cJRActiveMetroTicketModel.getType(), true));
                            }
                        }
                    }
                }
                if (list == null) {
                    k.a();
                }
                arrayList.addAll(list);
            }
            if (i2 > 0) {
                if (list2 != null) {
                    for (CJRActiveMetroTicketModel pass : list2) {
                        pass.setPass(true);
                    }
                }
                if (list2 == null) {
                    k.a();
                }
                arrayList.addAll(list2);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }

        static List<CJRActiveMetroTicketModel> a(List<? extends CJRActiveMetroTicketModel> list) {
            if (list == null) {
                return null;
            }
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                return null;
            }
            for (CJRActiveMetroTicketModel cJRActiveMetroTicketModel : list) {
                List<CJRActiveMetroTicketQRItemModel> qrCodes = cJRActiveMetroTicketModel.getQrCodes();
                if (qrCodes != null) {
                    for (CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel : qrCodes) {
                        k.a((Object) cJRActiveMetroTicketQRItemModel, "qr");
                        cJRActiveMetroTicketQRItemModel.setPenaltyTicket(p.a("PENALTY", cJRActiveMetroTicketModel.getType(), true));
                    }
                }
            }
            return list;
        }

        static List<CJRActiveMetroTicketModel> b(List<? extends CJRActiveMetroTicketModel> list) {
            if (list == null) {
                return null;
            }
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                return null;
            }
            for (CJRActiveMetroTicketModel pass : list) {
                pass.setPass(true);
            }
            return list;
        }

        private static String j(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Integer valueOf = str != null ? Integer.valueOf(str.length()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() <= 12) {
                return str;
            }
            if (str != null) {
                String substring = str.substring(0, 11);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring + AppConstants.DOTS;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }

        public static boolean c(List<? extends CJRActiveMetroTicketModel> list) {
            k.c(list, "tickets");
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (true ^ TextUtils.isEmpty(((CJRActiveMetroTicketModel) next).getPassId())) {
                    arrayList.add(next);
                }
            }
            if (!((List) arrayList).isEmpty()) {
                return true;
            }
            for (CJRActiveMetroTicketModel cJRActiveMetroTicketModel : list) {
                if (p.a("PENALTY", cJRActiveMetroTicketModel.getType(), true)) {
                    return false;
                }
                if (cJRActiveMetroTicketModel.getQrCodes() != null) {
                    Iterator<CJRActiveMetroTicketQRItemModel> it2 = cJRActiveMetroTicketModel.getQrCodes().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            CJRActiveMetroTicketQRItemModel next2 = it2.next();
                            k.a((Object) next2, "qr");
                            if (!p.a("ACTIVE", next2.getStatus(), true)) {
                                return false;
                            }
                        }
                    }
                } else if (!TextUtils.isEmpty(cJRActiveMetroTicketModel.getPassId())) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }

        public static void a(String str, CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList) {
            k.c(str, "metroProductType");
            k.c(cJRMetroQRFrequentOrderList, "freqOrderList");
            if (TextUtils.isEmpty(str)) {
                str = "Mumbai_Metro_All_recents";
            }
            a aVar = c.f63576a;
            c.m.put(str, cJRMetroQRFrequentOrderList);
        }

        public static String e(String str) {
            k.c(str, "input");
            try {
                String format = new SimpleDateFormat("dd-MM-yyyy, hh:mm a").format(new SimpleDateFormat("hh:mm a, dd MM yyyy").parse(str));
                k.a((Object) format, "SimpleDateFormat(\"dd-MM-…y, hh:mm a\").format(date)");
                return format;
            } catch (ParseException unused) {
                return "";
            }
        }

        public static boolean f(String str) {
            String str2;
            if (str == null) {
                str2 = null;
            } else if (str != null) {
                str2 = str.toLowerCase();
                k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = "Delhi Metro".toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase)) {
                Collection i2 = c.j;
                return !(i2 == null || i2.isEmpty());
            }
            String lowerCase2 = "Mumbai Metro".toLowerCase();
            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase2)) {
                Collection h2 = c.f63584i;
                return !(h2 == null || h2.isEmpty());
            }
            String lowerCase3 = "Hyderabad Metro".toLowerCase();
            k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str2, (Object) lowerCase3)) {
                Collection j = c.k;
                if (!(j == null || j.isEmpty())) {
                    return true;
                }
            }
            return false;
        }

        public static CJRUtilityVariantV2 d(List<? extends CJRUtilityVariantV2> list) {
            k.c(list, "variantList");
            if (a()) {
                return null;
            }
            if (c.f63584i != null) {
                List h2 = c.f63584i;
                if (h2 == null) {
                    k.a();
                }
                if (!h2.isEmpty()) {
                    Collection arrayList = new ArrayList();
                    for (Object next : list) {
                        if (((CJRUtilityVariantV2) next).getFilterName().equals("Mumbai Metro")) {
                            arrayList.add(next);
                        }
                    }
                    List list2 = (List) arrayList;
                    if (!list2.isEmpty()) {
                        return (CJRUtilityVariantV2) list2.get(0);
                    }
                    return null;
                }
            }
            if (c.j != null) {
                List i2 = c.j;
                if (i2 == null) {
                    k.a();
                }
                if (!i2.isEmpty()) {
                    Collection arrayList2 = new ArrayList();
                    for (Object next2 : list) {
                        if (((CJRUtilityVariantV2) next2).getFilterName().equals("Delhi Metro")) {
                            arrayList2.add(next2);
                        }
                    }
                    List list3 = (List) arrayList2;
                    if (!list3.isEmpty()) {
                        return (CJRUtilityVariantV2) list3.get(0);
                    }
                    return null;
                }
            }
            if (c.k == null) {
                return null;
            }
            List j = c.k;
            if (j == null) {
                k.a();
            }
            if (!(!j.isEmpty())) {
                return null;
            }
            Collection arrayList3 = new ArrayList();
            for (Object next3 : list) {
                if (((CJRUtilityVariantV2) next3).getFilterName().equals("Hyderabad Metro")) {
                    arrayList3.add(next3);
                }
            }
            List list4 = (List) arrayList3;
            if (!list4.isEmpty()) {
                return (CJRUtilityVariantV2) list4.get(0);
            }
            return null;
        }

        public static String g(String str) {
            k.c(str, "str");
            int hashCode = str.hashCode();
            return hashCode != -1685566971 ? hashCode != 485876509 ? (hashCode == 1815361374 && str.equals("Mumbai Metro")) ? "/mumbai-metro-smart-card-recharge" : "" : str.equals("Hyderabad Metro") ? "/hyderabad-metro" : "" : str.equals("Delhi Metro") ? "/delhi-metro" : "";
        }

        public static String h(String str) {
            k.c(str, "str");
            int hashCode = str.hashCode();
            return hashCode != -1685566971 ? hashCode != 485876509 ? (hashCode == 1815361374 && str.equals("Mumbai Metro")) ? "mumbai_metro_smart_card_recharge" : "" : str.equals("Hyderabad Metro") ? "hyderabad_metro" : "" : str.equals("Delhi Metro") ? "delhi_metro" : "";
        }

        public static String i(String str) {
            k.c(str, "str");
            switch (str.hashCode()) {
                case -1845801377:
                    return str.equals(c.f63580e) ? "mumbai_metro_store_value_pass" : "";
                case -1685566971:
                    return str.equals("Delhi Metro") ? "delhi_metro" : "";
                case 485876509:
                    return str.equals("Hyderabad Metro") ? "hyderabad_metro" : "";
                case 506330020:
                    return str.equals(c.f63579d) ? "mumbai_metro_qr_ticket" : "";
                case 1546666796:
                    return str.equals(c.f63578c) ? "mumbai_metro_trip_pass" : "";
                case 1815361374:
                    return str.equals("Mumbai Metro") ? "mumbai_metro_smart_card_recharge" : "";
                default:
                    return "";
            }
        }

        /* renamed from: net.one97.paytm.recharge.metro.f.c$a$c  reason: collision with other inner class name */
        public static final class C1230c extends com.google.gsonhtcfix.c.a<ArrayList<String>> {
            C1230c() {
            }
        }

        public static void b(Context context) {
            ArrayList arrayList;
            k.c(context, "context");
            ax.a aVar = ax.f61521a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            com.paytm.b.a.a a2 = ax.a.a(applicationContext, f.a.METRO_PREF);
            if (a2 != null) {
                String b2 = a2.b("metro_activate_tickets_", "", false);
                if (!TextUtils.isEmpty(b2) && (arrayList = (ArrayList) new com.google.gsonhtcfix.f().a(b2, new C1229a().getType())) != null && (!arrayList.isEmpty())) {
                    Iterator it2 = arrayList.iterator();
                    k.a((Object) it2, "activeTicketList.iterator()");
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        k.a(next, "iterator.next()");
                        String str = p.a((CharSequence) (String) next, new String[]{"_"}).get(1);
                        if (!TextUtils.isEmpty(str)) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                            Date parse = simpleDateFormat.parse(str);
                            Date date = new Date();
                            Calendar instance = Calendar.getInstance();
                            k.a((Object) instance, "calendar");
                            instance.setTime(parse);
                            instance.add(5, 1);
                            Date time = instance.getTime();
                            if (date.compareTo(simpleDateFormat.parse(simpleDateFormat2.format(time) + " 1:15")) > 0) {
                                it2.remove();
                            }
                        }
                    }
                    a2.a("metro_activate_tickets_", new com.google.gsonhtcfix.f().a((Object) arrayList), false);
                }
            }
        }

        /* renamed from: net.one97.paytm.recharge.metro.f.c$a$a  reason: collision with other inner class name */
        public static final class C1229a extends com.google.gsonhtcfix.c.a<ArrayList<String>> {
            C1229a() {
            }
        }

        public static final class e implements Comparator<CJRMetroQRFrequentOrder> {
            e() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
                r1 = r4.getSource();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ int compare(java.lang.Object r4, java.lang.Object r5) {
                /*
                    r3 = this;
                    net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r4 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r4
                    net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r5 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r5
                    r0 = 0
                    if (r4 == 0) goto L_0x0012
                    net.one97.paytm.recharge.model.metro.CJRMetroStationModel r1 = r4.getSource()
                    if (r1 == 0) goto L_0x0012
                    java.lang.String r1 = r1.getName()
                    goto L_0x0013
                L_0x0012:
                    r1 = r0
                L_0x0013:
                    if (r5 == 0) goto L_0x0020
                    net.one97.paytm.recharge.model.metro.CJRMetroStationModel r2 = r5.getSource()
                    if (r2 == 0) goto L_0x0020
                    java.lang.String r2 = r2.getName()
                    goto L_0x0021
                L_0x0020:
                    r2 = r0
                L_0x0021:
                    boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
                    if (r1 == 0) goto L_0x007d
                    if (r4 == 0) goto L_0x0034
                    net.one97.paytm.recharge.model.metro.CJRMetroStationModel r1 = r4.getDestination()
                    if (r1 == 0) goto L_0x0034
                    java.lang.String r1 = r1.getName()
                    goto L_0x0035
                L_0x0034:
                    r1 = r0
                L_0x0035:
                    if (r5 == 0) goto L_0x0042
                    net.one97.paytm.recharge.model.metro.CJRMetroStationModel r2 = r5.getDestination()
                    if (r2 == 0) goto L_0x0042
                    java.lang.String r2 = r2.getName()
                    goto L_0x0043
                L_0x0042:
                    r2 = r0
                L_0x0043:
                    boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
                    if (r1 == 0) goto L_0x007d
                    if (r4 == 0) goto L_0x0050
                    java.lang.String r1 = r4.getProductID()
                    goto L_0x0051
                L_0x0050:
                    r1 = r0
                L_0x0051:
                    if (r5 == 0) goto L_0x0058
                    java.lang.String r2 = r5.getProductID()
                    goto L_0x0059
                L_0x0058:
                    r2 = r0
                L_0x0059:
                    boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
                    if (r1 == 0) goto L_0x007d
                    if (r4 == 0) goto L_0x006a
                    int r4 = r4.getJourneyTypeCode()
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    goto L_0x006b
                L_0x006a:
                    r4 = r0
                L_0x006b:
                    if (r5 == 0) goto L_0x0075
                    int r5 = r5.getJourneyTypeCode()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
                L_0x0075:
                    boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r0)
                    if (r4 == 0) goto L_0x007d
                    r4 = 0
                    return r4
                L_0x007d:
                    r4 = 1
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.f.c.a.e.compare(java.lang.Object, java.lang.Object):int");
            }
        }

        public static List<CJRMetroQRFrequentOrder> e(List<CJRMetroQRFrequentOrder> list) {
            k.c(list, "frequentOrderList");
            TreeSet treeSet = new TreeSet(new e());
            treeSet.addAll(list);
            List<CJRMetroQRFrequentOrder> arrayList = new ArrayList<>();
            arrayList.addAll(treeSet);
            return arrayList;
        }

        public static String a(int i2) {
            if (i2 == c.f63581f) {
                return "metro_qr_ticket";
            }
            if (i2 == c.f63582g) {
                return "trip_pass";
            }
            if (i2 == c.f63583h) {
                return "store_value_pass";
            }
            return "metro_qr_ticket";
        }

        public static CJRMetroQRFrequentOrderList d(String str) {
            k.c(str, "productType");
            HashMap l = c.m;
            if (l != null) {
                return (CJRMetroQRFrequentOrderList) l.get(str);
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x01b3  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01e9 A[Catch:{ Exception -> 0x01e3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0205 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0206 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(java.util.HashMap<java.lang.String, java.lang.String> r17) {
            /*
                r0 = r17
                java.lang.String r1 = "deepLinkParams"
                kotlin.g.b.k.c(r0, r1)
                java.util.List r1 = net.one97.paytm.recharge.metro.f.c.f63584i
                r2 = 0
                if (r1 == 0) goto L_0x0041
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.HashSet r3 = new java.util.HashSet
                r3.<init>()
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Iterator r1 = r1.iterator()
            L_0x001e:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L_0x003d
                java.lang.Object r5 = r1.next()
                r6 = r5
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r6
                long r6 = r6.getProductId()
                java.lang.Long r6 = java.lang.Long.valueOf(r6)
                boolean r6 = r3.add(r6)
                if (r6 == 0) goto L_0x001e
                r4.add(r5)
                goto L_0x001e
            L_0x003d:
                r1 = r4
                java.util.List r1 = (java.util.List) r1
                goto L_0x0042
            L_0x0041:
                r1 = r2
            L_0x0042:
                r3 = 16
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x00c9
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                int r6 = kotlin.a.k.a(r1)
                int r6 = kotlin.a.ae.a((int) r6)
                int r6 = kotlin.j.e.b(r6, r3)
                java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
                r7.<init>(r6)
                r6 = r7
                java.util.Map r6 = (java.util.Map) r6
                java.util.Iterator r1 = r1.iterator()
            L_0x0062:
                boolean r7 = r1.hasNext()
                if (r7 == 0) goto L_0x00ca
                java.lang.Object r7 = r1.next()
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
                long r8 = r7.getProductId()
                java.lang.Long r8 = java.lang.Long.valueOf(r8)
                net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
                java.util.List r9 = net.one97.paytm.recharge.metro.f.c.f63584i
                if (r9 == 0) goto L_0x00b0
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.util.Collection r10 = (java.util.Collection) r10
                java.util.Iterator r9 = r9.iterator()
            L_0x008b:
                boolean r11 = r9.hasNext()
                if (r11 == 0) goto L_0x00ad
                java.lang.Object r11 = r9.next()
                r12 = r11
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r12 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r12
                long r12 = r12.getProductId()
                long r14 = r7.getProductId()
                int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r16 != 0) goto L_0x00a6
                r12 = 1
                goto L_0x00a7
            L_0x00a6:
                r12 = 0
            L_0x00a7:
                if (r12 == 0) goto L_0x008b
                r10.add(r11)
                goto L_0x008b
            L_0x00ad:
                java.util.List r10 = (java.util.List) r10
                goto L_0x00b8
            L_0x00b0:
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r10 = r7
                java.util.List r10 = (java.util.List) r10
            L_0x00b8:
                kotlin.o r7 = new kotlin.o
                r7.<init>(r8, r10)
                java.lang.Object r8 = r7.getFirst()
                java.lang.Object r7 = r7.getSecond()
                r6.put(r8, r7)
                goto L_0x0062
            L_0x00c9:
                r6 = r2
            L_0x00ca:
                java.util.List r1 = net.one97.paytm.recharge.metro.f.c.j
                if (r1 == 0) goto L_0x0103
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.HashSet r7 = new java.util.HashSet
                r7.<init>()
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.Iterator r1 = r1.iterator()
            L_0x00e0:
                boolean r9 = r1.hasNext()
                if (r9 == 0) goto L_0x00ff
                java.lang.Object r9 = r1.next()
                r10 = r9
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
                long r10 = r10.getProductId()
                java.lang.Long r10 = java.lang.Long.valueOf(r10)
                boolean r10 = r7.add(r10)
                if (r10 == 0) goto L_0x00e0
                r8.add(r9)
                goto L_0x00e0
            L_0x00ff:
                r1 = r8
                java.util.List r1 = (java.util.List) r1
                goto L_0x0104
            L_0x0103:
                r1 = r2
            L_0x0104:
                if (r1 == 0) goto L_0x0187
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                int r7 = kotlin.a.k.a(r1)
                int r7 = kotlin.a.ae.a((int) r7)
                int r3 = kotlin.j.e.b(r7, r3)
                java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
                r7.<init>(r3)
                r3 = r7
                java.util.Map r3 = (java.util.Map) r3
                java.util.Iterator r1 = r1.iterator()
            L_0x0120:
                boolean r7 = r1.hasNext()
                if (r7 == 0) goto L_0x0188
                java.lang.Object r7 = r1.next()
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
                long r8 = r7.getProductId()
                java.lang.Long r8 = java.lang.Long.valueOf(r8)
                net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
                java.util.List r9 = net.one97.paytm.recharge.metro.f.c.j
                if (r9 == 0) goto L_0x016e
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.util.Collection r10 = (java.util.Collection) r10
                java.util.Iterator r9 = r9.iterator()
            L_0x0149:
                boolean r11 = r9.hasNext()
                if (r11 == 0) goto L_0x016b
                java.lang.Object r11 = r9.next()
                r12 = r11
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r12 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r12
                long r12 = r12.getProductId()
                long r14 = r7.getProductId()
                int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r16 != 0) goto L_0x0164
                r12 = 1
                goto L_0x0165
            L_0x0164:
                r12 = 0
            L_0x0165:
                if (r12 == 0) goto L_0x0149
                r10.add(r11)
                goto L_0x0149
            L_0x016b:
                java.util.List r10 = (java.util.List) r10
                goto L_0x0176
            L_0x016e:
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r10 = r7
                java.util.List r10 = (java.util.List) r10
            L_0x0176:
                kotlin.o r7 = new kotlin.o
                r7.<init>(r8, r10)
                java.lang.Object r8 = r7.getFirst()
                java.lang.Object r7 = r7.getSecond()
                r3.put(r8, r7)
                goto L_0x0120
            L_0x0187:
                r3 = r2
            L_0x0188:
                if (r3 == 0) goto L_0x01ab
                boolean r1 = r3.isEmpty()
                r1 = r1 ^ r5
                if (r1 != r5) goto L_0x01ab
                if (r6 == 0) goto L_0x019a
                boolean r1 = r6.isEmpty()
                if (r1 != r5) goto L_0x019a
                goto L_0x01ac
            L_0x019a:
                if (r6 == 0) goto L_0x01a3
                r1 = r6
                java.util.HashMap r1 = (java.util.HashMap) r1
                r1.putAll(r3)
                goto L_0x01ab
            L_0x01a3:
                kotlin.u r0 = new kotlin.u
                java.lang.String r1 = "null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.collections.List<net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>>"
                r0.<init>(r1)
                throw r0
            L_0x01ab:
                r3 = r6
            L_0x01ac:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                if (r3 == 0) goto L_0x01e5
                java.lang.String r6 = "product_id"
                java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x01e3 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x01e3 }
                if (r6 == 0) goto L_0x01dc
                if (r6 == 0) goto L_0x01d4
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x01e3 }
                java.lang.CharSequence r6 = kotlin.m.p.b(r6)     // Catch:{ Exception -> 0x01e3 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01e3 }
                if (r6 == 0) goto L_0x01dc
                long r6 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x01e3 }
                java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x01e3 }
                goto L_0x01dc
            L_0x01d4:
                kotlin.u r2 = new kotlin.u     // Catch:{ Exception -> 0x01e3 }
                java.lang.String r3 = "null cannot be cast to non-null type kotlin.CharSequence"
                r2.<init>(r3)     // Catch:{ Exception -> 0x01e3 }
                throw r2     // Catch:{ Exception -> 0x01e3 }
            L_0x01dc:
                java.lang.Object r2 = r3.get(r2)     // Catch:{ Exception -> 0x01e3 }
                java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x01e3 }
                goto L_0x01e5
            L_0x01e3:
                goto L_0x01ee
            L_0x01e5:
                boolean r3 = r2 instanceof java.util.List     // Catch:{ Exception -> 0x01e3 }
                if (r3 == 0) goto L_0x01ee
                java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ Exception -> 0x01e3 }
                r1.addAll(r2)     // Catch:{ Exception -> 0x01e3 }
            L_0x01ee:
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L_0x0206
                java.lang.String r1 = "is_product_rechargable"
                java.lang.Object r0 = r0.get(r1)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "TRUE"
                boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r5)
                if (r0 == 0) goto L_0x0205
                goto L_0x0206
            L_0x0205:
                return r4
            L_0x0206:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.f.c.a.a(java.util.HashMap):boolean");
        }

        /* JADX WARNING: Removed duplicated region for block: B:110:0x028c A[SYNTHETIC, Splitter:B:110:0x028c] */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x029a A[Catch:{ Exception -> 0x029f }] */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x02b3  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x02cc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(long r17) {
            /*
                java.util.List r0 = net.one97.paytm.recharge.metro.f.c.f63584i
                r1 = 0
                if (r0 == 0) goto L_0x003a
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.HashSet r2 = new java.util.HashSet
                r2.<init>()
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Iterator r0 = r0.iterator()
            L_0x0017:
                boolean r4 = r0.hasNext()
                if (r4 == 0) goto L_0x0036
                java.lang.Object r4 = r0.next()
                r5 = r4
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
                long r5 = r5.getProductId()
                java.lang.Long r5 = java.lang.Long.valueOf(r5)
                boolean r5 = r2.add(r5)
                if (r5 == 0) goto L_0x0017
                r3.add(r4)
                goto L_0x0017
            L_0x0036:
                r0 = r3
                java.util.List r0 = (java.util.List) r0
                goto L_0x003b
            L_0x003a:
                r0 = r1
            L_0x003b:
                r2 = 16
                r3 = 0
                r4 = 1
                if (r0 == 0) goto L_0x00c2
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                int r5 = kotlin.a.k.a(r0)
                int r5 = kotlin.a.ae.a((int) r5)
                int r5 = kotlin.j.e.b(r5, r2)
                java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
                r6.<init>(r5)
                r5 = r6
                java.util.Map r5 = (java.util.Map) r5
                java.util.Iterator r0 = r0.iterator()
            L_0x005b:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x00c3
                java.lang.Object r6 = r0.next()
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r6
                long r7 = r6.getProductId()
                java.lang.Long r7 = java.lang.Long.valueOf(r7)
                net.one97.paytm.recharge.metro.f.c$a r8 = net.one97.paytm.recharge.metro.f.c.f63576a
                java.util.List r8 = net.one97.paytm.recharge.metro.f.c.f63584i
                if (r8 == 0) goto L_0x00a9
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.Collection r9 = (java.util.Collection) r9
                java.util.Iterator r8 = r8.iterator()
            L_0x0084:
                boolean r10 = r8.hasNext()
                if (r10 == 0) goto L_0x00a6
                java.lang.Object r10 = r8.next()
                r11 = r10
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r11 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r11
                long r11 = r11.getProductId()
                long r13 = r6.getProductId()
                int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r15 != 0) goto L_0x009f
                r11 = 1
                goto L_0x00a0
            L_0x009f:
                r11 = 0
            L_0x00a0:
                if (r11 == 0) goto L_0x0084
                r9.add(r10)
                goto L_0x0084
            L_0x00a6:
                java.util.List r9 = (java.util.List) r9
                goto L_0x00b1
            L_0x00a9:
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                r9 = r6
                java.util.List r9 = (java.util.List) r9
            L_0x00b1:
                kotlin.o r6 = new kotlin.o
                r6.<init>(r7, r9)
                java.lang.Object r7 = r6.getFirst()
                java.lang.Object r6 = r6.getSecond()
                r5.put(r7, r6)
                goto L_0x005b
            L_0x00c2:
                r5 = r1
            L_0x00c3:
                java.util.List r0 = net.one97.paytm.recharge.metro.f.c.j
                if (r0 == 0) goto L_0x00fc
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.HashSet r6 = new java.util.HashSet
                r6.<init>()
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                java.util.Iterator r0 = r0.iterator()
            L_0x00d9:
                boolean r8 = r0.hasNext()
                if (r8 == 0) goto L_0x00f8
                java.lang.Object r8 = r0.next()
                r9 = r8
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r9
                long r9 = r9.getProductId()
                java.lang.Long r9 = java.lang.Long.valueOf(r9)
                boolean r9 = r6.add(r9)
                if (r9 == 0) goto L_0x00d9
                r7.add(r8)
                goto L_0x00d9
            L_0x00f8:
                r0 = r7
                java.util.List r0 = (java.util.List) r0
                goto L_0x00fd
            L_0x00fc:
                r0 = r1
            L_0x00fd:
                if (r0 == 0) goto L_0x0180
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                int r6 = kotlin.a.k.a(r0)
                int r6 = kotlin.a.ae.a((int) r6)
                int r6 = kotlin.j.e.b(r6, r2)
                java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
                r7.<init>(r6)
                r6 = r7
                java.util.Map r6 = (java.util.Map) r6
                java.util.Iterator r0 = r0.iterator()
            L_0x0119:
                boolean r7 = r0.hasNext()
                if (r7 == 0) goto L_0x0181
                java.lang.Object r7 = r0.next()
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
                long r8 = r7.getProductId()
                java.lang.Long r8 = java.lang.Long.valueOf(r8)
                net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
                java.util.List r9 = net.one97.paytm.recharge.metro.f.c.j
                if (r9 == 0) goto L_0x0167
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.util.Collection r10 = (java.util.Collection) r10
                java.util.Iterator r9 = r9.iterator()
            L_0x0142:
                boolean r11 = r9.hasNext()
                if (r11 == 0) goto L_0x0164
                java.lang.Object r11 = r9.next()
                r12 = r11
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r12 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r12
                long r12 = r12.getProductId()
                long r14 = r7.getProductId()
                int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r16 != 0) goto L_0x015d
                r12 = 1
                goto L_0x015e
            L_0x015d:
                r12 = 0
            L_0x015e:
                if (r12 == 0) goto L_0x0142
                r10.add(r11)
                goto L_0x0142
            L_0x0164:
                java.util.List r10 = (java.util.List) r10
                goto L_0x016f
            L_0x0167:
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r10 = r7
                java.util.List r10 = (java.util.List) r10
            L_0x016f:
                kotlin.o r7 = new kotlin.o
                r7.<init>(r8, r10)
                java.lang.Object r8 = r7.getFirst()
                java.lang.Object r7 = r7.getSecond()
                r6.put(r8, r7)
                goto L_0x0119
            L_0x0180:
                r6 = r1
            L_0x0181:
                java.util.List r0 = net.one97.paytm.recharge.metro.f.c.k
                if (r0 == 0) goto L_0x01ba
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.HashSet r7 = new java.util.HashSet
                r7.<init>()
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.Iterator r0 = r0.iterator()
            L_0x0197:
                boolean r9 = r0.hasNext()
                if (r9 == 0) goto L_0x01b6
                java.lang.Object r9 = r0.next()
                r10 = r9
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
                long r10 = r10.getProductId()
                java.lang.Long r10 = java.lang.Long.valueOf(r10)
                boolean r10 = r7.add(r10)
                if (r10 == 0) goto L_0x0197
                r8.add(r9)
                goto L_0x0197
            L_0x01b6:
                r0 = r8
                java.util.List r0 = (java.util.List) r0
                goto L_0x01bb
            L_0x01ba:
                r0 = r1
            L_0x01bb:
                if (r0 == 0) goto L_0x023e
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                int r7 = kotlin.a.k.a(r0)
                int r7 = kotlin.a.ae.a((int) r7)
                int r2 = kotlin.j.e.b(r7, r2)
                java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
                r7.<init>(r2)
                r2 = r7
                java.util.Map r2 = (java.util.Map) r2
                java.util.Iterator r0 = r0.iterator()
            L_0x01d7:
                boolean r7 = r0.hasNext()
                if (r7 == 0) goto L_0x023f
                java.lang.Object r7 = r0.next()
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
                long r8 = r7.getProductId()
                java.lang.Long r8 = java.lang.Long.valueOf(r8)
                net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
                java.util.List r9 = net.one97.paytm.recharge.metro.f.c.k
                if (r9 == 0) goto L_0x0225
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.util.Collection r10 = (java.util.Collection) r10
                java.util.Iterator r9 = r9.iterator()
            L_0x0200:
                boolean r11 = r9.hasNext()
                if (r11 == 0) goto L_0x0222
                java.lang.Object r11 = r9.next()
                r12 = r11
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r12 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r12
                long r12 = r12.getProductId()
                long r14 = r7.getProductId()
                int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r16 != 0) goto L_0x021b
                r12 = 1
                goto L_0x021c
            L_0x021b:
                r12 = 0
            L_0x021c:
                if (r12 == 0) goto L_0x0200
                r10.add(r11)
                goto L_0x0200
            L_0x0222:
                java.util.List r10 = (java.util.List) r10
                goto L_0x022d
            L_0x0225:
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r10 = r7
                java.util.List r10 = (java.util.List) r10
            L_0x022d:
                kotlin.o r7 = new kotlin.o
                r7.<init>(r8, r10)
                java.lang.Object r8 = r7.getFirst()
                java.lang.Object r7 = r7.getSecond()
                r2.put(r8, r7)
                goto L_0x01d7
            L_0x023e:
                r2 = r1
            L_0x023f:
                java.lang.String r0 = "null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.collections.List<net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>>"
                if (r6 == 0) goto L_0x0263
                boolean r7 = r6.isEmpty()
                r7 = r7 ^ r4
                if (r7 != r4) goto L_0x0263
                if (r5 == 0) goto L_0x0254
                boolean r7 = r5.isEmpty()
                if (r7 != r4) goto L_0x0254
                r5 = r6
                goto L_0x0263
            L_0x0254:
                if (r5 == 0) goto L_0x025d
                r7 = r5
                java.util.HashMap r7 = (java.util.HashMap) r7
                r7.putAll(r6)
                goto L_0x0263
            L_0x025d:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r0)
                throw r1
            L_0x0263:
                if (r2 == 0) goto L_0x0284
                boolean r6 = r2.isEmpty()
                r6 = r6 ^ r4
                if (r6 != r4) goto L_0x0284
                if (r5 == 0) goto L_0x0275
                boolean r6 = r5.isEmpty()
                if (r6 != r4) goto L_0x0275
                goto L_0x0285
            L_0x0275:
                if (r5 == 0) goto L_0x027e
                r0 = r5
                java.util.HashMap r0 = (java.util.HashMap) r0
                r0.putAll(r2)
                goto L_0x0284
            L_0x027e:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r0)
                throw r1
            L_0x0284:
                r2 = r5
            L_0x0285:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                if (r2 == 0) goto L_0x0296
                java.lang.Long r1 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x029f }
                java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x029f }
                java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x029f }
            L_0x0296:
                boolean r2 = r1 instanceof java.util.List     // Catch:{ Exception -> 0x029f }
                if (r2 == 0) goto L_0x029f
                java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ Exception -> 0x029f }
                r0.addAll(r1)     // Catch:{ Exception -> 0x029f }
            L_0x029f:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r1 = r1.iterator()
            L_0x02ad:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L_0x02c4
                java.lang.Object r5 = r1.next()
                r6 = r5
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r6
                boolean r6 = r6.isPass()
                if (r6 == 0) goto L_0x02ad
                r2.add(r5)
                goto L_0x02ad
            L_0x02c4:
                java.util.List r2 = (java.util.List) r2
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x02f0
                r0 = r2
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r0 = r0 ^ r4
                if (r0 == 0) goto L_0x02ef
                net.one97.paytm.recharge.metro.f.c$d r0 = net.one97.paytm.recharge.metro.f.c.d.MUMBAI_METRO_SVP
                int r0 = r0.getValue()
                net.one97.paytm.recharge.metro.f.c$d$a r1 = net.one97.paytm.recharge.metro.f.c.d.Companion
                java.lang.Object r1 = r2.get(r3)
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r1 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r1
                java.lang.String r1 = r1.getProductType()
                int r1 = net.one97.paytm.recharge.metro.f.c.d.a.a((java.lang.String) r1)
                if (r0 != r1) goto L_0x02ef
                goto L_0x02f0
            L_0x02ef:
                return r3
            L_0x02f0:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.f.c.a.a(long):boolean");
        }

        public static boolean a() {
            Collection h2 = c.f63584i;
            int i2 = !(h2 == null || h2.isEmpty()) ? 1 : 0;
            Collection i3 = c.j;
            if (!(i3 == null || i3.isEmpty())) {
                i2++;
            }
            Collection j = c.k;
            if (!(j == null || j.isEmpty())) {
                i2++;
            }
            return i2 > 1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0069  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x007c A[LOOP:0: B:13:0x0076->B:15:0x007c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(android.content.Context r8, net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9) {
            /*
                java.lang.String r0 = "context"
                kotlin.g.b.k.c(r8, r0)
                java.lang.String r0 = "ticket"
                kotlin.g.b.k.c(r9, r0)
                net.one97.paytm.recharge.common.utils.ax$a r0 = net.one97.paytm.recharge.common.utils.ax.f61521a
                android.content.Context r0 = r8.getApplicationContext()
                java.lang.String r1 = "context.applicationContext"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                com.paytm.utility.f$a r2 = com.paytm.utility.f.a.METRO_PREF
                com.paytm.b.a.a r0 = net.one97.paytm.recharge.common.utils.ax.a.a(r0, r2)
                java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r8)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                r3 = 0
                if (r2 == 0) goto L_0x002a
                r2 = r3
                goto L_0x002e
            L_0x002a:
                java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r8)
            L_0x002e:
                r4 = r2
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                r5 = 0
                java.lang.String r6 = "metro_activate_tickets_"
                if (r4 != 0) goto L_0x0066
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.String r2 = r6.concat(r2)
                java.lang.String r4 = ""
                java.lang.String r0 = r0.b((java.lang.String) r2, (java.lang.String) r4, (boolean) r5)
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0066
                com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f
                r2.<init>()
                net.one97.paytm.recharge.metro.f.c$a$c r4 = new net.one97.paytm.recharge.metro.f.c$a$c
                r4.<init>()
                java.lang.reflect.Type r4 = r4.getType()
                java.lang.Object r0 = r2.a((java.lang.String) r0, (java.lang.reflect.Type) r4)
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                goto L_0x0067
            L_0x0066:
                r0 = r3
            L_0x0067:
                if (r0 != 0) goto L_0x006e
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
            L_0x006e:
                java.util.List r9 = r9.getQrCodes()
                java.util.Iterator r9 = r9.iterator()
            L_0x0076:
                boolean r2 = r9.hasNext()
                if (r2 == 0) goto L_0x00b8
                java.lang.Object r2 = r9.next()
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r2 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r2
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r7 = "qrCode"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
                java.lang.String r2 = r2.getQrCodeId()
                r4.append(r2)
                java.lang.String r2 = "_"
                r4.append(r2)
                java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
                java.lang.String r7 = "dd-MM-yyyy HH:mm"
                r2.<init>(r7)
                java.util.Date r7 = new java.util.Date
                r7.<init>()
                java.lang.String r2 = r2.format(r7)
                java.lang.String r7 = "dateFormat.format(date)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r0.add(r2)
                goto L_0x0076
            L_0x00b8:
                java.lang.String r9 = com.paytm.utility.b.n((android.content.Context) r8)
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                boolean r9 = android.text.TextUtils.isEmpty(r9)
                if (r9 == 0) goto L_0x00c5
                goto L_0x00c9
            L_0x00c5:
                java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r8)
            L_0x00c9:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r9 = android.text.TextUtils.isEmpty(r3)
                if (r9 != 0) goto L_0x00ec
                net.one97.paytm.recharge.common.utils.ax$a r9 = net.one97.paytm.recharge.common.utils.ax.f61521a
                android.content.Context r8 = r8.getApplicationContext()
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
                com.paytm.utility.f$a r9 = com.paytm.utility.f.a.METRO_PREF
                com.paytm.b.a.a r8 = net.one97.paytm.recharge.common.utils.ax.a.a(r8, r9)
                com.google.gsonhtcfix.f r9 = new com.google.gsonhtcfix.f
                r9.<init>()
                java.lang.String r9 = r9.a((java.lang.Object) r0)
                r8.a((java.lang.String) r6, (java.lang.String) r9, (boolean) r5)
            L_0x00ec:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.f.c.a.a(android.content.Context, net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel):void");
        }
    }

    public enum d {
        MUMBAI_METRO_QR(0),
        MUMBAI_METRO_TP(1),
        MUMBAI_METRO_SVP(2),
        MUMBAI_METRO_SMC(3),
        NONE(4),
        MUMBAI_METRO_QR_TICKET(5),
        MUMBAI_METRO_TP_TICKET(6),
        MUMBAI_METRO_SVP_TICKET(7),
        SUB_METRO_HEADING(9),
        METRO_HEADING(8),
        METRO_ACTIVE_TRIP_PASS(10),
        METRO_ACTIVE_SVP(11),
        METRO_RECENTS_VIEW_TYPE(13),
        METRO_ACTIVE_QR_TICKET(12);
        
        public static final a Companion = null;
        private final int value;

        private d(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            Companion = new a((byte) 0);
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            public static int a(String str) {
                if (k.a((Object) str, (Object) e.RETURN.getValue()) || k.a((Object) str, (Object) e.OUTWARD.getValue()) || k.a((Object) str, (Object) e.PENALTY.getValue()) || k.a((Object) str, (Object) e.SJT.getValue()) || k.a((Object) str, (Object) e.RJT.getValue())) {
                    return d.MUMBAI_METRO_QR.getValue();
                }
                if (k.a((Object) str, (Object) e.SVP.getValue()) || k.a((Object) str, (Object) e.STORE_VALUE.getValue())) {
                    return d.MUMBAI_METRO_SVP.getValue();
                }
                if (k.a((Object) str, (Object) b.TRIPPASS_10.getValue()) || k.a((Object) str, (Object) b.TRIPPASS_30.getValue()) || k.a((Object) str, (Object) b.TRIPPASS_45.getValue()) || k.a((Object) str, (Object) b.TRIPPASS.getValue()) || k.a((Object) str, (Object) e.TP.getValue()) || k.a((Object) str, (Object) e.TRIP_PASS.getValue())) {
                    return d.MUMBAI_METRO_TP.getValue();
                }
                return d.NONE.getValue();
            }

            public static d a(int i2) {
                if (i2 == d.MUMBAI_METRO_QR.getValue()) {
                    return d.MUMBAI_METRO_QR;
                }
                if (i2 == d.MUMBAI_METRO_SVP.getValue()) {
                    return d.MUMBAI_METRO_SVP;
                }
                if (i2 == d.MUMBAI_METRO_TP.getValue()) {
                    return d.MUMBAI_METRO_TP;
                }
                if (i2 == d.MUMBAI_METRO_QR_TICKET.getValue()) {
                    return d.MUMBAI_METRO_QR_TICKET;
                }
                if (i2 == d.MUMBAI_METRO_SVP_TICKET.getValue()) {
                    return d.MUMBAI_METRO_SVP_TICKET;
                }
                if (i2 == d.MUMBAI_METRO_TP_TICKET.getValue()) {
                    return d.MUMBAI_METRO_TP_TICKET;
                }
                if (i2 == d.METRO_HEADING.getValue()) {
                    return d.METRO_HEADING;
                }
                if (i2 == d.SUB_METRO_HEADING.getValue()) {
                    return d.SUB_METRO_HEADING;
                }
                if (i2 == d.METRO_ACTIVE_TRIP_PASS.getValue()) {
                    return d.METRO_ACTIVE_TRIP_PASS;
                }
                if (i2 == d.METRO_ACTIVE_SVP.getValue()) {
                    return d.METRO_ACTIVE_SVP;
                }
                if (i2 == d.METRO_ACTIVE_QR_TICKET.getValue()) {
                    return d.METRO_ACTIVE_QR_TICKET;
                }
                if (i2 == d.METRO_RECENTS_VIEW_TYPE.getValue()) {
                    return d.METRO_RECENTS_VIEW_TYPE;
                }
                return d.NONE;
            }

            public static String b(String str) {
                if (k.a((Object) str, (Object) e.RETURN.getValue()) || k.a((Object) str, (Object) e.OUTWARD.getValue()) || k.a((Object) str, (Object) e.PENALTY.getValue()) || k.a((Object) str, (Object) e.SJT.getValue()) || k.a((Object) str, (Object) e.RJT.getValue())) {
                    a aVar = c.f63576a;
                    return c.f63579d;
                } else if (k.a((Object) str, (Object) e.SVP.getValue()) || k.a((Object) str, (Object) e.STORE_VALUE.getValue())) {
                    a aVar2 = c.f63576a;
                    return c.f63580e;
                } else if (!k.a((Object) str, (Object) e.TP.getValue()) && !k.a((Object) str, (Object) e.TRIP_PASS.getValue())) {
                    return null;
                } else {
                    a aVar3 = c.f63576a;
                    return c.f63578c;
                }
            }
        }
    }

    public enum e {
        RETURN("RETURN"),
        OUTWARD("OUTWARD"),
        PENALTY("PENALTY"),
        SJT("MUMBAI_METRO_SJT"),
        RJT("MUMBAI_METRO_RJT"),
        SVP("MUMBAI_METRO_SVP"),
        TP("MUMBAI_METRO_TP"),
        STORE_VALUE("STORE_VALUE"),
        TRIP_PASS("TRIP_PASS"),
        QR("MUMBAI_METRO_QR"),
        NONE("NA");
        
        private final String value;

        private e(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public enum b {
        RETURN("RETURN"),
        OUTWARD("OUTWARD"),
        PENALTY("PENALTY"),
        NONE("NA"),
        QR("DELHI_METRO_QR"),
        SJT("DELHI_METRO_SJT"),
        TRIPPASS_10("DELHI_METRO_TP_10"),
        TRIPPASS_30("DELHI_METRO_TP_30"),
        TRIPPASS_45("DELHI_METRO_TP_45"),
        TRIPPASS("DELHI_METRO_TP");
        
        private final String value;

        private b(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* renamed from: net.one97.paytm.recharge.metro.f.c$c  reason: collision with other inner class name */
    public enum C1231c {
        QR("HYDERABAD_METRO_QR"),
        RJT("HYDERABAD_METRO_RJT"),
        SJT("HYDERABAD_METRO_SJT");
        
        private final String value;

        private C1231c(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
