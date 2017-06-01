package listviewgmail.studio.com.listviewgmail;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;


public class AdapterListView extends ArrayAdapter<String>{

    private MainActivity activity;

    //iniciamos a lissta de contatos.
    private List<String> listaContatos;

    //construtor do Adapter
    public AdapterListView(MainActivity contexto, int recursos, List<String> objetos) {
        super(contexto, recursos, objetos);
        this.activity = contexto;
        this.listaContatos = objetos;

    }

    //metodo para contar elementos do array
    @Override
    public int getCount(){
        return listaContatos.size();
    }

    //Metodo para retornar a possição do array na lista
    @Override
    public String getItem(int position) {
        return listaContatos.get(position);
    }

    //Meotdo que devolve a posiçao do determinado item do array
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Metodo que faz as letras coloridas
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE); // é a classse do efeito

        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nomeContato.setText(getItem(position));

        //pegando a primeira letra do contato
        String primeiraLetra = String.valueOf(getItem(position).charAt(0));

        ColorGenerator geradorDeCor = ColorGenerator.MATERIAL;
        //gerando cor aleatoria
        int cor = geradorDeCor.getColor(getItem(position));
        //int cor = geradorDeCor.getRandomColor();

        TextDrawable drawable = TextDrawable.builder().buildRoundRect(primeiraLetra, cor, 7);
        //build .buildRound(primeiraLetra, cor);

        holder.imageView.setImageDrawable(drawable);
        return convertView;
    }


    //Classe ViewHolder
    private class ViewHolder{
        private ImageView imageView;
        private TextView nomeContato;

        public ViewHolder(View v){
            imageView = (ImageView) v.findViewById(R.id.imageView);
            nomeContato = (TextView) v.findViewById(R.id.text);
        }
    }
}
