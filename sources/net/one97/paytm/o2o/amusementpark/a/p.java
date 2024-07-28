package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.activity.AJRAmParkSelectCityActivity;

public final class p extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final List<CJRSelectCityModel> f73259a;

    /* renamed from: b  reason: collision with root package name */
    Context f73260b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<CJRSelectCityModel> f73261c;

    /* renamed from: d  reason: collision with root package name */
    String f73262d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f73263e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<CJRSelectCityModel> f73264f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f73265g;

    /* renamed from: h  reason: collision with root package name */
    private String f73266h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f73267i = false;

    public p(Context context, ArrayList<CJRSelectCityModel> arrayList, String str, String str2, List<CJRSelectCityModel> list) {
        this.f73260b = context;
        this.f73264f = arrayList;
        this.f73261c = null;
        this.f73266h = str;
        this.f73263e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f73262d = str2;
        this.f73265g = new ArrayList<>();
        this.f73259a = list;
        a();
    }

    private void a() {
        this.f73265g.clear();
        List<CJRSelectCityModel> list = this.f73259a;
        if (list != null && list.size() > 0) {
            this.f73265g.add("Recent Grid");
        }
        ArrayList<CJRSelectCityModel> arrayList = this.f73264f;
        if (arrayList != null && arrayList.size() > 0) {
            this.f73265g.add("Grid");
        }
        ArrayList<CJRSelectCityModel> arrayList2 = this.f73261c;
        if (arrayList2 != null && arrayList2.size() > 0) {
            if (!EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f73262d)) {
                this.f73265g.add("ListHead");
            }
            Iterator<CJRSelectCityModel> it2 = this.f73261c.iterator();
            while (it2.hasNext()) {
                it2.next();
                this.f73265g.add("List");
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 4) {
            return new c(this.f73263e.inflate(R.layout.park_select_top_cities_row, viewGroup, false));
        }
        if (i2 == 1) {
            return new d(this.f73263e.inflate(R.layout.park_select_top_cities_row, viewGroup, false));
        }
        if (i2 == 2) {
            return new b(this.f73263e.inflate(R.layout.park_city_list_item, viewGroup, false));
        }
        if (i2 == 3) {
            return new a(this.f73263e.inflate(R.layout.park_all_cities_header, viewGroup, false));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            if (cVar.f73280b == null) {
                Context context = this.f73260b;
                cVar.f73280b = new j(context, (AJRAmParkSelectCityActivity) context, this.f73259a);
                cVar.f73279a.setAdapter(cVar.f73280b);
                return;
            }
            cVar.f73280b.notifyDataSetChanged();
        } else if (vVar instanceof d) {
            d dVar = (d) vVar;
            if (dVar.f73283b == null) {
                Context context2 = this.f73260b;
                dVar.f73283b = new j(context2, (AJRAmParkSelectCityActivity) context2, this.f73264f);
                dVar.f73282a.setAdapter(dVar.f73283b);
                return;
            }
            dVar.f73283b.notifyDataSetChanged();
        } else if (vVar instanceof b) {
            final b bVar = (b) vVar;
            if (!EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f73262d)) {
                i2 = net.one97.paytm.o2o.amusementpark.f.b.b((List) this.f73264f) ? i2 - 1 : i2 - 2;
            } else if (!net.one97.paytm.o2o.amusementpark.f.b.b((List) this.f73264f)) {
                i2--;
            }
            final CJRSelectCityModel cJRSelectCityModel = this.f73261c.get(i2);
            if (cJRSelectCityModel != null) {
                if (EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f73262d)) {
                    if (!cJRSelectCityModel.isEventPresent() || i2 != 0) {
                        bVar.f73277e.setVisibility(8);
                    } else {
                        bVar.f73277e.setVisibility(0);
                        bVar.f73277e.setText(R.string.header_event_present);
                    }
                    if (!cJRSelectCityModel.isEventPresent() && cJRSelectCityModel.isHeaderShown()) {
                        bVar.f73277e.setVisibility(0);
                        bVar.f73277e.setText(R.string.header_no_event_present);
                    } else if (i2 != 0) {
                        bVar.f73277e.setVisibility(8);
                    }
                    if (cJRSelectCityModel.isEventPresent()) {
                        bVar.f73274b.setTextColor(androidx.core.content.b.c(this.f73260b, R.color.color_de000000));
                    } else {
                        bVar.f73274b.setTextColor(androidx.core.content.b.c(this.f73260b, R.color.no_event_color));
                    }
                }
                if (cJRSelectCityModel.getLabel() != null) {
                    bVar.f73274b.setText(cJRSelectCityModel.getLabel());
                }
                if (cJRSelectCityModel.getValue() == null || !cJRSelectCityModel.getValue().equalsIgnoreCase(this.f73266h)) {
                    bVar.f73275c.setVisibility(8);
                } else {
                    bVar.f73275c.setVisibility(0);
                }
                bVar.f73273a.setTag(Integer.valueOf(i2));
                bVar.f73273a.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CJRSelectCityModel cJRSelectCityModel = p.this.f73261c.get(((Integer) bVar.f73273a.getTag()).intValue());
                        if (((EventsModuleManager.MODULE_NAME.equalsIgnoreCase(p.this.f73262d) && cJRSelectCityModel != null && cJRSelectCityModel.isEventPresent()) || !EventsModuleManager.MODULE_NAME.equalsIgnoreCase(p.this.f73262d)) && ((AJRAmParkSelectCityActivity) p.this.f73260b) != null) {
                            AJRAmParkSelectCityActivity aJRAmParkSelectCityActivity = (AJRAmParkSelectCityActivity) p.this.f73260b;
                            CJRSelectCityModel cJRSelectCityModel2 = cJRSelectCityModel;
                            if (cJRSelectCityModel2 != null) {
                                aJRAmParkSelectCityActivity.a(cJRSelectCityModel2);
                            }
                        }
                    }
                });
                if (i2 == getItemCount()) {
                    bVar.f73276d.setVisibility(8);
                }
                if (i2 > getItemCount() - 5) {
                    Context context3 = this.f73260b;
                    if (((AJRAmParkSelectCityActivity) context3) != null && !this.f73267i) {
                        this.f73267i = true;
                        AJRAmParkSelectCityActivity aJRAmParkSelectCityActivity = (AJRAmParkSelectCityActivity) context3;
                        aJRAmParkSelectCityActivity.b();
                        aJRAmParkSelectCityActivity.c();
                    }
                }
            }
        }
    }

    public final int getItemCount() {
        ArrayList<String> arrayList = this.f73265g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f73265g.get(i2).equals("Grid")) {
            return 1;
        }
        if (this.f73265g.get(i2).equalsIgnoreCase("Recent Grid")) {
            return 4;
        }
        if (this.f73265g.get(i2).equals("List")) {
            return 2;
        }
        return this.f73265g.get(i2).equals("ListHead") ? 3 : -1;
    }

    public class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f73282a;

        /* renamed from: b  reason: collision with root package name */
        j f73283b;

        public d(View view) {
            super(view);
            this.f73282a = (RecyclerView) view.findViewById(R.id.top_cities_list);
            ((RoboTextView) view.findViewById(R.id.top_cities_header)).setText(R.string.top_cities);
            this.f73282a.setLayoutManager(new GridLayoutManager(p.this.f73260b, 4));
        }
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f73279a;

        /* renamed from: b  reason: collision with root package name */
        j f73280b;

        public c(View view) {
            super(view);
            this.f73279a = (RecyclerView) view.findViewById(R.id.top_cities_list);
            ((RoboTextView) view.findViewById(R.id.top_cities_header)).setText(R.string.recent_search_cities);
            this.f73279a.setLayoutManager(new GridLayoutManager(p.this.f73260b, 4));
            this.f73279a.setAdapter(new j(p.this.f73260b, (AJRAmParkSelectCityActivity) p.this.f73260b, p.this.f73259a));
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f73273a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f73274b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f73275c;

        /* renamed from: d  reason: collision with root package name */
        public View f73276d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f73277e;

        public b(View view) {
            super(view);
            this.f73273a = (RelativeLayout) view.findViewById(R.id.parent_lyt);
            this.f73274b = (TextView) view.findViewById(R.id.txt_view_event_value);
            this.f73277e = (TextView) view.findViewById(R.id.text_header);
            this.f73275c = (ImageView) view.findViewById(R.id.selected_location);
            this.f73276d = view.findViewById(R.id.divider);
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f73272b;

        public a(View view) {
            super(view);
            this.f73272b = (TextView) view.findViewById(R.id.header_all_cites);
        }
    }
}
