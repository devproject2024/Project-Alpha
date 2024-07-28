package net.one97.paytm.nativesdk.instruments.wallet.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Utils.SingleLiveEvent;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.ToolbarState;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarEvents;

public final class WalletToolbarViewModel extends a {
    private final Application context;
    private ToolbarState currentState = ToolbarState.NONE.INSTANCE;
    private final HashMap<String, WalletDetails> map = new HashMap<>();
    private final SingleLiveEvent<WalletToolbarEvents> toolbar = new SingleLiveEvent<>();
    private final y<ToolbarState> walletSelector = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletToolbarViewModel(Application application) {
        super(application);
        k.c(application, "context");
        this.context = application;
    }

    public final Application getContext() {
        return this.context;
    }

    public final SingleLiveEvent<WalletToolbarEvents> getToolbar() {
        return this.toolbar;
    }

    public final LiveData<ToolbarState> getWalletSelection() {
        return this.walletSelector;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        r8 = (r8 = (r8 = (r8 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) kotlin.a.k.e(r8)).getBalanceInfo()).getAccountBalance()).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initializeToolbar(java.lang.String r7, net.one97.paytm.nativesdk.common.model.PaymentModes r8, net.one97.paytm.nativesdk.instruments.wallet.viewmodel.ToolbarState r9) {
        /*
            r6 = this;
            java.lang.String r0 = "walletName"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "paymentModes"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "toolbarState"
            kotlin.g.b.k.c(r9, r0)
            android.app.Application r0 = r6.context
            android.content.res.Resources r0 = r0.getResources()
            int r1 = net.one97.paytm.nativesdk.R.string.nativesdk_amount
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            net.one97.paytm.nativesdk.MerchantBL r3 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.util.ArrayList r8 = r8.getPayChannelOptions()
            if (r8 == 0) goto L_0x0047
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = kotlin.a.k.e(r8)
            net.one97.paytm.nativesdk.common.model.PayChannelOptions r8 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) r8
            if (r8 == 0) goto L_0x0047
            net.one97.paytm.nativesdk.common.model.BalanceInfo r8 = r8.getBalanceInfo()
            if (r8 == 0) goto L_0x0047
            net.one97.paytm.nativesdk.common.model.AccountBalance r8 = r8.getAccountBalance()
            if (r8 == 0) goto L_0x0047
            java.lang.String r8 = r8.getValue()
            if (r8 == 0) goto L_0x0047
            double r4 = java.lang.Double.parseDouble(r8)
            goto L_0x0049
        L_0x0047:
            r4 = 0
        L_0x0049:
            r8 = 0
            java.lang.String r3 = r3.getWithoutDoubleAmount(r4)
            r2[r8] = r3
            java.lang.String r8 = r0.getString(r1, r2)
            java.lang.String r0 = "context.getResources().g…lue)?.toDouble() ?: 0.0))"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletDetails r0 = new net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletDetails
            r0.<init>(r8, r7)
            net.one97.paytm.nativesdk.Utils.SingleLiveEvent<net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarEvents> r7 = r6.toolbar
            net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarEvents$Initialize r8 = new net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarEvents$Initialize
            r8.<init>(r0)
            r7.setValue(r8)
            java.util.HashMap<java.lang.String, net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletDetails> r7 = r6.map
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r8 = r9.getName()
            r7.put(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarViewModel.initializeToolbar(java.lang.String, net.one97.paytm.nativesdk.common.model.PaymentModes, net.one97.paytm.nativesdk.instruments.wallet.viewmodel.ToolbarState):void");
    }

    public final void selectInstrument(boolean z, ToolbarState toolbarState) {
        k.c(toolbarState, "toolbarState");
        if (!(!k.a((Object) this.currentState, (Object) toolbarState)) || z) {
            this.currentState = toolbarState;
            if (this.map.get(toolbarState.getName()) != null) {
                SingleLiveEvent<WalletToolbarEvents> singleLiveEvent = this.toolbar;
                WalletDetails walletDetails = this.map.get(toolbarState.getName());
                if (walletDetails == null) {
                    k.a();
                }
                k.a((Object) walletDetails, "map[toolbarState.name]!!");
                singleLiveEvent.setValue(new WalletToolbarEvents.Initialize(walletDetails));
            }
            this.toolbar.setValue(new WalletToolbarEvents.WalletState(z));
        }
    }

    public final void instrumentSelected() {
        ToolbarState toolbarState = this.currentState;
        if (toolbarState instanceof ToolbarState.WalletView) {
            this.walletSelector.setValue(ToolbarState.WalletView.INSTANCE);
        } else if (toolbarState instanceof ToolbarState.GiftVoucher) {
            this.walletSelector.setValue(ToolbarState.GiftVoucher.INSTANCE);
        }
    }
}
