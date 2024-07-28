package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.amPark.CJRAmParkAutosuggestEventItem;
import net.one97.paytm.o2o.amusementpark.R;

public final class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRAmParkAutosuggestEventItem> f73138a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f73139b;

    /* renamed from: c  reason: collision with root package name */
    private Context f73140c;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public f(Context context, ArrayList<CJRAmParkAutosuggestEventItem> arrayList) {
        this.f73140c = context;
        if (this.f73140c != null) {
            this.f73139b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
        this.f73138a = arrayList;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        int g2 = b.g(this.f73140c);
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 1) {
            view = this.f73139b.inflate(R.layout.park_city_list_item, (ViewGroup) null);
        } else if (itemViewType == 2) {
            view = this.f73139b.inflate(R.layout.park_search_header, (ViewGroup) null);
        }
        a aVar = new a(this, (byte) 0);
        if (2 == itemViewType) {
            aVar.f73141a = (TextView) view.findViewById(R.id.txt_view_event_search_header);
        } else if (1 == itemViewType) {
            aVar.f73141a = (TextView) view.findViewById(R.id.txt_view_event_value);
        }
        view.setTag(aVar);
        aVar.f73141a.setText(this.f73138a.get(i2).getParkName());
        aVar.f73141a.setTag(this.f73138a.get(i2));
        if (i2 == 0) {
            int i3 = g2 + (g2 / 2);
            aVar.f73141a.setPadding(0, i3, 0, i3);
            b.c(aVar.f73141a);
            aVar.f73141a.setTextSize(15.0f);
        } else {
            b.c(aVar.f73141a);
            aVar.f73141a.setTextSize(15.0f);
            int i4 = g2 + (g2 / 2);
            aVar.f73141a.setPadding(0, i4, 0, i4);
        }
        b.c(aVar.f73141a);
        return view;
    }

    public final int getCount() {
        ArrayList<CJRAmParkAutosuggestEventItem> arrayList = this.f73138a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: a */
    public final CJRAmParkAutosuggestEventItem getItem(int i2) {
        ArrayList<CJRAmParkAutosuggestEventItem> arrayList = this.f73138a;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        return null;
    }

    public final int getItemViewType(int i2) {
        ArrayList<CJRAmParkAutosuggestEventItem> arrayList = this.f73138a;
        if (arrayList != null) {
            return arrayList.get(i2).getType();
        }
        return -1;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f73141a;

        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }
    }
}
