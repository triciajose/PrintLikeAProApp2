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
    public static double THRESHOLD = 10000;
    public static double STROKE_POINT_THRESHOLD = 0.7;


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
    };
    int[][] e2 = new int[][]{
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
            StrokeDirection.RIGHT, StrokeDirection.CURVE_BACK
    };

    ArrayList<int[][]> ePoints = new ArrayList<int[][]>(){{
        add(e1);
        add(e2);
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
            {44, 108},
            {45, 124},
            {42, 160},
            {37, 200},
            {37, 256},
            {35, 276},
            {34, 282}
    };

    int[][] i2=new int[][]{
            {48, 29},
            {45, 30}

    };

    StrokeDirection[] iDirections = new StrokeDirection[]{
             StrokeDirection.DOWN, StrokeDirection.NOWHERE
    };

    ArrayList<int[][]> iPoints = new ArrayList<int[][]>(){{
        add(i1);
        add(i2);
    }};


    /*
    Data of char j;
     */
    int[][] j1 = new int[][]{
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

    int[][] j2=new int[][]{
            {46, 37},
            {45, 36}
    };

    StrokeDirection[] jDirections = new StrokeDirection[]{
             StrokeDirection.DOWN, StrokeDirection.NOWHERE
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

    };
    int[][] k3=new int[][]{
            {63, 185},
            {100, 233},
            {140, 268},
            {166, 285},
            {172, 288}
    };


    StrokeDirection[] kDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.SLIDE_BACK, StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> kPoints = new ArrayList<int[][]>(){{
        add(k1);
        add(k2);
        add(k3);
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
    };

    int[][] m3=new int[][]{
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
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> mPoints = new ArrayList<int[][]>(){{
        add(m1);
        add(m2);
        add(m3);
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
            {44, 377},
            {44, 373},
            {42, 355},
            {41, 321},
            {39, 264},
            {41, 210},
            {43, 160},
            {46, 109},
            {44, 93},
    };

    int[][] p3 = new int[][]{
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
            StrokeDirection.DOWN, StrokeDirection.UP, StrokeDirection.CURVE_FORWARD,
    };

    ArrayList<int[][]> pPoints = new ArrayList<int[][]>(){{
        add(p1);
        add(p2);
        add(p3);
    }};


    /*
   Data of char q;
    */
    int[][] q1 = new int[][]{
            {158, 147},
            {156, 148},
            {116, 140},
            {73, 151},
            {44, 177},
            {24, 221},
            {20, 265},
            {41, 292},
            {82, 287},
            {135, 232},
            {179, 158},
            {182, 155}
    };

    int[][] q2 = new int[][]{
            {160, 141},
            {159, 142},
            {160, 199},
            {160, 278},
            {159, 342},
            {159, 382},
            {157, 388}
    };

    int[][] q3 = new int[][]{
            {155, 403},
            {170, 393},
            {191, 380},
            {218, 356},
            {222, 354}
    };

    StrokeDirection[] qDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.DOWN, StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> qPoints = new ArrayList<int[][]>(){{
        add(q1);
        add(q2);
        add(q3);
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
            {67, 19},
            {65, 20},
            {65, 114},
            {66, 205},
            {66, 261},
            {66, 276},
            {66, 277}

    };
    

    int[][] t2 = new int[][]{
            {32, 103},
            {25, 102},
            {76, 105},
            {109, 103},
            {126, 104},
            {130, 103}
    };

    StrokeDirection[] tDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> tPoints = new ArrayList<int[][]>(){{
        add(t1);
        add(t2);
    }};

    /*
   Data of char u;
    */
    int[][] u1 = new int[][]{
            {46, 114},
            {45, 114},
            {45, 144},
            {42, 183},
            {44, 219},
            {46, 248},
            {50, 276},
            {61, 292},
            {86, 299},
            {111, 296},
            {132, 285},
            {145, 270},
            {151, 257},
            {152, 256}
    };
    int[][] u2 = new int[][]{
            {165, 125},
            {160, 144},
            {159, 187},
            {158, 233},
            {157, 274},
            {158, 294},
            {159, 302}
    };



    StrokeDirection[] uDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.DOWN
    };

    ArrayList<int[][]> uPoints = new ArrayList<int[][]>(){{
        add(u1);
        add(u2);
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

    };
    int[][] v2 = new int [][]{
            {116, 269},
            {160,207},
            {181, 162},
            {209, 96},
            {213, 89}
    };



    StrokeDirection[] vDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_UP
    };

    ArrayList<int[][]> vPoints = new ArrayList<int[][]>(){{
        add(v1);
        add(v2);
    }};


    /*
   Data of char w;
    */
    int[][] w1 = new int[][]{
            {28, 98},
            {29, 100},
            {52, 152},
            {76, 209},
            {96, 253}
    };
    int[][] w2 = new int[][]{
            {96, 253},
            {111, 245},
            {140, 200},
            {154, 152},
            {174, 100},
            {175, 95}
    };
    int[][] w3 = new int[][]{
            {175, 95},
            {190, 164},
            {214, 222},
            {230, 254}
    };
    int[][]w4 = new int[][]{
            {238, 257},
            {255, 200},
            {287, 160},
            {319, 108},
            {324, 97}
    };





    StrokeDirection[] wDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_UP, StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_UP

    };

    ArrayList<int[][]> wPoints = new ArrayList<int[][]>(){{
        add(w1);
        add(w2);
        add(w3);
        add(w4);
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

    };
    int [][]z2 = new int [][]{
            {147, 118},
            {100, 170},
            {72, 212},
            {55,240},
            {42, 263},
            {28, 284},
            {20, 294},
    };
    int[][] z3 = new int[][]{
            {61, 294},
            {110, 293},
            {144, 292},
            {164, 293},
            {166, 292}
    };
    StrokeDirection[] zDirections = new StrokeDirection[]{
            StrokeDirection.RIGHT, StrokeDirection.SLIDE_BACK, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> zPoints = new ArrayList<int[][]>(){{
        add(z1);
        add(z2);
        add(z3);
    }};

       /*
    Data of char A;
    */

    int [][] A1 = new int[][] {
            {164, -1},
            {153, 7},
            {147, 24},
            {140, 51},
            {123, 88},
            {87, 151},
            {51, 229},
            {21, 272}

    };

    int [][] A2 = new int[][] {
            {174, 21},
            {195, 54},
            {220, 112},
            {237, 166},
            {249, 213},
            {262, 247},
            {271, 269},
            {283, 276}
    };

    int [][] A3 = new int[][] {
            {103, 176},
            {118, 180},
            {152, 180},
            {187, 180},
            {224, 181},
            {246, 183}
    };

    StrokeDirection[] ADirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_BACK, StrokeDirection.SLIDE_FORWARD, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> APoints = new ArrayList<int[][]>(){{
        add(A1);
        add(A2);
        add(A3);
    }};

    /*
    Data of char B;
    */

    int [][] B1 = new int[][] {
            {56, 23},
            {60, 69},
            {57, 119},
            {53, 169},
            {54, 220},
            {56, 267},
            {55, 281}
    };

    int [][] B2 = new int [][] {
            {56, 21},
            {112, 24},
            {158, 51},
            {166, 97},
            {119, 133},
            {77, 147}
    };

    int [][] B3 = new int [][] {
            {88, 148},
            {136, 151},
            {185, 169},
            {196, 223},
            {153, 269},
            {98, 281},
            {83, 282}
    };

    StrokeDirection[] BDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> BPoints = new ArrayList<int[][]>(){{
        add(B1);
        add(B2);
        add(B3);
    }};

    /*
    Data of char C;
    */
    int [][] C1 = new int [][] {
            {302, 67},
            {251, 32},
            {203, 17},
            {150, 16},
            {97, 44},
            {60, 93},
            {50, 153},
            {62, 215},
            {92, 263},
            {151, 287},
            {207, 285},
            {271, 258},
            {282, 251}
    };

    StrokeDirection[] CDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK
    };

    ArrayList<int[][]> CPoints = new ArrayList<int[][]>(){{
        add(C1);
    }};

    /*
    Data of char D;
    */
    int [][] D1 = new int [][] {
            {65, 22},
            {61, 105},
            {55, 202},
            {56, 264},
            {56, 273}
    };

    int [][] D2 = new int [][] {
            {48, 21},
            {106, 17},
            {165, 29},
            {223, 58},
            {262, 103},
            {271, 162},
            {246, 223},
            {181, 272},
            {110, 284},
            {58, 284}
    };

    StrokeDirection[] DDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> DPoints = new ArrayList<int[][]>(){{
        add(D1);
        add(D2);
    }};

    /*
    Data of char E;
    */
    int [][] E1 = new int [][] {
            {64, 16},
            {62, 70},
            {62, 121},
            {62, 185},
            {62, 253},
            {64, 289}
    };

    int [][] E2 = new int [][] {
            {60, 18},
            {70, 19},
            {122, 21},
            {166, 20},
            {202, 20}
    };

    int [][] E3 = new int [][] {
            {57, 140},
            {64, 143},
            {121, 142},
            {178, 142},
            {216, 142}
    };

    int [][] E4 = new int [][] {
            {55, 276},
            {81, 279},
            {128, 278},
            {178, 278},
            {188, 280}
    };

    StrokeDirection[] EDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.RIGHT, StrokeDirection.RIGHT, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> EPoints = new ArrayList<int[][]>(){{
        add(E1);
        add(E2);
        add(E3);
        add(E4);
    }};


    /*
    Data of char F;
    */
    int [][] F1 = new int [][] {
            {59, 19},
            {60, 27},
            {61, 77},
            {58, 144},
            {58, 205},
            {60, 254},
            {61, 289}
    };

    int [][] F2 = new int [][] {
            {56, 17},
            {103, 17},
            {156, 18},
            {169, 18}
    };

    int [][] F3 = new int [][] {
            {89, 139},
            {101, 140},
            {154, 140},
            {176, 140}
    };

    StrokeDirection[] FDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.RIGHT, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> FPoints = new ArrayList<int[][]>(){{
        add(F1);
        add(F2);
        add(F3);
    }};


    /*
    Data of char G;
    */
    int [][] G1 = new int [][] {
            {314, 68},
            {311, 62},
            {249, 24},
            {178, 14},
            {113, 38},
            {61, 85},
            {50, 145},
            {61, 211},
            {93, 262},
            {139, 286},
            {191, 290},
            {241, 278},
            {291, 243},
            {318, 196},
            {323, 174}
    };

    int [] [] G2 = new int [][] {
            {328, 171},
            {281, 168},
            {229, 172},
            {229, 172}
    };

    StrokeDirection[] GDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.LEFT
    };

    ArrayList<int[][]> GPoints = new ArrayList<int[][]>(){{
        add(G1);
        add(G2);
    }};


    /*
    Data of char H;
    */
    int [][] H1 = new int [][] {
            {55, 17},
            {60, 66},
            {60, 125},
            {62, 177},
            {60, 233},
            {58, 280},
            {59, 283}
    };

    int [][] H2 = new int [][] {
            {223, 11},
            {226, 13},
            {233, 62},
            {232, 109},
            {231, 176},
            {231, 227},
            {234, 273},
            {234, 282}
    };

    int [][] H3 = new int [][] {
            {59, 137},
            {100, 141},
            {173, 143},
            {224, 143},
            {228, 142}
    };

    StrokeDirection[] HDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.RIGHT, StrokeDirection.DOWN
    };

    ArrayList<int[][]> HPoints = new ArrayList<int[][]>(){{
        add(H1);
        add(H2);
        add(H3);
    }};


    /*
    Data of char I;
    */
    int [][] I1 = new int [][] {
            {50, 19},
            {51, 78},
            {49, 189},
            {47, 265},
            {48, 279}
    };

    StrokeDirection[] IDirections = new StrokeDirection[]{
            StrokeDirection.DOWN
    };

    ArrayList<int[][]> IPoints = new ArrayList<int[][]>(){{
        add(I1);
    }};


    /*
    Data of char J;
    */
    int [][] J1 = new int [][] {
            {144, 19},
            {151, 77},
            {149, 148},
            {146, 215},
            {133, 275},
            {83, 289},
            {42, 269}
    };

    StrokeDirection[] JDirections = new StrokeDirection[]{
            StrokeDirection.DOWN
    };

    ArrayList<int[][]> JPoints = new ArrayList<int[][]>(){{
        add(J1);
    }};


    /*
    Data of char K;
    */
    int [][] K1 = new int [][] {
            {48, 18},
            {54, 55},
            {54, 107},
            {53, 175},
            {52, 234},
            {50, 284},
            {51, 301}
    };

    int [][] K2 = new int [][] {
            {178, 30},
            {124, 82},
            {81, 117},
            {62, 135}
    };

    int [][] K3 = new int [][] {
            {71, 138},
            {106, 183},
            {149, 225},
            {191, 267},
            {204, 278}
    };

    StrokeDirection[] KDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.SLIDE_BACK, StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> KPoints = new ArrayList<int[][]>(){{
        add(K1);
        add(K2);
        add(K3);
    }};

    /*
    Data of char L;
    */
    int [][] L1 = new int [][] {
            {57, 20},
            {58, 49},
            {53, 119},
            {52, 194},
            {53, 262},
            {51, 291}

    };

    int [][] L2 = new int [][] {
            {60, 276},
            {66, 277},
            {135, 280},
            {177, 281}
    };

    StrokeDirection[] LDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> LPoints = new ArrayList<int[][]>(){{
        add(L1);
        add(L2);
    }};

    /*
    Data of char M;
    */
    int [][] M1 = new int [][] {
            {85, 47},
            {75, 95},
            {60, 146},
            {48, 207},
            {43, 264},
            {41, 288}
    };

    int [][] M2 = new int [][] {
            {92, 64},
            {120, 122},
            {147, 179},
            {171, 226},
            {190, 271},
            {190, 271}
    };

    int [][] M3 = new int [][] {
            {196, 264},
            {224, 216},
            {249, 161},
            {277, 106},
            {307, 56},
            {307, 56}
    };

    int [][] M4 = new int [][] {
            {303, 45},
            {312, 95},
            {317, 145},
            {325, 209},
            {328, 257},
            {331, 277}
    };

    StrokeDirection[] MDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_UP, StrokeDirection.DOWN
    };

    ArrayList<int[][]> MPoints = new ArrayList<int[][]>(){{
        add(M1);
        add(M2);
        add(M3);
        add(M4);
    }};

    /*
    Data of char N;
    */
    int [][] N1 = new int [][] {
            {61, 32},
            {59, 95},
            {61, 170},
            {62, 249},
            {62, 284}
    };

    int [][] N2 = new int [][] {
            {55, 26},
            {65, 43},
            {100, 93},
            {142, 140},
            {184, 185},
            {224, 228},
            {255, 259}

    };

    int [][] N3 = new int [][] {
            {257, 251},
            {259, 230},
            {257, 173},
            {257, 121},
            {258, 66},
            {258, 33}
    };

    StrokeDirection[] NDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.SLIDE_FORWARD, StrokeDirection.UP
    };

    ArrayList<int[][]> NPoints = new ArrayList<int[][]>(){{
        add(N1);
        add(N2);
        add(N3);
    }};

    /*
    Data of char O;
     */
    int[][] O1 = new int[][]{
            {318, 132},
            {319, 131},
            {305, 103},
            {293, 87},
            {276, 70},
            {257, 54},
            {238, 44},
            {205, 32},
            {174, 25},
            {141, 24},
            {104, 38},
            {79, 65},
            {54, 100},
            {41, 136},
            {37, 169},
            {40, 202},
            {59, 233},
            {82, 259},
            {115, 287},
            {144, 303},
            {182, 310},
            {221, 300},
            {255, 270},
            {286, 236},
            {314, 184},
            {320, 155},
            {321, 146}
    };

    StrokeDirection[] ODirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK
    };

    ArrayList<int[][]> OPoints = new ArrayList<int[][]>(){{
        add(O1);
    }};


    /*
   Data of char P;
    */
    int[][] P1 = new int[][]{
            {51, 33},
            {51, 43},
            {53, 100},
            {49, 162},
            {44, 224},
            {46, 262},
            {48, 288},
            {48, 295}
    };

    int[][] P2 = new int[][]{
            {67, 34},
            {66, 34},
            {93, 33},
            {114, 34},
            {139, 32},
            {158, 31},
            {179, 37},
            {196, 53},
            {203, 82},
            {202, 111},
            {181, 135},
            {147, 145},
            {114, 148},
            {78, 149},
            {70, 145}
    };

    StrokeDirection[] PDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD
    };

    ArrayList<int[][]> PPoints = new ArrayList<int[][]>(){{
        add(P1);
        add(P2);
    }};


    /*
   Data of char Q;
    */
    int[][] Q1 = new int[][]{
            {321, 133},
            {321, 131},
            {299, 96},
            {254, 54},
            {222, 39},
            {195, 34},
            {162, 34},
            {122, 41},
            {94, 63},
            {71, 93},
            {56, 127},
            {50, 160},
            {53, 185},
            {58, 209},
            {75, 241},
            {100, 268},
            {142, 296},
            {187, 301},
            {243, 280},
            {280, 248},
            {314, 184},
            {318, 155},
            {319, 153}
    };

    int[][] Q2 = new int[][]{
            {193, 170},
            {202, 183},
            {234, 220},
            {252, 248},
            {278, 276},
            {291, 299},
            {299, 312},
            {303, 317}
    };

    StrokeDirection[] QDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK, StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> QPoints = new ArrayList<int[][]>(){{
        add(Q1);
        add(Q2);
    }};


    /*
   Data of char R;
    */
    int[][] R1 = new int[][]{
            {62, 22},
            {61, 21},
            {55, 41},
            {53, 71},
            {52, 98},
            {49, 128},
            {46, 152},
            {45, 175},
            {45, 198},
            {42, 230},
            {41, 254},
            {41, 277},
            {42, 290},
            {41, 298}
    };
    int[][] R2 = new int[][]{
            {69, 41},
            {69, 41},
            {98, 40},
            {124, 39},
            {151, 39},
            {169, 39},
            {187, 41},
            {198, 59},
            {200, 84},
            {198, 105},
            {184, 129},
            {163, 139},
            {139, 146},
            {117, 145},
            {97, 144},
            {75, 142},
            {73, 140}
    };

    int[][] R3 = new int[][]{
            {78, 147},
            {79, 146},
            {111, 186},
            {137, 221},
            {165, 260},
            {186, 277},
            {191, 287}
    };

    StrokeDirection[] RDirections = new StrokeDirection[]{
            StrokeDirection.DOWN, StrokeDirection.CURVE_FORWARD, StrokeDirection.SLIDE_FORWARD
    };

    ArrayList<int[][]> RPoints = new ArrayList<int[][]>(){{
        add(R1);
        add(R2);
        add(R3);
    }};

    /*
   Data of char S;
    */
    int[][] S1 = new int[][]{
            {167, 55},
            {167, 56},
            {156, 46},
            {141, 37},
            {121, 30},
            {102, 26},
            {84, 28},
            {61, 40},
            {50, 58},
            {44, 74},
            {43, 90},
            {48, 106},
            {61, 123},
            {76, 134},
            {92, 146},
            {106, 162},
            {116, 176},
            {129, 189},
            {138, 201},
            {146, 215},
            {152, 230},
            {152, 244},
            {149, 260},
            {140, 271},
            {108, 283},
            {75, 285},
            {50, 271},
            {34, 254},
            {27, 239},
            {27, 237}
    };

    StrokeDirection[] SDirections = new StrokeDirection[]{
            StrokeDirection.CURVE_BACK
    };

    ArrayList<int[][]> SPoints = new ArrayList<int[][]>(){{
        add(S1);
    }};

    /*
   Data of char T;
    */
    int[][] T1 = new int[][]{
            {24, 29},
            {34, 25},
            {83, 26},
            {129, 25},
            {151, 22},
            {158, 21}
    };

    int[][] T2 = new int[][]{
            {91, 28},
            {89, 29},
            {87, 57},
            {86, 80},
            {85, 101},
            {87, 126},
            {88, 152},
            {87, 179},
            {89, 209},
            {88, 237},
            {88, 265},
            {88, 284},
            {89, 296},
            {89, 296}
    };
    StrokeDirection[] TDirections = new StrokeDirection[]{
            StrokeDirection.RIGHT, StrokeDirection.DOWN
    };

    ArrayList<int[][]> TPoints = new ArrayList<int[][]>(){{
        add(T1);
        add(T2);
    }};



    /*
   Data of char U;
    */
    int[][] U1 = new int[][]{
            {62, 8},
            {53, 42},
            {50, 123},
            {54, 177},
            {59, 214},
            {70, 242},
            {104, 267},
            {146, 272},
            {184, 260},
            {204, 229},
            {209, 184},
            {211, 138},
            {210, 93},
            {208, 47},
            {208, 18},
            {208, 16}
    };



    StrokeDirection[] UDirections = new StrokeDirection[]{
            StrokeDirection.DOWN
    };

    ArrayList<int[][]> UPoints = new ArrayList<int[][]>(){{
        add(U1);
    }};

    /*
   Data of char V;
    */
    int[][] V1 = new int[][]{
            {30, 11},
            {32, 13},
            {45, 43},
            {57, 74},
            {64, 90},
            {75, 112},
            {93, 140},
            {99, 159},
            {111, 186},
            {121, 210},
            {128, 227},
            {134, 249},
            {138, 265}
    };

     int[][] V2 = new int[][]{
            {138, 265},
            {148, 265},
            {165, 222},
            {177, 189},
            {193, 140},
            {210, 98},
            {231, 60},
            {245, 36},
            {255, 18},
            {258, 15}
    };



    StrokeDirection[] VDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_UP
    };

    ArrayList<int[][]> VPoints = new ArrayList<int[][]>(){{
        add(V1);
    }};


    /*
   Data of char W;
    */
    int[][] W1 = new int[][]{
            {43, 13},
            {46, 26},
            {47, 48},
            {52, 72},
            {53, 91},
            {59, 121},
            {68, 142},
            {78, 178},
            {88, 214},
            {94, 240},
            {97, 262},
            {100, 274}
    };
    int[][] W2 = new int[][]{

            {100, 274},
            {107, 258},
            {122, 196},
            {130, 178},
            {146, 149},
            {165, 102},
            {184, 55},
            {196, 25},
            {198, 11}
    };

    int[][] W3 = new int[][]{

            {198, 11},
            {202, 42},
            {205, 79},
            {210, 110},
            {221, 154},
            {236, 197},
            {253, 238},
            {272, 271},
            {285, 285}
    };

    int[][] W4 = new int[][]{

            {285, 285},
            {299, 219},
            {310, 159},
            {325, 89},
            {346, 27},
            {356, 11}
    };

    StrokeDirection[] WDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_UP, StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_UP
    };

    ArrayList<int[][]> WPoints = new ArrayList<int[][]>(){{
        add(W1);
    }};


    /*
    Data of char X;
   */
    int[][] X1 = new int[][]{
            {47, 17},
            {68, 61},
            {111, 132},
            {162, 215},
            {202, 269},
            {214, 287},
            {218, 295}
    };

    int[][] X2 = new int[][]{
            {207, 31},
            {195, 53},
            {142, 140},
            {96, 210},
            {57, 265},
            {37, 287},
            {36, 288}
    };



    StrokeDirection[] XDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_BACK
    };

    ArrayList<int[][]> XPoints = new ArrayList<int[][]>(){{
        add(X1);
        add(X2);
    }};
    /*
   Data of char y;
    */
    int[][] Y1 = new int[][]{
            {29, 30},
            {39, 38},
            {83, 92},
            {113, 136},
            {123, 152},
            {124, 153}
    };

    int[][] Y2 = new int[][]{
            {217, 25},
            {217, 27},
            {171, 86},
            {131, 135},
            {124, 142}
    };

    int[][] Y3 = new int[][]{
            {116, 154},
            {115, 156},
            {116, 211},
            {117, 262},
            {118, 276}
    };


    StrokeDirection[] YDirections = new StrokeDirection[]{
            StrokeDirection.SLIDE_FORWARD, StrokeDirection.SLIDE_BACK, StrokeDirection.DOWN
    };

    ArrayList<int[][]> YPoints = new ArrayList<int[][]>(){{
        add(Y1);
        add(Y2);
        add(Y3);
    }};

    /*
   Data of char Z;
    */
    int[][] Z1 = new int[][]{
        {35, 18},
        {36, 18},
        {84, 17},
        {149, 12},
        {180, 11},
        {186, 10}
    };
    int[][] Z2 = new int[][]{
            {159, 46},
            {158, 45},
            {103, 148},
            {62, 239},
            {47, 274},
            {38, 284}
    };
    int[][] Z3 = new int[][]{
            {33, 282},
            {32, 282},
            {70, 279},
            {136, 276},
            {158, 280},
            {162, 280}
    };
    StrokeDirection[] ZDirections = new StrokeDirection[]{
            StrokeDirection.RIGHT, StrokeDirection.SLIDE_BACK, StrokeDirection.RIGHT
    };

    ArrayList<int[][]> ZPoints = new ArrayList<int[][]>(){{
        add(Z1);
        add(Z2);
        add(Z3);
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

        PATH_A=addPath(ADirections, APoints);
        PATH_B=addPath(BDirections, BPoints);
        PATH_C=addPath(CDirections, CPoints);
        PATH_D=addPath(DDirections, DPoints);
        PATH_E=addPath(EDirections, EPoints);
        PATH_F=addPath(FDirections, FPoints);
        PATH_G=addPath(GDirections, GPoints);
        PATH_H=addPath(HDirections, HPoints);
        PATH_I=addPath(IDirections, IPoints);
        PATH_J=addPath(JDirections, JPoints);
        PATH_K=addPath(KDirections, KPoints);
        PATH_L=addPath(LDirections, LPoints);
        PATH_M=addPath(MDirections, MPoints);
        PATH_N=addPath(NDirections, NPoints);

        PATH_O=addPath(ODirections, OPoints);
        PATH_P=addPath(PDirections, PPoints);
        PATH_Q=addPath(QDirections, QPoints);
        PATH_R=addPath(RDirections, RPoints);
        PATH_S=addPath(SDirections, SPoints);
        PATH_T=addPath(TDirections, TPoints);
        PATH_U=addPath(UDirections, UPoints);
        PATH_V=addPath(VDirections, VPoints);
        PATH_W=addPath(WDirections, WPoints);
        PATH_X=addPath(XDirections, YPoints);
        PATH_Y=addPath(YDirections, YPoints);
        PATH_Z=addPath(ZDirections, ZPoints);
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