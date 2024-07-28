package net.one97.paytm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import java.util.ArrayList;
import net.one97.paytm.paytm_finance.R;

public final class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f52332a = ((LayoutInflater) this.f52335d.getSystemService("layout_inflater"));

    /* renamed from: b  reason: collision with root package name */
    private String f52333b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f52334c;

    /* renamed from: d  reason: collision with root package name */
    private Context f52335d;

    /* renamed from: e  reason: collision with root package name */
    private int f52336e;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public d(Context context, String str, ArrayList<String> arrayList, int i2) {
        this.f52335d = context;
        this.f52334c = arrayList;
        this.f52333b = str;
        this.f52336e = i2;
    }

    public final int getCount() {
        return this.f52334c.size();
    }

    public final Object getItem(int i2) {
        return this.f52334c.get(i2);
    }

    public final void a(String str) {
        this.f52333b = str;
        notifyDataSetChanged();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = this.f52332a.inflate(R.layout.contact_all_reason_single_item, (ViewGroup) null);
            aVar.f52337a = (CheckedTextView) view2.findViewById(R.id.singleItem);
            CheckedTextView checkedTextView = aVar.f52337a;
            int i3 = this.f52336e;
            checkedTextView.setPadding(i3, i3, i3, i3);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        aVar.f52337a.setText(this.f52334c.get(i2));
        if (this.f52334c.get(i2).toString().equalsIgnoreCase(this.f52333b)) {
            aVar.f52337a.setTextColor(this.f52335d.getResources().getColor(R.color.paytm_blue));
            aVar.f52337a.setCheckMarkDrawable(this.f52335d.getResources().getDrawable(R.drawable.small_success_icon_blue));
            aVar.f52337a.isChecked();
        } else {
            aVar.f52337a.setTextColor(this.f52335d.getResources().getColor(17170444));
            aVar.f52337a.setCheckMarkDrawable(this.f52335d.getResources().getDrawable(17170445));
        }
        return view2;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f52337a;

        a() {
        }
    }
}
