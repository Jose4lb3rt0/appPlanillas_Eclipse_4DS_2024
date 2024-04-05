package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bean.Empleado;
import dao.EmpleadoDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JTextField txtUsuario;
	JPasswordField txtPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBackground( new Color(94, 17, 90) );
		pnlLogin.setBounds(0, 0, 400, 50);
		pnlLogin.setLayout(null);
		getContentPane().add(pnlLogin);
		
		JLabel imgLogo = new JLabel();
		imgLogo.setIcon(new ImageIcon(frmLogin.class.getResource("/ui/img/logo.png")));
		imgLogo.setBounds(96, 3, 208, 43);
		pnlLogin.add(imgLogo);
		
		JLabel imgSalir = new JLabel();
		imgSalir.setIcon(new ImageIcon(frmLogin.class.getResource("/ui/img/salir.png")));
		imgSalir.setBounds(370, 12, 24, 24);
		pnlLogin.add(imgSalir);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(100, 100, 80, 30);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(100, 140, 80, 30);
		getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(180, 100, 100, 30);
		txtUsuario.setColumns(8);
		txtUsuario.setMargin(new Insets(5, 10, 5, 10));
		getContentPane().add(txtUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(180, 140, 100, 30);
		txtPassword.setColumns(6);
		txtPassword.setMargin(new Insets(5, 10, 5, 10));
		getContentPane().add(txtPassword);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground( new Color(94, 17, 90) );
		btnIniciar.setBorderPainted(false);
		btnIniciar.setBounds(80, 200, 100, 30);
		btnIniciar.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		btnIniciar.setFocusPainted(false);
		btnIniciar.setForeground( Color.WHITE );
		getContentPane().add(btnIniciar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground( new Color(94, 17, 90) );
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBounds(220, 200, 100, 30);
		btnCancelar.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		btnCancelar.setFocusPainted(false);
		btnCancelar.setForeground( Color.WHITE );
		getContentPane().add(btnCancelar);		
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { btnIniciar_actionPerformed(); } });
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override public void mouseEntered(MouseEvent e) { btn_mouseEntered(btnIniciar); }
			@Override public void mouseExited(MouseEvent e) { btn_mouseExited(btnIniciar); } });
		btnIniciar.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) { btn_mouseEntered(btnIniciar); }
			@Override public void focusLost(FocusEvent e) { btn_mouseExited(btnIniciar); } });		

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { btnCancelar_actionPerformed(); } });
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override public void mouseEntered(MouseEvent e) { btn_mouseEntered(btnCancelar); }
			@Override public void mouseExited(MouseEvent e) { btn_mouseExited(btnCancelar); } });
		btnCancelar.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) { btn_mouseEntered(btnCancelar); }
			@Override public void focusLost(FocusEvent e) { btn_mouseExited(btnCancelar); } });		

		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override public void keyTyped(KeyEvent e) { txt_keyTyped(e); } });
		
		txtPassword.addKeyListener(new KeyAdapter() { 
			@Override public void keyTyped(KeyEvent e) { txt_keyTyped(e);} });
		
		imgSalir.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { imgSalir_mouseClicked(); } });
	}

	protected void txt_keyTyped(KeyEvent e) {
		JTextField txt = (JTextField) e.getSource();
		char letra = e.getKeyChar();
		
		if ( !Character.isDigit(letra) || txt.getText().length() >= txt.getColumns() )
			e.consume();
	}

	protected void btn_mouseEntered(JButton btn) {
		btn.setBackground( Color.BLACK );
	}

	protected void btn_mouseExited(JButton btn) {
		btn.setBackground( new Color(94, 17, 90) );
	}

	protected void btnIniciar_actionPerformed() {
		String sDni = txtUsuario.getText();
		String sPassword = String.valueOf( txtPassword.getPassword() );
		
		if ( sDni.isEmpty() || sPassword.isEmpty() ||
			 sDni.length() < 8 || sPassword.length() < 6 ) {
			btnCancelar_actionPerformed();
			JOptionPane.showMessageDialog(this, "Usuario y/o password inválidos");
			return;
		}
		
		Empleado empleado = new Empleado();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		
		empleado.setDni( sDni );
		empleado.setPassword( sPassword );
		if ( empleadoDAO.Login(empleado) ) {
			frmPlanilla frame = new frmPlanilla();
			frame.setEmpleado( empleado );
			frame.setVisible(true);
		} else {
			btnCancelar_actionPerformed();
			JOptionPane.showMessageDialog(this, "Usuario y/o password inválidos");
		}		
	}

	protected void btnCancelar_actionPerformed() {
		txtUsuario.setText("");
		txtPassword.setText("");
		txtUsuario.requestFocus();
	}
	
	protected void imgSalir_mouseClicked() {
		if ( JOptionPane.showConfirmDialog(this, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION )
			System.exit(0);
	}
}