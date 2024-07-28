package net.one97.paytm.games.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.a.g;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.model.pfg.GameUserTransaction;
import net.one97.paytm.games.model.pfg.TxnDate;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends Object> f35453a;

    /* renamed from: b  reason: collision with root package name */
    public int f35454b;

    /* renamed from: c  reason: collision with root package name */
    public int f35455c;

    /* renamed from: d  reason: collision with root package name */
    private final int f35456d;

    /* renamed from: e  reason: collision with root package name */
    private final int f35457e;

    /* renamed from: f  reason: collision with root package name */
    private final int f35458f;

    /* renamed from: g  reason: collision with root package name */
    private Context f35459g;

    public d() {
        this.f35457e = 1;
        this.f35458f = 2;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        if (getItemViewType(i2) != this.f35458f) {
            Context context = this.f35459g;
            if (context == null) {
                k.a("mContext");
            }
            List<? extends Object> list = this.f35453a;
            aVar.a(context, list != null ? list.get(i2) : null);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar;
        k.c(viewGroup, "parent");
        if (i2 == this.f35456d) {
            aVar = new b(g.a(viewGroup, R.layout.item_transaction_date));
        } else if (i2 == this.f35458f) {
            aVar = new C0593d(g.a(viewGroup, R.layout.item_txn_pagination_progress));
        } else {
            aVar = new c(g.a(viewGroup, R.layout.item_transaction));
        }
        return aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        this();
        k.c(context, "context");
        this.f35459g = context;
    }

    public final int getItemCount() {
        List<? extends Object> list = this.f35453a;
        int size = list != null ? list.size() : 0;
        return this.f35455c < this.f35454b ? size + 1 : size;
    }

    public final int getItemViewType(int i2) {
        List<? extends Object> list = this.f35453a;
        if (list != null && i2 == list.size()) {
            return this.f35458f;
        }
        List<? extends Object> list2 = this.f35453a;
        if ((list2 != null ? list2.get(i2) : null) instanceof TxnDate) {
            return this.f35456d;
        }
        return this.f35457e;
    }

    public final void a(List<? extends Object> list, int i2, int i3) {
        k.c(list, "data");
        this.f35453a = list;
        this.f35454b = i2;
        this.f35455c = i3;
        notifyDataSetChanged();
    }

    public static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f35461a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f35462b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f35463c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f35464d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f35465e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "itemView");
            this.f35461a = (TextView) view.findViewById(R.id.txt_title);
            this.f35462b = (TextView) view.findViewById(R.id.txt_transaction_id);
            this.f35463c = (TextView) view.findViewById(R.id.txt_transaction_amt);
            this.f35464d = (TextView) view.findViewById(R.id.txt_transaction_status_amt);
            this.f35465e = (TextView) view.findViewById(R.id.txt_transaction_time);
        }

        public final void a(Context context, Object obj) {
            k.c(context, "context");
            if (obj != null) {
                GameUserTransaction gameUserTransaction = (GameUserTransaction) obj;
                TextView textView = this.f35461a;
                k.a((Object) textView, "mTitle");
                textView.setText(gameUserTransaction.getRemark());
                TextView textView2 = this.f35465e;
                k.a((Object) textView2, "mTxnTime");
                textView2.setText(f.a("dd MMM yyyy", gameUserTransaction.getCreateTimeStamp()));
                TextView textView3 = this.f35462b;
                k.a((Object) textView3, "mTxnId");
                textView3.setText("Transaction ID: " + gameUserTransaction.getWalletOrderId());
                CharSequence statusName = gameUserTransaction.getStatusName();
                if (statusName == null || statusName.length() == 0) {
                    if (k.a((Object) gameUserTransaction.getTypeName(), (Object) "+")) {
                        TextView textView4 = this.f35464d;
                        k.a((Object) textView4, "mTxnAmountStatus");
                        textView4.setText("+ " + gameUserTransaction.getAmount());
                        this.f35464d.setTextColor(context.getResources().getColor(R.color.game_txn_success_txt));
                    } else {
                        this.f35464d.setTextColor(context.getResources().getColor(R.color.black_000000));
                        TextView textView5 = this.f35464d;
                        k.a((Object) textView5, "mTxnAmountStatus");
                        textView5.setText("- " + gameUserTransaction.getAmount());
                    }
                    TextView textView6 = this.f35463c;
                    k.a((Object) textView6, "mTxnAmount");
                    textView6.setVisibility(8);
                    return;
                }
                if (k.a((Object) gameUserTransaction.getStatusName(), (Object) "Failure")) {
                    this.f35464d.setTextColor(context.getResources().getColor(R.color.game_txn_failure_txt));
                } else {
                    this.f35464d.setTextColor(context.getResources().getColor(R.color.game_txn_progress_txt));
                }
                TextView textView7 = this.f35464d;
                k.a((Object) textView7, "mTxnAmountStatus");
                textView7.setText(gameUserTransaction.getStatusName());
                g.a(this.f35464d);
                g.a(this.f35463c);
                this.f35463c.setTextColor(context.getResources().getColor(R.color.game_txn_fail_amt_txt));
                TextView textView8 = this.f35463c;
                k.a((Object) textView8, "mTxnAmount");
                textView8.setText(gameUserTransaction.getTypeName() + " " + gameUserTransaction.getAmount());
            }
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f35460a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f35460a = (TextView) view.findViewById(R.id.txt_date);
        }

        public final void a(Context context, Object obj) {
            k.c(context, "context");
            if (obj != null) {
                TextView textView = this.f35460a;
                k.a((Object) textView, "mDate");
                textView.setText(((TxnDate) obj).getDate());
            }
        }
    }

    /* renamed from: net.one97.paytm.games.a.a.d$d  reason: collision with other inner class name */
    public static final class C0593d extends a {
        public final void a(Context context, Object obj) {
            k.c(context, "context");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0593d(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }

    public static abstract class a extends RecyclerView.v {
        public abstract void a(Context context, Object obj);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
