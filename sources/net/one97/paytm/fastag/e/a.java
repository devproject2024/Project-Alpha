package net.one97.paytm.fastag.e;

import android.net.Uri;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.fastag.a.a;
import net.one97.paytm.fastag.b.b;
import net.one97.paytm.fastag.b.c;
import net.one97.paytm.fastag.model.CJRAddresses;
import net.one97.paytm.fastag.model.CJRDetailProduct;
import net.one97.paytm.fastag.model.CJRUploadDocument;
import net.one97.paytm.fastag.widget.ImageUploader;

public final class a extends a.C0185a {

    /* renamed from: b  reason: collision with root package name */
    public final c f13758b;

    public a(a.b bVar, c cVar) {
        super(bVar);
        this.f13758b = cVar;
    }

    public final void a(final ImageUploader imageUploader, Uri uri) {
        this.f13758b.a(uri, (b) new b() {
            public final void a(Throwable th) {
                imageUploader.setState(ImageUploader.b.IMAGE_SELECTED_AND_UPLOADING_FAILED);
                if (th instanceof net.one97.paytm.fastag.c) {
                    ((a.b) a.this.f13555a).b(th);
                } else {
                    ((a.b) a.this.f13555a).c(th);
                }
            }

            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRUploadDocument) {
                    CJRUploadDocument cJRUploadDocument = (CJRUploadDocument) iJRPaytmDataModel;
                    if (cJRUploadDocument.keys != null && cJRUploadDocument.keys.size() > 0) {
                        imageUploader.setUploadedKey(cJRUploadDocument.keys.get(0));
                        imageUploader.setState(ImageUploader.b.IMAGE_UPLOADED);
                    }
                }
            }
        });
    }

    public final void a() {
        ((a.b) this.f13555a).b();
        this.f13758b.a(new b() {
            public final void a(Throwable th) {
                ((a.b) a.this.f13555a).a();
                if (th instanceof net.one97.paytm.fastag.c) {
                    ((a.b) a.this.f13555a).a((net.one97.paytm.fastag.c) th);
                } else {
                    ((a.b) a.this.f13555a).a(th);
                }
            }

            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                ((a.b) a.this.f13555a).a();
                if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAddresses)) {
                    ((a.b) a.this.f13555a).a((CJRAddresses) iJRPaytmDataModel);
                }
            }
        });
    }

    public final void a(String str) {
        ((a.b) this.f13555a).d();
        this.f13758b.a((b) new b() {
            public final void a(Throwable th) {
                ((a.b) a.this.f13555a).c();
                if (th instanceof net.one97.paytm.fastag.c) {
                    ((a.b) a.this.f13555a).a((net.one97.paytm.fastag.c) th);
                } else {
                    ((a.b) a.this.f13555a).a(th);
                }
            }

            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                ((a.b) a.this.f13555a).c();
                if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRDetailProduct)) {
                    ((a.b) a.this.f13555a).a((CJRDetailProduct) iJRPaytmDataModel);
                }
            }
        }, str);
    }
}
