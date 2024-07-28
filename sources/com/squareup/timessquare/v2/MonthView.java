package com.squareup.timessquare.v2;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.timessquare.R;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MonthView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f45580a;

    /* renamed from: b  reason: collision with root package name */
    CalendarGridView f45581b;

    /* renamed from: c  reason: collision with root package name */
    private a f45582c;

    /* renamed from: d  reason: collision with root package name */
    private List<Object> f45583d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45584e;

    /* renamed from: f  reason: collision with root package name */
    private Locale f45585f;

    public interface a {
        void a(d dVar);
    }

    public static MonthView a(ViewGroup viewGroup, LayoutInflater layoutInflater, DateFormat dateFormat, a aVar, Calendar calendar, int i2, int i3, int i4, int i5, boolean z, int i6, List<Object> list, Locale locale, a aVar2) {
        MonthView monthView = (MonthView) layoutInflater.inflate(R.layout.month2, viewGroup, false);
        monthView.setDayViewAdapter(aVar2);
        monthView.setDividerColor(i2);
        monthView.setDayTextColor(i4);
        monthView.setTitleTextColor(i5);
        monthView.setDisplayHeader(z);
        monthView.setHeaderTextColor(i6);
        if (i3 != 0) {
            monthView.setDayBackground(i3);
        }
        int i7 = calendar.get(7);
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        boolean z2 = true;
        if (!(directionality == 1 || directionality == 2)) {
            z2 = false;
        }
        monthView.f45584e = z2;
        monthView.f45585f = locale;
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        CalendarRowView calendarRowView = (CalendarRowView) monthView.f45581b.getChildAt(0);
        calendarRowView.setVisibility(8);
        for (int i8 = 0; i8 < 7; i8++) {
            int i9 = firstDayOfWeek + i8;
            if (monthView.f45584e) {
                i9 = 8 - i9;
            }
            calendar.set(7, i9);
            ((TextView) calendarRowView.getChildAt(i8)).setText(dateFormat.format(calendar.getTime()));
        }
        calendar.set(7, i7);
        monthView.f45582c = aVar;
        monthView.f45583d = list;
        return monthView;
    }

    public MonthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setDecorators(List<Object> list) {
        this.f45583d = list;
    }

    public List<Object> getDecorators() {
        return this.f45583d;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f45580a = (TextView) findViewById(R.id.title);
        this.f45581b = (CalendarGridView) findViewById(R.id.calendar_grid);
    }

    public final void a(e eVar, List<List<d>> list, boolean z, Typeface typeface, Typeface typeface2, ArrayList<Integer> arrayList, boolean z2) {
        int i2;
        e eVar2 = eVar;
        Typeface typeface3 = typeface;
        Typeface typeface4 = typeface2;
        ArrayList<Integer> arrayList2 = arrayList;
        int i3 = 0;
        Object[] objArr = {Integer.valueOf(System.identityHashCode(this)), eVar2};
        long currentTimeMillis = System.currentTimeMillis();
        this.f45580a.setAlpha(1.0f);
        int i4 = 8;
        if (z2) {
            this.f45580a.setVisibility(0);
            this.f45580a.setText(eVar2.f45598d);
        } else {
            this.f45580a.setVisibility(8);
        }
        NumberFormat instance = NumberFormat.getInstance(this.f45585f);
        int size = list.size();
        this.f45581b.setNumRows(size);
        int i5 = 0;
        while (i5 < 6) {
            int i6 = i5 + 1;
            CalendarRowView calendarRowView = (CalendarRowView) this.f45581b.getChildAt(i6);
            calendarRowView.setListener(this.f45582c);
            if (i5 < size) {
                calendarRowView.setVisibility(i3);
                List list2 = list.get(i5);
                int i7 = 0;
                while (i7 < list2.size()) {
                    d dVar = (d) list2.get(this.f45584e ? 6 - i7 : i7);
                    CalendarCellView calendarCellView = (CalendarCellView) calendarRowView.getChildAt(i7);
                    int i8 = size;
                    List list3 = list2;
                    String format = instance.format((long) dVar.f45587b);
                    if (!calendarCellView.getDayOfMonthTextView().getText().equals(format)) {
                        calendarCellView.getDayOfMonthTextView().setText(format);
                    }
                    calendarCellView.setEnabled(dVar.f45588c);
                    i7++;
                    calendarCellView.setClickable((arrayList2 == null || !arrayList2.contains(Integer.valueOf(i7))) && !z);
                    if (arrayList2 == null || !arrayList2.contains(Integer.valueOf(i7))) {
                        calendarCellView.setSelectable(dVar.f45591f);
                        calendarCellView.setSelected(dVar.f45589d);
                        calendarCellView.setCurrentMonth(dVar.f45588c);
                        calendarCellView.setToday(dVar.f45590e);
                        calendarCellView.setRangeState(dVar.f45594i);
                        calendarCellView.setHighlighted(dVar.f45592g);
                        calendarCellView.setRangeUnavailable(dVar.f45593h);
                        calendarCellView.setDeactivated(false);
                    } else {
                        calendarCellView.setSelectable(dVar.f45591f);
                        calendarCellView.setSelected(false);
                        calendarCellView.setCurrentMonth(dVar.f45588c);
                        calendarCellView.setToday(dVar.f45590e);
                        calendarCellView.setRangeState(dVar.f45594i);
                        calendarCellView.setHighlighted(dVar.f45592g);
                        calendarCellView.setRangeUnavailable(dVar.f45593h);
                        calendarCellView.setDeactivated(true);
                    }
                    calendarCellView.setTag(dVar);
                    List<Object> list4 = this.f45583d;
                    if (list4 != null) {
                        Iterator<Object> it2 = list4.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                    size = i8;
                    list2 = list3;
                }
                i2 = size;
                i4 = 8;
            } else {
                List<List<d>> list5 = list;
                i2 = size;
                calendarRowView.setVisibility(i4);
            }
            size = i2;
            i5 = i6;
            i3 = 0;
        }
        if (typeface3 != null) {
            this.f45580a.setTypeface(typeface3);
        }
        if (typeface4 != null) {
            this.f45581b.setTypeface(typeface4);
        }
        new Object[1][0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
    }

    public void setDividerColor(int i2) {
        this.f45581b.setDividerColor(i2);
    }

    public void setDayBackground(int i2) {
        this.f45581b.setDayBackground(i2);
    }

    public void setDayTextColor(int i2) {
        this.f45581b.setDayTextColor(i2);
    }

    public void setDayViewAdapter(a aVar) {
        this.f45581b.setDayViewAdapter(aVar);
    }

    public void setTitleTextColor(int i2) {
        this.f45580a.setTextColor(i2);
    }

    public void setDisplayHeader(boolean z) {
        this.f45581b.setDisplayHeader(z);
    }

    public void setHeaderTextColor(int i2) {
        this.f45581b.setHeaderTextColor(i2);
    }
}
