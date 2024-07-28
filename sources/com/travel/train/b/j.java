package com.travel.train.b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.model.trainticket.CJRTrainOfferCode;
import java.util.ArrayList;

public final class j extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRTrainOfferCode> f26429a;

    /* renamed from: b  reason: collision with root package name */
    Context f26430b;

    /* renamed from: c  reason: collision with root package name */
    a f26431c;

    /* renamed from: d  reason: collision with root package name */
    public String f26432d;

    public interface a {
        void a();

        void a(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        final CJRTrainOfferCode cJRTrainOfferCode = this.f26429a.get(i2);
        if (cJRTrainOfferCode != null) {
            bVar.f26445b.setText(cJRTrainOfferCode.getOfferText());
            bVar.f26444a.setText(cJRTrainOfferCode.getCode());
            bVar.f26447d.setTag(cJRTrainOfferCode.getCode());
            bVar.f26449f.setTag(cJRTrainOfferCode);
            bVar.f26447d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    String str = (String) view.getTag();
                    if (TextUtils.isEmpty(j.this.f26432d)) {
                        j.this.f26431c.a(cJRTrainOfferCode.getCode());
                    } else if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(j.this.f26432d)) {
                        j jVar = j.this;
                        if (!TextUtils.isEmpty(str)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(jVar.f26430b);
                            builder.setMessage(Html.fromHtml(String.format(jVar.f26430b.getString(R.string.remove_promo_cart), new Object[]{str})));
                            builder.setPositiveButton(jVar.f26430b.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    j jVar = j.this;
                                    jVar.f26432d = null;
                                    jVar.f26431c.a();
                                    j.this.notifyDataSetChanged();
                                }
                            });
                            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.show();
                        }
                    } else {
                        j jVar2 = j.this;
                        String code = cJRTrainOfferCode.getCode();
                        if (!TextUtils.isEmpty(code)) {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(jVar2.f26430b);
                            builder2.setMessage(Html.fromHtml("<B>" + jVar2.f26432d + "</B> has already been applied. If you wish to apply <B>" + code + "</B>, your last offer will be replaced."));
                            builder2.setPositiveButton(jVar2.f26430b.getString(R.string.cart_replace), new DialogInterface.OnClickListener(code) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ String f26439a;

                                {
                                    this.f26439a = r2;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    j.this.f26431c.a(this.f26439a);
                                }
                            });
                            builder2.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    dialogInterface.dismiss();
                                }
                            });
                            builder2.show();
                        }
                    }
                }
            });
            if (TextUtils.isEmpty(this.f26432d)) {
                bVar.f26448e.setVisibility(8);
                bVar.f26446c.setVisibility(0);
                bVar.f26447d.setBackground(this.f26430b.getResources().getDrawable(R.drawable.pre_t_train_bg_btn_coupon_add));
            } else if (cJRTrainOfferCode.getCode().equalsIgnoreCase(this.f26432d)) {
                bVar.f26448e.setVisibility(0);
                bVar.f26446c.setVisibility(8);
                bVar.f26447d.setBackground(this.f26430b.getResources().getDrawable(R.drawable.pre_t_train_bg_btn_coupon_add_selected));
            } else {
                bVar.f26448e.setVisibility(8);
                bVar.f26446c.setVisibility(0);
                bVar.f26447d.setBackground(this.f26430b.getResources().getDrawable(R.drawable.pre_t_train_bg_btn_coupon_add));
            }
        }
    }

    public final void a(String str) {
        this.f26432d = str;
        notifyDataSetChanged();
    }

    public j(Context context, ArrayList<CJRTrainOfferCode> arrayList, a aVar, String str) {
        this.f26430b = context;
        this.f26429a = arrayList;
        this.f26431c = aVar;
        this.f26432d = str;
    }

    public final int getItemCount() {
        ArrayList<CJRTrainOfferCode> arrayList = this.f26429a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f26444a;

        /* renamed from: b  reason: collision with root package name */
        TextView f26445b;

        /* renamed from: c  reason: collision with root package name */
        TextView f26446c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f26447d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f26448e;

        /* renamed from: f  reason: collision with root package name */
        TextView f26449f;

        public b(View view) {
            super(view);
            this.f26444a = (TextView) view.findViewById(R.id.offer_code_text_view);
            this.f26445b = (TextView) view.findViewById(R.id.offer_desc_text_view);
            this.f26447d = (RelativeLayout) view.findViewById(R.id.apply_promo_layout_train);
            this.f26448e = (ImageView) view.findViewById(R.id.apply_tick_image);
            this.f26446c = (TextView) view.findViewById(R.id.apply_text);
            this.f26449f = (TextView) view.findViewById(R.id.offer_desc_text_view);
            this.f26449f.setOnClickListener(new View.OnClickListener(j.this) {
                public final void onClick(View view) {
                    if (view.getTag() != null) {
                        CJRTrainOfferCode cJRTrainOfferCode = (CJRTrainOfferCode) view.getTag();
                        if (!TextUtils.isEmpty(cJRTrainOfferCode.getTerms()) && !TextUtils.isEmpty(cJRTrainOfferCode.getTermsTitle())) {
                            j jVar = j.this;
                            String termsTitle = cJRTrainOfferCode.getTermsTitle();
                            String obj = Html.fromHtml(cJRTrainOfferCode.getTerms()).toString();
                            try {
                                AlertDialog create = new AlertDialog.Builder(jVar.f26430b).create();
                                View inflate = LayoutInflater.from(jVar.f26430b).inflate(R.layout.pre_t_recharge_tc_custom_dialog, (ViewGroup) null);
                                create.setView(inflate);
                                ((TextView) inflate.findViewById(R.id.w_custom_dialog_title)).setText(termsTitle);
                                ((TextView) inflate.findViewById(R.id.w_custom_dialog_message)).setText(obj);
                                ((ImageView) inflate.findViewById(R.id.cross_icon_popup)).setOnClickListener(new View.OnClickListener(create) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AlertDialog f26435a;

                                    {
                                        this.f26435a = r2;
                                    }

                                    public final void onClick(View view) {
                                        this.f26435a.dismiss();
                                    }
                                });
                                ((Button) inflate.findViewById(R.id.w_custom_dialog_btn_positive)).setOnClickListener(new View.OnClickListener(create) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AlertDialog f26437a;

                                    {
                                        this.f26437a = r2;
                                    }

                                    public final void onClick(View view) {
                                        this.f26437a.dismiss();
                                    }
                                });
                                create.show();
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            });
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_offers_list_item, (ViewGroup) null));
    }
}
