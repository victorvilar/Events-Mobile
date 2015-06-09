package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Bairro;

/**
 * Created by Cephas on 03/06/2015.
 */

public class BairroAdapter extends ArrayAdapter<Bairro>{

    static class ViewHolder{
        TextView nomeTxt;
    }

    public BairroAdapter(Context context, int
            textViewResourceId,List<Bairro> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_bairro, null);
            holder = new ViewHolder();

            holder.nomeTxt =  (TextView) view.findViewById(R.id.bairroNomeRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Bairro bairro = getItem(position);
        if (bairro!= null) {
            holder.nomeTxt.setText(bairro.getNome());
        }
        return view;
    }

}