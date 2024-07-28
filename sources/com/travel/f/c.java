package com.travel.f;

import com.travel.model.CalendarPriceModel;
import java.util.Observable;

public final class c extends Observable {

    /* renamed from: a  reason: collision with root package name */
    public CalendarPriceModel f23452a;

    public final void a(CalendarPriceModel calendarPriceModel) {
        this.f23452a = calendarPriceModel;
        setChanged();
        notifyObservers();
    }
}
