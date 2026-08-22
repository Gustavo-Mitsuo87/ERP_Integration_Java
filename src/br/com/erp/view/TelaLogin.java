package br.com.erp.view;

import br.com.erp.controller.LoginController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JTextField email = new JTextField(30);
	private final JPasswordField senha = new JPasswordField(20);
	// private final LoginController controller;

	public TelaLogin() {
		super("Acesso - Sistema ERP");
		//controller = new LoginController(this);
		montar();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //(JFrame.EXIT_ON_CLOSE)
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private void montar() {
		JPanel componentes = new JPanel(new BorderLayout(10, 10));
		componentes.setBorder(BorderFactory.createEmptyBorder(18, 22, 18, 22));
		JLabel title = new JLabel("Sistema ERP", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));
		componentes.add(title, BorderLayout.NORTH);

		JPanel form = new JPanel(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();

		grid.insets = new Insets(6, 5, 6, 5);
		grid.anchor = GridBagConstraints.WEST;
		grid.gridx = 0;
		grid.gridy = 0;
		form.add(new JLabel("Email*:"), grid);
		grid.gridx = 1;
		form.add(email, grid);
		grid.gridx = 0;
		grid.gridy = 1;
		form.add(new JLabel("Senha*:"), grid);
		grid.gridx = 1;
		form.add(senha, grid);
		componentes.add(form);

		JPanel buttonArea = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton entrar = new JButton("Entrar"), sair = new JButton("Sair");

		buttonArea.add(entrar);
		buttonArea.add(sair);

		componentes.add(buttonArea, BorderLayout.SOUTH);
		setContentPane(componentes);
		// Para apertar a tecla enter e fazer o mesmo que clicar em entrar
		getRootPane().setDefaultButton(entrar);

		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
			}
		});

	}
	
	//Esse método futuramente irá para o controller
	private void sair() { 
	    if (
	      JOptionPane.showConfirmDialog(
	        this,
	        "Deseja encerrar o sistema?",
	        "Sair",
	        JOptionPane.YES_NO_OPTION
	      ) == JOptionPane.YES_OPTION
	    ) {
	      dispose();
	      System.exit(0);
	    }
	  }

	public JTextField getTxtEmail() {
		return email;
	}

	public JPasswordField getTxtSenha() {
		return senha;
	}

}
