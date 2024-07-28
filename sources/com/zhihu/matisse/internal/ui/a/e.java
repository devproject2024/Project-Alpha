package com.zhihu.matisse.internal.ui.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.e.h;
import com.bumptech.glide.f;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import com.zhihu.matisse.b;
import com.zhihu.matisse.internal.entity.Item;
import java.util.List;

public final class e extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    List<Item> f45829a;

    /* renamed from: b  reason: collision with root package name */
    ViewPager f45830b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f45831c;

    public e(Activity activity, List<Item> list, ViewPager viewPager) {
        this.f45831c = activity;
        this.f45829a = list;
        this.f45830b = viewPager;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f45831c).inflate(R.layout.chat_fragment_preview_bottom_item, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final Item item = this.f45829a.get(i2);
        ImageView imageView = ((a) vVar).f45834a;
        if (b.isGif(item.f45764b)) {
            com.bumptech.glide.b.a(this.f45831c).e().b((Object) item.f45765c).b((com.bumptech.glide.e.a<?>) ((h) new h().a(f.HIGH)).g()).a(imageView);
        } else {
            com.bumptech.glide.b.a(this.f45831c).a(item.f45765c).b((com.bumptech.glide.e.a<?>) ((h) new h().a(f.HIGH)).g()).a(imageView);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    e.this.f45830b.setCurrentItem(e.this.f45829a.indexOf(item), true);
                }
            }
        });
    }

    public final int getItemCount() {
        return this.f45829a.size();
    }

    static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f45834a;

        a(View view) {
            super(view);
            this.f45834a = (ImageView) view.findViewById(R.id.image);
        }
    }
}
