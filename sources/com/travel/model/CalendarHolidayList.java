package com.travel.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public final class CalendarHolidayList extends IJRPaytmDataModel {
    @b(a = "body")
    private List<CalendarHoliday> holidayList;

    public final void setHolidayList(List<CalendarHoliday> list) {
        this.holidayList = list;
    }

    public final List<CalendarHoliday> getHolidayList() {
        return (ArrayList) this.holidayList;
    }
}
