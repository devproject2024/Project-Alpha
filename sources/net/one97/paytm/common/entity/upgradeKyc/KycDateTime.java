package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class KycDateTime extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "dateTime")
    private ArrayList<DateTime> dateTime;
    @b(a = "errorMsg")
    private String errorMessage;
    @b(a = "statusCode")
    private int statusCode;

    public ArrayList<DateTime> getDateTime() {
        return this.dateTime;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public class DateTime {
        @b(a = "date")
        private String date;
        @b(a = "timeSlot")
        private ArrayList<String> timeSlot;

        public DateTime() {
        }

        public String getDate() {
            return this.date;
        }

        public ArrayList<String> getTimeSlot() {
            return this.timeSlot;
        }
    }
}
