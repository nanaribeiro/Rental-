/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package locadora;



/**
 *
 * @author alana.sasse
 */
public class Locadora {
    
    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD
    public static void main(String[] args){
        Principal roda=new Principal();
        Login login=new Login();
        login.LayoutLogin();
        
=======
    public static void main(String[] args) {
        Conexao.geConexao();
        Principal roda=new Principal();
        roda.layout();
>>>>>>> 262e971b915cf147fe2c0bdd478d3d7078bcb967
        // TODO code application logic here
    }
    
}
