package com.paytm.android.chat.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import java.util.ArrayList;
import java.util.List;

public final class o extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<String> f41458a;

    /* renamed from: b  reason: collision with root package name */
    boolean f41459b;

    /* renamed from: c  reason: collision with root package name */
    List<Integer> f41460c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    boolean f41461d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41462e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f41463f;

    /* renamed from: g  reason: collision with root package name */
    private Context f41464g;

    /* renamed from: h  reason: collision with root package name */
    private LayoutInflater f41465h;

    public interface a {
        void a(List<Integer> list);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        final b bVar = (b) vVar;
        this.f41461d = true;
        bVar.f41470a.setText(this.f41458a.get(i2));
        bVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!FastClickUtil.isFastClick()) {
                    return;
                }
                if (!bVar.f41471b.isChecked()) {
                    bVar.f41471b.setChecked(true);
                    if (!o.this.f41459b && !o.this.f41461d) {
                        o.this.notifyDataSetChanged();
                    }
                } else if (o.this.f41459b) {
                    bVar.f41471b.setChecked(false);
                }
            }
        });
        if (this.f41459b) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f41460c.size()) {
                    break;
                } else if (this.f41460c.get(i3).intValue() == i2) {
                    bVar.f41471b.setChecked(true);
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == this.f41460c.size()) {
                bVar.f41471b.setChecked(false);
            }
        } else if (this.f41460c.size() <= 0 || this.f41460c.get(0).intValue() != i2) {
            bVar.f41471b.setChecked(false);
        } else {
            bVar.f41471b.setChecked(true);
        }
        bVar.f41471b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                o oVar = o.this;
                oVar.f41462e = true;
                int i2 = 0;
                if (z) {
                    if (!oVar.f41459b) {
                        o.this.f41460c.clear();
                        if (!o.this.f41461d) {
                            while (i2 < o.this.f41458a.size()) {
                                if (i2 != i2) {
                                    o.this.notifyItemChanged(i2);
                                }
                                i2++;
                            }
                        }
                    }
                    o.this.f41460c.add(Integer.valueOf(i2));
                    o.this.f41463f.a(o.this.f41460c);
                } else if (oVar.f41459b) {
                    while (i2 < o.this.f41460c.size()) {
                        if (o.this.f41460c.get(i2).intValue() == i2) {
                            o.this.f41460c.remove(i2);
                            o.this.f41463f.a(o.this.f41460c);
                            return;
                        }
                        i2++;
                    }
                } else if (!o.this.f41461d) {
                    while (i2 < o.this.f41458a.size()) {
                        if (i2 == i2) {
                            o.this.notifyItemChanged(i2);
                        }
                        i2++;
                    }
                }
            }
        });
        this.f41461d = false;
    }

    public o(Context context, List<String> list, boolean z, List<Integer> list2) {
        this.f41464g = context;
        this.f41458a = list;
        this.f41459b = z;
        this.f41460c = list2;
        this.f41465h = LayoutInflater.from(context);
    }

    public final int getItemCount() {
        List<String> list = this.f41458a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f41470a;

        /* renamed from: b  reason: collision with root package name */
        CheckBox f41471b;

        public b(View view) {
            super(view);
            this.f41470a = (TextView) view.findViewById(R.id.item_sub_settings_title);
            this.f41471b = (CheckBox) view.findViewById(R.id.item_sub_settings_sel);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.f41462e = false;
        return new b(this.f41465h.inflate(R.layout.chat_item_sub_settings, viewGroup, false));
    }
}
