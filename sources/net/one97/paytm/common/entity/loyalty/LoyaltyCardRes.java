package net.one97.paytm.common.entity.loyalty;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class LoyaltyCardRes extends IJRPaytmDataModel implements IJRDataModel {
    private Customer customer;
    private String error;
    private String message;
    private int status;

    public String getMessage() {
        return this.message;
    }

    public String getError() {
        return this.error;
    }

    public int getStatus() {
        return this.status;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer2) {
        this.customer = customer2;
    }

    public class Customer {
        private String phoneNumber;
        private ArrayList<RegisteredBrands> registeredBrands;

        public Customer() {
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public ArrayList<RegisteredBrands> getRegisteredBrands() {
            return this.registeredBrands;
        }
    }

    public class RegisteredBrands {
        private String activeLoyaltyPoints;
        private String brandActive;
        private String brandCardURL;
        private String brandId;
        private String brandLogoUrl;
        private String brandName;
        private String canBeEnrolled;
        private String customerCategory;
        private String defaultLogoUrl;
        private String loyaltyPointsBurnLogic;
        private String minBurnPoints;
        private String termsAndConditions;

        public RegisteredBrands() {
        }

        public String getBrandLogoUrl() {
            return this.brandLogoUrl;
        }

        public String getBrandActive() {
            return this.brandActive;
        }

        public String getCanBeEnrolled() {
            return this.canBeEnrolled;
        }

        public String getCustomerCategory() {
            return this.customerCategory;
        }

        public String getMinBurnPoints() {
            return this.minBurnPoints;
        }

        public String getDefaultLogoUrl() {
            return this.defaultLogoUrl;
        }

        public String getActiveLoyaltyPoints() {
            return this.activeLoyaltyPoints;
        }

        public String getTermsAndConditions() {
            return this.termsAndConditions;
        }

        public String getBrandName() {
            return this.brandName;
        }

        public String getBrandId() {
            return this.brandId;
        }

        public String getLoyaltyPointsBurnLogic() {
            return this.loyaltyPointsBurnLogic;
        }

        public String getBrandCardURL() {
            return this.brandCardURL;
        }
    }
}
