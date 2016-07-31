/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namecalculator;

import javax.swing.JCheckBox;

/**
 *
 * @author Windows2K
 */
public class MyCheckBox extends JCheckBox{
    int intIndex=0;
    public MyCheckBox(String Text, int _intIndex){
        super(Text);
        intIndex = _intIndex;
    }
    public int fnGetIndex(){
        return intIndex;
    }
}
