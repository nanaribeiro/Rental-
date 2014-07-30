/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package locadora;

import BancoDados.Operacoes;
import java.sql.SQLException;



/**
 *
 * @author alana.sasse
 */
public class Locadora {
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */

    public static void main(String[] args) throws SQLException{
        Operacoes op=new Operacoes();
        op.Setroot();
        Principal roda=new Principal();
        Login login=new Login();
        login.setLogin(true);
        login.LayoutLogin();
        roda.layout();

    }
    
}
