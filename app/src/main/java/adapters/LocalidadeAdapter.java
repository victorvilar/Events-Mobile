package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Localidade;

/**
 * Created by Cephas on 03/06/2015.
 */

public class LocalidadeAdapter extends ArrayAdapter<Localidade>{

    static class ViewHolder{
        TextView tipoTxt;
    }

    public LocalidadeAdapter(Context context, int
            textViewResourceId,List<Localidade> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_localidade, null);
            holder = new ViewHolder();

            holder.tipoTxt =  (TextView) view.findViewById(R.id.localidadeTipoRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Localidade localidade = getItem(position);
        if (localidade!= null) {
            holder.tipoTxt.setText(localidade.getTipo());
        }
        return view;
    }

}