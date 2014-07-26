/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package locadora;


import BancoDados.InteracaoDAO;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author alana.sasse
 */
public class Login implements ActionListener{
<<<<<<< HEAD
    JDialog frmLogin=new JDialog();
    String sql;
    String strAux;
    boolean test;
    JButton cmdLogin = new JButton("Login");
    private JLabel lblMatricula, lblSenha;
    JTextField txtMatricula= new JTextField(15);
    private JPasswordField pswSenha;
    void LayoutLogin() {
        
        frmLogin.getContentPane().setLayout(new FlowLayout());
        cmdLogin.addActionListener(this);
        frmLogin.setBounds(50,50,300,300);
        lblMatricula=new JLabel("Matricula");
        lblSenha=new JLabel("Senha      ");
        pswSenha=new JPasswordField(6);
        frmLogin.getContentPane().add(lblMatricula);
        frmLogin.getContentPane().add(txtMatricula);
        frmLogin.getContentPane().add(lblSenha);
        frmLogin.getContentPane().add(pswSenha);
        frmLogin.getContentPane().add(cmdLogin);
        frmLogin.setUndecorated(true);
        frmLogin.setVisible(true);
=======
    
    JInternalFrame frmLogin=new JInternalFrame();
    
    JButton cmdLogin = new JButton("Login");
    JLabel label = new JLabel(frmLogin.getTitle(), JLabel.CENTER);
    void LayoutLogin() {
        cmdLogin.addActionListener((ActionListener) this);
        frmLogin.setBounds(25,25,300,300);
        
        frmLogin.add(label, BorderLayout.CENTER);
        frmLogin.getContentPane().add(cmdLogin);
        
        frmLogin.setVisible(true);
        
        
>>>>>>> 262e971b915cf147fe2c0bdd478d3d7078bcb967
        
      
    }
    @Override
    public void actionPerformed(ActionEvent event){
        /*Quando o funcionário clicar em login os dados serão comparados
        com os dados do banco de dados, se forem iguais o usuário acessará
        a tela principal
        */
        
        if (event.getSource() == cmdLogin){
          
            //Se o usuário não digitar a matricula não será executado as ações do botão
            if (txtMatricula.getText() != null && !txtMatricula.getText().equals("")) {
                try {
                    InteracaoDAO teste= new InteracaoDAO();
                    ResultSet RS;
                    sql="Select * from funcionarios where Matricula= " + Integer.parseInt(txtMatricula.getText())+";";
                    RS = teste.InteracaoDAO(sql);
                    while(RS.next()){
                        System.out.println(RS.getInt("Matricula"));
                        if(Integer.parseInt(txtMatricula.getText())==(RS.getInt("Matricula"))){
                            System.out.println(RS.getInt("Matricula"));
                            frmLogin.dispose();
                            test=true;
                            Principal unlock=new Principal();
                            //unlock.frmPrincipal.setEnabled(true);
                            unlock.layout(true);
                            
                    }
                        else{
                            JOptionPane.showMessageDialog(null, "Login inválido!");
                        }
                    }
                    teste.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            else{
                JOptionPane.showMessageDialog(null, "Digite a matrícula");
            }
        }
    }
}
