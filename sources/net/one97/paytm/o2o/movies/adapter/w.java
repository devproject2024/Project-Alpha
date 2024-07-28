package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytm.utility.t;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.w;
import net.one97.paytm.o2o.movies.entity.CJRAboutMovieVideoModel;

public class w extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: b  reason: collision with root package name */
    static final String f74794b = w.class.getSimpleName();
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Context f74795a;

    /* renamed from: c  reason: collision with root package name */
    public String f74796c;

    /* renamed from: d  reason: collision with root package name */
    a f74797d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<CJRAboutMovieVideoModel> f74798e = new ArrayList<>();

    public interface a {
        void a(Long l);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public w(Context context, a aVar, ArrayList<CJRAboutMovieVideoModel> arrayList) {
        this.f74795a = context;
        this.f74797d = aVar;
        this.f74798e = arrayList;
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            ((b) vVar).a(i2);
        }
    }

    public int getItemCount() {
        return this.f74798e.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f74799a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f74800b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f74801c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f74802d;

        public b(View view) {
            super(view);
            this.f74799a = (ImageView) view.findViewById(R.id.movie_video_thumb_image);
            this.f74800b = (TextView) view.findViewById(R.id.noOfViews);
            this.f74801c = (TextView) view.findViewById(R.id.duration);
            this.f74802d = (TextView) view.findViewById(R.id.trailer_name);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            String imageUrl = ((CJRAboutMovieVideoModel) w.this.f74798e.get(i2)).getImageUrl();
            this.f74799a.setVisibility(0);
            if (!TextUtils.isEmpty(imageUrl)) {
                String trim = imageUrl.trim();
                Drawable b2 = androidx.appcompat.a.a.a.b(w.this.f74795a, net.one97.paytm.common.assets.R.drawable.android_amusement_park_placeholder_bg);
                t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory());
                Context unused = w.this.f74795a;
                t.a(trim, 8, b2, b2, this.f74799a);
            }
            CJRAboutMovieVideoModel cJRAboutMovieVideoModel = (CJRAboutMovieVideoModel) w.this.f74798e.get(i2);
            if (!TextUtils.isEmpty(cJRAboutMovieVideoModel.getNumberOfViews())) {
                int parseInt = Integer.parseInt(cJRAboutMovieVideoModel.getNumberOfViews());
                if (parseInt <= 0 || parseInt >= 1000) {
                    if (parseInt > 1000) {
                        TextView textView = this.f74800b;
                        textView.setText(new DecimalFormat("##.#").format(((double) parseInt) / 1000.0d) + "k Views");
                    }
                } else if (parseInt == 1) {
                    TextView textView2 = this.f74800b;
                    textView2.setText(String.valueOf(parseInt) + " View");
                } else {
                    TextView textView3 = this.f74800b;
                    textView3.setText(String.valueOf(parseInt) + " Views");
                }
                if (parseInt > 0) {
                    this.f74800b.setVisibility(0);
                }
            }
            if (!TextUtils.isEmpty(cJRAboutMovieVideoModel.getDurationOfVideo())) {
                this.f74801c.setText(cJRAboutMovieVideoModel.getDurationOfVideo());
                this.f74801c.setVisibility(0);
            }
            if (!TextUtils.isEmpty(cJRAboutMovieVideoModel.getDescription())) {
                this.f74802d.setText(cJRAboutMovieVideoModel.getDescription());
                this.f74802d.setSingleLine(false);
                this.f74802d.setEllipsize(TextUtils.TruncateAt.END);
                this.f74802d.setLines(2);
                this.f74802d.setVisibility(0);
            }
            this.f74799a.setOnClickListener(new View.OnClickListener(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    w.b.this.a(this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, View view) {
            w wVar = w.this;
            CJRAboutMovieVideoModel cJRAboutMovieVideoModel = (CJRAboutMovieVideoModel) wVar.f74798e.get(i2);
            try {
                String videoUrl = cJRAboutMovieVideoModel.getVideoUrl();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, wVar.f74796c);
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.v);
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Movie Trailer Video Play Click");
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
                    if (com.paytm.utility.b.r(wVar.f74795a)) {
                        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(wVar.f74795a));
                    }
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, wVar.f74795a);
                } catch (Exception e2) {
                    String str = w.f74794b;
                    q.c(e2.getMessage());
                }
                String str2 = null;
                Intent intent = new Intent(wVar.f74795a, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("AJRYoutubeVideoPlay"));
                if (!TextUtils.isEmpty(videoUrl)) {
                    q.d("URL ------".concat(String.valueOf(videoUrl)));
                    str2 = com.paytm.utility.b.e(videoUrl);
                    if (str2 == null) {
                        str2 = com.paytm.utility.b.f(videoUrl);
                    }
                    q.d("VIDEO ID ------".concat(String.valueOf(str2)));
                    if (wVar.f74797d != null) {
                        wVar.f74797d.a(cJRAboutMovieVideoModel.getId());
                    }
                }
                if (str2 != null && !TextUtils.isEmpty(str2)) {
                    intent.putExtra(e.aA, str2);
                    wVar.f74795a.startActivity(intent);
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.b(e3.getMessage());
                }
            }
        }
    }

    public /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_video_thumb_list_item, viewGroup, false);
        if (Build.VERSION.SDK_INT >= 21) {
            inflate.setClipToOutline(true);
        }
        return new b(inflate);
    }
}
