package invision.app.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    /*Formulas :
            convert to celsius : (value - 32) * 5/9
            convert to fahrenheit : (value * 9/5) + 32*/

    private EditText et_temperature;
    private TextView tv_resulttemp;
    private Button btn_c, btn_f;
    private DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temperature = (EditText) findViewById(R.id.et_temperature);
        tv_resulttemp = (TextView) findViewById(R.id.tv_resulttemp);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_f = (Button) findViewById(R.id.btn_f);

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = et_temperature.getText().toString();
                if (value == null || value.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Temperature", Toast.LENGTH_SHORT).show();
                }
                else {
                    double doubleVal = Double.parseDouble(value);
                    String resTemp = round.format(convertToCelsius(doubleVal));
                    tv_resulttemp.setText(resTemp);
                }
            }
        });

        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = et_temperature.getText().toString();
                if (value == null || value.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Temperature", Toast.LENGTH_SHORT).show();
                }
                else {
                    double doubleVal = Double.parseDouble(value);
                    String resTemp = round.format(convertToFahrenheit(doubleVal));
                    tv_resulttemp.setText(resTemp);
                }
            }
        });

    }

    private double convertToCelsius(double fahVal){
        double result;
        result = (fahVal - 32) * 5/9;
        return result;
    }

    private double convertToFahrenheit(double celVal){
        double result;
        result = (celVal * 9/5) + 32;
        return result;
    }
}
