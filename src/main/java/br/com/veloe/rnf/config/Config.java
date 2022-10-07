package br.com.veloe.rnf.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Data
@Component
public class Config {

  @Value("${onesignal.url}")
  private String oneSignalUrl;
  @Value("${onesignal.app-id}")
  private String oneSignalAppId;
  @Value("${onesignal.rest-key}")
  private String oneSignalRestKey;
  @Value("${onesignal.app-id-return}")
  private String oneSignalAppIdReturn;
  @Value("${onesignal.onesignal.rest-key-return}")
  private String oneSignalRestKeyReturn;

}


