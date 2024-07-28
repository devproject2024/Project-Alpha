package com.travel.citybus.brts;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.travel.citybus.R;
import com.travel.citybus.brts.citybus.ac;
import com.travel.citybus.brts.model.CityBusQRModel;
import com.travel.citybus.brts.model.CitybusQrCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import org.json.JSONObject;

public final class e extends androidx.fragment.app.b {

    /* renamed from: a  reason: collision with root package name */
    private CJROrderedCart f23373a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CitybusQrCode> f23374b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap f23375c;

    private View a(int i2) {
        if (this.f23375c == null) {
            this.f23375c = new HashMap();
        }
        View view = (View) this.f23375c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23375c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getTheme() {
        return R.style.CustomDialogFragment;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f23373a = (CJROrderedCart) (arguments != null ? arguments.getSerializable("Order Data") : null);
    }

    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_q_r_code, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CJRFullFillmentObject fullFillmentOject;
        CJRFullFillmentObject fullFillmentOject2;
        WindowManager windowManager;
        Display defaultDisplay;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        a(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        CJROrderedCart cJROrderedCart = this.f23373a;
        if (cJROrderedCart != null) {
            String str = null;
            if ((cJROrderedCart != null ? cJROrderedCart.getFullFillmentOject() : null) != null) {
                CJROrderedCart cJROrderedCart2 = this.f23373a;
                if (!TextUtils.isEmpty((cJROrderedCart2 == null || (fullFillmentOject2 = cJROrderedCart2.getFullFillmentOject()) == null) ? null : fullFillmentOject2.getFulfillmentResponse())) {
                    try {
                        CJROrderedCart cJROrderedCart3 = this.f23373a;
                        if (!(cJROrderedCart3 == null || (fullFillmentOject = cJROrderedCart3.getFullFillmentOject()) == null)) {
                            str = fullFillmentOject.getFulfillmentResponse();
                        }
                        CityBusQRModel cityBusQRModel = (CityBusQRModel) new f().a(new JSONObject(str).toString(), CityBusQRModel.class);
                        k.a((Object) cityBusQRModel, "cityBusQRModel");
                        if (cityBusQRModel.getCitybusQrCode().size() > 0) {
                            List<CitybusQrCode> citybusQrCode = cityBusQRModel.getCitybusQrCode();
                            if (citybusQrCode != null) {
                                this.f23374b = (ArrayList) citybusQrCode;
                                a();
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.citybus.brts.model.CitybusQrCode> /* = java.util.ArrayList<com.travel.citybus.brts.model.CitybusQrCode> */");
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        ((AppCompatImageView) a(R.id.qrCodeClose)).setOnClickListener(new a(this));
        ((Switch) a(R.id.qrCodeSwitch)).setOnCheckedChangeListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f23376a;

        a(e eVar) {
            this.f23376a = eVar;
        }

        public final void onClick(View view) {
            Dialog dialog = this.f23376a.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f23377a;

        b(e eVar) {
            this.f23377a = eVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f23377a.a();
                return;
            }
            this.f23377a.a(false);
            e.c(this.f23377a);
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        a(true);
        int size = this.f23374b.size();
        ArrayList arrayList = new ArrayList();
        if (size == 1) {
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
            arrayList.add(this.f23374b.get(0));
        }
        FragmentActivity requireActivity = requireActivity();
        k.a((Object) requireActivity, "requireActivity()");
        ac acVar = new ac(requireActivity, arrayList);
        RecyclerView recyclerView = (RecyclerView) a(R.id.qrImageRv);
        k.a((Object) recyclerView, "qrImageRv");
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.qrImageRv);
        k.a((Object) recyclerView2, "qrImageRv");
        recyclerView2.setAdapter(acVar);
    }

    private static int d(e eVar) {
        Resources resources = eVar.getResources();
        k.a((Object) resources, "context.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        k.a((Object) displayMetrics, "resources.displayMetrics");
        return (int) ((((float) displayMetrics.densityDpi) / 160.0f) * 300.0f);
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        RecyclerView recyclerView = (RecyclerView) a(R.id.qrImageRv);
        k.a((Object) recyclerView, "qrImageRv");
        int i2 = 0;
        recyclerView.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) a(R.id.qrImage);
        k.a((Object) linearLayout, "qrImage");
        if (z) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    public static final /* synthetic */ void c(e eVar) {
        ((LinearLayout) eVar.a(R.id.qrImage)).removeAllViews();
        int size = eVar.f23374b.size();
        for (int i2 = 0; i2 < size; i2++) {
            CitybusQrCode citybusQrCode = eVar.f23374b.get(i2);
            k.a((Object) citybusQrCode, "cityBusQrCodes[i]");
            List<String> qrstrings = citybusQrCode.getQrstrings();
            if (qrstrings != null && qrstrings.size() > 0) {
                int size2 = qrstrings.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    View inflate = LayoutInflater.from(eVar.getActivity()).inflate(R.layout.bcll_qr_items, (LinearLayout) eVar.a(R.id.qrImage), false);
                    k.a((Object) inflate, "LayoutInflater.from(acti…          qrImage, false)");
                    eVar.getActivity();
                    ((ImageView) inflate.findViewById(R.id.e_qr_image)).setImageBitmap(com.google.zxing.client.android.d.a.a(qrstrings.get(i3), d(eVar), d(eVar), false));
                    ((LinearLayout) eVar.a(R.id.qrImage)).addView(inflate);
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23375c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
