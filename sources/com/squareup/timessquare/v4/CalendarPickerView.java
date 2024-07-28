package com.squareup.timessquare.v4;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.squareup.timessquare.R;
import com.squareup.timessquare.v4.MonthView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalendarPickerView extends ListView {
    /* access modifiers changed from: private */
    public Typeface A;
    /* access modifiers changed from: private */
    public h B;
    private c C;
    /* access modifiers changed from: private */
    public i D = new d(this, (byte) 0);
    /* access modifiers changed from: private */
    public a E;
    /* access modifiers changed from: private */
    public List<a> F;
    /* access modifiers changed from: private */
    public b G = new c();
    /* access modifiers changed from: private */
    public boolean H = false;

    /* renamed from: a  reason: collision with root package name */
    final MonthView.b f45666a = new b(this, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    final List<e> f45667b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final List<d> f45668c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    final List<d> f45669d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    final List<Calendar> f45670e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    final List<Calendar> f45671f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    j f45672g;

    /* renamed from: h  reason: collision with root package name */
    public Calendar f45673h;

    /* renamed from: i  reason: collision with root package name */
    Map<Date, String> f45674i = new HashMap();
    private final f j;
    /* access modifiers changed from: private */
    public final List<List<List<d>>> k = new ArrayList();
    /* access modifiers changed from: private */
    public Locale l;
    private DateFormat m;
    /* access modifiers changed from: private */
    public DateFormat n;
    /* access modifiers changed from: private */
    public DateFormat o;
    /* access modifiers changed from: private */
    public Calendar p;
    /* access modifiers changed from: private */
    public Calendar q;
    private Calendar r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */
    public int u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public int w;
    /* access modifiers changed from: private */
    public boolean x;
    /* access modifiers changed from: private */
    public int y;
    private Typeface z;

    public interface a {
        boolean a();
    }

    public interface c {
        boolean a();
    }

    public interface h {
        void a(Date date);
    }

    public interface i {
        void a();
    }

    public enum j {
        SINGLE,
        MULTIPLE,
        RANGE
    }

    public void setDecorators(List<a> list) {
        this.F = list;
        f fVar = this.j;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void setHolidayList(Map<Date, String> map) {
        this.f45674i = map;
        f fVar = this.j;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void setFromFlight(boolean z2) {
        this.H = z2;
    }

    public List<a> getDecorators() {
        return this.F;
    }

    public CalendarPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarPickerView);
        int color = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_android_background, resources.getColor(R.color.creamy_white));
        this.t = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_tsquare_dividerColor, resources.getColor(R.color.white));
        this.u = obtainStyledAttributes.getResourceId(R.styleable.CalendarPickerView_tsquare_dayBackground, R.drawable.calender_cell_background_v3);
        this.v = obtainStyledAttributes.getResourceId(R.styleable.CalendarPickerView_tsquare_dayTextColor, R.color.calender_text_selector_v3);
        this.w = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_tsquare_titleTextColor, resources.getColor(R.color.flight_month_text_color));
        this.x = obtainStyledAttributes.getBoolean(R.styleable.CalendarPickerView_tsquare_displayHeader, true);
        this.y = obtainStyledAttributes.getColor(R.styleable.CalendarPickerView_tsquare_headerTextColor, resources.getColor(R.color.flight_month_text_color));
        obtainStyledAttributes.recycle();
        this.j = new f(this, (byte) 0);
        setDivider((Drawable) null);
        setDividerHeight(0);
        setBackgroundColor(color);
        setCacheColorHint(color);
        this.l = new Locale(getDefaultLanguage());
        this.f45673h = Calendar.getInstance(this.l);
        this.p = Calendar.getInstance(this.l);
        this.q = Calendar.getInstance(this.l);
        this.r = Calendar.getInstance(this.l);
        this.m = new SimpleDateFormat(context.getString(R.string.month_name_format), this.l);
        this.n = new SimpleDateFormat(context.getString(R.string.day_name_format), this.l);
        this.o = DateFormat.getDateInstance(2, this.l);
        if (isInEditMode()) {
            Calendar instance = Calendar.getInstance(this.l);
            instance.add(1, 1);
            a(new Date(), instance.getTime(), new Locale(getDefaultLanguage())).a((Collection<Date>) Collections.singletonList(new Date()));
        }
    }

    private static String getDefaultLanguage() {
        String language = Locale.getDefault().getLanguage();
        if (language.equalsIgnoreCase("en") || language.equalsIgnoreCase("hi") || language.equalsIgnoreCase("ta") || language.equalsIgnoreCase("te") || language.equalsIgnoreCase("kn") || language.equalsIgnoreCase("pa") || language.equalsIgnoreCase("mr") || language.equalsIgnoreCase("gu") || language.equalsIgnoreCase("bn") || language.equalsIgnoreCase("or") || language.equalsIgnoreCase("ml")) {
            return language;
        }
        return "en";
    }

    public final e a(Date date, Date date2, Locale locale) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("minDate and maxDate must be non-null.  " + a(date, date2));
        } else if (date.after(date2)) {
            throw new IllegalArgumentException("minDate must be before maxDate.  " + a(date, date2));
        } else if (locale != null) {
            this.l = locale;
            this.f45673h = Calendar.getInstance(locale);
            this.p = Calendar.getInstance(locale);
            this.q = Calendar.getInstance(locale);
            this.r = Calendar.getInstance(locale);
            this.m = new SimpleDateFormat(getContext().getString(R.string.month_name_format), locale);
            for (e next : this.f45667b) {
                String format = this.m.format(next.f45705c);
                next.f45706d = format;
                String substring = format.substring(0, format.indexOf(" "));
                String substring2 = format.substring(format.indexOf(" "), format.length());
                next.f45707e = new SpannableStringBuilder(substring + substring2);
                next.f45707e.setSpan(new StyleSpan(1), 0, substring.length(), 33);
            }
            this.n = new SimpleDateFormat(getContext().getString(R.string.day_name_format), locale);
            this.o = DateFormat.getDateInstance(2, locale);
            this.f45672g = j.SINGLE;
            this.f45670e.clear();
            this.f45668c.clear();
            this.f45671f.clear();
            this.f45669d.clear();
            this.k.clear();
            this.f45667b.clear();
            this.p.setTime(date);
            this.q.setTime(date2);
            setMidnight(this.p);
            setMidnight(this.q);
            this.s = false;
            this.q.add(12, -1);
            this.r.setTime(this.p.getTime());
            int i2 = this.q.get(2);
            int i3 = this.q.get(1);
            while (true) {
                if ((this.r.get(2) <= i2 || this.r.get(1) < i3) && this.r.get(1) < i3 + 1) {
                    Date time = this.r.getTime();
                    e eVar = new e(this.r.get(2), this.r.get(1), time, this.m.format(time));
                    this.k.add(a(eVar, this.r));
                    new Object[1][0] = eVar;
                    this.f45667b.add(eVar);
                    this.r.add(2, 1);
                }
            }
            a();
            return new e();
        } else {
            throw new IllegalArgumentException("Locale is null.");
        }
    }

    public class e {
        public e() {
        }

        public final e a(j jVar) {
            CalendarPickerView calendarPickerView = CalendarPickerView.this;
            calendarPickerView.f45672g = jVar;
            calendarPickerView.a();
            return this;
        }

        public final e a(Collection<Date> collection) {
            if (CalendarPickerView.this.f45672g == j.SINGLE && collection.size() > 1) {
                throw new IllegalArgumentException("SINGLE mode can't be used with multiple selectedDates");
            } else if (CalendarPickerView.this.f45672g != j.RANGE || collection.size() <= 2) {
                if (collection != null) {
                    for (Date a2 : collection) {
                        CalendarPickerView.this.a(a2);
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

    private void a(int i2) {
        new Object[1][0] = Integer.valueOf(i2);
        setSelection(i2);
    }

    public void setTitleTypeface(Typeface typeface) {
        this.z = Typeface.create("sans-serif-medium", 0);
        a();
    }

    public void setDateTypeface(Typeface typeface) {
        this.A = Typeface.create("sans-serif", 0);
        a();
    }

    public void setTypeface(Typeface typeface) {
        setTitleTypeface(typeface);
        setDateTypeface(typeface);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!this.f45667b.isEmpty()) {
            super.onMeasure(i2, i3);
            return;
        }
        throw new IllegalStateException("Must have at least one month to display.  Did you forget to call init()?");
    }

    public Date getSelectedDate() {
        if (this.f45670e.size() > 0) {
            return this.f45670e.get(0).getTime();
        }
        return null;
    }

    public List<Date> getSelectedDates() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.f45668c) {
            arrayList.add(dVar.f45695a);
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

    class b implements MonthView.b {
        private b() {
        }

        /* synthetic */ b(CalendarPickerView calendarPickerView, byte b2) {
            this();
        }

        public final void a(d dVar) {
            Date date = dVar.f45695a;
            if (CalendarPickerView.this.E != null && CalendarPickerView.this.E.a()) {
                return;
            }
            if (CalendarPickerView.a(date, CalendarPickerView.this.p, CalendarPickerView.this.q) && CalendarPickerView.this.c()) {
                boolean a2 = CalendarPickerView.this.a(date, dVar);
                if (CalendarPickerView.this.B == null) {
                    return;
                }
                if (a2) {
                    CalendarPickerView.this.B.a(date);
                } else {
                    h unused = CalendarPickerView.this.B;
                }
            } else if (CalendarPickerView.this.D != null) {
                CalendarPickerView.this.D.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(Date date, d dVar) {
        Calendar instance = Calendar.getInstance(this.l);
        instance.setTime(date);
        setMidnight(instance);
        for (d dVar2 : this.f45668c) {
            dVar2.f45702h = f.NONE;
        }
        int i2 = AnonymousClass1.f45675a[this.f45672g.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                date = a(date, instance);
            } else if (i2 == 3) {
                b();
            } else {
                throw new IllegalStateException("Unknown selectionMode " + this.f45672g);
            }
        } else if (this.f45670e.size() > 1) {
            b();
        } else if (this.f45670e.size() == 1 && instance.before(this.f45670e.get(0))) {
            b();
        }
        if (date != null) {
            if (this.f45668c.size() == 0 || !this.f45668c.get(0).equals(dVar)) {
                this.f45668c.add(dVar);
                dVar.f45698d = true;
            }
            this.f45670e.add(instance);
            if (this.f45672g == j.RANGE && this.f45668c.size() > 1) {
                Date date2 = this.f45668c.get(0).f45695a;
                Date date3 = this.f45668c.get(1).f45695a;
                this.f45668c.get(0).f45702h = f.FIRST;
                this.f45668c.get(1).f45702h = f.LAST;
                for (List<List<d>> it2 : this.k) {
                    for (List<d> it3 : it2) {
                        for (d dVar3 : it3) {
                            if (dVar3.f45695a.after(date2) && dVar3.f45695a.before(date3) && dVar3.f45700f) {
                                dVar3.f45698d = true;
                                dVar3.f45702h = f.MIDDLE;
                                this.f45668c.add(dVar3);
                            }
                        }
                    }
                }
            }
        }
        a();
        return date != null;
    }

    /* renamed from: com.squareup.timessquare.v4.CalendarPickerView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45675a = new int[j.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.squareup.timessquare.v4.CalendarPickerView$j[] r0 = com.squareup.timessquare.v4.CalendarPickerView.j.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45675a = r0
                int[] r0 = f45675a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.squareup.timessquare.v4.CalendarPickerView$j r1 = com.squareup.timessquare.v4.CalendarPickerView.j.RANGE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f45675a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.squareup.timessquare.v4.CalendarPickerView$j r1 = com.squareup.timessquare.v4.CalendarPickerView.j.MULTIPLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f45675a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.squareup.timessquare.v4.CalendarPickerView$j r1 = com.squareup.timessquare.v4.CalendarPickerView.j.SINGLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.timessquare.v4.CalendarPickerView.AnonymousClass1.<clinit>():void");
        }
    }

    private void b() {
        for (d next : this.f45668c) {
            next.f45698d = false;
            if (!(this.B == null || this.f45672g != j.RANGE || this.f45668c.indexOf(next) == 0)) {
                this.f45668c.size();
            }
        }
        this.f45668c.clear();
        this.f45670e.clear();
    }

    private Date a(Date date, Calendar calendar) {
        Iterator<d> it2 = this.f45668c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            d next = it2.next();
            if (next.f45695a.equals(date)) {
                next.f45698d = false;
                this.f45668c.remove(next);
                date = null;
                break;
            }
        }
        Iterator<Calendar> it3 = this.f45670e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Calendar next2 = it3.next();
            if (a(next2, calendar)) {
                this.f45670e.remove(next2);
                break;
            }
        }
        return date;
    }

    static class g {

        /* renamed from: a  reason: collision with root package name */
        public d f45681a;

        /* renamed from: b  reason: collision with root package name */
        public int f45682b;

        public g(d dVar, int i2) {
            this.f45681a = dVar;
            this.f45682b = i2;
        }
    }

    class f extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private final LayoutInflater f45680b;

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
            this.f45680b = LayoutInflater.from(CalendarPickerView.this.getContext());
        }

        public final int getCount() {
            return CalendarPickerView.this.f45667b.size();
        }

        public final Object getItem(int i2) {
            return CalendarPickerView.this.f45667b.get(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            int i3 = i2;
            MonthView monthView = (MonthView) view;
            if (monthView == null || !monthView.getTag(R.id.day_view_adapter_class).equals(CalendarPickerView.this.G.getClass())) {
                monthView = MonthView.a(viewGroup, this.f45680b, CalendarPickerView.this.n, CalendarPickerView.this.f45666a, CalendarPickerView.this.f45673h, CalendarPickerView.this.t, CalendarPickerView.this.u, CalendarPickerView.this.v, CalendarPickerView.this.w, CalendarPickerView.this.x, CalendarPickerView.this.y, CalendarPickerView.this.F, CalendarPickerView.this.l, CalendarPickerView.this.G);
                monthView.setTag(R.id.day_view_adapter_class, CalendarPickerView.this.G.getClass());
            } else {
                monthView.setDecorators(CalendarPickerView.this.F);
            }
            monthView.setFromFlight(CalendarPickerView.this.H);
            if (!CalendarPickerView.this.f45674i.isEmpty()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd");
                Calendar instance = Calendar.getInstance(CalendarPickerView.this.l);
                ArrayList arrayList = new ArrayList();
                for (Map.Entry next : CalendarPickerView.this.f45674i.entrySet()) {
                    instance.setTime((Date) next.getKey());
                    if (instance.get(2) == CalendarPickerView.this.f45667b.get(i3).f45703a && instance.get(1) == CalendarPickerView.this.f45667b.get(i3).f45704b) {
                        arrayList.add(simpleDateFormat.format((Date) next.getKey()) + " - " + ((String) next.getValue()));
                    }
                }
                if (arrayList.isEmpty() || arrayList.size() <= 0) {
                    monthView.setHolidayList((List<String>) null);
                } else {
                    monthView.setHolidayList(arrayList);
                }
            }
            monthView.a(CalendarPickerView.this.f45667b.get(i3), (List) CalendarPickerView.this.k.get(i3), CalendarPickerView.this.s, Typeface.create("sans-serif-medium", 0), CalendarPickerView.this.A);
            return monthView;
        }
    }

    private List<List<d>> a(e eVar, Calendar calendar) {
        Calendar calendar2;
        e eVar2 = eVar;
        Calendar instance = Calendar.getInstance(this.l);
        instance.setTime(calendar.getTime());
        ArrayList arrayList = new ArrayList();
        int i2 = 2;
        if (calendar.get(2) == this.p.get(2)) {
            instance.set(5, instance.get(5));
        } else {
            instance.set(5, 1);
        }
        int firstDayOfWeek = instance.getFirstDayOfWeek() - instance.get(7);
        if (firstDayOfWeek > 0) {
            firstDayOfWeek -= 7;
        }
        instance.add(5, firstDayOfWeek);
        List<Calendar> list = this.f45670e;
        if (list == null || list.size() == 0) {
            calendar2 = null;
        } else {
            Collections.sort(list);
            calendar2 = list.get(0);
        }
        Calendar a2 = a(this.f45670e);
        while (true) {
            if ((instance.get(i2) < eVar2.f45703a + 1 || instance.get(1) < eVar2.f45704b) && instance.get(1) <= eVar2.f45704b) {
                new Object[1][0] = instance.getTime();
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
                int i3 = 0;
                while (i3 < 7) {
                    Date time = instance.getTime();
                    boolean z2 = instance.get(i2) == eVar2.f45703a;
                    boolean z3 = z2 && a(this.f45670e, instance);
                    boolean z4 = z2 && a(instance, this.p, this.q) && c();
                    boolean a3 = a(instance, this.f45673h);
                    boolean a4 = a(this.f45671f, instance);
                    int i4 = instance.get(5);
                    f fVar = f.NONE;
                    if (this.f45670e.size() > 1) {
                        if (a(calendar2, instance)) {
                            fVar = f.FIRST;
                        } else if (a(a(this.f45670e), instance)) {
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
            }
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
        if (calendar.get(2) == eVar.f45703a && calendar.get(1) == eVar.f45704b) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean c() {
        c cVar = this.C;
        return cVar == null || cVar.a();
    }

    public void setOnDateSelectedListener(h hVar) {
        this.B = hVar;
    }

    public void setOnInvalidDateSelectedListener(i iVar) {
        this.D = iVar;
    }

    public void setDateSelectableFilter(c cVar) {
        this.C = cVar;
    }

    public void setCustomDayView(b bVar) {
        this.G = bVar;
        f fVar = this.j;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void setCellClickInterceptor(a aVar) {
        this.E = aVar;
    }

    class d implements i {
        private d() {
        }

        /* synthetic */ d(CalendarPickerView calendarPickerView, byte b2) {
            this();
        }

        public final void a() {
            CalendarPickerView.this.getResources().getString(R.string.invalid_date, new Object[]{CalendarPickerView.this.o.format(CalendarPickerView.this.p.getTime()), CalendarPickerView.this.o.format(CalendarPickerView.this.q.getTime())});
        }
    }

    public final boolean a(Date date) {
        g gVar;
        if (date != null) {
            Calendar instance = Calendar.getInstance(this.l);
            instance.setTime(date);
            Calendar instance2 = Calendar.getInstance(this.l);
            Iterator<List<List<d>>> it2 = this.k.iterator();
            int i2 = 0;
            loop0:
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                for (List it3 : it2.next()) {
                    Iterator it4 = it3.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            d dVar = (d) it4.next();
                            instance2.setTime(dVar.f45695a);
                            if (a(instance2, instance) && dVar.f45700f) {
                                gVar = new g(dVar, i2);
                                break loop0;
                            }
                        }
                    }
                }
                i2++;
            }
        }
        gVar = null;
        if (gVar == null || !c()) {
            return false;
        }
        boolean a2 = a(date, gVar.f45681a);
        if (a2) {
            a(gVar.f45682b);
        }
        return a2;
    }

    static /* synthetic */ void b(CalendarPickerView calendarPickerView) {
        Calendar instance = Calendar.getInstance(calendarPickerView.l);
        Integer num = null;
        Integer num2 = null;
        for (int i2 = 0; i2 < calendarPickerView.f45667b.size(); i2++) {
            e eVar = calendarPickerView.f45667b.get(i2);
            if (num == null) {
                Iterator<Calendar> it2 = calendarPickerView.f45670e.iterator();
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
}
