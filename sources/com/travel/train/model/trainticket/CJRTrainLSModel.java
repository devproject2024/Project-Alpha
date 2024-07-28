package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainLSModel extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "body")
    private Body body;
    @a
    @b(a = "code")
    private Integer code;
    @a
    @b(a = "error")
    private String error;
    @a
    @b(a = "meta")
    private CJRTrainLSSearchResult.Meta meta;
    @a
    @b(a = "status")
    private CJRTrainStatus status;

    public String getError() {
        return this.error;
    }

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public CJRTrainLSSearchResult.Meta getMeta() {
        return this.meta;
    }

    public Integer getCode() {
        return this.code;
    }

    public Body getBody() {
        return this.body;
    }

    public class Body implements IJRDataModel {
        @a
        @b(a = "current_station")
        private String current_station;
        @b(a = "train_status_message")
        private String infoMessage;
        @a
        @b(a = "server_timestamp")
        private String server_timestamp;
        @a
        @b(a = "stations")
        private List<CJRTrainLSStation> stations;
        @a
        @b(a = "terminated")
        private boolean terminated;
        @a
        @b(a = "time_of_availability")
        private String time_of_availability;

        public Body() {
        }

        public String getTime_of_availability() {
            return this.time_of_availability;
        }

        public void setTime_of_availability(String str) {
            this.time_of_availability = str;
        }

        public String getCurrent_station() {
            return this.current_station;
        }

        public void setCurrent_station(String str) {
            this.current_station = str;
        }

        public boolean isTerminated() {
            return this.terminated;
        }

        public void setTerminated(boolean z) {
            this.terminated = z;
        }

        public String getServer_timestamp() {
            return this.server_timestamp;
        }

        public void setServer_timestamp(String str) {
            this.server_timestamp = str;
        }

        public List<CJRTrainLSStation> getStations() {
            return this.stations;
        }

        public void setStations(List<CJRTrainLSStation> list) {
            this.stations = list;
        }

        public String getInfoMessage() {
            return this.infoMessage;
        }
    }
}
