package com.bluetrainsoftware.bathe.initializer;

import bathe.BatheInitializer;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JulBridgeInitializer implements BatheInitializer {

  @Override
  public int getOrder() {
    return 1;
  }

  @Override
  public String getName() {
    return "jul-bridge";
  }

  @Override
  public String[] initialize(String[] args, String jumpClass) {
    Logger rootLogger = LogManager.getLogManager().getLogger("");

    for (Handler julHandler : rootLogger.getHandlers()) {
      rootLogger.removeHandler(julHandler);
    }

    SLF4JBridgeHandler.install();

    return args;
  }
}