package net.one97.paytm.nativesdk.instruments.wallet.viewmodel;

import kotlin.g.b.g;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public abstract class ToolbarState {
    private final String name;

    public static final class WalletView extends ToolbarState {
        public static final WalletView INSTANCE = new WalletView();

        private WalletView() {
            super("wallet", (g) null);
        }
    }

    private ToolbarState(String str) {
        this.name = str;
    }

    public /* synthetic */ ToolbarState(String str, g gVar) {
        this(str);
    }

    public final String getName() {
        return this.name;
    }

    public static final class GiftVoucher extends ToolbarState {
        public static final GiftVoucher INSTANCE = new GiftVoucher();

        private GiftVoucher() {
            super("Gift Voucher", (g) null);
        }
    }

    public static final class NONE extends ToolbarState {
        public static final NONE INSTANCE = new NONE();

        private NONE() {
            super(SDKConstants.NATIVE_SDK_NONE, (g) null);
        }
    }
}
