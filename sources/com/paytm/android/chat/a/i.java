package com.paytm.android.chat.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.e.a.h;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.SelectChannelBean;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.view.ChatHeadView;
import com.sendbird.android.GroupChannel;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class i extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    public List<SelectChannelBean> f41386a;

    /* renamed from: b  reason: collision with root package name */
    public b f41387b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<h<Bitmap>, Integer> f41388c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap<h<Bitmap>, GroupChannel> f41389d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f41390e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final ConcurrentHashMap<String, ImageView> f41391f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public final ConcurrentHashMap<String, SparseArray<Bitmap>> f41392g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private Context f41393h;

    public interface b {
        void a(int i2);
    }

    public i(Context context, List<SelectChannelBean> list) {
        this.f41393h = context;
        this.f41386a = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_multiple_select_send, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        ReceiverDisplayInfo receiverDisplayInfo = AppUtilKt.getReceiverDisplayInfo(this.f41386a.get(i2).getGroupChannel());
        String name = receiverDisplayInfo.getName();
        String profileImage = receiverDisplayInfo.getProfileImage();
        aVar.f41398a.setText(name);
        aVar.f41399b.setUI(profileImage, name);
        aVar.f41400c.setChecked(this.f41386a.get(i2).isSelect());
        vVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.f41387b.a(i2);
            }
        });
        aVar.f41400c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.f41387b.a(i2);
            }
        });
    }

    public final int getItemCount() {
        return this.f41386a.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f41398a;

        /* renamed from: b  reason: collision with root package name */
        ChatHeadView f41399b;

        /* renamed from: c  reason: collision with root package name */
        CheckBox f41400c;

        public a(View view) {
            super(view);
            this.f41398a = (TextView) view.findViewById(R.id.text_group_channel_list_topic);
            this.f41399b = (ChatHeadView) view.findViewById(R.id.image_group_channel_list_cover);
            this.f41400c = (CheckBox) view.findViewById(R.id.cb_item_channel_bg);
        }
    }
}
