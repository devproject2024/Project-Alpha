package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroPenaltyMessageModel extends IJRPaytmDataModel implements IJRDataModel {
    HashMap<String, Penalty> penalties = new HashMap<>();

    public HashMap<String, Penalty> getPenaltyMap() {
        return this.penalties;
    }

    public class Penalty {
        @b(a = "message")
        private ArrayList<String> message;
        @b(a = "title")
        private String title;

        public Penalty(String str, ArrayList<String> arrayList) {
            this.title = str;
            this.message = arrayList;
        }

        public String getTitle() {
            return this.title;
        }

        public ArrayList<String> getMessage() {
            return this.message;
        }
    }
}
