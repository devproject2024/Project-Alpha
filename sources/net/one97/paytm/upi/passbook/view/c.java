package net.one97.paytm.upi.passbook.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.passbook.a.a;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f67747a;

    /* renamed from: b  reason: collision with root package name */
    public int f67748b;

    /* renamed from: c  reason: collision with root package name */
    a.C1377a f67749c;

    /* renamed from: d  reason: collision with root package name */
    protected ArrayList<String> f67750d = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f67749c.a(i2, (a) vVar);
    }

    public c(Context context, a.C1377a aVar, int i2) {
        this.f67747a = context;
        this.f67749c = aVar;
        this.f67748b = i2;
    }

    public final int getItemCount() {
        return this.f67749c.a();
    }

    public final void a(int i2, int i3) {
        this.f67749c.g();
        notifyItemRangeInserted(i2, i3);
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f67779a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f67780b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f67781c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67782d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f67783e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f67784f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f67785g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f67786h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f67787i;
        public TextView j;
        public View k;
        public RelativeLayout l;
        public RelativeLayout m;
        public TextView n;
        public ImageView o;
        private TextView q;
        private TextView r;
        private TextView s;
        private TextView t;
        private TextView u;
        private TextView v;
        private TextView w;
        private RelativeLayout x;

        public a(View view) {
            super(view);
            this.n = (TextView) view.findViewById(R.id.recurringStatus);
            this.o = (ImageView) view.findViewById(R.id.recurringStatusIcon);
            this.f67779a = (ImageView) view.findViewById(R.id.iv_transaction_icon);
            this.f67780b = (ImageView) view.findViewById(R.id.iv_more_icon);
            this.q = (TextView) view.findViewById(R.id.tv_name_initial);
            this.r = (TextView) view.findViewById(R.id.tv_transaction_title);
            this.f67782d = (TextView) view.findViewById(R.id.tv_amount_indicator);
            this.f67783e = (TextView) view.findViewById(R.id.tv_amount);
            this.f67784f = (TextView) view.findViewById(R.id.tv_upi_address);
            this.f67785g = (TextView) view.findViewById(R.id.tv_timestamp);
            this.v = (TextView) view.findViewById(R.id.tv_pay_upi);
            this.w = (TextView) view.findViewById(R.id.tv_decline_upi);
            this.f67786h = (TextView) view.findViewById(R.id.tv_expiry);
            this.f67787i = (TextView) view.findViewById(R.id.tv_status);
            this.j = (TextView) view.findViewById(R.id.tv_note);
            this.t = (TextView) view.findViewById(R.id.tv_mark_spam);
            this.u = (TextView) view.findViewById(R.id.tv_remove_spam);
            this.s = (TextView) view.findViewById(R.id.tv_delete_spam);
            this.k = view.findViewById(R.id.v_divider);
            this.f67781c = (ImageView) view.findViewById(R.id.ivStatusIcon);
            this.l = (RelativeLayout) view.findViewById(R.id.rl_spam_actions);
            this.m = (RelativeLayout) view.findViewById(R.id.rl_received_actions);
            this.x = (RelativeLayout) view.findViewById(R.id.rl_border);
        }

        public final void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.x.setVisibility(8);
                this.q.setVisibility(8);
                this.f67779a.setVisibility(0);
                w.a().a(str).a(R.drawable.upi_merchant_icon).b(R.drawable.upi_merchant_icon).a(this.f67779a, (e) null);
            }
        }

        public final void b(String str) {
            this.x.setVisibility(8);
            this.q.setVisibility(8);
            this.f67779a.setVisibility(0);
            w.a().a(str).a(R.drawable.upi_merchant_icon).b(R.drawable.upi_merchant_icon).a(this.f67779a, (e) null);
        }

        public final void a(String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                this.f67782d.setTextColor(b.c(c.this.f67747a, R.color.color_222222));
                this.f67783e.setTextColor(b.c(c.this.f67747a, R.color.color_222222));
                if ("CREDIT".equalsIgnoreCase(str)) {
                    if ("SUCCESS".equalsIgnoreCase(str2)) {
                        this.r.setText(str3);
                        this.f67782d.setTextColor(b.c(c.this.f67747a, R.color.color_21c17a));
                        this.f67783e.setTextColor(b.c(c.this.f67747a, R.color.color_21c17a));
                        return;
                    }
                    this.r.setText(str3);
                } else if ("SUCCESS".equalsIgnoreCase(str2) || !"REJECT".equalsIgnoreCase(str2)) {
                    this.r.setText(str3);
                } else {
                    this.r.setText(str3);
                    this.f67782d.setTextColor(b.c(c.this.f67747a, R.color.color_fd5c5c));
                    this.f67783e.setTextColor(b.c(c.this.f67747a, R.color.color_fd5c5c));
                }
            } else {
                this.r.setText(str3);
            }
        }

        public final void c(String str) {
            TextView textView = this.f67782d;
            textView.setText(str + " ");
        }

        public final void d(String str) {
            this.f67783e.setText(f.b(UpiAppUtils.priceToString(str)));
        }

        public final void e(String str) {
            this.f67784f.setText(str);
        }

        public final void a(final int i2) {
            if (c.this.f67748b == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                TextView textView = this.t;
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            c.this.a(i2);
                        }
                    });
                }
                this.w.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.f67749c.d(i2);
                    }
                });
                this.v.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.f67749c.c(i2);
                    }
                });
                this.f67780b.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.f67749c.a(i2, a.this.f67780b);
                    }
                });
            } else if (c.this.f67748b == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
                this.s.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c cVar = c.this;
                        int i2 = i2;
                        if (cVar.f67749c.i(i2) != null) {
                            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(cVar.f67747a, Events.Category.COLLECT, "delete_request_click", "", "", "", cVar.f67749c.i(i2).getPayeeVa(), "", Events.Screen.SPAM_FOLDER, "passbook");
                            CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(cVar.f67747a);
                            customWalletAlertDialog.setTitle(cVar.f67747a.getString(R.string.alert));
                            customWalletAlertDialog.setMessage(cVar.f67747a.getString(R.string.upi_decline_request_message));
                            customWalletAlertDialog.setButton(-1, cVar.f67747a.getString(R.string.ok), new View.OnClickListener(i2, customWalletAlertDialog) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ int f67760a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ CustomWalletAlertDialog f67761b;

                                {
                                    this.f67760a = r2;
                                    this.f67761b = r3;
                                }

                                public final void onClick(View view) {
                                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(c.this.f67747a, Events.Category.COLLECT, "delete_request_confirm_click", "", "", "", c.this.f67749c.i(this.f67760a).getPayeeVa(), "", Events.Screen.SPAM_FOLDER, "passbook");
                                    this.f67761b.dismiss();
                                    c.this.f67749c.b(this.f67760a);
                                }
                            });
                            customWalletAlertDialog.setButton(-2, cVar.f67747a.getString(R.string.cancel), new View.OnClickListener(customWalletAlertDialog) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ CustomWalletAlertDialog f67763a;

                                {
                                    this.f67763a = r2;
                                }

                                public final void onClick(View view) {
                                    this.f67763a.dismiss();
                                }
                            });
                            customWalletAlertDialog.show();
                        }
                    }
                });
                this.u.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.f67749c.f(i2);
                    }
                });
            }
        }

        public final void f(String str) {
            this.f67786h.setText(String.format(c.this.f67747a.getString(R.string.upi_request_expires), new Object[]{str}));
        }

        public final void a() {
            this.f67787i.setVisibility(8);
            this.f67781c.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        }

        public final void a(String str, int i2) {
            this.x.setVisibility(0);
            this.q.setVisibility(0);
            this.f67779a.setVisibility(8);
            this.q.setBackgroundColor(Color.parseColor(c.this.f67750d.get(i2 % 10)));
            this.q.setText(UpiUtils.getNameInitials(str));
        }

        public final void a(String str, String str2) {
            this.f67779a.setVisibility(0);
            this.x.setVisibility(8);
            this.q.setVisibility(8);
            if ("P2P".equalsIgnoreCase(str2) && "DEBIT".equalsIgnoreCase(str)) {
                this.f67779a.setImageResource(R.drawable.ic_money_sent);
            } else if ("P2P".equalsIgnoreCase(str2) && "CREDIT".equalsIgnoreCase(str)) {
                this.f67779a.setImageResource(R.drawable.ic_money_recived);
            } else if ("CASHBACK".equalsIgnoreCase(str2)) {
                this.f67779a.setImageResource(R.drawable.ic_cash_back);
            } else if ("REFUND".equalsIgnoreCase(str2)) {
                this.f67779a.setImageResource(R.drawable.ic_refund);
            }
        }
    }

    public final void a(int i2) {
        this.f67749c.e(i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_upi_transaction, viewGroup, false));
    }
}
