package net.one97.paytm.upi.passbook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.passbook.a.a;
import net.one97.paytm.upi.passbook.c.b;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.UpiConstants;

public class a extends d {
    /* access modifiers changed from: protected */
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.fragment_payment_request, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public final void f() {
        this.f67801b.setNestedScrollingEnabled(false);
        if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            this.f67801b.setLayoutManager(new LinearLayoutManager(getActivity()));
        } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            this.f67801b.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        this.f67800a.setVisibility(8);
        this.o.setVisibility(0);
        TextView textView = (TextView) this.o.findViewById(R.id.tv_section_name);
        if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            textView.setText(getString(R.string.upi_payment_requests));
        } else {
            textView.setText(getString(R.string.upi_recent_payments));
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            view.findViewById(R.id.tv_view_request).setVisibility(8);
        }
        view.findViewById(R.id.tv_view_request).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.i();
            }
        });
    }

    /* access modifiers changed from: protected */
    public final b g() {
        getActivity();
        return new net.one97.paytm.upi.passbook.c.a(g.b(), this, this.f67808i, this.j);
    }

    /* access modifiers changed from: protected */
    public final c a(a.C1377a aVar) {
        return super.a(aVar);
    }

    public final void c(boolean z) {
        if (getActivity() != null) {
            if (z) {
                this.f67803d.setVisibility(0);
                this.f67806g.setVisibility(8);
                if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
                    this.f67805f.setText(getString(R.string.upi_no_transaction));
                    this.f67804e.setImageResource(R.drawable.ic_no_upi_transactions);
                } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                    this.f67805f.setText(getString(R.string.upi_no_payment_request));
                    this.f67804e.setImageResource(R.drawable.ic_upi_empty_payment_requests);
                } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
                    this.f67805f.setText(getString(R.string.upi_no_payment_request_sent_message));
                    this.f67804e.setImageResource(R.drawable.ic_upi_empty_payment_requests);
                } else {
                    this.f67805f.setText(getString(R.string.upi_no_spam_request));
                    this.f67804e.setImageResource(R.drawable.ic_upi_empty_payment_requests);
                }
            } else {
                this.f67803d.setVisibility(8);
                this.f67806g.setVisibility(0);
            }
        }
    }

    public final void a(boolean z, boolean z2) {
        if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            Intent intent = new Intent(UpiConstants.EXTRA_ACTION_UPI_LANDING_SHOW_PENDING);
            intent.putExtra(UpiConstants.EXTRA_DO_SHOW, z || z2);
            androidx.localbroadcastmanager.a.a.a(getContext()).a(intent);
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        if (getActivity() != null) {
            if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
                CJRSendGTMTag.sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.UPI_EVENT_CATEGORY, "recent_payments_clicked", "", "", "", "/bhim-upi/landing-screen", "wallet");
                Intent intent = new Intent(getActivity(), UpiPassbookActivity.class);
                intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
                getActivity().startActivity(intent);
            } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                Intent intent2 = new Intent(getActivity(), UpiPassbookActivity.class);
                intent2.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal());
                getActivity().startActivity(intent2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (getActivity() != null) {
            if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
                CJRSendGTMTag.sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.UPI_EVENT_CATEGORY, "recent_payments_clicked", "", "", "", "/bhim-upi/landing-screen", "wallet");
                Intent intent = new Intent(getActivity(), UpiPassbookActivity.class);
                intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
                getActivity().startActivity(intent);
            } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                Intent intent2 = new Intent(getActivity(), UpiPassbookActivity.class);
                intent2.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal());
                intent2.putExtra(UpiConstants.EXTRA_INTENT_UPI_PASSBOOK_TAB, "getpendingrequestssent");
                getActivity().startActivity(intent2);
            }
        }
    }
}
