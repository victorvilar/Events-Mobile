package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victor.events.R;
import java.util.List;

import domain.Pessoa;

/**
 * Created by Cephas on 03/06/2015.
 */

public class PessoaAdapter extends ArrayAdapter<Pessoa>{

    static class ViewHolder{
        TextView nomeText;
        TextView telefoneText;
        TextView emailText;
    }

    public PessoaAdapter(Context context, int
            textViewResourceId,List<Pessoa> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_pessoa, null);
            holder = new ViewHolder();

            holder.nomeText =  (TextView) view.findViewById(R.id.pessoaNomeRowText);
            holder.telefoneText =  (TextView) view.findViewById(R.id.pessoaTelefoneRowText);
            holder.emailText =  (TextView) view.findViewById(R.id.pessoaEmailRowText);

            view.setTag(holder);
        }

        else {
            holder = (ViewHolder) view.getTag();
        }

        Pessoa pessoa = getItem(position);

        if (pessoa!= null) {
            holder.nomeText.setText(pessoa.getNome());
            holder.telefoneText.setText(pessoa.getTelefone());
            holder.emailText.setText(pessoa.getEmail());
        }
        return view;
    }

}