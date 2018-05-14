package bot;

import java.io.IOException;

import org.junit.Test;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPException;


public class PGPTest {
	@Test
	public void generarRSA() throws PGPException, IOException {
		PGP pgp = new PGP();
		String user = "user";
		String path = "utils//pgp.keystore";
		String pass = "pass1234";
		String privatePass = "pass1234";

		KeyStore ks = new KeyStore(path, pass);

		pgp.GenerateKeyPairRSA(path, user, pass, privatePass);
		pgp.ExportKey(path, user, pass);

		boolean passwordIsCorrect = KeyStore.checkPassword(path, pass);
		System.out.println(passwordIsCorrect);

		boolean keyContainsPublic = ks.containsPublicKey(user);
		System.out.println(keyContainsPublic);

		boolean keyContainsPrivate = ks.containsPrivateKey(user);
		System.out.println(keyContainsPrivate);

		String msgEnc = pgp.encrypt("Decodificando la wea", path, user, pass);

		System.out.println(msgEnc);

		System.out.println(pgp.decrypt(msgEnc, path, pass, privatePass));

	}
}
