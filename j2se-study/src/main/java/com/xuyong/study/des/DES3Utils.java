package com.xuyong.study.des;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
/**
 * 3DES加解密
 * */
public class DES3Utils {
	
	private static final String encrytkey = "CD5A81F9010A094CDBF53A77D46D072E";
	/**
	 * 补全48位key
	 * @param key
	 * @return
	 */
	public static String toAddKey(String key){
		String str = key;
		int n = 48 - key.length();
		if(n > 0){
			str += str.substring(0, n);
		}
		return str;  
	}
	/**
	 * 	将十六进制字符串转换为byte[]
	 */
	public static byte[] hexByte(byte[] b) {
		if ((b.length % 2) != 0){
    		throw new IllegalArgumentException("长度不是偶数");
    	}
    	byte[] b2 = new byte[b.length / 2];
    	for (int n = 0; n < b.length; n += 2) {
    		String item = new String(b, n, 2);
    		b2[n / 2] = (byte) Integer.parseInt(item, 16);
    	}
    	return b2;
	}
	 /**
		 * 	将byte数组转换成十六进制字符串
		 * */
	public static String byteHex(byte[] b) {
		String hs="";
        String stmp="";

        for (int n=0;n<b.length;n++) {
            stmp=(Integer.toHexString(b[n] & 0XFF));
            if (stmp.length()==1){
           		hs=hs+"0"+stmp;
           }else{
            	hs=hs+stmp;
           }
        }
        return hs.toUpperCase();
	}
	   
	/**
	 * 3DES解密
	 * */
	public static byte[] toDecryptMode(byte[] data,byte[] key) throws Exception{
		
		byte[] DecByte=null;
		try {
			SecretKey deskey = new SecretKeySpec(key, "DESede");
			Cipher cipher = Cipher.getInstance("DESede/ECB/NOPADDING");
//			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.DECRYPT_MODE, deskey);
			DecByte=cipher.doFinal(data);
		} catch (InvalidKeyException e) {
			throw new Exception("3DES解密出错");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("3DES解密出错");
		} catch (NoSuchPaddingException e) {
			throw new Exception("3DES解密出错");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("3DES解密出错");
		} catch (BadPaddingException e) {
			throw new Exception("3DES解密出错");
		}
		return DecByte;
	}
	/**
	 * 3DES解密
	 * @throws Exception 
	 */
	public static String deDes3(String des3) throws Exception{
		/**
		 * 秘钥
		 * */
		String key = encrytkey;
		String result = UnDes3Str(key, des3);
		return result;
	}
	
	
	public static String UnDes3Str(String key,String src) throws Exception{
		byte[] keyStr = toAddKey(key).getBytes("GBK");
		byte[] keyBytes=hexByte(keyStr);
		byte[] cSrcBytes = toDecryptMode(hexByte(src.getBytes("GBK")), keyBytes);
		String hexStr=byteHex(cSrcBytes);
		/**
		* 	将解密后字符串的后面的00去掉
		**/
		int len_new=hexStr.length();
		int len_old=len_new;
		for(int i=0;i<8;i++)
		{	
			len_old=len_new;
			hexStr=hexStr.replaceAll("00$", "");//c++加密补位在后面加00
		    hexStr=hexStr.replaceAll("06$", "");//java加密补位在后面加06
		    hexStr=hexStr.replaceAll("08$", "");
		    len_new=hexStr.length();
		    if(len_new==len_old)
		      	break;        
		}
		 byte[] DecByte=hexByte(hexStr.getBytes("UTF-8"));
		 byte[] newtemp=new String(DecByte,"gbk").getBytes("utf-8");//这里写转换后的编码方式
         String newStr=new String(newtemp,"utf-8");//这里写转换后的编码方式
		return newStr;
	}
	/**
     *  转化字符串为十六进制编码
     */
	public static String toHexString(String s)   
	{   
		String str="";   
		for (int i=0;i<s.length();i++)   
		{   
			int ch = (int)s.charAt(i);   
			String s1 = Integer.toHexString(ch);   
			str = str + s1; 
		} 
		//自动添加补位00
		if((s.length())%8>0){
			int n=8-(s.length())%8;
			while((n--) >0){
				str+="00";
			}
		}
		return str;   
	} 
	public static String doDes3(String des3) throws Exception{
		String key = encrytkey;
		return Des3Str(key, des3);
	}
	
	public static String Des3Str(String key,String src) throws Exception{
		byte[] keyStr = toAddKey(key).getBytes("GBK");
		byte[] keyBytes=hexByte(keyStr);
		byte[] sData=src.getBytes("GBK");
		sData=new String(sData,"UTF-8").getBytes("GBK");//这里写转换后的编码方式
		byte[] desData=sData;
		if(sData.length%8!=0){
			desData=new byte[(1+sData.length/8)*8];
			System.arraycopy(sData,0,desData,0,sData.length);
		}
		
		byte[] cSrcBytes = toEncryptMode(desData, keyBytes);
		String hexStr=byteHex(cSrcBytes);
		return hexStr;
	}
	/**
	 * 3DES加密
	 * */
	public static byte[] toEncryptMode(byte[] data,byte[] key) throws Exception{
		
		byte[] EncByte=null;
		try {
			SecretKey deskey = new SecretKeySpec(key, "DESede");
			Cipher cipher = Cipher.getInstance("DESede/ECB/NOPADDING");
			cipher.init(Cipher.ENCRYPT_MODE, deskey);
			EncByte=cipher.doFinal(data);
		} catch (InvalidKeyException e) {
			throw new Exception("3DES加密出错");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("3DES加密出错");
		} catch (NoSuchPaddingException e) {
			throw new Exception("3DES加密出错");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("3DES加密出错");
		} catch (BadPaddingException e) {
			throw new Exception("3DES加密出错");
		}
		return EncByte;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("result = " + deDes3(""));
	}
}
