package szymon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private Button but0;
    private Button butPlus;
    private Button butMinus;
    private Button butMult;
    private Button butDiv;
    private Button butAction1;
    private Button butAction2;
    private EditText calc;

    //private String calculation;
    private Double number1;
    private Double number2;
    private Double result;
    private boolean toErase;
    private boolean firstExists;
    private boolean dotUsed;

    public enum CALCULATION {
        PLUS, MINUS, DIV, MULTI, NULL, POWER, MODULUS
    }

    CALCULATION type = CALCULATION.NULL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //elementy ui po kolei definiowane
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but3 = (Button) findViewById(R.id.but3);
        but4 = (Button) findViewById(R.id.but4);
        but5 = (Button) findViewById(R.id.but5);
        but6 = (Button) findViewById(R.id.but6);
        but7 = (Button) findViewById(R.id.but7);
        but8 = (Button) findViewById(R.id.but8);
        but9 = (Button) findViewById(R.id.but9);
        but0 = (Button) findViewById(R.id.but0);
        butPlus = (Button) findViewById(R.id.butPlus);
        butMinus = (Button) findViewById(R.id.butMinus);
        butMult = (Button) findViewById(R.id.butMult);
        butDiv = (Button) findViewById(R.id.butDiv);
        butAction1 = (Button) findViewById(R.id.butAction1);
        butAction2 = (Button) findViewById(R.id.button2);//NIEKONSEKWENCJA!!!! poprawcie prosze
        calc = (EditText) findViewById(R.id.editText);

        toErase = true;//czy nastepna liczba ma usunac z wyswietlacza co tam jest?
        firstExists = false;//czy to pierwsze po =, zeby liczyc z dwoch wartosci a nie jednej
        dotUsed = false;
        number1 = 0d;//liczby do dzialan
        number2 = 0d;

    }

    public double calculate(double number1, double number2) {
        double result = 0d;
        switch (type) {
            case PLUS: {
                result = number1 + number2;
                break;
            }
            case MINUS:
                result = number2 - number1;
                break;
            case DIV:
                result = number2 / number1;
                break;
            case MULTI:
                result = number2 * number1;
                break;
            case NULL:
                break;
            case POWER:
                result = pow(number2, number1);
                break;
            case MODULUS:
                result = sqrt(number1 * number1 + number2 * number2);
                break;
        }
        return result;
    }

    public void clickNumber(View v) {
//jedne na wszystkie przyciski, switch dla znalezienia ktore bylo wcisniete

        switch (v.getId()) {

            case R.id.but1:
                if (toErase) {
                    calc.setText("1");//jezeli wynik, skasowac napis i zaczac od nowa, i to juz nie wynik
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "1");//jesli nie wynik, to dopisac liczbe
                }
                break;
            case R.id.but2:
                if (toErase) {
                    calc.setText("2");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "2");
                }
                break;
            case R.id.but3:
                if (toErase) {
                    calc.setText("3");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "3");
                }
                break;
            case R.id.but4:
                if (toErase) {
                    calc.setText("4");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "4");
                }
                break;
            case R.id.but5:
                if (toErase) {
                    calc.setText("5");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "5");
                }
                break;
            case R.id.but6:
                if (toErase) {
                    calc.setText("6");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "6");
                }
                break;
            case R.id.but7:
                if (toErase) {
                    calc.setText("7");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "7");
                }
                break;
            case R.id.but8:
                if (toErase) {
                    calc.setText("8");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "8");
                }
                break;
            case R.id.but9:
                if (toErase) {
                    calc.setText("9");
                    toErase = false;
                } else {
                    calc.setText(calc.getText() + "9");
                }
            case R.id.but0:
                if (toErase) {
                    calc.setText("0");
                } else {
                    calc.setText(calc.getText() + "0");
                }
                break;
            case R.id.butDot:
                if (!dotUsed) {
                    if (toErase) {
                        calc.setText("0.");
                        toErase = false;
                    } else {
                        calc.setText(calc.getText() + ".");
                    }
                }
                dotUsed = true;
                break;

            case R.id.butPlus: {//dzialania nie dzialaja jakbym chcial (a wlasciwie prawie w ogole); mysle o zapisaniu ostatnio wybranego i wykonywaniu na =, ale tu prosze szczegolnie o opinie i wsparcie
                if (!toErase) {
                    toErase = true;
                    number2 = number1;// przepisanie wczesniejszej liczby do pamieci
                    number1 = Double.parseDouble(calc.getText().toString());
                    //zapisanie aktualnej liczby
                    //if (type==CALCULATION.NULL)type=CALCULATION.PLUS;
                    type = CALCULATION.PLUS;
                    if (firstExists) {
                        number1 = calculate(number1, number2);
                    }
                    firstExists = true;
                    calc.setText(String.valueOf(number1));

                    // calc.setText(String.valueOf(result));//wyswietlenie wyniku; do przesuniecia do =
                    break;
                } else {
                    type = CALCULATION.PLUS;
                    break;
                }
            }
            case R.id.butMinus: {
                if (!toErase) {
                    toErase = true;
                    number2 = number1;// przepisanie wczesniejszej liczby do pamieci
                    number1 = Double.parseDouble(calc.getText().toString());
                    //zapisanie aktualnej liczby
                    //if (type==CALCULATION.NULL)type=CALCULATION.PLUS;
                    type = CALCULATION.MINUS;
                    if (firstExists) {
                        number1 = calculate(number1, number2);
                    }
                    firstExists = true;
                    calc.setText(String.valueOf(number1));

                    // calc.setText(String.valueOf(result));//wyswietlenie wyniku; do przesuniecia do =
                    break;
                } else {
                    type = CALCULATION.MINUS;
                    break;
                }
            }
            case R.id.butMult: {
                if (!toErase) {
                    toErase = true;
                    number2 = number1;// przepisanie wczesniejszej liczby do pamieci
                    number1 = Double.parseDouble(calc.getText().toString());
                    //zapisanie aktualnej liczby
                    //if (type==CALCULATION.NULL)type=CALCULATION.PLUS;
                    type = CALCULATION.MULTI;
                    if (firstExists) {
                        number1 = calculate(number1, number2);
                    }
                    firstExists = true;
                    calc.setText(String.valueOf(number1));

                    // calc.setText(String.valueOf(result));//wyswietlenie wyniku; do przesuniecia do =
                    break;
                } else {
                    type = CALCULATION.MULTI;
                    break;
                }
            }
            case R.id.butDiv: {
                if (!toErase) {
                    toErase = true;
                    number2 = number1;// przepisanie wczesniejszej liczby do pamieci
                    number1 = Double.parseDouble(calc.getText().toString());
                    //zapisanie aktualnej liczby
                    //if (type==CALCULATION.NULL)type=CALCULATION.PLUS;
                    type = CALCULATION.DIV;
                    if (firstExists) {
                        number1 = calculate(number1, number2);
                    }
                    firstExists = true;
                    calc.setText(String.valueOf(number1));

                    // calc.setText(String.valueOf(result));//wyswietlenie wyniku; do przesuniecia do =
                    break;
                } else {
                    type = CALCULATION.DIV;
                    break;
                }
            }
            case R.id.butAction1: {
                if (!toErase) {
                    toErase = true;
                    number2 = number1;// przepisanie wczesniejszej liczby do pamieci
                    number1 = Double.parseDouble(calc.getText().toString());
                    //zapisanie aktualnej liczby
                    //if (type==CALCULATION.NULL)type=CALCULATION.PLUS;
                    type = CALCULATION.POWER;
                    if (firstExists) {
                        number1 = calculate(number1, number2);
                    }
                    firstExists = true;
                    calc.setText(String.valueOf(number1));

                    // calc.setText(String.valueOf(result));//wyswietlenie wyniku; do przesuniecia do =
                    break;
                } else {
                    type = CALCULATION.POWER;
                    break;
                }
            }
            case R.id.button2: {
                if (!toErase) {
                    toErase = true;
                    number2 = number1;// przepisanie wczesniejszej liczby do pamieci
                    number1 = Double.parseDouble(calc.getText().toString());
                    //zapisanie aktualnej liczby
                    //if (type==CALCULATION.NULL)type=CALCULATION.PLUS;
                    type = CALCULATION.MODULUS;
                    if (firstExists) {
                        number1 = calculate(number1, number2);
                    }
                    firstExists = true;
                    calc.setText(String.valueOf(number1));

                    // calc.setText(String.valueOf(result));//wyswietlenie wyniku; do przesuniecia do =
                    break;
                } else {
                    type = CALCULATION.MODULUS;
                    break;
                }
            }
            case R.id.butEqual: {
                toErase = true;
                number2 = number1;
                number1 = Double.parseDouble(calc.getText().toString());
                result = calculate(number1, number2);
                calc.setText(String.valueOf(result));
                type = CALCULATION.NULL;

                firstExists = false;
                break;

            }

        }
    }
}
