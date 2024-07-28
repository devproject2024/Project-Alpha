package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.utils.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.hotel4.service.a.g;
import net.one97.paytm.hotel4.service.model.HotelAutosuggestSearchResponse;
import net.one97.paytm.hotel4.service.model.HotelPopularSearchResponse;
import net.one97.paytm.hotel4.service.model.PopularRecentDataItem;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.hotels2.utils.e;

public final class HotelSearchViewModel extends ai {
    private y<HotelAutosuggestSearchResponse> autosuggestApiCallFailure = new y<>();
    private y<HotelAutosuggestSearchResponse> autosuggestApiCallSuccess = new y<>();
    private final l<Boolean> backClicked = new l<>();
    private l<Boolean> clearAutoSearch = new l<>();
    private y<String> currentCityName = new y<>();
    private y<String> deepLinkCitySearchText = new y<>();
    private y<Boolean> fetchCurrentLocation = new y<>();
    private l<Boolean> isCrossButtonVisible = new l<>();
    private y<Boolean> isNoresultViewVisible = new y<>();
    private g searchRepo;
    private String searchText = "";
    private l<Boolean> showProgressBar = new l<>();
    private y<Integer> showRecentPopularList = new y<>();
    private y<HotelPopularSearchResponse> trendingApiCallFailure = new y<>();
    private y<List<PopularRecentDataItem>> trendingApiCallSuccess = new y<>();

    public final y<List<PopularRecentDataItem>> getTrendingApiCallSuccess() {
        return this.trendingApiCallSuccess;
    }

    public final void setTrendingApiCallSuccess(y<List<PopularRecentDataItem>> yVar) {
        k.c(yVar, "<set-?>");
        this.trendingApiCallSuccess = yVar;
    }

    public final y<HotelPopularSearchResponse> getTrendingApiCallFailure() {
        return this.trendingApiCallFailure;
    }

    public final void setTrendingApiCallFailure(y<HotelPopularSearchResponse> yVar) {
        k.c(yVar, "<set-?>");
        this.trendingApiCallFailure = yVar;
    }

    public final y<HotelAutosuggestSearchResponse> getAutosuggestApiCallSuccess() {
        return this.autosuggestApiCallSuccess;
    }

    public final void setAutosuggestApiCallSuccess(y<HotelAutosuggestSearchResponse> yVar) {
        k.c(yVar, "<set-?>");
        this.autosuggestApiCallSuccess = yVar;
    }

    public final y<HotelAutosuggestSearchResponse> getAutosuggestApiCallFailure() {
        return this.autosuggestApiCallFailure;
    }

    public final void setAutosuggestApiCallFailure(y<HotelAutosuggestSearchResponse> yVar) {
        k.c(yVar, "<set-?>");
        this.autosuggestApiCallFailure = yVar;
    }

    public final y<Integer> getShowRecentPopularList() {
        return this.showRecentPopularList;
    }

    public final void setShowRecentPopularList(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.showRecentPopularList = yVar;
    }

    public final y<Boolean> getFetchCurrentLocation() {
        return this.fetchCurrentLocation;
    }

    public final void setFetchCurrentLocation(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.fetchCurrentLocation = yVar;
    }

    public final l<Boolean> getBackClicked() {
        return this.backClicked;
    }

    public final y<String> getCurrentCityName() {
        return this.currentCityName;
    }

    public final void setCurrentCityName(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.currentCityName = yVar;
    }

    public final l<Boolean> getShowProgressBar() {
        return this.showProgressBar;
    }

    public final void setShowProgressBar(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.showProgressBar = lVar;
    }

    public final g getSearchRepo() {
        return this.searchRepo;
    }

    public final void setSearchRepo(g gVar) {
        this.searchRepo = gVar;
    }

    public final String getSearchText() {
        return this.searchText;
    }

    public final void setSearchText(String str) {
        this.searchText = str;
    }

    public final l<Boolean> isCrossButtonVisible() {
        return this.isCrossButtonVisible;
    }

    public final void setCrossButtonVisible(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.isCrossButtonVisible = lVar;
    }

    public final l<Boolean> getClearAutoSearch() {
        return this.clearAutoSearch;
    }

    public final void setClearAutoSearch(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.clearAutoSearch = lVar;
    }

    public final y<Boolean> isNoresultViewVisible() {
        return this.isNoresultViewVisible;
    }

    public final void setNoresultViewVisible(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.isNoresultViewVisible = yVar;
    }

    public final y<String> getDeepLinkCitySearchText() {
        return this.deepLinkCitySearchText;
    }

    public final void setDeepLinkCitySearchText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.deepLinkCitySearchText = yVar;
    }

    public final void initPopularSearchRepository(g gVar) {
        k.c(gVar, "repo");
        this.searchRepo = gVar;
    }

    public final void backPressed() {
        this.backClicked.postValue(Boolean.TRUE);
    }

    public final void fetchTrendingSearchData() {
        ApiListener apiListener = new ApiListener();
        g gVar = this.searchRepo;
        if (gVar != null) {
            String trendingApiUrl = getTrendingApiUrl();
            b bVar = apiListener;
            k.c(trendingApiUrl, "url");
            k.c(bVar, "listener");
            a l = new com.paytm.network.b().a((Context) gVar.f28629a).a(a.b.SILENT).c("Hotel-trendingsearch").a(a.c.HOTELS).a(a.C0715a.GET).a(trendingApiUrl).h().a((Map<String, String>) new HashMap()).b((Map) null).b((String) null).a((IJRPaytmDataModel) new HotelPopularSearchResponse()).a(bVar).a(true).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a();
        }
    }

    public final void getCurrentLocation() {
        this.fetchCurrentLocation.postValue(Boolean.TRUE);
    }

    public final void onSearchTextChanged(CharSequence charSequence) {
        k.c(charSequence, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        this.searchText = charSequence.toString();
        this.isCrossButtonVisible.setValue(Boolean.valueOf(!TextUtils.isEmpty(this.searchText)));
        if (charSequence.length() >= 3) {
            ApiListener apiListener = new ApiListener();
            this.showProgressBar.setValue(Boolean.TRUE);
            g gVar = this.searchRepo;
            if (gVar != null) {
                String obj = charSequence.toString();
                b bVar = apiListener;
                k.c(obj, "searchText");
                k.c(bVar, "listener");
                StringBuilder sb = new StringBuilder();
                k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
                sb.append(e.m());
                sb.append(obj);
                sb.append("?");
                String sb2 = sb.toString();
                HashMap hashMap = new HashMap();
                String a2 = c.b().a((Context) gVar.f28629a);
                if (a2 == null) {
                    gVar.f28630b = "";
                } else {
                    gVar.f28630b = a2;
                }
                String str = gVar.f28630b;
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(AppConstants.SSO_TOKEN, str);
                }
                a l = new com.paytm.network.b().a((Context) gVar.f28629a).a(a.b.SILENT).c("Hotel-autosuggestsearch").a(a.c.FLIGHT).a(a.C0715a.GET).a(sb2).h().a((Map<String, String>) hashMap).b((Map) null).b((String) null).a((IJRPaytmDataModel) new HotelAutosuggestSearchResponse()).a(bVar).a(true).l();
                k.a((Object) l, "networking");
                l.a(true);
                l.a();
            }
            this.showRecentPopularList.postValue(8);
            return;
        }
        this.showRecentPopularList.postValue(0);
    }

    public final class ApiListener implements b {
        public ApiListener() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
            if ((!((java.util.Collection) r1).isEmpty()) != false) goto L_0x005d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof net.one97.paytm.hotel4.service.model.HotelAutosuggestSearchResponse
                r1 = 0
                if (r0 == 0) goto L_0x009e
                r0 = r4
                net.one97.paytm.hotel4.service.model.HotelAutosuggestSearchResponse r0 = (net.one97.paytm.hotel4.service.model.HotelAutosuggestSearchResponse) r0
                net.one97.paytm.hotel4.service.model.HotelSuggestionDataItem r2 = r0.getSuggestions()
                if (r2 == 0) goto L_0x0069
                net.one97.paytm.hotel4.service.model.HotelSuggestionDataItem r2 = r0.getSuggestions()
                if (r2 == 0) goto L_0x0019
                java.util.List r2 = r2.getCity()
                goto L_0x001a
            L_0x0019:
                r2 = r1
            L_0x001a:
                if (r2 != 0) goto L_0x001f
                kotlin.g.b.k.a()
            L_0x001f:
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ 1
                if (r2 != 0) goto L_0x005d
                net.one97.paytm.hotel4.service.model.HotelSuggestionDataItem r2 = r0.getSuggestions()
                if (r2 == 0) goto L_0x0034
                java.util.List r2 = r2.getLocalities()
                goto L_0x0035
            L_0x0034:
                r2 = r1
            L_0x0035:
                if (r2 != 0) goto L_0x003a
                kotlin.g.b.k.a()
            L_0x003a:
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ 1
                if (r2 != 0) goto L_0x005d
                net.one97.paytm.hotel4.service.model.HotelSuggestionDataItem r0 = r0.getSuggestions()
                if (r0 == 0) goto L_0x004e
                java.util.List r1 = r0.getHotels()
            L_0x004e:
                if (r1 != 0) goto L_0x0053
                kotlin.g.b.k.a()
            L_0x0053:
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r0 = r1.isEmpty()
                r0 = r0 ^ 1
                if (r0 == 0) goto L_0x0069
            L_0x005d:
                net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r0 = net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.this
                androidx.lifecycle.y r0 = r0.isNoresultViewVisible()
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                r0.setValue(r1)
                goto L_0x0094
            L_0x0069:
                net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r0 = net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.this
                java.lang.String r0 = r0.getSearchText()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0094
                net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r0 = net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.this
                java.lang.String r0 = r0.getSearchText()
                if (r0 != 0) goto L_0x0082
                kotlin.g.b.k.a()
            L_0x0082:
                int r0 = r0.length()
                r1 = 3
                if (r0 <= r1) goto L_0x0094
                net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r0 = net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.this
                androidx.lifecycle.y r0 = r0.isNoresultViewVisible()
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.setValue(r1)
            L_0x0094:
                net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r0 = net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.this
                androidx.lifecycle.y r0 = r0.getAutosuggestApiCallSuccess()
                r0.postValue(r4)
                goto L_0x00c9
            L_0x009e:
                boolean r0 = r4 instanceof net.one97.paytm.hotel4.service.model.HotelPopularSearchResponse
                if (r0 == 0) goto L_0x00c9
                net.one97.paytm.hotel4.service.model.HotelPopularSearchResponse r4 = (net.one97.paytm.hotel4.service.model.HotelPopularSearchResponse) r4
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r2 = "hotelTrendingSearchResponse "
                r0.<init>(r2)
                java.util.List r2 = r4.getData()
                if (r2 == 0) goto L_0x00b9
                int r1 = r2.size()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            L_0x00b9:
                r0.append(r1)
                net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r0 = net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.this
                androidx.lifecycle.y r0 = r0.getTrendingApiCallSuccess()
                java.util.List r4 = r4.getData()
                r0.postValue(r4)
            L_0x00c9:
                net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r4 = net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.this
                com.travel.utils.l r4 = r4.getShowProgressBar()
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                r4.setValue(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel.ApiListener.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof HotelPopularSearchResponse) {
                HotelSearchViewModel.this.getTrendingApiCallFailure().postValue((HotelPopularSearchResponse) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof HotelAutosuggestSearchResponse) {
                HotelSearchViewModel.this.getAutosuggestApiCallFailure().postValue((HotelAutosuggestSearchResponse) iJRPaytmDataModel);
            }
            HotelSearchViewModel.this.getShowProgressBar().setValue(Boolean.FALSE);
        }
    }

    private final String getTrendingApiUrl() {
        k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
        Uri.Builder buildUpon = Uri.parse(e.l()).buildUpon();
        buildUpon.appendQueryParameter("city", "All Cities");
        buildUpon.appendQueryParameter(H5Param.PAGE, "global");
        buildUpon.appendQueryParameter(AddEditGstinViewModelKt.BODY_PARAM_COUNTRY, "Domestic");
        String uri = buildUpon.build().toString();
        k.a((Object) uri, "uriBuilder.build().toString()");
        return uri;
    }

    public final void clearAllClick() {
        onSearchTextChanged("");
        this.isCrossButtonVisible.setValue(Boolean.FALSE);
        this.isNoresultViewVisible.setValue(Boolean.FALSE);
        this.clearAutoSearch.setValue(Boolean.TRUE);
    }

    public final String getNoSearchResultURL() {
        return f.c("lookingformorehotels");
    }
}
