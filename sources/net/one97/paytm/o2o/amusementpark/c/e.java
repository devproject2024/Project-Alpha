package net.one97.paytm.o2o.amusementpark.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.a.h;
import net.one97.paytm.o2o.amusementpark.d.h;
import net.one97.paytm.o2o.amusementpark.d.i;
import net.one97.paytm.o2o.amusementpark.utils.d;
import net.one97.paytm.o2o.amusementpark.utils.l;

public class e extends h implements View.OnClickListener, h.a, h.b {

    /* renamed from: a  reason: collision with root package name */
    h.a f73549a;

    /* renamed from: b  reason: collision with root package name */
    private i.a f73550b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.o2o.amusementpark.a.h f73551c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJROfferCode> f73552d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f73553e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f73554f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f73555g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f73556h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f73557i;
    private RelativeLayout j;
    private int k;
    private int l;
    private int m;
    private View n;
    private View o;
    private ImageView p;

    public e() {
    }

    public e(i.a aVar) {
        this.f73550b = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.a aVar;
        this.n = layoutInflater.inflate(R.layout.park_offers_layout, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("from_vertical")) {
                this.m = arguments.getInt("from_vertical", -1);
            }
            if (this.m == 2) {
                this.l = arguments.getInt(CLPConstants.PRODUCT_ID, -1);
                h.a aVar2 = this.f73549a;
                if (aVar2 != null) {
                    aVar2.a((h.b) this);
                }
            }
        }
        View view = this.n;
        if (view != null) {
            this.o = view.findViewById(R.id.promo_code_screen_progressbar);
            this.n.findViewById(R.id.promo_view).requestFocus();
            if (this.m != 1) {
                this.n.findViewById(R.id.gift_card_promo_header).setVisibility(0);
            }
            this.f73553e = (ImageView) this.n.findViewById(R.id.promo_back_arrow);
            this.p = (ImageView) this.n.findViewById(R.id.promo_remove_image);
            this.f73554f = (RelativeLayout) this.n.findViewById(R.id.apply_btn_lyt);
            this.f73555g = (EditText) this.n.findViewById(R.id.edit_txt_promocode);
            this.f73555g.setText("");
            this.f73556h = (ImageView) this.n.findViewById(R.id.promo_applied_success_remove_image);
            this.f73557i = (RecyclerView) this.n.findViewById(R.id.offers_list);
            this.f73557i.setHasFixedSize(true);
            this.f73557i.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.f73557i.addItemDecoration(new l(getActivity()));
            this.j = (RelativeLayout) this.n.findViewById(R.id.promocode_lyt);
            this.f73553e.setOnClickListener(this);
            this.f73554f.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.f73556h.setOnClickListener(this);
            this.n.findViewById(R.id.no_offers_layout).setVisibility(8);
            this.f73555g.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.length() > 0) {
                        e.a(e.this, true);
                    } else {
                        e.a(e.this, false);
                    }
                }
            });
            this.f73557i.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action != 0 && action != 2) {
                        return false;
                    }
                    e.this.a();
                    return false;
                }
            });
        }
        this.f73555g.setText("");
        String str = a.a().getStringFromGTM("moviePromoSearchUrl") + this.l + a.a().getStringFromGTM("moviePromoSearchUrlExtension");
        int i2 = this.m;
        if (i2 == 1) {
            h.a aVar3 = this.f73549a;
            if (aVar3 != null) {
                aVar3.a(str);
            }
        } else if (i2 == 2 && (aVar = this.f73549a) != null) {
            aVar.a(str);
        }
        if (this.f73550b != null) {
            getActivity().getString(R.string.apply_promo_code);
        }
        return this.n;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.promo_back_arrow) {
            getActivity().onBackPressed();
        } else if (view.getId() == R.id.apply_btn_lyt) {
            a();
            a(this.f73555g.getText().toString());
        } else if (view.getId() == R.id.promo_remove_image) {
            this.f73555g.setText("");
        }
    }

    private void c() {
        getActivity().startActivityForResult(new Intent(getActivity(), a.a().getLoginActivity()), 258);
    }

    public final void a() {
        if (getActivity() != null) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(ArrayList<CJROfferCode> arrayList) {
        ArrayList<CJROfferCode> arrayList2;
        b();
        if (arrayList != null) {
            this.f73552d = arrayList;
            this.f73551c = new net.one97.paytm.o2o.amusementpark.a.h(getActivity(), this.f73552d, "", this);
            this.n.findViewById(R.id.choose_offer_header).setVisibility(0);
            this.f73557i.setAdapter(this.f73551c);
            this.k = b.f((Context) getActivity());
            this.f73554f.getLayoutParams().width = this.k * 5;
            this.j.getLayoutParams().height = (int) (((double) this.k) * 2.5d);
            if (this.f73551c == null || (arrayList2 = this.f73552d) == null || arrayList2.size() <= 0) {
                this.n.findViewById(R.id.choose_offer_header).setVisibility(8);
                this.n.findViewById(R.id.second_view_divider).setVisibility(8);
            } else {
                net.one97.paytm.o2o.amusementpark.a.h hVar = this.f73551c;
                hVar.f73153c = this.f73552d;
                hVar.f73152b = "";
                hVar.notifyDataSetChanged();
                this.f73551c.notifyDataSetChanged();
            }
            this.n.findViewById(R.id.no_offers_layout).setVisibility(8);
            return;
        }
        this.n.findViewById(R.id.no_offers_layout).setVisibility(0);
    }

    public final void a(String str) {
        if (d.a((Context) getActivity())) {
            int i2 = this.m;
            if (i2 == 1) {
                h.a aVar = this.f73549a;
                if (aVar != null) {
                    aVar.b(str);
                }
            } else if (i2 == 2) {
                h.a aVar2 = this.f73549a;
                if (aVar2 != null) {
                    aVar2.b(str);
                }
            } else if (i2 == 3) {
            }
        } else {
            c();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        getActivity();
        if (i3 == -1 && i2 == 258) {
            a(this.f73555g.getText().toString());
        }
    }

    public final void b() {
        View view = this.o;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onStop() {
        EditText editText = this.f73555g;
        if (editText != null) {
            editText.setText("");
        }
        super.onStop();
    }

    static /* synthetic */ void a(e eVar, boolean z) {
        if (z) {
            eVar.f73554f.setVisibility(0);
            eVar.p.setVisibility(0);
            return;
        }
        eVar.f73554f.setVisibility(8);
        eVar.p.setVisibility(8);
    }
}
