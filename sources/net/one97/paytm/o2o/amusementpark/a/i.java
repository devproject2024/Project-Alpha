package net.one97.paytm.o2o.amusementpark.a;

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
import net.one97.paytm.o2o.amusementpark.R;

public final class i extends RecyclerView.a<a> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private Context f73170a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRSelectCityModel> f73171b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRSelectCityModel> f73172c;

    /* renamed from: d  reason: collision with root package name */
    private String f73173d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d f73174e;

    /* renamed from: f  reason: collision with root package name */
    private a f73175f;

    /* renamed from: g  reason: collision with root package name */
    private c f73176g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f73177h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public b f73178i;

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
        ArrayList<CJRSelectCityModel> arrayList = this.f73171b;
        if (arrayList != null && arrayList.size() > 0) {
            int g2 = com.paytm.utility.b.g(this.f73170a);
            final CJRSelectCityModel cJRSelectCityModel = this.f73171b.get(i2);
            if (cJRSelectCityModel != null) {
                if (EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f73177h)) {
                    if (!cJRSelectCityModel.isEventPresent() || i2 != 0) {
                        aVar.f73184c.setVisibility(8);
                    } else {
                        aVar.f73184c.setVisibility(0);
                        aVar.f73184c.setText(R.string.header_event_present);
                    }
                    if (!cJRSelectCityModel.isEventPresent() && cJRSelectCityModel.isHeaderShown()) {
                        aVar.f73184c.setVisibility(0);
                        aVar.f73184c.setText(R.string.header_no_event_present);
                    } else if (i2 != 0) {
                        aVar.f73184c.setVisibility(8);
                    }
                    if (cJRSelectCityModel.isEventPresent()) {
                        aVar.f73183b.setTextColor(androidx.core.content.b.c(this.f73170a, R.color.color_de000000));
                    } else {
                        aVar.f73183b.setTextColor(androidx.core.content.b.c(this.f73170a, R.color.no_event_color));
                    }
                }
                if (cJRSelectCityModel.getLabel() != null) {
                    aVar.f73183b.setText(cJRSelectCityModel.getLabel());
                }
                if (cJRSelectCityModel.getValue() == null || !cJRSelectCityModel.getValue().equalsIgnoreCase(this.f73173d)) {
                    aVar.f73185d.setVisibility(8);
                } else {
                    aVar.f73185d.setVisibility(0);
                }
                if (i2 == 0) {
                    int i3 = g2 + (g2 / 2);
                    aVar.f73183b.setPadding(0, i3, 0, i3);
                    com.paytm.utility.b.c(aVar.f73183b);
                    aVar.f73183b.setTextSize(15.0f);
                    aVar.f73185d.setPadding(0, i3, 0, i3);
                } else {
                    com.paytm.utility.b.c(aVar.f73183b);
                    aVar.f73183b.setTextSize(15.0f);
                    int i4 = g2 + (g2 / 2);
                    aVar.f73183b.setPadding(0, i4, 0, i4);
                    aVar.f73185d.setPadding(0, i4, 0, i4);
                }
                if (cJRSelectCityModel.isTopCity()) {
                    com.paytm.utility.b.d(aVar.f73183b);
                } else {
                    com.paytm.utility.b.c(aVar.f73183b);
                }
                aVar.f73182a.setTag(Integer.valueOf(i2));
                aVar.f73182a.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CJRSelectCityModel cJRSelectCityModel = (CJRSelectCityModel) i.this.f73171b.get(((Integer) aVar.f73182a.getTag()).intValue());
                        if (((EventsModuleManager.MODULE_NAME.equalsIgnoreCase(i.this.f73177h) && cJRSelectCityModel != null && cJRSelectCityModel.isEventPresent()) || !EventsModuleManager.MODULE_NAME.equalsIgnoreCase(i.this.f73177h)) && i.this.f73174e != null) {
                            i.this.f73174e.c(cJRSelectCityModel);
                        }
                    }
                });
                if (i2 == 0 && i2 == getItemCount() - 1) {
                    aVar.f73186e.setVisibility(8);
                } else {
                    aVar.f73186e.setVisibility(0);
                }
            }
        }
    }

    public i(Context context, d dVar, b bVar, ArrayList<CJRSelectCityModel> arrayList, String str, String str2) {
        this.f73172c = arrayList;
        this.f73170a = context;
        this.f73174e = dVar;
        this.f73178i = bVar;
        this.f73173d = str;
        this.f73177h = str2;
        this.f73171b.addAll(arrayList);
    }

    public final int getItemCount() {
        ArrayList<CJRSelectCityModel> arrayList = this.f73171b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Filter getFilter() {
        if (this.f73176g == null) {
            this.f73176g = new c(this, (byte) 0);
        }
        return this.f73176g;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f73182a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f73183b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f73184c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f73185d;

        /* renamed from: e  reason: collision with root package name */
        public View f73186e;

        public a(View view) {
            super(view);
            this.f73182a = (RelativeLayout) view.findViewById(R.id.parent_lyt);
            this.f73183b = (TextView) view.findViewById(R.id.txt_view_event_value);
            this.f73184c = (TextView) view.findViewById(R.id.text_header);
            this.f73185d = (ImageView) view.findViewById(R.id.selected_location);
            this.f73186e = view.findViewById(R.id.divider);
        }
    }

    class c extends Filter {
        private c() {
        }

        /* synthetic */ c(i iVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            i.this.f73171b.clear();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                i.this.f73171b.clear();
            } else {
                String trim = charSequence.toString().toUpperCase().trim();
                Iterator it2 = i.this.f73172c.iterator();
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
                                        i.this.f73171b.add(cJRSelectCityModel);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                filterResults.values = i.this.f73171b;
                filterResults.count = i.this.f73171b.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (i.this.f73171b != null && i.this.f73171b.size() > 0) {
                if (EventsModuleManager.MODULE_NAME.equalsIgnoreCase(i.this.f73177h)) {
                    i.e(i.this);
                }
                i.this.f73178i.a(false, false);
            } else if (TextUtils.isEmpty(charSequence)) {
                i.this.f73178i.a(false, true);
            } else {
                i.this.f73178i.a(true, false);
            }
            i.this.notifyDataSetChanged();
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Context context = this.f73170a;
        if (context != null) {
            this.f73175f = new a(LayoutInflater.from(context).inflate(R.layout.park_city_list_item, viewGroup, false));
        }
        return this.f73175f;
    }

    static /* synthetic */ void e(i iVar) {
        ArrayList<CJRSelectCityModel> arrayList = iVar.f73171b;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList(iVar.f73171b);
            iVar.f73171b.clear();
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
            iVar.f73171b.addAll(arrayList4);
        }
    }
}
