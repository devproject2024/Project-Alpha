package net.one97.paytm.paymentsBank.chequebook.signatureupdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;

public final class a extends RecyclerView.a<C0289a> {

    /* renamed from: a  reason: collision with root package name */
    b f17851a;

    /* renamed from: b  reason: collision with root package name */
    private Context f17852b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<DocumentCreateResponse.Payload> f17853c;

    public interface b {
        void a(String str, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        C0289a aVar = (C0289a) vVar;
        final DocumentCreateResponse.Payload payload = this.f17853c.get(i2);
        int i3 = i2 + 1;
        if (aVar != null) {
            aVar.f17857a.setText("Document-".concat(String.valueOf(i3)));
            aVar.f17858b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f17851a.a(payload.getDocumentId(), i2);
                }
            });
        }
    }

    public a(Context context, ArrayList<DocumentCreateResponse.Payload> arrayList, b bVar) {
        this.f17852b = context;
        this.f17853c = arrayList;
        this.f17851a = bVar;
    }

    public final void a(DocumentCreateResponse.Payload payload) {
        this.f17853c.add(payload);
        notifyDataSetChanged();
    }

    public final void a(ArrayList<DocumentCreateResponse.Payload> arrayList) {
        this.f17853c.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void a(int i2) {
        this.f17853c.remove(i2);
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        ArrayList<DocumentCreateResponse.Payload> arrayList = this.f17853c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.signatureupdate.a$a  reason: collision with other inner class name */
    public class C0289a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f17857a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f17858b;

        public C0289a(View view) {
            super(view);
            this.f17857a = (TextView) view.findViewById(R.id.txt_document_name);
            this.f17858b = (ImageView) view.findViewById(R.id.iv_document_delete);
        }
    }

    public final void a() {
        this.f17853c.clear();
        notifyDataSetChanged();
    }

    public final void b(ArrayList<DocumentCreateResponse.Payload> arrayList) {
        this.f17853c.clear();
        this.f17853c.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0289a(LayoutInflater.from(this.f17852b).inflate(R.layout.item_uploaded_document, (ViewGroup) null));
    }
}
