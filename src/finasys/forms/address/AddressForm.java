/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.forms.address;

import finasys.enities.Addresses;
import javax.swing.JInternalFrame;

/**
 * Help get an address from a form.
 * @author St John Giddy
 */
public abstract class AddressForm extends JInternalFrame {
    abstract public Addresses getAddress();
}
