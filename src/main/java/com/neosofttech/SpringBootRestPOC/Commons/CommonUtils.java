package com.neosofttech.SpringBootRestPOC.Commons;

//import org.apache.logging.log4j.core.config.ConfigurationSource;
//import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public enum CommonUtils {

    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    /*private final void loadLoggerConfiguration() {
        try {
            //ConfigurationSource configurationSource = new ConfigurationSource(CommonUtils.class.getResourceAsStream(LOG4J2_XML_PATH));
            //Configurator.initialize(null, configurationSource);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }*/

    public final String getStringStackTrace(Throwable throwable) {
        LOGGER.trace("Starting getStringStackTrace() from CommonUtils with arguments :: throwable: " + throwable);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printwriter);
        String stackTrace = stringWriter.toString();

        LOGGER.trace("Existing getStringStackTrace() from CommonUtils with return :: stackTrace: " + stackTrace);
        return stackTrace;
    }
}
