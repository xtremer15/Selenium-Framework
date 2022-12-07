package Library;

import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;


/** A-Z Key Codes
 * A - 65
 * B - 66
 * C - 67
 * D - 68
 * E - 69
 * F - 70
 * G - 71
 * H - 72
 * I - 73
 * J - 74
 * K - 75
 * L - 76
 * M - 77
 * N - 78
 * O - 79
 * P - 80
 * Q - 81
 * R - 82
 * S - 83
 * T - 84
 * U - 85
 * V - 86
 * W - 87
 * X - 88
 * Y - 89
 * Z - 90
 * */


public class KeyBoard {

    @Autowired
    private static Robot keyboardActions;

    public static void pressEnter() {
        keyboardActions.keyPress(13);
    }

    public static void testAction(){
    }
}
