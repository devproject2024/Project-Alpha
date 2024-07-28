package net.one97.paytm.wallet.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.paytm_finance.R;

public final class a extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f69961a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f69962b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f69963c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private C1412a f69964d;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public a(Context context, ArrayList<String> arrayList) {
        this.f69961a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f69962b = arrayList;
        ArrayList<String> arrayList2 = this.f69962b;
        if (arrayList2 != null) {
            this.f69963c.addAll(arrayList2);
        }
    }

    public final int getCount() {
        ArrayList<String> arrayList = this.f69963c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: a */
    public final String getItem(int i2) {
        return this.f69963c.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f69961a.inflate(R.layout.lyt_bank_list_item, (ViewGroup) null);
            bVar = new b(this, (byte) 0);
            bVar.f69966a = (TextView) view.findViewById(R.id.txt_name);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        String a2 = getItem(i2);
        if (!TextUtils.isEmpty(a2)) {
            bVar.f69966a.setText(a2);
        } else {
            bVar.f69966a.setText("");
        }
        return view;
    }

    public final Filter getFilter() {
        if (this.f69964d == null) {
            this.f69964d = new C1412a(this, (byte) 0);
        }
        return this.f69964d;
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f69966a;

        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }
    }

    /* renamed from: net.one97.paytm.wallet.b.a$a  reason: collision with other inner class name */
    class C1412a extends Filter {
        private C1412a() {
        }

        /* synthetic */ C1412a(a aVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = a.this.f69962b;
                filterResults.count = a.this.f69962b.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = a.this.f69962b.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!TextUtils.isEmpty(str) && str.toUpperCase().trim().contains(charSequence.toString().toUpperCase().trim())) {
                        arrayList.add(str);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList unused = a.this.f69963c = (ArrayList) filterResults.values;
            a.this.notifyDataSetChanged();
        }
    }
}
