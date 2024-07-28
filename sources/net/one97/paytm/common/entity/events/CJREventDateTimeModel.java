package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventDateTimeModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "eventDates")
    private List<String> mEventDateList = new ArrayList();
    @b(a = "seatDetails")
    private List<CJRSeatDetailsModel> mSeatDetails = new ArrayList();
    @b(a = "time")
    private Time mTime;

    public List<String> getmEventDateList() {
        return this.mEventDateList;
    }

    public void setmEventDateList(List<String> list) {
        this.mEventDateList = list;
    }

    public Time getmTime() {
        return this.mTime;
    }

    public void setmTime(Time time) {
        this.mTime = time;
    }

    public List<CJRSeatDetailsModel> getmSeatDetails() {
        return this.mSeatDetails;
    }

    public void setmSeatDetails(List<CJRSeatDetailsModel> list) {
        this.mSeatDetails = list;
    }

    public class Time implements Serializable {
        private static final long serialVersionUID = 1;
        @b(a = "start")
        private String mStart;
        @b(a = "to")
        private String mTo;

        public Time() {
        }

        public String getmStart() {
            return this.mStart;
        }

        public void setmStart(String str) {
            this.mStart = str;
        }

        public String getmTo() {
            return this.mTo;
        }

        public void setmTo(String str) {
            this.mTo = str;
        }
    }
}
