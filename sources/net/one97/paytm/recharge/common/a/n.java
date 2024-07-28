package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.d.h;
import net.one97.paytm.recharge.common.d.i;
import net.one97.paytm.recharge.common.d.j;
import net.one97.paytm.recharge.common.e.k;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class n extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<CJRAggsItem> f60632a;

    /* renamed from: b  reason: collision with root package name */
    List<CJRAggsItem> f60633b;

    /* renamed from: c  reason: collision with root package name */
    k f60634c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60635d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60636e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60637f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60638g;

    /* renamed from: h  reason: collision with root package name */
    private Context f60639h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f60640i;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((a) vVar).a(this.f60633b.get(i2));
    }

    public n(Context context, List<CJRAggsItem> list, boolean z, k kVar) {
        this.f60639h = context;
        this.f60632a = list;
        this.f60633b = list;
        this.f60640i = z;
        this.f60634c = kVar;
    }

    public final int getItemCount() {
        return this.f60633b.size();
    }

    public final int getItemViewType(int i2) {
        if (a(this.f60633b.get(i2))) {
            return R.layout.content_list_item_lpg_agency;
        }
        if (this.f60636e) {
            return R.layout.fragment_grid_operator_list_item_v2;
        }
        if (this.f60637f) {
            return R.layout.course_list_item_v2_new;
        }
        boolean z = true;
        if (i2 != getItemCount() - 1) {
            z = false;
        }
        if (!z || !this.f60638g) {
            return R.layout.course_list_item_v2;
        }
        return R.layout.content_view_refer_apartment;
    }

    public static boolean a(CJRAggsItem cJRAggsItem) {
        return !TextUtils.isEmpty(cJRAggsItem.getGasAgencyName());
    }

    public final Filter a() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                n.this.f60633b = (List) filterResults.values;
                if (n.this.f60634c != null) {
                    if (n.this.f60633b == null || !n.this.f60633b.isEmpty()) {
                        n.this.f60634c.a(false);
                    } else if (charSequence.toString().trim().length() > 0) {
                        n.this.f60634c.a(true);
                    } else {
                        n.this.f60634c.a(false);
                    }
                }
                n.this.notifyDataSetChanged();
            }

            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                boolean z;
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.count = n.this.f60632a.size();
                    filterResults.values = n.this.f60632a;
                } else {
                    String lowerCase = charSequence.toString().trim().toLowerCase(Locale.getDefault());
                    for (int i2 = 0; i2 < n.this.f60632a.size(); i2++) {
                        CJRAggsItem cJRAggsItem = n.this.f60632a.get(i2);
                        String str = lowerCase.toString();
                        if (!n.a(cJRAggsItem)) {
                            String displayValue = cJRAggsItem.getDisplayValue();
                            if (displayValue != null) {
                                z = displayValue.toLowerCase(Locale.getDefault()).contains(str);
                                arrayList.add(n.this.f60632a.get(i2));
                            }
                        } else if (cJRAggsItem.getDisplayValue().toLowerCase(Locale.getDefault()).contains(str) || cJRAggsItem.getGasAgencyName().toLowerCase(Locale.getDefault()).contains(str)) {
                            z = true;
                            if (z || (i2 == n.this.f60632a.size() - 1 && n.this.f60638g)) {
                                arrayList.add(n.this.f60632a.get(i2));
                            }
                        }
                        z = false;
                        arrayList.add(n.this.f60632a.get(i2));
                    }
                    filterResults.count = arrayList.size();
                    filterResults.values = arrayList;
                }
                return filterResults;
            }
        };
    }

    public final CJRAggsItem a(int i2) {
        List<CJRAggsItem> list = this.f60633b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f60633b.get(i2);
    }

    public static abstract class a extends RecyclerView.v {
        public abstract void a(CJRAggsItem cJRAggsItem);

        public a(View view) {
            super(view);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(this.f60639h).inflate(i2, viewGroup, false);
        if (i2 == R.layout.content_list_item_lpg_agency) {
            return new h(inflate, this.f60634c, this.f60639h);
        }
        if (i2 == R.layout.fragment_grid_operator_list_item_v2) {
            return new j(inflate, this.f60639h, Boolean.valueOf(this.f60640i), this.f60634c);
        }
        if (i2 == R.layout.content_view_refer_apartment) {
            return new net.one97.paytm.recharge.common.d.a(inflate, this.f60639h);
        }
        if (i2 == R.layout.course_list_item_v2_new) {
            return new i(inflate, this.f60639h, Boolean.valueOf(this.f60640i), this.f60634c);
        }
        return new net.one97.paytm.recharge.common.d.k(inflate, this.f60639h, Boolean.valueOf(this.f60640i), Boolean.valueOf(this.f60635d), this.f60634c);
    }
}
