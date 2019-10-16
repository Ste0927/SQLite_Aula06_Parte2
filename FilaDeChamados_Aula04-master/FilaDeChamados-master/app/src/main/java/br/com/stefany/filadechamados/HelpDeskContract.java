package br.com.stefany.filadechamados;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HelpDeskContract {


    private static List<Fila> filas;
    private static List <Chamado> chamados;

    static{
        filas = new ArrayList<>();
        filas.add (new Fila (1,
                "Desktops", R.drawable.ic_computer_black_24dp));
        filas.add (new Fila (2,
                "Telefonia",R.drawable.ic_phone_in_talk_black_24dp));
        filas.add (new Fila (3,
                "Redes",R.drawable.ic_network_check_black_24dp));
        filas.add (new Fila (4,
                "Servidores",R.drawable.ic_poll_black_24dp));
    }



    static{
        chamados = new ArrayList<>();
        chamados.add(new Chamado (
                1,
                filas.get(0),
                "Computador da secretária quebrado.",
                new Date(),
                null,
                "Aberto"
        ));
        chamados.add(new Chamado (
                2,
                filas.get(1),
                "Telefone não funciona.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                3,
                filas.get(2),
                "Manutenção no proxy.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                4,
                filas.get(3),
                "Lentidão generalizada.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (5,
                filas.get(4),
                "CRM",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                6,
                filas.get(4),
                "Gestão de Orçamento",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                7,
                filas.get(2),
                "Internet com lentidão",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                8,
                filas.get(4),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                9,
                filas.get(4),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
    }
    public static String createTableFila (){
        return String.format(
                Locale.getDefault(),
                "CREATE TABLE %s ( %s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER);",
                FilaContract.TABLE_NAME,
                FilaContract.COLUMN_NAME_ID,
                FilaContract.COLUMN_NAME_NOME,
                FilaContract.COLUMN_NAME_ICON_ID
        );
    }

    private HelpDeskContract (){}

    public static String createTableChamado (){
        return String.format(
                Locale.getDefault(),
                "CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY AUTOINCREMENT, %3$s TEXT, %4$s TEXT, %5$s INTEGER, %6$s INTEGER, %7$s INTEGER, FOREIGN KEY (%7$s) REFERENCES %8$s (%7$s) );",
                ChamadoContract.TABLE_NAME,
                ChamadoContract.COLUMN_NAME_ID,
                ChamadoContract.COLUMN_NAME_DESCRICAO,
                ChamadoContract.COLUMN_NAME_STATUS,
                ChamadoContract.COLUMN_NAME_DT_ABERTURA,
                ChamadoContract.COLUMN_NAME_DT_FECHAMENTO,
                FilaContract.COLUMN_NAME_ID,
                FilaContract.TABLE_NAME
        );
    }

    public static String insertFilas (){
        String t = "INSERT INTO %s (%s, %s, %s) VALUES (%d, '%s', %d);";
        StringBuilder sb = new StringBuilder("");
        for (Fila fila : filas){
            sb.append(
                    String.format(
                            Locale.getDefault(),
                            t,
                            FilaContract.TABLE_NAME,
                            FilaContract.COLUMN_NAME_ID,
                            FilaContract.COLUMN_NAME_NOME,
                            FilaContract.COLUMN_NAME_ICON_ID,
                            fila.getId(),
                            fila.getNome(),
                            fila.getIconId()
                    )
            );
        }
        return sb.toString();
    }

    public static String insertChamados (){
        String t =
                "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (%d, '%s', %d, %d, '%s', %d);";
        StringBuilder sb = new StringBuilder("");
        for (Chamado chamado : chamados){
            sb.append(
                    String.format(
                            Locale.getDefault(),
                            t,
                            ChamadoContract.TABLE_NAME,
                            ChamadoContract.COLUMN_NAME_ID,
                            ChamadoContract.COLUMN_NAME_DESCRICAO,
                            ChamadoContract.COLUMN_NAME_DT_ABERTURA,
                            ChamadoContract.COLUMN_NAME_DT_FECHAMENTO,
                            ChamadoContract.COLUMN_NAME_STATUS,
                            FilaContract.COLUMN_NAME_ID,
                            chamado.getId(),
                            chamado.getDescricao(),
                            chamado.getDataAbertura().getTime(),
                            chamado.getDataFechamento() == null ? null : chamado.getDataFechamento().getTime(),
                            chamado.getStatus(),
                            chamado.getFila().getId()
                    )
            );
        }
        return sb.toString();
    }



    public static class ChamadoContract implements BaseColumns {
        public static final String TABLE_NAME = "tb_chamado";
        public static final String COLUMN_NAME_ID = "id_chamado";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_DT_ABERTURA = "dt_abertura";
        public static final String COLUMN_NAME_DT_FECHAMENTO = "dt_fechamento";
        public static final String DROP_TABLE = String.format(
                Locale.getDefault(),
                "DROP TABLE %s",
                ChamadoContract.TABLE_NAME
        );

    }



    public static class FilaContract implements BaseColumns{

        public static final String TABLE_NAME = "tb_fila";
        public static final String COLUMN_NAME_ID = "id_fila";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_ICON_ID = "icon_id";
        public static final String DROP_TABLE = String.format(
                Locale.getDefault(),
                "DROP TABLE %s",
                FilaContract.TABLE_NAME
        );
    }
}
