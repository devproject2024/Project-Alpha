package net.one97.paytm.o2o.movies.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity;
import net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRSearchCategory;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.utils.i;
import net.one97.paytm.o2o.movies.utils.n;

public final class s extends RecyclerView.a<a> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public Activity f74744a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f74745b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Object> f74746c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Object> f74747d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private b f74748e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f74749f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f74750g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f74751h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public RoboTextView f74752i;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final a aVar = (a) vVar;
        final Object obj = this.f74746c.get(i2);
        "-------Binder---------".concat(String.valueOf(obj));
        com.paytm.utility.b.j();
        if (obj instanceof CJRSearchCategory) {
            aVar.f74761b.setVisibility(0);
            aVar.f74762c.setVisibility(8);
            aVar.f74760a.setVisibility(8);
            aVar.f74761b.setText(((CJRSearchCategory) obj).getCategoryTitle());
        } else if (obj instanceof CJRMovieHomeListItem) {
            aVar.f74761b.setVisibility(8);
            aVar.f74762c.setVisibility(0);
            aVar.f74760a.setVisibility(0);
            CJRMovieHomeListItem cJRMovieHomeListItem = (CJRMovieHomeListItem) obj;
            if (!TextUtils.isEmpty(cJRMovieHomeListItem.getLang())) {
                RoboTextView roboTextView = aVar.f74762c;
                roboTextView.setText(cJRMovieHomeListItem.getLabel() + " (" + cJRMovieHomeListItem.getLang() + ")");
            } else {
                aVar.f74762c.setText(cJRMovieHomeListItem.getLabel());
            }
            aVar.f74762c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    InputMethodManager inputMethodManager;
                    StringBuilder sb = new StringBuilder("---------MOVIE------------");
                    sb.append(((CJRMovieHomeListItem) obj).getLabel());
                    sb.append("-------------MOVIE CODE-----------");
                    sb.append(((CJRMovieHomeListItem) obj).getId());
                    com.paytm.utility.b.j();
                    Intent intent = new Intent(s.this.f74744a, AJRMovieDetailsV2Activity.class);
                    ArrayList<CJRMovieHomeListItem> arrayList = new ArrayList<>();
                    arrayList.add(obj);
                    i.a().f75937g = arrayList;
                    intent.putExtra("movie_ticket_selected_item_type", "movie");
                    CJRMovieHomeListItem cJRMovieHomeListItem = (CJRMovieHomeListItem) obj;
                    intent.putExtra("movie_ticket_city_selected", s.this.f74750g);
                    intent.putExtra("movie_ticket_specific_city_selected", s.this.f74750g);
                    intent.putExtra("is_selected_movie_exists_in_selected_city", true);
                    intent.putExtra("movie_ticket_selected_format_id", cJRMovieHomeListItem.getFrmtId());
                    intent.putExtra("movie_ticket_selected_item_value", cJRMovieHomeListItem.getId());
                    if (!(s.this.f74744a == null || (inputMethodManager = (InputMethodManager) s.this.f74744a.getSystemService("input_method")) == null)) {
                        inputMethodManager.hideSoftInputFromWindow(aVar.f74762c.getWindowToken(), 0);
                    }
                    CJRMovieHomeListItem cJRMovieHomeListItem2 = (CJRMovieHomeListItem) obj;
                    StringBuilder sb2 = new StringBuilder("---- CJRMovieSearchAdapter--------Language-----");
                    sb2.append(n.b(cJRMovieHomeListItem2.getLang()));
                    sb2.append("----Title----");
                    sb2.append(cJRMovieHomeListItem2.getLabel());
                    sb2.append("-----City----");
                    com.paytm.utility.b.j();
                    s sVar = s.this;
                    String b2 = n.b(cJRMovieHomeListItem2.getLang());
                    String label = cJRMovieHomeListItem2.getLabel();
                    String a2 = s.this.f74750g;
                    if (!TextUtils.isEmpty(com.paytm.utility.b.n((Context) s.this.f74744a))) {
                        com.paytm.utility.b.n((Context) s.this.f74744a);
                    }
                    s.a(sVar, b2, label, a2, "Movie");
                    s.b(s.this);
                    s.this.f74744a.startActivity(intent);
                    s.this.f74744a.overridePendingTransition(R.anim.slide_in_right, 17432577);
                }
            });
        } else if (obj instanceof CJRCinemas) {
            final CJRCinemas cJRCinemas = (CJRCinemas) obj;
            aVar.f74761b.setVisibility(8);
            aVar.f74762c.setVisibility(0);
            aVar.f74760a.setVisibility(0);
            aVar.f74762c.setText(cJRCinemas.getName());
            aVar.f74762c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    InputMethodManager inputMethodManager;
                    StringBuilder sb = new StringBuilder("---------CINEMA------------");
                    sb.append(((CJRCinemas) obj).getName());
                    sb.append("-------------CINEMA ID-----------");
                    sb.append(((CJRCinemas) obj).getPaytmCinemaId());
                    com.paytm.utility.b.j();
                    Intent intent = new Intent(s.this.f74744a, AJRCinemaDetailsActivity.class);
                    String a2 = s.this.f74750g;
                    if (cJRCinemas.isCurrentCityCinema().intValue() == 0) {
                        a2 = TextUtils.isEmpty(s.this.f74751h) ? s.this.f74750g : s.this.f74751h;
                    }
                    intent.putExtra("movie_ticket_city_selected", a2);
                    intent.putExtra("movie_ticket_selected_item_type", "cinema");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cJRCinemas.getPaytmCinemaId());
                    intent.putExtra("movie_ticket_selected_item_value", sb2.toString());
                    if (!(s.this.f74744a == null || (inputMethodManager = (InputMethodManager) s.this.f74744a.getSystemService("input_method")) == null)) {
                        inputMethodManager.hideSoftInputFromWindow(aVar.f74762c.getWindowToken(), 0);
                    }
                    CJRCinemas cJRCinemas = (CJRCinemas) obj;
                    i.a().f75936f = cJRCinemas;
                    StringBuilder sb3 = new StringBuilder("----Cinema Frag--------CINEMA NAME-----");
                    sb3.append(cJRCinemas.getName());
                    sb3.append("------Listing Type ------Cinema");
                    com.paytm.utility.b.j();
                    s sVar = s.this;
                    String name = cJRCinemas.getName();
                    if (!TextUtils.isEmpty(com.paytm.utility.b.n((Context) s.this.f74744a))) {
                        com.paytm.utility.b.n((Context) s.this.f74744a);
                    }
                    s.a(sVar, name, a2, "Cinema");
                    s.b(s.this);
                    s.this.f74744a.startActivity(intent);
                    s.this.f74744a.overridePendingTransition(R.anim.slide_in_right, 17432577);
                }
            });
        } else {
            aVar.f74761b.setVisibility(8);
            aVar.f74762c.setVisibility(0);
            if (obj.toString().equals("3D")) {
                aVar.f74762c.setText(obj.toString().toUpperCase());
            } else {
                aVar.f74762c.setText(obj.toString());
            }
        }
    }

    public s(Activity activity, ArrayList<CJRMovieHomeListItem> arrayList, List<CJRCinemas> list, LinearLayout linearLayout, ArrayList<String> arrayList2, String str, String str2, RoboTextView roboTextView) {
        this.f74744a = activity;
        this.f74749f = linearLayout;
        this.f74750g = str;
        this.f74751h = str2;
        this.f74752i = roboTextView;
        if (arrayList != null && arrayList.size() > 0) {
            CJRSearchCategory cJRSearchCategory = new CJRSearchCategory();
            cJRSearchCategory.setmCategoryTitle(this.f74744a.getString(net.one97.paytm.o2o.movies.R.string.movie_grid_page));
            this.f74746c.add(cJRSearchCategory);
            this.f74746c.addAll(arrayList);
        }
        if (list != null && list.size() > 0) {
            CJRSearchCategory cJRSearchCategory2 = new CJRSearchCategory();
            cJRSearchCategory2.setmCategoryTitle(this.f74744a.getString(net.one97.paytm.o2o.movies.R.string.cinema_header));
            this.f74746c.add(cJRSearchCategory2);
            this.f74746c.addAll(list);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            CJRSearchCategory cJRSearchCategory3 = new CJRSearchCategory();
            cJRSearchCategory3.setmCategoryTitle(this.f74744a.getString(net.one97.paytm.o2o.movies.R.string.language_header));
            this.f74746c.add(cJRSearchCategory3);
        }
        this.f74747d = this.f74746c;
        this.f74745b = (LayoutInflater) this.f74744a.getSystemService("layout_inflater");
    }

    public final int getItemCount() {
        ArrayList<Object> arrayList = this.f74746c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Filter getFilter() {
        if (this.f74748e == null) {
            this.f74748e = new b(this, (byte) 0);
        }
        return this.f74748e;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f74760a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f74761b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f74762c;

        public a(View view) {
            super(view);
            this.f74761b = (RoboTextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.heading);
            this.f74762c = (RoboTextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.value);
            this.f74760a = view.findViewById(net.one97.paytm.o2o.movies.R.id.bottom_border);
        }
    }

    class b extends Filter {

        /* renamed from: b  reason: collision with root package name */
        private String f74765b;

        private b() {
        }

        /* synthetic */ b(s sVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            this.f74765b = (String) charSequence;
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = s.this.f74747d;
                filterResults.count = s.this.f74747d.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = s.this.f74747d.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof CJRMovieHomeListItem) {
                        CJRMovieHomeListItem cJRMovieHomeListItem = (CJRMovieHomeListItem) next;
                        if (!TextUtils.isEmpty(cJRMovieHomeListItem.getLabel())) {
                            StringTokenizer stringTokenizer = new StringTokenizer(charSequence.toString());
                            ArrayList arrayList2 = new ArrayList();
                            while (stringTokenizer.hasMoreTokens()) {
                                if (cJRMovieHomeListItem.getLabel().toLowerCase().indexOf(stringTokenizer.nextToken().toLowerCase()) != -1) {
                                    arrayList2.add(Boolean.TRUE);
                                } else {
                                    arrayList2.add(Boolean.FALSE);
                                }
                            }
                            if (!arrayList2.contains(Boolean.FALSE)) {
                                if (i3 == 0) {
                                    CJRSearchCategory cJRSearchCategory = new CJRSearchCategory();
                                    cJRSearchCategory.setmCategoryTitle(s.this.f74744a.getString(net.one97.paytm.o2o.movies.R.string.movie_grid_page));
                                    arrayList.add(cJRSearchCategory);
                                }
                                arrayList.add(next);
                                i3++;
                            }
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it3 = s.this.f74747d.iterator();
                int i4 = 0;
                while (it3.hasNext()) {
                    Object next2 = it3.next();
                    if (next2 instanceof CJRCinemas) {
                        CJRCinemas cJRCinemas = (CJRCinemas) next2;
                        if (!TextUtils.isEmpty(cJRCinemas.getName())) {
                            StringTokenizer stringTokenizer2 = new StringTokenizer(charSequence.toString());
                            ArrayList arrayList4 = new ArrayList();
                            while (stringTokenizer2.hasMoreTokens()) {
                                if (cJRCinemas.getName().toLowerCase().indexOf(stringTokenizer2.nextToken().toLowerCase()) != -1) {
                                    arrayList4.add(Boolean.TRUE);
                                } else {
                                    arrayList4.add(Boolean.FALSE);
                                }
                            }
                            if (!arrayList4.contains(Boolean.FALSE)) {
                                if (i4 == 0) {
                                    CJRSearchCategory cJRSearchCategory2 = new CJRSearchCategory();
                                    cJRSearchCategory2.setmCategoryTitle(s.this.f74744a.getString(net.one97.paytm.o2o.movies.R.string.cinema_header));
                                    arrayList.add(cJRSearchCategory2);
                                }
                                arrayList3.add(next2);
                                i4++;
                            }
                        }
                    }
                }
                arrayList.addAll(arrayList3);
                Iterator it4 = s.this.f74747d.iterator();
                while (it4.hasNext()) {
                    Object next3 = it4.next();
                    if ((next3 instanceof String) && next3.toString().trim() != null && next3.toString().toLowerCase().trim().contains(charSequence.toString().toLowerCase().trim())) {
                        if (i2 == 0) {
                            CJRSearchCategory cJRSearchCategory3 = new CJRSearchCategory();
                            cJRSearchCategory3.setmCategoryTitle(s.this.f74744a.getString(net.one97.paytm.o2o.movies.R.string.language_header));
                            arrayList.add(cJRSearchCategory3);
                        }
                        arrayList.add(next3.toString());
                        i2++;
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            new StringBuilder("-----------Filter Results--------").append(filterResults.count);
            com.paytm.utility.b.j();
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList unused = s.this.f74746c = (ArrayList) filterResults.values;
            if (s.this.f74746c == null || s.this.f74746c.size() != 0) {
                s.this.f74749f.setVisibility(8);
                s.this.notifyDataSetChanged();
                return;
            }
            new StringBuilder("-----------Condition Satisfied mCurrentSearchList--------").append(s.this.f74746c.size());
            com.paytm.utility.b.j();
            s.this.notifyDataSetChanged();
            s.this.f74749f.setVisibility(0);
            new StringBuilder("------Search Text------").append(this.f74765b);
            com.paytm.utility.b.j();
            s.this.f74752i.setText(s.this.f74744a.getString(net.one97.paytm.o2o.movies.R.string.movies_err_msg, new Object[]{this.f74765b}));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f74744a).inflate(net.one97.paytm.o2o.movies.R.layout.movies_search_item, viewGroup, false));
    }

    static /* synthetic */ void a(s sVar, String str, String str2, String str3, String str4) {
        try {
            StringBuilder sb = new StringBuilder("-------------CJRMovieSearch----- searchCategory---");
            sb.append(str);
            sb.append("------movieName ----");
            sb.append(str2);
            sb.append("------cinemaName-----");
            sb.append((String) null);
            sb.append("----cityName----");
            sb.append(str3);
            sb.append("---listingType--");
            sb.append(str4);
            com.paytm.utility.b.j();
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.x);
            hashMap.put("movie_search_category", str);
            String str5 = "";
            if (str2 != null) {
                str5 = str2 + "|NA";
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Homescreen-".concat(String.valueOf(str2)));
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) sVar.f74744a)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) sVar.f74744a));
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str5);
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, sVar.f74744a);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void b(s sVar) {
        try {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEvents("mov_search_performed", sVar.f74744a);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(s sVar, String str, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder("-------------CJRMovieSearch---- searchCategory---");
            sb.append((String) null);
            sb.append("------movieName ----");
            sb.append((String) null);
            sb.append("------cinemaName-----");
            sb.append(str);
            sb.append("----cityName----");
            sb.append(str2);
            sb.append("---listingType--");
            sb.append(str3);
            com.paytm.utility.b.j();
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.x);
            hashMap.put("movie_search_category", (Object) null);
            String str4 = "";
            if (str != null) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Homescreen-".concat(String.valueOf(str)));
                str4 = "NA|".concat(String.valueOf(str));
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str4);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) sVar.f74744a)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) sVar.f74744a));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, sVar.f74744a);
        } catch (Exception unused) {
        }
    }
}
