package net.one97.paytm.common.entity.shopping;

import android.graphics.Bitmap;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieICancelProtectModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodBeveragesResponse;

public class CJROrderSummaryMetadataResponse implements IJRDataModel {
    @b(a = "address")
    private Object address;
    @b(a = "audi")
    private String audi;
    @b(a = "bookingId")
    private String bookingId;
    @b(a = "bookingIndex")
    private String bookingIndex;
    @b(a = "branchCode")
    private String branchCode;
    @b(a = "censor")
    private String censor;
    @b(a = "cinema")
    private String cinema;
    @b(a = "cinemaId")
    private String cinemaId;
    @b(a = "circleName")
    private String circleName;
    @b(a = "citySearched")
    private String citySearched;
    @b(a = "convFee")
    private String convFee;
    @b(a = "duration")
    private int duration;
    @b(a = "food_beverages")
    private CJRSummaryFoodBeveragesResponse foodAndBeverages;
    @b(a = "freeSeating")
    private boolean freeSeating;
    @b(a = "insurance")
    private CJRMovieICancelProtectModel insurance;
    @b(a = "isInsuranceLive")
    private int isInsuranceLive;
    @b(a = "isInsurancePresent")
    private int isInsurancePresent;
    @b(a = "isPostFBPresent")
    private int isPostFBPresent;
    @b(a = "language")
    private String language;
    @b(a = "latitude")
    private String latitude;
    @b(a = "longitude")
    private String longitude;
    @b(a = "movie")
    private String movie;
    @b(a = "movieCode")
    private String movieCode;
    @b(a = "movieImageUrl")
    private String movieImageUrl;
    private Bitmap moviePosterImg;
    @b(a = "multipleEticket")
    private String multipleEticket;
    @b(a = "multipleEticketSelected")
    private Boolean multipleEticketSelected;
    @b(a = "parent_order_id")
    private String parent_order_id;
    @b(a = "paytmCityName")
    private String paytmCityName;
    @b(a = "postFBCutoff")
    private String postFBCutoff;
    @b(a = "postFBOrder")
    private int postFBOrder;
    @b(a = "postFBUrl")
    private String postFBUrl;
    @b(a = "providerId")
    private String providerId;
    @b(a = "screen_format")
    private String screenFormat;
    @b(a = "screenNum")
    private String screenNum;
    @b(a = "seatIdsReturned")
    private String seatIdsReturned;
    @b(a = "seatType")
    private String seatType;
    @b(a = "serviceTax")
    private String serviceTax;
    @b(a = "sessionId")
    private String sessionId;
    @b(a = "showTime")
    private String showTime;
    @b(a = "source")
    private String source;
    @b(a = "summary_gallery")
    private CJRMovieSummaryGallery summaryGallery;
    @b(a = "swachBharatCess")
    private String swachBharatCess;
    @b(a = "taxInfo")
    private HashMap<String, String> taxInfo;
    @b(a = "ticketCount")
    private int ticketCount;
    @b(a = "totalCommision")
    private String totalCommision;
    @b(a = "totalConvFee")
    private String totalConvFee;
    @b(a = "totalPgCharges")
    private String totalPgCharges;
    @b(a = "totalServiceTax")
    private String totalServiceTax;
    @b(a = "totalSwachBharatCess")
    private String totalSwachBharatCess;
    @b(a = "totalTicketPrice")
    private double totalTicketPrice;
    @b(a = "transId")
    private String transId;
    @b(a = "uber_available")
    private boolean uberAvailable;
    @b(a = "uniqueBookingId")
    private String uniqueBookingId;

    public String getMovieCode() {
        return this.movieCode;
    }

    public String getPaytmCityName() {
        return this.paytmCityName;
    }

    public CJRMovieSummaryGallery getSummaryGallery() {
        return this.summaryGallery;
    }

    public String getServiceTax() {
        return this.serviceTax;
    }

    public void setServiceTax(String str) {
        this.serviceTax = str;
    }

    public String getAudi() {
        return this.audi;
    }

    public boolean isFreeSeating() {
        return this.freeSeating;
    }

    public String getCircleName() {
        return this.circleName;
    }

    public void setAudi(String str) {
        this.audi = str;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String str) {
        this.bookingId = str;
    }

    public boolean isUberAvailable() {
        return this.uberAvailable;
    }

    public String getMultipleEticket() {
        return this.multipleEticket;
    }

    public void setMultipleEticket(String str) {
        this.multipleEticket = str;
    }

    public String getCitySearched() {
        return this.citySearched;
    }

    public void setCitySearched(String str) {
        this.citySearched = str;
    }

    public String getTotalCommision() {
        return this.totalCommision;
    }

    public void setTotalCommision(String str) {
        this.totalCommision = str;
    }

    public String getTotalConvFee() {
        return this.totalConvFee;
    }

    public void setTotalConvFee(String str) {
        this.totalConvFee = str;
    }

    public double getTotalTicketPrice() {
        return this.totalTicketPrice;
    }

    public void setTotalTicketPrice(int i2) {
        this.totalTicketPrice = (double) i2;
    }

    public String getCensor() {
        return this.censor;
    }

    public void setCensor(String str) {
        this.censor = str;
    }

    public String getTotalServiceTax() {
        return this.totalServiceTax;
    }

    public void setTotalServiceTax(String str) {
        this.totalServiceTax = str;
    }

    public String getSwachBharatCess() {
        return this.swachBharatCess;
    }

    public void setSwachBharatCess(String str) {
        this.swachBharatCess = str;
    }

    public String getSeatType() {
        return this.seatType;
    }

    public void setSeatType(String str) {
        this.seatType = str;
    }

    public String getMovieImageUrl() {
        return this.movieImageUrl;
    }

    public void setMovieImageUrl(String str) {
        this.movieImageUrl = str;
    }

    public String getConvFee() {
        return this.convFee;
    }

    public void setConvFee(String str) {
        this.convFee = str;
    }

    public String getUniqueBookingId() {
        return this.uniqueBookingId;
    }

    public void setUniqueBookingId(String str) {
        this.uniqueBookingId = str;
    }

    public String getSeatIdsReturned() {
        return this.seatIdsReturned;
    }

    public void setSeatIdsReturned(String str) {
        this.seatIdsReturned = str;
    }

    public String getBranchCode() {
        return this.branchCode;
    }

    public void setBranchCode(String str) {
        this.branchCode = str;
    }

    public String getBookingIndex() {
        return this.bookingIndex;
    }

    public void setBookingIndex(String str) {
        this.bookingIndex = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getStringAddress() {
        Object obj = this.address;
        if (obj == null || obj.toString() == null) {
            return null;
        }
        return this.address.toString();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public Boolean getMultipleEticketSelected() {
        return this.multipleEticketSelected;
    }

    public void setMultipleEticketSelected(Boolean bool) {
        this.multipleEticketSelected = bool;
    }

    public String getTotalSwachBharatCess() {
        return this.totalSwachBharatCess;
    }

    public void setTotalSwachBharatCess(String str) {
        this.totalSwachBharatCess = str;
    }

    public String getTransId() {
        return this.transId;
    }

    public void setTransId(String str) {
        this.transId = str;
    }

    public String getScreenNum() {
        return this.screenNum;
    }

    public void setScreenNum(String str) {
        this.screenNum = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getMovie() {
        return this.movie;
    }

    public void setMovie(String str) {
        this.movie = str;
    }

    public String getCinema() {
        return this.cinema;
    }

    public void setCinema(String str) {
        this.cinema = str;
    }

    public String getShowTime() {
        return this.showTime;
    }

    public void setShowTime(String str) {
        this.showTime = str;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    public void setTicketCount(int i2) {
        this.ticketCount = i2;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(String str) {
        this.providerId = str;
    }

    public String getCinemaId() {
        return this.cinemaId;
    }

    public void setCinemaId(String str) {
        this.cinemaId = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getTotalPgCharges() {
        return this.totalPgCharges;
    }

    public HashMap<String, String> getTaxInfo() {
        return this.taxInfo;
    }

    public Bitmap getMoviePosterImg() {
        return this.moviePosterImg;
    }

    public void setMoviePosterImg(Bitmap bitmap) {
        this.moviePosterImg = bitmap;
    }

    public CJRSummaryFoodBeveragesResponse getFoodAndBeverages() {
        return this.foodAndBeverages;
    }

    public void setFoodAndBeverages(CJRSummaryFoodBeveragesResponse cJRSummaryFoodBeveragesResponse) {
        this.foodAndBeverages = cJRSummaryFoodBeveragesResponse;
    }

    public int getIsInsurancePresent() {
        return this.isInsurancePresent;
    }

    public int getIsInsuranceLive() {
        return this.isInsuranceLive;
    }

    public CJRMovieICancelProtectModel getInsurance() {
        return this.insurance;
    }

    public int isPostFBPresent() {
        return this.isPostFBPresent;
    }

    public void setPostFBPresent(int i2) {
        this.isPostFBPresent = i2;
    }

    public String getPostFBCutoff() {
        return this.postFBCutoff;
    }

    public void setPostFBCutoff(String str) {
        this.postFBCutoff = str;
    }

    public String getPostFBUrl() {
        return this.postFBUrl;
    }

    public void setPostFBUrl(String str) {
        this.postFBUrl = str;
    }

    public int getPostFBOrder() {
        return this.postFBOrder;
    }

    public void setPostFBOrder(int i2) {
        this.postFBOrder = i2;
    }

    public String getParent_order_id() {
        return this.parent_order_id;
    }

    public void setParent_order_id(String str) {
        this.parent_order_id = str;
    }

    public String getScreenFormat() {
        return this.screenFormat;
    }
}
