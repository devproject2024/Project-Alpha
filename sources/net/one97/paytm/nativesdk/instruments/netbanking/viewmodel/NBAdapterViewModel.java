package net.one97.paytm.nativesdk.instruments.netbanking.viewmodel;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingListener;

public class NBAdapterViewModel extends BaseViewModel {
    private NetBankingListener netBankingListener;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public NBAdapterViewModel(NetBankingListener netBankingListener2) {
        super((Context) null, netBankingListener2);
        this.netBankingListener = netBankingListener2;
    }

    public static void setVisibility(View view, Boolean bool) {
        view.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public static void setTextStyle(TextView textView, int i2) {
        textView.setTypeface((Typeface) null, i2);
    }
}
