package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.utils.d;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public String f73060a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<CJRSeatDetailsModel>> f73061b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CJRAmParkDateTimeModel.Time> f73062c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f73063d;

    /* renamed from: e  reason: collision with root package name */
    private final String f73064e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public C1470a f73065f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Map<String, CJRAmParkDateTimeModel.Time> f73066g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private String f73067h;

    /* renamed from: net.one97.paytm.o2o.amusementpark.a.a$a  reason: collision with other inner class name */
    public interface C1470a {
        void a(CJRAmParkDateTimeModel.Time time);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public a(List<CJRAmParkDateTimeModel.Time> list, Context context, C1470a aVar, String str, String str2) {
        this.f73062c = list;
        this.f73063d = context;
        this.f73065f = aVar;
        this.f73067h = str;
        this.f73064e = str2;
    }

    public final int getCount() {
        List<CJRAmParkDateTimeModel.Time> list = this.f73062c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final Object getItem(int i2) {
        List<CJRAmParkDateTimeModel.Time> list = this.f73062c;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z;
        Context context;
        if (view == null) {
            view = LayoutInflater.from(this.f73063d).inflate(R.layout.park_booking_time_list_item, (ViewGroup) null);
            b bVar = new b(this, (byte) 0);
            bVar.f73070a = (ImageView) view.findViewById(R.id.events_book_time_radio_button_item_imageview);
            bVar.f73071b = (TextView) view.findViewById(R.id.events_time_name_textview);
            bVar.f73072c = (TextView) view.findViewById(R.id.events_time_soldout_textview);
            view.setTag(bVar);
        }
        final b bVar2 = (b) view.getTag();
        CJRAmParkDateTimeModel.Time time = this.f73062c.get(i2);
        if (this.f73061b != null) {
            List list = this.f73061b.get(this.f73060a + time.getmStart() + time.getmTo());
            if (list != null) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((CJRSeatDetailsModel) it2.next()).getSeatsAvailable() > 0) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    bVar2.f73072c.setVisibility(0);
                    TextView textView = bVar2.f73071b;
                    if (!(view == null || textView == null || (context = this.f73063d) == null)) {
                        textView.setTextColor(androidx.core.content.b.c(context, R.color.event_text_gray_color));
                    }
                    bVar2.f73070a.setImageResource(R.drawable.park_radio_button_sold_out);
                } else {
                    bVar2.f73072c.setVisibility(8);
                    view.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            CJRAmParkDateTimeModel.Time time;
                            if (!net.one97.paytm.o2o.amparkeventcommonlib.b.a.INSTANCE.validateIsAlreadyClicked(this, view)) {
                                b bVar = bVar2;
                                bVar.f73073d = !bVar.f73073d;
                                if (bVar2.f73073d) {
                                    bVar2.f73070a.setImageResource(net.one97.paytm.common.assets.R.drawable.events_radio_button_selected);
                                } else {
                                    bVar2.f73070a.setImageResource(net.one97.paytm.common.assets.R.drawable.events_radio_button_unselected);
                                }
                                String charSequence = bVar2.f73071b.getText().toString();
                                if (charSequence != null && (time = (CJRAmParkDateTimeModel.Time) a.this.f73066g.get(charSequence)) != null && a.this.f73065f != null) {
                                    a.this.f73065f.a(time);
                                }
                            }
                        }
                    });
                }
            }
        }
        String str = time.getmStart();
        String str2 = time.getmTo();
        String str3 = d.a(this.f73063d, str) + this.f73063d.getString(R.string.to) + d.a(this.f73063d, str2);
        if (str3 != null) {
            this.f73066g.put(str3, time);
            bVar2.f73071b.setText(str3);
        }
        return view;
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        ImageView f73070a;

        /* renamed from: b  reason: collision with root package name */
        TextView f73071b;

        /* renamed from: c  reason: collision with root package name */
        TextView f73072c;

        /* renamed from: d  reason: collision with root package name */
        boolean f73073d;

        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }
    }
}
