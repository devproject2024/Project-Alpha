package com.paytmmall.artifact.cart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.c.a;
import com.paytmmall.artifact.cart.d.b;
import com.paytmmall.artifact.cart.entity.WishList;
import net.one97.paytm.activity.PaytmActivity;

public class AJRShoppingCartActivity extends PaytmActivity implements a {

    /* renamed from: i  reason: collision with root package name */
    private static String f15501i = AJRShoppingCartActivity.class.getName();

    /* renamed from: a  reason: collision with root package name */
    a f15502a;

    /* renamed from: b  reason: collision with root package name */
    private b f15503b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f15504c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15505d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15506e;

    /* renamed from: f  reason: collision with root package name */
    private WishList f15507f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15508g;

    /* renamed from: h  reason: collision with root package name */
    private View f15509h = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mall_activity_cart_new_layout);
        findViewById(R.id.wishlist_fragment_container).setVisibility(0);
        getSupportFragmentManager().a().a(R.id.wishlist_fragment_container, new b(), "wishList_fragment").b();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 400) {
            if (this.f15503b == null) {
                this.f15503b = (b) getSupportFragmentManager().c("wishList_fragment");
            }
            a aVar = this.f15502a;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f15503b != null) {
                if (intent.hasExtra("applied_promo") && intent.getStringExtra("applied_promo") != null) {
                    b bVar = this.f15503b;
                    String stringExtra = intent.getStringExtra("applied_promo");
                    bVar.f15522b = stringExtra;
                    if (bVar.f15521a != null) {
                        bVar.f15521a.f15437c = stringExtra;
                    }
                }
                String str = null;
                if (intent.hasExtra("item_name") && intent.getStringExtra("item_name") != null) {
                    str = intent.getStringExtra("item_name");
                }
                if (intent.getBooleanExtra("is_updated", false)) {
                    b bVar2 = this.f15503b;
                    if (str != null) {
                        bVar2.a(str);
                    }
                    bVar2.a();
                }
                this.f15503b.a();
            }
        }
    }

    public final void a(int i2) {
        if (this.f15503b == null) {
            this.f15503b = (b) getSupportFragmentManager().c("wishList_fragment");
        }
        if (this.f15503b == null) {
            return;
        }
        if (i2 == 0) {
            this.f15504c.setText(R.string.empty_wish_list);
        } else if (i2 == 1) {
            this.f15504c.setText(String.format(getString(R.string.wishlist_count_single_item), new Object[]{Integer.valueOf(i2)}));
        } else {
            this.f15504c.setText(String.format(getString(R.string.wishlist_count), new Object[]{Integer.valueOf(i2)}));
        }
    }

    public final void a() {
        this.f15504c.setText(R.string.wish_list);
    }

    public final void a(WishList wishList) {
        if (this.f15505d) {
            if (this.f15503b == null) {
                this.f15503b = (b) getSupportFragmentManager().c("wishList_fragment");
            }
            if (!this.f15506e) {
                this.f15506e = true;
                if (wishList != null && wishList.getmProduct().size() <= 0) {
                    return;
                }
                return;
            }
            return;
        }
        this.f15507f = wishList;
    }

    public final void b() {
        this.f15505d = true;
        if (!this.f15508g) {
            this.f15508g = true;
        }
    }

    public void setHeaderView(View view) {
        this.f15509h = view;
        if (view != null) {
            this.f15504c = (TextView) view.findViewById(R.id.tv_cart_header);
            view.findViewById(R.id.back_key).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRShoppingCartActivity.this.a(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }
}
