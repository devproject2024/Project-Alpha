package com.paytm.business.merchantprofile.common.utility;

import java.util.Date;

public class DateRange {
    public final Date endDate;
    public final Date startDate;

    public DateRange(Date date, Date date2) {
        this.startDate = date;
        this.endDate = date2;
    }
}
