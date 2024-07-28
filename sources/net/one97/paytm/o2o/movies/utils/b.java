package net.one97.paytm.o2o.movies.utils;

import android.text.TextUtils;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;

public final class b extends Filter {

    /* renamed from: a  reason: collision with root package name */
    private final List<CJRCinemaV2> f75917a;

    /* renamed from: b  reason: collision with root package name */
    private final a f75918b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CJRMovieSessionDetails> f75919c;

    public interface a {
        void a(List<CJRCinemaV2> list);
    }

    public b(List<CJRCinemaV2> list, List<Integer> list2, List<CJRMovieSessionDetails> list3, a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Integer num : list2) {
            CJRCinemaV2 cJRCinemaV2 = new CJRCinemaV2();
            cJRCinemaV2.setId(num.toString());
            if (list.indexOf(cJRCinemaV2) != -1) {
                arrayList.add(list.get(list.indexOf(cJRCinemaV2)));
            }
        }
        this.f75917a = arrayList;
        this.f75918b = aVar;
        this.f75919c = list3;
    }

    /* access modifiers changed from: protected */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        try {
            if (charSequence.toString().trim().isEmpty()) {
                filterResults.values = this.f75917a;
                filterResults.count = this.f75917a.size();
            } else {
                ArrayList arrayList = new ArrayList();
                for (CJRCinemaV2 next : this.f75917a) {
                    if (!TextUtils.isEmpty(next.getName())) {
                        StringTokenizer stringTokenizer = new StringTokenizer(charSequence.toString().trim());
                        ArrayList arrayList2 = new ArrayList();
                        while (stringTokenizer.hasMoreTokens()) {
                            if (next.getName().toLowerCase().contains(stringTokenizer.nextToken().toLowerCase())) {
                                arrayList2.add(Boolean.TRUE);
                            } else {
                                arrayList2.add(Boolean.FALSE);
                            }
                        }
                        if (!arrayList2.contains(Boolean.FALSE)) {
                            CJRMovieSessionDetails cJRMovieSessionDetails = new CJRMovieSessionDetails();
                            cJRMovieSessionDetails.setMcinemaid(next.getId());
                            if (!this.f75919c.contains(cJRMovieSessionDetails)) {
                                arrayList.add(next);
                            }
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            new StringBuilder("-----------Filter Results--------").append(filterResults.count);
            com.paytm.utility.b.j();
        } catch (Exception unused) {
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.f75918b;
        charSequence.toString().trim();
        aVar.a((List) filterResults.values);
    }
}
