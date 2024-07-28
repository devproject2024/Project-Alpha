package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.m.p;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.bc;
import net.one97.paytm.oauth.fragment.bw;
import net.one97.paytm.oauth.g.k;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class SavedCardListFragment extends v implements bw.b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56159a = {y.a((t) new u(y.b(SavedCardListFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    public static final a f56160b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private k f56161c;

    /* renamed from: d  reason: collision with root package name */
    private String f56162d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f56163e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f56164f = "phone_update_logout";

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56165g;

    public final View a(int i2) {
        if (this.f56165g == null) {
            this.f56165g = new HashMap();
        }
        View view = (View) this.f56165g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56165g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56165g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SavedCardListFragment f56166a;

        b(SavedCardListFragment savedCardListFragment) {
            this.f56166a = savedCardListFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56166a.a(R.id.loader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56166a.a((ErrorModel) t);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56166a.a((IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SavedCardListFragment f56167a;

        c(SavedCardListFragment savedCardListFragment) {
            this.f56167a = savedCardListFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56167a.a(R.id.loader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56167a.a((ErrorModel) t);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56167a.a((IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    public static final class e extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.$this_navArgs = fragment;
        }

        public final Bundle invoke() {
            Bundle arguments = this.$this_navArgs.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException("Fragment " + this.$this_navArgs + " has null arguments");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        ai a2 = am.a((Fragment) this).a(k.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…oneViewModel::class.java)");
        this.f56161c = (k) a2;
        return layoutInflater.inflate(R.layout.fragment_saved_card_list, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (com.paytm.utility.b.r(requireContext())) {
            this.f56164f = "phone_update_login";
        }
        kotlin.g dVar = new androidx.navigation.d(y.b(bb.class), new e(this));
        this.f56162d = ((bb) dVar.getValue()).a();
        this.f56163e = ((bb) dVar.getValue()).b();
        RadioGroup radioGroup = (RadioGroup) a(R.id.radioGroup);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new f(this));
        }
        b();
    }

    static final class f implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SavedCardListFragment f56169a;

        f(SavedCardListFragment savedCardListFragment) {
            this.f56169a = savedCardListFragment;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) radioGroup.findViewById(i2);
            if (appCompatRadioButton != null) {
                SavedCardListFragment savedCardListFragment = this.f56169a;
                String a2 = p.a(appCompatRadioButton.getText().toString(), " ", "", false);
                RadioGroup radioGroup2 = (RadioGroup) this.f56169a.a(R.id.radioGroup);
                SavedCardListFragment.a(savedCardListFragment, a2, String.valueOf(radioGroup2 != null ? Integer.valueOf(radioGroup2.indexOfChild(appCompatRadioButton)) : null));
                RadioGroup radioGroup3 = (RadioGroup) this.f56169a.a(R.id.radioGroup);
                if (radioGroup3 != null) {
                    radioGroup3.clearCheck();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        OAuthUtils.a((Activity) requireActivity());
        OAuthUtils.a((LottieAnimationView) a(R.id.loader));
        if (com.paytm.utility.b.r(requireContext())) {
            if (this.f56161c == null) {
                kotlin.g.b.k.a("viewModel");
            }
            String str = this.f56163e;
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
            k.e(str, b2.getSSOToken()).observe(this, new b(this));
            return;
        }
        if (this.f56161c == null) {
            kotlin.g.b.k.a("viewModel");
        }
        k.c(this.f56163e).observe(this, new c(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof net.one97.paytm.oauth.models.SavedCardsResModel
            if (r0 == 0) goto L_0x00fb
            net.one97.paytm.oauth.models.SavedCardsResModel r9 = (net.one97.paytm.oauth.models.SavedCardsResModel) r9
            net.one97.paytm.oauth.models.ResultInfo r0 = r9.getResultInfo()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getResultStatus()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            if (r0 != 0) goto L_0x0017
            goto L_0x00ee
        L_0x0017:
            int r2 = r0.hashCode()
            r3 = 83
            if (r2 == r3) goto L_0x0021
            goto L_0x00ee
        L_0x0021:
            java.lang.String r2 = "S"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00ee
            net.one97.paytm.oauth.models.RenderData r9 = r9.getRenderData()
            r0 = 0
            if (r9 == 0) goto L_0x0064
            java.lang.String r9 = r9.getMaskedCardList()
            if (r9 == 0) goto L_0x0064
            java.lang.String r2 = ""
            java.lang.String r3 = "\\"
            java.lang.String r9 = kotlin.m.p.a(r9, r3, r2, r0)
            if (r9 == 0) goto L_0x0064
            java.lang.String r3 = "\""
            java.lang.String r9 = kotlin.m.p.a(r9, r3, r2, r0)
            if (r9 == 0) goto L_0x0064
            java.lang.String r3 = "["
            java.lang.String r9 = kotlin.m.p.a(r9, r3, r2, r0)
            if (r9 == 0) goto L_0x0064
            java.lang.String r3 = "]"
            java.lang.String r9 = kotlin.m.p.a(r9, r3, r2, r0)
            if (r9 == 0) goto L_0x0064
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r1 = ","
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.List r1 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.String[]) r1)
        L_0x0064:
            if (r1 == 0) goto L_0x00ed
            java.lang.String r9 = r8.f56164f
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = r8.c()
            r2[r0] = r3
            int r3 = r1.size()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r4 = 1
            r2[r4] = r3
            java.util.ArrayList r2 = kotlin.a.k.d(r2)
            r3 = 16
            java.lang.String r5 = "/list_of_saved_cards"
            java.lang.String r6 = "list_of_saved_cards_page_loaded"
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r5, (java.lang.String) r9, (java.lang.String) r6, (java.util.ArrayList) r2, (int) r3)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r9 = r1.iterator()
            r1 = 0
        L_0x0090:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00ed
            java.lang.Object r2 = r9.next()
            java.lang.String r2 = (java.lang.String) r2
            androidx.appcompat.widget.AppCompatRadioButton r3 = new androidx.appcompat.widget.AppCompatRadioButton
            android.content.Context r5 = r8.requireContext()
            r3.<init>(r5)
            r5 = 1101004800(0x41a00000, float:20.0)
            r3.setTextSize(r5)
            android.widget.RadioGroup$LayoutParams r5 = new android.widget.RadioGroup$LayoutParams
            r6 = -1
            r7 = -2
            r5.<init>(r6, r7)
            r6 = 50
            r5.topMargin = r6
            r6 = 20
            r3.setPadding(r6, r0, r0, r0)
            if (r2 == 0) goto L_0x00e5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r2 = kotlin.m.p.b(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = net.one97.paytm.oauth.utils.OAuthUtils.f(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
            int r1 = r1 + r4
            r3.setId(r1)
            int r2 = net.one97.paytm.oauth.R.id.radioGroup
            android.view.View r2 = r8.a((int) r2)
            android.widget.RadioGroup r2 = (android.widget.RadioGroup) r2
            if (r2 == 0) goto L_0x0090
            android.view.View r3 = (android.view.View) r3
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r2.addView(r3, r5)
            goto L_0x0090
        L_0x00e5:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r9.<init>(r0)
            throw r9
        L_0x00ed:
            return
        L_0x00ee:
            net.one97.paytm.oauth.models.ResultInfo r9 = r9.getResultInfo()
            if (r9 == 0) goto L_0x00f8
            java.lang.String r1 = r9.getResultMsg()
        L_0x00f8:
            r8.b(r1)
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.SavedCardListFragment.a(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void a(ErrorModel errorModel) {
        kotlin.g.b.k.c(errorModel, "model");
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, errorModel.getCustomError())) {
            if (errorModel.getStatus() == -1) {
                String string = getString(R.string.no_connection);
                kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                String string2 = getString(R.string.no_internet);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.no_internet)");
                OAuthUtils.a(requireContext(), string, string2, new d(this));
            } else if (errorModel.getCustomError() instanceof NetworkCustomError) {
                byte[] bArr = errorModel.getCustomError().networkResponse.data;
                if (bArr == null) {
                    return;
                }
                if (!TextUtils.isEmpty(new String(bArr, kotlin.m.d.f47971a))) {
                    try {
                        b(new JSONObject(new String(bArr, kotlin.m.d.f47971a)).getString("message"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        b(getString(R.string.some_went_wrong));
                    }
                } else {
                    NetworkCustomError customError = errorModel.getCustomError();
                    kotlin.g.b.k.a((Object) customError, "model.customError");
                    if (!TextUtils.isEmpty(customError.getAlertMessage())) {
                        NetworkCustomError customError2 = errorModel.getCustomError();
                        kotlin.g.b.k.a((Object) customError2, "model.customError");
                        b(customError2.getAlertMessage());
                    }
                }
            } else {
                b(getString(R.string.some_went_wrong));
            }
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SavedCardListFragment f56168a;

        d(SavedCardListFragment savedCardListFragment) {
            this.f56168a = savedCardListFragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56168a.b();
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "stateToken");
        bc.a a2 = bc.a();
        kotlin.g.b.k.a((Object) a2, "SavedCardListFragmentDir…navActionEnterNewNumber()");
        a2.a(str);
        a2.b("/list_of_saved_cards");
        a2.c("saved_cards");
        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) a2);
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SavedCardListFragment f56170a;

        g(SavedCardListFragment savedCardListFragment) {
            this.f56170a = savedCardListFragment;
        }

        public final void onClick(View view) {
            this.f56170a.requireActivity().setResult(-1);
            this.f56170a.requireActivity().finish();
        }
    }

    private final void b(String str) {
        net.one97.paytm.oauth.d.a.a(requireContext(), str, (View.OnClickListener) new g(this));
    }

    public static final /* synthetic */ void a(SavedCardListFragment savedCardListFragment, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("card_position", str2);
        bundle.putString("marked_card_no", str);
        bundle.putString("stateToken", savedCardListFragment.f56162d);
        bundle.putString("verifierId", savedCardListFragment.f56163e);
        bw.a aVar = bw.f56541c;
        kotlin.g.b.k.c(bundle, "bundle");
        bw bwVar = new bw();
        bwVar.setArguments(bundle);
        bw.b bVar = savedCardListFragment;
        kotlin.g.b.k.c(bVar, "listener");
        bwVar.f56542b = bVar;
        bwVar.setCancelable(false);
        j fragmentManager = savedCardListFragment.getFragmentManager();
        q a2 = fragmentManager != null ? fragmentManager.a() : null;
        if (a2 != null) {
            a2.a((Fragment) bwVar, bw.class.getName());
            a2.c();
        }
    }
}
