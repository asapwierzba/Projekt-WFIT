import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Generator extends JFrame {
    public String[] kolor_lista = {"Czerwony", "Niebieski", "Zielony", "Fioletowy"};
    public String sciezka;
    public float kolor = 0;
    public int mandelbrot_width = 1280;
    public int mandelbrot_height = 720;
    public void generuj(){
        JFrame okno = new JFrame("Mandelbrot Generator");
        okno.setSize(300,300);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setLocationRelativeTo(null);

        JLabel tekst_kolor = new JLabel("Kolor:");
        tekst_kolor.setBounds(55,30,40,40);
        okno.add(tekst_kolor);

        JComboBox wybor_kolor = new JComboBox(kolor_lista);
        wybor_kolor.setBounds(100,30,150,40);
        okno.add(wybor_kolor);

        JLabel tekst_szerokosc = new JLabel("Szerokość:");
        tekst_szerokosc.setBounds(45,80,70,40);
        okno.add(tekst_szerokosc);

        JTextField szerokosc = new JTextField();
        szerokosc.setBounds(120,80,150,40);
        szerokosc.setText("1280");
        okno.add(szerokosc);

        JLabel tekst_wysokosc = new JLabel("Wysokość:");
        tekst_wysokosc.setBounds(45,120,70,40);
        okno.add(tekst_wysokosc);

        JTextField wysokosc = new JTextField();
        wysokosc.setBounds(120,120,150,40);
        wysokosc.setText("720");
        okno.add(wysokosc);

        JButton generuj = new JButton("Generuj fraktal");
        generuj.setBounds(75,160,150,40);
        okno.add(generuj);

        JButton zapisz = new JButton("Zapisz do pliku");
        zapisz.setBounds(75,210,150,40);
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
                else if(wybor_kolor.getSelectedIndex() == 2){
                    kolor = 84;
                }
                else if(wybor_kolor.getSelectedIndex() == 3){
                    kolor = 210;
                }
            }
        });

        generuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    mandelbrot_width = Integer.parseInt(szerokosc.getText());
                    mandelbrot_height = Integer.parseInt(wysokosc.getText());
                    sciezka = "mandelbrot";
                    new Mandelbrot(kolor,mandelbrot_width,mandelbrot_height,sciezka);
                    MandelbrotWindow pokaz = new MandelbrotWindow();
                    pokaz.okno_pokaz();
                }
                catch (NumberFormatException x){
                    JOptionPane.showMessageDialog(okno, "Wprowadzone dane muszą być liczbami całkowitymi!", "Błąd!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Wybierz ścieżkę");
                int userSelection = fileChooser.showSaveDialog(okno);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    sciezka = fileToSave.getAbsolutePath();
                    new Mandelbrot(kolor,mandelbrot_width,mandelbrot_height,sciezka);
                }
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
