import javax.swing.*;
import java.awt.event.ActionEvent;

public class SecondForm {
    private JPanel secondPanel;
    private JButton collapseButton;
    private JButton expandButton;
    private JTextArea nameTextArea;
    private JTextArea surnameTextArea;
    private JTextArea secondNameTextArea;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel secondNameLabel;
    private JPanel mainPanel;
    private String localName;


    public SecondForm() {
        collapseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(nameLabel.getText().equals("ФИО")){
                    JOptionPane.showMessageDialog(mainPanel,"Нажмите другую кнопку",
                            "Служебное сообщение",JOptionPane.ERROR_MESSAGE);
                }
                else if (!nameTextArea.getText().equals("")
                        && !surnameTextArea.getText().equals("")) {
                    localName = nameTextArea.getText();
                    nameTextArea.setText(nameTextArea.getText() + " " + surnameTextArea.getText()
                            + " " + secondNameTextArea.getText());

                    secondNameTextArea.setVisible(false);
                    secondNameLabel.setVisible(false);
                    surnameLabel.setVisible(false);
                    surnameTextArea.setVisible(false);
                    nameLabel.setText("ФИО");
                }else {
                        JOptionPane.showMessageDialog(mainPanel,"Заполните правильно " +
                                "все обозначенные звёздочкой столбцы",
                                "Служебное сообщение",JOptionPane.ERROR_MESSAGE);
                    }
            }
        });

        expandButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                secondNameTextArea.setVisible(true);
                secondNameLabel.setVisible(true);
                surnameLabel.setVisible(true);
                surnameTextArea.setVisible(true);
                nameLabel.setText("Имя*");

                nameTextArea.setText(localName);

            }
        });
    }

    public JPanel getSecondPanel() {
        return secondPanel;
    }


}
