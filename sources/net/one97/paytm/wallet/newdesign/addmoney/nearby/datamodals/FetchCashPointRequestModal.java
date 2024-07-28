package net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals;

import java.util.HashMap;
import java.util.List;

public class FetchCashPointRequestModal {
    public static final String CATEGORY = "CATEGORY";
    public static final double DISTANCE = 10.0d;
    public static final String IP_ADDRESS = "127.0.0.1";
    public static final String NEARBY_FILTER_SERVICE_ADD_CASH = "CASH_POINT";
    public static final String NEARBY_FILTER_SERVICE_PAY_WITH_PAYTM = "PAYMENT_POINT";
    public static final String NEARBY_FILTER_SERVICE_UPGRADE_ACCOUNT = "KYC_POINT";
    public static final String NERBY_FILTER_SERVICES = "CASH_POINT|PAYMENT_POINT|KYC_POINT";
    public static final int PAGING_LIMIT = 20;
    public static String PLATFORM_NAME = "PayTM";
    public static final String SERVICE = "SERVICE";
    public static final String SUBCATEGORY = "SUBCATEGORY";
    public static final String TIME = "TIME";
    public static final String TYPE = "TYPE";
    public String channel = "";
    public String ipAddress = "127.0.0.1";
    public String platformName = PLATFORM_NAME;
    public Request request;
    public String version = "";

    public enum FilterType {
        CASH_POINT,
        PAYMENT_POINT,
        KYC_POINT
    }

    public enum SortByFilter {
        DISTANCE_WISE_SORT,
        OPENING_TIME_SORT,
        CLOSING_TIME_SORT
    }

    public enum SortingType {
        ASC,
        DESC
    }

    public class Request {
        public Double distance = Double.valueOf(10.0d);
        public Integer endLimit;
        public String latitude;
        public String longitude;
        public List<SearchFilter> searchFilter;
        public HashMap<String, String> sortBy;
        public Integer startLimit;

        public Request() {
        }
    }

    public class SearchFilter {
        public String filterType;
        public String value;

        public SearchFilter() {
        }
    }
}
