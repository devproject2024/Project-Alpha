package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.SwipeRevealLayout;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public final class l extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    boolean f68947a;

    /* renamed from: b  reason: collision with root package name */
    final y f68948b = new y();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<BankAccountDetails.BankAccount> f68949c;

    /* renamed from: d  reason: collision with root package name */
    b f68950d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f68951e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final int f68952f;

    /* renamed from: g  reason: collision with root package name */
    private final int f68953g = 1;

    /* renamed from: h  reason: collision with root package name */
    private Context f68954h;

    public interface b {
        void a();

        void a(int i2, BankAccountDetails.BankAccount bankAccount);
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f68966a = new d();

        d() {
        }

        public final void onClick(View view) {
        }
    }

    public l(ArrayList<BankAccountDetails.BankAccount> arrayList, Context context, b bVar) {
        k.c(arrayList, "adapterBankList");
        k.c(bVar, "listener");
        this.f68949c = arrayList;
        this.f68954h = context;
        this.f68950d = bVar;
        this.f68948b.a();
    }

    public final int getItemViewType(int i2) {
        if (i2 == this.f68949c.size()) {
            return this.f68953g;
        }
        return this.f68952f;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f68952f) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_signup_add_bank, viewGroup, false));
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_add_another_bank, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…ther_bank, parent, false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f68949c.size() + 1;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof c) {
            y yVar = this.f68948b;
            c cVar = (c) vVar;
            SwipeRevealLayout swipeRevealLayout = cVar.f68963e;
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.getAdapterPosition());
            yVar.a(swipeRevealLayout, sb.toString());
            ArrayList<String> arrayList = this.f68951e;
            ArrayList<BankAccountDetails.BankAccount> arrayList2 = this.f68949c;
            if (arrayList2 == null) {
                k.a();
            }
            BankAccountDetails.BankAccount bankAccount = arrayList2.get(i2);
            k.a((Object) bankAccount, "adapterBankList!![position]");
            arrayList.add(bankAccount.getTempAccRefId());
            if (this.f68949c != null) {
                TextView textView = cVar.f68959a;
                ArrayList<BankAccountDetails.BankAccount> arrayList3 = this.f68949c;
                if (arrayList3 == null) {
                    k.a();
                }
                BankAccountDetails.BankAccount bankAccount2 = arrayList3.get(i2);
                k.a((Object) bankAccount2, "adapterBankList!![position]");
                String bankName = bankAccount2.getBankName();
                ArrayList<BankAccountDetails.BankAccount> arrayList4 = this.f68949c;
                if (arrayList4 == null) {
                    k.a();
                }
                BankAccountDetails.BankAccount bankAccount3 = arrayList4.get(i2);
                k.a((Object) bankAccount3, "adapterBankList!![position]");
                textView.setText(UpiUtils.getAccountNoFormat(bankName, bankAccount3.getMaskedAccountNumber()));
                ArrayList<BankAccountDetails.BankAccount> arrayList5 = this.f68949c;
                if (arrayList5 == null) {
                    k.a();
                }
                BankAccountDetails.BankAccount bankAccount4 = arrayList5.get(i2);
                k.a((Object) bankAccount4, "adapterBankList!![position]");
                String bankLogoUrl = bankAccount4.getBankLogoUrl();
                ImageView imageView = cVar.f68960b;
                ArrayList<BankAccountDetails.BankAccount> arrayList6 = this.f68949c;
                if (arrayList6 == null) {
                    k.a();
                }
                BankAccountDetails.BankAccount bankAccount5 = arrayList6.get(i2);
                k.a((Object) bankAccount5, "adapterBankList!![position]");
                String ifsc = bankAccount5.getIfsc();
                k.a((Object) ifsc, "adapterBankList!![position].ifsc");
                if (URLUtil.isValidUrl(bankLogoUrl)) {
                    w.a().a(bankLogoUrl).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView);
                } else if (!TextUtils.isEmpty(ifsc)) {
                    w a2 = w.a();
                    Context context = this.f68954h;
                    a2.a(UpiRequestBuilder.getBankIconUrl(context != null ? context.getApplicationContext() : null, ifsc)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView);
                }
                cVar.f68961c.setOnClickListener(d.f68966a);
                cVar.f68962d.setOnClickListener(new e(this, vVar));
            }
        } else if (vVar instanceof a) {
            a aVar = (a) vVar;
            aVar.f68955a.setOnClickListener(new a.C1397a(aVar));
            if (aVar.f68957c.f68947a) {
                aVar.f68955a.setVisibility(4);
                AnimationFactory.startWalletLoader(aVar.f68956b);
                return;
            }
            aVar.f68955a.setVisibility(0);
            AnimationFactory.stopWalletLoader(aVar.f68956b);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f68967a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f68968b;

        e(l lVar, RecyclerView.v vVar) {
            this.f68967a = lVar;
            this.f68968b = vVar;
        }

        public final void onClick(View view) {
            if (((c) this.f68968b).getAdapterPosition() < this.f68967a.f68949c.size()) {
                y yVar = this.f68967a.f68948b;
                StringBuilder sb = new StringBuilder();
                sb.append(((c) this.f68968b).getAdapterPosition());
                yVar.b(sb.toString());
                b bVar = this.f68967a.f68950d;
                int adapterPosition = ((c) this.f68968b).getAdapterPosition();
                BankAccountDetails.BankAccount bankAccount = this.f68967a.f68949c.get(((c) this.f68968b).getAdapterPosition());
                k.a((Object) bankAccount, "adapterBankList[holder.adapterPosition]");
                bVar.a(adapterPosition, bankAccount);
            }
        }
    }

    public final void a(boolean z) {
        this.f68947a = z;
        notifyItemChanged(this.f68949c.size());
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f68959a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f68960b;

        /* renamed from: c  reason: collision with root package name */
        final ConstraintLayout f68961c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f68962d;

        /* renamed from: e  reason: collision with root package name */
        final SwipeRevealLayout f68963e;

        /* renamed from: g  reason: collision with root package name */
        private final CheckBox f68965g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            if (view == null) {
                k.a();
            }
            View findViewById = view.findViewById(R.id.tv_bank_name);
            k.a((Object) findViewById, "itemView!!.findViewById(R.id.tv_bank_name)");
            this.f68959a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.chk_bank);
            k.a((Object) findViewById2, "itemView!!.findViewById(R.id.chk_bank)");
            this.f68965g = (CheckBox) findViewById2;
            View findViewById3 = view.findViewById(R.id.iv_bank_logo);
            k.a((Object) findViewById3, "itemView!!.findViewById(R.id.iv_bank_logo)");
            this.f68960b = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.root_layout);
            k.a((Object) findViewById4, "itemView!!.findViewById(R.id.root_layout)");
            this.f68961c = (ConstraintLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.delete);
            k.a((Object) findViewById5, "itemView!!.findViewById(R.id.delete)");
            this.f68962d = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.swipe_layout);
            k.a((Object) findViewById6, "itemView!!.findViewById(R.id.swipe_layout)");
            this.f68963e = (SwipeRevealLayout) findViewById6;
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f68955a;

        /* renamed from: b  reason: collision with root package name */
        final LottieAnimationView f68956b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f68957c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l lVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f68957c = lVar;
            View findViewById = view.findViewById(R.id.addMoreBank);
            k.a((Object) findViewById, "itemView.findViewById(R.id.addMoreBank)");
            this.f68955a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.lottieAnimation);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.lottieAnimation)");
            this.f68956b = (LottieAnimationView) findViewById2;
        }

        /* renamed from: net.one97.paytm.upi.registration.view.l$a$a  reason: collision with other inner class name */
        static final class C1397a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f68958a;

            C1397a(a aVar) {
                this.f68958a = aVar;
            }

            public final void onClick(View view) {
                this.f68958a.f68957c.f68950d.a();
            }
        }
    }
}
