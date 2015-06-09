package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Cidade;

/**
 * Created by Cephas on 03/06/2015.
 */

public class CidadeAdapter extends ArrayAdapter<Cidade>{

    static class ViewHolder{
        TextView nomeTxt;
    }

    public CidadeAdapter(Context context, int
            textViewResourceId,List<Cidade> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_cidade, null);
            holder = new ViewHolder();

            holder.nomeTxt =  (TextView) view.findViewById(R.id.cidadeNomeRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Cidade cidade = getItem(position);
        if (cidade!= null) {
            holder.nomeTxt.setText(cidade.getNome());
        }
        return view;
    }

}