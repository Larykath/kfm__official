package sample.crypto;
import com.sun.org.apache.xml.internal.security.keys.KeyUtils;
import com.sun.xml.internal.ws.util.StringUtils;
import sun.security.rsa.RSAKeyFactory;

import javax.crypto.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;

public class KeyGenerator {

    private static KeyGenerator keyGenerator;
    private final KeyPair keyPair;
    private KeyPairGenerator keyPairGenerator;

    public static KeyGenerator getNewKeyPair(int keysize) throws InvalidKeyException, NoSuchAlgorithmException {
        if (keysize>=512){
            keyGenerator = new KeyGenerator(keysize);
        }
        return keyGenerator;
    }

    public KeyGenerator(int keySize) throws NoSuchAlgorithmException, InvalidKeyException {

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(keySize);
        keyPair = keyGen.genKeyPair();
        byte[] publicKey = keyPair.getPublic().getEncoded();
        byte[] privateKey = keyPair.getPrivate().getEncoded();
        String retString = decodeKey(publicKey).toString();
        String ret2String = decodeKey(privateKey).toString();


        System.out.println(retString);
        System.out.println(ret2String);


    }

    public StringBuffer decodeKey(byte[] key){
        StringBuffer retString = new StringBuffer();
        for (int i = 0; i < key.length; ++i) {
            retString.append(Integer.toHexString(0x0100 + (key[i] & 0x00FF)).substring(1));
        }
        return retString;
    }

    public KeyPair getKeyPair(){
        return keyPair;
    }
    
    
    public void secretMethod(int keysize){
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(keysize);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
