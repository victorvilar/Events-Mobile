package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Convite;

/**
 * Created by Cephas on 03/06/2015.
 */

public class ConviteAdapter extends ArrayAdapter<Convite>{

    static class ViewHolder{
        TextView descricaoTxt;
        TextView dataEnvioTxt;
    }

    public ConviteAdapter(Context context, int
            textViewResourceId,List<Convite> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_convite, null);
            holder = new ViewHolder();

            holder.descricaoTxt =  (TextView) view.findViewById(R.id.conviteDescricaoRowText);
            holder.descricaoTxt =  (TextView) view.findViewById(R.id.conviteDataEnvioRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Convite convite = getItem(position);
        if (convite!= null) {
            holder.descricaoTxt.setText(convite.getDescricao());
            holder.dataEnvioTxt.setText(convite.getDataEnvio());
        }
        return view;
    }

}