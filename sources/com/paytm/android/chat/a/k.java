package com.paytm.android.chat.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.view.ChatHeadView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;

public final class k extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    public b f41409a;

    /* renamed from: b  reason: collision with root package name */
    private List<SelectContactsBean> f41410b;

    /* renamed from: c  reason: collision with root package name */
    private Context f41411c;

    public interface b {
        void a(int i2);
    }

    public k(Context context, List<SelectContactsBean> list) {
        this.f41411c = context;
        this.f41410b = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f41411c).inflate(R.layout.chat_item_select_contacts, viewGroup, false));
    }

    public final void a(List<SelectContactsBean> list) {
        this.f41410b = list;
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        aVar.f41414a.setText(TextUtils.isEmpty(this.f41410b.get(i2).getSendContactBean().getContactName()) ? this.f41410b.get(i2).getSendContactBean().getPtName() : this.f41410b.get(i2).getSendContactBean().getContactName());
        if (this.f41410b.get(i2).getSendContactBean().getContactPhone() == null || "".equals(this.f41410b.get(i2).getSendContactBean().getContactPhone())) {
            aVar.f41415b.setUI(this.f41410b.get(i2).getSendContactBean().getPtPic(), this.f41410b.get(i2).getSendContactBean().getContactName(), this.f41410b.get(i2).getSendContactBean().getPtName(), this.f41410b.get(i2).getSendContactBean().getContactPhone());
        } else {
            String[] split = this.f41410b.get(i2).getSendContactBean().getContactPhone().split(AppConstants.COMMA);
            if (split.length > 0) {
                aVar.f41415b.setUI(this.f41410b.get(i2).getSendContactBean().getPtPic(), this.f41410b.get(i2).getSendContactBean().getContactName(), this.f41410b.get(i2).getSendContactBean().getPtName(), split[0]);
            } else {
                aVar.f41415b.setUI(this.f41410b.get(i2).getSendContactBean().getPtPic(), this.f41410b.get(i2).getSendContactBean().getContactName(), this.f41410b.get(i2).getSendContactBean().getPtName(), this.f41410b.get(i2).getSendContactBean().getContactPhone());
            }
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    k.this.f41409a.a(i2);
                }
            }
        });
    }

    public final int getItemCount() {
        return this.f41410b.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f41414a;

        /* renamed from: b  reason: collision with root package name */
        final ChatHeadView f41415b;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView f41417d;

        public a(View view) {
            super(view);
            this.f41414a = (TextView) view.findViewById(R.id.tv_item_black_message_name);
            this.f41415b = (ChatHeadView) view.findViewById(R.id.img_item_black_message_invite);
            this.f41417d = (ImageView) view.findViewById(R.id.img_selected);
        }
    }
}
