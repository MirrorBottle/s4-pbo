/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;
/**
 *
 * @author setia
 */
public class UAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QueryHelper.init();
        Login login = new Login();
        
        login.setVisible(true);
    }
    
}
