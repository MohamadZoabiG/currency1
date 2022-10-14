package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button change;
    private ImageView imageView1;
    private ImageView imageView2;
    private Spinner sp1;
    private Spinner sp2;
    private TextView result;
    private EditText currency;
    private RadioButton btn1;
    private RadioButton btn2;
    private RadioGroup radiog;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();
    }

    private void connect()
    {
        imageView1=findViewById(R.id.imageViewMain1);
        imageView2=findViewById(R.id.imageViewMain2);
        change=findViewById(R.id.btnMain);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        result=findViewById(R.id.result);
        currency=findViewById(R.id.etMain);
        btn1=findViewById(R.id.radioDark);
        btn2=findViewById(R.id.radioLight);
        radiog=findViewById(R.id.radioGroup);
        checkBox=findViewById(R.id.checkBox1);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String currency1 =sp1.getSelectedItem().toString();
                if(currency1.equals("dollar"))
                {
                    imageView1.setImageResource(R.drawable.dollar);
                }
                else{
                    imageView1.setImageResource(R.drawable.shekel);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String currency1 =sp2.getSelectedItem().toString();
                if(currency1.equals("dollar"))
                {
                    imageView2.setImageResource(R.drawable.dollar);
                }
                else  {
                    imageView2.setImageResource(R.drawable.shekel);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }




    public void change(View view) {
         String currency1 =sp1.getSelectedItem().toString();
        String currency2 = sp2.getSelectedItem().toString();

        String coin =currency.getText().toString();
        if(coin.trim().isEmpty())
        {
            Toast.makeText(this, "You have to enter a number!", Toast.LENGTH_SHORT).show();
            return;
        }

        double h;
        double sum=Double.parseDouble(coin);


        if(currency1.equals("dollar") && currency2.equals(("dollar")))
        {
            Toast.makeText(this, "enter different values", Toast.LENGTH_SHORT).show();
            return;
        }

        else if(currency1.equals("shekel") && currency2.equals(("shekel")))
        {
            Toast.makeText(this, "enter different values", Toast.LENGTH_SHORT).show();
            return;
        }

        else if(currency1.equals("dollar"))
        {
            h=(sum * 3.55);
            result.setText( "" + h);
            return;
        }

        else if(currency1.equals("shekel"))
        {
            h=(sum/3.55);
            result.setText( "" +h);

            return;
        }
    }


    public void Dark(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    public void Light(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }
}