package net.one97.paytm.o2o.movies.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.core.content.b;
import net.one97.paytm.i.g;
import net.one97.paytm.o2o.movies.R;

public class j extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f75369a;

    /* renamed from: b  reason: collision with root package name */
    private String f75370b;

    /* renamed from: c  reason: collision with root package name */
    private String f75371c;

    /* renamed from: d  reason: collision with root package name */
    private int f75372d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f75373e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f75374f;

    public interface a {
        void a();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f75369a = getArguments().getString("dialog_text");
            this.f75370b = getArguments().getString("primary_text");
            this.f75371c = getArguments().getString("secondary_text");
            this.f75372d = getArguments().getInt("drawable_resource", 0);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        c.a aVar = new c.a(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.fragment_movies_yes_no_dialog_box, (ViewGroup) null);
        c a2 = aVar.a(inflate).a();
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dialog_image);
        if (this.f75372d == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(b.a(getContext(), this.f75372d));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.yes_button_dialog_box);
        textView.setText(this.f75370b);
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.this.f75373e.a();
                if (j.this.f75374f) {
                    j.this.getDialog().cancel();
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.no_button_dialog_box);
        textView2.setText(this.f75371c);
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a unused = j.this.f75373e;
                if (j.this.f75374f) {
                    j.this.getDialog().cancel();
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.dialog_text)).setText(this.f75369a);
        return a2;
    }

    public void onDetach() {
        super.onDetach();
        this.f75373e = null;
    }
}
