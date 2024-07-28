package net.one97.paytm.upi.mandate.view;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import kotlin.g.b.aa;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.utils.l;
import net.one97.paytm.upi.mandate.view.b;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class k extends b<Object> {

    /* renamed from: d  reason: collision with root package name */
    private final a f67540d;

    public interface a {
        void a();
    }

    public k(a aVar) {
        kotlin.g.b.k.c(aVar, "listener");
        this.f67540d = aVar;
    }

    public final RecyclerView.v a(ViewGroup viewGroup) {
        kotlin.g.b.k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mandate_list_item, viewGroup, false);
        kotlin.g.b.k.a((Object) inflate, "view");
        return new b(inflate);
    }

    public final void a(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            b bVar = (b) vVar;
            D d2 = this.f67510b.get(i2);
            if (d2 != null) {
                MandateItem mandateItem = (MandateItem) d2;
                kotlin.g.b.k.c(mandateItem, "receivedMandateItem");
                TextView textView = bVar.f67542b;
                String userName = mandateItem.getPayer().getUserName();
                textView.setText(userName != null ? f.a(userName) : null);
                bVar.f67543c.setText(mandateItem.getPayer().getVpa());
                aa aaVar = aa.f47921a;
                View view = bVar.itemView;
                kotlin.g.b.k.a((Object) view, "itemView");
                String string = view.getContext().getString(R.string.rs_str);
                kotlin.g.b.k.a((Object) string, "itemView.context.getString(R.string.rs_str)");
                String format = String.format(string, Arrays.copyOf(new Object[]{UpiAppUtils.priceToString(mandateItem.getAmount())}, 1));
                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                UpiAppUtils.updateAmount(format, bVar.f67545e);
                TextView textView2 = bVar.f67544d;
                View view2 = bVar.itemView;
                kotlin.g.b.k.a((Object) view2, "itemView");
                textView2.setText(view2.getContext().getString(R.string.upi_mandate_validity, new Object[]{UpiUtils.getMandateFormattedDate(mandateItem.getValidityStartDate()), UpiUtils.getMandateFormattedDate(mandateItem.getValidityEndDate())}));
                f.a((View) bVar.f67546f);
                f.a((View) bVar.f67549i);
                String userName2 = mandateItem.getPayer().getUserName();
                String str = net.one97.paytm.upi.mandate.utils.f.b().get(bVar.getAdapterPosition() % 10);
                kotlin.g.b.k.a((Object) str, "mColorsArray[index]");
                bVar.f67541a.setBackgroundColor(Color.parseColor(str));
                bVar.f67541a.setText(UpiUtils.getNameInitials(userName2));
                String state = mandateItem.getState();
                String stateMessage = mandateItem.getStateMessage();
                if (!TextUtils.isEmpty(state)) {
                    CharSequence charSequence = stateMessage;
                    if (!TextUtils.isEmpty(charSequence)) {
                        bVar.f67547g.setText(charSequence);
                        f.b((View) bVar.f67547g);
                    } else {
                        f.a((View) bVar.f67547g);
                    }
                    if (kotlin.g.b.k.a((Object) state, (Object) l.FAILED_EXECUTION_EXPIRED.getStatus())) {
                        f.b((View) bVar.f67548h);
                        bVar.f67548h.setImageResource(R.drawable.ic_status_failed);
                        TextView textView3 = bVar.f67547g;
                        View view3 = bVar.itemView;
                        kotlin.g.b.k.a((Object) view3, "itemView");
                        textView3.setTextColor(androidx.core.content.b.c(view3.getContext(), R.color.failure_color));
                    } else {
                        if (!kotlin.g.b.k.a((Object) state, (Object) l.COMPLETED.getStatus())) {
                            if (kotlin.g.b.k.a((Object) state, (Object) l.EXPIRED.getStatus())) {
                                f.b((View) bVar.f67548h);
                                bVar.f67548h.setImageResource(R.drawable.ic_upi_status_expired);
                                TextView textView4 = bVar.f67547g;
                                View view4 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view4, "itemView");
                                textView4.setTextColor(androidx.core.content.b.c(view4.getContext(), R.color.default_status_color));
                            } else if (kotlin.g.b.k.a((Object) state, (Object) l.CANCELLED.getStatus()) || kotlin.g.b.k.a((Object) state, (Object) l.DECLINED.getStatus())) {
                                f.b((View) bVar.f67548h);
                                bVar.f67548h.setImageResource(R.drawable.ic_upi_status_pending);
                                TextView textView5 = bVar.f67547g;
                                View view5 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view5, "itemView");
                                textView5.setTextColor(androidx.core.content.b.c(view5.getContext(), R.color.pending_color));
                            } else if (kotlin.g.b.k.a((Object) state, (Object) l.PENDING_CANCELLATION.getStatus()) || kotlin.g.b.k.a((Object) state, (Object) l.PENDING_DECLINE.getStatus())) {
                                f.b((View) bVar.f67548h);
                                bVar.f67548h.setImageResource(R.drawable.ic_upi_status_pending);
                                TextView textView6 = bVar.f67547g;
                                View view6 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view6, "itemView");
                                textView6.setTextColor(androidx.core.content.b.c(view6.getContext(), R.color.pending_color));
                            } else if (kotlin.g.b.k.a((Object) state, (Object) l.PENDING_EXECUTE.getStatus()) || kotlin.g.b.k.a((Object) state, (Object) l.PENDING_UPDATE.getStatus()) || kotlin.g.b.k.a((Object) state, (Object) l.PENDING_CREATE.getStatus())) {
                                f.b((View) bVar.f67548h);
                                bVar.f67548h.setImageResource(R.drawable.ic_upi_status_pending);
                                TextView textView7 = bVar.f67547g;
                                View view7 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view7, "itemView");
                                textView7.setTextColor(androidx.core.content.b.c(view7.getContext(), R.color.pending_color));
                            } else if (kotlin.g.b.k.a((Object) state, (Object) l.FAILED_EXECUTION_ACTIVE.getStatus())) {
                                f.b((View) bVar.f67548h);
                                bVar.f67548h.setImageResource(R.drawable.ic_status_failed);
                                TextView textView8 = bVar.f67547g;
                                View view8 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view8, "itemView");
                                textView8.setTextColor(androidx.core.content.b.c(view8.getContext(), R.color.failure_color));
                            } else if (kotlin.g.b.k.a((Object) state, (Object) l.FAILED_UPDATE_ACTIVE.getStatus())) {
                                f.b((View) bVar.f67548h);
                                bVar.f67548h.setImageResource(R.drawable.ic_status_failed);
                                TextView textView9 = bVar.f67547g;
                                View view9 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view9, "itemView");
                                textView9.setTextColor(androidx.core.content.b.c(view9.getContext(), R.color.failure_color));
                            } else if (kotlin.g.b.k.a((Object) state, (Object) l.FAILED_REVOKE_ACTIVE.getStatus())) {
                                f.b((View) bVar.f67548h);
                                bVar.f67548h.setImageResource(R.drawable.ic_status_failed);
                                TextView textView10 = bVar.f67547g;
                                View view10 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view10, "itemView");
                                textView10.setTextColor(androidx.core.content.b.c(view10.getContext(), R.color.failure_color));
                            }
                        }
                        f.a((View) bVar.f67548h);
                        TextView textView11 = bVar.f67547g;
                        View view11 = bVar.itemView;
                        kotlin.g.b.k.a((Object) view11, "itemView");
                        textView11.setTextColor(androidx.core.content.b.c(view11.getContext(), R.color.default_status_color));
                    }
                }
                String validityStartDate = mandateItem.getValidityStartDate();
                String validityEndDate = mandateItem.getValidityEndDate();
                String state2 = mandateItem.getState();
                if (validityStartDate != null) {
                    try {
                        if (validityStartDate.length() == 0) {
                            return;
                        }
                    } catch (Exception e2) {
                        PaytmLogs.e(k.class.getCanonicalName(), e2.getLocalizedMessage());
                        return;
                    }
                }
                if (validityEndDate != null) {
                    if (validityEndDate.length() == 0) {
                        return;
                    }
                }
                Date date = new Date();
                Calendar instance = Calendar.getInstance();
                kotlin.g.b.k.a((Object) instance, "todayCalendar");
                instance.setTime(date);
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                if (validityStartDate == null) {
                    kotlin.g.b.k.a();
                }
                Date date2 = new Date(Long.parseLong(validityStartDate));
                if (validityEndDate == null) {
                    kotlin.g.b.k.a();
                }
                Date date3 = new Date(Long.parseLong(validityEndDate));
                Calendar instance2 = Calendar.getInstance();
                kotlin.g.b.k.a((Object) instance2, "startCalendar");
                instance2.setTime(date2);
                Calendar instance3 = Calendar.getInstance();
                kotlin.g.b.k.a((Object) instance3, "endCalendar");
                instance3.setTime(date3);
                if (instance.before(instance2)) {
                    p.a(l.ACTIVE.getStatus(), state2, true);
                } else {
                    instance.after(instance3);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateItem");
            }
        }
    }

    public final void b(RecyclerView.v vVar, int i2) {
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            D d2 = this.f67510b.get(i2);
            if (d2 != null) {
                b.C1372b bVar = (b.C1372b) d2;
                kotlin.g.b.k.c(bVar, "headerItem");
                aVar.f67506a.setText(bVar.f67511a);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.view.InfinitePaginationAdapter.HeaderItem");
        }
    }

    public final void a() {
        this.f67540d.a();
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f67541a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f67542b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f67543c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f67544d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f67545e;

        /* renamed from: f  reason: collision with root package name */
        final ImageView f67546f;

        /* renamed from: g  reason: collision with root package name */
        final TextView f67547g;

        /* renamed from: h  reason: collision with root package name */
        final ImageView f67548h;

        /* renamed from: i  reason: collision with root package name */
        final TextView f67549i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            kotlin.g.b.k.c(view, "view");
            View findViewById = this.itemView.findViewById(R.id.tv_name_initial);
            kotlin.g.b.k.a((Object) findViewById, "itemView.findViewById(R.id.tv_name_initial)");
            this.f67541a = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.tvPayeeName);
            kotlin.g.b.k.a((Object) findViewById2, "itemView.findViewById(R.id.tvPayeeName)");
            this.f67542b = (TextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.tvPayeeVpa);
            kotlin.g.b.k.a((Object) findViewById3, "itemView.findViewById(R.id.tvPayeeVpa)");
            this.f67543c = (TextView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.tvValidity);
            kotlin.g.b.k.a((Object) findViewById4, "itemView.findViewById(R.id.tvValidity)");
            this.f67544d = (TextView) findViewById4;
            View findViewById5 = this.itemView.findViewById(R.id.tvAmount);
            kotlin.g.b.k.a((Object) findViewById5, "itemView.findViewById(R.id.tvAmount)");
            this.f67545e = (TextView) findViewById5;
            View findViewById6 = this.itemView.findViewById(R.id.ivOptions);
            kotlin.g.b.k.a((Object) findViewById6, "itemView.findViewById(R.id.ivOptions)");
            this.f67546f = (ImageView) findViewById6;
            View findViewById7 = this.itemView.findViewById(R.id.tvMandateStatus);
            kotlin.g.b.k.a((Object) findViewById7, "itemView.findViewById(R.id.tvMandateStatus)");
            this.f67547g = (TextView) findViewById7;
            View findViewById8 = this.itemView.findViewById(R.id.ivStatusIcon);
            kotlin.g.b.k.a((Object) findViewById8, "itemView.findViewById(R.id.ivStatusIcon)");
            this.f67548h = (ImageView) findViewById8;
            View findViewById9 = this.itemView.findViewById(R.id.tvExtraMandateInfo);
            kotlin.g.b.k.a((Object) findViewById9, "itemView.findViewById(R.id.tvExtraMandateInfo)");
            this.f67549i = (TextView) findViewById9;
        }
    }

    public final int getItemCount() {
        return this.f67510b.size();
    }
}
