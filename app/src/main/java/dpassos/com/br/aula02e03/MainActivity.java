package dpassos.com.br.aula02e03;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("djps", "onCreate");

        Button btNovaTela = (Button)findViewById(R.id.btNovaTela);

        //usando inner classes para listener
        btNovaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), NovaTelaActivity.class);
                startActivity(it);
            }
        });

        Button btListView = (Button)findViewById(R.id.btListView);
        btListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), ListViewActivity.class);
                startActivity(it);
            }
        });

        Button btTelefonar = (Button)findViewById(R.id.btTelefonar);
        btTelefonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txt = ((EditText)findViewById(R.id.editText));
                if(!txt.getText().toString().isEmpty()){
                    String foneNumber = ((EditText)findViewById(R.id.editText)).getText().toString();

                    Uri uri = Uri.parse("tel:"+foneNumber);
                    Intent it = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(it);
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


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("djps", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("djps", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("djps", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("djps", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("djps", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("djps", "onDestroy");
    }
}
