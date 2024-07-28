package com.travel.train.helper;

import android.text.TextUtils;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsMeta;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;

public final class b {
    public static CJRTrainSearchResults a(CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel) {
        CJRTrainSearchResults cJRTrainSearchResults = new CJRTrainSearchResults();
        CJRTrainSearchResultsBody cJRTrainSearchResultsBody = new CJRTrainSearchResultsBody();
        if (!(cJRSearchByTrainNumberModel == null || cJRSearchByTrainNumberModel.getBody() == null || cJRSearchByTrainNumberModel.getBody().getTrainDetails() == null || cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation() == null || cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation() == null || cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses() == null || cJRSearchByTrainNumberModel.getMeta() == null)) {
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = new CJRTrainSearchResultsTrain();
            String b2 = com.paytm.utility.b.b(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getDepartureDate(), "yyyymmdd", "yyyy-mm-dd");
            String b3 = com.paytm.utility.b.b(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getArrivalDate(), "yyyymmdd", "yyyy-mm-dd");
            if (TextUtils.isEmpty(b2)) {
                b2 = cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getDepartureDate();
            }
            cJRTrainSearchResultsTrain.setDeparture(b2);
            if (TextUtils.isEmpty(b3)) {
                b3 = cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getArrivalDate();
            }
            cJRTrainSearchResultsTrain.setArrival(b3);
            cJRTrainSearchResultsTrain.setTrainName(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getTrainName());
            cJRTrainSearchResultsTrain.setTrainNumber(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getTrainNumber());
            cJRTrainSearchResultsTrain.setSource(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getStationCode());
            cJRTrainSearchResultsTrain.setDestination(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getStationCode());
            cJRTrainSearchResultsTrain.setClasses(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getJourneyClasses());
            cJRTrainSearchResultsTrain.setBoardingStation(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getStationName());
            cJRTrainSearchResultsTrain.setRunsOn(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getRunningOn());
            cJRTrainSearchResultsTrain.setTrainType(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getTrainType());
            cJRTrainSearchResultsTrain.setDuration(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getDuration());
            cJRTrainSearchResultsTrain.setSourceName(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getStationName());
            cJRTrainSearchResultsTrain.setDestinationName(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getStationName());
            cJRTrainSearchResultsTrain.setMSearchedTrainDepartureTime(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getDepartureTime());
            cJRTrainSearchResultsTrain.setMSearchedTrainArrivalTime(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getArrivalTime());
            cJRTrainSearchResultsTrain.setDepartureTime(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getDepartureTime());
            cJRTrainSearchResultsTrain.setArrivalTime(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getArrivalTime());
            cJRTrainSearchResultsTrain.setQuota(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getQuota().get(0));
            cJRTrainSearchResultsTrain.setTrainClass(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getJourneyClasses().get(0));
            cJRTrainSearchResultsTrain.setSearchByTrainResult(true);
            if (cJRSearchByTrainNumberModel.getBody().getTrainDetails().getDynamicPricingMessage() != null) {
                cJRTrainSearchResultsTrain.setDynamicPricingEnable(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getDynamicPricingMessage().getEnabled().booleanValue());
                cJRTrainSearchResultsTrain.setDynamicPricingMessage(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getDynamicPricingMessage().getMessage_text());
            }
            for (int i2 = 0; i2 < cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().size(); i2++) {
                String quota = cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getQuota();
                CJRTrainSearchResultsAvailibiltyObject cJRTrainSearchResultsAvailibiltyObject = new CJRTrainSearchResultsAvailibiltyObject();
                cJRTrainSearchResultsAvailibiltyObject.setClassType(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getClassType());
                cJRTrainSearchResultsAvailibiltyObject.setClassName(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getClassName());
                if (!TextUtils.isEmpty(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getText_colour())) {
                    cJRTrainSearchResultsAvailibiltyObject.setTxtColour(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getText_colour());
                    cJRTrainSearchResultsAvailibiltyObject.setBackgroundColour(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getBackground_colour());
                } else {
                    cJRTrainSearchResultsAvailibiltyObject.setColour(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getColour());
                }
                cJRTrainSearchResultsAvailibiltyObject.setBackgroundColour(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getBackground_colour());
                cJRTrainSearchResultsAvailibiltyObject.setFare(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getFare());
                if (quota == null) {
                    quota = cJRTrainSearchResultsTrain.getQuota();
                }
                cJRTrainSearchResultsAvailibiltyObject.setQuota(quota);
                cJRTrainSearchResultsAvailibiltyObject.setStatus(cJRSearchByTrainNumberModel.getBody().getSearchedDateClasses().get(i2).getStatus());
                cJRTrainSearchResultsTrain.getMAvailability().add(cJRTrainSearchResultsAvailibiltyObject);
            }
            cJRTrainSearchResultsBody.getTrains().add(cJRTrainSearchResultsTrain);
            cJRTrainSearchResultsBody.setQuota(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getQuota());
            cJRTrainSearchResults.setBody(cJRTrainSearchResultsBody);
            CJRTrainSearchResultsMeta cJRTrainSearchResultsMeta = new CJRTrainSearchResultsMeta();
            cJRTrainSearchResultsMeta.setClasses(cJRSearchByTrainNumberModel.getMeta().getClassesMeta());
            cJRTrainSearchResultsMeta.setQuota(cJRSearchByTrainNumberModel.getMeta().getQuotaMeta());
            cJRTrainSearchResultsMeta.setRequestid(cJRSearchByTrainNumberModel.getMeta().getRequestid());
            cJRTrainSearchResults.setMeta(cJRTrainSearchResultsMeta);
            cJRTrainSearchResults.setError(cJRSearchByTrainNumberModel.getError());
            cJRTrainSearchResults.setCode(Integer.valueOf(cJRSearchByTrainNumberModel.getCode()));
        }
        return cJRTrainSearchResults;
    }
}
