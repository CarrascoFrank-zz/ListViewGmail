package listviewgmail.studio.com.listviewgmail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> nossoArray;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        setData();
        adapter = new AdapterListView(this, R.layout.item_listview,nossoArray);
        listView.setAdapter(adapter);
    }

    private void setData(){
        nossoArray = new ArrayList<>();
        nossoArray.add("Ilidio Zandamela");
        nossoArray.add("Florêncio Lipoche");
        nossoArray.add("Helena Sitoe");
        nossoArray.add("Isack Mabunda");
        nossoArray.add("Vânia Khumalo");
        nossoArray.add("Genny Macaringue ");
        nossoArray.add("Edson Mazuze");
        nossoArray.add("Jaime Mulungo");
        nossoArray.add("Crimilde Nguila");
        nossoArray.add("Thobile Coutinho");
        nossoArray.add("Alison Conceição");
        nossoArray.add("Julia Maposse");
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
