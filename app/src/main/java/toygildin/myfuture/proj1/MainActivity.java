package toygildin.myfuture.proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        EditText editText1 = findViewById(R.id.editTextNumber1);
        EditText editText2 = findViewById(R.id.editTextNumber2);
        TextView textView = findViewById(R.id.textViewResult);
        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);

        button.setOnClickListener(v -> {
            double number1 = editText1.getText().toString().equals("") ?
                    0 : Integer.parseInt(editText1.getText().toString());
            double number2 = editText2.getText().toString().equals("") ?
                    0 : Integer.parseInt(editText2.getText().toString());
            double result;
            if (radioButton1.isChecked()) {
                result = number1 + number2;
            } else {
                result = (number1 + number2) / 2;
            }
            textView.setText(String.valueOf(result));
        });
    }
}