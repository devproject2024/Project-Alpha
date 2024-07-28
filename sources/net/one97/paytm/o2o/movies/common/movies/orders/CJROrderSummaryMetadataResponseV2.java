package net.one97.paytm.o2o.movies.common.movies.orders;

import android.graphics.Bitmap;
import com.google.gsonhtcfix.a.b;
import java.util.LinkedHashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieICancelProtectModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodBeveragesResponse;
import net.one97.paytm.common.entity.shopping.CJRMovieSummaryGallery;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRSummaryFoodVoucherResponse;
import net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig;

public class CJROrderSummaryMetadataResponseV2 implements IJRDataModel {
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
    @b(a = "food_voucher")
    private CJRSummaryFoodVoucherResponse foodVoucher;
    @b(a = "freeSeating")
    private boolean freeSeating;
    @b(a = "insurance")
    private CJRMovieICancelProtectModel insurance;
    @b(a = "insurance_config")
    private CJRInsuranceConfig insuranceConfig;
    @b(a = "isCancellationAllowed")
    private int isCancellationAllowed;
    @b(a = "isInsuranceLive")
    private int isInsuranceLive;
    @b(a = "isInsurancePresentV2")
    private int isInsurancePresentV2;
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
    @b(a = "pkey")
    private String pKey;
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
    @b(a = "stype")
    private String stype;
    @b(a = "summary_gallery")
    private CJRMovieSummaryGallery summaryGallery;
    @b(a = "swachBharatCess")
    private String swachBharatCess;
    @b(a = "taxInfo")
    private LinkedHashMap<String, String> taxInfo;
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

    public String getpKey() {
        return this.pKey;
    }

    public void setpKey(String str) {
        this.pKey = str;
    }

    public String getAudi() {
        return this.audi;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public String getScreenFormat() {
        return this.screenFormat;
    }

    public String getCitySearched() {
        return this.citySearched;
    }

    public String getTotalCommision() {
        return this.totalCommision;
    }

    public double getTotalTicketPrice() {
        return this.totalTicketPrice;
    }

    public String getCensor() {
        return this.censor;
    }

    public String getSeatType() {
        return this.seatType;
    }

    public String getMovieImageUrl() {
        return this.movieImageUrl;
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

    public String getBranchCode() {
        return this.branchCode;
    }

    public String getBookingIndex() {
        return this.bookingIndex;
    }

    public String getSource() {
        return this.source;
    }

    public String getStringAddress() {
        Object obj = this.address;
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMovie() {
        return this.movie;
    }

    public String getCinema() {
        return this.cinema;
    }

    public String getShowTime() {
        return this.showTime;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    public String getProviderId() {
        return this.providerId;
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

    public String getCinemaId() {
        return this.cinemaId;
    }

    public boolean isFreeSeating() {
        return this.freeSeating;
    }

    public String getCircleName() {
        return this.circleName;
    }

    public LinkedHashMap<String, String> getTaxInfo() {
        return this.taxInfo;
    }

    public CJRSummaryFoodBeveragesResponse getFoodAndBeverages() {
        return this.foodAndBeverages;
    }

    public CJRSummaryFoodVoucherResponse getFoodVoucher() {
        return this.foodVoucher;
    }

    public int getIsInsurancePresentV2() {
        return this.isInsurancePresentV2;
    }

    public CJRMovieICancelProtectModel getInsurance() {
        return this.insurance;
    }

    public String getPostFBCutoff() {
        return this.postFBCutoff;
    }

    public String getPostFBUrl() {
        return this.postFBUrl;
    }

    public int getPostFBOrder() {
        return this.postFBOrder;
    }

    public String getParent_order_id() {
        return this.parent_order_id;
    }

    public String getMovieCode() {
        return this.movieCode;
    }

    public CJRMovieSummaryGallery getSummaryGallery() {
        return this.summaryGallery;
    }

    public String getPaytmCityName() {
        return this.paytmCityName;
    }

    public CJRInsuranceConfig getInsuranceConfig() {
        return this.insuranceConfig;
    }

    public int getIsCancellationAllowed() {
        return this.isCancellationAllowed;
    }

    public String getStype() {
        return this.stype;
    }

    public int getIsPostFBPresent() {
        return this.isPostFBPresent;
    }
}
