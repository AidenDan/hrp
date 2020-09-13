package com.hr.test;

import com.hr.utils.RsaUtils;


public class RsaUtilsTest {
    private static String privateFilePath = "H:\\auth_key\\id_key_rsa";
    private  static String publicFilePath = "H:\\auth_key\\id_key_rsa.pub";

    public static void generateKey() throws Exception {
        RsaUtils.generateKey(publicFilePath, privateFilePath, "itheima", 2048);
    }

    public static void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey(publicFilePath));
    }

    public static void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey(privateFilePath));
    }
    public static void main(String[] args) throws Exception {
        generateKey();
            }

}