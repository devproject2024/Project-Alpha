package com.travel.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.R;
import com.travel.travelPreferences.CJRBusTpUserProfileContact;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import net.one97.paytm.common.widgets.CircularImageView;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private static String f21420a = "CJRSavedTravellersAdapter";

    /* renamed from: b  reason: collision with root package name */
    private List<CJRBusTpUserProfileContact> f21421b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f21422c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public C0423a f21423d;

    /* renamed from: com.travel.a.a$a  reason: collision with other inner class name */
    public interface C0423a {
        void a(CJRBusTpUserProfileContact cJRBusTpUserProfileContact);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        long j;
        final b bVar = (b) vVar;
        CJRBusTpUserProfileContact cJRBusTpUserProfileContact = this.f21421b.get(i2);
        String firstname = cJRBusTpUserProfileContact.getFirstname();
        String lastname = cJRBusTpUserProfileContact.getLastname();
        if (TextUtils.isEmpty(firstname)) {
            firstname = cJRBusTpUserProfileContact.getFullname();
        }
        if ("male".equalsIgnoreCase(cJRBusTpUserProfileContact.getGender().toLowerCase()) || "m".equalsIgnoreCase(cJRBusTpUserProfileContact.getGender().toLowerCase())) {
            i3 = R.drawable.pre_td_male_img;
        } else {
            i3 = R.drawable.pre_td_female_img;
        }
        bVar.f21429a.setText(cJRBusTpUserProfileContact.getTitle() + ". " + firstname);
        if (TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname)) {
            bVar.f21430b.setVisibility(8);
        } else {
            bVar.f21430b.setVisibility(0);
            bVar.f21430b.setText(lastname);
        }
        if (!TextUtils.isEmpty(cJRBusTpUserProfileContact.getDob())) {
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            Date a2 = a(cJRBusTpUserProfileContact.getDob());
            Calendar instance2 = Calendar.getInstance(TimeZone.getDefault());
            instance2.setTime(a2);
            int i4 = instance.get(1) - instance2.get(1);
            if (instance2.get(6) > instance.get(6)) {
                i4--;
            }
            j = (long) i4;
        } else {
            j = !TextUtils.isEmpty(cJRBusTpUserProfileContact.getAge()) ? Long.parseLong(cJRBusTpUserProfileContact.getAge()) : -1;
        }
        if (j != -1) {
            if (j < 2) {
                i3 = R.drawable.pre_td_travel_infants;
            }
            if (j < 12) {
                if ("male".equalsIgnoreCase(cJRBusTpUserProfileContact.getGender().toLowerCase()) || "m".equalsIgnoreCase(cJRBusTpUserProfileContact.getGender().toLowerCase())) {
                    i3 = R.drawable.pre_td_child_male;
                } else {
                    i3 = R.drawable.pre_td_child_female;
                }
            }
        }
        bVar.f21431c.setBackgroundResource(i3);
        bVar.f21432d.setTag(cJRBusTpUserProfileContact);
        bVar.f21432d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(a.this.f21422c);
                final CJRBusTpUserProfileContact cJRBusTpUserProfileContact = (CJRBusTpUserProfileContact) bVar.f21432d.getTag();
                Resources resources = a.this.f21422c.getResources();
                int i2 = R.string.traveller_are_you_sure_delete_revamp;
                builder.setMessage(resources.getString(i2, new Object[]{cJRBusTpUserProfileContact.getTitle() + ". " + cJRBusTpUserProfileContact.getFirstname() + " " + cJRBusTpUserProfileContact.getLastname()})).setCancelable(false);
                builder.setPositiveButton(resources.getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        a.this.f21423d.a(cJRBusTpUserProfileContact);
                    }
                });
                builder.setNegativeButton(resources.getString(R.string.no), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
        if (i2 == 0) {
            bVar.f21433e.setVisibility(8);
        } else {
            bVar.f21433e.setVisibility(0);
        }
    }

    public a(Context context, List<CJRBusTpUserProfileContact> list, C0423a aVar) {
        this.f21421b = list;
        this.f21422c = context;
        this.f21423d = aVar;
    }

    public final int getItemCount() {
        return this.f21421b.size();
    }

    public class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public TextView f21429a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21430b;

        /* renamed from: c  reason: collision with root package name */
        public CircularImageView f21431c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f21432d;

        /* renamed from: e  reason: collision with root package name */
        public View f21433e;

        public final void onClick(View view) {
        }

        public b(View view) {
            super(view);
            view.setOnClickListener(this);
            this.f21429a = (TextView) view.findViewById(R.id.fname);
            this.f21430b = (TextView) view.findViewById(R.id.lname);
            this.f21431c = (CircularImageView) view.findViewById(R.id.img);
            this.f21432d = (ImageView) view.findViewById(R.id.cross);
            this.f21433e = view.findViewById(R.id.sep);
        }
    }

    private static Date a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            if (!com.paytm.utility.b.v) {
                return null;
            }
            q.c(e2.getMessage());
            return null;
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_td_layout_saved_travellers, viewGroup, false));
    }
}
