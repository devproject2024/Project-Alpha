package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class BookingStatus {
    @b(a = "data")
    ArrayList<BookingStatusData> data;

    public class BookingStatusData {
        @b(a = "status")
        String status;
        @b(a = "status_id")
        String status_id;
        @b(a = "status_text")
        String status_text;

        public BookingStatusData() {
        }

        public String getStatusId() {
            return this.status_id;
        }

        public void setStatusId(String str) {
            this.status_id = str;
        }

        public String getStatusText() {
            return this.status_text;
        }

        public void setStatusText(String str) {
            this.status_text = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }

    public ArrayList<BookingStatusData> getData() {
        return this.data;
    }

    public void setData(ArrayList<BookingStatusData> arrayList) {
        this.data = arrayList;
    }
}
