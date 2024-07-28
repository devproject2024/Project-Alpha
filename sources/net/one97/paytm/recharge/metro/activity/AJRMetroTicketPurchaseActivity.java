package net.one97.paytm.recharge.metro.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ag;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.c.i;
import net.one97.paytm.recharge.metro.c.m;
import net.one97.paytm.recharge.metro.e.b;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2;
import net.one97.paytm.recharge.ordersummary.f.g;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public class AJRMetroTicketPurchaseActivity extends CJRBaseMetroActivity implements View.OnClickListener, ag, net.one97.paytm.recharge.metro.e.a, g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f63219a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressDialog f63220b;

    /* renamed from: c  reason: collision with root package name */
    private CJRUtilityVariantV2 f63221c;

    /* renamed from: d  reason: collision with root package name */
    private CJRUtilityVariantV2 f63222d;

    /* renamed from: e  reason: collision with root package name */
    private a f63223e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f63224g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f63225h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f63226i;
    private String j;
    private Fragment k;
    private String l;
    private String m = "";
    private HashMap n;

    public interface a {
        void a(CJRFrequentOrder cJRFrequentOrder);
    }

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onCreate(Bundle bundle) {
        CharSequence charSequence;
        String str;
        CJRUtilityProductV2 product;
        CJRUtilityAttributesV2 attributes;
        CJRUtilityProductV2 product2;
        CJRUtilityAttributesV2 attributes2;
        CJRUtilityProductV2 product3;
        CJRUtilityAttributesV2 attributes3;
        String str2;
        CJRUtilityProductV2 product4;
        CJRUtilityAttributesV2 attributes4;
        String filterName;
        CJRUtilityProductV2 product5;
        CJRUtilityAttributesV2 attributes5;
        String str3;
        String displayName;
        super.onCreate(bundle);
        Serializable serializableExtra = getIntent().getSerializableExtra("metroTicketVariant");
        String str4 = null;
        if (!(serializableExtra instanceof CJRUtilityVariantV2)) {
            serializableExtra = null;
        }
        this.f63221c = (CJRUtilityVariantV2) serializableExtra;
        Serializable serializableExtra2 = getIntent().getSerializableExtra("productVariant");
        if (!(serializableExtra2 instanceof CJRUtilityVariantV2)) {
            serializableExtra2 = null;
        }
        this.f63222d = (CJRUtilityVariantV2) serializableExtra2;
        CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63222d;
        if (cJRUtilityVariantV2 != null) {
            if ((cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getProduct() : null) != null) {
                d dVar = d.f64967a;
                CJRRechargeErrorModel b2 = d.b();
                CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63222d;
                if (cJRUtilityVariantV22 == null) {
                    k.a();
                }
                CJRUtilityProductV2 product6 = cJRUtilityVariantV22.getProduct();
                k.a((Object) product6, "mProductVariant!!.product");
                b2.setProductId(String.valueOf(product6.getId()));
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            k.a((Object) window, "window");
            window.setStatusBarColor(androidx.core.content.b.c(this, R.color.color_fafbfb));
        }
        if (getIntent().hasExtra("vertical_name")) {
            String stringExtra = getIntent().getStringExtra("vertical_name");
            k.a((Object) stringExtra, "intent.getStringExtra(CJ…TENT_EXTRA_VERTICAL_NAME)");
            this.m = stringExtra;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_abs);
        if (linearLayout != null) {
            linearLayout.addView(getLayoutInflater().inflate(R.layout.custom_abs_layout_metro, (ViewGroup) null, false), 0);
        }
        View findViewById = findViewById(R.id.back_button);
        k.a((Object) findViewById, "findViewById<ImageView>(R.id.back_button)");
        this.f63226i = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tv_ab_title);
        k.a((Object) findViewById2, "findViewById<TextView>(R.id.tv_ab_title)");
        this.f63225h = (TextView) findViewById2;
        TextView textView = this.f63225h;
        if (textView == null) {
            k.a("abTitle");
        }
        CJRUtilityVariantV2 cJRUtilityVariantV23 = this.f63222d;
        if (cJRUtilityVariantV23 == null || (displayName = cJRUtilityVariantV23.getDisplayName()) == null) {
            CJRUtilityVariantV2 cJRUtilityVariantV24 = this.f63221c;
            if (cJRUtilityVariantV24 == null || (str3 = cJRUtilityVariantV24.getDisplayName()) == null) {
                str3 = "Mumbai Metro";
            }
            charSequence = str3;
        } else {
            charSequence = displayName;
        }
        textView.setText(charSequence);
        ImageView imageView = this.f63226i;
        if (imageView == null) {
            k.a("backButton");
        }
        imageView.setOnClickListener(this);
        Bundle bundle2 = new Bundle();
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        bundle2.putAll(intent.getExtras());
        bundle2.putSerializable("metroTicketVariant", this.f63221c);
        CJRUtilityVariantV2 cJRUtilityVariantV25 = this.f63222d;
        this.j = (cJRUtilityVariantV25 == null || (product5 = cJRUtilityVariantV25.getProduct()) == null || (attributes5 = product5.getAttributes()) == null) ? null : attributes5.getSelectedProductRequestType();
        bundle2.putString("product-type", this.j);
        bundle2.putString("vertical_name", this.m);
        CJRUtilityVariantV2 cJRUtilityVariantV26 = this.f63222d;
        if (cJRUtilityVariantV26 == null || (filterName = cJRUtilityVariantV26.getFilterName()) == null) {
            str = null;
        } else if (filterName != null) {
            str = filterName.toLowerCase();
            k.a((Object) str, "(this as java.lang.String).toLowerCase()");
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        c.a aVar = c.f63576a;
        String c2 = c.f63579d;
        if (c2 != null) {
            String lowerCase = c2.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str, (Object) lowerCase)) {
                CJRUtilityVariantV2 cJRUtilityVariantV27 = this.f63221c;
                if (p.a("Delhi Metro", cJRUtilityVariantV27 != null ? cJRUtilityVariantV27.getFilterName() : null, true)) {
                    str2 = "DELHI_METRO_SJT";
                } else {
                    CJRUtilityVariantV2 cJRUtilityVariantV28 = this.f63222d;
                    str2 = (cJRUtilityVariantV28 == null || (product4 = cJRUtilityVariantV28.getProduct()) == null || (attributes4 = product4.getAttributes()) == null) ? null : attributes4.getSingleJourneyType();
                }
                this.j = str2;
                bundle2.putString("product-type", this.j);
                this.l = i.class.getSimpleName();
                this.k = Fragment.instantiate(this, i.class.getName(), bundle2);
            } else {
                c.a aVar2 = c.f63576a;
                String b3 = c.f63578c;
                if (b3 != null) {
                    String lowerCase2 = b3.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (k.a((Object) str, (Object) lowerCase2)) {
                        this.l = m.class.getSimpleName();
                        this.k = Fragment.instantiate(this, m.class.getName(), bundle2);
                    } else {
                        c.a aVar3 = c.f63576a;
                        String d2 = c.f63580e;
                        if (d2 != null) {
                            String lowerCase3 = d2.toLowerCase();
                            k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
                            if (k.a((Object) str, (Object) lowerCase3)) {
                                this.l = net.one97.paytm.recharge.metro.c.k.class.getSimpleName();
                                this.k = Fragment.instantiate(this, net.one97.paytm.recharge.metro.c.k.class.getName(), bundle2);
                            } else {
                                finish();
                                return;
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            if (com.paytm.utility.d.c(this) && !TextUtils.isEmpty(this.j)) {
                try {
                    c.a aVar4 = c.f63576a;
                    CJRUtilityVariantV2 cJRUtilityVariantV29 = this.f63222d;
                    String selectedProductRequestType = (cJRUtilityVariantV29 == null || (product3 = cJRUtilityVariantV29.getProduct()) == null || (attributes3 = product3.getAttributes()) == null) ? null : attributes3.getSelectedProductRequestType();
                    if (selectedProductRequestType == null) {
                        k.a();
                    }
                    CJRMetroQRFrequentOrderList d3 = c.a.d(selectedProductRequestType);
                    if (d3 == null || d3.getmOrderList().size() == 0) {
                        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                        String aq = net.one97.paytm.recharge.di.helper.c.aq();
                        HashMap hashMap = new HashMap();
                        String a2 = com.paytm.utility.d.a(this);
                        k.a((Object) a2, "CJRNetUtility.getSSOToke…roTicketPurchaseActivity)");
                        hashMap.put(AppConstants.SSO_TOKEN, a2);
                        if (!TextUtils.isEmpty(aq)) {
                            String a3 = k.a(aq, (Object) "?customer_id=" + com.paytm.utility.b.n((Context) this));
                            CJRUtilityVariantV2 cJRUtilityVariantV210 = this.f63222d;
                            String selectedProductRequestType2 = (cJRUtilityVariantV210 == null || (product2 = cJRUtilityVariantV210.getProduct()) == null || (attributes2 = product2.getAttributes()) == null) ? null : attributes2.getSelectedProductRequestType();
                            if (selectedProductRequestType2 == null) {
                                k.a();
                            }
                            if (!k.a((Object) "Mumbai_Metro_All_recents", (Object) selectedProductRequestType2)) {
                                StringBuilder sb = new StringBuilder("&reqtype=");
                                CJRUtilityVariantV2 cJRUtilityVariantV211 = this.f63222d;
                                sb.append((cJRUtilityVariantV211 == null || (product = cJRUtilityVariantV211.getProduct()) == null || (attributes = product.getAttributes()) == null) ? null : attributes.getSelectedProductRequestType());
                                a3 = k.a(a3, (Object) sb.toString());
                            }
                            String str5 = a3;
                            d dVar2 = d.f64967a;
                            CJRRechargeErrorModel a4 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                            CRUFlowModel flowName = a4.getFlowName();
                            if (flowName == null) {
                                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
                            }
                            a4.setFlowName(flowName);
                            CRUFlowModel flowName2 = a4.getFlowName();
                            if (flowName2 != null) {
                                flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
                            }
                            CRUFlowModel flowName3 = a4.getFlowName();
                            if (flowName3 != null) {
                                flowName3.setActionType(ACTION_TYPE.METRO_RECENT.name());
                            }
                            CRUFlowModel flowName4 = a4.getFlowName();
                            if (flowName4 != null) {
                                StringBuilder sb2 = new StringBuilder();
                                CJRUtilityVariantV2 cJRUtilityVariantV212 = this.f63221c;
                                sb2.append(cJRUtilityVariantV212 != null ? cJRUtilityVariantV212.getFilterName() : null);
                                sb2.append("/");
                                CJRUtilityVariantV2 cJRUtilityVariantV213 = this.f63222d;
                                if (cJRUtilityVariantV213 != null) {
                                    str4 = cJRUtilityVariantV213.getFilterName();
                                }
                                sb2.append(str4);
                                flowName4.setVariantType(sb2.toString());
                            }
                            CRUFlowModel flowName5 = a4.getFlowName();
                            if (flowName5 != null) {
                                flowName5.setTag("metro_recents");
                            }
                            net.one97.paytm.recharge.common.f.d.a();
                            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b("metro_recents", str5, this, new CJRMetroQRFrequentOrderListV2(), hashMap, a4));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            Fragment fragment = this.k;
            if (fragment instanceof a) {
                if (fragment != null) {
                    this.f63223e = (a) fragment;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity.IJRMetroTicketPurchaseFragment");
                }
            }
            j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                q a5 = supportFragmentManager.a();
                int id = c().getId();
                Fragment fragment2 = this.k;
                if (fragment2 == null) {
                    k.a();
                }
                a5.b(id, fragment2, this.l).c();
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList;
        CJRUtilityProductV2 product;
        CJRUtilityAttributesV2 attributes;
        CJRUtilityProductV2 product2;
        CJRUtilityAttributesV2 attributes2;
        k.c(str, "tag");
        CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63221c;
        String str2 = null;
        if (!p.a("Mumbai Metro", cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null, true)) {
            CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63221c;
            if (p.a("Delhi Metro", cJRUtilityVariantV22 != null ? cJRUtilityVariantV22.getFilterName() : null, true)) {
                if (iJRPaytmDataModel != null) {
                    cJRMetroQRFrequentOrderList = ((CJRMetroQRFrequentOrderListV2) iJRPaytmDataModel).getMDelhiOrders();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2");
                }
            } else if (iJRPaytmDataModel != null) {
                cJRMetroQRFrequentOrderList = ((CJRMetroQRFrequentOrderListV2) iJRPaytmDataModel).getMHyderabadOrders();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2");
            }
        } else if (iJRPaytmDataModel != null) {
            cJRMetroQRFrequentOrderList = ((CJRMetroQRFrequentOrderListV2) iJRPaytmDataModel).getMMumbaiOrders();
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderListV2");
        }
        CJRUtilityVariantV2 cJRUtilityVariantV23 = this.f63222d;
        if (!TextUtils.isEmpty((cJRUtilityVariantV23 == null || (product2 = cJRUtilityVariantV23.getProduct()) == null || (attributes2 = product2.getAttributes()) == null) ? null : attributes2.getSelectedProductRequestType())) {
            c.a aVar = c.f63576a;
            CJRUtilityVariantV2 cJRUtilityVariantV24 = this.f63222d;
            if (!(cJRUtilityVariantV24 == null || (product = cJRUtilityVariantV24.getProduct()) == null || (attributes = product.getAttributes()) == null)) {
                str2 = attributes.getSelectedProductRequestType();
            }
            if (str2 == null) {
                k.a();
            }
            if (cJRMetroQRFrequentOrderList == null) {
                k.a();
            }
            c.a.a(str2, cJRMetroQRFrequentOrderList);
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        if ((iJRPaytmDataModel instanceof CJRMetroQRFrequentOrderListV2) && (obj instanceof CJRRechargeErrorModel)) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    public final void at_() {
        if (!isFinishing() && !isDestroyed()) {
            ProgressDialog progressDialog = this.f63220b;
            if (progressDialog == null) {
                this.f63220b = ProgressDialog.show(this, "", getString(R.string.please_wait), true);
            } else if (progressDialog != null) {
                progressDialog.show();
            }
        }
    }

    public final void o() {
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        try {
            if (this.f63220b != null && (progressDialog = this.f63220b) != null && progressDialog.isShowing() && !isFinishing() && (progressDialog2 = this.f63220b) != null) {
                progressDialog2.dismiss();
            }
        } catch (IllegalStateException unused) {
            this.f63220b = null;
        } catch (Exception unused2) {
            this.f63220b = null;
        }
    }

    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.back_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            onBackPressed();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r9 = r9.getProduct();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder
            java.lang.String r3 = "operator_variant"
            r4 = 0
            java.lang.String r5 = "intent_extra_item_index"
            r6 = 1
            if (r2 == 0) goto L_0x00a9
            r2 = r1
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r2 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r2
            java.lang.String r7 = r2.getProductID()
            r8 = 0
            if (r7 == 0) goto L_0x003a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r9 = r0.f63222d
            if (r9 == 0) goto L_0x002b
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r9 = r9.getProduct()
            if (r9 == 0) goto L_0x002b
            long r9 = r9.getId()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            goto L_0x002c
        L_0x002b:
            r9 = r8
        L_0x002c:
            boolean r7 = r7.equals(r9)
            if (r7 != r6) goto L_0x003a
            net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity$a r2 = r0.f63223e
            if (r2 == 0) goto L_0x0039
            r2.a(r1)
        L_0x0039:
            return
        L_0x003a:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r7 = r0.f63221c
            r9 = -1
            if (r7 == 0) goto L_0x0087
            java.util.List r7 = r7.getVariants()
            if (r7 == 0) goto L_0x0087
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r4 = r8
            r10 = -1
            r11 = 0
        L_0x004e:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x0089
            java.lang.Object r12 = r7.next()
            int r13 = r11 + 1
            if (r11 >= 0) goto L_0x005f
            kotlin.a.k.a()
        L_0x005f:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r12 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r12
            java.lang.String r14 = r2.getProductID()
            if (r14 == 0) goto L_0x0085
            java.lang.String r15 = "variant"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r15)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r15 = r12.getProduct()
            if (r15 == 0) goto L_0x007c
            long r15 = r15.getId()
            java.lang.String r15 = java.lang.String.valueOf(r15)
            goto L_0x007d
        L_0x007c:
            r15 = r8
        L_0x007d:
            boolean r14 = r14.equals(r15)
            if (r14 != r6) goto L_0x0085
            r10 = r11
            r4 = r12
        L_0x0085:
            r11 = r13
            goto L_0x004e
        L_0x0087:
            r4 = r8
            r10 = -1
        L_0x0089:
            if (r10 == r9) goto L_0x00a8
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            android.content.Intent r2 = r2.putExtra(r5, r10)
            java.io.Serializable r4 = (java.io.Serializable) r4
            android.content.Intent r2 = r2.putExtra(r3, r4)
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r3 = "metro_qr_frequent_object"
            android.content.Intent r1 = r2.putExtra(r3, r1)
            r0.setResult(r6, r1)
            r17.finish()
        L_0x00a8:
            return
        L_0x00a9:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            android.content.Intent r2 = r2.putExtra(r5, r4)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r4 = r0.f63221c
            java.io.Serializable r4 = (java.io.Serializable) r4
            android.content.Intent r2 = r2.putExtra(r3, r4)
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r3 = "frequent_object"
            android.content.Intent r1 = r2.putExtra(r3, r1)
            r0.setResult(r6, r1)
            r17.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity.a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder):void");
    }

    public final void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        k.c(jSONObject2, "errorInfoJson");
        if (!TextUtils.isEmpty(jSONObject2.optString("code")) && k.a((Object) "DT_400", (Object) jSONObject2.optString("code"))) {
            this.f63224g = true;
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName == null) {
                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
            }
            a2.setFlowName(flowName);
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setActionType(ACTION_TYPE.GET_ACTIVE_TICKET_AND_PASSES.name());
            }
            net.one97.paytm.recharge.metro.f.a.a("fetch_active_active_tickets", (Context) this, (b.a<List<CJRActiveMetroTicketModel>>) null, (ai) new b(), (Object) a2);
        }
    }

    public static final class b implements ai {
        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
        }

        b() {
        }
    }

    public void onBackPressed() {
        this.f63219a = true;
        if (this.f63224g) {
            setResult(1003);
        } else {
            setResult(1008);
        }
        finish();
        super.onBackPressed();
    }

    public void onDestroy() {
        this.f63219a = false;
        super.onDestroy();
    }
}
