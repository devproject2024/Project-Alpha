package com.travel.train.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.sendbird.android.constant.StringSet;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainResendTicketContactSelect;
import com.travel.train.activity.AJRTrainResendTicketEmailListSelect;
import com.travel.train.activity.AJRTrainSelectContactListActivity;
import com.travel.train.b.ao;
import com.travel.train.helper.k;
import com.travel.train.i.c;
import com.travel.train.i.l;
import com.travel.train.j.g;
import com.travel.train.j.h;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainResendContactDataResponse;
import com.travel.train.model.CJRTrainResendTicketResponse;
import com.travel.train.model.f;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryActionURLParams;
import com.travel.train.model.trainticket.a;
import com.travel.train.model.trainticket.e;
import com.travel.train.model.trainticket.j;
import io.reactivex.rxjava3.a.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class aa extends am implements b, l {

    /* renamed from: a  reason: collision with root package name */
    private CJRTrainOrderSummaryActionURLParams f26714a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26715b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f26716c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f26717d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f26718e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ao f26719f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ao f26720g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<j> f26721h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<j> f26722i;
    private ImageView j;
    private TextView k;
    private io.reactivex.rxjava3.b.b l;
    private List<a> m;
    private View n;
    private CJRTrainResendContactDataResponse o;

    public final void a() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_t_train_resend_ticket_home, viewGroup, false);
        this.l = new io.reactivex.rxjava3.b.b();
        this.f26715b = (TextView) inflate.findViewById(R.id.text_view_max_recipient_notification);
        this.n = inflate.findViewById(R.id.layout_progress);
        this.j = (ImageView) inflate.findViewById(R.id.image_view_cancel);
        this.k = (TextView) inflate.findViewById(R.id.text_view_resend_ticket_action);
        this.f26716c = (ImageView) inflate.findViewById(R.id.image_view_pick_contacts);
        this.f26717d = (RecyclerView) inflate.findViewById(R.id.recycler_view_contacts);
        this.f26718e = (RecyclerView) inflate.findViewById(R.id.recycler_view_emails);
        this.f26715b.setText(getString(R.string.you_can_resend_ticket_to_contacts_emails, 5, 5));
        this.j.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aa.this.c(view);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aa.this.b(view);
            }
        });
        this.f26716c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aa.this.a(view);
            }
        });
        this.f26717d.addOnItemTouchListener(new com.travel.train.helper.a(new c() {
            public final void a() {
                aa.this.a(e.CONTACT);
            }
        }));
        this.f26718e.addOnItemTouchListener(new com.travel.train.helper.a(new c() {
            public final void a() {
                aa.this.a(e.EMAIL);
            }
        }));
        a(true);
        this.l.a(y.a(new Callable() {
            public final Object call() {
                return aa.this.e();
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new io.reactivex.rxjava3.d.b() {
            public final void accept(Object obj, Object obj2) {
                aa.this.a((List) obj, (Throwable) obj2);
            }
        }));
        return inflate;
    }

    private void c() {
        if (com.paytm.utility.b.c((Context) getActivity())) {
            a(true);
            this.f26714a = ((CJRTrainOrderSummaryAction) getActivity().getIntent().getSerializableExtra("intent_extra_train_resend_ticket_data")).getUrlParams();
            String url = this.f26714a.getUrl();
            a.C0715a e2 = o.e(this.f26714a.getMethod());
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getActivity();
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.k;
            bVar.f42879c = e2;
            bVar.f42880d = url;
            bVar.f42882f = n.c((Context) getActivity());
            bVar.f42884h = null;
            bVar.f42885i = new CJRTrainResendContactDataResponse();
            bVar.j = this;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
            return;
        }
        a((CJRTrainResendContactDataResponse) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        FragmentActivity activity = getActivity();
        activity.setResult(0);
        activity.finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (com.paytm.utility.b.c((Context) getActivity())) {
            com.travel.train.b.a();
            String ae = com.travel.train.b.b().ae();
            if (!TextUtils.isEmpty(ae)) {
                f d2 = d();
                if (d2.getContactEmails().length == 0 && d2.getContactPhones().length == 0) {
                    com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.error), getResources().getString(R.string.no_contacts_or_emails_selected));
                    return;
                }
                a(true);
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getActivity();
                bVar.f42878b = a.c.TRAIN;
                bVar.n = a.b.USER_FACING;
                bVar.o = g.v;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = ae;
                bVar.f42882f = n.c((Context) getActivity());
                bVar.f42884h = new com.google.gsonhtcfix.f().a((Object) d2);
                bVar.f42885i = new CJRTrainResendTicketResponse();
                bVar.j = this;
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
                return;
            }
            return;
        }
        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet_train));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String string = getString(R.string.you_can_only_add_upto_contacts, 5);
        if (this.f26721h.size() - 1 >= 5) {
            Toast.makeText(getActivity(), string, 1).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<j> it2 = this.f26721h.iterator();
        while (it2.hasNext()) {
            j next = it2.next();
            if (next instanceof com.travel.train.model.trainticket.a) {
                arrayList.add((com.travel.train.model.trainticket.a) next);
            }
        }
        String string2 = getString(R.string.select_contacts);
        HashMap hashMap = new HashMap();
        hashMap.put("multiSelect", Boolean.TRUE);
        hashMap.put("maxLimit", 5);
        hashMap.put("title", string2);
        hashMap.put("intent_extra_multiple_contact", arrayList);
        hashMap.put("maxLimitExceedMessage", string);
        Intent intent = new Intent(getActivity(), AJRTrainSelectContactListActivity.class);
        intent.putExtra("intent_extra_contact_params", hashMap);
        startActivityForResult(intent, 999);
    }

    public final void a(e eVar, int i2) {
        if (eVar == e.CONTACT) {
            this.f26721h.remove(i2);
            if (this.f26721h.size() == 1) {
                j jVar = this.f26721h.get(0);
                if (jVar instanceof com.travel.train.model.trainticket.b) {
                    ((com.travel.train.model.trainticket.b) jVar).setHint(getString(R.string.enter_resend_mobile_number));
                }
            }
            this.f26719f.notifyDataSetChanged();
        } else if (eVar == e.EMAIL) {
            this.f26722i.remove(i2);
            if (this.f26722i.size() == 1) {
                j jVar2 = this.f26722i.get(0);
                if (jVar2 instanceof com.travel.train.model.trainticket.b) {
                    ((com.travel.train.model.trainticket.b) jVar2).setHint(getString(R.string.enter_resend_email_address));
                }
            }
            this.f26720g.notifyDataSetChanged();
        }
    }

    public final void a(e eVar) {
        if (eVar == e.CONTACT) {
            Intent intent = new Intent(getActivity(), AJRTrainResendTicketContactSelect.class);
            intent.putExtra("intent_extra_selected_contacts", this.f26721h);
            intent.putExtra("intent_extra_train_resend_profile_contacts", this.o.getContactPhones());
            intent.putExtra("maxLimitExceedMessage", getString(R.string.you_can_only_add_upto_contacts, 5));
            startActivityForResult(intent, 567);
        } else if (eVar == e.EMAIL) {
            Intent intent2 = new Intent(getActivity(), AJRTrainResendTicketEmailListSelect.class);
            intent2.putExtra("intent_extra_selected_emails", this.f26722i);
            intent2.putExtra("intent_extra_train_resend_profile_emails", this.o.getContactEmails());
            intent2.putExtra("maxLimitExceedMessage", getString(R.string.you_can_only_add_upto_contacts, 5));
            startActivityForResult(intent2, 568);
        }
    }

    public final void a(e eVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            a(eVar);
        }
    }

    public void onActivityResult(final int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 999) {
                ArrayList arrayList = new ArrayList();
                for (com.travel.train.model.trainticket.a add : (List) intent.getSerializableExtra("intent_extra_selected_contacts")) {
                    arrayList.add(add);
                }
                com.travel.train.model.trainticket.b bVar = new com.travel.train.model.trainticket.b();
                bVar.setHint(getString(R.string.enter_resend_mobile_number));
                arrayList.add(bVar);
                this.f26721h.clear();
                this.f26721h.addAll(arrayList);
                this.f26719f.notifyDataSetChanged();
            } else if (i2 == 567) {
                this.f26721h.clear();
                this.f26721h.addAll((List) intent.getSerializableExtra("intent_extra_selected_contacts"));
                this.f26719f.notifyDataSetChanged();
            } else if (i2 == 568) {
                this.f26722i.clear();
                this.f26722i.addAll((List) intent.getSerializableExtra("intent_extra_selected_emails"));
                this.f26720g.notifyDataSetChanged();
            }
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                int i2 = i2;
                if (i2 == 567) {
                    aa.this.f26719f.a();
                } else if (i2 == 568) {
                    aa.this.f26720g.a();
                }
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List e() throws Exception {
        return h.a(h.a((Context) getActivity()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list, Throwable th) throws Throwable {
        if (th == null) {
            this.m = list;
        } else {
            this.m = new ArrayList();
        }
        a(false);
        c();
    }

    public void onStop() {
        super.onStop();
        io.reactivex.rxjava3.b.b bVar = this.l;
        if (bVar != null && !bVar.isDisposed()) {
            this.l.dispose();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a(false);
        if (iJRPaytmDataModel instanceof CJRTrainResendContactDataResponse) {
            a((CJRTrainResendContactDataResponse) iJRPaytmDataModel);
        } else if ((iJRPaytmDataModel instanceof CJRTrainResendTicketResponse) && getActivity() != null && !getActivity().isFinishing()) {
            Intent intent = new Intent();
            intent.putExtra("intent_extra_train_resend_tickets_to", d());
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(false);
        if (iJRPaytmDataModel instanceof CJRTrainResendContactDataResponse) {
            a((CJRTrainResendContactDataResponse) null);
        } else if (iJRPaytmDataModel instanceof CJRTrainResendTicketResponse) {
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        com.travel.train.model.c message = ((com.travel.train.model.a) new com.google.gsonhtcfix.f().a(new String(networkResponse.data), com.travel.train.model.a.class)).getStatus().getMessage();
                        com.paytm.utility.b.b((Context) getActivity(), message.f27692a, message.f27693b);
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            if (i2 == 503 && getActivity() != null && !getActivity().isFinishing()) {
                String string = getResources().getString(R.string.bus_maintenance_error_title);
                String string2 = getResources().getString(R.string.bus_maintenance_error_description);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(string).setMessage(string2).setCancelable(false);
                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.cancel();
                        aa.this.getActivity().setResult(0);
                        aa.this.getActivity().finish();
                    }
                });
                builder.show();
            }
        }
    }

    private void a(boolean z) {
        this.n.setVisibility(z ? 0 : 8);
    }

    private void a(CJRTrainResendContactDataResponse cJRTrainResendContactDataResponse) {
        boolean z;
        this.f26721h = new ArrayList<>();
        this.f26722i = new ArrayList<>();
        if (cJRTrainResendContactDataResponse == null) {
            cJRTrainResendContactDataResponse = new CJRTrainResendContactDataResponse();
        }
        this.o = cJRTrainResendContactDataResponse;
        if (cJRTrainResendContactDataResponse != null) {
            String defaultPhone = cJRTrainResendContactDataResponse.getDefaultPhone();
            String defaultEmail = cJRTrainResendContactDataResponse.getDefaultEmail();
            String[] contactPhones = cJRTrainResendContactDataResponse.getContactPhones();
            if (contactPhones != null && contactPhones.length > 0) {
                o.a(this.m, contactPhones);
            }
            if (!TextUtils.isEmpty(defaultPhone)) {
                Iterator<com.travel.train.model.trainticket.a> it2 = this.m.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    com.travel.train.model.trainticket.a next = it2.next();
                    if (next.getContactNumber().equalsIgnoreCase(defaultPhone)) {
                        this.f26721h.add(next);
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    com.travel.train.j.a aVar = com.travel.train.j.a.f27481b;
                    com.travel.train.model.trainticket.a aVar2 = new com.travel.train.model.trainticket.a("", defaultPhone);
                    aVar2.setColor(aVar.a());
                    this.f26721h.add(aVar2);
                }
            }
            if (!TextUtils.isEmpty(defaultEmail)) {
                this.f26722i.add(new com.travel.train.model.trainticket.c("", defaultEmail));
            }
        }
        com.travel.train.model.trainticket.b bVar = new com.travel.train.model.trainticket.b();
        bVar.setHint(getActivity().getResources().getString(R.string.enter_resend_mobile_number));
        this.f26721h.add(bVar);
        com.travel.train.model.trainticket.b bVar2 = new com.travel.train.model.trainticket.b();
        bVar2.setHint(getActivity().getResources().getString(R.string.enter_resend_email_address));
        this.f26722i.add(bVar2);
        this.f26719f = new ao(getActivity(), this.f26721h, e.CONTACT, this);
        this.f26720g = new ao(getActivity(), this.f26722i, e.EMAIL, this);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getActivity());
        flexboxLayoutManager.c(0);
        flexboxLayoutManager.c();
        flexboxLayoutManager.b();
        flexboxLayoutManager.d(0);
        FlexboxLayoutManager flexboxLayoutManager2 = new FlexboxLayoutManager(getActivity());
        flexboxLayoutManager2.c(0);
        flexboxLayoutManager2.c();
        flexboxLayoutManager2.b();
        flexboxLayoutManager2.d(0);
        Rect rect = new Rect();
        rect.right = (int) getResources().getDimension(R.dimen.dimen_10dp);
        rect.top = (int) getResources().getDimension(R.dimen.dimen_7dp);
        this.f26717d.setLayoutManager(flexboxLayoutManager);
        this.f26717d.setAdapter(this.f26719f);
        this.f26717d.addItemDecoration(new k(rect));
        this.f26718e.setAdapter(this.f26720g);
        this.f26718e.addItemDecoration(new k(rect));
        this.f26718e.setLayoutManager(flexboxLayoutManager2);
    }

    private f d() {
        String queryParameter = Uri.parse(this.f26714a.getUrl()).getQueryParameter(StringSet.token);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<j> it2 = this.f26721h.iterator();
        while (it2.hasNext()) {
            j next = it2.next();
            if (next instanceof com.travel.train.model.trainticket.a) {
                arrayList.add(h.a(((com.travel.train.model.trainticket.a) next).getContactNumber()));
            }
        }
        Iterator<j> it3 = this.f26722i.iterator();
        while (it3.hasNext()) {
            j next2 = it3.next();
            if (next2 instanceof com.travel.train.model.trainticket.c) {
                arrayList2.add(((com.travel.train.model.trainticket.c) next2).getEmail());
            }
        }
        f fVar = new f();
        fVar.setToken(queryParameter);
        fVar.setContactPhones((String[]) arrayList.toArray(new String[0]));
        fVar.setContactEmails((String[]) arrayList2.toArray(new String[0]));
        return fVar;
    }

    public static aa b() {
        Bundle bundle = new Bundle();
        aa aaVar = new aa();
        aaVar.setArguments(bundle);
        return aaVar;
    }
}
