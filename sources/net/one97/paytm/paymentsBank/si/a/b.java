package net.one97.paytm.paymentsBank.si.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.si.a.b;
import net.one97.paytm.paymentsBank.si.activity.RecurringPaymentDetailActivity;
import net.one97.paytm.paymentsBank.si.response.AllSIResponse;
import net.one97.paytm.paymentsBank.utils.swipe.SwipeRevealLayout;

public final class b extends RecyclerView.a<C0323b> {

    /* renamed from: a  reason: collision with root package name */
    final net.one97.paytm.paymentsBank.utils.swipe.a f18781a = new net.one97.paytm.paymentsBank.utils.swipe.a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRPaytmDataModel> f18782b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    Context f18783c;

    /* renamed from: d  reason: collision with root package name */
    a f18784d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f18785e = new ArrayList<String>() {
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

    /* renamed from: f  reason: collision with root package name */
    private int f18786f = -1;

    public interface a {
        void a(AllSIResponse.StandingInstructions standingInstructions);

        void b(AllSIResponse.StandingInstructions standingInstructions);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0323b bVar = (C0323b) vVar;
        net.one97.paytm.paymentsBank.utils.swipe.a aVar = this.f18781a;
        SwipeRevealLayout swipeRevealLayout = bVar.f18787a;
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.getAdapterPosition());
        aVar.a(swipeRevealLayout, sb.toString());
        if (bVar != null) {
            bVar.f18788b.setTag(Integer.valueOf(i2));
            bVar.a(i2);
        }
    }

    public b(Context context, ArrayList<IJRPaytmDataModel> arrayList, a aVar) {
        this.f18783c = context;
        this.f18782b = arrayList;
        this.f18784d = aVar;
        this.f18781a.f19605c = true;
    }

    static String a(String str) {
        try {
            return a("yyyy-MM-dd", "dd MMM ''yy", str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str, String str2, String str3) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
            return simpleDateFormat2.format(simpleDateFormat.parse(str3));
        } catch (Exception unused) {
            return "";
        }
    }

    public final int getItemCount() {
        ArrayList<IJRPaytmDataModel> arrayList = this.f18782b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void a() {
        if (getItemCount() > 0) {
            AllSIResponse.StandingInstructions standingInstructions = (AllSIResponse.StandingInstructions) this.f18782b.get(0);
            if (!"PERMANENT_DEACTIVATED".equalsIgnoreCase(standingInstructions.getStatus()) || !"CLOSED".equalsIgnoreCase(standingInstructions.getStatus())) {
                net.one97.paytm.paymentsBank.utils.swipe.a aVar = this.f18781a;
                synchronized (aVar.f19606d) {
                    aVar.f19603a.put("0", 2);
                    if (aVar.f19604b.containsKey("0")) {
                        aVar.f19604b.get("0").a(true);
                    } else if (aVar.f19605c) {
                        aVar.a("0", aVar.f19604b.get("0"));
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        b.this.b();
                    }
                }, 500);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f18781a.a("0");
    }

    /* renamed from: net.one97.paytm.paymentsBank.si.a.b$b  reason: collision with other inner class name */
    public class C0323b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        SwipeRevealLayout f18787a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f18788b;

        /* renamed from: d  reason: collision with root package name */
        private TextView f18790d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18791e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18792f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f18793g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f18794h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f18795i;
        private TextView j;
        private ShapeDrawable k = new ShapeDrawable(new OvalShape());
        private ViewGroup l;
        private ViewGroup m;

        C0323b(View view) {
            super(view);
            this.f18787a = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            this.f18794h = (TextView) view.findViewById(R.id.accountTv);
            this.f18792f = (TextView) view.findViewById(R.id.delete_tv);
            this.f18793g = (TextView) view.findViewById(R.id.moreTv);
            this.f18790d = (TextView) view.findViewById(R.id.nameTv);
            this.f18791e = (TextView) view.findViewById(R.id.dateTv);
            this.f18795i = (TextView) view.findViewById(R.id.initialsTv);
            this.f18788b = (RelativeLayout) view.findViewById(R.id.beneficiary_item);
            this.j = (TextView) view.findViewById(R.id.amountTv);
            this.l = (ViewGroup) view.findViewById(R.id.circleLayout);
            this.m = (ViewGroup) view.findViewById(R.id.paused_lyt);
        }

        public final void a(int i2) {
            AllSIResponse.StandingInstructions standingInstructions = (AllSIResponse.StandingInstructions) b.this.f18782b.get(i2);
            String reminderDisplayName = standingInstructions.getReminderDisplayName();
            String str = b.this.f18785e.get(i2 % 10);
            if (!TextUtils.isEmpty(reminderDisplayName)) {
                this.f18790d.setText(reminderDisplayName);
                this.f18795i.setText(net.one97.paytm.paymentsBank.si.g.b.a(reminderDisplayName).toUpperCase());
            }
            this.j.setText(String.format(b.this.f18783c.getString(R.string.rupee), new Object[]{net.one97.paytm.bankCommon.mapping.a.c(standingInstructions.getAmount())}));
            TextView textView = this.f18794h;
            textView.setText(b.this.f18783c.getString(R.string.si_acc_no) + ".- " + net.one97.paytm.paymentsBank.si.g.b.b(standingInstructions.getDestinationAccount()));
            if ("ACTIVE".equalsIgnoreCase(standingInstructions.getStatus())) {
                this.f18793g.setText(b.this.f18783c.getString(R.string.si_pause));
                this.m.setVisibility(4);
                if (!TextUtils.isEmpty(standingInstructions.getStartDate()) && b.b(standingInstructions.getStartDate())) {
                    TextView textView2 = this.f18791e;
                    textView2.setText(b.this.f18783c.getString(R.string.si_first_payment_on) + " " + b.a(standingInstructions.getStartDate()));
                } else if (!TextUtils.isEmpty(standingInstructions.getNextExecutionDate())) {
                    TextView textView3 = this.f18791e;
                    textView3.setText(b.this.f18783c.getString(R.string.si_next_payment_on) + " " + b.a(standingInstructions.getNextExecutionDate()));
                } else {
                    this.f18791e.setText("");
                }
                this.f18791e.setVisibility(0);
            } else {
                this.f18793g.setText(b.this.f18783c.getString(R.string.si_resume));
                if ("PERMANENT_DEACTIVATED".equalsIgnoreCase(standingInstructions.getStatus()) || "CLOSED".equalsIgnoreCase(standingInstructions.getStatus())) {
                    this.m.setVisibility(8);
                    this.f18791e.setText("");
                    this.f18791e.setVisibility(0);
                } else {
                    this.m.setVisibility(0);
                    this.f18791e.setVisibility(8);
                }
            }
            this.f18788b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.C0323b.this.c(view);
                }
            });
            this.f18792f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.C0323b.this.b(view);
                }
            });
            this.f18793g.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.C0323b.this.a(view);
                }
            });
            if ("PERMANENT_DEACTIVATED".equalsIgnoreCase(standingInstructions.getStatus())) {
                net.one97.paytm.paymentsBank.utils.swipe.a aVar = b.this.f18781a;
                SwipeRevealLayout swipeRevealLayout = this.f18787a;
                StringBuilder sb = new StringBuilder();
                sb.append(getAdapterPosition());
                aVar.a(swipeRevealLayout, sb.toString());
                net.one97.paytm.paymentsBank.utils.swipe.a aVar2 = b.this.f18781a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getAdapterPosition());
                aVar2.a(sb2.toString());
                this.f18790d.setTextColor(androidx.core.content.b.c(b.this.f18783c, R.color.gray));
                this.f18794h.setTextColor(androidx.core.content.b.c(b.this.f18783c, R.color.gray));
                this.j.setTextColor(androidx.core.content.b.c(b.this.f18783c, R.color.gray));
                this.k.getPaint().setColor(Color.parseColor("#999999"));
                this.l.setBackground(this.k);
                return;
            }
            b.this.f18781a.a(false, String.valueOf(i2));
            this.f18790d.setTextColor(androidx.core.content.b.c(b.this.f18783c, R.color.color_222222));
            this.f18794h.setTextColor(androidx.core.content.b.c(b.this.f18783c, R.color.color_222222));
            this.j.setTextColor(androidx.core.content.b.c(b.this.f18783c, R.color.color_222222));
            this.k.getPaint().setColor(Color.parseColor(str));
            this.l.setBackground(this.k);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            Intent intent = new Intent(b.this.f18783c, RecurringPaymentDetailActivity.class);
            intent.putExtra("extra_data", b.this.f18782b.get(getAdapterPosition()));
            ((Activity) b.this.f18783c).startActivityForResult(intent, 120);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            net.one97.paytm.paymentsBank.utils.swipe.a aVar = b.this.f18781a;
            StringBuilder sb = new StringBuilder();
            sb.append(getAdapterPosition());
            aVar.a(sb.toString());
            a aVar2 = b.this.f18784d;
            getAdapterPosition();
            aVar2.a((AllSIResponse.StandingInstructions) b.this.f18782b.get(getAdapterPosition()));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            net.one97.paytm.paymentsBank.utils.swipe.a aVar = b.this.f18781a;
            StringBuilder sb = new StringBuilder();
            sb.append(getAdapterPosition());
            aVar.a(sb.toString());
            a aVar2 = b.this.f18784d;
            getAdapterPosition();
            aVar2.b((AllSIResponse.StandingInstructions) b.this.f18782b.get(getAdapterPosition()));
        }
    }

    static boolean b(String str) {
        try {
            if (new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(str).getTime() - new Date().getTime() > 0) {
                return true;
            }
            return false;
        } catch (ParseException unused) {
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0323b(LayoutInflater.from(this.f18783c).inflate(R.layout.si_recurring_list_swipe_item, viewGroup, false));
    }
}
