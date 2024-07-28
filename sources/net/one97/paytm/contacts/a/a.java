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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.contacts.e;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.GroupBean;
import net.one97.paytm.contacts.entities.beans.MTTopViewBean;
import net.one97.paytm.contacts.entities.beans.PaymentInstrument;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.postpayment.utils.WalletCircularProgressBar;
import net.one97.paytm.upi.registration.view.y;
import net.one97.paytm.upi.util.SwipeRevealLayout;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.af;
import net.one97.paytm.wallet.R;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<IJRDataModel> f49936a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRDataModel> f49937b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    e f49938c;

    /* renamed from: d  reason: collision with root package name */
    final y f49939d;

    /* renamed from: e  reason: collision with root package name */
    int f49940e;

    /* renamed from: f  reason: collision with root package name */
    final Context f49941f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f49942g;

    /* renamed from: h  reason: collision with root package name */
    private String f49943h;

    public a(Context context, e eVar, int i2) {
        k.c(context, "context");
        k.c(eVar, "listner");
        this.f49938c = eVar;
        this.f49939d = new y();
        this.f49943h = "";
        this.f49940e = i2;
        this.f49939d.a();
        this.f49941f = context;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
        if (i2 == net.one97.paytm.contacts.utils.e.k()) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_show_top_blue_icons_lyt, viewGroup, false);
            k.a((Object) inflate, "v");
            return new d(this, inflate);
        }
        net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
        if (i2 != net.one97.paytm.contacts.utils.e.b()) {
            net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
            if (i2 != net.one97.paytm.contacts.utils.e.c()) {
                net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
                if (i2 == net.one97.paytm.contacts.utils.e.a()) {
                    View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beneficiary_swipe_row, viewGroup, false);
                    k.a((Object) inflate2, "v");
                    return new C0886a(this, inflate2, this.f49938c);
                }
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_row, viewGroup, false);
                k.a((Object) inflate3, "v");
                return new b(this, inflate3, this.f49938c);
            }
        }
        View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_group_header, viewGroup, false);
        k.a((Object) inflate4, "v");
        return new c(inflate4);
    }

    public final int getItemCount() {
        return this.f49936a.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        RecyclerView.v vVar2 = vVar;
        int i3 = i2;
        k.c(vVar2, "holder");
        if (vVar2 instanceof c) {
            IJRDataModel iJRDataModel = this.f49936a.get(i3);
            k.a((Object) iJRDataModel, "filterList[position]");
            IJRDataModel iJRDataModel2 = iJRDataModel;
            c cVar = (c) vVar2;
            if (iJRDataModel2 != null) {
                GroupBean groupBean = (GroupBean) iJRDataModel2;
                k.c(groupBean, "contact");
                cVar.f49970a.setText(groupBean.getTitle());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.GroupBean");
        }
        int i4 = 8;
        if (vVar2 instanceof C0886a) {
            C0886a aVar = (C0886a) vVar2;
            IJRDataModel iJRDataModel3 = this.f49936a.get(i3);
            if (iJRDataModel3 != null) {
                ContactDetail contactDetail = (ContactDetail) iJRDataModel3;
                k.c(contactDetail, "item");
                y yVar = aVar.m.f49939d;
                SwipeRevealLayout swipeRevealLayout = aVar.f49951h;
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.getAdapterPosition());
                yVar.a(swipeRevealLayout, sb.toString());
                aVar.setIsRecyclable(false);
                if (contactDetail.isSelected()) {
                    aVar.f49952i.setVisibility(0);
                } else {
                    aVar.f49952i.setVisibility(8);
                }
                aVar.m.a(aVar.f49946c, contactDetail.getContactName(), true);
                if (p.a(SDKConstants.TYPE_BANK, contactDetail.getMode(), true)) {
                    aVar.m.a(aVar.f49947d, contactDetail.getContactDisplayDetail(), false);
                } else if (p.a("UPI", contactDetail.getMode(), true)) {
                    aVar.m.a(aVar.f49947d, contactDetail.getContactDisplayDetail(), false);
                }
                ImageView imageView = aVar.k;
                String ifsc = contactDetail.getIfsc();
                if (ifsc == null) {
                    k.a();
                }
                k.c(imageView, "imageView");
                k.c(ifsc, "ifscCode");
                CharSequence charSequence = ifsc;
                if (!TextUtils.isEmpty(charSequence) && p.a(charSequence, (CharSequence) "ICIC", false)) {
                    imageView.setVisibility(0);
                    imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.icici_bank_logo));
                } else if (!TextUtils.isEmpty(charSequence) && p.a(ifsc, "UPI", true)) {
                    imageView.setVisibility(0);
                    imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.ic_bhim));
                } else if (!TextUtils.isEmpty(charSequence)) {
                    imageView.setVisibility(0);
                    w.a().a(UpiRequestBuilder.getBankIconUrl(imageView.getContext(), ifsc)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView);
                }
                if (!TextUtils.isEmpty(contactDetail.getImageUrl())) {
                    aVar.j.setVisibility(0);
                    aVar.f49945b.setVisibility(8);
                    w.a().a(contactDetail.getImageUrl()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(aVar.j);
                } else {
                    aVar.j.setVisibility(8);
                    aVar.f49945b.setVisibility(0);
                    Object obj = aVar.l.get(aVar.getPosition() % 10);
                    k.a(obj, "mColorsArray[index]");
                    aVar.f49945b.setBackgroundColor(Color.parseColor((String) obj));
                    String nameInitials = UpiUtils.getNameInitials(contactDetail.getContactName());
                    k.a((Object) nameInitials, "UpiUtils.getNameInitials(item.contactName)");
                    if (nameInitials != null) {
                        String upperCase = nameInitials.toUpperCase();
                        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        aVar.f49945b.setText(upperCase);
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                aVar.f49944a.setOnClickListener(new C0886a.b(aVar, contactDetail));
                aVar.f49949f.setOnClickListener(new C0886a.c(aVar, contactDetail));
                aVar.f49950g.setOnClickListener(new C0886a.d(aVar, contactDetail));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
        } else if (vVar2 instanceof b) {
            if (this.f49936a.get(i3) instanceof ContactDetail) {
                b bVar = (b) vVar2;
                IJRDataModel iJRDataModel4 = this.f49936a.get(i3);
                if (iJRDataModel4 != null) {
                    ContactDetail contactDetail2 = (ContactDetail) iJRDataModel4;
                    k.c(contactDetail2, "item");
                    String contactName = contactDetail2.getContactName();
                    String primaryPhoneNumber = contactDetail2.getPrimaryPhoneNumber();
                    if (contactDetail2.isSelected()) {
                        bVar.f49963e.setVisibility(0);
                    } else {
                        bVar.f49963e.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(contactDetail2.getContactNewTime()) && TextUtils.isDigitsOnly(contactDetail2.getContactNewTime())) {
                        String contactNewTime = contactDetail2.getContactNewTime();
                        if (contactNewTime == null) {
                            throw new u("null cannot be cast to non-null type kotlin.String");
                        } else if (Long.parseLong(contactNewTime) - System.currentTimeMillis() > 0) {
                            bVar.f49965g.setVisibility(0);
                        } else {
                            bVar.f49965g.setVisibility(8);
                        }
                    } else if (TextUtils.isEmpty(contactDetail2.getContactNewAddedTimeLocal()) || !TextUtils.isDigitsOnly(contactDetail2.getContactNewAddedTimeLocal())) {
                        bVar.f49965g.setVisibility(8);
                    } else {
                        String contactNewAddedTimeLocal = contactDetail2.getContactNewAddedTimeLocal();
                        if (contactNewAddedTimeLocal == null) {
                            throw new u("null cannot be cast to non-null type kotlin.String");
                        } else if (Long.parseLong(contactNewAddedTimeLocal) - System.currentTimeMillis() > 0) {
                            bVar.f49965g.setVisibility(0);
                        } else {
                            bVar.f49965g.setVisibility(8);
                        }
                    }
                    bVar.f49961c.setText(contactName);
                    bVar.f49962d.setText(primaryPhoneNumber);
                    bVar.j.a(bVar.f49961c, contactName, true);
                    bVar.j.a(bVar.f49962d, primaryPhoneNumber, false);
                    if (!TextUtils.isEmpty(contactDetail2.getImageUrl())) {
                        bVar.f49966h.setVisibility(0);
                        bVar.f49960b.setVisibility(8);
                        w.a().a(contactDetail2.getImageUrl()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(bVar.f49966h);
                    } else {
                        bVar.f49966h.setVisibility(8);
                        bVar.f49960b.setVisibility(0);
                        Object obj2 = bVar.f49967i.get(bVar.getPosition() % 10);
                        k.a(obj2, "mColorsArray[index]");
                        bVar.f49960b.setBackgroundColor(Color.parseColor((String) obj2));
                        String nameInitials2 = UpiUtils.getNameInitials(contactName);
                        k.a((Object) nameInitials2, "UpiUtils.getNameInitials(name)");
                        if (nameInitials2 != null) {
                            String upperCase2 = nameInitials2.toUpperCase();
                            k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                            bVar.f49960b.setText(upperCase2);
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    bVar.f49959a.setOnClickListener(new b.C0889b(bVar, contactDetail2));
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
            }
        } else if (vVar2 instanceof d) {
            d dVar = (d) vVar2;
            IJRDataModel iJRDataModel5 = this.f49936a.get(i3);
            if (iJRDataModel5 != null) {
                MTTopViewBean mTTopViewBean = (MTTopViewBean) iJRDataModel5;
                k.c(mTTopViewBean, "MTTopViewBean");
                if (!mTTopViewBean.isAdded()) {
                    mTTopViewBean.setAdded(true);
                    Bundle bundle = new Bundle();
                    net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
                    bundle.putInt(net.one97.paytm.contacts.utils.e.h(), dVar.f49971a.f49940e);
                }
                if (mTTopViewBean.getShowSettingOption()) {
                    View view = dVar.itemView;
                    k.a((Object) view, "itemView");
                    TextView textView = (TextView) view.findViewById(R.id.tvsetting);
                    k.a((Object) textView, "itemView.tvsetting");
                    textView.setVisibility(0);
                } else {
                    View view2 = dVar.itemView;
                    k.a((Object) view2, "itemView");
                    TextView textView2 = (TextView) view2.findViewById(R.id.tvsetting);
                    k.a((Object) textView2, "itemView.tvsetting");
                    textView2.setVisibility(8);
                }
                View view3 = dVar.itemView;
                k.a((Object) view3, "itemView");
                Context context = view3.getContext();
                k.a((Object) context, "itemView.context");
                if (!s.c(context)) {
                    i4 = 0;
                }
                View view4 = dVar.itemView;
                k.a((Object) view4, "itemView");
                LinearLayout linearLayout = (LinearLayout) view4.findViewById(R.id.rootContactCardPermissionLayout);
                k.a((Object) linearLayout, "itemView.rootContactCardPermissionLayout");
                linearLayout.setVisibility(i4);
                x.c cVar2 = new x.c();
                cVar2.element = 0;
                try {
                    String string = dVar.f49971a.f49941f.getString(R.string.p2p_allow_paytm_to_access_your_contacts);
                    k.a((Object) string, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                    int a2 = p.a((CharSequence) string, "Privacy", 0, true);
                    SpannableString spannableString = new SpannableString(string);
                    spannableString.setSpan(new d.C0890a(dVar), a2, string.length(), 33);
                    View view5 = dVar.itemView;
                    k.a((Object) view5, "itemView");
                    TextView textView3 = (TextView) view5.findViewById(R.id.subTitleTv);
                    k.a((Object) textView3, "itemView.subTitleTv");
                    textView3.setText(spannableString);
                    View view6 = dVar.itemView;
                    k.a((Object) view6, "itemView");
                    TextView textView4 = (TextView) view6.findViewById(R.id.subTitleTv);
                    k.a((Object) textView4, "itemView.subTitleTv");
                    textView4.setMovementMethod(LinkMovementMethod.getInstance());
                    View view7 = dVar.itemView;
                    k.a((Object) view7, "itemView");
                    TextView textView5 = (TextView) view7.findViewById(R.id.subTitleTv);
                    k.a((Object) textView5, "itemView.subTitleTv");
                    textView5.setHighlightColor(0);
                    String string2 = dVar.f49971a.f49941f.getString(R.string.p2p_no_permission);
                    k.a((Object) string2, Item.KEY_TEXT1);
                    int a3 = p.a((CharSequence) string2, "Settings", 0, true);
                    SpannableString spannableString2 = new SpannableString(string2);
                    spannableString2.setSpan(new d.b(dVar), a3, string2.length(), 33);
                    View view8 = dVar.itemView;
                    k.a((Object) view8, "itemView");
                    TextView textView6 = (TextView) view8.findViewById(R.id.tvsetting);
                    k.a((Object) textView6, "itemView.tvsetting");
                    textView6.setText(spannableString2);
                    View view9 = dVar.itemView;
                    k.a((Object) view9, "itemView");
                    TextView textView7 = (TextView) view9.findViewById(R.id.tvsetting);
                    k.a((Object) textView7, "itemView.tvsetting");
                    textView7.setMovementMethod(LinkMovementMethod.getInstance());
                    View view10 = dVar.itemView;
                    k.a((Object) view10, "itemView");
                    TextView textView8 = (TextView) view10.findViewById(R.id.tvsetting);
                    k.a((Object) textView8, "itemView.tvsetting");
                    textView8.setHighlightColor(0);
                } catch (Exception unused) {
                }
                View view11 = dVar.itemView;
                k.a((Object) view11, "itemView");
                TextView textView9 = (TextView) view11.findViewById(R.id.allowContactAccessTv);
                if (textView9 != null) {
                    textView9.setOnClickListener(new d.c(dVar, mTTopViewBean, cVar2));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.MTTopViewBean");
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f49936a.get(i2) instanceof GroupBean) {
            IJRDataModel iJRDataModel = this.f49936a.get(i2);
            if (iJRDataModel != null) {
                return ((GroupBean) iJRDataModel).getGroupId();
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.GroupBean");
        } else if (this.f49936a.get(i2) instanceof ContactDetail) {
            IJRDataModel iJRDataModel2 = this.f49936a.get(i2);
            if (iJRDataModel2 != null) {
                return ((ContactDetail) iJRDataModel2).getContactType();
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
        } else if (this.f49936a.get(i2) instanceof MTTopViewBean) {
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            return net.one97.paytm.contacts.utils.e.k();
        } else {
            net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
            return net.one97.paytm.contacts.utils.e.f();
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f49970a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "v");
            TextView textView = (TextView) view.findViewById(R.id.tv_mt_header);
            k.a((Object) textView, "v.tv_mt_header");
            this.f49970a = textView;
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49971a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, View view) {
            super(view);
            k.c(view, "v");
            this.f49971a = aVar;
        }

        static final class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f49974a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MTTopViewBean f49975b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ x.c f49976c;

            c(d dVar, MTTopViewBean mTTopViewBean, x.c cVar) {
                this.f49974a = dVar;
                this.f49975b = mTTopViewBean;
                this.f49976c = cVar;
            }

            public final void onClick(View view) {
                if (this.f49975b.getShowSettingOption()) {
                    this.f49974a.f49971a.f49938c.a();
                }
                this.f49974a.f49971a.f49938c.d(this.f49976c.element == 0);
            }
        }

        /* renamed from: net.one97.paytm.contacts.a.a$d$a  reason: collision with other inner class name */
        public static final class C0890a extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f49972a;

            C0890a(d dVar) {
                this.f49972a = dVar;
            }

            public final void onClick(View view) {
                k.c(view, "widget");
                this.f49972a.f49971a.f49938c.a(e.d.PRIVACY_ALLOW.getType());
                Context context = view.getContext();
                k.a((Object) context, "widget.context");
                net.one97.paytm.wallet.utility.a.j(context);
            }
        }

        public static final class b extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f49973a;

            b(d dVar) {
                this.f49973a = dVar;
            }

            public final void onClick(View view) {
                k.c(view, "widget");
                this.f49973a.f49971a.f49938c.a();
            }
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RelativeLayout f49959a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f49960b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f49961c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f49962d;

        /* renamed from: e  reason: collision with root package name */
        final WalletCircularProgressBar f49963e;

        /* renamed from: f  reason: collision with root package name */
        final net.one97.paytm.contacts.e f49964f;

        /* renamed from: g  reason: collision with root package name */
        final TextView f49965g;

        /* renamed from: h  reason: collision with root package name */
        final ImageView f49966h;

        /* renamed from: i  reason: collision with root package name */
        final C0888a f49967i = new C0888a();
        final /* synthetic */ a j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view, net.one97.paytm.contacts.e eVar) {
            super(view);
            k.c(view, "v");
            k.c(eVar, "listner");
            this.j = aVar;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_main_row);
            k.a((Object) relativeLayout, "v.rl_main_row");
            this.f49959a = relativeLayout;
            TextView textView = (TextView) view.findViewById(R.id.contact_item_initials);
            k.a((Object) textView, "v.contact_item_initials");
            this.f49960b = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.layer_contact_name);
            k.a((Object) textView2, "v.layer_contact_name");
            this.f49961c = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.layer_contact_number);
            k.a((Object) textView3, "v.layer_contact_number");
            this.f49962d = textView3;
            WalletCircularProgressBar walletCircularProgressBar = (WalletCircularProgressBar) view.findViewById(R.id.progress_bar);
            k.a((Object) walletCircularProgressBar, "v.progress_bar");
            this.f49963e = walletCircularProgressBar;
            this.f49964f = eVar;
            TextView textView4 = (TextView) view.findViewById(R.id.tv_new_icon);
            k.a((Object) textView4, "v.tv_new_icon");
            this.f49965g = textView4;
            ImageView imageView = (ImageView) view.findViewById(R.id.p2p_img_profile);
            k.a((Object) imageView, "v.p2p_img_profile");
            this.f49966h = imageView;
        }

        /* renamed from: net.one97.paytm.contacts.a.a$b$a  reason: collision with other inner class name */
        public static final class C0888a extends ArrayList<String> {
            C0888a() {
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

        /* renamed from: net.one97.paytm.contacts.a.a$b$b  reason: collision with other inner class name */
        static final class C0889b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f49968a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ContactDetail f49969b;

            C0889b(b bVar, ContactDetail contactDetail) {
                this.f49968a = bVar;
                this.f49969b = contactDetail;
            }

            public final void onClick(View view) {
                this.f49968a.j.a(this.f49969b);
                this.f49968a.f49963e.setVisibility(0);
                ContactDetail contactDetail = this.f49969b;
                String a2 = net.one97.paytm.wallet.utility.a.a(contactDetail != null ? contactDetail.getPrimaryPhoneNumber() : null);
                if (a2.length() > 10) {
                    View view2 = this.f49968a.itemView;
                    k.a((Object) view2, "itemView");
                    Context context = view2.getContext();
                    if (context != null) {
                        a2 = net.one97.paytm.wallet.utility.a.a((Activity) context, a2);
                    } else {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                net.one97.paytm.contacts.e eVar = this.f49968a.f49964f;
                k.a((Object) a2, "filterNumber");
                eVar.a(a2, this.f49969b.getContactName(), true, this.f49969b);
                this.f49968a.j.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: net.one97.paytm.contacts.a.a$a  reason: collision with other inner class name */
    public final class C0886a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RelativeLayout f49944a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f49945b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f49946c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f49947d;

        /* renamed from: e  reason: collision with root package name */
        final net.one97.paytm.contacts.e f49948e;

        /* renamed from: f  reason: collision with root package name */
        final TextView f49949f;

        /* renamed from: g  reason: collision with root package name */
        final TextView f49950g;

        /* renamed from: h  reason: collision with root package name */
        SwipeRevealLayout f49951h;

        /* renamed from: i  reason: collision with root package name */
        final WalletCircularProgressBar f49952i;
        final ImageView j;
        final ImageView k;
        final C0887a l = new C0887a();
        final /* synthetic */ a m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0886a(a aVar, View view, net.one97.paytm.contacts.e eVar) {
            super(view);
            k.c(view, "v");
            k.c(eVar, "listner");
            this.m = aVar;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_main_row);
            k.a((Object) relativeLayout, "v.rl_main_row");
            this.f49944a = relativeLayout;
            TextView textView = (TextView) view.findViewById(R.id.contact_item_initials);
            k.a((Object) textView, "v.contact_item_initials");
            this.f49945b = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.layer_contact_name);
            k.a((Object) textView2, "v.layer_contact_name");
            this.f49946c = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.layer_contact_number);
            k.a((Object) textView3, "v.layer_contact_number");
            this.f49947d = textView3;
            this.f49948e = eVar;
            TextView textView4 = (TextView) view.findViewById(R.id.tv_remove);
            k.a((Object) textView4, "v.tv_remove");
            this.f49949f = textView4;
            TextView textView5 = (TextView) view.findViewById(R.id.tv_history);
            k.a((Object) textView5, "v.tv_history");
            this.f49950g = textView5;
            SwipeRevealLayout swipeRevealLayout = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            k.a((Object) swipeRevealLayout, "v.swipe_layout_2");
            this.f49951h = swipeRevealLayout;
            WalletCircularProgressBar walletCircularProgressBar = (WalletCircularProgressBar) view.findViewById(R.id.progress_bar);
            k.a((Object) walletCircularProgressBar, "v.progress_bar");
            this.f49952i = walletCircularProgressBar;
            ImageView imageView = (ImageView) view.findViewById(R.id.p2p_img_profile);
            k.a((Object) imageView, "v.p2p_img_profile");
            this.j = imageView;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_bank_logo);
            k.a((Object) imageView2, "v.img_bank_logo");
            this.k = imageView2;
        }

        /* renamed from: net.one97.paytm.contacts.a.a$a$a  reason: collision with other inner class name */
        public static final class C0887a extends ArrayList<String> {
            C0887a() {
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

        /* renamed from: net.one97.paytm.contacts.a.a$a$b */
        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0886a f49953a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ContactDetail f49954b;

            b(C0886a aVar, ContactDetail contactDetail) {
                this.f49953a = aVar;
                this.f49954b = contactDetail;
            }

            public final void onClick(View view) {
                this.f49953a.m.a(this.f49954b);
                this.f49953a.f49948e.a(this.f49954b);
            }
        }

        /* renamed from: net.one97.paytm.contacts.a.a$a$c */
        static final class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0886a f49955a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ContactDetail f49956b;

            c(C0886a aVar, ContactDetail contactDetail) {
                this.f49955a = aVar;
                this.f49956b = contactDetail;
            }

            public final void onClick(View view) {
                net.one97.paytm.contacts.utils.c cVar = net.one97.paytm.contacts.utils.c.f50249c;
                ContactDetail contactDetail = this.f49956b;
                net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
                k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
                Context context = a2.getContext();
                k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
                net.one97.paytm.contacts.utils.c.a(contactDetail, context);
                this.f49955a.m.f49937b.remove(this.f49955a.getAdapterPosition());
                this.f49955a.m.f49936a.remove(this.f49955a.getAdapterPosition());
                this.f49955a.m.f49939d.b(String.valueOf(this.f49955a.getAdapterPosition()));
                this.f49955a.m.notifyDataSetChanged();
            }
        }

        /* renamed from: net.one97.paytm.contacts.a.a$a$d */
        static final class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0886a f49957a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ContactDetail f49958b;

            d(C0886a aVar, ContactDetail contactDetail) {
                this.f49957a = aVar;
                this.f49958b = contactDetail;
            }

            public final void onClick(View view) {
                a aVar = this.f49957a.m;
                ContactDetail contactDetail = this.f49958b;
                HashSet<PaymentInstrument> paymentInstrument = contactDetail.getPaymentInstrument();
                PaymentInstrument paymentInstrument2 = paymentInstrument != null ? (PaymentInstrument) kotlin.a.k.c(paymentInstrument) : null;
                Object meta = paymentInstrument2 != null ? paymentInstrument2.getMeta() : null;
                if (meta != null) {
                    Map map = (Map) meta;
                    if (p.a(SDKConstants.TYPE_BANK, contactDetail.getMode(), true)) {
                        String str = map != null ? (String) map.get("accountNo") : null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("paytmmp://cash_wallet?featuretype=money_transfer_history");
                        sb.append("&payeeAccNoOrVpa=");
                        sb.append(str);
                        sb.append("&payeeName=");
                        sb.append(map != null ? (String) map.get("name") : null);
                        sb.append("&ifsc=");
                        sb.append(map != null ? (String) map.get("ifsc") : null);
                        sb.append("&bankName=");
                        sb.append(map != null ? (String) map.get("bankName") : null);
                        net.one97.paytm.wallet.communicator.b.a().handleDeepLink(aVar.f49941f, sb.toString(), (Bundle) null);
                    } else if (p.a("UPI", contactDetail.getMode(), true)) {
                        String str2 = map != null ? (String) map.get("vpa") : null;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("paytmmp://cash_wallet?featuretype=money_transfer_history");
                        sb2.append("&payeeAccNoOrVpa=");
                        sb2.append(str2);
                        sb2.append("&payeeName=");
                        sb2.append(map != null ? (String) map.get("name") : null);
                        net.one97.paytm.wallet.communicator.b.a().handleDeepLink(aVar.f49941f, sb2.toString(), (Bundle) null);
                    }
                    this.f49957a.f49951h.close(true);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<out kotlin.String, kotlin.String>");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ba, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) == false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00eb, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0107, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) != false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0109, code lost:
        r14 = r14 + 1;
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0136, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) == false) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0167, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0198, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r16, false) != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x019a, code lost:
        r14 = r14 + 1;
        r15 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "q"
            kotlin.g.b.k.c(r1, r2)
            r0.f49943h = r1
            java.lang.String r1 = r0.f49943h
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 1
            r1 = r1 ^ r2
            r0.f49942g = r1
            java.lang.String r1 = r0.f49943h
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.String"
            if (r1 == 0) goto L_0x0249
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r0.f49943h = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r5 = r0.f49943h
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            r6 = 0
            if (r5 <= 0) goto L_0x003a
            r5 = 1
            goto L_0x003b
        L_0x003a:
            r5 = 0
        L_0x003b:
            if (r5 == 0) goto L_0x0234
            java.lang.String r5 = r0.f49943h
            if (r5 == 0) goto L_0x022e
            java.lang.String r5 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r7 = " "
            java.lang.String[] r7 = new java.lang.String[]{r7}
            java.util.List r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.String[]) r7)
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.String[] r7 = new java.lang.String[r6]
            java.lang.Object[] r5 = r5.toArray(r7)
            if (r5 == 0) goto L_0x0226
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r7 = r0.f49937b
            java.util.Iterator r7 = r7.iterator()
            r9 = -99
            r10 = -99
        L_0x006a:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x01cb
            java.lang.Object r11 = r7.next()
            net.one97.paytm.common.entity.IJRDataModel r11 = (net.one97.paytm.common.entity.IJRDataModel) r11
            int r12 = r5.length
            r13 = r9
            r9 = 0
            r14 = 0
            r15 = 0
        L_0x007b:
            if (r9 >= r12) goto L_0x01c8
            r16 = r5[r9]
            boolean r6 = r11 instanceof net.one97.paytm.contacts.entities.beans.ContactDetail
            if (r6 == 0) goto L_0x01a4
            r6 = r11
            net.one97.paytm.contacts.entities.beans.ContactDetail r6 = (net.one97.paytm.contacts.entities.beans.ContactDetail) r6
            int r2 = r6.getContactType()
            net.one97.paytm.contacts.utils.e$b r17 = net.one97.paytm.contacts.utils.e.b.PHONEBOOK
            int r8 = r17.getType()
            if (r2 != r8) goto L_0x010e
            java.lang.String r2 = r6.getContactName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00c3
            java.lang.String r2 = r6.getContactName()
            if (r2 != 0) goto L_0x00a7
            kotlin.g.b.k.a()
        L_0x00a7:
            if (r2 == 0) goto L_0x00bd
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r8, false)
            if (r2 != 0) goto L_0x0109
            goto L_0x00c3
        L_0x00bd:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x00c3:
            java.lang.String r2 = r6.getContactNickName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00f4
            java.lang.String r2 = r6.getContactNickName()
            if (r2 != 0) goto L_0x00d8
            kotlin.g.b.k.a()
        L_0x00d8:
            if (r2 == 0) goto L_0x00ee
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r8, false)
            if (r2 != 0) goto L_0x0109
            goto L_0x00f4
        L_0x00ee:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x00f4:
            java.lang.String r2 = r6.getPrimaryPhoneNumber()
            if (r2 != 0) goto L_0x00fd
            kotlin.g.b.k.a()
        L_0x00fd:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6 = r16
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r6, false)
            if (r2 == 0) goto L_0x01a4
        L_0x0109:
            int r14 = r14 + 1
            r15 = 0
            goto L_0x01a4
        L_0x010e:
            java.lang.String r2 = r6.getContactName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x013f
            java.lang.String r2 = r6.getContactName()
            if (r2 != 0) goto L_0x0123
            kotlin.g.b.k.a()
        L_0x0123:
            if (r2 == 0) goto L_0x0139
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r8, false)
            if (r2 != 0) goto L_0x019a
            goto L_0x013f
        L_0x0139:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x013f:
            java.lang.String r2 = r6.getContactNickName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0170
            java.lang.String r2 = r6.getContactNickName()
            if (r2 != 0) goto L_0x0154
            kotlin.g.b.k.a()
        L_0x0154:
            if (r2 == 0) goto L_0x016a
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r8, false)
            if (r2 != 0) goto L_0x019a
            goto L_0x0170
        L_0x016a:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x0170:
            java.lang.String r2 = r6.getContactDisplayDetail()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01a4
            java.lang.String r2 = r6.getContactDisplayDetail()
            if (r2 != 0) goto L_0x0185
            kotlin.g.b.k.a()
        L_0x0185:
            if (r2 == 0) goto L_0x019e
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6 = r16
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r6, false)
            if (r2 == 0) goto L_0x01a4
        L_0x019a:
            int r14 = r14 + 1
            r15 = 1
            goto L_0x01a4
        L_0x019e:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x01a4:
            int r2 = r5.length
            if (r14 != r2) goto L_0x01c2
            if (r15 != 0) goto L_0x01b3
            r2 = -99
            if (r10 != r2) goto L_0x01bf
            int r6 = r1.size()
            r10 = r6
            goto L_0x01bf
        L_0x01b3:
            r2 = -99
            r6 = 1
            if (r15 != r6) goto L_0x01bf
            if (r13 != r2) goto L_0x01bf
            int r2 = r1.size()
            r13 = r2
        L_0x01bf:
            r1.add(r11)
        L_0x01c2:
            int r9 = r9 + 1
            r2 = 1
            r6 = 0
            goto L_0x007b
        L_0x01c8:
            r9 = r13
            goto L_0x006a
        L_0x01cb:
            r2 = -99
            if (r9 == r2) goto L_0x01f1
            if (r10 == r2) goto L_0x01d3
            int r10 = r10 + 1
        L_0x01d3:
            net.one97.paytm.contacts.entities.beans.GroupBean r2 = new net.one97.paytm.contacts.entities.beans.GroupBean
            r2.<init>()
            android.content.Context r3 = r0.f49941f
            int r4 = net.one97.paytm.wallet.R.string.p2p_mt_recent_saved_ac_new
            java.lang.String r3 = r3.getString(r4)
            r2.setTitle(r3)
            net.one97.paytm.contacts.utils.e r3 = net.one97.paytm.contacts.utils.e.f50261a
            int r3 = net.one97.paytm.contacts.utils.e.c()
            r2.setGroupId(r3)
            r1.add(r9, r2)
            r2 = -99
        L_0x01f1:
            if (r10 == r2) goto L_0x0242
            net.one97.paytm.contacts.entities.beans.GroupBean r2 = new net.one97.paytm.contacts.entities.beans.GroupBean
            r2.<init>()
            int r3 = r0.f49940e
            net.one97.paytm.contacts.utils.e$e r4 = net.one97.paytm.contacts.utils.e.C0905e.CONTACT_ONLY_WITH_RESULT
            int r4 = r4.getType()
            if (r3 != r4) goto L_0x020e
            android.content.Context r3 = r0.f49941f
            int r4 = net.one97.paytm.wallet.R.string.mt_contacts_only_p2p
            java.lang.String r3 = r3.getString(r4)
            r2.setTitle(r3)
            goto L_0x0219
        L_0x020e:
            android.content.Context r3 = r0.f49941f
            int r4 = net.one97.paytm.wallet.R.string.p2p_mt_contact_header_new
            java.lang.String r3 = r3.getString(r4)
            r2.setTitle(r3)
        L_0x0219:
            net.one97.paytm.contacts.utils.e r3 = net.one97.paytm.contacts.utils.e.f50261a
            int r3 = net.one97.paytm.contacts.utils.e.b()
            r2.setGroupId(r3)
            r1.add(r10, r2)
            goto L_0x0242
        L_0x0226:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
            r1.<init>(r2)
            throw r1
        L_0x022e:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x0234:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r2 = r0.f49936a
            r2.clear()
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r2 = r0.f49936a
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r3 = r0.f49937b
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
        L_0x0242:
            java.lang.String r2 = r0.f49943h
            r0.a(r1, r2)
            r1 = 1
            return r1
        L_0x0249:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.a.a.a(java.lang.String):boolean");
    }

    private final void a(ArrayList<IJRDataModel> arrayList, String str) {
        CharSequence charSequence = str;
        if (af.a(charSequence) || !af.a(charSequence) || (!net.one97.paytm.wallet.utility.a.b(str) && !af.a(str, (CharSequence) "@"))) {
            this.f49938c.b(false);
            this.f49938c.c(false);
        }
        if (arrayList.size() > 0) {
            this.f49936a.clear();
            this.f49936a.addAll(arrayList);
            this.f49938c.c(false);
            this.f49938c.a("");
        } else if (arrayList.size() == 0 && !TextUtils.isEmpty(charSequence) && TextUtils.isDigitsOnly(charSequence)) {
            this.f49936a.clear();
            this.f49938c.a(true);
            this.f49938c.c(false);
        } else if (arrayList.size() == 0 && !TextUtils.isEmpty(charSequence) && !p.a(charSequence, (CharSequence) " ", false) && net.one97.paytm.wallet.utility.a.y(str)) {
            this.f49936a.clear();
            this.f49938c.a(false);
            this.f49938c.b(true);
            this.f49938c.c(true);
        } else if (arrayList.size() != 0 || TextUtils.isEmpty(charSequence) || TextUtils.isDigitsOnly(charSequence)) {
            this.f49936a.clear();
            this.f49936a.addAll(this.f49937b);
            this.f49938c.a("");
            this.f49938c.b(false);
            this.f49938c.c(false);
        } else {
            net.one97.paytm.contacts.e eVar = this.f49938c;
            String string = this.f49941f.getString(R.string.search_no_string_found, new Object[]{str});
            k.a((Object) string, "mContext.getString(R.str…h_no_string_found, query)");
            eVar.a(string);
            this.f49936a.clear();
            this.f49938c.c(false);
            this.f49938c.b(false);
        }
        if (!af.a(charSequence) && (net.one97.paytm.wallet.utility.a.b(str) || af.a(str, (CharSequence) "@"))) {
            this.f49938c.b(true);
            if (af.a(str, (CharSequence) "@")) {
                this.f49938c.c(true);
            }
        }
        notifyDataSetChanged();
    }

    public final void a(ContactDetail contactDetail) {
        Iterator<IJRDataModel> it2 = this.f49936a.iterator();
        while (it2.hasNext()) {
            IJRDataModel next = it2.next();
            if (next instanceof ContactDetail) {
                if (contactDetail == null) {
                    ((ContactDetail) next).setSelected(false);
                } else {
                    ContactDetail contactDetail2 = (ContactDetail) next;
                    if (contactDetail2.getContactType() == e.b.TRANSFER_BENEFICIARY.getType()) {
                        contactDetail2.setSelected(p.a(contactDetail2.getContactId(), contactDetail.getContactId(), false));
                    } else {
                        contactDetail2.setSelected(p.a(contactDetail2.getUId(), contactDetail.getUId(), false));
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    private void a(TextView textView, String str, boolean z) {
        k.c(textView, "view");
        if (!this.f49942g || TextUtils.isEmpty(this.f49943h) || TextUtils.isEmpty(str)) {
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence)) {
                if (z) {
                    str = net.one97.paytm.wallet.utility.a.A(str);
                }
                textView.setText(str);
                return;
            }
            textView.setText(charSequence);
            return;
        }
        if (z) {
            str = net.one97.paytm.wallet.utility.a.A(str);
        }
        String str2 = this.f49943h;
        if (str2 != null) {
            String lowerCase = str2.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            Object[] array = p.a((CharSequence) lowerCase, new String[]{" "}).toArray(new String[0]);
            if (array != null) {
                CharSequence charSequence2 = str;
                SpannableString spannableString = new SpannableString(charSequence2);
                for (String str3 : (String[]) array) {
                    Integer valueOf = str != null ? Integer.valueOf(p.a(charSequence2, str3, 0, true)) : null;
                    if (this.f49942g && !TextUtils.isEmpty(str3) && valueOf != null && valueOf.intValue() != -1 && !TextUtils.isEmpty(charSequence2)) {
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
