package net.one97.paytm.o2o.amusementpark.utils;

import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public final class h implements a {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Date> f73667a;

    public h(ArrayList<Date> arrayList) {
        this.f73667a = arrayList;
    }

    public final void a(CalendarCellView calendarCellView, Date date) {
        boolean z;
        ArrayList<Date> arrayList = this.f73667a;
        if (arrayList != null && arrayList.size() != 0 && date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Date time = instance.getTime();
            if (time != null) {
                Iterator<Date> it2 = this.f73667a.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().compareTo(time) == 0) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        z = false;
        if (!z) {
            calendarCellView.setEnabled(false);
            calendarCellView.setActivated(false);
            calendarCellView.setClickable(false);
            calendarCellView.setSelectable(false);
            calendarCellView.setClickable(false);
            calendarCellView.setFocusable(false);
            return;
        }
        calendarCellView.setEnabled(true);
        calendarCellView.setActivated(true);
        calendarCellView.setClickable(true);
        calendarCellView.setSelectable(true);
        calendarCellView.setFocusable(true);
        calendarCellView.setClickable(true);
    }
}
