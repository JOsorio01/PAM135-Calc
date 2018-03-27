package firstapp.sv.edu.ues.om13001.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import firstapp.sv.edu.ues.om13001.firstapp.EOperacion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView edit;
    double actual_val = 0;
    double previous_val = 0;
    //flag usado para borrar la pantalla si se ingresa otro numero luego de una operacion
    //symbol es para asegurar que no se use más de un punto
    boolean symbol = true, flag = true;
    //op para saber cual fue la operacion anterior
    EOperacion op = EOperacion.NONE;
    Button clear_text, clear_mem, open, close;
    Button seven, eight, nine, div;
    Button four, five, six, product;
    Button one, two, three, plus;
    Button dot, zero, equal, minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (TextView) findViewById(R.id.editor);

        clear_text = (Button) findViewById(R.id.b_clear_text);
        clear_text.setOnClickListener(this);

        clear_mem = (Button) findViewById(R.id.b_clear_mem);
        clear_mem.setOnClickListener(this);

        open = (Button) findViewById(R.id.b_open);
        open.setOnClickListener(this);

        close = (Button) findViewById(R.id.b_close);
        close.setOnClickListener(this);

        seven = (Button) findViewById(R.id.b_seven);
        seven.setOnClickListener(this);

        eight = (Button) findViewById(R.id.b_eight);
        eight.setOnClickListener(this);

        nine = (Button) findViewById(R.id.b_nine);
        nine.setOnClickListener(this);

        div = (Button) findViewById(R.id.b_div);
        div.setOnClickListener(this);

        four = (Button) findViewById(R.id.b_four);
        four.setOnClickListener(this);

        five = (Button) findViewById(R.id.b_five);
        five.setOnClickListener(this);

        six = (Button) findViewById(R.id.b_six);
        six.setOnClickListener(this);

        product = (Button) findViewById(R.id.b_product);
        product.setOnClickListener(this);

        one = (Button) findViewById(R.id.b_one);
        one.setOnClickListener(this);

        two = (Button) findViewById(R.id.b_two);
        two.setOnClickListener(this);

        three = (Button) findViewById(R.id.b_three);
        three.setOnClickListener(this);

        plus = (Button) findViewById(R.id.b_plus);
        plus.setOnClickListener(this);

        dot = (Button) findViewById(R.id.b_dot);
        dot.setOnClickListener(this);

        zero = (Button) findViewById(R.id.b_zero);
        zero.setOnClickListener(this);

        equal = (Button) findViewById(R.id.b_equal);
        equal.setOnClickListener(this);

        minus = (Button) findViewById(R.id.b_minus);
        minus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_dot:
                if (symbol) {
                    edit.setText(
                            edit.getText().toString() + dot.getText()
                    );
                    symbol = false;
                }

                break;

            case R.id.b_zero:
                limpiar();
                edit.setText(
                        edit.getText().toString() + zero.getText()
                );
                break;

            case R.id.b_one:
                limpiar();
                edit.setText(
                        edit.getText().toString() + one.getText()
                );
                break;

            case R.id.b_two:
                limpiar();
                edit.setText(
                        edit.getText().toString() + two.getText()
                );
                break;

            case R.id.b_three:
                limpiar();
                edit.setText(
                        edit.getText().toString() + three.getText()
                );
                break;

            case R.id.b_four:
                limpiar();
                edit.setText(
                        edit.getText().toString() + four.getText()
                );
                break;

            case R.id.b_five:
                limpiar();
                edit.setText(
                        edit.getText().toString() + five.getText()
                );
                break;

            case R.id.b_six:
                limpiar();
                edit.setText(
                        edit.getText().toString() + six.getText()
                );
                break;

            case R.id.b_seven:
                limpiar();
                edit.setText(
                        edit.getText().toString() + seven.getText()
                );
                break;

            case R.id.b_eight:
                limpiar();
                edit.setText(
                        edit.getText().toString() + eight.getText()
                );
                break;

            case R.id.b_nine:
                limpiar();
                edit.setText(
                        edit.getText().toString() + nine.getText()
                );
                break;
/*
    Los metodos de las operaciones hacen uso de la enumeracion EOperacion
 */
            case R.id.b_minus:
                asignar();
                op = EOperacion.RESTA;
                flag = true;
                break;

            case R.id.b_plus:
                asignar();
                op = EOperacion.SUMA;
                flag = true;
                break;

            case R.id.b_product:
                asignar();
                op = EOperacion.MULTIPLICACION;
                flag = true;
                break;

            case R.id.b_div:
                asignar();
                op = EOperacion.DIVISION;
                flag = true;
                break;

            case R.id.b_equal:
                asignar();
                operacion(op);
                break;

            case R.id.b_clear_text:
                edit.setText("");
                break;

            case R.id.b_clear_mem:
                edit.setText("");
                actual_val = 0;
                previous_val = 0;
        }
    }

    public void operacion (EOperacion o){

        switch (o) {
            case SUMA:
                previous_val += actual_val;
                break;

            case RESTA:
                previous_val -= actual_val;
                break;

            case MULTIPLICACION:
                previous_val *= actual_val;
                break;

            case DIVISION:
                previous_val /= actual_val;
                break;

            case NONE:
                previous_val = actual_val;
                break;
        }

        edit.setText(""+previous_val);
        symbol = true;
        flag = true;
    }

    public void limpiar() {
        if (flag) {
            edit.setText("");
            flag = false;
        }
    }

    public void asignar() {
        previous_val = actual_val;
        if (!edit.getText().toString().isEmpty()) {
            actual_val = Double.parseDouble(edit.getText().toString());
        } else {
            actual_val = 0;
        }
    }
}
