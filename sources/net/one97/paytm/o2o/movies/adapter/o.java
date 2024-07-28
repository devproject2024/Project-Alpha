package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.movies.CJRMovieEntertainmentModel;
import net.one97.paytm.o2o.movies.adapter.o;

public final class o extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRMovieEntertainmentModel> f74689a;

    /* renamed from: b  reason: collision with root package name */
    b f74690b;

    /* renamed from: c  reason: collision with root package name */
    Context f74691c;

    public interface b {
        void a(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        CJRMovieEntertainmentModel cJRMovieEntertainmentModel = this.f74689a.get(i2);
        Drawable b2 = androidx.appcompat.a.a.a.b(this.f74691c, R.drawable.android_amusement_park_placeholder_bg);
        t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory());
        aVar.f74692a.getContext();
        t.a(cJRMovieEntertainmentModel.getImageUrl(), 0, b2, b2, aVar.f74692a);
        if (!TextUtils.isEmpty(a(cJRMovieEntertainmentModel.getDateOfUpload()))) {
            aVar.f74693b.setText(a(cJRMovieEntertainmentModel.getDateOfUpload()));
        }
        aVar.f74694c.setText(cJRMovieEntertainmentModel.getDescription());
        aVar.f74694c.setSingleLine(false);
        aVar.f74694c.setEllipsize(TextUtils.TruncateAt.END);
        aVar.f74694c.setLines(2);
    }

    public o(Context context, ArrayList<CJRMovieEntertainmentModel> arrayList, b bVar) {
        this.f74691c = context;
        this.f74689a = arrayList;
        this.f74690b = bVar;
    }

    public final int getItemCount() {
        ArrayList<CJRMovieEntertainmentModel> arrayList = this.f74689a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f74692a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74693b;

        /* renamed from: c  reason: collision with root package name */
        TextView f74694c;

        public a(View view) {
            super(view);
            this.f74692a = (ImageView) view.findViewById(net.one97.paytm.o2o.movies.R.id.movie_entertainment_thumb);
            this.f74693b = (TextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.release_time);
            this.f74694c = (TextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.entertainment_title);
            view.setOnClickListener(new View.OnClickListener(view) {
                private final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    o.a.this.a(this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view, View view2) {
            if (com.paytm.utility.b.c(view.getContext())) {
                o.this.f74690b.a(o.this.f74689a.get(getAdapterPosition()).getBlogUrl());
            }
        }
    }

    private static String a(String str) {
        float f2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Date parse = new SimpleDateFormat("dd/MM/yyyy").parse(str);
            Date time = Calendar.getInstance().getTime();
            if (parse != null) {
                long time2 = time.getTime() - parse.getTime();
                if (time2 < 0) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy");
                    if (parse != null) {
                        return simpleDateFormat.format(parse);
                    }
                    return null;
                }
                f2 = (float) (time2 / 86400000);
            } else {
                f2 = 0.0f;
            }
            int i2 = (int) (f2 / 7.0f);
            if (i2 <= 0) {
                int i3 = (int) (f2 % 7.0f);
                if (i3 == 0 || i3 == 1) {
                    return "1 day ago";
                }
                return i3 + " days ago";
            } else if (i2 == 1) {
                return i2 + " week ago";
            } else {
                if (i2 > 1) {
                    return i2 + " weeks ago";
                }
                return "";
            }
        } catch (ParseException unused) {
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(net.one97.paytm.o2o.movies.R.layout.layout_entertainment_blog_item, viewGroup, false));
    }
}
