package net.one97.paytm.contacts.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.GroupBean;
import net.one97.paytm.contacts.entities.beans.MTTopViewBean;
import net.one97.paytm.contacts.entities.beans.P2MRecentScan;
import net.one97.paytm.contacts.entities.beans.P2PRecentSendMoney;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.postpayment.utils.WalletCircularProgressBar;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<IJRDataModel> f49977a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRDataModel> f49978b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.contacts.e f49979c;

    /* renamed from: d  reason: collision with root package name */
    int f49980d;

    /* renamed from: e  reason: collision with root package name */
    final Context f49981e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f49982f;

    /* renamed from: g  reason: collision with root package name */
    private String f49983g;

    public b(Context context, net.one97.paytm.contacts.e eVar, int i2) {
        k.c(context, "context");
        k.c(eVar, "listner");
        this.f49979c = eVar;
        this.f49983g = "";
        this.f49980d = i2;
        this.f49981e = context;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
        if (i2 == net.one97.paytm.contacts.utils.e.k()) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_show_top_blue_icons_lyt, viewGroup, false);
            k.a((Object) inflate, "v");
            return new c(this, inflate);
        }
        net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
        if (i2 != net.one97.paytm.contacts.utils.e.b()) {
            net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
            if (i2 != net.one97.paytm.contacts.utils.e.c()) {
                net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
                if (i2 == net.one97.paytm.contacts.utils.e.e()) {
                    View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_row, viewGroup, false);
                    k.a((Object) inflate2, "v");
                    return new d(this, inflate2, this.f49979c);
                }
                net.one97.paytm.contacts.utils.e eVar5 = net.one97.paytm.contacts.utils.e.f50261a;
                if (i2 == net.one97.paytm.contacts.utils.e.d()) {
                    View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_row, viewGroup, false);
                    k.a((Object) inflate3, "v");
                    return new e(this, inflate3, this.f49979c);
                }
                View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_row, viewGroup, false);
                k.a((Object) inflate4, "v");
                return new a(this, inflate4, this.f49979c);
            }
        }
        View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_group_header, viewGroup, false);
        k.a((Object) inflate5, "v");
        return new C0893b(inflate5);
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f49996a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(view);
            k.c(view, "v");
            this.f49996a = bVar;
        }

        /* renamed from: net.one97.paytm.contacts.a.b$c$c  reason: collision with other inner class name */
        static final class C0895c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f49999a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MTTopViewBean f50000b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ x.c f50001c;

            C0895c(c cVar, MTTopViewBean mTTopViewBean, x.c cVar2) {
                this.f49999a = cVar;
                this.f50000b = mTTopViewBean;
                this.f50001c = cVar2;
            }

            public final void onClick(View view) {
                if (this.f50000b.getShowSettingOption()) {
                    this.f49999a.f49996a.f49979c.a();
                }
                this.f49999a.f49996a.f49979c.d(this.f50001c.element == 0);
            }
        }

        public static final class a extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f49997a;

            a(c cVar) {
                this.f49997a = cVar;
            }

            public final void onClick(View view) {
                k.c(view, "widget");
                this.f49997a.f49996a.f49979c.a(e.d.PRIVACY_ALLOW.getType());
                Context context = view.getContext();
                k.a((Object) context, "widget.context");
                net.one97.paytm.wallet.utility.a.j(context);
            }
        }

        /* renamed from: net.one97.paytm.contacts.a.b$c$b  reason: collision with other inner class name */
        public static final class C0894b extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f49998a;

            C0894b(c cVar) {
                this.f49998a = cVar;
            }

            public final void onClick(View view) {
                k.c(view, "widget");
                this.f49998a.f49996a.f49979c.a();
            }
        }
    }

    public final int getItemCount() {
        return this.f49977a.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof C0893b) {
            IJRDataModel iJRDataModel = this.f49977a.get(i2);
            k.a((Object) iJRDataModel, "filterList[position]");
            IJRDataModel iJRDataModel2 = iJRDataModel;
            C0893b bVar = (C0893b) vVar;
            if (iJRDataModel2 != null) {
                GroupBean groupBean = (GroupBean) iJRDataModel2;
                k.c(groupBean, "contact");
                bVar.f49995a.setText(groupBean.getTitle());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.GroupBean");
        } else if (vVar instanceof d) {
            d dVar = (d) vVar;
            IJRDataModel iJRDataModel3 = this.f49977a.get(i2);
            if (iJRDataModel3 != null) {
                P2MRecentScan p2MRecentScan = (P2MRecentScan) iJRDataModel3;
                k.c(p2MRecentScan, "item");
                if (p2MRecentScan.isSelected()) {
                    dVar.f50006e.setVisibility(0);
                } else {
                    dVar.f50006e.setVisibility(8);
                }
                dVar.f50010i.a(dVar.f50004c, p2MRecentScan.getName());
                dVar.f50005d.setVisibility(0);
                if (TextUtils.isEmpty(p2MRecentScan.getPhoneNumber())) {
                    dVar.f50005d.setText("Paytm Merchant");
                } else {
                    b bVar2 = dVar.f50010i;
                    TextView textView = dVar.f50005d;
                    bVar2.a(textView, "Paytm Merchant Linked to " + p2MRecentScan.getPhoneNumber());
                }
                if (!TextUtils.isEmpty(p2MRecentScan.getImageUrl())) {
                    ImageView imageView = dVar.f50008g;
                    k.a((Object) imageView, "profileImage");
                    imageView.setVisibility(0);
                    dVar.f50003b.setVisibility(8);
                    w.a().a(p2MRecentScan.getImageUrl()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(dVar.f50008g);
                } else {
                    Object obj = dVar.f50009h.get(dVar.getPosition() % 10);
                    k.a(obj, "mColorsArray[index]");
                    ImageView imageView2 = dVar.f50008g;
                    k.a((Object) imageView2, "profileImage");
                    imageView2.setVisibility(8);
                    dVar.f50003b.setVisibility(0);
                    dVar.f50003b.setBackgroundColor(Color.parseColor((String) obj));
                    String nameInitials = UpiUtils.getNameInitials(p2MRecentScan.getName());
                    k.a((Object) nameInitials, "UpiUtils.getNameInitials(item.name)");
                    if (nameInitials != null) {
                        String upperCase = nameInitials.toUpperCase();
                        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        dVar.f50003b.setText(upperCase);
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                dVar.f50002a.setOnClickListener(new d.C0896b(dVar, p2MRecentScan));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.P2MRecentScan");
        } else if (vVar instanceof a) {
            a aVar = (a) vVar;
            IJRDataModel iJRDataModel4 = this.f49977a.get(i2);
            if (iJRDataModel4 != null) {
                ContactDetail contactDetail = (ContactDetail) iJRDataModel4;
                k.c(contactDetail, "item");
                if (contactDetail.isSelected()) {
                    aVar.f49988e.setVisibility(0);
                } else {
                    aVar.f49988e.setVisibility(8);
                }
                if (!TextUtils.isEmpty(contactDetail.getContactNewTime()) && TextUtils.isDigitsOnly(contactDetail.getContactNewTime())) {
                    String contactNewTime = contactDetail.getContactNewTime();
                    if (contactNewTime == null) {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    } else if (Long.parseLong(contactNewTime) - System.currentTimeMillis() > 0) {
                        aVar.f49990g.setVisibility(0);
                    } else {
                        aVar.f49990g.setVisibility(8);
                    }
                } else if (TextUtils.isEmpty(contactDetail.getContactNewAddedTimeLocal()) || !TextUtils.isDigitsOnly(contactDetail.getContactNewAddedTimeLocal())) {
                    aVar.f49990g.setVisibility(8);
                } else {
                    String contactNewAddedTimeLocal = contactDetail.getContactNewAddedTimeLocal();
                    if (contactNewAddedTimeLocal == null) {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    } else if (Long.parseLong(contactNewAddedTimeLocal) - System.currentTimeMillis() > 0) {
                        aVar.f49990g.setVisibility(0);
                    } else {
                        aVar.f49990g.setVisibility(8);
                    }
                }
                aVar.j.a(aVar.f49986c, contactDetail.getContactName());
                aVar.j.a(aVar.f49987d, contactDetail.getPrimaryPhoneNumber());
                if (!TextUtils.isEmpty(contactDetail.getImageUrl())) {
                    aVar.f49991h.setVisibility(0);
                    aVar.f49985b.setVisibility(8);
                    w.a().a(contactDetail.getImageUrl()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(aVar.f49991h);
                } else {
                    aVar.f49991h.setVisibility(8);
                    aVar.f49985b.setVisibility(0);
                    Object obj2 = aVar.f49992i.get(aVar.getPosition() % 10);
                    k.a(obj2, "mColorsArray[index]");
                    aVar.f49985b.setBackgroundColor(Color.parseColor((String) obj2));
                    String nameInitials2 = UpiUtils.getNameInitials(contactDetail.getContactName());
                    k.a((Object) nameInitials2, "UpiUtils.getNameInitials(item.contactName)");
                    if (nameInitials2 != null) {
                        String upperCase2 = nameInitials2.toUpperCase();
                        k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                        aVar.f49985b.setText(upperCase2);
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                aVar.f49984a.setOnClickListener(new a.C0892b(aVar, contactDetail));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
        } else if (vVar instanceof e) {
            e eVar = (e) vVar;
            IJRDataModel iJRDataModel5 = this.f49977a.get(i2);
            if (iJRDataModel5 != null) {
                P2PRecentSendMoney p2PRecentSendMoney = (P2PRecentSendMoney) iJRDataModel5;
                k.c(p2PRecentSendMoney, "item");
                b bVar3 = eVar.f50021i;
                TextView textView2 = eVar.f50015c;
                RecentSendMoney recentSendMoney = p2PRecentSendMoney.getRecentSendMoney();
                k.a((Object) recentSendMoney, "item.recentSendMoney");
                bVar3.a(textView2, recentSendMoney.getName());
                b bVar4 = eVar.f50021i;
                TextView textView3 = eVar.f50016d;
                RecentSendMoney recentSendMoney2 = p2PRecentSendMoney.getRecentSendMoney();
                k.a((Object) recentSendMoney2, "item.recentSendMoney");
                bVar4.a(textView3, recentSendMoney2.getPhoneNumber());
                if (p2PRecentSendMoney.isSelected()) {
                    eVar.f50017e.setVisibility(0);
                } else {
                    eVar.f50017e.setVisibility(8);
                }
                RecentSendMoney recentSendMoney3 = p2PRecentSendMoney.getRecentSendMoney();
                k.a((Object) recentSendMoney3, "item.recentSendMoney");
                if (!TextUtils.isEmpty(recentSendMoney3.getImageurl())) {
                    eVar.f50019g.setVisibility(0);
                    eVar.f50014b.setVisibility(8);
                    w a2 = w.a();
                    RecentSendMoney recentSendMoney4 = p2PRecentSendMoney.getRecentSendMoney();
                    k.a((Object) recentSendMoney4, "item.recentSendMoney");
                    a2.a(recentSendMoney4.getImageurl()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(eVar.f50019g);
                } else {
                    Object obj3 = eVar.f50020h.get(eVar.getPosition() % 10);
                    k.a(obj3, "mColorsArray[index]");
                    String str = (String) obj3;
                    RecentSendMoney recentSendMoney5 = p2PRecentSendMoney.getRecentSendMoney();
                    k.a((Object) recentSendMoney5, "item.recentSendMoney");
                    String nameInitials3 = UpiUtils.getNameInitials(recentSendMoney5.getName());
                    k.a((Object) nameInitials3, "UpiUtils.getNameInitials…tem.recentSendMoney.name)");
                    if (nameInitials3 != null) {
                        String upperCase3 = nameInitials3.toUpperCase();
                        k.a((Object) upperCase3, "(this as java.lang.String).toUpperCase()");
                        eVar.f50019g.setVisibility(8);
                        eVar.f50014b.setVisibility(0);
                        eVar.f50014b.setText(upperCase3);
                        eVar.f50014b.setBackgroundColor(Color.parseColor(str));
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                eVar.f50013a.setOnClickListener(new e.C0897b(eVar, p2PRecentSendMoney));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.P2PRecentSendMoney");
        } else if (vVar instanceof c) {
            c cVar = (c) vVar;
            IJRDataModel iJRDataModel6 = this.f49977a.get(i2);
            if (iJRDataModel6 != null) {
                MTTopViewBean mTTopViewBean = (MTTopViewBean) iJRDataModel6;
                k.c(mTTopViewBean, "MTTopViewBean");
                if (!mTTopViewBean.isAdded()) {
                    mTTopViewBean.setAdded(true);
                    Bundle bundle = new Bundle();
                    net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
                    bundle.putInt(net.one97.paytm.contacts.utils.e.h(), cVar.f49996a.f49980d);
                }
                if (mTTopViewBean.getShowSettingOption()) {
                    View view = cVar.itemView;
                    k.a((Object) view, "itemView");
                    TextView textView4 = (TextView) view.findViewById(R.id.tvsetting);
                    k.a((Object) textView4, "itemView.tvsetting");
                    textView4.setVisibility(0);
                } else {
                    View view2 = cVar.itemView;
                    k.a((Object) view2, "itemView");
                    TextView textView5 = (TextView) view2.findViewById(R.id.tvsetting);
                    k.a((Object) textView5, "itemView.tvsetting");
                    textView5.setVisibility(8);
                }
                View view3 = cVar.itemView;
                k.a((Object) view3, "itemView");
                Context context = view3.getContext();
                k.a((Object) context, "itemView.context");
                int i3 = !s.c(context) ? 0 : 8;
                View view4 = cVar.itemView;
                k.a((Object) view4, "itemView");
                LinearLayout linearLayout = (LinearLayout) view4.findViewById(R.id.rootContactCardPermissionLayout);
                k.a((Object) linearLayout, "itemView.rootContactCardPermissionLayout");
                linearLayout.setVisibility(i3);
                x.c cVar2 = new x.c();
                cVar2.element = 0;
                if (!(!WalletSharedPrefs.isToContactSyncConcentAsked())) {
                    cVar2.element = 8;
                }
                try {
                    String string = cVar.f49996a.f49981e.getString(R.string.p2p_allow_paytm_to_access_your_contacts);
                    k.a((Object) string, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                    int a3 = p.a((CharSequence) string, "Privacy", 0, true);
                    SpannableString spannableString = new SpannableString(string);
                    spannableString.setSpan(new c.a(cVar), a3, string.length(), 33);
                    View view5 = cVar.itemView;
                    k.a((Object) view5, "itemView");
                    TextView textView6 = (TextView) view5.findViewById(R.id.subTitleTv);
                    k.a((Object) textView6, "itemView.subTitleTv");
                    textView6.setText(spannableString);
                    View view6 = cVar.itemView;
                    k.a((Object) view6, "itemView");
                    TextView textView7 = (TextView) view6.findViewById(R.id.subTitleTv);
                    k.a((Object) textView7, "itemView.subTitleTv");
                    textView7.setMovementMethod(LinkMovementMethod.getInstance());
                    View view7 = cVar.itemView;
                    k.a((Object) view7, "itemView");
                    TextView textView8 = (TextView) view7.findViewById(R.id.subTitleTv);
                    k.a((Object) textView8, "itemView.subTitleTv");
                    textView8.setHighlightColor(0);
                    String string2 = cVar.f49996a.f49981e.getString(R.string.p2p_no_permission);
                    k.a((Object) string2, Item.KEY_TEXT1);
                    int a4 = p.a((CharSequence) string2, "Settings", 0, true);
                    SpannableString spannableString2 = new SpannableString(string2);
                    spannableString2.setSpan(new c.C0894b(cVar), a4, string2.length(), 33);
                    View view8 = cVar.itemView;
                    k.a((Object) view8, "itemView");
                    TextView textView9 = (TextView) view8.findViewById(R.id.tvsetting);
                    k.a((Object) textView9, "itemView.tvsetting");
                    textView9.setText(spannableString2);
                    View view9 = cVar.itemView;
                    k.a((Object) view9, "itemView");
                    TextView textView10 = (TextView) view9.findViewById(R.id.tvsetting);
                    k.a((Object) textView10, "itemView.tvsetting");
                    textView10.setMovementMethod(LinkMovementMethod.getInstance());
                    View view10 = cVar.itemView;
                    k.a((Object) view10, "itemView");
                    TextView textView11 = (TextView) view10.findViewById(R.id.tvsetting);
                    k.a((Object) textView11, "itemView.tvsetting");
                    textView11.setHighlightColor(0);
                } catch (Exception unused) {
                }
                View view11 = cVar.itemView;
                k.a((Object) view11, "itemView");
                TextView textView12 = (TextView) view11.findViewById(R.id.allowContactAccessTv);
                if (textView12 != null) {
                    textView12.setOnClickListener(new c.C0895c(cVar, mTTopViewBean, cVar2));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.MTTopViewBean");
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f49977a.get(i2) instanceof GroupBean) {
            IJRDataModel iJRDataModel = this.f49977a.get(i2);
            if (iJRDataModel != null) {
                return ((GroupBean) iJRDataModel).getGroupId();
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.GroupBean");
        } else if (this.f49977a.get(i2) instanceof ContactDetail) {
            IJRDataModel iJRDataModel2 = this.f49977a.get(i2);
            if (iJRDataModel2 != null) {
                return ((ContactDetail) iJRDataModel2).getContactType();
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
        } else if (this.f49977a.get(i2) instanceof P2MRecentScan) {
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            return net.one97.paytm.contacts.utils.e.e();
        } else if (this.f49977a.get(i2) instanceof P2PRecentSendMoney) {
            net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
            return net.one97.paytm.contacts.utils.e.d();
        } else if (this.f49977a.get(i2) instanceof MTTopViewBean) {
            net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
            return net.one97.paytm.contacts.utils.e.k();
        } else {
            net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
            return net.one97.paytm.contacts.utils.e.f();
        }
    }

    /* renamed from: net.one97.paytm.contacts.a.b$b  reason: collision with other inner class name */
    public static final class C0893b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f49995a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0893b(View view) {
            super(view);
            k.c(view, "v");
            TextView textView = (TextView) view.findViewById(R.id.tv_mt_header);
            k.a((Object) textView, "v.tv_mt_header");
            this.f49995a = textView;
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RelativeLayout f49984a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f49985b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f49986c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f49987d;

        /* renamed from: e  reason: collision with root package name */
        final WalletCircularProgressBar f49988e;

        /* renamed from: f  reason: collision with root package name */
        final net.one97.paytm.contacts.e f49989f;

        /* renamed from: g  reason: collision with root package name */
        final TextView f49990g;

        /* renamed from: h  reason: collision with root package name */
        final ImageView f49991h;

        /* renamed from: i  reason: collision with root package name */
        final C0891a f49992i = new C0891a();
        final /* synthetic */ b j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view, net.one97.paytm.contacts.e eVar) {
            super(view);
            k.c(view, "v");
            k.c(eVar, "listner");
            this.j = bVar;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_main_row);
            k.a((Object) relativeLayout, "v.rl_main_row");
            this.f49984a = relativeLayout;
            TextView textView = (TextView) view.findViewById(R.id.contact_item_initials);
            k.a((Object) textView, "v.contact_item_initials");
            this.f49985b = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.layer_contact_name);
            k.a((Object) textView2, "v.layer_contact_name");
            this.f49986c = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.layer_contact_number);
            k.a((Object) textView3, "v.layer_contact_number");
            this.f49987d = textView3;
            WalletCircularProgressBar walletCircularProgressBar = (WalletCircularProgressBar) view.findViewById(R.id.progress_bar);
            k.a((Object) walletCircularProgressBar, "v.progress_bar");
            this.f49988e = walletCircularProgressBar;
            this.f49989f = eVar;
            TextView textView4 = (TextView) view.findViewById(R.id.tv_new_icon);
            k.a((Object) textView4, "v.tv_new_icon");
            this.f49990g = textView4;
            ImageView imageView = (ImageView) view.findViewById(R.id.p2p_img_profile);
            k.a((Object) imageView, "v.p2p_img_profile");
            this.f49991h = imageView;
        }

        /* renamed from: net.one97.paytm.contacts.a.b$a$a  reason: collision with other inner class name */
        public static final class C0891a extends ArrayList<String> {
            C0891a() {
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

        /* renamed from: net.one97.paytm.contacts.a.b$a$b  reason: collision with other inner class name */
        static final class C0892b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f49993a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ContactDetail f49994b;

            C0892b(a aVar, ContactDetail contactDetail) {
                this.f49993a = aVar;
                this.f49994b = contactDetail;
            }

            public final void onClick(View view) {
                this.f49993a.j.b(k.a(this.f49994b.getContactId(), (Object) this.f49994b.getPrimaryPhoneNumber()));
                this.f49993a.f49988e.setVisibility(0);
                ContactDetail contactDetail = this.f49994b;
                String a2 = net.one97.paytm.wallet.utility.a.a(contactDetail != null ? contactDetail.getPrimaryPhoneNumber() : null);
                if (a2.length() > 10) {
                    View view2 = this.f49993a.itemView;
                    k.a((Object) view2, "itemView");
                    Context context = view2.getContext();
                    if (context != null) {
                        a2 = net.one97.paytm.wallet.utility.a.a((Activity) context, a2);
                    } else {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                net.one97.paytm.contacts.e eVar = this.f49993a.f49989f;
                k.a((Object) a2, "filterNumber");
                eVar.a(a2, this.f49994b.getContactName(), true, this.f49994b);
                this.f49993a.j.notifyDataSetChanged();
            }
        }
    }

    public final class e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RelativeLayout f50013a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f50014b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f50015c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f50016d;

        /* renamed from: e  reason: collision with root package name */
        final WalletCircularProgressBar f50017e;

        /* renamed from: f  reason: collision with root package name */
        final net.one97.paytm.contacts.e f50018f;

        /* renamed from: g  reason: collision with root package name */
        final ImageView f50019g;

        /* renamed from: h  reason: collision with root package name */
        final a f50020h = new a();

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ b f50021i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, View view, net.one97.paytm.contacts.e eVar) {
            super(view);
            k.c(view, "v");
            k.c(eVar, "listner");
            this.f50021i = bVar;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_main_row);
            k.a((Object) relativeLayout, "v.rl_main_row");
            this.f50013a = relativeLayout;
            TextView textView = (TextView) view.findViewById(R.id.contact_item_initials);
            k.a((Object) textView, "v.contact_item_initials");
            this.f50014b = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.layer_contact_name);
            k.a((Object) textView2, "v.layer_contact_name");
            this.f50015c = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.layer_contact_number);
            k.a((Object) textView3, "v.layer_contact_number");
            this.f50016d = textView3;
            WalletCircularProgressBar walletCircularProgressBar = (WalletCircularProgressBar) view.findViewById(R.id.progress_bar);
            k.a((Object) walletCircularProgressBar, "v.progress_bar");
            this.f50017e = walletCircularProgressBar;
            this.f50018f = eVar;
            ImageView imageView = (ImageView) view.findViewById(R.id.p2p_img_profile);
            k.a((Object) imageView, "v.p2p_img_profile");
            this.f50019g = imageView;
        }

        public static final class a extends ArrayList<String> {
            a() {
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

        /* renamed from: net.one97.paytm.contacts.a.b$e$b  reason: collision with other inner class name */
        static final class C0897b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f50022a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ P2PRecentSendMoney f50023b;

            C0897b(e eVar, P2PRecentSendMoney p2PRecentSendMoney) {
                this.f50022a = eVar;
                this.f50023b = p2PRecentSendMoney;
            }

            public final void onClick(View view) {
                b bVar = this.f50022a.f50021i;
                RecentSendMoney recentSendMoney = this.f50023b.getRecentSendMoney();
                k.a((Object) recentSendMoney, "item.recentSendMoney");
                bVar.b(recentSendMoney.getPhoneNumber());
                this.f50022a.f50017e.setVisibility(0);
                RecentSendMoney recentSendMoney2 = this.f50023b.getRecentSendMoney();
                k.a((Object) recentSendMoney2, "item.recentSendMoney");
                String a2 = net.one97.paytm.wallet.utility.a.a(recentSendMoney2.getPhoneNumber());
                if (a2.length() > 10) {
                    View view2 = this.f50022a.itemView;
                    k.a((Object) view2, "itemView");
                    Context context = view2.getContext();
                    if (context != null) {
                        a2 = net.one97.paytm.wallet.utility.a.a((Activity) context, a2);
                    } else {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                net.one97.paytm.contacts.e eVar = this.f50022a.f50018f;
                k.a((Object) a2, "filterNumber");
                RecentSendMoney recentSendMoney3 = this.f50023b.getRecentSendMoney();
                k.a((Object) recentSendMoney3, "item.recentSendMoney");
                eVar.a(a2, recentSendMoney3.getName(), true, (ContactDetail) null);
                this.f50022a.f50021i.notifyDataSetChanged();
            }
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RelativeLayout f50002a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f50003b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f50004c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f50005d;

        /* renamed from: e  reason: collision with root package name */
        final WalletCircularProgressBar f50006e;

        /* renamed from: f  reason: collision with root package name */
        final net.one97.paytm.contacts.e f50007f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f50008g;

        /* renamed from: h  reason: collision with root package name */
        final a f50009h = new a();

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ b f50010i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, View view, net.one97.paytm.contacts.e eVar) {
            super(view);
            k.c(view, "v");
            k.c(eVar, "listner");
            this.f50010i = bVar;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_main_row);
            k.a((Object) relativeLayout, "v.rl_main_row");
            this.f50002a = relativeLayout;
            TextView textView = (TextView) view.findViewById(R.id.contact_item_initials);
            k.a((Object) textView, "v.contact_item_initials");
            this.f50003b = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.layer_contact_name);
            k.a((Object) textView2, "v.layer_contact_name");
            this.f50004c = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.layer_contact_number);
            k.a((Object) textView3, "v.layer_contact_number");
            this.f50005d = textView3;
            WalletCircularProgressBar walletCircularProgressBar = (WalletCircularProgressBar) view.findViewById(R.id.progress_bar);
            k.a((Object) walletCircularProgressBar, "v.progress_bar");
            this.f50006e = walletCircularProgressBar;
            this.f50007f = eVar;
            this.f50008g = (ImageView) view.findViewById(R.id.p2p_img_profile);
        }

        public static final class a extends ArrayList<String> {
            a() {
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

        /* renamed from: net.one97.paytm.contacts.a.b$d$b  reason: collision with other inner class name */
        static final class C0896b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f50011a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ P2MRecentScan f50012b;

            C0896b(d dVar, P2MRecentScan p2MRecentScan) {
                this.f50011a = dVar;
                this.f50012b = p2MRecentScan;
            }

            public final void onClick(View view) {
                this.f50011a.f50010i.b(this.f50012b.getRecentScan().getUniqKey());
                this.f50011a.f50006e.setVisibility(0);
                this.f50011a.f50007f.a(this.f50012b.getRecentScan());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ae, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e9, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) == false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fe, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) != false) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0100, code lost:
        r14 = r14 + 1;
        r18 = r7;
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013a, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r16, false) == false) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016b, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r16, false) == false) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x019c, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) != false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x019e, code lost:
        r14 = r14 + 1;
        r18 = r7;
        r15 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ec, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r16, false) == false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x021f, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r16, false) == false) goto L_0x0228;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "q"
            kotlin.g.b.k.c(r1, r2)
            r0.f49983g = r1
            java.lang.String r1 = r0.f49983g
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 1
            r1 = r1 ^ r2
            r0.f49982f = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r3 = r0.f49983g
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            r4 = 0
            if (r3 != 0) goto L_0x0029
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r3 != 0) goto L_0x02f5
            java.lang.String r3 = r0.f49983g
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            if (r3 == 0) goto L_0x02ef
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r6 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r7 = " "
            java.lang.String[] r7 = new java.lang.String[]{r7}
            java.util.List r3 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.String[]) r7)
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.String[] r7 = new java.lang.String[r4]
            java.lang.Object[] r3 = r3.toArray(r7)
            if (r3 == 0) goto L_0x02e7
            java.lang.String[] r3 = (java.lang.String[]) r3
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r7 = r0.f49978b
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r9 = -99
            r10 = -99
        L_0x005f:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x02a2
            java.lang.Object r11 = r7.next()
            net.one97.paytm.common.entity.IJRDataModel r11 = (net.one97.paytm.common.entity.IJRDataModel) r11
            int r12 = r3.length
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x006f:
            if (r13 >= r12) goto L_0x0271
            r16 = r3[r13]
            boolean r4 = r11 instanceof net.one97.paytm.contacts.entities.beans.ContactDetail
            if (r4 == 0) goto L_0x010b
            r4 = r11
            net.one97.paytm.contacts.entities.beans.ContactDetail r4 = (net.one97.paytm.contacts.entities.beans.ContactDetail) r4
            int r2 = r4.getContactType()
            net.one97.paytm.contacts.utils.e$b r17 = net.one97.paytm.contacts.utils.e.b.PHONEBOOK
            int r8 = r17.getType()
            if (r2 != r8) goto L_0x0107
            java.lang.String r2 = r4.getContactName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00b7
            java.lang.String r2 = r4.getContactName()
            if (r2 != 0) goto L_0x009b
            kotlin.g.b.k.a()
        L_0x009b:
            if (r2 == 0) goto L_0x00b1
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r8, false)
            if (r2 != 0) goto L_0x0100
            goto L_0x00b7
        L_0x00b1:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x00b7:
            java.lang.String r2 = r4.getContactNickName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00eb
            java.lang.String r2 = r4.getContactNickName()
            if (r2 == 0) goto L_0x00d9
            if (r2 == 0) goto L_0x00d3
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            goto L_0x00da
        L_0x00d3:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x00d9:
            r2 = 0
        L_0x00da:
            if (r2 != 0) goto L_0x00df
            kotlin.g.b.k.a()
        L_0x00df:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r8, false)
            if (r2 != 0) goto L_0x0100
        L_0x00eb:
            java.lang.String r2 = r4.getPrimaryPhoneNumber()
            if (r2 != 0) goto L_0x00f4
            kotlin.g.b.k.a()
        L_0x00f4:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = r16
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r4, false)
            if (r2 == 0) goto L_0x0107
        L_0x0100:
            int r14 = r14 + 1
            r18 = r7
            r15 = 0
            goto L_0x026a
        L_0x0107:
            r18 = r7
            goto L_0x026a
        L_0x010b:
            boolean r2 = r11 instanceof net.one97.paytm.contacts.entities.beans.P2MRecentScan
            if (r2 == 0) goto L_0x01ab
            r2 = r11
            net.one97.paytm.contacts.entities.beans.P2MRecentScan r2 = (net.one97.paytm.contacts.entities.beans.P2MRecentScan) r2
            java.lang.String r4 = r2.getName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0143
            java.lang.String r4 = r2.getName()
            if (r4 != 0) goto L_0x0127
            kotlin.g.b.k.a()
        L_0x0127:
            if (r4 == 0) goto L_0x013d
            java.lang.String r4 = r4.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r8, false)
            if (r4 != 0) goto L_0x019e
            goto L_0x0143
        L_0x013d:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x0143:
            java.lang.String r4 = r2.getNickName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0174
            java.lang.String r4 = r2.getNickName()
            if (r4 != 0) goto L_0x0158
            kotlin.g.b.k.a()
        L_0x0158:
            if (r4 == 0) goto L_0x016e
            java.lang.String r4 = r4.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r8, false)
            if (r4 != 0) goto L_0x019e
            goto L_0x0174
        L_0x016e:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x0174:
            java.lang.String r4 = r2.getPhoneNumber()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0107
            java.lang.String r2 = r2.getPhoneNumber()
            if (r2 != 0) goto L_0x0189
            kotlin.g.b.k.a()
        L_0x0189:
            if (r2 == 0) goto L_0x01a5
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = r16
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r4, false)
            if (r2 == 0) goto L_0x0107
        L_0x019e:
            int r14 = r14 + 1
            r18 = r7
            r15 = 1
            goto L_0x026a
        L_0x01a5:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x01ab:
            boolean r2 = r11 instanceof net.one97.paytm.contacts.entities.beans.P2PRecentSendMoney
            if (r2 == 0) goto L_0x0107
            r2 = r11
            net.one97.paytm.contacts.entities.beans.P2PRecentSendMoney r2 = (net.one97.paytm.contacts.entities.beans.P2PRecentSendMoney) r2
            net.one97.paytm.common.entity.wallet.RecentSendMoney r4 = r2.getRecentSendMoney()
            java.lang.String r8 = "item.recentSendMoney"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            java.lang.String r4 = r4.getName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01f5
            net.one97.paytm.common.entity.wallet.RecentSendMoney r4 = r2.getRecentSendMoney()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            java.lang.String r4 = r4.getName()
            r18 = r7
            java.lang.String r7 = "item.recentSendMoney.name"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            if (r4 == 0) goto L_0x01ef
            java.lang.String r4 = r4.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7 = r16
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r7, false)
            if (r4 != 0) goto L_0x0260
            goto L_0x01f7
        L_0x01ef:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x01f5:
            r18 = r7
        L_0x01f7:
            java.lang.String r4 = r2.getNickName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0228
            java.lang.String r4 = r2.getNickName()
            java.lang.String r7 = "item.nickName"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            if (r4 == 0) goto L_0x0222
            java.lang.String r4 = r4.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7 = r16
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r7, false)
            if (r4 != 0) goto L_0x0260
            goto L_0x0228
        L_0x0222:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x0228:
            net.one97.paytm.common.entity.wallet.RecentSendMoney r4 = r2.getRecentSendMoney()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            java.lang.String r4 = r4.getPhoneNumber()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x026a
            net.one97.paytm.common.entity.wallet.RecentSendMoney r2 = r2.getRecentSendMoney()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            java.lang.String r2 = r2.getPhoneNumber()
            java.lang.String r4 = "item.recentSendMoney.phoneNumber"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            if (r2 == 0) goto L_0x0264
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = r16
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r4, false)
            if (r2 == 0) goto L_0x026a
        L_0x0260:
            int r14 = r14 + 1
            r15 = 2
            goto L_0x026a
        L_0x0264:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x026a:
            int r13 = r13 + 1
            r7 = r18
            r2 = 1
            goto L_0x006f
        L_0x0271:
            r18 = r7
            int r2 = r3.length
            if (r14 != r2) goto L_0x029a
            if (r15 != 0) goto L_0x0281
            r2 = -99
            if (r10 != r2) goto L_0x0296
            int r10 = r1.size()
            goto L_0x0296
        L_0x0281:
            r2 = -99
            r4 = 1
            if (r15 != r4) goto L_0x028d
            if (r9 != r2) goto L_0x0296
            int r9 = r1.size()
            goto L_0x0296
        L_0x028d:
            r4 = 2
            if (r15 != r4) goto L_0x0296
            if (r9 != r2) goto L_0x0296
            int r9 = r1.size()
        L_0x0296:
            r1.add(r11)
            goto L_0x029c
        L_0x029a:
            r2 = -99
        L_0x029c:
            r7 = r18
            r2 = 1
            r4 = 0
            goto L_0x005f
        L_0x02a2:
            r2 = -99
            if (r9 == r2) goto L_0x02c8
            if (r10 == r2) goto L_0x02aa
            int r10 = r10 + 1
        L_0x02aa:
            net.one97.paytm.contacts.entities.beans.GroupBean r2 = new net.one97.paytm.contacts.entities.beans.GroupBean
            r2.<init>()
            android.content.Context r3 = r0.f49981e
            int r4 = net.one97.paytm.wallet.R.string.p2p_mt_recent_saved_ac_new
            java.lang.String r3 = r3.getString(r4)
            r2.setTitle(r3)
            net.one97.paytm.contacts.utils.e r3 = net.one97.paytm.contacts.utils.e.f50261a
            int r3 = net.one97.paytm.contacts.utils.e.c()
            r2.setGroupId(r3)
            r1.add(r9, r2)
            r2 = -99
        L_0x02c8:
            if (r10 == r2) goto L_0x0303
            net.one97.paytm.contacts.entities.beans.GroupBean r2 = new net.one97.paytm.contacts.entities.beans.GroupBean
            r2.<init>()
            android.content.Context r3 = r0.f49981e
            int r4 = net.one97.paytm.wallet.R.string.p2p_mt_contact_header_new
            java.lang.String r3 = r3.getString(r4)
            r2.setTitle(r3)
            net.one97.paytm.contacts.utils.e r3 = net.one97.paytm.contacts.utils.e.f50261a
            int r3 = net.one97.paytm.contacts.utils.e.b()
            r2.setGroupId(r3)
            r1.add(r10, r2)
            goto L_0x0303
        L_0x02e7:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
            r1.<init>(r2)
            throw r1
        L_0x02ef:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r5)
            throw r1
        L_0x02f5:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r2 = r0.f49977a
            r2.clear()
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r2 = r0.f49977a
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r3 = r0.f49978b
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
        L_0x0303:
            java.lang.String r2 = r0.f49983g
            r0.a((java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel>) r1, (java.lang.String) r2)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.a.b.a(java.lang.String):boolean");
    }

    private final void a(ArrayList<IJRDataModel> arrayList, String str) {
        if (arrayList.size() > 0) {
            this.f49977a.clear();
            this.f49977a.addAll(arrayList);
            this.f49979c.c(false);
            this.f49979c.a("");
        } else {
            if (arrayList.size() == 0) {
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence) && TextUtils.isDigitsOnly(charSequence)) {
                    this.f49977a.clear();
                    this.f49979c.a(true);
                    this.f49979c.c(false);
                }
            }
            if (arrayList.size() == 0) {
                CharSequence charSequence2 = str;
                if (!TextUtils.isEmpty(charSequence2) && !p.a(charSequence2, (CharSequence) " ", false) && net.one97.paytm.wallet.utility.a.y(str)) {
                    this.f49977a.clear();
                    this.f49979c.a(false);
                    this.f49979c.b(true);
                    this.f49979c.c(true);
                }
            }
            if (arrayList.size() == 0) {
                CharSequence charSequence3 = str;
                if (!TextUtils.isEmpty(charSequence3) && !TextUtils.isDigitsOnly(charSequence3)) {
                    net.one97.paytm.contacts.e eVar = this.f49979c;
                    aa aaVar = aa.f47921a;
                    String string = this.f49981e.getString(R.string.search_no_string_found, new Object[]{str});
                    k.a((Object) string, "mContext.getString(R.str…h_no_string_found, query)");
                    String format = String.format(string, Arrays.copyOf(new Object[0], 0));
                    k.a((Object) format, "java.lang.String.format(format, *args)");
                    eVar.a(format);
                    this.f49977a.clear();
                    this.f49979c.b(false);
                    this.f49979c.c(false);
                }
            }
            this.f49977a.clear();
            this.f49977a.addAll(this.f49978b);
            this.f49979c.a("");
            this.f49979c.b(false);
            this.f49979c.c(false);
        }
        notifyDataSetChanged();
    }

    public final void b(String str) {
        Iterator<IJRDataModel> it2 = this.f49977a.iterator();
        while (it2.hasNext()) {
            IJRDataModel next = it2.next();
            if (next instanceof ContactDetail) {
                ContactDetail contactDetail = (ContactDetail) next;
                contactDetail.setSelected(p.a(contactDetail.getUId(), str, false));
            } else if (next instanceof P2PRecentSendMoney) {
                P2PRecentSendMoney p2PRecentSendMoney = (P2PRecentSendMoney) next;
                RecentSendMoney recentSendMoney = p2PRecentSendMoney.getRecentSendMoney();
                k.a((Object) recentSendMoney, "contact.recentSendMoney");
                p2PRecentSendMoney.setSelected(k.a((Object) recentSendMoney.getPhoneNumber(), (Object) str));
            } else if (next instanceof P2MRecentScan) {
                P2MRecentScan p2MRecentScan = (P2MRecentScan) next;
                p2MRecentScan.setSelected(k.a((Object) p2MRecentScan.getRecentScan().getUniqKey(), (Object) str));
            }
            notifyDataSetChanged();
        }
    }

    private void a(TextView textView, String str) {
        k.c(textView, "view");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
            return;
        }
        String str2 = this.f49983g;
        if (str2 != null) {
            String lowerCase = str2.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            Object[] array = p.a((CharSequence) lowerCase, new String[]{" "}).toArray(new String[0]);
            if (array != null) {
                SpannableString spannableString = new SpannableString(charSequence);
                for (String str3 : (String[]) array) {
                    Integer valueOf = str != null ? Integer.valueOf(p.a(charSequence, str3, 0, true)) : null;
                    if (this.f49982f && !TextUtils.isEmpty(str3) && valueOf != null && valueOf.intValue() != -1 && !TextUtils.isEmpty(charSequence)) {
                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00aced")), valueOf.intValue(), valueOf.intValue() + str3.length(), 33);
                    }
                    textView.setText(spannableString);
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }
}
