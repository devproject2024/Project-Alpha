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
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRDetailImageGalleryViewer;
import net.one97.paytm.o2o.movies.adapter.u;
import net.one97.paytm.o2o.movies.common.c.b;

public final class u extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f74775a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f74776b;

    /* renamed from: c  reason: collision with root package name */
    public String f74777c;

    /* renamed from: d  reason: collision with root package name */
    public String f74778d;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public u(Context context, ArrayList<String> arrayList) {
        this.f74775a = context;
        this.f74776b = arrayList;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof a) {
            ((a) vVar).a(i2);
        }
    }

    public final int getItemCount() {
        return this.f74776b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f74779a;

        public a(View view) {
            super(view);
            this.f74779a = (ImageView) view.findViewById(R.id.movie_pdp_thumb_image);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            String str = u.this.f74776b.get(i2);
            this.f74779a.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                str = "drawable://" + net.one97.paytm.common.assets.R.drawable.android_amusement_park_placeholder_bg;
            }
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                Drawable b2 = androidx.appcompat.a.a.a.b(u.this.f74775a, net.one97.paytm.common.assets.R.drawable.android_amusement_park_placeholder_bg);
                t.a(b.f75032a.f75033b.getPicassoIsInMemory());
                t.a(trim, 8, b2, b2, this.f74779a);
            }
            this.f74779a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    u.a.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            Intent a2;
            u uVar = u.this;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, uVar.f74778d);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.u);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "posters_clicked");
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, uVar.f74777c);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
                if (com.paytm.utility.b.r(uVar.f74775a)) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(uVar.f74775a));
                }
                b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, uVar.f74775a);
            } catch (Exception unused) {
            }
            if (u.this.f74775a != null && (a2 = AJRDetailImageGalleryViewer.a(u.this.f74775a, u.this.f74776b, getAdapterPosition())) != null) {
                u.this.f74775a.startActivity(a2);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_thumb_list_item, viewGroup, false);
        if (Build.VERSION.SDK_INT >= 21) {
            inflate.setClipToOutline(true);
        }
        return new a(inflate);
    }
}
