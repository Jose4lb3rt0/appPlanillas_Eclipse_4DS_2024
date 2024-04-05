package ui;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import bean.Empleado;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frmPlanilla extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	
	Empleado empleado = new Empleado();
	Thread thHora = new Thread(this);
	
	JLabel lblFecha, lblHora, lblUsuario;
	JDesktopPane dskPlanilla;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPlanilla frame = new frmPlanilla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public frmPlanilla() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, 1024, 768);
			getContentPane().setLayout(null);
			setLocationRelativeTo(null);
			setUndecorated(true);
			
			lblHora = new JLabel();
			lblHora.setBounds(900, 730, 100, 30);
			getContentPane().add(lblHora);
			

			lblFecha = new JLabel();
			lblFecha.setBounds(700, 730, 150, 30);
			getContentPane().add(lblFecha);
			
			lblUsuario = new JLabel();
			lblUsuario.setBounds(20, 730, 150, 30);
			getContentPane().add(lblUsuario);
			
			dskPlanilla = new JDesktopPane();
			dskPlanilla.setBounds(250, 51, 773, 668);
			getContentPane().add(dskPlanilla);
			
			addWindowListener(new WindowAdapter() {
			@Override public void windowOpened(WindowEvent e) {frame_windowOpened();}
			@Override public void windowClosed(WindowEvent e) {frame_windowClosed();}});
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
		
	}


	protected void frame_windowOpened() {
		lblUsuario.setText(String.format("Usuario : %s %s %s", empleado.getNombres(), empleado.getApellidoPaterno(), empleado.getApellidoMaterno()));
		lblFecha.setText( new SimpleDateFormat("'Fecha:' dd/MM/yy").format( new Date()));
		thHora.start();
		
		pnlCargo panel = new pnlCargo();
		dskPlanilla.removeAll();
		dskPlanilla.add(panel);
		panel.setVisible(true);
		
	}


	protected void frame_windowClosed() {
		thHora.interrupt();
		
	}


	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'Hora:' hh:mm:ss");
		while(true){
			lblHora.setText( simpleDateFormat.format( new Date()));
			try { Thread.sleep(1000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}

}