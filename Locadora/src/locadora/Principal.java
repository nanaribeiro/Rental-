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
public class Principal implements ActionListener  {
    //Janela Principal
    JFrame frmPrincipal=new JFrame("Locadora");
    
    
    //Barra de menu
    JMenuBar bmnuPrincipal= new JMenuBar();
    //Conjunto dos menus da barra de menu
    JMenu mnuPrincipal;
    //Itens de cada menu
    JMenuItem sair,porcliente,porfilme;
    JMenuItem cliente,locacao;
    JMenuItem filme;
    
    //Objeto Login
    Login log=new Login();
    //Desenha o layout principal
    void layout(boolean blnLock){
        
        //Cria um objeto do tipo JMenu e atribui o nome Geral
        mnuPrincipal=new JMenu("Geral");
        mnuPrincipal.setEnabled(blnLock);
        bmnuPrincipal.add(mnuPrincipal);  
        
        cliente = new JMenuItem("Cadastro de Clientes");
	mnuPrincipal.add(cliente); // adiciona cliente no mnuPrincipal 
        
	filme = new JMenuItem("Cadastro de Filmes");
	mnuPrincipal.add(filme); // adiciona filme a mnuPrincipal  
        
        //PESQUISAR
        mnuPrincipal = new JMenu("Pesquisar"); //add mnuPrincipal pesquisar
        mnuPrincipal.setEnabled(blnLock);
        bmnuPrincipal.add(mnuPrincipal); //add mnuPrincipal a barra
        
	porcliente = new JMenuItem("Por cliente"); //add item
        mnuPrincipal.add(porcliente);   //add ao mnuPrincipal 
        
	porfilme = new JMenuItem("Por filme");      //add item        
        mnuPrincipal.add(porfilme);     //add ao mnuPrincipal 
        
        //NOVA LOCAÇÃO
        mnuPrincipal = new JMenu("Nova Locação"); // add mnuPrincipal Sair  
        mnuPrincipal.setEnabled(blnLock);
        bmnuPrincipal.add(mnuPrincipal); // adiciona mnuPrincipal a barra

        locacao = new JMenuItem("Cliente"); // add novo item no mnuPrincipal
        mnuPrincipal.add(locacao); //add intem 

        //SAIR
        sair = new JMenuItem("Sair");  
        sair.setEnabled(blnLock);
        bmnuPrincipal.add(sair);
        
                
        //Remove a tela de login se o login der certo
        
        
        //Adiciona o menu à tela prinipal
        bmnuPrincipal.setEnabled(blnLock);
        frmPrincipal.add(bmnuPrincipal, BorderLayout.NORTH);
        
        frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Faz com que ao clicar no 'X' saia do programa
        
        
        //frmPrincipal.add(log.jdpDesktop, BorderLayout.CENTER);
        frmPrincipal.setExtendedState(MAXIMIZED_BOTH);//Faz com que a tela apareca maximizada ao inicializar
        frmPrincipal.setVisible(true);
        
        //Listeners dos controles
        sair.addActionListener(this);
        frmPrincipal.addWindowListener((WindowListener) this);
    }
    public void test(Boolean blnLock){
        frmPrincipal.setEnabled(blnLock);
    }
    
    @Override
    //Ação dos controles
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == sair){
            System.exit(JFrame.DO_NOTHING_ON_CLOSE);
	        	 }   
    }
    
}
