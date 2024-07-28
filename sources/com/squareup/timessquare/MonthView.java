package com.squareup.timessquare;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MonthView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f45525a;

    /* renamed from: b  reason: collision with root package name */
    CalendarGridView f45526b;

    /* renamed from: c  reason: collision with root package name */
    List<String> f45527c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f45528d;

    /* renamed from: e  reason: collision with root package name */
    ListView f45529e;

    /* renamed from: f  reason: collision with root package name */
    private b f45530f;

    /* renamed from: g  reason: collision with root package name */
    private List<a> f45531g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f45532h;

    /* renamed from: i  reason: collision with root package name */
    private Typeface f45533i = Typeface.create("sans-serif", 0);
    private Locale j;
    private boolean k = false;

    public interface b {
        void a(d dVar);
    }

    public void setImmediateDateVisibility(int i2) {
    }

    public static MonthView a(ViewGroup viewGroup, LayoutInflater layoutInflater, DateFormat dateFormat, b bVar, Calendar calendar, int i2, int i3, int i4, int i5, boolean z, int i6, List<a> list, Locale locale, b bVar2) {
        String str;
        MonthView monthView = (MonthView) layoutInflater.inflate(R.layout.month, viewGroup, false);
        monthView.setDayViewAdapter(bVar2);
        monthView.setDividerColor(i2);
        monthView.setDayTextColor(i4);
        monthView.setTitleTextColor(i5);
        monthView.a();
        monthView.b();
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
        monthView.f45532h = z2;
        monthView.j = locale;
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        CalendarRowView calendarRowView = (CalendarRowView) monthView.f45526b.getChildAt(0);
        for (int i8 = 0; i8 < 7; i8++) {
            int i9 = firstDayOfWeek + i8;
            if (monthView.f45532h) {
                i9 = 8 - i9;
            }
            calendar.set(7, i9);
            TextView textView = (TextView) calendarRowView.getChildAt(i8);
            if (dateFormat.format(calendar.getTime()) != null && !TextUtils.isEmpty(dateFormat.format(calendar.getTime()))) {
                if (locale.equals(Locale.ENGLISH)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(dateFormat.format(calendar.getTime()).charAt(0));
                    str = sb.toString();
                } else {
                    str = dateFormat.format(calendar.getTime());
                }
                textView.setText(str);
            }
        }
        calendar.set(7, i7);
        monthView.f45530f = bVar;
        monthView.f45531g = list;
        return monthView;
    }

    public MonthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setDecorators(List<a> list) {
        this.f45531g = list;
    }

    public void setHolidayList(List<String> list) {
        this.f45527c = list;
    }

    public List<a> getDecorators() {
        return this.f45531g;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f45525a = (TextView) findViewById(R.id.title);
        this.f45526b = (CalendarGridView) findViewById(R.id.calendar_grid);
        this.f45528d = (LinearLayout) findViewById(R.id.flight_holiday_list_layout);
        this.f45529e = (ListView) findViewById(R.id.flight_holiday_list);
    }

    public final void a(e eVar, List<List<d>> list, boolean z, Typeface typeface, Typeface typeface2) {
        e eVar2 = eVar;
        int i2 = 0;
        Object[] objArr = {Integer.valueOf(System.identityHashCode(this)), eVar2};
        long currentTimeMillis = System.currentTimeMillis();
        if (this.k) {
            this.f45525a.setGravity(1);
            try {
                this.f45525a.setText(new SimpleDateFormat(getContext().getString(R.string.month_name_format_for_flight), this.j).format(new SimpleDateFormat(getContext().getString(R.string.month_name_format), this.j).parse(eVar2.f45546d)));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        } else {
            this.f45525a.setText(eVar2.f45546d);
        }
        NumberFormat instance = NumberFormat.getInstance(this.j);
        int size = list.size();
        this.f45526b.setNumRows(size);
        int i3 = 0;
        while (i3 < 6) {
            int i4 = i3 + 1;
            CalendarRowView calendarRowView = (CalendarRowView) this.f45526b.getChildAt(i4);
            calendarRowView.setListener(this.f45530f);
            if (i3 < size) {
                calendarRowView.setVisibility(i2);
                List list2 = list.get(i3);
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    d dVar = (d) list2.get(this.f45532h ? 6 - i5 : i5);
                    CalendarCellView calendarCellView = (CalendarCellView) calendarRowView.getChildAt(i5);
                    String format = instance.format((long) dVar.f45536b);
                    if (!calendarCellView.getDayOfMonthTextView().getText().equals(format)) {
                        calendarCellView.getDayOfMonthTextView().setText(format);
                        calendarCellView.getDayOfMonthTextView().setTextSize(2, 14.0f);
                        calendarCellView.getDayOfMonthTextView().setTypeface(this.f45533i, 0);
                    }
                    calendarCellView.setEnabled(dVar.f45537c);
                    calendarCellView.setClickable(!z);
                    calendarCellView.setSelectable(dVar.f45540f);
                    calendarCellView.setSelected(dVar.f45538d);
                    calendarCellView.setCurrentMonth(dVar.f45537c);
                    calendarCellView.setToday(dVar.f45539e);
                    calendarCellView.setRangeState(dVar.f45542h);
                    calendarCellView.setHighlighted(dVar.f45541g);
                    calendarCellView.setTag(dVar);
                    List<a> list3 = this.f45531g;
                    if (list3 != null) {
                        for (a a2 : list3) {
                            a2.a(calendarCellView, dVar.f45535a);
                        }
                    }
                }
            } else {
                List<List<d>> list4 = list;
                calendarRowView.setVisibility(8);
            }
            List<String> list5 = this.f45527c;
            if (list5 == null || list5.isEmpty() || this.f45527c.size() <= 0) {
                this.f45528d.setVisibility(8);
            } else {
                this.f45528d.setVisibility(0);
                this.f45529e.setAdapter(new a(this, (byte) 0));
                setListViewHeightBasedOnChildren(this.f45529e);
            }
            i3 = i4;
            i2 = 0;
        }
        if (typeface != null) {
            b();
        }
        if (typeface2 != null) {
            a();
        }
        new Object[1][0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
    }

    class a extends BaseAdapter {
        public final long getItemId(int i2) {
            return (long) i2;
        }

        private a() {
        }

        /* synthetic */ a(MonthView monthView, byte b2) {
            this();
        }

        public final int getCount() {
            if (MonthView.this.f45527c != null) {
                return MonthView.this.f45527c.size();
            }
            return 0;
        }

        public final Object getItem(int i2) {
            return MonthView.this.f45527c.get(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(MonthView.this.getContext()).inflate(R.layout.lyt_flight_holiday_list_item, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.holiday_date);
            textView.setText("");
            if (MonthView.this.f45527c.get(i2) != null && !TextUtils.isEmpty(MonthView.this.f45527c.get(i2))) {
                textView.setText(MonthView.this.f45527c.get(i2));
            }
            return view;
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        a aVar = (a) listView.getAdapter();
        if (aVar != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < aVar.getCount(); i3++) {
                view = aVar.getView(i3, view, listView);
                if (i3 == 0) {
                    view.setLayoutParams(new ViewGroup.LayoutParams(makeMeasureSpec, -2));
                }
                view.measure(makeMeasureSpec, 0);
                i2 += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i2 + (listView.getDividerHeight() * (aVar.getCount() - 1));
            listView.setLayoutParams(layoutParams);
        }
    }

    public void setFromFlight(boolean z) {
        this.k = z;
    }

    private void a() {
        CalendarGridView calendarGridView = this.f45526b;
        if (calendarGridView != null) {
            calendarGridView.setTypeface(Typeface.create("sans-serif", 0));
        }
    }

    private void b() {
        TextView textView = this.f45525a;
        if (textView != null) {
            textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        }
    }

    public void setDividerColor(int i2) {
        this.f45526b.setDividerColor(i2);
    }

    public void setDayBackground(int i2) {
        this.f45526b.setDayBackground(i2);
    }

    public void setDayTextColor(int i2) {
        this.f45526b.setDayTextColor(i2);
    }

    public void setDayViewAdapter(b bVar) {
        this.f45526b.setDayViewAdapter(bVar);
    }

    public void setTitleTextColor(int i2) {
        this.f45525a.setTextColor(i2);
    }

    public void setDisplayHeader(boolean z) {
        this.f45526b.setDisplayHeader(z);
    }

    public void setHeaderTextColor(int i2) {
        this.f45526b.setHeaderTextColor(i2);
    }
}
