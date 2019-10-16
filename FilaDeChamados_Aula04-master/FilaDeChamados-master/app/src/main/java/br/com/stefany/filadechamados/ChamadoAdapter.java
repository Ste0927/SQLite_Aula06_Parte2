package br.com.stefany.filadechamados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;
import java.util.List;

import br.com.bossini.usjt_ccp3bn_mcb_fila_de_chamados.R;

public class ChamadoAdapter extends ArrayAdapter <Chamado> {

    private Context context;
    private List <Chamado> chamados;

    public ChamadoAdapter(Context context, List<Chamado> chamados){
        super(context, -1, chamados);
        this.chamados = chamados;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        Chamado chamadoDaVez = getItem(position);
        ChamadoViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ChamadoViewHolder();
            viewHolder.descricaoChamadoTextView =
                    convertView.findViewById(R.id.descricaoChamadoTextView);
            viewHolder.dataAberturaChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
            viewHolder.dataFechamentoChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);
            viewHolder.statusChamadoNaFilaTextView =
                    convertView.findViewById(R.id.statusChamadoNaFilaTextView);
            viewHolder.filaIconImageView =
                    convertView.findViewById(R.id.filaIconImageView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ChamadoViewHolder) convertView.getTag();

        String descricao = chamadoDaVez.getDescricao();
        String status = chamadoDaVez.getStatus();
        Date dataAbertura = chamadoDaVez.getDataAbertura();
        Date dataFechamento = chamadoDaVez.getDataFechamento();
        Fila fila = chamadoDaVez.getFila();
        int filaIconId = fila.getIconId();


        viewHolder.descricaoChamadoTextView.setText(descricao);
        viewHolder.dataAberturaChamadoNaFilaTextView.setText(DateHelper.convert(dataAbertura));
        viewHolder.dataFechamentoChamadoNaFilaTextView.setText(dataFechamento != null ? DateHelper.convert(dataFechamento) : "");
        viewHolder.statusChamadoNaFilaTextView.setText(status);
        viewHolder.filaIconImageView.setImageResource(filaIconId);
        return convertView;

    }

    @Override
    public int getCount() {
        return chamados.size();
    }
}
