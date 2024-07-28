package net.one97.paytm.moneytransfer.view.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.List;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class h extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<UpiProfileDefaultBank> f54277a;

    /* renamed from: b  reason: collision with root package name */
    int f54278b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f54279c = -1;

    /* renamed from: d  reason: collision with root package name */
    boolean f54280d = true;

    /* renamed from: e  reason: collision with root package name */
    b f54281e;

    /* renamed from: f  reason: collision with root package name */
    private String f54282f;

    public interface b {
        void a(int i2);

        void a(UpiProfileDefaultBank upiProfileDefaultBank);

        void a(UpiProfileDefaultBank upiProfileDefaultBank, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        UpiProfileDefaultBank upiProfileDefaultBank = this.f54277a.get(i2);
        if (upiProfileDefaultBank != null) {
            Context context = aVar.f54285c.getContext();
            aVar.f54285c.setText(context.getString(R.string.check_balance));
            aVar.f54285c.setTextColor(androidx.core.content.b.c(context, R.color.color_00b9f5));
            aVar.f54285c.setVisibility(0);
            if (!(upiProfileDefaultBank.getDebitBank() == null || upiProfileDefaultBank.getDebitBank().getAccount() == null || upiProfileDefaultBank.getDebitBank().getBankName() == null)) {
                if (!"PYTM0123456".equalsIgnoreCase(upiProfileDefaultBank.getDebitBank().getIfsc()) && !upiProfileDefaultBank.getDebitBank().isMpinSet()) {
                    aVar.f54285c.setText(context.getString(R.string.mt_set_upi_pin));
                }
                aVar.f54286d.setVisibility(8);
                String a2 = m.a(upiProfileDefaultBank.getDebitBank().getBankName(), upiProfileDefaultBank.getDebitBank().getAccount());
                TextView a3 = aVar.f54284b;
                if (a2.length() == 0) {
                    a2 = context.getString(R.string.money_tranfer_balance_paytm_bank_string);
                }
                a3.setText(a2);
                if ("CURRENT" == upiProfileDefaultBank.getDebitBank().getAccountType()) {
                    aVar.f54289g.setVisibility(0);
                } else {
                    aVar.f54289g.setVisibility(8);
                }
            }
        }
        Context context2 = aVar.f54284b.getContext();
        if (i2 == this.f54278b) {
            aVar.f54290h.setChecked(true);
            aVar.f54286d.setTextColor(androidx.core.content.b.c(context2, R.color.color_222222));
            if (aVar.f54285c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || aVar.f54285c.getText().toString().equalsIgnoreCase(context2.getString(R.string.mt_set_upi_pin))) {
                aVar.f54285c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
            } else {
                aVar.f54285c.setTextColor(androidx.core.content.b.c(context2, R.color.color_222222));
            }
        } else {
            aVar.f54290h.setChecked(false);
            aVar.f54286d.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
            if (aVar.f54285c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || aVar.f54285c.getText().toString().equalsIgnoreCase(context2.getString(R.string.mt_set_upi_pin))) {
                aVar.f54285c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
            } else {
                aVar.f54285c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
            }
        }
        if (i2 != this.f54279c) {
            return;
        }
        if (this.f54280d) {
            a(aVar, true);
            return;
        }
        a(aVar, false);
        if (!TextUtils.isEmpty(this.f54282f)) {
            aVar.f54285c.setText(this.f54282f);
            aVar.f54285c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
            return;
        }
        aVar.f54285c.setText(context2.getString(R.string.check_balance));
        aVar.f54285c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
    }

    public h(List<UpiProfileDefaultBank> list) {
        this.f54277a = list;
    }

    public final void a(List<UpiProfileDefaultBank> list) {
        this.f54277a = list;
        notifyDataSetChanged();
    }

    public final void a(int i2) {
        this.f54278b = i2;
        notifyDataSetChanged();
    }

    public final void b(int i2) {
        this.f54279c = i2;
        this.f54280d = true;
        notifyItemChanged(i2);
    }

    public final void a(String str) {
        int i2 = this.f54279c;
        if (i2 != -1) {
            this.f54280d = false;
            this.f54282f = str;
            notifyItemChanged(i2);
        }
    }

    public final void a(b bVar) {
        this.f54281e = bVar;
    }

    public final UpiProfileDefaultBank c(int i2) {
        return this.f54277a.get(i2);
    }

    public final int getItemCount() {
        List<UpiProfileDefaultBank> list = this.f54277a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private static void a(a aVar, boolean z) {
        if (z) {
            if (aVar != null && aVar.f54288f != null) {
                aVar.f54285c.setVisibility(8);
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) aVar.f54288f);
            }
        } else if (aVar != null && aVar.f54288f != null) {
            aVar.f54285c.setVisibility(0);
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) aVar.f54288f);
        }
    }

    class a extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final TextView f54284b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final TextView f54285c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final TextView f54286d;

        /* renamed from: e  reason: collision with root package name */
        private final View f54287e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final View f54288f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final View f54289g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final RadioButton f54290h;

        a(View view) {
            super(view);
            this.f54290h = (RadioButton) view.findViewById(R.id.radio_button);
            this.f54287e = view.findViewById(R.id.item_rl_root);
            this.f54284b = (TextView) view.findViewById(R.id.source_name);
            this.f54285c = (TextView) view.findViewById(R.id.check_balance_tv);
            this.f54286d = (TextView) view.findViewById(R.id.source_balance);
            this.f54288f = view.findViewById(R.id.wallet_loader);
            this.f54289g = view.findViewById(R.id.accountTypeCurrent);
            this.f54290h.setOnClickListener(this);
            this.f54287e.setOnClickListener(this);
            this.f54285c.setOnClickListener(this);
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Context context = view.getContext();
            if (h.this.f54281e != null && adapterPosition != -1) {
                if (view.getId() == R.id.item_rl_root) {
                    h hVar = h.this;
                    hVar.notifyItemChanged(hVar.f54278b);
                    h hVar2 = h.this;
                    hVar2.f54278b = adapterPosition;
                    hVar2.notifyItemChanged(hVar2.f54278b);
                    h.this.f54281e.a(adapterPosition);
                } else if (view.getId() == R.id.radio_button) {
                    h hVar3 = h.this;
                    hVar3.notifyItemChanged(hVar3.f54278b);
                    h hVar4 = h.this;
                    hVar4.f54278b = adapterPosition;
                    hVar4.notifyItemChanged(hVar4.f54278b);
                    h.this.f54281e.a(adapterPosition);
                } else if (view.getId() != R.id.check_balance_tv) {
                } else {
                    if (!com.paytm.utility.b.c(context)) {
                        Toast.makeText(context, context.getResources().getString(R.string.no_internet), 0).show();
                    } else if (h.this.f54277a != null && h.this.f54281e != null) {
                        UpiProfileDefaultBank upiProfileDefaultBank = h.this.f54277a.get(adapterPosition);
                        if (this.f54285c.getText().toString().equalsIgnoreCase(context.getString(R.string.check_balance))) {
                            f.a(context, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "check_balance_clicked", "/money-transfer/payment", "", "");
                            h.this.f54281e.a(upiProfileDefaultBank, adapterPosition);
                            h hVar5 = h.this;
                            hVar5.f54280d = true;
                            hVar5.f54279c = adapterPosition;
                            hVar5.notifyItemChanged(hVar5.f54279c);
                        } else if (this.f54285c.getText().toString().equalsIgnoreCase(context.getString(R.string.mt_set_upi_pin))) {
                            h.this.f54281e.a(upiProfileDefaultBank);
                        }
                    }
                }
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.universal_money_tranfer_list_item, viewGroup, false));
    }
}
