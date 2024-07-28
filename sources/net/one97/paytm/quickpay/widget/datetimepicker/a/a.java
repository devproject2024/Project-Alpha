package net.one97.paytm.quickpay.widget.datetimepicker.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.entity.quick_pay.ReminderItem;
import net.one97.paytm.paytm_finance.R;

public final class a extends RecyclerView.a<C1157a> {

    /* renamed from: a  reason: collision with root package name */
    public List<ReminderItem> f60145a;

    /* renamed from: b  reason: collision with root package name */
    private Context f60146b;

    /* renamed from: c  reason: collision with root package name */
    private int f60147c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        Resources resources;
        int i3;
        Resources resources2;
        int i4;
        C1157a aVar = (C1157a) vVar;
        ReminderItem reminderItem = this.f60145a.get(i2);
        aVar.f60148a.setText(reminderItem.getDisplay());
        LinearLayout linearLayout = aVar.f60149b;
        if (reminderItem.isSelected) {
            resources = this.f60146b.getResources();
            i3 = R.drawable.monthly_bg_drawable;
        } else {
            int i5 = this.f60147c;
            if (i5 == 0 || i5 == 2) {
                resources = this.f60146b.getResources();
                i3 = R.drawable.blank_bg_drawable;
            } else {
                resources = this.f60146b.getResources();
                i3 = R.drawable.weekly_bg_drawable;
            }
        }
        linearLayout.setBackground(resources.getDrawable(i3));
        TextView textView = aVar.f60148a;
        if (reminderItem.isSelected) {
            resources2 = this.f60146b.getResources();
            i4 = R.color.white;
        } else {
            int i6 = this.f60147c;
            if (i6 == 0 || i6 == 2) {
                resources2 = this.f60146b.getResources();
                i4 = R.color.color_222222;
            } else {
                resources2 = this.f60146b.getResources();
                i4 = R.color.color_00b9f5;
            }
        }
        textView.setTextColor(resources2.getColor(i4));
    }

    public a(Context context, List<ReminderItem> list, int i2) {
        this.f60145a = list;
        this.f60146b = context;
        this.f60147c = i2;
    }

    public final int getItemCount() {
        return this.f60145a.size();
    }

    /* renamed from: net.one97.paytm.quickpay.widget.datetimepicker.a.a$a  reason: collision with other inner class name */
    public class C1157a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60148a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f60149b;

        public C1157a(View view) {
            super(view);
            this.f60148a = (TextView) view.findViewById(R.id.txt_day_date);
            this.f60149b = (LinearLayout) view.findViewById(R.id.lyt_day_date_container);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i3 = this.f60147c;
        return new C1157a(from.inflate((i3 == 0 || i3 == 2) ? R.layout.row_select_date_bottom_lyt : R.layout.row_select_day_lyt, (ViewGroup) null));
    }
}
