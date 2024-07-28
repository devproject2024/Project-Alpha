package com.paytm.android.chat.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
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

public final class a extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    List<SelectContactsBean> f41026a;

    /* renamed from: b  reason: collision with root package name */
    public b f41027b;

    /* renamed from: c  reason: collision with root package name */
    public String f41028c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41029d = "";

    /* renamed from: e  reason: collision with root package name */
    private Context f41030e;

    public interface b {
        void a(SelectContactsBean selectContactsBean);
    }

    public a(Context context, List<SelectContactsBean> list) {
        this.f41030e = context;
        this.f41026a = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0687a(LayoutInflater.from(this.f41030e).inflate(R.layout.chat_item_all_contacts, viewGroup, false));
    }

    public final void a(List<SelectContactsBean> list) {
        this.f41026a = list;
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        return this.f41026a.size();
    }

    /* renamed from: com.paytm.android.chat.a.a$a  reason: collision with other inner class name */
    class C0687a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f41033a;

        /* renamed from: b  reason: collision with root package name */
        final ChatHeadView f41034b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f41035c;

        public C0687a(View view) {
            super(view);
            this.f41033a = (TextView) view.findViewById(R.id.tv_item_black_message_name);
            this.f41034b = (ChatHeadView) view.findViewById(R.id.img_item_black_message_invite);
            this.f41035c = (ImageView) view.findViewById(R.id.img_selected);
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        int i3;
        C0687a aVar = (C0687a) vVar;
        if (this.f41028c.isEmpty() || this.f41026a.get(i2).getSendContactBean().getContactName() == null) {
            aVar.f41033a.setText(this.f41026a.get(i2).getSendContactBean().getContactName());
        } else {
            String contactName = this.f41026a.get(i2).getSendContactBean().getContactName();
            String str = this.f41028c;
            if (contactName == null) {
                i3 = -1;
            } else {
                i3 = contactName.toLowerCase().indexOf(str.toLowerCase());
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f41026a.get(i2).getSendContactBean().getContactName());
            if (i3 != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(1), i3, this.f41028c.length() + i3, 34);
            }
            aVar.f41033a.setText(spannableStringBuilder);
        }
        if (this.f41026a.get(i2).getSendContactBean().getContactPhone() == null || "".equals(this.f41026a.get(i2).getSendContactBean().getContactPhone())) {
            aVar.f41034b.setUI(this.f41026a.get(i2).getSendContactBean().getPtPic(), this.f41026a.get(i2).getSendContactBean().getContactName(), this.f41026a.get(i2).getSendContactBean().getPtName(), this.f41026a.get(i2).getSendContactBean().getContactPhone());
        } else {
            String[] split = this.f41026a.get(i2).getSendContactBean().getContactPhone().split(AppConstants.COMMA);
            if (split.length > 0) {
                aVar.f41034b.setUI(this.f41026a.get(i2).getSendContactBean().getPtPic(), this.f41026a.get(i2).getSendContactBean().getContactName(), this.f41026a.get(i2).getSendContactBean().getPtName(), split[0]);
            } else {
                aVar.f41034b.setUI(this.f41026a.get(i2).getSendContactBean().getPtPic(), this.f41026a.get(i2).getSendContactBean().getContactName(), this.f41026a.get(i2).getSendContactBean().getPtName(), this.f41026a.get(i2).getSendContactBean().getContactPhone());
            }
        }
        aVar.f41035c.setVisibility(this.f41026a.get(i2).isSelect() ? 0 : 8);
        aVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick() && !a.this.f41026a.get(i2).isSelect()) {
                    a.this.f41026a.get(i2).setSelect(true);
                    a.this.f41027b.a(a.this.f41026a.get(i2));
                    a.this.notifyItemChanged(i2);
                }
            }
        });
        String str2 = this.f41029d;
        if (str2 != null && !"".equals(str2)) {
            String[] split2 = this.f41029d.split(AppConstants.COMMA);
            for (int i4 = 0; i4 < split2.length; i4++) {
                if (this.f41026a.get(i2).getSendContactBean().getContactId() != null && split2[i4].equals(this.f41026a.get(i2).getSendContactBean().getContactId())) {
                    aVar.f41035c.setVisibility(0);
                }
            }
        }
    }
}
