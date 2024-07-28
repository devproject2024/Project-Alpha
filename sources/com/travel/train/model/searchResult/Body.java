package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Body extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "calendar")
    private List<CalendarData> calendar;
    @a
    @b(a = "searched_date")
    private String searchedDate;
    @a
    @b(a = "searched_date_classes")
    private List<SearchedDateClass> searchedDateClasses;
    @a
    @b(a = "train_details")
    private CJRSearchByTrainDetails trainDetails;

    public Body() {
        this((CJRSearchByTrainDetails) null, (String) null, (List) null, (List) null, 15, (g) null);
    }

    public final CJRSearchByTrainDetails getTrainDetails() {
        return this.trainDetails;
    }

    public final void setTrainDetails(CJRSearchByTrainDetails cJRSearchByTrainDetails) {
        this.trainDetails = cJRSearchByTrainDetails;
    }

    public final String getSearchedDate() {
        return this.searchedDate;
    }

    public final void setSearchedDate(String str) {
        this.searchedDate = str;
    }

    public final List<SearchedDateClass> getSearchedDateClasses() {
        return this.searchedDateClasses;
    }

    public final void setSearchedDateClasses(List<SearchedDateClass> list) {
        this.searchedDateClasses = list;
    }

    public Body(CJRSearchByTrainDetails cJRSearchByTrainDetails, String str, List<SearchedDateClass> list, List<CalendarData> list2) {
        this.trainDetails = cJRSearchByTrainDetails;
        this.searchedDate = str;
        this.searchedDateClasses = list;
        this.calendar = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Body(CJRSearchByTrainDetails cJRSearchByTrainDetails, String str, List list, List list2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRSearchByTrainDetails, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : list2);
    }

    public final List<CalendarData> getCalendar() {
        return this.calendar;
    }

    public final void setCalendar(List<CalendarData> list) {
        this.calendar = list;
    }
}
