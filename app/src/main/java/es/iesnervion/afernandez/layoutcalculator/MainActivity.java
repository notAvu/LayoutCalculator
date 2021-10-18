package es.iesnervion.afernandez.layoutcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private static LinkedList<Button> numberButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sum=findViewById(R.id.plusButton);
        Button minus=findViewById(R.id.minusButton);
        Button multiply=findViewById(R.id.multiplyButton);
        Button division=findViewById(R.id.divisionButton);
        Button equals=findViewById(R.id.equalsButton);

        Button[] numberedButtons={findViewById(R.id.button0),findViewById(R.id.button),findViewById(R.id.button2),
                findViewById(R.id.button3),findViewById(R.id.button4),findViewById(R.id.button5),
                findViewById(R.id.button6),findViewById(R.id.button7),findViewById(R.id.button8),
                findViewById(R.id.button9)};

        numberButtons = new LinkedList<>(Arrays.asList(numberedButtons));

        sum.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        division.setOnClickListener(this);
        equals.setOnClickListener(this);

        for (Button button:numberedButtons) {
            button.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        EditText editText= findViewById(R.id.operator);
        double result=Double.parseDouble(String.valueOf(editText.getText()));

        switch(view.getId())
        {
            case(R.id.plusButton):
            {
                result+=Double.parseDouble(String.valueOf(editText.getText()));
                editText.setText("");
                break;
            }
            case(R.id.minusButton):
            {
                result-=Double.parseDouble(String.valueOf(editText.getText()));
                editText.setText("");
                break;
            }
            case(R.id.multiply):
            {
                result*=Double.parseDouble(String.valueOf(editText.getText()));
                editText.setText("");
                break;
            }
            case(R.id.divisionButton):
            {
                result/=Double.parseDouble(String.valueOf(editText.getText()));
                editText.setText("");
                break;
            }
            case(R.id.equalsButton):
            {
                editText.setText((String.valueOf(result)));
                break;
            }

            default:
            {
                if(numberButtons.contains(view))
                {
                    Button pressed=(Button) view;
                    editText.append(pressed.getText());
                    break;
                }
            }
        }
    }
}