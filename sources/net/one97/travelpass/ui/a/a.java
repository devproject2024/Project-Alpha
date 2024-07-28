package net.one97.travelpass.ui.a;

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
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.travelpass.R;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f30584a;

    /* renamed from: b  reason: collision with root package name */
    b f30585b;

    /* renamed from: c  reason: collision with root package name */
    String f30586c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJROfferCode> f30587d;

    /* renamed from: e  reason: collision with root package name */
    private int f30588e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f30589f = 2;

    /* renamed from: g  reason: collision with root package name */
    private boolean f30590g = false;

    public interface b {
        void a();

        void a(String str);
    }

    public final void a(String str) {
        this.f30586c = str;
        notifyDataSetChanged();
    }

    public a(Context context, ArrayList<CJROfferCode> arrayList, b bVar, String str) {
        this.f30584a = context;
        this.f30587d = arrayList;
        this.f30585b = bVar;
        this.f30586c = str;
        this.f30590g = false;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.f30589f) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_tp_offers_list_item, (ViewGroup) null));
        }
        if (i2 == this.f30588e) {
            return new C0519a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_tp_recharge_offers_footer, (ViewGroup) null));
        }
        return null;
    }

    public final int getItemViewType(int i2) {
        if (i2 == this.f30587d.size() && this.f30590g) {
            return this.f30588e;
        }
        return this.f30589f;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            final CJROfferCode cJROfferCode = this.f30587d.get(i2);
            if (cJROfferCode != null) {
                cVar.f30604b.setText(cJROfferCode.getOfferText());
                cVar.f30603a.setText(cJROfferCode.getCode());
                cVar.f30607e.setTag(cJROfferCode.getCode());
                cVar.f30606d.setTag(cJROfferCode);
                cVar.f30607e.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        String str = (String) view.getTag();
                        if (TextUtils.isEmpty(a.this.f30586c)) {
                            cJROfferCode.getCode();
                            a.this.f30585b.a(cJROfferCode.getCode());
                        } else if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(a.this.f30586c)) {
                            a aVar = a.this;
                            if (!TextUtils.isEmpty(str)) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(aVar.f30584a);
                                builder.setMessage(Html.fromHtml(String.format(aVar.f30584a.getString(R.string.remove_promo_cart), new Object[]{str})));
                                builder.setPositiveButton(aVar.f30584a.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        a aVar = a.this;
                                        aVar.f30586c = null;
                                        aVar.f30585b.a();
                                        a.this.notifyDataSetChanged();
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
                            a aVar2 = a.this;
                            String code = cJROfferCode.getCode();
                            if (!TextUtils.isEmpty(code)) {
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(aVar2.f30584a);
                                builder2.setMessage(Html.fromHtml("<B>" + aVar2.f30586c + "</B> has already been applied. If you wish to apply <B>" + code + "</B>, your last offer will be replaced."));
                                builder2.setPositiveButton(aVar2.f30584a.getString(R.string.cart_replace), new DialogInterface.OnClickListener(code) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ String f30597a;

                                    {
                                        this.f30597a = r2;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        a.this.f30585b.a(this.f30597a);
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
                if (TextUtils.isEmpty(this.f30586c)) {
                    cVar.f30608f.setVisibility(8);
                    cVar.f30605c.setVisibility(0);
                    cVar.f30607e.setBackground(this.f30584a.getResources().getDrawable(R.drawable.pre_tp_bg_btn_coupon_add));
                } else if (cJROfferCode.getCode().equalsIgnoreCase(this.f30586c)) {
                    cVar.f30608f.setVisibility(0);
                    cVar.f30605c.setVisibility(8);
                    cVar.f30607e.setBackground(this.f30584a.getResources().getDrawable(R.drawable.pre_tp_bg_btn_coupon_add_selected));
                } else {
                    cVar.f30608f.setVisibility(8);
                    cVar.f30605c.setVisibility(0);
                    cVar.f30607e.setBackground(this.f30584a.getResources().getDrawable(R.drawable.pre_tp_bg_btn_coupon_add));
                }
            }
        }
    }

    public final void a(ArrayList<CJROfferCode> arrayList, String str) {
        this.f30587d = arrayList;
        this.f30586c = str;
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        ArrayList<CJROfferCode> arrayList = this.f30587d;
        if (arrayList == null) {
            return 0;
        }
        if (this.f30590g) {
            return arrayList.size() + 1;
        }
        return arrayList.size();
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f30603a;

        /* renamed from: b  reason: collision with root package name */
        TextView f30604b;

        /* renamed from: c  reason: collision with root package name */
        TextView f30605c;

        /* renamed from: d  reason: collision with root package name */
        TextView f30606d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f30607e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f30608f;

        public c(View view) {
            super(view);
            this.f30603a = (TextView) view.findViewById(R.id.offer_code_text_view);
            this.f30604b = (TextView) view.findViewById(R.id.offer_desc_text_view);
            this.f30607e = (RelativeLayout) view.findViewById(R.id.apply_promo_layout_train);
            this.f30606d = (TextView) view.findViewById(R.id.txt_bus_offer_terms);
            this.f30608f = (ImageView) view.findViewById(R.id.apply_tick_image);
            ResourceUtils.loadTPassImagesFromCDN(this.f30608f, "close_2.png", false, true, n.a.V1);
            this.f30605c = (TextView) view.findViewById(R.id.apply_text);
            this.f30606d.setOnClickListener(new View.OnClickListener(a.this) {
                public final void onClick(View view) {
                    if (view.getTag() != null) {
                        CJROfferCode cJROfferCode = (CJROfferCode) view.getTag();
                        if (!TextUtils.isEmpty(cJROfferCode.getTerms()) && !TextUtils.isEmpty(cJROfferCode.getTermsTitle())) {
                            a aVar = a.this;
                            String termsTitle = cJROfferCode.getTermsTitle();
                            String obj = Html.fromHtml(cJROfferCode.getTerms()).toString();
                            AlertDialog create = new AlertDialog.Builder(aVar.f30584a).create();
                            View inflate = LayoutInflater.from(aVar.f30584a).inflate(R.layout.pre_tp_recharge_tc_custom_dialog, (ViewGroup) null);
                            ImageView imageView = (ImageView) inflate.findViewById(R.id.cross_icon_popup);
                            ResourceUtils.loadBusImagesFromCDN(imageView, "close_1.png", false, true, n.a.V1);
                            create.setView(inflate);
                            ((TextView) inflate.findViewById(R.id.w_custom_dialog_title)).setText(termsTitle);
                            ((TextView) inflate.findViewById(R.id.w_custom_dialog_message)).setText(obj);
                            ((Button) inflate.findViewById(R.id.w_custom_dialog_btn_positive)).setOnClickListener(new View.OnClickListener(create) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ AlertDialog f30593a;

                                {
                                    this.f30593a = r2;
                                }

                                public final void onClick(View view) {
                                    this.f30593a.dismiss();
                                }
                            });
                            imageView.setOnClickListener(new View.OnClickListener(create) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ AlertDialog f30595a;

                                {
                                    this.f30595a = r2;
                                }

                                public final void onClick(View view) {
                                    this.f30595a.dismiss();
                                }
                            });
                            create.show();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: net.one97.travelpass.ui.a.a$a  reason: collision with other inner class name */
    class C0519a extends RecyclerView.v {
        public C0519a(View view) {
            super(view);
        }
    }
}
