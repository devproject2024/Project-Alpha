package com.travel.flight.flightSRPV2.viewModel;

import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "SRPSharedViewModel.kt", c = {}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel$handleSRPResult$1")
final class SRPSharedViewModel$handleSRPResult$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ boolean $isSecondaryAPIResponse;
    final /* synthetic */ CJRFlightSearchResult $srpResult;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SRPSharedViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SRPSharedViewModel$handleSRPResult$1(SRPSharedViewModel sRPSharedViewModel, CJRFlightSearchResult cJRFlightSearchResult, boolean z, d dVar) {
        super(2, dVar);
        this.this$0 = sRPSharedViewModel;
        this.$srpResult = cJRFlightSearchResult;
        this.$isSecondaryAPIResponse = z;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        SRPSharedViewModel$handleSRPResult$1 sRPSharedViewModel$handleSRPResult$1 = new SRPSharedViewModel$handleSRPResult$1(this.this$0, this.$srpResult, this.$isSecondaryAPIResponse, dVar);
        sRPSharedViewModel$handleSRPResult$1.p$ = (CoroutineScope) obj;
        return sRPSharedViewModel$handleSRPResult$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SRPSharedViewModel$handleSRPResult$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02c1, code lost:
        if (r14 != null) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02c3, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02c6, code lost:
        r14 = java.lang.String.valueOf(r14.intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02d4, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) "DRT") == false) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02d6, code lost:
        r14 = new java.lang.StringBuilder("Onward{");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02dd, code lost:
        if (r1 == null) goto L_0x02f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02df, code lost:
        r15 = r1.getmOnwardFlights();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02e3, code lost:
        if (r15 == null) goto L_0x02f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02e5, code lost:
        r15 = r15.getmFlightDetails();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02e9, code lost:
        if (r15 == null) goto L_0x02f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02eb, code lost:
        r15 = java.lang.Integer.valueOf(r15.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02f4, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02f5, code lost:
        if (r15 != null) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02f7, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02fa, code lost:
        r14.append(r15.intValue());
        r14.append("}, Return{");
        r15 = r1.getmReturnFlights();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x030b, code lost:
        if (r15 == null) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030d, code lost:
        r15 = r15.getmFlightDetails();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0311, code lost:
        if (r15 == null) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0313, code lost:
        r15 = java.lang.Integer.valueOf(r15.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x031c, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x031d, code lost:
        if (r15 != null) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x031f, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0322, code lost:
        r14.append(r15.intValue());
        r14.append('}');
        r14 = r14.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0333, code lost:
        if (r1 == null) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0335, code lost:
        r14 = r1.getmMapping();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0339, code lost:
        if (r14 == null) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x033b, code lost:
        r14 = java.lang.Integer.valueOf(r14.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0344, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0345, code lost:
        if (r14 != null) goto L_0x034a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0347, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x034a, code lost:
        r14 = java.lang.String.valueOf(r14.intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0352, code lost:
        r7.put("event_label", r14);
        r7 = com.travel.flight.utils.j.f25593a;
        com.travel.flight.utils.j.a.a("number_listings_SRP", (java.util.HashMap<java.lang.String, java.lang.Object>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0364, code lost:
        if (r0.this$0.isSortFilterEnable() == false) goto L_0x05bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0366, code lost:
        r2 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0372, code lost:
        if (r2 == null) goto L_0x05bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0374, code lost:
        kotlin.g.b.k.a((java.lang.Object) r2, "it");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x037d, code lost:
        if (r2.getNonStopSelected() == false) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x037f, code lost:
        r7 = new com.travel.flight.flightSRPV2.a.af(!r0.this$0.isRoundTrip(), 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x038f, code lost:
        switch(r4.hashCode()) {
            case 67884: goto L_0x0412;
            case 67974: goto L_0x03e1;
            case 72689: goto L_0x03da;
            case 72779: goto L_0x0394;
            default: goto L_0x0392;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0398, code lost:
        if (r4.equals("IRT") == false) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x039a, code lost:
        r14 = r0.this$0.getOnwardFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03a6, code lost:
        if (r14 == null) goto L_0x03af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03a8, code lost:
        java.lang.Boolean.valueOf(r14.add(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03af, code lost:
        r14 = r0.this$0.getReturnFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03bb, code lost:
        if (r14 == null) goto L_0x03c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03bd, code lost:
        java.lang.Boolean.valueOf(r14.add(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03c4, code lost:
        r14 = r0.this$0.getIrtFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03d0, code lost:
        if (r14 == null) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03d2, code lost:
        java.lang.Boolean.valueOf(r14.add(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03de, code lost:
        if (r4.equals("IOW") == false) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03e5, code lost:
        if (r4.equals("DRT") == false) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03e7, code lost:
        r14 = r0.this$0.getOnwardFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03f3, code lost:
        if (r14 == null) goto L_0x03fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03f5, code lost:
        java.lang.Boolean.valueOf(r14.add(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03fc, code lost:
        r14 = r0.this$0.getReturnFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0408, code lost:
        if (r14 == null) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x040a, code lost:
        java.lang.Boolean.valueOf(r14.add(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0416, code lost:
        if (r4.equals("DOW") == false) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0418, code lost:
        r14 = r0.this$0.getOnwardFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0424, code lost:
        if (r14 == null) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0426, code lost:
        java.lang.Boolean.valueOf(r14.add(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x042d, code lost:
        r7 = r2.getmDeeplinkFilterAirlineCodes();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0433, code lost:
        if (r7 == null) goto L_0x043e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0439, code lost:
        if (r7.length() != 0) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x043c, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x043e, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x043f, code lost:
        if (r7 != false) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0449, code lost:
        if (r1.getmOnwardFlights().getmMeta() == null) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x044b, code lost:
        r7 = r1.getmOnwardFlights().getmMeta();
        kotlin.g.b.k.a((java.lang.Object) r7, "flightsInfo.getmOnwardFlights().getmMeta()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x045c, code lost:
        if (r7.getAirlineNames() == null) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x045e, code lost:
        r2 = r2.getmDeeplinkFilterAirlineCodes();
        kotlin.g.b.k.a((java.lang.Object) r2, "it.getmDeeplinkFilterAirlineCodes()");
        r2 = kotlin.m.p.a((java.lang.CharSequence) r2, new java.lang.String[]{com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA}).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x047b, code lost:
        if (r2.hasNext() == false) goto L_0x0583;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x047d, code lost:
        r7 = (java.lang.String) r2.next();
        r15 = r1.getmOnwardFlights().getmMeta();
        kotlin.g.b.k.a((java.lang.Object) r15, "flightsInfo.getmOnwardFlights().getmMeta()");
        r15 = r15.getAirlineNames();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0494, code lost:
        if (r7 == null) goto L_0x057d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0496, code lost:
        r16 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04a6, code lost:
        if (r15.containsKey(kotlin.m.p.b(r16).toString()) == false) goto L_0x0579;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x04a8, code lost:
        r5 = com.travel.flight.utils.j.f25593a;
        r5 = r1.getmOnwardFlights().getmMeta();
        kotlin.g.b.k.a((java.lang.Object) r5, "flightsInfo.getmOnwardFlights().getmMeta()");
        r5 = r5.getAirlineNames();
        kotlin.g.b.k.a((java.lang.Object) r5, "flightsInfo.getmOnwardFl…).getmMeta().airlineNames");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x04be, code lost:
        if (r7 == null) goto L_0x0573;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x04c0, code lost:
        r15 = kotlin.m.p.b(r16).toString();
        kotlin.g.b.k.c(r5, "airlineNames");
        kotlin.g.b.k.c(r15, "airline");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04d6, code lost:
        if (r5.containsKey(r15) == false) goto L_0x04e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x04d8, code lost:
        r5 = r5.get(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x04dc, code lost:
        if (r5 != null) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04df, code lost:
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04e0, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04e2, code lost:
        r20 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04e4, code lost:
        if (r7 == null) goto L_0x056d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04e6, code lost:
        r19 = kotlin.m.p.b(r16).toString();
        r5 = new androidx.databinding.i();
        r5.set(java.lang.Boolean.TRUE);
        r6 = kotlin.x.f47997a;
        r18 = new com.travel.flight.flightSRPV2.a.d(r19, r20, 0, 0, r5);
        r5 = new com.travel.flight.flightSRPV2.a.r(true, r18);
        r15 = r0.this$0.getOnwardFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0519, code lost:
        if (r15 == null) goto L_0x0522;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x051b, code lost:
        java.lang.Boolean.valueOf(r15.add(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0528, code lost:
        if (r0.this$0.isRoundTrip() == false) goto L_0x0579;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x052a, code lost:
        r5 = r1.getmReturnFlights().getmMeta();
        kotlin.g.b.k.a((java.lang.Object) r5, "flightsInfo.getmReturnFlights().getmMeta()");
        r5 = r5.getAirlineNames();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x053b, code lost:
        if (r7 == null) goto L_0x0567;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0549, code lost:
        if (r5.containsKey(kotlin.m.p.b(r16).toString()) == false) goto L_0x0579;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x054b, code lost:
        r3 = new com.travel.flight.flightSRPV2.a.r(false, r18);
        r5 = r0.this$0.getReturnFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x055d, code lost:
        if (r5 == null) goto L_0x0579;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x055f, code lost:
        java.lang.Boolean.valueOf(r5.add(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x056c, code lost:
        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0572, code lost:
        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0578, code lost:
        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0582, code lost:
        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0583, code lost:
        r2 = r0.this$0.getOnwardFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x058f, code lost:
        if (r2 == null) goto L_0x059a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0595, code lost:
        if (r2.isEmpty() == false) goto L_0x0598;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0598, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x059a, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x059b, code lost:
        if (r2 == false) goto L_0x05b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x059d, code lost:
        r2 = r0.this$0.getReturnFilterList().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x05a9, code lost:
        if (r2 == null) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x05af, code lost:
        if (r2.isEmpty() == false) goto L_0x05b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x05b2, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x05b4, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05b5, code lost:
        if (r2 != false) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05b7, code lost:
        r0.this$0.setDeeplinkFilterApplied(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x05bd, code lost:
        r2 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x05c5, code lost:
        if (r0.$srpResult.getmMetaDetails() == null) goto L_0x06e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x05d1, code lost:
        if (r0.$srpResult.getmMetaDetails().getmToolTipMesage() == null) goto L_0x06e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x05d3, code lost:
        r2 = new java.util.ArrayList();
        r3 = r0.$srpResult.getmMetaDetails().getmToolTipMesage();
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x05e7, code lost:
        if (r5 == null) goto L_0x05f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x05ed, code lost:
        if (kotlin.m.p.a(r5) == false) goto L_0x05f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x05f0, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x05f2, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05f3, code lost:
        if (r5 != false) goto L_0x064c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x05fb, code lost:
        if (r0.this$0.isRoundTrip() == false) goto L_0x064c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05fd, code lost:
        r5 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0607, code lost:
        if (r5 != null) goto L_0x060c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0609, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x060c, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0613, code lost:
        if (r5.getmCount_adults() > 1) goto L_0x0643;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0615, code lost:
        r5 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x061f, code lost:
        if (r5 != null) goto L_0x0624;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0621, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x062a, code lost:
        if (r5.getmCount_childerns() > 0) goto L_0x0643;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x062c, code lost:
        r5 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0636, code lost:
        if (r5 != null) goto L_0x063b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0638, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0641, code lost:
        if (r5.getmCount_infants() <= 0) goto L_0x064d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0643, code lost:
        r2.add(new com.travel.flight.flightSRPV2.a.ag(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        if (r4.equals("IOW") != false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x064c, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x064d, code lost:
        r1 = r1.getAdditionalInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0651, code lost:
        if (r1 == null) goto L_0x0658;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0653, code lost:
        r3 = r1.getOriginVisaOptions();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0658, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0659, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x065c, code lost:
        if (r1 == null) goto L_0x0667;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0662, code lost:
        if (r1.isEmpty() == false) goto L_0x0665;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0665, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0667, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x066b, code lost:
        if (r1 != false) goto L_0x068c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x066d, code lost:
        r1 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0675, code lost:
        if (r1.hasNext() == false) goto L_0x068c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0677, code lost:
        r3 = r1.next();
        kotlin.g.b.k.a((java.lang.Object) r3, "visaMessage");
        r2.add(new com.travel.flight.flightSRPV2.a.ag(r3, "tip_fill.svg"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x068c, code lost:
        r1 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0696, code lost:
        if (r1 != null) goto L_0x069b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x0698, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x069b, code lost:
        kotlin.g.b.k.a((java.lang.Object) r1, "searchInput.value!!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x06a6, code lost:
        if (r1.getBookingSegment() != com.travel.flight.flightticket.d.b.Modify) goto L_0x06d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x06a8, code lost:
        r1 = r0.$srpResult.getmMetaDetails();
        kotlin.g.b.k.a((java.lang.Object) r1, "srpResult.getmMetaDetails()");
        r1 = r1.getModifySearchMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06b8, code lost:
        if (r1 == null) goto L_0x06d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x06ba, code lost:
        r3 = r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x06c0, code lost:
        if (r3 == null) goto L_0x06ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x06c6, code lost:
        if (kotlin.m.p.a(r3) == false) goto L_0x06c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x06c9, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06ca, code lost:
        if (r15 != false) goto L_0x06d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x06cc, code lost:
        r2.add(new com.travel.flight.flightSRPV2.a.ag(r1.getMessage(), "tip_fill.svg"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x06d8, code lost:
        r0.this$0.getToolTipMessagesEvent().postValue(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x06e3, code lost:
        if (r0.$isSecondaryAPIResponse != false) goto L_0x06ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x06e5, code lost:
        r0.this$0.triggerSecondaryAPITask();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x06ea, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x06ec, code lost:
        r0.this$0.logSrpLoadingPulseEvents(net.one97.paytm.upi.common.upi.CommonPayParams.Builder.NO);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x06f3, code lost:
        r0.this$0.getSrpResult().postValue(r0.$srpResult);
        r0.this$0.setProgressState(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0708, code lost:
        switch(r2.hashCode()) {
            case 67884: goto L_0x0751;
            case 67974: goto L_0x0732;
            case 72689: goto L_0x072b;
            case 72779: goto L_0x070c;
            default: goto L_0x070b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0710, code lost:
        if (r2.equals("IRT") == false) goto L_0x0775;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0712, code lost:
        r0.this$0.getShowSortFilterIcon().postValue(java.lang.Boolean.FALSE);
        r0.this$0.getShowFareCalenderIcon().postValue(java.lang.Boolean.FALSE);
        r1 = "PAGE_SRP_INTERNATIONAL_ROUND_TRIP";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x072f, code lost:
        if (r2.equals("IOW") == false) goto L_0x0775;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0736, code lost:
        if (r2.equals("DRT") == false) goto L_0x0775;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0738, code lost:
        r0.this$0.getShowSortFilterIcon().postValue(java.lang.Boolean.TRUE);
        r0.this$0.getShowFareCalenderIcon().postValue(java.lang.Boolean.TRUE);
        r1 = "PAGE_SRP_DOMESTIC_ROUND_TRIP";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0755, code lost:
        if (r2.equals("DOW") == false) goto L_0x0775;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x0757, code lost:
        r0.this$0.getShowSortFilterIcon().postValue(java.lang.Boolean.FALSE);
        r0.this$0.getShowFareCalenderIcon().postValue(java.lang.Boolean.TRUE);
        r1 = com.travel.flight.utils.j.f25593a;
        com.travel.flight.utils.j.a.a(net.one97.paytm.upi.common.upi.CommonPayParams.Builder.YES);
        r1 = "PAGE_SRP_ONE_WAY_TRIP";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0775, code lost:
        r0.this$0.getShowSortFilterIcon().postValue(java.lang.Boolean.FALSE);
        r0.this$0.getShowFareCalenderIcon().postValue(java.lang.Boolean.TRUE);
        r1 = "PAGE_NO_FLIGHTS_FOUND";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x078d, code lost:
        r0.this$0.navigate(new com.travel.flight.flightSRPV2.b.c(r1, com.travel.flight.R.id.container_child, (java.lang.String) null, 48));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f6, code lost:
        if (r4.equals("DOW") != false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f8, code lost:
        r7 = r0.this$0;
        r14 = r1.getmOnwardFlights();
        kotlin.g.b.k.a((java.lang.Object) r14, "flightsInfo.getmOnwardFlights()");
        r9 = r0.$srpResult.getmMetaDetails();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0107, code lost:
        if (r9 == null) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0109, code lost:
        r9 = r9.getmRequestId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010e, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010f, code lost:
        r7 = r7.isEmptyResponseFromResult(r14, r4, "ONWARD", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0114, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0115, code lost:
        r8 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011f, code lost:
        if (r8 != null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0121, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0124, code lost:
        kotlin.g.b.k.a((java.lang.Object) r8, "searchInput.value!!");
        r8.setJourneyDetailType(r4);
        r8 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0138, code lost:
        if (r8 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x013a, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013d, code lost:
        kotlin.g.b.k.a((java.lang.Object) r8, "searchInput.value!!");
        r14 = com.travel.flight.utils.j.f25593a;
        r8.setJourneyType(com.travel.flight.utils.j.a.a(!r0.this$0.isRoundTrip()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0154, code lost:
        if (r7 != false) goto L_0x06ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015a, code lost:
        switch(r4.hashCode()) {
            case 67884: goto L_0x0241;
            case 67974: goto L_0x0214;
            case 72689: goto L_0x020d;
            case 72779: goto L_0x015f;
            default: goto L_0x015d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0163, code lost:
        if (r4.equals("IRT") == false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016b, code lost:
        if (r0.this$0.isSortFilterEnable() == false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x016d, code lost:
        r0.this$0.getDefaultOnwardFilterInfo().postValue(com.travel.flight.flightSRPV2.a.t.a(r0.$srpResult, true));
        r0.this$0.getDefaultReturnFilterInfo().postValue(com.travel.flight.flightSRPV2.a.t.a(r0.$srpResult, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x018b, code lost:
        r0.$srpResult.setmInternationalFlightList(new com.travel.flight.flightSRPV2.a.q((byte) 0));
        r2 = r0.$srpResult.getNetworkResponse().headers.get("Content-Encoding");
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01aa, code lost:
        if (r7 == null) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b0, code lost:
        if (r7.length() != 0) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b3, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b5, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b6, code lost:
        if (r7 != false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01be, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) "gzip") == false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c0, code lost:
        r2 = com.paytm.network.b.g.a(com.paytm.network.b.g.a(r0.$srpResult.getNetworkResponse().data));
        kotlin.g.b.k.a((java.lang.Object) r2, "GzipUtils.convertString(…lt.networkResponse.data))");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d6, code lost:
        r2 = r0.$srpResult.getNetworkResponse().data;
        kotlin.g.b.k.a((java.lang.Object) r2, "srpResult.networkResponse.data");
        r2 = new java.lang.String(r2, kotlin.m.d.f47971a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ec, code lost:
        r2 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) new com.google.gsonhtcfix.f().a(r2, com.travel.flight.pojo.flightticket.CJRFlightSearchResult.class);
        r2.setmInternationalFlightList(new com.travel.flight.flightSRPV2.a.q((byte) 0));
        r0.this$0.getCopiedSrpResult().postValue(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0211, code lost:
        if (r4.equals("IOW") == false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0218, code lost:
        if (r4.equals("DRT") == false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0220, code lost:
        if (r0.this$0.isSortFilterEnable() == false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0222, code lost:
        r0.this$0.getDefaultOnwardFilterInfo().postValue(com.travel.flight.flightSRPV2.a.t.a(r0.$srpResult, true));
        r0.this$0.getDefaultReturnFilterInfo().postValue(com.travel.flight.flightSRPV2.a.t.a(r0.$srpResult, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0245, code lost:
        if (r4.equals("DOW") == false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0247, code lost:
        r0.this$0.getOneWaySortOption().postValue(new com.travel.flight.flightSRPV2.a.p((byte) 0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x025b, code lost:
        if (r0.this$0.isSortFilterEnable() == false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x025d, code lost:
        r0.this$0.getDefaultOnwardFilterInfo().postValue(com.travel.flight.flightSRPV2.a.t.a(r0.$srpResult, true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x026c, code lost:
        r0.this$0.logSrpLoadingPulseEvents(net.one97.paytm.upi.common.upi.CommonPayParams.Builder.YES);
        r2 = new java.util.HashMap();
        r7 = r2;
        r14 = com.travel.flight.utils.j.f25593a;
        r14 = r0.this$0.getSearchInput().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0285, code lost:
        if (r14 != null) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0287, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x028a, code lost:
        kotlin.g.b.k.a((java.lang.Object) r14, "searchInput.value!!");
        r14 = r14.getJourneyDetailType();
        kotlin.g.b.k.a((java.lang.Object) r14, "searchInput.value!!.journeyDetailType");
        kotlin.g.b.k.c(r14, "journeyDetailType");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02a7, code lost:
        if ((kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) "DOW") | kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) "IOW")) == false) goto L_0x02d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02a9, code lost:
        if (r1 == null) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02ab, code lost:
        r14 = r1.getmOnwardFlights();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02af, code lost:
        if (r14 == null) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02b1, code lost:
        r14 = r14.getmFlightDetails();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02b5, code lost:
        if (r14 == null) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b7, code lost:
        r14 = java.lang.Integer.valueOf(r14.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02c0, code lost:
        r14 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r1 = r0.label
            if (r1 != 0) goto L_0x07d6
            kotlin.ResultKt.a((java.lang.Object) r25)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getOnwardFilterList()
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x001e
            r1.clear()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x001e:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getReturnFilterList()
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0031
            r1.clear()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0031:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getSearchInput()
            java.lang.Object r1 = r1.getValue()
            java.lang.String r2 = "UNDEFINED"
            if (r1 == 0) goto L_0x07cb
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r1 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r1.getmOnwardReturnFlights()
            if (r1 == 0) goto L_0x07b5
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r1 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r1.getmOnwardReturnFlights()
            java.lang.String r4 = "flightsInfo"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = r1.getJourney_type()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0065
            boolean r4 = kotlin.m.p.a(r4)
            if (r4 == 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r4 = 0
            goto L_0x0066
        L_0x0065:
            r4 = 1
        L_0x0066:
            if (r4 != 0) goto L_0x079f
            java.lang.String r4 = r1.getJourney_type()
            java.lang.String r7 = net.one97.paytmflight.common.b.b.f30019i
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r7)
            com.travel.flight.utils.j$a r7 = com.travel.flight.utils.j.f25593a
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r0.this$0
            boolean r7 = r7.isRoundTrip()
            r7 = r7 ^ r6
            java.lang.String r4 = com.travel.flight.utils.j.a.a((boolean) r7, (boolean) r4)
            int r7 = r4.hashCode()
            java.lang.String r8 = "ONWARD"
            java.lang.String r9 = "flightsInfo.getmOnwardFlights()"
            java.lang.String r10 = "IRT"
            java.lang.String r11 = "IOW"
            java.lang.String r12 = "DRT"
            java.lang.String r13 = "DOW"
            switch(r7) {
                case 67884: goto L_0x00f2;
                case 67974: goto L_0x00ab;
                case 72689: goto L_0x00a4;
                case 72779: goto L_0x0094;
                default: goto L_0x0092;
            }
        L_0x0092:
            goto L_0x0114
        L_0x0094:
            boolean r7 = r4.equals(r10)
            if (r7 == 0) goto L_0x0114
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r0.this$0
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r8 = r0.$srpResult
            boolean r7 = r7.isEmptyResponseForIRT(r8)
            goto L_0x0115
        L_0x00a4:
            boolean r7 = r4.equals(r11)
            if (r7 == 0) goto L_0x0114
            goto L_0x00f8
        L_0x00ab:
            boolean r7 = r4.equals(r12)
            if (r7 == 0) goto L_0x0114
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r0.this$0
            com.travel.flight.pojo.flightticket.CJROnwardFlights r14 = r1.getmOnwardFlights()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r9 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r9 = r9.getmMetaDetails()
            if (r9 == 0) goto L_0x00c7
            java.lang.String r9 = r9.getmRequestId()
            goto L_0x00c8
        L_0x00c7:
            r9 = 0
        L_0x00c8:
            boolean r7 = r7.isEmptyResponseFromResult(r14, r4, r8, r9)
            if (r7 != 0) goto L_0x0114
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r0.this$0
            com.travel.flight.pojo.flightticket.CJROnwardFlights r8 = r1.getmReturnFlights()
            java.lang.String r9 = "flightsInfo.getmReturnFlights()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r9 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r9 = r9.getmMetaDetails()
            if (r9 == 0) goto L_0x00e6
            java.lang.String r9 = r9.getmRequestId()
            goto L_0x00e7
        L_0x00e6:
            r9 = 0
        L_0x00e7:
            java.lang.String r14 = "RETURN"
            boolean r7 = r7.isEmptyResponseFromResult(r8, r4, r14, r9)
            if (r7 == 0) goto L_0x00f0
            goto L_0x0114
        L_0x00f0:
            r7 = 0
            goto L_0x0115
        L_0x00f2:
            boolean r7 = r4.equals(r13)
            if (r7 == 0) goto L_0x0114
        L_0x00f8:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r0.this$0
            com.travel.flight.pojo.flightticket.CJROnwardFlights r14 = r1.getmOnwardFlights()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r9 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r9 = r9.getmMetaDetails()
            if (r9 == 0) goto L_0x010e
            java.lang.String r9 = r9.getmRequestId()
            goto L_0x010f
        L_0x010e:
            r9 = 0
        L_0x010f:
            boolean r7 = r7.isEmptyResponseFromResult(r14, r4, r8, r9)
            goto L_0x0115
        L_0x0114:
            r7 = 1
        L_0x0115:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r0.this$0
            androidx.lifecycle.y r8 = r8.getSearchInput()
            java.lang.Object r8 = r8.getValue()
            if (r8 != 0) goto L_0x0124
            kotlin.g.b.k.a()
        L_0x0124:
            java.lang.String r9 = "searchInput.value!!"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r8 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r8
            r8.setJourneyDetailType(r4)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r0.this$0
            androidx.lifecycle.y r8 = r8.getSearchInput()
            java.lang.Object r8 = r8.getValue()
            if (r8 != 0) goto L_0x013d
            kotlin.g.b.k.a()
        L_0x013d:
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r8 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r8
            com.travel.flight.utils.j$a r14 = com.travel.flight.utils.j.f25593a
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            boolean r14 = r14.isRoundTrip()
            r14 = r14 ^ r6
            java.lang.String r14 = com.travel.flight.utils.j.a.a((boolean) r14)
            r8.setJourneyType(r14)
            java.lang.String r8 = "Yes"
            if (r7 != 0) goto L_0x06ec
            int r2 = r4.hashCode()
            switch(r2) {
                case 67884: goto L_0x0241;
                case 67974: goto L_0x0214;
                case 72689: goto L_0x020d;
                case 72779: goto L_0x015f;
                default: goto L_0x015d;
            }
        L_0x015d:
            goto L_0x026c
        L_0x015f:
            boolean r2 = r4.equals(r10)
            if (r2 == 0) goto L_0x026c
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            boolean r2 = r2.isSortFilterEnable()
            if (r2 == 0) goto L_0x018b
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getDefaultOnwardFilterInfo()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7 = r0.$srpResult
            com.travel.flight.flightSRPV2.a.u r7 = com.travel.flight.flightSRPV2.a.t.a((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r7, (boolean) r6)
            r2.postValue(r7)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getDefaultReturnFilterInfo()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7 = r0.$srpResult
            com.travel.flight.flightSRPV2.a.u r7 = com.travel.flight.flightSRPV2.a.t.a((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r7, (boolean) r5)
            r2.postValue(r7)
        L_0x018b:
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r2 = r0.$srpResult
            com.travel.flight.flightSRPV2.a.q r7 = new com.travel.flight.flightSRPV2.a.q
            r7.<init>(r5)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            r2.setmInternationalFlightList(r7)
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r2 = r0.$srpResult
            com.paytm.network.model.NetworkResponse r2 = r2.getNetworkResponse()
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.headers
            java.lang.String r7 = "Content-Encoding"
            java.lang.Object r2 = r2.get(r7)
            java.lang.String r2 = (java.lang.String) r2
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x01b5
            int r7 = r7.length()
            if (r7 != 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b3:
            r7 = 0
            goto L_0x01b6
        L_0x01b5:
            r7 = 1
        L_0x01b6:
            if (r7 != 0) goto L_0x01d6
            java.lang.String r7 = "gzip"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x01d6
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r2 = r0.$srpResult
            com.paytm.network.model.NetworkResponse r2 = r2.getNetworkResponse()
            byte[] r2 = r2.data
            java.io.Reader r2 = com.paytm.network.b.g.a((byte[]) r2)
            java.lang.String r2 = com.paytm.network.b.g.a((java.io.Reader) r2)
            java.lang.String r7 = "GzipUtils.convertString(…lt.networkResponse.data))"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            goto L_0x01ec
        L_0x01d6:
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r2 = r0.$srpResult
            com.paytm.network.model.NetworkResponse r2 = r2.getNetworkResponse()
            byte[] r2 = r2.data
            java.lang.String r7 = "srpResult.networkResponse.data"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r14 = kotlin.m.d.f47971a
            r7.<init>(r2, r14)
            r2 = r7
        L_0x01ec:
            com.google.gsonhtcfix.f r7 = new com.google.gsonhtcfix.f
            r7.<init>()
            java.lang.Class<com.travel.flight.pojo.flightticket.CJRFlightSearchResult> r14 = com.travel.flight.pojo.flightticket.CJRFlightSearchResult.class
            java.lang.Object r2 = r7.a((java.lang.String) r2, r14)
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r2 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r2
            com.travel.flight.flightSRPV2.a.q r7 = new com.travel.flight.flightSRPV2.a.q
            r7.<init>(r5)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            r2.setmInternationalFlightList(r7)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r0.this$0
            androidx.lifecycle.y r7 = r7.getCopiedSrpResult()
            r7.postValue(r2)
            goto L_0x026c
        L_0x020d:
            boolean r2 = r4.equals(r11)
            if (r2 == 0) goto L_0x026c
            goto L_0x0247
        L_0x0214:
            boolean r2 = r4.equals(r12)
            if (r2 == 0) goto L_0x026c
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            boolean r2 = r2.isSortFilterEnable()
            if (r2 == 0) goto L_0x026c
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getDefaultOnwardFilterInfo()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7 = r0.$srpResult
            com.travel.flight.flightSRPV2.a.u r7 = com.travel.flight.flightSRPV2.a.t.a((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r7, (boolean) r6)
            r2.postValue(r7)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getDefaultReturnFilterInfo()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7 = r0.$srpResult
            com.travel.flight.flightSRPV2.a.u r7 = com.travel.flight.flightSRPV2.a.t.a((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r7, (boolean) r5)
            r2.postValue(r7)
            goto L_0x026c
        L_0x0241:
            boolean r2 = r4.equals(r13)
            if (r2 == 0) goto L_0x026c
        L_0x0247:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getOneWaySortOption()
            com.travel.flight.flightSRPV2.a.p r7 = new com.travel.flight.flightSRPV2.a.p
            r7.<init>(r5)
            r2.postValue(r7)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            boolean r2 = r2.isSortFilterEnable()
            if (r2 == 0) goto L_0x026c
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getDefaultOnwardFilterInfo()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7 = r0.$srpResult
            com.travel.flight.flightSRPV2.a.u r7 = com.travel.flight.flightSRPV2.a.t.a((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r7, (boolean) r6)
            r2.postValue(r7)
        L_0x026c:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            r2.logSrpLoadingPulseEvents(r8)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            com.travel.flight.utils.j$a r14 = com.travel.flight.utils.j.f25593a
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            androidx.lifecycle.y r14 = r14.getSearchInput()
            java.lang.Object r14 = r14.getValue()
            if (r14 != 0) goto L_0x028a
            kotlin.g.b.k.a()
        L_0x028a:
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r14 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r14
            java.lang.String r14 = r14.getJourneyDetailType()
            java.lang.String r15 = "searchInput.value!!.journeyDetailType"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
            java.lang.String r15 = "journeyDetailType"
            kotlin.g.b.k.c(r14, r15)
            boolean r15 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r13)
            boolean r16 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r11)
            r15 = r15 | r16
            if (r15 == 0) goto L_0x02d0
            if (r1 == 0) goto L_0x02c0
            com.travel.flight.pojo.flightticket.CJROnwardFlights r14 = r1.getmOnwardFlights()
            if (r14 == 0) goto L_0x02c0
            java.util.ArrayList r14 = r14.getmFlightDetails()
            if (r14 == 0) goto L_0x02c0
            int r14 = r14.size()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x02c1
        L_0x02c0:
            r14 = 0
        L_0x02c1:
            if (r14 != 0) goto L_0x02c6
            kotlin.g.b.k.a()
        L_0x02c6:
            int r14 = r14.intValue()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            goto L_0x0352
        L_0x02d0:
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r12)
            if (r14 == 0) goto L_0x0333
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "Onward{"
            r14.<init>(r15)
            if (r1 == 0) goto L_0x02f4
            com.travel.flight.pojo.flightticket.CJROnwardFlights r15 = r1.getmOnwardFlights()
            if (r15 == 0) goto L_0x02f4
            java.util.ArrayList r15 = r15.getmFlightDetails()
            if (r15 == 0) goto L_0x02f4
            int r15 = r15.size()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x02f5
        L_0x02f4:
            r15 = 0
        L_0x02f5:
            if (r15 != 0) goto L_0x02fa
            kotlin.g.b.k.a()
        L_0x02fa:
            int r15 = r15.intValue()
            r14.append(r15)
            java.lang.String r15 = "}, Return{"
            r14.append(r15)
            com.travel.flight.pojo.flightticket.CJROnwardFlights r15 = r1.getmReturnFlights()
            if (r15 == 0) goto L_0x031c
            java.util.ArrayList r15 = r15.getmFlightDetails()
            if (r15 == 0) goto L_0x031c
            int r15 = r15.size()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x031d
        L_0x031c:
            r15 = 0
        L_0x031d:
            if (r15 != 0) goto L_0x0322
            kotlin.g.b.k.a()
        L_0x0322:
            int r15 = r15.intValue()
            r14.append(r15)
            r15 = 125(0x7d, float:1.75E-43)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            goto L_0x0352
        L_0x0333:
            if (r1 == 0) goto L_0x0344
            java.util.List r14 = r1.getmMapping()
            if (r14 == 0) goto L_0x0344
            int r14 = r14.size()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x0345
        L_0x0344:
            r14 = 0
        L_0x0345:
            if (r14 != 0) goto L_0x034a
            kotlin.g.b.k.a()
        L_0x034a:
            int r14 = r14.intValue()
            java.lang.String r14 = java.lang.String.valueOf(r14)
        L_0x0352:
            java.lang.String r15 = "event_label"
            r7.put(r15, r14)
            com.travel.flight.utils.j$a r7 = com.travel.flight.utils.j.f25593a
            java.lang.String r7 = "number_listings_SRP"
            com.travel.flight.utils.j.a.a((java.lang.String) r7, (java.util.HashMap<java.lang.String, java.lang.Object>) r2)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            boolean r2 = r2.isSortFilterEnable()
            if (r2 == 0) goto L_0x05bf
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getSearchInput()
            java.lang.Object r2 = r2.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r2 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r2
            if (r2 == 0) goto L_0x05bf
            java.lang.String r7 = "it"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            boolean r7 = r2.getNonStopSelected()
            if (r7 == 0) goto L_0x042d
            com.travel.flight.flightSRPV2.a.af r7 = new com.travel.flight.flightSRPV2.a.af
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            boolean r14 = r14.isRoundTrip()
            r14 = r14 ^ r6
            r7.<init>(r14, r6)
            int r14 = r4.hashCode()
            switch(r14) {
                case 67884: goto L_0x0412;
                case 67974: goto L_0x03e1;
                case 72689: goto L_0x03da;
                case 72779: goto L_0x0394;
                default: goto L_0x0392;
            }
        L_0x0392:
            goto L_0x042d
        L_0x0394:
            boolean r14 = r4.equals(r10)
            if (r14 == 0) goto L_0x042d
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            androidx.lifecycle.y r14 = r14.getOnwardFilterList()
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x03af
            boolean r14 = r14.add(r7)
            java.lang.Boolean.valueOf(r14)
        L_0x03af:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            androidx.lifecycle.y r14 = r14.getReturnFilterList()
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x03c4
            boolean r14 = r14.add(r7)
            java.lang.Boolean.valueOf(r14)
        L_0x03c4:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            androidx.lifecycle.y r14 = r14.getIrtFilterList()
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x042d
            boolean r7 = r14.add(r7)
            java.lang.Boolean.valueOf(r7)
            goto L_0x042d
        L_0x03da:
            boolean r14 = r4.equals(r11)
            if (r14 == 0) goto L_0x042d
            goto L_0x0418
        L_0x03e1:
            boolean r14 = r4.equals(r12)
            if (r14 == 0) goto L_0x042d
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            androidx.lifecycle.y r14 = r14.getOnwardFilterList()
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x03fc
            boolean r14 = r14.add(r7)
            java.lang.Boolean.valueOf(r14)
        L_0x03fc:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            androidx.lifecycle.y r14 = r14.getReturnFilterList()
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x042d
            boolean r7 = r14.add(r7)
            java.lang.Boolean.valueOf(r7)
            goto L_0x042d
        L_0x0412:
            boolean r14 = r4.equals(r13)
            if (r14 == 0) goto L_0x042d
        L_0x0418:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r14 = r0.this$0
            androidx.lifecycle.y r14 = r14.getOnwardFilterList()
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x042d
            boolean r7 = r14.add(r7)
            java.lang.Boolean.valueOf(r7)
        L_0x042d:
            java.lang.String r7 = r2.getmDeeplinkFilterAirlineCodes()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x043e
            int r7 = r7.length()
            if (r7 != 0) goto L_0x043c
            goto L_0x043e
        L_0x043c:
            r7 = 0
            goto L_0x043f
        L_0x043e:
            r7 = 1
        L_0x043f:
            if (r7 != 0) goto L_0x05bd
            com.travel.flight.pojo.flightticket.CJROnwardFlights r7 = r1.getmOnwardFlights()
            com.travel.flight.pojo.flightticket.CJRFlightFilterMinMaxDetails r7 = r7.getmMeta()
            if (r7 == 0) goto L_0x05bd
            com.travel.flight.pojo.flightticket.CJROnwardFlights r7 = r1.getmOnwardFlights()
            com.travel.flight.pojo.flightticket.CJRFlightFilterMinMaxDetails r7 = r7.getmMeta()
            java.lang.String r14 = "flightsInfo.getmOnwardFlights().getmMeta()"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r14)
            java.util.Map r7 = r7.getAirlineNames()
            if (r7 == 0) goto L_0x05bd
            java.lang.String r2 = r2.getmDeeplinkFilterAirlineCodes()
            java.lang.String r7 = "it.getmDeeplinkFilterAirlineCodes()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r7 = ","
            java.lang.String[] r7 = new java.lang.String[]{r7}
            java.util.List r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.String[]) r7)
            java.util.Iterator r2 = r2.iterator()
        L_0x0477:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0583
            java.lang.Object r7 = r2.next()
            java.lang.String r7 = (java.lang.String) r7
            com.travel.flight.pojo.flightticket.CJROnwardFlights r15 = r1.getmOnwardFlights()
            com.travel.flight.pojo.flightticket.CJRFlightFilterMinMaxDetails r15 = r15.getmMeta()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r14)
            java.util.Map r15 = r15.getAirlineNames()
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.CharSequence"
            if (r7 == 0) goto L_0x057d
            r16 = r7
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            java.lang.CharSequence r17 = kotlin.m.p.b(r16)
            java.lang.String r5 = r17.toString()
            boolean r5 = r15.containsKey(r5)
            if (r5 == 0) goto L_0x0579
            com.travel.flight.utils.j$a r5 = com.travel.flight.utils.j.f25593a
            com.travel.flight.pojo.flightticket.CJROnwardFlights r5 = r1.getmOnwardFlights()
            com.travel.flight.pojo.flightticket.CJRFlightFilterMinMaxDetails r5 = r5.getmMeta()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r14)
            java.util.Map r5 = r5.getAirlineNames()
            java.lang.String r15 = "flightsInfo.getmOnwardFl…).getmMeta().airlineNames"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r15)
            if (r7 == 0) goto L_0x0573
            java.lang.CharSequence r15 = kotlin.m.p.b(r16)
            java.lang.String r15 = r15.toString()
            java.lang.String r6 = "airlineNames"
            kotlin.g.b.k.c(r5, r6)
            java.lang.String r6 = "airline"
            kotlin.g.b.k.c(r15, r6)
            boolean r6 = r5.containsKey(r15)
            if (r6 == 0) goto L_0x04e2
            java.lang.Object r5 = r5.get(r15)
            if (r5 != 0) goto L_0x04df
            goto L_0x04e0
        L_0x04df:
            r15 = r5
        L_0x04e0:
            java.lang.String r15 = (java.lang.String) r15
        L_0x04e2:
            r20 = r15
            if (r7 == 0) goto L_0x056d
            java.lang.CharSequence r5 = kotlin.m.p.b(r16)
            java.lang.String r19 = r5.toString()
            androidx.databinding.i r5 = new androidx.databinding.i
            r5.<init>()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.set(r6)
            kotlin.x r6 = kotlin.x.f47997a
            com.travel.flight.flightSRPV2.a.d r6 = new com.travel.flight.flightSRPV2.a.d
            r21 = 0
            r22 = 0
            r18 = r6
            r23 = r5
            r18.<init>(r19, r20, r21, r22, r23)
            com.travel.flight.flightSRPV2.a.r r5 = new com.travel.flight.flightSRPV2.a.r
            r15 = 1
            r5.<init>(r15, r6)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r15 = r0.this$0
            androidx.lifecycle.y r15 = r15.getOnwardFilterList()
            java.lang.Object r15 = r15.getValue()
            java.util.List r15 = (java.util.List) r15
            if (r15 == 0) goto L_0x0522
            boolean r5 = r15.add(r5)
            java.lang.Boolean.valueOf(r5)
        L_0x0522:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r0.this$0
            boolean r5 = r5.isRoundTrip()
            if (r5 == 0) goto L_0x0579
            com.travel.flight.pojo.flightticket.CJROnwardFlights r5 = r1.getmReturnFlights()
            com.travel.flight.pojo.flightticket.CJRFlightFilterMinMaxDetails r5 = r5.getmMeta()
            java.lang.String r15 = "flightsInfo.getmReturnFlights().getmMeta()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r15)
            java.util.Map r5 = r5.getAirlineNames()
            if (r7 == 0) goto L_0x0567
            java.lang.CharSequence r3 = kotlin.m.p.b(r16)
            java.lang.String r3 = r3.toString()
            boolean r3 = r5.containsKey(r3)
            if (r3 == 0) goto L_0x0579
            com.travel.flight.flightSRPV2.a.r r3 = new com.travel.flight.flightSRPV2.a.r
            r5 = 0
            r3.<init>(r5, r6)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r0.this$0
            androidx.lifecycle.y r5 = r5.getReturnFilterList()
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0579
            boolean r3 = r5.add(r3)
            java.lang.Boolean.valueOf(r3)
            goto L_0x0579
        L_0x0567:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x056d:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x0573:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x0579:
            r5 = 0
            r6 = 1
            goto L_0x0477
        L_0x057d:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x0583:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getOnwardFilterList()
            java.lang.Object r2 = r2.getValue()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x059a
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0598
            goto L_0x059a
        L_0x0598:
            r2 = 0
            goto L_0x059b
        L_0x059a:
            r2 = 1
        L_0x059b:
            if (r2 == 0) goto L_0x05b7
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            androidx.lifecycle.y r2 = r2.getReturnFilterList()
            java.lang.Object r2 = r2.getValue()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x05b4
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x05b2
            goto L_0x05b4
        L_0x05b2:
            r2 = 0
            goto L_0x05b5
        L_0x05b4:
            r2 = 1
        L_0x05b5:
            if (r2 != 0) goto L_0x05bd
        L_0x05b7:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r0.this$0
            r3 = 1
            r2.setDeeplinkFilterApplied(r3)
        L_0x05bd:
            kotlin.x r2 = kotlin.x.f47997a
        L_0x05bf:
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r2 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r2 = r2.getmMetaDetails()
            if (r2 == 0) goto L_0x06e1
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r2 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r2 = r2.getmMetaDetails()
            java.lang.String r2 = r2.getmToolTipMesage()
            if (r2 == 0) goto L_0x06e1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r3 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r3 = r3.getmMetaDetails()
            java.lang.String r3 = r3.getmToolTipMesage()
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x05f2
            boolean r5 = kotlin.m.p.a(r5)
            if (r5 == 0) goto L_0x05f0
            goto L_0x05f2
        L_0x05f0:
            r5 = 0
            goto L_0x05f3
        L_0x05f2:
            r5 = 1
        L_0x05f3:
            if (r5 != 0) goto L_0x064c
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r0.this$0
            boolean r5 = r5.isRoundTrip()
            if (r5 == 0) goto L_0x064c
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r0.this$0
            androidx.lifecycle.y r5 = r5.getSearchInput()
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x060c
            kotlin.g.b.k.a()
        L_0x060c:
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r5 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r5
            int r5 = r5.getmCount_adults()
            r15 = 1
            if (r5 > r15) goto L_0x0643
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r0.this$0
            androidx.lifecycle.y r5 = r5.getSearchInput()
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x0624
            kotlin.g.b.k.a()
        L_0x0624:
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r5 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r5
            int r5 = r5.getmCount_childerns()
            if (r5 > 0) goto L_0x0643
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r0.this$0
            androidx.lifecycle.y r5 = r5.getSearchInput()
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x063b
            kotlin.g.b.k.a()
        L_0x063b:
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r5 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r5
            int r5 = r5.getmCount_infants()
            if (r5 <= 0) goto L_0x064d
        L_0x0643:
            com.travel.flight.flightSRPV2.a.ag r5 = new com.travel.flight.flightSRPV2.a.ag
            r5.<init>(r3)
            r2.add(r5)
            goto L_0x064d
        L_0x064c:
            r15 = 1
        L_0x064d:
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r1 = r1.getAdditionalInfo()
            if (r1 == 0) goto L_0x0658
            java.util.List r3 = r1.getOriginVisaOptions()
            goto L_0x0659
        L_0x0658:
            r3 = 0
        L_0x0659:
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0667
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0665
            goto L_0x0667
        L_0x0665:
            r1 = 0
            goto L_0x0668
        L_0x0667:
            r1 = 1
        L_0x0668:
            java.lang.String r5 = "tip_fill.svg"
            if (r1 != 0) goto L_0x068c
            java.util.Iterator r1 = r3.iterator()
        L_0x0671:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x068c
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            com.travel.flight.flightSRPV2.a.ag r6 = new com.travel.flight.flightSRPV2.a.ag
            java.lang.String r7 = "visaMessage"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            r6.<init>(r3, r5)
            r2.add(r6)
            goto L_0x0671
        L_0x068c:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getSearchInput()
            java.lang.Object r1 = r1.getValue()
            if (r1 != 0) goto L_0x069b
            kotlin.g.b.k.a()
        L_0x069b:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r1 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r1
            com.travel.flight.flightticket.d.b r1 = r1.getBookingSegment()
            com.travel.flight.flightticket.d.b r3 = com.travel.flight.flightticket.d.b.Modify
            if (r1 != r3) goto L_0x06d8
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r1 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r1 = r1.getmMetaDetails()
            java.lang.String r3 = "srpResult.getmMetaDetails()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            com.travel.flight.pojo.flightticket.ModifySearchMessage r1 = r1.getModifySearchMessage()
            if (r1 == 0) goto L_0x06d8
            java.lang.String r3 = r1.getMessage()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x06ca
            boolean r3 = kotlin.m.p.a(r3)
            if (r3 == 0) goto L_0x06c9
            goto L_0x06ca
        L_0x06c9:
            r15 = 0
        L_0x06ca:
            if (r15 != 0) goto L_0x06d8
            com.travel.flight.flightSRPV2.a.ag r3 = new com.travel.flight.flightSRPV2.a.ag
            java.lang.String r1 = r1.getMessage()
            r3.<init>(r1, r5)
            r2.add(r3)
        L_0x06d8:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            com.travel.flight.flightSRPV2.c.b r1 = r1.getToolTipMessagesEvent()
            r1.postValue(r2)
        L_0x06e1:
            boolean r1 = r0.$isSecondaryAPIResponse
            if (r1 != 0) goto L_0x06ea
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            r1.triggerSecondaryAPITask()
        L_0x06ea:
            r2 = r4
            goto L_0x06f3
        L_0x06ec:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            java.lang.String r3 = "No"
            r1.logSrpLoadingPulseEvents(r3)
        L_0x06f3:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getSrpResult()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r3 = r0.$srpResult
            r1.postValue(r3)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            r3 = 0
            r1.setProgressState(r3)
            int r1 = r2.hashCode()
            switch(r1) {
                case 67884: goto L_0x0751;
                case 67974: goto L_0x0732;
                case 72689: goto L_0x072b;
                case 72779: goto L_0x070c;
                default: goto L_0x070b;
            }
        L_0x070b:
            goto L_0x0775
        L_0x070c:
            boolean r1 = r2.equals(r10)
            if (r1 == 0) goto L_0x0775
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowSortFilterIcon()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.postValue(r2)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowFareCalenderIcon()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.postValue(r2)
            java.lang.String r1 = "PAGE_SRP_INTERNATIONAL_ROUND_TRIP"
            goto L_0x078d
        L_0x072b:
            boolean r1 = r2.equals(r11)
            if (r1 == 0) goto L_0x0775
            goto L_0x0757
        L_0x0732:
            boolean r1 = r2.equals(r12)
            if (r1 == 0) goto L_0x0775
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowSortFilterIcon()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.postValue(r2)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowFareCalenderIcon()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.postValue(r2)
            java.lang.String r1 = "PAGE_SRP_DOMESTIC_ROUND_TRIP"
            goto L_0x078d
        L_0x0751:
            boolean r1 = r2.equals(r13)
            if (r1 == 0) goto L_0x0775
        L_0x0757:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowSortFilterIcon()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.postValue(r2)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowFareCalenderIcon()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.postValue(r2)
            com.travel.flight.utils.j$a r1 = com.travel.flight.utils.j.f25593a
            com.travel.flight.utils.j.a.a((java.lang.String) r8)
            java.lang.String r1 = "PAGE_SRP_ONE_WAY_TRIP"
            goto L_0x078d
        L_0x0775:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowSortFilterIcon()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.postValue(r2)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            androidx.lifecycle.y r1 = r1.getShowFareCalenderIcon()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.postValue(r2)
            java.lang.String r1 = "PAGE_NO_FLIGHTS_FOUND"
        L_0x078d:
            com.travel.flight.flightSRPV2.b.c r2 = new com.travel.flight.flightSRPV2.b.c
            int r3 = com.travel.flight.R.id.container_child
            r4 = 48
            r5 = 0
            r2.<init>(r1, r3, r5, r4)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            com.travel.flight.flightSRPV2.b.d r2 = (com.travel.flight.flightSRPV2.b.d) r2
            r1.navigate(r2)
            goto L_0x07d3
        L_0x079f:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r3 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r3 = r3.getmMetaDetails()
            if (r3 == 0) goto L_0x07ae
            java.lang.String r3 = r3.getmRequestId()
            goto L_0x07af
        L_0x07ae:
            r3 = 0
        L_0x07af:
            java.lang.String r4 = "journey_type key is missing"
            r1.sendHawkeyeErrorEvent(r2, r4, r3)
            goto L_0x07d3
        L_0x07b5:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r3 = r0.$srpResult
            com.travel.flight.pojo.flightticket.CJRMetadetails r3 = r3.getmMetaDetails()
            if (r3 == 0) goto L_0x07c4
            java.lang.String r3 = r3.getmRequestId()
            goto L_0x07c5
        L_0x07c4:
            r3 = 0
        L_0x07c5:
            java.lang.String r4 = "body is null"
            r1.sendHawkeyeErrorEvent(r2, r4, r3)
            goto L_0x07d3
        L_0x07cb:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r0.this$0
            java.lang.String r3 = "SearchInput is null"
            r4 = 0
            r1.sendHawkeyeErrorEvent(r2, r3, r4)
        L_0x07d3:
            kotlin.x r1 = kotlin.x.f47997a
            return r1
        L_0x07d6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel$handleSRPResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
