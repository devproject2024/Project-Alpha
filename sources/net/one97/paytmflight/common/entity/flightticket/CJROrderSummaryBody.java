package net.one97.paytmflight.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.FlightBookingRefundDetails;
import com.travel.flight.pojo.ModifiedParentOrder;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;

public class CJROrderSummaryBody extends IJRPaytmDataModel {
    private CJRAncillaryCard addon_travel_ins_card;
    private String aggregate_item_price;
    private CJROrderSummaryAllStates all_states;
    private List<CJRAncillaryCard> ancillary_card;
    private CJROrderSummaryBookingCard booking_card;
    private BundleCard bundle_card;
    private CJROrderSummaryCashbackCard cashback_card;
    private String cashback_label;
    private String cashback_text;
    private String channel_id;
    private CJROrderSummaryCancallationProtect cp_card;
    private String created_at;
    private String customer_id;
    private CJROrderSummaryFooterCard footer_card;
    @b(a = "info_box_html")
    private String info_box_html;
    private int item_level_status;
    private ArrayList<CJROrderSummaryItems> items;
    @b(a = "parent_order")
    private ModifiedParentOrder modifiedParentOrder;
    private String order_id;
    private String order_payment_summary;
    private String order_status;
    private String payment_text;
    private ArrayList<CJROrderSummaryPayments> payments;
    private CJROrderSummaryPymntSummary pymnt_summary;
    @b(a = "refresh_flag")
    private boolean refresh_flag;
    @b(a = "refresh_time_sec")
    private double refresh_time_sec;
    @b(a = "refund_card_dtls")
    private FlightBookingRefundDetails refundDetails;
    private OrderSummaryRefundCard refund_card;
    private ArrayList<FlightOrderSummaryRefundNotes> refund_notes;
    private OrderSummaryRefundSummary refund_summary;
    private String remote_ip;
    private List<CJRStatusLevelCardItem> status_label_card;
    private FlightOrderSummaryTaxBreakUp tax_break_up;
    private String total_cashback;
    private String total_conv_fee;
    private String total_items_price;
    private String total_price;
    private String vertical_id;
    private String vertical_label;

    public OrderSummaryRefundCard getRefund_card() {
        return this.refund_card;
    }

    public void setRefund_card(OrderSummaryRefundCard orderSummaryRefundCard) {
        this.refund_card = orderSummaryRefundCard;
    }

    public List<CJRStatusLevelCardItem> getStatusLabelCard() {
        return this.status_label_card;
    }

    public void setStatusLabelCard(List<CJRStatusLevelCardItem> list) {
        this.status_label_card = list;
    }

    public ModifiedParentOrder getModifiedParentOrder() {
        return this.modifiedParentOrder;
    }

    public ArrayList<CJROrderSummaryItems> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<CJROrderSummaryItems> arrayList) {
        this.items = arrayList;
    }

    public ArrayList<CJROrderSummaryPayments> getPayments() {
        return this.payments;
    }

    public void setPayments(ArrayList<CJROrderSummaryPayments> arrayList) {
        this.payments = arrayList;
    }

    public CJROrderSummaryPymntSummary getPymnt_summary() {
        return this.pymnt_summary;
    }

    public void setPymnt_summary(CJROrderSummaryPymntSummary cJROrderSummaryPymntSummary) {
        this.pymnt_summary = cJROrderSummaryPymntSummary;
    }

    public CJROrderSummaryCashbackCard getCashback_card() {
        return this.cashback_card;
    }

    public void setCashback_card(CJROrderSummaryCashbackCard cJROrderSummaryCashbackCard) {
        this.cashback_card = cJROrderSummaryCashbackCard;
    }

    public CJROrderSummaryBookingCard getBookingCard() {
        return this.booking_card;
    }

    public void setBookingCard(CJROrderSummaryBookingCard cJROrderSummaryBookingCard) {
        this.booking_card = cJROrderSummaryBookingCard;
    }

    public CJROrderSummaryAllStates getAll_states() {
        return this.all_states;
    }

    public void setAll_states(CJROrderSummaryAllStates cJROrderSummaryAllStates) {
        this.all_states = cJROrderSummaryAllStates;
    }

    public CJROrderSummaryFooterCard getFooter_card() {
        return this.footer_card;
    }

    public void setFooter_card(CJROrderSummaryFooterCard cJROrderSummaryFooterCard) {
        this.footer_card = cJROrderSummaryFooterCard;
    }

    public String getRemote_ip() {
        return this.remote_ip;
    }

    public void setRemote_ip(String str) {
        this.remote_ip = str;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public String getTotal_conv_fee() {
        return this.total_conv_fee;
    }

    public void setTotal_conv_fee(String str) {
        this.total_conv_fee = str;
    }

    public int getItem_level_status() {
        return this.item_level_status;
    }

    public void setItem_level_status(int i2) {
        this.item_level_status = i2;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getVertical_id() {
        return this.vertical_id;
    }

    public void setVertical_id(String str) {
        this.vertical_id = str;
    }

    public String getTotal_cashback() {
        return this.total_cashback;
    }

    public void setTotal_cashback(String str) {
        this.total_cashback = str;
    }

    public String getTotal_items_price() {
        return this.total_items_price;
    }

    public void setTotal_items_price(String str) {
        this.total_items_price = str;
    }

    public String getPayment_text() {
        return this.payment_text;
    }

    public void setPayment_text(String str) {
        this.payment_text = str;
    }

    public String getAggregate_item_price() {
        return this.aggregate_item_price;
    }

    public void setAggregate_item_price(String str) {
        this.aggregate_item_price = str;
    }

    public String getCashback_text() {
        return this.cashback_text;
    }

    public void setCashback_text(String str) {
        this.cashback_text = str;
    }

    public String getOrder_payment_summary() {
        return this.order_payment_summary;
    }

    public void setOrder_payment_summary(String str) {
        this.order_payment_summary = str;
    }

    public String getVertical_label() {
        return this.vertical_label;
    }

    public void setVertical_label(String str) {
        this.vertical_label = str;
    }

    public String getTotal_price() {
        return this.total_price;
    }

    public void setTotal_price(String str) {
        this.total_price = str;
    }

    public String getChannel_id() {
        return this.channel_id;
    }

    public void setChannel_id(String str) {
        this.channel_id = str;
    }

    public String getOrder_status() {
        return this.order_status;
    }

    public void setOrder_status(String str) {
        this.order_status = str;
    }

    public String getCashback_label() {
        return this.cashback_label;
    }

    public void setCashback_label(String str) {
        this.cashback_label = str;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(String str) {
        this.customer_id = str;
    }

    public CJROrderSummaryCancallationProtect getCp_card() {
        return this.cp_card;
    }

    public void setCp_card(CJROrderSummaryCancallationProtect cJROrderSummaryCancallationProtect) {
        this.cp_card = cJROrderSummaryCancallationProtect;
    }

    public List<CJRAncillaryCard> getAncillary_card() {
        return this.ancillary_card;
    }

    public void setAncillary_card(List<CJRAncillaryCard> list) {
        this.ancillary_card = list;
    }

    public OrderSummaryRefundSummary getRefund_summary() {
        return this.refund_summary;
    }

    public void setRefund_summary(OrderSummaryRefundSummary orderSummaryRefundSummary) {
        this.refund_summary = orderSummaryRefundSummary;
    }

    public FlightOrderSummaryTaxBreakUp getTax_break_up() {
        return this.tax_break_up;
    }

    public void setTax_break_up(FlightOrderSummaryTaxBreakUp flightOrderSummaryTaxBreakUp) {
        this.tax_break_up = flightOrderSummaryTaxBreakUp;
    }

    public CJRAncillaryCard getAddon_travel_ins_card() {
        return this.addon_travel_ins_card;
    }

    public void setAddon_travel_ins_card(CJRAncillaryCard cJRAncillaryCard) {
        this.addon_travel_ins_card = cJRAncillaryCard;
    }

    public ArrayList<FlightOrderSummaryRefundNotes> getRefund_notes() {
        return this.refund_notes;
    }

    public void setRefund_notes(ArrayList<FlightOrderSummaryRefundNotes> arrayList) {
        this.refund_notes = arrayList;
    }

    public BundleCard getBundle_card() {
        return this.bundle_card;
    }

    public void setBundle_card(BundleCard bundleCard) {
        this.bundle_card = bundleCard;
    }

    public FlightBookingRefundDetails getRefundDetails() {
        return this.refundDetails;
    }

    public String getInfo_box_html() {
        return this.info_box_html;
    }

    public void setInfo_box_html(String str) {
        this.info_box_html = str;
    }

    public boolean isRefresh_flag() {
        return this.refresh_flag;
    }

    public int getRefresh_time_sec() {
        return (int) this.refresh_time_sec;
    }
}
