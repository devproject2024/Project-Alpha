package net.one97.paytm.oauth.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.fragment.bp;
import net.one97.paytm.oauth.fragment.bq;

public final class b extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    final Context f52590a;

    /* renamed from: b  reason: collision with root package name */
    final bp f52591b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<bq> f52592c;

    public final int getItemPosition(Object obj) {
        k.c(obj, "object");
        return -2;
    }

    public b(bp bpVar, ArrayList<bq> arrayList) {
        k.c(bpVar, "dialogFragment");
        k.c(arrayList, "dataList");
        this.f52591b = bpVar;
        this.f52592c = arrayList;
        Context context = this.f52591b.getContext();
        if (context == null) {
            k.a();
        }
        this.f52590a = context;
    }

    public final int getCount() {
        return this.f52592c.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        k.c(view, "view");
        k.c(obj, "object");
        return view == ((ImageView) obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "container");
        AppCompatImageView appCompatImageView = new AppCompatImageView(viewGroup.getContext());
        bq bqVar = this.f52592c.get(i2);
        k.a((Object) bqVar, "dataList.get(position)");
        bq bqVar2 = bqVar;
        if (TextUtils.isEmpty(bqVar2.f56511a)) {
            appCompatImageView.setImageResource(bqVar2.f56513c);
            appCompatImageView.setOnClickListener((View.OnClickListener) null);
        } else {
            w.a().a(bqVar2.f56511a).a(this.f52590a.getResources().getDimensionPixelSize(R.dimen.dimen_320dp), this.f52590a.getResources().getDimensionPixelSize(R.dimen.dimen_190dp)).a((ImageView) appCompatImageView);
            if (!TextUtils.isEmpty(bqVar2.f56512b)) {
                appCompatImageView.setOnClickListener(new a(this, bqVar2));
            }
        }
        viewGroup.addView(appCompatImageView, new ViewGroup.LayoutParams(-2, -2));
        return appCompatImageView;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52593a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ bq f52594b;

        a(b bVar, bq bqVar) {
            this.f52593a = bVar;
            this.f52594b = bqVar;
        }

        public final void onClick(View view) {
            OauthModule.b().checkDeepLinking(this.f52593a.f52590a, this.f52594b.f56512b);
            bp bpVar = this.f52593a.f52591b;
            if (bpVar != null) {
                bpVar.f56504a = true;
            }
            bp bpVar2 = this.f52593a.f52591b;
            if (bpVar2 != null) {
                bpVar2.dismissAllowingStateLoss();
            }
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "object");
        viewGroup.removeView((ImageView) obj);
    }
}
