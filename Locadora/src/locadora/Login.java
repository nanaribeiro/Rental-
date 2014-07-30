/*
Criação: Alana Ribeiro      Data: 29/07/2014

Propósito: Fornecer segurança para o sistema, limitando o acesso a grupos de pessoas, protegendo os dados.
           Dividir tarefas, acesso ao sistema depende do nível de permissão de cada usuário 

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

    private JDialog frmLogin;
    private String strSql;
    private String strSenha;//Pega a senha do JPasswordField
    private GridBagLayout gblLayout;
    private boolean blnTest, blnChamada;//Mensagem de login inválido
    private JPanel jplLogin, jplSenha, jplLicenca, jplBotao;
    private JButton cmdLogin,cmdAlterar, cmdCancelar;
    private JLabel lblMatricula, lblSenha, lblLogin, lblLicenca, lblFuncionario, lblIcon, lblProduto, lblIconProg;
    private JLabel lblPicture;
    private JTextField txtMatricula;
    private JPasswordField pswSenha;
    void LayoutLogin() {

        frmLogin=new JDialog();
        frmLogin.setModal(true);
        cmdLogin = new JButton("   Login   ");
        cmdAlterar=new JButton("  Alterar  ");
        cmdCancelar=new JButton("Cancelar");
        txtMatricula= new JTextField(15);
        
        gblLayout = new GridBagLayout();
        //Cores de fundo
        Color corLavender = new Color(230,230,250);
        Color corGhostWhite = new Color(248,248,255);
        
        //Configura aparência JDialog
        Container cntLogin = frmLogin.getContentPane();
        cntLogin.setLayout(gblLayout);
        cntLogin.setPreferredSize(new Dimension(440,440));
        cntLogin.setBackground(corLavender);
        
        //ICONE Login
        Icon imgLogin=new ImageIcon("loginn.png");
        lblLogin=new JLabel();
        lblLogin.setIcon(imgLogin);
        lblLogin.setText("LOGIN");
        lblLogin.setFont(new Font("Dialog", Font.BOLD, 20));
        //Toda vez que é adicionado algo ao Painel e o Painel tenha o layout GridBag, temos que instanciar esse objeto
        //Esse objeto é responsável por fazer personalização de layout em cada componente que utilizar essa instancia
        GridBagConstraints gbcTopoLogin = new GridBagConstraints();
        gbcTopoLogin.anchor = GridBagConstraints.BASELINE_LEADING;
        gbcTopoLogin.insets = new Insets(20, 45, 0, 0);
        gbcTopoLogin.gridwidth=GridBagConstraints.REMAINDER;
        cntLogin.add(lblLogin,gbcTopoLogin);//Adiciona a label ao container definindo o Layout com as configurações
        
        //1º TEXTO
        lblIcon=new JLabel("Digite sua matrícula e senha:");
        
        GridBagConstraints gbcInstrucaoLogin = new GridBagConstraints();
        gbcInstrucaoLogin.gridwidth=GridBagConstraints.REMAINDER;
        
        cntLogin.add(lblIcon, gbcInstrucaoLogin);
        
        //TEXTO LICENÇA
        lblLicenca=new JLabel("Licença");
        Border paddingBorder = BorderFactory.createEmptyBorder(0,40,0,40);//Define dimensões da borda
        Border border = BorderFactory.createLineBorder(corGhostWhite);//Define cor da borda
        lblLicenca.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));//Cria uma borda com a aparência definida em border e paddingBord
        
        GridBagConstraints gbcLicencaLogin = new GridBagConstraints();
        gbcLicencaLogin.gridwidth=GridBagConstraints.REMAINDER;
        gbcLicencaLogin.anchor = GridBagConstraints.BASELINE_TRAILING;
        gbcLicencaLogin.insets = new Insets(30, 0, 0, 45);
        
        cntLogin.add(lblLicenca, gbcLicencaLogin);
        
        //PAINEL LICENÇA
        jplLicenca=new JPanel();
        jplLicenca.setLayout(gblLayout);//Layout como GridBagLayout
        jplLicenca.setBackground(corGhostWhite);
        Border paddingBorder2 = BorderFactory.createEmptyBorder(0,15,10,0);
        Border border2 = BorderFactory.createLineBorder(Color.WHITE);
        jplLicenca.setBorder(BorderFactory.createCompoundBorder(border2, paddingBorder2));//Coloca borda no Painel
        //Adiciona a label produto ao Painel
        lblProduto=new JLabel("Produto");
        lblProduto.setFont(new Font("Dialog", Font.BOLD, 14));
        
        GridBagConstraints gbcProdutoLogin = new GridBagConstraints();
        gbcProdutoLogin.gridwidth=GridBagConstraints.REMAINDER;
        gbcProdutoLogin.insets = new Insets(0, 0, 0, 20); 
        
        jplLicenca.add(lblProduto, gbcProdutoLogin);
        //Adiciona o icone do produto ao painel
        Icon prog=new ImageIcon("icon.png");
        lblIconProg=new JLabel();
        lblIconProg.setIcon(prog);
        lblIconProg.setText("<html>Versão: 4.0 <br>Licenciado para DES-98</html>");//Para fazer quebra de linha em uma label, deve-se usar HTML
        
        GridBagConstraints gbcLogoProduto = new GridBagConstraints();
        gbcLogoProduto.gridwidth=GridBagConstraints.REMAINDER;    
        gbcLogoProduto.insets = new Insets(0, 0, 0, 78);  
        gbcLogoProduto.ipadx=90;
        
        jplLicenca.add(lblIconProg, gbcLogoProduto);
        //Adiciona Painel ao JFrame
        GridBagConstraints gbcPrimeiroBloco = new GridBagConstraints();
        gbcPrimeiroBloco.gridwidth=GridBagConstraints.REMAINDER;
        gbcPrimeiroBloco.anchor = GridBagConstraints.PAGE_START;  
        gbcPrimeiroBloco.weightx = 1;
        gbcPrimeiroBloco.weighty = 1;
        
        cntLogin.add(jplLicenca, gbcPrimeiroBloco);
        
        //Texto ID Funcionário
        lblFuncionario=new JLabel("Identificação do Funcionário");
        lblFuncionario.setBorder(BorderFactory.createLineBorder(corGhostWhite, 1));
        //Adiciona texto ao JFrame
        GridBagConstraints gbcMensagem2Bloco = new GridBagConstraints();
        gbcMensagem2Bloco.gridwidth=GridBagConstraints.REMAINDER;
        gbcMensagem2Bloco.anchor = GridBagConstraints.PAGE_START;
        gbcMensagem2Bloco.insets = new Insets(0, 0, 0, 187);
        
        cntLogin.add(lblFuncionario, gbcMensagem2Bloco);
        
        //PAINEL ID FUNCIONÁRIO
        jplLogin=new JPanel();
        jplLogin.setLayout(gblLayout);
        jplLogin.setBackground(corGhostWhite);
        Border paddingBorder3 = BorderFactory.createEmptyBorder(10,15,5,0);
        Border border3 = BorderFactory.createLineBorder(corGhostWhite);
        jplLogin.setBorder(BorderFactory.createCompoundBorder(border3, paddingBorder3));
        lblPicture=new JLabel();
        Icon login=new ImageIcon("logo.png");//Logotipo da empresa
        lblPicture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblPicture.setIcon(login);
        //Adiciona a logo da empresa ao Painel
        GridBagConstraints gbcLogoEmp = new GridBagConstraints();    
        gbcLogoEmp.anchor = GridBagConstraints.PAGE_START;
        gbcLogoEmp.insets = new Insets(0, 0, 10, 15);
        
        jplLogin.add(lblPicture, gbcLogoEmp);
        
        //Matricula
        jplSenha=new JPanel();
        jplSenha.setLayout(gblLayout);
        jplSenha.setBackground(corGhostWhite);
        lblMatricula=new JLabel("Matricula");
        lblSenha=new JLabel("Senha         ");
        pswSenha=new JPasswordField(6);
        //Adiciona texto ao Painel
        GridBagConstraints gbcLogin= new GridBagConstraints();
        gbcLogin.gridwidth=GridBagConstraints.REMAINDER;
        gbcLogin.insets=new Insets(0,0,0,50);
        
        jplSenha.add(lblMatricula,gbcLogin);
        //Adiciona JTextField Matricula ao Painel
        GridBagConstraints gbcLoginTexto= new GridBagConstraints();
        gbcLoginTexto.gridwidth=GridBagConstraints.REMAINDER;
        gbcLoginTexto.insets=new Insets(0,0,0,50);
        gbcLoginTexto.ipadx=50;
        
        jplSenha.add(txtMatricula, gbcLoginTexto);
        
        //Adiciona texto Senha ao Painel
        GridBagConstraints gbcLoginSenha= new GridBagConstraints();
        gbcLoginSenha.gridwidth=GridBagConstraints.REMAINDER;
        gbcLoginSenha.insets=new Insets(0,0,0,40);
        
        jplSenha.add(lblSenha, gbcLoginSenha);
        //Adiciona JPasswordField ao Painel
        GridBagConstraints gbcSenha= new GridBagConstraints();
        gbcSenha.gridwidth=GridBagConstraints.REMAINDER;
        gbcSenha.insets=new Insets(0,0,0,50);
        gbcSenha.ipadx=50;
        
        jplSenha.add(pswSenha, gbcSenha);
        //Adiciona o painel ao Painel Login
        GridBagConstraints gbcFuncLogin= new GridBagConstraints();
        jplLogin.add(jplSenha, gbcFuncLogin);
        
        //Botões
        jplBotao=new JPanel();
        jplBotao.setBackground(corGhostWhite);
        jplBotao.setLayout(gblLayout);
        //Login
        GridBagConstraints gbcLoginBotao= new GridBagConstraints();
        gbcLoginBotao.gridwidth=GridBagConstraints.REMAINDER;
        gbcLoginBotao.insets=new Insets(0,0,5,10);
        
        jplBotao.add(cmdLogin,gbcLoginBotao);
        //Alterar
        GridBagConstraints gbcAlterarBotao= new GridBagConstraints();
        gbcAlterarBotao.gridwidth=GridBagConstraints.REMAINDER;
        gbcAlterarBotao.insets=new Insets(0,0,5,10);
        
        jplBotao.add(cmdAlterar, gbcAlterarBotao);
        //Cancelar
        GridBagConstraints gbcCancelarBotao= new GridBagConstraints();
        gbcCancelarBotao.gridwidth=GridBagConstraints.REMAINDER;
        gbcCancelarBotao.insets=new Insets(0,0,0,10);
        
        jplBotao.add(cmdCancelar, gbcCancelarBotao);
        //Adiciona o painel dos botões ao painel Login
        GridBagConstraints gbcAddBotao= new GridBagConstraints();
        
        jplLogin.add(jplBotao, gbcAddBotao);
        //Adiciona o último painel ao JFrame
        GridBagConstraints gbcAddLogin = new GridBagConstraints();
        gbcAddLogin.gridwidth=GridBagConstraints.PAGE_START;
        gbcAddLogin.anchor = GridBagConstraints.BELOW_BASELINE;
        gbcAddLogin.insets = new Insets(0, 0, 45, 0);  
        
        cntLogin.add(jplLogin, gbcAddLogin);
        

        //Açoes
        cmdLogin.addActionListener(this);
        cmdAlterar.addActionListener(this);
        cmdCancelar.addActionListener(this);
        
        //Visual do formulário
        frmLogin.setSize(440,440);
        frmLogin.setLocationRelativeTo(null);
        frmLogin.setUndecorated(true);//Tira a decoração da janela(título, botões padrão)
        frmLogin.setVisible(true);
      
      
    }
    public void setLogin(boolean blnChamada){
        this.blnChamada=blnChamada;
        
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
                    strSenha=new String(pswSenha.getPassword());
                    InteracaoDAO teste= new InteracaoDAO();
                    ResultSet RS;
                    strSql="Select * from funcionarios where Matricula= " + Integer.parseInt(txtMatricula.getText())+";";
                    RS = teste.InteracaoDAO(strSql);
                    while(RS.next()){             
                        if(strSenha.equals(RS.getString("Senha"))&& (Integer.parseInt(txtMatricula.getText())==(RS.getInt("Matricula")))){
                            
                            frmLogin.dispose();
                            blnTest=true;                            
                    }
                    }
                    if(!blnTest){
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
        else if(event.getSource() ==cmdAlterar){
            frmAlterarSenha alterar=new frmAlterarSenha();
            alterar.LayoutAltSenha();
        }
        else if(event.getSource()==cmdCancelar){
            if(blnChamada){
                System.exit(0);
            }
        }
        }
}
