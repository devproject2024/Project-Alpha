package com.travel.bus.busticket.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.bus.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.utility.d;

public final class l extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f21678a;

    /* renamed from: b  reason: collision with root package name */
    b f21679b;

    /* renamed from: c  reason: collision with root package name */
    String f21680c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJROfferCode> f21681d;

    /* renamed from: e  reason: collision with root package name */
    private int f21682e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f21683f = 2;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21684g = false;

    public interface b {
        void a();

        void a(String str);
    }

    public final void a(String str) {
        this.f21680c = str;
        notifyDataSetChanged();
    }

    public l(Context context, ArrayList<CJROfferCode> arrayList, b bVar, String str) {
        this.f21678a = context;
        this.f21681d = arrayList;
        this.f21679b = bVar;
        this.f21680c = str;
        this.f21684g = false;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.f21683f) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_offers_list_item, (ViewGroup) null));
        }
        if (i2 == this.f21682e) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_recharge_offers_footer, (ViewGroup) null));
        }
        return null;
    }

    public final int getItemViewType(int i2) {
        if (i2 == this.f21681d.size() && this.f21684g) {
            return this.f21682e;
        }
        return this.f21683f;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            final CJROfferCode cJROfferCode = this.f21681d.get(i2);
            if (cJROfferCode != null) {
                cVar.f21689b.setText(cJROfferCode.getOfferText());
                cVar.f21688a.setText(cJROfferCode.getCode());
                cVar.f21692e.setTag(cJROfferCode.getCode());
                cVar.f21691d.setTag(cJROfferCode);
                cVar.f21692e.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        String str = (String) view.getTag();
                        if (TextUtils.isEmpty(l.this.f21680c)) {
                            l.this.b(cJROfferCode.getCode());
                            l.this.f21679b.a(cJROfferCode.getCode());
                        } else if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(l.this.f21680c)) {
                            l.b(l.this, str);
                        } else {
                            l.a(l.this, cJROfferCode.getCode());
                        }
                    }
                });
                if (TextUtils.isEmpty(this.f21680c)) {
                    cVar.f21693f.setVisibility(8);
                    cVar.f21690c.setVisibility(0);
                    cVar.f21692e.setBackground(this.f21678a.getResources().getDrawable(R.drawable.travel_res_bus_bg_btn_coupon_add));
                } else if (cJROfferCode.getCode().equalsIgnoreCase(this.f21680c)) {
                    cVar.f21693f.setVisibility(0);
                    cVar.f21690c.setVisibility(8);
                    cVar.f21692e.setBackground(this.f21678a.getResources().getDrawable(R.drawable.travel_res_bus_bg_btn_coupon_add_selected));
                } else {
                    cVar.f21693f.setVisibility(8);
                    cVar.f21690c.setVisibility(0);
                    cVar.f21692e.setBackground(this.f21678a.getResources().getDrawable(R.drawable.travel_res_bus_bg_btn_coupon_add));
                }
            }
        }
    }

    public final void a(ArrayList<CJROfferCode> arrayList, String str) {
        this.f21681d = arrayList;
        this.f21680c = str;
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        ArrayList<CJROfferCode> arrayList = this.f21681d;
        if (arrayList == null) {
            return 0;
        }
        if (this.f21684g) {
            return arrayList.size() + 1;
        }
        return arrayList.size();
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f21688a;

        /* renamed from: b  reason: collision with root package name */
        TextView f21689b;

        /* renamed from: c  reason: collision with root package name */
        TextView f21690c;

        /* renamed from: d  reason: collision with root package name */
        TextView f21691d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f21692e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f21693f;

        public c(View view) {
            super(view);
            this.f21688a = (TextView) view.findViewById(R.id.offer_code_text_view);
            this.f21689b = (TextView) view.findViewById(R.id.offer_desc_text_view);
            this.f21692e = (RelativeLayout) view.findViewById(R.id.apply_promo_layout_train);
            this.f21691d = (TextView) view.findViewById(R.id.txt_bus_offer_terms);
            this.f21693f = (ImageView) view.findViewById(R.id.apply_tick_image);
            this.f21690c = (TextView) view.findViewById(R.id.apply_text);
            this.f21691d.setOnClickListener(new View.OnClickListener(l.this) {
                public final void onClick(View view) {
                    if (view.getTag() != null) {
                        CJROfferCode cJROfferCode = (CJROfferCode) view.getTag();
                        if (!TextUtils.isEmpty(cJROfferCode.getTerms()) && !TextUtils.isEmpty(cJROfferCode.getTermsTitle())) {
                            com.paytm.utility.b.b(l.this.f21678a, cJROfferCode.getTermsTitle(), Html.fromHtml(cJROfferCode.getTerms()).toString());
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n(this.f21678a));
            hashMap.put("bus_promocode", str);
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(d.cK, (Map<String, Object>) hashMap, this.f21678a);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    class a extends RecyclerView.v {
        public a(View view) {
            super(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, DialogInterface dialogInterface, int i2) {
        this.f21679b.a(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        this.f21680c = null;
        this.f21679b.a();
        notifyDataSetChanged();
    }

    static /* synthetic */ void a(l lVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            lVar.b(str);
            AlertDialog.Builder builder = new AlertDialog.Builder(lVar.f21678a);
            builder.setMessage(Html.fromHtml("<B>" + lVar.f21680c + "</B> has already been applied. If you wish to apply <B>" + str + "</B>, your last offer will be replaced."));
            builder.setPositiveButton(lVar.f21678a.getString(R.string.cart_replace), new DialogInterface.OnClickListener(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    l.this.a(this.f$1, dialogInterface, i2);
                }
            });
            builder.setNegativeButton(17039360, $$Lambda$l$F0JnI3Mnekzv7LCcFndxiLMbfg.INSTANCE);
            builder.show();
        }
    }

    static /* synthetic */ void b(l lVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", com.paytm.utility.b.n(lVar.f21678a));
                com.travel.bus.a.a();
                com.travel.bus.a.b().a(d.cL, (Map<String, Object>) hashMap, lVar.f21678a);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(lVar.f21678a);
            builder.setMessage(Html.fromHtml(String.format(lVar.f21678a.getString(R.string.remove_promo_cart), new Object[]{str})));
            builder.setPositiveButton(lVar.f21678a.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    l.this.b(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(17039360, $$Lambda$l$cCKoMxBLf3SqDSkCV_cmMNIgVqo.INSTANCE);
            builder.show();
        }
    }
}
