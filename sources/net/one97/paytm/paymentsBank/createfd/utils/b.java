package net.one97.paytm.paymentsBank.createfd.utils;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.utils.n;

public final class b {
    /* access modifiers changed from: private */
    public static final String A = A;
    /* access modifiers changed from: private */
    public static final String B = B;
    /* access modifiers changed from: private */
    public static final String C = C;
    /* access modifiers changed from: private */
    public static final String D = D;
    /* access modifiers changed from: private */
    public static final String E = E;
    /* access modifiers changed from: private */
    public static final String F = SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING;
    /* access modifiers changed from: private */
    public static final String G = G;
    /* access modifiers changed from: private */
    public static final String H = H;

    /* renamed from: a  reason: collision with root package name */
    public static final a f18186a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final int f18187b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f18188c = 3;

    /* renamed from: d  reason: collision with root package name */
    private static final int f18189d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f18190e = f18190e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f18191f = "amount";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String f18192g = "from";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f18193h = f18193h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f18194i = "success";
    /* access modifiers changed from: private */
    public static final String j = "failure";
    /* access modifiers changed from: private */
    public static final String k = SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING;
    private static final String l = SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING;
    /* access modifiers changed from: private */
    public static final String m = m;
    /* access modifiers changed from: private */
    public static final String n = n;
    /* access modifiers changed from: private */
    public static final String o = o;
    /* access modifiers changed from: private */
    public static final int p = -1;
    /* access modifiers changed from: private */
    public static int q = 1182;
    private static int r = 1183;
    /* access modifiers changed from: private */
    public static int s = 1184;
    private static final long t = t;
    /* access modifiers changed from: private */
    public static final String u = u;
    /* access modifiers changed from: private */
    public static final int v = v;
    /* access modifiers changed from: private */
    public static final int w = w;
    /* access modifiers changed from: private */
    public static final int x = 0;
    /* access modifiers changed from: private */
    public static final int y = 1;
    /* access modifiers changed from: private */
    public static final String z = z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public enum c {
            SUCCESS(b.f18194i),
            PENDING(b.k),
            FAILED(b.j),
            PROCESSING(b.k),
            SUCCESS_DETAIL(b.m);

            private c(String str) {
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.createfd.utils.b$a$a  reason: collision with other inner class name */
        public enum C0305a {
            ADDMONEY_MODULE_RESPONSE(b.B),
            ZERO_AMOUNT(b.z),
            ADDMONEY(b.A),
            LESS_THEN_FLOOR_AMT(b.C),
            GREATER_THEN_CAP_AMT(b.D),
            SUCCESS(b.f18194i),
            FAILURE(b.j),
            PAN_UPDATION_REQUIRED(b.E),
            PROCESSING(b.f18193h);

            private C0305a(String str) {
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.createfd.utils.b$a$b  reason: collision with other inner class name */
        public enum C0306b {
            PREFRENCE_PENDING(b.F),
            PREFRENCE_ALREADY_SET(b.G),
            PREFRENCE_FIRST_TIME(b.H);
            
            private String status;

            private C0306b(String str) {
                this.status = str;
            }

            public final String getStatus() {
                return this.status;
            }

            public final void setStatus(String str) {
                k.c(str, "<set-?>");
                this.status = str;
            }

            public final String getStatusValue() {
                return this.status;
            }
        }

        public static String a(String str, long j) {
            k.c(str, "toFormat");
            try {
                Calendar instance = Calendar.getInstance();
                Date date = new Date(j);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                k.a((Object) instance, "now");
                simpleDateFormat.setTimeZone(instance.getTimeZone());
                DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.getDefault());
                dateFormatSymbols.setAmPmStrings(new String[]{"am", "pm"});
                simpleDateFormat.setDateFormatSymbols(dateFormatSymbols);
                String format = simpleDateFormat.format(date);
                k.a((Object) format, "format.format(date)");
                return format;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public static boolean a() {
            try {
                Calendar b2 = b("00:00:00");
                String p = n.p();
                k.a((Object) p, "PaymentBankGtmLoader.getFdCreationStartTime()");
                Calendar b3 = b(p);
                Calendar instance = Calendar.getInstance();
                k.a((Object) instance, "currentCalender");
                String format = new SimpleDateFormat("HH:mm:ss").format(instance.getTime());
                k.a((Object) format, "SimpleDateFormat(\"HH:mm:ss\").format(currentDate)");
                Calendar b4 = b(format);
                if (!b4.getTime().after(b2.getTime()) || !b4.getTime().before(b3.getTime())) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        private static Calendar b(String str) {
            k.c(str, "time");
            Date parse = new SimpleDateFormat("HH:mm:ss").parse(str);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "calendar");
            instance.setTime(parse);
            instance.add(5, 1);
            return instance;
        }

        public static long a(String str) {
            k.c(str, "time");
            Date parse = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ").parse(str);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "calendar");
            instance.setTime(parse);
            Calendar instance2 = Calendar.getInstance();
            long timeInMillis = instance.getTimeInMillis();
            k.a((Object) instance2, "currentCalender");
            return (instance2.getTimeInMillis() - timeInMillis) / 3600000;
        }
    }
}
