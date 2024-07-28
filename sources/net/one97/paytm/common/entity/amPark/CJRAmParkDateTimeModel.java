package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkDateTimeModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "packages")
    private List<CJRParkPackageDetailsModel> mPackageDetailsList = new ArrayList();
    @b(a = "parkDates")
    private List<String> mParkDateList = new ArrayList();
    @b(a = "time")
    private Time mTime;

    public List<String> getmParkDateList() {
        return this.mParkDateList;
    }

    public void setmParkDateList(List<String> list) {
        this.mParkDateList = list;
    }

    public Time getmTime() {
        return this.mTime;
    }

    public void setmTime(Time time) {
        this.mTime = time;
    }

    public List<CJRParkPackageDetailsModel> getmPackageDetailsList() {
        return this.mPackageDetailsList;
    }

    public void setmPackageDetailsList(List<CJRParkPackageDetailsModel> list) {
        this.mPackageDetailsList = list;
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

        public boolean equals(Object obj) {
            if (obj instanceof Time) {
                Time time = (Time) obj;
                if (!this.mStart.equals(time.mStart) || !this.mTo.equals(time.mTo)) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
