package net.one97.paytm.recharge.widgets.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f64967a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final DecimalFormat f64968b = new DecimalFormat("##,##,##,##,###", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, String> f64969c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final String f64970d = f64970d;

    /* renamed from: e  reason: collision with root package name */
    private static CJRRechargeErrorModel f64971e;

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f64972f = {"#2cce86", "#6c7cff", "#ffa400", "#b069ec", "#40cdd8", "#fd5c7f", "#f2c110", "#f36bb4", "#3ab6f4", "#a6b7be"};

    private d() {
    }

    public static final class a extends HashMap<String, String> {
        a() {
            put(BaseViewModel.PaymentType.COD, "Cash On Delivery");
            put("cc", "Credit Card");
            put("credit_card", "Credit Card");
            put("dc", "Debit Card");
            put("debit_card", "Debit Card");
            put("nb", "Net Banking");
            put(SDKConstants.UPI_NET_BANKING, "Net Banking");
            put("escrow", "ESCROW");
            put("emi", "EMI");
            put("upi", "UPI");
            put("ppi", "Paytm Wallet");
            put("paytm cash", "Paytm Wallet");
            put("balance", "Paytm Wallet");
            put("paytm_digital_credit", "Paytm Postpaid");
        }

        public final /* bridge */ boolean containsKey(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return containsKey((String) obj);
        }

        public final /* bridge */ boolean containsKey(String str) {
            return super.containsKey(str);
        }

        public final /* bridge */ boolean containsValue(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return containsValue((String) obj);
        }

        public final /* bridge */ boolean containsValue(String str) {
            return super.containsValue(str);
        }

        public final Set<Map.Entry<String, String>> entrySet() {
            return getEntries();
        }

        public final /* bridge */ Object get(Object obj) {
            if (!(obj instanceof String)) {
                return null;
            }
            return get((String) obj);
        }

        public final /* bridge */ String get(String str) {
            return (String) super.get(str);
        }

        public final Set getEntries() {
            return super.entrySet();
        }

        public final Set getKeys() {
            return super.keySet();
        }

        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj != null ? obj instanceof String : true) ? obj2 : getOrDefault((String) obj, (String) obj2);
        }

        public final /* bridge */ String getOrDefault(String str, String str2) {
            return (String) super.getOrDefault(str, str2);
        }

        public final int getSize() {
            return super.size();
        }

        public final Collection getValues() {
            return super.values();
        }

        public final Set<String> keySet() {
            return getKeys();
        }

        public final /* bridge */ Object remove(Object obj) {
            if (!(obj instanceof String)) {
                return null;
            }
            return remove((String) obj);
        }

        public final /* bridge */ String remove(String str) {
            return (String) super.remove(str);
        }

        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            boolean z = true;
            if (!(obj != null ? obj instanceof String : true)) {
                return false;
            }
            if (obj2 != null) {
                z = obj2 instanceof String;
            }
            if (!z) {
                return false;
            }
            return remove((String) obj, (String) obj2);
        }

        public final /* bridge */ boolean remove(String str, String str2) {
            return super.remove(str, str2);
        }

        public final int size() {
            return getSize();
        }

        public final Collection<String> values() {
            return getValues();
        }
    }

    public static HashMap<String, String> a() {
        return f64969c;
    }

    public static CJRRechargeErrorModel b() {
        if (f64971e == null) {
            f64971e = new CJRRechargeErrorModel((VERTICAL) null, (ERROR_TYPE) null, (String) null, (a.b) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CRUFlowModel) null, (HashMap) null, (String) null, (Bundle) null, (Object) null, 32767, (g) null);
        }
        CJRRechargeErrorModel cJRRechargeErrorModel = f64971e;
        if (cJRRechargeErrorModel == null) {
            k.a();
        }
        return cJRRechargeErrorModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007f, code lost:
        if (r8 == null) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel a(net.one97.paytm.recharge.widgets.model.ACTION_TYPE r32, net.one97.paytm.recharge.widgets.model.ERROR_TYPE r33) {
        /*
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = b()
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
            if (r1 != 0) goto L_0x0033
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r2 = r1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1048575(0xfffff, float:1.469367E-39)
            r24 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0.setFlowName(r1)
        L_0x0033:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r0.getFlowName()
            if (r8 == 0) goto L_0x0081
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r28.<init>()
            r9 = 0
            if (r33 == 0) goto L_0x004d
            java.lang.String r10 = r33.name()
            goto L_0x004e
        L_0x004d:
            r10 = r9
        L_0x004e:
            if (r32 == 0) goto L_0x0054
            java.lang.String r9 = r32.name()
        L_0x0054:
            r31 = r9
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r29 = 409732(0x64084, float:5.74157E-40)
            r30 = 0
            java.lang.String r25 = ""
            r9 = r10
            r10 = r31
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = net.one97.paytm.recharge.widgets.model.CRUFlowModel.copy$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            if (r8 != 0) goto L_0x00ae
        L_0x0081:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r9 = r8
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 1048575(0xfffff, float:1.469367E-39)
            r31 = 0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
        L_0x00ae:
            r11 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 6977(0x1b41, float:9.777E-42)
            r17 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel.copy$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
            if (r1 == 0) goto L_0x00cd
            java.lang.StringBuilder r1 = r1.getJourneyStackTrace()
            if (r1 == 0) goto L_0x00cd
            kotlin.m.p.a(r1)
        L_0x00cd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.widgets.c.d.a(net.one97.paytm.recharge.widgets.model.ACTION_TYPE, net.one97.paytm.recharge.widgets.model.ERROR_TYPE):net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel");
    }

    public static void a(CJRRechargeErrorModel cJRRechargeErrorModel, ACTION_TYPE action_type) {
        k.c(action_type, "actionType");
        a(cJRRechargeErrorModel, action_type.name());
    }

    public static void a(CJRRechargeErrorModel cJRRechargeErrorModel, String str) {
        k.c(str, "action");
        if (cJRRechargeErrorModel == null) {
            cJRRechargeErrorModel = b();
        }
        Stack stack = cJRRechargeErrorModel.getActionsMap().get(cJRRechargeErrorModel.getRechargeItemCategoryId());
        if (stack == null) {
            stack = new Stack();
            cJRRechargeErrorModel.getActionsMap().put(cJRRechargeErrorModel.getRechargeItemCategoryId(), stack);
        }
        if (stack.size() == 30) {
            stack.remove(0);
        }
        if ((!stack.isEmpty()) && (!k.a((Object) (String) stack.peek(), (Object) str))) {
            stack.push(str);
        } else if (stack.isEmpty()) {
            stack.push(str);
        }
    }

    public static void b(CJRRechargeErrorModel cJRRechargeErrorModel, ACTION_TYPE action_type) {
        k.c(action_type, "actionType");
        String name = action_type.name();
        k.c(name, "action");
        if (cJRRechargeErrorModel == null) {
            cJRRechargeErrorModel = b();
        }
        Stack stack = cJRRechargeErrorModel.getActionsMap().get(cJRRechargeErrorModel.getRechargeItemCategoryId());
        if (stack != null) {
            boolean z = true;
            if (!stack.isEmpty()) {
                while (z) {
                    if (stack.isEmpty() || !stack.contains(name) || k.a((Object) (String) stack.pop(), (Object) name)) {
                        z = false;
                    }
                }
            }
        }
    }

    public static void a(String str) {
        k.c(str, "message");
        try {
            l.a(str);
            d.class.getSimpleName();
            q.d(str);
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public static void a(Throwable th) {
        if (th != null) {
            q.d(th.getMessage());
            try {
                l.a(th);
            } catch (Exception unused) {
                q.d(th.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1 A[Catch:{ Exception -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r8) {
        /*
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000a
            return r8
        L_0x000a:
            if (r8 != 0) goto L_0x000f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00a9 }
        L_0x000f:
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r1 = " "
            kotlin.m.l r2 = new kotlin.m.l     // Catch:{ Exception -> 0x00a9 }
            r2.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x00a9 }
            r1 = 0
            java.util.List r0 = r2.split(r0, r1)     // Catch:{ Exception -> 0x00a9 }
            boolean r2 = r0.isEmpty()     // Catch:{ Exception -> 0x00a9 }
            r3 = 1
            if (r2 != 0) goto L_0x0052
            int r2 = r0.size()     // Catch:{ Exception -> 0x00a9 }
            java.util.ListIterator r2 = r0.listIterator(r2)     // Catch:{ Exception -> 0x00a9 }
        L_0x002d:
            boolean r4 = r2.hasPrevious()     // Catch:{ Exception -> 0x00a9 }
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r2.previous()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00a9 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x00a9 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x00a9 }
            if (r4 != 0) goto L_0x0043
            r4 = 1
            goto L_0x0044
        L_0x0043:
            r4 = 0
        L_0x0044:
            if (r4 != 0) goto L_0x002d
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x00a9 }
            int r2 = r2.nextIndex()     // Catch:{ Exception -> 0x00a9 }
            int r2 = r2 + r3
            java.util.List r0 = kotlin.a.k.b(r0, (int) r2)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0056
        L_0x0052:
            kotlin.a.w r0 = kotlin.a.w.INSTANCE     // Catch:{ Exception -> 0x00a9 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x00a9 }
        L_0x0056:
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x00a9 }
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object[] r0 = r0.toArray(r2)     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x00a1
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ Exception -> 0x00a9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a9 }
            r2.<init>()     // Catch:{ Exception -> 0x00a9 }
            int r4 = r0.length     // Catch:{ Exception -> 0x00a9 }
            r5 = 0
        L_0x0069:
            if (r5 >= r4) goto L_0x009c
            r6 = r0[r5]     // Catch:{ Exception -> 0x00a9 }
            char r6 = r6.charAt(r1)     // Catch:{ Exception -> 0x00a9 }
            char r6 = java.lang.Character.toUpperCase(r6)     // Catch:{ Exception -> 0x00a9 }
            r2.append(r6)     // Catch:{ Exception -> 0x00a9 }
            r6 = r0[r5]     // Catch:{ Exception -> 0x00a9 }
            if (r6 == 0) goto L_0x0094
            java.lang.String r6 = r6.substring(r3)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r7 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x00a9 }
            r2.append(r6)     // Catch:{ Exception -> 0x00a9 }
            int r6 = r0.length     // Catch:{ Exception -> 0x00a9 }
            int r6 = r6 - r3
            if (r5 >= r6) goto L_0x0091
            r6 = 32
            r2.append(r6)     // Catch:{ Exception -> 0x00a9 }
        L_0x0091:
            int r5 = r5 + 1
            goto L_0x0069
        L_0x0094:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)     // Catch:{ Exception -> 0x00a9 }
            throw r0     // Catch:{ Exception -> 0x00a9 }
        L_0x009c:
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00a9
        L_0x00a1:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)     // Catch:{ Exception -> 0x00a9 }
            throw r0     // Catch:{ Exception -> 0x00a9 }
        L_0x00a9:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.widgets.c.d.b(java.lang.String):java.lang.String");
    }

    public static double c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -1.0d;
            }
            if (str == null) {
                k.a();
            }
            CharSequence replace = new kotlin.m.l("[₹, ]").replace((CharSequence) str, "");
            int length = replace.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = replace.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            return new BigDecimal(new kotlin.m.l("\\.0*$").replace((CharSequence) new kotlin.m.l("^\\s+").replace((CharSequence) replace.subSequence(i2, length + 1).toString(), ""), "")).doubleValue();
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str == null) {
                k.a();
            }
            CharSequence replace = new kotlin.m.l("[₹, ]").replace((CharSequence) str, "");
            int length = replace.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = replace.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            return a(Double.valueOf(new BigDecimal(new kotlin.m.l("\\.0*$").replace((CharSequence) new kotlin.m.l("^\\s+").replace((CharSequence) replace.subSequence(i2, length + 1).toString(), ""), "")).doubleValue()));
        } catch (Exception unused) {
            if (str == null) {
                return "";
            }
            return str;
        }
    }

    public static String a(Double d2) {
        double d3 = 1.0d;
        if (d2 == null || d2.doubleValue() <= 0.0d) {
            d3 = 0.0d;
        } else if (d2.doubleValue() >= 1.0d) {
            d3 = d2.doubleValue();
        }
        return a(String.valueOf(d3), false, 2, false, 10);
    }

    public static /* synthetic */ String a(String str, boolean z, int i2, boolean z2, int i3) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        return a(str, z, i2, z2);
    }

    public static String a(String str, boolean z, int i2, boolean z2) {
        k.c(str, "str");
        CharSequence replace = new kotlin.m.l("[₹, ]").replace((CharSequence) str, "");
        int length = replace.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length) {
            boolean z4 = replace.charAt(!z3 ? i3 : length) <= ' ';
            if (z3) {
                if (!z4) {
                    break;
                }
                length--;
            } else if (!z4) {
                z3 = true;
            } else {
                i3++;
            }
        }
        String replace2 = new kotlin.m.l("^\\s+").replace((CharSequence) replace.subSequence(i3, length + 1).toString(), "");
        if (z2 && z) {
            replace2 = new kotlin.m.l("\\.0*$").replace((CharSequence) replace2, "");
        }
        try {
            if (TextUtils.isEmpty(replace2)) {
                return str;
            }
            if (p.a((CharSequence) replace2, (CharSequence) AppUtility.CENTER_DOT, false)) {
                return a(replace2, z, i2);
            }
            return f(replace2);
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return str;
        }
    }

    public static String e(String str) {
        k.c(str, "str");
        return a(str, false, 2, false, 2);
    }

    public static String a(String str, boolean z, int i2) {
        k.c(str, "str");
        BigDecimal bigDecimal = new BigDecimal(str);
        DecimalFormat decimalFormat = new DecimalFormat("##,##,##,##,###." + k(str), DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        if (z) {
            decimalFormat.setMinimumIntegerDigits(1);
        }
        if (i2 != -1) {
            decimalFormat.setMinimumFractionDigits(i2);
        }
        String format = decimalFormat.format(bigDecimal);
        k.a((Object) format, "formatter.format(parsed)");
        return format;
    }

    private static String k(String str) {
        k.c(str, "str");
        int i2 = 0;
        int length = (str.length() - 1) - p.a((CharSequence) str, AppUtility.CENTER_DOT, 0, false, 6);
        String str2 = "";
        while (i2 < length && i2 < 2) {
            str2 = str2 + "0";
            i2++;
        }
        return str2;
    }

    public static String f(String str) {
        k.c(str, "str");
        String format = f64968b.format(new BigDecimal(str));
        k.a((Object) format, "decimalFormatter.format(parsed)");
        return format;
    }

    public static boolean g(String str) {
        k.c(str, "input");
        try {
            return Double.parseDouble(str) > 0.0d;
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: net.one97.paytm.common.entity.shopping.CJRServiceActions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: net.one97.paytm.common.entity.shopping.CJRServiceActions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: net.one97.paytm.common.entity.shopping.CJRServiceActions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: net.one97.paytm.common.entity.shopping.CJRServiceActions} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.common.entity.shopping.CJRServiceActions a(net.one97.paytm.common.entity.shopping.CJRServiceOptions r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x002c
            java.util.ArrayList r5 = r5.getActions()
            if (r5 == 0) goto L_0x002c
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x000f:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r5.next()
            r2 = r1
            net.one97.paytm.common.entity.shopping.CJRServiceActions r2 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r2
            java.lang.String r2 = r2.getmLabel()
            r3 = 1
            java.lang.String r4 = "customerInfo"
            boolean r2 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r3)
            if (r2 == 0) goto L_0x000f
            r0 = r1
        L_0x002a:
            net.one97.paytm.common.entity.shopping.CJRServiceActions r0 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r0
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.widgets.c.d.a(net.one97.paytm.common.entity.shopping.CJRServiceOptions):net.one97.paytm.common.entity.shopping.CJRServiceActions");
    }

    public static String a(Context context, String str, String str2) {
        if (!b.c(str2)) {
            str2 = null;
        }
        net.one97.paytm.f.b.a().c();
        Context context2 = context;
        String str3 = str;
        net.one97.paytm.f.b.a().a(context2, str3, str2, false, (String) null, b.s(context), b.t(context));
        net.one97.paytm.f.b a2 = net.one97.paytm.f.b.a();
        k.a((Object) a2, "RiskInformationController.getInstance()");
        return a2.d();
    }

    public static String h(String str) {
        int i2;
        int i3;
        BigDecimal bigDecimal;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BigDecimal bigDecimal2 = new BigDecimal(str);
            String plainString = bigDecimal2.toPlainString();
            k.a((Object) plainString, "inputAmount.toPlainString()");
            if (p.a((CharSequence) plainString, (CharSequence) AppUtility.CENTER_DOT, false)) {
                String plainString2 = bigDecimal2.toPlainString();
                k.a((Object) plainString2, "inputAmount.toPlainString()");
                i2 = p.a((CharSequence) plainString2, AppUtility.CENTER_DOT, 0, false, 6);
                if (i2 != -1) {
                    String plainString3 = bigDecimal2.toPlainString();
                    k.a((Object) plainString3, "inputAmount.toPlainString()");
                    if (plainString3 != null) {
                        String substring = plainString3.substring(0, i2);
                        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        i3 = substring.length();
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    i3 = 0;
                }
            } else {
                i3 = bigDecimal2.toPlainString().length();
                i2 = -1;
            }
            if (i2 != -1) {
                bigDecimal2 = bigDecimal2.setScale(2, RoundingMode.DOWN);
            }
            if (bigDecimal2 == null) {
                return null;
            }
            if (i3 < 6) {
                String plainString4 = bigDecimal2.toPlainString();
                k.a((Object) plainString4, "inputAmount.toPlainString()");
                return a(plainString4, false, 0, false, 14);
            }
            if (i3 == 6 || i3 == 7) {
                bigDecimal = new BigDecimal(bigDecimal2.doubleValue() / 100000.0d);
                str2 = "Lac";
            } else {
                bigDecimal = new BigDecimal(bigDecimal2.doubleValue() / 1.0E7d);
                str2 = "Cr";
            }
            BigDecimal scale = bigDecimal.setScale(2, RoundingMode.DOWN);
            StringBuilder sb = new StringBuilder();
            String bigDecimal3 = scale.toString();
            k.a((Object) bigDecimal3, "result.toString()");
            sb.append(a(bigDecimal3, false, 0, false, 14));
            sb.append(' ');
            sb.append(str2);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(JSONObject jSONObject) {
        Object obj;
        ArrayList arrayList = new ArrayList(2);
        if (jSONObject != null) {
            try {
                obj = jSONObject.opt("cart_items");
            } catch (Exception unused) {
            }
        } else {
            obj = null;
        }
        if (!(obj instanceof JSONArray)) {
            obj = null;
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (jSONArray == null) {
                k.a();
            }
            Object opt = jSONArray.opt(i2);
            if (!(opt instanceof JSONObject)) {
                opt = null;
            }
            JSONObject jSONObject2 = (JSONObject) opt;
            Object opt2 = jSONObject2 != null ? jSONObject2.opt(CLPConstants.PRODUCT_ID) : null;
            Object opt3 = jSONObject2 != null ? jSONObject2.opt(CLConstants.INPUT_KEY_CONFIGURATION) : null;
            HashMap hashMap = new HashMap(2);
            hashMap.put(CLPConstants.PRODUCT_ID, opt2);
            hashMap.put(CLConstants.INPUT_KEY_CONFIGURATION, opt3);
            arrayList.add(hashMap);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new f().a((Object) arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(java.lang.String r8) {
        /*
            java.lang.String r0 = "name"
            kotlin.g.b.k.c(r8, r0)
            r0 = 0
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0094 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0094 }
            if (r1 != 0) goto L_0x0094
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0094 }
            int r1 = r8.length()     // Catch:{ Exception -> 0x0094 }
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r4 = r1
            r1 = 0
            r5 = 0
        L_0x001b:
            if (r1 > r4) goto L_0x003b
            if (r5 != 0) goto L_0x0021
            r6 = r1
            goto L_0x0022
        L_0x0021:
            r6 = r4
        L_0x0022:
            char r6 = r8.charAt(r6)     // Catch:{ Exception -> 0x0094 }
            r7 = 32
            if (r6 > r7) goto L_0x002c
            r6 = 1
            goto L_0x002d
        L_0x002c:
            r6 = 0
        L_0x002d:
            if (r5 != 0) goto L_0x0036
            if (r6 != 0) goto L_0x0033
            r5 = 1
            goto L_0x001b
        L_0x0033:
            int r1 = r1 + 1
            goto L_0x001b
        L_0x0036:
            if (r6 == 0) goto L_0x003b
            int r4 = r4 + -1
            goto L_0x001b
        L_0x003b:
            int r4 = r4 + r2
            java.lang.CharSequence r8 = r8.subSequence(r1, r4)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0094 }
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0094 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0094 }
            if (r1 != 0) goto L_0x0094
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094 }
            r1.<init>()     // Catch:{ Exception -> 0x0094 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0092 }
            java.lang.String r2 = "\\s+"
            kotlin.m.l r4 = new kotlin.m.l     // Catch:{ Exception -> 0x0092 }
            r4.<init>((java.lang.String) r2)     // Catch:{ Exception -> 0x0092 }
            java.util.List r8 = r4.split(r8, r3)     // Catch:{ Exception -> 0x0092 }
            int r2 = r8.size()     // Catch:{ Exception -> 0x0092 }
            if (r2 < 0) goto L_0x0095
            r4 = 0
        L_0x0066:
            java.lang.Object r5 = r8.get(r4)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0092 }
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0092 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0092 }
            if (r6 != 0) goto L_0x0086
            char r5 = r5.charAt(r3)     // Catch:{ Exception -> 0x0092 }
            boolean r6 = java.lang.Character.isLetterOrDigit(r5)     // Catch:{ Exception -> 0x0092 }
            if (r6 == 0) goto L_0x0086
            char r5 = java.lang.Character.toUpperCase(r5)     // Catch:{ Exception -> 0x0092 }
            r1.append(r5)     // Catch:{ Exception -> 0x0092 }
        L_0x0086:
            int r5 = r1.length()     // Catch:{ Exception -> 0x0092 }
            r6 = 2
            if (r5 == r6) goto L_0x0095
            if (r4 == r2) goto L_0x0095
            int r4 = r4 + 1
            goto L_0x0066
        L_0x0092:
            goto L_0x0095
        L_0x0094:
            r1 = r0
        L_0x0095:
            if (r1 == 0) goto L_0x009c
            java.lang.String r8 = r1.toString()
            return r8
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.widgets.c.d.i(java.lang.String):java.lang.String");
    }

    public static void a(TextView textView, String str, int i2) {
        k.c(textView, "textView");
        k.c(str, "name");
        textView.setBackgroundColor(Color.parseColor(f64972f[i2 % 10]));
        textView.setText(i(str));
    }

    public static /* synthetic */ SpannableString j(String str) {
        Typeface create = Typeface.create("sans-serif-medium", 1);
        k.a((Object) create, "Typeface.create(\"sans-se…f-medium\", Typeface.BOLD)");
        Typeface create2 = Typeface.create("sans-serif-light", 0);
        k.a((Object) create2, "Typeface.create(\"sans-se…-light\", Typeface.NORMAL)");
        return a(str, false, create, create2);
    }

    public static SpannableString a(String str, boolean z, Typeface typeface, Typeface typeface2) {
        k.c(typeface, "beforeDecimalFont");
        k.c(typeface2, "afterDecimalFont");
        if (str == null || p.b(str).toString().length() <= 0) {
            return null;
        }
        String concat = FilterPriceSliderFragment.RUPEE_SYMBOL.concat(String.valueOf(d(str)));
        CharSequence charSequence = concat;
        String str2 = p.a(charSequence, new String[]{AppUtility.CENTER_DOT}).get(0);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new CustomTypefaceSpan("", typeface), z ? 1 : 0, str2.length(), 18);
        if (p.a(charSequence, new String[]{AppUtility.CENTER_DOT}).size() > 1) {
            spannableString.setSpan(new CustomTypefaceSpan("", typeface2), str2.length() + 1, concat.length(), 18);
        }
        return spannableString;
    }
}
