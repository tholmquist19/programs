package lab6.CSCD437Crypto;
import java.io.*;
import java.security.*;
import java.util.Scanner;
import javax.crypto.*;

public class CSCD437Crypto {
    private Signature sign;
    private KeyPairGenerator keyPairGen;
    private KeyPair pair;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public CSCD437Crypto(String signatureAlgo, String keyPairAlgo, int keySize){
        new Signature(signatureAlgo);
    }

}
