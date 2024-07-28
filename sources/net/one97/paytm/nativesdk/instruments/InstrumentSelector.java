package net.one97.paytm.nativesdk.instruments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.nativesdk.instruments.wallet.view.WalletView;

public final class InstrumentSelector {
    private final DirectPaymentBL directBl;
    private List<? extends PaytmBaseView> instruments;
    private boolean walletAutoSelected;

    public InstrumentSelector(List<? extends PaytmBaseView> list, DirectPaymentBL directPaymentBL) {
        k.c(list, "instruments");
        k.c(directPaymentBL, "directBl");
        this.instruments = list;
        this.directBl = directPaymentBL;
    }

    public final DirectPaymentBL getDirectBl() {
        return this.directBl;
    }

    public final List<PaytmBaseView> getInstruments() {
        return this.instruments;
    }

    public final void setInstruments(List<? extends PaytmBaseView> list) {
        k.c(list, "<set-?>");
        this.instruments = list;
    }

    public final PaytmBaseView selectNextInstrument() {
        int i2;
        if (this.instruments.isEmpty()) {
            return null;
        }
        List<? extends PaytmBaseView> list = this.instruments;
        ListIterator<? extends PaytmBaseView> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (((PaytmBaseView) listIterator.previous()).isSelected()) {
                    i2 = listIterator.nextIndex();
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        return selectInstrument(i2 + 1);
    }

    public final PaytmBaseView selectNextInstrument(String str) {
        k.c(str, "instrumentName");
        if (this.instruments.isEmpty()) {
            return null;
        }
        int i2 = 0;
        Iterator<? extends PaytmBaseView> it2 = this.instruments.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (p.a(str, ((PaytmBaseView) it2.next()).getInstrumentName(), true)) {
                break;
            } else {
                i2++;
            }
        }
        return selectInstrument(i2 + 1);
    }

    private final PaytmBaseView selectInstrument(int i2) {
        if (ExtensionsKt.hasIndex(this.instruments, i2)) {
            while (ExtensionsKt.hasIndex(this.instruments, i2) && ((PaytmBaseView) this.instruments.get(i2)).isDisabled()) {
                if (this.instruments.get(i2) instanceof UpiPushView) {
                    Object obj = this.instruments.get(i2);
                    if (obj == null) {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView");
                    } else if (k.a((Object) ((UpiPushView) obj).transactionErrorCode, (Object) SDKConstants.UPI_LIMIT_EXCEED_ERROR)) {
                        break;
                    }
                }
                i2++;
            }
            if (ExtensionsKt.hasIndex(this.instruments, i2)) {
                boolean z = this.instruments.get(i2) instanceof WalletView;
                if (z && this.walletAutoSelected && SDKConstants.ADDANDPAY.equals(this.directBl.getPaymentFlowAvailable()) && SDKConstants.HYBRID.equals(this.directBl.getSelectedPaymentMode())) {
                    i2++;
                    if (!ExtensionsKt.hasIndex(this.instruments, i2)) {
                        return null;
                    }
                } else if (z) {
                    this.walletAutoSelected = true;
                }
                return (PaytmBaseView) this.instruments.get(i2);
            }
        }
        return null;
    }

    public final void resetInstruments(List<? extends PaytmBaseView> list) {
        k.c(list, "instruments");
        this.instruments = list;
    }

    public final int getNumberOfInstrumentsSelected() {
        Collection arrayList = new ArrayList();
        for (Object next : this.instruments) {
            PaytmBaseView paytmBaseView = (PaytmBaseView) next;
            if (paytmBaseView.isSelected() && !paytmBaseView.isDisabled()) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).size();
    }
}
