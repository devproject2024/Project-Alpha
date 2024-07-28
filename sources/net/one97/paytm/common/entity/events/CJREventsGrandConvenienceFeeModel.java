package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJREventsGrandConvenienceFeeModel implements IJRDataModel {
    @b(a = "conFeeBreakUp")
    private ArrayList<CJRTaxInfo> conFeeBreakUp;
    @b(a = "convFee")
    private CJRTaxInfo convFee;

    public CJRTaxInfo getConvFee() {
        return this.convFee;
    }

    public ArrayList<CJRTaxInfo> getConvFeeBreakUp() {
        return this.conFeeBreakUp;
    }
}
