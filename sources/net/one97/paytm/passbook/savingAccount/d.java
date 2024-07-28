package net.one97.paytm.passbook.savingAccount;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.utility.l;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.UpiConstants;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> f58294a;

    /* renamed from: b  reason: collision with root package name */
    int f58295b;

    /* renamed from: c  reason: collision with root package name */
    boolean f58296c;

    /* renamed from: d  reason: collision with root package name */
    String f58297d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f58298e;

    /* renamed from: f  reason: collision with root package name */
    private Context f58299f;

    /* renamed from: g  reason: collision with root package name */
    private Resources f58300g;

    /* renamed from: h  reason: collision with root package name */
    private String f58301h = "";

    /* renamed from: i  reason: collision with root package name */
    private c f58302i;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail = this.f58294a.get(i2);
            bVar.itemView.setTag(transactionDetail);
            if (!TextUtils.isEmpty(transactionDetail.getTxnDesc())) {
                bVar.f58305c.setText(transactionDetail.getTxnDesc());
            }
            if (!TextUtils.isEmpty(transactionDetail.getNarration())) {
                bVar.f58304b.setText(transactionDetail.getNarration());
            }
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail2 = (SavingAccountPassbookEntriesModal.TransactionDetail) bVar.itemView.getTag();
            if (URLUtil.isValidUrl(transactionDetail2.getImageUrl())) {
                w.a().a(transactionDetail2.getImageUrl()).a((ImageView) bVar.f58309g, (e) null);
                bVar.j.setBackground(this.f58300g.getDrawable(R.drawable.pass_circle_border));
            } else {
                String txnType = transactionDetail2.getTxnType();
                bVar.f58309g.setImageResource(R.drawable.pass_default_sa);
                bVar.f58309g.setImageResource(R.drawable.pass_default_sa);
                bVar.j.setBackground(this.f58300g.getDrawable(R.drawable.pass_circle_border));
                if (txnType.equalsIgnoreCase(AppConstants.FEED_COMMUNITY)) {
                    bVar.f58309g.setImageResource(R.drawable.pass_default_sa);
                } else if (txnType.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
                    bVar.f58309g.setImageResource(R.drawable.pass_default_sa);
                } else {
                    bVar.f58309g.setImageResource(0);
                    bVar.j.setBackground((Drawable) null);
                }
            }
            String txnPostDate = transactionDetail.getTxnPostDate();
            String string = this.f58300g.getString(R.string.wallet_rs);
            String txnType2 = transactionDetail.getTxnType();
            if (this.f58299f != null) {
                if (!TextUtils.isEmpty(txnType2) && txnType2.equalsIgnoreCase(AppConstants.FEED_COMMUNITY)) {
                    String format = new DecimalFormat(q.a(Double.parseDouble(transactionDetail.getAmountValue())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(transactionDetail.getAmountValue()));
                    string = " + " + String.format(string, new Object[]{format});
                    bVar.f58306d.setTextColor(this.f58299f.getResources().getColor(R.color.color_21c17a));
                } else if (!TextUtils.isEmpty(txnType2) && txnType2.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
                    String format2 = new DecimalFormat(q.a(Double.parseDouble(transactionDetail.getAmountValue())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(transactionDetail.getAmountValue()));
                    string = " - " + String.format(string, new Object[]{format2});
                    bVar.f58306d.setTextColor(this.f58299f.getResources().getColor(R.color.color_222222));
                }
                if (!TextUtils.isEmpty(txnPostDate)) {
                    txnPostDate = net.one97.paytm.passbook.mapping.c.k("yyyy-MM-dd'T'HH:mm:ss.SSS", "hh:mm a", txnPostDate);
                }
            }
            if (!this.f58301h.equalsIgnoreCase(StringSet.all)) {
                b(this.f58301h);
            } else if (!TextUtils.isEmpty(txnType2)) {
                if (txnType2.equalsIgnoreCase(AppConstants.FEED_COMMUNITY)) {
                    b("CR");
                } else if (txnType2.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
                    b("DR");
                }
            }
            bVar.f58305c.setText(txnPostDate);
            net.one97.paytm.passbook.mapping.c.b(string, bVar.f58306d);
            bVar.f58307e.setText(this.f58299f.getString(R.string.bank_txn_id) + " " + transactionDetail.getTxnId());
        } else if ((aVar instanceof c) && (this.f58294a.get(i2) instanceof SavingAccountPassbookEntriesModal.TransactionHeader)) {
            ((c) aVar).f58312b.setText(((SavingAccountPassbookEntriesModal.TransactionHeader) this.f58294a.get(i2)).txnDate);
        }
    }

    public d(Fragment fragment, String str, ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList, boolean z, String str2) {
        this.f58299f = fragment.getActivity();
        if (fragment instanceof c) {
            this.f58302i = (c) fragment;
        }
        this.f58300g = fragment.getResources();
        this.f58301h = str;
        this.f58294a = arrayList;
        this.f58296c = z;
        this.f58297d = str2;
    }

    private void b(c cVar, String str) {
        try {
            boolean z = false;
            if (this.f58294a == null) {
                cVar.a(true, str);
            } else if (this.f58294a != null && this.f58294a.size() > 0) {
                cVar.a(false, str);
            } else if (this.f58294a != null && this.f58294a.size() <= 0) {
                cVar.a(true, str);
            }
            if (this.f58294a == null || this.f58294a.size() <= 0) {
                z = true;
            }
            boolean z2 = cVar.f58282a;
            if (z && z2) {
                ((l) this.f58299f).a("");
            }
        } catch (Exception unused) {
        }
    }

    public final int getItemCount() {
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList = this.f58294a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final int getItemViewType(int i2) {
        return this.f58294a.get(i2) instanceof SavingAccountPassbookEntriesModal.TransactionHeader ? 0 : 1;
    }

    public final void a(ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList) {
        if (arrayList.size() == 0) {
            this.f58294a = arrayList;
            return;
        }
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList2 = new ArrayList<>();
        String a2 = a(arrayList.get(0).getTxnPostDate());
        arrayList2.add(arrayList.get(0));
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            if (!a2.equalsIgnoreCase(a(arrayList.get(i2).getTxnPostDate()))) {
                arrayList2.add(new SavingAccountPassbookEntriesModal.TransactionHeader(a(arrayList.get(i2).getTxnPostDate())));
                a2 = a(arrayList.get(i2).getTxnPostDate());
            }
            arrayList2.add(arrayList.get(i2));
        }
        this.f58294a = arrayList2;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public final String a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy");
        try {
            Date parse = simpleDateFormat.parse(str);
            if (DateUtils.isToday(parse.getTime())) {
                return this.f58299f.getString(R.string.today_btn) + ", " + simpleDateFormat2.format(parse);
            } else if (!DateUtils.isToday(parse.getTime() + TimeUnit.DAYS.toMillis(1))) {
                return simpleDateFormat2.format(parse);
            } else {
                return this.f58299f.getString(R.string.yesterday) + ", " + simpleDateFormat2.format(parse);
            }
        } catch (ParseException unused) {
            return "";
        }
    }

    public final String a(int i2) {
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList = this.f58294a;
        if (arrayList != null && arrayList.size() > 0) {
            SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail = this.f58294a.get(i2);
            if (!(transactionDetail instanceof SavingAccountPassbookEntriesModal.TransactionHeader) && (transactionDetail instanceof SavingAccountPassbookEntriesModal.TransactionDetail)) {
                return a(transactionDetail.getTxnPostDate());
            }
        }
        return null;
    }

    public class c extends a {

        /* renamed from: b  reason: collision with root package name */
        final TextView f58312b;

        public c(View view) {
            super(view);
            this.f58312b = (TextView) view.findViewById(R.id.date);
        }
    }

    class b extends a {

        /* renamed from: b  reason: collision with root package name */
        TextView f58304b;

        /* renamed from: c  reason: collision with root package name */
        TextView f58305c;

        /* renamed from: d  reason: collision with root package name */
        TextView f58306d;

        /* renamed from: e  reason: collision with root package name */
        TextView f58307e;

        /* renamed from: f  reason: collision with root package name */
        TextView f58308f;

        /* renamed from: g  reason: collision with root package name */
        CircularImageView f58309g;

        /* renamed from: h  reason: collision with root package name */
        LinearLayout f58310h;

        /* renamed from: i  reason: collision with root package name */
        RelativeLayout f58311i;
        ImageView j;

        public b(View view) {
            super(view);
            this.f58304b = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
            this.f58305c = (TextView) view.findViewById(R.id.passbook_send_receive_name);
            this.f58306d = (TextView) view.findViewById(R.id.passbook_sender_receiver_amount_tv);
            this.f58309g = (CircularImageView) view.findViewById(R.id.passbook_payer_or_payee_icons_iv);
            this.f58310h = (LinearLayout) view.findViewById(R.id.passbook_send_receive_lyt_buttons_ll);
            this.f58311i = (RelativeLayout) view.findViewById(R.id.passbook_entry_row_rl);
            this.j = (ImageView) view.findViewById(R.id.passbook_payer_or_payee_ledger_icon_bg_iv);
            this.f58307e = (TextView) view.findViewById(R.id.passbook_send_receive_txn_dsc_2tv);
            this.f58308f = (TextView) view.findViewById(R.id.passbook_sender_receiver_txn_status_tv);
        }
    }

    public final SavingAccountPassbookEntriesModal.TransactionDetail b(int i2) {
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList = this.f58294a;
        if (arrayList == null || arrayList.size() <= 0 || i2 < 0) {
            return null;
        }
        return this.f58294a.get(i2);
    }

    public final void b(ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList) {
        boolean z = this.f58294a == null && arrayList != null && arrayList.size() > 0;
        this.f58294a = arrayList;
        b(this.f58302i, this.f58301h);
        if (z) {
            a(this.f58302i, this.f58301h);
        }
        notifyDataSetChanged();
    }

    private Drawable b(String str) {
        Context context = this.f58299f;
        if (context == null || !(context instanceof PassbookSubwalletActivity)) {
            return null;
        }
        PassbookSubwalletActivity passbookSubwalletActivity = (PassbookSubwalletActivity) context;
        Drawable drawable = passbookSubwalletActivity.f58763c.get(str);
        if (drawable == null) {
            if (str.equalsIgnoreCase("CR")) {
                drawable = passbookSubwalletActivity.getResources().getDrawable(R.drawable.pass_money_received);
            } else if (str.equalsIgnoreCase("DR")) {
                drawable = passbookSubwalletActivity.getResources().getDrawable(R.drawable.pass_money_sent);
            } else if (str.equalsIgnoreCase("CR_added")) {
                drawable = passbookSubwalletActivity.getResources().getDrawable(R.drawable.pass_money_received);
            }
            if (passbookSubwalletActivity.f58763c.get(str) == null) {
                passbookSubwalletActivity.f58763c.put(str, drawable);
            }
        }
        if (drawable == null) {
            return null;
        }
        return drawable;
    }

    abstract class a extends RecyclerView.v {
        public a(View view) {
            super(view);
        }
    }

    private void a(c cVar, String str) {
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList;
        if (cVar.f58282a && (this.f58299f instanceof l) && (arrayList = this.f58294a) != null && arrayList.size() > 0) {
            ((l) ((Activity) this.f58299f)).a(a(this.f58294a.get(0).getTxnPostDate()));
        }
        b(cVar, str);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (this.f58298e == null) {
            this.f58298e = LayoutInflater.from(viewGroup.getContext());
        }
        if (i2 == 0) {
            return new c(this.f58298e.inflate(R.layout.pass_passbook_transaction_header_item, viewGroup, false));
        }
        if (i2 == 1) {
            return new b(this.f58298e.inflate(R.layout.pass_passbook__module_saving_account_entry_row, (ViewGroup) null));
        }
        return null;
    }
}
