/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashingTool {
    private static final HashingTool instance = new HashingTool();

    public static HashingTool getInstance() {
        return instance;
    }

    private HashingTool() {

    }

    public byte[] hashUsingMD5(byte[] data) {
        byte[] result = new byte[1];
        try {
            result = MessageDigest.getInstance("MD5").digest(data);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashingTool.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
