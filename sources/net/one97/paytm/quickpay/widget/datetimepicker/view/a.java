package net.one97.paytm.quickpay.widget.datetimepicker.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.quick_pay.ReminderItem;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ax;

public class a extends f implements View.OnClickListener, ax.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ReminderItem> f60162a;

    /* renamed from: b  reason: collision with root package name */
    private int f60163b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.quickpay.widget.datetimepicker.b.a f60164c;

    /* renamed from: d  reason: collision with root package name */
    private View f60165d;

    /* renamed from: e  reason: collision with root package name */
    private Context f60166e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.quickpay.widget.datetimepicker.a.a f60167f;

    /* renamed from: g  reason: collision with root package name */
    private String f60168g;

    public static a a(net.one97.paytm.quickpay.widget.datetimepicker.b.a aVar, ArrayList<ReminderItem> arrayList, int i2, String str) {
        a aVar2 = new a();
        aVar2.f60164c = aVar;
        Bundle bundle = new Bundle();
        bundle.putSerializable("items", arrayList);
        bundle.putInt("picker_type", i2);
        bundle.putString("selected_item", str);
        aVar2.setArguments(bundle);
        return aVar2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context;
        int i2;
        Context context2;
        int i3;
        this.f60165d = layoutInflater.inflate(R.layout.remind_bottom_container_lyt, (ViewGroup) null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f60163b = arguments.getInt("picker_type");
            this.f60162a = (ArrayList) arguments.getSerializable("items");
            this.f60168g = arguments.getString("selected_item");
        }
        TextView textView = (TextView) this.f60165d.findViewById(R.id.remind_txt_title);
        int i4 = this.f60163b;
        if (i4 == 0 || i4 == 2) {
            context = this.f60166e;
            i2 = R.string.reminder_msg_monthy;
        } else {
            context = this.f60166e;
            i2 = R.string.reminder_msg_weekly;
        }
        textView.setText(context.getString(i2));
        TextView textView2 = (TextView) this.f60165d.findViewById(R.id.txt_select_title);
        if (this.f60163b == 0) {
            context2 = this.f60166e;
            i3 = R.string.select_a_date;
        } else {
            context2 = this.f60166e;
            i3 = R.string.select_a_day;
        }
        textView2.setText(context2.getString(i3));
        RecyclerView recyclerView = (RecyclerView) this.f60165d.findViewById(R.id.date_recycler);
        recyclerView.addOnItemTouchListener(new ax(this.f60166e, recyclerView, this));
        this.f60167f = new net.one97.paytm.quickpay.widget.datetimepicker.a.a(this.f60166e, this.f60162a, this.f60163b);
        net.one97.paytm.quickpay.widget.datetimepicker.a.a aVar = this.f60167f;
        String str = this.f60168g;
        if (!TextUtils.isEmpty(str)) {
            Iterator<ReminderItem> it2 = aVar.f60145a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ReminderItem next = it2.next();
                if (next.getItem().equalsIgnoreCase(str)) {
                    next.setSelected(true);
                    aVar.notifyItemChanged(0);
                    break;
                }
            }
        }
        int i5 = this.f60163b;
        if (i5 == 0 || i5 == 2) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f60166e, 7);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(this.f60167f);
        } else {
            GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this.f60166e, 4);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(gridLayoutManager2);
            recyclerView.setAdapter(this.f60167f);
        }
        this.f60165d.findViewById(R.id.close).setOnClickListener(this);
        return this.f60165d;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f60166e = context;
    }

    public final void a(int i2) {
        this.f60164c.a(this.f60167f.f60145a.get(i2).getItem());
        dismiss();
    }

    public void onClick(View view) {
        dismiss();
    }
}
