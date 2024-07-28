package net.one97.paytm.hotel4.viewmodel.filter;

import android.text.TextUtils;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gson.f;
import com.google.gson.p;
import com.google.gson.u;
import com.travel.utils.l;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FilterValuesItem;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FiltersItem;
import net.one97.paytm.hotel4.viewmodel.BaseViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;

public final class SRPFilterViewModel extends BaseViewModel {
    private ArrayList<FilterValuesItem> amenitiesFilterdata = new ArrayList<>();
    private y<String> amenitiesShowMoreLessText = new y<>();
    private y<Boolean> amenitiesVisibility = new y<>();
    private l<Boolean> clearAllClicked = new l<>();
    private String filterAmenitiesTitle = "";
    private l<Integer> filterCount = new l<>();
    private y<Integer> filterCountHotelChain = new y<>();
    private y<Integer> filterCountHotelTheme = new y<>();
    private y<Integer> filterCountLocality = new y<>();
    private String filterHotelChainTitle = "";
    private String filterHotelThemeTitle = "";
    private String filterHotelTypeTitle = "";
    private List<FiltersItem> filterItemList = new ArrayList();
    private String filterLocalityTitle = "";
    private String filterPriceRangeTitle = "";
    private l<o<String, Integer>> filterRecyclerViewItemClick = new l<>();
    private String filterStartRatingTitle = "";
    private y<Boolean> hoteLocalityVisibility = new y<>();
    private y<Boolean> hoteThemeVisibility = new y<>();
    private y<Boolean> hotelChainVisibility = new y<>();
    private ArrayList<FilterValuesItem> hotelTypeFilterdata = new ArrayList<>();
    private y<String> hotelTypeShowMoreLessText = new y<>();
    private y<Boolean> propertyTypeVisibility = new y<>();
    private HashMap<String, ArrayList<String>> selectedTempFilter = new HashMap<>();
    private y<Boolean> startRaitingsVisibility = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SRPFilterViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
        this.filterCount.setValue(0);
        this.amenitiesShowMoreLessText.setValue("Show More");
        this.hotelTypeShowMoreLessText.setValue("Show More");
        initSelectedFilter();
    }

    public final l<Integer> getFilterCount() {
        return this.filterCount;
    }

    public final void setFilterCount(l<Integer> lVar) {
        k.c(lVar, "<set-?>");
        this.filterCount = lVar;
    }

    public final y<Integer> getFilterCountHotelChain() {
        return this.filterCountHotelChain;
    }

    public final void setFilterCountHotelChain(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.filterCountHotelChain = yVar;
    }

    public final y<Integer> getFilterCountLocality() {
        return this.filterCountLocality;
    }

    public final void setFilterCountLocality(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.filterCountLocality = yVar;
    }

    public final y<Integer> getFilterCountHotelTheme() {
        return this.filterCountHotelTheme;
    }

    public final void setFilterCountHotelTheme(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.filterCountHotelTheme = yVar;
    }

    public final l<Boolean> getClearAllClicked() {
        return this.clearAllClicked;
    }

    public final void setClearAllClicked(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.clearAllClicked = lVar;
    }

    public final String getFilterPriceRangeTitle() {
        return this.filterPriceRangeTitle;
    }

    public final void setFilterPriceRangeTitle(String str) {
        k.c(str, "<set-?>");
        this.filterPriceRangeTitle = str;
    }

    public final String getFilterStartRatingTitle() {
        return this.filterStartRatingTitle;
    }

    public final void setFilterStartRatingTitle(String str) {
        k.c(str, "<set-?>");
        this.filterStartRatingTitle = str;
    }

    public final String getFilterAmenitiesTitle() {
        return this.filterAmenitiesTitle;
    }

    public final void setFilterAmenitiesTitle(String str) {
        k.c(str, "<set-?>");
        this.filterAmenitiesTitle = str;
    }

    public final String getFilterHotelTypeTitle() {
        return this.filterHotelTypeTitle;
    }

    public final void setFilterHotelTypeTitle(String str) {
        k.c(str, "<set-?>");
        this.filterHotelTypeTitle = str;
    }

    public final String getFilterLocalityTitle() {
        return this.filterLocalityTitle;
    }

    public final void setFilterLocalityTitle(String str) {
        k.c(str, "<set-?>");
        this.filterLocalityTitle = str;
    }

    public final String getFilterHotelChainTitle() {
        return this.filterHotelChainTitle;
    }

    public final void setFilterHotelChainTitle(String str) {
        k.c(str, "<set-?>");
        this.filterHotelChainTitle = str;
    }

    public final String getFilterHotelThemeTitle() {
        return this.filterHotelThemeTitle;
    }

    public final void setFilterHotelThemeTitle(String str) {
        k.c(str, "<set-?>");
        this.filterHotelThemeTitle = str;
    }

    public final List<FiltersItem> getFilterItemList() {
        return this.filterItemList;
    }

    public final void setFilterItemList(List<FiltersItem> list) {
        this.filterItemList = list;
    }

    public final l<o<String, Integer>> getFilterRecyclerViewItemClick() {
        return this.filterRecyclerViewItemClick;
    }

    public final void setFilterRecyclerViewItemClick(l<o<String, Integer>> lVar) {
        k.c(lVar, "<set-?>");
        this.filterRecyclerViewItemClick = lVar;
    }

    public final y<String> getAmenitiesShowMoreLessText() {
        return this.amenitiesShowMoreLessText;
    }

    public final void setAmenitiesShowMoreLessText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.amenitiesShowMoreLessText = yVar;
    }

    public final y<String> getHotelTypeShowMoreLessText() {
        return this.hotelTypeShowMoreLessText;
    }

    public final void setHotelTypeShowMoreLessText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.hotelTypeShowMoreLessText = yVar;
    }

    public final ArrayList<FilterValuesItem> getAmenitiesFilterdata() {
        return this.amenitiesFilterdata;
    }

    public final void setAmenitiesFilterdata(ArrayList<FilterValuesItem> arrayList) {
        k.c(arrayList, "<set-?>");
        this.amenitiesFilterdata = arrayList;
    }

    public final ArrayList<FilterValuesItem> getHotelTypeFilterdata() {
        return this.hotelTypeFilterdata;
    }

    public final void setHotelTypeFilterdata(ArrayList<FilterValuesItem> arrayList) {
        k.c(arrayList, "<set-?>");
        this.hotelTypeFilterdata = arrayList;
    }

    public final y<Boolean> getHotelChainVisibility() {
        return this.hotelChainVisibility;
    }

    public final void setHotelChainVisibility(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.hotelChainVisibility = yVar;
    }

    public final y<Boolean> getHoteLocalityVisibility() {
        return this.hoteLocalityVisibility;
    }

    public final void setHoteLocalityVisibility(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.hoteLocalityVisibility = yVar;
    }

    public final y<Boolean> getHoteThemeVisibility() {
        return this.hoteThemeVisibility;
    }

    public final void setHoteThemeVisibility(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.hoteThemeVisibility = yVar;
    }

    public final y<Boolean> getPropertyTypeVisibility() {
        return this.propertyTypeVisibility;
    }

    public final void setPropertyTypeVisibility(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.propertyTypeVisibility = yVar;
    }

    public final y<Boolean> getAmenitiesVisibility() {
        return this.amenitiesVisibility;
    }

    public final void setAmenitiesVisibility(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.amenitiesVisibility = yVar;
    }

    public final y<Boolean> getStartRaitingsVisibility() {
        return this.startRaitingsVisibility;
    }

    public final void setStartRaitingsVisibility(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.startRaitingsVisibility = yVar;
    }

    public final HashMap<String, ArrayList<String>> getSelectedTempFilter() {
        return this.selectedTempFilter;
    }

    public final void setSelectedTempFilter(HashMap<String, ArrayList<String>> hashMap) {
        k.c(hashMap, "<set-?>");
        this.selectedTempFilter = hashMap;
    }

    public final void initSelectedFilter() {
        this.selectedTempFilter = new HashMap<>(getParent().getSelectedSRPFilter());
    }

    public final void onBackClick() {
        getParent().postScreenNavigationEvent("44", "2");
    }

    public final void onClearAllClick() {
        this.selectedTempFilter = new HashMap<>();
        this.clearAllClicked.setValue(Boolean.TRUE);
    }

    public final ArrayList<FilterValuesItem> getFilterValues(String str) {
        Type type = new SRPFilterViewModel$getFilterValues$type$1().getType();
        ArrayList<FilterValuesItem> arrayList = new ArrayList<>();
        if (str != null) {
            try {
                Object a2 = new f().a(str, type);
                k.a(a2, "Gson().fromJson(jsonData, type)");
                return (ArrayList) a2;
            } catch (p | u | Exception unused) {
            }
        }
        return arrayList;
    }

    public final void updateSelectedFilter(String str, String str2, int i2, boolean z) {
        k.c(str, H5Param.PARAM);
        setSelectedTempFilter(str, str2);
        if (z && (str.equals("amenities") || str.equals("propertyTypes"))) {
            this.filterRecyclerViewItemClick.setValue(new o(str, Integer.valueOf(i2)));
        }
        updateFilterCount();
    }

    public final void updateFilterCount() {
        this.filterCount.setValue(Integer.valueOf(getTempFilterAppliedCount()));
        this.filterCountHotelChain.postValue(getFilterCount("chain"));
        this.filterCountLocality.postValue(getFilterCount("localities"));
        this.filterCountHotelTheme.postValue(getFilterCount("types"));
    }

    public final Integer getFilterCount(String str) {
        k.c(str, "type");
        if (!this.selectedTempFilter.containsKey(str)) {
            return 0;
        }
        ArrayList arrayList = this.selectedTempFilter.get(str);
        if (arrayList != null) {
            return Integer.valueOf(arrayList.size());
        }
        return null;
    }

    public final int getTempFilterAppliedCount() {
        HashMap<String, ArrayList<String>> hashMap = this.selectedTempFilter;
        if (hashMap != null) {
            return hashMap.size();
        }
        return 0;
    }

    public final void filterApplyClick() {
        getParent().setFromFilterAvailableApiCall(true);
        getParent().setSelectedSRPFilter(this.selectedTempFilter);
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        if (!TextUtils.isEmpty(searchInput != null ? searchInput.getHotelId() : null)) {
            CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
            if (searchInput2 != null) {
                searchInput2.setHotelId("");
            }
            getParent().setHotelSoldOut(false);
            CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
            if (searchInput3 != null) {
                searchInput3.setPoi("");
            }
        }
        CJRHotelSearchInput searchInput4 = getParent().getSearchInput();
        if (searchInput4 != null) {
            searchInput4.setFilterParams(new f().a((Object) this.selectedTempFilter, (Type) HashMap.class));
        }
        sendPulseEvent(this.selectedTempFilter.keySet().toString());
        getParent().postScreenNavigationEvent("2", "3");
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
                throw new kotlin.u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        if (str != null) {
            map2.put("event_label2", str);
            c.b().a("customEvent", "Search Page", "hotels_srp", "results_filtered", map2);
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type kotlin.Any");
    }

    public final void onScreenClick(String str) {
        k.c(str, "type");
        if (k.a((Object) str, (Object) this.filterLocalityTitle)) {
            getParent().postScreenNavigationEvent("44", "55");
        } else if (k.a((Object) str, (Object) this.filterHotelChainTitle)) {
            getParent().postScreenNavigationEvent("44", "66");
        } else if (k.a((Object) str, (Object) this.filterAmenitiesTitle)) {
            if (kotlin.m.p.a(this.amenitiesShowMoreLessText.getValue(), "show More", true)) {
                this.amenitiesShowMoreLessText.setValue("Show Less");
            } else if (kotlin.m.p.a(this.amenitiesShowMoreLessText.getValue(), "Show Less", true)) {
                this.amenitiesShowMoreLessText.setValue("Show More");
            }
        } else if (k.a((Object) str, (Object) this.filterHotelTypeTitle)) {
            if (kotlin.m.p.a(this.hotelTypeShowMoreLessText.getValue(), "show More", true)) {
                this.hotelTypeShowMoreLessText.setValue("Show Less");
            } else if (kotlin.m.p.a(this.hotelTypeShowMoreLessText.getValue(), "Show Less", true)) {
                this.hotelTypeShowMoreLessText.setValue("Show More");
            }
        } else if (k.a((Object) str, (Object) this.filterHotelThemeTitle)) {
            getParent().postScreenNavigationEvent("44", "77");
        }
    }

    public final void setSelectedTempFilter(String str, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        HashMap<String, ArrayList<String>> hashMap;
        ArrayList arrayList3;
        ArrayList arrayList4;
        HashMap<String, ArrayList<String>> hashMap2;
        k.c(str, "key");
        if (this.selectedTempFilter.containsKey(str)) {
            HashMap<String, ArrayList<String>> hashMap3 = this.selectedTempFilter;
            if (hashMap3 == null) {
                k.a();
            }
            ArrayList<String> arrayList5 = hashMap3.get(str);
            if (arrayList5 == null) {
                k.a();
            }
            k.a((Object) arrayList5, "selectedTempFilter!!.get(key)!!");
            if (!kotlin.a.k.a(arrayList5, str2)) {
                HashMap<String, ArrayList<String>> hashMap4 = this.selectedTempFilter;
                if (hashMap4 != null && (arrayList = hashMap4.get(str)) != null) {
                    if (str2 == null) {
                        k.a();
                    }
                    arrayList.add(str2);
                }
            } else if (str.equals("starCategory")) {
                removeHotelStart(str2);
                HashMap<String, ArrayList<String>> hashMap5 = this.selectedTempFilter;
                if (hashMap5 != null && (arrayList4 = hashMap5.get(str)) != null && arrayList4.size() == 0 && (hashMap2 = this.selectedTempFilter) != null) {
                    hashMap2.remove(str);
                }
            } else {
                HashMap<String, ArrayList<String>> hashMap6 = this.selectedTempFilter;
                if (!(hashMap6 == null || (arrayList3 = hashMap6.get(str)) == null)) {
                    Collection collection = arrayList3;
                    if (collection != null) {
                        ab.b(collection).remove(str2);
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                }
                HashMap<String, ArrayList<String>> hashMap7 = this.selectedTempFilter;
                if (hashMap7 != null && (arrayList2 = hashMap7.get(str)) != null && arrayList2.size() == 0 && (hashMap = this.selectedTempFilter) != null) {
                    hashMap.remove(str);
                }
            }
        } else {
            ArrayList arrayList6 = new ArrayList();
            if (str2 == null) {
                k.a();
            }
            arrayList6.add(str2);
            this.selectedTempFilter.put(str, arrayList6);
        }
    }

    private final void removeHotelStart(String str) {
        ArrayList arrayList = this.selectedTempFilter.get("starCategory");
        if (k.a((Object) str, (Object) "3")) {
            if (arrayList != null) {
                arrayList.remove("3");
            }
            if (arrayList == null) {
                k.a();
            }
            if (arrayList.contains("1")) {
                arrayList.remove("1");
            }
            if (arrayList.contains("2")) {
                arrayList.remove("2");
            }
        } else if (k.a((Object) str, (Object) "5")) {
            if (arrayList != null) {
                arrayList.remove("5");
            }
            if (arrayList == null) {
                k.a();
            }
            if (arrayList.contains("4")) {
                arrayList.remove("4");
            }
        }
    }

    public final boolean getFilterSelectedStatus(String str, String str2) {
        k.c(str, "filterParam");
        if (!this.selectedTempFilter.containsKey(str)) {
            return false;
        }
        HashMap<String, ArrayList<String>> hashMap = this.selectedTempFilter;
        if (hashMap == null) {
            k.a();
        }
        ArrayList<String> arrayList = hashMap.get(str);
        if (arrayList == null) {
            k.a();
        }
        k.a((Object) arrayList, "selectedTempFilter!!.get(filterParam)!!");
        return kotlin.a.k.a(arrayList, str2);
    }
}
