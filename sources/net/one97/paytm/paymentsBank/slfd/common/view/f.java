package net.one97.paytm.paymentsBank.slfd.common.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.mapping.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdModel;
import net.one97.paytm.paymentsBank.slfd.common.a.c;

public final class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final c.a f19032a;

    /* renamed from: b  reason: collision with root package name */
    final e f19033b;

    /* renamed from: c  reason: collision with root package name */
    final String f19034c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        this.f19032a.a(aVar, i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return new a(from != null ? from.inflate(R.layout.item_active_fd, viewGroup, false) : null);
    }

    public f(c.a aVar, e eVar, String str) {
        k.c(aVar, "presenter");
        k.c(eVar, "context");
        k.c(str, "type");
        this.f19032a = aVar;
        this.f19033b = eVar;
        this.f19034c = str;
    }

    public final int getItemCount() {
        return this.f19032a.c();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f19036b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f19037c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f19038d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f19039e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f19040f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f19041g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            if (view == null) {
                k.a();
            }
            TextView textView = (TextView) view.findViewById(R.id.tv_fd_created_on);
            if (textView != null) {
                this.f19036b = textView;
                View findViewById = view.findViewById(R.id.tv_fd_amount);
                if (findViewById != null) {
                    this.f19037c = (TextView) findViewById;
                    View findViewById2 = view.findViewById(R.id.tv_total_interest_earned);
                    if (findViewById2 != null) {
                        this.f19038d = (TextView) findViewById2;
                        View findViewById3 = view.findViewById(R.id.tv_fd_status);
                        if (findViewById3 != null) {
                            this.f19039e = (TextView) findViewById3;
                            View findViewById4 = view.findViewById(R.id.tv_fd_interest_amount);
                            if (findViewById4 != null) {
                                this.f19040f = (TextView) findViewById4;
                                View findViewById5 = view.findViewById(R.id.tv_processing);
                                if (findViewById5 != null) {
                                    this.f19041g = (TextView) findViewById5;
                                    return;
                                }
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        public final void a(String str) {
            TextView textView;
            k.c(str, "title");
            String str2 = null;
            if (f.this.f19034c.equals("active,pending")) {
                textView = this.f19036b;
                aa aaVar = aa.f47921a;
                FragmentActivity activity = f.this.f19033b.getActivity();
                if (activity == null) {
                    k.a();
                }
                String string = activity.getString(R.string.fd_created_on);
                k.a((Object) string, "context.activity!!.getSt…k.R.string.fd_created_on)");
                str2 = String.format(string, Arrays.copyOf(new Object[]{net.one97.paytm.paymentsBank.slfd.b.a.a.a(str)}, 1));
                k.a((Object) str2, "java.lang.String.format(format, *args)");
            } else if (f.this.f19034c.equals("A")) {
                if ("IBL_FD_CREATION".equals(str)) {
                    TextView textView2 = this.f19036b;
                    FragmentActivity activity2 = f.this.f19033b.getActivity();
                    if (activity2 != null) {
                        str2 = activity2.getString(R.string.fd_invested_amount_label);
                    }
                    textView2.setText(str2);
                    return;
                }
                TextView textView3 = this.f19036b;
                FragmentActivity activity3 = f.this.f19033b.getActivity();
                if (activity3 != null) {
                    str2 = activity3.getString(R.string.redemption_amount_label);
                }
                textView3.setText(str2);
                return;
            } else if (f.this.f19034c.equals(AppConstants.FEED_COMMUNITY)) {
                TextView textView4 = this.f19036b;
                FragmentActivity activity4 = f.this.f19033b.getActivity();
                if (activity4 != null) {
                    str2 = activity4.getString(R.string.fd_invested_amount_label);
                }
                textView4.setText(str2);
                return;
            } else if (f.this.f19034c.equals("R")) {
                textView = this.f19036b;
                FragmentActivity activity5 = f.this.f19033b.getActivity();
                if (activity5 != null) {
                    str2 = activity5.getString(R.string.redemption_amount_label);
                }
            } else {
                return;
            }
            textView.setText(str2);
        }

        public final void b(String str) {
            k.c(str, "amount");
            aa aaVar = aa.f47921a;
            FragmentActivity activity = f.this.f19033b.getActivity();
            if (activity == null) {
                k.a();
            }
            String string = activity.getString(R.string.fd_amount, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(str)});
            k.a((Object) string, "context.activity!!.getSt…nt)\n                    )");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            e.a(format, this.f19037c);
        }

        public final void a(SlfdModel slfdModel) {
            k.c(slfdModel, "slfdModel");
            this.f19039e.setVisibility(8);
            if (SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING.equalsIgnoreCase(slfdModel.getFdStatus()) || slfdModel.getLockedAmount() > 0.0d) {
                this.f19040f.setVisibility(8);
                this.f19038d.setVisibility(8);
                this.f19041g.setVisibility(0);
                return;
            }
            this.f19038d.setVisibility(0);
            this.f19040f.setVisibility(0);
            this.f19041g.setVisibility(8);
            TextView textView = this.f19040f;
            FragmentActivity activity = f.this.f19033b.getActivity();
            if (activity == null) {
                k.a();
            }
            textView.setText(activity.getString(R.string.fd_amount_without_space, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(slfdModel.getInterestEarned()))}));
            for (String next : slfdModel.getFdCategory()) {
                if (!next.equals("2000")) {
                    next.equals("2001");
                }
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.slfd.common.view.f$a$a  reason: collision with other inner class name */
        public static final class C0332a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f19042a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f19043b;

            public C0332a(a aVar, int i2) {
                this.f19042a = aVar;
                this.f19043b = i2;
            }

            public final void onClick(View view) {
                f.this.f19032a.a(this.f19043b);
            }
        }
    }
}
