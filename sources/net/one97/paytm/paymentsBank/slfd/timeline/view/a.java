package net.one97.paytm.paymentsBank.slfd.timeline.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.mapping.e;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.timeline.utils.SlfdDottedVerticalLine;
import net.one97.paytm.paymentsBank.slfd.timeline.view.TimelineSlfdActivity;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19400a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<TimelineSlfdActivity.a> f19401b;

    public a(Context context, ArrayList<TimelineSlfdActivity.a> arrayList) {
        k.c(context, "context");
        k.c(arrayList, "listData");
        this.f19400a = context;
        this.f19401b = arrayList;
    }

    public final int getItemCount() {
        return this.f19401b.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (i2 == this.f19401b.size() - 2) {
            TimelineSlfdActivity.a aVar = this.f19401b.get(i2);
            k.a((Object) aVar, "listData.get(position)");
            ((C0345a) vVar).a(aVar, true, false, this.f19400a);
        } else if (i2 == this.f19401b.size() - 1) {
            TimelineSlfdActivity.a aVar2 = this.f19401b.get(i2);
            k.a((Object) aVar2, "listData.get(position)");
            ((C0345a) vVar).a(aVar2, false, true, this.f19400a);
        } else {
            TimelineSlfdActivity.a aVar3 = this.f19401b.get(i2);
            k.a((Object) aVar3, "listData.get(position)");
            ((C0345a) vVar).a(aVar3, false, false, this.f19400a);
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f19400a).inflate(R.layout.time_line_slfd_item, viewGroup, false);
        k.a((Object) inflate, "v");
        return new C0345a(inflate);
    }

    /* renamed from: net.one97.paytm.paymentsBank.slfd.timeline.view.a$a  reason: collision with other inner class name */
    public static final class C0345a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0345a(View view) {
            super(view);
            k.c(view, "itemView");
        }

        public final void a(TimelineSlfdActivity.a aVar, boolean z, boolean z2, Context context) {
            k.c(aVar, "_list");
            k.c(context, "context");
            View view = this.itemView;
            k.a((Object) view, "itemView");
            TextView textView = (TextView) view.findViewById(R.id.tv_timeline_label);
            k.a((Object) textView, "itemView.tv_timeline_label");
            textView.setText(aVar.f19391a);
            String str = aVar.f19392b;
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            TextView textView2 = (TextView) view2.findViewById(R.id.tv_timeline_amount);
            k.a((Object) textView2, "itemView.tv_timeline_amount");
            a(str, context, textView2);
            View view3 = this.itemView;
            k.a((Object) view3, "itemView");
            ImageView imageView = (ImageView) view3.findViewById(R.id.img_blue_tick);
            k.a((Object) imageView, "itemView.img_blue_tick");
            imageView.setVisibility(0);
            View view4 = this.itemView;
            k.a((Object) view4, "itemView");
            ((ImageView) view4.findViewById(R.id.img_blue_tick)).setImageDrawable(b.a(context, R.drawable.pb_ic_order_tick));
            View view5 = this.itemView;
            k.a((Object) view5, "itemView");
            TextView textView3 = (TextView) view5.findViewById(R.id.tv_timeline_details);
            k.a((Object) textView3, "itemView.tv_timeline_details");
            textView3.setText(aVar.f19393c);
            if (z) {
                View view6 = this.itemView;
                k.a((Object) view6, "itemView");
                View findViewById = view6.findViewById(R.id.view_solid);
                k.a((Object) findViewById, "itemView.view_solid");
                findViewById.setVisibility(8);
                View view7 = this.itemView;
                k.a((Object) view7, "itemView");
                SlfdDottedVerticalLine slfdDottedVerticalLine = (SlfdDottedVerticalLine) view7.findViewById(R.id.view_dotted);
                k.a((Object) slfdDottedVerticalLine, "itemView.view_dotted");
                slfdDottedVerticalLine.setVisibility(0);
            }
            if (z2) {
                View view8 = this.itemView;
                k.a((Object) view8, "itemView");
                View findViewById2 = view8.findViewById(R.id.view_solid);
                k.a((Object) findViewById2, "itemView.view_solid");
                findViewById2.setVisibility(8);
                View view9 = this.itemView;
                k.a((Object) view9, "itemView");
                SlfdDottedVerticalLine slfdDottedVerticalLine2 = (SlfdDottedVerticalLine) view9.findViewById(R.id.view_dotted);
                k.a((Object) slfdDottedVerticalLine2, "itemView.view_dotted");
                slfdDottedVerticalLine2.setVisibility(8);
                View view10 = this.itemView;
                k.a((Object) view10, "itemView");
                ((ImageView) view10.findViewById(R.id.img_blue_tick)).setImageDrawable(b.a(context, R.drawable.pb_ic_order_tick_empty));
            }
        }

        private static void a(String str, Context context, TextView textView) {
            k.c(context, "context");
            k.c(textView, "tv_amount");
            aa aaVar = aa.f47921a;
            String string = context.getString(R.string.fd_amount, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(str)});
            k.a((Object) string, "context.getString(R.stri…ty.priceToString(amount))");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            e.a(format, textView);
        }
    }
}
