package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;

public class CJRTrainActionResponse extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "post_actions")
    private List<CJRActiveMetroTicketModel> activeMetroTickets;
    private String cancelType;
    @b(a = "actions")
    private ArrayList<CJRTrainOrderSummaryAction> mActions;
    @b(a = "error")
    private String mError;
    @b(a = "message")
    private String mMessage;
    @b(a = "status")
    private int mStatus;
    @b(a = "title ")
    private String mTitle;
    private List<CJRActiveMetroTicketModel> passes;
    private String requestUrl;
    private List<CJRActiveMetroTicketModel> tickets;

    public List<CJRActiveMetroTicketModel> getTickets() {
        return this.tickets;
    }

    public List<CJRActiveMetroTicketModel> getPasses() {
        return this.passes;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getError() {
        return this.mError;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public ArrayList<CJRTrainOrderSummaryAction> getActions() {
        return this.mActions;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public List<CJRActiveMetroTicketModel> getActiveMetroTickets() {
        return this.activeMetroTickets;
    }

    public String getCancelType() {
        return this.cancelType;
    }
}
