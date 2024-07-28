package net.one97.paytm.passbook.landing.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.aa;
import com.squareup.picasso.af;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.PaymentHistoryResponse;
import net.one97.paytm.passbook.beans.PaymentHistoryRootHeader;
import net.one97.paytm.passbook.beans.PaymentHistoryTransaction;
import net.one97.paytm.passbook.beans.PaymentHistoryTransactionHeader;
import net.one97.paytm.passbook.beans.PaymentHistoryTransactionItems;
import net.one97.paytm.passbook.beans.SecondPartyInfo;
import net.one97.paytm.passbook.beans.UserInstrumentLogos;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.search.b.a;
import net.one97.paytm.passbook.transactionHistory.activity.TransactionHistoryActivity;
import net.one97.paytm.passbook.utility.i;
import net.one97.paytm.passbook.utility.q;

public final class a extends RecyclerView.a<RecyclerView.v> implements a.C1128a {

    /* renamed from: a  reason: collision with root package name */
    public PaymentHistoryResponse f57542a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PaymentHistoryTransaction> f57543b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public String f57544c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f57545d;

    /* renamed from: e  reason: collision with root package name */
    final net.one97.paytm.passbook.landing.d.b f57546e;

    /* renamed from: f  reason: collision with root package name */
    private final int f57547f;

    /* renamed from: g  reason: collision with root package name */
    private final int f57548g = 1;

    /* renamed from: h  reason: collision with root package name */
    private final int f57549h = 3;

    /* renamed from: i  reason: collision with root package name */
    private final int f57550i = 2;
    private LayoutInflater j;
    private boolean k;
    private c l;

    public interface c {
        void a();
    }

    public a(c cVar, net.one97.paytm.passbook.landing.d.b bVar) {
        k.c(cVar, "loadMoreListener");
        k.c(bVar, "filterClickListener");
        this.l = cVar;
        this.f57546e = bVar;
    }

    public final void a() {
        if (this.f57543b.isEmpty()) {
            this.f57543b.add(new PaymentHistoryTransaction(new PaymentHistoryRootHeader("Sample Text"), (PaymentHistoryTransactionHeader) null, (PaymentHistoryTransactionItems) null));
        }
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.j = from;
        if (i2 == this.f57547f) {
            LayoutInflater layoutInflater = this.j;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            View inflate = layoutInflater.inflate(R.layout.pass_white_header_layout, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…er_layout, parent, false)");
            return new C1084a(inflate);
        } else if (i2 == this.f57549h) {
            LayoutInflater layoutInflater2 = this.j;
            if (layoutInflater2 == null) {
                k.a("mInflater");
            }
            View inflate2 = layoutInflater2.inflate(R.layout.pass_payment_history_root_header, viewGroup, false);
            k.a((Object) inflate2, "mInflater.inflate(R.layo…ot_header, parent, false)");
            return new d(this, inflate2);
        } else {
            LayoutInflater layoutInflater3 = this.j;
            if (layoutInflater3 == null) {
                k.a("mInflater");
            }
            View inflate3 = layoutInflater3.inflate(R.layout.pass_payment_history_item_layout, viewGroup, false);
            k.a((Object) inflate3, "mInflater.inflate(R.layo…em_layout, parent, false)");
            return new b(inflate3);
        }
    }

    public final int getItemCount() {
        return this.f57543b.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f57543b.get(i2).getTxnHeader() != null) {
            return this.f57547f;
        }
        if (this.f57543b.get(i2).getHeaderLayout() != null) {
            return this.f57549h;
        }
        return this.f57548g;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String logoUrl;
        String logoUrl2;
        RecyclerView.v vVar2 = vVar;
        int i3 = i2;
        k.c(vVar2, "holder");
        if (vVar2 instanceof C1084a) {
            TextView textView = ((C1084a) vVar2).f57551a;
            PaymentHistoryTransactionHeader txnHeader = this.f57543b.get(i3).getTxnHeader();
            textView.setText(txnHeader != null ? txnHeader.getTxnDate() : null);
        } else {
            int i4 = 0;
            if (vVar2 instanceof b) {
                PaymentHistoryTransactionItems txnItem = this.f57543b.get(i3).getTxnItem();
                if (txnItem != null) {
                    b bVar = (b) vVar2;
                    k.c(txnItem, "transaction");
                    View view = bVar.itemView;
                    k.a((Object) view, "itemView");
                    TextView textView2 = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
                    k.a((Object) textView2, "itemView.passbook_send_receive_type_tv");
                    String narration = txnItem.getNarration();
                    SecondPartyInfo secondPartyInfo = txnItem.getSecondPartyInfo();
                    String name = secondPartyInfo != null ? secondPartyInfo.getName() : null;
                    String txnIndicator = txnItem.getTxnIndicator();
                    View view2 = bVar.itemView;
                    k.a((Object) view2, "itemView");
                    TextView textView3 = (TextView) view2.findViewById(R.id.passbook_send_receive_type_tv);
                    k.a((Object) textView3, "itemView.passbook_send_receive_type_tv");
                    Context context = textView3.getContext();
                    k.a((Object) context, "itemView.passbook_send_receive_type_tv.context");
                    String str = "";
                    if (narration != null) {
                        str = str + narration + ' ';
                    }
                    if (name != null) {
                        str = str + name + ' ';
                    }
                    if (txnIndicator != null) {
                        if (str == null) {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        } else if (TextUtils.isEmpty(p.b(str).toString())) {
                            if (txnIndicator.equals("2")) {
                                str = context.getString(R.string.pass_narration_money_debited);
                                k.a((Object) str, "context.getString(R.stri…_narration_money_debited)");
                            } else if (txnIndicator.equals("1")) {
                                String string = context.getString(R.string.pass_narration_money_credited);
                                k.a((Object) string, "context.getString(R.stri…narration_money_credited)");
                                str = string;
                            }
                        }
                    }
                    if (str != null) {
                        textView2.setText(p.b(str).toString());
                        String txnIndicator2 = txnItem.getTxnIndicator();
                        if (txnIndicator2 != null) {
                            String amount = txnItem.getAmount();
                            String c2 = amount != null ? net.one97.paytm.passbook.utility.f.c(Double.parseDouble(amount)) : null;
                            if (TextUtils.isEmpty(txnItem.getStatusKey()) || !p.a(txnItem.getStatusKey(), "2", true)) {
                                View view3 = bVar.itemView;
                                k.a((Object) view3, "itemView");
                                AppCompatTextView appCompatTextView = (AppCompatTextView) view3.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                k.a((Object) appCompatTextView, "itemView.passbook_sender_receiver_amount_tv");
                                View view4 = bVar.itemView;
                                k.a((Object) view4, "itemView");
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) view4.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                k.a((Object) appCompatTextView2, "itemView.passbook_sender_receiver_amount_tv");
                                String string2 = appCompatTextView2.getContext().getString(R.string.pass_rupee, new Object[]{c2});
                                k.a((Object) string2, "itemView.passbook_sender…s_rupee, strTotalBalance)");
                                net.one97.paytm.passbook.utility.f.a(appCompatTextView, string2);
                            } else {
                                CharSequence charSequence = "2";
                                if (txnIndicator2 == null) {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                } else if (txnIndicator2.contentEquals(charSequence)) {
                                    View view5 = bVar.itemView;
                                    k.a((Object) view5, "itemView");
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) view5.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                    k.a((Object) appCompatTextView3, "itemView.passbook_sender_receiver_amount_tv");
                                    View view6 = bVar.itemView;
                                    k.a((Object) view6, "itemView");
                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) view6.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                    k.a((Object) appCompatTextView4, "itemView.passbook_sender_receiver_amount_tv");
                                    String string3 = appCompatTextView4.getContext().getString(R.string.pass_rupee_debit, new Object[]{c2});
                                    k.a((Object) string3, "itemView.passbook_sender…e_debit, strTotalBalance)");
                                    net.one97.paytm.passbook.utility.f.a(appCompatTextView3, string3);
                                } else {
                                    CharSequence charSequence2 = "1";
                                    if (txnIndicator2 == null) {
                                        throw new u("null cannot be cast to non-null type java.lang.String");
                                    } else if (txnIndicator2.contentEquals(charSequence2)) {
                                        View view7 = bVar.itemView;
                                        k.a((Object) view7, "itemView");
                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) view7.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                        k.a((Object) appCompatTextView5, "itemView.passbook_sender_receiver_amount_tv");
                                        View view8 = bVar.itemView;
                                        k.a((Object) view8, "itemView");
                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) view8.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                        k.a((Object) appCompatTextView6, "itemView.passbook_sender_receiver_amount_tv");
                                        String string4 = appCompatTextView6.getContext().getString(R.string.pass_rupee_credit, new Object[]{c2});
                                        k.a((Object) string4, "itemView.passbook_sender…_credit, strTotalBalance)");
                                        net.one97.paytm.passbook.utility.f.a(appCompatTextView5, string4);
                                    } else {
                                        View view9 = bVar.itemView;
                                        k.a((Object) view9, "itemView");
                                        AppCompatTextView appCompatTextView7 = (AppCompatTextView) view9.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                        k.a((Object) appCompatTextView7, "itemView.passbook_sender_receiver_amount_tv");
                                        View view10 = bVar.itemView;
                                        k.a((Object) view10, "itemView");
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) view10.findViewById(R.id.passbook_sender_receiver_amount_tv);
                                        k.a((Object) appCompatTextView8, "itemView.passbook_sender_receiver_amount_tv");
                                        String string5 = appCompatTextView8.getContext().getString(R.string.pass_rupee, new Object[]{c2});
                                        k.a((Object) string5, "itemView.passbook_sender…s_rupee, strTotalBalance)");
                                        net.one97.paytm.passbook.utility.f.a(appCompatTextView7, string5);
                                    }
                                }
                            }
                        }
                        Boolean maskAmount = txnItem.getMaskAmount();
                        if (maskAmount == null) {
                            b bVar2 = bVar;
                            View view11 = bVar2.itemView;
                            k.a((Object) view11, "itemView");
                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) view11.findViewById(R.id.tvViewAmount);
                            k.a((Object) appCompatTextView9, "itemView.tvViewAmount");
                            appCompatTextView9.setVisibility(4);
                            View view12 = bVar2.itemView;
                            k.a((Object) view12, "itemView");
                            AppCompatTextView appCompatTextView10 = (AppCompatTextView) view12.findViewById(R.id.passbook_sender_receiver_amount_tv);
                            k.a((Object) appCompatTextView10, "itemView.passbook_sender_receiver_amount_tv");
                            appCompatTextView10.setVisibility(0);
                        } else if (maskAmount.booleanValue()) {
                            View view13 = bVar.itemView;
                            k.a((Object) view13, "itemView");
                            AppCompatTextView appCompatTextView11 = (AppCompatTextView) view13.findViewById(R.id.tvViewAmount);
                            k.a((Object) appCompatTextView11, "itemView.tvViewAmount");
                            appCompatTextView11.setVisibility(0);
                            View view14 = bVar.itemView;
                            k.a((Object) view14, "itemView");
                            AppCompatTextView appCompatTextView12 = (AppCompatTextView) view14.findViewById(R.id.passbook_sender_receiver_amount_tv);
                            k.a((Object) appCompatTextView12, "itemView.passbook_sender_receiver_amount_tv");
                            appCompatTextView12.setVisibility(4);
                        } else {
                            View view15 = bVar.itemView;
                            k.a((Object) view15, "itemView");
                            AppCompatTextView appCompatTextView13 = (AppCompatTextView) view15.findViewById(R.id.tvViewAmount);
                            k.a((Object) appCompatTextView13, "itemView.tvViewAmount");
                            appCompatTextView13.setVisibility(4);
                            View view16 = bVar.itemView;
                            k.a((Object) view16, "itemView");
                            AppCompatTextView appCompatTextView14 = (AppCompatTextView) view16.findViewById(R.id.passbook_sender_receiver_amount_tv);
                            k.a((Object) appCompatTextView14, "itemView.passbook_sender_receiver_amount_tv");
                            appCompatTextView14.setVisibility(0);
                        }
                        View view17 = bVar.itemView;
                        k.a((Object) view17, "itemView");
                        ((AppCompatTextView) view17.findViewById(R.id.tvViewAmount)).setOnClickListener(new b.C1085a(bVar));
                        String str2 = txnItem.getDateLabel() + " " + txnItem.getTimeLabel();
                        if (str2 != null) {
                            View view18 = bVar.itemView;
                            k.a((Object) view18, "itemView");
                            TextView textView4 = (TextView) view18.findViewById(R.id.passbook_send_receive_time);
                            k.a((Object) textView4, "itemView.passbook_send_receive_time");
                            View view19 = bVar.itemView;
                            k.a((Object) view19, "itemView");
                            view19.getContext();
                            String a2 = net.one97.paytm.passbook.mapping.a.a(str2, "yyyy-MM-dd HH:mm:ss", "dd MMM", "hh:mm a");
                            k.a((Object) a2, "CJRAppUtility.getDateWit…:mm a\", itemView.context)");
                            textView4.setText(p.a(p.a(a2, "am", "AM", false), "pm", "PM", false));
                        }
                        SecondPartyInfo secondPartyInfo2 = txnItem.getSecondPartyInfo();
                        if (!(secondPartyInfo2 == null || (logoUrl2 = secondPartyInfo2.getLogoUrl()) == null)) {
                            String txnIndicator3 = txnItem.getTxnIndicator();
                            if (TextUtils.isEmpty(txnIndicator3)) {
                                aa a3 = w.a().a(logoUrl2).a((ah) new net.one97.paytm.passbook.customview.b());
                                View view20 = bVar.itemView;
                                k.a((Object) view20, "itemView");
                                a3.a((ImageView) (CircularImageView) view20.findViewById(R.id.passbook_payer_or_payee_icons_iv));
                            } else if (p.a(txnIndicator3, "2", false)) {
                                View view21 = bVar.itemView;
                                k.a((Object) view21, "itemView");
                                Drawable b2 = androidx.appcompat.a.a.a.b(view21.getContext(), R.drawable.pass_ic_money_sent);
                                if (b2 != null) {
                                    View view22 = bVar.itemView;
                                    k.a((Object) view22, "itemView");
                                    Drawable b3 = androidx.appcompat.a.a.a.b(view22.getContext(), R.drawable.pass_ic_money_sent);
                                    if (b3 != null) {
                                        w.a().a(logoUrl2).a((ah) new net.one97.paytm.passbook.customview.b()).a(b2).b(b3).a(bVar.f57553a);
                                    }
                                }
                            } else if (p.a(txnIndicator3, "1", false)) {
                                View view23 = bVar.itemView;
                                k.a((Object) view23, "itemView");
                                Drawable b4 = androidx.appcompat.a.a.a.b(view23.getContext(), R.drawable.pass_ic_money_received);
                                if (b4 != null) {
                                    View view24 = bVar.itemView;
                                    k.a((Object) view24, "itemView");
                                    Drawable b5 = androidx.appcompat.a.a.a.b(view24.getContext(), R.drawable.pass_ic_money_received);
                                    if (b5 != null) {
                                        w.a().a(logoUrl2).a((ah) new net.one97.paytm.passbook.customview.b()).a(b5).b(b4).a(bVar.f57553a);
                                    }
                                }
                            } else {
                                aa a4 = w.a().a(logoUrl2).a((ah) new net.one97.paytm.passbook.customview.b());
                                View view25 = bVar.itemView;
                                k.a((Object) view25, "itemView");
                                a4.a((ImageView) (CircularImageView) view25.findViewById(R.id.passbook_payer_or_payee_icons_iv));
                            }
                        }
                        ArrayList<UserInstrumentLogos> userInstrumentLogos = txnItem.getUserInstrumentLogos();
                        if (!(userInstrumentLogos == null || userInstrumentLogos.size() <= 0 || (logoUrl = userInstrumentLogos.get(0).getLogoUrl()) == null)) {
                            View view26 = bVar.itemView;
                            k.a((Object) view26, "itemView");
                            ImageView imageView = (ImageView) view26.findViewById(R.id.passbook_debit_source_icon);
                            k.a((Object) imageView, "itemView.passbook_debit_source_icon");
                            imageView.setVisibility(0);
                            aa a5 = w.a().a(logoUrl);
                            View view27 = bVar.itemView;
                            k.a((Object) view27, "itemView");
                            a5.a((ImageView) view27.findViewById(R.id.passbook_debit_source_icon));
                        }
                        View view28 = bVar.itemView;
                        k.a((Object) view28, "itemView");
                        ImageView imageView2 = (ImageView) view28.findViewById(R.id.passbook_txn_status_iv);
                        k.a((Object) imageView2, "itemView.passbook_txn_status_iv");
                        imageView2.setVisibility(8);
                        String statusKey = txnItem.getStatusKey();
                        if (statusKey != null) {
                            if (!p.a(statusKey, "2", true)) {
                                String status = txnItem.getStatus();
                                View view29 = bVar.itemView;
                                k.a((Object) view29, "itemView");
                                TextView textView5 = (TextView) view29.findViewById(R.id.passbook_txn_status_text);
                                k.a((Object) textView5, "itemView.passbook_txn_status_text");
                                textView5.setVisibility(0);
                                View view30 = bVar.itemView;
                                k.a((Object) view30, "itemView");
                                TextView textView6 = (TextView) view30.findViewById(R.id.passbook_txn_status_text);
                                k.a((Object) textView6, "itemView.passbook_txn_status_text");
                                textView6.setText(status);
                                if (p.a(statusKey, "1", true)) {
                                    View view31 = bVar.itemView;
                                    k.a((Object) view31, "itemView");
                                    View view32 = bVar.itemView;
                                    k.a((Object) view32, "itemView");
                                    ((TextView) view31.findViewById(R.id.passbook_txn_status_text)).setTextColor(androidx.core.content.b.c(view32.getContext(), R.color.color_ff585d));
                                    View view33 = bVar.itemView;
                                    k.a((Object) view33, "itemView");
                                    ImageView imageView3 = (ImageView) view33.findViewById(R.id.passbook_txn_status_iv);
                                    k.a((Object) imageView3, "itemView.passbook_txn_status_iv");
                                    imageView3.setVisibility(0);
                                    View view34 = bVar.itemView;
                                    k.a((Object) view34, "itemView");
                                    ((ImageView) view34.findViewById(R.id.passbook_txn_status_iv)).setImageResource(R.drawable.pb_failed_status);
                                } else if (p.a(statusKey, "3", true)) {
                                    View view35 = bVar.itemView;
                                    k.a((Object) view35, "itemView");
                                    View view36 = bVar.itemView;
                                    k.a((Object) view36, "itemView");
                                    ((TextView) view35.findViewById(R.id.passbook_txn_status_text)).setTextColor(androidx.core.content.b.c(view36.getContext(), R.color.color_ffAD00));
                                    View view37 = bVar.itemView;
                                    k.a((Object) view37, "itemView");
                                    ImageView imageView4 = (ImageView) view37.findViewById(R.id.passbook_txn_status_iv);
                                    k.a((Object) imageView4, "itemView.passbook_txn_status_iv");
                                    imageView4.setVisibility(0);
                                    View view38 = bVar.itemView;
                                    k.a((Object) view38, "itemView");
                                    ((ImageView) view38.findViewById(R.id.passbook_txn_status_iv)).setImageResource(R.drawable.pb_status_pending);
                                }
                            } else {
                                View view39 = bVar.itemView;
                                k.a((Object) view39, "itemView");
                                TextView textView7 = (TextView) view39.findViewById(R.id.passbook_txn_status_text);
                                k.a((Object) textView7, "itemView.passbook_txn_status_text");
                                textView7.setVisibility(8);
                            }
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                int i5 = i3 + 1;
                if (this.f57543b.size() > i5) {
                    View view40 = vVar2.itemView;
                    k.a((Object) view40, "holder.itemView");
                    View findViewById = view40.findViewById(R.id.bottom_border);
                    k.a((Object) findViewById, "holder.itemView.bottom_border");
                    if (this.f57543b.get(i5).getTxnItem() == null) {
                        i4 = 8;
                    }
                    findViewById.setVisibility(i4);
                }
                View view41 = vVar2.itemView;
                k.a((Object) view41, "holder.itemView");
                ((ConstraintLayout) view41.findViewById(R.id.passbook_entry_row_detail_rl)).setOnClickListener(new g(this, vVar2, i3));
            } else if (vVar2 instanceof d) {
                if (!net.one97.paytm.passbook.d.b().a("passUTHFiltersEnabled", false)) {
                    ((d) vVar2).f57557a.setVisibility(8);
                } else {
                    ((d) vVar2).f57557a.setVisibility(0);
                }
                ((d) vVar2).f57557a.setOnClickListener(new h(this, vVar2));
            }
        }
        if (i3 == (this.f57543b.size() - 1) - this.f57550i) {
            this.l.a();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57573a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f57574b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f57575c;

        g(a aVar, RecyclerView.v vVar, int i2) {
            this.f57573a = aVar;
            this.f57574b = vVar;
            this.f57575c = i2;
        }

        public final void onClick(View view) {
            View view2 = this.f57574b.itemView;
            k.a((Object) view2, "holder.itemView");
            Context context = view2.getContext();
            k.a((Object) context, "holder.itemView.context");
            if (net.one97.paytm.passbook.utility.f.a(context)) {
                View view3 = this.f57574b.itemView;
                k.a((Object) view3, "holder.itemView");
                Intent intent = new Intent(view3.getContext(), TransactionHistoryActivity.class);
                PaymentHistoryTransactionItems txnItem = this.f57573a.f57543b.get(this.f57575c).getTxnItem();
                if (txnItem != null) {
                    intent.putExtra("txnId", txnItem.getTxnId());
                    intent.putExtra("stream_source", txnItem.getStreamSource());
                }
                View view4 = this.f57574b.itemView;
                k.a((Object) view4, "holder.itemView");
                view4.getContext().startActivity(intent);
                k.a((Object) view, "it");
                q.a(view.getContext(), "uth_passbook", "uth_detail_screen_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
                return;
            }
            View view5 = this.f57574b.itemView;
            k.a((Object) view5, "holder.itemView");
            Context context2 = view5.getContext();
            View view6 = this.f57574b.itemView;
            k.a((Object) view6, "holder.itemView");
            String string = view6.getContext().getString(R.string.no_connection);
            View view7 = this.f57574b.itemView;
            k.a((Object) view7, "holder.itemView");
            net.one97.paytm.passbook.mapping.c.a(context2, string, view7.getContext().getString(R.string.no_internet_body));
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57576a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f57577b;

        h(a aVar, RecyclerView.v vVar) {
            this.f57576a = aVar;
            this.f57577b = vVar;
        }

        public final void onClick(View view) {
            j supportFragmentManager;
            a aVar = this.f57576a;
            View view2 = this.f57577b.itemView;
            k.a((Object) view2, "holder.itemView");
            Context context = view2.getContext();
            k.a((Object) context, "holder.itemView.context");
            d dVar = (d) this.f57577b;
            String[] stringArray = context.getResources().getStringArray(R.array.pass_payment_hist_filter_items);
            k.a((Object) stringArray, "context.resources.getStr…ayment_hist_filter_items)");
            ArrayList arrayList = (ArrayList) kotlin.a.f.a((T[]) stringArray, new ArrayList());
            i iVar = new i(context.getString(R.string.pass_filter_payment_history), arrayList, aVar.f57545d);
            if (context != null) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                if (!(fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null)) {
                    iVar.show(supportFragmentManager, iVar.getTag());
                }
                iVar.a((i.a) new e(aVar, context, arrayList, dVar));
                dVar.f57561e.setOnClickListener(new f(aVar, context, arrayList, dVar));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    static final class e implements i.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57565a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f57566b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f57567c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f57568d;

        e(a aVar, Context context, ArrayList arrayList, d dVar) {
            this.f57565a = aVar;
            this.f57566b = context;
            this.f57567c = arrayList;
            this.f57568d = dVar;
        }

        public final void a(int i2) {
            q.a(this.f57566b, "uth_passbook", "uth_filter_clicked", (String) this.f57567c.get(i2), (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            if (a.a(this.f57566b)) {
                a aVar = this.f57565a;
                aVar.f57545d = i2;
                if (aVar.f57545d == 0) {
                    a.a(this.f57568d, false);
                } else {
                    a.a(this.f57568d, true);
                    this.f57568d.f57560d.setText((CharSequence) this.f57567c.get(i2));
                }
                this.f57565a.f57546e.d();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57569a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f57570b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f57571c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f57572d;

        f(a aVar, Context context, ArrayList arrayList, d dVar) {
            this.f57569a = aVar;
            this.f57570b = context;
            this.f57571c = arrayList;
            this.f57572d = dVar;
        }

        public final void onClick(View view) {
            if (a.a(this.f57570b)) {
                q.a(this.f57570b, "uth_passbook", "uth_selected_filter_removed", (String) this.f57571c.get(this.f57569a.f57545d), (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
                this.f57569a.f57545d = 0;
                a.a(this.f57572d, false);
                this.f57569a.f57546e.d();
            }
        }
    }

    /* renamed from: net.one97.paytm.passbook.landing.a.a$a  reason: collision with other inner class name */
    public static final class C1084a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f57551a;

        /* renamed from: b  reason: collision with root package name */
        private final View f57552b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1084a(View view) {
            super(view);
            k.c(view, "itemView");
            TextView textView = (TextView) view.findViewById(R.id.date);
            k.a((Object) textView, "itemView.date");
            this.f57551a = textView;
            View findViewById = view.findViewById(R.id.vTopDivider);
            k.a((Object) findViewById, "itemView.vTopDivider");
            this.f57552b = findViewById;
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final AppCompatImageView f57557a;

        /* renamed from: b  reason: collision with root package name */
        final ConstraintLayout f57558b;

        /* renamed from: c  reason: collision with root package name */
        final AppCompatTextView f57559c;

        /* renamed from: d  reason: collision with root package name */
        final AppCompatTextView f57560d;

        /* renamed from: e  reason: collision with root package name */
        final AppCompatImageView f57561e;

        /* renamed from: f  reason: collision with root package name */
        final View f57562f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ a f57563g;

        /* renamed from: h  reason: collision with root package name */
        private final AppCompatTextView f57564h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f57563g = aVar;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tvPaymentHistory);
            k.a((Object) appCompatTextView, "itemView.tvPaymentHistory");
            this.f57564h = appCompatTextView;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.ivPaymentHistoryFilter);
            k.a((Object) appCompatImageView, "itemView.ivPaymentHistoryFilter");
            this.f57557a = appCompatImageView;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.selectedFilterLayout);
            k.a((Object) constraintLayout, "itemView.selectedFilterLayout");
            this.f57558b = constraintLayout;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.tvPaymentHistDesc);
            k.a((Object) appCompatTextView2, "itemView.tvPaymentHistDesc");
            this.f57559c = appCompatTextView2;
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) view.findViewById(R.id.tvSelectedFilter);
            k.a((Object) appCompatTextView3, "itemView.tvSelectedFilter");
            this.f57560d = appCompatTextView3;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.ivRemoveFilter);
            k.a((Object) appCompatImageView2, "itemView.ivRemoveFilter");
            this.f57561e = appCompatImageView2;
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R.id.vFilterIndicator);
            k.a((Object) appCompatImageView3, "itemView.vFilterIndicator");
            this.f57562f = appCompatImageView3;
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        af f57553a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f57553a = new C1086b(this, view);
        }

        /* renamed from: net.one97.paytm.passbook.landing.a.a$b$b  reason: collision with other inner class name */
        public static final class C1086b implements af {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f57555a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f57556b;

            C1086b(b bVar, View view) {
                this.f57555a = bVar;
                this.f57556b = view;
            }

            public final void onPrepareLoad(Drawable drawable) {
                ((CircularImageView) this.f57556b.findViewById(R.id.passbook_payer_or_payee_icons_iv)).setImageBitmap(drawable != null ? b.a(drawable) : null);
            }

            public final void onBitmapFailed(Exception exc, Drawable drawable) {
                ((CircularImageView) this.f57556b.findViewById(R.id.passbook_payer_or_payee_icons_iv)).setImageBitmap(drawable != null ? b.a(drawable) : null);
            }

            public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                ((CircularImageView) this.f57556b.findViewById(R.id.passbook_payer_or_payee_icons_iv)).setImageBitmap(bitmap);
            }
        }

        public static Bitmap a(Drawable drawable) {
            k.c(drawable, "drawable");
            try {
                if (drawable instanceof BitmapDrawable) {
                    return ((BitmapDrawable) drawable).getBitmap();
                }
                Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: net.one97.paytm.passbook.landing.a.a$b$a  reason: collision with other inner class name */
        static final class C1085a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f57554a;

            C1085a(b bVar) {
                this.f57554a = bVar;
            }

            public final void onClick(View view) {
                View view2 = this.f57554a.itemView;
                k.a((Object) view2, "itemView");
                AppCompatTextView appCompatTextView = (AppCompatTextView) view2.findViewById(R.id.tvViewAmount);
                k.a((Object) appCompatTextView, "itemView.tvViewAmount");
                appCompatTextView.setVisibility(4);
                View view3 = this.f57554a.itemView;
                k.a((Object) view3, "itemView");
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) view3.findViewById(R.id.passbook_sender_receiver_amount_tv);
                k.a((Object) appCompatTextView2, "itemView.passbook_sender_receiver_amount_tv");
                appCompatTextView2.setVisibility(0);
            }
        }
    }

    public final boolean c(int i2) {
        try {
            return this.f57543b.get(i2).getTxnHeader() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final int b(int i2) {
        if (this.f57543b.get(i2).getTxnHeader() != null) {
            return R.layout.pass_grey_sticky_header_layout;
        }
        return R.layout.pass_payment_history_item_layout;
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

    public final void a(View view, int i2) {
        String str = null;
        if (i2 == 1 && !this.k) {
            q.a(view != null ? view.getContext() : null, "uth_passbook", "uth_payment_history_viewed", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            this.k = true;
        }
        TextView textView = view != null ? (TextView) view.findViewById(R.id.date) : null;
        PaymentHistoryTransactionHeader txnHeader = this.f57543b.get(i2).getTxnHeader();
        if (textView != null) {
            if (txnHeader != null) {
                str = txnHeader.getTxnDate();
            }
            textView.setText(str);
        }
    }

    public static final /* synthetic */ boolean a(Context context) {
        if (net.one97.paytm.passbook.utility.f.a(context)) {
            return true;
        }
        Toast.makeText(context, context.getString(R.string.no_internet_body), 0).show();
        return false;
    }

    public static final /* synthetic */ void a(d dVar, boolean z) {
        if (z) {
            dVar.f57559c.setVisibility(8);
            dVar.f57558b.setVisibility(0);
            dVar.f57562f.setVisibility(0);
            return;
        }
        dVar.f57558b.setVisibility(8);
        dVar.f57562f.setVisibility(8);
    }
}
