/*
Criação: Alana Ribeiro      Data: 30/07/2014

Propósito: Alterar a senha de login de modo rápido e prático.
  

 */

package locadora;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author alana.sasse
 */
public class frmAlterarSenha {
    private Border loweredbevel;
    private TitledBorder brdAltSenha, brdOption;
    private JDialog frmAltSenha;
    private GridBagLayout gblLayout;
    private JPanel jplAltSenha, jplOption;
    private JLabel lblLogin, lblNovaSenha, lblRedSenha;
    private JTextField txtLogin;
    private JPasswordField pswNovaSenha, pswRedSenha;
    private JButton cmdGravar, cmdCancelar;
    void LayoutAltSenha(){
        frmAltSenha=new JDialog();
        frmAltSenha.setTitle("Alteração de senha");
        frmAltSenha.setModal(true);
        
        gblLayout=new GridBagLayout();        
        Container cntAlterarSenha=frmAltSenha.getContentPane();
        cntAlterarSenha.setLayout(gblLayout);
        
        //PAINEL ALTERAÇÃO SENHA
        jplAltSenha=new JPanel();
        jplAltSenha.setLayout(gblLayout);
        loweredbevel=BorderFactory.createLoweredBevelBorder();
        brdAltSenha=BorderFactory.createTitledBorder(loweredbevel,"Alteração Senha");
        brdAltSenha.setTitleJustification(TitledBorder.LEFT);
        jplAltSenha.setBorder(brdAltSenha);
        //Cria label Login:
        lblLogin=new JLabel("Login:");
        //Layout da label
        GridBagConstraints gbcLogin=new GridBagConstraints();
        gbcLogin.insets = new Insets(0, 0, 0, 60);
        //Adiciona label ao Painel
        jplAltSenha.add(lblLogin, gbcLogin);
        //Cria JTextField de Login
        txtLogin=new JTextField(6);
        //Layout da caixe de texto de login
        GridBagConstraints gbcTxtLogin=new GridBagConstraints();
        gbcTxtLogin.gridwidth=GridBagConstraints.REMAINDER;
        //Adiciona JTextField de login ao Painel
        jplAltSenha.add(txtLogin, gbcTxtLogin);
        //Cria label Senha
        lblNovaSenha=new JLabel("Nova Senha:");
        //Layout da Label NovaSenha
        GridBagConstraints gbcNovaSenha = new GridBagConstraints(); 
        gbcNovaSenha.insets= new Insets(0,0,0,25);
        //Adiciona label Nova Senha ao Painel
        jplAltSenha.add(lblNovaSenha, gbcNovaSenha);
        //Cria JPasswordField de nova senha
        pswNovaSenha=new JPasswordField(6);
        //Layout do JPassword nova senha
        GridBagConstraints gbcPswNovaSenha=new GridBagConstraints();
        gbcPswNovaSenha.gridwidth=GridBagConstraints.REMAINDER;
        //Adiciona JPasswordField Nova senha ao painel
        jplAltSenha.add(pswNovaSenha, gbcPswNovaSenha);
        //Cria label RedSenha
        lblRedSenha=new JLabel("Redigite a senha:");
        //Layout da label RedSenha
        GridBagConstraints gbcRedSenha=new GridBagConstraints();
        //Adiciona label RedSenha ao painel
        jplAltSenha.add(lblRedSenha, gbcRedSenha);
        //Cria JPasswordField RedSenha
        pswRedSenha=new JPasswordField(6);
        //layout do JPass RedSenha
        GridBagConstraints gbcPswRedSenha= new GridBagConstraints();
        //Adiciona JPass RedSenha ao painel
        jplAltSenha.add(pswRedSenha, gbcPswRedSenha);
        //Layout do painel de alteração de senha
        GridBagConstraints gbcPainelAltSenha = new GridBagConstraints();
        //gbcPainelAltSenha.gridwidth=GridBagConstraints.REMAINDER;
        gbcPainelAltSenha.insets = new Insets(0, 0, 0, 15);
        gbcPainelAltSenha.ipady=20;
        //gbcPainelAltSenha.ipadx=100;
        //Adiciona Painel AltSenha no container
        cntAlterarSenha.add(jplAltSenha, gbcPainelAltSenha);
        
        //PAINEL OPÇÕES
        jplOption=new JPanel();
        jplOption.setLayout(gblLayout);
        brdOption=BorderFactory.createTitledBorder(loweredbevel,"Opções");
        brdOption.setTitleJustification(TitledBorder.LEFT);
        jplOption.setBorder(brdOption);
        //Cria botão gravar
        cmdGravar=new JButton("Gravar");
        //Layout do botão gravar
        GridBagConstraints gbcGravar=new GridBagConstraints();
        gbcGravar.gridwidth=GridBagConstraints.REMAINDER;
        gbcGravar.ipadx=13;
        //Adiciona botão gravar ao painel de opções
        jplOption.add(cmdGravar, gbcGravar);
        //Cria botão Cancelar 
        cmdCancelar=new JButton("Cancelar");
        //Layout do botão cancelar
        GridBagConstraints gbcCancelar=new GridBagConstraints();        
        //Adiciona botão cancelar ao painel de opções
        jplOption.add(cmdCancelar, gbcCancelar);
        
        //Layout do Painel de Opções
        GridBagConstraints gbcOption=new GridBagConstraints();
        gbcOption.ipady=30;
        gbcOption.ipadx=10;
        //Adiciona painel de opções ao container
        cntAlterarSenha.add(jplOption, gbcOption);
        
        frmAltSenha.setSize(370,170);
        frmAltSenha.setLocationRelativeTo(null);
        frmAltSenha.setVisible(true);
        
    }
    
}
