package net.one97.paytmflight.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryCancellation extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private CJROrderSummaryCancellationBody body;
    @b(a = "error")
    private Object error;
    @b(a = "status")
    private CJROrderSummaryCancellationStatus status;

    public static long getSerialVersionUID() {
        return 1;
    }

    public Object getError() {
        return this.error;
    }

    public void setError(Object obj) {
        this.error = obj;
    }

    public CJROrderSummaryCancellationStatus getStatus() {
        return this.status;
    }

    public void setStatus(CJROrderSummaryCancellationStatus cJROrderSummaryCancellationStatus) {
        this.status = cJROrderSummaryCancellationStatus;
    }

    public CJROrderSummaryCancellationBody getBody() {
        return this.body;
    }

    public void setBody(CJROrderSummaryCancellationBody cJROrderSummaryCancellationBody) {
        this.body = cJROrderSummaryCancellationBody;
    }

    public class CJROrderSummaryCancellationStatus implements IJRDataModel {
        @b(a = "message")
        private Object messageObject;
        @b(a = "result")
        private String result;

        public CJROrderSummaryCancellationStatus() {
        }

        public String getResult() {
            return this.result;
        }

        public void setResult(String str) {
            this.result = str;
        }

        public Object getMessageObject() {
            return this.messageObject;
        }

        public void setMessageObject(Object obj) {
            this.messageObject = obj;
        }
    }

    public class CJROrderSummaryCancellationBody implements IJRDataModel {
        @b(a = "addons")
        private Object addOns;
        @b(a = "items")
        private Object items;
        @b(a = "order_id")
        private String orderId;
        @b(a = "paytm_cashback")
        private String paytmCashBack;
        @b(a = "timeline")
        private List<CJROrderSummaryCancellationTimeline> timeLine;
        @b(a = "total_fare")
        private String totalFare;
        @b(a = "total_refund")
        private String totalRefund;

        public CJROrderSummaryCancellationBody() {
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public String getTotalFare() {
            return this.totalFare;
        }

        public void setTotalFare(String str) {
            this.totalFare = str;
        }

        public String getTotalRefund() {
            return this.totalRefund;
        }

        public void setTotalRefund(String str) {
            this.totalRefund = str;
        }

        public String getPaytmCashBack() {
            return this.paytmCashBack;
        }

        public void setPaytmCashBack(String str) {
            this.paytmCashBack = str;
        }

        public List<CJROrderSummaryCancellationTimeline> getTimeLine() {
            return this.timeLine;
        }

        public void setTimeLine(List<CJROrderSummaryCancellationTimeline> list) {
            this.timeLine = list;
        }

        public Object getItems() {
            return this.items;
        }

        public void setItems(Object obj) {
            this.items = obj;
        }

        public Object getAddOns() {
            return this.addOns;
        }

        public void setAddOns(Object obj) {
            this.addOns = obj;
        }
    }

    public class CJROrderSummaryCancellationTimeline implements IJRDataModel {
        @b(a = "item_ids")
        private List<String> itemIds;
        @b(a = "states")
        private List<CJROrderSummaryCancellationState> states;

        public CJROrderSummaryCancellationTimeline() {
        }

        public List<String> getItemIds() {
            return this.itemIds;
        }

        public void setItemIds(List<String> list) {
            this.itemIds = list;
        }

        public List<CJROrderSummaryCancellationState> getStates() {
            return this.states;
        }

        public void setStates(List<CJROrderSummaryCancellationState> list) {
            this.states = list;
        }
    }

    public class CJROrderSummaryCancellationState implements IJRDataModel {
        @b(a = "completed_at")
        private String completedAt;
        @b(a = "done")
        private boolean done;
        @b(a = "eta")
        private String eta;
        @b(a = "index")
        private String index;
        @b(a = "text")
        private String text;

        public CJROrderSummaryCancellationState() {
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public boolean isDone() {
            return this.done;
        }

        public void setDone(boolean z) {
            this.done = z;
        }

        public String getIndex() {
            return this.index;
        }

        public void setIndex(String str) {
            this.index = str;
        }

        public String getCompletedAt() {
            return this.completedAt;
        }

        public void setCompletedAt(String str) {
            this.completedAt = str;
        }

        public String getEta() {
            return this.eta;
        }

        public void setEta(String str) {
            this.eta = str;
        }
    }

    public class CJROrderSummaryCancellationItem implements IJRDataModel {
        @b(a = "airline_code")
        private String airline_code;
        @b(a = "airline_name")
        private String airline_name;
        @b(a = "ancillary_total_refund")
        private Double ancillaryTotalRefund;
        @b(a = "cancellation_charges")
        private Object cancellation_charges;
        @b(a = "cancel_protect_refund")
        private String cpCancelRefundAmount;
        @b(a = "cancel_protect_cancellation_charges")
        private String cpCancellationCharges;
        @b(a = "cp_note")
        private String cpNote;
        @b(a = "departure_date")
        private String departure_date;
        @b(a = "destination")
        private String destination;
        @b(a = "destination_iata")
        private String destination_iata;
        @b(a = "direction")
        private String direction;
        @b(a = "fare")
        private Object fare;
        @b(a = "is_cancel_protect_used")
        private Boolean isCancelProtectUsed;
        @b(a = "is_combination")
        private String isCombination;
        @b(a = "item_id")
        private String itemId;
        @b(a = "origin")
        private String origin;
        @b(a = "origin_iata")
        private String origin_iata;
        @b(a = "passenger_details")
        private Object passenger_details;
        @b(a = "paytm_cashback")
        private String paytm_cashback;
        @b(a = "provider")
        private String provider;
        @b(a = "refund")
        private String refund;
        @b(a = "refundable")
        private boolean refundable;
        @b(a = "status")
        private String status;

        public CJROrderSummaryCancellationItem() {
        }

        public String getItemId() {
            return this.itemId;
        }

        public void setItemId(String str) {
            this.itemId = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public boolean isRefundable() {
            return this.refundable;
        }

        public void setRefundable(boolean z) {
            this.refundable = z;
        }

        public String getIsCombination() {
            return this.isCombination;
        }

        public void setIsCombination(String str) {
            this.isCombination = str;
        }

        public String getOrigin_iata() {
            return this.origin_iata;
        }

        public void setOrigin_iata(String str) {
            this.origin_iata = str;
        }

        public String getOrigin() {
            return this.origin;
        }

        public void setOrigin(String str) {
            this.origin = str;
        }

        public String getDestination() {
            return this.destination;
        }

        public void setDestination(String str) {
            this.destination = str;
        }

        public String getDestination_iata() {
            return this.destination_iata;
        }

        public void setDestination_iata(String str) {
            this.destination_iata = str;
        }

        public String getProvider() {
            return this.provider;
        }

        public void setProvider(String str) {
            this.provider = str;
        }

        public String getDeparture_date() {
            return this.departure_date;
        }

        public void setDeparture_date(String str) {
            this.departure_date = str;
        }

        public String getAirline_name() {
            return this.airline_name;
        }

        public void setAirline_name(String str) {
            this.airline_name = str;
        }

        public String getAirline_code() {
            return this.airline_code;
        }

        public void setAirline_code(String str) {
            this.airline_code = str;
        }

        public String getDirection() {
            return this.direction;
        }

        public void setDirection(String str) {
            this.direction = str;
        }

        public Object getPassenger_details() {
            return this.passenger_details;
        }

        public void setPassenger_details(Object obj) {
            this.passenger_details = obj;
        }

        public Object getFare() {
            return this.fare;
        }

        public void setFare(Object obj) {
            this.fare = obj;
        }

        public String getPaytm_cashback() {
            return this.paytm_cashback;
        }

        public void setPaytm_cashback(String str) {
            this.paytm_cashback = str;
        }

        public Object getCancellation_charges() {
            return this.cancellation_charges;
        }

        public void setCancellation_charges(Object obj) {
            this.cancellation_charges = obj;
        }

        public String getRefund() {
            return this.refund;
        }

        public void setRefund(String str) {
            this.refund = str;
        }

        public Boolean isCancelProtectUsed() {
            return this.isCancelProtectUsed;
        }

        public void setCancelProtectUsed(Boolean bool) {
            this.isCancelProtectUsed = bool;
        }

        public String getCpCancellationCharges() {
            return this.cpCancellationCharges;
        }

        public void setCpCancellationCharges(String str) {
            this.cpCancellationCharges = str;
        }

        public String getCpCancelRefundAmount() {
            return this.cpCancelRefundAmount;
        }

        public void setCpCancelRefundAmount(String str) {
            this.cpCancelRefundAmount = str;
        }

        public String getCpNote() {
            return this.cpNote;
        }

        public void setCpNote(String str) {
            this.cpNote = str;
        }

        public Double getAncillaryTotalRefund() {
            return this.ancillaryTotalRefund;
        }

        public void setAncillaryTotalRefund(Double d2) {
            this.ancillaryTotalRefund = d2;
        }
    }
}
