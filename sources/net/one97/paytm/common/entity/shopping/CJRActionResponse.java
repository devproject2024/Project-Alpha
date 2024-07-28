package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;

public class CJRActionResponse extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "post_actions")
    private List<CJRActiveMetroTicketModel> activeMetroTickets;
    private String cancelType;
    @b(a = "actions")
    private ArrayList<CJROrderSummaryAction> mActions;
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

    public ArrayList<CJROrderSummaryAction> getActions() {
        return this.mActions;
    }

    public void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public List<CJRActiveMetroTicketModel> getActiveMetroTickets() {
        return this.activeMetroTickets;
    }

    public void setActiveMetroTickets(List<CJRActiveMetroTicketModel> list) {
        this.activeMetroTickets = list;
    }

    public String getCancelType() {
        return this.cancelType;
    }

    public void setCancelType(String str) {
        this.cancelType = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRActionResponse cJRActionResponse = (CJRActionResponse) fVar.a(str, getClass());
        cJRActionResponse.setRequestUrl(getRequestUrl());
        return cJRActionResponse;
    }
}
