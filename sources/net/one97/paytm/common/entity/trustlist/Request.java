package net.one97.paytm.common.entity.trustlist;

import java.util.ArrayList;

public class Request {
    private EventInfo eventInfo;
    private ArrayList<MsgDetail> messageInfo;
    private TxnInfo txnInfo;

    public TxnInfo getTxnInfo() {
        return this.txnInfo;
    }

    public void setTxnInfo(TxnInfo txnInfo2) {
        this.txnInfo = txnInfo2;
    }

    public EventInfo getEventInfo() {
        return this.eventInfo;
    }

    public void setEventInfo(EventInfo eventInfo2) {
        this.eventInfo = eventInfo2;
    }

    public ArrayList<MsgDetail> getMessageInfo() {
        return this.messageInfo;
    }

    public void setMessageInfo(ArrayList<MsgDetail> arrayList) {
        this.messageInfo = arrayList;
    }
}
