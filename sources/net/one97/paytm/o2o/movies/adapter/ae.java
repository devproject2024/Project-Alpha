package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.utils.h;

public final class ae extends RecyclerView.a<a> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private Context f74282a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRSelectCityModel> f74283b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRSelectCityModel> f74284c;

    /* renamed from: d  reason: collision with root package name */
    private String f74285d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d f74286e;

    /* renamed from: f  reason: collision with root package name */
    private a f74287f;

    /* renamed from: g  reason: collision with root package name */
    private c f74288g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f74289h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public b f74290i;

    public interface b {
        void a(boolean z, boolean z2);
    }

    public interface d {
        void c(CJRSelectCityModel cJRSelectCityModel);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final a aVar = (a) vVar;
        ArrayList<CJRSelectCityModel> arrayList = this.f74283b;
        if (arrayList != null && arrayList.size() > 0) {
            final CJRSelectCityModel cJRSelectCityModel = this.f74283b.get(i2);
            int g2 = com.paytm.utility.b.g(this.f74282a);
            if (cJRSelectCityModel != null) {
                if (EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f74289h)) {
                    if (!cJRSelectCityModel.isEventPresent() || i2 != 0) {
                        aVar.f74296c.setVisibility(8);
                    } else {
                        aVar.f74296c.setVisibility(0);
                        aVar.f74296c.setText(R.string.header_event_present);
                    }
                    if (!cJRSelectCityModel.isEventPresent() && cJRSelectCityModel.isHeaderShown()) {
                        aVar.f74296c.setVisibility(0);
                        aVar.f74296c.setText(R.string.header_no_event_present);
                    } else if (i2 != 0) {
                        aVar.f74296c.setVisibility(8);
                    }
                    if (cJRSelectCityModel.isEventPresent()) {
                        aVar.f74295b.setTextColor(androidx.core.content.b.c(this.f74282a, net.one97.paytm.common.assets.R.color.color_de000000));
                    } else {
                        aVar.f74295b.setTextColor(androidx.core.content.b.c(this.f74282a, R.color.no_event_color));
                    }
                }
                TextView textView = aVar.f74295b;
                h hVar = h.f75928a;
                textView.setText(h.a(cJRSelectCityModel));
                if (cJRSelectCityModel.getValue() == null || !cJRSelectCityModel.getValue().equalsIgnoreCase(this.f74285d)) {
                    aVar.f74297d.setVisibility(8);
                } else {
                    aVar.f74297d.setVisibility(0);
                }
                if (i2 == 0) {
                    int i3 = g2 + (g2 / 2);
                    aVar.f74295b.setPadding(0, i3, 0, i3);
                    com.paytm.utility.b.c(aVar.f74295b);
                    aVar.f74295b.setTextSize(15.0f);
                    aVar.f74297d.setPadding(0, i3, 0, i3);
                } else {
                    com.paytm.utility.b.c(aVar.f74295b);
                    aVar.f74295b.setTextSize(15.0f);
                    int i4 = g2 + (g2 / 2);
                    aVar.f74295b.setPadding(0, i4, 0, i4);
                    aVar.f74297d.setPadding(0, i4, 0, i4);
                }
                if (cJRSelectCityModel.isTopCity()) {
                    com.paytm.utility.b.d(aVar.f74295b);
                } else {
                    com.paytm.utility.b.c(aVar.f74295b);
                }
                aVar.f74294a.setTag(Integer.valueOf(i2));
                aVar.f74294a.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CJRSelectCityModel cJRSelectCityModel = (CJRSelectCityModel) ae.this.f74283b.get(((Integer) aVar.f74294a.getTag()).intValue());
                        if (((EventsModuleManager.MODULE_NAME.equalsIgnoreCase(ae.this.f74289h) && cJRSelectCityModel != null && cJRSelectCityModel.isEventPresent()) || !EventsModuleManager.MODULE_NAME.equalsIgnoreCase(ae.this.f74289h)) && ae.this.f74286e != null) {
                            ae.this.f74286e.c(cJRSelectCityModel);
                        }
                    }
                });
                if (i2 == 0 && i2 == getItemCount() - 1) {
                    aVar.f74298e.setVisibility(8);
                } else {
                    aVar.f74298e.setVisibility(0);
                }
            }
        }
    }

    public ae(Context context, d dVar, b bVar, ArrayList<CJRSelectCityModel> arrayList, String str, String str2) {
        this.f74284c = arrayList;
        this.f74282a = context;
        this.f74286e = dVar;
        this.f74290i = bVar;
        this.f74285d = str;
        this.f74289h = str2;
        this.f74283b.addAll(arrayList);
    }

    public final int getItemCount() {
        ArrayList<CJRSelectCityModel> arrayList = this.f74283b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Filter getFilter() {
        if (this.f74288g == null) {
            this.f74288g = new c(this, (byte) 0);
        }
        return this.f74288g;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f74294a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f74295b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f74296c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f74297d;

        /* renamed from: e  reason: collision with root package name */
        public View f74298e;

        public a(View view) {
            super(view);
            this.f74294a = (RelativeLayout) view.findViewById(R.id.parent_lyt);
            this.f74295b = (TextView) view.findViewById(R.id.txt_view_event_value);
            this.f74296c = (TextView) view.findViewById(R.id.text_header);
            this.f74297d = (ImageView) view.findViewById(R.id.selected_location);
            this.f74298e = view.findViewById(R.id.divider);
        }
    }

    class c extends Filter {
        private c() {
        }

        /* synthetic */ c(ae aeVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayList = new ArrayList();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                arrayList.clear();
            } else {
                String trim = charSequence.toString().toUpperCase().trim();
                Iterator it2 = ae.this.f74284c.iterator();
                while (it2.hasNext()) {
                    CJRSelectCityModel cJRSelectCityModel = (CJRSelectCityModel) it2.next();
                    if (cJRSelectCityModel != null && cJRSelectCityModel.getLabel() != null) {
                        cJRSelectCityModel.setHeaderShown(false);
                        List<String> list = cJRSelectCityModel.getmSeachKeys();
                        if (list != null && list.size() > 0) {
                            Iterator<String> it3 = list.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (it3.next().toUpperCase().trim().startsWith(trim)) {
                                        arrayList.add(cJRSelectCityModel);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList arrayList;
            try {
                arrayList = (ArrayList) filterResults.values;
            } catch (Exception unused) {
                arrayList = null;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (arrayList.size() > 0) {
                if (EventsModuleManager.MODULE_NAME.equalsIgnoreCase(ae.this.f74289h)) {
                    ae.a(arrayList);
                }
                ae.this.f74290i.a(false, false);
            } else if (TextUtils.isEmpty(charSequence)) {
                ae.this.f74290i.a(false, true);
            } else {
                ae.this.f74290i.a(true, false);
            }
            ae.a(ae.this, arrayList);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Context context = this.f74282a;
        if (context != null) {
            this.f74287f = new a(LayoutInflater.from(context).inflate(R.layout.movies_city_list_item, viewGroup, false));
        }
        return this.f74287f;
    }

    static /* synthetic */ void a(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList(arrayList);
            arrayList.clear();
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                CJRSelectCityModel cJRSelectCityModel = (CJRSelectCityModel) it2.next();
                if (!cJRSelectCityModel.isTopCity()) {
                    if (cJRSelectCityModel.isEventPresent()) {
                        arrayList2.add(cJRSelectCityModel);
                    } else {
                        arrayList3.add(cJRSelectCityModel);
                    }
                }
            }
            arrayList4.clear();
            arrayList4.addAll(arrayList2);
            if (!arrayList4.isEmpty()) {
                ((CJRSelectCityModel) arrayList4.get(0)).setHeaderShown(true);
            }
            int size = arrayList4.size();
            if (!arrayList3.isEmpty()) {
                arrayList4.addAll(arrayList3);
                ((CJRSelectCityModel) arrayList4.get(size)).setHeaderShown(true);
            }
            arrayList.addAll(arrayList4);
        }
    }

    static /* synthetic */ void a(ae aeVar, ArrayList arrayList) {
        aeVar.f74283b = arrayList;
        aeVar.notifyDataSetChanged();
    }
}
