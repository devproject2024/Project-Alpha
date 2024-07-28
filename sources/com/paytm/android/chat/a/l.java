package com.paytm.android.chat.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.MoreContactsBean;
import com.paytm.android.chat.utils.FastClickUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;

public final class l extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    List<MoreContactsBean> f41418a;

    /* renamed from: b  reason: collision with root package name */
    b f41419b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41420c;

    public interface b {
        void a(String str);
    }

    public l(List<MoreContactsBean> list, boolean z) {
        this.f41418a = list;
        this.f41420c = z;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(View.inflate(viewGroup.getContext(), R.layout.chat_item_send_more_number_contacts, (ViewGroup) null));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        final a aVar = (a) vVar;
        aVar.f41425a.setText(this.f41418a.get(i2).getPhone());
        aVar.f41426b.setChecked(this.f41418a.get(i2).isSelect());
        aVar.f41426b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                l.this.f41418a.get(i2).setSelect(z);
                String str = "";
                for (int i2 = 0; i2 < l.this.f41418a.size(); i2++) {
                    if (l.this.f41418a.get(i2).isSelect()) {
                        str = str + l.this.f41418a.get(i2).getPhone() + AppConstants.COMMA;
                    }
                }
                l.this.f41419b.a(str);
            }
        });
        aVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick() && aVar.f41426b.getVisibility() == 0) {
                    aVar.f41426b.setChecked(!aVar.f41426b.isChecked());
                }
            }
        });
        if (this.f41420c) {
            aVar.f41426b.setVisibility(8);
        } else {
            aVar.f41426b.setVisibility(0);
        }
    }

    public final int getItemCount() {
        return this.f41418a.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f41425a;

        /* renamed from: b  reason: collision with root package name */
        final CheckBox f41426b;

        public a(View view) {
            super(view);
            this.f41425a = (TextView) view.findViewById(R.id.tv_item_send_phone);
            this.f41426b = (CheckBox) view.findViewById(R.id.rb_item_send_selected);
        }
    }
}
