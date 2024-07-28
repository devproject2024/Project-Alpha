package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytm.utility.t;
import com.squareup.picasso.aa;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Date;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.utils.n;

public final class p extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f74696a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRFoodBeverageItemV2> f74697b;

    /* renamed from: c  reason: collision with root package name */
    boolean f74698c = false;

    /* renamed from: d  reason: collision with root package name */
    c f74699d;

    /* renamed from: e  reason: collision with root package name */
    Toast f74700e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f74701f = ((LayoutInflater) this.f74696a.getSystemService("layout_inflater"));

    /* renamed from: g  reason: collision with root package name */
    private int f74702g;

    public interface c {
        void a(int i2);

        void a(boolean z);

        void a(boolean z, boolean z2);

        void b(int i2);
    }

    public final int getItemViewType(int i2) {
        return 1;
    }

    public p(Context context, ArrayList<CJRFoodBeverageItemV2> arrayList, c cVar) {
        this.f74696a = context;
        this.f74697b = arrayList;
        this.f74699d = cVar;
        this.f74702g = n.a(4, this.f74696a);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != 1) {
            return new b(this.f74701f.inflate(R.layout.food_adapter_view_more, viewGroup, false));
        }
        View inflate = this.f74701f.inflate(R.layout.food_adapter_item, viewGroup, false);
        if (!this.f74698c) {
            inflate.setLayoutParams(new ConstraintLayout.LayoutParams(new ConstraintLayout.LayoutParams(-1, -2)));
        }
        return new a(inflate);
    }

    public final int getItemCount() {
        ArrayList<CJRFoodBeverageItemV2> arrayList = this.f74697b;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        int size = this.f74697b.size();
        if (!this.f74698c || size <= 5) {
            return size;
        }
        return 5;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        int i3;
        if (vVar instanceof a) {
            final a aVar = (a) vVar;
            ArrayList<CJRFoodBeverageItemV2> arrayList = this.f74697b;
            final CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = (arrayList == null || arrayList.size() <= 0) ? null : this.f74697b.get(i2);
            if (cJRFoodBeverageItemV2 != null) {
                if (!TextUtils.isEmpty(cJRFoodBeverageItemV2.getmItemName())) {
                    aVar.f74719e.setText(cJRFoodBeverageItemV2.getmItemName());
                    if (!TextUtils.isEmpty(cJRFoodBeverageItemV2.getmItemDescription())) {
                        aVar.f74720f.setText(cJRFoodBeverageItemV2.getmItemDescription());
                    } else {
                        aVar.f74720f.setText("");
                    }
                }
                if (!TextUtils.isEmpty(cJRFoodBeverageItemV2.getmPrice())) {
                    RoboTextView roboTextView = aVar.f74721g;
                    roboTextView.setText(this.f74696a.getString(R.string.rupees) + cJRFoodBeverageItemV2.getmPrice());
                }
                Boolean isVeg = cJRFoodBeverageItemV2.isVeg();
                if (isVeg == null) {
                    i3 = 0;
                } else {
                    i3 = isVeg.booleanValue() ? R.drawable.ic_veg_12_dp_green : R.drawable.ic_nonveg_12_dp_red;
                }
                aVar.k.setImageResource(i3);
                Float valueOf = Float.valueOf(0.0f);
                if (!TextUtils.isEmpty(cJRFoodBeverageItemV2.getmDiscount())) {
                    valueOf = Float.valueOf(Float.parseFloat(cJRFoodBeverageItemV2.getmDiscount()));
                }
                double floatValue = (double) valueOf.floatValue();
                int i4 = 8;
                if (floatValue > 0.0d) {
                    RoboTextView roboTextView2 = aVar.f74723i;
                    roboTextView2.setText("( " + this.f74696a.getString(R.string.item_discount_text, new Object[]{cJRFoodBeverageItemV2.getmDiscount()}) + " )");
                    aVar.f74723i.setVisibility(0);
                    if (!TextUtils.isEmpty(cJRFoodBeverageItemV2.getmMrpPrice())) {
                        aVar.f74722h.setVisibility(0);
                        RoboTextView roboTextView3 = aVar.f74722h;
                        roboTextView3.setText(this.f74696a.getString(R.string.rs) + " " + cJRFoodBeverageItemV2.getmMrpPrice());
                        aVar.f74722h.setPaintFlags(aVar.f74722h.getPaintFlags() | 16);
                    } else {
                        aVar.f74722h.setVisibility(8);
                    }
                } else {
                    aVar.f74722h.setVisibility(8);
                    aVar.f74723i.setVisibility(8);
                }
                aa a2 = w.a().a(cJRFoodBeverageItemV2.getmItemImageURL());
                a2.f45353b = true;
                a2.b(this.f74696a.getResources().getDrawable(R.drawable.fnb_item_placeholder)).a(this.f74696a.getResources().getDrawable(R.drawable.fnb_item_placeholder)).a((ah) new t.b(this.f74702g, 0, true)).a(aVar.j, (e) null);
                int i5 = cJRFoodBeverageItemV2.getmFoodQauntitySelected();
                try {
                    aVar.f74715a.setBackground((GradientDrawable) aVar.f74715a.getBackground());
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.b(e2.getMessage());
                    }
                }
                aVar.f74715a.setVisibility(i5 > 0 ? 8 : 0);
                LinearLayout linearLayout = aVar.f74716b;
                if (i5 > 0) {
                    i4 = 0;
                }
                linearLayout.setVisibility(i4);
                if (i5 > 0) {
                    aVar.l.setText(String.valueOf(i5));
                }
                aVar.f74715a.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        aVar.f74715a.setVisibility(8);
                        aVar.f74716b.setVisibility(0);
                        aVar.l.setText("1");
                        cJRFoodBeverageItemV2.setmFoodQauntitySelected(1);
                        cJRFoodBeverageItemV2.setItemSelectionTimeStamp(new Date());
                        if (p.this.f74699d != null) {
                            p.this.f74699d.a(true);
                            p.this.f74699d.a(i2);
                        }
                    }
                });
                aVar.f74717c.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        int i2 = p.this.f74697b.get(i2).getmFoodQauntitySelected();
                        Integer maxOrderCount = p.this.f74697b.get(i2).getMaxOrderCount();
                        if (maxOrderCount != null) {
                            try {
                                if (i2 >= maxOrderCount.intValue()) {
                                    Context context = p.this.f74696a;
                                    int i3 = R.string.movies_fnb_voucher_limit_reached;
                                    Object[] objArr = new Object[2];
                                    objArr[0] = maxOrderCount;
                                    objArr[1] = CJRFoodBeverageItemV2.FOOD_VOUCHER.equals(p.this.f74697b.get(i2).getType()) ? "Vouchers" : "Food Items";
                                    String string = context.getString(i3, objArr);
                                    if (p.this.f74700e != null) {
                                        p.this.f74700e.cancel();
                                    }
                                    p.this.f74700e = Toast.makeText(p.this.f74696a, string, 0);
                                    p.this.f74700e.show();
                                    return;
                                }
                            } catch (Exception unused) {
                            }
                        }
                        int i4 = i2 + 1;
                        if (i4 > 0) {
                            aVar.l.setText(String.valueOf(i4));
                            cJRFoodBeverageItemV2.setmFoodQauntitySelected(i4);
                        }
                        if (p.this.f74699d != null) {
                            p.this.f74699d.a(true);
                        }
                        cJRFoodBeverageItemV2.setItemSelectionTimeStamp(new Date());
                    }
                });
                aVar.f74718d.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        int i2 = p.this.f74697b.get(i2).getmFoodQauntitySelected() - 1;
                        if (i2 > 0) {
                            aVar.l.setText(String.valueOf(i2));
                            cJRFoodBeverageItemV2.setmFoodQauntitySelected(i2);
                        } else {
                            cJRFoodBeverageItemV2.setmFoodQauntitySelected(0);
                            aVar.f74715a.setVisibility(0);
                            aVar.f74716b.setVisibility(8);
                            if (p.this.f74699d != null) {
                                p.this.f74699d.b(i2);
                            }
                        }
                        cJRFoodBeverageItemV2.setItemSelectionTimeStamp(new Date());
                        if (p.this.f74699d != null) {
                            p.this.f74699d.a(true);
                        }
                    }
                });
            }
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f74715a;

        /* renamed from: b  reason: collision with root package name */
        final LinearLayout f74716b;

        /* renamed from: c  reason: collision with root package name */
        final AppCompatImageView f74717c;

        /* renamed from: d  reason: collision with root package name */
        final AppCompatImageView f74718d;

        /* renamed from: e  reason: collision with root package name */
        RoboTextView f74719e;

        /* renamed from: f  reason: collision with root package name */
        RoboTextView f74720f;

        /* renamed from: g  reason: collision with root package name */
        RoboTextView f74721g;

        /* renamed from: h  reason: collision with root package name */
        RoboTextView f74722h;

        /* renamed from: i  reason: collision with root package name */
        RoboTextView f74723i;
        ImageView j;
        ImageView k;
        RoboTextView l;
        private final View n;

        public a(View view) {
            super(view);
            this.f74719e = (RoboTextView) view.findViewById(R.id.food_title);
            this.f74720f = (RoboTextView) view.findViewById(R.id.food_name);
            this.f74715a = (RoboTextView) view.findViewById(R.id.id_add_item);
            this.f74716b = (LinearLayout) view.findViewById(R.id.id_food_add_sub_linlayout);
            this.j = (ImageView) view.findViewById(R.id.id_food_img);
            this.k = (ImageView) view.findViewById(R.id.food_type_indicator);
            this.f74721g = (RoboTextView) view.findViewById(R.id.food_price);
            this.f74717c = (AppCompatImageView) view.findViewById(R.id.plus_icon);
            this.f74718d = (AppCompatImageView) view.findViewById(R.id.minus_icon);
            this.l = (RoboTextView) view.findViewById(R.id.food_quantity);
            this.f74722h = (RoboTextView) view.findViewById(R.id.food_mrp_price);
            this.f74723i = (RoboTextView) view.findViewById(R.id.food_discount);
            this.n = view.findViewById(R.id.separator);
            if (p.this.f74698c) {
                view.setBackground(androidx.core.content.b.a(p.this.f74696a, net.one97.paytm.common.assets.R.drawable.fnb_item_bg));
            } else {
                this.n.setVisibility(0);
            }
        }
    }

    class b extends RecyclerView.v {
        public b(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener(p.this) {
                public final void onClick(View view) {
                    if (p.this.f74699d != null) {
                        p.this.f74699d.a(false, false);
                    }
                }
            });
        }
    }
}
