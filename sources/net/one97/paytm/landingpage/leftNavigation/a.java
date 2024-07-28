package net.one97.paytm.landingpage.leftNavigation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.c;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.b;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.Utils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.home.LeftNavigationModel;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f52797a;

    /* renamed from: b  reason: collision with root package name */
    List<IJRDataModel> f52798b;

    /* renamed from: c  reason: collision with root package name */
    c f52799c;

    /* renamed from: d  reason: collision with root package name */
    net.one97.paytm.landingpage.c.a f52800d;

    /* renamed from: e  reason: collision with root package name */
    private int f52801e;

    /* renamed from: f  reason: collision with root package name */
    private final Activity f52802f;

    /* renamed from: g  reason: collision with root package name */
    private List<? extends View> f52803g;

    /* renamed from: h  reason: collision with root package name */
    private IGAHandlerListener f52804h;

    public interface c {
        void a(android.view.View view, int i2, LeftNavigationModel leftNavigationModel);
    }

    public enum f {
        VIEW_TYPE_HEADER,
        VIEW_TYPE_PROFILE_TOGGLE,
        VIEW_TYPE_FOOTER
    }

    public a(Activity activity, Context context, List<IJRDataModel> list, List<? extends View> list2, c cVar, net.one97.paytm.landingpage.c.a aVar, IGAHandlerListener iGAHandlerListener) {
        k.c(context, "context");
        k.c(cVar, "clicklistener");
        k.c(aVar, "imageLoadedListener");
        k.c(iGAHandlerListener, "gaListener");
        this.f52802f = activity;
        this.f52797a = context;
        this.f52798b = list;
        this.f52803g = list2;
        this.f52799c = cVar;
        this.f52800d = aVar;
        this.f52804h = iGAHandlerListener;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == f.VIEW_TYPE_HEADER.ordinal()) {
            android.view.View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.left_navigation_new_2, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…ion_new_2, parent, false)");
            return new b(this, inflate);
        } else if (i2 == f.VIEW_TYPE_PROFILE_TOGGLE.ordinal()) {
            android.view.View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.left_navigation_toggle_profile, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…e_profile, parent, false)");
            return new d(this, inflate2);
        } else if (i2 == f.VIEW_TYPE_FOOTER.ordinal()) {
            android.view.View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.left_navi_footer_layout, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(pare…er_layout, parent, false)");
            return new C0943a(this, inflate3);
        } else if (i2 == this.f52801e) {
            CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f52804h);
            k.a((Object) viewHolder, "ViewHolderFactory.getVie…Type)), null, gaListener)");
            return viewHolder;
        } else {
            android.view.View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.left_navi_separator, viewGroup, false);
            k.a((Object) inflate4, "LayoutInflater.from(pare…separator, parent, false)");
            return new e(this, inflate4);
        }
    }

    public final int getItemCount() {
        List<IJRDataModel> list = this.f52798b;
        if (list == null) {
            list = w.INSTANCE;
        }
        int size = list.size();
        List<? extends View> list2 = this.f52803g;
        if (list2 == null) {
            list2 = w.INSTANCE;
        }
        return size + list2.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        RecyclerView.v vVar2 = vVar;
        int i3 = i2;
        k.c(vVar2, "holder");
        IJRDataModel iJRDataModel = null;
        boolean z = true;
        if (i3 == 0) {
            List<IJRDataModel> list = this.f52798b;
            IJRDataModel iJRDataModel2 = list != null ? list.get(i3) : null;
            if (iJRDataModel2 != null) {
                LeftNavigationModel leftNavigationModel = (LeftNavigationModel) iJRDataModel2;
                if (vVar.getItemViewType() == f.VIEW_TYPE_HEADER.ordinal()) {
                    b bVar = (b) vVar2;
                    if (leftNavigationModel.getHeader() != null) {
                        LeftNavigationModel.HeaderModel header = leftNavigationModel.getHeader();
                        k.a((Object) header, "model.header");
                        if (com.paytm.utility.a.p(this.f52797a)) {
                            if (!TextUtils.isEmpty(header.getHeaderImageUrl())) {
                                if (p.a(Environment.getExternalStorageState(), "mounted", true)) {
                                    String str = Environment.getExternalStorageDirectory().toString() + com.paytm.utility.b.am(this.f52797a.getApplicationContext()) + UpiConstants.USER_PROFILE_PIC_FILENAME;
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeFile(str, options);
                                    int a2 = com.paytm.utility.b.a(48.0f, this.f52797a);
                                    options.inSampleSize = a(options, a2, a2);
                                    options.inJustDecodeBounds = false;
                                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                                    String headerImageUrl = header.getHeaderImageUrl();
                                    k.a((Object) headerImageUrl, "model.headerImageUrl");
                                    android.view.View view = bVar.itemView;
                                    k.a((Object) view, "headerViewHolder.itemView");
                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_left_navi);
                                    k.a((Object) imageView, "headerViewHolder.itemView.iv_left_navi");
                                    try {
                                        if (!com.paytm.utility.b.an(this.f52797a) || decodeFile == null) {
                                            b.a aVar = com.paytm.utility.b.b.f43744a;
                                            b.a.C0750a a3 = b.a.a(this.f52797a);
                                            a3.f43753a = headerImageUrl;
                                            b.a.C0750a a4 = b.a.C0750a.a(a3, a.c.HOME.name());
                                            Drawable a5 = androidx.core.content.b.a(this.f52797a, R.drawable.left_navi_default_user);
                                            if (a5 == null) {
                                                k.a();
                                            }
                                            k.a((Object) a5, "ContextCompat.getDrawabl…left_navi_default_user)!!");
                                            b.a.C0750a a6 = a4.a((Object) a5);
                                            a6.n = true;
                                            b.a.C0750a.a(a6, (ImageView) null, new h(this, imageView, headerImageUrl), 1);
                                        } else {
                                            b.a aVar2 = com.paytm.utility.b.b.f43744a;
                                            Context context = imageView.getContext();
                                            k.a((Object) context, "imageView.context");
                                            b.a.C0750a a7 = b.a.a(context);
                                            a7.f43753a = decodeFile;
                                            b.a.C0750a a8 = b.a.C0750a.a(a7, a.c.HOME.name());
                                            a8.n = true;
                                            b.a.C0750a.a(a8, (ImageView) null, new g(imageView), 1);
                                        }
                                    } catch (Exception e2) {
                                        q.b(e2.getMessage());
                                    }
                                }
                                android.view.View view2 = bVar.itemView;
                                k.a((Object) view2, "headerViewHolder.itemView");
                                TextView textView = (TextView) view2.findViewById(R.id.ic_user_name_img);
                                k.a((Object) textView, "headerViewHolder.itemView.ic_user_name_img");
                                textView.setVisibility(8);
                            } else {
                                if (a() != null) {
                                    android.view.View view3 = bVar.itemView;
                                    k.a((Object) view3, "headerViewHolder.itemView");
                                    TextView textView2 = (TextView) view3.findViewById(R.id.ic_user_name_img);
                                    k.a((Object) textView2, "headerViewHolder.itemView.ic_user_name_img");
                                    textView2.setVisibility(0);
                                    android.view.View view4 = bVar.itemView;
                                    k.a((Object) view4, "headerViewHolder.itemView");
                                    TextView textView3 = (TextView) view4.findViewById(R.id.ic_user_name_img);
                                    k.a((Object) textView3, "headerViewHolder.itemView.ic_user_name_img");
                                    textView3.setText(a());
                                } else {
                                    android.view.View view5 = bVar.itemView;
                                    k.a((Object) view5, "headerViewHolder.itemView");
                                    TextView textView4 = (TextView) view5.findViewById(R.id.ic_user_name_img);
                                    k.a((Object) textView4, "headerViewHolder.itemView.ic_user_name_img");
                                    textView4.setVisibility(8);
                                    android.view.View view6 = bVar.itemView;
                                    k.a((Object) view6, "headerViewHolder.itemView");
                                    ((ImageView) view6.findViewById(R.id.iv_left_navi)).setImageDrawable(androidx.core.content.b.a(this.f52797a, R.drawable.left_navi_default_user));
                                }
                                android.view.View view7 = bVar.itemView;
                                k.a((Object) view7, "headerViewHolder.itemView");
                                TextView textView5 = (TextView) view7.findViewById(R.id.tv_edit_profile);
                                k.a((Object) textView5, "headerViewHolder.itemView.tv_edit_profile");
                                textView5.setText(this.f52797a.getString(R.string.upload_photo_txt));
                            }
                            CharSequence name = header.getName();
                            if (!(name == null || name.length() == 0)) {
                                android.view.View view8 = bVar.itemView;
                                k.a((Object) view8, "headerViewHolder.itemView");
                                AppCompatTextView appCompatTextView = (AppCompatTextView) view8.findViewById(R.id.ln_name_tv);
                                k.a((Object) appCompatTextView, "headerViewHolder.itemView.ln_name_tv");
                                appCompatTextView.setText(header.getName());
                            }
                            CharSequence primaryUpiId = header.getPrimaryUpiId();
                            if (!(primaryUpiId == null || primaryUpiId.length() == 0)) {
                                z = false;
                            }
                            if (!z) {
                                android.view.View view9 = bVar.itemView;
                                k.a((Object) view9, "headerViewHolder.itemView");
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) view9.findViewById(R.id.upi_id_tv);
                                k.a((Object) appCompatTextView2, "headerViewHolder.itemView.upi_id_tv");
                                appCompatTextView2.setText(header.getPrimaryUpiId());
                                android.view.View view10 = bVar.itemView;
                                k.a((Object) view10, "headerViewHolder.itemView");
                                Group group = (Group) view10.findViewById(R.id.group_upi_id);
                                k.a((Object) group, "headerViewHolder.itemView.group_upi_id");
                                group.setVisibility(0);
                                android.view.View view11 = bVar.itemView;
                                k.a((Object) view11, "headerViewHolder.itemView");
                                Group group2 = (Group) view11.findViewById(R.id.group_link_bank);
                                k.a((Object) group2, "headerViewHolder.itemView.group_link_bank");
                                group2.setVisibility(8);
                            }
                            if (header.isShowLinkBankAccount()) {
                                android.view.View view12 = bVar.itemView;
                                k.a((Object) view12, "headerViewHolder.itemView");
                                TextView textView6 = (TextView) view12.findViewById(R.id.link_bank_tv);
                                k.a((Object) textView6, "headerViewHolder.itemView.link_bank_tv");
                                textView6.setText(this.f52797a.getString(R.string.link_bank_account));
                                android.view.View view13 = bVar.itemView;
                                k.a((Object) view13, "headerViewHolder.itemView");
                                Group group3 = (Group) view13.findViewById(R.id.group_upi_id);
                                k.a((Object) group3, "headerViewHolder.itemView.group_upi_id");
                                group3.setVisibility(8);
                                android.view.View view14 = bVar.itemView;
                                k.a((Object) view14, "headerViewHolder.itemView");
                                Group group4 = (Group) view14.findViewById(R.id.group_link_bank);
                                k.a((Object) group4, "headerViewHolder.itemView.group_link_bank");
                                group4.setVisibility(0);
                            }
                            android.view.View view15 = bVar.itemView;
                            k.a((Object) view15, "headerViewHolder.itemView");
                            Switch switchR = (Switch) view15.findViewById(R.id.switch_security_shield);
                            k.a((Object) switchR, "headerViewHolder.itemView.switch_security_shield");
                            switchR.setChecked(header.isSecurityShieldEnabled());
                            android.view.View view16 = bVar.itemView;
                            k.a((Object) view16, "headerViewHolder.itemView");
                            TextView textView7 = (TextView) view16.findViewById(R.id.tv_security_shield_subtitle);
                            k.a((Object) textView7, "headerViewHolder.itemVie…_security_shield_subtitle");
                            android.view.View view17 = bVar.itemView;
                            k.a((Object) view17, "headerViewHolder.itemView");
                            Switch switchR2 = (Switch) view17.findViewById(R.id.switch_security_shield);
                            k.a((Object) switchR2, "headerViewHolder.itemView.switch_security_shield");
                            if (switchR2.isChecked()) {
                                charSequence = this.f52797a.getString(R.string.paytm_security_shield_on_subtitle);
                            } else {
                                charSequence = this.f52797a.getString(R.string.paytm_security_shield_off_subtitle);
                            }
                            textView7.setText(charSequence);
                            android.view.View view18 = bVar.itemView;
                            k.a((Object) view18, "headerViewHolder.itemView");
                            AppCompatImageView appCompatImageView = (AppCompatImageView) view18.findViewById(R.id.view_logout);
                            k.a((Object) appCompatImageView, "headerViewHolder.itemView.view_logout");
                            appCompatImageView.setVisibility(8);
                            android.view.View view19 = bVar.itemView;
                            k.a((Object) view19, "headerViewHolder.itemView");
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view19.findViewById(R.id.view_login);
                            k.a((Object) appCompatImageView2, "headerViewHolder.itemView.view_login");
                            appCompatImageView2.setVisibility(0);
                            android.view.View view20 = bVar.itemView;
                            k.a((Object) view20, "headerViewHolder.itemView");
                            Group group5 = (Group) view20.findViewById(R.id.group_logout);
                            k.a((Object) group5, "headerViewHolder.itemView.group_logout");
                            group5.setVisibility(8);
                            android.view.View view21 = bVar.itemView;
                            k.a((Object) view21, "headerViewHolder.itemView");
                            Group group6 = (Group) view21.findViewById(R.id.group_login);
                            k.a((Object) group6, "headerViewHolder.itemView.group_login");
                            group6.setVisibility(0);
                            android.view.View view22 = bVar.itemView;
                            k.a((Object) view22, "headerViewHolder.itemView");
                            ConstraintLayout constraintLayout = (ConstraintLayout) view22.findViewById(R.id.iv_bg_security_shield);
                            k.a((Object) constraintLayout, "headerViewHolder.itemView.iv_bg_security_shield");
                            constraintLayout.setVisibility(0);
                            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                            android.view.View view23 = bVar.itemView;
                            k.a((Object) view23, "headerViewHolder.itemView");
                            cVar.b((ConstraintLayout) view23.findViewById(R.id.rootLayout));
                            android.view.View view24 = bVar.itemView;
                            k.a((Object) view24, "headerViewHolder.itemView");
                            Group group7 = (Group) view24.findViewById(R.id.group_upi_id);
                            k.a((Object) group7, "headerViewHolder.itemView.group_upi_id");
                            if (group7.getVisibility() != 0) {
                                android.view.View view25 = bVar.itemView;
                                k.a((Object) view25, "headerViewHolder.itemView");
                                Group group8 = (Group) view25.findViewById(R.id.group_link_bank);
                                k.a((Object) group8, "headerViewHolder.itemView.group_link_bank");
                                if (group8.getVisibility() != 0) {
                                    cVar.a(R.id.ln_name_tv, 4, R.id.iv_left_navi, 4);
                                    android.view.View view26 = bVar.itemView;
                                    k.a((Object) view26, "headerViewHolder.itemView");
                                    cVar.c((ConstraintLayout) view26.findViewById(R.id.rootLayout));
                                    return;
                                }
                            }
                            int i4 = R.id.ln_name_tv;
                            if (cVar.f2536c.containsKey(Integer.valueOf(i4))) {
                                c.a aVar3 = cVar.f2536c.get(Integer.valueOf(i4));
                                aVar3.f2541d.n = -1;
                                aVar3.f2541d.o = -1;
                                aVar3.f2541d.G = -1;
                                aVar3.f2541d.M = -1;
                            }
                            android.view.View view262 = bVar.itemView;
                            k.a((Object) view262, "headerViewHolder.itemView");
                            cVar.c((ConstraintLayout) view262.findViewById(R.id.rootLayout));
                            return;
                        }
                        android.view.View view27 = bVar.itemView;
                        k.a((Object) view27, "headerViewHolder.itemView");
                        Group group9 = (Group) view27.findViewById(R.id.group_logout);
                        k.a((Object) group9, "headerViewHolder.itemView.group_logout");
                        group9.setVisibility(0);
                        android.view.View view28 = bVar.itemView;
                        k.a((Object) view28, "headerViewHolder.itemView");
                        Group group10 = (Group) view28.findViewById(R.id.group_login);
                        k.a((Object) group10, "headerViewHolder.itemView.group_login");
                        group10.setVisibility(8);
                        android.view.View view29 = bVar.itemView;
                        k.a((Object) view29, "headerViewHolder.itemView");
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) view29.findViewById(R.id.view_logout);
                        k.a((Object) appCompatImageView3, "headerViewHolder.itemView.view_logout");
                        appCompatImageView3.setVisibility(0);
                        android.view.View view30 = bVar.itemView;
                        k.a((Object) view30, "headerViewHolder.itemView");
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) view30.findViewById(R.id.view_login);
                        k.a((Object) appCompatImageView4, "headerViewHolder.itemView.view_login");
                        appCompatImageView4.setVisibility(8);
                        android.view.View view31 = bVar.itemView;
                        k.a((Object) view31, "headerViewHolder.itemView");
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view31.findViewById(R.id.iv_bg_security_shield);
                        k.a((Object) constraintLayout2, "headerViewHolder.itemView.iv_bg_security_shield");
                        constraintLayout2.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
        }
        List<IJRDataModel> list2 = this.f52798b;
        if (list2 == null) {
            list2 = w.INSTANCE;
        }
        int size = list2.size();
        List<? extends View> list3 = this.f52803g;
        if (list3 == null) {
            list3 = w.INSTANCE;
        }
        if (i3 == (size + list3.size()) - 1) {
            List<IJRDataModel> list4 = this.f52798b;
            if (list4 == null) {
                list4 = w.INSTANCE;
            }
            if (!list4.isEmpty()) {
                List<IJRDataModel> list5 = this.f52798b;
                if (list5 != null) {
                    int size2 = list5.size() - 1;
                    List<IJRDataModel> list6 = this.f52798b;
                    if (list6 != null) {
                        iJRDataModel = list6.get(size2);
                    }
                }
                if (iJRDataModel != null) {
                    LeftNavigationModel leftNavigationModel2 = (LeftNavigationModel) iJRDataModel;
                    if (vVar.getItemViewType() == f.VIEW_TYPE_FOOTER.ordinal()) {
                        C0943a aVar4 = (C0943a) vVar2;
                        if (leftNavigationModel2.getFooter() != null) {
                            StringBuilder sb = new StringBuilder("V ");
                            sb.append(com.paytm.utility.b.Q(this.f52797a));
                            sb.append("( ");
                            net.one97.paytm.common.b.e a9 = net.one97.paytm.common.b.d.a();
                            k.a((Object) a9, "HomeHelper.getModuleInterface()");
                            sb.append(a9.o());
                            sb.append(" )");
                            String sb2 = sb.toString();
                            android.view.View view32 = aVar4.itemView;
                            k.a((Object) view32, "footerViewHolder.itemView");
                            TextView textView8 = (TextView) view32.findViewById(R.id.app_version);
                            k.a((Object) textView8, "footerViewHolder.itemView.app_version");
                            textView8.setText(sb2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
            }
        } else if (i3 == 1) {
            List<IJRDataModel> list7 = this.f52798b;
            IJRDataModel iJRDataModel3 = list7 != null ? list7.get(i3) : null;
            if (iJRDataModel3 != null) {
                LeftNavigationModel leftNavigationModel3 = (LeftNavigationModel) iJRDataModel3;
                if (vVar.getItemViewType() == f.VIEW_TYPE_PROFILE_TOGGLE.ordinal()) {
                    d dVar = (d) vVar2;
                    if (leftNavigationModel3.getHeader() != null) {
                        LeftNavigationModel.HeaderModel header2 = leftNavigationModel3.getHeader();
                        k.a((Object) header2, "model.header");
                        if (com.paytm.utility.a.p(this.f52797a)) {
                            if (!TextUtils.isEmpty(header2.getAccountNumber())) {
                                android.view.View view33 = dVar.itemView;
                                k.a((Object) view33, "profileToggleViewHolder.itemView");
                                TextView textView9 = (TextView) view33.findViewById(R.id.tv_ppbl_info);
                                k.a((Object) textView9, "profileToggleViewHolder.itemView.tv_ppbl_info");
                                aa aaVar = aa.f47921a;
                                String string = this.f52797a.getString(R.string.text_ppbl_info);
                                k.a((Object) string, "context.getString(R.string.text_ppbl_info)");
                                String format = String.format(string, Arrays.copyOf(new Object[]{header2.getAccountNumber()}, 1));
                                k.a((Object) format, "java.lang.String.format(format, *args)");
                                textView9.setText(format);
                            } else {
                                android.view.View view34 = dVar.itemView;
                                k.a((Object) view34, "profileToggleViewHolder.itemView");
                                TextView textView10 = (TextView) view34.findViewById(R.id.tv_ppbl_info);
                                k.a((Object) textView10, "profileToggleViewHolder.itemView.tv_ppbl_info");
                                textView10.setText(this.f52797a.getString(R.string.text_ppbl_info_api_fail));
                            }
                            if (!TextUtils.isEmpty(header2.getAccountBalance())) {
                                android.view.View view35 = dVar.itemView;
                                k.a((Object) view35, "profileToggleViewHolder.itemView");
                                TextView textView11 = (TextView) view35.findViewById(R.id.tv_ppbl_check_balance);
                                k.a((Object) textView11, "profileToggleViewHolder.…iew.tv_ppbl_check_balance");
                                aa aaVar2 = aa.f47921a;
                                String string2 = this.f52797a.getString(R.string.text_ppbl_balance);
                                k.a((Object) string2, "context.getString(R.string.text_ppbl_balance)");
                                String format2 = String.format(string2, Arrays.copyOf(new Object[]{header2.getAccountBalance()}, 1));
                                k.a((Object) format2, "java.lang.String.format(format, *args)");
                                textView11.setText(format2);
                                android.view.View view36 = dVar.itemView;
                                k.a((Object) view36, "profileToggleViewHolder.itemView");
                                ((TextView) view36.findViewById(R.id.tv_ppbl_check_balance)).setTextColor(androidx.core.content.b.c(this.f52797a, R.color.black));
                                android.view.View view37 = dVar.itemView;
                                k.a((Object) view37, "profileToggleViewHolder.itemView");
                                TextView textView12 = (TextView) view37.findViewById(R.id.tv_ppbl_check_balance);
                                k.a((Object) textView12, "profileToggleViewHolder.…iew.tv_ppbl_check_balance");
                                net.one97.paytm.utils.c.a.a(textView12, true);
                            } else {
                                android.view.View view38 = dVar.itemView;
                                k.a((Object) view38, "profileToggleViewHolder.itemView");
                                TextView textView13 = (TextView) view38.findViewById(R.id.tv_ppbl_check_balance);
                                k.a((Object) textView13, "profileToggleViewHolder.…iew.tv_ppbl_check_balance");
                                textView13.setText(this.f52797a.getString(R.string.check_balance));
                                android.view.View view39 = dVar.itemView;
                                k.a((Object) view39, "profileToggleViewHolder.itemView");
                                ((TextView) view39.findViewById(R.id.tv_ppbl_check_balance)).setTextColor(androidx.core.content.b.c(this.f52797a, R.color.event_blue_color));
                                android.view.View view40 = dVar.itemView;
                                k.a((Object) view40, "profileToggleViewHolder.itemView");
                                TextView textView14 = (TextView) view40.findViewById(R.id.tv_ppbl_check_balance);
                                k.a((Object) textView14, "profileToggleViewHolder.…iew.tv_ppbl_check_balance");
                                net.one97.paytm.utils.c.a.a(textView14, false);
                            }
                            List<String> availableProfiles = header2.getAvailableProfiles();
                            k.a((Object) availableProfiles, "model.availableProfiles");
                            if (!(!availableProfiles.isEmpty()) || header2.getAvailableProfiles().size() <= 1) {
                                android.view.View view41 = dVar.itemView;
                                k.a((Object) view41, "profileToggleViewHolder.itemView");
                                android.view.View findViewById = view41.findViewById(R.id.view_profile);
                                k.a((Object) findViewById, "profileToggleViewHolder.itemView.view_profile");
                                findViewById.setVisibility(8);
                                android.view.View view42 = dVar.itemView;
                                k.a((Object) view42, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) view42.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView3, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView3.setVisibility(8);
                                android.view.View view43 = dVar.itemView;
                                k.a((Object) view43, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) view43.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView4, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView4.setVisibility(8);
                                android.view.View view44 = dVar.itemView;
                                k.a((Object) view44, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) view44.findViewById(R.id.tv_personal_profile);
                                k.a((Object) appCompatTextView5, "profileToggleViewHolder.…mView.tv_personal_profile");
                                appCompatTextView5.setVisibility(8);
                                return;
                            }
                            android.view.View view45 = dVar.itemView;
                            k.a((Object) view45, "profileToggleViewHolder.itemView");
                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) view45.findViewById(R.id.tv_personal_profile);
                            k.a((Object) appCompatTextView6, "profileToggleViewHolder.…mView.tv_personal_profile");
                            appCompatTextView6.setVisibility(0);
                            if (header2.getAvailableProfiles().contains(e.b.RESELLER.name())) {
                                android.view.View view46 = dVar.itemView;
                                k.a((Object) view46, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView7 = (AppCompatTextView) view46.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView7, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView7.setVisibility(0);
                            }
                            if (header2.getAvailableProfiles().contains(e.b.MERCHANT.name())) {
                                android.view.View view47 = dVar.itemView;
                                k.a((Object) view47, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) view47.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView8, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView8.setVisibility(0);
                            }
                            android.view.View view48 = dVar.itemView;
                            k.a((Object) view48, "profileToggleViewHolder.itemView");
                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) view48.findViewById(R.id.tv_personal_profile);
                            k.a((Object) appCompatTextView9, "profileToggleViewHolder.…mView.tv_personal_profile");
                            appCompatTextView9.setText(this.f52797a.getString(R.string.text_personal_left_nav));
                            android.view.View view49 = dVar.itemView;
                            k.a((Object) view49, "profileToggleViewHolder.itemView");
                            AppCompatTextView appCompatTextView10 = (AppCompatTextView) view49.findViewById(R.id.tv_merchant_profile);
                            k.a((Object) appCompatTextView10, "profileToggleViewHolder.…mView.tv_merchant_profile");
                            appCompatTextView10.setText(this.f52797a.getString(R.string.text_merchant_left_nav));
                            android.view.View view50 = dVar.itemView;
                            k.a((Object) view50, "profileToggleViewHolder.itemView");
                            AppCompatTextView appCompatTextView11 = (AppCompatTextView) view50.findViewById(R.id.tv_service_profile);
                            k.a((Object) appCompatTextView11, "profileToggleViewHolder.…emView.tv_service_profile");
                            appCompatTextView11.setText(this.f52797a.getString(R.string.text_service_agent_left_nav));
                            android.view.View view51 = dVar.itemView;
                            k.a((Object) view51, "profileToggleViewHolder.itemView");
                            android.view.View findViewById2 = view51.findViewById(R.id.view_profile);
                            k.a((Object) findViewById2, "profileToggleViewHolder.itemView.view_profile");
                            findViewById2.setVisibility(0);
                            if (header2.getSelectedProfile().equals(e.b.RESELLER.name())) {
                                android.view.View view52 = dVar.itemView;
                                k.a((Object) view52, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView12 = (AppCompatTextView) view52.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView12, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView12.setTypeface(Typeface.create("sans-serif-medium", 0));
                                android.view.View view53 = dVar.itemView;
                                k.a((Object) view53, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView13 = (AppCompatTextView) view53.findViewById(R.id.tv_personal_profile);
                                k.a((Object) appCompatTextView13, "profileToggleViewHolder.…mView.tv_personal_profile");
                                appCompatTextView13.setTypeface(Typeface.create("sans-serif-regular", 0));
                                android.view.View view54 = dVar.itemView;
                                k.a((Object) view54, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView14 = (AppCompatTextView) view54.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView14, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView14.setTypeface(Typeface.create("sans-serif-regular", 0));
                                android.view.View view55 = dVar.itemView;
                                k.a((Object) view55, "profileToggleViewHolder.itemView");
                                Group group11 = (Group) view55.findViewById(R.id.group_ppbl_info);
                                k.a((Object) group11, "profileToggleViewHolder.itemView.group_ppbl_info");
                                group11.setVisibility(0);
                                android.view.View view56 = dVar.itemView;
                                k.a((Object) view56, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView15 = (AppCompatTextView) view56.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView15, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView15.setBackground(androidx.core.content.b.a(this.f52797a, R.drawable.rectangle_selected_profile));
                                android.view.View view57 = dVar.itemView;
                                k.a((Object) view57, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView16 = (AppCompatTextView) view57.findViewById(R.id.tv_personal_profile);
                                k.a((Object) appCompatTextView16, "profileToggleViewHolder.…mView.tv_personal_profile");
                                appCompatTextView16.setBackground((Drawable) null);
                                android.view.View view58 = dVar.itemView;
                                k.a((Object) view58, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView17 = (AppCompatTextView) view58.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView17, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView17.setBackground((Drawable) null);
                            } else if (header2.getSelectedProfile().equals(e.b.MERCHANT.name())) {
                                android.view.View view59 = dVar.itemView;
                                k.a((Object) view59, "profileToggleViewHolder.itemView");
                                android.view.View findViewById3 = view59.findViewById(R.id.view_profile);
                                k.a((Object) findViewById3, "profileToggleViewHolder.itemView.view_profile");
                                findViewById3.setVisibility(0);
                                android.view.View view60 = dVar.itemView;
                                k.a((Object) view60, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView18 = (AppCompatTextView) view60.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView18, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView18.setTypeface(Typeface.create("sans-serif-medium", 0));
                                android.view.View view61 = dVar.itemView;
                                k.a((Object) view61, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView19 = (AppCompatTextView) view61.findViewById(R.id.tv_personal_profile);
                                k.a((Object) appCompatTextView19, "profileToggleViewHolder.…mView.tv_personal_profile");
                                appCompatTextView19.setTypeface(Typeface.create("sans-serif-regular", 0));
                                android.view.View view62 = dVar.itemView;
                                k.a((Object) view62, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView20 = (AppCompatTextView) view62.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView20, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView20.setTypeface(Typeface.create("sans-serif-regular", 0));
                                android.view.View view63 = dVar.itemView;
                                k.a((Object) view63, "profileToggleViewHolder.itemView");
                                Group group12 = (Group) view63.findViewById(R.id.group_ppbl_info);
                                k.a((Object) group12, "profileToggleViewHolder.itemView.group_ppbl_info");
                                group12.setVisibility(8);
                                android.view.View view64 = dVar.itemView;
                                k.a((Object) view64, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView21 = (AppCompatTextView) view64.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView21, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView21.setBackground(androidx.core.content.b.a(this.f52797a, R.drawable.rectangle_selected_profile));
                                android.view.View view65 = dVar.itemView;
                                k.a((Object) view65, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView22 = (AppCompatTextView) view65.findViewById(R.id.tv_personal_profile);
                                k.a((Object) appCompatTextView22, "profileToggleViewHolder.…mView.tv_personal_profile");
                                appCompatTextView22.setBackground((Drawable) null);
                                android.view.View view66 = dVar.itemView;
                                k.a((Object) view66, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView23 = (AppCompatTextView) view66.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView23, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView23.setBackground((Drawable) null);
                            } else {
                                android.view.View view67 = dVar.itemView;
                                k.a((Object) view67, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView24 = (AppCompatTextView) view67.findViewById(R.id.tv_personal_profile);
                                k.a((Object) appCompatTextView24, "profileToggleViewHolder.…mView.tv_personal_profile");
                                appCompatTextView24.setTypeface(Typeface.create("sans-serif-medium", 0));
                                android.view.View view68 = dVar.itemView;
                                k.a((Object) view68, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView25 = (AppCompatTextView) view68.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView25, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView25.setTypeface(Typeface.create("sans-serif-regular", 0));
                                android.view.View view69 = dVar.itemView;
                                k.a((Object) view69, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView26 = (AppCompatTextView) view69.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView26, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView26.setTypeface(Typeface.create("sans-serif-regular", 0));
                                android.view.View view70 = dVar.itemView;
                                k.a((Object) view70, "profileToggleViewHolder.itemView");
                                Group group13 = (Group) view70.findViewById(R.id.group_ppbl_info);
                                k.a((Object) group13, "profileToggleViewHolder.itemView.group_ppbl_info");
                                group13.setVisibility(8);
                                android.view.View view71 = dVar.itemView;
                                k.a((Object) view71, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView27 = (AppCompatTextView) view71.findViewById(R.id.tv_personal_profile);
                                k.a((Object) appCompatTextView27, "profileToggleViewHolder.…mView.tv_personal_profile");
                                appCompatTextView27.setBackground(androidx.core.content.b.a(this.f52797a, R.drawable.rectangle_selected_profile));
                                android.view.View view72 = dVar.itemView;
                                k.a((Object) view72, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView28 = (AppCompatTextView) view72.findViewById(R.id.tv_service_profile);
                                k.a((Object) appCompatTextView28, "profileToggleViewHolder.…emView.tv_service_profile");
                                appCompatTextView28.setBackground((Drawable) null);
                                android.view.View view73 = dVar.itemView;
                                k.a((Object) view73, "profileToggleViewHolder.itemView");
                                AppCompatTextView appCompatTextView29 = (AppCompatTextView) view73.findViewById(R.id.tv_merchant_profile);
                                k.a((Object) appCompatTextView29, "profileToggleViewHolder.…mView.tv_merchant_profile");
                                appCompatTextView29.setBackground((Drawable) null);
                            }
                        } else {
                            android.view.View view74 = dVar.itemView;
                            k.a((Object) view74, "profileToggleViewHolder.itemView");
                            Group group14 = (Group) view74.findViewById(R.id.group_ppbl_info);
                            k.a((Object) group14, "profileToggleViewHolder.itemView.group_ppbl_info");
                            group14.setVisibility(8);
                            android.view.View view75 = dVar.itemView;
                            k.a((Object) view75, "profileToggleViewHolder.itemView");
                            android.view.View findViewById4 = view75.findViewById(R.id.view_profile);
                            k.a((Object) findViewById4, "profileToggleViewHolder.itemView.view_profile");
                            findViewById4.setVisibility(8);
                            android.view.View view76 = dVar.itemView;
                            k.a((Object) view76, "profileToggleViewHolder.itemView");
                            AppCompatTextView appCompatTextView30 = (AppCompatTextView) view76.findViewById(R.id.tv_service_profile);
                            k.a((Object) appCompatTextView30, "profileToggleViewHolder.…emView.tv_service_profile");
                            appCompatTextView30.setVisibility(8);
                            android.view.View view77 = dVar.itemView;
                            k.a((Object) view77, "profileToggleViewHolder.itemView");
                            AppCompatTextView appCompatTextView31 = (AppCompatTextView) view77.findViewById(R.id.tv_personal_profile);
                            k.a((Object) appCompatTextView31, "profileToggleViewHolder.…mView.tv_personal_profile");
                            appCompatTextView31.setVisibility(8);
                            android.view.View view78 = dVar.itemView;
                            k.a((Object) view78, "profileToggleViewHolder.itemView");
                            AppCompatTextView appCompatTextView32 = (AppCompatTextView) view78.findViewById(R.id.tv_merchant_profile);
                            k.a((Object) appCompatTextView32, "profileToggleViewHolder.…mView.tv_merchant_profile");
                            appCompatTextView32.setVisibility(8);
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
            }
        } else {
            CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar2;
            List<IJRDataModel> list8 = this.f52798b;
            if (list8 == null) {
                list8 = w.INSTANCE;
            }
            int size3 = i3 - (list8.size() - 1);
            List<? extends View> list9 = this.f52803g;
            if (list9 != null && size3 < list9.size()) {
                View view79 = (View) list9.get(size3);
                HashMap hashMap = new HashMap();
                hashMap.put(CLPConstants.WIDGET_BIND_POSITION, Integer.valueOf(size3));
                view79.setGaData(hashMap);
                cLPBaseViewHolder.bind(view79, (CLPBaseViewHolder.IParentListProvider) null);
            }
        }
    }

    private final String a() {
        String kYCName = Utils.getKYCName(this.f52797a);
        if (TextUtils.isEmpty(kYCName)) {
            Context context = this.f52797a;
            kYCName = com.paytm.utility.b.aa(context != null ? context.getApplicationContext() : null);
        }
        CharSequence charSequence = kYCName;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<String> b2 = p.a(charSequence, new String[]{" "});
        if (!b2.isEmpty()) {
            int i2 = 0;
            for (String str : b2) {
                if (str.length() > 0) {
                    if (i2 >= 2) {
                        break;
                    }
                    sb.append(str.charAt(0));
                    i2++;
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (r5 == null) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getItemViewType(int r5) {
        /*
            r4 = this;
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r0 = r4.f52798b
            r1 = 1
            if (r0 == 0) goto L_0x0032
            if (r5 != 0) goto L_0x000e
            net.one97.paytm.landingpage.leftNavigation.a$f r5 = net.one97.paytm.landingpage.leftNavigation.a.f.VIEW_TYPE_HEADER
            int r5 = r5.ordinal()
            return r5
        L_0x000e:
            if (r5 != r1) goto L_0x0017
            net.one97.paytm.landingpage.leftNavigation.a$f r5 = net.one97.paytm.landingpage.leftNavigation.a.f.VIEW_TYPE_PROFILE_TOGGLE
            int r5 = r5.ordinal()
            return r5
        L_0x0017:
            int r0 = r0.size()
            java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r2 = r4.f52803g
            if (r2 != 0) goto L_0x0023
            kotlin.a.w r2 = kotlin.a.w.INSTANCE
            java.util.List r2 = (java.util.List) r2
        L_0x0023:
            int r2 = r2.size()
            int r0 = r0 + r2
            int r0 = r0 - r1
            if (r5 != r0) goto L_0x0032
            net.one97.paytm.landingpage.leftNavigation.a$f r5 = net.one97.paytm.landingpage.leftNavigation.a.f.VIEW_TYPE_FOOTER
            int r5 = r5.ordinal()
            return r5
        L_0x0032:
            java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r0 = r4.f52803g
            if (r0 == 0) goto L_0x0060
            com.paytmmall.clpartifact.utils.WidgetLayoutType$Companion r0 = com.paytmmall.clpartifact.utils.WidgetLayoutType.Companion
            java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r2 = r4.f52803g
            if (r2 == 0) goto L_0x0052
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r3 = r4.f52798b
            if (r3 != 0) goto L_0x0044
            kotlin.a.w r3 = kotlin.a.w.INSTANCE
            java.util.List r3 = (java.util.List) r3
        L_0x0044:
            int r3 = r3.size()
            int r3 = r3 - r1
            int r5 = r5 - r3
            java.lang.Object r5 = r2.get(r5)
            com.paytmmall.clpartifact.modal.clpCommon.View r5 = (com.paytmmall.clpartifact.modal.clpCommon.View) r5
            if (r5 != 0) goto L_0x0057
        L_0x0052:
            com.paytmmall.clpartifact.modal.clpCommon.View r5 = new com.paytmmall.clpartifact.modal.clpCommon.View
            r5.<init>()
        L_0x0057:
            int r5 = r0.getLayoutTypeIndexfromName((com.paytmmall.clpartifact.modal.clpCommon.View) r5)
            r4.f52801e = r5
            int r5 = r4.f52801e
            return r5
        L_0x0060:
            int r5 = super.getItemViewType(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.leftNavigation.a.getItemViewType(int):int");
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f52807a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, android.view.View view) {
            super(view);
            k.c(view, "itemView");
            this.f52807a = aVar;
            view.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52808a;

                {
                    this.f52808a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52808a.f52807a, this.f52808a.getAdapterPosition())) {
                        c cVar = this.f52808a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52808a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52808a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52808a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((AppCompatImageView) view.findViewById(R.id.iv_back_left_navi)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52817a;

                {
                    this.f52817a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52817a.f52807a, this.f52817a.getAdapterPosition())) {
                        c cVar = this.f52817a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52817a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52817a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52817a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((RoboTextView) view.findViewById(R.id.ln_profile_login)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52818a;

                {
                    this.f52818a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52818a.f52807a, this.f52818a.getAdapterPosition())) {
                        c cVar = this.f52818a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52818a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52818a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52818a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((RoboTextView) view.findViewById(R.id.ln_profile_signup)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52819a;

                {
                    this.f52819a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52819a.f52807a, this.f52819a.getAdapterPosition())) {
                        c cVar = this.f52819a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52819a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52819a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52819a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((ImageView) view.findViewById(R.id.iv_left_navi)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52820a;

                {
                    this.f52820a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52820a.f52807a, this.f52820a.getAdapterPosition())) {
                        c cVar = this.f52820a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52820a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52820a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52820a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((TextView) view.findViewById(R.id.tv_edit_profile)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52809a;

                {
                    this.f52809a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52809a.f52807a, this.f52809a.getAdapterPosition())) {
                        c cVar = this.f52809a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52809a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52809a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52809a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((AppCompatImageView) view.findViewById(R.id.share_upi_iv)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52810a;

                {
                    this.f52810a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52810a.f52807a, this.f52810a.getAdapterPosition())) {
                        c cVar = this.f52810a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52810a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52810a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52810a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((AppCompatTextView) view.findViewById(R.id.upi_id_tv)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52811a;

                {
                    this.f52811a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52811a.f52807a, this.f52811a.getAdapterPosition())) {
                        c cVar = this.f52811a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52811a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52811a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52811a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((AppCompatImageView) view.findViewById(R.id.link_bank_iv)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52812a;

                {
                    this.f52812a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52812a.f52807a, this.f52812a.getAdapterPosition())) {
                        c cVar = this.f52812a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52812a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52812a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52812a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((TextView) view.findViewById(R.id.link_bank_tv)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52813a;

                {
                    this.f52813a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52813a.f52807a, this.f52813a.getAdapterPosition())) {
                        c cVar = this.f52813a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52813a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52813a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52813a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((AppCompatImageView) view.findViewById(R.id.link_bank_iv)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52814a;

                {
                    this.f52814a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52814a.f52807a, this.f52814a.getAdapterPosition())) {
                        c cVar = this.f52814a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52814a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52814a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52814a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((TextView) view.findViewById(R.id.link_bank_tv)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52815a;

                {
                    this.f52815a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52815a.f52807a, this.f52815a.getAdapterPosition())) {
                        c cVar = this.f52815a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52815a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52815a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52815a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((Switch) view.findViewById(R.id.switch_security_shield)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f52816a;

                {
                    this.f52816a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52816a.f52807a, this.f52816a.getAdapterPosition())) {
                        c cVar = this.f52816a.f52807a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52816a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52816a.f52807a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52816a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f52821a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, android.view.View view) {
            super(view);
            k.c(view, "itemView");
            this.f52821a = aVar;
            ((AppCompatTextView) view.findViewById(R.id.tv_personal_profile)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f52822a;

                {
                    this.f52822a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52822a.f52821a, this.f52822a.getAdapterPosition())) {
                        c cVar = this.f52822a.f52821a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52822a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52822a.f52821a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52822a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((AppCompatTextView) view.findViewById(R.id.tv_service_profile)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f52823a;

                {
                    this.f52823a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52823a.f52821a, this.f52823a.getAdapterPosition())) {
                        c cVar = this.f52823a.f52821a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52823a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52823a.f52821a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52823a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((AppCompatTextView) view.findViewById(R.id.tv_merchant_profile)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f52824a;

                {
                    this.f52824a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52824a.f52821a, this.f52824a.getAdapterPosition())) {
                        c cVar = this.f52824a.f52821a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52824a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52824a.f52821a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52824a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
            ((TextView) view.findViewById(R.id.tv_ppbl_check_balance)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f52825a;

                {
                    this.f52825a = r1;
                }

                public final void onClick(android.view.View view) {
                    if (a.a(this.f52825a.f52821a, this.f52825a.getAdapterPosition())) {
                        c cVar = this.f52825a.f52821a.f52799c;
                        k.a((Object) view, "it");
                        int adapterPosition = this.f52825a.getAdapterPosition();
                        List<IJRDataModel> list = this.f52825a.f52821a.f52798b;
                        IJRDataModel iJRDataModel = list != null ? list.get(this.f52825a.getAdapterPosition()) : null;
                        if (iJRDataModel != null) {
                            cVar.a(view, adapterPosition, (LeftNavigationModel) iJRDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.home.LeftNavigationModel");
                    }
                }
            });
        }
    }

    /* renamed from: net.one97.paytm.landingpage.leftNavigation.a$a  reason: collision with other inner class name */
    public final class C0943a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f52805a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0943a(a aVar, android.view.View view) {
            super(view);
            k.c(view, "itemView");
            this.f52805a = aVar;
            ((TextView) view.findViewById(R.id.tvdebugSetting)).setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C0943a f52806a;

                {
                    this.f52806a = r1;
                }

                public final void onClick(android.view.View view) {
                    net.one97.paytm.common.b.d.b().a(this.f52806a.f52805a.f52797a, "paytmmp://debug_setting");
                }
            });
            TextView textView = (TextView) view.findViewById(R.id.tvdebugSetting);
            k.a((Object) textView, "itemView.tvdebugSetting");
            textView.setVisibility(8);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_debug_settings);
            k.a((Object) imageView, "itemView.img_debug_settings");
            imageView.setVisibility(8);
        }
    }

    public final class e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f52826a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, android.view.View view) {
            super(view);
            k.c(view, "itemView");
            this.f52826a = aVar;
        }
    }

    public static final class g implements com.paytm.utility.b.b.b<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f52827a;

        public final void onError(Exception exc) {
        }

        g(ImageView imageView) {
            this.f52827a = imageView;
        }

        public final /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
            this.f52827a.setImageBitmap((Bitmap) obj);
        }
    }

    public static final class h implements com.paytm.utility.b.b.b<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f52828a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageView f52829b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f52830c;

        public final void onError(Exception exc) {
        }

        h(a aVar, ImageView imageView, String str) {
            this.f52828a = aVar;
            this.f52829b = imageView;
            this.f52830c = str;
        }

        public final /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
            this.f52829b.setImageBitmap((Bitmap) obj);
            this.f52828a.f52800d.a(this.f52830c);
        }
    }

    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public static final /* synthetic */ boolean a(a aVar, int i2) {
        List<IJRDataModel> list = aVar.f52798b;
        if (list == null) {
            list = w.INSTANCE;
        }
        return list.size() > i2 && i2 >= 0;
    }
}
