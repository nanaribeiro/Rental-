/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BancoDados;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sweet
 */
public class Operacoes {
    InteracaoDAO op= new InteracaoDAO();
    ResultSet resultado;
    String sql;
    boolean blnAt=true;
    //Seta o usuário root padrão
    public void Setroot() throws SQLException{
        sql="Select * from bancodados where Programa='SetRoot' and Flag=true; ";
        resultado=op.InteracaoDAO(sql);
        while(resultado.next()){
            blnAt = !resultado.getString("Programa").equals("SetRoot") || !resultado.getBoolean("Flag");

        }
        if (blnAt){
            sql="Insert into funcionarios(Matricula, Senha, Nome, Endereco, Telefone, CPF) values (111111, '123', 'root', 's/e', '000','0'); ";
            op.Query(sql);
            sql="Insert into bancodados(Programa, Flag) values ('SetRoot', true); ";
            op.Query(sql);
            op.close();
        }
    }
}
