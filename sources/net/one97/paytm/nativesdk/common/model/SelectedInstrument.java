package net.one97.paytm.nativesdk.common.model;

import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;

public class SelectedInstrument implements BaseDataModel {
    private BaseViewModel baseViewModel;
    private String primaryName;
    private String secondaryName;

    public SelectedInstrument() {
    }

    public SelectedInstrument(String str, String str2, BaseViewModel baseViewModel2) {
        this.primaryName = str;
        this.secondaryName = str2;
        this.baseViewModel = baseViewModel2;
    }

    public String getPrimaryName() {
        return this.primaryName;
    }

    public String getSecondaryName() {
        return this.secondaryName;
    }

    public BaseViewModel getBaseViewModel() {
        return this.baseViewModel;
    }

    public void setBaseViewModel(BaseViewModel baseViewModel2) {
        this.baseViewModel = baseViewModel2;
    }

    public void setPrimaryName(String str) {
        this.primaryName = str;
    }

    public void setSecondaryName(String str) {
        this.secondaryName = str;
    }
}
