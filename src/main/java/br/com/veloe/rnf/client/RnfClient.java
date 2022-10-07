package br.com.veloe.rnf.client;

import br.com.veloe.rnf.model.request.TransacoesRnf;
import br.com.veloe.rnf.service.RnfService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;

@Slf4j
public class RnfClient {

    @Autowired
    private RnfService rnfService;

    @JmsListener(destination = "rnf-notas-a-emitir")
    public void orderRnf(String orderContent) throws Exception {
     try{
           ObjectMapper objectMapper = new ObjectMapper();
           TransacoesRnf transacoesRnf = objectMapper.readValue(orderContent, TransacoesRnf.class);
            if(transacoesRnf != null) {
                rnfService.postRnfTransacao(transacoesRnf, null);
            }
            else{
                log.info("Order is not valid");
                throw new JMSException("Encountered error while parsing message.");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @JmsListener(destination = "rnf-notas-a-emitir")
    public void orderFinisher(String orderFinisher) throws Exception{
        try {
            log.info("Finishing order:" + orderFinisher);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
