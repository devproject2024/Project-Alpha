package net.one97.paytm.o2o.movies.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.q;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage;
import net.one97.paytm.o2o.movies.d.f;

public final class q extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f74727a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f74728b;

    /* renamed from: c  reason: collision with root package name */
    f f74729c;

    /* renamed from: d  reason: collision with root package name */
    private CJRMovieShowTimeFilterDataStorage f74730d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage;
        a aVar = (a) vVar;
        String str = this.f74727a.get(i2);
        if (!TextUtils.isEmpty(str) && (cJRMovieShowTimeFilterDataStorage = this.f74730d) != null && cJRMovieShowTimeFilterDataStorage.f75183e != null && !this.f74730d.f75183e.isEmpty()) {
            if (this.f74730d.f75183e.contains(str)) {
                aVar.f74731a.setSelected(true);
                aVar.f74731a.setTextColor(-1);
            } else {
                aVar.f74731a.setSelected(false);
                aVar.f74731a.setTextColor(androidx.core.content.b.c(aVar.f74731a.getContext(), R.color.color_00b9f5));
            }
        }
        aVar.f74731a.setText(this.f74727a.get(i2));
    }

    public q(ArrayList<String> arrayList, CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage, f fVar) {
        f fVar2;
        this.f74727a = arrayList;
        this.f74730d = cJRMovieShowTimeFilterDataStorage;
        this.f74729c = fVar;
        ArrayList<String> arrayList2 = this.f74727a;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.f74728b = new ArrayList<>(this.f74727a.size());
        }
        CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage2 = this.f74730d;
        if (cJRMovieShowTimeFilterDataStorage2 != null && cJRMovieShowTimeFilterDataStorage2.f75183e != null && !this.f74730d.f75183e.isEmpty() && (fVar2 = this.f74729c) != null) {
            fVar2.a(this.f74730d.f75183e);
            this.f74728b.addAll(this.f74730d.f75183e);
        }
    }

    public final int getItemCount() {
        ArrayList<String> arrayList = this.f74727a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74731a;

        /* synthetic */ a(q qVar, View view, byte b2) {
            this(view);
        }

        private a(View view) {
            super(view);
            this.f74731a = (TextView) view.findViewById(R.id.movie_format_name);
            this.f74731a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    q.a.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            String str = q.this.f74727a.get(getAdapterPosition());
            if (this.f74731a.isSelected()) {
                this.f74731a.setSelected(false);
                TextView textView = this.f74731a;
                textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.color_00b9f5));
                if (q.this.f74728b.contains(str)) {
                    q.this.f74728b.remove(str);
                }
            } else {
                this.f74731a.setSelected(true);
                this.f74731a.setTextColor(-1);
                if (!q.this.f74728b.contains(str)) {
                    q.this.f74728b.add(str);
                }
            }
            q qVar = q.this;
            new b(qVar.f74729c, q.this.f74728b).start();
        }
    }

    class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        f f74733a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<String> f74734b;

        b(f fVar, ArrayList<String> arrayList) {
            this.f74733a = fVar;
            this.f74734b = arrayList;
        }

        public final void run() {
            super.run();
            f fVar = this.f74733a;
            if (fVar != null) {
                fVar.a(this.f74734b);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_format_list_item, (ViewGroup) null, false), (byte) 0);
    }
}
