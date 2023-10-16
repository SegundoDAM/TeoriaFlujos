package binarios03Interface;

import java.io.DataOutputStream;

// abstracto
public interface Adecuador {
	public boolean graba(DataOutputStream conversor, Object objeto);
}
