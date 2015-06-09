package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.ConvitePessoa;

/**
 * Created by Cephas on 03/06/2015.
 */

public class ConvitePessoaAdapter extends ArrayAdapter<ConvitePessoa>{

    static class ViewHolder{
        TextView justificativaTxt;
        TextView statusTxt;
    }

    public ConvitePessoaAdapter(Context context, int
            textViewResourceId,List<ConvitePessoa> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_convitepessoa, null);
            holder = new ViewHolder();

            holder.justificativaTxt =  (TextView) view.findViewById(R.id.convitePessoaJustificativaRowText);
            holder.statusTxt = (TextView) view.findViewById(R.id.convitePessoaStatusRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ConvitePessoa convitePessoa = getItem(position);
        if (convitePessoa!= null) {
            holder.justificativaTxt.setText(convitePessoa.getJustificativa());
            holder.justificativaTxt.setText(convitePessoa.getStatus());
        }
        return view;
    }

}