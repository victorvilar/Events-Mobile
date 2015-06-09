package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Evento;

/**
 * Created by Cephas on 03/06/2015.
 */

public class EventoAdapter extends ArrayAdapter<Evento>{

    static class ViewHolder{
        TextView nomeTxt;
        TextView criadorTxt;
        TextView dataTxt;
        TextView horaTxt;
        TextView localTxt;
        TextView descricaoTxt;
    }

    public EventoAdapter(Context context, int
            textViewResourceId,List<Evento> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_evento, null);
            holder = new ViewHolder();

            holder.nomeTxt =  (TextView) view.findViewById(R.id.eventoNomeRowText);
            holder.criadorTxt =  (TextView) view.findViewById(R.id.eventoCriadorRowText);
            holder.dataTxt =  (TextView) view.findViewById(R.id.eventoDataRowText);
            holder.horaTxt =  (TextView) view.findViewById(R.id.eventoHoraRowText);
            holder.localTxt =  (TextView) view.findViewById(R.id.eventoLocalTextRow);
            holder.descricaoTxt =  (TextView) view.findViewById(R.id.eventoDescricaoRowText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Evento evento = getItem(position);
        if (evento!= null) {
            holder.nomeTxt.setText(evento.getNome());
            holder.criadorTxt.setText(evento.getPessoa().getNome());
            holder.dataTxt.setText(evento.getDataInicio());
            holder.horaTxt.setText(evento.getHora());
            switch(evento.getLocalidade().getTipo()){
                case 0: holder.localTxt.setText(evento.getLocalidade().getBairro().getNome());
                case 1: holder.localTxt.setText(evento.getLocalidade().getCidade().getNome());
                case 2: holder.localTxt.setText(evento.getLocalidade().getEstado().getNome());
                case 3: holder.localTxt.setText(evento.getLocalidade().getPais().getNome());
            }
            holder.descricaoTxt.setText(evento.getDescricao());
        }
        return view;
    }

}