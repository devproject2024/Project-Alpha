package net.one97.paytm.wallet.newdesign.postcard.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.PostcardThemesResponseDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;
import net.one97.paytm.common.widgets.f;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.a.e;

public class g extends h implements View.OnClickListener {
    private boolean A = false;
    private RoboTextView B;
    /* access modifiers changed from: private */
    public RoboTextView C;
    /* access modifiers changed from: private */
    public RoboTextView D;
    private String E;
    private String F;
    private int G;
    private ImageView H;
    private boolean I = false;
    private Button J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextWatcher N = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            g.this.r.setError((CharSequence) null);
        }
    };
    private TextWatcher O = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            g.this.C.setText("");
        }
    };
    private TextWatcher P = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            g.this.s.setError((CharSequence) null);
            try {
                if (TextUtils.isEmpty(charSequence) || Double.parseDouble(charSequence.toString()) <= n.j.doubleValue()) {
                    String obj = g.this.n.getText().toString();
                    if (TextUtils.isEmpty(obj) || obj.length() <= 0) {
                        g.this.D.setVisibility(8);
                        return;
                    }
                    g.this.D.setVisibility(0);
                    g.this.D.setText(String.format(g.this.getResources().getString(R.string.lucky_lifafa_amount_text), new Object[]{obj}));
                    return;
                }
                g.this.s.setError(g.this.getString(R.string.amount_limit_error));
            } catch (NumberFormatException e2) {
                q.d(String.valueOf(e2));
            }
        }

        public final void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                g.this.D.setVisibility(8);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private ImageView f71317a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f71318b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f71319c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f71320d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f71321e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f71322f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f71323g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f71324h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f71325i;
    private b j;
    private String k;
    private String l;
    private AutoCompleteTextView m;
    /* access modifiers changed from: private */
    public EditText n;
    /* access modifiers changed from: private */
    public EditText o;
    /* access modifiers changed from: private */
    public EditText p;
    /* access modifiers changed from: private */
    public com.paytm.utility.h q;
    /* access modifiers changed from: private */
    public TextInputLayout r;
    /* access modifiers changed from: private */
    public TextInputLayout s;
    private TextInputLayout t;
    private TextInputLayout u;
    /* access modifiers changed from: private */
    public e v;
    private PostcardThemesResponseDataModel w;
    private String x = "";
    /* access modifiers changed from: private */
    public ThemesMetaDataModel y;
    private Dialog z;

    public interface a {
        void a(ThemesMetaDataModel themesMetaDataModel, int i2);
    }

    public interface b {
        void a(String str, String str2, String str3, String str4, String str5, IconMetaDataModel iconMetaDataModel, boolean z);
    }

    static /* synthetic */ void a() {
    }

    public static g a(PostcardThemesResponseDataModel postcardThemesResponseDataModel, boolean z2, boolean z3) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_themes_data", postcardThemesResponseDataModel);
        bundle.putBoolean("key_image_load_finish", z2);
        bundle.putBoolean("lucky_lifafa", z3);
        gVar.setArguments(bundle);
        return gVar;
    }

    public static g a(PostcardThemesResponseDataModel postcardThemesResponseDataModel, boolean z2, String str, String str2, String str3, int i2) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_themes_data", postcardThemesResponseDataModel);
        bundle.putBoolean("key_image_load_finish", z2);
        bundle.putBoolean("postcard_dl", true);
        bundle.putString("postcard_beneficiary_name", str);
        bundle.putString("postcard_beneficiary_account", str2);
        bundle.putString("postcard_beneficiary_amount", str3);
        bundle.putInt("postcard_type", i2);
        gVar.setArguments(bundle);
        return gVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            this.w = (PostcardThemesResponseDataModel) getArguments().getSerializable("key_themes_data");
            this.A = getArguments().getBoolean("key_image_load_finish");
            this.I = getArguments().getBoolean("lucky_lifafa");
            if (this.w != null && this.w.getResponse() != null && this.w.getResponse().size() > 0) {
                this.y = this.w.getResponse().get(0);
                if (arguments.getBoolean("postcard_dl")) {
                    this.E = arguments.getString("postcard_beneficiary_name");
                    this.F = arguments.getString("postcard_beneficiary_account");
                    this.G = arguments.getInt("postcard_type");
                }
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onResume() {
        super.onResume();
        try {
            if (!this.A) {
                try {
                    if (this.z == null) {
                        this.z = net.one97.paytm.wallet.utility.a.b((Activity) getActivity());
                    }
                    if (this.z != null && !this.z.isShowing()) {
                        this.z.show();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                }
            } else if ((this.w == null || this.w.getResponse() == null) && this.A) {
                b(getString(R.string.error), getString(R.string.some_went_wrong));
            }
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
    }

    private void b() {
        try {
            if (this.z != null && this.z.isShowing()) {
                this.z.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof b) {
                this.j = (b) context;
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_send_onetomany_postcard, viewGroup, false);
        getActivity().getWindow().setSoftInputMode(3);
        FragmentActivity activity = getActivity();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        try {
            this.f71318b = (ImageView) inflate.findViewById(R.id.ivBtnPlayKnowMoreVideo);
            this.f71317a = (ImageView) inflate.findViewById(R.id.iv_back_button);
            this.K = (TextView) inflate.findViewById(R.id.tvHeader);
            this.L = (TextView) inflate.findViewById(R.id.tvSendPostCard);
            this.M = (TextView) inflate.findViewById(R.id.tvLuckyLifafaHeader);
            this.L.setOnClickListener(this);
            this.f71320d = (ImageView) inflate.findViewById(R.id.iv_anim_object1);
            this.f71321e = (ImageView) inflate.findViewById(R.id.iv_anim_object2);
            this.f71322f = (ImageView) inflate.findViewById(R.id.iv_anim_object3);
            this.f71323g = (ImageView) inflate.findViewById(R.id.iv_anim_object4);
            this.J = (Button) inflate.findViewById(R.id.btnCreateLuckyLifafa);
            this.J.setOnClickListener(this);
            this.u = (TextInputLayout) inflate.findViewById(R.id.edit_account_input_number_layout);
            this.r = (TextInputLayout) inflate.findViewById(R.id.edit_account_input_layout);
            this.s = (TextInputLayout) inflate.findViewById(R.id.edit_amount_input_layout);
            this.t = (TextInputLayout) inflate.findViewById(R.id.edit_message_input_layout);
            this.D = (RoboTextView) inflate.findViewById(R.id.tvAmountHint);
            this.C = (RoboTextView) inflate.findViewById(R.id.tvLifafaNumberHint);
            this.f71324h = (ImageView) inflate.findViewById(R.id.contact_picker);
            this.B = (RoboTextView) inflate.findViewById(R.id.contact_picker_text);
            this.m = (AutoCompleteTextView) inflate.findViewById(R.id.edit_no);
            this.n = (EditText) inflate.findViewById(R.id.edit_number_lifafa);
            this.m.addTextChangedListener(this.N);
            this.o = (EditText) inflate.findViewById(R.id.edit_amount);
            this.o.addTextChangedListener(this.P);
            this.p = (EditText) inflate.findViewById(R.id.edit_message);
            this.H = (ImageView) inflate.findViewById(R.id.img_mobile_number_clear);
            this.f71325i = (ImageView) inflate.findViewById(R.id.iv_bottom_strip);
            this.n.addTextChangedListener(this.O);
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "max_digit_paytmcash");
            int parseInt = !TextUtils.isEmpty(stringFromGTM) ? Integer.parseInt(stringFromGTM) : 0;
            if (parseInt <= 0) {
                parseInt = 5;
            }
            this.o.setFilters(new InputFilter[]{new f(parseInt, 2)});
            this.o.setImeOptions(6);
            if (this.y != null) {
                this.p.setText(this.y.getDescription());
            }
            this.f71324h.setOnClickListener(this);
            this.B.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.f71318b.setOnClickListener(this);
            this.f71319c = (RecyclerView) inflate.findViewById(R.id.rv_themes_icons);
            if (!(this.w == null || this.w.getResponse() == null)) {
                c();
            }
            this.f71317a.setOnClickListener(this);
            this.o.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    g.a();
                }
            });
            this.m.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    g.a();
                }
            });
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
        if (this.I) {
            this.B.setVisibility(8);
            this.f71324h.setVisibility(8);
            this.H.setVisibility(8);
            this.r.setVisibility(8);
            this.u.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
            this.J.setVisibility(0);
            this.L.setVisibility(8);
            this.f71318b.setVisibility(8);
            this.M.setVisibility(0);
            this.s.setHint(getResources().getString(R.string.enter_amount));
            this.t.setHint(getResources().getString(R.string.message));
        } else {
            this.r.setVisibility(0);
            this.B.setVisibility(8);
            this.f71324h.setVisibility(0);
            this.H.setVisibility(0);
            this.C.setVisibility(8);
            this.u.setVisibility(8);
            this.D.setVisibility(8);
            this.J.setVisibility(0);
            this.L.setVisibility(8);
            this.f71318b.setVisibility(8);
            this.M.setVisibility(8);
            this.K.setText(getResources().getString(R.string.send_lifafa));
            this.J.setText(getResources().getString(R.string.single_sent_lifafa));
            this.s.setHint(getResources().getString(R.string.lifafa_enter_amount));
            this.t.setHint(getResources().getString(R.string.lifafa_type_message));
        }
        this.k = this.E;
        if (this.G == n.aW) {
            ThemesMetaDataModel themesMetaDataModel = null;
            PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.w;
            if (postcardThemesResponseDataModel != null) {
                Iterator<ThemesMetaDataModel> it2 = postcardThemesResponseDataModel.getResponse().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ThemesMetaDataModel next = it2.next();
                    if (next.getId().equalsIgnoreCase("d594f202-7852-11e7-83c6-1866da8588af")) {
                        themesMetaDataModel = next;
                        break;
                    }
                }
            }
            this.y = themesMetaDataModel;
        }
        ThemesMetaDataModel themesMetaDataModel2 = this.y;
        if (themesMetaDataModel2 != null) {
            themesMetaDataModel2.setSelected(true);
            this.x = this.y.getId();
            PostcardThemesResponseDataModel postcardThemesResponseDataModel2 = this.w;
            if (!(postcardThemesResponseDataModel2 == null || postcardThemesResponseDataModel2.getResponse() == null)) {
                for (int i2 = 0; i2 < this.w.getResponse().size(); i2++) {
                    if (this.w.getResponse().get(i2) != this.y) {
                        this.w.getResponse().get(i2).setSelected(false);
                    }
                }
            }
            a(this.y);
        }
        if (this.I) {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/wallet/create-lucky-lifafa");
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "open_screen_event", hashMap);
        }
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.m.getWindowToken(), 0);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    private void c() {
        try {
            this.f71319c.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            this.v = new e(getActivity(), this.w.getResponse(), new a() {
                public final void a(ThemesMetaDataModel themesMetaDataModel, int i2) {
                    g.this.v.notifyDataSetChanged();
                    g.this.a(themesMetaDataModel);
                    g.this.p.setText(themesMetaDataModel.getDescription());
                    ThemesMetaDataModel unused = g.this.y = themesMetaDataModel;
                    g.a(g.this, i2);
                }
            });
            this.f71319c.setAdapter(this.v);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x00ad */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00f0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x006a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel r5) {
        /*
            r4 = this;
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0115 }
            r1 = 0
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r2 = r5.getThemes()     // Catch:{ Exception -> 0x0027 }
            java.util.ArrayList r2 = r2.getApplicationView()     // Catch:{ Exception -> 0x0027 }
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = net.one97.paytm.wallet.d.l.a((android.content.Context) r3)     // Catch:{ Exception -> 0x0027 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r2 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = r2.getCacheURL1()     // Catch:{ Exception -> 0x0027 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ Exception -> 0x0027 }
            android.widget.ImageView r3 = r4.f71323g     // Catch:{ Exception -> 0x0027 }
            r3.setImageBitmap(r2)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0048
        L_0x0027:
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r2 = r5.getThemes()     // Catch:{ Exception -> 0x0115 }
            java.util.ArrayList r2 = r2.getApplicationView()     // Catch:{ Exception -> 0x0115 }
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = net.one97.paytm.wallet.d.l.a((android.content.Context) r3)     // Catch:{ Exception -> 0x0115 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r2 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r2.getUrl1()     // Catch:{ Exception -> 0x0115 }
            com.squareup.picasso.aa r2 = r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0115 }
            android.widget.ImageView r3 = r4.f71320d     // Catch:{ Exception -> 0x0115 }
            r2.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r1)     // Catch:{ Exception -> 0x0115 }
        L_0x0048:
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r2 = r5.getThemes()     // Catch:{ Exception -> 0x006a }
            java.util.ArrayList r2 = r2.getApplicationView()     // Catch:{ Exception -> 0x006a }
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()     // Catch:{ Exception -> 0x006a }
            java.lang.String r3 = net.one97.paytm.wallet.d.l.a((android.content.Context) r3)     // Catch:{ Exception -> 0x006a }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r2 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x006a }
            java.lang.String r2 = r2.getCacheURL2()     // Catch:{ Exception -> 0x006a }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ Exception -> 0x006a }
            android.widget.ImageView r3 = r4.f71322f     // Catch:{ Exception -> 0x006a }
            r3.setImageBitmap(r2)     // Catch:{ Exception -> 0x006a }
            goto L_0x008b
        L_0x006a:
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r2 = r5.getThemes()     // Catch:{ Exception -> 0x0115 }
            java.util.ArrayList r2 = r2.getApplicationView()     // Catch:{ Exception -> 0x0115 }
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = net.one97.paytm.wallet.d.l.a((android.content.Context) r3)     // Catch:{ Exception -> 0x0115 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r2 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r2.getUrl2()     // Catch:{ Exception -> 0x0115 }
            com.squareup.picasso.aa r2 = r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0115 }
            android.widget.ImageView r3 = r4.f71321e     // Catch:{ Exception -> 0x0115 }
            r2.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r1)     // Catch:{ Exception -> 0x0115 }
        L_0x008b:
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r2 = r5.getThemes()     // Catch:{ Exception -> 0x00ad }
            java.util.ArrayList r2 = r2.getApplicationView()     // Catch:{ Exception -> 0x00ad }
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()     // Catch:{ Exception -> 0x00ad }
            java.lang.String r3 = net.one97.paytm.wallet.d.l.a((android.content.Context) r3)     // Catch:{ Exception -> 0x00ad }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r2 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x00ad }
            java.lang.String r2 = r2.getCacheURL3()     // Catch:{ Exception -> 0x00ad }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ Exception -> 0x00ad }
            android.widget.ImageView r3 = r4.f71321e     // Catch:{ Exception -> 0x00ad }
            r3.setImageBitmap(r2)     // Catch:{ Exception -> 0x00ad }
            goto L_0x00ce
        L_0x00ad:
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r2 = r5.getThemes()     // Catch:{ Exception -> 0x0115 }
            java.util.ArrayList r2 = r2.getApplicationView()     // Catch:{ Exception -> 0x0115 }
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = net.one97.paytm.wallet.d.l.a((android.content.Context) r3)     // Catch:{ Exception -> 0x0115 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r2 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r2.getUrl3()     // Catch:{ Exception -> 0x0115 }
            com.squareup.picasso.aa r2 = r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0115 }
            android.widget.ImageView r3 = r4.f71322f     // Catch:{ Exception -> 0x0115 }
            r2.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r1)     // Catch:{ Exception -> 0x0115 }
        L_0x00ce:
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r2 = r5.getThemes()     // Catch:{ Exception -> 0x00f0 }
            java.util.ArrayList r2 = r2.getApplicationView()     // Catch:{ Exception -> 0x00f0 }
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r3 = net.one97.paytm.wallet.d.l.a((android.content.Context) r3)     // Catch:{ Exception -> 0x00f0 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r2 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r2 = r2.getCacheURL4()     // Catch:{ Exception -> 0x00f0 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ Exception -> 0x00f0 }
            android.widget.ImageView r3 = r4.f71320d     // Catch:{ Exception -> 0x00f0 }
            r3.setImageBitmap(r2)     // Catch:{ Exception -> 0x00f0 }
            goto L_0x0111
        L_0x00f0:
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r5 = r5.getThemes()     // Catch:{ Exception -> 0x0115 }
            java.util.ArrayList r5 = r5.getApplicationView()     // Catch:{ Exception -> 0x0115 }
            androidx.fragment.app.FragmentActivity r2 = r4.getActivity()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = net.one97.paytm.wallet.d.l.a((android.content.Context) r2)     // Catch:{ Exception -> 0x0115 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r5 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r5, (java.lang.String) r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = r5.getUrl4()     // Catch:{ Exception -> 0x0115 }
            com.squareup.picasso.aa r5 = r0.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0115 }
            android.widget.ImageView r0 = r4.f71323g     // Catch:{ Exception -> 0x0115 }
            r5.a((android.widget.ImageView) r0, (com.squareup.picasso.e) r1)     // Catch:{ Exception -> 0x0115 }
        L_0x0111:
            r4.f()     // Catch:{ Exception -> 0x0115 }
            return
        L_0x0115:
            r5 = move-exception
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.paytm.utility.q.d(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.postcard.b.g.a(net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel):void");
    }

    private static IconMetaDataModel a(ArrayList<IconMetaDataModel> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).getResolution().equalsIgnoreCase(str)) {
                return arrayList.get(i2);
            }
        }
        return arrayList.get(0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:159|160|161|162) */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        r0 = new java.util.HashMap();
        r0.put("wallet_error_type", "send_postcard_error");
        r0.put("wallet_error_text", getString(net.one97.paytm.wallet.R.string.wallet_amount_error));
        net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity().getApplicationContext(), "wallet_error_displayed", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
        r14.s.setErrorEnabled(true);
        r14.s.setError(getString(net.one97.paytm.wallet.R.string.wallet_amount_error));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:130:0x03b5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x0406 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x04af */
    /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x04cf */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r15) {
        /*
            r14 = this;
            int r0 = r15.getId()     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.id.contact_picker     // Catch:{ Exception -> 0x04f2 }
            if (r0 != r1) goto L_0x000c
            r14.d()     // Catch:{ Exception -> 0x04f2 }
            goto L_0x0023
        L_0x000c:
            int r0 = r15.getId()     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.id.contact_picker_text     // Catch:{ Exception -> 0x04f2 }
            if (r0 != r1) goto L_0x0018
            r14.d()     // Catch:{ Exception -> 0x04f2 }
            goto L_0x0023
        L_0x0018:
            int r0 = r15.getId()     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.id.img_mobile_number_clear     // Catch:{ Exception -> 0x04f2 }
            if (r0 != r1) goto L_0x0023
            r14.e()     // Catch:{ Exception -> 0x04f2 }
        L_0x0023:
            android.widget.ImageView r0 = r14.f71317a     // Catch:{ Exception -> 0x04f2 }
            if (r15 != r0) goto L_0x0030
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            r0.onBackPressed()     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x0030:
            android.widget.Button r0 = r14.J     // Catch:{ Exception -> 0x04f2 }
            if (r15 != r0) goto L_0x04df
            android.widget.AutoCompleteTextView r0 = r14.m     // Catch:{ Exception -> 0x04f2 }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04f2 }
            android.widget.EditText r1 = r14.p     // Catch:{ Exception -> 0x04f2 }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x04f2 }
            android.widget.EditText r1 = r14.o     // Catch:{ Exception -> 0x04f2 }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x04f2 }
            android.widget.EditText r1 = r14.n     // Catch:{ Exception -> 0x04f2 }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04f2 }
            boolean r2 = r14.I     // Catch:{ Exception -> 0x04f2 }
            if (r2 == 0) goto L_0x008d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f2 }
            r0.<init>()     // Catch:{ Exception -> 0x04f2 }
            r0.append(r1)     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = " "
            r0.append(r2)     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r2 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r3 = net.one97.paytm.wallet.R.string.lifafa_lucky     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04f2 }
            r0.append(r2)     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04f2 }
            r14.k = r0     // Catch:{ Exception -> 0x04f2 }
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity r0 = (net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity) r0     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = "create_lucky_lifafa_clicked"
            r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x04f2 }
            r4 = r1
            goto L_0x00a4
        L_0x008d:
            java.lang.String r2 = r14.l     // Catch:{ Exception -> 0x04f2 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x04f2 }
            if (r2 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            java.lang.String r0 = r14.l     // Catch:{ Exception -> 0x04f2 }
        L_0x0098:
            androidx.fragment.app.FragmentActivity r2 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity r2 = (net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity) r2     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r3 = "send_lifafa_clicked"
            r2.a((java.lang.String) r3)     // Catch:{ Exception -> 0x04f2 }
            r4 = r0
        L_0x00a4:
            boolean r0 = r14.I     // Catch:{ Exception -> 0x04f2 }
            r2 = 1
            java.lang.String r3 = "wallet_error_displayed"
            java.lang.String r7 = "wallet_error_text"
            java.lang.String r8 = "send_postcard_error"
            java.lang.String r9 = "wallet_error_type"
            if (r0 != 0) goto L_0x0126
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x04f2 }
            if (r0 != 0) goto L_0x00bd
            boolean r0 = net.one97.paytm.wallet.utility.a.b((java.lang.String) r4)     // Catch:{ Exception -> 0x04f2 }
            if (r0 != 0) goto L_0x0126
        L_0x00bd:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00de }
            r0.<init>()     // Catch:{ Exception -> 0x00de }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x00de }
            int r1 = net.one97.paytm.wallet.R.string.wallet_mobile_number_error     // Catch:{ Exception -> 0x00de }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00de }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x00de }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x00de }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x00de }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x00de }
            r1.sendCustomGTMEvent(r4, r3, r0)     // Catch:{ Exception -> 0x00de }
            goto L_0x00ea
        L_0x00de:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x04f2 }
            if (r1 == 0) goto L_0x00ea
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x04f2 }
        L_0x00ea:
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x04f2 }
            boolean r0 = r1.isFromAppEvoke(r0)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x0114
            int r0 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.invalid_mobile_p2p_number     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.newdesign.postcard.b.g$7 r3 = new net.one97.paytm.wallet.newdesign.postcard.b.g$7     // Catch:{ Exception -> 0x04f2 }
            r3.<init>()     // Catch:{ Exception -> 0x04f2 }
            r14.a(r0, r1, r2, r3)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x0114:
            com.google.android.material.textfield.TextInputLayout r0 = r14.r     // Catch:{ Exception -> 0x04f2 }
            r0.setErrorEnabled(r2)     // Catch:{ Exception -> 0x04f2 }
            com.google.android.material.textfield.TextInputLayout r0 = r14.r     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.wallet_mobile_number_error     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            r0.setError(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x0126:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x0176
            boolean r0 = r14.I     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x0176
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x04f2 }
            boolean r0 = r1.isFromAppEvoke(r0)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x015a
            int r0 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.msg_invalid_value     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.newdesign.postcard.b.g$8 r3 = new net.one97.paytm.wallet.newdesign.postcard.b.g$8     // Catch:{ Exception -> 0x04f2 }
            r3.<init>()     // Catch:{ Exception -> 0x04f2 }
            r14.a(r0, r1, r2, r3)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x015a:
            com.paytm.utility.RoboTextView r0 = r14.C     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.color.red     // Catch:{ Exception -> 0x04f2 }
            int r1 = r1.getColor(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setTextColor(r1)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.RoboTextView r0 = r14.C     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.lucky_lifafa_count_error     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            r0.setText(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x0176:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r0 != 0) goto L_0x01d0
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r0 != 0) goto L_0x01d0
            boolean r0 = r14.I     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x01d0
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x04f2 }
            boolean r0 = r1.isFromAppEvoke(r0)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x01b0
            int r0 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.msg_invalid_value     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.newdesign.postcard.b.g$9 r3 = new net.one97.paytm.wallet.newdesign.postcard.b.g$9     // Catch:{ Exception -> 0x04f2 }
            r3.<init>()     // Catch:{ Exception -> 0x04f2 }
            r14.a(r0, r1, r2, r3)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x01b0:
            com.paytm.utility.RoboTextView r0 = r14.C     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.color.red     // Catch:{ Exception -> 0x04f2 }
            int r1 = r1.getColor(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setTextColor(r1)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.RoboTextView r0 = r14.C     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.lifafa_count_greater_than_zero     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setText(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x01d0:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x04f2 }
            r10 = 25
            if (r0 != 0) goto L_0x022c
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r0 <= r10) goto L_0x022c
            boolean r0 = r14.I     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x022c
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x04f2 }
            boolean r0 = r1.isFromAppEvoke(r0)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x020c
            int r0 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.msg_invalid_value     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.newdesign.postcard.b.g$10 r3 = new net.one97.paytm.wallet.newdesign.postcard.b.g$10     // Catch:{ Exception -> 0x04f2 }
            r3.<init>()     // Catch:{ Exception -> 0x04f2 }
            r14.a(r0, r1, r2, r3)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x020c:
            com.paytm.utility.RoboTextView r0 = r14.C     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.color.red     // Catch:{ Exception -> 0x04f2 }
            int r1 = r1.getColor(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setTextColor(r1)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.RoboTextView r0 = r14.C     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.lifafa_limit     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setText(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x022c:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r0 != 0) goto L_0x0243
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r0 > r10) goto L_0x0243
            boolean r0 = r14.I     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x0243
            com.paytm.utility.RoboTextView r0 = r14.C     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r10 = ""
            r0.setText(r10)     // Catch:{ Exception -> 0x04f2 }
        L_0x0243:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x02b2
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x026a }
            r0.<init>()     // Catch:{ Exception -> 0x026a }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x026a }
            int r1 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x026a }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x026a }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x026a }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x026a }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x026a }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x026a }
            r1.sendCustomGTMEvent(r4, r3, r0)     // Catch:{ Exception -> 0x026a }
            goto L_0x0276
        L_0x026a:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x04f2 }
            if (r1 == 0) goto L_0x0276
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x04f2 }
        L_0x0276:
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x04f2 }
            boolean r0 = r1.isFromAppEvoke(r0)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x02a0
            int r0 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.msg_invalid_value     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.wallet.newdesign.postcard.b.g$11 r3 = new net.one97.paytm.wallet.newdesign.postcard.b.g$11     // Catch:{ Exception -> 0x04f2 }
            r3.<init>()     // Catch:{ Exception -> 0x04f2 }
            r14.a(r0, r1, r2, r3)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x02a0:
            com.google.android.material.textfield.TextInputLayout r0 = r14.s     // Catch:{ Exception -> 0x04f2 }
            r0.setErrorEnabled(r2)     // Catch:{ Exception -> 0x04f2 }
            com.google.android.material.textfield.TextInputLayout r0 = r14.s     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            r0.setError(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x02b2:
            double r10 = java.lang.Double.parseDouble(r5)     // Catch:{ NumberFormatException -> 0x04af }
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 >= 0) goto L_0x02fa
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02dd }
            r0.<init>()     // Catch:{ Exception -> 0x02dd }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x02dd }
            int r1 = net.one97.paytm.wallet.R.string.transaction_limit_message_min     // Catch:{ Exception -> 0x02dd }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x02dd }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x02dd }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02dd }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x02dd }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x02dd }
            r1.sendCustomGTMEvent(r4, r3, r0)     // Catch:{ Exception -> 0x02dd }
            goto L_0x02e9
        L_0x02dd:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v     // Catch:{ NumberFormatException -> 0x04af }
            if (r1 == 0) goto L_0x02e9
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x04af }
            com.paytm.utility.q.d(r0)     // Catch:{ NumberFormatException -> 0x04af }
        L_0x02e9:
            int r0 = net.one97.paytm.wallet.R.string.transaction_limit_header     // Catch:{ NumberFormatException -> 0x04af }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ NumberFormatException -> 0x04af }
            int r1 = net.one97.paytm.wallet.R.string.transaction_limit_message_min     // Catch:{ NumberFormatException -> 0x04af }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ NumberFormatException -> 0x04af }
            r14.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ NumberFormatException -> 0x04af }
            goto L_0x04df
        L_0x02fa:
            double r10 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x04f2 }
            java.lang.Double r0 = net.one97.paytm.utils.n.j     // Catch:{ Exception -> 0x04f2 }
            double r12 = r0.doubleValue()     // Catch:{ Exception -> 0x04f2 }
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x033e
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0329 }
            r0.<init>()     // Catch:{ Exception -> 0x0329 }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x0329 }
            int r1 = net.one97.paytm.wallet.R.string.transaction_limit_message     // Catch:{ Exception -> 0x0329 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x0329 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x0329 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x0329 }
            androidx.fragment.app.FragmentActivity r2 = r14.getActivity()     // Catch:{ Exception -> 0x0329 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0329 }
            r1.sendCustomGTMEvent(r2, r3, r0)     // Catch:{ Exception -> 0x0329 }
            goto L_0x0335
        L_0x0329:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x04f2 }
            if (r1 == 0) goto L_0x0335
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x04f2 }
        L_0x0335:
            android.widget.EditText r0 = r14.o     // Catch:{ Exception -> 0x04f2 }
            android.text.TextWatcher r1 = r14.P     // Catch:{ Exception -> 0x04f2 }
            r0.addTextChangedListener(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x033e:
            double r10 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x04f2 }
            java.lang.Double r0 = net.one97.paytm.utils.n.j     // Catch:{ Exception -> 0x04f2 }
            double r12 = r0.doubleValue()     // Catch:{ Exception -> 0x04f2 }
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x038a
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x036d }
            r0.<init>()     // Catch:{ Exception -> 0x036d }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x036d }
            int r1 = net.one97.paytm.wallet.R.string.transaction_limit_message     // Catch:{ Exception -> 0x036d }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x036d }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x036d }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x036d }
            androidx.fragment.app.FragmentActivity r2 = r14.getActivity()     // Catch:{ Exception -> 0x036d }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x036d }
            r1.sendCustomGTMEvent(r2, r3, r0)     // Catch:{ Exception -> 0x036d }
            goto L_0x0379
        L_0x036d:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x04f2 }
            if (r1 == 0) goto L_0x0379
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x04f2 }
        L_0x0379:
            int r0 = net.one97.paytm.wallet.R.string.transaction_limit_header     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.transaction_limit_message     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            r14.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x038a:
            int r0 = a((java.lang.String) r5)     // Catch:{ Exception -> 0x04f2 }
            r10 = -1
            if (r0 != r10) goto L_0x03cb
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x03b5 }
            r0.<init>()     // Catch:{ Exception -> 0x03b5 }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x03b5 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x03b5 }
            int r4 = net.one97.paytm.wallet.R.string.lifafa_decimal_not_allowed     // Catch:{ Exception -> 0x03b5 }
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x03b5 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x03b5 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x03b5 }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x03b5 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x03b5 }
            r1.sendCustomGTMEvent(r4, r3, r0)     // Catch:{ Exception -> 0x03b5 }
        L_0x03b5:
            com.google.android.material.textfield.TextInputLayout r0 = r14.s     // Catch:{ Exception -> 0x04f2 }
            r0.setErrorEnabled(r2)     // Catch:{ Exception -> 0x04f2 }
            com.google.android.material.textfield.TextInputLayout r0 = r14.s     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.lifafa_decimal_not_allowed     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setError(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x03cb:
            boolean r0 = r14.I     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x042b
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r0 != 0) goto L_0x042b
            double r10 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x04f2 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x04f2 }
            double r0 = (double) r0
            int r12 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r12 >= 0) goto L_0x042b
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0406 }
            r0.<init>()     // Catch:{ Exception -> 0x0406 }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x0406 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x0406 }
            int r4 = net.one97.paytm.wallet.R.string.lifafa_amount_and_count     // Catch:{ Exception -> 0x0406 }
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x0406 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x0406 }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x0406 }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x0406 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x0406 }
            r1.sendCustomGTMEvent(r4, r3, r0)     // Catch:{ Exception -> 0x0406 }
        L_0x0406:
            com.google.android.material.textfield.TextInputLayout r0 = r14.s     // Catch:{ Exception -> 0x04f2 }
            r0.setErrorEnabled(r2)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.RoboTextView r0 = r14.D     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.color.red     // Catch:{ Exception -> 0x04f2 }
            int r1 = r1.getColor(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setTextColor(r1)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.RoboTextView r0 = r14.D     // Catch:{ Exception -> 0x04f2 }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x04f2 }
            int r2 = net.one97.paytm.wallet.R.string.lifafa_amount_and_count     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x04f2 }
            r0.setText(r1)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x042b:
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x048f
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x045d }
            r0.<init>()     // Catch:{ Exception -> 0x045d }
            java.lang.String r1 = "wallet_send_money_method_name"
            java.lang.String r2 = "mobile"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x045d }
            java.lang.String r1 = "wallet_send_money_amount"
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x045d }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x045d }
            java.lang.String r1 = "wallet_send_money_comment"
            r0.put(r1, r6)     // Catch:{ Exception -> 0x045d }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x045d }
            androidx.fragment.app.FragmentActivity r2 = r14.getActivity()     // Catch:{ Exception -> 0x045d }
            java.lang.String r3 = "wallet_send_money_clicked"
            r1.sendCustomGTMEvent(r2, r3, r0)     // Catch:{ Exception -> 0x045d }
            goto L_0x0469
        L_0x045d:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x04f2 }
            if (r1 == 0) goto L_0x0469
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04f2 }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x04f2 }
        L_0x0469:
            net.one97.paytm.wallet.newdesign.postcard.b.g$b r2 = r14.j     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r3 = r14.k     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel r0 = r14.y     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r7 = r0.getId()     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel r0 = r14.y     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r0 = r0.getThemes()     // Catch:{ Exception -> 0x04f2 }
            java.util.ArrayList r0 = r0.getSummaryView()     // Catch:{ Exception -> 0x04f2 }
            androidx.fragment.app.FragmentActivity r1 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = net.one97.paytm.wallet.d.l.a((android.content.Context) r1)     // Catch:{ Exception -> 0x04f2 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r8 = a((java.util.ArrayList<net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel>) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x04f2 }
            boolean r9 = r14.I     // Catch:{ Exception -> 0x04f2 }
            r2.a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x048f:
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x04df
            boolean r0 = r14.isDetached()     // Catch:{ Exception -> 0x04f2 }
            if (r0 == 0) goto L_0x049c
            goto L_0x04df
        L_0x049c:
            r0 = 0
            net.one97.paytm.wallet.newdesign.utils.NoInternetAlertDialogFragment r0 = net.one97.paytm.wallet.newdesign.utils.NoInternetAlertDialogFragment.newInstance(r0)     // Catch:{ Exception -> 0x04f2 }
            androidx.fragment.app.j r1 = r14.getFragmentManager()     // Catch:{ Exception -> 0x04f2 }
            androidx.fragment.app.q r1 = r1.a()     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r2 = "dialog"
            r0.show((androidx.fragment.app.q) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x04df
        L_0x04af:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x04cf }
            r0.<init>()     // Catch:{ Exception -> 0x04cf }
            r0.put(r9, r8)     // Catch:{ Exception -> 0x04cf }
            int r1 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x04cf }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04cf }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x04cf }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x04cf }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x04cf }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x04cf }
            r1.sendCustomGTMEvent(r4, r3, r0)     // Catch:{ Exception -> 0x04cf }
        L_0x04cf:
            com.google.android.material.textfield.TextInputLayout r0 = r14.s     // Catch:{ Exception -> 0x04f2 }
            r0.setErrorEnabled(r2)     // Catch:{ Exception -> 0x04f2 }
            com.google.android.material.textfield.TextInputLayout r0 = r14.s     // Catch:{ Exception -> 0x04f2 }
            int r1 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x04f2 }
            r0.setError(r1)     // Catch:{ Exception -> 0x04f2 }
        L_0x04df:
            android.widget.ImageView r0 = r14.f71318b     // Catch:{ Exception -> 0x04f2 }
            if (r15 != r0) goto L_0x04f1
            android.content.Intent r15 = new android.content.Intent     // Catch:{ Exception -> 0x04f2 }
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()     // Catch:{ Exception -> 0x04f2 }
            java.lang.Class<net.one97.paytm.wallet.newdesign.postcard.HowItWorksActivity> r1 = net.one97.paytm.wallet.newdesign.postcard.HowItWorksActivity.class
            r15.<init>(r0, r1)     // Catch:{ Exception -> 0x04f2 }
            r14.startActivity(r15)     // Catch:{ Exception -> 0x04f2 }
        L_0x04f1:
            return
        L_0x04f2:
            r15 = move-exception
            java.lang.String r15 = java.lang.String.valueOf(r15)
            com.paytm.utility.q.d(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.postcard.b.g.onClick(android.view.View):void");
    }

    private void d() {
        try {
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
            intent.setType("vnd.android.cursor.dir/phone_v2");
            startActivityForResult(intent, 100);
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0127 A[Catch:{ all -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r12, int r13, android.content.Intent r14) {
        /*
            r11 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = "display_name"
            java.lang.String r2 = "data1"
            java.lang.String r3 = ""
            super.onActivityResult(r12, r13, r14)
            r4 = -1
            if (r13 != r4) goto L_0x0158
            r13 = 100
            if (r12 != r13) goto L_0x0158
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x0158
            if (r14 == 0) goto L_0x0158
            android.net.Uri r5 = r14.getData()
            if (r5 == 0) goto L_0x0158
            r12 = 0
            androidx.fragment.app.FragmentActivity r13 = r11.getActivity()     // Catch:{ all -> 0x014e }
            android.content.ContentResolver r4 = r13.getContentResolver()     // Catch:{ all -> 0x014e }
            java.lang.String[] r6 = new java.lang.String[]{r2, r1}     // Catch:{ all -> 0x014e }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x014e }
            if (r13 == 0) goto L_0x012b
            boolean r14 = r13.moveToFirst()     // Catch:{ all -> 0x014c }
            if (r14 == 0) goto L_0x012b
            int r14 = r13.getColumnIndex(r2)     // Catch:{ all -> 0x014c }
            int r1 = r13.getColumnIndex(r1)     // Catch:{ all -> 0x014c }
            java.lang.String r1 = r13.getString(r1)     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r13.getString(r14)     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r2 = r11.getActivity()     // Catch:{ all -> 0x014c }
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0124
            java.lang.String r2 = "-"
            java.lang.String r14 = r14.replace(r2, r3)     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r14.replace(r0, r3)     // Catch:{ all -> 0x014c }
            java.lang.String r2 = "("
            java.lang.String r14 = r14.replace(r2, r3)     // Catch:{ all -> 0x014c }
            java.lang.String r2 = ")"
            java.lang.String r14 = r14.replace(r2, r3)     // Catch:{ all -> 0x014c }
            if (r14 == 0) goto L_0x00ba
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x014c }
            if (r2 != 0) goto L_0x00ba
            java.lang.String r14 = r14.trim()     // Catch:{ all -> 0x014c }
            java.lang.String r2 = "\\p{C}"
            java.lang.String r14 = r14.replaceAll(r2, r3)     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r2 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r6 = net.one97.paytm.wallet.R.string.mobile_number_prefix_91     // Catch:{ all -> 0x014c }
            java.lang.String r2 = r2.getString(r6)     // Catch:{ all -> 0x014c }
            boolean r2 = r14.startsWith(r2)     // Catch:{ all -> 0x014c }
            if (r2 == 0) goto L_0x008e
            r2 = 3
            goto L_0x00a1
        L_0x008e:
            androidx.fragment.app.FragmentActivity r2 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r6 = net.one97.paytm.wallet.R.string.mobile_number_prefix_0     // Catch:{ all -> 0x014c }
            java.lang.String r2 = r2.getString(r6)     // Catch:{ all -> 0x014c }
            boolean r2 = r14.startsWith(r2)     // Catch:{ all -> 0x014c }
            if (r2 == 0) goto L_0x00a0
            r2 = 1
            goto L_0x00a1
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            int r6 = r14.length()     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r14.substring(r2, r6)     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r14.trim()     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r14.replaceAll(r0, r3)     // Catch:{ all -> 0x014c }
            int r0 = r14.length()     // Catch:{ all -> 0x014c }
            r2 = 10
            if (r0 != r2) goto L_0x00ba
            r12 = r14
        L_0x00ba:
            if (r12 == 0) goto L_0x0109
            java.lang.String r14 = "^([6,7,8,9]{1}+[0-9]{9})$"
            java.util.regex.Pattern r14 = java.util.regex.Pattern.compile(r14)     // Catch:{ all -> 0x014c }
            java.util.regex.Matcher r14 = r14.matcher(r12)     // Catch:{ all -> 0x014c }
            if (r12 == 0) goto L_0x00ed
            boolean r14 = r14.find()     // Catch:{ all -> 0x014c }
            if (r14 == 0) goto L_0x00ed
            android.widget.AutoCompleteTextView r14 = r11.m     // Catch:{ all -> 0x014c }
            r0 = 20
            a((android.widget.AutoCompleteTextView) r14, (int) r0)     // Catch:{ all -> 0x014c }
            android.widget.AutoCompleteTextView r14 = r11.m     // Catch:{ all -> 0x014c }
            if (r14 == 0) goto L_0x00de
            android.widget.AutoCompleteTextView r14 = r11.m     // Catch:{ all -> 0x014c }
            r14.setText(r1)     // Catch:{ all -> 0x014c }
        L_0x00de:
            r11.l = r12     // Catch:{ all -> 0x014c }
            r11.k = r1     // Catch:{ all -> 0x014c }
            android.widget.AutoCompleteTextView r12 = r11.m     // Catch:{ all -> 0x014c }
            r12.setEnabled(r5)     // Catch:{ all -> 0x014c }
            android.widget.ImageView r12 = r11.H     // Catch:{ all -> 0x014c }
            r12.setVisibility(r5)     // Catch:{ all -> 0x014c }
            goto L_0x0125
        L_0x00ed:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r14 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r0 = net.one97.paytm.wallet.R.string.error     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r14.getString(r0)     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r1 = net.one97.paytm.wallet.R.string.invalid_mobileno_msg     // Catch:{ all -> 0x014c }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x014c }
            com.paytm.utility.b.b((android.content.Context) r12, (java.lang.String) r14, (java.lang.String) r0)     // Catch:{ all -> 0x014c }
            goto L_0x0124
        L_0x0109:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r14 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r0 = net.one97.paytm.wallet.R.string.error     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r14.getString(r0)     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r1 = net.one97.paytm.wallet.R.string.invalid_mobileno_msg     // Catch:{ all -> 0x014c }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x014c }
            com.paytm.utility.b.b((android.content.Context) r12, (java.lang.String) r14, (java.lang.String) r0)     // Catch:{ all -> 0x014c }
        L_0x0124:
            r4 = 0
        L_0x0125:
            if (r4 != 0) goto L_0x0146
            r11.e()     // Catch:{ all -> 0x014c }
            goto L_0x0146
        L_0x012b:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r14 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r0 = net.one97.paytm.wallet.R.string.error     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r14.getString(r0)     // Catch:{ all -> 0x014c }
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()     // Catch:{ all -> 0x014c }
            int r1 = net.one97.paytm.wallet.R.string.invalid_mobileno_msg     // Catch:{ all -> 0x014c }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x014c }
            com.paytm.utility.b.b((android.content.Context) r12, (java.lang.String) r14, (java.lang.String) r0)     // Catch:{ all -> 0x014c }
        L_0x0146:
            if (r13 == 0) goto L_0x0158
            r13.close()
            return
        L_0x014c:
            r12 = move-exception
            goto L_0x0152
        L_0x014e:
            r13 = move-exception
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x0152:
            if (r13 == 0) goto L_0x0157
            r13.close()
        L_0x0157:
            throw r12
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.postcard.b.g.onActivityResult(int, int, android.content.Intent):void");
    }

    private void e() {
        if (getActivity() != null) {
            this.l = "";
            this.k = "";
            this.H.setVisibility(4);
            this.m.setEnabled(true);
            this.m.setText("");
            a(this.m, 10);
        }
    }

    private static void a(AutoCompleteTextView autoCompleteTextView, int i2) {
        autoCompleteTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    private void a(String str, String str2, String str3, View.OnClickListener onClickListener) {
        try {
            this.q = new com.paytm.utility.h(getActivity());
            this.q.setTitle(str);
            this.q.a(str2);
            this.q.setCancelable(false);
            this.q.a(-3, str3, onClickListener);
            this.q.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private void a(String str, String str2) {
        this.q = new com.paytm.utility.h(getActivity());
        this.q.setTitle(str);
        this.q.a(str2);
        this.q.setCancelable(true);
        this.q.a(-3, getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.q.dismiss();
                g.this.o.setText("");
            }
        });
        this.q.show();
    }

    private void f() {
        try {
            a(-100.0f, 0.0f, this.f71320d);
            a(0.0f, -200.0f, this.f71321e);
            a(200.0f, 0.0f, this.f71322f);
            a(150.0f, 0.0f, this.f71323g);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    private static void a(float f2, float f3, ImageView imageView) {
        try {
            TranslateAnimation translateAnimation = new TranslateAnimation(f2, 0.0f, f3, 0.0f);
            translateAnimation.setDuration(1000);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            imageView.startAnimation(translateAnimation);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public final void a(Bundle bundle) {
        if (getActivity() != null) {
            try {
                this.A = true;
                this.w = (PostcardThemesResponseDataModel) bundle.getSerializable("key_themes_data");
                if (this.w == null || this.w.getResponse() == null || this.w.getResponse().size() <= 0) {
                    b(getString(R.string.error), getString(R.string.some_went_wrong));
                } else {
                    int i2 = 0;
                    if (this.y == null) {
                        this.y = this.w.getResponse().get(0);
                        this.x = this.y.getId();
                    } else {
                        while (true) {
                            if (i2 >= this.w.getResponse().size()) {
                                break;
                            } else if (this.w.getResponse().get(i2).getId().equalsIgnoreCase(this.x)) {
                                this.y = this.w.getResponse().get(i2);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    this.p.setText(this.y.getDescription());
                    c();
                }
                b();
            } catch (Exception unused) {
                b();
                b(getString(R.string.error), getString(R.string.some_went_wrong));
            }
        }
    }

    private void b(String str, String str2) {
        com.paytm.utility.b.b((Context) getActivity(), str, str2);
    }

    static /* synthetic */ void a(g gVar, int i2) {
        if (i2 == 0) {
            gVar.f71325i.setVisibility(0);
        } else {
            gVar.f71325i.setVisibility(8);
        }
    }
}
