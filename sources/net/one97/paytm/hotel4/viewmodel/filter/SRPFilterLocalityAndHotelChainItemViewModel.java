package net.one97.paytm.hotel4.viewmodel.filter;

import androidx.lifecycle.ai;
import com.travel.utils.l;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FilterValuesItem;

public final class SRPFilterLocalityAndHotelChainItemViewModel extends ai {
    private FilterValuesItem filterItem;
    private String filterParam = "";
    private l<Boolean> isSelected = new l<>();
    private int position = -1;
    private l<String> rangeText = new l<>();
    private SRPFilterLocalityAndHotelChainViewModel srpfilterViewModel;
    private int visibility = 8;

    public SRPFilterLocalityAndHotelChainItemViewModel(SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel) {
        k.c(sRPFilterLocalityAndHotelChainViewModel, "srpfilterViewModel");
        this.srpfilterViewModel = sRPFilterLocalityAndHotelChainViewModel;
        this.isSelected.setValue(Boolean.FALSE);
        this.filterItem = new FilterValuesItem(false, (String) null, (String) null, 7, (g) null);
    }

    public final SRPFilterLocalityAndHotelChainViewModel getSrpfilterViewModel() {
        return this.srpfilterViewModel;
    }

    public final void setSrpfilterViewModel(SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel) {
        k.c(sRPFilterLocalityAndHotelChainViewModel, "<set-?>");
        this.srpfilterViewModel = sRPFilterLocalityAndHotelChainViewModel;
    }

    public final String getFilterParam() {
        return this.filterParam;
    }

    public final void setFilterParam(String str) {
        k.c(str, "<set-?>");
        this.filterParam = str;
    }

    public final l<String> getRangeText() {
        return this.rangeText;
    }

    public final void setRangeText(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.rangeText = lVar;
    }

    public final l<Boolean> isSelected() {
        return this.isSelected;
    }

    public final void setSelected(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.isSelected = lVar;
    }

    public final int getVisibility() {
        return this.visibility;
    }

    public final void setVisibility(int i2) {
        this.visibility = i2;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final FilterValuesItem getFilterItem() {
        return this.filterItem;
    }

    public final void setFilterItem(FilterValuesItem filterValuesItem) {
        this.filterItem = filterValuesItem;
    }

    public final void setItemData(FilterValuesItem filterValuesItem, String str, int i2) {
        k.c(str, "paramName");
        this.position = i2;
        this.filterItem = filterValuesItem;
        l<Boolean> lVar = this.isSelected;
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.srpfilterViewModel;
        FilterValuesItem filterValuesItem2 = this.filterItem;
        String str2 = null;
        lVar.setValue(Boolean.valueOf(sRPFilterLocalityAndHotelChainViewModel.getFilterSelectedStatus(str, filterValuesItem2 != null ? filterValuesItem2.getId() : null)));
        l<String> lVar2 = this.rangeText;
        FilterValuesItem filterValuesItem3 = this.filterItem;
        if (filterValuesItem3 != null) {
            str2 = filterValuesItem3.getName();
        }
        lVar2.setValue(str2);
        this.filterParam = str;
    }

    public final void onFilterItemClick() {
        l<Boolean> lVar = this.isSelected;
        Boolean value = lVar.getValue();
        if (value == null) {
            k.a();
        }
        lVar.setValue(Boolean.valueOf(!value.booleanValue()));
        FilterValuesItem filterValuesItem = this.filterItem;
        if (filterValuesItem != null) {
            Boolean value2 = this.isSelected.getValue();
            if (value2 == null) {
                k.a();
            }
            filterValuesItem.setApplied(value2.booleanValue());
        }
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.srpfilterViewModel;
        String str = this.filterParam;
        FilterValuesItem filterValuesItem2 = this.filterItem;
        sRPFilterLocalityAndHotelChainViewModel.updateSelectedFilter(str, filterValuesItem2 != null ? filterValuesItem2.getId() : null, this.position);
    }
}
