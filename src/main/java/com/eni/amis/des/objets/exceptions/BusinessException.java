package com.eni.amis.des.objets.exceptions;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private List<String> clefsExternalisations;

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public List<String> getClefsExternalisation() {
        return clefsExternalisations;

    }

    public void add(String clef) {
        if (clefsExternalisations == null) {
            clefsExternalisations = new ArrayList<>();
        }
        clefsExternalisations.add(clef);
    }

    /**
     * @return permet de confirmer si des erreurs ont été chargées
     */
    public boolean isValid() {
        return clefsExternalisations == null || clefsExternalisations.isEmpty();
    }

}
