package com.paytm.android.chat.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.ImageUtils;
import java.util.List;

public final class d extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public a f41054a;

    /* renamed from: b  reason: collision with root package name */
    private Context f41055b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f41056c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f41057d;

    public interface a {
        void a(int i2);
    }

    public final int getItemViewType(int i2) {
        return i2 == 0 ? 100 : 0;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        final b bVar = (b) vVar;
        if (i2 != 0) {
            ImageUtils.displayImageFromUrl(this.f41055b, this.f41056c.get(i2), bVar.f41061a, androidx.core.content.b.a(this.f41055b, R.drawable.chat_icon_group_chat_deful_contact_pic));
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick() && d.this.f41054a != null) {
                    d.this.f41054a.a(i2);
                }
            }
        });
    }

    public d(Context context, List<String> list) {
        this.f41055b = context;
        this.f41056c = list;
        this.f41057d = LayoutInflater.from(context);
    }

    public final int getItemCount() {
        List<String> list = this.f41056c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41061a;

        public b(View view) {
            super(view);
            this.f41061a = (ImageView) view.findViewById(R.id.profile_pic);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 100) {
            return new b(this.f41057d.inflate(R.layout.chat_item_change_profile_pic_add, viewGroup, false));
        }
        return new b(this.f41057d.inflate(R.layout.chat_item_change_profile_pic, viewGroup, false));
    }
}
