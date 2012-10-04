/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import java.util.ArrayList;

/**
 *
 * @author kiro
 */
public class RCon {
    
    public ArrayList<WPoly> rcon = new ArrayList<>();
        
    
    private RCon() {
        rcon.add(new WPoly(0x1, 0x0, 0x0, 0x0));
        BinPoly p = new BinPoly(0x2);
        rcon.add(new WPoly(0x2, 0x0, 0x0, 0x0));
        for (int i = 2; i < 10; i++) {
            p = p.multiply(new BinPoly(0x2));
            WPoly temp = new WPoly(p.poly, 0, 0, 0);
            rcon.add(temp);
            //temp.debug();
        }
    }
    
    public static RCon getInstance() {
        return RConHolder.INSTANCE;
    }
    
    private static class RConHolder {

        private static final RCon INSTANCE = new RCon();
    }
}
