/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package locadora;

import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author alana.sasse
 */

   
   
public class Principal implements ActionListener {
    //Janela Principal
    JFrame frmPrincipal=new JFrame("Locadora");
    
    JDesktopPane jdpDesktop=new JDesktopPane();
    //Barra de menu
    JMenuBar bmnuPrincipal= new JMenuBar();
    //Conjunto dos menus da barra de menu
    JMenu mnuPrincipal, mnuSub;
    //Itens de cada menu
    JMenuItem sair,porcliente,porfilme;
    JMenuItem cliente,locacao, permissoes;
    JMenuItem filme, login;
    
    //Desenha o layout principal
    void layout(){
        
        //Cria um objeto do tipo JMenu e atribui o nome Geral
        mnuPrincipal=new JMenu("Geral");
        bmnuPrincipal.add(mnuPrincipal);  

        //Cria um objeto do tipo JMenu e atribui o nome Geral
  
        //submenu
        mnuSub = new JMenu("Cadastro");
        filme = new JMenuItem("Filmes");
        mnuSub.add(filme);
        cliente=new JMenuItem("Clientes");
        mnuSub.add(cliente);
        mnuPrincipal.add(mnuSub);
        //Item do Menu
        permissoes=new JMenuItem("Permissões");
        mnuPrincipal.add(permissoes);
        login=new JMenuItem("Novo Login");
        mnuPrincipal.add(login);
        
        //PESQUISAR
        mnuPrincipal = new JMenu("Pesquisar"); //add mnuPrincipal pesquisar
        bmnuPrincipal.add(mnuPrincipal); //add mnuPrincipal a barra
        
	porcliente = new JMenuItem("Por cliente"); //add item
        mnuPrincipal.add(porcliente);   //add ao mnuPrincipal 
        
	porfilme = new JMenuItem("Por filme");      //add item        
        mnuPrincipal.add(porfilme);     //add ao mnuPrincipal 
        
        //NOVA LOCAÇÃO

        mnuPrincipal = new JMenu("Nova Locação"); // add mnuPrincipal Sair
        bmnuPrincipal.add(mnuPrincipal); // adiciona mnuPrincipal a barra


        //SAIR
        sair = new JMenuItem("Sair");  
        bmnuPrincipal.add(sair);
        
                
        //Remove a tela de login se o login der certo
        
        
        //Adiciona o menu à tela prinipal
        frmPrincipal.add(bmnuPrincipal, BorderLayout.NORTH);
        
        frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Faz com que ao clicar no 'X' saia do programa

        frmPrincipal.setExtendedState(MAXIMIZED_BOTH);//Faz com que a tela apareca maximizada ao inicializar
        frmPrincipal.setVisible(true);
        
        //Listeners dos controles
        sair.addActionListener(this);
        
    }
    

    @Override
    //Ação dos controles
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == sair){
            System.exit(JFrame.DO_NOTHING_ON_CLOSE);
	        	 }   
    }

}
