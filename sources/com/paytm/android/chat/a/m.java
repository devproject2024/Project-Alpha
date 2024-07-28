package com.paytm.android.chat.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.l;
import com.paytm.android.chat.bean.MoreContactsBean;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.SendContactBean;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.view.ChatHeadView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;

public final class m extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    public c f41428a;

    /* renamed from: b  reason: collision with root package name */
    public b f41429b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41430c;

    /* renamed from: d  reason: collision with root package name */
    private List<SelectContactsBean> f41431d;

    /* renamed from: e  reason: collision with root package name */
    private Context f41432e;

    public interface b {
        void a(SendContactBean sendContactBean);
    }

    public interface c {
        void a(int i2, String str);
    }

    public m(Context context, List<SelectContactsBean> list) {
        this.f41432e = context;
        this.f41431d = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f41432e).inflate(R.layout.chat_item_send_contacts, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        final SendContactBean sendContactBean = this.f41431d.get(i2).getSendContactBean();
        aVar.f41437a.setText(sendContactBean.getContactName());
        aVar.f41438b.setUI(sendContactBean.getPtPic(), sendContactBean.getContactName(), sendContactBean.getPtName(), sendContactBean.getContactPhone());
        String[] split = sendContactBean.getContactPhone().split(AppConstants.COMMA);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < split.length; i3++) {
            if (i3 == 0) {
                arrayList.add(new MoreContactsBean(split[i3], true));
            } else {
                arrayList.add(new MoreContactsBean(split[i3], false));
            }
        }
        l lVar = new l(arrayList, this.f41430c);
        aVar.f41439c.setLayoutManager(new LinearLayoutManager(this.f41432e));
        aVar.f41439c.setAdapter(lVar);
        lVar.f41419b = new l.b() {
            public final void a(String str) {
                m.this.f41428a.a(i2, str);
            }
        };
        if (this.f41430c) {
            aVar.f41440d.setVisibility(0);
        } else {
            aVar.f41440d.setVisibility(8);
        }
        aVar.f41440d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick() && sendContactBean != null) {
                    m.this.f41429b.a(sendContactBean);
                }
            }
        });
    }

    public final int getItemCount() {
        return this.f41431d.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f41437a;

        /* renamed from: b  reason: collision with root package name */
        final ChatHeadView f41438b;

        /* renamed from: c  reason: collision with root package name */
        final RecyclerView f41439c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f41440d;

        public a(View view) {
            super(view);
            this.f41437a = (TextView) view.findViewById(R.id.tv_item_send_name);
            this.f41438b = (ChatHeadView) view.findViewById(R.id.img_item_send_invite);
            this.f41439c = (RecyclerView) view.findViewById(R.id.rv_item_send_contacts);
            this.f41440d = (TextView) view.findViewById(R.id.tv_item_add_contacts);
        }
    }
}
