package com.paytmmall.artifact.cart.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.t;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.activity.AJRSelectOfferActivity;
import com.paytmmall.artifact.cart.entity.WishListProduct;
import com.paytmmall.artifact.cart.entity.WishListTag;
import com.paytmmall.artifact.d.c;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.f;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b extends RecyclerView.a<C0209b> {

    /* renamed from: a  reason: collision with root package name */
    final Context f15435a;

    /* renamed from: b  reason: collision with root package name */
    public a f15436b;

    /* renamed from: c  reason: collision with root package name */
    public String f15437c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<WishListProduct> f15438d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final int f15439e = 3;

    /* renamed from: f  reason: collision with root package name */
    private final int f15440f = 2;

    /* renamed from: g  reason: collision with root package name */
    private final int f15441g = 1;

    /* renamed from: h  reason: collision with root package name */
    private final String f15442h = "OFFERS";

    /* renamed from: i  reason: collision with root package name */
    private final String f15443i = "OOS";
    private final String j = "PRICE-DROP";
    private int k;

    public interface a {
        void a(int i2, String str, int i3, String str2, String str3);

        void a(int i2, String str, String str2, String str3, boolean z);

        void a(String str, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        boolean z;
        C0209b bVar = (C0209b) vVar;
        final WishListProduct wishListProduct = this.f15438d.get(i2);
        if (!TextUtils.isEmpty(wishListProduct.getName())) {
            bVar.f15477f.setText(wishListProduct.getName());
        }
        if (URLUtil.isValidUrl(wishListProduct.getImageUrl())) {
            w.a().a(wishListProduct.getImageUrl()).a(bVar.f15472a, (e) null);
        }
        if (!TextUtils.isEmpty(wishListProduct.getBrand())) {
            bVar.f15473b.setText(Html.fromHtml(this.f15435a.getString(R.string.by, new Object[]{wishListProduct.getBrand()})));
        }
        if (wishListProduct.getPrice().equalsIgnoreCase(wishListProduct.getMrp())) {
            bVar.f15475d.setText(this.f15435a.getString(R.string.rs) + c.a(wishListProduct.getPrice()));
            bVar.f15476e.setVisibility(8);
        } else {
            bVar.f15475d.setText(this.f15435a.getString(R.string.rs) + " " + c.a(wishListProduct.getPrice()));
            bVar.f15476e.setText(this.f15435a.getString(R.string.rs) + " " + c.a(wishListProduct.getMrp()));
            bVar.f15476e.setVisibility(0);
        }
        bVar.f15474c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b bVar = b.this;
                WishListProduct wishListProduct = wishListProduct;
                int i2 = i2;
                if (Build.VERSION.SDK_INT >= 11) {
                    PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                    popupMenu.getMenu().add(0, 1, 0, bVar.f15435a.getString(R.string.move_to_bag));
                    popupMenu.getMenu().add(0, 2, 0, bVar.f15435a.getString(R.string.share));
                    popupMenu.getMenu().add(0, 3, 0, bVar.f15435a.getString(R.string.remove_wishlist_item));
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(view, wishListProduct, i2, popupMenu) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ View f15462a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ WishListProduct f15463b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ int f15464c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ PopupMenu f15465d;

                        {
                            this.f15462a = r2;
                            this.f15463b = r3;
                            this.f15464c = r4;
                            this.f15465d = r5;
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            b.a(b.this, this.f15462a.getContext(), this.f15463b, this.f15464c, menuItem.getItemId());
                            this.f15465d.dismiss();
                            return true;
                        }
                    });
                    return;
                }
                t tVar = new t(view.getContext(), view);
                tVar.f1796a.add(0, 1, 0, bVar.f15435a.getString(R.string.move_to_bag));
                tVar.f1796a.add(0, 2, 0, bVar.f15435a.getString(R.string.share));
                tVar.f1796a.add(0, 3, 0, bVar.f15435a.getString(R.string.remove_wishlist_item));
                tVar.f1797b.a();
                tVar.f1798c = new t.b(view, wishListProduct, i2, tVar) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ View f15467a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ WishListProduct f15468b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ int f15469c;

                    /* renamed from: d  reason: collision with root package name */
                    final /* synthetic */ t f15470d;

                    {
                        this.f15467a = r2;
                        this.f15468b = r3;
                        this.f15469c = r4;
                        this.f15470d = r5;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        b.a(b.this, this.f15467a.getContext(), this.f15468b, this.f15469c, menuItem.getItemId());
                        this.f15470d.f1797b.d();
                        return true;
                    }
                };
            }
        });
        bVar.f15479h.setVisibility(8);
        ArrayList<WishListTag> arrayList = wishListProduct.getmTagList();
        if (!arrayList.isEmpty()) {
            Iterator<WishListTag> it2 = arrayList.iterator();
            z = false;
            boolean z2 = false;
            final boolean z3 = false;
            while (it2.hasNext()) {
                WishListTag next = it2.next();
                if (next.getName().equalsIgnoreCase("OFFERS")) {
                    bVar.f15478g.setText(next.getmDisplayName());
                    bVar.f15479h.setVisibility(0);
                    z3 = true;
                }
                if (next.getName().equalsIgnoreCase("OOS") && next.getmDisplayName() != null && !next.getmDisplayName().equalsIgnoreCase("Out of Stock")) {
                    bVar.j.setText(next.getmDisplayName());
                    z = true;
                }
                if (next.getName().equalsIgnoreCase("PRICE-DROP")) {
                    String str = next.getmDisplayName();
                    if (str.contains(AppUtility.CENTER_DOT)) {
                        int indexOf = str.indexOf(AppUtility.CENTER_DOT);
                        if ((str.length() - 1) - indexOf >= 2) {
                            str = str.substring(0, indexOf + 2 + 1);
                        }
                    }
                    bVar.f15480i.setText(str);
                    z2 = true;
                }
            }
            if (z) {
                bVar.j.setVisibility(0);
            } else {
                bVar.j.setVisibility(8);
            }
            if (z2) {
                bVar.n.setVisibility(0);
            } else {
                bVar.n.setVisibility(8);
            }
            if (z3) {
                bVar.f15479h.setVisibility(0);
                bVar.f15479h.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        try {
                            new HashMap();
                        } catch (Exception unused) {
                        }
                        if (wishListProduct.getProductType() == 2) {
                            b.this.f15436b.a(i2, wishListProduct.getUrl(), wishListProduct.getProductId(), wishListProduct.getName(), true);
                            return;
                        }
                        b bVar = b.this;
                        Context context = view.getContext();
                        String offerUrl = wishListProduct.getOfferUrl();
                        WishListProduct wishListProduct = wishListProduct;
                        boolean z = z3;
                        int i2 = i2;
                        Intent intent = new Intent(context, AJRSelectOfferActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("offers_url", offerUrl);
                        bundle.putSerializable("wish_list_item", wishListProduct);
                        bundle.putSerializable(CLPConstants.PRODUCT_ID, wishListProduct.getProductId());
                        bundle.putSerializable("item_id", wishListProduct.getmItemId());
                        bundle.putSerializable("is_apply_promo", Boolean.TRUE);
                        bundle.putSerializable(f.f15705c, Boolean.FALSE);
                        bundle.putSerializable(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2));
                        if (wishListProduct.isInStock() || !z) {
                            bundle.putSerializable("is_in_stock", Boolean.TRUE);
                        }
                        if (wishListProduct.getProductType() == 2) {
                            bundle.putSerializable("is_complex_product", Boolean.TRUE);
                        }
                        if (bVar.f15437c != null) {
                            bundle.putString("applied_promo", bVar.f15437c);
                        }
                        intent.putExtras(bundle);
                        ((Activity) context).startActivityForResult(intent, 400);
                    }
                });
            } else {
                bVar.f15479h.setVisibility(8);
            }
        } else {
            z = false;
        }
        if (!(wishListProduct.getProductType() == 2 && !wishListProduct.getAttributeNames().isEmpty()) || !z) {
            bVar.k.setVisibility(8);
        } else {
            bVar.k.removeAllViews();
            for (String str2 : wishListProduct.getAttributeNames().keySet()) {
                TextView textView = (TextView) LayoutInflater.from(bVar.k.getContext()).inflate(R.layout.mall_roboto_textview, (ViewGroup) null, false);
                textView.setText(Html.fromHtml("<u>Select " + str2 + "</u>"));
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (!b.this.f15438d.isEmpty()) {
                            b.this.f15436b.a(i2, wishListProduct.getUrl(), wishListProduct.getProductId(), (String) null, false);
                        }
                    }
                });
                bVar.k.addView(textView);
            }
            bVar.k.setVisibility(0);
        }
        if (wishListProduct.getProductType() != 1 || wishListProduct.getAttributeSeletedValues().isEmpty()) {
            bVar.l.setVisibility(8);
        } else {
            bVar.l.removeAllViews();
            int i3 = -1;
            int i4 = 0;
            for (Map.Entry next2 : wishListProduct.getAttributeSeletedValues().entrySet()) {
                String valueOf = String.valueOf(next2.getKey());
                String valueOf2 = String.valueOf(next2.getValue());
                int i5 = i3 == -1 ? 25 : i3;
                String str3 = valueOf + " : " + valueOf2;
                if (str3.length() > i5) {
                    str3 = str3.substring(0, i5) + AppConstants.DOTS;
                }
                if (i4 == 0) {
                    i3 = str3.length();
                }
                TextView textView2 = (TextView) LayoutInflater.from(bVar.k.getContext()).inflate(R.layout.mall_roboto_textview_wlist_size, (ViewGroup) null, false);
                textView2.setText(str3);
                bVar.l.addView(textView2);
                i4++;
            }
            bVar.l.setVisibility(0);
        }
        bVar.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.paytmmall.a.a.b(b.this.f15438d.get(i2).getUrl(), "product");
            }
        });
        bVar.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, view.getContext(), wishListProduct, i2, 3);
            }
        });
        bVar.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, view.getContext(), wishListProduct, i2, 1);
            }
        });
    }

    public b(Context context) {
        this.f15435a = context;
    }

    public final void a(int i2) {
        if (i2 >= 0 && !this.f15438d.isEmpty() && this.f15438d.size() > i2) {
            this.f15438d.remove(i2);
            notifyDataSetChanged();
        }
    }

    public final int getItemCount() {
        return this.f15438d.size();
    }

    /* renamed from: com.paytmmall.artifact.cart.a.b$b  reason: collision with other inner class name */
    static class C0209b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f15472a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f15473b;

        /* renamed from: c  reason: collision with root package name */
        final View f15474c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f15475d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f15476e;

        /* renamed from: f  reason: collision with root package name */
        final TextView f15477f;

        /* renamed from: g  reason: collision with root package name */
        final TextView f15478g;

        /* renamed from: h  reason: collision with root package name */
        final View f15479h;

        /* renamed from: i  reason: collision with root package name */
        final TextView f15480i;
        final TextView j;
        final LinearLayout k;
        final LinearLayout l;
        final View m;
        LinearLayout n;
        final TextView o;
        final TextView p;

        public C0209b(View view) {
            super(view);
            this.f15477f = (TextView) view.findViewById(R.id.wish_list_product_name);
            this.f15473b = (TextView) view.findViewById(R.id.wish_list_product_seller_name_by);
            this.f15472a = (ImageView) view.findViewById(R.id.wishlist_item_image);
            this.f15474c = view.findViewById(R.id.wish_list_remove_menu);
            this.f15475d = (TextView) view.findViewById(R.id.wishlist_item_discount);
            this.f15476e = (TextView) view.findViewById(R.id.wishlist_item_original_price);
            TextView textView = this.f15476e;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            this.f15478g = (TextView) view.findViewById(R.id.wishlist_new_offer);
            this.f15479h = view.findViewById(R.id.wishlist_offer_lyt);
            this.f15480i = (TextView) view.findViewById(R.id.price_drop);
            this.j = (TextView) view.findViewById(R.id.wishlist_out_of_stock);
            this.k = (LinearLayout) view.findViewById(R.id.select_attributes);
            this.l = (LinearLayout) view.findViewById(R.id.selected_attributes);
            this.m = view.findViewById(R.id.wishlist_product_detail_lyt);
            this.n = (LinearLayout) view.findViewById(R.id.price_drop_layout);
            this.o = (TextView) view.findViewById(R.id.wishlist_remove_text);
            this.p = (TextView) view.findViewById(R.id.wishlist_move_to_bag);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0209b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mall_wish_list_product_item, viewGroup, false));
    }

    static /* synthetic */ void a(b bVar, Context context, WishListProduct wishListProduct, int i2, int i3) {
        String str;
        if (i3 == 1) {
            bVar.k = i2;
            if (wishListProduct.getProductType() == 1) {
                bVar.a(i2);
                bVar.f15436b.a(wishListProduct.getProductId(), bVar.getItemCount());
            }
            bVar.f15436b.a(i2, wishListProduct.getProductId(), wishListProduct.getProductType(), wishListProduct.getUrl(), wishListProduct.getName());
        } else if (i3 == 2) {
            String name = wishListProduct.getName();
            String shareUrl = wishListProduct.getShareUrl();
            if (!TextUtils.isEmpty(shareUrl)) {
                try {
                    if (!TextUtils.isEmpty(d.c(context))) {
                        str = String.format(bVar.f15435a.getString(R.string.wishlist_share_msg), new Object[]{d.c(context), name, shareUrl.toString()});
                    } else {
                        str = String.format(bVar.f15435a.getString(R.string.wishlist_share_msg_title), new Object[]{name, shareUrl.toString()});
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.SUBJECT", "Paytm");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    context.startActivity(Intent.createChooser(intent, context.getString(R.string.share_via)));
                    d.a("don", "url ".concat(String.valueOf(shareUrl)));
                } catch (Exception unused) {
                }
            }
        } else if (i3 == 3) {
            bVar.a(i2);
            bVar.f15436b.a(wishListProduct.getProductId(), bVar.getItemCount());
        }
    }
}
