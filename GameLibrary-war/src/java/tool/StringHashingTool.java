/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringHashingTool {
    private static final StringHashingTool instance = new StringHashingTool();

    public static StringHashingTool getInstance() {
        return instance;
    }

    private final HashingTool hashingTool;

    public StringHashingTool() {
        hashingTool = HashingTool.getInstance();
    }

    public byte[] hashUsingMD5(String data) {
        byte[] result = new byte[1];
        try {
            result = hashingTool.hashUsingMD5(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(StringHashingTool.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
