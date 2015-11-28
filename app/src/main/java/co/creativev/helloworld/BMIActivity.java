package co.creativev.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        final EditText inputName = (EditText) findViewById(R.id.inputName);
        final EditText inputWeight = (EditText) findViewById(R.id.inputWeight);
        final EditText inputHeight = (EditText) findViewById(R.id.inputHeight);
        final TextView output = (TextView) findViewById(R.id.textOutput);
        findViewById(R.id.buttonCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bmiStatus = null;
                String name = inputName.getText().toString();
                float weight = Float.parseFloat(inputWeight.getText().toString());
                float height = Float.parseFloat(inputHeight.getText().toString());
                float bmi = weight / (height * height) * 10000;
                if (bmi < 18.5)
                    bmiStatus = "UnderWeight";
                else if (bmi < 25)
                    bmiStatus = "Normal";
                else if (bmi < 30)
                    bmiStatus = "Overweight";
                else
                    bmiStatus = "Obese";

                output.setText(String.format("Hello %s\nYour BMI is %.2f.\nAnd you are %s.", name, bmi, bmiStatus));
            }
        });
    }
}
