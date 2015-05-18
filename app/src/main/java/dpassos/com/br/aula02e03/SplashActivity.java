package dpassos.com.br.aula02e03;


import
        android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class SplashActivity extends ActionBarActivity implements Runnable{

    private static final int DELAY = 2000;
    private static final int ACTION_BAR_UPDATE = DELAY /100;
    private static final int PROGRESS_INCREMENT_CODE = 1;
    private Handler h , progressHandle;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        h = new Handler();
        h.postDelayed(this, DELAY);

        progressHandle = new MeuHandler();
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        updateProgressBar();
    }

    private void updateProgressBar(){
        progressBar.incrementProgressBy(1);
        Message msg = new Message();
        msg.what = PROGRESS_INCREMENT_CODE;
        progressHandle.sendMessageDelayed(msg, ACTION_BAR_UPDATE);
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
    public void run() {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public void finish() {
        h.removeCallbacksAndMessages(null);
        progressHandle.removeCallbacksAndMessages(null);
        super.finish();
    }

   class MeuHandler extends Handler{

       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           switch (msg.what){
               case PROGRESS_INCREMENT_CODE:
                    updateProgressBar();
               break;
           }
       }
   }
}