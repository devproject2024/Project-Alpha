package net.one97.paytm.moneytransferv4.b.a.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55348a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static View a(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (i2 == g.WIDGET_TYPE_TITLE.getId()) {
                View inflate = from.inflate(R.layout.mt_v4_widget_type_title, viewGroup, false);
                k.a((Object) inflate, "inflater.inflate(R.layou…ype_title, parent, false)");
                return inflate;
            } else if (i2 == g.WIDGET_TYPE_SEARCH.getId()) {
                View inflate2 = from.inflate(R.layout.mt_v4_widget_type_search, viewGroup, false);
                k.a((Object) inflate2, "inflater.inflate(R.layou…pe_search, parent, false)");
                return inflate2;
            } else if (i2 == g.WIDGET_TYPE_PAYMENT_OPTIONS.getId()) {
                View inflate3 = from.inflate(R.layout.mt_v4_widget_type_options, viewGroup, false);
                k.a((Object) inflate3, "inflater.inflate(R.layou…e_options, parent, false)");
                return inflate3;
            } else if (i2 == g.WIDGET_TYPE_BENEFICIARIES.getId()) {
                View inflate4 = from.inflate(R.layout.mt_v4_widget_type_beneficiary, viewGroup, false);
                k.a((Object) inflate4, "inflater.inflate(R.layou…neficiary, parent, false)");
                return inflate4;
            } else if (i2 == g.WIDGET_TYPE_UPI_REGISTRATION.getId()) {
                View inflate5 = from.inflate(R.layout.mt_v4_upi_select_banks_grid, viewGroup, false);
                k.a((Object) inflate5, "inflater.inflate(R.layou…anks_grid, parent, false)");
                return inflate5;
            } else if (i2 == g.WIDGET_TYPE_CONTACTS.getId()) {
                View inflate6 = from.inflate(R.layout.mt_v4_widget_type_contacts, viewGroup, false);
                k.a((Object) inflate6, "inflater.inflate(R.layou…_contacts, parent, false)");
                return inflate6;
            } else if (i2 == g.WIDGET_TYPE_CONTACT_PERMISSION.getId()) {
                View inflate7 = from.inflate(R.layout.mt_v4_contact_permission_item_view, viewGroup, false);
                k.a((Object) inflate7, "inflater.inflate(R.layou…item_view, parent, false)");
                return inflate7;
            } else if (i2 == g.WIDGET_TYPE_CONTACT_MOTIF.getId()) {
                View inflate8 = from.inflate(R.layout.mt_motif_item_view, viewGroup, false);
                k.a((Object) inflate8, "inflater.inflate(R.layou…item_view, parent, false)");
                return inflate8;
            } else if (i2 == g.WIDGET_TYPE_ALL_IN_ONE.getId()) {
                View inflate9 = from.inflate(R.layout.mt_all_in_one_item_view, viewGroup, false);
                k.a((Object) inflate9, "inflater.inflate(R.layou…item_view, parent, false)");
                return inflate9;
            } else if (i2 == g.WIDGET_TYPE_ADD_BANK.getId()) {
                View inflate10 = from.inflate(R.layout.mt_v4_add_bank_widget, viewGroup, false);
                k.a((Object) inflate10, "inflater.inflate(R.layou…nk_widget, parent, false)");
                return inflate10;
            } else if (i2 == g.WIDGET_TYPE_COLLECT_REQUEST.getId()) {
                View inflate11 = from.inflate(R.layout.mt_v4_collect_request_widget, viewGroup, false);
                k.a((Object) inflate11, "inflater.inflate(R.layou…st_widget, parent, false)");
                return inflate11;
            } else {
                View inflate12 = from.inflate(R.layout.mt_v4_widget_type_title, viewGroup, false);
                k.a((Object) inflate12, "inflater.inflate(R.layou…ype_title, parent, false)");
                return inflate12;
            }
        }
    }
}
