/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package locadora;

import BancoDados.Conexao;

/**
 *
 * @author alana.sasse
 */
public class Locadora {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao.geConexao();
        Principal roda=new Principal();
        roda.layout();
        // TODO code application logic here
    }
    
}
