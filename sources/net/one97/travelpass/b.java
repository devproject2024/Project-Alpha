package net.one97.travelpass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30057a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static View a(net.one97.travelpass.ordersummary.b.a aVar, Context context, ViewGroup viewGroup) {
            k.c(viewGroup, "parent");
            if (aVar != null) {
                switch (c.f30313b[aVar.ordinal()]) {
                    case 1:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_header, viewGroup, false);
                    case 2:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_action, viewGroup, false);
                    case 3:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_banner, viewGroup, false);
                    case 4:
                        return LayoutInflater.from(context).inflate(R.layout.order_summery_pass_details, viewGroup, false);
                    case 5:
                        return LayoutInflater.from(context).inflate(R.layout.order_summery_pass_item_details, viewGroup, false);
                    case 6:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_cashback, viewGroup, false);
                    case 7:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_payment_detail, viewGroup, false);
                    case 8:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_terms_and_condition, viewGroup, false);
                    case 9:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_header_contact_us, viewGroup, false);
                    case 10:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_payment_detail_item, viewGroup, false);
                    case 11:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_payment_breakup_item, viewGroup, false);
                    case 12:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_refund_detail, viewGroup, false);
                    case 13:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_refund_info_item, viewGroup, false);
                    case 14:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_refund_detail_item, viewGroup, false);
                    case 15:
                        return LayoutInflater.from(context).inflate(R.layout.order_summary_wallet_refund_item, viewGroup, false);
                }
            }
            System.out.print("");
            return null;
        }
    }
}
