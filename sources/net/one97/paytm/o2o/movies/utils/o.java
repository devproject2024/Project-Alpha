package net.one97.paytm.o2o.movies.utils;

import android.text.TextUtils;
import android.widget.Filter;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieSessionDetails;

public final class o extends Filter {

    /* renamed from: a  reason: collision with root package name */
    private final List<CJRMovieSessionDetails> f75973a;

    /* renamed from: b  reason: collision with root package name */
    private final a f75974b;

    public interface a {
        void onFilterCompleted(String str, List<CJRMovieSessionDetails> list);
    }

    public o(List<CJRMovieSessionDetails> list, a aVar) {
        this.f75973a = list;
        this.f75974b = aVar;
    }

    /* access modifiers changed from: protected */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        try {
            if (charSequence.toString().trim().isEmpty()) {
                filterResults.values = this.f75973a;
                filterResults.count = this.f75973a.size();
            } else {
                ArrayList arrayList = new ArrayList();
                for (CJRMovieSessionDetails next : this.f75973a) {
                    if (!TextUtils.isEmpty(next.getMcinemaName())) {
                        StringTokenizer stringTokenizer = new StringTokenizer(charSequence.toString().trim());
                        ArrayList arrayList2 = new ArrayList();
                        while (stringTokenizer.hasMoreTokens()) {
                            if (next.getMcinemaName().toLowerCase().contains(stringTokenizer.nextToken().toLowerCase())) {
                                arrayList2.add(Boolean.TRUE);
                            } else {
                                arrayList2.add(Boolean.FALSE);
                            }
                        }
                        if (!arrayList2.contains(Boolean.FALSE)) {
                            arrayList.add(next);
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            new StringBuilder("-----------Filter Results--------").append(filterResults.count);
            b.j();
        } catch (Exception unused) {
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        this.f75974b.onFilterCompleted(charSequence.toString().trim(), (List) filterResults.values);
    }
}
