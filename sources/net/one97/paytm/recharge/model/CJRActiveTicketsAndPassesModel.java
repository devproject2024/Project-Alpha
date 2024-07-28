package net.one97.paytm.recharge.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;

public class CJRActiveTicketsAndPassesModel extends IJRPaytmDataModel implements IJRDataModel {
    private List<CJRActiveMetroTicketModel> passes;
    private List<CJRActiveMetroTicketModel> tickets;

    public List<CJRActiveMetroTicketModel> getTickets() {
        return this.tickets;
    }

    public List<CJRActiveMetroTicketModel> getPasses() {
        return this.passes;
    }
}
