package net.one97.paytm.moneytransferv4.b.a.a.a.d;

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
import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<UpiProfileDefaultBank> f55217a;

    /* renamed from: b  reason: collision with root package name */
    int f55218b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f55219c = -1;

    /* renamed from: d  reason: collision with root package name */
    C1006a f55220d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f55221e = true;

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.d.a$a  reason: collision with other inner class name */
    public interface C1006a {
        void a(int i2);

        void a(UpiProfileDefaultBank upiProfileDefaultBank);

        void a(UpiProfileDefaultBank upiProfileDefaultBank, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        UpiProfileDefaultBank upiProfileDefaultBank = this.f55217a.get(i2);
        if (upiProfileDefaultBank != null) {
            Context context = bVar.f55224c.getContext();
            bVar.f55224c.setText(context.getString(R.string.check_balance));
            bVar.f55224c.setTextColor(androidx.core.content.b.c(context, R.color.color_00b9f5));
            bVar.f55224c.setVisibility(0);
            if (!(upiProfileDefaultBank.getDebitBank() == null || upiProfileDefaultBank.getDebitBank().getAccount() == null || upiProfileDefaultBank.getDebitBank().getBankName() == null)) {
                if (!"PYTM0123456".equalsIgnoreCase(upiProfileDefaultBank.getDebitBank().getIfsc()) && !upiProfileDefaultBank.getDebitBank().isMpinSet()) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) bVar.f55226e);
                    bVar.f55224c.setText(context.getString(R.string.mt_set_upi_pin));
                }
                String a2 = m.a(upiProfileDefaultBank.getDebitBank().getBankName(), upiProfileDefaultBank.getDebitBank().getAccount());
                TextView a3 = bVar.f55223b;
                if (a2.length() == 0) {
                    a2 = context.getString(R.string.money_tranfer_balance_paytm_bank_string);
                }
                a3.setText(a2);
            }
            if (upiProfileDefaultBank.getBalance() != null && upiProfileDefaultBank.getBalance().isEmpty()) {
                bVar.f55224c.setText(upiProfileDefaultBank.getBalance());
            }
            ImageView e2 = bVar.f55228g;
            String bankLogoUrl = upiProfileDefaultBank.getDebitBank().getBankLogoUrl();
            if (bankLogoUrl == null || !URLUtil.isValidUrl(bankLogoUrl)) {
                m.a(e2, upiProfileDefaultBank.getDebitBank().getIfsc(), e2.getContext());
            } else {
                w.a().a(bankLogoUrl).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(e2, (e) null);
            }
        }
        Context context2 = bVar.f55223b.getContext();
        if (i2 == this.f55218b) {
            bVar.f55227f.setChecked(true);
            if (bVar.f55224c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || bVar.f55224c.getText().toString().equalsIgnoreCase(context2.getString(R.string.mt_set_upi_pin))) {
                bVar.f55224c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
            } else {
                bVar.f55224c.setTextColor(androidx.core.content.b.c(context2, R.color.color_222222));
            }
            bVar.f55223b.setTypeface(Typeface.create("sans-serif", 1));
        } else {
            bVar.f55227f.setChecked(false);
            if (bVar.f55224c.getText().toString().equalsIgnoreCase(context2.getString(R.string.check_balance)) || bVar.f55224c.getText().toString().equalsIgnoreCase(context2.getString(R.string.mt_set_upi_pin))) {
                bVar.f55224c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
            } else {
                bVar.f55224c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
            }
            bVar.f55223b.setTypeface(Typeface.create("sans-serif", 0));
        }
        if (this.f55217a.get(i2).isRequestInProgress()) {
            a(bVar, this.f55217a.get(i2).isRequestInProgress());
            return;
        }
        a(bVar, this.f55217a.get(i2).isRequestInProgress());
        if (!TextUtils.isEmpty(this.f55217a.get(i2).getBalance())) {
            bVar.f55224c.setText(this.f55217a.get(i2).getBalance());
            bVar.f55224c.setTextColor(androidx.core.content.b.c(context2, R.color.color_666666));
            return;
        }
        bVar.f55224c.setText(context2.getString(R.string.check_balance));
        bVar.f55224c.setTextColor(androidx.core.content.b.c(context2, R.color.color_00b9f5));
    }

    public final void a(List<UpiProfileDefaultBank> list) {
        List<UpiProfileDefaultBank> list2 = this.f55217a;
        if (list2 == null || list2.isEmpty()) {
            this.f55217a = list;
            notifyDataSetChanged();
            return;
        }
        this.f55217a = list;
        notifyDataSetChanged();
    }

    public final void a(int i2) {
        this.f55218b = i2;
    }

    public final void a(String str) {
        int i2 = this.f55219c;
        if (i2 != -1) {
            this.f55217a.get(i2).setBalance(str);
            notifyItemChanged(this.f55219c);
            this.f55219c = -1;
        }
    }

    public final void a() {
        d();
        this.f55219c = -1;
    }

    public final int b() {
        return this.f55219c;
    }

    public final void c() {
        this.f55217a.get(this.f55219c).setRequestInProgress(true);
        notifyItemChanged(this.f55219c);
    }

    public final void d() {
        this.f55217a.get(this.f55219c).setRequestInProgress(false);
        notifyItemChanged(this.f55219c);
    }

    public final void a(C1006a aVar) {
        this.f55220d = aVar;
    }

    public final int getItemCount() {
        List<UpiProfileDefaultBank> list = this.f55217a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private static void a(b bVar, boolean z) {
        if (z) {
            if (bVar != null && bVar.f55226e != null) {
                bVar.f55224c.setVisibility(8);
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) bVar.f55226e);
            }
        } else if (bVar != null && bVar.f55226e != null) {
            bVar.f55224c.setVisibility(0);
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) bVar.f55226e);
        }
    }

    class b extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final TextView f55223b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final TextView f55224c;

        /* renamed from: d  reason: collision with root package name */
        private final View f55225d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final View f55226e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final RadioButton f55227f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final ImageView f55228g;

        b(View view) {
            super(view);
            this.f55227f = (RadioButton) view.findViewById(R.id.radio_button);
            this.f55225d = view.findViewById(R.id.item_rl_root);
            this.f55223b = (TextView) view.findViewById(R.id.source_name);
            this.f55224c = (TextView) view.findViewById(R.id.check_balance_tv);
            this.f55226e = view.findViewById(R.id.wallet_loader);
            this.f55228g = (ImageView) view.findViewById(R.id.bankImage);
            this.f55227f.setClickable(false);
            this.f55225d.setOnClickListener(this);
            this.f55224c.setOnClickListener(this);
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Context context = view.getContext();
            if (a.this.f55220d != null && adapterPosition != -1) {
                if (view.getId() == R.id.item_rl_root) {
                    a aVar = a.this;
                    aVar.notifyItemChanged(aVar.f55218b);
                    a aVar2 = a.this;
                    aVar2.f55218b = adapterPosition;
                    aVar2.notifyItemChanged(aVar2.f55218b);
                    a.this.f55220d.a(adapterPosition);
                } else if (view.getId() == R.id.radio_button) {
                    a aVar3 = a.this;
                    aVar3.notifyItemChanged(aVar3.f55218b);
                    a aVar4 = a.this;
                    aVar4.f55218b = adapterPosition;
                    aVar4.notifyItemChanged(aVar4.f55218b);
                    a.this.f55220d.a(adapterPosition);
                } else if (view.getId() != R.id.check_balance_tv) {
                } else {
                    if (!com.paytm.utility.a.m(context)) {
                        Toast.makeText(context, context.getResources().getString(R.string.no_internet), 0).show();
                    } else if (a.this.f55217a != null && a.this.f55220d != null) {
                        UpiProfileDefaultBank upiProfileDefaultBank = a.this.f55217a.get(adapterPosition);
                        if (this.f55224c.getText().toString().equalsIgnoreCase(context.getString(R.string.check_balance))) {
                            f.a(context, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "check_balance_clicked", "/money-transfer/payment", "", "");
                            a aVar5 = a.this;
                            aVar5.f55219c = adapterPosition;
                            aVar5.f55220d.a(upiProfileDefaultBank, adapterPosition);
                        } else if (this.f55224c.getText().toString().equalsIgnoreCase(context.getString(R.string.mt_set_upi_pin))) {
                            a.this.f55220d.a(upiProfileDefaultBank);
                        }
                    }
                }
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_all_acccounts_list_item, viewGroup, false));
    }
}
