package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class FlightBookingRefundDetails extends IJRPaytmDataModel {
    @a
    @b(a = "cards")
    private List<Card> cards;
    @a
    @b(a = "header")
    private String header;

    public FlightBookingRefundDetails() {
        this((List) null, (String) null, 3, (g) null);
    }

    public final List<Card> getCards() {
        return this.cards;
    }

    public final void setCards(List<Card> list) {
        this.cards = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlightBookingRefundDetails(List list, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : str);
    }

    public final String getHeader() {
        return this.header;
    }

    public final void setHeader(String str) {
        this.header = str;
    }

    public FlightBookingRefundDetails(List<Card> list, String str) {
        this.cards = list;
        this.header = str;
    }
}
