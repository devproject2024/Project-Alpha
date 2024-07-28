package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.g.d;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;

public final class o extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f60642a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f60643b = null;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f60644c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private Context f60645d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f60646a;

        /* renamed from: b  reason: collision with root package name */
        TextView f60647b;
    }

    public o(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.f60644c = arrayList;
        this.f60642a = arrayList2;
        this.f60643b = LayoutInflater.from(context);
        this.f60645d = context;
    }

    public final int getCount() {
        return this.f60644c.size();
    }

    public final Object getItem(int i2) {
        return this.f60644c.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) this.f60644c.get(i2).hashCode();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f60643b.inflate(R.layout.payment_mode_list_item, viewGroup, false);
            a aVar = new a();
            aVar.f60646a = (TextView) view.findViewById(R.id.payment_mode_label);
            aVar.f60647b = (TextView) view.findViewById(R.id.convenience_fee_text);
            view.setTag(aVar);
        }
        if (this.f60642a.size() > i2 && this.f60644c.size() > i2) {
            a aVar2 = (a) view.getTag();
            d<String, String> a2 = ba.a(this.f60644c.get(i2), view.getContext());
            if (a2 != null) {
                aVar2.f60646a.setText((CharSequence) a2.f2965b);
            }
            TextView textView = aVar2.f60647b;
            textView.setText(this.f60645d.getResources().getString(R.string.rs) + b.x(this.f60642a.get(i2)));
        }
        return view;
    }
}
