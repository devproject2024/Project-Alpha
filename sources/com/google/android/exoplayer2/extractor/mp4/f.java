package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.nio.ByteBuffer;

final class f {
    private static final int A = ae.h("sosn");
    private static final int B = ae.h("tvsh");
    private static final int C = ae.h("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* renamed from: a  reason: collision with root package name */
    private static final int f32231a = ae.h("nam");

    /* renamed from: b  reason: collision with root package name */
    private static final int f32232b = ae.h("trk");

    /* renamed from: c  reason: collision with root package name */
    private static final int f32233c = ae.h("cmt");

    /* renamed from: d  reason: collision with root package name */
    private static final int f32234d = ae.h("day");

    /* renamed from: e  reason: collision with root package name */
    private static final int f32235e = ae.h("ART");

    /* renamed from: f  reason: collision with root package name */
    private static final int f32236f = ae.h("too");

    /* renamed from: g  reason: collision with root package name */
    private static final int f32237g = ae.h("alb");

    /* renamed from: h  reason: collision with root package name */
    private static final int f32238h = ae.h("com");

    /* renamed from: i  reason: collision with root package name */
    private static final int f32239i = ae.h("wrt");
    private static final int j = ae.h("lyr");
    private static final int k = ae.h("gen");
    private static final int l = ae.h("covr");
    private static final int m = ae.h("gnre");
    private static final int n = ae.h("grp");
    private static final int o = ae.h("disk");
    private static final int p = ae.h("trkn");
    private static final int q = ae.h("tmpo");
    private static final int r = ae.h("cpil");
    private static final int s = ae.h("aART");
    private static final int t = ae.h("sonm");
    private static final int u = ae.h("soal");
    private static final int v = ae.h("soar");
    private static final int w = ae.h("soaa");
    private static final int x = ae.h("soco");
    private static final int y = ae.h("rtng");
    private static final int z = ae.h("pgap");

    public static Format a(int i2, Format format, Metadata metadata, Metadata metadata2, k kVar) {
        if (i2 == 1) {
            if (kVar.a()) {
                format = format.a(kVar.f32143a, kVar.f32144b);
            }
            if (metadata != null) {
                return format.a(metadata);
            }
            return format;
        } else if (i2 != 2 || metadata2 == null) {
            return format;
        } else {
            Format format2 = format;
            for (Metadata.Entry entry : metadata2.f32644a) {
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if ("com.android.capture.fps".equals(mdtaMetadataEntry.f32155a) && mdtaMetadataEntry.f32158d == 23) {
                        try {
                            format2 = format2.a(ByteBuffer.wrap(mdtaMetadataEntry.f32156b).asFloatBuffer().get()).a(new Metadata(mdtaMetadataEntry));
                        } catch (NumberFormatException unused) {
                            l.c();
                        }
                    }
                }
            }
            return format2;
        }
    }

    private static TextInformationFrame a(int i2, String str, r rVar) {
        int i3 = rVar.i();
        if (rVar.i() == a.aT) {
            rVar.d(8);
            return new TextInformationFrame(str, (String) null, rVar.f(i3 - 16));
        }
        new StringBuilder("Failed to parse text attribute: ").append(a.c(i2));
        l.c();
        return null;
    }

    private static Id3Frame a(int i2, String str, r rVar, boolean z2, boolean z3) {
        int b2 = b(rVar);
        if (z3) {
            b2 = Math.min(1, b2);
        }
        if (b2 < 0) {
            new StringBuilder("Failed to parse uint8 attribute: ").append(a.c(i2));
            l.c();
            return null;
        } else if (z2) {
            return new TextInformationFrame(str, (String) null, Integer.toString(b2));
        } else {
            return new CommentFrame("und", str, Integer.toString(b2));
        }
    }

    private static TextInformationFrame b(int i2, String str, r rVar) {
        int i3 = rVar.i();
        if (rVar.i() == a.aT && i3 >= 22) {
            rVar.d(10);
            int d2 = rVar.d();
            if (d2 > 0) {
                String valueOf = String.valueOf(d2);
                int d3 = rVar.d();
                if (d3 > 0) {
                    valueOf = valueOf + "/" + d3;
                }
                return new TextInformationFrame(str, (String) null, valueOf);
            }
        }
        new StringBuilder("Failed to parse index/count attribute: ").append(a.c(i2));
        l.c();
        return null;
    }

    private static int b(r rVar) {
        rVar.d(4);
        if (rVar.i() == a.aT) {
            rVar.d(8);
            return rVar.c();
        }
        l.c();
        return -1;
    }

    public static Metadata.Entry a(r rVar) {
        ApicFrame apicFrame;
        TextInformationFrame textInformationFrame;
        int i2 = rVar.f32567b + rVar.i();
        int i3 = rVar.i();
        int i4 = (i3 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID;
        CommentFrame commentFrame = null;
        if (i4 == 169 || i4 == 253) {
            int i5 = 16777215 & i3;
            if (i5 == f32233c) {
                int i6 = rVar.i();
                if (rVar.i() == a.aT) {
                    rVar.d(8);
                    String f2 = rVar.f(i6 - 16);
                    commentFrame = new CommentFrame("und", f2, f2);
                } else {
                    new StringBuilder("Failed to parse comment attribute: ").append(a.c(i3));
                    l.c();
                }
                rVar.c(i2);
                return commentFrame;
            }
            if (i5 != f32231a) {
                if (i5 != f32232b) {
                    if (i5 != f32238h) {
                        if (i5 != f32239i) {
                            if (i5 == f32234d) {
                                TextInformationFrame a2 = a(i3, "TDRC", rVar);
                                rVar.c(i2);
                                return a2;
                            } else if (i5 == f32235e) {
                                TextInformationFrame a3 = a(i3, "TPE1", rVar);
                                rVar.c(i2);
                                return a3;
                            } else if (i5 == f32236f) {
                                TextInformationFrame a4 = a(i3, "TSSE", rVar);
                                rVar.c(i2);
                                return a4;
                            } else if (i5 == f32237g) {
                                TextInformationFrame a5 = a(i3, "TALB", rVar);
                                rVar.c(i2);
                                return a5;
                            } else if (i5 == j) {
                                TextInformationFrame a6 = a(i3, "USLT", rVar);
                                rVar.c(i2);
                                return a6;
                            } else if (i5 == k) {
                                TextInformationFrame a7 = a(i3, "TCON", rVar);
                                rVar.c(i2);
                                return a7;
                            } else if (i5 == n) {
                                TextInformationFrame a8 = a(i3, "TIT1", rVar);
                                rVar.c(i2);
                                return a8;
                            }
                        }
                    }
                    TextInformationFrame a9 = a(i3, "TCOM", rVar);
                    rVar.c(i2);
                    return a9;
                }
            }
            TextInformationFrame a10 = a(i3, "TIT2", rVar);
            rVar.c(i2);
            return a10;
        }
        try {
            if (i3 == m) {
                int b2 = b(rVar);
                String str = (b2 <= 0 || b2 > D.length) ? null : D[b2 - 1];
                if (str != null) {
                    textInformationFrame = new TextInformationFrame("TCON", (String) null, str);
                } else {
                    l.c();
                    textInformationFrame = null;
                }
                return textInformationFrame;
            } else if (i3 == o) {
                TextInformationFrame b3 = b(i3, "TPOS", rVar);
                rVar.c(i2);
                return b3;
            } else if (i3 == p) {
                TextInformationFrame b4 = b(i3, "TRCK", rVar);
                rVar.c(i2);
                return b4;
            } else if (i3 == q) {
                Id3Frame a11 = a(i3, "TBPM", rVar, true, false);
                rVar.c(i2);
                return a11;
            } else if (i3 == r) {
                Id3Frame a12 = a(i3, "TCMP", rVar, true, true);
                rVar.c(i2);
                return a12;
            } else if (i3 == l) {
                int i7 = rVar.i();
                if (rVar.i() == a.aT) {
                    int b5 = a.b(rVar.i());
                    String str2 = b5 == 13 ? "image/jpeg" : b5 == 14 ? "image/png" : null;
                    if (str2 == null) {
                        "Unrecognized cover art flags: ".concat(String.valueOf(b5));
                    } else {
                        rVar.d(4);
                        byte[] bArr = new byte[(i7 - 16)];
                        rVar.a(bArr, 0, bArr.length);
                        apicFrame = new ApicFrame(str2, (String) null, 3, bArr);
                        rVar.c(i2);
                        return apicFrame;
                    }
                }
                l.c();
                apicFrame = null;
                rVar.c(i2);
                return apicFrame;
            } else if (i3 == s) {
                TextInformationFrame a13 = a(i3, "TPE2", rVar);
                rVar.c(i2);
                return a13;
            } else if (i3 == t) {
                TextInformationFrame a14 = a(i3, "TSOT", rVar);
                rVar.c(i2);
                return a14;
            } else if (i3 == u) {
                TextInformationFrame a15 = a(i3, "TSO2", rVar);
                rVar.c(i2);
                return a15;
            } else if (i3 == v) {
                TextInformationFrame a16 = a(i3, "TSOA", rVar);
                rVar.c(i2);
                return a16;
            } else if (i3 == w) {
                TextInformationFrame a17 = a(i3, "TSOP", rVar);
                rVar.c(i2);
                return a17;
            } else if (i3 == x) {
                TextInformationFrame a18 = a(i3, "TSOC", rVar);
                rVar.c(i2);
                return a18;
            } else if (i3 == y) {
                Id3Frame a19 = a(i3, "ITUNESADVISORY", rVar, false, false);
                rVar.c(i2);
                return a19;
            } else if (i3 == z) {
                Id3Frame a20 = a(i3, "ITUNESGAPLESS", rVar, false, true);
                rVar.c(i2);
                return a20;
            } else if (i3 == A) {
                TextInformationFrame a21 = a(i3, "TVSHOWSORT", rVar);
                rVar.c(i2);
                return a21;
            } else if (i3 == B) {
                TextInformationFrame a22 = a(i3, "TVSHOW", rVar);
                rVar.c(i2);
                return a22;
            } else if (i3 == C) {
                Id3Frame a23 = a(rVar, i2);
                rVar.c(i2);
                return a23;
            }
        } finally {
            rVar.c(i2);
        }
        new StringBuilder("Skipped unknown metadata entry: ").append(a.c(i3));
        l.a();
        rVar.c(i2);
        return null;
    }

    public static MdtaMetadataEntry a(r rVar, int i2, String str) {
        while (true) {
            int i3 = rVar.f32567b;
            if (i3 >= i2) {
                return null;
            }
            int i4 = rVar.i();
            if (rVar.i() == a.aT) {
                int i5 = rVar.i();
                int i6 = rVar.i();
                int i7 = i4 - 16;
                byte[] bArr = new byte[i7];
                rVar.a(bArr, 0, i7);
                return new MdtaMetadataEntry(str, bArr, i6, i5);
            }
            rVar.c(i3 + i4);
        }
    }

    private static Id3Frame a(r rVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (rVar.f32567b < i2) {
            int i5 = rVar.f32567b;
            int i6 = rVar.i();
            int i7 = rVar.i();
            rVar.d(4);
            if (i7 == a.aR) {
                str = rVar.f(i6 - 12);
            } else if (i7 == a.aS) {
                str2 = rVar.f(i6 - 12);
            } else {
                if (i7 == a.aT) {
                    i3 = i5;
                    i4 = i6;
                }
                rVar.d(i6 - 12);
            }
        }
        if (str == null || str2 == null || i3 == -1) {
            return null;
        }
        rVar.c(i3);
        rVar.d(16);
        return new InternalFrame(str, str2, rVar.f(i4 - 16));
    }
}
