package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.Address;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress;
import net.one97.paytm.common.entity.upgradeKyc.PermanentAddress;
import net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.b;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycProfileProfessionChooseActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.b;

public final class c extends net.one97.paytm.i.h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public a f65439a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CersaiDetails f65440b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.kycV3.c.h f65441c;

    /* renamed from: d  reason: collision with root package name */
    private int f65442d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f65443e = 1234;

    /* renamed from: f  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> f65444f = new e(this);

    /* renamed from: g  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<UADPincode>> f65445g = new j(this);

    /* renamed from: h  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> f65446h = new g(this);

    /* renamed from: i  reason: collision with root package name */
    private final b f65447i = new b(this);
    private final d j = new d(this);
    private final C1293c k = new C1293c(this);
    private final k l = new k(this);
    private final f m = new f(this);
    private final r n = new r(this);
    private HashMap o;

    public interface a {
        void aC_();
    }

    public final View a(int i2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.o.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65451a;

        e(c cVar) {
            this.f65451a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            NetworkCustomError networkCustomError;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar == null || (networkCustomError = bVar.f66170c) == null || (str = networkCustomError.getMessage()) == null) {
                str = this.f65451a.getString(R.string.kyc_something_went_wrong);
                kotlin.g.b.k.a((Object) str, "getString(R.string.kyc_something_went_wrong)");
            }
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = d.f65465a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65451a.a(R.id.wallet_loader_main));
                    Toast.makeText(this.f65451a.getActivity(), this.f65451a.getString(R.string.profile_saved_toast), 0).show();
                    a aVar = this.f65451a.f65439a;
                    if (aVar == null) {
                        kotlin.g.b.k.a("mHost");
                    }
                    aVar.aC_();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65451a.a(R.id.wallet_loader_main));
                    }
                } else if (this.f65451a.getActivity() != null && bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    FragmentActivity activity = this.f65451a.getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    Context context = activity;
                    NetworkCustomError networkCustomError2 = bVar.f66170c;
                    if (networkCustomError2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError2)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65451a.a(R.id.wallet_loader_main));
                        Snackbar.a((View) (ScrollView) this.f65451a.a(R.id.parent), (CharSequence) str, -1).c();
                    }
                }
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65453a;

        g(c cVar) {
            this.f65453a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = d.f65467c[dVar.ordinal()];
                if (i2 == 1) {
                    View a2 = this.f65453a.a(R.id.error_layout);
                    kotlin.g.b.k.a((Object) a2, "error_layout");
                    a2.setVisibility(8);
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65453a.a(R.id.wallet_loader_main));
                    c.a(this.f65453a, (IJRPaytmDataModel) bVar.f66169b);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65453a.a(R.id.wallet_loader_main));
                    }
                } else if (this.f65453a.getActivity() != null && bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    FragmentActivity activity = this.f65453a.getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    Context context = activity;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        View a3 = this.f65453a.a(R.id.error_layout);
                        kotlin.g.b.k.a((Object) a3, "error_layout");
                        a3.setVisibility(0);
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65453a.a(R.id.wallet_loader_main));
                    }
                }
            }
        }
    }

    static final class j<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<UADPincode>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65456a;

        j(c cVar) {
            this.f65456a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            UADPincode uADPincode;
            ArrayList<UADPincode.SubPincode> pincodeList;
            ArrayList<UADPincode.SubPincode> pincodeList2;
            UADPincode.SubPincode subPincode;
            ArrayList<UADPincode.SubPincode> pincodeList3;
            UADPincode.SubPincode subPincode2;
            NetworkCustomError networkCustomError;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar == null || (networkCustomError = bVar.f66170c) == null || (str = networkCustomError.getMessage()) == null) {
                str = this.f65456a.getString(R.string.kyc_something_went_wrong);
                kotlin.g.b.k.a((Object) str, "getString(R.string.kyc_something_went_wrong)");
            }
            String str2 = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = d.f65466b[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65456a.a(R.id.wallet_loader_main));
                    UADPincode uADPincode2 = (UADPincode) bVar.f66169b;
                    if ((uADPincode2 != null ? uADPincode2.getResponseCode() : null) != null) {
                        UADPincode uADPincode3 = (UADPincode) bVar.f66169b;
                        if (kotlin.g.b.k.a((Object) uADPincode3 != null ? uADPincode3.getResponseCode() : null, (Object) "200")) {
                            UADPincode uADPincode4 = (UADPincode) bVar.f66169b;
                            if ((uADPincode4 != null ? uADPincode4.getPincodeMap() : null) != null) {
                                UADPincode uADPincode5 = (UADPincode) bVar.f66169b;
                                Map<String, List<UADPincode.SubPincode>> pincodeMap = uADPincode5 != null ? uADPincode5.getPincodeMap() : null;
                                Set<String> keySet = pincodeMap != null ? pincodeMap.keySet() : null;
                                System.out.println("All keys are: ".concat(String.valueOf(keySet)));
                                if (keySet != null) {
                                    for (String next : keySet) {
                                        System.out.println(next + ": " + pincodeMap.get(next));
                                        List<UADPincode.SubPincode> list = pincodeMap.get(next);
                                        if (list != null) {
                                            List list2 = list;
                                            if (((TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_city)) != null) {
                                                ((TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_city)).setText(((UADPincode.SubPincode) list2.get(0)).getTier3Value());
                                            }
                                            if (((TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_state)) != null) {
                                                ((TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_state)).setText(((UADPincode.SubPincode) list2.get(0)).getState());
                                            }
                                        } else {
                                            throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.upgradeKyc.UADPincode.SubPincode>");
                                        }
                                    }
                                }
                            } else {
                                Toast.makeText(this.f65456a.getActivity(), this.f65456a.getString(R.string.msg_invalid_pin), 0).show();
                            }
                            UADPincode uADPincode6 = (UADPincode) bVar.f66169b;
                            if ((uADPincode6 != null ? uADPincode6.getPincodeList() : null) != null && (uADPincode = (UADPincode) bVar.f66169b) != null && (pincodeList = uADPincode.getPincodeList()) != null && (!pincodeList.isEmpty())) {
                                if (((TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_city)) != null) {
                                    TextInputEditText textInputEditText = (TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_city);
                                    UADPincode uADPincode7 = (UADPincode) bVar.f66169b;
                                    textInputEditText.setText((uADPincode7 == null || (pincodeList3 = uADPincode7.getPincodeList()) == null || (subPincode2 = pincodeList3.get(0)) == null) ? null : subPincode2.getTier3Value());
                                }
                                if (((TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_state)) != null) {
                                    TextInputEditText textInputEditText2 = (TextInputEditText) this.f65456a.a(R.id.layout_kyc_contact_details_et_state);
                                    UADPincode uADPincode8 = (UADPincode) bVar.f66169b;
                                    if (!(uADPincode8 == null || (pincodeList2 = uADPincode8.getPincodeList()) == null || (subPincode = pincodeList2.get(0)) == null)) {
                                        str2 = subPincode.getState();
                                    }
                                    textInputEditText2.setText(str2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    Toast.makeText(this.f65456a.getActivity(), str, 0).show();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65456a.a(R.id.wallet_loader_main));
                    }
                } else if (this.f65456a.getActivity() != null && bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    FragmentActivity activity = this.f65456a.getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    Context context = activity;
                    NetworkCustomError networkCustomError2 = bVar.f66170c;
                    if (networkCustomError2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError2)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65456a.a(R.id.wallet_loader_main));
                        Toast.makeText(this.f65456a.getActivity(), str, 0).show();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.c.h a(c cVar) {
        net.one97.paytm.upgradeKyc.kycV3.c.h hVar = cVar.f65441c;
        if (hVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return hVar;
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof a) {
            this.f65439a = (a) context;
            return;
        }
        throw new IllegalStateException(context + " must implement KycDetailsFragment.InteractionListener");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_kyc_details, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f65441c = (net.one97.paytm.upgradeKyc.kycV3.c.h) net.one97.paytm.upgradeKyc.kycV3.b.a((Fragment) this, net.one97.paytm.upgradeKyc.kycV3.c.h.class);
        net.one97.paytm.upgradeKyc.kycV3.c.h hVar = this.f65441c;
        if (hVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        hVar.f66240a.observe(getViewLifecycleOwner(), this.f65446h);
        net.one97.paytm.upgradeKyc.kycV3.c.h hVar2 = this.f65441c;
        if (hVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        hVar2.f66243d.observe(getViewLifecycleOwner(), this.f65445g);
        net.one97.paytm.upgradeKyc.kycV3.c.h hVar3 = this.f65441c;
        if (hVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        hVar3.f66241b.observe(getViewLifecycleOwner(), this.f65444f);
        net.one97.paytm.upgradeKyc.kycV3.c.h hVar4 = this.f65441c;
        if (hVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        hVar4.a();
        ((TextView) a(R.id.tv_retry)).setOnClickListener(new h(this));
        ((TextView) a(R.id.contact_us_tv)).setOnClickListener(new i(this));
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65454a;

        h(c cVar) {
            this.f65454a = cVar;
        }

        public final void onClick(View view) {
            View a2 = this.f65454a.a(R.id.error_layout);
            kotlin.g.b.k.a((Object) a2, "error_layout");
            a2.setVisibility(8);
            c.a(this.f65454a).a();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65455a;

        i(c cVar) {
            this.f65455a = cVar;
        }

        public final void onClick(View view) {
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            net.one97.paytm.upgradeKyc.helper.f b2 = e.a.b();
            FragmentActivity activity = this.f65455a.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            b2.a((Context) activity, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000005&l1=1200004");
        }
    }

    public final void onClick(View view) {
        CorrespondenceAddress coresspondenceAddress;
        CorrespondenceAddress coresspondenceAddress2;
        CorrespondenceAddress coresspondenceAddress3;
        CorrespondenceAddress coresspondenceAddress4;
        CorrespondenceAddress coresspondenceAddress5;
        CorrespondenceAddress coresspondenceAddress6;
        CorrespondenceAddress coresspondenceAddress7;
        Address address;
        CorrespondenceAddress coresspondenceAddress8;
        CorrespondenceAddress coresspondenceAddress9;
        View view2 = view;
        if (kotlin.g.b.k.a((Object) view2, (Object) (TextInputLayout) a(R.id.select_profession_til)) || kotlin.g.b.k.a((Object) view2, (Object) (TextInputEditText) a(R.id.profession_et))) {
            Intent intent = new Intent(getActivity(), KycProfileProfessionChooseActivity.class);
            int i2 = this.f65442d;
            if (i2 != -1) {
                intent.putExtra("profession", i2);
            }
            startActivityForResult(intent, this.f65443e);
        } else if (kotlin.g.b.k.a((Object) view2, (Object) (Button) a(R.id.fragment_cersai_details_save_btn)) && this.f65440b != null && a()) {
            CersaiDetails cersaiDetails = this.f65440b;
            if (cersaiDetails != null) {
                Address address2 = cersaiDetails.getAddress();
                String str = null;
                if ((address2 != null ? address2.getCoresspondenceAddress() : null) != null) {
                    Address address3 = cersaiDetails.getAddress();
                    if (!(address3 == null || (coresspondenceAddress9 = address3.getCoresspondenceAddress()) == null)) {
                        str = coresspondenceAddress9.getAction();
                    }
                    if (!(!TextUtils.isEmpty(str) || (address = cersaiDetails.getAddress()) == null || (coresspondenceAddress8 = address.getCoresspondenceAddress()) == null)) {
                        coresspondenceAddress8.setAction("edit");
                    }
                    Address address4 = cersaiDetails.getAddress();
                    if (!(address4 == null || (coresspondenceAddress7 = address4.getCoresspondenceAddress()) == null)) {
                        CheckBox checkBox = (CheckBox) a(R.id.correspondence_cb);
                        kotlin.g.b.k.a((Object) checkBox, "correspondence_cb");
                        coresspondenceAddress7.setSameAsPermanent(Boolean.valueOf(checkBox.isChecked()));
                    }
                    CheckBox checkBox2 = (CheckBox) a(R.id.correspondence_cb);
                    kotlin.g.b.k.a((Object) checkBox2, "correspondence_cb");
                    if (checkBox2.isChecked()) {
                        this.f65440b = cersaiDetails;
                    } else if (a()) {
                        Address address5 = cersaiDetails.getAddress();
                        if (!(address5 == null || (coresspondenceAddress6 = address5.getCoresspondenceAddress()) == null)) {
                            TextInputEditText textInputEditText = (TextInputEditText) a(R.id.address_line_one_et);
                            kotlin.g.b.k.a((Object) textInputEditText, "address_line_one_et");
                            coresspondenceAddress6.setAddressOne(String.valueOf(textInputEditText.getText()));
                        }
                        Address address6 = cersaiDetails.getAddress();
                        if (!(address6 == null || (coresspondenceAddress5 = address6.getCoresspondenceAddress()) == null)) {
                            TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.address_line_two_et);
                            kotlin.g.b.k.a((Object) textInputEditText2, "address_line_two_et");
                            coresspondenceAddress5.setAddressTwo(String.valueOf(textInputEditText2.getText()));
                        }
                        Address address7 = cersaiDetails.getAddress();
                        if (!(address7 == null || (coresspondenceAddress4 = address7.getCoresspondenceAddress()) == null)) {
                            TextInputEditText textInputEditText3 = (TextInputEditText) a(R.id.address_line_three_et);
                            kotlin.g.b.k.a((Object) textInputEditText3, "address_line_three_et");
                            coresspondenceAddress4.setAddressThree(String.valueOf(textInputEditText3.getText()));
                        }
                        Address address8 = cersaiDetails.getAddress();
                        if (!(address8 == null || (coresspondenceAddress3 = address8.getCoresspondenceAddress()) == null)) {
                            TextInputEditText textInputEditText4 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_city);
                            kotlin.g.b.k.a((Object) textInputEditText4, "layout_kyc_contact_details_et_city");
                            coresspondenceAddress3.setCity(String.valueOf(textInputEditText4.getText()));
                        }
                        Address address9 = cersaiDetails.getAddress();
                        if (!(address9 == null || (coresspondenceAddress2 = address9.getCoresspondenceAddress()) == null)) {
                            TextInputEditText textInputEditText5 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_state);
                            kotlin.g.b.k.a((Object) textInputEditText5, "layout_kyc_contact_details_et_state");
                            coresspondenceAddress2.setState(String.valueOf(textInputEditText5.getText()));
                        }
                        Address address10 = cersaiDetails.getAddress();
                        if (!(address10 == null || (coresspondenceAddress = address10.getCoresspondenceAddress()) == null)) {
                            TextInputEditText textInputEditText6 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
                            kotlin.g.b.k.a((Object) textInputEditText6, "layout_kyc_contact_details_et_pincode");
                            coresspondenceAddress.setPostalCode(String.valueOf(textInputEditText6.getText()));
                        }
                        this.f65440b = cersaiDetails;
                    }
                } else {
                    CorrespondenceAddress correspondenceAddress = new CorrespondenceAddress((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 1023, (kotlin.g.b.g) null);
                    CheckBox checkBox3 = (CheckBox) a(R.id.correspondence_cb);
                    kotlin.g.b.k.a((Object) checkBox3, "correspondence_cb");
                    correspondenceAddress.setSameAsPermanent(Boolean.valueOf(checkBox3.isChecked()));
                    correspondenceAddress.setAction("add");
                    if (!kotlin.g.b.k.a((Object) correspondenceAddress.isSameAsPermanent(), (Object) Boolean.FALSE)) {
                        cersaiDetails.setAddress(new Address((PermanentAddress) null, correspondenceAddress));
                        this.f65440b = cersaiDetails;
                    } else if (a()) {
                        TextInputEditText textInputEditText7 = (TextInputEditText) a(R.id.address_line_one_et);
                        kotlin.g.b.k.a((Object) textInputEditText7, "address_line_one_et");
                        correspondenceAddress.setAddressOne(String.valueOf(textInputEditText7.getText()));
                        TextInputEditText textInputEditText8 = (TextInputEditText) a(R.id.address_line_two_et);
                        kotlin.g.b.k.a((Object) textInputEditText8, "address_line_two_et");
                        correspondenceAddress.setAddressTwo(String.valueOf(textInputEditText8.getText()));
                        TextInputEditText textInputEditText9 = (TextInputEditText) a(R.id.address_line_three_et);
                        kotlin.g.b.k.a((Object) textInputEditText9, "address_line_three_et");
                        correspondenceAddress.setAddressThree(String.valueOf(textInputEditText9.getText()));
                        TextInputEditText textInputEditText10 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_city);
                        kotlin.g.b.k.a((Object) textInputEditText10, "layout_kyc_contact_details_et_city");
                        correspondenceAddress.setCity(String.valueOf(textInputEditText10.getText()));
                        TextInputEditText textInputEditText11 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_state);
                        kotlin.g.b.k.a((Object) textInputEditText11, "layout_kyc_contact_details_et_state");
                        correspondenceAddress.setState(String.valueOf(textInputEditText11.getText()));
                        TextInputEditText textInputEditText12 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
                        kotlin.g.b.k.a((Object) textInputEditText12, "layout_kyc_contact_details_et_pincode");
                        correspondenceAddress.setPostalCode(String.valueOf(textInputEditText12.getText()));
                        cersaiDetails.setAddress(new Address((PermanentAddress) null, correspondenceAddress));
                        this.f65440b = cersaiDetails;
                    }
                }
            }
            net.one97.paytm.upgradeKyc.kycV3.c.h hVar = this.f65441c;
            if (hVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CersaiDetails cersaiDetails2 = this.f65440b;
            if (cersaiDetails2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(cersaiDetails2, "cersaiDetails");
            y<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> yVar = hVar.f66241b;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            hVar.f66244e.a(cersaiDetails2, hVar.f66241b);
        }
    }

    static final class l implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65458a;

        l(c cVar) {
            this.f65458a = cVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            Address address2;
            CorrespondenceAddress coresspondenceAddress2;
            Address address3;
            CorrespondenceAddress coresspondenceAddress3;
            CersaiDetails b2 = this.f65458a.f65440b;
            if (!(b2 == null || (address3 = b2.getAddress()) == null || (coresspondenceAddress3 = address3.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress3.setAction("edit");
            }
            if (!z) {
                CersaiDetails b3 = this.f65458a.f65440b;
                if (!(b3 == null || (address2 = b3.getAddress()) == null || (coresspondenceAddress2 = address2.getCoresspondenceAddress()) == null)) {
                    coresspondenceAddress2.setSameAsPermanent(Boolean.FALSE);
                }
                Group group = (Group) this.f65458a.a(R.id.kyc_new_address_lyt);
                kotlin.g.b.k.a((Object) group, "kyc_new_address_lyt");
                group.setVisibility(0);
                return;
            }
            CersaiDetails b4 = this.f65458a.f65440b;
            if (!(b4 == null || (address = b4.getAddress()) == null || (coresspondenceAddress = address.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress.setSameAsPermanent(Boolean.TRUE);
            }
            Group group2 = (Group) this.f65458a.a(R.id.kyc_new_address_lyt);
            kotlin.g.b.k.a((Object) group2, "kyc_new_address_lyt");
            group2.setVisibility(8);
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65448a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        b(c cVar) {
            this.f65448a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails b2;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            kotlin.g.b.k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65448a.a(R.id.address_line_one_til);
            kotlin.g.b.k.a((Object) textInputLayout, "address_line_one_til");
            textInputLayout.setError("");
            if (this.f65448a.f65440b != null && (b2 = this.f65448a.f65440b) != null && (address = b2.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setAddressOne(editable.toString());
            }
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65450a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        d(c cVar) {
            this.f65450a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails b2;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            kotlin.g.b.k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65450a.a(R.id.address_line_two_til);
            kotlin.g.b.k.a((Object) textInputLayout, "address_line_two_til");
            textInputLayout.setError("");
            if (this.f65450a.f65440b != null && (b2 = this.f65450a.f65440b) != null && (address = b2.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setAddressTwo(editable.toString());
            }
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.activity.c$c  reason: collision with other inner class name */
    public static final class C1293c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65449a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        C1293c(c cVar) {
            this.f65449a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails b2;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            kotlin.g.b.k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65449a.a(R.id.address_line_three_til);
            kotlin.g.b.k.a((Object) textInputLayout, "address_line_three_til");
            textInputLayout.setError("");
            if (!(this.f65449a.f65440b == null || (b2 = this.f65449a.f65440b) == null || (address = b2.getAddress()) == null || (coresspondenceAddress = address.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress.setAddressThree(editable.toString());
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f65449a.a(R.id.address_line_three_til);
            kotlin.g.b.k.a((Object) textInputLayout2, "address_line_three_til");
            textInputLayout2.setError("");
        }
    }

    public static final class k implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65457a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        k(c cVar) {
            this.f65457a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails b2;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            kotlin.g.b.k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65457a.a(R.id.layout_kyc_contact_details_lyt_pincode);
            kotlin.g.b.k.a((Object) textInputLayout, "layout_kyc_contact_details_lyt_pincode");
            textInputLayout.setError("");
            if (!(this.f65457a.f65440b == null || (b2 = this.f65457a.f65440b) == null || (address = b2.getAddress()) == null || (coresspondenceAddress = address.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress.setPostalCode(editable.toString());
            }
            if (editable.length() == 6) {
                net.one97.paytm.upgradeKyc.kycV3.c.h a2 = c.a(this.f65457a);
                String obj = editable.toString();
                kotlin.g.b.k.c(obj, "pinCode");
                a2.f66242c.setValue(obj);
            }
        }
    }

    public static final class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65452a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        f(c cVar) {
            this.f65452a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails b2;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            kotlin.g.b.k.c(editable, "s");
            if (this.f65452a.f65440b != null && (b2 = this.f65452a.f65440b) != null && (address = b2.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setCity(editable.toString());
            }
        }
    }

    public static final class r implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65464a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        r(c cVar) {
            this.f65464a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails b2;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            kotlin.g.b.k.c(editable, "s");
            if (this.f65464a.f65440b != null && (b2 = this.f65464a.f65440b) != null && (address = b2.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setState(editable.toString());
            }
        }
    }

    private boolean a() {
        CheckBox checkBox = (CheckBox) a(R.id.correspondence_cb);
        kotlin.g.b.k.a((Object) checkBox, "correspondence_cb");
        if (!checkBox.isChecked()) {
            TextInputEditText textInputEditText = (TextInputEditText) a(R.id.address_line_one_et);
            kotlin.g.b.k.a((Object) textInputEditText, "address_line_one_et");
            if (TextUtils.isEmpty(textInputEditText.getText())) {
                TextInputLayout textInputLayout = (TextInputLayout) a(R.id.address_line_one_til);
                kotlin.g.b.k.a((Object) textInputLayout, "address_line_one_til");
                textInputLayout.setError(getString(R.string.error_fill_details));
                TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.address_line_one_til);
                kotlin.g.b.k.a((Object) textInputLayout2, "address_line_one_til");
                a((View) textInputLayout2);
                return false;
            }
            TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.address_line_two_et);
            kotlin.g.b.k.a((Object) textInputEditText2, "address_line_two_et");
            if (TextUtils.isEmpty(textInputEditText2.getText())) {
                TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.address_line_two_til);
                kotlin.g.b.k.a((Object) textInputLayout3, "address_line_two_til");
                textInputLayout3.setError(getString(R.string.error_fill_details));
                TextInputLayout textInputLayout4 = (TextInputLayout) a(R.id.address_line_two_til);
                kotlin.g.b.k.a((Object) textInputLayout4, "address_line_two_til");
                a((View) textInputLayout4);
                return false;
            }
            TextInputEditText textInputEditText3 = (TextInputEditText) a(R.id.address_line_three_et);
            kotlin.g.b.k.a((Object) textInputEditText3, "address_line_three_et");
            if (TextUtils.isEmpty(textInputEditText3.getText())) {
                TextInputLayout textInputLayout5 = (TextInputLayout) a(R.id.address_line_three_til);
                kotlin.g.b.k.a((Object) textInputLayout5, "address_line_three_til");
                textInputLayout5.setError(getString(R.string.error_fill_details));
                TextInputLayout textInputLayout6 = (TextInputLayout) a(R.id.address_line_three_til);
                kotlin.g.b.k.a((Object) textInputLayout6, "address_line_three_til");
                a((View) textInputLayout6);
                return false;
            }
            TextInputEditText textInputEditText4 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_city);
            kotlin.g.b.k.a((Object) textInputEditText4, "layout_kyc_contact_details_et_city");
            if (TextUtils.isEmpty(textInputEditText4.getText())) {
                TextInputLayout textInputLayout7 = (TextInputLayout) a(R.id.layout_kyc_contact_details_lyt_pincode);
                kotlin.g.b.k.a((Object) textInputLayout7, "layout_kyc_contact_details_lyt_pincode");
                textInputLayout7.setError(getString(R.string.pdp_enter_valid_pin));
                TextInputEditText textInputEditText5 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_city);
                kotlin.g.b.k.a((Object) textInputEditText5, "layout_kyc_contact_details_et_city");
                a((View) textInputEditText5);
                return false;
            }
            TextInputEditText textInputEditText6 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_state);
            kotlin.g.b.k.a((Object) textInputEditText6, "layout_kyc_contact_details_et_state");
            if (TextUtils.isEmpty(textInputEditText6.getText())) {
                TextInputLayout textInputLayout8 = (TextInputLayout) a(R.id.layout_kyc_contact_details_lyt_state);
                kotlin.g.b.k.a((Object) textInputLayout8, "layout_kyc_contact_details_lyt_state");
                textInputLayout8.setError(getString(R.string.pdp_enter_valid_pin));
                TextInputEditText textInputEditText7 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_state);
                kotlin.g.b.k.a((Object) textInputEditText7, "layout_kyc_contact_details_et_state");
                a((View) textInputEditText7);
                return false;
            }
            TextInputEditText textInputEditText8 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
            kotlin.g.b.k.a((Object) textInputEditText8, "layout_kyc_contact_details_et_pincode");
            if (TextUtils.isEmpty(textInputEditText8.getText())) {
                TextInputEditText textInputEditText9 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
                kotlin.g.b.k.a((Object) textInputEditText9, "layout_kyc_contact_details_et_pincode");
                textInputEditText9.setError(getString(R.string.error_pincode));
                TextInputEditText textInputEditText10 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
                kotlin.g.b.k.a((Object) textInputEditText10, "layout_kyc_contact_details_et_pincode");
                a((View) textInputEditText10);
                return false;
            }
            TextInputEditText textInputEditText11 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
            kotlin.g.b.k.a((Object) textInputEditText11, "layout_kyc_contact_details_et_pincode");
            if (!TextUtils.isEmpty(textInputEditText11.getText())) {
                TextInputEditText textInputEditText12 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
                kotlin.g.b.k.a((Object) textInputEditText12, "layout_kyc_contact_details_et_pincode");
                if (!com.paytm.utility.p.a(String.valueOf(textInputEditText12.getText()))) {
                    TextInputEditText textInputEditText13 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
                    kotlin.g.b.k.a((Object) textInputEditText13, "layout_kyc_contact_details_et_pincode");
                    textInputEditText13.setError(getString(R.string.pdp_enter_valid_pin));
                    TextInputEditText textInputEditText14 = (TextInputEditText) a(R.id.layout_kyc_contact_details_et_pincode);
                    kotlin.g.b.k.a((Object) textInputEditText14, "layout_kyc_contact_details_et_pincode");
                    a((View) textInputEditText14);
                    return false;
                }
            }
            RadioGroup radioGroup = (RadioGroup) a(R.id.married_question_rg);
            kotlin.g.b.k.a((Object) radioGroup, "married_question_rg");
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) a(R.id.married);
            kotlin.g.b.k.a((Object) radioButton, "married");
            if (checkedRadioButtonId == radioButton.getId()) {
                CersaiDetails cersaiDetails = this.f65440b;
                if (cersaiDetails != null) {
                    cersaiDetails.setMaritalStatus("married");
                }
            } else {
                RadioButton radioButton2 = (RadioButton) a(R.id.unmarried);
                kotlin.g.b.k.a((Object) radioButton2, "unmarried");
                if (checkedRadioButtonId == radioButton2.getId()) {
                    CersaiDetails cersaiDetails2 = this.f65440b;
                    if (cersaiDetails2 != null) {
                        cersaiDetails2.setMaritalStatus("unmarried");
                    }
                } else {
                    RadioButton radioButton3 = (RadioButton) a(R.id.others_marital);
                    kotlin.g.b.k.a((Object) radioButton3, "others_marital");
                    if (checkedRadioButtonId == radioButton3.getId()) {
                        CersaiDetails cersaiDetails3 = this.f65440b;
                        if (cersaiDetails3 != null) {
                            cersaiDetails3.setMaritalStatus("others");
                        }
                    } else {
                        TextView textView = (TextView) a(R.id.tv_error_martial);
                        kotlin.g.b.k.a((Object) textView, "tv_error_martial");
                        textView.setVisibility(0);
                        TextView textView2 = (TextView) a(R.id.tv_error_martial);
                        kotlin.g.b.k.a((Object) textView2, "tv_error_martial");
                        textView2.setText(getString(R.string.error_marital_status));
                        return false;
                    }
                }
            }
            TextInputEditText textInputEditText15 = (TextInputEditText) a(R.id.profession_et);
            kotlin.g.b.k.a((Object) textInputEditText15, "profession_et");
            if (kotlin.m.p.a(String.valueOf(textInputEditText15.getText()), getString(R.string.kyc_select_profession), true)) {
                TextInputLayout textInputLayout9 = (TextInputLayout) a(R.id.select_profession_til);
                kotlin.g.b.k.a((Object) textInputLayout9, "select_profession_til");
                textInputLayout9.setError(getString(R.string.error_profession));
                return false;
            }
            TextInputEditText textInputEditText16 = (TextInputEditText) a(R.id.kyc_family_mother_first_name_et);
            kotlin.g.b.k.a((Object) textInputEditText16, "kyc_family_mother_first_name_et");
            if (TextUtils.isEmpty(String.valueOf(textInputEditText16.getText()))) {
                TextInputLayout textInputLayout10 = (TextInputLayout) a(R.id.kyc_family_mother_first_name_layout);
                kotlin.g.b.k.a((Object) textInputLayout10, "kyc_family_mother_first_name_layout");
                textInputLayout10.setError(getString(R.string.sign_up_first_name_error));
                return false;
            }
            TextInputEditText textInputEditText17 = (TextInputEditText) a(R.id.kyc_family_father_first_name_et);
            kotlin.g.b.k.a((Object) textInputEditText17, "kyc_family_father_first_name_et");
            if (TextUtils.isEmpty(String.valueOf(textInputEditText17.getText()))) {
                TextInputLayout textInputLayout11 = (TextInputLayout) a(R.id.kyc_family_father_first_name_layout);
                kotlin.g.b.k.a((Object) textInputLayout11, "kyc_family_father_first_name_layout");
                textInputLayout11.setError(getString(R.string.sign_up_first_name_error));
                return false;
            }
        }
        return true;
    }

    private static void a(View view) {
        view.getParent().requestChildFocus(view, view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0146 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r11 = this;
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.util.ArrayList r0 = r0.getRelationships()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            r2 = 0
            java.lang.String r3 = "MOTHER"
            java.lang.String r4 = "FATHER"
            if (r0 == 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x0025
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 == 0) goto L_0x0025
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            if (r0 != 0) goto L_0x002b
            kotlin.g.b.k.a()
        L_0x002b:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x0042
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 == 0) goto L_0x0042
            java.util.Collection r0 = (java.util.Collection) r0
            kotlin.j.d r0 = kotlin.a.k.a((java.util.Collection<?>) r0)
            goto L_0x0043
        L_0x0042:
            r0 = r1
        L_0x0043:
            if (r0 != 0) goto L_0x0048
            kotlin.g.b.k.a()
        L_0x0048:
            int r5 = r0.f47939a
            int r0 = r0.f47940b
            if (r5 > r0) goto L_0x0143
            r6 = 0
        L_0x004f:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r7 = r11.f65440b
            if (r7 == 0) goto L_0x0066
            java.util.ArrayList r7 = r7.getRelationships()
            if (r7 == 0) goto L_0x0066
            java.lang.Object r7 = r7.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r7 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r7
            if (r7 == 0) goto L_0x0066
            java.lang.String r7 = r7.getRelationShip()
            goto L_0x0067
        L_0x0066:
            r7 = r1
        L_0x0067:
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            r10 = 1
            if (r9 != 0) goto L_0x00ce
            boolean r9 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r4, (boolean) r10)
            if (r9 == 0) goto L_0x00ce
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r11.f65440b
            if (r2 == 0) goto L_0x008e
            java.util.ArrayList r2 = r2.getRelationships()
            if (r2 == 0) goto L_0x008e
            java.lang.Object r2 = r2.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r2 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r2
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = r2.getFirstName()
            goto L_0x008f
        L_0x008e:
            r2 = r1
        L_0x008f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            if (r9 != 0) goto L_0x00a2
            int r9 = net.one97.paytm.upgradeKyc.R.id.kyc_family_father_first_name_et
            android.view.View r9 = r11.a((int) r9)
            com.google.android.material.textfield.TextInputEditText r9 = (com.google.android.material.textfield.TextInputEditText) r9
            r9.setText(r2)
        L_0x00a2:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r11.f65440b
            if (r2 == 0) goto L_0x00b9
            java.util.ArrayList r2 = r2.getRelationships()
            if (r2 == 0) goto L_0x00b9
            java.lang.Object r2 = r2.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r2 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r2
            if (r2 == 0) goto L_0x00b9
            java.lang.String r2 = r2.getLastName()
            goto L_0x00ba
        L_0x00b9:
            r2 = r1
        L_0x00ba:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            if (r9 != 0) goto L_0x00cd
            int r9 = net.one97.paytm.upgradeKyc.R.id.kyc_family_father_last_name_et
            android.view.View r9 = r11.a((int) r9)
            com.google.android.material.textfield.TextInputEditText r9 = (com.google.android.material.textfield.TextInputEditText) r9
            r9.setText(r2)
        L_0x00cd:
            r2 = 1
        L_0x00ce:
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0131
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r3, (boolean) r10)
            if (r7 == 0) goto L_0x0131
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r11.f65440b
            if (r6 == 0) goto L_0x00f1
            java.util.ArrayList r6 = r6.getRelationships()
            if (r6 == 0) goto L_0x00f1
            java.lang.Object r6 = r6.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r6 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r6
            if (r6 == 0) goto L_0x00f1
            java.lang.String r6 = r6.getFirstName()
            goto L_0x00f2
        L_0x00f1:
            r6 = r1
        L_0x00f2:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0105
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_family_mother_first_name_et
            android.view.View r7 = r11.a((int) r7)
            com.google.android.material.textfield.TextInputEditText r7 = (com.google.android.material.textfield.TextInputEditText) r7
            r7.setText(r6)
        L_0x0105:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r11.f65440b
            if (r6 == 0) goto L_0x011c
            java.util.ArrayList r6 = r6.getRelationships()
            if (r6 == 0) goto L_0x011c
            java.lang.Object r6 = r6.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r6 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r6
            if (r6 == 0) goto L_0x011c
            java.lang.String r6 = r6.getLastName()
            goto L_0x011d
        L_0x011c:
            r6 = r1
        L_0x011d:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0130
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_family_mother_last_name_et
            android.view.View r7 = r11.a((int) r7)
            com.google.android.material.textfield.TextInputEditText r7 = (com.google.android.material.textfield.TextInputEditText) r7
            r7.setText(r6)
        L_0x0130:
            r6 = 1
        L_0x0131:
            if (r5 == r0) goto L_0x0144
            int r5 = r5 + 1
            goto L_0x004f
        L_0x0137:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r1 = r11.f65440b
            if (r1 == 0) goto L_0x0143
            r1.setRelationships(r0)
        L_0x0143:
            r6 = 0
        L_0x0144:
            if (r2 != 0) goto L_0x014f
            if (r6 != 0) goto L_0x014f
            r11.a((java.lang.String) r3)
            r11.a((java.lang.String) r4)
            return
        L_0x014f:
            if (r2 != 0) goto L_0x0155
            r11.a((java.lang.String) r4)
            return
        L_0x0155:
            if (r6 != 0) goto L_0x015a
            r11.a((java.lang.String) r3)
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.c.b():void");
    }

    private final void a(String str) {
        ArrayList<RelationShipDetails> relationships;
        RelationShipDetails relationShipDetails = new RelationShipDetails((String) null, (String) null, (String) null, (String) null, 15, (kotlin.g.b.g) null);
        relationShipDetails.setAction("add");
        relationShipDetails.setRelationShip(str);
        CersaiDetails cersaiDetails = this.f65440b;
        if (cersaiDetails != null && (relationships = cersaiDetails.getRelationships()) != null) {
            relationships.add(relationShipDetails);
        }
    }

    static final class o implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65461a;

        o(c cVar) {
            this.f65461a = cVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            CersaiDetails b2;
            CersaiDetails b3;
            CersaiDetails b4;
            TextView textView = (TextView) this.f65461a.a(R.id.tv_error_martial);
            kotlin.g.b.k.a((Object) textView, "tv_error_martial");
            textView.setVisibility(8);
            RadioButton radioButton = (RadioButton) this.f65461a.a(R.id.married);
            kotlin.g.b.k.a((Object) radioButton, "married");
            if (!(!radioButton.isChecked() || this.f65461a.f65440b == null || (b4 = this.f65461a.f65440b) == null)) {
                b4.setMaritalStatus("married");
            }
            RadioButton radioButton2 = (RadioButton) this.f65461a.a(R.id.unmarried);
            kotlin.g.b.k.a((Object) radioButton2, "unmarried");
            if (!(!radioButton2.isChecked() || this.f65461a.f65440b == null || (b3 = this.f65461a.f65440b) == null)) {
                b3.setMaritalStatus("unmarried");
            }
            RadioButton radioButton3 = (RadioButton) this.f65461a.a(R.id.others_marital);
            kotlin.g.b.k.a((Object) radioButton3, "others_marital");
            if (radioButton3.isChecked() && this.f65461a.f65440b != null && (b2 = this.f65461a.f65440b) != null) {
                b2.setMaritalStatus("others");
            }
        }
    }

    public static final class p implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65462a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        p(c cVar) {
            this.f65462a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
            c.a(this.f65462a, "mother", true, false, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65462a.a(R.id.kyc_family_mother_first_name_layout);
            kotlin.g.b.k.a((Object) textInputLayout, "kyc_family_mother_first_name_layout");
            textInputLayout.setError("");
            TextInputEditText textInputEditText = (TextInputEditText) this.f65462a.a(R.id.kyc_family_mother_first_name_et);
            kotlin.g.b.k.a((Object) textInputEditText, "kyc_family_mother_first_name_et");
            String valueOf = String.valueOf(textInputEditText.getText());
            if (valueOf.length() > 0 && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f65462a.a(R.id.kyc_family_mother_first_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    textInputEditText2.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            TextInputEditText textInputEditText3 = (TextInputEditText) this.f65462a.a(R.id.kyc_family_mother_first_name_et);
            TextInputEditText textInputEditText4 = (TextInputEditText) this.f65462a.a(R.id.kyc_family_mother_first_name_et);
            kotlin.g.b.k.a((Object) textInputEditText4, "kyc_family_mother_first_name_et");
            Editable text = textInputEditText4.getText();
            if (text == null) {
                kotlin.g.b.k.a();
            }
            textInputEditText3.setSelection(text.length());
        }
    }

    public static final class q implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65463a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        q(c cVar) {
            this.f65463a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
            c.a(this.f65463a, "mother", false, true, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            kotlin.g.b.k.c(charSequence, "s");
            TextInputEditText textInputEditText = (TextInputEditText) this.f65463a.a(R.id.kyc_family_mother_last_name_et);
            kotlin.g.b.k.a((Object) textInputEditText, "kyc_family_mother_last_name_et");
            String valueOf = String.valueOf(textInputEditText.getText());
            if (valueOf.length() > 0 && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f65463a.a(R.id.kyc_family_mother_last_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    textInputEditText2.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            TextInputEditText textInputEditText3 = (TextInputEditText) this.f65463a.a(R.id.kyc_family_mother_last_name_et);
            TextInputEditText textInputEditText4 = (TextInputEditText) this.f65463a.a(R.id.kyc_family_mother_last_name_et);
            kotlin.g.b.k.a((Object) textInputEditText4, "kyc_family_mother_last_name_et");
            Editable text = textInputEditText4.getText();
            if (text == null) {
                kotlin.g.b.k.a();
            }
            textInputEditText3.setSelection(text.length());
        }
    }

    public static final class m implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65459a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        m(c cVar) {
            this.f65459a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
            c.a(this.f65459a, "father", true, false, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65459a.a(R.id.kyc_family_father_first_name_layout);
            kotlin.g.b.k.a((Object) textInputLayout, "kyc_family_father_first_name_layout");
            textInputLayout.setError("");
            TextInputEditText textInputEditText = (TextInputEditText) this.f65459a.a(R.id.kyc_family_mother_first_name_et);
            kotlin.g.b.k.a((Object) textInputEditText, "kyc_family_mother_first_name_et");
            String valueOf = String.valueOf(textInputEditText.getText());
            if ((valueOf.length() > 0) && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f65459a.a(R.id.kyc_family_father_first_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    textInputEditText2.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            TextInputEditText textInputEditText3 = (TextInputEditText) this.f65459a.a(R.id.kyc_family_father_first_name_et);
            TextInputEditText textInputEditText4 = (TextInputEditText) this.f65459a.a(R.id.kyc_family_father_first_name_et);
            kotlin.g.b.k.a((Object) textInputEditText4, "kyc_family_father_first_name_et");
            Editable text = textInputEditText4.getText();
            if (text == null) {
                kotlin.g.b.k.a();
            }
            textInputEditText3.setSelection(text.length());
        }
    }

    public static final class n implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65460a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        n(c cVar) {
            this.f65460a = cVar;
        }

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
            c.a(this.f65460a, "father", false, true, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            kotlin.g.b.k.c(charSequence, "s");
            TextInputEditText textInputEditText = (TextInputEditText) this.f65460a.a(R.id.kyc_family_father_last_name_et);
            kotlin.g.b.k.a((Object) textInputEditText, "kyc_family_father_last_name_et");
            String valueOf = String.valueOf(textInputEditText.getText());
            if (valueOf.length() > 0 && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f65460a.a(R.id.kyc_family_father_last_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    textInputEditText2.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            TextInputEditText textInputEditText3 = (TextInputEditText) this.f65460a.a(R.id.kyc_family_father_last_name_et);
            TextInputEditText textInputEditText4 = (TextInputEditText) this.f65460a.a(R.id.kyc_family_father_last_name_et);
            kotlin.g.b.k.a((Object) textInputEditText4, "kyc_family_father_last_name_et");
            Editable text = textInputEditText4.getText();
            if (text == null) {
                kotlin.g.b.k.a();
            }
            textInputEditText3.setSelection(text.length());
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        int intExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f65443e && i3 == -1 && intent != null && (intExtra = intent.getIntExtra("profession", -1)) != -1) {
            ((TextInputEditText) a(R.id.profession_et)).setText(getResources().getStringArray(R.array.kyc_profession_array)[intExtra]);
            CersaiDetails cersaiDetails = this.f65440b;
            if (cersaiDetails != null) {
                if (cersaiDetails != null) {
                    cersaiDetails.setProfession(b.e.values()[intExtra].toString());
                }
                TextInputLayout textInputLayout = (TextInputLayout) a(R.id.select_profession_til);
                kotlin.g.b.k.a((Object) textInputLayout, "select_profession_til");
                textInputLayout.setError("");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = r0.getRelationships();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.upgradeKyc.activity.c r5, java.lang.String r6, boolean r7, boolean r8, android.text.Editable r9) {
        /*
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r5.f65440b
            if (r0 == 0) goto L_0x00d2
            r1 = 0
            if (r0 == 0) goto L_0x0016
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 == 0) goto L_0x0016
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 != 0) goto L_0x001c
            kotlin.g.b.k.a()
        L_0x001c:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x00d2
            r0 = 0
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65440b
            if (r2 == 0) goto L_0x0036
            java.util.ArrayList r2 = r2.getRelationships()
            if (r2 == 0) goto L_0x0036
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0037
        L_0x0036:
            r2 = r1
        L_0x0037:
            if (r2 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            int r2 = r2.intValue()
        L_0x0040:
            if (r0 >= r2) goto L_0x00d2
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r3 = r5.f65440b
            if (r3 == 0) goto L_0x0053
            java.util.ArrayList r3 = r3.getRelationships()
            if (r3 == 0) goto L_0x0053
            java.lang.Object r3 = r3.get(r0)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r3 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r3
            goto L_0x0054
        L_0x0053:
            r3 = r1
        L_0x0054:
            if (r3 == 0) goto L_0x00ce
            java.lang.String r3 = r3.getRelationShip()
            r4 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r3, (boolean) r4)
            if (r3 == 0) goto L_0x00ce
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r3 = r5.f65440b
            if (r3 == 0) goto L_0x0078
            java.util.ArrayList r3 = r3.getRelationships()
            if (r3 == 0) goto L_0x0078
            java.lang.Object r3 = r3.get(r0)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r3 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r3
            if (r3 == 0) goto L_0x0078
            java.lang.String r3 = r3.getAction()
            goto L_0x0079
        L_0x0078:
            r3 = r1
        L_0x0079:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0098
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r3 = r5.f65440b
            if (r3 == 0) goto L_0x0098
            java.util.ArrayList r3 = r3.getRelationships()
            if (r3 == 0) goto L_0x0098
            java.lang.Object r3 = r3.get(r0)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r3 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r3
            if (r3 == 0) goto L_0x0098
            java.lang.String r4 = "edit"
            r3.setAction(r4)
        L_0x0098:
            if (r7 == 0) goto L_0x00b3
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r3 = r5.f65440b
            if (r3 == 0) goto L_0x00b3
            java.util.ArrayList r3 = r3.getRelationships()
            if (r3 == 0) goto L_0x00b3
            java.lang.Object r3 = r3.get(r0)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r3 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r3
            if (r3 == 0) goto L_0x00b3
            java.lang.String r4 = r9.toString()
            r3.setFirstName(r4)
        L_0x00b3:
            if (r8 == 0) goto L_0x00ce
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r3 = r5.f65440b
            if (r3 == 0) goto L_0x00ce
            java.util.ArrayList r3 = r3.getRelationships()
            if (r3 == 0) goto L_0x00ce
            java.lang.Object r3 = r3.get(r0)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r3 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r3
            if (r3 == 0) goto L_0x00ce
            java.lang.String r4 = r9.toString()
            r3.setLastName(r4)
        L_0x00ce:
            int r0 = r0 + 1
            goto L_0x0040
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.c.a(net.one97.paytm.upgradeKyc.activity.c, java.lang.String, boolean, boolean, android.text.Editable):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0581  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x058a  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x05e4  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x05f1  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0364 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.upgradeKyc.activity.c r11, com.paytm.network.model.IJRPaytmDataModel r12) {
        /*
            boolean r0 = r12 instanceof net.one97.paytm.common.entity.CJRAadharPanGet
            if (r0 == 0) goto L_0x0731
            net.one97.paytm.common.entity.CJRAadharPanGet r12 = (net.one97.paytm.common.entity.CJRAadharPanGet) r12
            java.lang.String r0 = r12.getGender()
            if (r0 == 0) goto L_0x0731
            java.lang.String r0 = r12.getGender()
            java.lang.String r1 = "it.gender"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0021
            r0 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x0731
            java.lang.String r0 = r12.getName()
            java.lang.String r3 = "full_name_tv"
            java.lang.String r4 = "kyc_details_full_name_value_tv"
            r5 = 8
            if (r0 == 0) goto L_0x0068
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r6 = r0.length()
            if (r6 <= 0) goto L_0x003a
            r6 = 1
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            if (r6 == 0) goto L_0x0068
            int r6 = net.one97.paytm.upgradeKyc.R.id.full_name_tv
            android.view.View r6 = r11.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            r6.setVisibility(r2)
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_details_full_name_value_tv
            android.view.View r3 = r11.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r3.setVisibility(r2)
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_details_full_name_value_tv
            android.view.View r3 = r11.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r3.setText(r0)
            goto L_0x0084
        L_0x0068:
            int r0 = net.one97.paytm.upgradeKyc.R.id.full_name_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_details_full_name_value_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r5)
        L_0x0084:
            java.lang.String r0 = r12.getGender()
            java.lang.String r3 = "gender_tv"
            java.lang.String r4 = "kyc_gender_value_tv"
            if (r0 == 0) goto L_0x011a
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0099
            r6 = 1
            goto L_0x009a
        L_0x0099:
            r6 = 0
        L_0x009a:
            if (r6 == 0) goto L_0x011a
            int r6 = net.one97.paytm.upgradeKyc.R.id.gender_tv
            android.view.View r6 = r11.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            r6.setVisibility(r2)
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_gender_value_tv
            android.view.View r3 = r11.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r3.setVisibility(r2)
            int r3 = r0.hashCode()
            r6 = 70
            if (r3 == r6) goto L_0x00e4
            r6 = 77
            if (r3 == r6) goto L_0x00c5
            goto L_0x0103
        L_0x00c5:
            java.lang.String r3 = "M"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0103
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_gender_value_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            int r3 = net.one97.paytm.upgradeKyc.R.string.male
            java.lang.String r3 = r11.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            goto L_0x0136
        L_0x00e4:
            java.lang.String r3 = "F"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0103
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_gender_value_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            int r3 = net.one97.paytm.upgradeKyc.R.string.female
            java.lang.String r3 = r11.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            goto L_0x0136
        L_0x0103:
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_gender_value_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            int r3 = net.one97.paytm.upgradeKyc.R.string.na
            java.lang.String r3 = r11.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            goto L_0x0136
        L_0x011a:
            int r0 = net.one97.paytm.upgradeKyc.R.id.gender_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_gender_value_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r5)
        L_0x0136:
            java.lang.String r0 = r12.getDob()
            java.lang.String r3 = "kyc_dob_tv"
            java.lang.String r4 = "kyc_dob_value_tv"
            if (r0 == 0) goto L_0x0178
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r6 = r0.length()
            if (r6 <= 0) goto L_0x014a
            r6 = 1
            goto L_0x014b
        L_0x014a:
            r6 = 0
        L_0x014b:
            if (r6 == 0) goto L_0x0178
            int r6 = net.one97.paytm.upgradeKyc.R.id.kyc_dob_tv
            android.view.View r6 = r11.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            r6.setVisibility(r2)
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_dob_value_tv
            android.view.View r3 = r11.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r3.setVisibility(r2)
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_dob_value_tv
            android.view.View r3 = r11.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r3.setText(r0)
            goto L_0x0194
        L_0x0178:
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_dob_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_dob_value_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r5)
        L_0x0194:
            java.util.List r0 = r12.getDocuments()
            int r0 = r0.size()
            r3 = 0
            r7 = r3
            r4 = 0
            r6 = 0
            r8 = 0
        L_0x01a1:
            if (r4 >= r0) goto L_0x0210
            java.util.List r9 = r12.getDocuments()
            java.lang.Object r9 = r9.get(r4)
            java.lang.String r10 = "it.documents.get(i)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            net.one97.paytm.common.entity.CJRAadharPanDocList r9 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r9
            java.lang.String r9 = r9.getDocCode()
            java.lang.String r10 = "pan"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x020d
            java.util.List r6 = r12.getDocuments()
            java.lang.Object r6 = r6.get(r4)
            java.lang.String r7 = "it.documents[i]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.common.entity.CJRAadharPanDocList r6 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r6
            java.lang.String r6 = r6.getDocValue()
            java.util.List r9 = r12.getDocuments()
            java.lang.Object r9 = r9.get(r4)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            net.one97.paytm.common.entity.CJRAadharPanDocList r9 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r9
            java.lang.String r9 = r9.getEditableAction()
            java.lang.String r10 = "NON_EDITABLE_TICKED"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x01ee
            r7 = r6
            r6 = 1
            r8 = 1
            goto L_0x020d
        L_0x01ee:
            java.util.List r9 = r12.getDocuments()
            java.lang.Object r9 = r9.get(r4)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            net.one97.paytm.common.entity.CJRAadharPanDocList r9 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r9
            java.lang.String r7 = r9.getEditableAction()
            java.lang.String r9 = "NON_EDITABLE_WAITING"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x020b
            r7 = r6
            r6 = 1
            r8 = 0
            goto L_0x020d
        L_0x020b:
            r7 = r6
            r6 = 1
        L_0x020d:
            int r4 = r4 + 1
            goto L_0x01a1
        L_0x0210:
            java.lang.String r0 = "edit_profile_pan_tick_iv"
            java.lang.String r4 = "kyc_details_pan_value_tv"
            if (r6 == 0) goto L_0x0270
            int r6 = net.one97.paytm.upgradeKyc.R.id.kyc_details_pan_value_tv
            android.view.View r6 = r11.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            r6.setVisibility(r2)
            int r6 = net.one97.paytm.upgradeKyc.R.id.edit_profile_pan_tick_iv
            android.view.View r6 = r11.a((int) r6)
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            r6.setVisibility(r2)
            int r0 = net.one97.paytm.upgradeKyc.R.id.pan_number_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r6 = "pan_number_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_details_pan_value_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            if (r8 == 0) goto L_0x0262
            int r0 = net.one97.paytm.upgradeKyc.R.id.edit_profile_pan_tick_iv
            android.view.View r0 = r11.a((int) r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            int r4 = net.one97.paytm.upgradeKyc.R.drawable.ic_kyc_badge
            r0.setImageResource(r4)
            goto L_0x029c
        L_0x0262:
            int r0 = net.one97.paytm.upgradeKyc.R.id.edit_profile_pan_tick_iv
            android.view.View r0 = r11.a((int) r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            int r4 = net.one97.paytm.upgradeKyc.R.drawable.ic_timeline_pending
            r0.setImageResource(r4)
            goto L_0x029c
        L_0x0270:
            int r6 = net.one97.paytm.upgradeKyc.R.id.kyc_details_pan_value_tv
            android.view.View r6 = r11.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            r6.setVisibility(r5)
            int r4 = net.one97.paytm.upgradeKyc.R.id.edit_profile_pan_tick_iv
            android.view.View r4 = r11.a((int) r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            r4.setVisibility(r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.pan_number_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "pan_number_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r5)
        L_0x029c:
            int r0 = net.one97.paytm.upgradeKyc.R.id.want_to_edit_kyc_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "want_to_edit_kyc_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.upgradeKyc.R.id.contact_us_tv
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "contact_us_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r2)
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r12.getCersaiInfo()
            r11.f65440b = r12
            int r12 = net.one97.paytm.upgradeKyc.R.id.kyc_details_parent
            android.view.View r12 = r11.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            java.lang.String r0 = "kyc_details_parent"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r2)
            int r12 = net.one97.paytm.upgradeKyc.R.id.v1
            android.view.View r12 = r11.a((int) r12)
            java.lang.String r0 = "v1"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r2)
            int r12 = net.one97.paytm.upgradeKyc.R.id.additional_parent
            android.view.View r12 = r11.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            java.lang.String r0 = "additional_parent"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r2)
            int r12 = net.one97.paytm.upgradeKyc.R.id.v3
            android.view.View r12 = r11.a((int) r12)
            java.lang.String r0 = "v3"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r2)
            net.one97.paytm.upgradeKyc.helper.d$a r12 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r12 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r12 != 0) goto L_0x0309
            kotlin.g.b.k.a()
        L_0x0309:
            java.lang.String r12 = "showCorrespAddBankProfileGTM"
            boolean r12 = net.one97.paytm.upgradeKyc.helper.d.a(r12, r1)
            if (r12 == 0) goto L_0x0330
            int r12 = net.one97.paytm.upgradeKyc.R.id.corresponding_parent
            android.view.View r12 = r11.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            java.lang.String r0 = "corresponding_parent"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r2)
            int r12 = net.one97.paytm.upgradeKyc.R.id.v2
            android.view.View r12 = r11.a((int) r12)
            java.lang.String r0 = "v2"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r2)
            goto L_0x034e
        L_0x0330:
            int r12 = net.one97.paytm.upgradeKyc.R.id.v2
            android.view.View r12 = r11.a((int) r12)
            java.lang.String r0 = "v2"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r5)
            int r12 = net.one97.paytm.upgradeKyc.R.id.corresponding_parent
            android.view.View r12 = r11.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            java.lang.String r0 = "corresponding_parent"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setVisibility(r5)
        L_0x034e:
            int r12 = net.one97.paytm.upgradeKyc.R.id.correspondence_cb
            android.view.View r12 = r11.a((int) r12)
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            net.one97.paytm.upgradeKyc.activity.c$l r0 = new net.one97.paytm.upgradeKyc.activity.c$l
            r0.<init>(r11)
            android.widget.CompoundButton$OnCheckedChangeListener r0 = (android.widget.CompoundButton.OnCheckedChangeListener) r0
            r12.setOnCheckedChangeListener(r0)
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r11.f65440b
            if (r12 == 0) goto L_0x0489
            if (r12 == 0) goto L_0x0377
            net.one97.paytm.common.entity.upgradeKyc.Address r12 = r12.getAddress()
            if (r12 == 0) goto L_0x0377
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r12 = r12.getCoresspondenceAddress()
            if (r12 == 0) goto L_0x0377
            java.lang.String r0 = "edit"
            r12.setAction(r0)
        L_0x0377:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r11.f65440b
            if (r12 == 0) goto L_0x038c
            net.one97.paytm.common.entity.upgradeKyc.Address r12 = r12.getAddress()
            if (r12 == 0) goto L_0x038c
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r12 = r12.getCoresspondenceAddress()
            if (r12 == 0) goto L_0x038c
            java.lang.Boolean r12 = r12.isSameAsPermanent()
            goto L_0x038d
        L_0x038c:
            r12 = r3
        L_0x038d:
            if (r12 == 0) goto L_0x03a7
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x03a7
            int r12 = net.one97.paytm.upgradeKyc.R.id.correspondence_cb
            android.view.View r12 = r11.a((int) r12)
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            java.lang.String r0 = "correspondence_cb"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setChecked(r1)
            goto L_0x0489
        L_0x03a7:
            int r12 = net.one97.paytm.upgradeKyc.R.id.correspondence_cb
            android.view.View r12 = r11.a((int) r12)
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            java.lang.String r0 = "correspondence_cb"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r12.setChecked(r2)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_one_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x03d4
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x03d4
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r0 = r0.getCoresspondenceAddress()
            if (r0 == 0) goto L_0x03d4
            java.lang.String r0 = r0.getAddressOne()
            goto L_0x03d5
        L_0x03d4:
            r0 = r3
        L_0x03d5:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_two_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x03f7
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x03f7
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r0 = r0.getCoresspondenceAddress()
            if (r0 == 0) goto L_0x03f7
            java.lang.String r0 = r0.getAddressTwo()
            goto L_0x03f8
        L_0x03f7:
            r0 = r3
        L_0x03f8:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_three_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x041a
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x041a
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r0 = r0.getCoresspondenceAddress()
            if (r0 == 0) goto L_0x041a
            java.lang.String r0 = r0.getAddressThree()
            goto L_0x041b
        L_0x041a:
            r0 = r3
        L_0x041b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x043d
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x043d
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r0 = r0.getCoresspondenceAddress()
            if (r0 == 0) goto L_0x043d
            java.lang.String r0 = r0.getPostalCode()
            goto L_0x043e
        L_0x043d:
            r0 = r3
        L_0x043e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_city
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x0460
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x0460
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r0 = r0.getCoresspondenceAddress()
            if (r0 == 0) goto L_0x0460
            java.lang.String r0 = r0.getCity()
            goto L_0x0461
        L_0x0460:
            r0 = r3
        L_0x0461:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_state
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65440b
            if (r0 == 0) goto L_0x0483
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x0483
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r0 = r0.getCoresspondenceAddress()
            if (r0 == 0) goto L_0x0483
            java.lang.String r0 = r0.getState()
            goto L_0x0484
        L_0x0483:
            r0 = r3
        L_0x0484:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
        L_0x0489:
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_one_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$b r0 = r11.f65447i
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_two_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$d r0 = r11.j
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_three_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$c r0 = r11.k
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$k r0 = r11.l
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_city
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$f r0 = r11.m
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_state
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$r r0 = r11.n
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_state
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            java.lang.String r0 = "layout_kyc_contact_details_et_state"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r0 = 2
            android.text.InputFilter[] r4 = new android.text.InputFilter[r0]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r7 = 30
            r6.<init>(r7)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r2] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r1] = r6
            r12.setFilters(r4)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_three_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            java.lang.String r4 = "address_line_three_et"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            android.text.InputFilter[] r4 = new android.text.InputFilter[r0]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r7 = 150(0x96, float:2.1E-43)
            r6.<init>(r7)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r2] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r1] = r6
            r12.setFilters(r4)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_two_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            java.lang.String r4 = "address_line_two_et"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            android.text.InputFilter[] r4 = new android.text.InputFilter[r0]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r7)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r2] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r1] = r6
            r12.setFilters(r4)
            int r12 = net.one97.paytm.upgradeKyc.R.id.address_line_one_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            java.lang.String r4 = "address_line_one_et"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            android.text.InputFilter[] r4 = new android.text.InputFilter[r0]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r7)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r2] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r4[r1] = r6
            r12.setFilters(r4)
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r11.f65440b
            if (r12 == 0) goto L_0x0581
            java.lang.String r12 = r12.getMaritalStatus()
            goto L_0x0582
        L_0x0581:
            r12 = r3
        L_0x0582:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x05e0
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r11.f65440b
            if (r12 == 0) goto L_0x0593
            java.lang.String r12 = r12.getMaritalStatus()
            goto L_0x0594
        L_0x0593:
            r12 = r3
        L_0x0594:
            java.lang.String r4 = "UNMARRIED"
            boolean r12 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r4, (boolean) r1)
            if (r12 == 0) goto L_0x05ad
            int r12 = net.one97.paytm.upgradeKyc.R.id.unmarried
            android.view.View r12 = r11.a((int) r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            java.lang.String r4 = "unmarried"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            r12.setChecked(r1)
            goto L_0x05e0
        L_0x05ad:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r11.f65440b
            if (r12 == 0) goto L_0x05b6
            java.lang.String r12 = r12.getMaritalStatus()
            goto L_0x05b7
        L_0x05b6:
            r12 = r3
        L_0x05b7:
            java.lang.String r4 = "MARRIED"
            boolean r12 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r4, (boolean) r1)
            if (r12 == 0) goto L_0x05d0
            int r12 = net.one97.paytm.upgradeKyc.R.id.married
            android.view.View r12 = r11.a((int) r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            java.lang.String r4 = "married"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            r12.setChecked(r1)
            goto L_0x05e0
        L_0x05d0:
            int r12 = net.one97.paytm.upgradeKyc.R.id.others_marital
            android.view.View r12 = r11.a((int) r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            java.lang.String r4 = "others_marital"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            r12.setChecked(r1)
        L_0x05e0:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r11.f65440b
            if (r12 == 0) goto L_0x05e8
            java.lang.String r3 = r12.getProfession()
        L_0x05e8:
            r12 = r3
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x06b0
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.PROFESSIONAL
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0601
            r11.f65442d = r2
            goto L_0x0690
        L_0x0601:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.GOVERNMENT_JOB
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0611
            r11.f65442d = r1
            goto L_0x0690
        L_0x0611:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.PRIVATE_SECTOR_JOB
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0621
            r11.f65442d = r0
            goto L_0x0690
        L_0x0621:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.PUBLIC_SECTOR_JOB
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0631
            r12 = 3
            r11.f65442d = r12
            goto L_0x0690
        L_0x0631:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.BUSINESS
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0641
            r12 = 4
            r11.f65442d = r12
            goto L_0x0690
        L_0x0641:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.STUDENT
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0651
            r12 = 5
            r11.f65442d = r12
            goto L_0x0690
        L_0x0651:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.HOUSE_WIFE
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0661
            r12 = 6
            r11.f65442d = r12
            goto L_0x0690
        L_0x0661:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.RETIRED
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0671
            r12 = 7
            r11.f65442d = r12
            goto L_0x0690
        L_0x0671:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.SELF_EMPLOYED
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0680
            r11.f65442d = r5
            goto L_0x0690
        L_0x0680:
            net.one97.paytm.upgradeKyc.activity.b$e r12 = net.one97.paytm.upgradeKyc.activity.b.e.OTHERS
            java.lang.String r12 = r12.name()
            boolean r12 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r12, (boolean) r1)
            if (r12 == 0) goto L_0x0690
            r12 = 9
            r11.f65442d = r12
        L_0x0690:
            int r12 = r11.f65442d
            r0 = -1
            if (r12 == r0) goto L_0x06b0
            int r12 = net.one97.paytm.upgradeKyc.R.id.profession_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            android.content.res.Resources r0 = r11.getResources()
            int r1 = net.one97.paytm.upgradeKyc.R.array.kyc_profession_array
            java.lang.String[] r0 = r0.getStringArray(r1)
            int r1 = r11.f65442d
            r0 = r0[r1]
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
        L_0x06b0:
            r11.b()
            int r12 = net.one97.paytm.upgradeKyc.R.id.married_question_rg
            android.view.View r12 = r11.a((int) r12)
            android.widget.RadioGroup r12 = (android.widget.RadioGroup) r12
            net.one97.paytm.upgradeKyc.activity.c$o r0 = new net.one97.paytm.upgradeKyc.activity.c$o
            r0.<init>(r11)
            android.widget.RadioGroup$OnCheckedChangeListener r0 = (android.widget.RadioGroup.OnCheckedChangeListener) r0
            r12.setOnCheckedChangeListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.kyc_family_mother_first_name_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$p r0 = new net.one97.paytm.upgradeKyc.activity.c$p
            r0.<init>(r11)
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.kyc_family_mother_last_name_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$q r0 = new net.one97.paytm.upgradeKyc.activity.c$q
            r0.<init>(r11)
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.kyc_family_father_first_name_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$m r0 = new net.one97.paytm.upgradeKyc.activity.c$m
            r0.<init>(r11)
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.kyc_family_father_last_name_et
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.upgradeKyc.activity.c$n r0 = new net.one97.paytm.upgradeKyc.activity.c$n
            r0.<init>(r11)
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r12.addTextChangedListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.fragment_cersai_details_save_btn
            android.view.View r12 = r11.a((int) r12)
            android.widget.Button r12 = (android.widget.Button) r12
            r0 = r11
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r12.setOnClickListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.select_profession_til
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
            r12.setOnClickListener(r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.profession_et
            android.view.View r11 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r11 = (com.google.android.material.textfield.TextInputEditText) r11
            r11.setOnClickListener(r0)
        L_0x0731:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.c.a(net.one97.paytm.upgradeKyc.activity.c, com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
