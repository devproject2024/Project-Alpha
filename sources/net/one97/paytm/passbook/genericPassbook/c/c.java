package net.one97.paytm.passbook.genericPassbook.c;

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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.aa;
import com.squareup.picasso.af;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.SAHistoryTransaction;
import net.one97.paytm.passbook.beans.SAHistoryTransactionHeader;
import net.one97.paytm.passbook.beans.SAHistoryTransactionItems;
import net.one97.paytm.passbook.beans.SASecondPartyInfo;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.search.b.a;
import net.one97.paytm.passbook.transactionHistory.activity.SATransactionDetailsActivity;
import net.one97.paytm.passbook.utility.f;

public final class c extends RecyclerView.a<RecyclerView.v> implements a.C1128a {

    /* renamed from: a  reason: collision with root package name */
    String f57360a;

    /* renamed from: b  reason: collision with root package name */
    private final int f57361b;

    /* renamed from: c  reason: collision with root package name */
    private final int f57362c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final int f57363d = 2;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f57364e;

    /* renamed from: f  reason: collision with root package name */
    private String f57365f = "";

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<SAHistoryTransaction> f57366g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.passbook.genericPassbook.b.c f57367h;

    public c(ArrayList<SAHistoryTransaction> arrayList, net.one97.paytm.passbook.genericPassbook.b.c cVar) {
        k.c(arrayList, "transactionList");
        this.f57366g = arrayList;
        this.f57367h = cVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.f57364e = from;
        if (i2 == this.f57361b) {
            LayoutInflater layoutInflater = this.f57364e;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            View inflate = layoutInflater.inflate(R.layout.pass_payment_history_header, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…ry_header, parent, false)");
            return new a(inflate);
        }
        LayoutInflater layoutInflater2 = this.f57364e;
        if (layoutInflater2 == null) {
            k.a("mInflater");
        }
        View inflate2 = layoutInflater2.inflate(R.layout.pass_payment_history_item_layout, viewGroup, false);
        k.a((Object) inflate2, "mInflater.inflate(R.layo…em_layout, parent, false)");
        return new b(inflate2);
    }

    public final int getItemCount() {
        return this.f57366g.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f57366g.get(i2).getTxnHeader() != null) {
            return this.f57361b;
        }
        return this.f57362c;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        net.one97.paytm.passbook.genericPassbook.b.c cVar;
        String str;
        String logoUrl;
        String txnIndicator;
        RecyclerView.v vVar2 = vVar;
        int i3 = i2;
        k.c(vVar2, "holder");
        x.e eVar = new x.e();
        T t = this.f57366g.get(i3);
        k.a((Object) t, "transactionList[position]");
        eVar.element = (SAHistoryTransaction) t;
        if (vVar2 instanceof a) {
            TextView textView = ((a) vVar2).f57368a;
            SAHistoryTransactionHeader txnHeader = ((SAHistoryTransaction) eVar.element).getTxnHeader();
            textView.setText(txnHeader != null ? txnHeader.getTxnDate() : null);
        } else if (vVar2 instanceof b) {
            SAHistoryTransactionItems txnItem = ((SAHistoryTransaction) eVar.element).getTxnItem();
            if (txnItem != null) {
                b bVar = (b) vVar2;
                k.c(txnItem, "transaction");
                View view = bVar.itemView;
                k.a((Object) view, "itemView");
                TextView textView2 = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
                k.a((Object) textView2, "itemView.passbook_send_receive_type_tv");
                String narration = txnItem.getNarration();
                SASecondPartyInfo secondPartyInfo = txnItem.getSecondPartyInfo();
                String name = secondPartyInfo != null ? secondPartyInfo.getName() : null;
                String txnIndicator2 = txnItem.getTxnIndicator();
                View view2 = bVar.itemView;
                k.a((Object) view2, "itemView");
                TextView textView3 = (TextView) view2.findViewById(R.id.passbook_send_receive_type_tv);
                k.a((Object) textView3, "itemView.passbook_send_receive_type_tv");
                Context context = textView3.getContext();
                k.a((Object) context, "itemView.passbook_send_receive_type_tv.context");
                String str2 = "";
                if (narration != null) {
                    str = str2 + narration + ' ';
                } else {
                    str = str2;
                }
                if (name != null) {
                    str = str + name + ' ';
                }
                if (txnIndicator2 != null) {
                    if (str == null) {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    } else if (TextUtils.isEmpty(p.b(str).toString())) {
                        if (txnIndicator2.equals("2")) {
                            str = context.getString(R.string.pass_narration_money_debited);
                            k.a((Object) str, "context.getString(R.stri…_narration_money_debited)");
                        } else if (txnIndicator2.equals("1")) {
                            str = context.getString(R.string.pass_narration_money_credited);
                            k.a((Object) str, "context.getString(R.stri…narration_money_credited)");
                        }
                    }
                }
                textView2.setText(str);
                String amount = txnItem.getAmount();
                String c2 = amount != null ? f.c(Double.parseDouble(amount)) : null;
                if (!(txnItem == null || (txnIndicator = txnItem.getTxnIndicator()) == null)) {
                    str2 = txnIndicator;
                }
                if (TextUtils.isEmpty(txnItem.getStatus()) || !p.a(txnItem.getStatus(), "success", true)) {
                    View view3 = bVar.itemView;
                    k.a((Object) view3, "itemView");
                    AppCompatTextView appCompatTextView = (AppCompatTextView) view3.findViewById(R.id.passbook_sender_receiver_amount_tv);
                    k.a((Object) appCompatTextView, "itemView.passbook_sender_receiver_amount_tv");
                    View view4 = bVar.itemView;
                    k.a((Object) view4, "itemView");
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) view4.findViewById(R.id.passbook_sender_receiver_amount_tv);
                    k.a((Object) appCompatTextView2, "itemView.passbook_sender_receiver_amount_tv");
                    String string = appCompatTextView2.getContext().getString(R.string.pass_rupee, new Object[]{c2});
                    k.a((Object) string, "itemView.passbook_sender…s_rupee, strTotalBalance)");
                    f.a(appCompatTextView, string);
                    View view5 = bVar.itemView;
                    k.a((Object) view5, "itemView");
                    View view6 = bVar.itemView;
                    k.a((Object) view6, "itemView");
                    ((AppCompatTextView) view5.findViewById(R.id.passbook_sender_receiver_amount_tv)).setTextColor(androidx.core.content.b.c(view6.getContext(), R.color.color_8bac61));
                } else {
                    CharSequence charSequence = "2";
                    if (str2 == null) {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    } else if (str2.contentEquals(charSequence)) {
                        View view7 = bVar.itemView;
                        k.a((Object) view7, "itemView");
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) view7.findViewById(R.id.passbook_sender_receiver_amount_tv);
                        k.a((Object) appCompatTextView3, "itemView.passbook_sender_receiver_amount_tv");
                        View view8 = bVar.itemView;
                        k.a((Object) view8, "itemView");
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) view8.findViewById(R.id.passbook_sender_receiver_amount_tv);
                        k.a((Object) appCompatTextView4, "itemView.passbook_sender_receiver_amount_tv");
                        String string2 = appCompatTextView4.getContext().getString(R.string.pass_rupee_debit, new Object[]{c2});
                        k.a((Object) string2, "itemView.passbook_sender…e_debit, strTotalBalance)");
                        f.a(appCompatTextView3, string2);
                        View view9 = bVar.itemView;
                        k.a((Object) view9, "itemView");
                        View view10 = bVar.itemView;
                        k.a((Object) view10, "itemView");
                        ((AppCompatTextView) view9.findViewById(R.id.passbook_sender_receiver_amount_tv)).setTextColor(androidx.core.content.b.c(view10.getContext(), R.color.color_1d252d));
                    } else {
                        CharSequence charSequence2 = "1";
                        if (str2 == null) {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        } else if (str2.contentEquals(charSequence2)) {
                            View view11 = bVar.itemView;
                            k.a((Object) view11, "itemView");
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) view11.findViewById(R.id.passbook_sender_receiver_amount_tv);
                            k.a((Object) appCompatTextView5, "itemView.passbook_sender_receiver_amount_tv");
                            View view12 = bVar.itemView;
                            k.a((Object) view12, "itemView");
                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) view12.findViewById(R.id.passbook_sender_receiver_amount_tv);
                            k.a((Object) appCompatTextView6, "itemView.passbook_sender_receiver_amount_tv");
                            String string3 = appCompatTextView6.getContext().getString(R.string.pass_rupee_credit, new Object[]{c2});
                            k.a((Object) string3, "itemView.passbook_sender…_credit, strTotalBalance)");
                            f.a(appCompatTextView5, string3);
                            View view13 = bVar.itemView;
                            k.a((Object) view13, "itemView");
                            View view14 = bVar.itemView;
                            k.a((Object) view14, "itemView");
                            ((AppCompatTextView) view13.findViewById(R.id.passbook_sender_receiver_amount_tv)).setTextColor(androidx.core.content.b.c(view14.getContext(), R.color.color_21c17a));
                        } else {
                            View view15 = bVar.itemView;
                            k.a((Object) view15, "itemView");
                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) view15.findViewById(R.id.passbook_sender_receiver_amount_tv);
                            k.a((Object) appCompatTextView7, "itemView.passbook_sender_receiver_amount_tv");
                            View view16 = bVar.itemView;
                            k.a((Object) view16, "itemView");
                            AppCompatTextView appCompatTextView8 = (AppCompatTextView) view16.findViewById(R.id.passbook_sender_receiver_amount_tv);
                            k.a((Object) appCompatTextView8, "itemView.passbook_sender_receiver_amount_tv");
                            String string4 = appCompatTextView8.getContext().getString(R.string.pass_rupee, new Object[]{c2});
                            k.a((Object) string4, "itemView.passbook_sender…s_rupee, strTotalBalance)");
                            f.a(appCompatTextView7, string4);
                            View view17 = bVar.itemView;
                            k.a((Object) view17, "itemView");
                            View view18 = bVar.itemView;
                            k.a((Object) view18, "itemView");
                            ((AppCompatTextView) view17.findViewById(R.id.passbook_sender_receiver_amount_tv)).setTextColor(androidx.core.content.b.c(view18.getContext(), R.color.color_8bac61));
                        }
                    }
                }
                String str3 = txnItem.getDateLabel() + " " + txnItem.getTimeLabel();
                if (str3 != null) {
                    View view19 = bVar.itemView;
                    k.a((Object) view19, "itemView");
                    TextView textView4 = (TextView) view19.findViewById(R.id.passbook_send_receive_time);
                    k.a((Object) textView4, "itemView.passbook_send_receive_time");
                    View view20 = bVar.itemView;
                    k.a((Object) view20, "itemView");
                    view20.getContext();
                    textView4.setText(net.one97.paytm.passbook.mapping.a.a(str3, "yyyy-MM-dd HH:mm:ss", "dd MMM", "hh:mm a").toString());
                }
                SASecondPartyInfo secondPartyInfo2 = txnItem.getSecondPartyInfo();
                if (!(secondPartyInfo2 == null || (logoUrl = secondPartyInfo2.getLogoUrl()) == null)) {
                    String txnIndicator3 = txnItem.getTxnIndicator();
                    if (TextUtils.isEmpty(txnIndicator3)) {
                        aa a2 = w.a().a(logoUrl).a((ah) new net.one97.paytm.passbook.customview.b());
                        View view21 = bVar.itemView;
                        k.a((Object) view21, "itemView");
                        a2.a((ImageView) (CircularImageView) view21.findViewById(R.id.passbook_payer_or_payee_icons_iv));
                    } else if (p.a(txnIndicator3, "2", false)) {
                        View view22 = bVar.itemView;
                        k.a((Object) view22, "itemView");
                        Drawable b2 = androidx.appcompat.a.a.a.b(view22.getContext(), R.drawable.pass_ic_money_sent);
                        if (b2 != null) {
                            View view23 = bVar.itemView;
                            k.a((Object) view23, "itemView");
                            Drawable b3 = androidx.appcompat.a.a.a.b(view23.getContext(), R.drawable.pass_ic_money_sent);
                            if (b3 != null) {
                                w.a().a(logoUrl).a((ah) new net.one97.paytm.passbook.customview.b()).a(b2).b(b3).a(bVar.f57369a);
                            }
                        }
                    } else if (p.a(txnIndicator3, "1", false)) {
                        View view24 = bVar.itemView;
                        k.a((Object) view24, "itemView");
                        Drawable b4 = androidx.appcompat.a.a.a.b(view24.getContext(), R.drawable.pass_ic_money_received);
                        if (b4 != null) {
                            View view25 = bVar.itemView;
                            k.a((Object) view25, "itemView");
                            Drawable b5 = androidx.appcompat.a.a.a.b(view25.getContext(), R.drawable.pass_ic_money_received);
                            if (b5 != null) {
                                w.a().a(logoUrl).a((ah) new net.one97.paytm.passbook.customview.b()).a(b4).b(b5).a(bVar.f57369a);
                            }
                        }
                    } else {
                        aa a3 = w.a().a(logoUrl).a((ah) new net.one97.paytm.passbook.customview.b());
                        View view26 = bVar.itemView;
                        k.a((Object) view26, "itemView");
                        a3.a((ImageView) (CircularImageView) view26.findViewById(R.id.passbook_payer_or_payee_icons_iv));
                    }
                }
                View view27 = bVar.itemView;
                k.a((Object) view27, "itemView");
                ImageView imageView = (ImageView) view27.findViewById(R.id.passbook_debit_source_icon);
                k.a((Object) imageView, "itemView.passbook_debit_source_icon");
                imageView.setVisibility(8);
                String status = txnItem.getStatus();
                if (status != null) {
                    if (!p.a(status, "success", true)) {
                        String status2 = txnItem.getStatus();
                        View view28 = bVar.itemView;
                        k.a((Object) view28, "itemView");
                        TextView textView5 = (TextView) view28.findViewById(R.id.passbook_txn_status_text);
                        k.a((Object) textView5, "itemView.passbook_txn_status_text");
                        textView5.setVisibility(0);
                        View view29 = bVar.itemView;
                        k.a((Object) view29, "itemView");
                        TextView textView6 = (TextView) view29.findViewById(R.id.passbook_txn_status_text);
                        k.a((Object) textView6, "itemView.passbook_txn_status_text");
                        textView6.setText(status2);
                        if (p.a(status, SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING, true)) {
                            View view30 = bVar.itemView;
                            k.a((Object) view30, "itemView");
                            View view31 = bVar.itemView;
                            k.a((Object) view31, "itemView");
                            ((TextView) view30.findViewById(R.id.passbook_txn_status_text)).setTextColor(androidx.core.content.b.c(view31.getContext(), R.color.color_ff585d));
                        } else if (p.a(status, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true)) {
                            View view32 = bVar.itemView;
                            k.a((Object) view32, "itemView");
                            View view33 = bVar.itemView;
                            k.a((Object) view33, "itemView");
                            ((TextView) view32.findViewById(R.id.passbook_txn_status_text)).setTextColor(androidx.core.content.b.c(view33.getContext(), R.color.color_ffAD00));
                        }
                    } else {
                        View view34 = bVar.itemView;
                        k.a((Object) view34, "itemView");
                        TextView textView7 = (TextView) view34.findViewById(R.id.passbook_txn_status_text);
                        k.a((Object) textView7, "itemView.passbook_txn_status_text");
                        textView7.setVisibility(8);
                    }
                }
            }
            View view35 = vVar2.itemView;
            k.a((Object) view35, "holder.itemView");
            ((ConstraintLayout) view35.findViewById(R.id.passbook_entry_row_detail_rl)).setOnClickListener(new C1073c(this, vVar2, eVar));
        }
        if (i3 == (this.f57366g.size() - 1) - this.f57363d && (cVar = this.f57367h) != null) {
            cVar.c();
        }
    }

    /* renamed from: net.one97.paytm.passbook.genericPassbook.c.c$c  reason: collision with other inner class name */
    static final class C1073c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57372a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f57373b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f57374c;

        C1073c(c cVar, RecyclerView.v vVar, x.e eVar) {
            this.f57372a = cVar;
            this.f57373b = vVar;
            this.f57374c = eVar;
        }

        public final void onClick(View view) {
            View view2 = this.f57373b.itemView;
            k.a((Object) view2, "holder.itemView");
            Context context = view2.getContext();
            k.a((Object) context, "holder.itemView.context");
            if (f.a(context)) {
                View view3 = this.f57373b.itemView;
                k.a((Object) view3, "holder.itemView");
                Intent intent = new Intent(view3.getContext(), SATransactionDetailsActivity.class);
                SAHistoryTransactionItems txnItem = ((SAHistoryTransaction) this.f57374c.element).getTxnItem();
                if (txnItem != null) {
                    intent.putExtra("ACCOUNT_NUMBER", this.f57372a.f57360a);
                    intent.putExtra("txnId", txnItem.getTxnId());
                    intent.putExtra("tranDateEpochMilli", txnItem.getTranDateEpochMilli());
                    intent.putExtra("dateTimeEpochMilli", txnItem.getDateTimeEpochMilli());
                }
                View view4 = this.f57373b.itemView;
                k.a((Object) view4, "holder.itemView");
                view4.getContext().startActivity(intent);
                return;
            }
            View view5 = this.f57373b.itemView;
            k.a((Object) view5, "holder.itemView");
            Context context2 = view5.getContext();
            View view6 = this.f57373b.itemView;
            k.a((Object) view6, "holder.itemView");
            String string = view6.getContext().getString(R.string.no_connection);
            View view7 = this.f57373b.itemView;
            k.a((Object) view7, "holder.itemView");
            net.one97.paytm.passbook.mapping.c.a(context2, string, view7.getContext().getString(R.string.no_internet_body));
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f57368a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            TextView textView = (TextView) view.findViewById(R.id.date);
            k.a((Object) textView, "itemView.date");
            this.f57368a = textView;
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        af f57369a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f57369a = new a(this, view);
        }

        public static final class a implements af {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f57370a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f57371b;

            a(b bVar, View view) {
                this.f57370a = bVar;
                this.f57371b = view;
            }

            public final void onPrepareLoad(Drawable drawable) {
                ((CircularImageView) this.f57371b.findViewById(R.id.passbook_payer_or_payee_icons_iv)).setImageBitmap(drawable != null ? b.a(drawable) : null);
            }

            public final void onBitmapFailed(Exception exc, Drawable drawable) {
                ((CircularImageView) this.f57371b.findViewById(R.id.passbook_payer_or_payee_icons_iv)).setImageBitmap(drawable != null ? b.a(drawable) : null);
            }

            public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                ((CircularImageView) this.f57371b.findViewById(R.id.passbook_payer_or_payee_icons_iv)).setImageBitmap(bitmap);
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
    }

    public final boolean c(int i2) {
        return this.f57366g.get(i2).getTxnHeader() != null;
    }

    public final int b(int i2) {
        if (this.f57366g.get(i2).getTxnHeader() != null) {
            return R.layout.pass_payment_history_header;
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
        TextView textView = view != null ? (TextView) view.findViewById(R.id.date) : null;
        SAHistoryTransactionHeader txnHeader = this.f57366g.get(i2).getTxnHeader();
        if (textView != null) {
            if (txnHeader != null) {
                str = txnHeader.getTxnDate();
            }
            textView.setText(str);
        }
    }
}
