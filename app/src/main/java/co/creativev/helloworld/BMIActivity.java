package co.creativev.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        final EditText inputName = (EditText) findViewById(R.id.inputName);
        final SeekBar seekBarWeight = (SeekBar) findViewById(R.id.seekBarWeight);
        final SeekBar seekBarHeight = (SeekBar) findViewById(R.id.seekBarHeight);
        final TextView textViewWeight = (TextView) findViewById(R.id.textViewWeight);
        final TextView textViewHeight = (TextView) findViewById(R.id.textViewHeight);
        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewWeight.setText(String.format("%d kgs", seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewHeight.setText(String.format("%d cms", seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final TextView output = (TextView) findViewById(R.id.textOutput);
        findViewById(R.id.buttonCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bmiStatus = null;
                String name = inputName.getText().toString();
                float weight = seekBarWeight.getProgress();
                float height = seekBarHeight.getProgress();
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
