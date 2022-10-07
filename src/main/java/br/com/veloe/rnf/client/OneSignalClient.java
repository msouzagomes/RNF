package br.com.veloe.rnf.client;

import br.com.veloe.rnf.config.Config;
import br.com.veloe.rnf.model.request.TransacoesRnf;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onesignal.client.ApiClient;
import com.onesignal.client.ApiException;
import com.onesignal.client.Configuration;
import com.onesignal.client.api.DefaultApi;
import com.onesignal.client.auth.HttpBearerAuth;
import com.onesignal.client.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Slf4j
@Component
public class OneSignalClient {

    @Autowired
    private Config config;

    public final int DEVICE_IOS =  0;
    public final int DEVICE_ANDROID =  1;
    public final int DEVICE_AMAZON =  2;
    public final int DEVICE_WINDOWSPHONE =  3;
    public final int DEVICE_CHROMEAPP =  4;
    public final int DEVICE_CHROMEWEB =  5;
    public final int DEVICE_WINDOWS =  6;
    public final int DEVICE_SAFARI =  7;
    public final int DEVICE_FIREFOX =  8;
    public final int DEVICE_MACOS =  9;
    public final int DEVICE_ALEXA = 10;
    public final int DEVICE_EMAIL = 11;
    public final int DEVICE_HUAWEIAPP = 13;
    public final int DEVICE_HUAWEIDEVICE = 14;

    public final int NOTIFICATION_SUBSCRIBE = 1;
    public final int NOTIFICATION_UNSUBSCRIBE = 2;


    // ---------------------------------------------------

    public String checkMessages() throws Exception {
        log.info("Buscando notificações...");
        try {
            DefaultApi apiInstance = defaultApi();
            NotificationSlice result = apiInstance.getNotifications(config.getOneSignalAppId(), 50, 0, null);
            log.info("Notificações disponíveis [ total: {}, limit: {}, offset: {} ]",
                    result.getTotalCount(), result.getLimit(), result.getOffset() );
            if( result.getNotifications() == null ) {
                log.info("Nenhuma notificação até o momento.");
                return null;
            }
            StringBuilder sb = new StringBuilder("- Mensagens:\n");
            int count = 1;
            for( NotificationWithMeta notif : result.getNotifications() ) {
                sb.append("  - ").append( count ).append(" Headings: ").append( str( notif.getHeadings() ) ).append("\n");
                sb.append("  - ").append( count ).append(" Subtitle: ").append( str( notif.getSubtitle() ) ).append("\n");
                sb.append("  - ").append( count ).append(" Contents: ").append( str( notif.getContents() ) ).append("\n");
                count++;
                // cancelMessage(notif.getId());
            }
            return sb.toString();
        } catch (ApiException e) {
            log.error("Erro ao consultar notificacoes!", e);
            throw new Exception(e.getMessage());
        }
    }

    public List<TransacoesRnf> checkMessages_Return() throws Exception {
        log.info("Buscando notificações...");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ApiClient defaultClient = Configuration.getDefaultApiClient();
            defaultClient.setBasePath( config.getOneSignalUrl() );
            HttpBearerAuth app_key = (HttpBearerAuth) defaultClient.getAuthentication("app_key");
            app_key.setBearerToken( config.getOneSignalRestKeyReturn() );
            DefaultApi apiInstance = new DefaultApi(defaultClient);

            NotificationSlice result = apiInstance.getNotifications(config.getOneSignalAppIdReturn(), 50, 0, null);
            log.info("Notificações disponíveis [ total: {}, limit: {}, offset: {} ]",
                    result.getTotalCount(), result.getLimit(), result.getOffset() );
            if( result.getNotifications() == null ) {
                log.info("Nenhuma notificação até o momento.");
                return null;
            }
            List<TransacoesRnf> lista = new ArrayList<TransacoesRnf>(60);
            for( NotificationWithMeta notif : result.getNotifications() ) {
                String conteudo = str( notif.getContents() );
                try {
                    TransacoesRnf recebido = mapper.readValue(conteudo, TransacoesRnf.class);
                    lista.add(recebido);
                } catch (JsonProcessingException e) {
                    log.error("Erro ao ler requisição de NFE: {}", conteudo, e);
                }
            }
            return lista;
        } catch (Exception e) {
            log.error("Erro ao consultar notificacoes!", e);
            throw new Exception(e.getMessage());
        }
    }

    public void cancelMessage(String msgId) {
        log.info("Cancelando notificação {} ...", msgId);
        try {
            DefaultApi apiInstance = defaultApi();
            InlineResponse2001 result = apiInstance.cancelNotification(config.getOneSignalAppId(), msgId);
            log.info("Notificação cancelada: {}", result.getSuccess() );
        } catch (ApiException e) {
            log.error("Erro ao cancelar notificacao {}!", msgId, e);
        }
    }

    public void sendMessage(String body, String cnpj) throws ApiException {
        log.info("Enviando notificação ...");
        String userId = registerUser(cnpj);
        try {
            DefaultApi apiInstance = defaultApi();
            Notification notification = new Notification();
            notification.isIos(true);
            notification.isAndroid(true);
            notification.isAnyWeb(true);
            List<String> listSegment = Arrays.asList("Segment-NF");
            notification.setIncludedSegments(listSegment);
            notification.channelForExternalUserIds("push");
            notification.appId(config.getOneSignalAppId());
            StringMap contents = new StringMap();
            contents.en(body);
            notification.setContents(contents);
            List<String> listCnpj = Arrays.asList(cnpj);
            notification.includeExternalUserIds(listCnpj);
            InlineResponse200 result = apiInstance.createNotification(notification);
            log.info("Notificação enviada: {}", result );
        } catch (ApiException e) {
            log.error("Erro ao enviar notificacao!", e);
            throw new ApiException();
        } finally {
            deleteUser(userId);
        }
    }

    public String registerUser(String cnpj) {
        log.info("Registrando usuário.");
        DefaultApi apiInstance = defaultApi();
        Player player = player(cnpj);
        try {
            InlineResponse2005 result = apiInstance.createPlayer(player);
            log.info("Usuário registrado: {} {} \n{}", result.getSuccess(), result.getId(), result);
            return result.getId();
        } catch (ApiException e) {
            log.error("Erro ao criar novo usuário!", e);
        }
        return null;
    }
    public void updateUser(String userId, String cnpj) {
        log.info("Atualizando usuário: {}", userId);
        DefaultApi apiInstance = defaultApi();
        Player player = player(cnpj);
        try {
            InlineResponse2001 result = apiInstance.updatePlayer(userId, player);
            log.info("Usuário atualizado: {} \n{}", result.getSuccess(), result );
        } catch (ApiException e) {
            log.error("Erro ao atualizar usuário!", e);
        }
    }
    public void deleteUser(String userId) {
        log.info("Delete usuário: {}", userId);
        DefaultApi apiInstance = defaultApi();
        try {
            InlineResponse2007 result = apiInstance.deletePlayer(config.getOneSignalAppId(), userId);
            log.info("Usuário deletado: {} \n{}", result.getSuccess(), result );
        } catch (ApiException e) {
            log.error("Erro ao deletar usuário!", e);
        }
    }
    public Player player(String cnpj) {
        Player player = new Player();
        player.setAppId(config.getOneSignalAppId());
        player.setExternalUserId(cnpj);
        Map<String, String> tags = new HashMap<>();
        tags.put("cnpj", cnpj);
        player.setTags(tags);
        player.setTags(tags);
        player.identifier(cnpj); // + "@internal.email"
        player.setLanguage( Locale.getDefault().getLanguage() );
        player.setDeviceType(DEVICE_ANDROID);
        player.setNotificationTypes( NOTIFICATION_SUBSCRIBE );
        player.setCreatedAt( LocalDateTime.now().toEpochSecond( ZoneOffset.UTC ) );
        player.setGameVersion( "1.0" );
        return player;
    }

    protected DefaultApi defaultApi() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath( config.getOneSignalUrl() );
        HttpBearerAuth app_key = (HttpBearerAuth) defaultClient.getAuthentication("app_key");
        app_key.setBearerToken( config.getOneSignalRestKey() );
        DefaultApi apiInstance = new DefaultApi(defaultClient);
        return apiInstance;
    }

    private String str(StringMap map) {
        if( map == null ) return "";
        return map.getEn();
    }
}
