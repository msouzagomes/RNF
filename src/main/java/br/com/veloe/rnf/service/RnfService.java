package br.com.veloe.rnf.service;

import br.com.veloe.rnf.model.request.TransacoesRnf;
import com.amazonaws.util.json.JSONObject;

public interface RnfService {
    Object postRnfTransacao(TransacoesRnf transacoesRnf, String statusEnvio);
}
