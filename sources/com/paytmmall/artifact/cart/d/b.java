package com.paytmmall.artifact.cart.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.a.b;
import com.paytmmall.artifact.cart.activity.AJRSelectOfferActivity;
import com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity;
import com.paytmmall.artifact.cart.c.a;
import com.paytmmall.artifact.cart.entity.CJRCart;
import com.paytmmall.artifact.cart.entity.CJRDetailProduct;
import com.paytmmall.artifact.cart.entity.CJRFilterItem;
import com.paytmmall.artifact.cart.entity.CJRFilterValue;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.cart.entity.StringModel;
import com.paytmmall.artifact.cart.entity.WishList;
import com.paytmmall.artifact.cart.entity.WishListProduct;
import com.paytmmall.artifact.cart.entity.WishListTag;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.f;
import com.paytmmall.artifact.d.g;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.n;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.v;
import com.paytmmall.artifact.widget.CJRFlowLayout;
import com.paytmmall.b.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.i.h;
import org.json.JSONObject;

public class b extends h implements View.OnClickListener, b.a {

    /* renamed from: a  reason: collision with root package name */
    public com.paytmmall.artifact.cart.a.b f15521a;

    /* renamed from: b  reason: collision with root package name */
    public String f15522b;

    /* renamed from: c  reason: collision with root package name */
    private String f15523c = "FJRWishListFragment";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Activity f15524d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f15525e;

    /* renamed from: f  reason: collision with root package name */
    private View f15526f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f15527g;

    /* renamed from: h  reason: collision with root package name */
    private View f15528h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15529i;
    private View j;
    /* access modifiers changed from: private */
    public a k;
    private View l;
    private Button m;
    private Button n;
    private RelativeLayout o;
    /* access modifiers changed from: private */
    public boolean p;
    private CJRCart q;
    /* access modifiers changed from: private */
    public boolean r;
    /* access modifiers changed from: private */
    public WishList s;
    /* access modifiers changed from: private */
    public boolean t;

    static /* synthetic */ void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = layoutInflater.inflate(R.layout.mall_wishlist_fragment, (ViewGroup) null);
        View view = this.j;
        if (view != null) {
            View findViewById = view.findViewById(R.id.top_bar);
            if (getActivity() instanceof AJRShoppingCartActivity) {
                ((AJRShoppingCartActivity) getActivity()).setHeaderView(findViewById);
            }
        }
        if (!(getArguments() == null || getArguments().getSerializable("cart") == null)) {
            this.q = (CJRCart) getArguments().getSerializable("cart");
        }
        this.o = (RelativeLayout) this.j.findViewById(R.id.wish_list_loading_progress_bar);
        this.f15526f = this.j.findViewById(R.id.progress_bar);
        this.f15525e = (RecyclerView) this.j.findViewById(R.id.wish_list_recyclerview);
        this.f15525e.setLayoutManager(new LinearLayoutManager(this.f15524d, 1, false));
        this.f15521a = new com.paytmmall.artifact.cart.a.b(getActivity());
        this.f15521a.f15436b = this;
        this.j.findViewById(R.id.shop_now_buton).setOnClickListener(this);
        this.f15525e.setAdapter(this.f15521a);
        this.f15528h = this.j.findViewById(R.id.lyt_filter_overlay);
        this.f15527g = this.j.findViewById(R.id.lyt_filter_overlay_container);
        this.l = this.j.findViewById(R.id.wishlist_sign_out_screen);
        ((TextView) this.j.findViewById(R.id.wish_list_info_text1)).setText(Html.fromHtml(this.f15524d.getString(R.string.wish_list_info_text1)));
        ((TextView) this.j.findViewById(R.id.wish_list_info_text2)).setText(Html.fromHtml(this.f15524d.getString(R.string.wish_list_info_text2)));
        ((TextView) this.j.findViewById(R.id.wish_list_info_text3)).setText(Html.fromHtml(this.f15524d.getString(R.string.wish_list_info_text3)));
        ((TextView) this.j.findViewById(R.id.wish_list_info_text4)).setText(Html.fromHtml(this.f15524d.getString(R.string.wish_list_info_text4)));
        this.m = (Button) this.j.findViewById(R.id.wishist_button_login);
        this.n = (Button) this.j.findViewById(R.id.wishlist_button_sign_up);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.f15527g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this);
            }
        });
        if (d.d((Context) this.f15524d)) {
            f();
        }
        this.k.b();
        a();
        setRetainInstance(true);
        return this.j;
    }

    public void onResume() {
        super.onResume();
        if (this.k == null) {
            this.k = (a) getActivity();
        }
        this.k.a();
    }

    public final void a() {
        Activity activity = this.f15524d;
        if (activity != null) {
            if (d.d((Context) activity)) {
                if (this.p) {
                    d();
                } else {
                    c();
                }
                this.k.a();
                if (d.a((Context) this.f15524d)) {
                    c.a(this.f15524d, new com.paytmmall.b.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (!b.this.f15524d.isFinishing()) {
                                WishList wishList = (WishList) iJRPaytmDataModel;
                                b.d(b.this);
                                b.e(b.this);
                                WishList unused = b.this.s = wishList;
                                b bVar = b.this;
                                boolean unused2 = bVar.t;
                                b.b(bVar, wishList);
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            b.d(b.this);
                            b.b();
                        }
                    });
                } else if (getActivity() != null) {
                    n.a(getActivity());
                }
            } else {
                g();
            }
        }
    }

    private void c() {
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
            this.o.setVisibility(0);
        }
        View view = this.l;
        if (view != null && view.getVisibility() == 0) {
            this.l.setVisibility(8);
        }
        View view2 = this.j;
        if (view2 != null && this.p) {
            view2.findViewById(R.id.empty_wishlist_lyt).setVisibility(8);
        }
    }

    public final void a(final int i2, String str, final String str2, final String str3, boolean z) {
        this.r = z;
        d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (d.a((Context) this.f15524d)) {
            Activity activity = this.f15524d;
            AnonymousClass6 r6 = new com.paytmmall.b.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (!b.this.f15524d.isFinishing()) {
                        b.e(b.this);
                        CJRDetailProduct cJRDetailProduct = (CJRDetailProduct) iJRPaytmDataModel;
                        if (!cJRDetailProduct.getFilterList().isEmpty()) {
                            b.a(b.this, i2, (ArrayList) cJRDetailProduct.getFilterList(), str2, str3);
                        }
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    b.b();
                }
            };
            if (str != null) {
                String a2 = d.a((Context) activity, str);
                d.a("don", " product detail call" + a2.toString());
                com.paytmmall.b.a.a(activity, a.C0216a.GET, a2, (String) null, (Map<String, String>) null, new CJRDetailProduct(), r6);
                return;
            }
            return;
        }
        n.a(getActivity());
    }

    public final void a(int i2, String str, int i3, String str2, final String str3) {
        if (i3 == 2) {
            this.f15529i = true;
            a(i2, str2, str, str3, false);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a2 = d.a((HashMap<String, String>) hashMap, (Context) getActivity());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "update");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CLPConstants.PRODUCT_ID, str);
            jSONObject2.put("quantity", 1);
            jSONObject.put("object", jSONObject2);
        } catch (Exception e2) {
            if (t.c().g()) {
                q.c(e2.getMessage());
            }
        }
        com.paytmmall.artifact.common.a.a.a();
        String a3 = com.paytmmall.artifact.common.a.a.a("cartv2", (String) null);
        if (!TextUtils.isEmpty(a3)) {
            String str4 = a3 + "/" + l.b();
            d.a("don", "before adding url ".concat(String.valueOf(str4)));
            String str5 = str4 + g.a((Context) this.f15524d);
            d.a("don", "after adding url ".concat(String.valueOf(str5)));
            d();
            if (d.a((Context) this.f15524d)) {
                com.paytmmall.b.a.a(getContext(), a.C0216a.POST, str5, jSONObject.toString(), a2, new StringModel(), new com.paytmmall.b.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (!b.this.f15524d.isFinishing()) {
                            String data = ((StringModel) iJRPaytmDataModel).getData();
                            b.e(b.this);
                            if (!TextUtils.isEmpty(data)) {
                                if (b.this.k != null) {
                                    com.paytmmall.artifact.cart.c.a unused = b.this.k;
                                    com.paytmmall.artifact.cart.c.a unused2 = b.this.k;
                                    b.this.k.a(b.this.f15521a.getItemCount());
                                }
                                v a2 = v.a();
                                a2.a((Context) b.this.f15524d, data);
                                CJRShoppingCart cJRShoppingCart = a2.f15746a;
                                if (!(cJRShoppingCart == null || cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getCartItems().isEmpty())) {
                                    l.a(cJRShoppingCart.getCart().getCartItems().size());
                                    l.b(cJRShoppingCart.getCart().getFinalPrice());
                                }
                                b.this.a(str3);
                            }
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        b.b();
                    }
                });
            } else if (getActivity() != null) {
                n.a(getActivity());
            }
        }
    }

    public final void a(final String str, final int i2) {
        if (i2 == 0) {
            e();
        }
        c.a(this.f15524d, new com.paytmmall.b.b() {
            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                a.c(b.this.f15524d, str);
                if (b.this.k != null) {
                    b.this.k.a(i2);
                }
            }
        }, str);
    }

    public final void a(String str) {
        Activity activity = this.f15524d;
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(String.format(getString(R.string.wishlist_moved_to_cart), new Object[]{str}));
            builder.setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }
    }

    private void a(int i2, String str, String str2, CJRFlowLayout cJRFlowLayout, CJRFilterItem cJRFilterItem, TextView textView, TextView textView2, RelativeLayout relativeLayout, CJRFlowLayout cJRFlowLayout2) {
        cJRFlowLayout.removeAllViews();
        final TextView textView3 = textView2;
        final CJRFlowLayout cJRFlowLayout3 = cJRFlowLayout2;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (cJRFlowLayout3.getVisibility() == 8) {
                    cJRFlowLayout3.setVisibility(0);
                    textView3.setVisibility(8);
                }
            }
        });
        textView.setText(cJRFilterItem.getDisplayValue());
        Iterator<CJRFilterValue> it2 = cJRFilterItem.getFilterValues().iterator();
        while (it2.hasNext()) {
            final CJRFilterValue next = it2.next();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f15524d).inflate(R.layout.mall_layout_pdp_filter_option_item, (ViewGroup) null, false);
            final LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.lyt_filter_option_btn_container);
            ((TextView) linearLayout.findViewById(R.id.txt_filter_name)).setText(next.getName());
            final CJRFlowLayout cJRFlowLayout4 = cJRFlowLayout;
            final TextView textView4 = textView2;
            final int i3 = i2;
            final String str3 = str;
            final String str4 = str2;
            linearLayout.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!linearLayout2.isSelected()) {
                        for (int i2 = 0; i2 < cJRFlowLayout4.getChildCount(); i2++) {
                            ((LinearLayout) cJRFlowLayout4.getChildAt(i2)).findViewById(R.id.lyt_filter_option_btn_container).setSelected(false);
                        }
                        textView4.setText(next.getName());
                        linearLayout2.setSelected(true);
                        textView4.setVisibility(0);
                        cJRFlowLayout4.setVisibility(8);
                        b.a(b.this, i3, str3, str4, next.getProductId());
                        b.a(b.this);
                    }
                }
            });
            cJRFlowLayout.addView(linearLayout);
        }
    }

    private void d() {
        View view = this.f15526f;
        if (view != null && view.getVisibility() == 8) {
            this.f15526f.setVisibility(0);
        }
        View view2 = this.l;
        if (view2 != null && view2.getVisibility() == 0) {
            this.l.setVisibility(8);
        }
    }

    private void e() {
        this.j.findViewById(R.id.empty_wishlist_lyt).setVisibility(0);
        this.f15525e.setVisibility(8);
        this.l.setVisibility(8);
    }

    private void f() {
        this.j.findViewById(R.id.empty_wishlist_lyt).setVisibility(8);
        this.f15525e.setVisibility(0);
        this.l.setVisibility(8);
    }

    private void g() {
        this.j.findViewById(R.id.empty_wishlist_lyt).setVisibility(8);
        this.f15525e.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void onStart() {
        super.onStart();
        com.paytmmall.artifact.cart.a.b bVar = this.f15521a;
        if (bVar != null) {
            bVar.f15436b = this;
        }
    }

    public void onStop() {
        super.onStop();
        com.paytmmall.artifact.cart.a.b bVar = this.f15521a;
        if (bVar != null) {
            bVar.f15436b = this;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f15524d = activity;
        this.k = (com.paytmmall.artifact.cart.c.a) activity;
    }

    public void onDetach() {
        super.onDetach();
        this.k = null;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.shop_now_buton) {
            Intent intent = new Intent();
            intent.putExtra("resultant fragment position", 0);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, d.l());
            t.e().resolveIntentByMainApp(this.f15524d, intent, "mainActivity", Integer.MIN_VALUE);
        } else if (id == R.id.wishist_button_login) {
            a(Boolean.FALSE);
        } else if (id == R.id.wishlist_button_sign_up) {
            a(Boolean.TRUE);
        }
    }

    private void a(Boolean bool) {
        if (this.f15524d != null) {
            Intent intent = new Intent();
            intent.putExtra("launchSignUp", bool);
            intent.putExtra("set_result_required", true);
            t.e().resolveIntentByMainApp(this.f15524d, intent, "authActivity", 100);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        getActivity();
        if (i3 == -1 && i2 == 100) {
            this.l.setVisibility(8);
            a();
        }
    }

    static /* synthetic */ void a(b bVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(bVar.f15524d, R.anim.mall_bottom_bar_slide_down);
        bVar.f15528h.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                b.this.f15527g.setVisibility(8);
            }
        });
    }

    static /* synthetic */ void d(b bVar) {
        RelativeLayout relativeLayout = bVar.o;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            bVar.o.setVisibility(8);
        }
    }

    static /* synthetic */ void e(b bVar) {
        View view = bVar.f15526f;
        if (view != null && view.getVisibility() == 0) {
            bVar.f15526f.setVisibility(8);
        }
    }

    static /* synthetic */ void b(b bVar, WishList wishList) {
        int i2 = 0;
        if (wishList == null || wishList.getmProduct() == null || wishList.getmProduct().isEmpty()) {
            bVar.k.a(0);
            bVar.e();
            return;
        }
        bVar.k.a(wishList.getmProduct().size());
        bVar.f();
        bVar.k.a(bVar.s);
        com.paytmmall.artifact.cart.a.b bVar2 = bVar.f15521a;
        bVar2.f15438d = wishList.getmProduct();
        bVar2.notifyDataSetChanged();
        com.paytmmall.artifact.cart.c.a aVar = bVar.k;
        com.paytmmall.artifact.cart.a.b bVar3 = bVar.f15521a;
        if (bVar3 != null) {
            i2 = bVar3.getItemCount();
        }
        aVar.a(i2);
    }

    static /* synthetic */ void a(b bVar, int i2, ArrayList arrayList, String str, String str2) {
        b bVar2 = bVar;
        ArrayList arrayList2 = arrayList;
        bVar2.f15527g.setVisibility(0);
        bVar2.f15528h.startAnimation(AnimationUtils.loadAnimation(bVar2.f15524d, R.anim.mall_bottom_bar_slide_up));
        RelativeLayout relativeLayout = (RelativeLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_overlay_item_1);
        RelativeLayout relativeLayout2 = (RelativeLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_overlay_item_2);
        relativeLayout.setVisibility(8);
        relativeLayout2.setVisibility(8);
        if (arrayList2 != null && arrayList.size() > 0) {
            if (arrayList2.get(0) != null) {
                relativeLayout.setVisibility(0);
                bVar.a(i2, str2, str, (CJRFlowLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_type_1_options_container), (CJRFilterItem) arrayList2.get(0), (TextView) bVar2.f15528h.findViewById(R.id.filter_type_1), (TextView) bVar2.f15528h.findViewById(R.id.filter_type_1_expand), (RelativeLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_overlay_item_1_header), (CJRFlowLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_type_1_options_container));
            }
            if (arrayList.size() <= 1 || arrayList2.get(1) == null) {
                RelativeLayout relativeLayout3 = (RelativeLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_overlay_item_1_header);
                if (relativeLayout3 != null) {
                    relativeLayout3.performClick();
                    return;
                }
                return;
            }
            relativeLayout2.setVisibility(0);
            bVar.a(i2, str2, str, (CJRFlowLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_type_2_options_container), (CJRFilterItem) arrayList2.get(1), (TextView) bVar2.f15528h.findViewById(R.id.filter_type_2), (TextView) bVar2.f15528h.findViewById(R.id.filter_type_2_expand), (RelativeLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_overlay_item_2_header), (CJRFlowLayout) bVar2.f15528h.findViewById(R.id.lyt_filter_type_2_options_container));
        }
    }

    static /* synthetic */ void a(b bVar, final int i2, String str, String str2, final String str3) {
        bVar.d();
        if (bVar.f15529i) {
            bVar.a(i2, str3, 1, (String) null, str);
            bVar.f15521a.a(i2);
            bVar.a(str2, bVar.f15521a.getItemCount());
            bVar.f15529i = false;
            return;
        }
        c.a(bVar.f15524d, new com.paytmmall.b.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (!b.this.f15524d.isFinishing()) {
                    boolean unused = b.this.p = true;
                    c.a(b.this.f15524d, new com.paytmmall.b.b(str3, i2) {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            String str;
                            if (b.this.f15524d != null && !b.this.f15524d.isFinishing()) {
                                WishList wishList = (WishList) iJRPaytmDataModel;
                                b.d(b.this);
                                b.e(b.this);
                                if (wishList != null && wishList.getmProduct() != null && wishList.getmProduct().size() > 0) {
                                    Iterator<WishListProduct> it2 = wishList.getmProduct().iterator();
                                    while (it2.hasNext()) {
                                        WishListProduct next = it2.next();
                                        if (!(next.getProductId() == null || (str = r4) == null || !str.equals(next.getProductId()))) {
                                            Iterator<WishListTag> it3 = next.getmTagList().iterator();
                                            boolean z = false;
                                            while (it3.hasNext()) {
                                                if (it3.next().getName().equalsIgnoreCase("OOS")) {
                                                    z = true;
                                                }
                                            }
                                            if (b.this.r) {
                                                b bVar = b.this;
                                                b.a(bVar, bVar.getActivity(), next.getOfferUrl(), next, z, r3);
                                            } else {
                                                b.this.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            b.d(b.this);
                        }
                    });
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                b.b();
            }
        }, str3, str2);
    }

    static /* synthetic */ void a(b bVar, Context context, String str, WishListProduct wishListProduct, boolean z, int i2) {
        new HashMap();
        Intent intent = new Intent(context, AJRSelectOfferActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("offers_url", str);
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
        String str2 = bVar.f15522b;
        if (str2 != null) {
            bundle.putString("applied_promo", str2);
        }
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, 400);
    }
}
