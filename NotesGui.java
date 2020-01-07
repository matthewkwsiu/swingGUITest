/**
 * The GUI from the notes (p.15 Chapter 11 Slides)
 * 
 * @author Lynn Marshall
 * @version Skeleton: November 17, 2012
 * 
 * @author Matthew Siu
 * @version November 29, 2019
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;

public class NotesGui implements ActionListener, ChangeListener, ListSelectionListener
{

    private JButton aJButton;
    private JToggleButton aJToggleButton;
    private JCheckBox aJCheckBox;
    private JCheckBox anotherJCheckBox;
    private JRadioButton aJRadioButton;
    private JRadioButton anotherJRadioButton;

    
    
    private JTextField jTextField;

    private JProgressBar jProgressBar;
    private int progress = 75;
    
    private JSlider jSlider;
    private JSpinner spinner;
    private JList list1;
    private JComboBox itemList;
    
    

    public NotesGui() {
        // JFrame and contentPane
        JFrame frame = new JFrame("Swing Component Demo");
        Container contentPane = frame.getContentPane();

        // set the layout of the contentPane
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        // add all the GUI components 
        // Most of the classes required can be determined from the names
        // used in the GUI (e.g. JButton, etc.).
        // Note that many of these have a TitledBorder -- that's what
        // puts the line around a component with a title in the upper left.
        // See the TitledBorder interface and also the tutorial on using Borders:
        // http://docs.oracle.com/javase/tutorial/uiswing/components/border.html

        // set up the action listeners 

        // set up button panel
        JPanel buttonsPanel = new JPanel();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Buttons");
        buttonsPanel.setBorder(title);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        contentPane.add(buttonsPanel);

        // the panel for the two left buttons
        JPanel leftButtonPane = new JPanel();
        leftButtonPane.setBorder(BorderFactory.createLineBorder(Color.gray));
        leftButtonPane.setLayout(new BoxLayout(leftButtonPane, BoxLayout.PAGE_AXIS));
        aJButton = new JButton("A JButton");
        aJButton.addActionListener(this);
        leftButtonPane.add(aJButton);
        aJToggleButton = new JToggleButton("A JToggleButton");
        aJToggleButton.addActionListener(this);
        leftButtonPane.add(aJToggleButton);
        buttonsPanel.add(leftButtonPane);

        // the panel for the middle buttons (JCheckBoxes)
        JPanel middleButtonPane = new JPanel();
        middleButtonPane.setBorder(BorderFactory.createLineBorder(Color.gray));
        middleButtonPane.setLayout(new BoxLayout(middleButtonPane, BoxLayout.PAGE_AXIS));
        aJCheckBox = new JCheckBox("A JCheckBox");
        aJCheckBox.addActionListener(this);
        middleButtonPane.add(aJCheckBox);
        anotherJCheckBox = new JCheckBox("Another JCheckBox");
        anotherJCheckBox.addActionListener(this);
        middleButtonPane.add(anotherJCheckBox);
        buttonsPanel.add(middleButtonPane);

        // the panel for the right buttons (JRadioButtons)
        JPanel rightButtonPane = new JPanel();
        rightButtonPane.setBorder(BorderFactory.createTitledBorder("A ButtonGroup"));
        rightButtonPane.setBorder(BorderFactory.createLineBorder(Color.gray));
        rightButtonPane.setLayout(new BoxLayout(rightButtonPane, BoxLayout.PAGE_AXIS));
        aJRadioButton = new JRadioButton("A JRadioButton");
        aJRadioButton.addActionListener(this);
        rightButtonPane.add(aJRadioButton);
        anotherJRadioButton = new JRadioButton("Another JRadioButton");
        anotherJRadioButton.addActionListener(this);
        rightButtonPane.add(anotherJRadioButton);
        buttonsPanel.add(rightButtonPane);

        // set up the Labels and Text Entry panel
        JPanel labelsPane = new JPanel();
        labelsPane.setBorder(BorderFactory.createTitledBorder("Labels and Text Entry"));
        labelsPane.setLayout(new BoxLayout(labelsPane, BoxLayout.LINE_AXIS));
        contentPane.add(labelsPane);
        JLabel jLabel = new JLabel("A JLabel with a text label.");
        labelsPane.add(jLabel);
        jTextField = new JTextField("You can type text in an editable JTextField");
        jTextField.addActionListener(this);
        labelsPane.add(jTextField);

        // set up the A JProgress Bar panel
        JPanel progressBarPane = new JPanel();
        progressBarPane.setBorder(BorderFactory.createTitledBorder("A JProgress Bar"));
        progressBarPane.setLayout(new BoxLayout(progressBarPane, BoxLayout.LINE_AXIS));
        //note: this sets the min as 0 and max as 100
        jProgressBar = new JProgressBar();
        jProgressBar.setValue(progress);
        jProgressBar.setStringPainted(true);
        progressBarPane.add(jProgressBar, BorderLayout.LINE_START);
        contentPane.add(progressBarPane);

        // set up Components for Selecting panel
        JPanel componentsPane = new JPanel();
        componentsPane.setBorder(BorderFactory.createTitledBorder("Components for Selecting"));
        componentsPane.setLayout(new BoxLayout(componentsPane, BoxLayout.PAGE_AXIS));
        contentPane.add(componentsPane);
        JPanel topPane = new JPanel();
        topPane.setLayout(new BoxLayout(topPane, BoxLayout.LINE_AXIS));
        componentsPane.add(topPane);
        JPanel bottomPane = new JPanel();
        bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.LINE_AXIS));
        componentsPane.add(bottomPane);

        // set up JSlider Panel
        JPanel sliderPane = new JPanel();
        sliderPane.setBorder(BorderFactory.createTitledBorder("A JSlider"));
        jSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        //NOTE: this should make the paint Ticks visible, and space is added, but they are not visible
        jSlider.setPaintTicks(true);
        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer(0), new JLabel("0"));
        labelTable.put(new Integer(5), new JLabel("5"));
        labelTable.put(new Integer(10), new JLabel("10"));
        jSlider.setLabelTable(labelTable);
        jSlider.setPaintLabels(true);
        jSlider.addChangeListener(this);
        sliderPane.add(jSlider);
        topPane.add(sliderPane);

        // set up JSpinner panel
        // NOTE: I tried to left align this one using BoxLayout and Horizontal glue, but due to the layout, 
        // it would fit to the same height as the JSlider panel, so it would look weird
        JPanel spinnerPane = new JPanel();
        spinnerPane.setBorder(BorderFactory.createTitledBorder("A JSpinner"));
        //spinnerPane.setLayout(new BoxLayout(spinnerPane, BoxLayout.LINE_AXIS));
        SpinnerModel numberModel = new SpinnerNumberModel(0, 0, 10, 1);
        spinner = new JSpinner(numberModel);
        spinner.addChangeListener(this);
        spinnerPane.add(spinner);
        spinnerPane.add(Box.createHorizontalGlue());
        spinnerPane.add(Box.createVerticalGlue());
        topPane.add(spinnerPane);

        // set up Jlist and JScrollPane Panel
        JPanel listScrollPane = new JPanel();
        listScrollPane.setBorder(BorderFactory.createTitledBorder("A JList in a JScrollPane"));
        listScrollPane.setLayout(new BoxLayout(listScrollPane, BoxLayout.LINE_AXIS));
        String[] strings = new String[10];
        for(int i = 0; i<10; i++){
            strings[i] = "Item " + i;
        }
        list1 = new JList(strings);
        list1.setVisibleRowCount(8);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setLayoutOrientation(JList.VERTICAL);
        list1.setFixedCellHeight(12);
        JScrollPane listScroller = new JScrollPane(list1);
        listScroller.setPreferredSize(new Dimension(200, 80));
        listScrollPane.add(listScroller);
        list1.addListSelectionListener(this);
        listScrollPane.add(Box.createHorizontalGlue());
        bottomPane.add(listScrollPane);

        // set up JComboBox Panel
        // NOTE: I tried to left align this one using BoxLayout and Horizontal glue, but due to the layout, 
        // it would fit to the same height as the Jlist panel, so it would look weird
        JPanel comboPane = new JPanel();
        comboPane.setBorder(BorderFactory.createTitledBorder("A JComboBox"));
        //comboPane.setLayout(new BoxLayout(comboPane, BoxLayout.LINE_AXIS));
        String[] strings2 = new String[10];
        for(int i = 0; i<10; i++){
            strings2[i] = "Item " + i;
        }
        itemList = new JComboBox(strings2);
        itemList.setSelectedIndex(0);
        itemList.addActionListener(this);
        comboPane.add(itemList);
        comboPane.add(Box.createHorizontalGlue());
        bottomPane.add(comboPane);

        topPane.add(Box.createHorizontalGlue());
        bottomPane.add(Box.createHorizontalGlue());
        
        
        // finish setting up the frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    /** 
     * This action listener is called when the user clicks / enters
     * information using the GUI. 
     */
    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource();

        if(o instanceof JButton){
            JButton button = (JButton) o;
            if(button == aJButton){
                System.out.println("a JButton was pressed" + "\nNote: this also updates the progress bar so that it is dynamic");
                progress++;
                jProgressBar.setValue(progress);
            }
        } else
        if(o instanceof JCheckBox){
            //note: if either of these are selected, both will check if they are selected, and will fire accordingly
            //could adjust to an else statement, but I felt that this would
            //be more useful
            if(aJCheckBox.isSelected()){
                System.out.println("a JCheckBox was selected");
            } 
            if(anotherJCheckBox.isSelected()){
                System.out.println("another JCheckBox was selected");
            } 
        } else
        if(o instanceof JRadioButton){
            //note: if either of these are selected, both will check if they are selected, and will fire accordingly
            //could adjust to an else statement, but I felt that this would
            //be more useful
            if(aJRadioButton.isSelected()){
                System.out.println("a JRadioButton was selected");
            } 
            if(anotherJRadioButton.isSelected()){
                System.out.println("another JRadioButton was selected");
            } 
        } else
        if(o instanceof JTextField){
            String text = jTextField.getText();
            System.out.println(text);
        } else
        if(o instanceof JComboBox ){
            JComboBox comboBox = (JComboBox)o;
            if(comboBox == itemList)
            System.out.println((String)itemList.getSelectedItem() + " was selected from JComboBox");
        } else
        if(o instanceof JToggleButton){
            JToggleButton toggleButton = (JToggleButton) o;
            if(toggleButton == aJToggleButton){
                //note: if want to change based on whether this is up or down, need an itemlistener
                System.out.println("a JToggleButton was pressed");
            }
        } 

    }  

    /** 
     * This ChangeListener is called when the user clicks / enters
     * information using the GUI. 
     */
    public void stateChanged(ChangeEvent ce){
        Object o = ce.getSource();

        if(o instanceof JSlider){
            JSlider slider = (JSlider)o;
            //set its such that it only prints when mouse is released
            if(!slider.getValueIsAdjusting()){
                int value = slider.getValue();
                System.out.println("Slider is at " + value);
            }
        } else
        if(o instanceof JSpinner){
            JSpinner spinner = (JSpinner)o;
            //just print out the value of the spinner when it is clicked
            System.out.println("Spinner is at " + spinner.getValue());

        }

    }
    /** 
     * This ListSelectionListener is called when the user clicks / enters
     * information using the GUI. 
     */
    public void valueChanged(ListSelectionEvent lse){
        Object o = lse.getSource();

        if(o instanceof JList){
            JList list = (JList) o;
            if(list == list1){
                if(!list1.getValueIsAdjusting()){
                    Object selection = list1.getSelectedValue();
                    if(selection instanceof String){
                        System.out.println((String)selection + " was selected from JList");
                    }
                }
            } 

        }
    }

}