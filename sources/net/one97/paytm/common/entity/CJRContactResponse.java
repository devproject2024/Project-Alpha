package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.cst.CJRCSTTicketDetail;

public class CJRContactResponse extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "message ")
    private String mMessage;
    @b(a = "message")
    private String mMsg;
    @b(a = "messsage")
    private String mMsg2;
    @b(a = "status")
    private int mStatus;
    @b(a = "ticket_id")
    private String mTicketId;
    @b(a = "ticket")
    private CJRCSTTicketDetail ticket;

    public String getMsg() {
        return this.mMsg;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }

    public String getmMsg2() {
        return this.mMsg2;
    }

    public void setmMsg2(String str) {
        this.mMsg2 = str;
    }

    public String getmTicketId() {
        return this.mTicketId;
    }

    public void setmTicketId(String str) {
        this.mTicketId = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getmMessage() {
        return this.mMessage;
    }

    public CJRCSTTicketDetail getTicket() {
        return this.ticket;
    }

    public void setTicket(CJRCSTTicketDetail cJRCSTTicketDetail) {
        this.ticket = cJRCSTTicketDetail;
    }
}
