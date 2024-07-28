package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.k;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class y extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    ExpandableListView f60729a;

    /* renamed from: b  reason: collision with root package name */
    private Context f60730b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<CJRAggsItem> f60731c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<CJRAggsItem> f60732d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f60733e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public k f60734f;

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
        return true;
    }

    public y(Context context, List<CJRAggsItem> list, ExpandableListView expandableListView, String str, k kVar) {
        this.f60730b = context;
        this.f60731c = list;
        this.f60732d = list;
        this.f60729a = expandableListView;
        this.f60733e = str;
        this.f60734f = kVar;
    }

    public final int getGroupCount() {
        List<CJRAggsItem> list = this.f60731c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getChildrenCount(int i2) {
        if (!"accordion".equalsIgnoreCase(this.f60733e) || this.f60731c.get(i2).getAggs() == null) {
            return 0;
        }
        return this.f60731c.get(i2).getAggs().size();
    }

    public final Object getGroup(int i2) {
        return this.f60731c.get(i2);
    }

    public final Object getChild(int i2, int i3) {
        return this.f60731c.get(i2).getAggs().get(i3);
    }

    public final View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        ExpandableListView expandableListView;
        CJRAggsItem cJRAggsItem = (CJRAggsItem) getGroup(i2);
        String displayValue = cJRAggsItem != null ? cJRAggsItem.getDisplayValue() : null;
        if (view == null) {
            view = ((LayoutInflater) this.f60730b.getSystemService("layout_inflater")).inflate(R.layout.layout_expandable_list_header, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.text_list_header);
        ImageView imageView = (ImageView) view.findViewById(R.id.group_drop_down_img);
        if (imageView != null) {
            if (cJRAggsItem == null || cJRAggsItem.getAggs() == null || cJRAggsItem.getAggs().size() <= 0 || !"accordion".equalsIgnoreCase(this.f60733e)) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            if (z) {
                imageView.setImageResource(R.drawable.up);
            } else {
                imageView.setImageResource(R.drawable.down);
            }
        }
        if (textView != null) {
            textView.setText(displayValue);
        }
        if (!(cJRAggsItem == null || !cJRAggsItem.getShouldExpand() || (expandableListView = this.f60729a) == null)) {
            expandableListView.expandGroup(i2);
        }
        return view;
    }

    public final View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        CJRAggsItem cJRAggsItem = (CJRAggsItem) getChild(i2, i3);
        if (cJRAggsItem != null) {
            String displayValue = cJRAggsItem.getDisplayValue();
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_expandable_list_child, viewGroup, false);
            }
            try {
                ((TextView) view.findViewById(R.id.text_list_child)).setText(displayValue);
                return view;
            } catch (NullPointerException unused) {
            }
        }
        return null;
    }
}
