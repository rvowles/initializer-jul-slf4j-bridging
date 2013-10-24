package com.bluetrainsoftware.bathe.initializer

import bathe.BatheInitializer
import groovy.transform.CompileStatic
import org.slf4j.bridge.SLF4JBridgeHandler

import java.util.logging.Handler
import java.util.logging.LogManager
import java.util.logging.Logger

/**
 * This simply initializes the JUL bridge. It needs to be done fairly early, so we set it up at 1
 *
 * author: Richard Vowles - http://gplus.to/Richard.Vowles
 */
@CompileStatic
class JulBridgeInitializer implements BatheInitializer {

	@Override
	int getOrder() {
		return 1
	}

	@Override
	String getName() {
		return "jul-bridge"
	}

	@Override
	String[] initialize(String[] args, String jumpClass) {
		Logger rootLogger = LogManager.getLogManager().getLogger("");

		for (Handler julHandler : rootLogger.getHandlers()) {
			rootLogger.removeHandler(julHandler);
		}

		SLF4JBridgeHandler.install();

		return args
	}
}
