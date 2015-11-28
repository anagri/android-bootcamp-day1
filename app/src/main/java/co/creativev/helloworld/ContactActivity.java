package co.creativev.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        findViewById(R.id.buttonHello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.editTextName)).getText().toString();

                RadioGroup genderRadioGroup = (RadioGroup) findViewById(R.id.radio_group_gender);
                RadioButton selectedGender = (RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId());
                String gender = selectedGender.getText().toString();

                Spinner spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
                String selectedCountry = spinnerCountry.getSelectedItem().toString();

                ((TextView) findViewById(R.id.textViewOutput))
                        .setText(
                                String.format("Hello %s, you are a %s from %s", name, gender, selectedCountry));
            }
        });

    }
}
