package net.one97.paytm.hotel4.viewmodel.filter;

import androidx.lifecycle.ai;
import com.alipay.mobile.h5container.api.H5Param;
import com.travel.utils.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FilterValuesItem;

public final class SRPFilterLocalityAndHotelChainViewModel extends ai {
    private l<String> autoSearchEevent = new l<>();
    private l<Integer> filterCount = new l<>();
    private final String filterParamName;
    private l<o<String, Integer>> filterRecyclerViewItemClick = new l<>();
    private l<Boolean> filterSaveClicked = new l<>();
    private String hint = "";
    private int imageId = -1;
    private HashMap<String, ArrayList<String>> selectedFilter = new HashMap<>();
    private SRPFilterViewModel srpfilterViewModel;
    private String title = "locality";

    public final SRPFilterViewModel getSrpfilterViewModel() {
        return this.srpfilterViewModel;
    }

    public final void setSrpfilterViewModel(SRPFilterViewModel sRPFilterViewModel) {
        k.c(sRPFilterViewModel, "<set-?>");
        this.srpfilterViewModel = sRPFilterViewModel;
    }

    public final String getFilterParamName() {
        return this.filterParamName;
    }

    public SRPFilterLocalityAndHotelChainViewModel(SRPFilterViewModel sRPFilterViewModel, String str) {
        k.c(sRPFilterViewModel, "srpfilterViewModel");
        k.c(str, "filterParamName");
        this.srpfilterViewModel = sRPFilterViewModel;
        this.filterParamName = str;
        initFilterStatus();
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        k.c(str, "<set-?>");
        this.title = str;
    }

    public final String getHint() {
        return this.hint;
    }

    public final void setHint(String str) {
        k.c(str, "<set-?>");
        this.hint = str;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final void setImageId(int i2) {
        this.imageId = i2;
    }

    public final HashMap<String, ArrayList<String>> getSelectedFilter() {
        return this.selectedFilter;
    }

    public final void setSelectedFilter(HashMap<String, ArrayList<String>> hashMap) {
        k.c(hashMap, "<set-?>");
        this.selectedFilter = hashMap;
    }

    public final l<o<String, Integer>> getFilterRecyclerViewItemClick() {
        return this.filterRecyclerViewItemClick;
    }

    public final void setFilterRecyclerViewItemClick(l<o<String, Integer>> lVar) {
        k.c(lVar, "<set-?>");
        this.filterRecyclerViewItemClick = lVar;
    }

    public final l<Integer> getFilterCount() {
        return this.filterCount;
    }

    public final void setFilterCount(l<Integer> lVar) {
        k.c(lVar, "<set-?>");
        this.filterCount = lVar;
    }

    public final l<Boolean> getFilterSaveClicked() {
        return this.filterSaveClicked;
    }

    public final void setFilterSaveClicked(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.filterSaveClicked = lVar;
    }

    public final l<String> getAutoSearchEevent() {
        return this.autoSearchEevent;
    }

    public final void setAutoSearchEevent(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.autoSearchEevent = lVar;
    }

    public final void initFilterStatus() {
        if (this.srpfilterViewModel.getSelectedTempFilter().containsKey("chain")) {
            HashMap<String, ArrayList<String>> hashMap = this.selectedFilter;
            ArrayList<String> arrayList = this.srpfilterViewModel.getSelectedTempFilter().get("chain");
            if (arrayList == null) {
                k.a();
            }
            hashMap.put("chain", new ArrayList(arrayList));
        }
        if (this.srpfilterViewModel.getSelectedTempFilter().containsKey("localities")) {
            HashMap<String, ArrayList<String>> hashMap2 = this.selectedFilter;
            ArrayList<String> arrayList2 = this.srpfilterViewModel.getSelectedTempFilter().get("localities");
            if (arrayList2 == null) {
                k.a();
            }
            hashMap2.put("localities", new ArrayList(arrayList2));
        }
        if (this.srpfilterViewModel.getSelectedTempFilter().containsKey("types")) {
            HashMap<String, ArrayList<String>> hashMap3 = this.selectedFilter;
            ArrayList<String> arrayList3 = this.srpfilterViewModel.getSelectedTempFilter().get("types");
            if (arrayList3 == null) {
                k.a();
            }
            hashMap3.put("types", new ArrayList(arrayList3));
        }
        Integer num = null;
        if (this.filterParamName.equals("chain")) {
            l<Integer> lVar = this.filterCount;
            ArrayList arrayList4 = this.srpfilterViewModel.getSelectedTempFilter().get("chain");
            if (arrayList4 != null) {
                num = Integer.valueOf(arrayList4.size());
            }
            lVar.setValue(num);
        } else if (this.filterParamName.equals("localities")) {
            l<Integer> lVar2 = this.filterCount;
            ArrayList arrayList5 = this.srpfilterViewModel.getSelectedTempFilter().get("localities");
            if (arrayList5 != null) {
                num = Integer.valueOf(arrayList5.size());
            }
            lVar2.setValue(num);
        } else if (this.filterParamName.equals("types")) {
            l<Integer> lVar3 = this.filterCount;
            ArrayList arrayList6 = this.srpfilterViewModel.getSelectedTempFilter().get("types");
            if (arrayList6 != null) {
                num = Integer.valueOf(arrayList6.size());
            }
            lVar3.setValue(num);
        }
    }

    public final void updateSelectedFilter(String str, String str2, int i2) {
        k.c(str, H5Param.PARAM);
        setSelectedFilter(str, str2);
        l<o<String, Integer>> lVar = this.filterRecyclerViewItemClick;
        if (str2 == null) {
            k.a();
        }
        lVar.setValue(new o(str2, Integer.valueOf(i2)));
    }

    public final void setSelectedFilter(String str, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        k.c(str, "key");
        if (this.selectedFilter.containsKey(str)) {
            HashMap<String, ArrayList<String>> hashMap = this.selectedFilter;
            if (hashMap == null) {
                k.a();
            }
            ArrayList<String> arrayList3 = hashMap.get(str);
            if (arrayList3 == null) {
                k.a();
            }
            k.a((Object) arrayList3, "selectedFilter!!.get(key)!!");
            if (kotlin.a.k.a(arrayList3, str2)) {
                HashMap<String, ArrayList<String>> hashMap2 = this.selectedFilter;
                if (!(hashMap2 == null || (arrayList2 = hashMap2.get(str)) == null)) {
                    Collection collection = arrayList2;
                    if (collection != null) {
                        ab.b(collection).remove(str2);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                }
            } else {
                HashMap<String, ArrayList<String>> hashMap3 = this.selectedFilter;
                if (!(hashMap3 == null || (arrayList = hashMap3.get(str)) == null)) {
                    if (str2 == null) {
                        k.a();
                    }
                    arrayList.add(str2);
                }
            }
        } else {
            ArrayList arrayList4 = new ArrayList();
            if (str2 == null) {
                k.a();
            }
            arrayList4.add(str2);
            this.selectedFilter.put(str, arrayList4);
        }
        l<Integer> lVar = this.filterCount;
        ArrayList arrayList5 = this.selectedFilter.get(str);
        lVar.setValue(arrayList5 != null ? Integer.valueOf(arrayList5.size()) : null);
    }

    public final void onSaveClick() {
        ArrayList arrayList;
        HashMap<String, ArrayList<String>> hashMap = this.selectedFilter;
        if (hashMap != null && hashMap.containsKey(this.filterParamName)) {
            HashMap<String, ArrayList<String>> hashMap2 = this.selectedFilter;
            if (hashMap2 == null || (arrayList = hashMap2.get(this.filterParamName)) == null || arrayList.size() != 0) {
                HashMap<String, ArrayList<String>> selectedTempFilter = this.srpfilterViewModel.getSelectedTempFilter();
                String str = this.filterParamName;
                ArrayList<String> arrayList2 = this.selectedFilter.get(str);
                if (arrayList2 == null) {
                    k.a();
                }
                selectedTempFilter.put(str, new ArrayList(arrayList2));
            } else if (this.srpfilterViewModel.getSelectedTempFilter() != null && this.srpfilterViewModel.getSelectedTempFilter().containsKey(this.filterParamName)) {
                this.srpfilterViewModel.getSelectedTempFilter().remove(this.filterParamName);
            }
        }
        this.filterSaveClicked.setValue(Boolean.TRUE);
        this.srpfilterViewModel.updateFilterCount();
    }

    public final void onCancelClick() {
        this.filterSaveClicked.setValue(Boolean.TRUE);
    }

    public final void onClearClick() {
        HashMap<String, ArrayList<String>> hashMap = this.selectedFilter;
        if (hashMap != null && hashMap.containsKey(this.filterParamName)) {
            this.selectedFilter.put(this.filterParamName, new ArrayList());
        }
        this.filterCount.setValue(0);
        this.filterRecyclerViewItemClick.setValue(new o("", -1));
    }

    public final ArrayList<FilterValuesItem> getFilteredList(List<FilterValuesItem> list, String str) {
        k.c(list, "data");
        k.c(str, "searchString");
        ArrayList<FilterValuesItem> arrayList = new ArrayList<>();
        for (FilterValuesItem next : list) {
            if (p.a((CharSequence) next.getName(), (CharSequence) str, true)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final void onPasswordTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.c(charSequence, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        new StringBuilder("text:").append(charSequence);
        this.autoSearchEevent.setValue(charSequence.toString());
    }

    public final boolean getFilterSelectedStatus(String str, String str2) {
        k.c(str, "filterParam");
        if (!this.selectedFilter.containsKey(str)) {
            return false;
        }
        HashMap<String, ArrayList<String>> hashMap = this.selectedFilter;
        if (hashMap == null) {
            k.a();
        }
        ArrayList<String> arrayList = hashMap.get(str);
        if (arrayList == null) {
            k.a();
        }
        k.a((Object) arrayList, "selectedFilter!!.get(filterParam)!!");
        return kotlin.a.k.a(arrayList, str2);
    }
}
