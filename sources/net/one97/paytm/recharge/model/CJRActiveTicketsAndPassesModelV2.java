package net.one97.paytm.recharge.model;

import com.paytm.network.model.IJRPaytmDataModel;

public final class CJRActiveTicketsAndPassesModelV2 extends IJRPaytmDataModel {
    private CJRActiveTicketsAndPassesModel DELHI_METRO;
    private CJRActiveTicketsAndPassesModel HYDERABAD_METRO;
    private CJRActiveTicketsAndPassesModel MUMBAI_METRO;

    public final CJRActiveTicketsAndPassesModel getMUMBAI_METRO() {
        return this.MUMBAI_METRO;
    }

    public final void setMUMBAI_METRO(CJRActiveTicketsAndPassesModel cJRActiveTicketsAndPassesModel) {
        this.MUMBAI_METRO = cJRActiveTicketsAndPassesModel;
    }

    public final CJRActiveTicketsAndPassesModel getDELHI_METRO() {
        return this.DELHI_METRO;
    }

    public final void setDELHI_METRO(CJRActiveTicketsAndPassesModel cJRActiveTicketsAndPassesModel) {
        this.DELHI_METRO = cJRActiveTicketsAndPassesModel;
    }

    public final CJRActiveTicketsAndPassesModel getHYDERABAD_METRO() {
        return this.HYDERABAD_METRO;
    }

    public final void setHYDERABAD_METRO(CJRActiveTicketsAndPassesModel cJRActiveTicketsAndPassesModel) {
        this.HYDERABAD_METRO = cJRActiveTicketsAndPassesModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if ((r0 == null || r0.isEmpty()) != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        if ((r0 == null || r0.isEmpty()) == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r0 = r3.MUMBAI_METRO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        if (r0 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
        if (r0 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0044, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r0 = r0.getTickets();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004b, code lost:
        if (r0 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
        if (r0 == null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0055, code lost:
        if (r0.isEmpty() == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0058, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005a, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
        if (r0 == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005d, code lost:
        r0 = r3.MUMBAI_METRO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005f, code lost:
        if (r0 != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0061, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0064, code lost:
        r0 = r0.getPasses();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0068, code lost:
        if (r0 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006a, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006c, code lost:
        if (r0 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0072, code lost:
        if (r0.isEmpty() == false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0075, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0077, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0078, code lost:
        if (r0 != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007a, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isMultiActiveTicketsAvailable() {
        /*
            r3 = this;
            net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r0 = r3.DELHI_METRO
            r1 = 0
            if (r0 == 0) goto L_0x007b
            if (r0 != 0) goto L_0x000a
            kotlin.g.b.k.a()
        L_0x000a:
            java.util.List r0 = r0.getTickets()
            r2 = 1
            if (r0 == 0) goto L_0x0021
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r0 = 0
            goto L_0x001f
        L_0x001e:
            r0 = 1
        L_0x001f:
            if (r0 == 0) goto L_0x003e
        L_0x0021:
            net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r0 = r3.DELHI_METRO
            if (r0 != 0) goto L_0x0028
            kotlin.g.b.k.a()
        L_0x0028:
            java.util.List r0 = r0.getPasses()
            if (r0 == 0) goto L_0x007b
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x003b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r0 = 0
            goto L_0x003c
        L_0x003b:
            r0 = 1
        L_0x003c:
            if (r0 != 0) goto L_0x007b
        L_0x003e:
            net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r0 = r3.MUMBAI_METRO
            if (r0 == 0) goto L_0x007b
            if (r0 != 0) goto L_0x0047
            kotlin.g.b.k.a()
        L_0x0047:
            java.util.List r0 = r0.getTickets()
            if (r0 == 0) goto L_0x005d
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x005a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r0 = 0
            goto L_0x005b
        L_0x005a:
            r0 = 1
        L_0x005b:
            if (r0 == 0) goto L_0x007a
        L_0x005d:
            net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r0 = r3.MUMBAI_METRO
            if (r0 != 0) goto L_0x0064
            kotlin.g.b.k.a()
        L_0x0064:
            java.util.List r0 = r0.getPasses()
            if (r0 == 0) goto L_0x007b
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r0 = 0
            goto L_0x0078
        L_0x0077:
            r0 = 1
        L_0x0078:
            if (r0 != 0) goto L_0x007b
        L_0x007a:
            return r2
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModelV2.isMultiActiveTicketsAvailable():boolean");
    }
}
