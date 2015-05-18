package dpassos.com.br.aula02e03;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends ActionBarActivity {

    List<Item> lista;
    ListView lv;
    ListViewAdapter lva;
    Handler hand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        hand = new Handler();

        lista = new ArrayList();

        for(int i = 0; i < 25; i++){
            lista.add(new Item("cabeçalho"+i, getString(R.string.item_detalhes)+i, "url"+i));
        }

        lv = (ListView) findViewById(R.id.list_view);

        lv.addHeaderView(getTextView("Cabecalho"));
        lv.addFooterView(getTextView("Rodape"));

        lva = new ListViewAdapter();
        lv.setAdapter(lva);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);

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


    class ListViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                LayoutInflater li = getLayoutInflater();
                convertView = li.inflate(R.layout.list_view_item, null);
            }

            TextView txt = (TextView)convertView.findViewById(R.id.itemTextCabecalho);
            txt.setText(lista.get(position).getCabecalho());

            txt = (TextView)convertView.findViewById(R.id.itemTextDetalhes);
            txt.setText(lista.get(position).getDetalhes());

            if(position == getCount() - 1){
                atualizarLista(getCount());
            }

            return convertView;
        }
    }
    private void atualizarLista(final int count) {
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lista.add(new Item("cabeçalho" + (count + i), getString(R.string.item_detalhes) + (count + i), "url" + (count + i)));
                }
                lva.notifyDataSetChanged();
            }
        }, 1000);
    }

    private TextView getTextView(String texto){
        TextView txt = new TextView(getBaseContext());
        txt.setLayoutParams(new
                ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT,ListView.LayoutParams.WRAP_CONTENT));
        txt.setText(texto);
        txt.setTextColor(Color.BLACK);
        txt.setTextSize(20);
        return txt;
    }
}
