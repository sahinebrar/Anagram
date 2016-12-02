
package anagram;

import anagram.ListHashTable.Node;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Anagram extends javax.swing.JFrame {
    ListHashTable t;
    private JFileChooser fileChooser;
    private boolean fileSelected = false;
    private File myFile;
    private ArrayList<String> myOrderedList = new ArrayList<>();
    private ArrayList<String> myUnOrderedList = new ArrayList<>(); 
    ArrayList<String> WordList(File f){
        ArrayList<String> WordList = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                WordList.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Anagram.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Anagram.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return WordList;
    }
    String selectFile(){
        fileSelected=true;
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Şahin\\Desktop"));
        fileChooser.setDialogTitle("Select Text File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile().getAbsolutePath();
    }
    ArrayList<Character> kelimeyiListeAt(String s){
        ArrayList<Character> tempWord = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            tempWord.add(i, s.charAt(i));
        }
        return tempWord;
    }
    private ArrayList<Character> SelectionSortForLetters(ArrayList<Character> c){
        int min;
        char temp;
        for (int i = 0; i < c.size()-1; i++) {
            min = i;
            for (int j = i+1; j < c.size(); j++) {
                if(c.get(j).compareTo(c.get(min))< 0 ){
                    min = j;
                }
            }
            if(min != i){
                temp = c.get(i);
                c.set(i, c.get(min));
                c.set(min, temp);
            }
        }
        return c;
    }
    ArrayList<String> harflerKendiAralarindaSiralansin(){
        ArrayList<String> myList;
        myList = WordList(myFile);
        ArrayList<Character> tempWord;
        String temp="";
        for (int i = 0; i < myList.size(); i++) {
            tempWord = kelimeyiListeAt(myList.get(i));
                tempWord=SelectionSortForLetters(tempWord);
                temp="";
                for (int k = 0; k < tempWord.size(); k++) {
                    temp=temp+tempWord.get(k);
                }
                myOrderedList.add(i, temp);          
        }
        return myOrderedList;
    }
    void addAnagramsToCombo(ListHashTable t){
        for (int i = 0; i < t.table.length; i++) {
            if(t.table[i].head!= null){
                jComboBox_anagrams.addItem(t.table[i].head.value);
            }
        }

    }
    void printList(){
        for (int i = 0; i < myOrderedList.size(); i++) {
            System.out.println(myOrderedList.get(i));
        }
    }
    void writeAnagramsToFile(ListHashTable t){
        try {
            BufferedWriter bW = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir")+"\\MyAnagrams.txt")));
            for (int i = 0; i < t.table.length; i++) {
                if(t.table[i].head!= null){
                    Node temp = t.table[i].head;
                    if(temp!=null)
                        bW.append("*******************");
                        bW.newLine();                   
                    while(temp!=null){                      
                    bW.append(temp.value);
                    bW.newLine();
                    temp = temp.next;
                    }
                }
            }
            bW.close();
        } catch (IOException ex) {
            Logger.getLogger(Anagram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Anagram() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_openfile = new javax.swing.JButton();
        btn_findAnagrams = new javax.swing.JButton();
        jComboBox_anagrams = new javax.swing.JComboBox();
        btn_showthewords = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_words = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_openfile.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        btn_openfile.setText("OPEN FILE");
        btn_openfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openfileActionPerformed(evt);
            }
        });

        btn_findAnagrams.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        btn_findAnagrams.setText("FIND ANAGRAMS!");
        btn_findAnagrams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findAnagramsActionPerformed(evt);
            }
        });

        jComboBox_anagrams.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N

        btn_showthewords.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        btn_showthewords.setText("SHOW THE WORDS");
        btn_showthewords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showthewordsActionPerformed(evt);
            }
        });

        jList_words.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jScrollPane1.setViewportView(jList_words);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setText("Number of anagram groups:");

        jTextField2.setFont(new java.awt.Font("Verdana", 3, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_openfile, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_findAnagrams, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_anagrams, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_showthewords)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_openfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_findAnagrams)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox_anagrams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_showthewords))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openfileActionPerformed
        String filePath = selectFile();
        File newFile = new File(filePath);
        this.myFile = newFile;
    }//GEN-LAST:event_btn_openfileActionPerformed

    private void btn_findAnagramsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findAnagramsActionPerformed
        myOrderedList = harflerKendiAralarindaSiralansin();
        myUnOrderedList = WordList(myFile);
        t = new ListHashTable(myOrderedList.size());
        for (int i = 0; i < myOrderedList.size(); i++) {
            t.PUT(myOrderedList.get(i).trim(),myUnOrderedList.get(i).trim() );
        }
        t.printTable();
        addAnagramsToCombo(t);
        jTextField2.setText(jComboBox_anagrams.getItemCount()+"");
        writeAnagramsToFile(t);
    }//GEN-LAST:event_btn_findAnagramsActionPerformed

    private void btn_showthewordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showthewordsActionPerformed
        String temp = (String) jComboBox_anagrams.getSelectedItem();
        int index = myUnOrderedList.indexOf(temp);
        int key = t.myHashes.indexOf(myOrderedList.get(index));        
        t.GET(key, jList_words);
    }//GEN-LAST:event_btn_showthewordsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Anagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Anagram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_findAnagrams;
    private javax.swing.JButton btn_openfile;
    private javax.swing.JButton btn_showthewords;
    private javax.swing.JComboBox jComboBox_anagrams;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList_words;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
