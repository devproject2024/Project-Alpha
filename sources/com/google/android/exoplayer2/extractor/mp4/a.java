package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a {
    public static final int A = ae.h("ac-3");
    public static final int B = ae.h("dac3");
    public static final int C = ae.h("ec-3");
    public static final int D = ae.h("dec3");
    public static final int E = ae.h("ac-4");
    public static final int F = ae.h("dac4");
    public static final int G = ae.h("dtsc");
    public static final int H = ae.h("dtsh");
    public static final int I = ae.h("dtsl");
    public static final int J = ae.h("dtse");
    public static final int K = ae.h("ddts");
    public static final int L = ae.h("tfdt");
    public static final int M = ae.h("tfhd");
    public static final int N = ae.h("trex");
    public static final int O = ae.h("trun");
    public static final int P = ae.h("sidx");
    public static final int Q = ae.h("moov");
    public static final int R = ae.h("mvhd");
    public static final int S = ae.h("trak");
    public static final int T = ae.h("mdia");
    public static final int U = ae.h("minf");
    public static final int V = ae.h("stbl");
    public static final int W = ae.h("esds");
    public static final int X = ae.h("moof");
    public static final int Y = ae.h("traf");
    public static final int Z = ae.h("mvex");

    /* renamed from: a  reason: collision with root package name */
    public static final int f32159a = ae.h("ftyp");
    public static final int aA = ae.h("stss");
    public static final int aB = ae.h("ctts");
    public static final int aC = ae.h("stsc");
    public static final int aD = ae.h("stsz");
    public static final int aE = ae.h("stz2");
    public static final int aF = ae.h("stco");
    public static final int aG = ae.h("co64");
    public static final int aH = ae.h("tx3g");
    public static final int aI = ae.h("wvtt");
    public static final int aJ = ae.h("stpp");
    public static final int aK = ae.h("c608");
    public static final int aL = ae.h("samr");
    public static final int aM = ae.h("sawb");
    public static final int aN = ae.h("udta");
    public static final int aO = ae.h("meta");
    public static final int aP = ae.h("keys");
    public static final int aQ = ae.h("ilst");
    public static final int aR = ae.h("mean");
    public static final int aS = ae.h("name");
    public static final int aT = ae.h("data");
    public static final int aU = ae.h("emsg");
    public static final int aV = ae.h("st3d");
    public static final int aW = ae.h("sv3d");
    public static final int aX = ae.h("proj");
    public static final int aY = ae.h("camm");
    public static final int aZ = ae.h("alac");
    public static final int aa = ae.h("mehd");
    public static final int ab = ae.h("tkhd");
    public static final int ac = ae.h("edts");
    public static final int ad = ae.h("elst");
    public static final int ae = ae.h("mdhd");
    public static final int af = ae.h("hdlr");
    public static final int ag = ae.h("stsd");
    public static final int ah = ae.h("pssh");
    public static final int ai = ae.h("sinf");
    public static final int aj = ae.h("schm");
    public static final int ak = ae.h("schi");
    public static final int al = ae.h("tenc");
    public static final int am = ae.h("encv");
    public static final int an = ae.h("enca");
    public static final int ao = ae.h("frma");
    public static final int ap = ae.h("saiz");
    public static final int aq = ae.h("saio");
    public static final int ar = ae.h("sbgp");
    public static final int as = ae.h("sgpd");
    public static final int at = ae.h("uuid");
    public static final int au = ae.h("senc");
    public static final int av = ae.h("pasp");
    public static final int aw = ae.h("TTML");
    public static final int ax = ae.h("vmhd");
    public static final int ay = ae.h("mp4v");
    public static final int az = ae.h("stts");

    /* renamed from: b  reason: collision with root package name */
    public static final int f32160b = ae.h("avc1");
    public static final int ba = ae.h("alaw");
    public static final int bb = ae.h("ulaw");
    public static final int bc = ae.h("Opus");
    public static final int bd = ae.h("dOps");
    public static final int be = ae.h("fLaC");
    public static final int bf = ae.h("dfLa");

    /* renamed from: c  reason: collision with root package name */
    public static final int f32161c = ae.h("avc3");

    /* renamed from: d  reason: collision with root package name */
    public static final int f32162d = ae.h("avcC");

    /* renamed from: e  reason: collision with root package name */
    public static final int f32163e = ae.h("hvc1");

    /* renamed from: f  reason: collision with root package name */
    public static final int f32164f = ae.h("hev1");

    /* renamed from: g  reason: collision with root package name */
    public static final int f32165g = ae.h("hvcC");

    /* renamed from: h  reason: collision with root package name */
    public static final int f32166h = ae.h("vp08");

    /* renamed from: i  reason: collision with root package name */
    public static final int f32167i = ae.h("vp09");
    public static final int j = ae.h("vpcC");
    public static final int k = ae.h("av01");
    public static final int l = ae.h("av1C");
    public static final int m = ae.h("dvav");
    public static final int n = ae.h("dva1");
    public static final int o = ae.h("dvhe");
    public static final int p = ae.h("dvh1");
    public static final int q = ae.h("dvcC");
    public static final int r = ae.h("dvvC");
    public static final int s = ae.h("s263");
    public static final int t = ae.h("d263");
    public static final int u = ae.h("mdat");
    public static final int v = ae.h("mp4a");
    public static final int w = ae.h(".mp3");
    public static final int x = ae.h("wave");
    public static final int y = ae.h("lpcm");
    public static final int z = ae.h("sowt");
    public final int bg;

    public static int a(int i2) {
        return (i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public a(int i2) {
        this.bg = i2;
    }

    public String toString() {
        return c(this.bg);
    }

    static final class b extends a {
        public final r bh;

        public b(int i2, r rVar) {
            super(i2);
            this.bh = rVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.a$a  reason: collision with other inner class name */
    static final class C0542a extends a {
        public final long bh;
        public final List<b> bi = new ArrayList();
        public final List<C0542a> bj = new ArrayList();

        public C0542a(int i2, long j) {
            super(i2);
            this.bh = j;
        }

        public final void a(b bVar) {
            this.bi.add(bVar);
        }

        public final void a(C0542a aVar) {
            this.bj.add(aVar);
        }

        public final b d(int i2) {
            int size = this.bi.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.bi.get(i3);
                if (bVar.bg == i2) {
                    return bVar;
                }
            }
            return null;
        }

        public final C0542a e(int i2) {
            int size = this.bj.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0542a aVar = this.bj.get(i3);
                if (aVar.bg == i2) {
                    return aVar;
                }
            }
            return null;
        }

        public final String toString() {
            return c(this.bg) + " leaves: " + Arrays.toString(this.bi.toArray()) + " containers: " + Arrays.toString(this.bj.toArray());
        }
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID));
        sb.append((char) ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID));
        sb.append((char) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID));
        sb.append((char) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID));
        return sb.toString();
    }
}
