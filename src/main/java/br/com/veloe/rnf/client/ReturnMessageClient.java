package br.com.veloe.rnf.client;

import br.com.veloe.rnf.config.StatusEnvio;
import br.com.veloe.rnf.model.request.TransacoesRnf;
import br.com.veloe.rnf.service.RnfService;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReturnMessageClient {
    @Autowired
    private OneSignalClient oneSignalClient;

    @Autowired
    private RnfService rnfService;

    @Async
    @Scheduled(cron = "0 */1 * * * ?")
    public void getMessage() throws Exception {
        try {
            List<TransacoesRnf> list = this.oneSignalClient.checkMessages_Return();
            list.stream().forEach(s->{
                this.rnfService.postRnfTransacao(s, StatusEnvio.EMITIDA.getDescricao());
            });
        }catch (Exception e){
           log.info(e.getMessage());
        }
    }
}
