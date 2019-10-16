package br.com.stefany.filadechamados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bossini.usjt_ccp3bn_mcb_fila_de_chamados.R;

public class ListaChamadosActivity extends AppCompatActivity {

    private ListView chamadosListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        List <Chamado> chamados = buscaChamados(nomeFila);
        chamadosListView = findViewById(R.id.chamadosListView);

        ChamadoAdapter adapter = new ChamadoAdapter(this, chamados);
        chamadosListView.setAdapter(adapter);

        chamadosListView.setOnItemClickListener((
                adapterView, view, position, id
        ) -> {
            Chamado chamadoSelecionado = chamados.get(position);
            Intent intent
                    = new Intent (this,
                    DetalhesChamadoActivity.class);
            intent.putExtra(
                    "chamado_selecionado",
                    chamadoSelecionado);
            startActivity(intent);

        });
    }

    public List <Chamado> geraListaChamados (){
        List <Chamado> chamados = new ArrayList<>();
        chamados.add(
                new Chamado (
                        new Fila ("Desktops",
                                R.drawable.ic_computer_black_24dp),
                        "Computador da secretária quebrado",
                        new Date(),
                        null,
                        "Aberto"

                )
        );
        chamados.add(new Chamado (
                new Fila ("Telefonia",
                        R.drawable. ic_phone_in_talk_black_24dp ),
                "Telefone não funciona.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable. ic_network_check_black_24dp ),
                "Manutenção no proxy.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Servidores", R.drawable. ic_poll_black_24dp ),
                "Lentidão generalizada.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable. ic_new_releases_black_24dp ),
                "CRM",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable. ic_new_releases_black_24dp ),
                "Gestão de Orçamento",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable. ic_network_check_black_24dp ),
                "Internet com lentidão",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable. ic_new_releases_black_24dp ),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (new Fila ("Novos Projetos",
                R.drawable. ic_new_releases_black_24dp ),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        return chamados;
    }

     "Telefonia: liberar celular");
        lista.add("Telefonia: mover ramal");
        lista.add("Redes: ponto com defeito");
        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }*/

    public List <Chamado> buscaChamados (String chave){
        List <Chamado> resultado = new ArrayList<>();
        if (chave == null || chave.isEmpty())
            return resultado;
        for (Chamado chamado: geraListaChamados()){
            if (chamado.getFila().getNome().toLowerCase().contains(chave.toLowerCase()))
                resultado.add(chamado);
        }
        return resultado;
    }
}
