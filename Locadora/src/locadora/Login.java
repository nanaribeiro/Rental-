/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package locadora;


import java.awt.BorderLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author alana.sasse
 */
public class Login implements ActionListener{
    
    JInternalFrame frmLogin=new JInternalFrame();
    
    JButton cmdLogin = new JButton("Login");
    JLabel label = new JLabel(frmLogin.getTitle(), JLabel.CENTER);
    void LayoutLogin() {
        cmdLogin.addActionListener((ActionListener) this);
        frmLogin.setBounds(25,25,300,300);
        
        frmLogin.add(label, BorderLayout.CENTER);
        frmLogin.getContentPane().add(cmdLogin);
        
        frmLogin.setVisible(true);
        
        
        
      
    }
    @Override
    public void actionPerformed(ActionEvent event){
        /*Quando o funcionário clicar em login os dados serão comparados
        com os dados do banco de dados, se forem iguais o usuário acessará
        a tela principal
        */
        
    }
}
