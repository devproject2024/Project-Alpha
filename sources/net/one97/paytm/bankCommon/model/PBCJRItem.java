package net.one97.paytm.bankCommon.model;

import net.one97.paytm.common.entity.IJRDataModel;

public abstract class PBCJRItem extends PBCJRDataModelItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String autoSuggestMetaData;
    private boolean isTrainRoundTrip;
    private String mTrainDepartureDate;
    private String mTrainDestinationCity;
    private String mTrainDestinationCityName;
    private String mTrainSourceCity;
    private String mTrainSourceCityName;

    public abstract String getBrand();

    public abstract String getCategoryId();

    public abstract String getItemID();

    public abstract String getLabel();

    public abstract String getListId();

    public abstract String getListName();

    public abstract int getListPosition();

    public abstract String getName();

    public abstract String getParentID();

    public abstract String getSearchABValue();

    public abstract String getSearchCategory();

    public abstract String getSearchResultType();

    public abstract String getSearchTerm();

    public abstract String getSearchType();

    public abstract String getSource();

    public abstract String getURL();

    public abstract String getURLType();

    public abstract String getmContainerInstanceID();

    public void setUrl(String str) {
    }

    public String getTrainSourceCityCode() {
        return this.mTrainSourceCity;
    }

    public void setTrainSourceCityCode(String str) {
        this.mTrainSourceCity = str;
    }

    public String getTrainDestinationCityCode() {
        return this.mTrainDestinationCity;
    }

    public void setTrainDestinationCityCode(String str) {
        this.mTrainDestinationCity = str;
    }

    public String getTrainDepartureDate() {
        return this.mTrainDepartureDate;
    }

    public void setTrainDepartureDate(String str) {
        this.mTrainDepartureDate = str;
    }

    public String getTrainSourceCityName() {
        return this.mTrainSourceCityName;
    }

    public void setTrainSourceCityName(String str) {
        this.mTrainSourceCityName = str;
    }

    public String getTrainDestinationCityName() {
        return this.mTrainDestinationCityName;
    }

    public void setTrainDestinationCityName(String str) {
        this.mTrainDestinationCityName = str;
    }

    public boolean isTrainRoundTrip() {
        return this.isTrainRoundTrip;
    }

    public void setTrainRoundTrip(boolean z) {
        this.isTrainRoundTrip = z;
    }

    public String getAutoSuggestMetaData() {
        return this.autoSuggestMetaData;
    }

    public void setAutoSuggestMetaData(String str) {
        this.autoSuggestMetaData = str;
    }
}
