package net.one97.paytm.upi.mandate.a;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.mandate.a.d;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.UpiUtils;

public final class d extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    List<UpiProfileDefaultBank> f67034a;

    /* renamed from: b  reason: collision with root package name */
    int f67035b = -1;

    /* renamed from: c  reason: collision with root package name */
    a f67036c;

    /* renamed from: d  reason: collision with root package name */
    String f67037d;

    /* renamed from: e  reason: collision with root package name */
    final String f67038e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f67039f = true;

    /* renamed from: g  reason: collision with root package name */
    private String f67040g;

    public interface a {
        void a(UpiProfileDefaultBank upiProfileDefaultBank);

        void b(UpiProfileDefaultBank upiProfileDefaultBank);

        void c(UpiProfileDefaultBank upiProfileDefaultBank);
    }

    public final int getItemViewType(int i2) {
        List<String> bankFilterList = this.f67034a.get(i2).getDebitBank().getBankFilterList();
        if (!this.f67038e.equalsIgnoreCase("ASBA") || !this.f67034a.get(i2).getDebitBank().isAsbaEnabled()) {
            return (bankFilterList == null || !bankFilterList.contains(this.f67038e)) ? 0 : 1;
        }
        return 1;
    }

    public d(String str) {
        this.f67038e = str;
    }

    public final void a(List<UpiProfileDefaultBank> list) {
        this.f67034a = list;
        notifyDataSetChanged();
    }

    public final void a(String str) {
        int i2 = this.f67035b;
        if (i2 != -1) {
            this.f67040g = str;
            notifyItemChanged(i2);
        }
    }

    public final void a() {
        this.f67039f = true;
        notifyItemChanged(this.f67035b);
    }

    public final void b() {
        this.f67039f = false;
        notifyItemChanged(this.f67035b);
    }

    public final void a(a aVar) {
        this.f67036c = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == 1) {
            return new b(from.inflate(R.layout.mandate_account_bottom_sheet_item_view, viewGroup, false));
        }
        return new c(from.inflate(R.layout.mandate_unsupported_type_item_view, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            b bVar = (b) vVar;
            UpiProfileDefaultBank upiProfileDefaultBank = this.f67034a.get(i2);
            if (upiProfileDefaultBank != null) {
                Context context = bVar.f67043c.getContext();
                bVar.f67043c.setText(context.getString(R.string.check_balance));
                bVar.f67043c.setTextColor(androidx.core.content.b.c(context, R.color.color_00b9f5));
                bVar.f67043c.setVisibility(0);
                if (!(upiProfileDefaultBank.getDebitBank() == null || upiProfileDefaultBank.getDebitBank().getAccount() == null || upiProfileDefaultBank.getDebitBank().getBankName() == null)) {
                    if (!"PYTM0123456".equalsIgnoreCase(upiProfileDefaultBank.getDebitBank().getIfsc()) && !upiProfileDefaultBank.getDebitBank().isMpinSet()) {
                        AnimationFactory.stopWalletLoader((LottieAnimationView) bVar.f67045e);
                        bVar.f67043c.setText(context.getString(R.string.set_upi_pin));
                    }
                    String accountNoFormat = UpiUtils.getAccountNoFormat(upiProfileDefaultBank.getDebitBank().getBankName(), upiProfileDefaultBank.getDebitBank().getAccount());
                    TextView a2 = bVar.f67042b;
                    if (accountNoFormat.length() == 0) {
                        accountNoFormat = context.getString(R.string.money_tranfer_balance_paytm_bank_string);
                    }
                    a2.setText(accountNoFormat);
                }
                ImageView e2 = bVar.f67047g;
                UpiUtils.setBankIcon(e2, upiProfileDefaultBank.getDebitBank(), e2.getContext());
            }
            Context context2 = bVar.f67042b.getContext();
            if (upiProfileDefaultBank.getDebitBank().getAccount().equals(this.f67037d)) {
                bVar.f67046f.setChecked(true);
                if (bVar.f67043c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || bVar.f67043c.getText().toString().equalsIgnoreCase(context2.getString(R.string.set_upi_pin))) {
                    bVar.f67043c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
                } else {
                    bVar.f67043c.setTextColor(androidx.core.content.b.c(context2, R.color.color_222222));
                }
                bVar.f67042b.setTypeface(Typeface.create("sans-serif", 1));
            } else {
                bVar.f67046f.setChecked(false);
                if (bVar.f67043c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || bVar.f67043c.getText().toString().equalsIgnoreCase(context2.getString(R.string.set_upi_pin))) {
                    bVar.f67043c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
                } else {
                    bVar.f67043c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
                }
                bVar.f67042b.setTypeface(Typeface.create("sans-serif", 0));
            }
            if (i2 != this.f67035b) {
                return;
            }
            if (this.f67039f) {
                a(bVar, true);
                return;
            }
            a(bVar, false);
            if (!TextUtils.isEmpty(this.f67040g)) {
                bVar.f67043c.setText(this.f67040g);
                bVar.f67043c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
                this.f67040g = "";
                return;
            }
            bVar.f67043c.setText(context2.getString(R.string.check_balance));
            bVar.f67043c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
        } else if (vVar instanceof c) {
            c cVar = (c) vVar;
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.f67034a.get(i2);
            if (d.this.f67038e.equalsIgnoreCase("ASBA")) {
                cVar.f67050c.setText(R.string.not_supported_for_ipo_payments);
            } else {
                cVar.f67050c.setText(R.string.not_supported_for_scheduled_payments);
            }
            Context context3 = cVar.itemView.getContext();
            UpiUtils.setBankIcon(cVar.f67049b, upiProfileDefaultBank2.getDebitBank(), context3);
            String accountNoFormat2 = UpiUtils.getAccountNoFormat(upiProfileDefaultBank2.getDebitBank().getBankName(), upiProfileDefaultBank2.getDebitBank().getAccount());
            TextView textView = cVar.f67048a;
            if (accountNoFormat2.length() == 0) {
                accountNoFormat2 = context3.getString(R.string.money_tranfer_balance_paytm_bank_string);
            }
            textView.setText(accountNoFormat2);
        }
    }

    public final int getItemCount() {
        List<UpiProfileDefaultBank> list = this.f67034a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private static void a(b bVar, boolean z) {
        if (z) {
            if (bVar != null && bVar.f67045e != null) {
                bVar.f67043c.setVisibility(8);
                AnimationFactory.startWalletLoader((LottieAnimationView) bVar.f67045e);
            }
        } else if (bVar != null && bVar.f67045e != null) {
            bVar.f67043c.setVisibility(0);
            AnimationFactory.stopWalletLoader((LottieAnimationView) bVar.f67045e);
        }
    }

    public final void b(String str) {
        this.f67037d = str;
    }

    class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f67048a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f67049b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f67050c;

        public c(View view) {
            super(view);
            this.f67049b = (ImageView) view.findViewById(R.id.bankImage);
            this.f67048a = (TextView) view.findViewById(R.id.source_name);
            this.f67050c = (TextView) view.findViewById(R.id.errorMessage);
        }
    }

    class b extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final TextView f67042b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final TextView f67043c;

        /* renamed from: d  reason: collision with root package name */
        private final View f67044d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final View f67045e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final RadioButton f67046f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final ImageView f67047g;

        b(View view) {
            super(view);
            this.f67046f = (RadioButton) view.findViewById(R.id.radio_button);
            this.f67044d = view.findViewById(R.id.item_rl_root);
            this.f67042b = (TextView) view.findViewById(R.id.source_name);
            this.f67043c = (TextView) view.findViewById(R.id.check_balance_tv);
            this.f67045e = view.findViewById(R.id.wallet_loader);
            this.f67047g = (ImageView) view.findViewById(R.id.bankImage);
            this.f67043c.setOnClickListener(this);
            this.f67046f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.b.this.a(view);
                }
            });
            this.f67046f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    d.b.this.a(compoundButton, z);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            this.f67046f.setChecked(true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
            if (this.f67046f.isPressed() && z) {
                d dVar = d.this;
                dVar.f67037d = dVar.f67034a.get(getAdapterPosition()).getDebitBank().getAccount();
                d.this.f67036c.a(d.this.f67034a.get(getAdapterPosition()));
                d.this.notifyDataSetChanged();
            }
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Context context = view.getContext();
            if (d.this.f67036c != null && adapterPosition != -1 && view.getId() == R.id.check_balance_tv) {
                if (!com.paytm.utility.a.m(context)) {
                    Toast.makeText(context, context.getResources().getString(R.string.no_internet), 0).show();
                } else if (d.this.f67034a != null && d.this.f67036c != null) {
                    UpiProfileDefaultBank upiProfileDefaultBank = d.this.f67034a.get(adapterPosition);
                    if (this.f67043c.getText().toString().equalsIgnoreCase(context.getString(R.string.check_balance))) {
                        d dVar = d.this;
                        dVar.f67035b = adapterPosition;
                        dVar.f67036c.b(upiProfileDefaultBank);
                    } else if (this.f67043c.getText().toString().equalsIgnoreCase(context.getString(R.string.set_upi_pin))) {
                        d.this.f67036c.c(upiProfileDefaultBank);
                    }
                }
            }
        }
    }
}
