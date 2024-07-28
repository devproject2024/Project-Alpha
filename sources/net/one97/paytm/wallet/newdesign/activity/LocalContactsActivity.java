package net.one97.paytm.wallet.newdesign.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.common.FastScrollerLinearLayout;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.contacts.b;
import net.one97.paytm.contacts.c;
import net.one97.paytm.contacts.d;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.f.f;
import net.one97.paytm.utils.ae;
import net.one97.paytm.utils.x;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.l;
import net.one97.paytm.wallet.entity.CustomEditText;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;

public class LocalContactsActivity extends BaseActivity implements FastScrollerLinearLayout.a, f, x.d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<IJRDataModel> f70502a;

    /* renamed from: b  reason: collision with root package name */
    private final int f70503b = 201;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f70504c;

    /* renamed from: e  reason: collision with root package name */
    private Button f70505e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public d f70506f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CustomEditText f70507g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f70508h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ImageView f70509i;
    private RelativeLayout j;
    /* access modifiers changed from: private */
    public FastScrollerLinearLayout k;
    private p l;
    private RecyclerView.LayoutManager m;
    /* access modifiers changed from: private */
    public TextView n;
    private final float o = 0.2f;
    private RelativeLayout p;
    private RelativeLayout q;
    private boolean r;
    private TextView s;
    private TextView t;
    /* access modifiers changed from: private */
    public ArrayList<b> u;
    private LottieAnimationView v;
    private LottieAnimationView w;
    private TextWatcher x = new TextWatcher() {

        /* renamed from: a  reason: collision with root package name */
        int f70512a = 0;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            String str;
            if (editable.toString().length() == 1 && editable.toString().charAt(0) == ' ') {
                editable.clear();
            }
            String trim = editable.toString().trim();
            String replace = trim.replace(" ", "");
            if (!(replace.length() <= 10 || replace.length() == this.f70512a + 1 || replace.length() == this.f70512a - 1)) {
                x.a aVar = x.f69805a;
                k.c(replace, "query");
                if (replace.length() >= 15 && kotlin.m.p.b(replace, "0091-", false)) {
                    String substring = replace.substring(5);
                    k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                    str = x.a.b(substring);
                } else if (replace.length() >= 14 && (kotlin.m.p.b(replace, "+91-", false) || kotlin.m.p.b(replace, "+91.", false) || kotlin.m.p.b(replace, "091-", false) || kotlin.m.p.b(replace, "+91/", false))) {
                    String substring2 = replace.substring(4);
                    k.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                    str = x.a.b(substring2);
                } else if (replace.length() >= 13 && (kotlin.m.p.b(replace, "+91", false) || kotlin.m.p.b(replace, "091", false) || kotlin.m.p.b(replace, "91-", false) || kotlin.m.p.b(replace, "91/", false))) {
                    String substring3 = replace.substring(3);
                    k.a((Object) substring3, "(this as java.lang.String).substring(startIndex)");
                    str = x.a.b(substring3);
                } else if (replace.length() >= 12 && (kotlin.m.p.b(replace, "91", false) || kotlin.m.p.b(replace, "0-", false))) {
                    String substring4 = replace.substring(2);
                    k.a((Object) substring4, "(this as java.lang.String).substring(startIndex)");
                    str = x.a.b(substring4);
                } else if (replace.length() < 11 || !kotlin.m.p.b(replace, "0", false)) {
                    str = x.a.b(replace);
                } else {
                    String substring5 = replace.substring(1);
                    k.a((Object) substring5, "(this as java.lang.String).substring(startIndex)");
                    str = x.a.b(substring5);
                }
                if (!str.equals(trim) && l.a((CharSequence) str)) {
                    LocalContactsActivity.this.f70507g.setText(str);
                    trim = str;
                }
            }
            this.f70512a = trim.length();
            if (l.a((CharSequence) trim)) {
                LocalContactsActivity.this.f70507g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
            } else {
                LocalContactsActivity.this.f70507g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(35)});
            }
            if (trim.equals("")) {
                LocalContactsActivity.this.k.setVisibility(0);
                LocalContactsActivity.this.f70509i.setVisibility(8);
            } else {
                LocalContactsActivity.this.k.setVisibility(8);
                LocalContactsActivity.this.f70509i.setVisibility(0);
            }
            if (LocalContactsActivity.this.n.getVisibility() == 0) {
                LocalContactsActivity.this.n.setVisibility(8);
            }
            if (LocalContactsActivity.this.f70506f != null) {
                LocalContactsActivity.this.f70506f.a(trim);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.scanner_local_contact_list_layout);
        this.f70504c = (RecyclerView) findViewById(R.id.contacts_list);
        this.f70507g = (CustomEditText) findViewById(R.id.filter_contacts_et);
        this.f70507g.addTextChangedListener(this.x);
        this.f70508h = (ImageView) findViewById(R.id.back_arrow);
        this.j = (RelativeLayout) findViewById(R.id.contact_not_found);
        this.k = (FastScrollerLinearLayout) findViewById(R.id.fast_scroller);
        this.f70504c.setHasFixedSize(true);
        this.n = (TextView) findViewById(R.id.enter_number_tv);
        this.f70509i = (ImageView) findViewById(R.id.iv_clear);
        this.f70505e = (Button) findViewById(R.id.proceed_btn);
        this.p = (RelativeLayout) findViewById(R.id.proceed_but_rl);
        this.q = (RelativeLayout) findViewById(R.id.go_to_settings);
        this.s = (TextView) findViewById(R.id.contact_not_found_tv);
        this.t = (TextView) findViewById(R.id.go_to_settings_tv);
        this.v = (LottieAnimationView) findViewById(R.id.loader);
        this.w = (LottieAnimationView) findViewById(R.id.pay_button_loader);
        this.f70506f = new d(this);
        this.f70505e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                LocalContactsActivity.this.c(view);
            }
        });
        if (this.r || this.f70502a == null) {
            this.f70507g.requestFocus();
        }
        this.f70508h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                LocalContactsActivity.this.b(view);
            }
        });
        this.f70509i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                LocalContactsActivity.this.a(view);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.r = intent.getBooleanExtra("showKeyboardOnStart", false);
        }
        if (this.r) {
            this.f70507g.requestFocus();
        }
        d();
    }

    private void c() {
        x.a aVar = x.f69805a;
        ArrayList<IJRDataModel> arrayList = this.f70502a;
        k.c(arrayList, "p2PContactEntity");
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator<IJRDataModel> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            IJRDataModel next = it2.next();
            if (next != null) {
                RecentSendMoney recentSendMoney = (RecentSendMoney) next;
                String name = recentSendMoney.getName();
                if (name != null) {
                    char upperCase = Character.toUpperCase(name.charAt(0));
                    if (!Character.isLetter(upperCase)) {
                        arrayList2.add(recentSendMoney);
                    } else if (!hashMap.containsKey(Character.valueOf(upperCase))) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(next);
                        hashMap.put(Character.valueOf(upperCase), arrayList3);
                    } else {
                        List list = (List) hashMap.get(Character.valueOf(upperCase));
                        if (list != null) {
                            list.add(next);
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.wallet.RecentSendMoney");
            }
        }
        if (arrayList2.size() > 0) {
            hashMap.put('#', arrayList2);
        }
        x.a aVar2 = x.f69805a;
        this.u = x.a.a((HashMap<Character, List<IJRDataModel>>) hashMap);
        d dVar = this.f70506f;
        ArrayList<b> arrayList4 = this.u;
        k.c(arrayList4, "data");
        Collection collection = arrayList4;
        dVar.f50124a.addAll(collection);
        dVar.f50125b.addAll(collection);
        x.a aVar3 = x.f69805a;
        this.k.setUpWithRecyclerView(this.f70504c, x.a.a(), this);
        this.f70504c.setAdapter(this.f70506f);
        this.l = new p(this) {
            public final int getVerticalSnapPreference() {
                return -1;
            }

            public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return super.calculateSpeedPerPixel(displayMetrics) * 0.2f;
            }
        };
        this.m = new LinearLayoutManager(this);
        this.f70504c.setLayoutManager(this.m);
        this.f70504c.addOnScrollListener(new RecyclerView.l() {
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) LocalContactsActivity.this.f70504c.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) LocalContactsActivity.this.f70504c.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                if (LocalContactsActivity.this.k.getVisibility() == 0 && LocalContactsActivity.this.u != null && !LocalContactsActivity.this.u.isEmpty() && findLastCompletelyVisibleItemPosition < LocalContactsActivity.this.u.size() && findFirstCompletelyVisibleItemPosition >= 0 && (LocalContactsActivity.this.u.get(findFirstCompletelyVisibleItemPosition) instanceof c)) {
                    FastScrollerLinearLayout b2 = LocalContactsActivity.this.k;
                    String valueOf = String.valueOf(((c) LocalContactsActivity.this.u.get(findFirstCompletelyVisibleItemPosition)).f50122a);
                    int i4 = 0;
                    String[] strArr = b2.f49583b;
                    if (strArr == null) {
                        k.a("sectionList");
                    }
                    int length = strArr.length;
                    while (true) {
                        if (i4 >= length) {
                            i4 = -1;
                            break;
                        }
                        String[] strArr2 = b2.f49583b;
                        if (strArr2 == null) {
                            k.a("sectionList");
                        }
                        if (kotlin.m.p.a(strArr2[i4], valueOf, true)) {
                            break;
                        }
                        i4++;
                    }
                    if (i4 != -1) {
                        b2.a(i4);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f70507g.setText("");
    }

    public final void a() {
        this.f70504c.setVisibility(8);
        this.p.setVisibility(0);
    }

    public final void b(String str) {
        this.f70504c.setVisibility(8);
        this.p.setVisibility(8);
        this.s.setText(String.format(getString(R.string.contact_not_found_error), new Object[]{str}));
        this.j.setVisibility(0);
    }

    public final void b() {
        this.j.setVisibility(8);
        this.p.setVisibility(8);
        this.f70504c.setVisibility(0);
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.READ_CONTACTS") == 0) {
            this.q.setVisibility(8);
            a.a(this.v);
            x.a aVar = x.f69805a;
            x.a.a(this, this);
            return;
        }
        requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 201);
    }

    public final void a(ArrayList<IJRDataModel> arrayList) {
        a.b(this.v);
        this.f70502a = new ArrayList<>();
        this.f70502a.addAll(arrayList);
        c();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 201) {
            if (s.a(iArr)) {
                d();
            } else {
                this.f70507g.setInputType(12290);
                String str = getString(R.string.settings) + AppUtility.CENTER_DOT;
                String str2 = getString(R.string.contacts_go_to_settings) + " " + str;
                int indexOf = str2.indexOf(str);
                int length = str2.length();
                TextView textView = this.t;
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", LocalContactsActivity.this.getPackageName(), (String) null));
                        LocalContactsActivity.this.startActivityForResult(intent, 101);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(LocalContactsActivity.this.getResources().getColor(R.color.color_00b9f5));
                    }
                }, indexOf, length, 33);
                textView.setText(spannableString);
                this.t.setClickable(true);
                this.t.setMovementMethod(LinkMovementMethod.getInstance());
                this.q.setVisibility(0);
                this.f70507g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
                this.p.setVisibility(0);
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            d();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f70506f;
        if (dVar != null) {
            dVar.f50126c = null;
        }
    }

    public final void a(String str) {
        Iterator<b> it2 = this.u.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if ((next instanceof c) && String.valueOf(((c) next).f50122a).equalsIgnoreCase(str)) {
                this.l.setTargetPosition(this.u.indexOf(next));
                this.m.startSmoothScroll(this.l);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a.b(this.w);
            if (fVar.f55797b != null && (fVar.f55797b instanceof PaymentCombinationAPIResponse)) {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) fVar.f55797b;
                if (paymentCombinationAPIResponse.getCategory() != null && paymentCombinationAPIResponse.getCategory().equalsIgnoreCase("P2P")) {
                    net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
                    net.one97.paytm.wallet.utility.d.a(this, paymentCombinationAPIResponse, (String) null, (String) null, e.C0905e.PAY.getType(), false, false, true, false, false);
                    finish();
                }
            }
        } else if (fVar.f55796a == h.ERROR && fVar.f55798c != null) {
            a.b(this.w);
            this.f70505e.setBackgroundColor(getResources().getColor(R.color.color_00b9f5));
            this.f70505e.setClickable(true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            ae aeVar = ae.f69602a;
            if (ae.a(fVar.f55798c.f55799a)) {
                ae aeVar2 = ae.f69602a;
                ae.a(this, fVar.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                return;
            }
            net.one97.paytm.wallet.utility.d dVar2 = net.one97.paytm.wallet.utility.d.f72319a;
            net.one97.paytm.wallet.utility.d.a(this, (String) null, (String) null, com.paytm.utility.b.j((Context) this), com.paytm.utility.b.l((Context) this), (String) null, str, true, (ExtraData) null, true, false, false);
        } else if (fVar.f55796a == h.CANCELLED) {
            a.b(this.w);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (!(currentFocus == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null)) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f70505e.setBackgroundColor(getResources().getColor(R.color.grid_offer_blue));
        this.f70505e.setClickable(false);
        a.a(this.w);
        net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
        a2.f71397i = "entered";
        a2.j = a.e.CONATCT_SCREEN;
        a2.l = a.C1450a.CONTACT_PROCEED_CLICKED;
        a2.k = a.b.WAlLET_SEND_MONEY;
        a2.b((Context) this);
        String obj = this.f70507g.getText().toString();
        a2.f71392d = a.c.MOBILE_NUMBER_ENTERED;
        a2.f71394f = "no";
        String a3 = net.one97.paytm.wallet.utility.a.a(obj);
        x.a aVar = x.f69805a;
        if (!x.a.a(a3)) {
            this.n.setVisibility(0);
            this.n.setText(getString(R.string.money_transfer_enter_valid_mobile));
        } else if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this, "mt_revamp_enabled", true)) {
            net.one97.paytm.wallet.utility.a.a aVar2 = net.one97.paytm.wallet.utility.a.a.f72261c;
            if (net.one97.paytm.wallet.utility.a.a.c() != null) {
                net.one97.paytm.wallet.utility.a.a aVar3 = net.one97.paytm.wallet.utility.a.a.f72261c;
                net.one97.paytm.wallet.utility.a.a.c().b();
                net.one97.paytm.wallet.utility.a.a aVar4 = net.one97.paytm.wallet.utility.a.a.f72261c;
                net.one97.paytm.wallet.utility.a.a.d();
            }
            net.one97.paytm.wallet.utility.a.a.f72261c.a(this, a3, "PHONE_NUMBER", (String) null).observe(this, new z(a3) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    LocalContactsActivity.this.a(this.f$1, (net.one97.paytm.network.f) obj);
                }
            });
        } else {
            Intent intent = new Intent();
            intent.putExtra("PHONE_NUMBER", a3);
            intent.putExtra("NAME", "");
            intent.putExtra("MODE_OF_PAYMENT", "");
            net.one97.paytm.wallet.utility.a.a(intent, (Activity) this);
            finish();
        }
    }
}
