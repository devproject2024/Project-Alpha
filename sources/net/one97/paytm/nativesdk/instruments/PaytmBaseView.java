package net.one97.paytm.nativesdk.instruments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import androidx.localbroadcastmanager.a.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public abstract class PaytmBaseView {
    public static boolean isOnceClicked;
    public Context context;
    private String instrumentName;
    public Instruments instruments;
    private boolean isDisabled = false;
    private boolean isSelected;
    private boolean isVisaSingleClickEligible = true;
    public View view;

    public abstract void closeView();

    public Object getVerifyResponseModel() {
        return null;
    }

    public void hidePaymentsLoader() {
    }

    public boolean isEmiHybridDisabled() {
        return false;
    }

    public boolean isHybridDisabled() {
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onDestroy() {
    }

    public abstract void openAutoInstrument();

    public void refreshLayout() {
    }

    public PaytmBaseView(Instruments instruments2) {
        this.instruments = instruments2;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public View getView() {
        return this.view;
    }

    public void setIsVSCPEligible(boolean z) {
        this.isVisaSingleClickEligible = z;
    }

    public boolean isVSCPEligible() {
        return this.isVisaSingleClickEligible;
    }

    public Context getContext() {
        return this.context;
    }

    public void registerReciever(Context context2, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.UNCHECK_VIEWS_ACTION_FILTER);
        intentFilter.addAction(SDKConstants.UNREGISTER_BROADCAST);
        intentFilter.addAction(SDKConstants.REFRESH_LAYOUT_FILTER);
        intentFilter.addAction(SDKConstants.EMI_REFRESH_FILTER);
        a.a(context2.getApplicationContext()).a(broadcastReceiver, intentFilter);
    }

    public void setInstrumentName(String str) {
        this.instrumentName = str;
    }

    public String getInstrumentName() {
        return this.instrumentName;
    }

    public boolean isDisabled() {
        return this.isDisabled;
    }

    public void setDisabled(boolean z) {
        this.isDisabled = z;
    }
}
