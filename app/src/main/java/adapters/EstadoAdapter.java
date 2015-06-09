package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Estado;

/**
 * Created by Cephas on 03/06/2015.
 */

public class EstadoAdapter extends ArrayAdapter<Estado>{

    static class ViewHolder{
        TextView nomeTxt;
    }

    public EstadoAdapter(Context context, int
            textViewResourceId,List<Estado> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_estado, null);
            holder = new ViewHolder();

            holder.nomeTxt =  (TextView) view.findViewById(R.id.estadoNomeRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Estado estado = getItem(position);
        if (estado!= null) {
            holder.nomeTxt.setText(estado.getNome());
        }
        return view;
    }

}