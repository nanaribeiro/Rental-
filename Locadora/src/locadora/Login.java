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
import javax.swing.border.Border;


public class Login implements ActionListener{

    JDialog frmLogin=new JDialog();
    String sql;
    String Senha;
    String strAux;
    GridBagLayout layout;
    boolean test;
    JPanel jplLogin, jplSenha, jplLicenca, jplBotao;
    JButton cmdLogin = new JButton("   Login   ");
    JButton cmdAlterar=new JButton("  Alterar  ");
    JButton cmdCancelar=new JButton("Cancelar");
    private JLabel lblMatricula, lblSenha, lblLogin, lblLicenca, lblFuncionario, lblIcon, lblProduto, lblIconProg;
    private JLabel lblPicture;
    JTextField txtMatricula= new JTextField(15);
    private JPasswordField pswSenha;
    void LayoutLogin() {

        layout = new GridBagLayout();
        Color lavender = new Color(230,230,250);
        Color ghostWhite = new Color(248,248,255);
        
        //Adiciona os componentes no JDialog
        Container container = frmLogin.getContentPane();
        container.setLayout(layout);
        container.setPreferredSize(new Dimension(440,440));
        container.setBackground(lavender);
        
        //ICONE
        Icon ic=new ImageIcon("loginn.png");
        lblLogin=new JLabel();
        lblLogin.setIcon(ic);
        lblLogin.setText("LOGIN");
        lblLogin.setFont(new Font("Dialog", Font.BOLD, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(20, 45, 0, 0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        container.add(lblLogin,gbc);
        
        //1º TEXTO
        lblIcon=new JLabel("Digite sua matrícula e senha:");
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth=GridBagConstraints.REMAINDER;
        container.add(lblIcon, gbc2);
        
        //TEXTO LICENÇA
        lblLicenca=new JLabel("Licença");
        Border paddingBorder = BorderFactory.createEmptyBorder(0,40,0,40);
        Border border = BorderFactory.createLineBorder(ghostWhite);
        lblLicenca.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth=GridBagConstraints.REMAINDER;
        gbc3.anchor = GridBagConstraints.BASELINE_TRAILING;
        gbc3.insets = new Insets(30, 0, 0, 45);
        //gbc3.weightx = 3;
        //gbc3.weighty = 3;
        container.add(lblLicenca, gbc3);
        
        //PAINEL LICENÇA
        jplLicenca=new JPanel();
        jplLicenca.setLayout(layout);//Layout como GridBagLayout
        jplLicenca.setBackground(ghostWhite);
        Border paddingBorder2 = BorderFactory.createEmptyBorder(0,15,10,0);
        Border border2 = BorderFactory.createLineBorder(Color.WHITE);
        jplLicenca.setBorder(BorderFactory.createCompoundBorder(border2, paddingBorder2));//Coloca borda no Painel
        lblProduto=new JLabel("Produto");
        lblProduto.setFont(new Font("Dialog", Font.BOLD, 14));
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridwidth=GridBagConstraints.REMAINDER;
        gbc4.insets = new Insets(0, 0, 0, 20);        
        jplLicenca.add(lblProduto, gbc4);
        
        Icon prog=new ImageIcon("icon.png");
        lblIconProg=new JLabel();
        lblIconProg.setIcon(prog);
        lblIconProg.setText("<html>Versão: 4.0 <br>Licenciado para DES-98</html>");
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth=GridBagConstraints.REMAINDER;
        //gbc5.anchor = GridBagConstraints.NORTH;
        gbc5.insets = new Insets(0, 0, 0, 78);  
        gbc5.ipadx=90;
        jplLicenca.add(lblIconProg, gbc5);

        
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridwidth=GridBagConstraints.REMAINDER;
        gbc6.anchor = GridBagConstraints.PAGE_START;
        //gbc7.insets = new Insets(30, 0, 150, 0);
        gbc6.weightx = 1;
        gbc6.weighty = 1;
        container.add(jplLicenca, gbc6);
        
        //Texto ID Funcionário
        lblFuncionario=new JLabel("Identificação do Funcionário");
        lblFuncionario.setBorder(BorderFactory.createLineBorder(ghostWhite, 1));
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridwidth=GridBagConstraints.REMAINDER;
        gbc7.anchor = GridBagConstraints.PAGE_START;
        gbc7.insets = new Insets(0, 0, 0, 187);
        container.add(lblFuncionario, gbc7);
        
        //PAINEL ID FUNCIONÁRIO
        jplLogin=new JPanel();
        jplLogin.setLayout(layout);
        jplLogin.setBackground(ghostWhite);
        Border paddingBorder3 = BorderFactory.createEmptyBorder(10,15,5,0);
        Border border3 = BorderFactory.createLineBorder(ghostWhite);
        jplLogin.setBorder(BorderFactory.createCompoundBorder(border3, paddingBorder3));
        lblPicture=new JLabel();
        Icon login=new ImageIcon("logo.png");
        lblPicture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblPicture.setIcon(login);
        GridBagConstraints gbc8 = new GridBagConstraints();
        //gbc8.gridwidth=GridBagConstraints.REMAINDER;
        gbc8.anchor = GridBagConstraints.PAGE_START;
        gbc8.insets = new Insets(0, 0, 10, 15);
        //gbc8.weightx = 1;
        //gbc8.weighty = 1;
        jplLogin.add(lblPicture, gbc8);
        
        //Matricula
        jplSenha=new JPanel();
        jplSenha.setLayout(layout);
        jplSenha.setBackground(ghostWhite);
        lblMatricula=new JLabel("Matricula");
        lblSenha=new JLabel("Senha         ");
        pswSenha=new JPasswordField(6);
        GridBagConstraints gbc9= new GridBagConstraints();
        gbc9.gridwidth=GridBagConstraints.REMAINDER;
        gbc9.insets=new Insets(0,0,0,50);
        jplSenha.add(lblMatricula,gbc9);
        
        GridBagConstraints gbc10= new GridBagConstraints();
        gbc10.gridwidth=GridBagConstraints.REMAINDER;
        gbc10.insets=new Insets(0,0,0,50);
        gbc10.ipadx=50;
        jplSenha.add(txtMatricula, gbc10);
        
        //Senha
        GridBagConstraints gbc11= new GridBagConstraints();
        gbc11.gridwidth=GridBagConstraints.REMAINDER;
        gbc11.insets=new Insets(0,0,0,40);
        jplSenha.add(lblSenha, gbc11);
        
        GridBagConstraints gbc12= new GridBagConstraints();
        gbc12.gridwidth=GridBagConstraints.REMAINDER;
        gbc12.insets=new Insets(0,0,0,50);
        gbc12.ipadx=50;
        jplSenha.add(pswSenha, gbc12);
        
        GridBagConstraints gbc13= new GridBagConstraints();
        jplLogin.add(jplSenha, gbc13);
        
        //Botões
        jplBotao=new JPanel();
        jplBotao.setBackground(ghostWhite);
        jplBotao.setLayout(layout);
        //Login
        GridBagConstraints gbc14= new GridBagConstraints();
        gbc14.gridwidth=GridBagConstraints.REMAINDER;
        gbc14.insets=new Insets(0,0,5,10);
        jplBotao.add(cmdLogin,gbc14);
        //Alterar
        GridBagConstraints gbc15= new GridBagConstraints();
        gbc15.gridwidth=GridBagConstraints.REMAINDER;
        gbc15.insets=new Insets(0,0,5,10);
        jplBotao.add(cmdAlterar, gbc15);
        //Cancelar
        GridBagConstraints gbc16= new GridBagConstraints();
        gbc16.gridwidth=GridBagConstraints.REMAINDER;
        gbc16.insets=new Insets(0,0,0,10);
        jplBotao.add(cmdCancelar, gbc16);
        
        GridBagConstraints gbc17= new GridBagConstraints();
        jplLogin.add(jplBotao, gbc17);
        
        GridBagConstraints gbc18 = new GridBagConstraints();
        gbc18.gridwidth=GridBagConstraints.PAGE_START;
        gbc18.anchor = GridBagConstraints.BELOW_BASELINE;
        gbc18.insets = new Insets(0, 0, 45, 0);
        //gbc9.weightx = 1;
        //gbc9.weighty = 1;
        container.add(jplLogin, gbc18);
        
        
        
        
        //Açoes
        cmdLogin.addActionListener(this);
        
        //Visual do formulário
        frmLogin.setBounds(50,50,440,440);
        frmLogin.setUndecorated(true);
        frmLogin.setVisible(true);
      
      
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
                if(pswSenha.getPassword().length !=0){
                try {
                    Senha=new String(pswSenha.getPassword());
                    InteracaoDAO teste= new InteracaoDAO();
                    ResultSet RS;
                    sql="Select * from funcionarios where Matricula= " + Integer.parseInt(txtMatricula.getText())+";";
                    RS = teste.InteracaoDAO(sql);
                    while(RS.next()){             
                        if(Senha.equals(RS.getString("Senha"))&& (Integer.parseInt(txtMatricula.getText())==(RS.getInt("Matricula")))){
                            
                            frmLogin.dispose();
                            test=true;
                            Principal unlock=new Principal();
                            //unlock.frmPrincipal.setEnabled(true);
                            unlock.layout();
                            
                    }
                    }
                    if(!test){
                        JOptionPane.showMessageDialog(null, "Login inválido!");
                    }
                    teste.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            
            
                else{
                        JOptionPane.showMessageDialog(null, "Digite a senha");
                        }
        }
            else{
                JOptionPane.showMessageDialog(null, "Digite a matrícula");
            }
            }
        }
}
