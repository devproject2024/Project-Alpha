package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.travel.utils.l;
import com.travel.utils.s;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.hotel4.service.a.f;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.datamodel.search.Locations;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SearchParams;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.hotels2.utils.e;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SRPViewModel extends BaseViewModel {
    private String TAG_LOG = "SRPViewModel";
    private final l<ErrorData> apiCallFailure = new l<>();
    private final l<HotelSearchResponse> apiCallSuccess = new l<>();
    private boolean fetchingData;
    private y<Integer> filterCount = new y<>();
    private y<Integer> hotelCount = new y<>();
    private y<Boolean> isBottonSortFilterVisible = new y<>();
    private y<Boolean> isHotelSoldOut = new y<>();
    private l<Boolean> isHotelSoldOutMessageVisible = new l<>();
    private int lastTotalItemCount;
    private final y<SRPDataItem> selectedData = new y<>();
    private l<String> selectedLocation = new l<>();
    private l<String> soldOutHotelName = new l<>();
    private l<String> soldOutImageUrl = new l<>();
    private l<String> soldOutLocality = new l<>();
    private y<String> sortSelectedName = new y<>();
    private final y<HotelSearchResponse> srpData = new y<>();
    private l<Boolean> srpErrorVisibility = new l<>();
    private l<Boolean> srpFilterNoResultVisibility = new l<>();
    private l<Boolean> srpFilterSingleResultVisibility = new l<>();
    private l<Boolean> srpNoResultVisibility = new l<>();
    private f srpRepo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SRPViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final String getTAG_LOG() {
        return this.TAG_LOG;
    }

    public final void setTAG_LOG(String str) {
        k.c(str, "<set-?>");
        this.TAG_LOG = str;
    }

    public final f getSrpRepo() {
        return this.srpRepo;
    }

    public final void setSrpRepo(f fVar) {
        this.srpRepo = fVar;
    }

    public final l<HotelSearchResponse> getApiCallSuccess() {
        return this.apiCallSuccess;
    }

    public final l<ErrorData> getApiCallFailure() {
        return this.apiCallFailure;
    }

    public final y<Integer> getHotelCount() {
        return this.hotelCount;
    }

    public final void setHotelCount(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.hotelCount = yVar;
    }

    public final y<String> getSortSelectedName() {
        return this.sortSelectedName;
    }

    public final void setSortSelectedName(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.sortSelectedName = yVar;
    }

    public final y<Boolean> isHotelSoldOut() {
        return this.isHotelSoldOut;
    }

    public final void setHotelSoldOut(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.isHotelSoldOut = yVar;
    }

    public final l<Boolean> isHotelSoldOutMessageVisible() {
        return this.isHotelSoldOutMessageVisible;
    }

    public final void setHotelSoldOutMessageVisible(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.isHotelSoldOutMessageVisible = lVar;
    }

    public final l<String> getSoldOutHotelName() {
        return this.soldOutHotelName;
    }

    public final void setSoldOutHotelName(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.soldOutHotelName = lVar;
    }

    public final l<String> getSoldOutImageUrl() {
        return this.soldOutImageUrl;
    }

    public final void setSoldOutImageUrl(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.soldOutImageUrl = lVar;
    }

    public final l<String> getSoldOutLocality() {
        return this.soldOutLocality;
    }

    public final void setSoldOutLocality(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.soldOutLocality = lVar;
    }

    public final y<Integer> getFilterCount() {
        return this.filterCount;
    }

    public final void setFilterCount(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.filterCount = yVar;
    }

    public final y<Boolean> isBottonSortFilterVisible() {
        return this.isBottonSortFilterVisible;
    }

    public final void setBottonSortFilterVisible(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.isBottonSortFilterVisible = yVar;
    }

    public final y<HotelSearchResponse> getSrpData() {
        return this.srpData;
    }

    public final y<SRPDataItem> getSelectedData() {
        return this.selectedData;
    }

    public final boolean getFetchingData() {
        return this.fetchingData;
    }

    public final void setFetchingData(boolean z) {
        this.fetchingData = z;
    }

    public final int getLastTotalItemCount() {
        return this.lastTotalItemCount;
    }

    public final void setLastTotalItemCount(int i2) {
        this.lastTotalItemCount = i2;
    }

    public final l<Boolean> getSrpNoResultVisibility() {
        return this.srpNoResultVisibility;
    }

    public final void setSrpNoResultVisibility(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.srpNoResultVisibility = lVar;
    }

    public final l<Boolean> getSrpFilterNoResultVisibility() {
        return this.srpFilterNoResultVisibility;
    }

    public final void setSrpFilterNoResultVisibility(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.srpFilterNoResultVisibility = lVar;
    }

    public final l<Boolean> getSrpFilterSingleResultVisibility() {
        return this.srpFilterSingleResultVisibility;
    }

    public final void setSrpFilterSingleResultVisibility(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.srpFilterSingleResultVisibility = lVar;
    }

    public final l<Boolean> getSrpErrorVisibility() {
        return this.srpErrorVisibility;
    }

    public final void setSrpErrorVisibility(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.srpErrorVisibility = lVar;
    }

    public final l<String> getSelectedLocation() {
        return this.selectedLocation;
    }

    public final void setSelectedLocation(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.selectedLocation = lVar;
    }

    public final void initSrpRepository(f fVar) {
        k.c(fVar, "repo");
        this.srpRepo = fVar;
        this.isHotelSoldOut.setValue(Boolean.FALSE);
    }

    public final void onSuccess(String str, HotelSearchResponse hotelSearchResponse) {
        k.c(str, "from");
        this.fetchingData = false;
        this.srpErrorVisibility.setValue(Boolean.FALSE);
        Integer num = null;
        if ((hotelSearchResponse != null ? hotelSearchResponse.getData() : null) == null || !(!hotelSearchResponse.getData().isEmpty())) {
            this.isBottonSortFilterVisible.setValue(Boolean.FALSE);
            this.srpFilterNoResultVisibility.setValue(Boolean.valueOf(getParent().isFromFilterAvailableApiCall()));
            this.srpFilterSingleResultVisibility.setValue(Boolean.FALSE);
            this.hotelCount.setValue(0);
            sendPulseEventHotelSearchTapped(0);
            this.srpData.postValue(hotelSearchResponse);
            this.srpNoResultVisibility.setValue(Boolean.TRUE);
        } else {
            Extra extra = hotelSearchResponse.getExtra();
            setDateFromResponse(extra != null ? extra.getSearchParams() : null);
            y<HotelSearchResponse> yVar = this.srpData;
            if (hotelSearchResponse == null) {
                k.a();
            }
            yVar.postValue(hotelSearchResponse);
            y<Integer> yVar2 = this.hotelCount;
            Extra extra2 = hotelSearchResponse.getExtra();
            yVar2.setValue(extra2 != null ? Integer.valueOf(extra2.getHotelCount()) : null);
            this.isBottonSortFilterVisible.setValue(Boolean.TRUE);
            Integer value = this.hotelCount.getValue();
            if (value != null && value.intValue() == 1 && getParent().isFromFilterAvailableApiCall()) {
                this.srpNoResultVisibility.setValue(Boolean.TRUE);
                this.srpFilterNoResultVisibility.setValue(Boolean.FALSE);
                this.srpFilterSingleResultVisibility.setValue(Boolean.TRUE);
            } else {
                this.srpNoResultVisibility.setValue(Boolean.FALSE);
                this.srpFilterSingleResultVisibility.setValue(Boolean.FALSE);
                this.srpFilterNoResultVisibility.setValue(Boolean.FALSE);
            }
            this.sortSelectedName.setValue(getSortDisplayString(hotelSearchResponse));
            this.filterCount.setValue(Integer.valueOf(getParent().getAppliedFilterCount()));
            y<Integer> yVar3 = this.hotelCount;
            if (yVar3 != null) {
                num = yVar3.getValue();
            }
            if (num != null) {
                Integer value2 = this.hotelCount.getValue();
                if (value2 == null) {
                    k.a();
                }
                k.a((Object) value2, "hotelCount.value!!");
                sendPulseEventHotelSearchTapped(value2.intValue());
            }
        }
        getParent().postScreenNavigationEvent(str, "2");
    }

    public final void hideSoldOut() {
        this.isHotelSoldOutMessageVisible.postValue(Boolean.FALSE);
    }

    public final void selectedLocationSelected(String str) {
        k.c(str, "selectedLocationDetails");
        this.selectedLocation.postValue(str);
    }

    public final void onPageResponseSuccess(HotelSearchResponse hotelSearchResponse) {
        int i2 = 0;
        this.fetchingData = false;
        HotelSearchResponse value = this.srpData.getValue();
        Integer num = null;
        if (value != null) {
            List<SRPDataItem> data = hotelSearchResponse != null ? hotelSearchResponse.getData() : null;
            if (data != null) {
                List c2 = ab.c(data);
                List<SRPDataItem> data2 = value.getData();
                if (data2 == null) {
                    k.a();
                }
                c2.addAll(0, data2);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem>");
            }
        }
        y<Integer> yVar = this.hotelCount;
        if (hotelSearchResponse != null) {
            Extra extra = hotelSearchResponse.getExtra();
            if (extra != null) {
                i2 = extra.getHotelCount();
            }
            yVar.setValue(num);
            this.srpData.postValue(hotelSearchResponse);
        }
        num = Integer.valueOf(i2);
        yVar.setValue(num);
        this.srpData.postValue(hotelSearchResponse);
    }

    public static /* synthetic */ void fetchSearchData$default(SRPViewModel sRPViewModel, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        sRPViewModel.fetchSearchData(i2);
    }

    public final void fetchSearchData(int i2) {
        this.fetchingData = true;
        f fVar = this.srpRepo;
        if (fVar != null) {
            String searchUrl = getSearchUrl(i2, 15);
            l<HotelSearchResponse> lVar = this.apiCallSuccess;
            l<ErrorData> lVar2 = this.apiCallFailure;
            k.c(searchUrl, "url");
            k.c(lVar, "sucessListener");
            k.c(lVar2, "failureListener");
            fVar.f28626c = lVar;
            fVar.f28627d = lVar2;
            HashMap hashMap = new HashMap();
            String a2 = c.b().a((Context) fVar.f28624a);
            if (a2 == null) {
                fVar.f28625b = "";
            } else {
                fVar.f28625b = a2;
            }
            String str = fVar.f28625b;
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(AppConstants.SSO_TOKEN, str);
            }
            a l = new b().a((Context) fVar.f28624a).a(a.b.SILENT).c("SRP").a(a.c.HOTELS).a(a.C0715a.GET).a(searchUrl).h().a((Map<String, String>) hashMap).b((Map) null).b((String) null).a((IJRPaytmDataModel) new HotelSearchResponse()).a((com.paytm.network.listener.b) new f.a()).a(true).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a();
        }
    }

    public final void reFetchSearchDta() {
        if (getParent().isSRPReload()) {
            this.srpData.setValue(null);
            getParent().postScreenNavigationEvent("2", "3");
        }
    }

    public final void setSelectedHotel(SRPDataItem sRPDataItem) {
        k.c(sRPDataItem, "data");
        this.selectedData.postValue(sRPDataItem);
        getParent().postScreenNavigationEvent("2", "5");
    }

    public final void onSortClick() {
        sendPulseEvent("sort_selected");
        getParent().postScreenNavigationEvent("2", "22");
    }

    public final void onFilterClick() {
        sendPulseEvent("filter_selected");
        getParent().postScreenNavigationEvent("2", "44");
    }

    public final void onBackPressedSRPMap() {
        this.selectedData.setValue(null);
        getParent().postScreenNavigationEvent("4", "2");
    }

    public final void onMapClick() {
        List<SRPDataItem> data;
        this.selectedData.setValue(null);
        sendPulseEvent("map_selected");
        HotelSearchResponse searchResponse = getParent().getSearchResponse();
        if (searchResponse != null && (data = searchResponse.getData()) != null && (!data.isEmpty())) {
            getParent().postScreenNavigationEvent("2", "4");
        }
    }

    private final void sendPulseEvent(String str) {
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        c.b().a("customEvent", "Search Page", "hotels_srp", str, hashMap);
    }

    public final void onSeeAllHotelsClick() {
        getParent().setSelectedSRPFilter(new HashMap());
        getParent().setFromFilterAvailableApiCall(false);
        getParent().postScreenNavigationEvent("2", "3");
    }

    private final String getSearchUrl(int i2, int i3) {
        ArrayList<CJRRoom> rooms;
        k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
        String c2 = e.c();
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        Uri.Builder buildUpon = Uri.parse(c2).buildUpon();
        CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
        String str = null;
        if (!TextUtils.isEmpty(searchInput2 != null ? searchInput2.getHotelId() : null)) {
            buildUpon.appendQueryParameter("is_hotel_search", "true");
        }
        if (searchInput == null || !searchInput.isNearBySearch()) {
            buildUpon.appendQueryParameter("city", searchInput != null ? searchInput.getCity() : null);
        } else {
            buildUpon.appendQueryParameter("nearby", "true");
        }
        buildUpon.appendQueryParameter("filter_params", getFilterParam());
        if (!TextUtils.isEmpty(searchInput != null ? searchInput.getPoi() : null)) {
            buildUpon.appendQueryParameter("poi", searchInput != null ? searchInput.getPoi() : null);
        }
        buildUpon.appendQueryParameter("check_in_date", searchInput != null ? searchInput.getCheckInDate() : null);
        buildUpon.appendQueryParameter("check_out_date", searchInput != null ? searchInput.getCheckOutDate() : null);
        buildUpon.appendQueryParameter("num_rooms", String.valueOf((searchInput == null || (rooms = searchInput.getRooms()) == null) ? null : Integer.valueOf(rooms.size())));
        buildUpon.appendQueryParameter(H5Param.PAGE, String.valueOf(i2));
        buildUpon.appendQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, String.valueOf(i3));
        buildUpon.appendQueryParameter("rooms_details", new com.google.gson.f().b(searchInput != null ? searchInput.getRooms() : null));
        if (searchInput == null) {
            k.a();
        }
        if (searchInput.isLocalitySearch()) {
            buildUpon.appendQueryParameter("is_locality_search", "true");
        }
        if (searchInput.getSortBy() != null) {
            SortKeysItem sortBy = searchInput.getSortBy();
            String urlParams = sortBy != null ? sortBy.getUrlParams() : null;
            SortKeysItem sortBy2 = searchInput.getSortBy();
            if (sortBy2 != null) {
                str = sortBy2.getDefault();
            }
            buildUpon.appendQueryParameter(urlParams, str);
        }
        String uri = buildUpon.build().toString();
        k.a((Object) uri, "uriBuilder.build().toString()");
        return uri;
    }

    private final String getFilterParam() {
        Locations locationDetails;
        Locations locationDetails2;
        Locations locationDetails3;
        JSONObject jSONObject = new JSONObject();
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        JSONObject jSONObject2 = null;
        if (!TextUtils.isEmpty(searchInput != null ? searchInput.getHotelId() : null)) {
            JSONArray jSONArray = new JSONArray();
            CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
            String hotelId = searchInput2 != null ? searchInput2.getHotelId() : null;
            if (hotelId == null) {
                k.a();
            }
            jSONObject.put("hotelId", jSONArray.put(hotelId));
            CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
            JSONObject jSONObject3 = (searchInput3 == null || (locationDetails3 = searchInput3.getLocationDetails()) == null) ? null : locationDetails3.toJSONObject();
            if (jSONObject3 == null) {
                k.a();
            }
            if (jSONObject3.has("lat") || jSONObject3.has("lon")) {
                jSONObject.put("location", jSONObject3);
            }
        } else if (getParent().getSelectedSRPFilter() == null || (getParent().getSelectedSRPFilter() != null && getParent().getSelectedSRPFilter().size() == 0)) {
            CJRHotelSearchInput searchInput4 = getParent().getSearchInput();
            JSONObject jSONObject4 = (searchInput4 == null || (locationDetails2 = searchInput4.getLocationDetails()) == null) ? null : locationDetails2.toJSONObject();
            if (jSONObject4 == null) {
                k.a();
            }
            if (jSONObject4.has("lat") || jSONObject4.has("lon")) {
                jSONObject.put("location", jSONObject4);
            }
        } else if (getParent().getSelectedSRPFilter().containsKey("starCategory")) {
            HashMap<String, ArrayList<String>> selectedSRPFilter = getParent().getSelectedSRPFilter();
            ArrayList arrayList = getParent().getSelectedSRPFilter().get("starCategory");
            if (arrayList == null || arrayList.size() <= 0) {
                selectedSRPFilter.remove("starCategory");
                getParent().getSelectedSRPFilter().remove("starCategory");
            } else {
                if (arrayList.contains("3")) {
                    if (!arrayList.contains("1")) {
                        arrayList.add("1");
                    }
                    if (!arrayList.contains("2")) {
                        arrayList.add("2");
                    }
                }
                if (arrayList.contains("5") && !arrayList.contains("4")) {
                    arrayList.add("4");
                }
                selectedSRPFilter.put("starCategory", arrayList);
            }
            HashMap<String, ArrayList<String>> selectedSRPFilter2 = getParent().getSelectedSRPFilter();
            if (selectedSRPFilter2 != null) {
                jSONObject = new JSONObject(selectedSRPFilter2);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            }
        } else {
            HashMap<String, ArrayList<String>> selectedSRPFilter3 = getParent().getSelectedSRPFilter();
            if (selectedSRPFilter3 != null) {
                jSONObject = new JSONObject(selectedSRPFilter3);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            }
        }
        CJRHotelSearchInput searchInput5 = getParent().getSearchInput();
        if (searchInput5 != null && searchInput5.isNearBySearch()) {
            CJRHotelSearchInput searchInput6 = getParent().getSearchInput();
            if (!(searchInput6 == null || (locationDetails = searchInput6.getLocationDetails()) == null)) {
                jSONObject2 = locationDetails.toJSONObject();
            }
            jSONObject.put("location", jSONObject2);
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r0 = r0.getExtra();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handlePageRequest(int r2) {
        /*
            r1 = this;
            boolean r0 = r1.fetchingData
            if (r0 != 0) goto L_0x0032
            boolean r0 = r1.isPageRquestValid(r2)
            if (r0 == 0) goto L_0x0032
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse> r0 = r1.srpData
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse) r0
            if (r0 == 0) goto L_0x0023
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r0 = r0.getExtra()
            if (r0 == 0) goto L_0x0023
            int r0 = r0.getNextPage()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            if (r0 != 0) goto L_0x0029
            kotlin.g.b.k.a()
        L_0x0029:
            int r0 = r0.intValue()
            r1.fetchSearchData(r0)
            r1.lastTotalItemCount = r2
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SRPViewModel.handlePageRequest(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r2 = r2.getExtra();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isPageRquestValid(int r2) {
        /*
            r1 = this;
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse> r2 = r1.srpData
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r2 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse) r2
            if (r2 == 0) goto L_0x001a
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r2 = r2.getExtra()
            if (r2 == 0) goto L_0x001a
            int r2 = r2.getNextPage()
            r0 = -1
            if (r2 == r0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r2 = 0
            return r2
        L_0x001a:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SRPViewModel.isPageRquestValid(int):boolean");
    }

    public final void onError(String str, ErrorData errorData) {
        k.c(str, "from");
        this.fetchingData = false;
        this.srpErrorVisibility.setValue(Boolean.TRUE);
        this.isBottonSortFilterVisible.setValue(Boolean.FALSE);
        this.srpFilterNoResultVisibility.setValue(Boolean.FALSE);
        this.srpFilterSingleResultVisibility.setValue(Boolean.FALSE);
        this.hotelCount.setValue(0);
        this.srpData.postValue(null);
        this.srpNoResultVisibility.setValue(Boolean.FALSE);
        getParent().postScreenNavigationEvent(str, "2");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r6.getExtra();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getSortDisplayString(net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x000e
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r1 = r6.getExtra()
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.getSelectedSortingParam()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 == 0) goto L_0x0088
            r1 = 0
            if (r6 == 0) goto L_0x001f
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r2 = r6.getExtra()
            if (r2 == 0) goto L_0x001f
            java.util.List r2 = r2.getSortKeys()
            goto L_0x0020
        L_0x001f:
            r2 = r0
        L_0x0020:
            if (r2 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x002b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = r2.next()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r3 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem) r3
            java.lang.String r3 = r3.getDefault()
            if (r6 == 0) goto L_0x0048
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r4 = r6.getExtra()
            if (r4 == 0) goto L_0x0048
            java.lang.String r4 = r4.getSelectedSortingParam()
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0085
            if (r6 == 0) goto L_0x0069
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r2 = r6.getExtra()
            if (r2 == 0) goto L_0x0069
            java.util.List r2 = r2.getSortKeys()
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r2 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem) r2
            if (r2 == 0) goto L_0x0069
            r3 = 1
            r2.setSelected(r3)
        L_0x0069:
            if (r6 == 0) goto L_0x0084
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r6 = r6.getExtra()
            if (r6 == 0) goto L_0x0084
            java.util.List r6 = r6.getSortKeys()
            if (r6 == 0) goto L_0x0084
            java.lang.Object r6 = r6.get(r1)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r6 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem) r6
            if (r6 == 0) goto L_0x0084
            java.lang.String r6 = r6.getName()
            return r6
        L_0x0084:
            return r0
        L_0x0085:
            int r1 = r1 + 1
            goto L_0x002b
        L_0x0088:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SRPViewModel.getSortDisplayString(net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse):java.lang.String");
    }

    private final void sendPulseEventHotelSearchTapped(int i2) {
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        map2.put("event_label2", Integer.valueOf(i2));
        if (this.srpRepo != null) {
            c.b().a("customEvent", "Search Page", "hotels_srp", "page_opened", map2);
        }
    }

    public final String getHotelBuleImageUrl() {
        return net.one97.paytm.hotel4.utils.f.c("hotelBlue");
    }

    public final void setDateFromResponse(SearchParams searchParams) {
        CJRHotelSearchInput searchInput;
        if (searchParams != null && !TextUtils.isEmpty(searchParams.getCheckInDate()) && !TextUtils.isEmpty(searchParams.getCheckOutDate())) {
            s sVar = s.f28553a;
            if (s.a(searchParams.getCheckInDate())) {
                s sVar2 = s.f28553a;
                if (s.a(searchParams.getCheckOutDate()) && (searchInput = getParent().getSearchInput()) != null) {
                    searchInput.setCheckInDate(searchParams.getCheckInDate());
                }
            }
        }
        CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
        String str = null;
        if (searchInput2 != null) {
            searchInput2.setCheckOutDate(searchParams != null ? searchParams.getCheckOutDate() : null);
        }
        CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
        if (searchInput3 != null) {
            String checkInDate = searchParams != null ? searchParams.getCheckInDate() : null;
            if (searchParams != null) {
                str = searchParams.getCheckOutDate();
            }
            searchInput3.setNumOfNights(getNumberOfNights(checkInDate, str));
        }
    }

    public final int getNumberOfNights(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            return (int) TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return 0;
        }
    }
}
