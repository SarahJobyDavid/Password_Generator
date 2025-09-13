import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// render the GUI Components(FrontEnd)

public class PasswordGeneratorGUI extends JFrame{
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        super("Password Generator");

        setSize(540,570);
        setResizable(false); // THIS PREVENTS THE GUI TO GET RESIZED

        setLayout(null);  // I SET THE LAYOUT TO BE NULL TO HAVE CONTROL OVER THE POSITION AND SIZE AND SIZE OF THE COMPONENTS IN THE APP

        //WITH THIS WE CAN TERMINATE THE PROGRAM WHEN THE GUI IS CLOSED
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // with this the gui will be at the center of the screen
        getContentPane().setBackground(new Color(255, 223, 239));

        //INITIATE PASSWORD GENERATOR
        passwordGenerator = new PasswordGenerator();

        //GUI COMPONENTS
        addGUIComponents();
    }
    private void addGUIComponents(){
        //TITLE TEXT
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(93, 47, 119));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);  // IT CENTERS THE TEXT TO THE SCREEN

        titleLabel.setBounds(0,20,540,39);

        add(titleLabel); // ADD TO GUI

        // WITH THIS I ADDED THE RESULT TEXT AREA
        JTextArea passwordOutput = new JTextArea();

        passwordOutput.setEditable(false); // WITH THIS NO EDITING WILL BE ALLOWED
        passwordOutput.setFont(new Font("Arial", Font.BOLD, 32));
        passwordOutput.setBackground(new Color(235, 214, 251));

        JScrollPane passwordOutputPanel = new JScrollPane(passwordOutput); // THIS MAKES THE OUTPUT SCROLLABLE IN CASE IF THE PASSWORD IS TOO LONG
        passwordOutputPanel.setBounds(25,97,479,70);


        passwordOutputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(passwordOutputPanel);


        //PASSWORD LENGTH LABEL
        JLabel passwordLengthLabel = new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Arial", Font.BOLD, 30));
        passwordLengthLabel.setForeground(new Color(93, 47, 119));

        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        //PASSWORD LENGTH INPUT
        JTextArea passLengthInput = new JTextArea();
        passLengthInput.setFont(new Font("Arial", Font.PLAIN, 28));
        passLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passLengthInput.setBounds(310,215,192,39);
        passLengthInput.setBackground(new Color(235, 214, 251));
        add(passLengthInput);


        // TOGGLE BUTTONS
        //1.UPPERCASE:
        JToggleButton upperCase = new JToggleButton("UpperCase");
        upperCase.setFont(new Font("Arial", Font.BOLD, 20));
        upperCase.setForeground(new Color(255, 255, 255));
        upperCase.setBounds(25,302,225,56);
        upperCase.setBackground(new Color(170, 96, 200));
        add(upperCase);

        //2.LOWERCASE:
        JToggleButton lowerCase = new JToggleButton("LowerCase");
        lowerCase.setFont(new Font("Arial", Font.BOLD, 20));
        lowerCase.setForeground(new Color(255, 255, 255));
        lowerCase.setBounds(282,302,225,56);
        lowerCase.setBackground(new Color(170, 96, 200));
        add(lowerCase);

        //3. Numbers:
        JToggleButton numbers = new JToggleButton("Numbers");
        numbers.setFont(new Font("Arial", Font.BOLD, 20));
        numbers.setForeground(new Color(255, 255, 255));
        numbers.setBounds(25,373,225,56);
        numbers.setBackground(new Color(170, 96, 200));
        add(numbers);

        //4.Specials Symbols
        JToggleButton symbols = new JToggleButton("Symbols");
        symbols.setFont(new Font("Arial", Font.BOLD, 20));
        symbols.setForeground(new Color(255, 255, 255));
        symbols.setBounds(282,373,225,56);
        symbols.setBackground(new Color(170, 96, 200));
        add(symbols);

        //GENERATE BUTTON
        JButton generate = new JButton("Generate");
        generate.setFont(new Font("Arial",Font.BOLD, 26));
        generate.setBounds(155,477,222,41);
        generate.setForeground(new Color(255, 255, 255));
        generate.setBackground(new Color(197, 98, 175));
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // VALIDATION : GENERATE PASSWORD ONLY WHEN LEN>0 AND ANY 1 OF THE TOGGLE BUTTON IS PRESSED
                if(passLengthInput.getText().length() <= 0) return;
                boolean anyToggleSelected = lowerCase.isSelected() ||
                        upperCase.isSelected() ||
                        numbers.isSelected() ||
                        symbols.isSelected();

                int passwordLength = Integer.parseInt(passLengthInput.getText());

                if(anyToggleSelected){
                    String generatePassword = passwordGenerator.generatePassword(passwordLength,
                            upperCase.isSelected(),
                            lowerCase.isSelected(),
                            numbers.isSelected(),
                            symbols.isSelected());

                    //DISPLAY PASSWORD TO USER
                    passwordOutput.setText(generatePassword);
                }
            }
        });
        add(generate);

    }
}
