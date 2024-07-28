package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.o2o.amusementpark.R;

public final class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List<CJRAddressDetailModel> f73075a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f73076b;

    /* renamed from: c  reason: collision with root package name */
    private Context f73077c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f73078d;

    public interface a {
        void a(String str);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public b(Context context, List<CJRAddressDetailModel> list, a aVar) {
        this.f73075a = list;
        if (context != null) {
            this.f73077c = context;
            this.f73078d = LayoutInflater.from(context);
        }
        this.f73076b = aVar;
    }

    public final int getCount() {
        List<CJRAddressDetailModel> list = this.f73075a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final Object getItem(int i2) {
        List<CJRAddressDetailModel> list = this.f73075a;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        Context context;
        if (view == null) {
            view = this.f73078d.inflate(R.layout.park_booking_venue_list_item, viewGroup, false);
            C1471b bVar = new C1471b(this, (byte) 0);
            bVar.f73081a = (ImageView) view.findViewById(R.id.events_book_venue_radio_button_item_imageview);
            bVar.f73082b = (TextView) view.findViewById(R.id.events_venue_name_textview);
            bVar.f73083c = (TextView) view.findViewById(R.id.events_venue_soldout_textview);
            bVar.f73084d = (TextView) view.findViewById(R.id.events_book_venue_desc_textview);
            view.setTag(bVar);
        }
        final C1471b bVar2 = (C1471b) view.getTag();
        CJRAddressDetailModel cJRAddressDetailModel = this.f73075a.get(i2);
        if (cJRAddressDetailModel != null && !TextUtils.isEmpty(cJRAddressDetailModel.getAddressName())) {
            bVar2.f73082b.setText(cJRAddressDetailModel.getAddressName());
        }
        if (cJRAddressDetailModel != null && !TextUtils.isEmpty(cJRAddressDetailModel.getAddress())) {
            bVar2.f73084d.setText(cJRAddressDetailModel.getAddress());
        }
        if (cJRAddressDetailModel == null || !cJRAddressDetailModel.getSoldOutInfo()) {
            bVar2.f73083c.setVisibility(8);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    C1471b bVar = bVar2;
                    bVar.f73085e = !bVar.f73085e;
                    if (bVar2.f73085e) {
                        bVar2.f73081a.setImageResource(net.one97.paytm.common.assets.R.drawable.events_radio_button_selected);
                    } else {
                        bVar2.f73081a.setImageResource(net.one97.paytm.common.assets.R.drawable.events_radio_button_unselected);
                    }
                    if (b.this.f73076b != null) {
                        b.this.f73076b.a(bVar2.f73082b.getText().toString());
                    }
                }
            });
        } else {
            bVar2.f73083c.setVisibility(0);
            TextView textView = bVar2.f73082b;
            TextView textView2 = bVar2.f73084d;
            if (!(view == null || textView == null || textView2 == null || (context = this.f73077c) == null)) {
                textView.setTextColor(androidx.core.content.b.c(context, R.color.event_text_gray_color));
                textView2.setTextColor(androidx.core.content.b.c(this.f73077c, R.color.event_text_gray_color));
            }
            bVar2.f73081a.setImageResource(R.drawable.park_radio_button_sold_out);
        }
        return view;
    }

    /* renamed from: net.one97.paytm.o2o.amusementpark.a.b$b  reason: collision with other inner class name */
    class C1471b {

        /* renamed from: a  reason: collision with root package name */
        ImageView f73081a;

        /* renamed from: b  reason: collision with root package name */
        TextView f73082b;

        /* renamed from: c  reason: collision with root package name */
        TextView f73083c;

        /* renamed from: d  reason: collision with root package name */
        TextView f73084d;

        /* renamed from: e  reason: collision with root package name */
        boolean f73085e;

        private C1471b() {
        }

        /* synthetic */ C1471b(b bVar, byte b2) {
            this();
        }
    }
}
