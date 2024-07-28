package net.one97.paytm.hotel4.service.model;

import com.paytm.network.model.IJRPaytmDataModel;

public final class HotelAutosuggestSearchResponse extends IJRPaytmDataModel {
    private final String requestId = "";
    private final HotelSuggestionDataItem suggestions;

    public final HotelSuggestionDataItem getSuggestions() {
        return this.suggestions;
    }

    public final String getRequestId() {
        return this.requestId;
    }
}
