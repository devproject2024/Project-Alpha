package net.one97.paytm.o2o.movies.adapter;

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
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRMoviesSelectCityActivity;

public final class bc extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final List<CJRSelectCityModel> f74545a;

    /* renamed from: b  reason: collision with root package name */
    Context f74546b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<CJRSelectCityModel> f74547c;

    /* renamed from: d  reason: collision with root package name */
    String f74548d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f74549e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<CJRSelectCityModel> f74550f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f74551g;

    /* renamed from: h  reason: collision with root package name */
    private String f74552h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f74553i = false;

    public bc(Context context, ArrayList<CJRSelectCityModel> arrayList, ArrayList<CJRSelectCityModel> arrayList2, String str, String str2, List<CJRSelectCityModel> list) {
        this.f74546b = context;
        this.f74550f = arrayList;
        this.f74547c = arrayList2;
        this.f74552h = str;
        this.f74549e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f74548d = str2;
        this.f74551g = new ArrayList<>();
        this.f74545a = list;
        a();
    }

    private void a() {
        this.f74551g.clear();
        List<CJRSelectCityModel> list = this.f74545a;
        if (list != null && list.size() > 0) {
            this.f74551g.add("Recent Grid");
        }
        ArrayList<CJRSelectCityModel> arrayList = this.f74550f;
        if (arrayList != null && arrayList.size() > 0) {
            this.f74551g.add("Grid");
        }
        ArrayList<CJRSelectCityModel> arrayList2 = this.f74547c;
        if (arrayList2 != null && arrayList2.size() > 0) {
            if (!EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f74548d)) {
                this.f74551g.add("ListHead");
            }
            Iterator<CJRSelectCityModel> it2 = this.f74547c.iterator();
            while (it2.hasNext()) {
                it2.next();
                this.f74551g.add("List");
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 4) {
            return new c(this.f74549e.inflate(R.layout.select_top_cities_row, viewGroup, false));
        }
        if (i2 == 1) {
            return new d(this.f74549e.inflate(R.layout.select_top_cities_row, viewGroup, false));
        }
        if (i2 == 2) {
            return new b(this.f74549e.inflate(R.layout.movies_city_list_item, viewGroup, false));
        }
        if (i2 == 3) {
            return new a(this.f74549e.inflate(R.layout.all_cities_header, viewGroup, false));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            if (cVar.f74566b == null) {
                Context context = this.f74546b;
                cVar.f74566b = new af(context, (AJRMoviesSelectCityActivity) context, this.f74545a);
                cVar.f74565a.setAdapter(cVar.f74566b);
                return;
            }
            cVar.f74566b.notifyDataSetChanged();
        } else if (vVar instanceof d) {
            d dVar = (d) vVar;
            if (dVar.f74569b == null) {
                Context context2 = this.f74546b;
                dVar.f74569b = new af(context2, (AJRMoviesSelectCityActivity) context2, this.f74550f);
                dVar.f74568a.setAdapter(dVar.f74569b);
                return;
            }
            dVar.f74569b.notifyDataSetChanged();
        } else if (vVar instanceof b) {
            final b bVar = (b) vVar;
            if (!EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f74548d)) {
                i2 = net.one97.paytm.o2o.movies.common.d.a((List) this.f74550f) ? i2 - 1 : i2 - 2;
            } else if (!net.one97.paytm.o2o.movies.common.d.a((List) this.f74550f)) {
                i2--;
            }
            final CJRSelectCityModel cJRSelectCityModel = this.f74547c.get(i2);
            if (cJRSelectCityModel != null) {
                if (EventsModuleManager.MODULE_NAME.equalsIgnoreCase(this.f74548d)) {
                    if (!cJRSelectCityModel.isEventPresent() || i2 != 0) {
                        bVar.f74563e.setVisibility(8);
                    } else {
                        bVar.f74563e.setVisibility(0);
                        bVar.f74563e.setText(R.string.header_event_present);
                    }
                    if (!cJRSelectCityModel.isEventPresent() && cJRSelectCityModel.isHeaderShown()) {
                        bVar.f74563e.setVisibility(0);
                        bVar.f74563e.setText(R.string.header_no_event_present);
                    } else if (i2 != 0) {
                        bVar.f74563e.setVisibility(8);
                    }
                    if (cJRSelectCityModel.isEventPresent()) {
                        bVar.f74560b.setTextColor(androidx.core.content.b.c(this.f74546b, net.one97.paytm.common.assets.R.color.color_de000000));
                    } else {
                        bVar.f74560b.setTextColor(androidx.core.content.b.c(this.f74546b, R.color.no_event_color));
                    }
                }
                if (cJRSelectCityModel.getLabel() != null) {
                    bVar.f74560b.setText(cJRSelectCityModel.getLabel());
                }
                if (cJRSelectCityModel.getValue() == null || !cJRSelectCityModel.getValue().equalsIgnoreCase(this.f74552h)) {
                    bVar.f74561c.setVisibility(8);
                } else {
                    bVar.f74561c.setVisibility(0);
                }
                bVar.f74559a.setTag(Integer.valueOf(i2));
                bVar.f74559a.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CJRSelectCityModel cJRSelectCityModel = bc.this.f74547c.get(((Integer) bVar.f74559a.getTag()).intValue());
                        if (((EventsModuleManager.MODULE_NAME.equalsIgnoreCase(bc.this.f74548d) && cJRSelectCityModel != null && cJRSelectCityModel.isEventPresent()) || !EventsModuleManager.MODULE_NAME.equalsIgnoreCase(bc.this.f74548d)) && ((AJRMoviesSelectCityActivity) bc.this.f74546b) != null) {
                            AJRMoviesSelectCityActivity aJRMoviesSelectCityActivity = (AJRMoviesSelectCityActivity) bc.this.f74546b;
                            CJRSelectCityModel cJRSelectCityModel2 = cJRSelectCityModel;
                            if (cJRSelectCityModel2 != null) {
                                aJRMoviesSelectCityActivity.a(cJRSelectCityModel2.getValue());
                                aJRMoviesSelectCityActivity.a(cJRSelectCityModel2);
                            }
                        }
                    }
                });
                if (i2 == getItemCount()) {
                    bVar.f74562d.setVisibility(8);
                }
                if (i2 > getItemCount() - 5) {
                    Context context3 = this.f74546b;
                    if (((AJRMoviesSelectCityActivity) context3) != null && !this.f74553i) {
                        this.f74553i = true;
                        AJRMoviesSelectCityActivity aJRMoviesSelectCityActivity = (AJRMoviesSelectCityActivity) context3;
                        aJRMoviesSelectCityActivity.a();
                        aJRMoviesSelectCityActivity.b();
                    }
                }
            }
        }
    }

    public final int getItemCount() {
        ArrayList<String> arrayList = this.f74551g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f74551g.get(i2).equals("Grid")) {
            return 1;
        }
        if (this.f74551g.get(i2).equalsIgnoreCase("Recent Grid")) {
            return 4;
        }
        if (this.f74551g.get(i2).equals("List")) {
            return 2;
        }
        return this.f74551g.get(i2).equals("ListHead") ? 3 : -1;
    }

    public class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f74568a;

        /* renamed from: b  reason: collision with root package name */
        af f74569b;

        public d(View view) {
            super(view);
            this.f74568a = (RecyclerView) view.findViewById(R.id.top_cities_list);
            ((RoboTextView) view.findViewById(R.id.top_cities_header)).setText(R.string.top_cities);
            this.f74568a.setLayoutManager(new GridLayoutManager(bc.this.f74546b, 4));
        }
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f74565a;

        /* renamed from: b  reason: collision with root package name */
        af f74566b;

        public c(View view) {
            super(view);
            this.f74565a = (RecyclerView) view.findViewById(R.id.top_cities_list);
            ((RoboTextView) view.findViewById(R.id.top_cities_header)).setText(R.string.recent_search_cities);
            this.f74565a.setLayoutManager(new GridLayoutManager(bc.this.f74546b, 4));
            this.f74565a.setAdapter(new af(bc.this.f74546b, (AJRMoviesSelectCityActivity) bc.this.f74546b, bc.this.f74545a));
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f74559a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f74560b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f74561c;

        /* renamed from: d  reason: collision with root package name */
        public View f74562d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f74563e;

        public b(View view) {
            super(view);
            this.f74559a = (RelativeLayout) view.findViewById(R.id.parent_lyt);
            this.f74560b = (TextView) view.findViewById(R.id.txt_view_event_value);
            this.f74563e = (TextView) view.findViewById(R.id.text_header);
            this.f74561c = (ImageView) view.findViewById(R.id.selected_location);
            this.f74562d = view.findViewById(R.id.divider);
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f74558b;

        public a(View view) {
            super(view);
            this.f74558b = (TextView) view.findViewById(R.id.header_all_cites);
        }
    }
}
