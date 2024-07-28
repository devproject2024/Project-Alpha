package net.one97.paytm.recharge.metro.d;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.f.c;

public class p extends RecyclerView.v {

    /* renamed from: g  reason: collision with root package name */
    public static final a f63520g = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final TextView f63521a;

    /* renamed from: b  reason: collision with root package name */
    final TextView f63522b;

    /* renamed from: c  reason: collision with root package name */
    final TextView f63523c;

    /* renamed from: d  reason: collision with root package name */
    final TextView f63524d;

    /* renamed from: e  reason: collision with root package name */
    final TextView f63525e;

    /* renamed from: f  reason: collision with root package name */
    final b f63526f;

    public interface b {
        void a(View view, int i2);

        void a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List<? extends CJRActiveMetroTicketModel> list, boolean z);

        void a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, CJRActiveMetroTicketModel cJRActiveMetroTicketModel);

        void b(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, CJRActiveMetroTicketModel cJRActiveMetroTicketModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(View view, b bVar) {
        super(view);
        k.c(view, "itemView");
        this.f63526f = bVar;
        View findViewById = view.findViewById(R.id.source_destination);
        if (findViewById != null) {
            this.f63521a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.validity);
            if (findViewById2 != null) {
                this.f63522b = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.txt_view_tickets);
                if (findViewById3 != null) {
                    this.f63523c = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(R.id.txt_ticket_count);
                    if (findViewById4 != null) {
                        this.f63524d = (TextView) findViewById4;
                        View findViewById5 = view.findViewById(R.id.txt_new_ticket);
                        if (findViewById5 != null) {
                            this.f63525e = (TextView) findViewById5;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List<? extends CJRActiveMetroTicketModel> list) {
        String str;
        String str2;
        k.c(list, "ticketAndPass");
        CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) list.get(0);
        TextView textView = this.f63521a;
        View view = this.itemView;
        k.a((Object) view, "itemView");
        textView.setText(view.getContext().getString(R.string.metro_mumbai_station, new Object[]{cJRActiveMetroTicketModel.getSource(), cJRActiveMetroTicketModel.getDestination()}));
        String valid = cJRActiveMetroTicketModel.getValid();
        try {
            CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = cJRActiveMetroTicketModel.getQrCodes().get(0);
            k.a((Object) cJRActiveMetroTicketQRItemModel, "ticket.qrCodes[0]");
            valid = cJRActiveMetroTicketQRItemModel.getExpiry();
        } catch (Exception unused) {
        }
        this.f63522b.setText(valid);
        this.f63525e.setVisibility(kotlin.m.p.a("PENALTY", cJRActiveMetroTicketModel.getType(), true) ? 0 : 8);
        if (kotlin.m.p.a(c.e.RETURN.getValue(), cJRActiveMetroTicketModel.getProductType(), true)) {
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            str = view2.getContext().getString(R.string.metro_ticket_type_rjt);
        } else {
            View view3 = this.itemView;
            k.a((Object) view3, "itemView");
            str = view3.getContext().getString(R.string.metro_ticket_type_sjt);
        }
        k.a((Object) str, "if (CJRMetroUtils.Mumbai…pe_sjt)\n                }");
        TextView textView2 = this.f63524d;
        View view4 = this.itemView;
        k.a((Object) view4, "itemView");
        Context context = view4.getContext();
        int i2 = R.string.metro_count_journey_ticket;
        Object[] objArr = new Object[2];
        List<CJRActiveMetroTicketQRItemModel> qrCodes = cJRActiveMetroTicketModel.getQrCodes();
        if (qrCodes == null || (str2 = String.valueOf(qrCodes.size())) == null) {
            str2 = "";
        }
        objArr[0] = str2;
        objArr[1] = str;
        String string = context.getString(i2, objArr);
        k.a((Object) string, "itemView.context.getStri…ing() ?: \"\"), ticketType)");
        if (string != null) {
            textView2.setText(kotlin.m.p.b(string).toString());
            TextView textView3 = this.f63523c;
            View view5 = this.itemView;
            k.a((Object) view5, "itemView");
            textView3.setText(view5.getContext().getString(R.string.metro_view_tickets));
            this.itemView.setOnClickListener(new c(this));
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f63527a;

        c(p pVar) {
            this.f63527a = pVar;
        }

        public final void onClick(View view) {
            b bVar = this.f63527a.f63526f;
            if (bVar != null) {
                View view2 = this.f63527a.itemView;
                k.a((Object) view2, "itemView");
                bVar.a(view2, this.f63527a.getAdapterPosition());
            }
        }
    }
}
