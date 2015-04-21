import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField valorEuros;
	private JTextField valorConvertido;
	private JTextField smsInfo;

	public Conversor() {
		setTitle("Ventana Conversion v4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel condicion = new JLabel("Introducir un valor entre 0 y 500");
		condicion.setBounds(6, 31, 290, 16);
		contentPane.add(condicion);
		
		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(6, 59, 61, 16);
		contentPane.add(lblEuros);
		
		valorEuros = new JTextField();
		valorEuros.setBounds(6, 84, 134, 28);
		contentPane.add(valorEuros);
		valorEuros.setColumns(10);
		
		JComboBox lista = new JComboBox();
		lista.setModel(new DefaultComboBoxModel(new String[] {"Dolares", "Euros", "Libras", "Yenes"}));
		lista.setBounds(6, 124, 134, 27);
		contentPane.add(lista);
		
		valorConvertido = new JTextField();
		valorConvertido.setBounds(6, 162, 134, 28);
		contentPane.add(valorConvertido);
		valorConvertido.setColumns(10);
		
		JButton boton = new JButton("Convertir");
		boton.setBounds(158, 163, 117, 29);
		contentPane.add(boton);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosGenerales dg = new DatosGenerales();
				if(dg.esNumero(valorEuros.getText())){
					Float euro = Float.parseFloat(valorEuros.getText());
					if(euro >= 0 && euro <= 500){
						switch((String)lista.getSelectedItem()){
						case "Dolares":
							valorConvertido.setText(String.valueOf(dg.calculoConversion(euro, 0)));
							smsInfo.setText(dg.muestraMensaje(0));
							break;
						case "Euros":
							valorConvertido.setText(String.valueOf(dg.calculoConversion(euro, 1)));
							smsInfo.setText(dg.muestraMensaje(1));
							break;
						case "Libras":
							valorConvertido.setText(String.valueOf(dg.calculoConversion(euro, 2)));
							smsInfo.setText(dg.muestraMensaje(2));
							break;
						case "Yenes":
							valorConvertido.setText(String.valueOf(dg.calculoConversion(euro, 3)));
							smsInfo.setText(dg.muestraMensaje(3));
							break;
						}
					}else{
						smsInfo.setText("El valor introducido de euros debe estar entre 0 y 500.");
					}
				}else{
					smsInfo.setText("El valor introducido no es numérico.");
				}
			}
		});
		
		JLabel lblMensajeDeControl = new JLabel("Mensaje de control");
		lblMensajeDeControl.setBounds(6, 202, 134, 16);
		contentPane.add(lblMensajeDeControl);
		
		smsInfo = new JTextField();
		smsInfo.setBounds(6, 230, 438, 28);
		contentPane.add(smsInfo);
		smsInfo.setColumns(10);
		
		lista.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				smsInfo.setText("Moneda seleccionada: "+lista.getSelectedItem());
			}
		});
	}

}
