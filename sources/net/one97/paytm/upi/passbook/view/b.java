package net.one97.paytm.upi.passbook.view;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CJRReplacementReason;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends o {

    /* renamed from: a  reason: collision with root package name */
    private Context f67741a;

    /* renamed from: b  reason: collision with root package name */
    private CJRReplacementReason f67742b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f67743c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f67744d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f67745e;

    /* renamed from: f  reason: collision with root package name */
    private int f67746f;

    public b(Context context, j jVar, CJRReplacementReason cJRReplacementReason, boolean z, int i2, boolean z2, boolean z3) {
        super(jVar);
        this.f67741a = context;
        this.f67742b = cJRReplacementReason;
        this.f67743c = z;
        this.f67744d = z2;
        this.f67746f = i2;
        this.f67745e = z3;
    }

    public final Fragment getItem(int i2) {
        if (this.f67746f == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, this.f67742b);
            bundle.putInt(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
            bundle.getBoolean(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, this.f67743c);
            bundle.putBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST, this.f67744d);
            dVar.setArguments(bundle);
            return dVar;
        } else if (this.f67746f == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
            d dVar2 = new d();
            Bundle bundle2 = new Bundle();
            if (i2 == 0) {
                bundle2.putInt(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal());
                bundle2.getBoolean(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, this.f67743c);
            } else {
                bundle2.putInt(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal());
                bundle2.getBoolean(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, this.f67743c);
            }
            bundle2.putBoolean(CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, this.f67745e);
            bundle2.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, this.f67742b);
            dVar2.setArguments(bundle2);
            return dVar2;
        } else if (this.f67746f != UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            return null;
        } else {
            d dVar3 = new d();
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, this.f67742b);
            bundle3.putInt(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal());
            bundle3.getBoolean(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, this.f67743c);
            dVar3.setArguments(bundle3);
            return dVar3;
        }
    }

    public final int getCount() {
        if (this.f67746f == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            return 1;
        }
        if (this.f67746f == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
            return 2;
        }
        if (this.f67746f == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            return 1;
        }
        return 0;
    }

    public final CharSequence getPageTitle(int i2) {
        if (this.f67746f == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            if (this.f67742b != null) {
                return this.f67741a.getString(R.string.cst_upi_passbook_tab_transaction);
            }
            return this.f67741a.getString(R.string.upi_passbook_tab_transaction);
        } else if (this.f67746f == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
            if (i2 == 0) {
                if (this.f67742b != null) {
                    return this.f67741a.getString(R.string.cst_upi_passbook_tab_pending_requests);
                }
                return this.f67741a.getString(R.string.upi_received_text);
            } else if (this.f67742b != null) {
                return this.f67741a.getString(R.string.cst_upi_passbook_tab_pending_requests);
            } else {
                return this.f67741a.getString(R.string.upi_sent_text);
            }
        } else if (this.f67746f != UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            return "";
        } else {
            if (this.f67742b != null) {
                return this.f67741a.getString(R.string.upi_spam_folder_new);
            }
            return this.f67741a.getString(R.string.upi_spam_folder_new);
        }
    }
}
