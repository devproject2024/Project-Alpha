package net.one97.paytm.o2o.events.common;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventsDownloadTicket extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "digital_ticket_url")
    String digital_ticket_url;

    public String getTicketUrl() {
        return this.digital_ticket_url;
    }

    public void setTicketUrl(String str) {
        this.digital_ticket_url = str;
    }
}
