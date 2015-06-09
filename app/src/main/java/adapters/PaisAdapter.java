package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Pais;

/**
 * Created by Cephas on 03/06/2015.
 */

public class PaisAdapter extends ArrayAdapter<Pais>{

    static class ViewHolder{
        TextView nomeTxt;
    }

    public PaisAdapter(Context context, int
            textViewResourceId,List<Pais> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_pais, null);
            holder = new ViewHolder();

            holder.nomeTxt =  (TextView) view.findViewById(R.id.paisNomeRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Pais pais = getItem(position);
        if (pais!= null) {
            holder.nomeTxt.setText(pais.getNome());
        }
        return view;
    }

}