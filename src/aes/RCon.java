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
    
    public ArrayList<WordPoly> rcon = new ArrayList<>();
        
    
    private RCon() {
        rcon.add(new WordPoly(0x0, 0x0, 0x0, 0x1));
        BinPoly p = new BinPoly(0x2);
        rcon.add(new WordPoly(0x0, 0x0, 0x0, 0x2));
        for (int i = 2; i < 14; i++) {
            p = p.multiply(new BinPoly(0x2));
            WordPoly temp = new WordPoly(0, 0, 0, p.poly);
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
