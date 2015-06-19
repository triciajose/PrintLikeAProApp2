package com.example.apps4kids.printlikeaproapp;

import android.graphics.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by peter on 15-06-13.
 */
public class ConstantCharacter {
    public static final int cSizeX = 400;
    public static final int cSizeY = 400;
    public static final float cStartX = cSizeX/2;
    public static final float cStartY = cSizeY-100;
    public static float upSolidY = cStartY - 600;
    public static float bottomSolidY = cStartY + 300;
    public static float dotY = (upSolidY+bottomSolidY)/2;
    public static float solidLineWidth = 20;

    public static final float POINT_OFFSET_X = 0;
    public static final float POINT_OFFSET_Y = 0;
    public static final double THRESHOLD = 10000;
    public static final int STROKE_POINT_THRESHOLD = 1;


    /*
    Data of char a;
     */
    int[][] a1 = new int[][]{
            {210, 140},
            {195, 128},
            {164, 114},
            {126, 108},
            {96, 110},
            {71, 124},
            {58, 141},
            {45, 171},
            {43, 200},
            {49, 227},
            {53, 251},
            {72, 276},
            {95, 290},
            {127, 293},
            {161, 286},
            {189, 268},
            {199, 256}
    };

    int[][] a2=new int[][]{
            {235, 94},
            {227, 119},
            {223, 184},
            {224, 239},
            {229, 279},
            {229, 290}
    };

    StrokeDirection[] aDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.DOWN
    };

    ArrayList<int[][]> aPoints = new ArrayList<int[][]>(){{
        add(a1);
        add(a2);
    }};



    /*
    Data of char b;
     */
    int[][] b1 = new int[][]{
            {49, 26},
            {44, 57},
            {45, 116},
            {45, 174},
            {50, 248},
            {53, 278},
            {53, 286}
    };

    int[][] b2=new int[][]{
            {70, 152},
            {94, 128},
            {114, 115},
            {143, 108},
            {166, 108},
            {192, 124},
            {204, 140},
            {217, 163},
            {224, 186},
            {224, 208},
            {217, 228},
            {198, 252},
            {183, 265},
            {160, 275},
            {129, 279},
            {104, 265},
            {82, 244},
            {72, 231},
            {72, 231}
    };

    StrokeDirection[] bDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> bPoints = new ArrayList<int[][]>(){{
        add(b1);
        add(b2);
    }};



    /*
    Data of char c;
     */
    int[][] c1 = new int[][]{
            {210, 132},
            {196, 118},
            {175, 108},
            {156, 102},
            {136, 101},
            {110, 101},
            {92, 110},
            {77, 119},
            {64, 136},
            {50, 150},
            {42, 170},
            {37, 198},
            {37, 221},
            {44, 240},
            {64, 259},
            {83, 272},
            {104, 279},
            {144, 290},
            {172, 290},
            {199, 281},
            {214, 270},
            {220, 264}
    };



    StrokeDirection[] cDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK,
    };

    ArrayList<int[][]> cPoints = new ArrayList<int[][]>(){{
        add(c1);
    }};



    /*
    Data of char d;
     */
    int[][] d1 = new int[][]{
            {229, 156},
            {205, 136},
            {181, 120},
            {152, 107},
            {121, 107},
            {100, 109},
            {77, 118},
            {60, 137},
            {45, 162},
            {37, 187},
            {35, 214},
            {37, 235},
            {49, 260},
            {64, 277},
            {95, 293},
            {127, 294},
            {157, 289},
            {194, 271},
            {216, 254},
            {230, 243},
            {230, 243}
    };

    int[][] d2=new int[][]{
            {237, 50},
            {233, 112},
            {229, 203},
            {231, 261},
            {229, 283},
            {229, 290}
    };

    StrokeDirection[] dDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.DOWN
    };

    ArrayList<int[][]> dPoints = new ArrayList<int[][]>(){{
        add(d1);
        add(d2);
    }};



    /*
    Data of char e;
     */
    int[][] e1 = new int[][]{
            {88, 187},
            {118, 189},
            {143, 189},
            {170, 190},
            {195, 193},
            {214, 191},
            {232, 189},
            {234, 177},
            {226, 156},
            {212, 138},
            {192, 124},
            {172, 108},
            {154, 100},
            {139, 98},
            {114, 100},
            {92, 101},
            {66, 116},
            {46, 133},
            {33, 166},
            {31, 191},
            {30, 219},
            {36, 251},
            {45, 266},
            {67, 280},
            {96, 295},
            {124, 302},
            {155, 296},
            {192, 271},
            {208, 251},
            {217, 242}
    };

    StrokeDirection[] eDirections = new StrokeDirection[]{
            StrokeDirection.RIGHT,
    };

    ArrayList<int[][]> ePoints = new ArrayList<int[][]>(){{
        add(e1);
    }};


    /*
    Data of char f;
     */
    int[][] f1 = new int[][]{
            {119, 27},
            {106, 20},
            {86, 20},
            {72, 24},
            {68, 48},
            {64, 86},
            {64, 124},
            {62, 170},
            {60, 224},
            {59, 265},
            {59, 281},
            {58, 291}
    };

    int[][] f2=new int[][]{
            {28, 103},
            {52, 108},
            {66, 108},
            {94, 109},
            {107, 106}
    };

    StrokeDirection[] fDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> fPoints = new ArrayList<int[][]>(){{
        add(f1);
        add(f2);
    }};



    /*
    Data of char a;
     */
    int[][] g1 = new int[][]{
            {236, 158},
            {215, 143},
            {200, 130},
            {175, 111},
            {128, 101},
            {89, 105},
            {63, 123},
            {42, 143},
            {34, 167},
            {36, 198},
            {42, 228},
            {53, 254},
            {72, 274},
            {103, 290},
            {144, 290},
            {181, 272},
            {217, 241},
            {227, 232}
    };

    int[][] g2=new int[][]{
            {236, 100},
            {229, 141},
            {224, 178},
            {222, 236},
            {221, 273},
            {222, 306},
            {213, 330},
            {192, 355},
            {155, 363},
            {111, 364},
            {70, 354},
            {49, 324},
            {42, 315}
    };

    StrokeDirection[] gDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.DOWN
    };

    ArrayList<int[][]> gPoints = new ArrayList<int[][]>(){{
        add(g1);
        add(g2);
    }};


    /*
    Data of char h;
     */
    int[][] h1 = new int[][]{
            {53, 50},
            {48, 118},
            {46, 185},
            {50, 248},
            {49, 268},
            {50, 278}
    };

    int[][] h2=new int[][]{
            {70, 159},
            {77, 135},
            {104, 113},
            {133, 105},
            {154, 103},
            {181, 116},
            {190, 143},
            {194, 200},
            {196, 241},
            {196, 270},
            {197, 270}
    };

    StrokeDirection[] hDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> hPoints = new ArrayList<int[][]>(){{
        add(h1);
        add(h2);
    }};


    /*
    Data of char i;
     */
    int[][] i1 = new int[][]{
            {48, 29},
            {45, 30}
    };

    int[][] i2=new int[][]{
            {44, 108},
            {45, 124},
            {42, 160},
            {37, 200},
            {37, 256},
            {35, 276},
            {34, 282}
    };

    StrokeDirection[] iDirections = new StrokeDirection[]{
            StrokeDirection.NOWHERE, StrokeDirection.DOWN
    };

    ArrayList<int[][]> iPoints = new ArrayList<int[][]>(){{
        add(i1);
        add(i2);
    }};


    /*
    Data of char j;
     */
    int[][] j1 = new int[][]{
            {46, 37},
            {45, 36}
    };

    int[][] j2=new int[][]{
            {31, 105},
            {34, 129},
            {34, 165},
            {35, 194},
            {32, 231},
            {30, 268},
            {32, 294},
            {32, 319},
            {34, 344},
            {33, 362},
            {23, 372},
            {3, 367},
            {0, 352}
    };

    StrokeDirection[] jDirections = new StrokeDirection[]{
            StrokeDirection.NOWHERE, StrokeDirection.DOWN
    };

    ArrayList<int[][]> jPoints = new ArrayList<int[][]>(){{
        add(j1);
        add(j2);
    }};


    /*
    Data of char k;
     */
    int[][] k1 = new int[][]{
            {56, 11},
            {47, 75},
            {47, 167},
            {46, 253},
            {46, 276},
            {44, 288},
            {45, 291}
    };

    int[][] k2=new int[][]{
            {173, 102},
            {110, 140},
            {79, 163},
            {67, 176},
            {63, 185},
            {100, 233},
            {140, 268},
            {166, 285},
            {172, 288}
    };

    StrokeDirection[] kDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_BACK, StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> kPoints = new ArrayList<int[][]>(){{
        add(k1);
        add(k2);
    }};


    /*
    Data of char l;
     */
    int[][] l1 = new int[][]{
            {55, 8},
            {51, 91},
            {51, 194},
            {52, 276},
            {53, 300},
            {55, 300}
    };

    StrokeDirection[] lDirections = new StrokeDirection[]{
            StrokeDirection.DOWN
    };

    ArrayList<int[][]> lPoints = new ArrayList<int[][]>(){{
        add(l1);
    }};


    /*
    Data of char m;
     */
    int[][] m1 = new int[][]{
            {54, 126},
            {49, 208},
            {50, 266},
            {48, 283},
            {47, 283}
    };

    int[][] m2=new int[][]{
            {68, 152},
            {89, 127},
            {134, 102},
            {163, 104},
            {181, 135},
            {184, 180},
            {187, 232},
            {186, 270},
            {186, 280},
            {201, 228},
            {215, 179},
            {231, 137},
            {259, 103},
            {291, 95},
            {315, 109},
            {325, 156},
            {330, 228},
            {335, 272},
            {336, 288},
            {336, 290}
    };

    StrokeDirection[] mDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> mPoints = new ArrayList<int[][]>(){{
        add(m1);
        add(m2);
    }};


    /*
    Data of char n;
     */
    int[][] n1 = new int[][]{
            {57, 92},
            {57, 95},
            {52, 173},
            {53, 240},
            {53, 272},
            {53, 283}
    };

    int[][] n2=new int[][]{
            {72, 150},
            {71, 150},
            {92, 114},
            {125, 101},
            {160, 100},
            {186, 126},
            {198, 174},
            {201, 224},
            {201, 268},
            {202, 286},
            {202, 292}
    };

    StrokeDirection[] nDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> nPoints = new ArrayList<int[][]>(){{
        add(n1);
        add(n2);
    }};

    /*
    Data of char o;
     */
    int[][] o1 = new int[][]{
            {220, 140},
            {174, 101},
            {105, 93},
            {59, 119},
            {33, 164},
            {32, 209},
            {46, 249},
            {81, 271},
            {135, 276},
            {184, 262},
            {221, 215},
            {238, 170},
            {242, 169}
    };

    StrokeDirection[] oDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK
    };

    ArrayList<int[][]> oPoints = new ArrayList<int[][]>(){{
        add(o1);
    }};


    /*
   Data of char p;
    */
    int[][] p1 = new int[][]{
            {44, 93},
            {46, 109},
            {43, 160},
            {41, 210},
            {39, 264},
            {41, 321},
            {42, 355},
            {44, 373},
            {44, 377}
    };

    int[][] p2 = new int[][]{
            {69, 152},
            {68, 143},
            {94, 128},
            {115, 113},
            {148, 102},
            {175, 101},
            {202, 114},
            {224, 138},
            {233, 175},
            {234, 205},
            {231, 232},
            {211, 256},
            {179, 275},
            {150, 286},
            {114, 286},
            {74, 260},
            {64, 237},
            {61, 227}
    };

    StrokeDirection[] pDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> pPoints = new ArrayList<int[][]>(){{
        add(p1);
        add(p2);
    }};


    /*
   Data of char o;
    */
    int[][] q1 = new int[][]{
            {236, 157},
            {235, 156},
            {212, 128},
            {184, 111},
            {141, 103},
            {91, 104},
            {58, 123},
            {35, 155},
            {27, 185},
            {30, 229},
            {51, 266},
            {75, 288},
            {126, 293},
            {172, 270},
            {205, 245},
            {215, 238}
    };

    int[][] q2 = new int[][]{
            {237, 95},
            {235, 96},
            {229, 145},
            {226, 217},
            {226, 300},
            {232, 343},
            {234, 363},
            {234, 363}
    };

    StrokeDirection[] qDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.DOWN
    };

    ArrayList<int[][]> qPoints = new ArrayList<int[][]>(){{
        add(q1);
        add(q2);
    }};


    /*
   Data of char r;
    */
    int[][] r1 = new int[][]{
            {44, 91},
            {40, 114},
            {38, 169},
            {44, 241},
            {45, 284},
            {41, 300},
            {43, 302}
    };
    int[][] r2 = new int[][]{
            {58, 287},
            {55, 278},
            {52, 215},
            {64, 139},
            {102, 95},
            {126, 89},
            {128, 88}
    };

    StrokeDirection[] rDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> rPoints = new ArrayList<int[][]>(){{
        add(r1);
        add(r2);
    }};

    /*
   Data of char s;
    */
    int[][] s1 = new int[][]{
            {135, 125},
            {134, 124},
            {114, 110},
            {92, 105},
            {71, 104},
            {52, 108},
            {40, 127},
            {36, 148},
            {50, 171},
            {82, 191},
            {105, 215},
            {112, 236},
            {113, 264},
            {94, 286},
            {67, 286},
            {44, 280},
            {30, 272},
            {26, 269}
    };

    StrokeDirection[] sDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK
    };

    ArrayList<int[][]> sPoints = new ArrayList<int[][]>(){{
        add(s1);
    }};

    /*
   Data of char t;
    */
    int[][] t1 = new int[][]{
            {32, 103},
            {25, 102},
            {76, 105},
            {109, 103},
            {126, 104},
            {130, 103}
    };

    int[][] t2 = new int[][]{
            {67, 19},
            {65, 20},
            {65, 114},
            {66, 205},
            {66, 261},
            {66, 276},
            {66, 277}
    };
    StrokeDirection[] tDirections = new StrokeDirection[]{
            StrokeDirection.RIGHT, StrokeDirection.DOWN
    };

    ArrayList<int[][]> tPoints = new ArrayList<int[][]>(){{
        add(t1);
        add(t2);
    }};

    /*
   Data of char u;
    */
    int[][] u1 = new int[][]{
            {54, 87},
            {53, 87},
            {53, 118},
            {52, 152},
            {52, 180},
            {52, 212},
            {52, 238},
            {56, 256},
            {63, 270},
            {80, 282},
            {101, 285},
            {123, 286},
            {153, 281},
            {176, 269},
            {191, 241},
            {195, 210},
            {198, 171},
            {198, 136},
            {198, 103},
            {195, 87}
    };



    StrokeDirection[] uDirections = new StrokeDirection[]{
            StrokeDirection.DOWN
    };

    ArrayList<int[][]> uPoints = new ArrayList<int[][]>(){{
        add(u1);
    }};

    /*
   Data of char v;
    */
    int[][] v1 = new int[][]{
            {27, 95},
            {27, 95},
            {42, 135},
            {73, 207},
            {107, 261},
            {116, 269},
            {181, 162},
            {209, 96},
            {213, 89}
    };



    StrokeDirection[] vDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> vPoints = new ArrayList<int[][]>(){{
        add(v1);
    }};


    /*
   Data of char w;
    */
    int[][] w1 = new int[][]{
            {28, 98},
            {29, 100},
            {52, 152},
            {76, 209},
            {96, 253},
            {111, 245},
            {154, 152},
            {174, 100},
            {175, 95},
            {190, 164},
            {214, 222},
            {230, 254},
            {238, 257},
            {287, 160},
            {319, 108},
            {324, 97}
    };





    StrokeDirection[] wDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> wPoints = new ArrayList<int[][]>(){{
        add(w1);
    }};

    /*
   Data of char x;
    */
    int[][] x1 = new int[][]{
            {39, 94},
            {39, 94},
            {57, 128},
            {111, 204},
            {156, 271},
            {166, 286},
            {170, 288}
    };

    int[][] x2 = new int[][]{
            {178, 96},
            {175, 96},
            {138, 136},
            {71, 219},
            {44, 265},
            {30, 280},
            {30, 280}
    };



    StrokeDirection[] xDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_BACK
    };

    ArrayList<int[][]> xPoints = new ArrayList<int[][]>(){{
        add(x1);
        add(x2);
    }};
    /*
   Data of char y;
    */
    int[][] y1 = new int[][]{
            {20, 104},
            {19, 104},
            {55, 173},
            {102, 254},
            {110, 275},
            {111, 280}
    };

    int[][] y2 = new int[][]{
            {196, 107},
            {196, 107},
            {172, 143},
            {149, 192},
            {127, 242},
            {104, 300},
            {86, 339},
            {72, 359},
            {70, 362}
    };


    StrokeDirection[] yDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_BACK
    };

    ArrayList<int[][]> yPoints = new ArrayList<int[][]>(){{
        add(y1);
        add(y2);
    }};

    /*
   Data of char z;
    */
    int[][] z1 = new int[][]{
            {32, 105},
            {37, 107},
            {105, 112},
            {141, 108},
            {147, 118},
            {72, 212},
            {42, 263},
            {28, 284},
            {61, 294},
            {110, 293},
            {144, 292},
            {164, 293},
            {166, 292}
    };






    StrokeDirection[] zDirections = new StrokeDirection[]{
            StrokeDirection.LEFT
    };

    ArrayList<int[][]> zPoints = new ArrayList<int[][]>(){{
        add(z1);
    }};

    public static ArrayList<StrokePath> PATH_A = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_B = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_C = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_D = new ArrayList<>();
    public static  ArrayList<StrokePath> PATH_E = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_F = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_G = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_H = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_I = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_J = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_K = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_L = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_M = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_N = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_O = new ArrayList<>();
    public static  ArrayList<StrokePath> PATH_P = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_Q = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_R = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_S = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_T = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_U = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_V = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_W = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_X = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_Y = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_Z = new ArrayList<>();


    public static ArrayList<StrokePath> PATH_a = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_b = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_c = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_d = new ArrayList<>();
    public static  ArrayList<StrokePath> PATH_e = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_f = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_g = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_h = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_i = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_j = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_k = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_l = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_m = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_n = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_o = new ArrayList<>();
    public static  ArrayList<StrokePath> PATH_p = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_q = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_r = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_s = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_t = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_u = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_v = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_w = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_x = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_y = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_z = new ArrayList<>();


    public static HashMap<String, ArrayList<StrokePath>> map = new HashMap<>();




    public ArrayList<StrokePath> addPath(StrokeDirection[] strokeDirections, ArrayList<int[][]> points) {
        ArrayList<StrokePath> paths = new ArrayList<>();
        for(int i=0; i<points.size(); i++){
            StrokePath strokePath = new StrokePath();
            for(int j=0; j<points.get(i).length; j++) {
                strokePath.points.add(new Point(points.get(i)[j][0], points.get(i)[j][1]));
            }
            if(i<strokeDirections.length) {
                strokePath.direction = strokeDirections[i];
            }
            paths.add(strokePath);
        }
        return paths;
    }






    public ConstantCharacter() {
        PATH_a=addPath(aDirections, aPoints);
        PATH_b=addPath(bDirections, bPoints);
        PATH_c=addPath(cDirections, cPoints);
        PATH_d=addPath(dDirections, dPoints);
        PATH_e=addPath(eDirections, ePoints);
        PATH_f=addPath(fDirections, fPoints);
        PATH_g=addPath(gDirections, gPoints);
        PATH_h=addPath(hDirections, hPoints);
        PATH_i=addPath(iDirections, iPoints);
        PATH_j=addPath(jDirections, jPoints);
        PATH_k=addPath(kDirections, kPoints);
        PATH_l=addPath(lDirections, lPoints);
        PATH_m=addPath(mDirections, mPoints);
        PATH_n=addPath(nDirections, nPoints);
        PATH_o=addPath(oDirections, oPoints);
        PATH_p=addPath(pDirections, pPoints);
        PATH_q=addPath(qDirections, qPoints);
        PATH_r=addPath(rDirections, rPoints);
        PATH_s=addPath(sDirections, sPoints);
        PATH_t=addPath(tDirections, tPoints);
        PATH_u=addPath(uDirections, uPoints);
        PATH_v=addPath(vDirections, vPoints);
        PATH_w=addPath(wDirections, wPoints);
        PATH_x=addPath(xDirections, xPoints);
        PATH_y=addPath(yDirections, yPoints);
        PATH_z=addPath(zDirections, zPoints);
        map.put("a", PATH_a);
        map.put("b", PATH_b);
        map.put("c", PATH_c);
        map.put("d", PATH_d);
        map.put("e", PATH_e);
        map.put("f", PATH_f);
        map.put("g", PATH_g);
        map.put("h", PATH_h);
        map.put("i", PATH_i);
        map.put("j", PATH_j);
        map.put("k", PATH_k);
        map.put("l", PATH_l);
        map.put("m", PATH_m);
        map.put("n", PATH_n);
        map.put("o", PATH_o);
        map.put("p", PATH_p);
        map.put("q", PATH_q);
        map.put("r", PATH_r);
        map.put("s", PATH_s);
        map.put("t", PATH_t);
        map.put("u", PATH_u);
        map.put("v", PATH_v);
        map.put("w", PATH_w);
        map.put("x", PATH_x);
        map.put("y", PATH_y);
        map.put("z", PATH_z);
        map.put("A", PATH_A);
        map.put("B", PATH_B);
        map.put("C", PATH_C);
        map.put("D", PATH_D);
        map.put("E", PATH_E);
        map.put("F", PATH_F);
        map.put("G", PATH_G);
        map.put("H", PATH_H);
        map.put("I", PATH_I);
        map.put("J", PATH_J);
        map.put("K", PATH_K);
        map.put("L", PATH_L);
        map.put("M", PATH_M);
        map.put("N", PATH_N);
        map.put("O", PATH_O);
        map.put("P", PATH_P);
        map.put("Q", PATH_Q);
        map.put("R", PATH_R);
        map.put("S", PATH_S);
        map.put("T", PATH_T);
        map.put("U", PATH_U);
        map.put("V", PATH_V);
        map.put("W", PATH_W);
        map.put("X", PATH_X);
        map.put("Y", PATH_Y);
        map.put("Z", PATH_Z);
    }
}