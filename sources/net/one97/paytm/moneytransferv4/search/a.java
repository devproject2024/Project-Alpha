package net.one97.paytm.moneytransferv4.search;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.r;
import net.one97.paytm.moneytransfer.c.s;
import net.one97.paytm.moneytransfer.model.ContactItemModel;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    int f55683a = -1;

    /* renamed from: b  reason: collision with root package name */
    boolean f55684b;

    /* renamed from: c  reason: collision with root package name */
    boolean f55685c;

    /* renamed from: d  reason: collision with root package name */
    String f55686d = "";

    /* renamed from: e  reason: collision with root package name */
    List<? extends IJRDataModel> f55687e = this.f55688f;

    /* renamed from: f  reason: collision with root package name */
    final List<IJRDataModel> f55688f;

    /* renamed from: g  reason: collision with root package name */
    final d f55689g;

    /* renamed from: h  reason: collision with root package name */
    private final int f55690h;

    /* renamed from: i  reason: collision with root package name */
    private final int f55691i = 1;
    private final int j = 2;

    public interface d {
        void a(IJRDataModel iJRDataModel);
    }

    public a(List<IJRDataModel> list, d dVar) {
        k.c(list, "list");
        k.c(dVar, "listener");
        this.f55688f = list;
        this.f55689g = dVar;
    }

    public final int getItemViewType(int i2) {
        if (this.f55687e.get(i2) instanceof SearchTitleModel) {
            return this.f55690h;
        }
        if (this.f55687e.get(i2) instanceof BeneficiaryEntity) {
            return this.f55691i;
        }
        return this.j;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f55690h) {
            s a2 = s.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            k.a((Object) a2, "MtSearchTitleItemViewBin….context), parent, false)");
            return new c(this, a2);
        } else if (i2 == this.f55691i) {
            r a3 = r.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            k.a((Object) a3, "MtSearchContactItemViewB….context), parent, false)");
            return new C1036a(this, a3);
        } else {
            r a4 = r.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            k.a((Object) a4, "MtSearchContactItemViewB….context), parent, false)");
            return new b(this, a4);
        }
    }

    public final int getItemCount() {
        return this.f55687e.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        RecyclerView.v vVar2 = vVar;
        k.c(vVar2, "holder");
        IJRDataModel iJRDataModel = (IJRDataModel) this.f55687e.get(i2);
        if (vVar2 instanceof c) {
            c cVar = (c) vVar2;
            if (iJRDataModel != null) {
                SearchTitleModel searchTitleModel = (SearchTitleModel) iJRDataModel;
                k.c(searchTitleModel, "searchTitleModel");
                TextView textView = cVar.f55706a.f53835a;
                k.a((Object) textView, "binding.titleText");
                textView.setText(searchTitleModel.getTitleText());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.search.SearchTitleModel");
        } else if (vVar2 instanceof b) {
            b bVar = (b) vVar2;
            if (iJRDataModel != null) {
                ContactItemModel contactItemModel = (ContactItemModel) iJRDataModel;
                k.c(contactItemModel, "contactItemModel");
                String name = contactItemModel.getName();
                String phnNo = contactItemModel.getPhnNo();
                String photoUri = contactItemModel.getPhotoUri();
                r rVar = bVar.f55699a;
                CharSequence charSequence = name;
                if (!TextUtils.isEmpty(charSequence)) {
                    TextView textView2 = rVar.f53833g;
                    k.a((Object) textView2, "tvInitials");
                    textView2.setText(UpiUtils.getNameInitials(name));
                    TextView textView3 = rVar.f53833g;
                    k.a((Object) textView3, "tvInitials");
                    Drawable background = textView3.getBackground();
                    if (background != null) {
                        ((GradientDrawable) background).setColor(m.c()[bVar.getAdapterPosition() % 10]);
                    } else {
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                }
                if (!TextUtils.isEmpty(photoUri)) {
                    ImageView imageView = rVar.f53828b;
                    k.a((Object) imageView, "ivProfilePic");
                    imageView.setVisibility(0);
                    TextView textView4 = rVar.f53833g;
                    k.a((Object) textView4, "tvInitials");
                    textView4.setVisibility(8);
                    w.a().a(photoUri).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(rVar.f53828b);
                } else {
                    ImageView imageView2 = rVar.f53828b;
                    k.a((Object) imageView2, "ivProfilePic");
                    imageView2.setVisibility(8);
                    TextView textView5 = rVar.f53833g;
                    k.a((Object) textView5, "tvInitials");
                    textView5.setVisibility(0);
                }
                if (contactItemModel.isSelected()) {
                    CircularProgressBar circularProgressBar = rVar.f53829c;
                    k.a((Object) circularProgressBar, "progressBar");
                    circularProgressBar.setVisibility(0);
                    bVar.f55700b.f55683a = bVar.getAdapterPosition();
                } else {
                    CircularProgressBar circularProgressBar2 = rVar.f53829c;
                    k.a((Object) circularProgressBar2, "progressBar");
                    circularProgressBar2.setVisibility(4);
                }
                TextView textView6 = rVar.f53831e;
                k.a((Object) textView6, "tvContactName");
                textView6.setText(charSequence);
                TextView textView7 = rVar.f53832f;
                k.a((Object) textView7, "tvContactNumber");
                textView7.setText(phnNo);
                a aVar = bVar.f55700b;
                TextView textView8 = rVar.f53831e;
                TextView textView9 = rVar.f53832f;
                k.a((Object) textView9, "tvContactNumber");
                aVar.a(textView8, textView9);
                rVar.a().setOnClickListener(new b.C1038a(bVar, name, photoUri, contactItemModel, phnNo));
                CircularProgressBar circularProgressBar3 = rVar.f53829c;
                k.a((Object) circularProgressBar3, "progressBar");
                f.a((View) circularProgressBar3, contactItemModel.isSelected());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.model.ContactItemModel");
        } else if (vVar2 instanceof C1036a) {
            C1036a aVar2 = (C1036a) vVar2;
            if (iJRDataModel != null) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) iJRDataModel;
                k.c(beneficiaryEntity, "beneficiaryEntity");
                String a2 = f.a(m.b(beneficiaryEntity));
                String a3 = m.a(beneficiaryEntity);
                k.a((Object) a3, "MoneyTransferUtils.getAc…tOrVpa(beneficiaryEntity)");
                boolean z = true;
                boolean z2 = beneficiaryEntity.instrumentPreferences.upi != null;
                r rVar2 = aVar2.f55692a;
                TextView textView10 = rVar2.f53833g;
                k.a((Object) textView10, "tvInitials");
                f.a((View) textView10, z2);
                ImageView imageView3 = rVar2.f53828b;
                k.a((Object) imageView3, "ivProfilePic");
                f.a((View) imageView3, !z2);
                TextView textView11 = rVar2.f53831e;
                k.a((Object) textView11, "tvContactName");
                textView11.setText(a2);
                if (z2) {
                    TextView textView12 = rVar2.f53832f;
                    k.a((Object) textView12, "tvContactNumber");
                    textView12.setText("UPI ID ".concat(String.valueOf(a3)));
                    TextView textView13 = rVar2.f53833g;
                    k.a((Object) textView13, "tvInitials");
                    textView13.setText(UpiUtils.getNameInitials(a2));
                    TextView textView14 = rVar2.f53833g;
                    k.a((Object) textView14, "tvInitials");
                    Drawable background2 = textView14.getBackground();
                    if (background2 != null) {
                        ((GradientDrawable) background2).setColor(m.c()[aVar2.getAdapterPosition() % 10]);
                        a aVar3 = aVar2.f55693b;
                        TextView textView15 = rVar2.f53831e;
                        TextView textView16 = rVar2.f53832f;
                        k.a((Object) textView16, "tvContactNumber");
                        aVar3.a(textView15, textView16);
                    } else {
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                } else {
                    TextView textView17 = rVar2.f53832f;
                    k.a((Object) textView17, "tvContactNumber");
                    StringBuilder sb = new StringBuilder("A/c No. XX ");
                    int length = a3.length() - 4;
                    if (a3 != null) {
                        String substring = a3.substring(length);
                        k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                        sb.append(substring);
                        textView17.setText(sb.toString());
                        a aVar4 = aVar2.f55693b;
                        TextView textView18 = rVar2.f53832f;
                        k.a((Object) textView18, "tvContactNumber");
                        aVar4.a((TextView) null, textView18);
                        CharSequence c2 = m.c(beneficiaryEntity);
                        if (!(c2 == null || c2.length() == 0)) {
                            z = false;
                        }
                        if (z) {
                            ImageView imageView4 = rVar2.f53828b;
                            String d2 = m.d(beneficiaryEntity);
                            ConstraintLayout a4 = rVar2.a();
                            k.a((Object) a4, "root");
                            m.a(imageView4, d2, a4.getContext());
                        } else {
                            w.a().a(m.c(beneficiaryEntity)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(rVar2.f53828b);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                rVar2.a().setOnClickListener(new C1036a.C1037a(aVar2, z2, a2, a3, beneficiaryEntity));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity");
        }
    }

    public final void a(ArrayList<IJRDataModel> arrayList, int i2) {
        k.c(arrayList, "contactItemModels");
        int size = this.f55688f.size();
        this.f55688f.addAll(i2, arrayList);
        if (i2 != 0) {
            notifyItemRangeChanged(size, this.f55688f.size());
        } else if (size == 0) {
            notifyItemRangeChanged(0, arrayList.size());
        } else {
            notifyItemRangeChanged(0, size);
        }
    }

    public final void a(boolean z) {
        int i2 = this.f55683a;
        if (i2 != -1) {
            this.f55684b = z;
            Object obj = this.f55687e.get(i2);
            if (obj != null) {
                ((ContactItemModel) obj).setSelected(z);
                notifyItemChanged(this.f55683a);
                if (!z) {
                    this.f55683a = -1;
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.model.ContactItemModel");
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final s f55706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f55707b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, s sVar) {
            super(sVar.a());
            k.c(sVar, "binding");
            this.f55707b = aVar;
            this.f55706a = sVar;
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final r f55699a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f55700b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, r rVar) {
            super(rVar.a());
            k.c(rVar, "binding");
            this.f55700b = aVar;
            this.f55699a = rVar;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.search.a$b$a  reason: collision with other inner class name */
        static final class C1038a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f55701a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f55702b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f55703c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ContactItemModel f55704d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f55705e;

            C1038a(b bVar, String str, String str2, ContactItemModel contactItemModel, String str3) {
                this.f55701a = bVar;
                this.f55702b = str;
                this.f55703c = str2;
                this.f55704d = contactItemModel;
                this.f55705e = str3;
            }

            public final void onClick(View view) {
                if (!this.f55701a.f55700b.f55684b) {
                    this.f55701a.f55700b.f55683a = this.f55701a.getAdapterPosition();
                    this.f55701a.f55700b.f55689g.a(this.f55704d);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.search.a$a  reason: collision with other inner class name */
    public final class C1036a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final r f55692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f55693b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1036a(a aVar, r rVar) {
            super(rVar.a());
            k.c(rVar, "binding");
            this.f55693b = aVar;
            this.f55692a = rVar;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.search.a$a$a  reason: collision with other inner class name */
        static final class C1037a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1036a f55694a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f55695b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f55696c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f55697d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ BeneficiaryEntity f55698e;

            C1037a(C1036a aVar, boolean z, String str, String str2, BeneficiaryEntity beneficiaryEntity) {
                this.f55694a = aVar;
                this.f55695b = z;
                this.f55696c = str;
                this.f55697d = str2;
                this.f55698e = beneficiaryEntity;
            }

            public final void onClick(View view) {
                this.f55694a.f55693b.f55689g.a(this.f55698e);
            }
        }
    }

    private void a(TextView textView, TextView textView2) {
        int a2 = p.a((CharSequence) String.valueOf(textView != null ? textView.getText() : null), this.f55686d, 0, true, 2);
        int a3 = p.a((CharSequence) textView2.getText().toString(), this.f55686d, 0, true, 2);
        if (!(a2 == -1 || textView == null)) {
            textView.setText(f.a(f.a(f.a((CharSequence) textView.getText().toString()), f.c("#00aced"), a2, this.f55686d.length() + a2), a2, this.f55686d.length() + a2));
        }
        if (a3 != -1) {
            textView2.setText(f.a(f.a(f.a((CharSequence) textView2.getText().toString()), f.c("#00aced"), a3, this.f55686d.length() + a3), a3, this.f55686d.length() + a3));
        }
    }
}
