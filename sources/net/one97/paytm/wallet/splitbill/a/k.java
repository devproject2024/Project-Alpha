package net.one97.paytm.wallet.splitbill.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.registration.view.y;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.SwipeRevealLayout;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBMarkAsPaidActivity;
import net.one97.paytm.wallet.splitbill.activity.SBUserToUserDetailActivity;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementBaseResponse;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSnapShotPojo;

public final class k extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    List<SBUserSnapShotPojo> f71855a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    Activity f71856b;

    /* renamed from: c  reason: collision with root package name */
    a f71857c;

    /* renamed from: d  reason: collision with root package name */
    boolean f71858d;

    /* renamed from: e  reason: collision with root package name */
    y f71859e = new y();

    /* renamed from: f  reason: collision with root package name */
    com.paytm.b.a.a f71860f;

    /* renamed from: g  reason: collision with root package name */
    private final int f71861g = 1;

    /* renamed from: h  reason: collision with root package name */
    private final int f71862h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f71863i = false;
    private ArrayList<String> j = new ArrayList<String>() {
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

    public interface a {
        void a();

        void a(String str, boolean z, String str2, Double d2);

        void aJ_();

        void c();

        void d();

        void e();
    }

    public k(Activity activity, a aVar) {
        this.f71856b = activity;
        this.f71857c = aVar;
        this.f71859e.f69090b = true;
        this.f71860f = be.a(this.f71856b.getApplicationContext());
        this.f71858d = this.f71860f.b("needToShowSliderHint", true, false);
    }

    public final void a(List<SBUserSnapShotPojo> list, boolean z) {
        this.f71855a = list;
        this.f71863i = z;
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_pay_receive_item, viewGroup, false));
        }
        if (i2 != 1) {
            return null;
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_rv_user_settlement_footer_item, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        String str;
        String str2;
        if (vVar instanceof c) {
            final c cVar = (c) vVar;
            this.f71859e.a(cVar.f71893f, String.valueOf(i2));
            if (Float.parseFloat(this.f71855a.get(i2).getAmount()) > 0.0f) {
                str2 = this.f71855a.get(i2).getPayeeName();
                str = String.valueOf(Math.abs(Float.parseFloat(this.f71855a.get(i2).getAmount())));
                cVar.f71894g.setText(Events.Label.PAY);
                cVar.f71894g.setBackgroundColor(Color.parseColor("#00b9f5"));
                cVar.f71895h.setText("Mark as Paid");
                cVar.f71895h.setBackgroundColor(Color.parseColor("#b8c2cb"));
                cVar.f71891d.setText("To Pay");
                cVar.f71891d.setTextColor(Color.parseColor("#fd5c5c"));
            } else {
                str2 = this.f71855a.get(i2).getPayeeName();
                str = String.valueOf(Math.abs(Float.parseFloat(this.f71855a.get(i2).getAmount())));
                cVar.f71894g.setText("Send Reminder");
                cVar.f71894g.setBackgroundColor(Color.parseColor("#ffad00"));
                cVar.f71895h.setText("Mark as Paid");
                cVar.f71895h.setBackgroundColor(Color.parseColor("#b8c2cb"));
                cVar.f71891d.setText("To Receive");
                cVar.f71891d.setTextColor(Color.parseColor("#21c17a"));
            }
            cVar.f71888a.setText(str2);
            cVar.f71889b.setBackgroundColor(Color.parseColor(this.j.get(i2 % 10)));
            if (!TextUtils.isEmpty(str)) {
                TextView textView = cVar.f71890c;
                textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Double.parseDouble(str))));
            }
            String a2 = net.one97.paytm.wallet.splitbill.e.b.a(str2);
            TextView textView2 = cVar.f71889b;
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            textView2.setText(a2);
            cVar.f71892e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.f71859e.b(String.valueOf(i2));
                    Intent intent = new Intent(k.this.f71856b, SBUserToUserDetailActivity.class);
                    intent.putExtra("user_id", k.this.f71855a.get(i2).getPayeeId());
                    intent.putExtra("your_id", k.this.f71855a.get(i2).getPayerId());
                    k.this.f71856b.startActivity(intent);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("splitBillHome");
                    arrayList.add(k.this.f71855a.get(i2).getPayeeId());
                    net.one97.paytm.wallet.splitbill.e.b.a(k.this.f71856b, "split_bill", "splitbill_user2user", arrayList, "", "/splitbill/user2user", "split_bill");
                }
            });
            cVar.f71894g.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (cVar.f71894g.getText().toString().equalsIgnoreCase("Send Reminder")) {
                        Double valueOf = Double.valueOf(k.this.f71855a.get(i2).getAmount());
                        k kVar = k.this;
                        kVar.a(kVar.f71855a.get(i2).getPayeeId(), Double.valueOf(Math.abs(valueOf.doubleValue())));
                    } else if (cVar.f71894g.getText().toString().equalsIgnoreCase(Events.Label.PAY)) {
                        Double valueOf2 = Double.valueOf(k.this.f71855a.get(i2).getAmount());
                        Intent intent = new Intent();
                        intent.putExtra("PHONE_NUMBER", k.this.f71855a.get(i2).getPayeeMobile());
                        intent.putExtra("AMOUNT", net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(valueOf2.doubleValue()))));
                        intent.putExtra("SOURCE", "SPLIT_BILL");
                        intent.putExtra("PAYER_ID", k.this.f71855a.get(i2).getPayerId());
                        intent.putExtra("PAYEE_ID", k.this.f71855a.get(i2).getPayeeId());
                        net.one97.paytm.wallet.utility.a.a(intent, k.this.f71856b);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("splitBillHome");
                        arrayList.add(k.this.f71855a.get(i2).getPayeeId());
                        net.one97.paytm.wallet.splitbill.e.b.a(k.this.f71856b, "split_bill", "splitbill_pay", arrayList, String.valueOf(Math.abs(valueOf2.doubleValue())), "/splitbill/pay", "split_bill");
                    }
                    k.this.f71859e.b(String.valueOf(i2));
                }
            });
            cVar.f71895h.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (cVar.f71895h.getText().toString().equalsIgnoreCase("Mark as Paid")) {
                        Intent intent = new Intent(k.this.f71856b, SBMarkAsPaidActivity.class);
                        intent.putExtra("fromHome", true);
                        intent.putExtra("user_name", k.this.f71855a.get(i2).getPayeeName());
                        Double valueOf = Double.valueOf(k.this.f71855a.get(i2).getAmount());
                        intent.putExtra("amount", valueOf);
                        intent.putExtra("mode", "MANUAL");
                        if (valueOf.doubleValue() >= 0.0d) {
                            intent.putExtra("payerId", k.this.f71855a.get(i2).getPayerId());
                            intent.putExtra("payeeId", k.this.f71855a.get(i2).getPayeeId());
                        } else {
                            intent.putExtra("payerId", k.this.f71855a.get(i2).getPayeeId());
                            intent.putExtra("payeeId", k.this.f71855a.get(i2).getPayerId());
                        }
                        k.this.f71856b.startActivity(intent);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("splitBillHome");
                        arrayList.add(k.this.f71855a.get(i2).getPayeeId());
                        net.one97.paytm.wallet.splitbill.e.b.a(k.this.f71856b, "split_bill", "splitbill_markPay", arrayList, String.valueOf(Math.abs(valueOf.doubleValue())), "splitbill_markPay", "split_bill");
                    }
                    k.this.f71859e.b(String.valueOf(i2));
                }
            });
            if (i2 == 0 && this.f71858d) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        k.this.f71859e.a(String.valueOf(i2));
                        k kVar = k.this;
                        kVar.f71858d = false;
                        kVar.f71860f = be.a(kVar.f71856b.getApplicationContext());
                        k.this.f71860f.a("needToShowSliderHint", false, false);
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                k.this.f71859e.b(String.valueOf(i2));
                            }
                        }, 1000);
                    }
                }, 1000);
            }
            if (i2 == this.f71855a.size() - 1) {
                cVar.f71896i.setVisibility(8);
            } else {
                cVar.f71896i.setVisibility(0);
            }
        } else if (vVar instanceof b) {
            b bVar = (b) vVar;
            bVar.f71880a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.f71857c.aJ_();
                }
            });
            bVar.f71881b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.f71857c.c();
                }
            });
            bVar.f71882c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.f71857c.d();
                }
            });
            bVar.f71883d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.f71857c.e();
                }
            });
            bVar.f71884e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                }
            });
            if (this.f71863i && i2 == 6) {
                bVar.f71880a.setVisibility(0);
                bVar.f71885f.setText("View More");
                bVar.f71886g.setBackground(androidx.core.content.b.a((Context) this.f71856b, R.drawable.ic_sb_view_all));
            } else if (!this.f71863i && i2 > 6) {
                bVar.f71880a.setVisibility(0);
                bVar.f71885f.setText("View Less");
                bVar.f71886g.setBackground(androidx.core.content.b.a((Context) this.f71856b, R.drawable.ic_sb_view_less));
            } else if (!this.f71863i || i2 <= 6) {
                bVar.f71880a.setVisibility(8);
            } else {
                bVar.f71880a.setVisibility(0);
                bVar.f71885f.setText("View Less");
                bVar.f71886g.setBackground(androidx.core.content.b.a((Context) this.f71856b, R.drawable.ic_sb_view_less));
            }
        }
        if (this.f71855a.size() == i2 + 1 && i2 > 7) {
            this.f71857c.a();
        }
    }

    public final int getItemViewType(int i2) {
        return i2 == this.f71855a.size() ? 1 : 0;
    }

    public final int getItemCount() {
        if (this.f71855a.size() > 0) {
            return this.f71855a.size() + 1;
        }
        return 1;
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71888a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71889b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71890c;

        /* renamed from: d  reason: collision with root package name */
        TextView f71891d;

        /* renamed from: e  reason: collision with root package name */
        FrameLayout f71892e;

        /* renamed from: f  reason: collision with root package name */
        SwipeRevealLayout f71893f;

        /* renamed from: g  reason: collision with root package name */
        TextView f71894g;

        /* renamed from: h  reason: collision with root package name */
        TextView f71895h;

        /* renamed from: i  reason: collision with root package name */
        View f71896i;

        public c(View view) {
            super(view);
            this.f71888a = (TextView) view.findViewById(R.id.name);
            this.f71889b = (TextView) view.findViewById(R.id.mp_initial_name_tv);
            this.f71890c = (TextView) view.findViewById(R.id.amount);
            this.f71893f = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            this.f71892e = (FrameLayout) view.findViewById(R.id.frame_pay_receive);
            this.f71894g = (TextView) view.findViewById(R.id.tv1);
            this.f71895h = (TextView) view.findViewById(R.id.tv2);
            this.f71891d = (TextView) view.findViewById(R.id.tv_to_pay_receive);
            this.f71896i = view.findViewById(R.id.line_separator);
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f71880a;

        /* renamed from: b  reason: collision with root package name */
        LinearLayout f71881b;

        /* renamed from: c  reason: collision with root package name */
        LinearLayout f71882c;

        /* renamed from: d  reason: collision with root package name */
        LinearLayout f71883d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f71884e;

        /* renamed from: f  reason: collision with root package name */
        TextView f71885f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f71886g;

        public b(View view) {
            super(view);
            this.f71880a = (RelativeLayout) view.findViewById(R.id.lyt_view_all);
            this.f71881b = (LinearLayout) view.findViewById(R.id.lyt_view_bills);
            this.f71882c = (LinearLayout) view.findViewById(R.id.lyt_splitbill_activity);
            this.f71883d = (LinearLayout) view.findViewById(R.id.lyt_share_feedback);
            this.f71885f = (TextView) view.findViewById(R.id.tv_view_all_less);
            this.f71886g = (ImageView) view.findViewById(R.id.iv_expand_all_less);
            this.f71884e = (LinearLayout) view.findViewById(R.id.lyt_help);
        }
    }

    public final void a(String str, Double d2) {
        String stringFromGTM = !TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f71856b, "getSendReminderURL")) ? net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f71856b, "getSendReminderURL") : "https://prms.paytmbank.com/prms/ext/v1/reminder/user";
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", net.one97.paytm.wallet.splitbill.e.b.class.getSimpleName());
        hashMap.put("userId", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", com.paytm.utility.a.q(this.f71856b));
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("content-type", "application/json");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        new net.one97.paytm.network.b(stringFromGTM, new SBUserSettlementBaseResponse(), hashMap, hashMap2, (String) null).c().observeForever(new z(str, d2) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Double f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onChanged(Object obj) {
                k.this.a(this.f$1, this.f$2, (f) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, Double d2, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if ((fVar.f55797b instanceof SBUserSettlementBaseResponse) && ((SBUserSettlementBaseResponse) fVar.f55797b).getSuccess() != null) {
                if (((SBUserSettlementBaseResponse) fVar.f55797b).getSuccess().booleanValue()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("splitBillHome");
                    arrayList.add(str);
                    arrayList.add("success");
                    net.one97.paytm.wallet.splitbill.e.b.a(this.f71856b, "split_bill", "splitbill_remind", arrayList, String.valueOf(d2), "/splitbill/remind", "split_bill");
                    this.f71857c.a("Reminder sent for ₹".concat(String.valueOf(d2)), true, str, d2);
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("splitBillHome");
                arrayList2.add(str);
                arrayList2.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                String message = ((SBUserSettlementBaseResponse) fVar.f55797b).getMessage() != null ? ((SBUserSettlementBaseResponse) fVar.f55797b).getMessage() : "";
                net.one97.paytm.wallet.splitbill.e.b.a(this.f71856b, "split_bill", "splitbill_remind", arrayList2, String.valueOf(d2), "/splitbill/remind", "split_bill");
                this.f71857c.a(message, false, str, d2);
            }
        } else if (fVar.f55796a == h.ERROR) {
            this.f71857c.a(fVar.f55798c.f55801c.getMessage(), false, str, d2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("splitBillHome");
            arrayList3.add(str);
            arrayList3.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            net.one97.paytm.wallet.splitbill.e.b.a(this.f71856b, "split_bill", "splitbill_remind", arrayList3, String.valueOf(d2), "/splitbill/remind", "split_bill");
        }
    }
}
