import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Generator extends JFrame {
    public String[] kolor_lista = {"Czerwony", "Niebieski", "Zielony"};
    public float kolor = 0;
    public void generuj(){
        JFrame okno = new JFrame("Mandelbrot Generator");
        okno.setSize(1280,720);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setLocationRelativeTo(null);

        JLabel tekst_kolor = new JLabel("Kolor:");
        tekst_kolor.setBounds(355,20,40,40);
        okno.add(tekst_kolor);

        JComboBox wybor_kolor = new JComboBox(kolor_lista);
        wybor_kolor.setBounds(395,20,150,40);
        okno.add(wybor_kolor);

        JButton generuj = new JButton("Generuj fraktal");
        generuj.setBounds(570,20,150,40);
        okno.add(generuj);

        JButton zapisz = new JButton("Zapisz do pliku");
        zapisz.setBounds(745,20,150,40);
        okno.add(zapisz);

        wybor_kolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wybor_kolor.getSelectedIndex() == 0){
                    kolor = 0;
                }
                else if(wybor_kolor.getSelectedIndex() == 1){
                    kolor = 150;
                }
                else {
                    kolor = 84;
                }
            }
        });

        generuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Mandelbrot(kolor);
            }
        });

        okno.setLayout(null);
        okno.setVisible(true);
    }

    public static void main(String args[]){
        Generator nowy = new Generator();
        nowy.generuj();
    }
}
