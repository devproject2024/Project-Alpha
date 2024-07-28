package net.one97.paytm.nativesdk.common.viewmodel;

import android.widget.CompoundButton;

public class InstrumentInfoViewModel {
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private String mInstrumentPrimaryInfo;
    private String mInstrumentSecondaryInfo;

    public InstrumentInfoViewModel(String str, String str2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mInstrumentPrimaryInfo = str;
        this.mInstrumentSecondaryInfo = str2;
        this.mCheckedChangeListener = onCheckedChangeListener;
    }

    public String getInstrumentPrimaryInfo() {
        return this.mInstrumentPrimaryInfo;
    }

    public void setInstrumentPrimaryInfo(String str) {
        this.mInstrumentPrimaryInfo = str;
    }

    public String getInstrumentSecondaryInfo() {
        return this.mInstrumentSecondaryInfo;
    }

    public void setInstrumentSecondaryInfo(String str) {
        this.mInstrumentSecondaryInfo = str;
    }

    public CompoundButton.OnCheckedChangeListener getCheckedChangeListener() {
        return this.mCheckedChangeListener;
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckedChangeListener = onCheckedChangeListener;
    }

    public void radioButtonChecked(CompoundButton compoundButton, boolean z) {
        this.mCheckedChangeListener.onCheckedChanged(compoundButton, z);
    }
}
