package net.one97.paytm.nativesdk.instruments.wallet.widgets;

import android.app.Application;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletDetails;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarEvents;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarViewModel;

public final class StickyToolbar extends LinearLayout {
    private HashMap _$_findViewCache;
    private boolean animate;
    private View backArrow;
    private CheckBox checkboxWallet;
    private View downArrow;
    private boolean showWallet;
    private View toolbar;
    private TextView toolbarOrderDetail;
    private TextView toolbarTitle;
    private TextView toolbarTxnAmount;
    private View toolbarWallet;
    private View toolbarWalletCheckboxContainer;
    private TextView walletBalance;
    private TextView walletName;

    public StickyToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickyToolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
        View inflate = LayoutInflater.from(context).inflate(R.layout.instrument_toolbar, this, true);
        ao aoVar = (ao) context;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ai a2 = new al(aoVar, (al.b) new al.a((Application) applicationContext)).a(WalletToolbarViewModel.class);
            k.a((Object) a2, "ViewModelProvider((conte…barViewModel::class.java)");
            final WalletToolbarViewModel walletToolbarViewModel = (WalletToolbarViewModel) a2;
            View findViewById = inflate.findViewById(R.id.toolbar);
            k.a((Object) findViewById, "view.findViewById(R.id.toolbar)");
            this.toolbar = findViewById;
            View findViewById2 = inflate.findViewById(R.id.iv_back_arrow_toolbar);
            k.a((Object) findViewById2, "view.findViewById(R.id.iv_back_arrow_toolbar)");
            this.backArrow = findViewById2;
            View findViewById3 = inflate.findViewById(R.id.txt_title_toolbar);
            k.a((Object) findViewById3, "view.findViewById(R.id.txt_title_toolbar)");
            this.toolbarTitle = (TextView) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.txt_amount_toolbar);
            k.a((Object) findViewById4, "view.findViewById(R.id.txt_amount_toolbar)");
            this.toolbarTxnAmount = (TextView) findViewById4;
            View findViewById5 = inflate.findViewById(R.id.txt_order_detail_toolbar);
            k.a((Object) findViewById5, "view.findViewById(R.id.txt_order_detail_toolbar)");
            this.toolbarOrderDetail = (TextView) findViewById5;
            View findViewById6 = inflate.findViewById(R.id.toolbar_wallet_layout);
            k.a((Object) findViewById6, "view.findViewById(R.id.toolbar_wallet_layout)");
            this.toolbarWallet = findViewById6;
            View findViewById7 = inflate.findViewById(R.id.ivDownArrow_toolbar);
            k.a((Object) findViewById7, "view.findViewById(R.id.ivDownArrow_toolbar)");
            this.downArrow = findViewById7;
            View findViewById8 = inflate.findViewById(R.id.toolbar_wallet_layout);
            k.a((Object) findViewById8, "view.findViewById(R.id.toolbar_wallet_layout)");
            this.toolbarWalletCheckboxContainer = findViewById8;
            View findViewById9 = inflate.findViewById(R.id.cb_wallet);
            k.a((Object) findViewById9, "view.findViewById(R.id.cb_wallet)");
            this.checkboxWallet = (CheckBox) findViewById9;
            View findViewById10 = inflate.findViewById(R.id.txt_wallet_name);
            k.a((Object) findViewById10, "view.findViewById(R.id.txt_wallet_name)");
            this.walletName = (TextView) findViewById10;
            View findViewById11 = inflate.findViewById(R.id.tv_toolbar_wallet_balance);
            k.a((Object) findViewById11, "view.findViewById(R.id.tv_toolbar_wallet_balance)");
            this.walletBalance = (TextView) findViewById11;
            inflate.findViewById(R.id.wallet_checkbox_layout).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    walletToolbarViewModel.instrumentSelected();
                }
            });
            walletToolbarViewModel.getToolbar().observe((q) context, new z<WalletToolbarEvents>(this) {
                final /* synthetic */ StickyToolbar this$0;

                {
                    this.this$0 = r1;
                }

                public final void onChanged(WalletToolbarEvents walletToolbarEvents) {
                    StickyToolbar stickyToolbar = this.this$0;
                    if (walletToolbarEvents == null) {
                        k.a();
                    }
                    stickyToolbar.observerToolbarEvents(walletToolbarEvents);
                }
            });
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Application");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StickyToolbar(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* access modifiers changed from: private */
    public final void observerToolbarEvents(WalletToolbarEvents walletToolbarEvents) {
        if (walletToolbarEvents instanceof WalletToolbarEvents.RefreshWalletToolbar) {
            refreshWalletView();
        } else if (walletToolbarEvents instanceof WalletToolbarEvents.Initialize) {
            initializeWalletView(((WalletToolbarEvents.Initialize) walletToolbarEvents).getWalletDetails());
        } else if (walletToolbarEvents instanceof WalletToolbarEvents.WalletState) {
            changeWalletState(((WalletToolbarEvents.WalletState) walletToolbarEvents).getChecked());
        }
    }

    private final void changeWalletState(boolean z) {
        if (z) {
            this.toolbarWalletCheckboxContainer.setVisibility(0);
        } else {
            this.toolbarWalletCheckboxContainer.setVisibility(8);
        }
        selectWalletInstrument(z);
    }

    private final void initializeWalletView(WalletDetails walletDetails) {
        setWalletBalance(walletDetails.getWalletBalance());
        setWalletName(walletDetails.getWalletName());
    }

    private final void refreshWalletView() {
        if (this.checkboxWallet.isChecked()) {
            this.toolbarWalletCheckboxContainer.setVisibility(0);
        } else {
            this.toolbarWalletCheckboxContainer.setVisibility(8);
        }
    }

    public final void showToolbar(boolean z) {
        ExtensionsKt.setVisibility(this.toolbar, z);
    }

    public final void setOnBackPressListener(b<? super View, x> bVar) {
        k.c(bVar, "clickListener");
        this.backArrow.setOnClickListener(new StickyToolbar$setOnBackPressListener$1(bVar));
    }

    public final void setToolbarTitle(String str) {
        k.c(str, "title");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (!instance.isSubsCriptionFlow()) {
            this.toolbarTitle.setText(str);
        } else if (PaytmSDK.isSubsDetailAvailable()) {
            if (getContext() != null) {
                this.toolbarTitle.setText(getContext().getString(R.string.amount_to_be_paid));
            }
            this.toolbarOrderDetail.setText(getContext().getString(R.string.subscription_details));
        } else {
            this.toolbarTitle.setText(getContext().getString(R.string.amount_to_be_paid));
            this.downArrow.setVisibility(8);
        }
    }

    private final void amountZeroSubscriptionLabel(String str) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_subs_zero_amount_label);
        k.a((Object) textView, "tv_subs_zero_amount_label");
        textView.setVisibility(0);
    }

    public final void setToolbarAmount(String str) {
        k.c(str, "amount");
        this.toolbarTxnAmount.setText(str);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isSubsCriptionFlow() && SDKUtility.isSubscriptionAmountZero()) {
            amountZeroSubscriptionLabel(str);
        }
    }

    public final void setOrderDetailOnClickListener(b<? super View, x> bVar) {
        k.c(bVar, "clickListener");
        this.toolbarOrderDetail.setOnClickListener(new StickyToolbar$setOrderDetailOnClickListener$1(bVar));
    }

    public final void showOrderDetailToolbarVisibility(boolean z) {
        ExtensionsKt.setVisibility(this.toolbarOrderDetail, z);
    }

    public final void showWalletView(boolean z) {
        ExtensionsKt.setVisibility(this.toolbarWallet, z);
    }

    public final void setdownArrowVisibility(boolean z) {
        ExtensionsKt.setVisibility(this.downArrow, z);
    }

    public final void setdownArrowOnClickListener(b<? super View, x> bVar) {
        k.c(bVar, "clickListener");
        this.downArrow.setOnClickListener(new StickyToolbar$setdownArrowOnClickListener$1(bVar));
    }

    public final void setWalletLayoutOnClickListener(b<? super View, x> bVar) {
        k.c(bVar, "clickListener");
        this.toolbarWalletCheckboxContainer.setOnClickListener(new StickyToolbar$setWalletLayoutOnClickListener$1(bVar));
    }

    public final boolean isWalletChecked() {
        return this.checkboxWallet.isChecked();
    }

    public final void selectWalletInstrument(boolean z) {
        this.checkboxWallet.setChecked(z);
    }

    public final void setWalletName(String str) {
        k.c(str, "name");
        this.walletName.setText(str);
    }

    public final void setWalletBalance(String str) {
        k.c(str, "balance");
        this.walletBalance.setText(str);
    }

    public final void setAnimate(boolean z) {
        this.animate = z;
    }

    public final void setWalletView(boolean z) {
        this.showWallet = z;
    }

    public final void toggleToolbarVisibility() {
        ExtensionsKt.toggleVisibility(this.toolbar, Boolean.TRUE);
    }

    public final int isToolbarVisible() {
        View view = this.toolbar;
        return (view != null ? Integer.valueOf(view.getVisibility()) : null).intValue();
    }

    public final void setToolbarColor(int i2) {
        this.toolbar.setBackgroundColor(i2);
    }
}
