package net.one97.paytm.moneytransferv4.accountsbottomsheet;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class e extends RecyclerView.a<c> {

    /* renamed from: a  reason: collision with root package name */
    List<UpiProfileDefaultBank> f55028a;

    /* renamed from: b  reason: collision with root package name */
    int f55029b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f55030c = -1;

    /* renamed from: d  reason: collision with root package name */
    b f55031d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f55032e = true;

    /* renamed from: f  reason: collision with root package name */
    private String f55033f;

    public interface b {
        void a(int i2);

        void a(UpiProfileDefaultBank upiProfileDefaultBank);

        void a(UpiProfileDefaultBank upiProfileDefaultBank, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        c cVar = (c) vVar;
        UpiProfileDefaultBank upiProfileDefaultBank = this.f55028a.get(i2);
        if (upiProfileDefaultBank != null) {
            Context context = cVar.f55039c.getContext();
            cVar.f55039c.setText(context.getString(R.string.check_balance));
            cVar.f55039c.setTextColor(androidx.core.content.b.c(context, R.color.color_00b9f5));
            cVar.f55039c.setVisibility(0);
            if (!(upiProfileDefaultBank.getDebitBank() == null || upiProfileDefaultBank.getDebitBank().getAccount() == null || upiProfileDefaultBank.getDebitBank().getBankName() == null)) {
                if (!"PYTM0123456".equalsIgnoreCase(upiProfileDefaultBank.getDebitBank().getIfsc()) && !upiProfileDefaultBank.getDebitBank().isMpinSet()) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) cVar.f55041e);
                    cVar.f55039c.setText(context.getString(R.string.mt_set_upi_pin));
                }
                String a2 = m.a(upiProfileDefaultBank.getDebitBank().getBankName(), upiProfileDefaultBank.getDebitBank().getAccount());
                TextView a3 = cVar.f55038b;
                if (a2.length() == 0) {
                    a2 = context.getString(R.string.money_tranfer_balance_paytm_bank_string);
                }
                a3.setText(a2);
            }
            ImageView e2 = cVar.f55043g;
            String bankLogoUrl = upiProfileDefaultBank.getDebitBank().getBankLogoUrl();
            if (bankLogoUrl == null || !URLUtil.isValidUrl(bankLogoUrl)) {
                m.a(e2, upiProfileDefaultBank.getDebitBank().getIfsc(), e2.getContext());
            } else {
                w.a().a(bankLogoUrl).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(e2, (com.squareup.picasso.e) null);
            }
        }
        Context context2 = cVar.f55038b.getContext();
        if (i2 == this.f55029b) {
            cVar.f55042f.setChecked(true);
            if (cVar.f55039c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || cVar.f55039c.getText().toString().equalsIgnoreCase(context2.getString(R.string.mt_set_upi_pin))) {
                cVar.f55039c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
            } else {
                cVar.f55039c.setTextColor(androidx.core.content.b.c(context2, R.color.color_222222));
            }
            cVar.f55038b.setTypeface(Typeface.create("sans-serif", 1));
        } else {
            cVar.f55042f.setChecked(false);
            if (cVar.f55039c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || cVar.f55039c.getText().toString().equalsIgnoreCase(context2.getString(R.string.mt_set_upi_pin))) {
                cVar.f55039c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
            } else {
                cVar.f55039c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
            }
            cVar.f55038b.setTypeface(Typeface.create("sans-serif", 0));
        }
        if (i2 != this.f55030c) {
            return;
        }
        if (this.f55032e) {
            a(cVar, true);
            return;
        }
        a(cVar, false);
        if (!TextUtils.isEmpty(this.f55033f)) {
            cVar.f55039c.setText(this.f55033f);
            cVar.f55039c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
            this.f55033f = "";
            return;
        }
        cVar.f55039c.setText(context2.getString(R.string.check_balance));
        cVar.f55039c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
    }

    public final void a(List<UpiProfileDefaultBank> list) {
        List<UpiProfileDefaultBank> list2 = this.f55028a;
        if (list2 == null || list2.isEmpty()) {
            this.f55028a = list;
            notifyDataSetChanged();
            return;
        }
        h.b a2 = h.a(new a(this.f55028a, list));
        this.f55028a = list;
        a2.a((RecyclerView.a) this);
    }

    public final void a(int i2) {
        this.f55029b = i2;
        notifyDataSetChanged();
    }

    public final void a(String str) {
        int i2 = this.f55030c;
        if (i2 != -1) {
            this.f55033f = str;
            notifyItemChanged(i2);
        }
    }

    public final void a() {
        this.f55032e = true;
        notifyItemChanged(this.f55030c);
    }

    public final void b() {
        this.f55032e = false;
        notifyItemChanged(this.f55030c);
    }

    public final void a(b bVar) {
        this.f55031d = bVar;
    }

    public final int getItemCount() {
        List<UpiProfileDefaultBank> list = this.f55028a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private static void a(c cVar, boolean z) {
        if (z) {
            if (cVar != null && cVar.f55041e != null) {
                cVar.f55039c.setVisibility(8);
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) cVar.f55041e);
            }
        } else if (cVar != null && cVar.f55041e != null) {
            cVar.f55039c.setVisibility(0);
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) cVar.f55041e);
        }
    }

    class c extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final TextView f55038b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final TextView f55039c;

        /* renamed from: d  reason: collision with root package name */
        private final View f55040d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final View f55041e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final RadioButton f55042f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final ImageView f55043g;

        c(View view) {
            super(view);
            this.f55042f = (RadioButton) view.findViewById(R.id.radio_button);
            this.f55040d = view.findViewById(R.id.item_rl_root);
            this.f55038b = (TextView) view.findViewById(R.id.source_name);
            this.f55039c = (TextView) view.findViewById(R.id.check_balance_tv);
            this.f55041e = view.findViewById(R.id.wallet_loader);
            this.f55043g = (ImageView) view.findViewById(R.id.bankImage);
            this.f55042f.setClickable(false);
            this.f55040d.setOnClickListener(this);
            this.f55039c.setOnClickListener(this);
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Context context = view.getContext();
            if (e.this.f55031d != null && adapterPosition != -1) {
                if (view.getId() == R.id.item_rl_root) {
                    e eVar = e.this;
                    eVar.notifyItemChanged(eVar.f55029b);
                    e eVar2 = e.this;
                    eVar2.f55029b = adapterPosition;
                    eVar2.notifyItemChanged(eVar2.f55029b);
                    e.this.f55031d.a(adapterPosition);
                } else if (view.getId() == R.id.radio_button) {
                    e eVar3 = e.this;
                    eVar3.notifyItemChanged(eVar3.f55029b);
                    e eVar4 = e.this;
                    eVar4.f55029b = adapterPosition;
                    eVar4.notifyItemChanged(eVar4.f55029b);
                    e.this.f55031d.a(adapterPosition);
                } else if (view.getId() != R.id.check_balance_tv) {
                } else {
                    if (!com.paytm.utility.a.m(context)) {
                        Toast.makeText(context, context.getResources().getString(R.string.no_internet), 0).show();
                    } else if (e.this.f55028a != null && e.this.f55031d != null) {
                        UpiProfileDefaultBank upiProfileDefaultBank = e.this.f55028a.get(adapterPosition);
                        if (this.f55039c.getText().toString().equalsIgnoreCase(context.getString(R.string.check_balance))) {
                            f.a(context, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "check_balance_clicked", "/money-transfer/payment", "", "");
                            e eVar5 = e.this;
                            eVar5.f55030c = adapterPosition;
                            eVar5.f55031d.a(upiProfileDefaultBank, adapterPosition);
                        } else if (this.f55039c.getText().toString().equalsIgnoreCase(context.getString(R.string.mt_set_upi_pin))) {
                            e.this.f55031d.a(upiProfileDefaultBank);
                        }
                    }
                }
            }
        }
    }

    class a extends h.a {

        /* renamed from: b  reason: collision with root package name */
        private List<UpiProfileDefaultBank> f55035b;

        /* renamed from: c  reason: collision with root package name */
        private List<UpiProfileDefaultBank> f55036c;

        public a(List<UpiProfileDefaultBank> list, List<UpiProfileDefaultBank> list2) {
            this.f55035b = list;
            this.f55036c = list2;
        }

        public final int getOldListSize() {
            return this.f55035b.size();
        }

        public final int getNewListSize() {
            return this.f55036c.size();
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            UpiProfileDefaultBank upiProfileDefaultBank = this.f55035b.get(i2);
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.f55036c.get(i3);
            return (upiProfileDefaultBank == null || upiProfileDefaultBank2 == null || !upiProfileDefaultBank.getDebitBank().getAccount().equals(upiProfileDefaultBank2.getDebitBank().getAccount())) ? false : true;
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            UpiProfileDefaultBank upiProfileDefaultBank = this.f55035b.get(i2);
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.f55036c.get(i3);
            if (upiProfileDefaultBank == null || upiProfileDefaultBank2 == null) {
                return false;
            }
            String bankName = upiProfileDefaultBank.getDebitBank().getBankName();
            String bankName2 = upiProfileDefaultBank2.getDebitBank().getBankName();
            if (TextUtils.isEmpty(bankName) || TextUtils.isEmpty(bankName2)) {
                return false;
            }
            return bankName.equals(bankName2);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_all_acccounts_list_item, viewGroup, false));
    }
}
