package com.travel.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;
import com.travel.R;
import com.travel.model.CalendarDatePriceInfo;
import com.travel.model.CalendarHoliday;
import com.travel.utils.DottedProgressBarCalendar;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class d implements com.squareup.timessquare.v3.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f23453d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final Handler f23454a;

    /* renamed from: b  reason: collision with root package name */
    public DottedProgressBarCalendar f23455b;

    /* renamed from: c  reason: collision with root package name */
    public Context f23456c;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f23457e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, CalendarHoliday> f23458f;

    /* renamed from: g  reason: collision with root package name */
    private final Date f23459g;

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, CalendarDatePriceInfo> f23460h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f23461i;
    private final Date j;
    private final Date k;

    public d(Context context, HashMap<String, CalendarDatePriceInfo> hashMap, boolean z, Handler handler, HashMap<String, CalendarHoliday> hashMap2, boolean z2, String str, Date date, Date date2) {
        k.c(handler, "handler");
        k.c(str, "bookedDate");
        this.f23456c = context;
        this.f23460h = hashMap;
        this.f23461i = z2;
        this.j = date;
        this.k = date2;
        this.f23457e = z;
        this.f23454a = handler;
        this.f23458f = hashMap2;
        this.f23459g = new SimpleDateFormat("yyyy MM dd").parse(str);
    }

    private final ColorStateList a(int i2) {
        Context context = this.f23456c;
        if (context == null) {
            return null;
        }
        int[][] iArr = {new int[]{16842919}, new int[]{-16842913}};
        int[] iArr2 = new int[2];
        if (context == null) {
            k.a();
        }
        iArr2[0] = androidx.core.content.b.c(context, R.color.white);
        iArr2[1] = i2;
        return new ColorStateList(iArr, iArr2);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<DottedProgressBarCalendar> f23462a;

        /* renamed from: b  reason: collision with root package name */
        private final int f23463b;

        public b(DottedProgressBarCalendar dottedProgressBarCalendar, int i2) {
            k.c(dottedProgressBarCalendar, "cjrDottedProgressBarFlight");
            this.f23462a = new WeakReference<>(dottedProgressBarCalendar);
            this.f23463b = i2;
        }

        public final void run() {
            DottedProgressBarCalendar dottedProgressBarCalendar = (DottedProgressBarCalendar) this.f23462a.get();
            if (dottedProgressBarCalendar != null) {
                dottedProgressBarCalendar.setVisibility(this.f23463b);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(String str) {
            k.c(str, "value");
            while (str.length() > 1 && p.a((CharSequence) str, "0", 0, false, 6) == 0) {
                if (str != null) {
                    str = str.substring(1);
                    k.a((Object) str, "(this as java.lang.String).substring(startIndex)");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return str;
        }

        public static Date a(Date date) {
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "calendar");
            instance.setTime(date);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTime();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f5 A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0119 A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0131 A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x017b A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0182 A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0187 A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018e A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0191 A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x019e A[Catch:{ Exception -> 0x032e }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ad A[Catch:{ Exception -> 0x032e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.squareup.timessquare.v3.CalendarCellView r12, java.util.Date r13) {
        /*
            r11 = this;
            java.lang.String r0 = "cellView"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "date"
            kotlin.g.b.k.c(r13, r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x032e }
            java.lang.String r1 = "dd"
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x032e }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r0.format(r13)     // Catch:{ Exception -> 0x032e }
            java.lang.String r1 = "day"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = com.travel.f.d.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x032e }
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x032e }
            java.lang.String r2 = "yyyy-MM-dd"
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x032e }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x032e }
            java.lang.String r1 = r1.format(r13)     // Catch:{ Exception -> 0x032e }
            int r2 = com.travel.R.id.flight_calendar_custom_date_cell     // Catch:{ Exception -> 0x032e }
            android.view.View r2 = r12.findViewById(r2)     // Catch:{ Exception -> 0x032e }
            java.lang.String r3 = "null cannot be cast to non-null type android.widget.TextView"
            if (r2 == 0) goto L_0x0328
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x032e }
            int r4 = com.travel.R.id.flight_calendar_custom_price_cell     // Catch:{ Exception -> 0x032e }
            android.view.View r4 = r12.findViewById(r4)     // Catch:{ Exception -> 0x032e }
            if (r4 == 0) goto L_0x0322
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x032e }
            int r3 = com.travel.R.id.flight_cell_lyt     // Catch:{ Exception -> 0x032e }
            android.view.View r3 = r12.findViewById(r3)     // Catch:{ Exception -> 0x032e }
            if (r3 == 0) goto L_0x031a
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3     // Catch:{ Exception -> 0x032e }
            int r5 = com.travel.R.id.progressBar     // Catch:{ Exception -> 0x032e }
            android.view.View r5 = r12.findViewById(r5)     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x0312
            com.travel.utils.DottedProgressBarCalendar r5 = (com.travel.utils.DottedProgressBarCalendar) r5     // Catch:{ Exception -> 0x032e }
            r11.f23455b = r5     // Catch:{ Exception -> 0x032e }
            android.view.View r5 = r12.getFlightMarker()     // Catch:{ Exception -> 0x032e }
            java.lang.String r6 = "cellView.flightMarker"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x032e }
            r6 = 0
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x032e }
            int r5 = com.travel.R.drawable.cal_bg_new     // Catch:{ Exception -> 0x032e }
            r12.setBackgroundResource(r5)     // Catch:{ Exception -> 0x032e }
            r3.setBackgroundResource(r6)     // Catch:{ Exception -> 0x032e }
            android.widget.TextView r5 = r12.getDayOfMonthTextView()     // Catch:{ Exception -> 0x032e }
            r7 = 1
            r8 = 0
            r5.setTypeface(r8, r7)     // Catch:{ Exception -> 0x032e }
            java.util.Date r5 = r11.f23459g     // Catch:{ Exception -> 0x032e }
            r7 = 8
            if (r5 == 0) goto L_0x009e
            java.util.Date r5 = com.travel.f.d.a.a((java.util.Date) r13)     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x0087
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x0087:
            java.util.Date r9 = r11.f23459g     // Catch:{ Exception -> 0x032e }
            java.util.Date r9 = com.travel.f.d.a.a((java.util.Date) r9)     // Catch:{ Exception -> 0x032e }
            boolean r5 = r5.before(r9)     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x009e
            com.travel.utils.DottedProgressBarCalendar r5 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x009a
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x009a:
            r5.setVisibility(r7)     // Catch:{ Exception -> 0x032e }
            goto L_0x00c3
        L_0x009e:
            boolean r5 = r12.a()     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x00b9
            com.travel.utils.DottedProgressBarCalendar r5 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x00ab
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x00ab:
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x032e }
            com.travel.utils.DottedProgressBarCalendar r5 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x00b5
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x00b5:
            r5.a()     // Catch:{ Exception -> 0x032e }
            goto L_0x00c3
        L_0x00b9:
            com.travel.utils.DottedProgressBarCalendar r5 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x00c0
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x00c0:
            r5.setVisibility(r7)     // Catch:{ Exception -> 0x032e }
        L_0x00c3:
            android.widget.TextView r5 = r12.getDayOfMonthTextView()     // Catch:{ Exception -> 0x032e }
            android.content.Context r9 = r11.f23456c     // Catch:{ Exception -> 0x032e }
            if (r9 != 0) goto L_0x00ce
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x00ce:
            int r10 = com.squareup.timessquare.R.color.calendar_text_selector     // Catch:{ Exception -> 0x032e }
            android.content.res.ColorStateList r9 = androidx.core.content.b.b(r9, r10)     // Catch:{ Exception -> 0x032e }
            r5.setTextColor(r9)     // Catch:{ Exception -> 0x032e }
            boolean r5 = r12.isSelected()     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x00f1
            android.view.View r5 = r12.getFlightMarker()     // Catch:{ Exception -> 0x032e }
            android.content.Context r9 = r11.f23456c     // Catch:{ Exception -> 0x032e }
            if (r9 != 0) goto L_0x00e8
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x00e8:
            int r10 = com.travel.R.color.calendar_fareCalender_line1     // Catch:{ Exception -> 0x032e }
            int r9 = androidx.core.content.b.c(r9, r10)     // Catch:{ Exception -> 0x032e }
            r5.setBackgroundColor(r9)     // Catch:{ Exception -> 0x032e }
        L_0x00f1:
            java.util.Date r5 = r11.f23459g     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x0115
            java.util.Date r5 = com.travel.f.d.a.a((java.util.Date) r13)     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x00fe
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x00fe:
            java.util.Date r9 = r11.f23459g     // Catch:{ Exception -> 0x032e }
            java.util.Date r9 = com.travel.f.d.a.a((java.util.Date) r9)     // Catch:{ Exception -> 0x032e }
            boolean r5 = r5.before(r9)     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x0115
            boolean r5 = r12.a()     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x0115
            int r5 = com.travel.R.drawable.pre_rounded_rect_with_9dp_radius     // Catch:{ Exception -> 0x032e }
            r3.setBackgroundResource(r5)     // Catch:{ Exception -> 0x032e }
        L_0x0115:
            boolean r3 = r11.f23461i     // Catch:{ Exception -> 0x032e }
            if (r3 == 0) goto L_0x012d
            com.travel.utils.DottedProgressBarCalendar r3 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r3 != 0) goto L_0x0120
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x0120:
            r3.b()     // Catch:{ Exception -> 0x032e }
            com.travel.utils.DottedProgressBarCalendar r3 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r3 != 0) goto L_0x012a
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x012a:
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x032e }
        L_0x012d:
            com.travel.utils.DottedProgressBarCalendar r3 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r3 == 0) goto L_0x0177
            boolean r3 = r11.f23457e     // Catch:{ Exception -> 0x032e }
            if (r3 == 0) goto L_0x014a
            com.travel.utils.DottedProgressBarCalendar r3 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r3 != 0) goto L_0x013c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x013c:
            r3.b()     // Catch:{ Exception -> 0x032e }
            com.travel.utils.DottedProgressBarCalendar r3 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r3 != 0) goto L_0x0146
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x0146:
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x032e }
            goto L_0x0177
        L_0x014a:
            boolean r3 = r12.a()     // Catch:{ Exception -> 0x032e }
            if (r3 == 0) goto L_0x0164
            android.os.Handler r3 = r11.f23454a     // Catch:{ Exception -> 0x032e }
            com.travel.f.d$b r5 = new com.travel.f.d$b     // Catch:{ Exception -> 0x032e }
            com.travel.utils.DottedProgressBarCalendar r9 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r9 != 0) goto L_0x015b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x015b:
            r5.<init>(r9, r6)     // Catch:{ Exception -> 0x032e }
            java.lang.Runnable r5 = (java.lang.Runnable) r5     // Catch:{ Exception -> 0x032e }
            r3.post(r5)     // Catch:{ Exception -> 0x032e }
            goto L_0x0177
        L_0x0164:
            android.os.Handler r3 = r11.f23454a     // Catch:{ Exception -> 0x032e }
            com.travel.f.d$b r5 = new com.travel.f.d$b     // Catch:{ Exception -> 0x032e }
            com.travel.utils.DottedProgressBarCalendar r9 = r11.f23455b     // Catch:{ Exception -> 0x032e }
            if (r9 != 0) goto L_0x016f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x016f:
            r5.<init>(r9, r7)     // Catch:{ Exception -> 0x032e }
            java.lang.Runnable r5 = (java.lang.Runnable) r5     // Catch:{ Exception -> 0x032e }
            r3.post(r5)     // Catch:{ Exception -> 0x032e }
        L_0x0177:
            java.util.HashMap<java.lang.String, com.travel.model.CalendarDatePriceInfo> r3 = r11.f23460h     // Catch:{ Exception -> 0x032e }
            if (r3 == 0) goto L_0x0182
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x032e }
            com.travel.model.CalendarDatePriceInfo r3 = (com.travel.model.CalendarDatePriceInfo) r3     // Catch:{ Exception -> 0x032e }
            goto L_0x0183
        L_0x0182:
            r3 = r8
        L_0x0183:
            java.util.HashMap<java.lang.String, com.travel.model.CalendarHoliday> r5 = r11.f23458f     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x018e
            java.lang.Object r1 = r5.get(r1)     // Catch:{ Exception -> 0x032e }
            com.travel.model.CalendarHoliday r1 = (com.travel.model.CalendarHoliday) r1     // Catch:{ Exception -> 0x032e }
            goto L_0x018f
        L_0x018e:
            r1 = r8
        L_0x018f:
            if (r4 == 0) goto L_0x0198
            java.lang.String r5 = ""
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x032e }
            r4.setText(r5)     // Catch:{ Exception -> 0x032e }
        L_0x0198:
            boolean r5 = r12.a()     // Catch:{ Exception -> 0x032e }
            if (r5 != 0) goto L_0x01ad
            android.view.View r13 = r12.getFlightMarker()     // Catch:{ Exception -> 0x032e }
            r13.setBackgroundResource(r6)     // Catch:{ Exception -> 0x032e }
            android.view.View r12 = r12.getFlightMarker()     // Catch:{ Exception -> 0x032e }
            r12.setVisibility(r7)     // Catch:{ Exception -> 0x032e }
            return
        L_0x01ad:
            if (r2 == 0) goto L_0x0346
            r2.setText(r8)     // Catch:{ Exception -> 0x032e }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x032e }
            r2.setText(r0)     // Catch:{ Exception -> 0x032e }
            r2.setTag(r13)     // Catch:{ Exception -> 0x032e }
            if (r4 == 0) goto L_0x02ec
            r4.setVisibility(r6)     // Catch:{ Exception -> 0x032e }
            boolean r0 = r12.isSelected()     // Catch:{ Exception -> 0x032e }
            if (r0 != 0) goto L_0x01de
            android.widget.TextView r0 = r12.getPriceTextview()     // Catch:{ Exception -> 0x032e }
            android.content.Context r2 = r11.f23456c     // Catch:{ Exception -> 0x032e }
            if (r2 != 0) goto L_0x01d0
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x01d0:
            int r5 = com.travel.R.color.calendar_grey     // Catch:{ Exception -> 0x032e }
            int r2 = androidx.core.content.b.c(r2, r5)     // Catch:{ Exception -> 0x032e }
            android.content.res.ColorStateList r2 = r11.a(r2)     // Catch:{ Exception -> 0x032e }
            r0.setTextColor(r2)     // Catch:{ Exception -> 0x032e }
            goto L_0x01f2
        L_0x01de:
            android.widget.TextView r0 = r12.getPriceTextview()     // Catch:{ Exception -> 0x032e }
            android.content.Context r2 = r11.f23456c     // Catch:{ Exception -> 0x032e }
            if (r2 != 0) goto L_0x01e9
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x01e9:
            int r5 = com.travel.R.color.white     // Catch:{ Exception -> 0x032e }
            int r2 = androidx.core.content.b.c(r2, r5)     // Catch:{ Exception -> 0x032e }
            r0.setTextColor(r2)     // Catch:{ Exception -> 0x032e }
        L_0x01f2:
            if (r3 == 0) goto L_0x02e0
            int r0 = r3.getFare()     // Catch:{ Exception -> 0x032e }
            r2 = -1
            if (r0 == r2) goto L_0x0204
            int r0 = r3.getFare()     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x032e }
            goto L_0x0205
        L_0x0204:
            r0 = r8
        L_0x0205:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x032e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x032e }
            java.lang.String r5 = ","
            java.lang.String r7 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            if (r2 != 0) goto L_0x024c
            if (r0 != 0) goto L_0x0217
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x0217:
            int r2 = r0.length()     // Catch:{ Exception -> 0x032e }
            r9 = 3
            if (r2 <= r9) goto L_0x024c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032e }
            r2.<init>()     // Catch:{ Exception -> 0x032e }
            int r10 = r0.length()     // Catch:{ Exception -> 0x032e }
            int r10 = r10 - r9
            java.lang.String r10 = r0.substring(r6, r10)     // Catch:{ Exception -> 0x032e }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r7)     // Catch:{ Exception -> 0x032e }
            r2.append(r10)     // Catch:{ Exception -> 0x032e }
            r2.append(r5)     // Catch:{ Exception -> 0x032e }
            int r10 = r0.length()     // Catch:{ Exception -> 0x032e }
            int r10 = r10 - r9
            int r9 = r0.length()     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r0.substring(r10, r9)     // Catch:{ Exception -> 0x032e }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x032e }
            r2.append(r0)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x032e }
        L_0x024c:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x032e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x032e }
            if (r2 != 0) goto L_0x028f
            if (r0 != 0) goto L_0x025a
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x025a:
            int r2 = r0.length()     // Catch:{ Exception -> 0x032e }
            r9 = 6
            if (r2 <= r9) goto L_0x028f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032e }
            r2.<init>()     // Catch:{ Exception -> 0x032e }
            int r10 = r0.length()     // Catch:{ Exception -> 0x032e }
            int r10 = r10 - r9
            java.lang.String r10 = r0.substring(r6, r10)     // Catch:{ Exception -> 0x032e }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r7)     // Catch:{ Exception -> 0x032e }
            r2.append(r10)     // Catch:{ Exception -> 0x032e }
            r2.append(r5)     // Catch:{ Exception -> 0x032e }
            int r5 = r0.length()     // Catch:{ Exception -> 0x032e }
            int r5 = r5 - r9
            int r9 = r0.length()     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r0.substring(r5, r9)     // Catch:{ Exception -> 0x032e }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x032e }
            r2.append(r0)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x032e }
        L_0x028f:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x032e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x032e }
            if (r2 != 0) goto L_0x02e1
            java.lang.String r2 = "₹"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r2.concat(r0)     // Catch:{ Exception -> 0x032e }
            boolean r2 = r12.isSelected()     // Catch:{ Exception -> 0x032e }
            if (r2 != 0) goto L_0x02cb
            android.widget.TextView r2 = r12.getPriceTextview()     // Catch:{ Exception -> 0x032e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032e }
            java.lang.String r7 = "#"
            r5.<init>(r7)     // Catch:{ Exception -> 0x032e }
            java.lang.String r3 = r3.getColorCode()     // Catch:{ Exception -> 0x032e }
            r5.append(r3)     // Catch:{ Exception -> 0x032e }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x032e }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ Exception -> 0x032e }
            android.content.res.ColorStateList r3 = r11.a(r3)     // Catch:{ Exception -> 0x032e }
            r2.setTextColor(r3)     // Catch:{ Exception -> 0x032e }
            goto L_0x02e1
        L_0x02cb:
            android.widget.TextView r2 = r12.getPriceTextview()     // Catch:{ Exception -> 0x032e }
            android.content.Context r3 = r11.f23456c     // Catch:{ Exception -> 0x032e }
            if (r3 != 0) goto L_0x02d6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x032e }
        L_0x02d6:
            int r5 = com.travel.R.color.white     // Catch:{ Exception -> 0x032e }
            int r3 = androidx.core.content.b.c(r3, r5)     // Catch:{ Exception -> 0x032e }
            r2.setTextColor(r3)     // Catch:{ Exception -> 0x032e }
            goto L_0x02e1
        L_0x02e0:
            r0 = r8
        L_0x02e1:
            r4.setText(r8)     // Catch:{ Exception -> 0x032e }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x032e }
            r4.setText(r0)     // Catch:{ Exception -> 0x032e }
            r4.setTag(r13)     // Catch:{ Exception -> 0x032e }
        L_0x02ec:
            android.view.View r13 = r12.getFlightMarker()     // Catch:{ Exception -> 0x032e }
            if (r13 == 0) goto L_0x0311
            if (r1 == 0) goto L_0x02f8
            java.lang.String r8 = r1.getName()     // Catch:{ Exception -> 0x032e }
        L_0x02f8:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x032e }
            boolean r13 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x032e }
            if (r13 == 0) goto L_0x0308
            android.view.View r12 = r12.getFlightMarker()     // Catch:{ Exception -> 0x032e }
            r12.setBackgroundResource(r6)     // Catch:{ Exception -> 0x032e }
            return
        L_0x0308:
            android.view.View r12 = r12.getFlightMarker()     // Catch:{ Exception -> 0x032e }
            int r13 = com.travel.R.drawable.pre_blue_circle     // Catch:{ Exception -> 0x032e }
            r12.setBackgroundResource(r13)     // Catch:{ Exception -> 0x032e }
        L_0x0311:
            return
        L_0x0312:
            kotlin.u r12 = new kotlin.u     // Catch:{ Exception -> 0x032e }
            java.lang.String r13 = "null cannot be cast to non-null type com.travel.utils.DottedProgressBarCalendar"
            r12.<init>(r13)     // Catch:{ Exception -> 0x032e }
            throw r12     // Catch:{ Exception -> 0x032e }
        L_0x031a:
            kotlin.u r12 = new kotlin.u     // Catch:{ Exception -> 0x032e }
            java.lang.String r13 = "null cannot be cast to non-null type android.widget.RelativeLayout"
            r12.<init>(r13)     // Catch:{ Exception -> 0x032e }
            throw r12     // Catch:{ Exception -> 0x032e }
        L_0x0322:
            kotlin.u r12 = new kotlin.u     // Catch:{ Exception -> 0x032e }
            r12.<init>(r3)     // Catch:{ Exception -> 0x032e }
            throw r12     // Catch:{ Exception -> 0x032e }
        L_0x0328:
            kotlin.u r12 = new kotlin.u     // Catch:{ Exception -> 0x032e }
            r12.<init>(r3)     // Catch:{ Exception -> 0x032e }
            throw r12     // Catch:{ Exception -> 0x032e }
        L_0x032e:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "exception FlightCalendarCellDecorator "
            r13.<init>(r0)
            java.lang.String r12 = r12.getMessage()
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            java.io.PrintStream r13 = java.lang.System.out
            r13.println(r12)
        L_0x0346:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.f.d.a(com.squareup.timessquare.v3.CalendarCellView, java.util.Date):void");
    }
}
