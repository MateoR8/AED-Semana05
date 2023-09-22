package gui;

import java.awt.EventQueue;
import semana_05.ArregloNotas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Propuesto_5_1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnReportar;
	private JButton btnGenerar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto_5_1 frame = new Propuesto_5_1();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Propuesto_5_1() {
		setTitle("Propuesto_5_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(71, 11, 89, 23);
		contentPane.add(btnListar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(171, 11, 89, 23);
		contentPane.add(btnReportar);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(271, 11, 89, 23);
		contentPane.add(btnGenerar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 414, 406);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	
	ArregloNotas ae = new ArregloNotas(); 
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnReportar(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		txtS.setText("");
		for (int i=0; i<ae.tamanio(); i++){
 			imprimir("n[" + i + "] :  " + ae.obtener(i));
 	 	}
	}
	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		imprimir();    	
    	imprimir("Cantidad de notas                   :  " + ae.tamanio());
    	imprimir("Nota promedio                       :  " + ae.notaPromedio());
    	imprimir("Nota mayor                          :  " + ae.notaMayor());
    	imprimir("Nota menor                          :  " + ae.notaMenor());
    	imprimir("Cantidad de notas aprobatorias      :  " + ae.cantNotasAprobatorias());
    	imprimir("Cantidad de notas desaprobatorias   :  " + ae.cantNotasDesaprobatorias());
    	imprimir("Cantidad de notas mayores a 15      :  " + ae.cantNotasMayoresA15());
    	imprimir("Primera nota mayor o igual a 13     :  " + ae.posPrimeraNotaAprobatoria());
    	imprimir("Penultima nota menor a 13           :  " + ae.posPenultimaNotaDesaprobatoria());
	}
	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		ae.generarNotas();
		imprimir();
    	imprimir("Las notas han sido cambiadas. Pulse [Listar]");
	}
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}