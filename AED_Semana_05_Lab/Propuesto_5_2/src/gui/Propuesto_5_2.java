package gui;

import java.awt.EventQueue;
import semana_05.ArregloPrecios;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Propuesto_5_2 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnReportar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnGenerar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto_5_2 frame = new Propuesto_5_2();
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
	public Propuesto_5_2() {
		setTitle("Propuesto_5_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(10, 11, 95, 23);
		contentPane.add(btnListar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(170, 11, 95, 23);
		contentPane.add(btnReportar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 414, 406);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(329, 11, 95, 23);
		contentPane.add(btnGenerar);
	}
	
	ArregloPrecios ap = new ArregloPrecios();
	DecimalFormat unDecimal = new DecimalFormat("#.#");
	
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
		for (int i=0; i<ap.tamanio(); i++){
 			imprimir("n[" + i + "] :  " + unDecimal.format(ap.obtener(i)));
 	 	}
	}
	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		imprimir();    	
    	imprimir("Cantidad de Precios                                                     :  " + ap.tamanio());
    	imprimir("Precio promedio                                                         :  " + unDecimal.format(ap.precioPromedio()));
    	imprimir("Precio mayor                                                            :  " + unDecimal.format(ap.precioMayor()));
    	imprimir("Precio menor                                                            :  " + unDecimal.format(ap.precioMenor()));
    	imprimir("Cantidad de productos cuyo precio es mayor o igual al precio promedio   :  " + ap.cantMayoresPrecioPromedio());
    	imprimir("Cantidad de productos cuyo precio es menor al precio promedio           :  " + ap.cantMenoresPrecioPromedio());
    	imprimir("Posición del primer precio mayor al segundo de los precios              :  " + ap.posPrimerPrecioMayorAlSegundo());
    	imprimir("Posición del ultimo precio menor al penultimo de los precios            :  " + ap.posUltimoPrecioMenorAlPenultimo());
	}
	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		ap.generarPrecios();
		imprimir();
    	imprimir("Los Precios han sido cambiados. Pulse [Listar]");
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