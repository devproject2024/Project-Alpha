package net.one97.paytm.common.entity.movies.moviepass;

import java.util.Map;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMPMataDataModel implements IJRDataModel {
    private String customer_id;
    private Map<String, ? extends Object> instructions;
    private String isPostFBPresent;
    private Boolean moviePassPresent;
    private String movie_order_summary;
    private CJRPrevalidateMoviePassModel movie_pass;
    private CJRMPPassengerModel passenger;
    private String postFBOrder;
    private CJRMPTaxInfoModel taxInfo;
    private Boolean ticketNotPresent;
    private Boolean uber_available;

    public CJRMPMataDataModel(Boolean bool, Boolean bool2, String str, CJRMPPassengerModel cJRMPPassengerModel, CJRPrevalidateMoviePassModel cJRPrevalidateMoviePassModel, CJRMPTaxInfoModel cJRMPTaxInfoModel, String str2, String str3, String str4, Boolean bool3, Map<String, ? extends Object> map) {
        this.ticketNotPresent = bool;
        this.moviePassPresent = bool2;
        this.customer_id = str;
        this.passenger = cJRMPPassengerModel;
        this.movie_pass = cJRPrevalidateMoviePassModel;
        this.taxInfo = cJRMPTaxInfoModel;
        this.isPostFBPresent = str2;
        this.postFBOrder = str3;
        this.movie_order_summary = str4;
        this.uber_available = bool3;
        this.instructions = map;
    }

    public final Boolean getTicketNotPresent() {
        return this.ticketNotPresent;
    }

    public final void setTicketNotPresent(Boolean bool) {
        this.ticketNotPresent = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMPMataDataModel(Boolean bool, Boolean bool2, String str, CJRMPPassengerModel cJRMPPassengerModel, CJRPrevalidateMoviePassModel cJRPrevalidateMoviePassModel, CJRMPTaxInfoModel cJRMPTaxInfoModel, String str2, String str3, String str4, Boolean bool3, Map map, int i2, g gVar) {
        this(bool, (i2 & 2) != 0 ? Boolean.TRUE : bool2, str, cJRMPPassengerModel, cJRPrevalidateMoviePassModel, cJRMPTaxInfoModel, str2, str3, str4, bool3, map);
    }

    public final Boolean getMoviePassPresent() {
        return this.moviePassPresent;
    }

    public final void setMoviePassPresent(Boolean bool) {
        this.moviePassPresent = bool;
    }

    public final String getCustomer_id() {
        return this.customer_id;
    }

    public final void setCustomer_id(String str) {
        this.customer_id = str;
    }

    public final CJRMPPassengerModel getPassenger() {
        return this.passenger;
    }

    public final void setPassenger(CJRMPPassengerModel cJRMPPassengerModel) {
        this.passenger = cJRMPPassengerModel;
    }

    public final CJRPrevalidateMoviePassModel getMovie_pass() {
        return this.movie_pass;
    }

    public final void setMovie_pass(CJRPrevalidateMoviePassModel cJRPrevalidateMoviePassModel) {
        this.movie_pass = cJRPrevalidateMoviePassModel;
    }

    public final CJRMPTaxInfoModel getTaxInfo() {
        return this.taxInfo;
    }

    public final void setTaxInfo(CJRMPTaxInfoModel cJRMPTaxInfoModel) {
        this.taxInfo = cJRMPTaxInfoModel;
    }

    public final String isPostFBPresent() {
        return this.isPostFBPresent;
    }

    public final void setPostFBPresent(String str) {
        this.isPostFBPresent = str;
    }

    public final String getPostFBOrder() {
        return this.postFBOrder;
    }

    public final void setPostFBOrder(String str) {
        this.postFBOrder = str;
    }

    public final String getMovie_order_summary() {
        return this.movie_order_summary;
    }

    public final void setMovie_order_summary(String str) {
        this.movie_order_summary = str;
    }

    public final Boolean getUber_available() {
        return this.uber_available;
    }

    public final void setUber_available(Boolean bool) {
        this.uber_available = bool;
    }

    public final Map<String, Object> getInstructions() {
        return this.instructions;
    }

    public final void setInstructions(Map<String, ? extends Object> map) {
        this.instructions = map;
    }
}
