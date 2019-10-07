package javier_linde_m7_practica2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class MatriculacionAlumnos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatriculacionAlumnos frame = new MatriculacionAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MatriculacionAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Matricular");
		btnNewButton.setBounds(226, 82, 93, 28);
		panel.add(btnNewButton);
		DefaultListModel<String> modeloA = new DefaultListModel<String>();
		DefaultListModel<String> modeloB = new DefaultListModel<String>();
		modeloA.clear();
		modeloA.addElement("Jose Luis Pongo Mora");
		modeloA.addElement("Miguel Angelo Guerra");
		modeloA.addElement("Luis Enrique Salcedo");

		modeloB.clear();
		modeloB.addElement("Eugenio Clemente");

		JList<String> list = new JList<String>();
		list.setBounds(10, 37, 180, 186);
		list.setModel(modeloA);
		panel.add(list);

		JList<String> list_1 = new JList<String>();
		list_1.setBounds(352, 37, 180, 191);
		list_1.setModel(modeloB);
		panel.add(list_1);

		JButton btnNewButton_1 = new JButton("Quitar");
		btnNewButton_1.setBounds(226, 131, 93, 28);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Inscritos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 180, 32);
		panel.add(lblNewLabel);

		JLabel lblMatriculados = new JLabel("Matriculados");
		lblMatriculados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatriculados.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculados.setBounds(352, 0, 180, 32);
		panel.add(lblMatriculados);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<String> seleccionA = list.getSelectedValuesList();
				for (int i = 0; i < seleccionA.size(); i++) {
					nombre = seleccionA.get(i);
					modeloA.removeElement(nombre);
					modeloB.addElement(nombre);
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<String> seleccionB = list_1.getSelectedValuesList();
				for (int i = 0; i < seleccionB.size(); i++) {
					nombre = seleccionB.get(i);
					modeloB.removeElement(nombre);
					modeloA.addElement(nombre);
				}
			}
		});

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAadirAlumno = new JButton("Inscribir alumno");
		btnAadirAlumno.setBounds(230, 59, 189, 37);
		btnAadirAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					
				}else {
					modeloA.addElement(textField.getText());
					textField.setText("");
				}
				
			}
		});
		panel_1.add(btnAadirAlumno);

		JButton btnNewButton_2 = new JButton("Eliminar alumno");
		btnNewButton_2.setBounds(0, 163, 369, 45);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre="";
				System.out.println(list_1.getSelectedValuesList());
				List<String> seleccionB = list_1.getSelectedValuesList();
				List<String> seleccionA = list.getSelectedValuesList();
				if(seleccionA.size()!=0) {
					for(int i=0;i<seleccionA.size();i++) {
						nombre=seleccionA.get(i);
						modeloA.removeElement(nombre);
					}
					
				}else if(seleccionB.size()!=0) {
					for(int i=0;i<seleccionB.size();i++) {
						nombre=seleccionB.get(i);
						modeloB.removeElement(nombre);
					}
					
				}
				/*modeloA.removeElement();list_1.getSelectedValuesList();
				list.getSelectedValuesList();*/
				
			}
		});
		panel_1.add(btnNewButton_2);

		textField = new JTextField();
		textField.setBounds(10, 59, 196, 37);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblEscribaElNombre = new JLabel("Escriba el nombre del alumno a insertar: ");
		lblEscribaElNombre.setBounds(10, 11, 337, 37);
		panel_1.add(lblEscribaElNombre);

		JLabel lblParaEliminarUn = new JLabel("Para eliminar un alumno seleccionelo y presione el siguiente boton");
		lblParaEliminarUn.setHorizontalAlignment(SwingConstants.LEFT);
		lblParaEliminarUn.setBounds(10, 138, 417, 25);
		panel_1.add(lblParaEliminarUn);
	}
}
