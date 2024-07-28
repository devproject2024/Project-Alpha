package com.paytm.android.chat.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import java.util.List;

public final class j extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    a f41402a;

    /* renamed from: b  reason: collision with root package name */
    private Context f41403b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f41404c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f41405d;

    public interface a {
        void a(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        final String str = this.f41404c.get(i2);
        bVar.f41408a.setText(str);
        bVar.f41408a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (j.this.f41402a != null) {
                    j.this.f41402a.a(str);
                }
            }
        });
    }

    public j(Context context, List<String> list) {
        this.f41403b = context;
        this.f41404c = list;
        this.f41405d = LayoutInflater.from(context);
    }

    public final void a(List<String> list) {
        this.f41404c = list;
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        List<String> list = this.f41404c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void a(a aVar) {
        this.f41402a = aVar;
    }

    public static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f41408a;

        public b(View view) {
            super(view);
            this.f41408a = (TextView) view.findViewById(R.id.tv_quick_reply_option);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f41405d.inflate(R.layout.chat_item_quick_reply_chip, viewGroup, false));
    }
}
