
package anagram;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ListHashTable {
    LinkedList [] table;
    ArrayList<String> myHashes = new ArrayList<String>();
    private int myHashMethod(String key){
        boolean isAdded = false;
        int index = 0;
        if(myHashes.size() == 0){
            myHashes.add(key);
            index = 0;
        }
        else{
            for (int i = 0; i < myHashes.size(); i++) {
                if(myHashes.get(i) == key){
                    isAdded = true;
                    index = i; 
                    break;
                }
            }
            if(isAdded == false){
                myHashes.add(key);
                index = myHashes.indexOf(key);
            }
        }
        return index;
    }
    void PUT(String key,String value){
        int hash = myHashMethod(key);
        Node t = table[hash].head;
        while(t!= null && ! t.value.equals(value)){
            t = t.next;
        } 
        if(t == null){
            table[hash].addFirst(key,value);
        }
        else{
            t.value=value;
        }
    }
    void GET(int key,JList list){
        Node current = table[key].head;
        DefaultListModel dlm = new DefaultListModel();
        while(current != null){
            dlm.addElement(current.value);
            current = current.next;
        }
        list.setModel(dlm);
    }
    ListHashTable(int size){
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList();
        }
    }
    void printTable(){
        
        for (int i = 0; i < table.length; i++) {
                           
                System.out.print("[" + i + "] ");
                table[i].printList();
                System.out.println("");
                       
        }
    }
    class LinkedList{
        Node head;
        
        void addFirst(String key,String value){
            Node n = new Node(key,value);
            n.next = head;
            head = n;
        }
        
       Node removeFirst(){
          
            Node temp = head;
            head = head.next;
            return temp;   
       }
       
       void printList(){
           Node temp = head;
           while( temp != null){
               System.out.print( "[" + temp.key + " : " + temp.value + "] -> ");
               temp = temp.next;
           }
       }
    }    
    class Node{
        String key;
        String value;
        Node next;
        
        Node(String key,String value){
            this.key = key;
            this.value = value;
        }
    }    
}
