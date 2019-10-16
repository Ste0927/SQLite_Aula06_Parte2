package br.com.stefany.filadechamados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.bossini.usjt_ccp3bn_mcb_fila_de_chamados.R;

public class DetalhesChamadoActivity extends AppCompatActivity {

    private TextView descricaoChamadoTextView;
    private TextView statusChamadoNaFilaTextView;
    private TextView dataAberturaChamadoNaFilaTextView;
    private TextView dataFechamentoChamadoNaFilaTextView;
    private ImageView filaIconImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_chamado);
        Intent origemIntent = getIntent();
        Chamado chamadoSelecionado = (Chamado)
                origemIntent.
                        getSerializableExtra(
                                "chamado_selecionado");

        descricaoChamadoTextView =
                findViewById(
                        R.id.descricaoChamadoTextView
                );
        statusChamadoNaFilaTextView =
                findViewById(
                        R.id.statusChamadoNaFilaTextView
                );
        dataAberturaChamadoNaFilaTextView =
                findViewById(
                        R.id.dataAberturaChamadoNaFilaTextView
                );
        dataFechamentoChamadoNaFilaTextView =
                findViewById(
                        R.id.dataFechamentoChamadoNaFilaTextView
                );
        filaIconImageView =
                findViewById(R.id.filaIconImageView);

        descricaoChamadoTextView.setText(
                chamadoSelecionado.getDescricao()
        );
        statusChamadoNaFilaTextView.setText(
                chamadoSelecionado.getStatus()
        );
        dataAberturaChamadoNaFilaTextView.setText(
                DateHelper.convert(
                        chamadoSelecionado.getDataAbertura()
                )

        );

        if (chamadoSelecionado.getDataFechamento() != null){
            dataFechamentoChamadoNaFilaTextView.setText(
                    DateHelper.convert(
                            chamadoSelecionado.getDataFechamento()
                    )
            );
        }
        filaIconImageView.setImageResource(
                chamadoSelecionado.getFila().getIconId()
        );

    }
}
