/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.pa.patterns.memento.model;

import java.util.*;

public class Caretaker {
    private Stack<Memento> mementos;
    private Originator originator;

    public Caretaker(Originator originator) {
        this.originator = originator;
        this.mementos = new Stack<>();
    }

    public void saveState(){
        mementos.push(originator.createMemento());
    }

    public void restoreState() throws NoMementoException{
        if(mementos.empty()){
            throw new NoMementoException("No memento");
        }
        originator.setMemento(mementos.pop());
    }

}
