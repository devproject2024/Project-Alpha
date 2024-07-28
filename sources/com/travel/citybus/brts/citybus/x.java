package com.travel.citybus.brts.citybus;

import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestRecentResponse;
import com.travel.citybus.best.model.BestToken;
import com.travel.citybus.brts.model.CJRAmountPax;
import com.travel.citybus.brts.model.pojo.CJRCity;
import java.util.List;

public interface x {

    public interface a {
        void ePurseDetailsMissing();

        void launchCityBusRouteActivity(BestEPurse bestEPurse);

        void lottieLayoutGone();

        void setBCLLData(CJRAmountPax.CJRBCLLResponse cJRBCLLResponse);

        void setCityListForBottomSheet(List<CJRCity> list);

        void showActiveTicket(BestToken bestToken);

        void showActiveToken(BestToken bestToken);

        void showBothCityMissingAlert();

        void showDestinationCityMissingAlert();

        void showEPurseData(BestEPurse bestEPurse);

        void showError(String str);

        void showInternetIssue(boolean z);

        void showMerchantName(String str);

        void showRecentBookedTickets(BestRecentResponse bestRecentResponse);

        void showSourceCityMissingAlert();
    }
}
