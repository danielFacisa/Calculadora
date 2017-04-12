package br.com.cesed.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.cesed.calculadora.expr.Expr;
import br.com.cesed.calculadora.expr.Parser;
import br.com.cesed.calculadora.expr.SyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView campoExpressao;
    private String expressao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        campoExpressao = (TextView) findViewById(R.id.expressao);
        campoExpressao.setOnClickListener(this);

        Button limpar = (Button) findViewById(R.id.limpar);
        limpar.setOnClickListener(this);

        Button zero = (Button) findViewById(R.id.button0);
        zero.setOnClickListener(this);
        Button um = (Button) findViewById(R.id.button1);
        um.setOnClickListener(this);
        Button dois = (Button) findViewById(R.id.button2);
        dois.setOnClickListener(this);
        Button tres = (Button) findViewById(R.id.button3);
        tres.setOnClickListener(this);
        Button quatro = (Button) findViewById(R.id.button4);
        quatro.setOnClickListener(this);
        Button cinco = (Button) findViewById(R.id.button5);
        cinco.setOnClickListener(this);
        Button seis = (Button) findViewById(R.id.button6);
        seis.setOnClickListener(this);
        Button sete = (Button) findViewById(R.id.button7);
        sete.setOnClickListener(this);
        Button oito = (Button) findViewById(R.id.button8);
        oito.setOnClickListener(this);
        Button nove = (Button) findViewById(R.id.button9);
        nove.setOnClickListener(this);

        Button somar = (Button) findViewById(R.id.somar);
        somar.setOnClickListener(this);
        Button subtrair = (Button) findViewById(R.id.subtrair);
        subtrair.setOnClickListener(this);
        Button multiplicar = (Button) findViewById(R.id.multiplicar);
        multiplicar.setOnClickListener(this);
        Button dividir = (Button) findViewById(R.id.dividir);
        dividir.setOnClickListener(this);

        Button igual = (Button) findViewById(R.id.igual);
        igual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.limpar:
                expressao = "";
                campoExpressao.setText("");
                break;
            case R.id.button0:
                expressao += "0";
                campoExpressao.setText(expressao);
                break;
            case R.id.button1:
                expressao += "1";
                campoExpressao.setText(expressao);
                break;
            case R.id.button2:
                expressao += "2";
                campoExpressao.setText(expressao);
                break;
            case R.id.button3:
                expressao += "3";
                campoExpressao.setText(expressao);
                break;
            case R.id.button4:
                expressao += "4";
                campoExpressao.setText(expressao);
                break;
            case R.id.button5:
                expressao += "5";
                campoExpressao.setText(expressao);
                break;
            case R.id.button6:
                expressao += "6";
                campoExpressao.setText(expressao);
                break;
            case R.id.button7:
                expressao += "7";
                campoExpressao.setText(expressao);
                break;
            case R.id.button8:
                expressao += "8";
                campoExpressao.setText(expressao);
                break;
            case R.id.button9:
                expressao += "9";
                campoExpressao.setText(expressao);
                break;
            case R.id.somar:
                expressao += "+";
                campoExpressao.setText(expressao);
                break;
            case R.id.subtrair:
                expressao += "-";
                campoExpressao.setText(expressao);
                break;
            case R.id.multiplicar:
                expressao += "*";
                campoExpressao.setText(expressao);
                break;
            case R.id.dividir:
                expressao += "/";
                campoExpressao.setText(expressao);
                break;
            case R.id.igual:
                Expr expr;
                try {
                    expr = Parser.parse(this.expressao);
                    Toast.makeText(this, "Resultado da Expressão é:\n"+String.valueOf(expr.value()), Toast.LENGTH_SHORT).show();
                } catch (SyntaxException e) {
                    Toast.makeText(this, "Digite uma expressão válida!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
