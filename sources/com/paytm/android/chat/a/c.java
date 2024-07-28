package com.paytm.android.chat.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.ImageUtils;
import com.sendbird.android.User;
import java.util.List;

public final class c extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public a f41044a;

    /* renamed from: b  reason: collision with root package name */
    private Context f41045b;

    /* renamed from: c  reason: collision with root package name */
    private List<User> f41046c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f41047d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41048e = true;

    public interface a {
        void a(View view, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        b bVar = (b) vVar;
        this.f41048e = true;
        User user = this.f41046c.get(i2);
        ImageUtils.displayCornersImageFromUrl(this.f41045b, user.getProfileUrl(), bVar.f41051a);
        bVar.f41052b.setText(user.getNickname());
        bVar.f41053c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick() && c.this.f41044a != null) {
                    c.this.f41044a.a(view, i2);
                }
            }
        });
        this.f41048e = false;
    }

    public c(Context context, List<User> list) {
        this.f41045b = context;
        this.f41046c = list;
        this.f41047d = LayoutInflater.from(context);
    }

    public final void a(List<User> list) {
        this.f41046c = list;
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        List<User> list = this.f41046c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41051a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41052b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41053c;

        public b(View view) {
            super(view);
            this.f41051a = (ImageView) view.findViewById(R.id.item_blocked_userlist_img);
            this.f41052b = (TextView) view.findViewById(R.id.item_blocked_userlist_title);
            this.f41053c = (TextView) view.findViewById(R.id.item_blocked_userlist_unblock);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f41047d.inflate(R.layout.chat_item_blocked_userlist, viewGroup, false));
    }
}
