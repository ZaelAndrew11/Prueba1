package cl.aguzman.prueba1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
//import static cl.aguzman.prueba1.R.id.fab;

public class MainActivity extends AppCompatActivity implements Serializable{

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnGoCalendar = (Button) findViewById(R.id.btnTOCalendar);

        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textUserName = (EditText) findViewById(R.id.userName);
                String nameUserText = textUserName.getText().toString();
                nameUserText = nameUserText.trim();
                if(nameUserText.matches("")){
                    Toast.makeText(MainActivity.this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
                    intentCalendar.putExtra("name", nameUserText);
                    startActivity(intentCalendar);
                }

            }
        });

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
