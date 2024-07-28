package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainRecentBooking extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private RecentBookingBody mRecentBookingBody;

    public RecentBookingBody getRecentBookingBody() {
        return this.mRecentBookingBody;
    }

    public class RecentBookingBody extends IJRPaytmDataModel {
        @b(a = "bookings")
        private ArrayList<CJRBookings> mBookingsList;
        @b(a = "pax_info")
        private HashMap<String, CJRPassengerInformation> mPassengerInformation;
        @b(a = "irctc_user_ids")
        private ArrayList<CJRIRCTCuserId> mUserIdList;

        public RecentBookingBody() {
        }

        public ArrayList<CJRBookings> getmBookingsList() {
            return this.mBookingsList;
        }

        public HashMap<String, CJRPassengerInformation> getPassengerInformation() {
            return this.mPassengerInformation;
        }

        public ArrayList<String> getPassengerNameList() {
            ArrayList<String> arrayList = new ArrayList<>();
            HashMap<String, CJRPassengerInformation> hashMap = this.mPassengerInformation;
            if (hashMap != null && hashMap.size() > 0) {
                for (Map.Entry<String, CJRPassengerInformation> key : this.mPassengerInformation.entrySet()) {
                    arrayList.add(key.getKey());
                }
            }
            return arrayList;
        }

        public ArrayList<CJRIRCTCuserId> getmUserIdList() {
            return this.mUserIdList;
        }
    }
}
