package bot;

import java.io.IOException;

import com.didisoft.pgp.CompressionAlgorithm;
import com.didisoft.pgp.CypherAlgorithm;
import com.didisoft.pgp.HashAlgorithm;
import com.didisoft.pgp.KeyAlgorithm;
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPException;
import com.didisoft.pgp.PGPLib;

import bdd.Data;

public class PGP {
	
	private static final String path = "src/main/resources/pgp.keystore";
	private static final String pass = "pass1234";
	
	public static String encrypt(String msg, String user) throws PGPException, IOException {

		// create an instance of the library
		PGPLib pgp = new PGPLib();

		KeyStore keystore = KeyStore.openFile(path, pass);

		// encrypt

		return pgp.encryptString(msg, keystore, keystore.getKeyIdForUserId(user));

	}

	public static String decrypt(String msg, String user) throws Exception {

		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		Data d = new Data(user);
		d.obtain();

		String privateKeyPassword = d.getPasswordRSA();
		KeyStore keyStore = KeyStore.openFile(path, pass);

		return pgp.decryptString(msg, keyStore, privateKeyPassword);

	}

	public static void GenerateKeyPairRSA(String user, String privatePass)
			throws PGPException, IOException {

		// initialize the KeyStore where the key will be generated

		KeyStore ks = new KeyStore("src/main/resources/pgp.keystore", "pass1234");

		String keyAlgorithm = KeyAlgorithm.RSA;

		// user Id for the key pair

		// preferred hashing algorithms
		String[] hashingAlgorithms = new String[] { HashAlgorithm.SHA1, HashAlgorithm.SHA256, HashAlgorithm.SHA384,
				HashAlgorithm.SHA512, HashAlgorithm.MD5 };

		// preferred compression algorithms
		String[] compressions = new String[] { CompressionAlgorithm.ZIP, CompressionAlgorithm.ZLIB,
				CompressionAlgorithm.UNCOMPRESSED };

		// preferred symmetric key algorithms
		String[] cyphers = new String[] { CypherAlgorithm.CAST5, CypherAlgorithm.AES_128, CypherAlgorithm.AES_192,
				CypherAlgorithm.AES_256, CypherAlgorithm.TWOFISH };

		String privateKeyPassword = privatePass;

		int keySizeInBytes = 2048;
		ks.generateKeyPair(keySizeInBytes, user, keyAlgorithm, privateKeyPassword, compressions, hashingAlgorithms,
				cyphers);

	}

	public void ExportKey(String path, String user) throws IOException, PGPException {
		KeyStore ks = KeyStore.openFile("src/main/resources/pgp.keystore", "pass1234");
		boolean asciiArmored = true;
		ks.exportPrivateKey("utils//private_key.asc", user, asciiArmored);
		ks.exportPublicKey("utils//public_key.asc", user, asciiArmored);
	}
	
}
