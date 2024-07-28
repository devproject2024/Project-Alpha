package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRPaymentOptions;
import net.one97.paytm.recharge.R;

public final class x extends BaseExpandableListAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRPaymentOptions> f60709a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f60710b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f60711c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ExpandableListView f60712d;

    /* renamed from: e  reason: collision with root package name */
    private RadioButton f60713e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public c f60714f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CJRPaymentOptions f60715g;

    public interface c {
        void a(CJRPaymentOptions cJRPaymentOptions);
    }

    public final long getChildId(int i2, int i3) {
        return (long) i3;
    }

    public final long getGroupId(int i2) {
        return (long) i2;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i2, int i3) {
        return false;
    }

    public x(Context context, c cVar, ExpandableListView expandableListView, ArrayList<CJRPaymentOptions> arrayList, CJRPaymentOptions cJRPaymentOptions) {
        this.f60710b = context;
        this.f60714f = cVar;
        this.f60709a = arrayList;
        this.f60712d = expandableListView;
        this.f60711c = (LayoutInflater) this.f60710b.getSystemService("layout_inflater");
        this.f60715g = cJRPaymentOptions;
    }

    public final int getGroupCount() {
        return this.f60709a.size();
    }

    public final int getChildrenCount(int i2) {
        if (this.f60709a.get(i2).getDisplayValues() != null) {
            return this.f60709a.get(i2).getDisplayValues().size();
        }
        return 0;
    }

    public final Object getGroup(int i2) {
        return this.f60709a.get(i2);
    }

    public final Object getChild(int i2, int i3) {
        return this.f60709a.get(i2).getDisplayValues();
    }

    public final View getGroupView(final int i2, final boolean z, View view, ViewGroup viewGroup) {
        final b bVar;
        if (view == null) {
            view = this.f60711c.inflate(R.layout.utility_amount_selection_group_item, (ViewGroup) null);
            bVar = new b();
            bVar.f60725a = (TextView) view.findViewById(R.id.ums_label_textView);
            bVar.f60726b = (TextView) view.findViewById(R.id.ums_price_textView);
            bVar.f60727c = (RadioButton) view.findViewById(R.id.ums_radio);
            bVar.f60728d = (TextView) view.findViewById(R.id.ums_view_details_textView);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f60725a.setText(this.f60709a.get(i2).getLabel());
        TextView textView = bVar.f60726b;
        textView.setText(this.f60710b.getString(R.string.rupee_symbol) + this.f60709a.get(i2).getAmount());
        bVar.f60728d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!z) {
                    bVar.f60728d.setText(x.this.f60710b.getString(R.string.hide_details));
                    x.this.f60712d.expandGroup(i2);
                    return;
                }
                x.this.f60712d.collapseGroup(i2);
                bVar.f60728d.setText(x.this.f60710b.getString(R.string.view_details_re));
            }
        });
        CJRPaymentOptions cJRPaymentOptions = this.f60715g;
        if (cJRPaymentOptions == null || !cJRPaymentOptions.equals(this.f60709a.get(i2))) {
            bVar.f60727c.setChecked(false);
        } else {
            bVar.f60727c.setChecked(true);
            this.f60715g = this.f60709a.get(i2);
            this.f60714f.a(this.f60709a.get(i2));
        }
        bVar.f60727c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                bVar.f60727c.setChecked(true);
                x xVar = x.this;
                CJRPaymentOptions unused = xVar.f60715g = (CJRPaymentOptions) xVar.f60709a.get(i2);
                x.this.notifyDataSetChanged();
                x.this.f60714f.a((CJRPaymentOptions) x.this.f60709a.get(i2));
            }
        });
        return view;
    }

    public final View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f60711c.inflate(R.layout.utility_amount_selection_child_item, (ViewGroup) null);
            aVar = new a();
            aVar.f60723a = (TextView) view.findViewById(R.id.ums_child_label_textView);
            aVar.f60724b = (TextView) view.findViewById(R.id.ums_child_price_textView);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f60723a.setText(this.f60709a.get(i2).getDisplayValues().get(i3).getLabel());
        if (TextUtils.isEmpty(aVar.f60723a.getText()) || !aVar.f60723a.getText().toString().toLowerCase().contains("amount")) {
            aVar.f60724b.setText(this.f60709a.get(i2).getDisplayValues().get(i3).getValue());
        } else {
            TextView textView = aVar.f60724b;
            textView.setText(this.f60710b.getString(R.string.rupee_symbol) + this.f60709a.get(i2).getDisplayValues().get(i3).getValue());
        }
        return view;
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f60725a;

        /* renamed from: b  reason: collision with root package name */
        TextView f60726b;

        /* renamed from: c  reason: collision with root package name */
        RadioButton f60727c;

        /* renamed from: d  reason: collision with root package name */
        TextView f60728d;

        b() {
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f60723a;

        /* renamed from: b  reason: collision with root package name */
        TextView f60724b;

        a() {
        }
    }
}
