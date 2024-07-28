package com.squareup.timessquare.v2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.squareup.timessquare.R;
import com.squareup.timessquare.v2.MonthView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarPickerView extends ListView {
    /* access modifiers changed from: private */
    public Typeface A;
    /* access modifiers changed from: private */
    public Typeface B;
    /* access modifiers changed from: private */
    public g C;
    private c D;
    /* access modifiers changed from: private */
    public h E = new d(this, (byte) 0);
    /* access modifiers changed from: private */
    public a F;
    /* access modifiers changed from: private */
    public List<Object> G;
    /* access modifiers changed from: private */
    public a H = new b();
    /* access modifiers changed from: private */
    public boolean I;

    /* renamed from: a  reason: collision with root package name */
    final MonthView.a f45560a = new b(this, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    final List<e> f45561b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final List<d> f45562c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    final List<d> f45563d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    final List<Calendar> f45564e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    final List<Calendar> f45565f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<Integer> f45566g;

    /* renamed from: h  reason: collision with root package name */
    i f45567h;

    /* renamed from: i  reason: collision with root package name */
    public Calendar f45568i;
    private final f j;
    /* access modifiers changed from: private */
    public final c<String, List<List<d>>> k = new c<>();
    /* access modifiers changed from: private */
    public Locale l;
    private TimeZone m;
    private DateFormat n;
    /* access modifiers changed from: private */
    public DateFormat o;
    private DateFormat p;
    /* access modifiers changed from: private */
    public Calendar q;
    /* access modifiers changed from: private */
    public Calendar r;
    private Calendar s;
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public int u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public int w;
    /* access modifiers changed from: private */
    public int x;
    /* access modifiers changed from: private */
    public boolean y;
    /* access modifiers changed from: private */
    public int z;

    public interface a {
        boolean a();
    }

    public interface c {
        boolean a();
    }

    public interface g {
    }

    public interface h {
    }

    public enum i {
        SINGLE,
        MULTIPLE,
        RANGE
    }

    public void setDecorators(List<Object> list) {
        this.G = list;
        f fVar = this.j;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public List<Object> getDecorators() {
        return this.G;
    }

    public CalendarPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarPickerView);
        int color = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_android_background, resources.getColor(R.color.calendar_bg));
        this.u = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_tsquare_dividerColor, resources.getColor(R.color.calendar_divider));
        this.v = obtainStyledAttributes.getResourceId(R.styleable.CalendarPickerView_tsquare_dayBackground, R.drawable.calendar_bg_selector2);
        this.w = obtainStyledAttributes.getResourceId(R.styleable.CalendarPickerView_tsquare_dayBackground, R.drawable.day_text_color2);
        this.x = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_tsquare_titleTextColor, resources.getColor(R.color.dateTimeRangePickerTitleTextColor));
        this.y = obtainStyledAttributes.getBoolean(R.styleable.CalendarPickerView_tsquare_displayHeader, true);
        this.z = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_tsquare_headerTextColor, resources.getColor(R.color.dateTimeRangePickerHeaderTextColor));
        obtainStyledAttributes.recycle();
        this.j = new f(this, (byte) 0);
        setDivider((Drawable) null);
        setDividerHeight(0);
        setBackgroundColor(color);
        setCacheColorHint(color);
        this.l = new Locale(getDefaultLanguage());
        this.f45568i = Calendar.getInstance(this.l);
        this.q = Calendar.getInstance(this.l);
        this.r = Calendar.getInstance(this.l);
        this.s = Calendar.getInstance(this.l);
        this.n = new SimpleDateFormat(context.getString(R.string.month_name_format), this.l);
        this.o = new SimpleDateFormat(context.getString(R.string.day_name_format), this.l);
        this.p = DateFormat.getDateInstance(2, this.l);
        this.p.setTimeZone(this.m);
        if (isInEditMode()) {
            Calendar instance = Calendar.getInstance(this.l);
            instance.add(1, 1);
            a(new Date(), instance.getTime(), TimeZone.getDefault(), Locale.getDefault()).a(Collections.singletonList(new Date()));
        }
    }

    public static String getDefaultLanguage() {
        String language = Locale.getDefault().getLanguage();
        if (language.equalsIgnoreCase("en") || language.equalsIgnoreCase("hi") || language.equalsIgnoreCase("ta") || language.equalsIgnoreCase("te") || language.equalsIgnoreCase("kn") || language.equalsIgnoreCase("pa") || language.equalsIgnoreCase("mr") || language.equalsIgnoreCase("gu") || language.equalsIgnoreCase("bn") || language.equalsIgnoreCase("or") || language.equalsIgnoreCase("ml")) {
            return language;
        }
        return "en";
    }

    private e a(Date date, Date date2, TimeZone timeZone, Locale locale) {
        if (date2 == null) {
            throw new IllegalArgumentException("minDate and maxDate must be non-null.  " + a(date, date2));
        } else if (date.after(date2)) {
            throw new IllegalArgumentException("minDate must be before maxDate.  " + a(date, date2));
        } else if (locale == null) {
            throw new IllegalArgumentException("Locale is null.");
        } else if (timeZone != null) {
            this.m = timeZone;
            this.l = locale;
            this.f45568i = Calendar.getInstance(locale);
            this.q = Calendar.getInstance(locale);
            this.r = Calendar.getInstance(locale);
            this.s = Calendar.getInstance(locale);
            this.n = new SimpleDateFormat(getContext().getString(R.string.month_name_format), locale);
            for (e next : this.f45561b) {
                next.f45599e = this.n.format(next.f45597c);
            }
            this.o = new SimpleDateFormat(getContext().getString(R.string.day_name_format), locale);
            this.p = DateFormat.getDateInstance(2, locale);
            this.p.setTimeZone(timeZone);
            this.f45567h = i.SINGLE;
            this.f45564e.clear();
            this.f45562c.clear();
            this.f45565f.clear();
            this.f45563d.clear();
            this.k.clear();
            this.f45561b.clear();
            this.q.setTime(date);
            this.r.setTime(date2);
            setMidnight(this.q);
            setMidnight(this.r);
            this.t = false;
            this.r.add(12, -1);
            this.s.setTime(this.q.getTime());
            int i2 = this.r.get(2);
            int i3 = this.r.get(1);
            while (true) {
                if ((this.s.get(2) <= i2 || this.s.get(1) < i3) && this.s.get(1) < i3 + 1) {
                    Date time = this.s.getTime();
                    e eVar = new e(this.s.get(2), this.s.get(1), time, this.n.format(time));
                    c<String, List<List<d>>> cVar = this.k;
                    cVar.put(eVar.f45596b + "-" + eVar.f45595a, a(eVar, this.s));
                    new Object[1][0] = eVar;
                    this.f45561b.add(eVar);
                    this.s.add(2, 1);
                }
            }
            a();
            return new e();
        } else {
            throw new IllegalArgumentException("Time zone is null.");
        }
    }

    public class e {
        public e() {
        }

        public final e a(Collection<Date> collection) {
            if (CalendarPickerView.this.f45567h == i.SINGLE && collection.size() > 1) {
                throw new IllegalArgumentException("SINGLE mode can't be used with multiple selectedDates");
            } else if (CalendarPickerView.this.f45567h != i.RANGE || collection.size() <= 2) {
                if (collection != null) {
                    Iterator<Date> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
                CalendarPickerView.b(CalendarPickerView.this);
                CalendarPickerView.this.a();
                return this;
            } else {
                throw new IllegalArgumentException("RANGE mode only allows two selectedDates.  You tried to pass " + collection.size());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (getAdapter() == null) {
            setAdapter(this.j);
        }
        this.j.notifyDataSetChanged();
    }

    public void setTitleTypeface(Typeface typeface) {
        this.A = Typeface.create("sans-serif-medium", 0);
        a();
    }

    public void setDateTypeface(Typeface typeface) {
        this.B = Typeface.create("sans-serif", 0);
        a();
    }

    public void setTypeface(Typeface typeface) {
        setTitleTypeface(typeface);
        setDateTypeface(typeface);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!this.f45561b.isEmpty()) {
            super.onMeasure(i2, i3);
            return;
        }
        throw new IllegalStateException("Must have at least one month to display.  Did you forget to call init()?");
    }

    public Date getSelectedDate() {
        if (this.f45564e.size() > 0) {
            return this.f45564e.get(0).getTime();
        }
        return null;
    }

    public List<Date> getSelectedDates() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.f45562c) {
            arrayList.add(dVar.f45586a);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static String a(Date date, Date date2) {
        return "minDate: " + date + "\nmaxDate: " + date2;
    }

    static void setMidnight(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    class b implements MonthView.a {
        private b() {
        }

        /* synthetic */ b(CalendarPickerView calendarPickerView, byte b2) {
            this();
        }

        public final void a(d dVar) {
            Date date = dVar.f45586a;
            if (!CalendarPickerView.this.f45563d.contains(dVar)) {
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                int i2 = instance.get(7);
                if (CalendarPickerView.this.f45566g != null && CalendarPickerView.this.f45566g.contains(Integer.valueOf(i2))) {
                    return;
                }
                if (CalendarPickerView.this.F != null && CalendarPickerView.this.F.a()) {
                    return;
                }
                if (CalendarPickerView.a(date, CalendarPickerView.this.q, CalendarPickerView.this.r) && CalendarPickerView.this.c()) {
                    boolean a2 = CalendarPickerView.a(CalendarPickerView.this, date, dVar);
                    if (CalendarPickerView.this.C == null) {
                        return;
                    }
                    if (a2) {
                        g unused = CalendarPickerView.this.C;
                    } else {
                        g unused2 = CalendarPickerView.this.C;
                    }
                } else if (CalendarPickerView.this.E != null) {
                    h unused3 = CalendarPickerView.this.E;
                }
            }
        }
    }

    /* renamed from: com.squareup.timessquare.v2.CalendarPickerView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45572a = new int[i.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.squareup.timessquare.v2.CalendarPickerView$i[] r0 = com.squareup.timessquare.v2.CalendarPickerView.i.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45572a = r0
                int[] r0 = f45572a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.squareup.timessquare.v2.CalendarPickerView$i r1 = com.squareup.timessquare.v2.CalendarPickerView.i.RANGE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f45572a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.squareup.timessquare.v2.CalendarPickerView$i r1 = com.squareup.timessquare.v2.CalendarPickerView.i.MULTIPLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f45572a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.squareup.timessquare.v2.CalendarPickerView$i r1 = com.squareup.timessquare.v2.CalendarPickerView.i.SINGLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.timessquare.v2.CalendarPickerView.AnonymousClass2.<clinit>():void");
        }
    }

    private static String a(Calendar calendar) {
        return calendar.get(1) + "-" + calendar.get(2);
    }

    private void b() {
        for (d next : this.f45562c) {
            next.f45589d = false;
            if (this.f45563d.contains(next)) {
                next.f45593h = false;
                next.f45592g = true;
            }
            if (!(this.C == null || this.f45567h != i.RANGE || this.f45562c.indexOf(next) == 0)) {
                this.f45562c.size();
            }
        }
        this.f45562c.clear();
        this.f45564e.clear();
    }

    class f extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private final LayoutInflater f45577b;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final boolean isEnabled(int i2) {
            return false;
        }

        /* synthetic */ f(CalendarPickerView calendarPickerView, byte b2) {
            this();
        }

        private f() {
            this.f45577b = LayoutInflater.from(CalendarPickerView.this.getContext());
        }

        public final int getCount() {
            return CalendarPickerView.this.f45561b.size();
        }

        public final Object getItem(int i2) {
            return CalendarPickerView.this.f45561b.get(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            MonthView monthView = (MonthView) view;
            if (monthView == null || !monthView.getTag(R.id.day_view_adapter_class).equals(CalendarPickerView.this.H.getClass())) {
                monthView = MonthView.a(viewGroup, this.f45577b, CalendarPickerView.this.o, CalendarPickerView.this.f45560a, CalendarPickerView.this.f45568i, CalendarPickerView.this.u, CalendarPickerView.this.v, CalendarPickerView.this.w, CalendarPickerView.this.x, CalendarPickerView.this.y, CalendarPickerView.this.z, CalendarPickerView.this.G, CalendarPickerView.this.l, CalendarPickerView.this.H);
                monthView.setTag(R.id.day_view_adapter_class, CalendarPickerView.this.H.getClass());
            } else {
                monthView.setDecorators(CalendarPickerView.this.G);
            }
            int size = CalendarPickerView.this.I ? (CalendarPickerView.this.f45561b.size() - i2) - 1 : i2;
            if (size == 0) {
                monthView.a(CalendarPickerView.this.f45561b.get(size), (List) CalendarPickerView.this.k.getValueAtIndex(size), CalendarPickerView.this.t, CalendarPickerView.this.A, CalendarPickerView.this.B, CalendarPickerView.this.f45566g, false);
            } else {
                monthView.a(CalendarPickerView.this.f45561b.get(size), (List) CalendarPickerView.this.k.getValueAtIndex(size), CalendarPickerView.this.t, CalendarPickerView.this.A, CalendarPickerView.this.B, CalendarPickerView.this.f45566g, true);
            }
            return monthView;
        }
    }

    private List<List<d>> a(e eVar, Calendar calendar) {
        Calendar calendar2;
        e eVar2 = eVar;
        Calendar instance = Calendar.getInstance(this.l);
        int i2 = 2;
        instance.setFirstDayOfWeek(2);
        instance.setTime(calendar.getTime());
        ArrayList arrayList = new ArrayList();
        if (calendar.get(2) == this.q.get(2)) {
            instance.set(5, instance.get(5));
        } else {
            instance.set(5, 1);
        }
        int firstDayOfWeek = instance.getFirstDayOfWeek() - instance.get(7);
        if (firstDayOfWeek > 0) {
            firstDayOfWeek -= 7;
        }
        instance.add(5, firstDayOfWeek);
        List<Calendar> list = this.f45564e;
        if (list == null || list.size() == 0) {
            calendar2 = null;
        } else {
            Collections.sort(list);
            calendar2 = list.get(0);
        }
        Calendar a2 = a(this.f45564e);
        while (true) {
            if ((instance.get(i2) >= eVar2.f45595a + 1 && instance.get(1) >= eVar2.f45596b) || instance.get(1) > eVar2.f45596b) {
                break;
            }
            new Object[1][0] = instance.getTime();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(arrayList2);
            int i3 = 0;
            while (i3 < 7) {
                Date time = instance.getTime();
                boolean z2 = instance.get(i2) == eVar2.f45595a;
                boolean z3 = z2 && a(this.f45564e, instance);
                boolean z4 = z2 && a(instance, this.q, this.r) && c();
                boolean a3 = a(instance, this.f45568i);
                boolean a4 = a(this.f45565f, instance);
                int i4 = instance.get(5);
                f fVar = f.NONE;
                if (this.f45564e.size() > 1) {
                    if (a(calendar2, instance)) {
                        fVar = f.FIRST;
                    } else if (a(a(this.f45564e), instance)) {
                        fVar = f.LAST;
                    } else if (a(instance, calendar2, a2)) {
                        fVar = f.MIDDLE;
                    }
                }
                arrayList2.add(new d(time, z2, z4, z3, a3, a4, i4, fVar));
                instance.add(5, 1);
                i3++;
                i2 = 2;
            }
            if (instance.after(this.r)) {
                break;
            }
            i2 = 2;
        }
        return arrayList;
    }

    private static boolean a(List<Calendar> list, Calendar calendar) {
        for (Calendar a2 : list) {
            if (a(calendar, a2)) {
                return true;
            }
        }
        return false;
    }

    private static Calendar a(List<Calendar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    private static boolean a(Calendar calendar, Calendar calendar2) {
        if (calendar.get(2) == calendar2.get(2) && calendar.get(1) == calendar2.get(1) && calendar.get(5) == calendar2.get(5)) {
            return true;
        }
        return false;
    }

    private static boolean a(Calendar calendar, Calendar calendar2, Calendar calendar3) {
        return a(calendar.getTime(), calendar2, calendar3);
    }

    static boolean a(Date date, Calendar calendar, Calendar calendar2) {
        Date time = calendar.getTime();
        return (date.equals(time) || date.after(time)) && date.before(calendar2.getTime());
    }

    private static boolean a(Calendar calendar, e eVar) {
        if (calendar.get(2) == eVar.f45595a && calendar.get(1) == eVar.f45596b) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean c() {
        c cVar = this.D;
        return cVar == null || cVar.a();
    }

    public void setOnDateSelectedListener(g gVar) {
        this.C = gVar;
    }

    public void setOnInvalidDateSelectedListener(h hVar) {
        this.E = hVar;
    }

    public void setDateSelectableFilter(c cVar) {
        this.D = cVar;
    }

    public void setCustomDayView(a aVar) {
        this.H = aVar;
        f fVar = this.j;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void setCellClickInterceptor(a aVar) {
        this.F = aVar;
    }

    class d implements h {
        private d() {
        }

        /* synthetic */ d(CalendarPickerView calendarPickerView, byte b2) {
            this();
        }
    }

    private void a(final int i2) {
        post(new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f45570b = false;

            public final void run() {
                new Object[1][0] = Integer.valueOf(i2);
                if (this.f45570b) {
                    CalendarPickerView.this.smoothScrollToPosition(i2);
                } else {
                    CalendarPickerView.this.setSelection(i2);
                }
            }
        });
    }

    static /* synthetic */ void b(CalendarPickerView calendarPickerView) {
        Calendar instance = Calendar.getInstance(calendarPickerView.m, calendarPickerView.l);
        Integer num = null;
        Integer num2 = null;
        for (int i2 = 0; i2 < calendarPickerView.f45561b.size(); i2++) {
            e eVar = calendarPickerView.f45561b.get(i2);
            if (num == null) {
                Iterator<Calendar> it2 = calendarPickerView.f45564e.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (a(it2.next(), eVar)) {
                            num = Integer.valueOf(i2);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (num == null && num2 == null && a(instance, eVar)) {
                    num2 = Integer.valueOf(i2);
                }
            }
        }
        if (num != null) {
            calendarPickerView.a(num.intValue());
        } else if (num2 != null) {
            calendarPickerView.a(num2.intValue());
        }
    }

    static /* synthetic */ boolean a(CalendarPickerView calendarPickerView, Date date, d dVar) {
        Calendar instance = Calendar.getInstance(calendarPickerView.l);
        instance.setTime(date);
        setMidnight(instance);
        for (d dVar2 : calendarPickerView.f45562c) {
            dVar2.f45594i = f.NONE;
        }
        int i2 = AnonymousClass2.f45572a[calendarPickerView.f45567h.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                Iterator<d> it2 = calendarPickerView.f45562c.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    d next = it2.next();
                    if (next.f45586a.equals(date)) {
                        next.f45589d = false;
                        calendarPickerView.f45562c.remove(next);
                        date = null;
                        break;
                    }
                }
                Iterator<Calendar> it3 = calendarPickerView.f45564e.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Calendar next2 = it3.next();
                    if (a(next2, instance)) {
                        calendarPickerView.f45564e.remove(next2);
                        break;
                    }
                }
            } else if (i2 == 3) {
                calendarPickerView.b();
            } else {
                throw new IllegalStateException("Unknown selectionMode " + calendarPickerView.f45567h);
            }
        } else if (calendarPickerView.f45564e.size() > 1) {
            calendarPickerView.b();
        } else if (calendarPickerView.f45564e.size() == 1 && instance.before(calendarPickerView.f45564e.get(0))) {
            calendarPickerView.b();
        }
        if (date != null) {
            if (calendarPickerView.f45562c.size() == 0 || !calendarPickerView.f45562c.get(0).equals(dVar)) {
                calendarPickerView.f45562c.add(dVar);
                dVar.f45589d = true;
            }
            calendarPickerView.f45564e.add(instance);
            if (calendarPickerView.f45567h == i.RANGE && calendarPickerView.f45562c.size() > 1) {
                Date date2 = calendarPickerView.f45562c.get(0).f45586a;
                Date date3 = calendarPickerView.f45562c.get(1).f45586a;
                calendarPickerView.f45562c.get(0).f45594i = f.FIRST;
                calendarPickerView.f45562c.get(1).f45594i = f.LAST;
                int indexOfKey = calendarPickerView.k.getIndexOfKey(a(calendarPickerView.f45564e.get(1)));
                boolean z2 = false;
                for (int indexOfKey2 = calendarPickerView.k.getIndexOfKey(a(calendarPickerView.f45564e.get(0))); indexOfKey2 <= indexOfKey; indexOfKey2++) {
                    for (List<d> it4 : calendarPickerView.k.getValueAtIndex(indexOfKey2)) {
                        boolean z3 = z2;
                        d dVar3 = null;
                        for (d dVar4 : it4) {
                            if (dVar4.f45586a.after(date2) && dVar4.f45586a.before(date3) && dVar4.f45591f) {
                                if (calendarPickerView.f45563d.contains(dVar4)) {
                                    dVar4.f45589d = false;
                                    dVar4.f45593h = true;
                                    dVar4.f45592g = false;
                                    calendarPickerView.f45562c.add(dVar4);
                                } else {
                                    dVar4.f45589d = true;
                                    dVar4.f45594i = f.MIDDLE;
                                    calendarPickerView.f45562c.add(dVar4);
                                }
                            }
                            if (dVar4.f45588c) {
                                dVar3 = dVar4;
                            }
                            if ((!dVar4.f45588c && dVar3 != null && (dVar3.f45594i == f.FIRST || dVar3.f45594i == f.MIDDLE)) || (z3 && dVar4.f45586a.before(date3))) {
                                dVar4.f45594i = f.EXTEND;
                                calendarPickerView.f45562c.add(dVar4);
                                z3 = true;
                            }
                        }
                        z2 = z3;
                    }
                }
            }
        }
        calendarPickerView.a();
        return date != null;
    }
}
