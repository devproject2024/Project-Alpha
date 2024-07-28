package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.movies.CJRMoviesCastCrewItem;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRActorPage;
import net.one97.paytm.o2o.movies.adapter.x;

public final class x extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f74804a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRMoviesCastCrewItem> f74805b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    b f74806c;

    /* renamed from: d  reason: collision with root package name */
    public String f74807d;

    /* renamed from: e  reason: collision with root package name */
    boolean f74808e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f74809f;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        return i2;
    }

    public x(Context context, List<CJRMoviesCastCrewItem> list, boolean z) {
        this.f74804a = context;
        this.f74805b = (ArrayList) list;
        this.f74808e = z;
        Context context2 = this.f74804a;
        if (context2 != null) {
            this.f74809f = (LayoutInflater) context2.getSystemService("layout_inflater");
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof a) {
            ((a) vVar).a(i2);
        }
    }

    public final int getItemCount() {
        return this.f74805b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f74810a;

        /* renamed from: c  reason: collision with root package name */
        private TextView f74812c;

        /* renamed from: d  reason: collision with root package name */
        private RelativeLayout f74813d;

        public a(View view) {
            super(view);
            this.f74810a = (ImageView) view.findViewById(R.id.thumb_item);
            this.f74812c = (TextView) view.findViewById(R.id.name_item);
            this.f74813d = (RelativeLayout) view.findViewById(R.id.castContainer);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            CJRMoviesCastCrewItem cJRMoviesCastCrewItem = x.this.f74805b.get(i2);
            this.f74812c.setText(cJRMoviesCastCrewItem.getName());
            boolean isEmpty = TextUtils.isEmpty(cJRMoviesCastCrewItem.getDescription());
            this.f74812c.setTypeface(Typeface.create(isEmpty ? "Roboto-Regular.ttf" : "Roboto-Medium.ttf", 0));
            this.f74812c.setTextColor(androidx.core.content.b.c(x.this.f74804a, isEmpty ? net.one97.paytm.common.assets.R.color.color_999999 : net.one97.paytm.common.assets.R.color.color_000000));
            this.f74813d.setOnClickListener(new View.OnClickListener(cJRMoviesCastCrewItem) {
                private final /* synthetic */ CJRMoviesCastCrewItem f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    x.a.this.a(this.f$1, view);
                }
            });
            String imageUrl = cJRMoviesCastCrewItem.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory()).a(imageUrl.replace(" ", "%20"), this.f74810a, x.this.f74806c);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(CJRMoviesCastCrewItem cJRMoviesCastCrewItem, View view) {
            if (x.this.f74808e && cJRMoviesCastCrewItem.getId() != 0 && !TextUtils.isEmpty(cJRMoviesCastCrewItem.getDescription())) {
                Intent intent = new Intent(x.this.f74804a, AJRActorPage.class);
                intent.putExtra("actor_id", cJRMoviesCastCrewItem.getId());
                x.this.f74804a.startActivity(intent);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar = new a(this.f74809f.inflate(R.layout.item_cast_crew, viewGroup, false));
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f74804a.getResources(), net.one97.paytm.common.assets.R.drawable.img_movie_placeholder_163_x_190_dp);
        this.f74806c = d.a(this.f74804a.getResources(), decodeResource);
        this.f74806c.b();
        this.f74806c.a(((float) Math.max(decodeResource.getWidth(), decodeResource.getHeight())) / 2.0f);
        return aVar;
    }
}
