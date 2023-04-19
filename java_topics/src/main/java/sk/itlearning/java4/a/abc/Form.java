package sk.itlearning.java4.a.abc;

import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Form {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Form");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		JPanel panel = new JPanel();

		Obcan o1 = new Obcan("11", "Jano");
		Obcan o2 = new Obcan("11", "Miso");

		Obcan[] po = { o1, o2 };

		JComboBox<Obcan> combo = new JComboBox<>(po);

		panel.add(combo);

		frame.setContentPane(panel);

		Obcan selected = loadSelected();

		final Obcan[] selectedObcan = { selected };

//		final Obcan selectedObcan = null;

		JLabel label = new JLabel();

		label.setText("Selected Obcan = " + selectedObcan[0]);

		panel.add(label);

//		combo.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//			}
//		});

		combo.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Obcan o = (Obcan) e.getItem();
				selectedObcan[0] = o;
				label.setText("Selected Obcan = " + selectedObcan[0]);
				saveSelection(o);
			}
		});

		frame.setVisible(true);
	}

	private static void saveSelection(Obcan o) {
		File f = new File("C:/devel/SelectedObcan");
		try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Obcan loadSelected() {
		File f = new File("C:/devel/SelectedObcan");
		try (InputStream is = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(is);) {
			return (Obcan) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
