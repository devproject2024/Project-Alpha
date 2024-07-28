package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroPenaltyDetailsModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "actualDestination")
    private CJRMetroStationModel actualDestination;
    @b(a = "actualSource")
    private CJRMetroStationModel actualSource;
    @b(a = "code")
    private int code;
    @b(a = "entryTime")
    private String entryTime;
    @b(a = "expiryTime")
    private String expiryTime;
    @b(a = "newDestination")
    private CJRMetroStationModel newDestination;
    @b(a = "order_id")
    private long order_id;
    @b(a = "penalties")
    private List<CJRMetroPenaltyReasonModel> penalties;

    public String getEntryTime() {
        return this.entryTime;
    }

    public String getExpiryTime() {
        return this.expiryTime;
    }

    public CJRMetroStationModel getActualSource() {
        return this.actualSource;
    }

    public CJRMetroStationModel getActualDestination() {
        return this.actualDestination;
    }

    public CJRMetroStationModel getNewDestination() {
        return this.newDestination;
    }

    public int getCode() {
        return this.code;
    }

    public long getOrderId() {
        return this.order_id;
    }

    public List<CJRMetroPenaltyReasonModel> getPenalties() {
        List<CJRMetroPenaltyReasonModel> list = this.penalties;
        return list != null ? list : new ArrayList();
    }

    public String getValidity() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm a");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            long time = (simpleDateFormat.parse(this.expiryTime).getTime() - simpleDateFormat.parse(this.entryTime).getTime()) % 86400000;
            long j = time / 3600000;
            long j2 = time % 3600000;
            long j3 = j2 / 60000;
            long j4 = (j2 % 60000) / 1000;
            StringBuilder sb = new StringBuilder();
            if (j != 0) {
                sb.append(j);
                sb.append("hrs ");
            }
            if (j3 != 0) {
                sb.append(j3);
                sb.append("mins ");
            }
            if (j4 != 0) {
                sb.append(j4);
                sb.append(" sec");
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
