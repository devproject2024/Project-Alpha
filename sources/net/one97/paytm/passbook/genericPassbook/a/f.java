package net.one97.paytm.passbook.genericPassbook.a;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.w;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.customview.d;
import net.one97.paytm.passbook.savingAccount.SavingAccountTransactionDetailActivity;
import net.one97.paytm.passbook.search.b.a;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.UpiConstants;

public final class f extends RecyclerView.a<RecyclerView.v> implements a.C1128a {

    /* renamed from: a  reason: collision with root package name */
    public String f57306a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> f57307b;

    /* renamed from: c  reason: collision with root package name */
    private final int f57308c;

    /* renamed from: d  reason: collision with root package name */
    private final int f57309d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f57310e = 2;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f57311f;

    /* renamed from: g  reason: collision with root package name */
    private d f57312g = new d();

    public f(ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList) {
        k.c(arrayList, "mTransactionList");
        this.f57307b = arrayList;
        this.f57312g.a();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.f57311f = from;
        if (i2 == this.f57308c) {
            LayoutInflater layoutInflater = this.f57311f;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            View inflate = layoutInflater.inflate(R.layout.pass_new_search_header_item, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…ader_item, parent, false)");
            return new b(inflate);
        }
        LayoutInflater layoutInflater2 = this.f57311f;
        if (layoutInflater2 == null) {
            k.a("mInflater");
        }
        View inflate2 = layoutInflater2.inflate(R.layout.pass_generic_subwallet_txn_item_layout, (ViewGroup) null);
        k.a((Object) inflate2, "mInflater.inflate(R.layo…et_txn_item_layout, null)");
        return new a(inflate2);
    }

    public final int getItemCount() {
        return this.f57307b.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        RecyclerView.v vVar2 = vVar;
        int i3 = i2;
        k.c(vVar2, "holder");
        if (vVar2 instanceof a) {
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail = this.f57307b.get(i3);
            k.a((Object) transactionDetail, "mTransactionList[position]");
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail2 = transactionDetail;
            View view = vVar2.itemView;
            k.a((Object) view, "holder.itemView");
            view.setTag(transactionDetail2);
            if (!TextUtils.isEmpty(transactionDetail2.getTxnDesc())) {
                TextView textView = ((a) vVar2).f57315c;
                k.a((Object) textView, "holder.passbookSendReceiveName");
                textView.setText(transactionDetail2.getTxnDesc());
            }
            if (!TextUtils.isEmpty(transactionDetail2.getNarration())) {
                TextView textView2 = ((a) vVar2).f57314b;
                k.a((Object) textView2, "holder.passbookSendReceiveType");
                textView2.setText(transactionDetail2.getNarration());
            }
            a aVar = (a) vVar2;
            View view2 = aVar.itemView;
            k.a((Object) view2, "holder.itemView");
            Object tag = view2.getTag();
            if (tag != null) {
                SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail3 = (SavingAccountPassbookEntriesModal.TransactionDetail) tag;
                if (URLUtil.isValidUrl(transactionDetail3.getImageUrl())) {
                    w.a().a(transactionDetail3.getImageUrl()).a((ImageView) aVar.f57319g);
                    ImageView imageView = aVar.f57320h;
                    k.a((Object) imageView, "holder.passbookEntryIconBackground");
                    View view3 = aVar.itemView;
                    k.a((Object) view3, "holder.itemView");
                    imageView.setBackground(androidx.core.content.b.a(view3.getContext(), R.drawable.pass_circle_border));
                } else {
                    String txnType = transactionDetail3.getTxnType();
                    aVar.f57319g.setImageResource(R.drawable.pass_default_sa);
                    aVar.f57319g.setImageResource(R.drawable.pass_default_sa);
                    ImageView imageView2 = aVar.f57320h;
                    k.a((Object) imageView2, "holder.passbookEntryIconBackground");
                    View view4 = aVar.itemView;
                    k.a((Object) view4, "holder.itemView");
                    imageView2.setBackground(androidx.core.content.b.a(view4.getContext(), R.drawable.pass_circle_border));
                    if (p.a(txnType, AppConstants.FEED_COMMUNITY, true)) {
                        aVar.f57319g.setImageResource(R.drawable.pass_default_sa);
                    } else if (p.a(txnType, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, true)) {
                        aVar.f57319g.setImageResource(R.drawable.pass_default_sa);
                    } else {
                        aVar.f57319g.setImageResource(0);
                        ImageView imageView3 = aVar.f57320h;
                        k.a((Object) imageView3, "holder.passbookEntryIconBackground");
                        imageView3.setBackground((Drawable) null);
                    }
                }
                String txnPostDate = transactionDetail2.getTxnPostDate();
                View view5 = aVar.itemView;
                k.a((Object) view5, "holder.itemView");
                String string = view5.getContext().getString(R.string.wallet_rs);
                String txnType2 = transactionDetail2.getTxnType();
                View view6 = aVar.itemView;
                k.a((Object) view6, "holder.itemView");
                if (view6.getContext() != null) {
                    CharSequence charSequence = txnType2;
                    if (!TextUtils.isEmpty(charSequence) && p.a(txnType2, AppConstants.FEED_COMMUNITY, true)) {
                        String format = new DecimalFormat(q.a(Double.parseDouble(transactionDetail2.getAmountValue())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(transactionDetail2.getAmountValue()));
                        StringBuilder sb = new StringBuilder(" + ");
                        aa aaVar = aa.f47921a;
                        k.a((Object) string, "rsformat");
                        String format2 = String.format(string, Arrays.copyOf(new Object[]{format}, 1));
                        k.a((Object) format2, "java.lang.String.format(format, *args)");
                        sb.append(format2);
                        string = sb.toString();
                        TextView textView3 = aVar.f57317e;
                        View view7 = aVar.itemView;
                        k.a((Object) view7, "holder.itemView");
                        textView3.setTextColor(androidx.core.content.b.c(view7.getContext(), R.color.color_21c17a));
                    } else if (!TextUtils.isEmpty(charSequence) && p.a(txnType2, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, true)) {
                        String format3 = new DecimalFormat(q.a(Double.parseDouble(transactionDetail2.getAmountValue())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(transactionDetail2.getAmountValue()));
                        StringBuilder sb2 = new StringBuilder(" - ");
                        aa aaVar2 = aa.f47921a;
                        k.a((Object) string, "rsformat");
                        String format4 = String.format(string, Arrays.copyOf(new Object[]{format3}, 1));
                        k.a((Object) format4, "java.lang.String.format(format, *args)");
                        sb2.append(format4);
                        string = sb2.toString();
                        TextView textView4 = aVar.f57317e;
                        View view8 = aVar.itemView;
                        k.a((Object) view8, "holder.itemView");
                        textView4.setTextColor(androidx.core.content.b.c(view8.getContext(), R.color.color_222222));
                    }
                    if (!TextUtils.isEmpty(txnPostDate)) {
                        txnPostDate = net.one97.paytm.passbook.mapping.c.k("yyyy-MM-dd'T'HH:mm:ss.SSS", "hh:mm a", txnPostDate);
                    }
                }
                TextView textView5 = aVar.f57316d;
                k.a((Object) textView5, "holder.passbookTransactionTime");
                textView5.setVisibility(0);
                TextView textView6 = aVar.f57316d;
                k.a((Object) textView6, "holder.passbookTransactionTime");
                textView6.setText(txnPostDate);
                net.one97.paytm.passbook.mapping.c.b(string, aVar.f57317e);
                TextView textView7 = aVar.f57318f;
                k.a((Object) textView7, "holder.desc2");
                StringBuilder sb3 = new StringBuilder();
                View view9 = aVar.itemView;
                k.a((Object) view9, "holder.itemView");
                sb3.append(view9.getContext().getString(R.string.bank_txn_id));
                sb3.append(" ");
                sb3.append(transactionDetail2.getTxnId());
                textView7.setText(sb3.toString());
                aVar.f57313a.setOnClickListener(new c(this, vVar2, i3));
                View view10 = aVar.f57321i;
                k.a((Object) view10, "holder.bottomSeparator");
                view10.setVisibility(0);
                if (i3 != this.f57307b.size() - 1 && (this.f57307b.get(i3 + 1) instanceof SavingAccountPassbookEntriesModal.TransactionHeader)) {
                    View view11 = aVar.f57321i;
                    k.a((Object) view11, "holder.bottomSeparator");
                    view11.setVisibility(8);
                }
                if (i3 == this.f57307b.size() - 1) {
                    View view12 = aVar.f57321i;
                    k.a((Object) view12, "holder.bottomSeparator");
                    view12.setVisibility(8);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal.TransactionDetail");
        } else if ((vVar2 instanceof b) && (this.f57307b.get(i3) instanceof SavingAccountPassbookEntriesModal.TransactionHeader)) {
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail4 = this.f57307b.get(i3);
            if (transactionDetail4 != null) {
                SavingAccountPassbookEntriesModal.TransactionHeader transactionHeader = (SavingAccountPassbookEntriesModal.TransactionHeader) transactionDetail4;
                k.c(transactionHeader, "transaction");
                ((b) vVar2).f57322a.setText(transactionHeader.txnDate);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal.TransactionHeader");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f57323a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f57324b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f57325c;

        c(f fVar, RecyclerView.v vVar, int i2) {
            this.f57323a = fVar;
            this.f57324b = vVar;
            this.f57325c = i2;
        }

        public final void onClick(View view) {
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail;
            f fVar = this.f57323a;
            a aVar = (a) this.f57324b;
            int i2 = this.f57325c;
            net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
            View view2 = aVar.itemView;
            k.a((Object) view2, "holder.itemView");
            b2.a(view2.getContext(), "passbook", "recents_clicked", BaseViewModel.PaymentType.PPB, "", "/passbook/ppb", "passbook");
            ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList = fVar.f57307b;
            if (!(arrayList == null || (transactionDetail = arrayList.get(i2)) == null)) {
                String str = fVar.f57306a;
                if (str == null) {
                    k.a("mAccountNumber");
                }
                transactionDetail.setAccountId(str);
            }
            View view3 = aVar.itemView;
            k.a((Object) view3, "holder.itemView");
            Intent intent = new Intent(view3.getContext(), SavingAccountTransactionDetailActivity.class);
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail2 = fVar.f57307b.get(i2);
            String str2 = null;
            intent.putExtra("txnId", transactionDetail2 != null ? transactionDetail2.getTxnId() : null);
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail3 = fVar.f57307b.get(i2);
            intent.putExtra("txnDate", transactionDetail3 != null ? transactionDetail3.getTxnPostDate() : null);
            String str3 = fVar.f57306a;
            if (str3 == null) {
                k.a("mAccountNumber");
            }
            intent.putExtra("ActId", str3);
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail4 = fVar.f57307b.get(i2);
            intent.putExtra("serialNum", transactionDetail4 != null ? transactionDetail4.getTxnSerialNumber() : null);
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail5 = fVar.f57307b.get(i2);
            intent.putExtra("reportCode", transactionDetail5 != null ? transactionDetail5.getReportCode() : null);
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail6 = fVar.f57307b.get(i2);
            intent.putExtra("bank_description", transactionDetail6 != null ? transactionDetail6.getNarration() : null);
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail7 = fVar.f57307b.get(i2);
            if (transactionDetail7 != null) {
                str2 = transactionDetail7.getReportCode();
            }
            intent.putExtra("reportCode", str2);
            intent.putExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, fVar.f57307b.get(i2));
            intent.putExtra(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
            View view4 = aVar.itemView;
            k.a((Object) view4, "holder.itemView");
            view4.getContext().startActivity(intent);
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f57307b.get(i2) instanceof SavingAccountPassbookEntriesModal.TransactionHeader) {
            return this.f57308c;
        }
        return this.f57309d;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RelativeLayout f57313a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f57314b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f57315c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f57316d;

        /* renamed from: e  reason: collision with root package name */
        TextView f57317e;

        /* renamed from: f  reason: collision with root package name */
        TextView f57318f;

        /* renamed from: g  reason: collision with root package name */
        CircularImageView f57319g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f57320h;

        /* renamed from: i  reason: collision with root package name */
        View f57321i;
        private TextView j;
        private LinearLayout k;
        private RelativeLayout l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f57313a = (RelativeLayout) view.findViewById(R.id.passbook_entry_row_rl);
            this.f57314b = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
            this.f57315c = (TextView) view.findViewById(R.id.passbook_send_receive_name);
            this.f57316d = (TextView) view.findViewById(R.id.passbook_send_receive_time);
            this.f57317e = (TextView) view.findViewById(R.id.passbook_sender_receiver_amount_tv);
            this.f57318f = (TextView) view.findViewById(R.id.passbook_send_receive_txn_dsc_2tv);
            this.j = (TextView) view.findViewById(R.id.passbook_sender_receiver_txn_status_tv);
            this.f57319g = (CircularImageView) view.findViewById(R.id.passbook_payer_or_payee_icons_iv);
            this.k = (LinearLayout) view.findViewById(R.id.passbook_send_receive_lyt_buttons_ll);
            this.l = (RelativeLayout) view.findViewById(R.id.passbook_entry_row_rl);
            this.f57320h = (ImageView) view.findViewById(R.id.passbook_payer_or_payee_ledger_icon_bg_iv);
            this.f57321i = view.findViewById(R.id.bottom_separator);
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f57322a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.date);
            k.a((Object) findViewById, "itemView.findViewById(R.id.date)");
            this.f57322a = (TextView) findViewById;
        }
    }

    public final int a(int i2) {
        while (!c(i2)) {
            i2--;
            if (i2 < 0) {
                return 0;
            }
        }
        return i2;
    }

    public final int b(int i2) {
        if (this.f57307b.get(i2) instanceof SavingAccountPassbookEntriesModal.TransactionDetail) {
            return R.layout.pass_new_search_header_item;
        }
        return R.layout.pass_generic_subwallet_txn_item_layout;
    }

    public final void a(View view, int i2) {
        TextView textView = view != null ? (TextView) view.findViewById(R.id.date) : null;
        SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail = this.f57307b.get(i2);
        if (transactionDetail != null) {
            SavingAccountPassbookEntriesModal.TransactionHeader transactionHeader = (SavingAccountPassbookEntriesModal.TransactionHeader) transactionDetail;
            if (textView != null) {
                textView.setText(transactionHeader.txnDate);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal.TransactionHeader");
    }

    public final boolean c(int i2) {
        try {
            return this.f57307b.get(i2) instanceof SavingAccountPassbookEntriesModal.TransactionHeader;
        } catch (Exception unused) {
            return false;
        }
    }
}
