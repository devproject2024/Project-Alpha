package net.one97.travelpass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.g.b.k;
import net.one97.travelpass.ui.b.b;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30337a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static View a(b bVar, Context context, ViewGroup viewGroup) {
            k.c(viewGroup, "parent");
            if (bVar != null) {
                switch (g.f30470b[bVar.ordinal()]) {
                    case 1:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_images, viewGroup, false);
                    case 2:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_price_details, viewGroup, false);
                    case 3:
                        return LayoutInflater.from(context).inflate(R.layout.vh_pass_details, viewGroup, false);
                    case 4:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_benefits, viewGroup, false);
                    case 5:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_internal_offers, viewGroup, false);
                    case 6:
                        return LayoutInflater.from(context).inflate(R.layout.vh_tp_tabs, viewGroup, false);
                    case 7:
                        return LayoutInflater.from(context).inflate(R.layout.vh_tp_tab_item, viewGroup, false);
                    case 8:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_how_to_use_items, viewGroup, false);
                    case 9:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_faq_items, viewGroup, false);
                    case 10:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_teams, viewGroup, false);
                    case 11:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_button, viewGroup, false);
                    case 12:
                        return LayoutInflater.from(context).inflate(R.layout.vh_know_more, viewGroup, false);
                    case 13:
                        return LayoutInflater.from(context).inflate(R.layout.vh_know_more_item, viewGroup, false);
                    case 14:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_benefit_item, viewGroup, false);
                    case 15:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_offer, viewGroup, false);
                    case 16:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_header_info_layout, viewGroup, false);
                    case 17:
                        return LayoutInflater.from(context).inflate(R.layout.vh_pass_details_info_container, viewGroup, false);
                    case 18:
                        return LayoutInflater.from(context).inflate(R.layout.vh_faq_details, viewGroup, false);
                    case 19:
                        return LayoutInflater.from(context).inflate(R.layout.vh_my_passes_header_info_layout, viewGroup, false);
                    case 20:
                        return LayoutInflater.from(context).inflate(R.layout.vh_travel_header_user_info_layout, viewGroup, false);
                    case 21:
                        return LayoutInflater.from(context).inflate(R.layout.vh_pass_notify_layout, viewGroup, false);
                }
            }
            System.out.print("");
            return null;
        }
    }
}
