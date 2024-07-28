package net.one97.paytm.upi.requestmoney.view;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import d.a.a.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.QuickPayModeEnum;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;
import net.one97.paytm.upi.registration.view.y;
import net.one97.paytm.upi.util.SwipeRevealLayout;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final y f69336a = new y();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<UpiBaseDataModel> f69337b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    Context f69338c;

    /* renamed from: d  reason: collision with root package name */
    boolean f69339d = true;

    /* renamed from: e  reason: collision with root package name */
    C1403a f69340e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<String> f69341f = new ArrayList<String>() {
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

    /* renamed from: g  reason: collision with root package name */
    private int f69342g = -1;

    /* renamed from: net.one97.paytm.upi.requestmoney.view.a$a  reason: collision with other inner class name */
    public interface C1403a {
        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        String str2;
        String str3;
        b bVar = (b) vVar;
        y yVar = this.f69336a;
        SwipeRevealLayout swipeRevealLayout = bVar.f69347a;
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.getAdapterPosition());
        yVar.a(swipeRevealLayout, sb.toString());
        if (bVar != null) {
            bVar.f69354h.setTag(Integer.valueOf(i2));
            if (((BeneficiaryEntity) a.this.f69337b.get(i2)).instrumentPreferences.upi != null) {
                QuickPayModeEnum.UPI.getPayMode();
                BeneficiaryEntity.UPI upi = ((BeneficiaryEntity) a.this.f69337b.get(i2)).instrumentPreferences.upi;
                str3 = upi.accounts.get(0).accountDetail.accountHolderName;
                str2 = upi.accounts.get(0).accountDetail.vpa;
                str = upi.accounts.get(0).creationTime;
                if (upi.accounts.get(0).uuid.equalsIgnoreCase("0")) {
                    bVar.f69351e.setVisibility(8);
                } else {
                    bVar.f69351e.setVisibility(0);
                }
            } else {
                str3 = "";
                str2 = str3;
                str = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                bVar.f69352f.setText(str3);
                bVar.f69353g.setText(UpiAppUtils.getInitialsSingle(str3));
            } else {
                bVar.f69355i.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str2)) {
                if (UpiAppUtils.checkIsVpa(str2)) {
                    bVar.f69348b.setText(Html.fromHtml(String.format(a.this.f69338c.getString(R.string.money_transfer_upi_without_bold), new Object[]{str2})));
                } else {
                    bVar.f69348b.setText(Html.fromHtml(String.format(a.this.f69338c.getString(R.string.money_transfer_acc_no_with_placeholder_without_bold), new Object[]{UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(str2), 4)})));
                }
            }
            bVar.f69350d.setVisibility(8);
            if (!TextUtils.isEmpty("")) {
                bVar.f69353g.setVisibility(8);
                bVar.f69355i.setVisibility(0);
                bVar.j.setVisibility(8);
                bVar.f69350d.setText("");
                a aVar = a.this;
                ImageView imageView = bVar.f69355i;
                boolean isEmpty = TextUtils.isEmpty("");
                boolean isEmpty2 = TextUtils.isEmpty("");
                if (!TextUtils.isEmpty("")) {
                    w.a().a(UpiRequestBuilder.getBankIconUrl(aVar.f69338c.getApplicationContext(), "")).a(R.drawable.mt_dummy_beneficiary_icon).b(R.drawable.ic_default_bank).a(imageView, (e) null);
                }
            } else {
                bVar.j.setVisibility(0);
                bVar.f69353g.setVisibility(0);
                bVar.f69353g.setBackgroundColor(Color.parseColor(a.this.f69341f.get(i2 % 10)));
            }
            bVar.f69349c.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                bVar.f69349c.setText(String.format(a.this.f69338c.getString(R.string.money_transfer_added_on), new Object[]{a(str)}));
            }
            bVar.f69354h.setOnClickListener(new View.OnClickListener(str3, str2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f69365a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ String f69366b;

                {
                    this.f69365a = r2;
                    this.f69366b = r3;
                }

                public final void onClick(View view) {
                    try {
                        c.a().c(new net.one97.paytm.upi.requestmoney.model.a(this.f69365a, this.f69366b));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            bVar.f69351e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    y yVar = a.this.f69336a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(b.this.getAdapterPosition());
                    yVar.b(sb.toString());
                    a.this.f69340e.a(b.this.getAdapterPosition());
                }
            });
        }
    }

    public a(Context context, ArrayList<UpiBaseDataModel> arrayList, C1403a aVar) {
        this.f69338c = context;
        this.f69337b = arrayList;
        this.f69340e = aVar;
        this.f69336a.f69090b = true;
    }

    private static String a(String str) {
        try {
            return a("dd/MM/yyyy HH:mm:ss", "dd MMM", str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final int getItemCount() {
        ArrayList<UpiBaseDataModel> arrayList = this.f69337b;
        if (arrayList == null) {
            return 0;
        }
        if (this.f69339d) {
            return arrayList.size();
        }
        return Math.min(arrayList.size(), b.f69376a);
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        SwipeRevealLayout f69347a;

        /* renamed from: b  reason: collision with root package name */
        TextView f69348b;

        /* renamed from: c  reason: collision with root package name */
        TextView f69349c;

        /* renamed from: d  reason: collision with root package name */
        TextView f69350d;

        /* renamed from: e  reason: collision with root package name */
        TextView f69351e;

        /* renamed from: f  reason: collision with root package name */
        TextView f69352f;

        /* renamed from: g  reason: collision with root package name */
        TextView f69353g;

        /* renamed from: h  reason: collision with root package name */
        RelativeLayout f69354h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f69355i;
        RelativeLayout j;
        private ImageView l;

        b(View view) {
            super(view);
            this.f69347a = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            this.f69348b = (TextView) view.findViewById(R.id.beneficiary_name);
            this.f69351e = (TextView) view.findViewById(R.id.delete_tv);
            this.f69352f = (TextView) view.findViewById(R.id.beneficiary_number);
            this.f69349c = (TextView) view.findViewById(R.id.date_tv);
            this.f69350d = (TextView) view.findViewById(R.id.headerBankLogoName);
            this.f69353g = (TextView) view.findViewById(R.id.beneficiary_circle);
            this.f69354h = (RelativeLayout) view.findViewById(R.id.beneficiary_item);
            this.f69355i = (ImageView) view.findViewById(R.id.beneficiary_no_name_icon);
            this.l = (ImageView) view.findViewById(R.id.selected_icon);
            this.j = (RelativeLayout) view.findViewById(R.id.layer_contact_list_backgrnd);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f69338c).inflate(R.layout.item_request_money_recent_txns, viewGroup, false));
    }
}
