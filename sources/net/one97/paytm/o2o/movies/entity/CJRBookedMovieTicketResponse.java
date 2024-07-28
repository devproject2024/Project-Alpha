package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBookedMovieTicketResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "result")
    ArrayList<CJRBookedMovieTicket> result;

    public ArrayList<CJRBookedMovieTicket> getResult() {
        return this.result;
    }

    public void setResult(ArrayList<CJRBookedMovieTicket> arrayList) {
        this.result = arrayList;
    }
}
