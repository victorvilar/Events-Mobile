package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Tema;

/**
 * Created by Cephas on 03/06/2015.
 */

public class TemaAdapter extends ArrayAdapter<Tema>{

    static class ViewHolder{
        TextView descricaoTxt;
    }

    public TemaAdapter(Context context, int
            textViewResourceId,List<Tema> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_tema, null);
            holder = new ViewHolder();

            holder.descricaoTxt =  (TextView) view.findViewById(R.id.temaDescricaoRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Tema tema = getItem(position);
        if (tema!= null) {
            holder.descricaoTxt.setText(tema.getDescricao());
        }
        return view;
    }

}