package com.ipc1.cah.ui.hanoi_towers;

import javax.swing.JPanel;

public class Tower extends JPanel{
    
    private Disk root;
    private int towerSize;

    public Tower() {
        this.root = null;
        this.towerSize = 0;
        this.setSize(250, 295);
        this.setLayout(null);
        this.setOpaque(false);
    }
        
    public boolean isEmpty(){
        return (this.root == null);
    }
    
    public int getTowerSize(){
        return this.towerSize;
    }
    
    public void stack(Disk disk) {
        towerSize++;
        disk.setLocation(0, 295-(30*(towerSize)));
        disk.setTower(this);
        this.add(disk);
        this.repaint();
        Disk newNode = disk; 
        if (isEmpty()) {
            root = newNode;
        }
        else{
            newNode.setNext(root);
            root = newNode;
        }
    }    

    public Disk pop() {
        Disk answer = null;
        if (!isEmpty()) {
            answer = root;
            root = root.getNext();
            towerSize--;
            remove(answer);
            repaint();
        }
        return answer;
    }

    public Disk getTop() {
        Disk answer = null;
        if (!isEmpty()) {
            answer = root;
        }
        return answer;
    }
    
}
