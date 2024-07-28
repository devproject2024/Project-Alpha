package net.one97.paytm.contacts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.f.f;
import net.one97.paytm.postpayment.utils.WalletCircularProgressBar;
import net.one97.paytm.utils.ae;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.d.l;

public final class d extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f50124a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f50125b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public f f50126c;

    /* renamed from: d  reason: collision with root package name */
    private String f50127d = "";

    public d(Context context) {
        k.c(context, "mContext");
        this.f50126c = (f) context;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RelativeLayout f50128a;

        /* renamed from: b  reason: collision with root package name */
        final WalletCircularProgressBar f50129b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f50130c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f50131d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f50132e;

        /* renamed from: f  reason: collision with root package name */
        final C0899a f50133f = new C0899a();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "v");
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_main_row);
            k.a((Object) relativeLayout, "v.rl_main_row");
            this.f50128a = relativeLayout;
            WalletCircularProgressBar walletCircularProgressBar = (WalletCircularProgressBar) view.findViewById(R.id.progress_bar);
            k.a((Object) walletCircularProgressBar, "v.progress_bar");
            this.f50129b = walletCircularProgressBar;
            TextView textView = (TextView) view.findViewById(R.id.contact_item_initials);
            k.a((Object) textView, "v.contact_item_initials");
            this.f50130c = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.layer_contact_name);
            k.a((Object) textView2, "v.layer_contact_name");
            this.f50131d = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.layer_contact_number);
            k.a((Object) textView3, "v.layer_contact_number");
            this.f50132e = textView3;
        }

        /* renamed from: net.one97.paytm.contacts.d$a$a  reason: collision with other inner class name */
        public static final class C0899a extends ArrayList<String> {
            C0899a() {
                add("#2cce86");
                add("#6c7cff");
                add("#ffa400");
                add("#b069ec");
                add("#40cdd8");
                add("#fd5c7f");
                add("#f2c110");
                add("#f36bb4");
                add("#3ab6f4");
                add("#a6b7be");
            }

            public final /* bridge */ boolean contains(Object obj) {
                if (!(obj instanceof String)) {
                    return false;
                }
                return contains((String) obj);
            }

            public final /* bridge */ boolean contains(String str) {
                return super.contains(str);
            }

            public final int getSize() {
                return super.size();
            }

            public final /* bridge */ int indexOf(Object obj) {
                if (!(obj instanceof String)) {
                    return -1;
                }
                return indexOf((String) obj);
            }

            public final /* bridge */ int indexOf(String str) {
                return super.indexOf(str);
            }

            public final /* bridge */ int lastIndexOf(Object obj) {
                if (!(obj instanceof String)) {
                    return -1;
                }
                return lastIndexOf((String) obj);
            }

            public final /* bridge */ int lastIndexOf(String str) {
                return super.lastIndexOf(str);
            }

            public final String remove(int i2) {
                return removeAt(i2);
            }

            public final /* bridge */ boolean remove(Object obj) {
                if (!(obj instanceof String)) {
                    return false;
                }
                return remove((String) obj);
            }

            public final /* bridge */ boolean remove(String str) {
                return super.remove(str);
            }

            public final String removeAt(int i2) {
                return (String) super.remove(i2);
            }

            public final int size() {
                return getSize();
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f50134a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ RecentSendMoney f50135b;

            b(a aVar, RecentSendMoney recentSendMoney) {
                this.f50134a = aVar;
                this.f50135b = recentSendMoney;
            }

            public final void onClick(final View view) {
                this.f50134a.f50129b.setVisibility(0);
                final x.e eVar = new x.e();
                eVar.element = net.one97.paytm.wallet.utility.a.a(this.f50135b.getPhoneNumber());
                if (((String) eVar.element).length() > 10) {
                    View view2 = this.f50134a.itemView;
                    k.a((Object) view2, "itemView");
                    Context context = view2.getContext();
                    if (context != null) {
                        eVar.element = net.one97.paytm.wallet.utility.a.a((Activity) context, (String) eVar.element);
                    } else {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                c a2 = net.one97.paytm.wallet.communicator.b.a();
                k.a((Object) view, "it");
                if (a2.getBooleanFromGTM(view.getContext(), "mt_revamp_enabled", true)) {
                    net.one97.paytm.wallet.utility.a.a aVar = net.one97.paytm.wallet.utility.a.a.f72261c;
                    if (net.one97.paytm.wallet.utility.a.a.c() != null) {
                        net.one97.paytm.wallet.utility.a.a aVar2 = net.one97.paytm.wallet.utility.a.a.f72261c;
                        net.one97.paytm.network.a c2 = net.one97.paytm.wallet.utility.a.a.c();
                        if (c2 != null) {
                            c2.b();
                        }
                        net.one97.paytm.wallet.utility.a.a aVar3 = net.one97.paytm.wallet.utility.a.a.f72261c;
                        net.one97.paytm.wallet.utility.a.a.d();
                    }
                    net.one97.paytm.wallet.utility.a.a aVar4 = net.one97.paytm.wallet.utility.a.a.f72261c;
                    Context context2 = view.getContext();
                    if (context2 != null) {
                        String str = (String) eVar.element;
                        k.a((Object) str, "filterNumber");
                        aVar4.a((Activity) context2, str, "CONTACT", this.f50135b.getName()).observeForever(new z<net.one97.paytm.network.f>(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ b f50136a;

                            {
                                this.f50136a = r1;
                            }

                            public final /* synthetic */ void onChanged(Object obj) {
                                net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
                                this.f50136a.f50134a.f50129b.setVisibility(8);
                                if (fVar.f55796a == h.SUCCESS) {
                                    if (fVar.f55797b != null && (fVar.f55797b instanceof PaymentCombinationAPIResponse)) {
                                        IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                                        PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) iJRPaytmDataModel;
                                        if (paymentCombinationAPIResponse.getCategory() != null && p.a(paymentCombinationAPIResponse.getCategory(), "P2P", true)) {
                                            net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
                                            View view = view;
                                            k.a((Object) view, "it");
                                            Context context = view.getContext();
                                            k.a((Object) context, "it.context");
                                            net.one97.paytm.wallet.utility.d.a(context, iJRPaytmDataModel, (String) null, (String) null, e.C0905e.PAY.getType(), false, false, true, false, false);
                                            View view2 = view;
                                            k.a((Object) view2, "it");
                                            Context context2 = view2.getContext();
                                            if (context2 != null) {
                                                ((Activity) context2).finish();
                                                return;
                                            }
                                            throw new u("null cannot be cast to non-null type android.app.Activity");
                                        }
                                    }
                                } else if (fVar.f55796a == h.ERROR && fVar.f55798c != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("key_is_from_fragment", true);
                                    ae aeVar = ae.f69602a;
                                    if (ae.a(fVar.f55798c.f55799a)) {
                                        ae aeVar2 = ae.f69602a;
                                        View view3 = view;
                                        k.a((Object) view3, "it");
                                        Context context3 = view3.getContext();
                                        if (context3 != null) {
                                            ae.a((Activity) context3, fVar.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                                            return;
                                        }
                                        throw new u("null cannot be cast to non-null type android.app.Activity");
                                    }
                                    net.one97.paytm.wallet.utility.d dVar2 = net.one97.paytm.wallet.utility.d.f72319a;
                                    View view4 = view;
                                    k.a((Object) view4, "it");
                                    Context context4 = view4.getContext();
                                    if (context4 != null) {
                                        View view5 = view;
                                        k.a((Object) view5, "it");
                                        String j = com.paytm.utility.b.j(view5.getContext());
                                        View view6 = view;
                                        k.a((Object) view6, "it");
                                        net.one97.paytm.wallet.utility.d.a((Activity) context4, (String) null, (String) null, j, com.paytm.utility.b.l(view6.getContext()), this.f50136a.f50135b.getName(), (String) eVar.element, true, (ExtraData) null, true, false, false);
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type android.app.Activity");
                                }
                            }
                        });
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                }
                Context context3 = view.getContext();
                k.a((Object) context3, "it.context");
                String str2 = (String) eVar.element;
                k.a((Object) str2, "filterNumber");
                String name = this.f50135b.getName();
                k.a((Object) name, "contact.name");
                String modeOfPayment = this.f50135b.getModeOfPayment();
                Intent intent = new Intent();
                intent.putExtra("PHONE_NUMBER", str2);
                intent.putExtra("NAME", name);
                intent.putExtra("MODE", "MOBILE");
                intent.putExtra("MODE_OF_PAYMENT", modeOfPayment);
                if (context3 instanceof Activity) {
                    Activity activity = (Activity) context3;
                    net.one97.paytm.wallet.utility.a.a(intent, activity);
                    activity.finish();
                }
            }
        }
    }

    public static final class b extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "v");
        }
    }

    public final int getItemViewType(int i2) {
        b bVar = this.f50124a.get(i2);
        k.a((Object) bVar, "mP2PContactList[position]");
        return bVar.b();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_group_item_layout, viewGroup, false);
            k.a((Object) inflate, "v");
            return new b(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_item_layout, viewGroup, false);
        k.a((Object) inflate2, "v");
        return new a(inflate2);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            b bVar = this.f50124a.get(i2);
            k.a((Object) bVar, "mP2PContactList[position]");
            b bVar2 = bVar;
            k.c(bVar2, "item");
            IJRDataModel a2 = ((a) bVar2).a();
            if (a2 != null) {
                RecentSendMoney recentSendMoney = (RecentSendMoney) a2;
                Object obj = aVar.f50133f.get(aVar.getPosition() % 10);
                k.a(obj, "mColorsArray[index]");
                aVar.f50130c.setBackgroundColor(Color.parseColor((String) obj));
                String name = recentSendMoney.getName();
                String phoneNumber = recentSendMoney.getPhoneNumber();
                aVar.f50131d.setText(name);
                aVar.f50132e.setText(phoneNumber);
                String d2 = net.one97.paytm.wallet.utility.a.d(recentSendMoney.getName());
                k.a((Object) d2, "CJRWalletUtility.getInitialsSingle(contact.name)");
                aVar.f50130c.setText(d2);
                aVar.f50128a.setOnClickListener(new a.b(aVar, recentSendMoney));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.wallet.RecentSendMoney");
        } else if (vVar instanceof b) {
            b bVar3 = this.f50124a.get(i2);
            k.a((Object) bVar3, "mP2PContactList[position]");
            b bVar4 = bVar3;
            if (bVar4 instanceof c) {
                c cVar = (c) bVar4;
                k.c(cVar, "groupItem");
                View view = ((b) vVar).itemView;
                k.a((Object) view, "itemView");
                TextView textView = (TextView) view.findViewById(R.id.tv_group_title);
                if (textView != null) {
                    textView.setText(String.valueOf(cVar.a()));
                }
            }
        }
    }

    public final int getItemCount() {
        return this.f50124a.size();
    }

    public final boolean a(String str) {
        k.c(str, "q");
        String lowerCase = str.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence = lowerCase;
        if (!(charSequence.length() == 0)) {
            Iterator<b> it2 = this.f50125b.iterator();
            while (it2.hasNext()) {
                b next = it2.next();
                k.a((Object) next, "p2PContactEntity");
                if (next.b() == 1) {
                    IJRDataModel a2 = ((a) next).a();
                    if (a2 != null) {
                        RecentSendMoney recentSendMoney = (RecentSendMoney) a2;
                        String name = recentSendMoney.getName();
                        k.a((Object) name, "contactItem.name");
                        if (name != null) {
                            String lowerCase2 = name.toLowerCase();
                            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                            if (!p.a((CharSequence) lowerCase2, charSequence, false)) {
                                String phoneNumber = recentSendMoney.getPhoneNumber();
                                k.a((Object) phoneNumber, "contactItem.phoneNumber");
                                if (phoneNumber != null) {
                                    String lowerCase3 = phoneNumber.toLowerCase();
                                    k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
                                    if (!p.a((CharSequence) lowerCase3, charSequence, false)) {
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            arrayList.add(next);
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.wallet.RecentSendMoney");
                    }
                }
            }
        } else {
            f fVar = this.f50126c;
            if (fVar != null) {
                fVar.b();
            }
            this.f50124a.clear();
            this.f50124a.addAll(this.f50125b);
        }
        if (arrayList.size() > 0) {
            this.f50127d = lowerCase;
            f fVar2 = this.f50126c;
            if (fVar2 != null) {
                fVar2.b();
            }
            this.f50124a.clear();
            this.f50124a.addAll(arrayList);
        } else if (arrayList.size() == 0 && !TextUtils.isEmpty(charSequence)) {
            if (l.a(charSequence)) {
                f fVar3 = this.f50126c;
                if (fVar3 != null) {
                    fVar3.a();
                }
            } else {
                f fVar4 = this.f50126c;
                if (fVar4 != null) {
                    fVar4.b(lowerCase);
                }
            }
            this.f50124a.clear();
        }
        notifyDataSetChanged();
        return true;
    }
}
