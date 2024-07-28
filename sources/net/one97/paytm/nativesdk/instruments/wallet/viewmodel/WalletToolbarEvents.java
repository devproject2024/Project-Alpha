package net.one97.paytm.nativesdk.instruments.wallet.viewmodel;

import kotlin.g.b.g;
import kotlin.g.b.k;

public abstract class WalletToolbarEvents {
    private WalletToolbarEvents() {
    }

    public /* synthetic */ WalletToolbarEvents(g gVar) {
        this();
    }

    public static final class Initialize extends WalletToolbarEvents {
        private final WalletDetails walletDetails;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Initialize(WalletDetails walletDetails2) {
            super((g) null);
            k.c(walletDetails2, "walletDetails");
            this.walletDetails = walletDetails2;
        }

        public final WalletDetails getWalletDetails() {
            return this.walletDetails;
        }
    }

    public static final class RefreshWalletToolbar extends WalletToolbarEvents {
        public static final RefreshWalletToolbar INSTANCE = new RefreshWalletToolbar();

        private RefreshWalletToolbar() {
            super((g) null);
        }
    }

    public static final class WalletState extends WalletToolbarEvents {
        private final boolean checked;

        public WalletState(boolean z) {
            super((g) null);
            this.checked = z;
        }

        public final boolean getChecked() {
            return this.checked;
        }
    }

    public static final class WalletSelected extends WalletToolbarEvents {
        public static final WalletSelected INSTANCE = new WalletSelected();

        private WalletSelected() {
            super((g) null);
        }
    }
}
