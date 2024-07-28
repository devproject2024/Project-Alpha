package net.one97.paytm.upi.mandate.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.t;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.b;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.utils.l;
import net.one97.paytm.upi.mandate.utils.v;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class m extends net.one97.paytm.upi.b<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final a f67551a;

    /* renamed from: e  reason: collision with root package name */
    final List<MandateItem> f67552e;

    /* renamed from: f  reason: collision with root package name */
    private final int f67553f;

    /* renamed from: g  reason: collision with root package name */
    private final int f67554g = 1;

    /* renamed from: h  reason: collision with root package name */
    private final int f67555h = 2;

    public interface a {
        void a(MandateItem mandateItem);

        void a(MandateItem mandateItem, v vVar);

        void b(MandateItem mandateItem);

        void c(MandateItem mandateItem);
    }

    public m(a aVar, List<MandateItem> list) {
        k.c(aVar, "listener");
        k.c(list, "dataList");
        this.f67551a = aVar;
        this.f67552e = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f67553f) {
            return new b.a(a(R.layout.loading_footer_item, viewGroup));
        }
        if (i2 == this.f67554g) {
            return new b(this, a(R.layout.mandate_list_item, viewGroup));
        }
        return new c(this, a(R.layout.mandate_list_item, viewGroup));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        RecyclerView.v vVar2 = vVar;
        int i3 = i2;
        k.c(vVar2, "holder");
        if (vVar2 instanceof b) {
            b bVar = (b) vVar2;
            MandateItem mandateItem = this.f67552e.get(i3);
            k.c(mandateItem, "scheduledMandateItem");
            net.one97.paytm.upi.f.a((View) bVar.j);
            bVar.k.a(bVar.f67561f, bVar.f67564i, bVar.f67557b, bVar.f67558c, bVar.f67560e, mandateItem, bVar.getAdapterPosition(), bVar.f67556a, bVar.f67563h, bVar.f67562g);
            TextView textView = bVar.f67559d;
            View view = bVar.itemView;
            k.a((Object) view, "itemView");
            textView.setText(view.getContext().getString(R.string.mandate_starting_up_to_end, new Object[]{UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMM yyyy", mandateItem.getValidityStartDate()), UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMM yyyy", mandateItem.getValidityEndDate())}));
        } else if (vVar2 instanceof c) {
            c cVar = (c) vVar2;
            MandateItem mandateItem2 = this.f67552e.get(i3);
            k.c(mandateItem2, "scheduledMandateItem");
            View view2 = cVar.j;
            CharSequence recurrence = mandateItem2.getRecurrence();
            net.one97.paytm.upi.f.a(view2, !(recurrence == null || p.a(recurrence)));
            TextView textView2 = cVar.f67568d;
            Context a2 = cVar.l.a();
            int i4 = R.string.upi_scheduled_mandate_validity_message;
            Object[] objArr = new Object[2];
            net.one97.paytm.upi.mandate.d.a aVar = net.one97.paytm.upi.mandate.d.a.f67112a;
            Context a3 = cVar.l.a();
            String recurrenceRule = mandateItem2.getRecurrenceRule();
            if (recurrenceRule == null) {
                k.a();
            }
            String recurrence2 = mandateItem2.getRecurrence();
            if (recurrence2 == null) {
                k.a();
            }
            String recurrenceType = mandateItem2.getRecurrenceType();
            if (recurrenceType == null) {
                k.a();
            }
            String validityStartDate = mandateItem2.getValidityStartDate();
            if (validityStartDate == null) {
                k.a();
            }
            objArr[0] = net.one97.paytm.upi.mandate.d.a.a(a3, recurrenceRule, recurrence2, recurrenceType, validityStartDate);
            boolean z = true;
            objArr[1] = UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMM yyyy", mandateItem2.getValidityEndDate());
            textView2.setText(a2.getString(i4, objArr));
            View view3 = cVar.k;
            if (!k.a((Object) mandateItem2.getState(), (Object) "PAUSED") && !k.a((Object) mandateItem2.getState(), (Object) TxNotifyData.UPI_STATUS_EXPIRED) && !k.a((Object) mandateItem2.getState(), (Object) TxNotifyData.UPI_STATUS_DECLINED) && !k.a((Object) mandateItem2.getState(), (Object) TxNotifyData.UPI_STATUS_CANCELLED)) {
                z = false;
            }
            net.one97.paytm.upi.f.a(view3, z);
            cVar.l.a(cVar.f67570f, cVar.f67573i, cVar.f67566b, cVar.f67567c, cVar.f67569e, mandateItem2, cVar.getAdapterPosition(), cVar.f67565a, cVar.f67572h, cVar.f67571g);
        }
    }

    public final void a(List<MandateItem> list) {
        k.c(list, "data");
        int size = this.f67552e.size();
        this.f67552e.addAll(list);
        if (size == 0) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeChanged(size, list.size());
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f67565a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f67566b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f67567c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f67568d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f67569e;

        /* renamed from: f  reason: collision with root package name */
        final ImageView f67570f;

        /* renamed from: g  reason: collision with root package name */
        final TextView f67571g;

        /* renamed from: h  reason: collision with root package name */
        final ImageView f67572h;

        /* renamed from: i  reason: collision with root package name */
        final ConstraintLayout f67573i;
        final Group j;
        final View k;
        final /* synthetic */ m l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(m mVar, View view) {
            super(view);
            k.c(view, "view");
            this.l = mVar;
            View findViewById = this.itemView.findViewById(R.id.tv_name_initial);
            k.a((Object) findViewById, "itemView.findViewById(R.id.tv_name_initial)");
            this.f67565a = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.tvPayeeName);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.tvPayeeName)");
            this.f67566b = (TextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.tvPayeeVpa);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.tvPayeeVpa)");
            this.f67567c = (TextView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.tvValidity);
            k.a((Object) findViewById4, "itemView.findViewById(R.id.tvValidity)");
            this.f67568d = (TextView) findViewById4;
            View findViewById5 = this.itemView.findViewById(R.id.tvAmount);
            k.a((Object) findViewById5, "itemView.findViewById(R.id.tvAmount)");
            this.f67569e = (TextView) findViewById5;
            View findViewById6 = this.itemView.findViewById(R.id.ivOptions);
            k.a((Object) findViewById6, "itemView.findViewById(R.id.ivOptions)");
            this.f67570f = (ImageView) findViewById6;
            View findViewById7 = this.itemView.findViewById(R.id.tvMandateStatus);
            k.a((Object) findViewById7, "itemView.findViewById(R.id.tvMandateStatus)");
            this.f67571g = (TextView) findViewById7;
            View findViewById8 = this.itemView.findViewById(R.id.ivStatusIcon);
            k.a((Object) findViewById8, "itemView.findViewById(R.id.ivStatusIcon)");
            this.f67572h = (ImageView) findViewById8;
            View findViewById9 = this.itemView.findViewById(R.id.root_layout);
            k.a((Object) findViewById9, "itemView.findViewById(R.id.root_layout)");
            this.f67573i = (ConstraintLayout) findViewById9;
            View findViewById10 = this.itemView.findViewById(R.id.recurringGroup);
            k.a((Object) findViewById10, "itemView.findViewById(R.id.recurringGroup)");
            this.j = (Group) findViewById10;
            View findViewById11 = this.itemView.findViewById(R.id.overlay);
            k.a((Object) findViewById11, "itemView.findViewById(R.id.overlay)");
            this.k = findViewById11;
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f67556a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f67557b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f67558c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f67559d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f67560e;

        /* renamed from: f  reason: collision with root package name */
        final ImageView f67561f;

        /* renamed from: g  reason: collision with root package name */
        final TextView f67562g;

        /* renamed from: h  reason: collision with root package name */
        final ImageView f67563h;

        /* renamed from: i  reason: collision with root package name */
        final ConstraintLayout f67564i;
        final Group j;
        final /* synthetic */ m k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(m mVar, View view) {
            super(view);
            k.c(view, "view");
            this.k = mVar;
            View findViewById = this.itemView.findViewById(R.id.tv_name_initial);
            k.a((Object) findViewById, "itemView.findViewById(R.id.tv_name_initial)");
            this.f67556a = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.tvPayeeName);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.tvPayeeName)");
            this.f67557b = (TextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.tvPayeeVpa);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.tvPayeeVpa)");
            this.f67558c = (TextView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.tvValidity);
            k.a((Object) findViewById4, "itemView.findViewById(R.id.tvValidity)");
            this.f67559d = (TextView) findViewById4;
            View findViewById5 = this.itemView.findViewById(R.id.tvAmount);
            k.a((Object) findViewById5, "itemView.findViewById(R.id.tvAmount)");
            this.f67560e = (TextView) findViewById5;
            View findViewById6 = this.itemView.findViewById(R.id.ivOptions);
            k.a((Object) findViewById6, "itemView.findViewById(R.id.ivOptions)");
            this.f67561f = (ImageView) findViewById6;
            View findViewById7 = this.itemView.findViewById(R.id.tvMandateStatus);
            k.a((Object) findViewById7, "itemView.findViewById(R.id.tvMandateStatus)");
            this.f67562g = (TextView) findViewById7;
            View findViewById8 = this.itemView.findViewById(R.id.ivStatusIcon);
            k.a((Object) findViewById8, "itemView.findViewById(R.id.ivStatusIcon)");
            this.f67563h = (ImageView) findViewById8;
            View findViewById9 = this.itemView.findViewById(R.id.root_layout);
            k.a((Object) findViewById9, "itemView.findViewById(R.id.root_layout)");
            this.f67564i = (ConstraintLayout) findViewById9;
            View findViewById10 = this.itemView.findViewById(R.id.recurringGroup);
            k.a((Object) findViewById10, "itemView.findViewById(R.id.recurringGroup)");
            this.j = (Group) findViewById10;
        }
    }

    static final class d implements t.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f67574a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MandateItem f67575b;

        d(m mVar, MandateItem mandateItem) {
            this.f67574a = mVar;
            this.f67575b = mandateItem;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            k.a((Object) menuItem, "item");
            int itemId = menuItem.getItemId();
            if (itemId == R.id.need_help) {
                this.f67574a.f67551a.b(this.f67575b);
                return true;
            } else if (itemId == R.id.edit_mandate) {
                this.f67574a.f67551a.a(this.f67575b, v.UPDATE);
                return true;
            } else if (itemId == R.id.cancel_mandate) {
                this.f67574a.f67551a.a(this.f67575b, v.CANCEL);
                return true;
            } else if (itemId == R.id.pause_payment) {
                this.f67574a.f67551a.a(this.f67575b, v.PAUSE);
                return true;
            } else if (itemId == R.id.resume_payment) {
                this.f67574a.f67551a.a(this.f67575b, v.RESUME);
                return true;
            } else if (itemId != R.id.view_invoice) {
                return true;
            } else {
                this.f67574a.f67551a.a(this.f67575b);
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, MandateItem mandateItem, int i2, TextView textView4, ImageView imageView2, TextView textView5) {
        String userName = mandateItem.getPayee().getUserName();
        String str = net.one97.paytm.upi.mandate.utils.f.b().get(i2 % 10);
        k.a((Object) str, "mColorsArray[index]");
        textView4.setBackgroundColor(Color.parseColor(str));
        textView4.setText(UpiUtils.getNameInitials(userName));
        String state = mandateItem.getState();
        String stateMessage = mandateItem.getStateMessage();
        if (!TextUtils.isEmpty(state)) {
            CharSequence charSequence = stateMessage;
            if (!TextUtils.isEmpty(charSequence)) {
                textView5.setText(charSequence);
                net.one97.paytm.upi.f.b((View) textView5);
            } else {
                net.one97.paytm.upi.f.a((View) textView5);
            }
            if (k.a((Object) state, (Object) l.PENDING_CANCELLATION.getStatus()) || k.a((Object) state, (Object) l.PENDING_DECLINE.getStatus())) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(R.drawable.ic_upi_status_pending);
                textView5.setTextColor(androidx.core.content.b.c(a(), R.color.pending_color));
            } else if (k.a((Object) state, (Object) l.PENDING_UPDATE.getStatus()) || k.a((Object) state, (Object) l.PENDING_CREATE.getStatus())) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(R.drawable.ic_upi_status_pending);
                textView5.setTextColor(androidx.core.content.b.c(a(), R.color.pending_color));
            } else if (k.a((Object) state, (Object) l.FAILED_UPDATE_ACTIVE.getStatus()) || k.a((Object) state, (Object) l.FAILED_REVOKE_ACTIVE.getStatus())) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(R.drawable.ic_status_failed);
                textView5.setTextColor(androidx.core.content.b.c(a(), R.color.failure_color));
            } else if (k.a((Object) state, (Object) l.EXPIRED.getStatus())) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(R.drawable.ic_upi_status_expired);
                textView5.setTextColor(androidx.core.content.b.c(a(), R.color.default_status_color));
            } else {
                imageView2.setVisibility(8);
                textView5.setTextColor(androidx.core.content.b.c(a(), R.color.default_status_color));
            }
        }
        net.one97.paytm.upi.f.b((View) imageView);
        String priceToString = UpiAppUtils.priceToString(mandateItem.getAmount());
        k.a((Object) priceToString, "UpiAppUtils.priceToStrin…eduledMandateItem.amount)");
        String b2 = net.one97.paytm.upi.f.b(priceToString);
        if (k.a((Object) mandateItem.getAmountRule(), (Object) "EXACT")) {
            textView3.setText(b2);
            textView3.setTypeface(Typeface.SANS_SERIF, 1);
        } else {
            textView3.setText((textView3.getContext().getString(R.string.upi_mandate_upto) + " ") + b2);
            textView3.setTypeface(Typeface.SANS_SERIF, 0);
        }
        imageView.setOnClickListener(new e(this, i2));
        constraintLayout.setOnClickListener(new f(this, i2, mandateItem));
        String userName2 = mandateItem.getPayee().getUserName();
        textView.setText(userName2 != null ? net.one97.paytm.upi.f.a(userName2) : null);
        textView2.setText(mandateItem.getPayee().getVpa());
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f67576a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f67577b;

        e(m mVar, int i2) {
            this.f67576a = mVar;
            this.f67577b = i2;
        }

        public final void onClick(View view) {
            boolean z;
            View view2 = view;
            int i2 = this.f67577b;
            if (i2 != -1) {
                m mVar = this.f67576a;
                k.a((Object) view2, "it");
                Context context = view.getContext();
                k.a((Object) context, "it.context");
                t tVar = new t(context, view2);
                tVar.b().inflate(R.menu.scheduled_mandate_menu, tVar.a());
                MenuItem findItem = tVar.a().findItem(R.id.cancel_mandate);
                MenuItem findItem2 = tVar.a().findItem(R.id.edit_mandate);
                MenuItem findItem3 = tVar.a().findItem(R.id.pause_payment);
                MenuItem findItem4 = tVar.a().findItem(R.id.resume_payment);
                MenuItem findItem5 = tVar.a().findItem(R.id.view_invoice);
                MandateItem mandateItem = mVar.f67552e.get(i2);
                MenuItem menuItem = findItem5;
                MenuItem menuItem2 = findItem4;
                t tVar2 = tVar;
                MenuItem menuItem3 = findItem3;
                m mVar2 = mVar;
                MenuItem menuItem4 = findItem2;
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Overflow_Actions", mandateItem.getState(), mandateItem.getModifyAllowed(), mandateItem.getRevokeAllowed(), mandateItem.getPayee().getVpa(), mandateItem.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENTS, "UPI");
                k.a((Object) findItem, "revokeMandate");
                findItem.setVisible(k.a((Object) "Y", (Object) mandateItem.getRevokeAllowed()));
                k.a((Object) menuItem4, "modifyMandate");
                menuItem4.setVisible(k.a((Object) "Y", (Object) mandateItem.getModifyAllowed()));
                k.a((Object) menuItem, "invoiceMenuItem");
                CharSequence refUrl = mandateItem.getRefUrl();
                boolean z2 = false;
                menuItem.setVisible(!(refUrl == null || p.a(refUrl)));
                k.a((Object) menuItem3, "pauseMandate");
                if (k.a((Object) mandateItem.getState(), (Object) "ACTIVE") && k.a((Object) mandateItem.getType(), (Object) "RECURRING")) {
                    String validityEndDate = mandateItem.getValidityEndDate();
                    if (validityEndDate == null) {
                        k.a();
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
                    Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(simpleDateFormat.parse(validityEndDate));
                    instance.add(5, -1);
                    k.a((Object) instance, "calendar");
                    if (parse.before(instance.getTime())) {
                        z = true;
                        menuItem3.setVisible(z);
                        k.a((Object) menuItem2, "resumePayment");
                        if (k.a((Object) mandateItem.getState(), (Object) "PAUSED") && k.a((Object) mandateItem.getType(), (Object) "RECURRING")) {
                            z2 = true;
                        }
                        menuItem2.setVisible(z2);
                        t tVar3 = tVar2;
                        tVar3.a((t.b) new d(mVar2, mandateItem));
                        tVar3.c();
                    }
                }
                z = false;
                menuItem3.setVisible(z);
                k.a((Object) menuItem2, "resumePayment");
                z2 = true;
                menuItem2.setVisible(z2);
                t tVar32 = tVar2;
                tVar32.a((t.b) new d(mVar2, mandateItem));
                tVar32.c();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f67578a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f67579b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MandateItem f67580c;

        f(m mVar, int i2, MandateItem mandateItem) {
            this.f67578a = mVar;
            this.f67579b = i2;
            this.f67580c = mandateItem;
        }

        public final void onClick(View view) {
            if (this.f67579b != -1) {
                this.f67578a.f67551a.c(this.f67580c);
            }
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f66589d && i2 == this.f67552e.size()) {
            return this.f67553f;
        }
        if (k.a((Object) this.f67552e.get(i2).getType(), (Object) "RECURRING")) {
            return this.f67555h;
        }
        return this.f67554g;
    }

    public final int getItemCount() {
        if (this.f66589d) {
            return this.f67552e.size() + 1;
        }
        return this.f67552e.size();
    }
}
