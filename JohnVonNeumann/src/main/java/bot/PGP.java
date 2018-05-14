package bot;

import java.io.IOException;

import com.didisoft.pgp.CompressionAlgorithm;
import com.didisoft.pgp.CypherAlgorithm;
import com.didisoft.pgp.HashAlgorithm;
import com.didisoft.pgp.KeyAlgorithm;
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPException;
import com.didisoft.pgp.PGPLib;

public class PGP {
	public String encrypt(String msg, String path, String user, String pass) throws PGPException, IOException {

		// create an instance of the library
		PGPLib pgp = new PGPLib();

		KeyStore keystore = KeyStore.openFile(path, pass);

		// encrypt

		return pgp.encryptString(msg, keystore, keystore.getKeyIdForUserId(user));

	}

	public String decrypt(String msg, String path, String pass, String privatePass) throws PGPException, IOException {

		// create an instance of the library
		PGPLib pgp = new PGPLib();

		String privateKeyPassword = privatePass;
		KeyStore keyStore = KeyStore.openFile(path, pass);

		return pgp.decryptString(msg, keyStore, privateKeyPassword);

	}

	public void GenerateKeyPairRSA(String path, String user, String pass, String privatePass)
			throws PGPException, IOException {

		// initialize the KeyStore where the key will be generated

		KeyStore ks = new KeyStore("pgp.keystore", pass);

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

	public void ExportKey(String path, String user, String pass) throws IOException, PGPException {
		// initialize the KeyStore
		KeyStore ks = KeyStore.openFile("pgp.keystore", pass);

		// should the exported files be ASCII or binary
		boolean asciiArmored = true;

		// export public key having the specified userId
		// all public sub keys are exported too
		ks.exportPrivateKey("utils//public_key.asc", user, asciiArmored);

		// export secret key having the specified userId,
		// this is usually our own key.
		// all secret sub keys are exported too
		ks.exportPrivateKey("utils//private_key.asc", user, asciiArmored);

		// export both public and secret key with all sub keys in one file
		// the file is in ASCII armored format by default
		ks.exportKeyRing("utils//public_key.asc", user, asciiArmored);
	}
}
