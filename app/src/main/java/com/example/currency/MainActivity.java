package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button change;
    private ImageView imageView1;
    private Spinner sp1;
    private Spinner sp2;
    private TextView result;
    private EditText currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();
    }

    private void connect()
    {
        imageView1=findViewById(R.id.imageViewMain);
        change=findViewById(R.id.btnMain);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        result=findViewById(R.id.result);
        currency=findViewById(R.id.etMain);
    }

    public void change(View view) {

        String coin =currency.getText().toString();
        if(coin.trim().isEmpty())
        {
            Toast.makeText(this, "You have to enter a number!", Toast.LENGTH_SHORT).show();
            return;
        }
        String currency1 =sp1.getSelectedItem().toString();
        String currency2 = sp2.getSelectedItem().toString();
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
            imageView1.setImageResource(R.drawable.shekel);

            return;
        }

        else if(currency1.equals("shekel"))
        {
            h=(sum/3.55);
            result.setText( "" +h);
            imageView1.setImageResource(R.drawable.dollar);


            return;
        }







    }
}