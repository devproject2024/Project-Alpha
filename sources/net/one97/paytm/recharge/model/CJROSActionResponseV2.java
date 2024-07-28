package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;

public final class CJROSActionResponseV2 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "actions")
    private List<CJROSActionItemV2> actions;
    @b(a = "category_message")
    private String categoryMassage;
    @b(a = "error")
    private String error;
    @b(a = "generate_ticket_url")
    private String generateTicketUrl;
    @b(a = "item_level_actions")
    private CJROSActionResponseV2 itemLevelActions;
    @b(a = "message")
    private String message;
    @b(a = "metro_smart_card")
    private CJROSMetroSmartCard metroSmartCard;
    @b(a = "operator_reference_number")
    private String operatorReferenceNumber;
    @b(a = "order_level_actions")
    private CJROSActionResponseV2 orderLevelActions;
    @b(a = "order_level_widgets")
    private List<CJROSActionItemV2> orderLevelWidgets;
    private List<? extends CJRActiveMetroTicketModel> passes;
    @b(a = "status")
    private int status;
    @b(a = "statusCode")
    private int statusCode = -1;
    private List<? extends CJRActiveMetroTicketModel> tickets;
    @b(a = "title ")
    private String title;
    @b(a = "verticalActions")
    private List<CJROSActionItemV2> verticalActions;

    public final int getStatus() {
        return this.status;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCategoryMassage() {
        return this.categoryMassage;
    }

    public final String getOperatorReferenceNumber() {
        return this.operatorReferenceNumber;
    }

    public final String getError() {
        return this.error;
    }

    public final List<CJRActiveMetroTicketModel> getTickets() {
        return this.tickets;
    }

    public final List<CJRActiveMetroTicketModel> getPasses() {
        return this.passes;
    }

    public final String getGenerateTicketUrl() {
        return this.generateTicketUrl;
    }

    public final CJROSActionResponseV2 getOrderLevelActions() {
        return this.orderLevelActions;
    }

    public final List<CJROSActionItemV2> getOrderLevelWidgets() {
        return this.orderLevelWidgets;
    }

    public final CJROSActionResponseV2 getItemLevelActions() {
        return this.itemLevelActions;
    }

    public final void setItemLevelActions(CJROSActionResponseV2 cJROSActionResponseV2) {
        this.itemLevelActions = cJROSActionResponseV2;
    }

    public final CJROSMetroSmartCard getMetroSmartCard() {
        return this.metroSmartCard;
    }

    public final void setMetroSmartCard(CJROSMetroSmartCard cJROSMetroSmartCard) {
        this.metroSmartCard = cJROSMetroSmartCard;
    }

    public final List<CJROSActionItemV2> getActions() {
        return this.actions;
    }

    public final void setActions(List<CJROSActionItemV2> list) {
        this.actions = list;
    }

    public final List<CJROSActionItemV2> getVerticalActions() {
        return this.verticalActions;
    }
}
