package net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;

public class PayTMPartnerListModal extends IJRPaytmDataModel {
    public String orderId;
    public String requestGuid;
    public ArrayList<Response> response;
    public String status;
    public String statusCode;
    public String statusMessage;

    public class Response extends CJRItem {
        private static final long serialVersionUID = 1;
        public CashPointDetail cashPointsDetail;
        public String currentCashPointStatus;
        public String dealUrl;
        public Double distanceFromLocation;
        public boolean isFavorite = false;
        public String offerText;

        public String getBrand() {
            return null;
        }

        public String getCategoryId() {
            return null;
        }

        public String getItemID() {
            return null;
        }

        public String getLabel() {
            return null;
        }

        public String getListId() {
            return null;
        }

        public String getListName() {
            return null;
        }

        public int getListPosition() {
            return 0;
        }

        public String getParentID() {
            return null;
        }

        public ArrayList<CJRRelatedCategory> getRelatedCategories() {
            return null;
        }

        public String getSearchABValue() {
            return null;
        }

        public String getSearchCategory() {
            return null;
        }

        public String getSearchResultType() {
            return null;
        }

        public String getSearchTerm() {
            return null;
        }

        public String getSearchType() {
            return null;
        }

        public String getSource() {
            return null;
        }

        public String getmContainerInstanceID() {
            return null;
        }

        public Response() {
        }

        public String getURLType() {
            return b.g(this.dealUrl);
        }

        public String getURL() {
            return this.dealUrl;
        }

        public String getName() {
            return this.offerText;
        }
    }

    public class CashPointDetail implements IJRDataModel {
        public ArrayList<String> address;
        public String businessName;
        public String category = "";
        public String city;
        public ArrayList<String> contactNo;
        public ArrayList<String> contactPerson;
        public String displayName;
        public String editAble;
        public ArrayList<String> emailId;
        public String endTime;
        public String establishmentDate;
        public String fax;
        public String friday;
        public String landMark;
        public Location location;
        public String logoUrl;
        public String monday;
        public String pinCode;
        public String rating;
        public String saturday;
        public String saturdayEndTime;
        public String saturdayStartTime;
        public ArrayList<String> servicesOffered;
        public String startTime;
        public String state;
        public String subCategory = "";
        public String sunday;
        public String terminalId;
        public String terminalType;
        public String thurday;
        public String tuesday;
        public String wednesday;

        public CashPointDetail() {
        }

        public String toString() {
            return "CashPointDetail{terminalId='" + this.terminalId + '\'' + ", terminalType='" + this.terminalType + '\'' + ", businessName='" + this.businessName + '\'' + ", contactPerson=" + this.contactPerson + ", state='" + this.state + '\'' + ", city='" + this.city + '\'' + ", category='" + this.category + '\'' + ", subCategory='" + this.subCategory + '\'' + ", displayName='" + this.displayName + '\'' + ", fax='" + this.fax + '\'' + ", startTime='" + this.startTime + '\'' + ", endTime='" + this.endTime + '\'' + ", saturdayStartTime='" + this.saturdayStartTime + '\'' + ", saturdayEndTime='" + this.saturdayEndTime + '\'' + ", rating='" + this.rating + '\'' + ", monday='" + this.monday + '\'' + ", tuesday='" + this.tuesday + '\'' + ", wednesday='" + this.wednesday + '\'' + ", thurday='" + this.thurday + '\'' + ", friday='" + this.friday + '\'' + ", saturday='" + this.saturday + '\'' + ", sunday='" + this.sunday + '\'' + ", landMark='" + this.landMark + '\'' + ", pinCode='" + this.pinCode + '\'' + ", establishmentDate='" + this.establishmentDate + '\'' + ", logoUrl='" + this.logoUrl + '\'' + ", editAble='" + this.editAble + '\'' + ", address=" + this.address + ", contactNo=" + this.contactNo + ", servicesOffered=" + this.servicesOffered + ", emailId=" + this.emailId + '}';
        }
    }

    public class Location implements IJRDataModel {
        public String lat = "";
        public String lon = "";

        public Location() {
        }
    }

    public String toString() {
        return "PayTMPartnerListModal{requestGuid='" + this.requestGuid + '\'' + ", orderId='" + this.orderId + '\'' + ", status='" + this.status + '\'' + ", statusCode='" + this.statusCode + '\'' + ", statusMessage='" + this.statusMessage + '\'' + ", response=" + this.response + '}';
    }
}
