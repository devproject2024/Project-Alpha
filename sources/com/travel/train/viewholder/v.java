package com.travel.train.viewholder;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.j.c;
import com.travel.train.model.trainticket.CJRCountryCodeList;
import com.travel.train.model.trainticket.CJRCountryList;
import com.travel.train.model.trainticket.CJRIRCTCUserAvailability;
import com.travel.train.model.trainticket.CJRIRCTCUserRegister;
import com.travel.train.model.trainticket.CJRPincodeResponse;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.common.widgets.CJRFloatingLabel;

public final class v extends RecyclerView.v implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f28255a;

    /* renamed from: b  reason: collision with root package name */
    public CJRFloatingLabel f28256b;

    /* renamed from: c  reason: collision with root package name */
    public CJRFloatingLabel f28257c;

    /* renamed from: d  reason: collision with root package name */
    CJRFloatingLabel f28258d;

    /* renamed from: e  reason: collision with root package name */
    Spinner f28259e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28260f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f28261g;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<CJRPincodeResponse.CJRCities> f28262h;

    /* renamed from: i  reason: collision with root package name */
    ProgressDialog f28263i;
    String j = "CJRPassengerDestDetailViewHolder";
    private Spinner k;
    private RoboTextView l;
    private View m;
    private RoboTextView n;
    private View o;
    private View p;
    private TextView q;
    private TextView r;
    private TextView s;
    private View t;
    private TextView u;
    private boolean v;
    private ArrayList<String> w;

    public final void a(CJRCountryCodeList cJRCountryCodeList) {
    }

    public final void a(CJRCountryList cJRCountryList) {
    }

    public final void a(CJRIRCTCUserAvailability cJRIRCTCUserAvailability) {
    }

    public final void a(CJRIRCTCUserRegister cJRIRCTCUserRegister) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(View view, boolean z, ArrayList<String> arrayList) {
        super(view);
        Resources resources;
        Resources resources2;
        Resources resources3;
        k.c(view, "itemView");
        this.v = z;
        this.w = arrayList;
        this.f28255a = view.getContext();
        int i2 = 0;
        int i3 = this.v ? 0 : 8;
        this.t = view.findViewById(R.id.dest_detail_lyt);
        View view2 = this.t;
        if (view2 != null) {
            view2.setVisibility(i3);
        }
        this.f28256b = (CJRFloatingLabel) view.findViewById(R.id.address_edit_text);
        CJRFloatingLabel cJRFloatingLabel = this.f28256b;
        String str = null;
        if (cJRFloatingLabel != null) {
            Context context = this.f28255a;
            cJRFloatingLabel.setHintText((context == null || (resources3 = context.getResources()) == null) ? null : resources3.getString(R.string.train_destination_address));
        }
        this.f28257c = (CJRFloatingLabel) view.findViewById(R.id.pincode_edit_text);
        CJRFloatingLabel cJRFloatingLabel2 = this.f28257c;
        if (cJRFloatingLabel2 != null) {
            Context context2 = this.f28255a;
            cJRFloatingLabel2.setHintText((context2 == null || (resources2 = context2.getResources()) == null) ? null : resources2.getString(R.string.train_destination_pincode));
        }
        this.f28258d = (CJRFloatingLabel) view.findViewById(R.id.state_edit_text);
        CJRFloatingLabel cJRFloatingLabel3 = this.f28258d;
        if (cJRFloatingLabel3 != null) {
            cJRFloatingLabel3.setEdittextEditable(false);
        }
        CJRFloatingLabel cJRFloatingLabel4 = this.f28258d;
        if (cJRFloatingLabel4 != null) {
            Context context3 = this.f28255a;
            if (!(context3 == null || (resources = context3.getResources()) == null)) {
                str = resources.getString(R.string.train_destination_state);
            }
            cJRFloatingLabel4.setHintText(str);
        }
        this.p = view.findViewById(R.id.state_edit_text_underline);
        this.l = (RoboTextView) view.findViewById(R.id.city_label_view);
        this.k = (Spinner) view.findViewById(R.id.city_town);
        this.m = view.findViewById(R.id.city_town_underline);
        this.n = (RoboTextView) view.findViewById(R.id.post_office_label_view);
        this.f28259e = (Spinner) view.findViewById(R.id.post_office_spinner);
        this.o = view.findViewById(R.id.post_office_spinner_underline);
        this.u = (TextView) view.findViewById(R.id.travel_advisory_desc);
        this.f28260f = (TextView) view.findViewById(R.id.address_error);
        this.f28261g = (TextView) view.findViewById(R.id.pincode_error);
        this.q = (TextView) view.findViewById(R.id.city_error);
        this.r = (TextView) view.findViewById(R.id.state_error);
        this.s = (TextView) view.findViewById(R.id.office_post_error);
        CJRFloatingLabel cJRFloatingLabel5 = this.f28256b;
        if (cJRFloatingLabel5 != null) {
            cJRFloatingLabel5.a((CJRFloatingLabel.c) new b(this));
        }
        CJRFloatingLabel cJRFloatingLabel6 = this.f28257c;
        if (cJRFloatingLabel6 != null) {
            cJRFloatingLabel6.a((CJRFloatingLabel.c) new c(this));
        }
        String str2 = "";
        ArrayList<String> arrayList2 = this.w;
        if (arrayList2 != null) {
            if (arrayList2 == null) {
                k.a();
            }
            int size = arrayList2.size() - 1;
            if (size >= 0) {
                while (true) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    ArrayList<String> arrayList3 = this.w;
                    if (arrayList3 == null) {
                        k.a();
                    }
                    sb.append(arrayList3.get(i2));
                    sb.append(StringUtility.NEW_LINE);
                    str2 = sb.toString();
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            TextView textView = this.u;
            if (textView != null) {
                textView.setText(str2);
            }
        }
    }

    public static final class b implements CJRFloatingLabel.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f28267a;

        b(v vVar) {
            this.f28267a = vVar;
        }

        public final void a(CharSequence charSequence) {
            TextView textView;
            if (!TextUtils.isEmpty(charSequence)) {
                if (charSequence == null) {
                    k.a();
                }
                if (charSequence.length() > 0 && (textView = this.f28267a.f28260f) != null) {
                    textView.setVisibility(8);
                }
            }
        }
    }

    public static final class c implements CJRFloatingLabel.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f28268a;

        c(v vVar) {
            this.f28268a = vVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0105  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x011e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.CharSequence r6) {
            /*
                r5 = this;
                boolean r0 = android.text.TextUtils.isEmpty(r6)
                r1 = 0
                if (r0 != 0) goto L_0x0025
                if (r6 != 0) goto L_0x000c
                kotlin.g.b.k.a()
            L_0x000c:
                int r0 = r6.length()
                if (r0 == 0) goto L_0x0025
                com.travel.train.viewholder.v r0 = r5.f28268a
                android.content.Context r0 = r0.f28255a
                if (r0 == 0) goto L_0x0038
                android.content.res.Resources r0 = r0.getResources()
                if (r0 == 0) goto L_0x0038
                int r2 = com.travel.train.R.string.train_pincode_hint_text
                java.lang.String r0 = r0.getString(r2)
                goto L_0x0039
            L_0x0025:
                com.travel.train.viewholder.v r0 = r5.f28268a
                android.content.Context r0 = r0.f28255a
                if (r0 == 0) goto L_0x0038
                android.content.res.Resources r0 = r0.getResources()
                if (r0 == 0) goto L_0x0038
                int r2 = com.travel.train.R.string.train_enter_pincode_hint_text
                java.lang.String r0 = r0.getString(r2)
                goto L_0x0039
            L_0x0038:
                r0 = r1
            L_0x0039:
                com.travel.train.viewholder.v r2 = r5.f28268a
                net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r2.f28257c
                if (r2 == 0) goto L_0x0042
                r2.setHintText((java.lang.String) r0)
            L_0x0042:
                boolean r0 = android.text.TextUtils.isEmpty(r6)
                if (r0 != 0) goto L_0x005e
                if (r6 != 0) goto L_0x004d
                kotlin.g.b.k.a()
            L_0x004d:
                int r0 = r6.length()
                if (r0 <= 0) goto L_0x005e
                com.travel.train.viewholder.v r0 = r5.f28268a
                android.widget.TextView r0 = r0.f28261g
                if (r0 == 0) goto L_0x005e
                r2 = 8
                r0.setVisibility(r2)
            L_0x005e:
                boolean r0 = android.text.TextUtils.isEmpty(r6)
                java.lang.String r2 = ""
                if (r0 != 0) goto L_0x011e
                java.lang.String r6 = java.lang.String.valueOf(r6)
                r0 = r6
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x010d
                if (r6 != 0) goto L_0x0078
                kotlin.g.b.k.a()
            L_0x0078:
                int r0 = r6.length()
                r3 = 6
                if (r0 != r3) goto L_0x010d
                com.travel.train.viewholder.v r0 = r5.f28268a
                android.content.Context r2 = r0.f28255a
                com.travel.train.viewholder.v r3 = r5.f28268a
                android.content.Context r3 = r3.f28255a
                if (r3 == 0) goto L_0x0095
                android.content.res.Resources r3 = r3.getResources()
                if (r3 == 0) goto L_0x0095
                int r1 = com.travel.train.R.string.pp_please_wait
                java.lang.String r1 = r3.getString(r1)
            L_0x0095:
                android.app.ProgressDialog r3 = r0.f28263i
                r4 = 0
                if (r3 == 0) goto L_0x00b1
                android.app.ProgressDialog r3 = r0.f28263i
                if (r3 != 0) goto L_0x00a1
                kotlin.g.b.k.a()
            L_0x00a1:
                boolean r3 = r3.isShowing()
                if (r3 == 0) goto L_0x00b1
                android.app.ProgressDialog r0 = r0.f28263i
                if (r0 == 0) goto L_0x00e9
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setMessage(r1)
                goto L_0x00e9
            L_0x00b1:
                android.app.ProgressDialog r3 = new android.app.ProgressDialog
                r3.<init>(r2)
                r0.f28263i = r3
                android.app.ProgressDialog r2 = r0.f28263i     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
                if (r2 == 0) goto L_0x00bf
                r2.setProgressStyle(r4)     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
            L_0x00bf:
                android.app.ProgressDialog r2 = r0.f28263i     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
                if (r2 == 0) goto L_0x00c8
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
                r2.setMessage(r1)     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
            L_0x00c8:
                android.app.ProgressDialog r1 = r0.f28263i     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
                if (r1 == 0) goto L_0x00d0
                r2 = 1
                r1.setCancelable(r2)     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
            L_0x00d0:
                android.app.ProgressDialog r1 = r0.f28263i     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
                if (r1 == 0) goto L_0x00d7
                r1.setCanceledOnTouchOutside(r4)     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
            L_0x00d7:
                android.app.ProgressDialog r0 = r0.f28263i     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
                if (r0 == 0) goto L_0x00e9
                r0.show()     // Catch:{ IllegalArgumentException -> 0x00e1, Exception -> 0x00df }
                goto L_0x00e9
            L_0x00df:
                goto L_0x00e9
            L_0x00e1:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.paytm.utility.q.c(r0)
            L_0x00e9:
                com.travel.train.j.c r0 = new com.travel.train.j.c
                com.travel.train.viewholder.v r1 = r5.f28268a
                android.content.Context r1 = r1.f28255a
                com.travel.train.viewholder.v r2 = r5.f28268a
                com.travel.train.j.c$a r2 = (com.travel.train.j.c.a) r2
                r0.<init>(r1, r2, r4)
                com.travel.train.viewholder.v r1 = r5.f28268a
                android.content.Context r1 = r1.f28255a
                if (r1 == 0) goto L_0x0105
                android.app.Activity r1 = (android.app.Activity) r1
                com.travel.train.j.o.a((android.app.Activity) r1)
                r0.a((java.lang.String) r6)
                return
            L_0x0105:
                kotlin.u r6 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.app.Activity"
                r6.<init>(r0)
                throw r6
            L_0x010d:
                com.travel.train.viewholder.v r6 = r5.f28268a
                r6.b()
                com.travel.train.viewholder.v r6 = r5.f28268a
                net.one97.paytm.common.widgets.CJRFloatingLabel r6 = r6.f28258d
                if (r6 == 0) goto L_0x011d
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r6.setText((java.lang.CharSequence) r2)
            L_0x011d:
                return
            L_0x011e:
                com.travel.train.viewholder.v r6 = r5.f28268a
                r6.b()
                com.travel.train.viewholder.v r6 = r5.f28268a
                net.one97.paytm.common.widgets.CJRFloatingLabel r6 = r6.f28258d
                if (r6 == 0) goto L_0x012e
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r6.setText((java.lang.CharSequence) r2)
            L_0x012e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.viewholder.v.c.a(java.lang.CharSequence):void");
        }
    }

    public final void b() {
        CJRFloatingLabel cJRFloatingLabel = this.f28258d;
        if (cJRFloatingLabel != null) {
            cJRFloatingLabel.setVisibility(8);
        }
        View view = this.p;
        if (view != null) {
            view.setVisibility(8);
        }
        b(8);
        a(8);
    }

    public final void a() {
        TextView textView = this.f28261g;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public static final class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f28264a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f28265b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f28266c;

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        a(v vVar, ArrayList arrayList, x.e eVar) {
            this.f28264a = vVar;
            this.f28265b = arrayList;
            this.f28266c = eVar;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            ArrayList arrayList = this.f28265b;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList arrayList2 = this.f28265b;
            if (arrayList2 != null) {
                ArrayList<CJRPincodeResponse.CJRCities> arrayList3 = this.f28264a.f28262h;
                if (arrayList3 == null) {
                    k.a();
                }
                CJRPincodeResponse.CJRCities cJRCities = arrayList3.get(i2);
                k.a((Object) cJRCities, "mCityList!!.get(position)");
                arrayList2.addAll(cJRCities.getPostOfficeList());
            }
            ((ArrayAdapter) this.f28266c.element).notifyDataSetChanged();
            Spinner spinner = this.f28264a.f28259e;
            if (spinner != null) {
                spinner.setSelection(0);
            }
        }
    }

    public final String c() {
        CharSequence text;
        CJRFloatingLabel cJRFloatingLabel = this.f28256b;
        if (cJRFloatingLabel == null || (text = cJRFloatingLabel.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    public final String d() {
        CharSequence text;
        CJRFloatingLabel cJRFloatingLabel = this.f28257c;
        if (cJRFloatingLabel == null || (text = cJRFloatingLabel.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    public final String e() {
        CharSequence text;
        CJRFloatingLabel cJRFloatingLabel = this.f28258d;
        if (cJRFloatingLabel == null || (text = cJRFloatingLabel.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    public final String f() {
        Object selectedItem;
        Spinner spinner = this.k;
        if (spinner == null || (selectedItem = spinner.getSelectedItem()) == null) {
            return null;
        }
        return selectedItem.toString();
    }

    public final String g() {
        Object selectedItem;
        Spinner spinner = this.f28259e;
        if (spinner == null || (selectedItem = spinner.getSelectedItem()) == null) {
            return null;
        }
        return selectedItem.toString();
    }

    private void a(int i2) {
        RoboTextView roboTextView = this.n;
        if (roboTextView != null) {
            roboTextView.setVisibility(i2);
        }
        Spinner spinner = this.f28259e;
        if (spinner != null) {
            spinner.setVisibility(i2);
        }
        View view = this.o;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    private void b(int i2) {
        RoboTextView roboTextView = this.l;
        if (roboTextView != null) {
            roboTextView.setVisibility(i2);
        }
        Spinner spinner = this.k;
        if (spinner != null) {
            spinner.setVisibility(i2);
        }
        View view = this.m;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public final void a(CJRPincodeResponse cJRPincodeResponse) {
        ProgressDialog progressDialog = this.f28263i;
        String str = null;
        if (progressDialog != null) {
            if (progressDialog == null) {
                k.a();
            }
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = this.f28263i;
                if (progressDialog2 != null) {
                    progressDialog2.dismiss();
                }
                this.f28263i = null;
            }
        }
        if (cJRPincodeResponse != null) {
            CJRFloatingLabel cJRFloatingLabel = this.f28258d;
            if (cJRFloatingLabel != null) {
                cJRFloatingLabel.setVisibility(0);
            }
            View view = this.p;
            if (view != null) {
                view.setVisibility(0);
            }
            CJRFloatingLabel cJRFloatingLabel2 = this.f28258d;
            if (cJRFloatingLabel2 != null) {
                CJRPincodeResponse.CJRPincodeBody pincodeBody = cJRPincodeResponse.getPincodeBody();
                if (pincodeBody != null) {
                    str = pincodeBody.getState();
                }
                cJRFloatingLabel2.setText((CharSequence) str);
            }
            b(0);
            CJRPincodeResponse.CJRPincodeBody pincodeBody2 = cJRPincodeResponse.getPincodeBody();
            k.a((Object) pincodeBody2, "pincodeResponse.pincodeBody");
            if (pincodeBody2.getCityList() != null) {
                CJRPincodeResponse.CJRPincodeBody pincodeBody3 = cJRPincodeResponse.getPincodeBody();
                k.a((Object) pincodeBody3, "pincodeResponse.pincodeBody");
                this.f28262h = pincodeBody3.getCityList();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<CJRPincodeResponse.CJRCities> arrayList3 = this.f28262h;
                if (arrayList3 != null) {
                    if (arrayList3 == null) {
                        k.a();
                    }
                    if (arrayList3.size() > 0) {
                        ArrayList<CJRPincodeResponse.CJRCities> arrayList4 = this.f28262h;
                        if (arrayList4 == null) {
                            k.a();
                        }
                        int size = arrayList4.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<CJRPincodeResponse.CJRCities> arrayList5 = this.f28262h;
                            if (arrayList5 == null) {
                                k.a();
                            }
                            CJRPincodeResponse.CJRCities cJRCities = arrayList5.get(i2);
                            k.a((Object) cJRCities, "mCityList!!.get(index)");
                            arrayList.add(cJRCities.getCityName());
                        }
                        ArrayList<CJRPincodeResponse.CJRCities> arrayList6 = this.f28262h;
                        if (arrayList6 == null) {
                            k.a();
                        }
                        CJRPincodeResponse.CJRCities cJRCities2 = arrayList6.get(0);
                        k.a((Object) cJRCities2, "mCityList!!.get(0)");
                        arrayList2.addAll(cJRCities2.getPostOfficeList());
                    }
                }
                Context context = this.f28255a;
                if (context == null) {
                    k.a();
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.pre_t_train_spinner_item_dark, arrayList);
                Spinner spinner = this.k;
                if (spinner != null) {
                    spinner.setAdapter(arrayAdapter);
                }
                Spinner spinner2 = this.k;
                if (spinner2 != null) {
                    spinner2.setSelection(0);
                }
                a(0);
                x.e eVar = new x.e();
                Context context2 = this.f28255a;
                if (context2 == null) {
                    k.a();
                }
                eVar.element = new ArrayAdapter(context2, R.layout.pre_t_train_spinner_item_dark, arrayList2);
                Spinner spinner3 = this.f28259e;
                if (spinner3 != null) {
                    spinner3.setAdapter((ArrayAdapter) eVar.element);
                }
                Spinner spinner4 = this.f28259e;
                if (spinner4 != null) {
                    spinner4.setSelection(0);
                }
                Spinner spinner5 = this.k;
                if (spinner5 != null) {
                    spinner5.setOnItemSelectedListener(new a(this, arrayList2, eVar));
                }
            }
        }
    }
}
